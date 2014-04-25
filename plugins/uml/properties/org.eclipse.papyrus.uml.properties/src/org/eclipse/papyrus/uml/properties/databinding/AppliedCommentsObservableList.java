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
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.databinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.uml.tools.databinding.PapyrusObservableList;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Observable list for applied comments.
 */
public class AppliedCommentsObservableList extends PapyrusObservableList {

	/** The comment Listener */
	private Adapter commentListener;

	private ArrayList<Comment> commentList = new ArrayList<Comment>();

	public AppliedCommentsObservableList(EditingDomain domain, Element source) {
		super(getAppliedCommentsList(source), domain, source, UMLPackage.eINSTANCE.getElement_OwnedComment());
		addCommentListener(source);
	}

	/**
	 * Add a listener on comment annotated element.
	 *
	 * @param source
	 */
	private void addCommentListener(Element source) {
		Iterator<Setting> it = UML2Util.getNonNavigableInverseReferences(source).iterator();
		while (it.hasNext()) {
			Setting setting = it.next();
			if (setting.getEStructuralFeature() == UMLPackage.Literals.COMMENT__ANNOTATED_ELEMENT) {
				if (setting.getEObject() instanceof Comment) {
					Comment comment = (Comment) setting.getEObject();
					comment.eAdapters().add(getCommentListener());
					commentList.add(comment);
				}
			}
		}
	}

	/**
	 * Create a listener for DiagramElement.
	 */
	private Adapter getCommentListener() {
		if (commentListener == null) {
			commentListener = new AdapterImpl() {

				@Override
				public void notifyChanged(Notification event) {
					refreshCacheList();
				}
			};
		}
		return commentListener;
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
						if (annotatedElement.eResource() == null) {
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
	 * <p>
	 * Redefine refresh cache because applied comments list is a subset of {@link Element#getOwnedComments <em>Owned Comments</em>}.
	 * </p>
	 *
	 * @see org.eclipse.papyrus.infra.emf.databinding.EMFObservableList#refreshCacheList()
	 *
	 */
	@Override
	protected void refreshCacheList() {
		if (isDisposed()) {
			return;
		}
		wrappedList.clear();
		wrappedList.addAll(getAppliedCommentsList((Element) source));
		fireListChange(null);
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
			Comment comment = (Comment) value;

			// Add an adapter to the comment
			comment.eAdapters().add(getCommentListener());
			commentList.add(comment);

			addAppliedCommentCommand = new CompoundCommand("Add applied comment");

			// Add the comment to source#ownedComment
			SetRequest setRequest = new SetRequest(source, feature, comment);
			addAppliedCommentCommand.append(getCommandFromRequests(getProvider(), Collections.singletonList(setRequest)));

			// Check if source was already had to comment
			if (!comment.getAnnotatedElements().contains(source)) {
				// Add comment to element
				AddCommand addCommand = new AddCommand(editingDomain, comment, UMLPackage.eINSTANCE.getComment_AnnotatedElement(), source);
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

			// remove the adapter
			comment.eAdapters().remove(commentListener);
			commentList.remove(comment);

			if (comment.getAnnotatedElements().size() > 1) {
				// Remove on link between source and comment
				List<Element> values = new LinkedList<Element>(comment.getAnnotatedElements());
				values.remove(source);
				SetRequest setRequest = new SetRequest(comment, UMLPackage.eINSTANCE.getComment_AnnotatedElement(), values);
				removeAppliedCommentCommand = getCommandFromRequests(getProvider(), Collections.singletonList(setRequest));

			} else {
				// Remove comment in element
				DestroyElementRequest detroyRequest = new DestroyElementRequest((TransactionalEditingDomain) editingDomain, comment, false);
				removeAppliedCommentCommand = getCommandFromRequests(getProvider(), Collections.singleton(detroyRequest));
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
			Comment comment = (Comment) value;

			// remove the adapter
			comment.eAdapters().remove(commentListener);
			commentList.remove(comment);

			removeAppliedCommentCommand.append(getRemoveCommand(comment));
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


	@Override
	public synchronized void dispose() {
		// remove adapters
		for (int i = 0; i < commentList.size(); i++) {
			commentList.get(i).eAdapters().remove(commentListener);
			commentList.remove(commentList.get(i));
		}
		super.dispose();
	}
}
