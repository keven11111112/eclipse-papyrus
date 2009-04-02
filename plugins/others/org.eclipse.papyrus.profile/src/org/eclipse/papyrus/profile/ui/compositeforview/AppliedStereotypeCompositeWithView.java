/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.profile.ui.compositeforview;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.JFaceColors;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.papyrus.profile.tree.objects.AppliedStereotypePropertyTreeObject;
import org.eclipse.papyrus.umlutils.ui.helper.AppliedStereotypeHelper;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * This Composite allows displaying applied stereotypes from the model, but allows also displaying it in the associated view.
 */
public class AppliedStereotypeCompositeWithView extends org.eclipse.papyrus.profile.ui.compositesformodel.AppliedStereotypeCompositeOnModel {

	/**
	 * The selection.
	 */
	protected ISelection selection;

	/**
	 * The property composite.
	 */
	protected AppliedStereotypePropertyCompositeWithView propertyComposite;

	private EModelElement diagramElement;

	/**
	 * The Constructor.
	 * 
	 * @param parent
	 *            the parent
	 */
	public AppliedStereotypeCompositeWithView(Composite parent, TransactionalEditingDomain domain) {
		super(parent);
		this.setBackground(JFaceColors.getBannerBackground(parent.getDisplay()));
		this.setDomain(domain);
	}

	/**
	 * Creates the content.
	 * 
	 * @param parent
	 *            the parent
	 * @param factory
	 *            the factory
	 * 
	 * @return the composite
	 */
	@Override
	public Composite createContent(Composite parent, TabbedPropertySheetWidgetFactory factory) {
		super.createContent(parent, factory);

		// Replace label and content providers in treeViewers
		treeViewer.setContentProvider(new ProfileElementWithDisplayContentProvider(diagramElement));
		treeViewer.setLabelProvider(new ProfileElementWithDisplayLabelProvider());

		refresh();
		return this;
	}

	/**
	 * Sets the selection.
	 * 
	 * @param selection
	 *            the selection
	 */
	public void setSelection(ISelection selection) {
		this.selection = selection;
	}

	/**
	 * Sets the diagram element.
	 * 
	 * @param diagramElement
	 *            the diagram element
	 */
	public void setDiagramElement(EModelElement diagramElement) {
		this.diagramElement = diagramElement;
		((ProfileElementWithDisplayContentProvider) treeViewer.getContentProvider()).setDiagramElement(diagramElement);
	}

	/**
	 * Sets the property composite associated to this stereotype composite
	 * 
	 * @param propertyComposite
	 *            the composite associated to this stereotype composite used for stereotype property display.
	 */
	public void setPropertyComposite(AppliedStereotypePropertyCompositeWithView propertyComposite) {
		this.propertyComposite = propertyComposite;
	}

	/**
	 * Gets the selected.
	 * 
	 * @return the selected
	 */
	@Override
	public Element getSelected() {
		Object input = ((IStructuredSelection) selection).getFirstElement();
		if (input instanceof GraphicalEditPart) {
			if (((GraphicalEditPart) input).getModel() instanceof View) {
				return (Element) ((View) ((GraphicalEditPart) input).getModel()).getElement();
			}
		}
		return null;
	}

	/**
	 * Adds the button pressed.
	 */
	@Override
	public void addButtonPressed() {
		super.addButtonPressed();
	}

	/**
	 * Display the stereotype once it is applied
	 * 
	 * @param st
	 *            the stereotype to add
	 */
	@Override
	protected void applyStereotype(final Element elt, final Stereotype st) {
		super.applyStereotype(elt, st);
		// bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
		if (diagramElement == null) {
			return;
		}
		try {

			getDomain().runExclusive(new Runnable() {

				public void run() {

					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {
							String presentationKind = AppliedStereotypeHelper.getAppliedSterotypePresentationKind(diagramElement);
							RecordingCommand command = AppliedStereotypeHelper.getAddAppliedStereotypeCommand(getDomain(), diagramElement, st.getQualifiedName(), presentationKind);
							getDomain().getCommandStack().execute(command);
						}
					});
				}
			});

		} catch (Exception e) {
			System.err.println(e);
		}

	}

	/**
	 * Remove a stereotype from the list of stereotypes to display.
	 * 
	 * @param st
	 *            the stereotype to remove
	 */
	@Override
	protected void unapplyStereotype(final Element elt, final Stereotype st) {
		super.unapplyStereotype(elt, st);
		// bugfix: a selected element is not necessary a diagram element (ex: selection in the outline)
		if (diagramElement == null) {
			return;
		}
		try {
			getDomain().runExclusive(new Runnable() {

				public void run() {

					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {
							String presentationKind = AppliedStereotypeHelper.getAppliedSterotypePresentationKind(diagramElement);
							RecordingCommand command = AppliedStereotypeHelper.getRemoveAppliedStereotypeCommand(getDomain(), diagramElement, st.getQualifiedName(), presentationKind);

							getDomain().getCommandStack().execute(command);
						}
					});
				}
			});
		} catch (Exception e) {
			System.err.println(e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.papyrus.profile.ui.composites.StereotypeComposite#removeButtonPressed()
	 */
	@Override
	public void removeButtonPressed() {
		superRemoveButton();
	}

	/**
	 * Calls super method
	 */
	private void superRemoveButton() {
		super.removeButtonPressed();
	}

	/**
	 * Selection changed.
	 * 
	 * @param event
	 *            the event
	 */
	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		if (event == null) {
			propertyComposite.setInput(null);
			return;
		}

		IStructuredSelection structSelection = (IStructuredSelection) event.getSelection();
		Object selection = structSelection.getFirstElement();

		if (selection instanceof AppliedStereotypePropertyTreeObject) {
			propertyComposite.setInput((AppliedStereotypePropertyTreeObject) selection);
		} else {
			propertyComposite.setInput(null);
		}
	}
}
