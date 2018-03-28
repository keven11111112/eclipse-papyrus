/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.viewpoints.policy;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.infra.architecture.ArchitectureDescriptionUtils;
import org.eclipse.papyrus.infra.core.architecture.RepresentationKind;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureContext;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureDescriptionLanguage;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureFramework;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureViewpoint;
import org.eclipse.papyrus.infra.core.architecture.provider.ArchitectureEditPlugin;
import org.eclipse.papyrus.infra.core.architecture.provider.ArchitectureItemProviderAdapterFactory;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.viewpoints.policy.providers.MergedArchitectureDescriptionLanguageItemProvider;
import org.eclipse.papyrus.infra.viewpoints.policy.providers.MergedArchitectureFrameworkItemProvider;
import org.eclipse.papyrus.infra.viewpoints.policy.providers.MergedArchitectureViewpointItemProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

/**
 * Eclipse view for the user to explore the current viewpoint
 *
 * @author Laurent Wouters
 *
 */
public class ViewpointExplorer extends ViewPart {

	private TreeViewer tree;

	private IPartListener listener;
	
	private ArchitectureItemProviderAdapterFactory architectureAdapterFactory;
	private ComposedAdapterFactory adapterFactory;
	private AdapterFactoryContentProvider contentProvider;
	private AdapterFactoryLabelProvider labelProvider;
	private AdapterFactoryEditingDomain editingDomain;
	
	private class ViewpointAdapterFactory extends ComposedAdapterFactory implements IEditingDomainProvider {
		public ViewpointAdapterFactory(Descriptor.Registry adapterFactoryDescriptorRegistry) {
			super(adapterFactoryDescriptorRegistry);
		}
		
		@Override
		public EditingDomain getEditingDomain() {
			return editingDomain;
		}
	}
	
