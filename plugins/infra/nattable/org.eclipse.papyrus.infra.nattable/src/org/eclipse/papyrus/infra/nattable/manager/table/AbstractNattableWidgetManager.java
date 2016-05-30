/*****************************************************************************
 * Copyright (c) 2012, 2016 CEA LIST and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 402525
 *  Christian W. Damus (CEA) - bug 430880
 *  Dirk Fauth <dirk.fauth@googlemail.com> - Bug 488234
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.manager.table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.coordinate.Range;
import org.eclipse.nebula.widgets.nattable.copy.command.CopyDataToClipboardCommand;
import org.eclipse.nebula.widgets.nattable.data.IDataProvider;
import org.eclipse.nebula.widgets.nattable.export.command.ExportCommand;
//import org.eclipse.nebula.widgets.nattable.filterrow.FilterRowHeaderComposite;
import org.eclipse.nebula.widgets.nattable.filterrow.IFilterStrategy;
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.grid.data.DefaultCornerDataProvider;
import org.eclipse.nebula.widgets.nattable.grid.layer.CornerLayer;
import org.eclipse.nebula.widgets.nattable.grid.layer.GridLayer;
import org.eclipse.nebula.widgets.nattable.layer.DataLayer;
import org.eclipse.nebula.widgets.nattable.layer.ILayerListener;
import org.eclipse.nebula.widgets.nattable.layer.LabelStack;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.layer.event.ILayerEvent;
import org.eclipse.nebula.widgets.nattable.print.command.PrintCommand;
import org.eclipse.nebula.widgets.nattable.print.command.TurnViewportOffCommand;
import org.eclipse.nebula.widgets.nattable.print.command.TurnViewportOnCommand;
import org.eclipse.nebula.widgets.nattable.print.config.DefaultPrintBindings;
import org.eclipse.nebula.widgets.nattable.reorder.ColumnReorderLayer;
import org.eclipse.nebula.widgets.nattable.reorder.event.ColumnReorderEvent;
import org.eclipse.nebula.widgets.nattable.resize.event.ColumnResizeEvent;
import org.eclipse.nebula.widgets.nattable.resize.event.RowResizeEvent;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer;
import org.eclipse.nebula.widgets.nattable.selection.command.SelectAllCommand;
import org.eclipse.nebula.widgets.nattable.selection.command.SelectColumnCommand;
import org.eclipse.nebula.widgets.nattable.selection.command.SelectRowsCommand;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.nebula.widgets.nattable.ui.binding.UiBindingRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.command.CommandIds;
import org.eclipse.papyrus.infra.nattable.command.UpdateFilterMapCommand;
import org.eclipse.papyrus.infra.nattable.comparator.ObjectNameAndPathComparator;
import org.eclipse.papyrus.infra.nattable.configuration.CellEditorAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.configuration.ClearSelectionUIBindingConfiguration;
import org.eclipse.papyrus.infra.nattable.configuration.CornerConfiguration;
import org.eclipse.papyrus.infra.nattable.configuration.FilterRowAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.configuration.FilterRowCustomConfiguration;
import org.eclipse.papyrus.infra.nattable.configuration.RowSortModelConfiguration;
import org.eclipse.papyrus.infra.nattable.configuration.TableClickSortConfiguration;
import org.eclipse.papyrus.infra.nattable.configuration.TablePopupMenuConfiguration;
import org.eclipse.papyrus.infra.nattable.dataprovider.AbstractCompositeDataProvider;
import org.eclipse.papyrus.infra.nattable.dataprovider.BodyDataProvider;
import org.eclipse.papyrus.infra.nattable.dataprovider.ColumnIndexHeaderDataProvider;
import org.eclipse.papyrus.infra.nattable.dataprovider.ColumnLabelHeaderDataProvider;
import org.eclipse.papyrus.infra.nattable.dataprovider.CompositeColumnHeaderDataProvider;
import org.eclipse.papyrus.infra.nattable.dataprovider.CompositeRowHeaderDataProvider;
import org.eclipse.papyrus.infra.nattable.display.converter.ObjectNameAndPathDisplayConverter;
import org.eclipse.papyrus.infra.nattable.fillhandle.config.PapyrusFillHandleConfiguration;
import org.eclipse.papyrus.infra.nattable.filter.configuration.IFilterConfiguration;
import org.eclipse.papyrus.infra.nattable.layer.FilterRowHeaderComposite;
import org.eclipse.papyrus.infra.nattable.layer.PapyrusGridLayer;
import org.eclipse.papyrus.infra.nattable.layerstack.BodyLayerStack;
import org.eclipse.papyrus.infra.nattable.layerstack.ColumnHeaderLayerStack;
import org.eclipse.papyrus.infra.nattable.layerstack.RowHeaderHierarchicalLayerStack;
import org.eclipse.papyrus.infra.nattable.layerstack.RowHeaderLayerStack;
import org.eclipse.papyrus.infra.nattable.listener.NatTableDropListener;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.EObjectAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.EStructuralFeatureAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.FeatureIdAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.LocalTableHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.TableHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablestyle.BooleanValueStyle;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablestyle.IntValueStyle;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablestyle.NamedStyle;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablestyle.NattablestyleFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablestyle.NattablestylePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablestyle.StringListValueStyle;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablestyle.StringValueStyle;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablestyle.Style;
import org.eclipse.papyrus.infra.nattable.provider.PapyrusNatTableToolTipProvider;
import org.eclipse.papyrus.infra.nattable.provider.TableSelectionProvider;
import org.eclipse.papyrus.infra.nattable.provider.TableStructuredSelection;
import org.eclipse.papyrus.infra.nattable.selection.ISelectionExtractor;
import org.eclipse.papyrus.infra.nattable.sort.IPapyrusSortModel;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.nattable.utils.DefaultSizeUtils;
import org.eclipse.papyrus.infra.nattable.utils.HeaderAxisConfigurationManagementUtils;
import org.eclipse.papyrus.infra.nattable.utils.LocationValue;
import org.eclipse.papyrus.infra.nattable.utils.NamedStyleConstants;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;
import org.eclipse.papyrus.infra.nattable.utils.PapyrusTableSizeCalculation;
import org.eclipse.papyrus.infra.nattable.utils.TableEditingDomainUtils;
import org.eclipse.papyrus.infra.nattable.utils.TableGridRegion;
import org.eclipse.papyrus.infra.nattable.utils.TableSelectionWrapper;
import org.eclipse.papyrus.infra.services.decoration.DecorationService;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.ui.util.EclipseCommandUtils;
import org.eclipse.papyrus.infra.widgets.util.NavigationTarget;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.services.IDisposable;

/**
 *
 * This class allows to create, configure and manipulate the NatTable Widget
 *
 */
public abstract class AbstractNattableWidgetManager implements INattableModelManager, NavigationTarget, IAdaptable {

	/**
	 * we need to keep it to be able to remove listener (required when we destroy the context of the table)
	 *
	 * The editing domain to use to edit context element
	 */
	protected TransactionalEditingDomain contextEditingDomain;

	/**
	 * we need to keep it to be able to remove listener (required when we destroy the context of the table)
	 *
	 * The editing domain to use to edit table elements
	 */
	protected TransactionalEditingDomain tableEditingDomain;

	/**
	 * the managed table
	 */
	private Table table;

	/**
	 * we need to keep it, to be able to remove the listener on it, when the table is destroying
	 */
	private EObject tableContext;

	/**
	 * the nattable widget
	 */
	protected NatTable natTable;

	/**
	 * the grid layer
	 */
	private GridLayer gridLayer;

	/**
	 * the columnHeaderLayerStack
	 */
	private ColumnHeaderLayerStack columnHeaderLayerStack;

	/**
	 * @return the rowHeaderLayerStack
	 */
	public ColumnHeaderLayerStack getColumnHeaderLayerStack() {
		return columnHeaderLayerStack;
	}

	/**
	 * the rowHeaderLayerStack
	 */
	private RowHeaderLayerStack rowHeaderLayerStack;

	/**
	 * @return the rowHeaderLayerStack
	 */
	public RowHeaderLayerStack getRowHeaderLayerStack() {
		return rowHeaderLayerStack;
	}

	/**
	 * the selection provider
	 */
	private TableSelectionProvider selectionProvider;

	private IFilterStrategy<Object> filterStrategy;

	/**
	 * the body layer stack
	 */
	private BodyLayerStack bodyLayerStack;

	private ILayerListener resizeAxisListener;

	private ILayerListener resizeRowHeaderListener;

	private ILayerListener resizeColumnHeaderListener;

	private AbstractCompositeDataProvider columnHeaderDataProvider;

	private AbstractCompositeDataProvider rowHeaderDataProvider;

	private BodyDataProvider bodyDataProvider;

	/**
	 * the composite layer providing the filter row in the column header
	 * 
	 * @since 2.0
	 */
	protected FilterRowHeaderComposite<?> filterColumnHeaderComposite;

	/**
	 * the sort model used for rows
	 */
	protected IPapyrusSortModel rowSortModel;

	private ISelectionExtractor selectionExtractor;

	/**
	 * this listener is used to update value in nattable layer
	 */
	private ResourceSetListener resourceSetListener;

	/**
	 * the filter configuration
	 */
	private FilterRowAxisConfiguration filterConfiguration;

	/**
	 * the cell editor axis configuration
	 */
	private CellEditorAxisConfiguration cellAxisConfiguration;

	/**
	 *
	 * Constructor.
	 *
	 * @param table
	 *            the model of the table
	 */
	public AbstractNattableWidgetManager(final Table table, final ISelectionExtractor selectionExtractor) {
		this.table = table;
		this.tableContext = table.getContext();
		this.selectionExtractor = selectionExtractor;
		this.tableEditingDomain = TableEditingDomainUtils.getTableEditingDomain(table);
		this.contextEditingDomain = TableEditingDomainUtils.getTableContextEditingDomain(table);
	}

	/**
	 * Returns the EditingDomain associated to the table
	 *
	 * @return
	 */
	protected final TransactionalEditingDomain getTableEditingDomain() {
		return this.tableEditingDomain;
	}

