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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.StructuredSelection;
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
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablestyle.Style;
import org.eclipse.papyrus.infra.nattable.tree.CollapseAndExpandActionsEnum;
import org.eclipse.papyrus.infra.nattable.tree.ITreeItemAxisHelper;
import org.eclipse.papyrus.infra.nattable.utils.HeaderAxisConfigurationManagementUtils;
import org.eclipse.papyrus.infra.nattable.utils.NattableModelManagerFactory;
import org.eclipse.papyrus.infra.nattable.utils.TableHelper;
import org.eclipse.papyrus.infra.properties.contexts.Property;
import org.eclipse.papyrus.infra.properties.ui.modelelement.CompositeModelElement;
import org.eclipse.papyrus.infra.properties.ui.modelelement.DataSource;
import org.eclipse.papyrus.infra.properties.ui.modelelement.DataSourceChangedEvent;
import org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElement;
import org.eclipse.papyrus.infra.properties.ui.modelelement.IDataSourceListener;
import org.eclipse.papyrus.infra.properties.ui.modelelement.ModelElement;
import org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.papyrus.uml.properties.modelelement.UMLNotationModelElement;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.uml2.uml.Element;

/**
 * The property editor for the nattable widget.
 */
public class NattablePropertyEditor extends AbstractPropertyEditor {

	/**
	 * The composite.
	 */
	protected Group self = null;;

	/**
	 * The table configuration URI.
	 */
	private URI tableConfigURI = null;

	/**
	 * The nattable widget.
	 */
	protected NatTable natTableWidget = null;

	/**
	 * The nattable manager.
	 */
	protected INattableModelManager nattableManager = null;

	/**
	 * The dispose listener.
	 */
	private DisposeListener nattableDisposeListener = null;

	/**
	 * The data source listener.
	 */
	private IDataSourceListener dataSourceListener;

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
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor#checkInput()
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
	 * @see org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor#doBinding()
	 */
	@Override
	protected void doBinding() {
		super.doBinding();

		final ModelElement modelElement = input.getModelElement(propertyPath);

		// The data neede to create the table
		final List<Object> rows = new ArrayList<Object>();
		EObject sourceElement = null;
		EStructuralFeature feature = null;

		// Manage the data needed for the table creation
		if (modelElement instanceof CompositeModelElement) {
			if (!((CompositeModelElement) modelElement).getSubElements().isEmpty()) {
				if (((CompositeModelElement) modelElement).getSubElements().get(0) instanceof UMLNotationModelElement) {
					final EModelElement eModelElement = ((UMLNotationModelElement) ((CompositeModelElement) modelElement).getSubElements().get(0)).getEModelElement();
					// Fill the list of views to determinate the axis to display (cannot be created without the table editing domain)
					for (ModelElement subModelElement : ((CompositeModelElement) modelElement).getSubElements()) {
						if (subModelElement instanceof UMLNotationModelElement) {
							rows.add(((UMLNotationModelElement) subModelElement).getEModelElement());
						}
					}
					sourceElement = eModelElement;
				} else if (((CompositeModelElement) modelElement).getSubElements().get(0) instanceof EMFModelElement) {
					final EMFModelElement emfModelElement = (EMFModelElement) ((CompositeModelElement) modelElement).getSubElements().get(0);
					sourceElement = emfModelElement.getSource();
					feature = emfModelElement.getFeature(getLocalPropertyPath());
				}
			}
		} else if (modelElement instanceof UMLNotationModelElement) {
			final EModelElement eModelElement = ((UMLNotationModelElement) modelElement).getEModelElement();
			// Fill the list of views to determinate the axis to display (cannot be created without the table editing domain)
			rows.add(eModelElement);
			sourceElement = eModelElement;
		} else if (modelElement instanceof EMFModelElement) {
			final EMFModelElement emfModelElement = (EMFModelElement) modelElement;
			sourceElement = emfModelElement.getSource();
			feature = emfModelElement.getFeature(getLocalPropertyPath());
		} else {
			displayError("Invalid table context"); //$NON-NLS-1$
			return;
		}

		createTableWidget(sourceElement, feature, rows);

	}

