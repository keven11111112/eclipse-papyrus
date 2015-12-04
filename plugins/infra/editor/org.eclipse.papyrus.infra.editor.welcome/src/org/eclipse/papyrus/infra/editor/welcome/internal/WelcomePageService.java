/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.editor.welcome.internal;

import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl.ResourceLocator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModelUtils;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.utils.IPageUtils;
import org.eclipse.papyrus.infra.core.sasheditor.editor.DefaultPageLifeCycleEventListener;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IComponentPage;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IEditorPage;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPage;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPageLifeCycleEventsListener;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPageVisitor;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashModel;
import org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder;
import org.eclipse.papyrus.infra.core.services.EditorLifecycleEventListener;
import org.eclipse.papyrus.infra.core.services.EditorLifecycleManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.TransactionHelper;
import org.eclipse.papyrus.infra.editor.welcome.IWelcomePageService;
import org.eclipse.papyrus.infra.editor.welcome.Welcome;
import org.eclipse.papyrus.infra.editor.welcome.WelcomeFactory;
import org.eclipse.papyrus.infra.editor.welcome.WelcomePackage;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.swt.widgets.Display;

/**
 * Default implementation of the <em>Welcome Page</em> service.
 */
public class WelcomePageService implements IWelcomePageService {

	private ServicesRegistry services;
	private ISashWindowsContainer sashContainer;
	private IPageManager pageManager;
	private EditorLifecycleManager editorManager;

	private WelcomeLocator welcomeLocator;

	private IPageLifeCycleEventsListener sashListener;
	private EditorLifecycleEventListener editorListener;

	private IPage welcomePage;

	public WelcomePageService() {
		super();
	}