	/**
	 * Returns the EditingDomain associated to the context
	 *
	 * @return
	 */
	protected final TransactionalEditingDomain getContextEditingDomain() {
		return this.contextEditingDomain;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#createNattable(org.eclipse.swt.widgets.Composite, int, org.eclipse.ui.IWorkbenchPartSite)
	 *
	 * @param parent
	 * @param style
	 * @param site
	 * @return
	 */
	@Override
	public NatTable createNattable(final Composite parent, final int style, final IWorkbenchPartSite site) {
		this.bodyDataProvider = new BodyDataProvider(this);


		this.bodyLayerStack = new BodyLayerStack(this.bodyDataProvider, this);

		columnHeaderDataProvider = new CompositeColumnHeaderDataProvider(this);
		final IDataProvider indexColumnProvider = new ColumnIndexHeaderDataProvider(this);
		final IDataProvider labelColumnProvider = new ColumnLabelHeaderDataProvider(this);
		columnHeaderDataProvider.addDataProvider(indexColumnProvider);
		columnHeaderDataProvider.addDataProvider(labelColumnProvider);

		// this.columnHeaderDataProvider = new ColumnHeaderDataProvider(this);
		// this.columnHeaderDataProvider = new ColumnHeaderDataProvider(this);
		// this.columnHeaderLayerStack = new ColumnHeaderLayerStack(this.columnHeaderDataProvider, this.bodyLayerStack, this.bodyDataProvider, getRowSortModel());
		this.columnHeaderLayerStack = new ColumnHeaderLayerStack(this, indexColumnProvider, labelColumnProvider, this.bodyLayerStack, getRowSortModel());

		this.rowHeaderLayerStack = createRowHeaderLayerStack(this.bodyLayerStack);
		rowHeaderDataProvider = new CompositeRowHeaderDataProvider(this);
		rowHeaderDataProvider.addDataProvider(this.rowHeaderLayerStack.getIndexDataProvider());
		rowHeaderDataProvider.addDataProvider(this.rowHeaderLayerStack.getLabelDataProvider());



		// final IDataProvider cornerDataProvider = new DefaultCornerDataProvider(this.columnHeaderDataProvider, this.rowHeaderDataProvider);
		final IDataProvider cornerDataProvider = new DefaultCornerDataProvider(columnHeaderDataProvider, rowHeaderDataProvider);


		// create the filter layer, configRegistry can be null for our usecase
		this.filterStrategy = createFilterStrategy();
		this.filterColumnHeaderComposite = new FilterRowHeaderComposite<Object>(this.filterStrategy, columnHeaderLayerStack, columnHeaderDataProvider, this);

		// init the filter visibility
		this.filterColumnHeaderComposite.setFilterRowVisible(HeaderAxisConfigurationManagementUtils.getColumnAbstractHeaderAxisConfigurationUsedInTable(this.table).isDisplayFilter());

		final CornerLayer cornerLayer = new CornerLayer(new DataLayer(cornerDataProvider), this.rowHeaderLayerStack, filterColumnHeaderComposite);
		cornerLayer.addConfiguration(new CornerConfiguration(this));

		this.gridLayer = new PapyrusGridLayer(TransactionUtil.getEditingDomain(tableContext), this.bodyLayerStack, filterColumnHeaderComposite, this.rowHeaderLayerStack, cornerLayer);
		this.gridLayer.addConfiguration(new DefaultPrintBindings());
		this.natTable = new NatTable(parent, this.gridLayer, false);

		// we register nattable configuration
		addClickSortConfiguration(this.natTable);
		this.natTable.addConfiguration(new FilterRowCustomConfiguration());
		this.natTable.addConfiguration(new RowSortModelConfiguration(getRowSortModel()));
		this.natTable.addConfiguration(new ClearSelectionUIBindingConfiguration());

		// add the copy AND increment behavior
		this.natTable.addConfiguration(new PapyrusFillHandleConfiguration(this.bodyLayerStack.getSelectionLayer(), this));

		// we register some information in the config registry of the nattable widget
		IConfigRegistry configRegistry = this.natTable.getConfigRegistry();

		// could be done by config file!
		configRegistry.registerConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, AbstractNattableWidgetManager.this, DisplayMode.NORMAL, NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);
		configRegistry.registerConfigAttribute(NattableConfigAttributes.LABEL_PROVIDER_SERVICE_CONFIG_ATTRIBUTE, getContextLabelProviderService(), DisplayMode.NORMAL, NattableConfigAttributes.LABEL_PROVIDER_SERVICE_ID);
		// commented because seems generate several bugs with edition
		// newRegistry.registerConfigAttribute( CellConfigAttributes.DISPLAY_CONVERTER, new GenericDisplayConverter(), DisplayMode.NORMAL, GridRegion.BODY);

		// configuration used by filter
		ObjectNameAndPathDisplayConverter converter = new ObjectNameAndPathDisplayConverter(getContextLabelProviderService());
		configRegistry.registerConfigAttribute(NattableConfigAttributes.OBJECT_NAME_AND_PATH_DISPLAY_CONVERTER, converter, DisplayMode.NORMAL, NattableConfigAttributes.OBJECT_NAME_AND_PATH_DISPLAY_CONVERTER_ID);
		configRegistry.registerConfigAttribute(NattableConfigAttributes.OBJECT_NAME_AND_PATH_COMPARATOR, new ObjectNameAndPathComparator(converter), DisplayMode.NORMAL, NattableConfigAttributes.OBJECT_NAME_AND_PATH_COMPARATOR_ID);

		// register the decoration service
		configRegistry.registerConfigAttribute(NattableConfigAttributes.DECORATION_SERVICE_CONFIG_ATTRIBUTE, getDecorationService(), DisplayMode.NORMAL, NattableConfigAttributes.DECORATION_SERVICE_ID);

		this.natTable.setConfigRegistry(configRegistry);
		this.natTable.setUiBindingRegistry(new UiBindingRegistry(this.natTable));
		this.selectionProvider = new TableSelectionProvider(this, this.bodyLayerStack.getSelectionLayer());

		if (site != null) {
			// we are creating an editor
			site.setSelectionProvider(this.selectionProvider);
		}
		registerPopupMenuConfiguration(this.natTable);
		this.natTable.configure();

		// we create editors and filter configuration, we can not add it to a layer, because the configuration must be updated after add/move axis and invert axis
		this.filterConfiguration = new FilterRowAxisConfiguration();
		this.cellAxisConfiguration = new CellEditorAxisConfiguration();
		configureFilters();
		configureCellAxisEditor();


		// initialize the table by checking all its applied styles
		initTableAxis();
		initTableHeaders();
		initTableMerge();

		// Fill the columns size
		doFillColumnsSize();

		addColumnReorderListener(this.bodyLayerStack.getColumnReorderLayer());
		addAxisResizeListener(this.bodyLayerStack);
		addColumnHeaderResizeListener(getColumnHeaderLayerStack());
		addRowHeaderResizeListener(getRowHeaderLayerStack());
		addDragAndDropSupport(this.natTable);

		new PapyrusNatTableToolTipProvider(this.natTable, GridRegion.BODY, GridRegion.COLUMN_HEADER, GridRegion.ROW_HEADER);
		initResourceSetListener();
		return this.natTable;
	}

	/**
	 * Register the menu configuration for the table
	 *
	 * @param natTable
	 *            the nattable to configure
	 * @since 2.0
	 */
	protected void registerPopupMenuConfiguration(final NatTable natTable) {
		natTable.addConfiguration(new TablePopupMenuConfiguration(natTable));
	}

	/**
	 * Configure the row sort selecting column header
	 *
	 * @param natTable
	 *            the nattable widget
	 */
	protected void addClickSortConfiguration(NatTable natTable) {
		natTable.addConfiguration(new TableClickSortConfiguration());
	}

	/**
	 * @return
	 * 		the filter strategy to use
	 */
	protected abstract IFilterStrategy<Object> createFilterStrategy();


	/**
	 * TODO : should be refactored with resourceset used in NattableModelManager
	 */
	private void initResourceSetListener() {
		// resourceSetListener used to capture table style modification
		// these events can be used to undo/redo previous actions
		resourceSetListener = new ResourceSetListener() {

			@Override
			public Command transactionAboutToCommit(ResourceSetChangeEvent event) throws RollbackException {
				return null;
			}

			@Override
			public void resourceSetChanged(ResourceSetChangeEvent event) {

				for (final Notification notification : event.getNotifications()) {
					// filter the events to only let through the changes on the current table resource
					Table notifiedTable = findTable(notification);
					if (getTable().equals(notifiedTable)) {

						Display.getDefault().asyncExec(new Runnable() {

							@Override
							public void run() {

								Object notifier = notification.getNotifier();
								Object feature = notification.getFeature();
								Object newValue = notification.getNewValue();
								Object oldValue = notification.getOldValue();
								if (notifier instanceof LocalTableHeaderAxisConfiguration) {
									boolean onColumnOnModel = getTable().getLocalColumnHeaderAxisConfiguration() == notifier;
									boolean isInverted = table.isInvertAxis();

									if (feature == NattableaxisconfigurationPackage.eINSTANCE.getAbstractHeaderAxisConfiguration_DisplayFilter() && newValue instanceof Boolean) {
										if ((onColumnOnModel && !isInverted) || (!onColumnOnModel && isInverted)) {
											AbstractNattableWidgetManager.this.filterColumnHeaderComposite.setFilterRowVisible(((Boolean) newValue).booleanValue());
											natTable.refresh();
										}
									}
								} else if (notifier instanceof Table && feature == NattablePackage.eINSTANCE.getTable_InvertAxis()) {
									// TODO : replace the listener and its action done in NattableModelManger by this one
									AbstractNattableWidgetManager.this.filterColumnHeaderComposite.setFilterRowVisible(HeaderAxisConfigurationManagementUtils.getColumnAbstractHeaderAxisConfigurationUsedInTable(getTable()).isDisplayFilter());
									natTable.refresh();
								} else if (notifier instanceof IAxis || notifier instanceof StringValueStyle || notifier instanceof StringListValueStyle) {
									boolean refreshFilter = false;
									IAxis axisToRefresh = null;
									if (notifier instanceof IAxis) {
										axisToRefresh = (IAxis) notifier;
										if (oldValue instanceof NamedStyle && IFilterConfiguration.FILTER_VALUE_TO_MATCH.equals(((NamedStyle) oldValue).getName())) {
											// we need to replay the filter
											refreshFilter = true;
										} else if (newValue instanceof NamedStyle && IFilterConfiguration.FILTER_VALUE_TO_MATCH.equals(((NamedStyle) newValue).getName())) {
											refreshFilter = true;
										}
									}
									if ((notifier instanceof StringValueStyle || notifier instanceof StringListValueStyle) && IFilterConfiguration.FILTER_VALUE_TO_MATCH.equals(((NamedStyle) notifier).getName())) {
										EObject container = ((NamedStyle) notifier).eContainer();
										if (container instanceof IAxis) {
											axisToRefresh = (IAxis) container;
											refreshFilter = true;
										}
									}
									if (refreshFilter && axisToRefresh != null) {
										// we need to update the filter map value (manage Undo/Redo for example)
										int index = -1;
										if (table.isInvertAxis() && getRowElementsList().contains(axisToRefresh)) {
											index = getRowElementsList().indexOf(axisToRefresh);
										} else if (!table.isInvertAxis() && getColumnElementsList().contains(axisToRefresh)) {
											index = getColumnElementsList().indexOf(axisToRefresh);
										}
										if (index != -1) {
											filterColumnHeaderComposite.doCommand(new UpdateFilterMapCommand(index));
										}

									}
								}
							}
						});
					}
				}
			}

			@Override
			public boolean isPrecommitOnly() {
				return false;
			}

			@Override
			public boolean isPostcommitOnly() {
				return false;
			}

			@Override
			public boolean isAggregatePrecommitListener() {
				return false;
			}

			@Override
			public NotificationFilter getFilter() {
				// this filter only lets through the notifications pertaining to the table
				// the first three conditions handle the modification, the add and the remove of styles
				// the last seven handle the modified or created objects containing those styles
				return ((NotificationFilter.createEventTypeFilter(Notification.SET))
						.or(NotificationFilter.createEventTypeFilter(Notification.ADD))
						.or(NotificationFilter.createEventTypeFilter(Notification.REMOVE)))
								.and((NotificationFilter.createNotifierTypeFilter(BooleanValueStyle.class))
										.or(NotificationFilter.createNotifierTypeFilter(IntValueStyle.class))
										.or(NotificationFilter.createNotifierTypeFilter(Style.class))
										.or(NotificationFilter.createNotifierTypeFilter(EObjectAxis.class))
										.or(NotificationFilter.createNotifierTypeFilter(FeatureIdAxis.class))
										.or(NotificationFilter.createNotifierTypeFilter(EStructuralFeatureAxis.class))
										.or(NotificationFilter.createNotifierTypeFilter(LocalTableHeaderAxisConfiguration.class))
										.or(NotificationFilter.createNotifierTypeFilter(Table.class)));
				// return NotificationFilter.createNotifierTypeFilter(EObject.class);
			}
		};

		if (this.tableEditingDomain != null) {
			this.tableEditingDomain.addResourceSetListener(resourceSetListener);
		}
	}