	/**
	 * This allow to create the table widget.
	 * 
	 * @param sourceElement
	 *            The source Element.
	 * @param feature
	 *            The feature.
	 * @param rows
	 *            The rows of the table.
	 */
	protected void createTableWidget(final EObject sourceElement, final EStructuralFeature feature, final Collection<?> rows) {

		// Create the table
		final Table table = createTable(sourceElement, feature, rows);
		if (table == null) {
			displayError("Cannot initialize the table"); //$NON-NLS-1$
			return;
		}

		// Create the widget
		nattableManager = NattableModelManagerFactory.INSTANCE.createNatTableModelManager(table, new EObjectSelectionExtractor());
		natTableWidget = nattableManager.createNattable(self, SWT.NONE, null);
		if (nattableManager instanceof TreeNattableModelManager) {
			configureTreeTable((TreeNattableModelManager) nattableManager, sourceElement, feature, rows);

			((TreeNattableModelManager) nattableManager).doCollapseExpandAction(CollapseAndExpandActionsEnum.EXPAND_ALL, null);
		}

		self.addDisposeListener(getDisposeListener());
		natTableWidget.setBackground(self.getBackground());

		// Configure the layout and the layout data
		configureLayout();
	}

	/**
	 * This allows to configure the tree table.
	 * 
	 * @param nattableManager
	 *            The nattable model manager.
	 * @param sourceElement
	 *            The source Element.
	 * @param feature
	 *            The feature.
	 * @param rows
	 *            The rows of the table.
	 */
	protected void configureTreeTable(final TreeNattableModelManager nattableManager, final EObject sourceElement, final EStructuralFeature feature, final Collection<?> rows) {
		// Do nohting
	}
	
	/**
	 * This allows to configure the layout and the layout data.
	 */
	protected void configureLayout(){
		// Adapt the group to the table preferred size
		final GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);

		// The preferred height of the nattable calculate it for each row (even if some are hidden)
		// So to calculate the correct height for the composite :
		// - Calculate the header height
		// - Calculate the body height
		// Add these values and add some extra to have correct displays
		final int headerHeight = natTableWidget.getPreferredHeight() - nattableManager.getBodyLayerStack().getRowHideShowLayer().getPreferredHeight();
		final int bodyHeight = nattableManager.getBodyLayerStack().getRowHideShowLayer().getHeight();
		final int extra = 20;
		data.minimumHeight = headerHeight + bodyHeight + extra;
		self.setLayoutData(data);

