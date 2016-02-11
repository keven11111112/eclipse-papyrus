/*****************************************************************************
 * Copyright (c) 2009, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bugs 451230, 485220
 *  Shuai Li - Modifications for navigation menu integration
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.hyperlink.editpolicies;

import java.util.ArrayList;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.tools.AbstractPopupBarTool;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.ServiceUtilsForEditPart;
import org.eclipse.papyrus.infra.gmfdiag.hyperlink.Activator;
import org.eclipse.papyrus.infra.gmfdiag.navigation.editpolicy.NavigationEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.navigation.menu.button.HyperlinkButton;
import org.eclipse.papyrus.infra.hyperlink.helper.AbstractHyperLinkHelper;
import org.eclipse.papyrus.infra.hyperlink.helper.HyperLinkHelperFactory;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkDocument;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkWeb;
import org.eclipse.papyrus.infra.hyperlink.ui.HyperLinkManagerShell;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkException;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkHelpersRegistrationUtil;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.ui.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.infra.ui.editorsfactory.PageIconsRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * The Class HyperlinkNavigationMenuEditPolicy can be applied on edit part to display
 * shortcuts on sub-diagrams or to associate hyper-link of files, in addition to the
 * tools provided by the Navigation menu.
 */
public class HyperlinkNavigationMenuEditPolicy extends NavigationEditPolicy {

	/** The editor registry. */
	private IPageIconsRegistry editorRegistry;

	/** The hyper link manager shell. */
	private HyperLinkManagerShell hyperLinkManagerShell;

	protected LinkedList<HyperLinkObject> hyperLinkObjectList;

	protected HyperLinkHelperFactory hyperlinkHelperFactory;

