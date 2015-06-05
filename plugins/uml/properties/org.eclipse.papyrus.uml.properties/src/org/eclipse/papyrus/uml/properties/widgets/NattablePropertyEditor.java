/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.widgets;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.papyrus.infra.emf.nattable.selection.EObjectSelectionExtractor;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.TreeNattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattableFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.EStructuralFeatureValueFillingConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.TableHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration;
import org.eclipse.papyrus.infra.nattable.tree.CollapseAndExpandActionsEnum;
import org.eclipse.papyrus.infra.nattable.tree.ITreeItemAxisHelper;
import org.eclipse.papyrus.infra.nattable.utils.HeaderAxisConfigurationManagementUtils;
import org.eclipse.papyrus.infra.nattable.utils.NattableModelManagerFactory;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.papyrus.uml.properties.modelelement.UMLNotationModelElement;
import org.eclipse.papyrus.views.properties.contexts.Property;
import org.eclipse.papyrus.views.properties.modelelement.CompositeModelElement;
import org.eclipse.papyrus.views.properties.modelelement.EMFModelElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElement;
import org.eclipse.papyrus.views.properties.widgets.AbstractPropertyEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

/**
 * The property editor for the nattable widget.
 */
public class NattablePropertyEditor extends AbstractPropertyEditor{

	/**
	 * The composite.
	 */
	private Composite self = null;;

	/**
	 * The table configuration URI.
	 */
	private URI tableConfigURI = null;
	
	/**
	 * The row axis categories to hide.
	 */
	private List<Integer> rowsAxisCategoriesHide = null;
	
	/**
	 * The columns axis categories to hide.
	 */
	private List<Integer> columnsAxisCategoriesHide = null;

	/**
	 * Constructor.
	 *
	 * @param parent
	 *            The parent composite.
	 * @param style
	 *            The style of the composite.
	 */
	public NattablePropertyEditor(final Composite parent, final int style) {
		self = new Group(parent, SWT.NONE);
		FillLayout fillLayout = new FillLayout();
		fillLayout.marginHeight = 10;
		fillLayout.marginWidth = 10;
		self.setLayout(fillLayout);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.minimumHeight = 330;
		self.setLayoutData(data);
	}

	/**
	 * Set the table URI.
	 * 
	 * @param uri
	 *            The URI of the table (as String).
	 */
	public void setTableURI(final String uri) {
		tableConfigURI = URI.createURI(uri);
		checkInput();
	}

	/**
	 * Get the table configuration URI.
	 * 
	 * @return The table configuration URI.
	 */
	public String getTableURI() {
		return tableConfigURI == null ? null : tableConfigURI.toString();
	}
	
	/**
	 * Set the rows axis categories to hide.
	 * 
	 * @param axis
	 *            The axis to hide represented as String (separated by ",").
	 */
	public void setRowsAxisCategoriesHide(final String axis) {
		rowsAxisCategoriesHide = new ArrayList<Integer>();
		if(! axis.isEmpty()){
			String[] multiAxis = axis.split(","); //$NON-NLS-1$
			for(String oneAxis : multiAxis){
				try{
					rowsAxisCategoriesHide.add(Integer.parseInt(oneAxis));
				}catch(final NumberFormatException e){
					// Do nothing
				}
			}
		}
	}

	/**
	 * Get the rows axis categories to hide.
	 * 
	 * @return The rows axis categories to hide.
	 */
	public String getRowsAxisCategoriesHide() {
		return rowsAxisCategoriesHide == null ? null : rowsAxisCategoriesHide.toString();
	}
	
	/**
	 * Set the rows axis categories to hide.
	 * 
	 * @param axis
	 *            The axis to hide represented as String (separated by ",").
	 */
	public void setColumnsAxisCategoriesHide(final String axis) {
		columnsAxisCategoriesHide = new ArrayList<Integer>();
		if(! axis.isEmpty()){
			String[] multiAxis = axis.split(","); //$NON-NLS-1$
			for(String oneAxis : multiAxis){
				try{
					columnsAxisCategoriesHide.add(Integer.parseInt(oneAxis));
				}catch(final NumberFormatException e){
					// Do nothing
				}
			}
		}
	}