		self.layout();
		natTableWidget.layout();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor#updateDescription(java.lang.String)
	 */
	@Override
	protected void updateDescription(String description) {
		self.setToolTipText(description);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor#updateLabel(java.lang.String)
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
		final Label label = new Label(self, SWT.NONE);
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
	 * @param rows
	 *            The rows of the table.
	 * @return The created nattable.
	 */
	protected Table createTable(final EObject sourceElement, final EStructuralFeature synchronizedFeature, final Collection<?> rows) {

		final TableConfiguration tableConfiguration = getTableConfiguration();
		if (tableConfiguration == null) {
			return null;
		}

		final Property property = getModelProperty();
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

		if (null != synchronizedFeature) {
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

		for (final Style style : tableConfiguration.getStyles()) {
			table.getStyles().add(EcoreUtil.copy(style));
		}

		// Manage the construction of axis here because the table editing domain is null
		if (TableHelper.isTreeTable(table) && null != rows && !rows.isEmpty()) {// add test on TreeTable to fix bug 476623
			final AbstractAxisProvider axisProvider = table.getCurrentRowAxisProvider();
			TableHeaderAxisConfiguration conf = (TableHeaderAxisConfiguration) HeaderAxisConfigurationManagementUtils.getRowAbstractHeaderAxisInTableConfiguration(table);
			AxisManagerRepresentation rep = conf.getAxisManagers().get(0);
			for (Object context : rows) {
				addTreeItemAxis(axisProvider, rep, context);
			}
		}

		return table;
	}

	/**
	 * This allow to add the tree item axis.
	 * 
	 * @param axisProvider
	 *            The axis provider.
	 * @param rep
	 *            The axis manager representation.
	 * @param object
	 *            The object to add.
	 */
	protected void addTreeItemAxis(final AbstractAxisProvider axisProvider, final AxisManagerRepresentation rep, final Object object) {
		if (object instanceof View && isStereotypedElement((View) object)) {
			final IAxis axis = ITreeItemAxisHelper.createITreeItemAxis(null, null, object, rep);
			axisProvider.getAxis().add(axis);
		}
	}

	/**
	 * Check is the element of the view is stereotyped.
	 * 
	 * @param view
	 *            The view.
	 * @return <code>true</code> if the element of view is stereotyped, <code>false</code> otherwise.
	 */
	protected boolean isStereotypedElement(final View view) {
		boolean result = false;
		if (view.getElement() instanceof Element && !((Element) view.getElement()).getAppliedStereotypes().isEmpty()) {
			result = true;
		}
		return result;
	}

	/**
	 * Get the table configuration (from the table configuration URI).
	 * 
	 * @return The table configuration.
	 */
	protected TableConfiguration getTableConfiguration() {
		ResourceSet resourceSet = new ResourceSetImpl();
		try {
			final TableConfiguration tableConfiguration = (TableConfiguration) EMFHelper.loadEMFModel(resourceSet,
					tableConfigURI);
			return tableConfiguration;
		} catch (Exception ex) {
			Activator.log.error("Invalid table configuration", ex); //$NON-NLS-1$
		}

		return null;
	}

	/**
	 * This allow to create the dispose listener for the nattable table manager.
	 * 
	 * @return The dispose nattable manager listener.
	 */
	protected DisposeListener getDisposeListener() {
		if (null == nattableDisposeListener) {
			nattableDisposeListener = new DisposeListener() {

				public void widgetDisposed(DisposeEvent e) {
					nattableManager.dispose();
					natTableWidget.dispose();
				}
			};
		}
		return nattableDisposeListener;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor#unhookDataSourceListener(org.eclipse.papyrus.infra.properties.ui.modelelement.DataSource)
	 */
	@Override
	protected void unhookDataSourceListener(DataSource oldInput) {
		oldInput.removeDataSourceListener(getDataSourceListener());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.properties.ui.widgets.AbstractPropertyEditor#hookDataSourceListener(org.eclipse.papyrus.infra.properties.ui.modelelement.DataSource)
	 */
	@Override
	protected void hookDataSourceListener(DataSource newInput) {
		newInput.addDataSourceListener(getDataSourceListener());
	}

	/**
	 * This allow to create the data source listener.
	 * 
	 * @return The created data source listeer.
	 */
	private IDataSourceListener getDataSourceListener() {
		if (dataSourceListener == null) {
			dataSourceListener = new IDataSourceListener() {

				public void dataSourceChanged(final DataSourceChangedEvent event) {
					if (null != nattableManager) {
						nattableManager.dispose();
						nattableManager = null;
					}
					// Dispose the previous nattablewidget if necessary
					if (null != natTableWidget) {
						natTableWidget.dispose();
						natTableWidget = null;
						self.removeDisposeListener(getDisposeListener());
					}
					// Get the datasource
					final DataSource dataSource = event.getDataSource();
					final StructuredSelection selection = (StructuredSelection) dataSource.getSelection();

					// Manage the context selection
					final List<Object> contexts = new ArrayList<Object>(selection.size());
					final Iterator<?> selectionIterator = selection.iterator();
					while (selectionIterator.hasNext()) {
						Object selectedObject = selectionIterator.next();
						if (selectedObject instanceof AbstractEditPart) {
							contexts.add(((AbstractEditPart) selectedObject).getModel());
						} else {
							contexts.add(selectedObject);
						}
					}

					// Get the model element
					if(0 < contexts.size()){
						final ModelElement modelElement = dataSource.getModelElement(propertyPath);
						EObject sourceElement = EMFHelper.getEObject(contexts.get(0));
						EStructuralFeature feature = null;
						if (modelElement instanceof CompositeModelElement) {
							if (!((CompositeModelElement) modelElement).getSubElements().isEmpty()) {
								if (((CompositeModelElement) modelElement).getSubElements().get(0) instanceof EMFModelElement) {
									final EMFModelElement emfModelElement = (EMFModelElement) ((CompositeModelElement) modelElement).getSubElements().get(0);
									feature = emfModelElement.getFeature(getLocalPropertyPath());
								}
							}
						} else if (modelElement instanceof EMFModelElement) {
							final EMFModelElement emfModelElement = (EMFModelElement) modelElement;
							feature = emfModelElement.getFeature(getLocalPropertyPath());
						}
					
						// Recreate the table widget
						createTableWidget(sourceElement, feature, contexts);
					}
				}
			};
		}

		return dataSourceListener;
	}
}