	public HyperlinkNavigationMenuEditPolicy() {
		super();

		ArrayList<AbstractHyperLinkHelper> hyperLinkHelpers = new ArrayList<AbstractHyperLinkHelper>();
		// TODO
		// hyperLinkHelpers.add(new DiagramHyperLinkHelper());
		// hyperLinkHelpers.add(new DocumentHyperLinkHelper());
		// hyperLinkHelpers.add(new WebHyperLinkHelper());
		hyperLinkHelpers.addAll(HyperLinkHelpersRegistrationUtil.INSTANCE.getAllRegisteredHyperLinkHelper());
		hyperlinkHelperFactory = new HyperLinkHelperFactory(hyperLinkHelpers);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void appendNavigationMenuItem() {
		clearAppendObjects();

		// add all subdiagrams
		try {
			hyperLinkObjectList = new LinkedList<HyperLinkObject>();
			ArrayList<HyperLinkObject> unfilteredHyperlinkObjects = (ArrayList<HyperLinkObject>) hyperlinkHelperFactory.getAllreferenced(((IGraphicalEditPart) getHost()).getNotationView());

			for (AbstractHyperLinkHelper hyperlinkHelper : hyperlinkHelperFactory.getHyperLinkHelpers()) {
				hyperLinkObjectList.addAll(hyperlinkHelper.getFilteredObject(unfilteredHyperlinkObjects));
			}

			if (hyperLinkObjectList.isEmpty()) {
				hyperLinkObjectList.addAll(unfilteredHyperlinkObjects);
			} else if (hyperLinkObjectList.size() != unfilteredHyperlinkObjects.size()) {
				hyperLinkObjectList.clear();
				hyperLinkObjectList.addAll(unfilteredHyperlinkObjects);
			}

			addHyperlinks();
		} catch (HyperLinkException e) {
			Activator.log.error(e);
		}

		// Add the New Hyperlink tool
		addNavigationMenuHyperlinkDescriptor(Activator.getDefault().getIcon(Activator.IMG_PLUS), new AddHyperlinkAction(), "Open hyperlinks menu", "Modify hyperlinks");
	}

	private void addHyperlinks() {
		ILabelProvider labelProvider = null;
		boolean localLabelProvider = false;
		try {
			EObject contextElement = EMFHelper.getEObject(getHost());
			labelProvider = ServiceUtilsForEObject.getInstance().getService(LabelProviderService.class, contextElement).getLabelProvider();
		} catch (ServiceException ex) {
			Activator.log.error(ex);
		}

		if (labelProvider == null) {
			labelProvider = new LabelProvider();
			localLabelProvider = true;
		}

		for (HyperLinkObject hyperlink : hyperLinkObjectList) {
			String tooltip;
			String text;
			if (labelProvider instanceof CellLabelProvider) {
				tooltip = ((CellLabelProvider) labelProvider).getToolTipText(hyperlink);
				text = tooltip;
			} else {
				if (hyperlink instanceof HyperLinkDocument || hyperlink instanceof HyperLinkWeb) {
					text = hyperlink.getTooltipText();
					tooltip = labelProvider.getText(hyperlink);
				} else {
					text = labelProvider.getText(hyperlink);
					tooltip = hyperlink.getTooltipText();
				}

				if (tooltip == null) {
					tooltip = text;
				}

				if (text == null) {
					text = tooltip;
				}
			}

			addNavigationMenuHyperlinkDescriptor(labelProvider.getImage(hyperlink), new NavigateHyperlinkAction(hyperlink), tooltip, text);
		}

		if (localLabelProvider) {
			labelProvider.dispose();
		}
	}

	protected void addNavigationMenuHyperlinkDescriptor(Image theImage, IAction theAction, String theTip, String theText) {
		if (!(theAction instanceof AbstractPopupBarTool) || ((AbstractPopupBarTool) theAction).isCommandEnabled()) {
			// We only add pop-up bar tools whose commands are actually executable in this context
			HyperlinkButton desc = new HyperlinkButton(theText, theTip, theImage, theAction);
			this.navigationMenu.getAppendObjects().add(desc);
		}
	}

	//
	// Nested types
	//

	// protected abstract class AbstractHyperlinkTool extends AbstractTool implements DragTracker {
	protected abstract class AbstractHyperlinkAction extends Action {

	}

	public class AddHyperlinkAction extends AbstractHyperlinkAction {
		@Override
		public void run() {
			hyperLinkManagerShell = new HyperLinkManagerShell(getEditorRegistry(), ((IGraphicalEditPart) getHost()).getEditingDomain(), (EModelElement) ((IGraphicalEditPart) getHost()).getNotationView().getElement(),
					((IGraphicalEditPart) getHost()).getNotationView(), hyperlinkHelperFactory);
			hyperLinkManagerShell.setInput(hyperLinkObjectList);

			// Hide the navigation menu now because the shell is modal
			// destroyViewerContext();

			hyperLinkManagerShell.open();
		}
	}

	protected class NavigateHyperlinkAction extends AbstractHyperlinkAction {
		private final HyperLinkObject hyperlink;

		public NavigateHyperlinkAction(HyperLinkObject hyperlink) {
			super();

			this.hyperlink = hyperlink;
		}

		@Override
		public void run() {
			if (hyperlink.needsOpenCommand()) {
				try {
					TransactionalEditingDomain editingDomain = ServiceUtilsForEditPart.getInstance().getTransactionalEditingDomain(getHost());
					editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain, hyperlink.getTooltipText()) {

						@Override
						protected void doExecute() {
							hyperlink.openLink();
						}
					});
				} catch (ServiceException ex) {

				}
			} else {
				hyperlink.openLink();
			}
		}
	}

	/**
	 * Return the EditorRegistry for nested editor descriptors. Subclass should
	 * implements this method in order to return the registry associated to the
	 * extension point namespace.
	 *
	 * @return the EditorRegistry for nested editor descriptors
	 *
	 * @generated NOT
	 */
	protected IPageIconsRegistry createEditorRegistry() {
		try {
			return ServiceUtilsForEditPart.getInstance().getService(IPageIconsRegistry.class, getHost());
		} catch (ServiceException e) {
			// Return an empty registry always providing null;
			return new PageIconsRegistry();
		}
	}

	/**
	 * Gets the editor registry.
	 *
	 * @return the singleton eINSTANCE of editor registry
	 *
	 * @generated NOT Get the EditorRegistry used to create editor instances.
	 *            This default implementation return the singleton eINSTANCE.
	 *            This method can be subclassed to return another registry.
	 */
	protected IPageIconsRegistry getEditorRegistry() {
		if (editorRegistry == null) {
			editorRegistry = createEditorRegistry();
		}
		return editorRegistry;
	}
}
