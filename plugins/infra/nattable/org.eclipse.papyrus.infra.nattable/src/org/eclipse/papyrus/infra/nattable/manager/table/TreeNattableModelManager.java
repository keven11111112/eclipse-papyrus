/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.manager.table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.Command;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.hideshow.ColumnHideShowLayer;
import org.eclipse.nebula.widgets.nattable.hideshow.command.MultiColumnHideCommand;
import org.eclipse.nebula.widgets.nattable.hideshow.command.MultiColumnShowCommand;
import org.eclipse.nebula.widgets.nattable.hideshow.command.ShowAllColumnsCommand;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.papyrus.commands.Activator;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.GMFUnsafe;
import org.eclipse.papyrus.infra.nattable.command.CommandIds;
import org.eclipse.papyrus.infra.nattable.configuration.TreeTableClickSortConfiguration;
import org.eclipse.papyrus.infra.nattable.configuration.TreeTablePopupMenuConfiguration;
import org.eclipse.papyrus.infra.nattable.layerstack.BodyLayerStack;
import org.eclipse.papyrus.infra.nattable.layerstack.RowHeaderHierarchicalLayerStack;
import org.eclipse.papyrus.infra.nattable.layerstack.RowHeaderLayerStack;
import org.eclipse.papyrus.infra.nattable.listener.HideShowCategoriesTableListener;
import org.eclipse.papyrus.infra.nattable.manager.axis.AxisManagerFactory;
import org.eclipse.papyrus.infra.nattable.manager.axis.CompositeAxisManagerForEventList;
import org.eclipse.papyrus.infra.nattable.manager.axis.CompositeTreeAxisManagerForEventList;
import org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager;
import org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManagerForEventList;
import org.eclipse.papyrus.infra.nattable.manager.axis.ICompositeAxisManager;
import org.eclipse.papyrus.infra.nattable.manager.axis.ITreeItemAxisManagerForEventList;
import org.eclipse.papyrus.infra.nattable.menu.MenuConstants;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.ITreeItemAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.TreeFillingConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablestyle.DisplayStyle;
import org.eclipse.papyrus.infra.nattable.selection.ISelectionExtractor;
import org.eclipse.papyrus.infra.nattable.selection.ObjectsSelectionExtractor;
import org.eclipse.papyrus.infra.nattable.tree.CollapseAndExpandActionsEnum;
import org.eclipse.papyrus.infra.nattable.tree.DatumExpansionModel;
import org.eclipse.papyrus.infra.nattable.tree.DatumTreeFormat;
import org.eclipse.papyrus.infra.nattable.utils.CollapseExpandActionHelper;
import org.eclipse.papyrus.infra.nattable.utils.FillingConfigurationUtils;
import org.eclipse.papyrus.infra.nattable.utils.StyleUtils;
import org.eclipse.papyrus.infra.nattable.utils.TableHelper;
import org.eclipse.papyrus.infra.ui.util.EclipseCommandUtils;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.commands.ICommandService;

import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.FilterList;
import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.SortedList;
import ca.odell.glazedlists.TreeList;
import ca.odell.glazedlists.TreeList.Format;

/**
 * This class allows to manage Papyrus Tree Table
 *
 */
public class TreeNattableModelManager extends NattableModelManager implements ITreeNattableModelManager {

	/**
	 * the event list used to build the tree list
	 */
	// protected EventList<Object> eventList;

	/**
	 * the managed tree list
	 */
	protected TreeList treeList;

	protected DatumTreeFormat treeFormat;

	protected DatumExpansionModel expansionModel;


	/**
	 * the listener used to refresh the update the hidden rows
	 */
	protected ResourceSetListener hideShowCategoriesListener;

	/**
	 * Constructor.
	 *
	 * @param rawModel
	 * @param selectionExtractor
	 */
	public TreeNattableModelManager(Table rawModel, ISelectionExtractor selectionExtractor) {
		super(rawModel, selectionExtractor);
		Assert.isTrue(TableHelper.isTreeTable(rawModel));

		// Manage the change axis provider adapter only for the column (row cannot manage refresh)
		rawModel.eAdapters().remove(changeAxisProvider);
		changeAxisProvider = new AdapterImpl() {

			@Override
			public void notifyChanged(final Notification msg) {
				if (NattablePackage.eINSTANCE.getTable_CurrentColumnAxisProvider() == msg.getFeature()) {
					if (null != msg.getNewValue() && !msg.getNewValue().equals(msg.getOldValue())) {
						Display.getCurrent().asyncExec(new Runnable() {

							@Override
							public void run() {
								init();
								refreshNatTable();
							}
						});
					}
				}
			}
		};
		rawModel.eAdapters().add(changeAxisProvider);
	}