	/**
	 *
	 * @param notification
	 * @return
	 * 		The nearest table containing the style in order to verify the table's styled event's source
	 */
	protected static Table findTable(Notification notification) {
		if (notification.getNotifier() instanceof Table) {
			return (Table) notification.getNotifier();
		} else {
			Object notifier = notification.getNotifier();
			if (notifier instanceof EObject) {
				EObject container = ((EObject) notifier).eContainer();
				while (!(container instanceof Table) && container != null) {
					container = container.eContainer();
				}
				return (Table) container;
			}
			return null;
		}
	}

	/**
	 *
	 * @param bodyLayerStack
	 *            the body layer stack to use
	 *
	 * @return
	 * 		the row header layer stack to use
	 */
	protected RowHeaderLayerStack createRowHeaderLayerStack(BodyLayerStack bodyLayerStack) {
		return new RowHeaderLayerStack(bodyLayerStack, this);
	}

	/**
	 * configure the cell editor used in the table
	 */
	protected final void configureCellAxisEditor() {
		this.cellAxisConfiguration.configureRegistry(this.natTable.getConfigRegistry());
	}

	/**
	 * configure the filters
	 */
	protected final void configureFilters() {
		this.filterConfiguration.configureRegistry(this.natTable.getConfigRegistry());
	}

	/**
	 *
	 * @return
	 * 		the label provider service
	 */
	private LabelProviderService getContextLabelProviderService() {
		try {
			ServicesRegistry serviceRegistry = ServiceUtilsForEObject.getInstance().getServiceRegistry(this.table.getContext());// get context and NOT get table for the usecase where the table is not in a resource
			return serviceRegistry.getService(LabelProviderService.class);
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
		return null;
	}

	/**
	 *
	 * @return
	 * 		the decoration service
	 */
	protected DecorationService getDecorationService() {
		// Bug 490067: We need to check if the resource of the context is existing before to get the decoration service (to avoid useless log exception)
		// The resource of the context is not existing in the case of deletion (EObject was already deleted but the reference of table always exists)
		if (null != this.table.getContext().eResource()) {
			try {
				ServicesRegistry serviceRegistry = ServiceUtilsForEObject.getInstance().getServiceRegistry(this.table.getContext());// get context and NOT get table for the usecase where the table is not in a resource
				return serviceRegistry.getService(DecorationService.class);
			} catch (ServiceException e) {
				Activator.log.error(e);
			}
		}
		return null;
	}

	/**
	 *
	 * @param natTable
	 * @return
	 *
	 * @deprecated since Papyrus 1.2 (Eclipse Neon), now the menu configuration is done using {@link TablePopupMenuConfiguration}
	 */
	@Deprecated
	public MenuManager createMenuManager(final NatTable natTable) {
		return createAndRegisterMenuManagerAndSelectionProvider(natTable, null, this.selectionProvider);
	}

	/**
	 *
	 * @param natTable
	 * @param site
	 * @param selectionProvider
	 *
	 * @return
	 * 		This method creates the MenuManager used for theBody of the table and register it, with the selection provider in the {@link IWorkbenchPartSite} of the editor when not <code>null</code>
	 * @since 2.0
	 */
	public MenuManager createAndRegisterMenuManagerAndSelectionProvider(final NatTable natTable, final IWorkbenchPartSite site, ISelectionProvider selectionProvider) {
		final MenuManager menuManager = new MenuManager("#PopUp", "org.eclipse.papyrus.infra.nattable.widget.menu"); //$NON-NLS-1$ //$NON-NLS-2$
		menuManager.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		menuManager.setRemoveAllWhenShown(true);
		return menuManager;
	}

	/**
	 * Enable the table to receive dropped elements
	 *
	 * @param nattable
	 *            the nattable widget in which we add the drag&drop support
	 */
	protected void addDragAndDropSupport(final NatTable nattable) {
		final int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT;
		final DropTarget target = new DropTarget(nattable, operations);
		final LocalTransfer localTransfer = LocalTransfer.getInstance();
		final LocalSelectionTransfer localSelectionTransfer = LocalSelectionTransfer.getTransfer();
		final Transfer[] types = new Transfer[] { localSelectionTransfer, localTransfer };
		target.setTransfer(types);
		final NatTableDropListener dropListener = createDropListener();
		target.addDropListener(dropListener);
	}

	protected NatTableDropListener createDropListener() {
		return new NatTableDropListener(this, this.selectionExtractor);
	}

	/**
	 * Add a listener on the column reorder layer in order to update the model
	 *
	 * @param columnReorderLayer
	 *            the column reorder layer
	 */
	private void addColumnReorderListener(final ColumnReorderLayer columnReorderLayer) {
		columnReorderLayer.addLayerListener(new ILayerListener() {


			@Override
			public void handleLayerEvent(final ILayerEvent event) {
				if (event instanceof ColumnReorderEvent) {
					ColumnReorderEvent columnReorderEvent = (ColumnReorderEvent) event;
					int start = -1;
					int end = columnReorderEvent.getBeforeToColumnPosition();
					for (Range range : columnReorderEvent.getBeforeFromColumnPositionRanges()) {
						start = range.start;
						break;
					}

					if (start != -1) {
						final List<IAxis> allAxis = AbstractNattableWidgetManager.this.getColumnAxisManager().getRepresentedContentProvider().getAxis();

						// This solve an index difference between moving
						// a column from right to left and moving a
						// column from left to right
						if (start >= 0 && start < end && columnReorderEvent.isReorderToLeftEdge()) {
							end--;
						}

						final IAxis axisToMove = allAxis.get(start);
						if (axisToMove != null) {
							moveColumnElement(axisToMove, end);
						}
					}
				}
			}
		});
	}

	/**
	 * Add a listener on the body itself in order to update the model
	 *
	 * @param bodyLayerStack
	 *            the table's body layer
	 */
	private void addAxisResizeListener(final BodyLayerStack bodyLayerStack) {
		resizeAxisListener = new ILayerListener() {

			@Override
			public void handleLayerEvent(ILayerEvent event) {
				// both events are considered as a body change and therefore we need to check each possibility
				if (event instanceof ColumnResizeEvent || event instanceof RowResizeEvent) {
					final CompositeCommand resizeCommand = new CompositeCommand("resize IAxis' width or height"); //$NON-NLS-1$
					TransactionalEditingDomain tableDomain = TableEditingDomainUtils.getTableEditingDomain(table);
					if (tableDomain == null) {
						return;
					}

					if (event instanceof ColumnResizeEvent) {
						// get the index of the first column modified by the user
						// the assumption is that the user changes only one column at a time in order to resize to its liking
						int resizedColumnPosition = getRangeStart(event);
						// get the resized value from this column
						int newColumnSize = columnHeaderLayerStack.getColumnWidthByPosition(resizedColumnPosition);
						ICommand cmd = createSetColumnSizeCommand(resizedColumnPosition, newColumnSize);
						if (cmd != null && cmd.canExecute()) {
							resizeCommand.add(cmd);
						}

					}

					// the process is the same for this event
					else if (event instanceof RowResizeEvent) {
						int resizedRowPosition = getRangeStart(event);
						int newRowSize = rowHeaderLayerStack.getRowHeightByPosition(resizedRowPosition);
						ICommand cmd = createSetRowSizeCommand(resizedRowPosition, newRowSize);
						if (cmd != null && cmd.canExecute()) {
							resizeCommand.add(cmd);
						}

					}
					if (!resizeCommand.isEmpty()) {
						tableDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(resizeCommand));
					}

				}
			}
		};

		bodyLayerStack.addLayerListener(resizeAxisListener);

	}

	/**
	 * Create the set column size command for the column resizing.
	 * 
	 * @param columnIndex
	 *            the column where we edit the width.
	 * @param newColumnWidth
	 *            the new width for the given column.
	 * @return
	 * 		the command to set the new column width when the column is saved as IAxis and <code>null</code> in others cases
	 * 
	 * @since 2.0
	 */
	private ICommand createSetColumnSizeCommand(final int resizedColumnPosition, final int newColumnWidth) {
		final CompositeCommand compositeResizeCommand = new CompositeCommand("Resize Column"); //$NON-NLS-1$

		// get the associated object
		Object currentColumnObject = getColumnElement(resizedColumnPosition); // INattableModelManager -> ITableAxisElementProvider.getColumnElement
		if (currentColumnObject instanceof IAxis) {
			// the object is now the Axis in which the style will be applied
			IAxis currentColumnIAxis = (IAxis) currentColumnObject;
			if (currentColumnIAxis.eContainer() != null) {
				IntValueStyle value = (IntValueStyle) currentColumnIAxis.getNamedStyle(NattablestylePackage.eINSTANCE.getIntValueStyle(), NamedStyleConstants.AXIS_WIDTH);
				if (value != null && value.getIntValue() != newColumnWidth) {
					// Constructs a new request to set the value of a structural feature in a model element
					SetRequest resizeColumnRequest = new SetRequest(getTableEditingDomain(), value, NattablestylePackage.eINSTANCE.getIntValueStyle_IntValue(), newColumnWidth);
					// initialize the feature value if none before and replace the value if another existed prior to the resize
					compositeResizeCommand.add(new SetValueCommand(resizeColumnRequest));

				} else if (value == null && newColumnWidth != DefaultSizeUtils.getDefaultCellWidth()) {
					// the element does not have any predefined width value attached to its resource so we create it
					value = NattablestyleFactory.eINSTANCE.createIntValueStyle();
					value.setIntValue(newColumnWidth);
					value.setName(NamedStyleConstants.AXIS_WIDTH);
					SetRequest initColumnSizeRequest = new SetRequest(getTableEditingDomain(), currentColumnIAxis, NattablestylePackage.eINSTANCE.getStyledElement_Styles(), value);
					compositeResizeCommand.add(new SetValueCommand(initColumnSizeRequest));
				}
			}
		}
		
		if(!compositeResizeCommand.isEmpty()){
			// If the named style 'fillColumnSize' is used, this must be set to false to avoid re-fill
			BooleanValueStyle fillColumnsSize = (BooleanValueStyle) getTable().getNamedStyle(NattablestylePackage.eINSTANCE.getBooleanValueStyle(), NamedStyleConstants.FILL_COLUMNS_SIZE);
			if (fillColumnsSize == null) {
				final TableConfiguration config = getTable().getTableConfiguration();
				fillColumnsSize = (BooleanValueStyle) config.getNamedStyle(NattablestylePackage.eINSTANCE.getBooleanValueStyle(), NamedStyleConstants.FILL_COLUMNS_SIZE);
			}

			if (null != fillColumnsSize && fillColumnsSize.isBooleanValue()) {
				SetRequest fillColumnSizeRequest = new SetRequest(getTableEditingDomain(), fillColumnsSize, NattablestylePackage.eINSTANCE.getBooleanValueStyle_BooleanValue(), false);
				compositeResizeCommand.add(new SetValueCommand(fillColumnSizeRequest));
			}
		}

		return compositeResizeCommand;
	}

