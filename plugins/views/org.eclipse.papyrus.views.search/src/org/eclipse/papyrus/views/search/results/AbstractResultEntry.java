/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.search.results;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.openelement.service.OpenElementService;
import org.eclipse.papyrus.views.search.scope.ScopeEntry;
import org.eclipse.search.ui.text.Match;
import org.eclipse.search.ui.text.MatchFilter;
import org.eclipse.ui.PartInitException;

/**
 * 
 * Abstract implementation of Result entry. A ResultEntry is an entry that will appear in the result of a search. It provides a tree structure.
 * It is abstract because entries can be real matches i.e. {@see ModelMatch} or entries shown for hierarchical reasons i.e. {@see ResultEntry}.
 * 
 */
public abstract class AbstractResultEntry extends Match {

	/**
	 * The source element that raised a match
	 */
	protected Object source;

	/**
	 * The parent of this result entry in the hierarchy
	 */
	protected Object parent;

	protected URI uriSource;

	protected java.net.URI uriResource;

	/**
	 * Used to specify offset and length of {@link Match} when these attributes are not meaningful
	 */
	final protected static int UNSPECIFIED = -1;

	/**
	 * Every implementation of {@link AbstractResultEntry} must implement this to define what should be displayed in labelproviders
	 * 
	 * @return
	 *         the element to display in labelproviders
	 */
	public abstract Object elementToDisplay();

	/**
	 * Every implementation of {@link AbstractResultEntry} must implement this to define what element is to give to the {@link OpenElementService}
	 * 
	 * @return
	 *         the element to open with {@link OpenElementService}
	 */
	public abstract Object openElement(OpenElementService service) throws ServiceException, PartInitException;

	/**
	 * Every implementation of {@link AbstractResultEntry} must implement this to define what element is to be analyzed by {@link MatchFilter}(s)
	 * 
	 * @return
	 *         the element to analyze to filter matches
	 */
	public abstract Object elementToCheckFilterFor();

	/**
	 * Compute the parent hierarchy of parents of a element in a model
	 * 
	 * @param child
	 *        the element to search parents for
	 * @param scopeEntry
	 *        the {@link ScopeEntry} corresponding to the resource that contains the element that matches
	 */
	public void recursiveHierarchy(AbstractResultEntry child) {
		if(child.getSource() instanceof EObject) {
			EObject potentialParent = ((EObject)child.getSource()).eContainer();

			if(potentialParent != null) {
				ResultEntry theParent = new ResultEntry(potentialParent, (ScopeEntry)this.getElement());
				child.setParent(theParent);
				recursiveHierarchy(theParent);
			} else {
				ResultEntry theParent = new ResultEntry(((ScopeEntry)this.getElement()).getResource(), (ScopeEntry)this.getElement());
				child.setParent(theParent);
			}
		}
	}

	protected AbstractResultEntry getLastParent(AbstractResultEntry child, ScopeEntry scopeEntry) {
		if(child.getSource() instanceof EObject) {


			EObject potentialParent = ((EObject)child.getSource()).eContainer();
			ResultEntry theParent = null;

			while(potentialParent != null) {
				theParent = new ResultEntry(potentialParent, scopeEntry);
				theParent.setParent(new ResultEntry(scopeEntry.getResource(), scopeEntry));

				potentialParent = potentialParent.eContainer();
			}

			if(theParent == null) {

				theParent = new ResultEntry(scopeEntry.getResource(), scopeEntry);

			}
			return theParent;

		}

		return null;

	}

	/**
	 * It is a really important override that used to not duplicate elements in the result hierarchy. Extensions of {@link AbstractResultEntry} may
	 * specialize this method
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof AbstractResultEntry) {
			if(obj instanceof EObject && this.getSource() instanceof EObject) {
				if(EcoreUtil.equals((EObject)this.getSource(), (EObject)obj)) {
					if(((AbstractResultEntry)obj).getOffset() == this.getOffset()) {
						if(((AbstractResultEntry)obj).getLength() == this.getLength()) {
							return true;
						}
					}
				}
			} else {
				if(((AbstractResultEntry)obj).getSource() != null) {
					if(((AbstractResultEntry)obj).getSource().equals(this.getSource())) {
						if(((AbstractResultEntry)obj).getOffset() == this.getOffset()) {
							if(((AbstractResultEntry)obj).getLength() == this.getLength()) {
								return true;
							}
						}

					}
				}
			}
			return false;

		}
		return super.equals(obj);
	}

	/**
	 * @see Match#Match(Object, int, int)
	 * 
	 * @param offset
	 * 
	 * @param lenght
	 * 
	 * @param source
	 *        the element that raised the match
	 * @param scopeEntry
	 *        the {@link ScopeEntry} that correspond to the resource that contains the element that raised the match
	 */
	public AbstractResultEntry(int offset, int lenght, Object source, ScopeEntry scopeEntry) {
		super(scopeEntry, offset, lenght);
		//		this.source = source;
		if(source instanceof EObject) {

			this.uriSource = EcoreUtil.getURI((EObject)source);
		} else if(source instanceof IResource) {
			this.uriResource = ((IResource)source).getLocationURI();
		}
	}

	public Object getSource() {
		if(this.uriSource != null) {
			ResourceSet resSet = ((ScopeEntry)this.getElement()).getModelSet();
			return resSet.getEObject(this.uriSource, true);
		} else if(this.uriResource != null) {

			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();


			IPath path = new Path(this.uriResource.getPath());
			return root.getFile(path);
		}

		return null;
	}

	public void setSource(Object source) {
		this.source = source;
	}

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "(" + super.hashCode() + ") : source -> " + source; //$NON-NLS-1$ //$NON-NLS-2$
	}


}