	@Override
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		this.services = servicesRegistry;
	}

	@Override
	public final ServicesRegistry getOwner() {
		return services;
	}

	@Override
	public void startService() throws ServiceException {
		welcomeLocator = new WelcomeLocator(services.getService(ModelSet.class));

		pageManager = services.getService(IPageManager.class);

		editorManager = services.getService(EditorLifecycleManager.class);
		editorListener = new EditorListener();
		editorManager.addEditorLifecycleEventsListener(editorListener);
	}

	@Override
	public void disposeService() throws ServiceException {
		if (welcomeLocator != null) {
			welcomeLocator.dispose();
			welcomeLocator = null;
		}

		pageManager = null;

		if (editorManager != null) {
			editorManager.removeEditorLifecycleEventsListener(editorListener);
			editorManager = null;
		}
	}

	@Override
	public boolean canCloseWelcomePage() {
		return (welcomePage != null) && (getOpenPageCount() > 1);
	}

	public int getOpenPageCount() {
		class PageCounter implements IPageVisitor {
			int count = 0;

			@Override
			public void accept(IEditorPage page) {
				count++;
			}

			@Override
			public void accept(IComponentPage page) {
				count++;
			}
		}

		PageCounter counter = new PageCounter();

		sashContainer.visit(counter);

		return counter.count;
	}

	@Override
	public void openWelcomePage() {
		if (pageManager != null) {
			if (welcomePage == null) {
				pageManager.openPage(getModel());
			} else {
				pageManager.selectPage(getModel());
			}
		}
	}

	@Override
	public void resetWelcomePage() {
		if (welcomePage instanceof IAdaptable) {
			((IAdaptable) welcomePage).getAdapter(WelcomePage.class).reset();
		}
	}

	void checkWelcomePage() {
		Display.getDefault().asyncExec(() -> {
			// Check that the editor hasn't been disposed in the mean-time
			if ((sashContainer != null) && !sashContainer.isDisposed()) {
				if (getOpenPageCount() <= 0) {
					openWelcomePage();
				}

				if (welcomePage instanceof IAdaptable) {
					((IAdaptable) welcomePage).getAdapter(WelcomePage.class).fireCanCloseChanged();
				}
			}
		});
	}

	@Override
	public Welcome getWelcome() {
		return welcomeLocator.getWelcome();
	}

	@Override
	public Resource getWelcomeResource() {
		return welcomeLocator.getWelcomeResource();
	}

	Object getModel() {
		return getWelcome();
	}

	static boolean isModel(Object object) {
		return object instanceof Welcome;
	}

	boolean isWelcomePage(IPage page) {
		return isModel(IPageUtils.getRawModel(page));
	}

	void trackActivePage(PageRef pageRef) {
		TabFolder folder = pageRef.getParent();

		if ((folder != null) && (folder.getCurrentSelection() != pageRef)) {
			SashModel sashModel = EMFHelper.getContainer(folder, SashModel.class);
			if ((sashModel != null) && sashModel.isRestoreActivePage()) {
				// track the active page in this folder, but not as an undoable operation
				EditingDomain domain = EMFHelper.resolveEditingDomain(sashModel);

				try {
					TransactionHelper.run(domain, () -> folder.setCurrentSelection(pageRef));
				} catch (Exception e) {
					Activator.log.error("Failed to track page selection", e); //$NON-NLS-1$
				}
			}
		}
	}

	void initializeActivePages(PageRef welcomePage) {
		SashModel sashModel = EMFHelper.getContainer(welcomePage, SashModel.class);
		if ((sashModel != null) && sashModel.isRestoreActivePage()) {
			// Select all of the remembered pages to make them active
			sashContainer.getIFolderList().stream()
					.filter(f -> f.getRawModel() instanceof TabFolder)
					.forEach(f -> {
						TabFolder tabFolder = (TabFolder) f.getRawModel();
						if (tabFolder.getCurrentSelection() != null) {
							IPage page = sashContainer.lookupModelPage(tabFolder.getCurrentSelection());
							if (page != null) {
								sashContainer.selectPage(page);
							}
						}
					});
		}
	}

	//
	// Nested types
	//

	private class SashListener extends DefaultPageLifeCycleEventListener {

		@Override
		public void pageOpened(IPage page) {
			if (isWelcomePage(page)) {
				welcomePage = page;
			}

			checkWelcomePage();
		}

		@Override
		public void pageClosed(IPage page) {
			if (page == welcomePage) {
				welcomePage = null;
			}

			checkWelcomePage();
		}

		@Override
		public void pageActivated(IPage page) {
			if (page.getRawModel() instanceof PageRef) {
				PageRef pageRef = (PageRef) page.getRawModel();
				trackActivePage(pageRef);
			}
		}
	}

	private class EditorListener implements EditorLifecycleEventListener {

		@Override
		public void postInit(IMultiDiagramEditor editor) {
			// Pass
		}

		@Override
		public void preDisplay(IMultiDiagramEditor editor) {
			sashContainer = editor.getAdapter(ISashWindowsContainer.class);
			sashListener = new SashListener();
			sashContainer.addPageLifeCycleListener(sashListener);

			welcomePage = IPageUtils.lookupModelPage(sashContainer, getModel());
			checkWelcomePage();

			if ((welcomePage != null) && (welcomePage.getRawModel() instanceof PageRef)) {
				initializeActivePages((PageRef) welcomePage.getRawModel());
			}
		}

		@Override
		public void postDisplay(IMultiDiagramEditor editor) {
			// Pass
		}

		@Override
		public void beforeClose(IMultiDiagramEditor editor) {
			// By this time, it's already too late to remove the page lifecycle listener, so
			// don't bother (it isn't necessary, anyways, once the sash container is gone)
			sashListener = null;
		}

	}

	private static class WelcomeLocator extends ResourceLocator {
		private final Resource welcomeResource;
		private final Welcome welcome;

		WelcomeLocator(ModelSet modelSet) {
			super(modelSet);

			// TODO: Store this resource in the workspace metadata area for custom default layout
			welcomeResource = new ResourceImpl(URI.createURI("papyrus.welcome:dynamic")) {
				@Override
				public ResourceSet getResourceSet() {
					// Yes, this is a violation of the opposite constraint
					return modelSet;
				}

				@Override
				public NotificationChain basicSetResourceSet(ResourceSet resourceSet, NotificationChain notifications) {
					throw new UnsupportedOperationException("setResourceSet");
				}
			};

			org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel sashModel = SashModelUtils.getSashModel(modelSet);
			Resource sashRes = (sashModel == null) ? null : sashModel.getResource();
			Welcome sashWelcome = (sashRes == null) ? null : (Welcome) EcoreUtil.getObjectByType(sashRes.getContents(), WelcomePackage.Literals.WELCOME);

			if (sashWelcome != null) {
				// The user has customized this one
				welcome = sashWelcome;
			} else {
				// Create the empty prototype
				welcome = WelcomeFactory.eINSTANCE.createWelcome();
				welcomeResource.getContents().add(welcome);
			}
		}

		@Override
		public Resource getResource(URI uri, boolean loadOnDemand) {
			Resource result;

			if (uri.equals(welcomeResource.getURI())) {
				// The welcome resource is always implicitly loaded
				result = welcomeResource;
			} else {
				result = basicGetResource(uri, loadOnDemand);
			}

			return result;
		}

		// More or less copied from EMF
		@Override
		protected Resource basicGetResource(URI uri, boolean loadOnDemand) {
			Map<URI, Resource> map = resourceSet.getURIResourceMap();
			if (map != null) {
				Resource resource = map.get(uri);
				if (resource != null) {
					if (loadOnDemand && !resource.isLoaded()) {
						demandLoadHelper(resource);
					}
					return resource;
				}
			}

			URIConverter theURIConverter = resourceSet.getURIConverter();
			URI normalizedURI = theURIConverter.normalize(uri);
			for (Resource resource : resourceSet.getResources()) {
				if (theURIConverter.normalize(resource.getURI()).equals(normalizedURI)) {
					if (loadOnDemand && !resource.isLoaded()) {
						demandLoadHelper(resource);
					}

					if (map != null) {
						map.put(uri, resource);
					}
					return resource;
				}
			}

			Resource delegatedResource = delegatedGetResource(uri, loadOnDemand);
			if (delegatedResource != null) {
				if (map != null) {
					map.put(uri, delegatedResource);
				}
				return delegatedResource;
			}

			if (loadOnDemand) {
				Resource resource = demandCreateResource(uri);
				if (resource == null) {
					throw new IllegalArgumentException(String.format("Cannot create a resource for '%s'; a registered resource factory is needed", uri));
				}

				demandLoadHelper(resource);

				if (map != null) {
					map.put(uri, resource);
				}
				return resource;
			}

			return null;

		}

		@Override
		public void dispose() {
			super.dispose();

			welcomeResource.unload();
		}

		Welcome getWelcome() {
			return welcome;
		}

		Resource getWelcomeResource() {
			return welcomeResource;
		}
	}
}