	/**
	 * Get the rows axis categories to hide.
	 * 
	 * @return The rows axis categories to hide.
	 */
	public String getColumnsAxisCategoriesHide() {
		return columnsAxisCategoriesHide == null ? null : columnsAxisCategoriesHide.toString();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.views.properties.widgets.AbstractPropertyEditor#checkInput()
	 */
	@Override
	protected void checkInput() {
		if (tableConfigURI != null) {
			super.checkInput();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.views.properties.widgets.AbstractPropertyEditor#doBinding()
	 */
	@Override
	protected void doBinding() {
		super.doBinding();

		// Configure the table
		ModelElement modelElement = input.getModelElement(propertyPath);

		Table table = null;
		if(modelElement instanceof CompositeModelElement){
			if(!((CompositeModelElement)modelElement).getSubElements().isEmpty()){
				if(((CompositeModelElement)modelElement).getSubElements().get(0) instanceof UMLNotationModelElement){
					EModelElement eModelElement = ((UMLNotationModelElement) ((CompositeModelElement)modelElement).getSubElements().get(0)).getEModelElement();
					// Create a list of views to determinate the axis to display (cannot be created without the table editing domain)
					final List<Object> views = new ArrayList<Object>();
					for(ModelElement a : ((CompositeModelElement)modelElement).getSubElements()){
						if(a instanceof UMLNotationModelElement){
							views.add(((UMLNotationModelElement)a).getEModelElement());
						}
					}
					table = createTable(eModelElement, null, views);
					if (table == null) {
						displayError("Cannot initialize the table"); //$NON-NLS-1$
						return;
					}
				} else if (((CompositeModelElement)modelElement).getSubElements().get(0) instanceof EMFModelElement) {
					EMFModelElement emfModelElement = (EMFModelElement) ((CompositeModelElement)modelElement).getSubElements().get(0);
					EObject sourceElement = emfModelElement.getSource();
					EStructuralFeature feature = emfModelElement.getFeature(getLocalPropertyPath());
					
					table = createTable(sourceElement, feature, null);
					if (table == null) {
						displayError("Cannot initialize the table"); //$NON-NLS-1$
						return;
					}
				}
			}
		}else if (modelElement instanceof UMLNotationModelElement) {
			EModelElement eModelElement = ((UMLNotationModelElement) modelElement).getEModelElement();
			// Create a list of views to determinate the axis to display (cannot be created without the table editing domain)
			final List<Object> views = new ArrayList<Object>();
			views.add(eModelElement);
			table = createTable(eModelElement, null, views);
			if (table == null) {
				displayError("Cannot initialize the table"); //$NON-NLS-1$
				return;
			}
		} else if (modelElement instanceof EMFModelElement) {
			EMFModelElement emfModelElement = (EMFModelElement) modelElement;
			EObject sourceElement = emfModelElement.getSource();
			EStructuralFeature feature = emfModelElement.getFeature(getLocalPropertyPath());

			table = createTable(sourceElement, feature, null);
			if (table == null) {
				displayError("Cannot initialize the table"); //$NON-NLS-1$
				return;
			}
		} else {
			displayError("Invalid table context"); //$NON-NLS-1$
			return;
		}
		
		// Create the widget
		final INattableModelManager nattableManager = NattableModelManagerFactory.INSTANCE.createNatTableModelManager(table, new EObjectSelectionExtractor());
		NatTable widget = nattableManager.createNattable(self, SWT.NONE, null);
		if (nattableManager instanceof TreeNattableModelManager) {
			((TreeNattableModelManager) nattableManager).doCollapseExpandAction(CollapseAndExpandActionsEnum.EXPAND_ALL, null);
			// Hide categories
			((TreeNattableModelManager)nattableManager).hideShowRowCategories(rowsAxisCategoriesHide, columnsAxisCategoriesHide);
		}
		self.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				nattableManager.dispose();
			}
		});

		widget.setBackground(self.getBackground());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.views.properties.widgets.AbstractPropertyEditor#updateDescription(java.lang.String)
	 */
	@Override
	protected void updateDescription(String description) {
		self.setToolTipText(description);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.views.properties.widgets.AbstractPropertyEditor#updateLabel(java.lang.String)
	 */
	@Override
	public void updateLabel(final String label) {
		if (showLabel) {
			((Group) self).setText(getLabel());
		}
	}

	/**
	 * This allow to display the error.
	 * 
	 * @param message
	 *            The error mesage to display.
	 */
	protected void displayError(final String message) {
		Label label = new Label(self, SWT.NONE);
		label.setText(message);
		label.setImage(org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("icons/error.gif")); //$NON-NLS-1$
	}

	/**
	 * This allow to create the nattable.
	 * 
	 * @param sourceElement
	 *            The context element.
	 * @param synchronizedFeature
	 *            The synchronized feature.
	 * @return The created nattable.
	 */
	protected Table createTable(final EObject sourceElement, final EStructuralFeature synchronizedFeature, final List<Object> views) {

		final TableConfiguration tableConfiguration = getTableConfiguration();
		if (tableConfiguration == null) {
			return null;
		}

		Property property = getModelProperty();
		final Table table = NattableFactory.eINSTANCE.createTable();

		table.setTableConfiguration(tableConfiguration);
		
		if (property != null) {
			String description = property.getDescription();
			if (description != null) {
				table.setDescription(description);
			}
		}

		table.setName(getLabel());

		AbstractAxisProvider rowProvider = tableConfiguration.getDefaultRowAxisProvider();
		if (rowProvider == null) {
			rowProvider = NattableaxisproviderFactory.eINSTANCE.createMasterObjectAxisProvider();
		} else {
			rowProvider = EcoreUtil.copy(rowProvider);
		}

		AbstractAxisProvider columnProvider = tableConfiguration.getDefaultColumnAxisProvider();
		if (columnProvider == null) {
			columnProvider = NattableaxisproviderFactory.eINSTANCE.createSlaveObjectAxisProvider();
		} else {
			columnProvider = EcoreUtil.copy(columnProvider);
		}

		if(null != synchronizedFeature){
			TableHeaderAxisConfiguration rowHeaderAxisconfig = tableConfiguration.getRowHeaderAxisConfiguration();
			for (IAxisConfiguration axisConfig : rowHeaderAxisconfig.getOwnedAxisConfigurations()) {
				if (axisConfig instanceof EStructuralFeatureValueFillingConfiguration) {
					((EStructuralFeatureValueFillingConfiguration) axisConfig).setListenFeature(synchronizedFeature);
				}
			}
		}

		table.setCurrentColumnAxisProvider(columnProvider);
		table.setCurrentRowAxisProvider(rowProvider);
		
		table.setContext(sourceElement);
		
		// Manage the construction of axis here because the table editing domain is null
		if(null != views && !views.isEmpty()){
			final AbstractAxisProvider axisProvider = table.getCurrentRowAxisProvider();
			TableHeaderAxisConfiguration conf = (TableHeaderAxisConfiguration) HeaderAxisConfigurationManagementUtils.getRowAbstractHeaderAxisInTableConfiguration(table);
			AxisManagerRepresentation rep = conf.getAxisManagers().get(0);
			for(Object view : views){
				IAxis a = ITreeItemAxisHelper.createITreeItemAxis(null, null, view, rep);
				axisProvider.getAxis().add(a);
			}
		}
		
		return table;
	}

	/**
	 * Get the table configuration (from the table configuration URI).
	 * 
	 * @return The table configuration.
	 */
	protected TableConfiguration getTableConfiguration() {
		ResourceSet resourceSet = new ResourceSetImpl();
		try {
			TableConfiguration tableConfiguration = (TableConfiguration) EMFHelper.loadEMFModel(resourceSet,
					tableConfigURI);
			return tableConfiguration;
		} catch (Exception ex) {
			Activator.log.error("Invalid table configuration", ex); //$NON-NLS-1$
		}

		return null;
	}
	
}