	/**
	 * Constructor.
	 *
	 * @param rawModel
	 */
	public TreeNattableModelManager(Table rawModel) {
		this(rawModel, new ObjectsSelectionExtractor());
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.AbstractNattableWidgetManager#registerPopupMenuConfiguration(org.eclipse.nebula.widgets.nattable.NatTable)
	 *
	 * @param natTable
	 */
	@Override
	protected void registerPopupMenuConfiguration(final NatTable natTable) {
		natTable.addConfiguration(new TreeTablePopupMenuConfiguration());
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager#createHorizontalElementList()
	 *
	 * @return
	 */
	@Override
	protected List<Object> createHorizontalElementList() {
		// super.createHorizontalElementList();
		EventList<Object> eventList = GlazedLists.eventList(new ArrayList<Object>());
		eventList = GlazedLists.threadSafeList(eventList);
		this.basicHorizontalList = eventList;
		// must be created before the row sort model
		this.rowSortedList = new SortedList<Object>(this.basicHorizontalList, null);
		treeFormat = new DatumTreeFormat(getRowSortModel());
		this.expansionModel = new DatumExpansionModel();

		this.horizontalFilterList = new FilterList<Object>(this.rowSortedList);
		this.treeList = new TreeList(this.horizontalFilterList, treeFormat, expansionModel);

		return this.treeList;
	}

	public TreeList getTreeList() {
		return this.treeList;
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.AbstractNattableWidgetManager#createAndRegisterMenuManagerAndSelectionProvider(org.eclipse.nebula.widgets.nattable.NatTable, org.eclipse.ui.IWorkbenchPartSite,
	 *      org.eclipse.jface.viewers.ISelectionProvider)
	 *
	 * @param natTable
	 * @param site
	 * @param selectionProvider
	 * @return
	 */
	@Override
	public MenuManager createAndRegisterMenuManagerAndSelectionProvider(NatTable natTable, IWorkbenchPartSite site, ISelectionProvider selectionProvider) {
		final MenuManager menuManager = super.createAndRegisterMenuManagerAndSelectionProvider(natTable, site, selectionProvider);
		final Separator separator = new Separator(MenuConstants.TREE_SEPARATOR_ID);
		separator.setVisible(true);
		menuManager.insertAfter(MenuConstants.EDIT_SEPARATOR_ID, separator);
		return menuManager;
	}


	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager#createNattable(org.eclipse.swt.widgets.Composite, int, org.eclipse.ui.IWorkbenchPartSite)
	 *
	 * @param parent
	 * @param style
	 * @param site
	 * @return
	 */
	@Override
	public NatTable createNattable(Composite parent, int style, IWorkbenchPartSite site) {
		NatTable nattable = super.createNattable(parent, style, site);
		// update the hidden categories

		List<Integer> hiddenDepth = StyleUtils.getHiddenDepths(this);
		if (hiddenDepth.size() > 0) {
			hideShowCategories(hiddenDepth, null);
		}
		this.hideShowCategoriesListener = new HideShowCategoriesTableListener(this);
		if (null != getTableEditingDomain()) {
			getTableEditingDomain().addResourceSetListener(this.hideShowCategoriesListener);
		}

		// FIX for the bug 469284: [Tree Table] empty table when a table is loaded with applied filters
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=469284
		if (StyleUtils.hasAppliedFilter(this)) {
			doCollapseExpandAction(CollapseAndExpandActionsEnum.EXPAND_ALL, null);
		}

		return nattable;
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.AbstractNattableWidgetManager#addClickSortConfiguration(org.eclipse.nebula.widgets.nattable.NatTable)
	 *
	 * @param natTable
	 */
	@Override
	protected void addClickSortConfiguration(NatTable natTable) {
		natTable.addConfiguration(new TreeTableClickSortConfiguration());
	}


	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager#updateToggleActionState()
	 *
	 */
	@Override
	protected void updateToggleActionState() {
		super.updateToggleActionState();
		// update hierarchic table display style
		DisplayStyle style = TableHelper.getTableDisplayStyle(this);
		final ICommandService commandService = EclipseCommandUtils.getCommandService();
		if (commandService != null) {

			Command command = commandService.getCommand(CommandIds.COMMAND_HIERARCHIC_DISPLAY_STYLE);
			if (!DisplayStyle.NORMAL.equals(style)) {
				updateRadioCommandState(command, style.getLiteral());
			}
		}
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager#createAxisManager(java.util.List, org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider, boolean)
	 *
	 * @param representations
	 * @param contentProvider
	 * @param columnAxisManager
	 * @return
	 */
	@Override
	protected ICompositeAxisManager createAxisManager(List<AxisManagerRepresentation> representations, AbstractAxisProvider contentProvider, boolean columnAxisManager) {
		if (columnAxisManager) {
			return super.createAxisManager(representations, contentProvider, columnAxisManager);
		} else {
			CompositeTreeAxisManagerForEventList compositeAxisManager = new CompositeTreeAxisManagerForEventList((EventList<Object>) horizontalFilterList);
			final List<IAxisManagerForEventList> managers = new ArrayList<IAxisManagerForEventList>();
			for (AxisManagerRepresentation current : representations) {
				final IAxisManager manager = AxisManagerFactory.INSTANCE.getAxisManager(current);
				Assert.isTrue(manager instanceof IAxisManagerForEventList);
				manager.init(this, current, contentProvider);
				managers.add((IAxisManagerForEventList) manager);

			}
			compositeAxisManager.init(this, null, contentProvider);
			DatumTreeFormat treeFormat = getTreeFormat();
			treeFormat.setTreeComparatorProvider((CompositeTreeAxisManagerForEventList) compositeAxisManager);
			this.expansionModel.setAxisManager((CompositeTreeAxisManagerForEventList) compositeAxisManager);
			((CompositeAxisManagerForEventList) compositeAxisManager).setSubManagers(managers);
			return compositeAxisManager;
		}

	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.ITreeNattableModelManager#getTreeFormat()
	 *
	 * @return
	 */
	@Override
	public DatumTreeFormat getTreeFormat() {
		return this.treeFormat;
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.ITreeNattableModelManager#getDepth()
	 *
	 * @return
	 */
	@Override
	public int getTreeItemDepth(final ITreeItemAxis axis) {
		Format<ITreeItemAxis> format = getTreeFormat();
		if (format != null) {
			List<ITreeItemAxis> path = new ArrayList<ITreeItemAxis>();
			format.getPath(path, axis);
			return path.size() - 1;
		}
		return 0;
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.ITreeNattableModelManager#getSemanticDepth(org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.ITreeItemAxis)
	 *
	 * @param axis
	 * @return
	 */
	@Override
	public int getSemanticDepth(ITreeItemAxis axis) {
		Object representedObject = axis.getElement();
		if (representedObject instanceof TreeFillingConfiguration) {
			return ((TreeFillingConfiguration) representedObject).getDepth();
		} else {
			ITreeItemAxis parent = axis.getParent();
			if (parent == null) {
				return 0;
			}
			representedObject = parent.getElement();
			Assert.isTrue(representedObject instanceof TreeFillingConfiguration);
			return ((TreeFillingConfiguration) representedObject).getDepth();
		}
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.ITreeNattableModelManager#hideShowCategories(java.util.List, java.util.List)
	 *
	 * @param depthToHide
	 * @param depthToShow
	 */
	@Override
	public void hideShowCategories(List<Integer> depthToHide, List<Integer> depthToShow) {
		hideShowRowCategories(depthToHide, depthToShow);
		hideShowColumnCategoriesInRowHeader(depthToHide, depthToShow);
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.ITreeNattableModelManager#hideShowRowCategories(java.util.List, java.util.List)
	 *
	 * @param depthToHide
	 * @param depthToShow
	 */
	@Override
	public void hideShowRowCategories(List<Integer> depthToHide, List<Integer> depthToShow) {
		// we hide the rows representing the categories
		((ITreeItemAxisManagerForEventList) getRowAxisManager()).managedHideShowCategoriesForDepth(depthToHide, depthToShow);
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.ITreeNattableModelManager#hideShowColumnCategoriesInRowHeader(java.util.List, java.util.List)
	 *
	 * @param depthToHide
	 * @param depthToShow
	 */
	@Override
	public void hideShowColumnCategoriesInRowHeader(List<Integer> depthToHide, List<Integer> depthToShow) {
		this.natTable.refresh();
		RowHeaderLayerStack rowHeaderLayerStack = getRowHeaderLayerStack();
		if (rowHeaderLayerStack instanceof RowHeaderHierarchicalLayerStack) {
			ColumnHideShowLayer layer = ((RowHeaderHierarchicalLayerStack) rowHeaderLayerStack).getRowHeaderColumnHideShowLayer();
			ILayer subLayer = layer.getUnderlyingLayerByPosition(0, 0);
			// we hide the columns representing the categories
			if (TableHelper.isMultiColumnTreeTable(this)) {
				boolean hasRootConfif = FillingConfigurationUtils.hasTreeFillingConfigurationForDepth(getTable(), 0);

				if (depthToHide != null && depthToHide.size() > 0) {
					int[] indexToHide = new int[depthToHide.size()];
					for (int i = 0; i < depthToHide.size(); i++) {
						Integer curr = depthToHide.get(i);
						int tmp = -1;
						if (hasRootConfif) {
							tmp = curr * 2;
						} else {
							// TODO not yet tested
							tmp = curr * 2 - 1;
						}

						// we need to convert the position
						tmp = layer.underlyingToLocalColumnPosition(subLayer, tmp);
						indexToHide[i] = tmp;
					}
					layer.doCommand(new MultiColumnHideCommand(layer, indexToHide));
				}

				if (depthToShow != null && depthToShow.size() > 0) {

					List<Integer> indexToShow = new ArrayList<Integer>();
					for (int i = 0; i < depthToShow.size(); i++) {
						Integer curr = depthToShow.get(i);
						int tmp = -1;
						if (hasRootConfif) {
							tmp = curr * 2;
						} else {
							// TODO not yet tested
							tmp = curr * 2 - 1;
						}
						indexToShow.add(tmp);
					}
					layer.doCommand(new MultiColumnShowCommand(indexToShow));
				}
			} else {
				layer.doCommand(new ShowAllColumnsCommand());
			}
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
		return new RowHeaderHierarchicalLayerStack(bodyLayerStack, this);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.ITreeNattableModelManager#doCollapseExpandAction(org.eclipse.papyrus.infra.nattable.tree.CollapseAndExpandActionsEnum, java.util.List)
	 *
	 * @param actionId
	 * @param selectedAxis
	 */
	@Override
	public void doCollapseExpandAction(CollapseAndExpandActionsEnum actionId, List<ITreeItemAxis> selectedAxis) {
		CollapseExpandActionHelper.doCollapseExpandAction(actionId, selectedAxis, getTableAxisElementProvider(), this.natTable);
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager#createInvertAxisListener()
	 *
	 * @return
	 */
	@Override
	protected Adapter createInvertAxisListener() {
		return null;
	}

	/**
	 * Modify the axis when it is disposed.
	 * 
	 * @param iAxis
	 *            The list of axis.
	 */
	private void modifyAcisDeliver(final List<IAxis> iAxis) {
		for (IAxis axis : iAxis) {
			if (axis instanceof ITreeItemAxis) {
				boolean isDelivering = axis.eDeliver();
				if (isDelivering) {
					// I suppose than it is not necessary to send notification here
					axis.eSetDeliver(false);
				}
				((ITreeItemAxis) axis).getChildren().clear();
				if (isDelivering) {
					// I reset the initial value, because the model can be reopened
					axis.eSetDeliver(true);
				}
			}
		}
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager#dispose()
	 *
	 */
	@Override
	public void dispose() {
		if (getTableEditingDomain() != null && this.hideShowCategoriesListener != null) {
			getTableEditingDomain().removeResourceSetListener(this.hideShowCategoriesListener);
			this.hideShowCategoriesListener = null;
		}
		final List<IAxis> iAxis;
		if (null == getHorizontalAxisProvider()) {
			iAxis = null;
		} else {
			iAxis = getHorizontalAxisProvider().getAxis();
		}

		if (iAxis != null && !iAxis.isEmpty()) { // see bug 467706: [Table 2] Tree Table with no tree filling configuration on depth==0 can't be reopened
			// we need to remove the children which are not serialized from the root of the table, to be able to reopen
			Runnable runnable = new Runnable() {

				@Override
				public void run() {
					modifyAcisDeliver(iAxis);
				}
			};
			try {
				if (null != getTableEditingDomain()) {
					GMFUnsafe.write(getTableEditingDomain(), runnable);
				} else {
					modifyAcisDeliver(iAxis);
				}
			} catch (InterruptedException e) {
				Activator.log.error(e);
			} catch (RollbackException e) {
				Activator.log.error(e);
			}

		}
		if (getTableEditingDomain() != null) {
			if (this.hideShowCategoriesListener != null) {
				getTableEditingDomain().removeResourceSetListener(this.hideShowCategoriesListener);
			}
		}
		super.dispose();
	}
}