	/**
	 * Constructor.
	 *
	 */
	public ViewpointExplorer() {
		architectureAdapterFactory = new ArchitectureItemProviderAdapterFactory();
		adapterFactory = new ViewpointAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		contentProvider = new AdapterFactoryContentProvider(adapterFactory);
		labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, null, new HashMap<Resource, Boolean>()) {
			  public boolean isReadOnly(Resource resource) {
				  return true; // to make the editing domain non-editable
			  }
		};
	}

     @Override
	public void init(IViewSite site) throws PartInitException {
        super.init(site);
    }
	
	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		parent.setLayout(gridLayout);

		Composite inner = new Composite(parent, SWT.NONE);
		inner.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL | GridData.FILL_VERTICAL));
		inner.setLayout(new FillLayout());

		tree = new TreeViewer(inner, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tree.setLabelProvider(createLabelProvider(adapterFactory));
		tree.setContentProvider(createContentProvider(adapterFactory));
		
        getSite().getPage().addPartListener(listener = createSelectionListener(tree));
		getSite().setSelectionProvider(tree);
	}

    public void dispose() {
    		if (listener != null)
    			getSite().getPage().removePartListener(listener);
    }

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {

	}

	private ILabelProvider createLabelProvider(ComposedAdapterFactory adapterFactory) {
		return new LabelProvider() {

			@Override
			public Image getImage(Object element) {
				if (element instanceof PropertySource) {
					element = ((PropertySource)element).getObject();
				}
				if (element instanceof MergedArchitectureDescriptionLanguage) {
					Object object = ArchitectureEditPlugin.INSTANCE.getImage("full/obj16/ArchitectureDescriptionLanguage");
					return ExtendedImageRegistry.INSTANCE.getImage(object);
				}
				if (element instanceof MergedArchitectureFramework) {
					Object object = ArchitectureEditPlugin.INSTANCE.getImage("full/obj16/ArchitectureFramework");
					return ExtendedImageRegistry.INSTANCE.getImage(object);
				}
				if (element instanceof MergedArchitectureViewpoint) {
					Object object = ArchitectureEditPlugin.INSTANCE.getImage("full/obj16/ArchitectureViewpoint");
					return ExtendedImageRegistry.INSTANCE.getImage(object);
				}
				return labelProvider.getImage(element);
			}

			@Override
			public String getText(Object element) {
				if (element instanceof PropertySource) {
					element = ((PropertySource)element).getObject();
				}
				if (element instanceof MergedArchitectureDescriptionLanguage) {
					String text = ArchitectureEditPlugin.INSTANCE.getString("_UI_ArchitectureDescriptionLanguage_type");
					return text + " " + ((MergedArchitectureDescriptionLanguage)element).getName();
				}
				if (element instanceof MergedArchitectureFramework) {
					String text = ArchitectureEditPlugin.INSTANCE.getString("_UI_ArchitectureFramework_type");
					return text + " " + ((MergedArchitectureFramework)element).getName();
				}
				if (element instanceof MergedArchitectureViewpoint) {
					String text = ArchitectureEditPlugin.INSTANCE.getString("_UI_ArchitectureViewpoint_type");
					return text + " " + ((MergedArchitectureViewpoint)element).getName();
				}
				return labelProvider.getText(element);
			}
		};
	}
	
	private ITreeContentProvider createContentProvider(ComposedAdapterFactory adapterFactory) {
		return new ITreeContentProvider() {
			private ArchitectureDescriptionUtils utils;
			
			@Override
			public boolean hasChildren(Object element) {
				return getChildren(element) != null;
			}
			
			@Override
			public Object getParent(Object element) {
				return null;
			}
			
			@Override
			public Object[] getElements(Object inputElement) {
				if (inputElement instanceof ModelSet) {
					utils = new ArchitectureDescriptionUtils((ModelSet)inputElement);
					return getPropertySources(new Object[] {utils.getArchitectureContext()});
				} else {
					utils = null;
					return null;
				}
			}
			
			@Override
			public Object[] getChildren(Object parentElement) {
				if (parentElement instanceof PropertySource) {
					parentElement = ((PropertySource)parentElement).getObject();
					if (parentElement instanceof MergedArchitectureContext)
						return getPropertySources(utils.getArchitectureViewpoints().toArray());
					if (parentElement instanceof MergedArchitectureViewpoint)
						return getPropertySources(((MergedArchitectureViewpoint)parentElement).getRepresentationKinds().toArray());
					else
						return getPropertySources(contentProvider.getChildren(parentElement));
				}
				return null;
			}
		};
	}

	private IPartListener createSelectionListener(TreeViewer viewer) {
		return new IPartListener() {
			private IWorkbenchPart editor;
			
			@Override
			public void partActivated(IWorkbenchPart part) {
				if (part == editor)
					viewer.refresh();
				else if (part instanceof IMultiDiagramEditor) {
					EditingDomain domain = part.getAdapter(EditingDomain.class);
					if (domain != null) {
						ResourceSet resourceSet = domain.getResourceSet();
						if (resourceSet instanceof ModelSet) {
							editor = part;
							viewer.setInput((ModelSet)resourceSet);
						}
					}
				}
			}

			@Override
			public void partBroughtToTop(IWorkbenchPart part) {
				if (part instanceof IMultiDiagramEditor) {
					
				}
			}

			@Override
			public void partClosed(IWorkbenchPart part) {
				if (part == editor) {
					viewer.setInput(null);
				}
			}

			@Override
			public void partDeactivated(IWorkbenchPart part) {
				if (part instanceof IMultiDiagramEditor) {
					
				}
			}

			@Override
			public void partOpened(IWorkbenchPart part) {
				if (part instanceof IMultiDiagramEditor) {
					
				}
			}
		};	
	}
	
	public Object[] getPropertySources(Object[] objects) {
		ArrayList<Object> propertySources = new ArrayList<Object>();
		for (Object object : objects) {
			propertySources.add(getPropertySource(object));
		}
		return propertySources.toArray();
	}

	public Object getPropertySource(Object object) {
		if (object instanceof EObject)
			return contentProvider.getPropertySource(object);
		else if (object instanceof MergedArchitectureViewpoint) {
			IItemPropertySource source = new MergedArchitectureViewpointItemProvider(architectureAdapterFactory);
			return new PropertySource(object, source);
		} 
		else if (object instanceof MergedArchitectureFramework) {
			IItemPropertySource source = new MergedArchitectureFrameworkItemProvider(architectureAdapterFactory);
			return new PropertySource(object, source);
		} 
		else if (object instanceof MergedArchitectureDescriptionLanguage) {
			IItemPropertySource source = new MergedArchitectureDescriptionLanguageItemProvider(architectureAdapterFactory);
			return new PropertySource(object, source);
		} 
		return object;
	}
	
}
