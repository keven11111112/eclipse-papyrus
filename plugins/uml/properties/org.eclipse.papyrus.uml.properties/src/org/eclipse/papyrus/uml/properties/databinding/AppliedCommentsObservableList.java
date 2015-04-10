/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sebastien Poissonnet (CEA LIST) sebastien.poissonnet@cea.fr
 *  Mickaël ADAM (ALL4TEC) mickael.adam@all4tec.net - bug 435174
 *  Gabriel Pascual (ALL4TEC)  -  Bug 441511
 *  Christian W. Damus (CEA) - Bug 441227
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.databinding;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.databinding.CommandBasedObservableList;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Observable list for applied comments.
 */
public class AppliedCommentsObservableList extends CommandBasedObservableList {

	public AppliedCommentsObservableList(EditingDomain domain, Element source) {
		super(getAppliedCommentsList(source), domain, source, UMLPackage.eINSTANCE.getElement_OwnedComment());
	}

	/**
	 * Gets the applied comments list.
	 *
	 * @param source
	 *            the source
	 * @return the applied comments list
	 */
	private static List<Comment> getAppliedCommentsList(Element source) {
		List<Comment> result = new LinkedList<Comment>();
		Iterator<Setting> it = UML2Util.getNonNavigableInverseReferences(source).iterator();
		while (it.hasNext()) {
			Setting setting = it.next();
			if (setting.getEStructuralFeature() == UMLPackage.Literals.COMMENT__ANNOTATED_ELEMENT) {
				if (setting.getEObject() instanceof Comment) {
					Comment comment = (Comment) setting.getEObject();
					// small bugfix...
					// UML2Util.getNonNavigableInverseReferences returns more element than
					// needed, especially elements that are not real ones
					// so we must check if they are contained by the current resource or
					// not...
					boolean isProxy = false;
					for (Element annotatedElement : comment.getAnnotatedElements()) {
						// Don't check the annotated element if it's the source, because it may be a new
						// element being created in a dialog and not yet attached to the model
						if ((annotatedElement != source) && (annotatedElement.eResource() == null)) {
							isProxy = true;
						}
					}
					// this is the real element, not a ghost one. display it in the list
					if (!isProxy) {
						if (comment.getAnnotatedElements().contains(source)) {
							result.add(comment);
						}
					}
				}
			}
		}
		return result;
	}

	/**
	 * @return the IElementEditService used to retrieve the command
	 */
	protected IElementEditService getProvider() {
		return ElementEditServiceUtils.getCommandProvider(source);
	}

	/**
	 * Creates an EMF command from a GMF request, with the given IElementEditService
	 *
	 * @param provider
	 * @param request
	 * @return
	 * 		The EMF command corresponding to the given request
	 */
	protected Command getCommandFromRequests(IElementEditService provider, IEditCommandRequest request) {
		return new GMFtoEMFCommandWrapper(provider.getEditCommand(request));
	}

	/**
	 * @see org.eclipse.papyrus.infra.emf.databinding.CommandBasedObservableList#add(java.lang.Object)
	 *
	 * @param o
	 * @return
	 */
	@Override
	public boolean add(Object o) {
		super.add(o);
		return wrappedList.add(o);
	}

	/**
	 * @see org.eclipse.papyrus.infra.emf.databinding.CommandBasedObservableList#remove(java.lang.Object)
	 *
	 * @param o
	 * @return
	 */
	@Override
	public boolean remove(Object o) {
		super.remove(o);
		return wrappedList.remove(o);
	}

	/**
	 * @see org.eclipse.papyrus.infra.emf.databinding.CommandBasedObservableList#clear()
	 *
	 */
	@Override
	public void clear() {
		super.clear();
		wrappedList.clear();
	}

