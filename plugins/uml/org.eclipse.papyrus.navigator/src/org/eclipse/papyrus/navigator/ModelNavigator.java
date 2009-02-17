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
package org.eclipse.papyrus.navigator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.di.Diagram;
import org.eclipse.papyrus.navigator.internal.utils.NavigatorUtils;
import org.eclipse.papyrus.navigator.providers.IContentProvider;
import org.eclipse.papyrus.navigator.providers.UMLComposedAdapterFactory;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.INavigatorContentExtension;
import org.eclipse.ui.views.properties.IPropertySheetPage;

/**
 * This class define a view used to navigate in UML model and resource
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class ModelNavigator extends CommonNavigator {

	IWorkbenchPage page = null;

	/** <EditingDomain> used to perform actions and commands. */
	TransactionalEditingDomain editingDomain = null;

	/** Active <IEditorPart>. */
	IEditorPart editorPart = null;

	IPropertySheetPage propertySheetPage = null;

	/**
	 * <ResourseSetListener> to listen and react to changes in the resource set.
	 */
	ResourceSetListener resourceSetListener = new ResourceSetListenerImpl() {

		@Override
		public void resourceSetChanged(ResourceSetChangeEvent event) {
			super.resourceSetChanged(event);
			handleResourceSetChanged(event);
		}
	};

	private void handleResourceSetChanged(ResourceSetChangeEvent event) {
		// Refresh global viewer
		refreshViewer();

		// Notify all content providers
		List<Notification> notifications = event.getNotifications();
		int i = 0;
		boolean finish = false;
		while (!finish && i < notifications.size()) {
			Object n = notifications.get(i);
			if (n instanceof Notification) {
				Notification notification = (Notification) n;
				// if (notification.getNotifier() instanceof EObject) {
				// EObject notifier = (EObject) notification.getNotifier();
				// Iterator<?> it = getNavigatorContentService().findRootContentExtensions(notifier).iterator();
				Iterator<?> it = getNavigatorContentService().findRootContentExtensions(notification.getNotifier()).iterator();
				while (it.hasNext()) {
					Object obj = it.next();
					finish = true;
					if (obj instanceof INavigatorContentExtension) {
						INavigatorContentExtension nce = (INavigatorContentExtension) obj;
						if (nce.getContentProvider() instanceof IContentProvider) {
							IContentProvider provider = (IContentProvider) nce.getContentProvider();
							provider.resourceSetChanged(event);
						}
					}
				}
				// }
			}
			i++;
		}
	}

	private void handlePartActivated(IWorkbenchPartReference partRef) {
		IWorkbenchPart part = partRef.getPart(false);
		if (part instanceof IEditorPart) {
			activate();
		}
	}

	private void handlePartDeactivated(IWorkbenchPartReference partRef) {
		IWorkbenchPart part = partRef.getPart(false);
		if (editorPart != null && editorPart.equals(part)) {
			deactivate();
		}
	}

	public void activate() {
		this.editorPart = NavigatorUtils.getMultiDiagramEditor();
		this.editingDomain = NavigatorUtils.getTransactionalEditingDomain();
		if (editingDomain != null) {
			editingDomain.addResourceSetListener(resourceSetListener);
		}
		refreshViewer();
		;
	}

	public void deactivate() {
		editorPart = null;
		if (editingDomain != null) {
			editingDomain.removeResourceSetListener(resourceSetListener);
		}
		// if (propertySheet != null) {
		// propertySheet.dispose();
		// }
		refreshViewer();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter.equals(IPropertySheetPage.class)) {
			return getPropertySheetPage();
		}
		return super.getAdapter(adapter);
	}

	/**
	 * Forces the viewer to be refreshed.
	 */
	public void refreshViewer() {
		CommonViewer viewer = getCommonViewer();
		if (viewer != null && viewer.getTree().isDisposed() == false) {
			viewer.refresh();
		}
	}

	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		page = site.getPage();
		page.addPartListener(new IPartListener2() {

			public void partActivated(IWorkbenchPartReference partRef) {
				handlePartActivated(partRef);
			}

			public void partBroughtToTop(IWorkbenchPartReference partRef) {
			}

			public void partClosed(IWorkbenchPartReference partRef) {
				handlePartDeactivated(partRef);
			}

			public void partDeactivated(IWorkbenchPartReference partRef) {
			}

			public void partHidden(IWorkbenchPartReference partRef) {
			}

			public void partInputChanged(IWorkbenchPartReference partRef) {
				handlePartActivated(partRef);
			}

			public void partOpened(IWorkbenchPartReference partRef) {
				handlePartActivated(partRef);
			}

			public void partVisible(IWorkbenchPartReference partRef) {
				handlePartActivated(partRef);
			}

		});
		page.addSelectionListener(new ISelectionListener() {

			public void selectionChanged(IWorkbenchPart part, ISelection selection) {
				handleSelectionChangedFromDiagramEditor(part, selection);
			}
		});
		activate();
	}

	private IPropertySheetPage getPropertySheetPage() {
		final IMultiDiagramEditor multiDiagramEditor = NavigatorUtils.getMultiDiagramEditor();
		if (multiDiagramEditor != null) {
			BasicCommandStack commandStack = new BasicCommandStack();
			ComposedAdapterFactory adapterFactory = UMLComposedAdapterFactory.getAdapterFactory();
			AdapterFactoryEditingDomain adapterFactoryEditingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap<Resource, Boolean>());
			if (propertySheetPage == null) {
				this.propertySheetPage = new ExtendedPropertySheetPage(adapterFactoryEditingDomain);
				((ExtendedPropertySheetPage) this.propertySheetPage).setPropertySourceProvider(new AdapterFactoryContentProvider(adapterFactory));
			}
			return propertySheetPage;
			// TODO fix bug on org.eclipse.papyrus.tabbedproperties.core.forms.ReferencedTable
			// if(multiDiagramEditor instanceof ITabbedPropertySheetPageContributor){
			// ITabbedPropertySheetPageContributor contributor = (ITabbedPropertySheetPageContributor)multiDiagramEditor;
			// this.propertySheetPage = new TabbedPropertySheetPage(contributor);
			// return propertySheetPage;
			// }
		}
		return null;
	}

	@Override
	protected CommonViewer createCommonViewer(Composite parent) {
		CommonViewer commonViewer = super.createCommonViewer(parent);
		commonViewer.addPostSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				handleSelectionChangedFromCommonViewer(event);
			}
		});
		return commonViewer;
	}

	// optimize selection handling
	private boolean handlingSelectionChanged = false;

	protected void handleSelectionChangedFromDiagramEditor(IWorkbenchPart part, ISelection selection) {
		// Handle selection from diagram editor
		if (isLinkingEnabled() && !handlingSelectionChanged) {
			this.handlingSelectionChanged = true;
			if (part instanceof IEditorPart) {
				ISelection unwrappedSelection = NavigatorUtils.unwrapSelection(selection);
				if (!unwrappedSelection.isEmpty()) {
					getCommonViewer().setSelection(unwrappedSelection, true);
				}
			}
			this.handlingSelectionChanged = false;
		}
	}

	protected void handleSelectionChangedFromCommonViewer(SelectionChangedEvent event) {
		// Handle selection from common viewer
		if (isLinkingEnabled() && !handlingSelectionChanged) {
			this.handlingSelectionChanged = true;
			IEditorPart editor = NavigatorUtils.getActiveEditor();
			if (editor instanceof IMultiDiagramEditor) {
				IMultiDiagramEditor multiDiagramEditor = (IMultiDiagramEditor) editor;
				IEditorPart activeEditor = multiDiagramEditor.getActiveEditor();
				// TODO break GMF dependency (maybe add a new method in IMultiDiagramEditor) Cedric ?
				if (activeEditor instanceof DiagramEditor) {
					// set editor selection and select the EditParts
					IDiagramGraphicalViewer diagramGraphicalViewer = ((DiagramEditor) activeEditor).getDiagramGraphicalViewer();
					List<?> editPartsToSelect = NavigatorUtils.getEditPartsFromSelection(event.getSelection(), diagramGraphicalViewer);
					StructuredSelection selectedEditParts = new StructuredSelection(editPartsToSelect);
					diagramGraphicalViewer.setSelection(selectedEditParts);
					if (!selectedEditParts.isEmpty()) {
						EditPart editPart = (EditPart) selectedEditParts.getFirstElement();
						diagramGraphicalViewer.reveal(editPart);
					}
				}
			}
			this.handlingSelectionChanged = false;
		}
	}

	@Override
	protected void handleDoubleClick(DoubleClickEvent anEvent) {
		IAction openHandler = getViewSite().getActionBars().getGlobalActionHandler(ICommonActionConstants.OPEN);
		if (openHandler != null) {
			openHandler.run();
		} else {
			IStructuredSelection selection = (IStructuredSelection) anEvent.getSelection();
			Object element = selection.getFirstElement();
			if (element instanceof Diagram) {
				handleDoubleClickOnDiagram((Diagram) element);
			} else {
				super.handleDoubleClick(anEvent);
			}
		}
	}

	protected void handleDoubleClickOnDiagram(Diagram diagram) {
		// BackboneContext backboneContext = NavigatorUtils.getBackboneContext();
		// Resource diResource = backboneContext.getResourceSet().getDiResource();
		// TODO synchronize with Cedric in order to understand how to open diagram with the new sash multi editor
		// SashDiagramModelUtil.openDiagramInCurrentFolder(diResource, diagram);
		// org.eclipse.gmf.runtime.notation.Diagram gmfDiagram=null;
		// IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		// try {
		// page.openEditor(getEditorInput(gmfDiagram),getEditorID());
		// } catch (PartInitException e) {
		// Activator.getDefault().getLog().log(new Status(IStatus.ERROR,Activator.PLUGIN_ID, "Can't open the Diagram Editor!"));
		// }
		System.out.println("#ModelNavigator-> handleDoubleClickOnDiagram : " + diagram);
	}

}