	/**
	 * Create the set row size command for the row resizing.
	 * 
	 * @param columnIndex
	 *            the row where we edit the height.
	 * @param newRowHeight
	 *            the new height for the given row.
	 * @return
	 * 		the command to set the new row height when the row is saved as IAxis and <code>null</code> in others cases
	 * 
	 * @since 2.0
	 */
	private ICommand createSetRowSizeCommand(final int resizedRowPosition, final int newRowHeight) {
		ICommand resizeCommand = null;

		Object currentRowObject = getRowElement(resizedRowPosition);
		if (currentRowObject instanceof IAxis) {
			IAxis currentRowIAxis = (IAxis) currentRowObject;
			if (currentRowIAxis.eContainer() != null) {
				IntValueStyle value = (IntValueStyle) currentRowIAxis.getNamedStyle(NattablestylePackage.eINSTANCE.getIntValueStyle(), NamedStyleConstants.AXIS_HEIGHT);
				if (value != null && value.getIntValue() != newRowHeight) {
					SetRequest resizeRowRequest = new SetRequest(getTableEditingDomain(), value, NattablestylePackage.eINSTANCE.getIntValueStyle_IntValue(), newRowHeight);
					resizeCommand = new SetValueCommand(resizeRowRequest);

				} else if (value == null && newRowHeight != DefaultSizeUtils.getDefaultCellHeight()) {
					value = NattablestyleFactory.eINSTANCE.createIntValueStyle();
					value.setIntValue(newRowHeight);
					value.setName(NamedStyleConstants.AXIS_HEIGHT);
					SetRequest initRowSizeRequest = new SetRequest(getTableEditingDomain(), currentRowIAxis, NattablestylePackage.eINSTANCE.getStyledElement_Styles(), value);
					resizeCommand = new SetValueCommand(initRowSizeRequest);

				}
			}
		}

		return resizeCommand;
	}

	/**
	 * This method is used to get the position of the row or column being modified
	 *
	 * @param event
	 * @return
	 */
	private int getRangeStart(ILayerEvent event) {
		int start = -1;
		if (event instanceof ColumnResizeEvent) {
			ColumnResizeEvent resizeEvent = (ColumnResizeEvent) event;
			// only one element is handled at a time so the start value won't be overwritten
			for (Range current : resizeEvent.getColumnPositionRanges()) {
				start = current.start;
			}
		}
		if (event instanceof RowResizeEvent) {
			RowResizeEvent resizeEvent = (RowResizeEvent) event;
			for (Range current : resizeEvent.getRowPositionRanges()) {
				start = current.start;
			}
		}
		return start;
	}


	/**
	 * Add a listener to the column's header layer in order to update the model
	 *
	 * @param columnHeaderLayerStack
	 */
	private void addColumnHeaderResizeListener(final ColumnHeaderLayerStack columnHeaderLayerStack) {
		resizeColumnHeaderListener = new ILayerListener() {

			@Override
			public void handleLayerEvent(ILayerEvent event) {
				if (event instanceof RowResizeEvent) {
					// get the new values from the index and label headers
					int newHeaderIndexHeight = columnHeaderLayerStack.getColumnIndexDataLayer().getRowHeightByPosition(0);
					int newHeaderLabelHeight = columnHeaderLayerStack.getColumnLabelDataLayer().getRowHeightByPosition(0);
					// get the position of the header being modified
					int resizedHeaderPosition = getRangeStart(event);

					// verify that the event is handled properly
					if (resizedHeaderPosition != -1) {
						final CompositeCommand resizeColumnHeaderCommand = new CompositeCommand("resize ColumnHeader's height"); //$NON-NLS-1$
						TransactionalEditingDomain tableDomain = TableEditingDomainUtils.getTableEditingDomain(table);
						// create a blank variable as its contents can change if the table is inverted or not
						LocalTableHeaderAxisConfiguration localColumnHeaderAxis = null;

						if (!getTable().isInvertAxis()) {
							if (getTable().getLocalColumnHeaderAxisConfiguration() != null) {
								localColumnHeaderAxis = getTable().getLocalColumnHeaderAxisConfiguration();
							} else if (newHeaderIndexHeight != DefaultSizeUtils.getDefaultCellHeight() || newHeaderLabelHeight != DefaultSizeUtils.getDefaultCellHeight()) {
								TableHeaderAxisConfiguration columnHeaderAxis;
								// create the blank feature that will host the new local header
								EStructuralFeature localHeaderFeature = null;
								columnHeaderAxis = getTable().getTableConfiguration().getColumnHeaderAxisConfiguration();
								localColumnHeaderAxis = HeaderAxisConfigurationManagementUtils.transformToLocalHeaderConfiguration(columnHeaderAxis);
								localHeaderFeature = NattablePackage.eINSTANCE.getTable_LocalColumnHeaderAxisConfiguration();

								// commands used to modify the notation file and create the new local header
								IEditCommandRequest initLocalColumnHeaderAxis = new SetRequest(tableDomain, table, localHeaderFeature, localColumnHeaderAxis);
								IElementEditService localColumnHeaderAxisProvider = ElementEditServiceUtils.getCommandProvider(table);
								resizeColumnHeaderCommand.add(localColumnHeaderAxisProvider.getEditCommand(initLocalColumnHeaderAxis));
							}

						} else {
							if (getTable().getLocalRowHeaderAxisConfiguration() != null) {
								// as the axis are inverted the row headers are now the column headers
								localColumnHeaderAxis = getTable().getLocalRowHeaderAxisConfiguration();
							} else if (newHeaderIndexHeight != DefaultSizeUtils.getDefaultCellHeight() || newHeaderLabelHeight != DefaultSizeUtils.getDefaultCellHeight()) {
								// the behavior is now the same as usual
								TableHeaderAxisConfiguration columnHeaderAxis;
								EStructuralFeature localHeaderFeature = null;
								columnHeaderAxis = getTable().getTableConfiguration().getRowHeaderAxisConfiguration();
								localColumnHeaderAxis = HeaderAxisConfigurationManagementUtils.transformToLocalHeaderConfiguration(columnHeaderAxis);
								localHeaderFeature = NattablePackage.eINSTANCE.getTable_LocalRowHeaderAxisConfiguration();

								IEditCommandRequest initLocalColumnHeaderAxis = new SetRequest(tableDomain, table, localHeaderFeature, localColumnHeaderAxis);
								IElementEditService localColumnHeaderAxisProvider = ElementEditServiceUtils.getCommandProvider(table);
								resizeColumnHeaderCommand.add(localColumnHeaderAxisProvider.getEditCommand(initLocalColumnHeaderAxis));
							}

						}

						// If this index is not display, increment the resized header position to corresponding to the label
						if (null != localColumnHeaderAxis && !localColumnHeaderAxis.isDisplayIndex()) {
							resizedHeaderPosition++;
						}


						// manipulate the index layer and as the variables are now fixed this part is common to both the inverted and not inverted case
						if (resizedHeaderPosition == 0 && localColumnHeaderAxis != null) {
							IntValueStyle valueIndex = (IntValueStyle) localColumnHeaderAxis.getNamedStyle(NattablestylePackage.eINSTANCE.getIntValueStyle(), NamedStyleConstants.COLUMN_INDEX_HEIGHT);
							if (valueIndex != null && valueIndex.getIntValue() != newHeaderIndexHeight) {
								// the variable to be edited already exists
								SetRequest resizeRowHeaderIndex = new SetRequest(tableDomain, valueIndex, NattablestylePackage.eINSTANCE.getIntValueStyle_IntValue(), newHeaderIndexHeight);
								SetValueCommand resizeColumnHeaderIndexCommand = new SetValueCommand(resizeRowHeaderIndex);
								resizeColumnHeaderCommand.add(resizeColumnHeaderIndexCommand);
							} else if (valueIndex == null && newHeaderIndexHeight != DefaultSizeUtils.getDefaultCellHeight()) {
								// if the variable does not exist, it is created
								valueIndex = NattablestyleFactory.eINSTANCE.createIntValueStyle();
								valueIndex.setIntValue(newHeaderIndexHeight);
								valueIndex.setName(NamedStyleConstants.COLUMN_INDEX_HEIGHT);

								SetRequest initRowHeaderIndexSizeRequest = new SetRequest(tableDomain, localColumnHeaderAxis, NattablestylePackage.eINSTANCE.getStyledElement_Styles(), valueIndex);
								SetValueCommand resizeColumnHeaderIndexCommand = new SetValueCommand(initRowHeaderIndexSizeRequest);
								resizeColumnHeaderCommand.add(resizeColumnHeaderIndexCommand);
							}
						}

						// manipulate the label layer and as the variables are now fixed this part is common to both the inverted and not inverted case
						if (resizedHeaderPosition == 1 && localColumnHeaderAxis != null) {
							IntValueStyle valueLabel = (IntValueStyle) localColumnHeaderAxis.getNamedStyle(NattablestylePackage.eINSTANCE.getIntValueStyle(), NamedStyleConstants.COLUMN_LABEL_HEIGHT);
							if (valueLabel != null && valueLabel.getIntValue() != newHeaderLabelHeight) {
								// the variable to be edited already exists
								SetRequest resizeRowHeaderLabel = new SetRequest(tableDomain, valueLabel, NattablestylePackage.eINSTANCE.getIntValueStyle_IntValue(), newHeaderLabelHeight);
								SetValueCommand resizeRowHeaderLabelCommand = new SetValueCommand(resizeRowHeaderLabel);
								resizeColumnHeaderCommand.add(resizeRowHeaderLabelCommand);
							} else if (valueLabel == null && newHeaderLabelHeight != DefaultSizeUtils.getDefaultCellHeight()) {
								// if the variable does not exist, it is created
								valueLabel = NattablestyleFactory.eINSTANCE.createIntValueStyle();
								valueLabel.setIntValue(newHeaderLabelHeight);
								valueLabel.setName(NamedStyleConstants.COLUMN_LABEL_HEIGHT);

								SetRequest initRowHeaderLabelSizeRequest = new SetRequest(tableDomain, localColumnHeaderAxis, NattablestylePackage.eINSTANCE.getStyledElement_Styles(), valueLabel);
								SetValueCommand resizeRowHeaderLabelCommand = new SetValueCommand(initRowHeaderLabelSizeRequest);
								resizeColumnHeaderCommand.add(resizeRowHeaderLabelCommand);
							}
						}

						// all the commands are executed and the variables and their local headers are created or updated
						if (resizeColumnHeaderCommand.canExecute() && !resizeColumnHeaderCommand.isEmpty()) {

							tableDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(resizeColumnHeaderCommand));
						}
					}
				}
			}
		};

