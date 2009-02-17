/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.navigator.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IWrapperItemProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.di.CoreSemanticModelBridge;
import org.eclipse.papyrus.di.Diagram;
import org.eclipse.papyrus.di.SemanticModelBridge;
import org.eclipse.papyrus.navigator.internal.AdditionalResources;
import org.eclipse.papyrus.navigator.internal.utils.NavigatorUtils;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.uml2.uml.Element;

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class UMLContentProvider extends AdapterFactoryContentProvider implements IContentProvider {

	private static final Object[] EMPTY_ARRAY = new Object[0];

	/** The my editor. */
	// protected IEditorPart myEditor = null;
	protected DiResourceSet diResourceSet;

	/** <ICommonContentExtensionSite> as given in initialization. */
	protected ICommonContentExtensionSite contentExtensionSite = null;

	// private ResourceSet resourceSet;

	public UMLContentProvider() {
		super(UMLComposedAdapterFactory.getAdapterFactory());
		// this.resourceSet = new ResourceSetImpl();
	}

	public void init(ICommonContentExtensionSite config) {
		this.contentExtensionSite = config;
	}

	public void restoreState(IMemento memento) {
		// TODO Auto-generated method stub

	}

	public void saveState(IMemento memento) {
		// TODO Auto-generated method stub
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasChildren(Object element) {
		// if (object instanceof IFile)
		// return true;
		// return super.hasChildren(object);

		if (element instanceof Diagram) {
			return false;
		}
		return getChildren(element).length > 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] getChildren(Object parentElement) {
		// System.out.println("UMLContentProvider.getChildren : "+parentElement);
		// if (object instanceof IFile) {
		// String path = ((IFile) object).getFullPath().toString();
		// URI uri = URI.createPlatformResourceURI(path);
		// object = resourceSet.getResource(uri, true);
		// }
		// return super.getChildren(object);

		// Only display diagram (no graphNodes or graphEdges)
		if (parentElement instanceof Diagram) {
			return EMPTY_ARRAY;
		}
		if (parentElement instanceof AdditionalResources) {
			return ((AdditionalResources) parentElement).getResources().toArray();
		}

		// In the case of a domain element :
		List<Object> children = new ArrayList<Object>();

		// 1. Retrieve children elements
		Object[] modelChildren = super.getChildren(parentElement);
		for (int i = 0; i < modelChildren.length; i++) {
			Object child = modelChildren[i];
			children.add(child);
		}

		// 2. and associated diagrams
		if (parentElement instanceof EObject || parentElement instanceof IWrapperItemProvider || parentElement instanceof FeatureMap.Entry) {
			Object object = AdapterFactoryEditingDomain.unwrap(parentElement);
			if (object instanceof Element) {
				Element owner = (Element) object;
				if (owner != null) {
					children.addAll(findAllExistingDiagrams(owner));
				}
			}
		}
		return children.toArray();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getParent(Object element) {
		/*
		 * if (object instanceof IFile) return ((IResource) object).getParent(); return super.getParent(object);
		 */

		// The parent of a diagram is the model object that contains it.
		// if (element instanceof Diagram) {
		// return ((Diagram) element).getElement();
		// }
		// Delegates
		if (element instanceof IWrapperItemProvider || element instanceof FeatureMap.Entry || element instanceof EObject) {
			return super.getParent(element);
		}
		return null;
	}

	@Override
	public Object[] getElements(Object object) {

		if (canPopulateModelNavigator()) {
			this.diResourceSet = getDiResourceSet();
			Resource modelResource = diResourceSet.getUMLModelResource();
			List<Object> children = new ArrayList<Object>(modelResource.getContents());
			AdditionalResources resources = new AdditionalResources(diResourceSet);
			children.add(resources);
			// hookListeners();
			return children.toArray();
		}
		// TODO check //WorkspaceRoot for physical representation
		// if (object instanceof IFile) {
		// String path = ((IFile) object).getFullPath().toString();
		// URI uri = URI.createPlatformResourceURI(path);
		// object = resourceSet.getResource(uri, true);
		// }
		return EMPTY_ARRAY;

		// return super.getElements(object);
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		// Dispose objects
		// adapterFactoryContentProvider.dispose();
		super.dispose();
	}

	// public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	// myAdapterFactoryContentProvider.inputChanged(viewer, oldInput, newInput);
	// }

	/**
	 * @param owner
	 *            the owner of the diagrams
	 * @return the list of diagrams contained by the given owner
	 */
	private List<Diagram> findAllExistingDiagrams(Element owner) {
		ArrayList<Diagram> diagrams = new ArrayList<Diagram>();
		for (Diagram diagram : diResourceSet.getDiagrams()) {
			SemanticModelBridge semanticModelBridge = diagram.getSemanticModel();
			if (semanticModelBridge instanceof CoreSemanticModelBridge) {
				CoreSemanticModelBridge coreSemanticModelBridge = (CoreSemanticModelBridge) semanticModelBridge;
				EObject element = coreSemanticModelBridge.getElement();
				// TODO break GMF dependency
				if (element instanceof org.eclipse.gmf.runtime.notation.Diagram) {
					element = ((org.eclipse.gmf.runtime.notation.Diagram) element).getElement();
				}
				if (owner.equals(element)) {
					diagrams.add(diagram);
				}
			}
		}
		return diagrams;
	}

	private boolean canPopulateModelNavigator() {
		return (NavigatorUtils.getMultiDiagramEditor() != null);
	}

	private DiResourceSet getDiResourceSet() {
		return NavigatorUtils.getDiResourceSet();
	}

	/**
	 * Override this method if you want to execute additional actions when the resource is modified
	 * 
	 * @param event
	 */
	public void resourceSetChanged(ResourceSetChangeEvent event) {
		for (Object o : event.getNotifications()) {
			if (o instanceof Notification) {
				Notification n = (Notification) o;
				if (n.getEventType() == Notification.ADD) {
					if (getCommonNavigator() != null) {
						getCommonNavigator().getCommonViewer().setSelection(new StructuredSelection(n.getNewValue()));
					}
				}
			}

		}
	}

	/**
	 * Gets the <CommonNavigator>. This content provider is associated to, via the viewer ID.
	 * 
	 * @return the common navigator
	 */
	protected CommonNavigator getCommonNavigator() {
		IViewPart part = NavigatorUtils.findViewPart(getViewerID());
		if (part instanceof CommonNavigator) {
			return ((CommonNavigator) part);
		}
		return null;
	}

	protected String getViewerID() {
		return contentExtensionSite.getExtensionStateModel().getViewerId();
	}

}