	/**
	 * @see org.eclipse.papyrus.uml.tools.databinding.PapyrusObservableList#getAddCommand(java.lang.Object)
	 *
	 * @param value
	 * @return
	 */
	@Override
	public Command getAddCommand(Object value) {
		CompoundCommand addAppliedCommentCommand = null;

		if (value instanceof Comment) {

			addAppliedCommentCommand = new CompoundCommand("Add applied comment");

			// Add the comment to source#ownedComment
			SetRequest setRequest = new SetRequest((TransactionalEditingDomain) editingDomain, source, feature, value);
			addAppliedCommentCommand.append(getCommandFromRequests(getProvider(), setRequest));

			// Check if source was already had to comment
			if (!((Comment) value).getAnnotatedElements().contains(source)) {
				// Add comment to element
				AddCommand addCommand = new AddCommand(editingDomain, (EObject) value, UMLPackage.eINSTANCE.getComment_AnnotatedElement(), source);
				addAppliedCommentCommand.append(addCommand);
			}
		}

		return addAppliedCommentCommand;
	}

	/**
	 * @see org.eclipse.papyrus.uml.tools.databinding.PapyrusObservableList#getRemoveCommand(java.lang.Object)
	 *
	 * @param value
	 * @return
	 */
	@Override
	public Command getRemoveCommand(Object value) {

		Command removeAppliedCommentCommand = null;
		if (value instanceof Comment) {

			Comment comment = (Comment) value;

			if (comment.getAnnotatedElements().size() > 1) {
				// Remove on link between source and comment
				List<Element> values = new LinkedList<Element>(comment.getAnnotatedElements());
				values.remove(source);
				SetRequest setRequest = new SetRequest(comment, UMLPackage.eINSTANCE.getComment_AnnotatedElement(), values);
				removeAppliedCommentCommand = getCommandFromRequests(getProvider(), setRequest);

			} else {
				// Remove comment in element
				DestroyElementRequest detroyRequest = new DestroyElementRequest((TransactionalEditingDomain) editingDomain, comment, false);
				removeAppliedCommentCommand = getCommandFromRequests(getProvider(), detroyRequest);
			}

		}

		return removeAppliedCommentCommand;
	}

	/**
	 * @see org.eclipse.papyrus.uml.tools.databinding.PapyrusObservableList#getRemoveAllCommand(java.util.Collection)
	 *
	 * @param values
	 * @return
	 */
	@Override
	public Command getRemoveAllCommand(Collection<?> values) {
		Iterator<?> itr = values.iterator();
		Element value;
		CompoundCommand removeAppliedCommentCommand = new CompoundCommand("Remove applied comment");
		while (itr.hasNext()) {
			value = (Element) itr.next();
			Assert.isTrue(value instanceof Comment);
			removeAppliedCommentCommand.append(getRemoveCommand(value));
		}
		return removeAppliedCommentCommand;
	}

	//
	// Unsupported operations
	//
	@Override
	public Command getClearCommand() {
		throw new UnsupportedOperationException();
		// return super.getClearCommand();
	}

	@Override
	public List<Command> getMoveCommands(int oldIndex, int newIndex) {
		throw new UnsupportedOperationException();
		// return super.getMoveCommands(oldIndex, newIndex);
	}

	@Override
	public Command getRemoveCommand(int index) {
		throw new UnsupportedOperationException();
		// return super.getRemoveCommand(index);
	}

	@Override
	public Command getSetCommand(int index, Object value) {
		throw new UnsupportedOperationException();
		// return super.getSetCommand(index, value);
	}

	@Override
	public Command getAddAllCommand(Collection<?> values) {
		throw new UnsupportedOperationException();
		// return super.getAddAllCommand(values);
	}

	@Override
	public Command getAddAllCommand(int index, Collection<?> values) {
		throw new UnsupportedOperationException();
		// return super.getAddAllCommand(index, values);
	}

	@Override
	public Command getAddCommand(int index, Object value) {
		throw new UnsupportedOperationException();
		// return super.getAddCommand(index, value);
	}
}