		columnHeaderLayerStack.addLayerListener(resizeColumnHeaderListener);

	}


	/**
	 * Add a listener to the row's header layer in order to update the model
	 *
	 * @param rowHeaderLayerStack
	 */
	private void addRowHeaderResizeListener(final RowHeaderLayerStack rowHeaderLayerStack) {
		resizeRowHeaderListener = new ILayerListener() {

			// the behavior of this method is exactly the same as the one before
			@Override
			public void handleLayerEvent(ILayerEvent event) {
				if (event instanceof ColumnResizeEvent) {

					// Get the event position
					int resizedHeaderPosition = getRangeStart(event);

					boolean isLocalRowHeaderAxisCreation = false;

					if (resizedHeaderPosition != -1) {
						final CompositeCommand resizeRowHeaderCommand = new CompositeCommand("resize RowHeader's width"); //$NON-NLS-1$
						TransactionalEditingDomain tableDomain = TableEditingDomainUtils.getTableEditingDomain(table);
						if (tableDomain == null) {
							return;
						}
						LocalTableHeaderAxisConfiguration localRowHeaderAxis = null;

						// Get or create the local row header axis configuration
						if (!getTable().isInvertAxis()) {
							if (getTable().getLocalRowHeaderAxisConfiguration() != null) {
								localRowHeaderAxis = getTable().getLocalRowHeaderAxisConfiguration();
							} else {
								TableHeaderAxisConfiguration rowHeaderAxis;
								EStructuralFeature localHeaderFeature = null;
								rowHeaderAxis = getTable().getTableConfiguration().getRowHeaderAxisConfiguration();
								localRowHeaderAxis = HeaderAxisConfigurationManagementUtils.transformToLocalHeaderConfiguration(rowHeaderAxis);
								localHeaderFeature = NattablePackage.eINSTANCE.getTable_LocalRowHeaderAxisConfiguration();

								IEditCommandRequest initLocalRowHeaderAxis = new SetRequest(tableDomain, table, localHeaderFeature, localRowHeaderAxis);
								IElementEditService localRowHeaderAxisProvider = ElementEditServiceUtils.getCommandProvider(table);
								resizeRowHeaderCommand.add(localRowHeaderAxisProvider.getEditCommand(initLocalRowHeaderAxis));
								isLocalRowHeaderAxisCreation = true;
							}

						} else {
							if (getTable().getLocalColumnHeaderAxisConfiguration() != null) {
								localRowHeaderAxis = getTable().getLocalColumnHeaderAxisConfiguration();
							} else {
								TableHeaderAxisConfiguration rowHeaderAxis;
								EStructuralFeature localHeaderFeature = null;
								rowHeaderAxis = getTable().getTableConfiguration().getColumnHeaderAxisConfiguration();
								localRowHeaderAxis = HeaderAxisConfigurationManagementUtils.transformToLocalHeaderConfiguration(rowHeaderAxis);
								localHeaderFeature = NattablePackage.eINSTANCE.getTable_LocalColumnHeaderAxisConfiguration();

								IEditCommandRequest initLocalRowHeaderAxis = new SetRequest(tableDomain, table, localHeaderFeature, localRowHeaderAxis);
								IElementEditService localRowHeaderAxisProvider = ElementEditServiceUtils.getCommandProvider(table);
								resizeRowHeaderCommand.add(localRowHeaderAxisProvider.getEditCommand(initLocalRowHeaderAxis));
								isLocalRowHeaderAxisCreation = true;
							}

						}

						if (null != localRowHeaderAxis) {
							// If this index is not display, increment the resized header position to corresponding to the label
							if (!localRowHeaderAxis.isDisplayIndex()) {
								resizedHeaderPosition++;
							}

							if (0 < resizedHeaderPosition && rowHeaderLayerStack instanceof RowHeaderHierarchicalLayerStack) {
								// Decrement because the index is not managed in the label layer
								resizedHeaderPosition--;
								resizedHeaderPosition = ((RowHeaderHierarchicalLayerStack) rowHeaderLayerStack).getRowHeaderLayerLabel().getColumnIndexByPosition(resizedHeaderPosition);
								// Increment because the index is not managed in the label layer
								resizedHeaderPosition++;
							}

							// Resize the index if the position is 0
							if (0 == resizedHeaderPosition && localRowHeaderAxis != null) {
								// Calculate the width of the index column
								int newHeaderIndexWidth = rowHeaderLayerStack.getRowIndexDataLayer().getColumnWidthByPosition(0);
								IntValueStyle valueIndex = (IntValueStyle) localRowHeaderAxis.getNamedStyle(NattablestylePackage.eINSTANCE.getIntValueStyle(), NamedStyleConstants.ROW_INDEX_WIDTH);
								if (valueIndex != null && valueIndex.getIntValue() != newHeaderIndexWidth) {
									SetRequest resizeRowHeaderIndex = new SetRequest(tableDomain, valueIndex, NattablestylePackage.eINSTANCE.getIntValueStyle_IntValue(), newHeaderIndexWidth);
									SetValueCommand resizeRowHeaderIndexCommand = new SetValueCommand(resizeRowHeaderIndex);
									resizeRowHeaderCommand.add(resizeRowHeaderIndexCommand);
								} else if (valueIndex == null && newHeaderIndexWidth != DefaultSizeUtils.getDefaultRowHeaderWidth()) {
									valueIndex = NattablestyleFactory.eINSTANCE.createIntValueStyle();
									valueIndex.setIntValue(newHeaderIndexWidth);
									valueIndex.setName(NamedStyleConstants.ROW_INDEX_WIDTH);

									SetRequest initRowHeaderIndexSizeRequest = new SetRequest(tableDomain, localRowHeaderAxis, NattablestylePackage.eINSTANCE.getStyledElement_Styles(), valueIndex);
									SetValueCommand resizeRowHeaderIndexCommand = new SetValueCommand(initRowHeaderIndexSizeRequest);
									resizeRowHeaderCommand.add(resizeRowHeaderIndexCommand);
								}
							}

							// This is a resize of row header label
							if (1 <= resizedHeaderPosition && null != localRowHeaderAxis) {
								// Calculate the width of the label column (depending to its position)
								int newHeaderLabelWidth = rowHeaderLayerStack.getRowLabelDataLayer().getColumnWidthByPosition(resizedHeaderPosition - 1);
								if (1 == resizedHeaderPosition) {
									IntValueStyle valueLabel = (IntValueStyle) localRowHeaderAxis.getNamedStyle(NattablestylePackage.eINSTANCE.getIntValueStyle(), NamedStyleConstants.ROW_LABEL_WIDTH);
									if (valueLabel != null && valueLabel.getIntValue() != newHeaderLabelWidth) {
										SetRequest resizeRowHeaderLabel = new SetRequest(tableDomain, valueLabel, NattablestylePackage.eINSTANCE.getIntValueStyle_IntValue(), newHeaderLabelWidth);
										SetValueCommand resizeRowHeaderLabelCommand = new SetValueCommand(resizeRowHeaderLabel);
										resizeRowHeaderCommand.add(resizeRowHeaderLabelCommand);
									} else if (valueLabel == null && newHeaderLabelWidth != DefaultSizeUtils.getDefaultRowHeaderWidth()) {
										valueLabel = NattablestyleFactory.eINSTANCE.createIntValueStyle();
										valueLabel.setIntValue(newHeaderLabelWidth);
										valueLabel.setName(NamedStyleConstants.ROW_LABEL_WIDTH);

										SetRequest initRowHeaderLabelSizeRequest = new SetRequest(tableDomain, localRowHeaderAxis, NattablestylePackage.eINSTANCE.getStyledElement_Styles(), valueLabel);
										SetValueCommand resizeRowHeaderLabelCommand = new SetValueCommand(initRowHeaderLabelSizeRequest);
										resizeRowHeaderCommand.add(resizeRowHeaderLabelCommand);
									}
								} else {
									final StringBuilder nameStyle = new StringBuilder(NamedStyleConstants.ROW_LABEL_POSITION_PREFIX_WIDTH);
									nameStyle.append(resizedHeaderPosition);
									nameStyle.append(NamedStyleConstants.ROW_LABEL_POSITION_SUFFIX_WIDTH);

									IntValueStyle valueLabel = (IntValueStyle) localRowHeaderAxis.getNamedStyle(NattablestylePackage.eINSTANCE.getIntValueStyle(), nameStyle.toString());
									if (valueLabel != null && valueLabel.getIntValue() != newHeaderLabelWidth) {
										SetRequest resizeRowHeaderLabel = new SetRequest(tableDomain, valueLabel, NattablestylePackage.eINSTANCE.getIntValueStyle_IntValue(), newHeaderLabelWidth);
										SetValueCommand resizeRowHeaderLabelCommand = new SetValueCommand(resizeRowHeaderLabel);
										resizeRowHeaderCommand.add(resizeRowHeaderLabelCommand);
									} else if (valueLabel == null && newHeaderLabelWidth != DefaultSizeUtils.getDefaultRowHeaderWidth()) {
										valueLabel = NattablestyleFactory.eINSTANCE.createIntValueStyle();
										valueLabel.setIntValue(newHeaderLabelWidth);
										valueLabel.setName(nameStyle.toString());

										SetRequest initRowHeaderLabelSizeRequest = new SetRequest(tableDomain, localRowHeaderAxis, NattablestylePackage.eINSTANCE.getStyledElement_Styles(), valueLabel);
										SetValueCommand resizeRowHeaderLabelCommand = new SetValueCommand(initRowHeaderLabelSizeRequest);
										resizeRowHeaderCommand.add(resizeRowHeaderLabelCommand);
									}
								}
							}


							if (resizeRowHeaderCommand.canExecute() && !resizeRowHeaderCommand.isEmpty()
							// If the local row header axis is created, check that this is not the single command to execute
							// because we need to manage the named style with this command
									&& ((!isLocalRowHeaderAxisCreation) || (isLocalRowHeaderAxisCreation && 1 < resizeRowHeaderCommand.size()))) {
								tableDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(resizeRowHeaderCommand));
							}
						}
					}
				}
			}
		};

		rowHeaderLayerStack.addLayerListener(resizeRowHeaderListener);

	}

	/**
	 *
	 * @param event
	 *            an event
	 * @return
	 * 		a LocationValue for the point, which contains informations about this location (TableGridRegion, row and column index, row and column
	 *         elements, the cell, the point and its translation).
	 *         Some of these values can be <code>null</code> or not depending of the region of the table
	 */
	@Override
	public LocationValue getLocationInTheTable(final Point absolutePoint) {
		final Point widgetPoint = this.natTable.toControl(absolutePoint.x, absolutePoint.y);
		TableGridRegion kind = TableGridRegion.UNKNOWN;
		int columnPosition = this.natTable.getColumnPositionByX(widgetPoint.x);
		int columnIndex = this.natTable.getColumnIndexByPosition(columnPosition);
		int rowPosition = this.natTable.getRowPositionByY(widgetPoint.y);
		int rowIndex = this.natTable.getRowIndexByPosition(rowPosition);
		final ILayerCell cell = this.natTable.getCellByPosition(columnPosition, rowPosition);
		Object columnObject = null;
		Object rowObject = null;
		if (rowIndex == -1 && columnIndex == -1) {
			kind = TableGridRegion.UNKNOWN;
		} else if (rowIndex == -1) {
			kind = TableGridRegion.AFTER_ROW_HEADER;
		} else if (columnIndex == -1) {
			kind = TableGridRegion.AFTER_COLUMN_HEADER;
		} else {
			if (cell != null) {
				LabelStack label = cell.getConfigLabels();
				if (label.hasLabel(GridRegion.ROW_HEADER)) {
					kind = TableGridRegion.ROW_HEADER;

				} else if (label.hasLabel(GridRegion.COLUMN_HEADER)) {
					kind = TableGridRegion.COLUMN_HEADER;

				} else if (label.hasLabel(GridRegion.CORNER)) {
					kind = TableGridRegion.CORNER;
				} else if (label.hasLabel(GridRegion.BODY)) {
					kind = TableGridRegion.CELL;
					columnObject = getColumnElement(columnIndex);
					rowObject = getRowElement(rowIndex);
				}
			}
		}
		return new LocationValue(absolutePoint, widgetPoint, kind, cell, columnIndex, rowIndex, columnObject, rowObject);
	}


	public GridLayer getGridLayer() {
		return this.gridLayer;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#print()
	 *
	 */
	@Override
	public void print() {
		this.natTable.doCommand(new TurnViewportOffCommand());
		this.natTable.doCommand(new PrintCommand(this.natTable.getConfigRegistry(), this.natTable.getShell()));
		this.natTable.doCommand(new TurnViewportOnCommand());
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#selectAll()
	 *
	 */
	@Override
	public void selectAll() {
		this.natTable.doCommand(new SelectAllCommand());
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#exportToXLS()
	 *
	 */
	@Override
	public void exportToXLS() {
		this.natTable.doCommand(new ExportCommand(this.natTable.getConfigRegistry(), this.natTable.getShell()));
	}

	public void copyToClipboard() {
		this.natTable.doCommand(new CopyDataToClipboardCommand("\t", System.getProperty("line.separator"), this.natTable.getConfigRegistry())); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager#getBodyLayerStack()
	 *
	 * @return
	 */
	@Override
	public BodyLayerStack getBodyLayerStack() {
		return this.bodyLayerStack;
	}

	@Override
	public void dispose() {
		if (this.bodyDataProvider != null) {
			this.bodyLayerStack.removeLayerListener(resizeAxisListener);
			this.bodyLayerStack.dispose();
			this.bodyLayerStack = null;
			this.bodyDataProvider.dispose();
			this.bodyDataProvider = null;
		}
		if (this.rowHeaderDataProvider != null) {
			this.rowHeaderLayerStack.removeLayerListener(resizeRowHeaderListener);
			this.rowHeaderLayerStack.dispose();
			this.rowHeaderLayerStack = null;
			this.rowHeaderDataProvider.dispose();
			this.rowHeaderDataProvider = null;
		}
		if (this.columnHeaderDataProvider != null) {
			this.columnHeaderLayerStack.removeLayerListener(resizeColumnHeaderListener);
			this.columnHeaderLayerStack.dispose();
			this.columnHeaderLayerStack = null;
			this.columnHeaderDataProvider.dispose();
			this.columnHeaderDataProvider = null;
		}

		if (this.tableEditingDomain != null && this.resourceSetListener != null) {
			this.tableEditingDomain.removeResourceSetListener(this.resourceSetListener);
			this.tableEditingDomain = null;
		}
		if (this.filterStrategy instanceof IDisposable) {
			((IDisposable) this.filterStrategy).dispose();
		}
		this.cellAxisConfiguration = null;
		this.filterConfiguration = null;
		this.tableEditingDomain = null;
		this.contextEditingDomain = null;
		this.tableContext = null;
		if (this.natTable != null) {
			this.natTable.dispose();
		}
	}

	public EObject getTableContext() {
		return this.tableContext;
	}

	@Override
	public Table getTable() {
		return this.table;
	}

	protected abstract IPapyrusSortModel getRowSortModel();

	/**
	 *
	 * Handles the selections from the model explorer to the table when the link is activated
	 *
	 * @see org.eclipse.papyrus.infra.nattable.utils.AxisUtils
	 * @see org.eclipse.nebula.widgets.nattable.selection.SelectionLayer
	 *
	 * @param elementList
	 */
	@Override
	public boolean revealElement(Object element) {

		return revealElement(Collections.singleton(element));
	}

	@Override
	public boolean revealElement(Collection<?> elements) {

		boolean selectObject = false;
		SelectionLayer selectionLayer = bodyLayerStack.getSelectionLayer();
		List<Object> rowObjects = getRowElementsList();
		List<Object> columnObjects = getColumnElementsList();

		// clear the selectionLayer to avoid the previous selections to mess with the current
		selectionLayer.clear();

		for (int rowIndex = 0; rowIndex < rowObjects.size(); rowIndex++) {
			List<Object> toFind = new ArrayList<Object>(elements);
			for (Object object : elements) {
				Object realObject = AxisUtils.getRepresentedElement(object);
				if (!realObject.equals(object)) { // getRepresentedElement can return the axis itself
					toFind.add(realObject);
				}
			}

			Object currentAxisObject = rowObjects.get(rowIndex);
			Object currentRealObject = AxisUtils.getRepresentedElement(currentAxisObject);
			if (toFind.contains(currentRealObject)) {
				selectionLayer.doCommand(new SelectRowsCommand(selectionLayer, 0, rowIndex, false, true));
				// we remove the found object from the cloned elementList as they are already selected
				toFind.remove(currentRealObject);
				selectObject = true;
			}
			if (toFind.isEmpty()) {
				// all objects are selected
				return selectObject;
			}
		}

		for (int columnIndex = 0; columnIndex < columnObjects.size(); columnIndex++) {
			List<Object> toFind = new ArrayList<Object>(elements);
			for (Object object : elements) {
				Object realObject = AxisUtils.getRepresentedElement(object);
				if (!realObject.equals(object)) { // getRepresentedElement can return the axis itself
					toFind.add(realObject);
				}
			}

			Object currentAxisObject = columnObjects.get(columnIndex);
			Object currentRealObject = AxisUtils.getRepresentedElement(currentAxisObject);
			if (toFind.contains(currentRealObject)) {
				selectionLayer.doCommand(new SelectColumnCommand(selectionLayer, columnIndex, 0, false, true));
				// we remove the found object from the cloned elementList as they are already selected
				toFind.remove(currentRealObject);
				selectObject = true;
			}
			if (toFind.isEmpty()) {
				// all objects are selected
				return selectObject;
			}
		}

		return selectObject;
	}


	/**
	 *
	 * Handles the initialization of the table's body resize styles, on opening, based on the previous changes made by the user.
	 *
	 */
	protected void initTableAxis() {
		DataLayer tableBodyLayer = getBodyLayerStack().getBodyDataLayer();
		// notation lists represent the elements that are instantiated in their table instance inside the model.notation file
		List<IAxis> notationColumnsAxisList = getTable().getCurrentColumnAxisProvider().getAxis();
		List<IAxis> notationRowsAxisList = getTable().getCurrentRowAxisProvider().getAxis();
		// actual number of displayed elements when looking at the table editor
		int actualColumnAxisElements = getTableAxisElementProvider().getColumnElementsList().size();
		int actualRowAxisElements = getTableAxisElementProvider().getRowElementsList().size();
		// value, width or height, of the resized column or row
		IntValueStyle value = null;

		// we go through all the elements to find those which have been modified
		for (int index = 0; index < notationColumnsAxisList.size(); index++) {
			IAxis currentColumnAxis = notationColumnsAxisList.get(index);
			// we need both to detect and use the correct value, width or height, of the handled element as the user could have modified the table when the axis was inverted
			if (!getTable().isInvertAxis()) {
				int axisWidth = tableBodyLayer.getColumnWidthByPosition(index);
				value = (IntValueStyle) currentColumnAxis.getNamedStyle(NattablestylePackage.eINSTANCE.getIntValueStyle(), NamedStyleConstants.AXIS_WIDTH);
				if (value != null) {
					// we set the size of the axis in the graphical representation
					tableBodyLayer.setColumnWidthByPosition(index, value.getIntValue());
				} else if (axisWidth != DefaultSizeUtils.getDefaultCellWidth()) {
					// resets the size in case of an undo to the default table
					tableBodyLayer.setColumnWidthByPosition(index, DefaultSizeUtils.getDefaultCellWidth());
				}
			} else {
				int axisHeight = tableBodyLayer.getRowHeightByPosition(index);
				value = (IntValueStyle) currentColumnAxis.getNamedStyle(NattablestylePackage.eINSTANCE.getIntValueStyle(), NamedStyleConstants.AXIS_HEIGHT);
				if (value != null) {
					tableBodyLayer.setRowHeightByPosition(index, value.getIntValue());
				} else if (axisHeight != DefaultSizeUtils.getDefaultCellHeight()) {
					tableBodyLayer.setRowHeightByPosition(index, DefaultSizeUtils.getDefaultCellHeight());
				}
			}
		}

		for (int index = 0; index < notationRowsAxisList.size(); index++) {
			IAxis currentRowAxis = notationRowsAxisList.get(index);
			if (!getTable().isInvertAxis()) {
				int axisHeight = tableBodyLayer.getRowHeightByPosition(index);
				value = (IntValueStyle) currentRowAxis.getNamedStyle(NattablestylePackage.eINSTANCE.getIntValueStyle(), NamedStyleConstants.AXIS_HEIGHT);
				if (value != null) {
					tableBodyLayer.setRowHeightByPosition(index, value.getIntValue());
				} else if (axisHeight != DefaultSizeUtils.getDefaultCellHeight()) {
					tableBodyLayer.setRowHeightByPosition(index, DefaultSizeUtils.getDefaultCellHeight());
				}
			} else {
				int axisWidth = tableBodyLayer.getColumnWidthByPosition(index);
				value = (IntValueStyle) currentRowAxis.getNamedStyle(NattablestylePackage.eINSTANCE.getIntValueStyle(), NamedStyleConstants.AXIS_WIDTH);
				if (value != null) {
					tableBodyLayer.setColumnWidthByPosition(index, value.getIntValue());
				} else if (axisWidth != DefaultSizeUtils.getDefaultCellWidth()) {
					tableBodyLayer.setColumnWidthByPosition(index, DefaultSizeUtils.getDefaultCellWidth());
				}
			}
		}

		// this method is used to resize by default. In the actual state, only the rows, representing the table's core elements, are missing from the notation file
		if (notationRowsAxisList.size() == 0) {
			if (getTable().isInvertAxis()) {
				for (int index = 0; index < actualColumnAxisElements; index++) {
					tableBodyLayer.setColumnWidthByPosition(index, DefaultSizeUtils.getDefaultCellWidth());
				}

			} else if (!getTable().isInvertAxis()) {
				for (int index = 0; index < actualRowAxisElements; index++) {
					tableBodyLayer.setRowHeightByPosition(index, DefaultSizeUtils.getDefaultCellHeight());
				}

			}
		}
	}

	/**
	 * This allows to manage the fill columns size named style by managing the width of columns to fill all the parent space.
	 * 
	 * @since 2.0
	 */
	protected void doFillColumnsSize() {
		BooleanValueStyle fillColumnsSize = (BooleanValueStyle) getTable().getNamedStyle(NattablestylePackage.eINSTANCE.getBooleanValueStyle(), NamedStyleConstants.FILL_COLUMNS_SIZE);
		if (fillColumnsSize == null) {
			final TableConfiguration config = getTable().getTableConfiguration();
			fillColumnsSize = (BooleanValueStyle) config.getNamedStyle(NattablestylePackage.eINSTANCE.getBooleanValueStyle(), NamedStyleConstants.FILL_COLUMNS_SIZE);
		}

		if (null != fillColumnsSize) {
			if (fillColumnsSize.isBooleanValue()) {
				final Composite parent = natTable.getParent();

				if (null != parent && !parent.isDisposed()) {
					final int parentSize = parent.getSize().x;

					// Get the column width needed
					final int columnSize = PapyrusTableSizeCalculation.getColumnFillWidth(this, parentSize);

					if (0 < columnSize) {
						// Affext the width to the column
						for (int columnPosition = 0; columnPosition < getBodyLayerStack().getColumnHideShowLayer().getColumnCount(); columnPosition++) {
							getBodyLayerStack().getBodyDataLayer().setColumnWidthByPosition(columnPosition, columnSize);
						}
					}
				}
			}
		}
	}

	/**
	 *
	 * Handles the initialization of the table's headers resize styles, on opening, based on the previous changes made by the user.
	 *
	 */
	protected void initTableHeaders() {
		DataLayer tableRowIndexHeaderLayer = rowHeaderLayerStack.getRowIndexDataLayer();
		DataLayer tableRowLabelHeaderLayer = rowHeaderLayerStack.getRowLabelDataLayer();
		DataLayer tableColumnIndexHeaderLayer = columnHeaderLayerStack.getColumnIndexDataLayer();
		DataLayer tableColumnLabelHeaderLayer = columnHeaderLayerStack.getColumnLabelDataLayer();
		AbstractHeaderAxisConfiguration rowHeader = HeaderAxisConfigurationManagementUtils.getRowAbstractHeaderAxisConfigurationUsedInTable(getTable());
		AbstractHeaderAxisConfiguration columnHeader = HeaderAxisConfigurationManagementUtils.getColumnAbstractHeaderAxisConfigurationUsedInTable(getTable());

		// handles the initialization for the column headers,
		// check if the the user saved the table with an inverted axis or not as it would change the type of style required for resize,
		// it is important to note that AbstractHeaderAxisConfigurationUsedInTable already handles the invertAxis parameter to return the correct Axis (column/row)
		IntValueStyle valueColumnIndex = (IntValueStyle) columnHeader.getNamedStyle(NattablestylePackage.eINSTANCE.getIntValueStyle(), NamedStyleConstants.COLUMN_INDEX_HEIGHT);
		// check if the user has previously entered a value for it, if not resets to the default
		if (valueColumnIndex != null) {
			tableColumnIndexHeaderLayer.setRowHeightByPosition(0, valueColumnIndex.getIntValue());
		} else {
			tableColumnIndexHeaderLayer.setRowHeightByPosition(0, DefaultSizeUtils.getDefaultCellHeight());
		}

		// same here
		IntValueStyle valueColumnLabel = (IntValueStyle) columnHeader.getNamedStyle(NattablestylePackage.eINSTANCE.getIntValueStyle(), NamedStyleConstants.COLUMN_LABEL_HEIGHT);
		if (valueColumnLabel != null) {
			tableColumnLabelHeaderLayer.setRowHeightByPosition(0, valueColumnLabel.getIntValue());
		} else {
			tableColumnLabelHeaderLayer.setRowHeightByPosition(0, DefaultSizeUtils.getDefaultCellHeight());
		}

		// same behavior but with the row headers
		IntValueStyle valueRowIndex = (IntValueStyle) rowHeader.getNamedStyle(NattablestylePackage.eINSTANCE.getIntValueStyle(), NamedStyleConstants.ROW_INDEX_WIDTH);
		if (valueRowIndex != null) {
			tableRowIndexHeaderLayer.setColumnWidthByPosition(0, valueRowIndex.getIntValue());
		} else {
			tableRowIndexHeaderLayer.setColumnWidthByPosition(0, DefaultSizeUtils.getDefaultRowHeaderWidth());
		}

		IntValueStyle valueRowLabel = (IntValueStyle) rowHeader.getNamedStyle(NattablestylePackage.eINSTANCE.getIntValueStyle(), NamedStyleConstants.ROW_LABEL_WIDTH);
		if (valueRowLabel != null) {
			tableRowLabelHeaderLayer.setColumnWidthByPosition(0, valueRowLabel.getIntValue());
		} else {
			tableRowLabelHeaderLayer.setColumnWidthByPosition(0, DefaultSizeUtils.getDefaultRowHeaderWidth());
		}

		// Manage the style for the header with index > 1
		for (final Style style : rowHeader.getStyles()) {
			if (style instanceof IntValueStyle) {
				final String styleName = ((IntValueStyle) style).getName();
				if (styleName.startsWith(NamedStyleConstants.ROW_LABEL_POSITION_PREFIX_WIDTH)) {
					// Calculate the position contained in the name of the style
					String styleNameWithoutPrefix = styleName.replace(NamedStyleConstants.ROW_LABEL_POSITION_PREFIX_WIDTH, "");
					String styleNameWithoutSuffix = styleNameWithoutPrefix.replace(NamedStyleConstants.ROW_LABEL_POSITION_SUFFIX_WIDTH, "");
					// Remove 1 because the column position start at 0
					int position = Integer.parseInt(styleNameWithoutSuffix) - 1;

					// Don't try to set a width of a position which not existing
					if (position < tableRowLabelHeaderLayer.getColumnCount()) {
						tableRowLabelHeaderLayer.setColumnWidthByPosition(position, ((IntValueStyle) style).getIntValue());
					}
				}
			}
		}

	}


	/**
	 *
	 * Handles the initialization of the table's cell merges, on opening, based on the previous changes made by the user.
	 *
	 */
	protected void initTableMerge() {
		// clears the previous spanning (== merge) behavior that would interfere with the new one
		clearTableSpan();

		// the four booleans that indicate the type of merge currently used in the table: all columns, all rows, selected rows, selected columns
		BooleanValueStyle valueRow = (BooleanValueStyle) HeaderAxisConfigurationManagementUtils.getRowAbstractHeaderAxisConfigurationUsedInTable(getTable())
				.getNamedStyle(NattablestylePackage.eINSTANCE.getBooleanValueStyle(), NamedStyleConstants.MERGE_ROWS);
		BooleanValueStyle valueColumn = (BooleanValueStyle) HeaderAxisConfigurationManagementUtils.getColumnAbstractHeaderAxisConfigurationUsedInTable(getTable())
				.getNamedStyle(NattablestylePackage.eINSTANCE.getBooleanValueStyle(), NamedStyleConstants.MERGE_COLUMNS);
		boolean mergeSelectedRows = getToMergeRowBoolean();
		boolean mergeSelectedColumns = getToMergeColumnBoolean();

		// notation lists represent the elements that are instantiated in their table instance inside the model.notation file
		List<IAxis> notationColumnsAxisList = getTable().getCurrentColumnAxisProvider().getAxis();
		List<IAxis> notationRowsAxisList = getTable().getCurrentRowAxisProvider().getAxis();
		// list of the selected Axis indexes
		List<Integer> selectedAxisIndex = new ArrayList<Integer>();

		// the two conditions below handle the merge of all the columns/rows
		if (valueRow != null && valueRow.isBooleanValue()) {
			// it is important to note that AbstractHeaderAxisConfigurationUsedInTable already handles the invertAxis parameter to return the correct Header (column/row)
			bodyLayerStack.getBodyLayerSpanProvider().setAutoColumnSpan(true);
		}
		if (valueColumn != null && valueColumn.isBooleanValue()) {
			bodyLayerStack.getBodyLayerSpanProvider().setAutoRowSpan(true);
		}

		// the two conditions below handle the merge of the selected columns/rows
		if (mergeSelectedRows) {
			// check the axis' boolean to know if it has to be merged or not in the selection
			if (!getTable().isInvertAxis()) {
				for (int index = 0; index < notationRowsAxisList.size(); index++) {
					IAxis currentAxis = notationRowsAxisList.get(index);
					BooleanValueStyle currentAxisMergeBoolean = (BooleanValueStyle) currentAxis.getNamedStyle(NattablestylePackage.eINSTANCE.getBooleanValueStyle(), NamedStyleConstants.MERGE_IN_SELECTED_ROWS);
					if (currentAxisMergeBoolean != null && currentAxisMergeBoolean.isBooleanValue()) {
						selectedAxisIndex.add(index);
					}
				}
			} else {
				// this behavior checks the merge boolean, if any, as the rows are now columns and vice versa
				for (int index = 0; index < notationColumnsAxisList.size(); index++) {
					IAxis currentAxis = notationColumnsAxisList.get(index);
					BooleanValueStyle currentAxisMergeBoolean = (BooleanValueStyle) currentAxis.getNamedStyle(NattablestylePackage.eINSTANCE.getBooleanValueStyle(), NamedStyleConstants.MERGE_IN_SELECTED_ROWS);
					if (currentAxisMergeBoolean != null && currentAxisMergeBoolean.isBooleanValue()) {
						selectedAxisIndex.add(index);
					}
				}
			}

			// the spanning can now be set correctly
			bodyLayerStack.getBodyLayerSpanProvider().setAutoColumnSpan(true);
			bodyLayerStack.getBodyLayerSpanProvider().addAutoSpanningRowPositions(selectedAxisIndex.toArray(new Integer[selectedAxisIndex.size()]));
		}
		// same behavior for the column axis
		if (mergeSelectedColumns) {
			if (!getTable().isInvertAxis()) {
				for (int index = 0; index < notationColumnsAxisList.size(); index++) {
					IAxis currentAxis = notationColumnsAxisList.get(index);
					BooleanValueStyle currentAxisMergeBoolean = (BooleanValueStyle) currentAxis.getNamedStyle(NattablestylePackage.eINSTANCE.getBooleanValueStyle(), NamedStyleConstants.MERGE_IN_SELECTED_COLUMNS);
					if (currentAxisMergeBoolean != null && currentAxisMergeBoolean.isBooleanValue()) {
						selectedAxisIndex.add(index);
					}
				}
			} else {
				for (int index = 0; index < notationRowsAxisList.size(); index++) {
					IAxis currentAxis = notationRowsAxisList.get(index);
					BooleanValueStyle currentAxisMergeBoolean = (BooleanValueStyle) currentAxis.getNamedStyle(NattablestylePackage.eINSTANCE.getBooleanValueStyle(), NamedStyleConstants.MERGE_IN_SELECTED_COLUMNS);
					if (currentAxisMergeBoolean != null && currentAxisMergeBoolean.isBooleanValue()) {
						selectedAxisIndex.add(index);
					}
				}
			}

			bodyLayerStack.getBodyLayerSpanProvider().setAutoRowSpan(true);
			bodyLayerStack.getBodyLayerSpanProvider().addAutoSpanningColumnPositions(selectedAxisIndex.toArray(new Integer[selectedAxisIndex.size()]));
		}
	}


	/**
	 * Clears the merge behavior currently used in the table
	 */
	protected void clearTableSpan() {
		bodyLayerStack.getBodyLayerSpanProvider().clearAutoSpanningColumnPositions();
		bodyLayerStack.getBodyLayerSpanProvider().clearAutoSpanningRowPositions();
		bodyLayerStack.getBodyLayerSpanProvider().setAutoColumnSpan(false);
		bodyLayerStack.getBodyLayerSpanProvider().setAutoRowSpan(false);
	}


	/**
	 *
	 * @return
	 * 		The boolean indicating that some row axis are to be merged in the selection
	 */
	protected boolean getToMergeRowBoolean() {
		// for(IAxis currentAxis : getTable().getCurrentRowAxisProvider().getAxis()) {
		// the above test does not allow a quick switch between invertAxis and not as the provider will deliver the same list in both states
		for (Object currentObject : getRowElementsList()) {
			if (currentObject instanceof IAxis) {
				IAxis currentAxis = (IAxis) currentObject;
				BooleanValueStyle axisToMerge = (BooleanValueStyle) currentAxis.getNamedStyle(NattablestylePackage.eINSTANCE.getBooleanValueStyle(), NamedStyleConstants.MERGE_IN_SELECTED_ROWS);
				if (axisToMerge != null && axisToMerge.isBooleanValue()) {
					// one axis has a merge boolean to true hence the table was previously merged
					return true;
				}
			}
		}
		return false;
	}

	/**
	 *
	 * @return
	 * 		The boolean indicating that some column axis are to be merged in the selection
	 */
	protected boolean getToMergeColumnBoolean() {
		// for(IAxis currentAxis : getTable().getCurrentColumnAxisProvider().getAxis()) {
		// the above test does not allow a quick switch between invertAxis and not as the provider will deliver the same list in both states
		for (Object currentObject : getColumnElementsList()) {
			if (currentObject instanceof IAxis) {
				IAxis currentAxis = (IAxis) currentObject;
				BooleanValueStyle axisToMerge = (BooleanValueStyle) currentAxis.getNamedStyle(NattablestylePackage.eINSTANCE.getBooleanValueStyle(), NamedStyleConstants.MERGE_IN_SELECTED_COLUMNS);
				if (axisToMerge != null && axisToMerge.isBooleanValue()) {
					// one axis has a merge boolean to true hence the table was previously merged
					return true;
				}
			}
		}
		return false;
	}

	/**
	 *
	 * @return
	 * 		The boolean indicating if the toggle of the currently used menu is to be set to true or not.
	 *         i.e. if the current selection is the same that the previously merged selection
	 */
	protected boolean getToggleStateSelectedRows() {
		// the size of the selection used to see if an axis has been selected
		int selectionSize = bodyLayerStack.getSelectionLayer().getFullySelectedRowPositions().length;
		// fetch the merge booleans of the selected rows and return false if the selection does not match the previously merged rows
		for (int index : bodyLayerStack.getSelectionLayer().getFullySelectedRowPositions()) {
			Object currentObject = getRowElement(index);
			if (getRowElement(index) instanceof IAxis) {
				IAxis currentAxis = (IAxis) currentObject;
				BooleanValueStyle axisToMerge = (BooleanValueStyle) currentAxis.getNamedStyle(NattablestylePackage.eINSTANCE.getBooleanValueStyle(), NamedStyleConstants.MERGE_IN_SELECTED_ROWS);
				if ((axisToMerge != null && !axisToMerge.isBooleanValue()) || (axisToMerge == null)) {
					return false;
				}
			}
		}

		// as the user may have selected only a cell or a column, those cases must be taken into account
		if (selectionSize > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 *
	 * @return
	 * 		The boolean indicating if the toggle of the currently used menu is to be set to true or not.
	 *         i.e. if the current selection is the same that the previously merged selection
	 */
	protected boolean getToggleStateSelectedColumns() {
		// the size of the selection used to see if an axis has been selected
		int selectionSize = bodyLayerStack.getSelectionLayer().getFullySelectedColumnPositions().length;
		// fetch the merge booleans of the selected rows and return false if the selection does not match the previously merged columns
		for (int index : bodyLayerStack.getSelectionLayer().getFullySelectedColumnPositions()) {
			Object currentObject = getColumnElement(index);
			if (getColumnElement(index) instanceof IAxis) {
				IAxis currentAxis = (IAxis) currentObject;
				BooleanValueStyle axisToMerge = (BooleanValueStyle) currentAxis.getNamedStyle(NattablestylePackage.eINSTANCE.getBooleanValueStyle(), NamedStyleConstants.MERGE_IN_SELECTED_COLUMNS);
				if ((axisToMerge != null && !axisToMerge.isBooleanValue()) || (axisToMerge == null)) {
					return false;
				}
			}
		}

		// as the user may have selected only a cell or a column, those cases must be taken into account
		if (selectionSize > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 *
	 * @return
	 * 		The boolean indicating if the toggle of the currently used menu is to be set to true or not.
	 *         i.e. if the current selection is the same that the previously merged selection
	 */
	protected boolean getToggleStateAllRows() {
		BooleanValueStyle mergeRows = (BooleanValueStyle) HeaderAxisConfigurationManagementUtils.getRowAbstractHeaderAxisConfigurationUsedInTable(getTable())
				.getNamedStyle(NattablestylePackage.eINSTANCE.getBooleanValueStyle(), NamedStyleConstants.MERGE_ROWS);
		if (mergeRows != null && mergeRows.isBooleanValue()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * this method is used to update the state of the toggle actions for table
	 */
	protected void updateToggleActionState() {
		final ICommandService commandService = EclipseCommandUtils.getCommandService();
		if (commandService != null) {
			final AbstractHeaderAxisConfiguration columnAxisConfiguration = HeaderAxisConfigurationManagementUtils.getColumnAbstractHeaderAxisConfigurationUsedInTable(getTable());

			// update the header configuration
			org.eclipse.core.commands.Command command = commandService.getCommand(CommandIds.COMMAND_COLUMN_DISPLAY_FILTER_ID);
			EclipseCommandUtils.updateToggleCommandState(command, columnAxisConfiguration.isDisplayFilter());
		}
	}

	/**
	 *
	 * @return
	 * 		The boolean indicating if the toggle of the currently used menu is to be set to true or not.
	 *         i.e. if the current selection is the same that the previously merged selection
	 */
	protected boolean getToggleStateAllColumns() {
		BooleanValueStyle mergeColumns = (BooleanValueStyle) HeaderAxisConfigurationManagementUtils.getColumnAbstractHeaderAxisConfigurationUsedInTable(getTable())
				.getNamedStyle(NattablestylePackage.eINSTANCE.getBooleanValueStyle(), NamedStyleConstants.MERGE_COLUMNS);
		if (mergeColumns != null && mergeColumns.isBooleanValue()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 *
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 *
	 * @param adapter
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter == TableSelectionProvider.class) {
			return this.selectionProvider;
		}
		if (adapter == TableSelectionWrapper.class) {
			ISelection selection = this.selectionProvider.getSelection();
			if (selection instanceof TableStructuredSelection) {
				return ((TableStructuredSelection) selection).getAdapter((TableSelectionWrapper.class));
			}
		}
		if (adapter == TableStructuredSelection.class) {
			ISelection selection = this.selectionProvider.getSelection();
			if (selection instanceof TableStructuredSelection) {
				return selection;
			}
		}
		return null;

	}

	/**
	 *
	 * @return
	 * 		a {@link TableStructuredSelection} representing the current selection of the table or <code>null</code> when there is no selection
	 * @since 2.0
	 */
	public final TableStructuredSelection getSelectionInTable() {
		ISelection selection = this.selectionProvider.getSelection();
		if (selection instanceof TableStructuredSelection) {
			return (TableStructuredSelection) selection;
		}
		return null;
	}

	/**
	 *
	 * @return
	 * 		a map representing index of fully selected rows linked to the associated element
	 *
	 *         The returned value can't be <code>null</code>
	 */
	protected final Map<Integer, Object> getFullySelectedRows() {
		TableStructuredSelection selection = getSelectionInTable();
		if (selection != null) {
			TableSelectionWrapper selectionWrapper = (TableSelectionWrapper) selection.getAdapter(TableSelectionWrapper.class);
			if (selectionWrapper != null) {
				return selectionWrapper.getFullySelectedRows();
			}
		}
		return Collections.emptyMap();
	}

	/**
	 *
	 * @return
	 * 		a map representing index of fully selected columns linked to the associated element
	 *
	 *         The returned value can't be <code>null</code>
	 */
	protected final Map<Integer, Object> getFullySelectedColumns() {
		TableStructuredSelection selection = getSelectionInTable();
		if (selection != null) {
			TableSelectionWrapper selectionWrapper = (TableSelectionWrapper) selection.getAdapter(TableSelectionWrapper.class);
			if (selectionWrapper != null) {
				return selectionWrapper.getFullySelectedColumns();
			}
		}
		return Collections.emptyMap();
	}

}
