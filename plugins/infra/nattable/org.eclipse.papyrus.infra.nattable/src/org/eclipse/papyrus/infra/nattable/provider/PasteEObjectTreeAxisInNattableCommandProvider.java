/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 448065
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.provider;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.EMFCommandOperation;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer;
import org.eclipse.nebula.widgets.nattable.selection.command.SelectRowsCommand;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.commands.CheckedOperationHistory;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.manager.cell.CellManagerFactory;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IPasteConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.PasteEObjectConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.TreeFillingConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.Cell;
import org.eclipse.papyrus.infra.nattable.parsers.CSVParser;
import org.eclipse.papyrus.infra.nattable.parsers.CellIterator;
import org.eclipse.papyrus.infra.nattable.parsers.RowIterator;
import org.eclipse.papyrus.infra.nattable.paste.IValueSetter;
import org.eclipse.papyrus.infra.nattable.utils.AxisConfigurationUtils;
import org.eclipse.papyrus.infra.nattable.utils.CSVPasteHelper;
import org.eclipse.papyrus.infra.nattable.utils.Constants;
import org.eclipse.papyrus.infra.nattable.utils.FillingConfigurationUtils;
import org.eclipse.papyrus.infra.nattable.utils.PasteSeverityCode;
import org.eclipse.papyrus.infra.nattable.utils.PasteTreeUtils;
import org.eclipse.papyrus.infra.nattable.utils.StyleUtils;
import org.eclipse.papyrus.infra.nattable.utils.TableEditingDomainUtils;
import org.eclipse.papyrus.infra.nattable.utils.TableHelper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.ui.converter.AbstractStringValueConverter;
import org.eclipse.ui.progress.UIJob;

/**
 * Paste command manager for the paste in the table
 *
 * @author VL222926
 *
 */
// TODO : refactor me to create common ancestor with normal paste
// TODO : refactor me : This class should be in oep.infra.emf.nattable
// TODO Nicolas FAUVERGUE : This class must be refactor because the detached mode and the attached mode have some duplicated code.
public class PasteEObjectTreeAxisInNattableCommandProvider implements PasteNattableCommandProvider {

	private static final int MIN_AXIS_FOR_PROGRESS_MONITOR = 5;

	/**
	 * the table manager
	 */
	private INattableModelManager tableManager;

	/**
	 * the paste mode
	 */
	// private PasteEnablementStatus pasteMode;

	/**
	 * if true, we are pasting in detached mode
	 */
	private boolean detachedMode;

	/**
	 * the list of the post actions do do
	 */
	private List<String> postActions;

	/**
	 * the list of the axis to paste
	 */
	// private final String[] axisToPaste;

	/**
	 * the paste helper
	 */
	private final CSVPasteHelper pasteHelper;

	/**
	 * the converter map
	 */
	private final Map<Class<? extends AbstractStringValueConverter>, AbstractStringValueConverter> existingConverters;

	private static final String PASTE_ACTION_TASK_NAME = Messages.PasteEObjectAxisInTableCommandProvider_PasteAction;

	private static final String PASTE_ROWS_JOB_NAME = Messages.PasteEObjectAxisInTableCommandProvider_PasteRows;

	private static final String PASTE_COLUMNS_JOB_NAME = Messages.PasteEObjectAxisInTableCommandProvider_PasteColumns;

	private static final String PASTE_COMMAND_HAS_BEEN_CANCELLED = Messages.PasteEObjectAxisInTableCommandProvider_CommandCreationHasBeenCancelled;

	private static final String PASTE_COMMAND_CANT_BE_EXECUTED = "The Paste command can't be executed"; //$NON-NLS-1$

	private static final String PASTE_COMMAND_NAME = Messages.PasteEObjectAxisInTableCommandProvider_PasteFromStringCommand;

	private static final String CREATING_ELEMENT_A_NUMBER_X_Y = Messages.PasteEObjectAxisInTableCommandProvider_CreatingAnumberXonY;

	protected final boolean pasteColumn;

	private final int nbOperationsToDo;

	/**
	 * The character of the indentation for the single column.
	 */
	private static final char INDENTATION_CHARACTER = ' '; // $NON-NLS-1$


	// we refresh the dialog each X read char
	private final int refreshEachReadChar = 1000;

	/**
	 * if <code>true</code> the command can't be created and executed
	 */
	private boolean isDisposed = false;

	/**
	 * the reader to parse
	 */
	private final Reader reader;

	/**
	 * the parser to use
	 */
	private final CSVParser parser;

	int factor;

	private final Table table;

	final TransactionalEditingDomain tableEditingDomain;

	final TransactionalEditingDomain contextEditingDomain;

	final EObject tableContext;

	List<Object> secondAxis;

	/**
	 * Determinate if the table contains a single header column or multiple.
	 */
	private final boolean isSingleHeaderColumnTreeTable;

	/**
	 * Constructor.
	 *
	 * @param tableManager
	 *            The table manager.
	 * @param pasteColumn
	 *            Boolean to determinate if the column are pasted.
	 * @param reader
	 *            The reader of the pasted text.
	 * @param pasteHelper
	 *            The paste helper.
	 * @param totalSize
	 *            The total size of element pasted.
	 */
	public PasteEObjectTreeAxisInNattableCommandProvider(final INattableModelManager tableManager, final boolean pasteColumn, final Reader reader, final CSVPasteHelper pasteHelper, final long totalSize) {
		this.tableManager = tableManager;
		// this.pasteMode = status;
		this.existingConverters = new HashMap<Class<? extends AbstractStringValueConverter>, AbstractStringValueConverter>();
		this.pasteHelper = pasteHelper;
		this.reader = reader;
		this.pasteColumn = pasteColumn;
		this.table = tableManager.getTable();
		this.tableContext = table.getContext();
		tableEditingDomain = TableEditingDomainUtils.getTableEditingDomain(table);
		contextEditingDomain = TableEditingDomainUtils.getTableContextEditingDomain(table);
		// TODO improve refresh and progress monitor...
		long div = -1;
		if (totalSize > Integer.MAX_VALUE) {
			div = totalSize / Integer.MAX_VALUE;
			if (div > Integer.MAX_VALUE) {
				div = 2 * div;
			}
			this.factor = (int) div;
			this.nbOperationsToDo = (int) (totalSize / div);
		} else {
			this.factor = 1;
			this.nbOperationsToDo = (int) totalSize;
		}
		this.isSingleHeaderColumnTreeTable = TableHelper.isSingleColumnTreeTable(table);
		parser = this.pasteHelper.createParser(reader, isSingleHeaderColumnTreeTable);
		init();
	}

	/**
	 * Get the paste configuration for the depth.
	 * 
	 * @param depth
	 *            The depth searched.
	 * @return The paste configuration for the depth.
	 */
	protected List<IPasteConfiguration> getPasteConfigurationFor(final int depth) {
		final List<IPasteConfiguration> pasteConfs = new ArrayList<IPasteConfiguration>();
		if (depth == 0 && FillingConfigurationUtils.hasTreeFillingConfigurationForDepth(table, depth)) {
			final IPasteConfiguration conf = (IPasteConfiguration) AxisConfigurationUtils.getIAxisConfigurationUsedInTable(tableManager.getTable(), NattableaxisconfigurationPackage.eINSTANCE.getPasteEObjectConfiguration(), false);
			pasteConfs.add(conf);
		}
		for (final TreeFillingConfiguration current : FillingConfigurationUtils.getAllTreeFillingConfiguration(table)) {
			if (current.getDepth() == depth) {
				final IPasteConfiguration pasteConf = current.getPasteConfiguration();
				Assert.isNotNull(pasteConf);// must not be null here! (so must be verified before
				pasteConfs.add(pasteConf);
			}
		}
		return pasteConfs;
	}

	/**
	 * Get the paste configuration for the depth and the category name.
	 * 
	 * @param depth
	 *            The depth searched.
	 * @param categoryName
	 *            The category name searched.
	 * @returnThe paste configuration for the depth and the category name.
	 */
	protected IPasteConfiguration getPasteConfigurationsFor(final int depth, final String categoryName) {
		if (depth == 0 && !FillingConfigurationUtils.hasTreeFillingConfigurationForDepth(table, 0)) {
			AbstractHeaderAxisConfiguration conf = table.getLocalRowHeaderAxisConfiguration();
			if (conf != null) {
				conf = table.getTableConfiguration().getRowHeaderAxisConfiguration();
			}
			final List<TreeFillingConfiguration> filling = FillingConfigurationUtils.getAllTreeFillingConfigurationForDepth(table, depth);
			final List<IAxisConfiguration> referencedPasteConf = new ArrayList<IAxisConfiguration>();
			for (final TreeFillingConfiguration tmp : filling) {
				if (tmp.getPasteConfiguration() != null) {
					referencedPasteConf.add(tmp.getPasteConfiguration());
				}
			}
			for (final IAxisConfiguration axisConf : conf.getOwnedAxisConfigurations()) {
				if (axisConf instanceof IPasteConfiguration && !referencedPasteConf.contains(axisConf)) {
					return (IPasteConfiguration) axisConf;
				}
			}
		}
		for (final TreeFillingConfiguration curr : FillingConfigurationUtils.getAllTreeFillingConfiguration(table)) {
			if (curr.getDepth() == depth) {
				if (categoryName == null || categoryName.isEmpty()) {
					return curr.getPasteConfiguration();
				} else {
					String featureName = curr.getAxisUsedAsAxisProvider().getAlias();
					if (featureName == null || "".equals(featureName)) {
						final Object element = curr.getAxisUsedAsAxisProvider().getElement();
						// TODO : doesn't work for stereotype propertyes
						// TODO : use label provider
						if (element instanceof EStructuralFeature) {
							featureName = ((EStructuralFeature) element).getName();
						}
					}
					if (categoryName.equals(featureName)) {
						return curr.getPasteConfiguration();
					}

				}
			}
		}
		// TODO : verify category name
		return null;
	}

	/**
	 * Returns <code>true</code> if the configuration is in the detached mode, <code>false</code> otherwise.
	 * 
	 * @param table
	 *            The table.
	 * @return <code>true</code> if the configuration is in the detached mode, <code>false</code> otherwise.
	 */
	protected boolean isPasteInDetachedMode(final Table table) {
		final List<IPasteConfiguration> confs = getPasteConfigurationFor(0);
		for (final IPasteConfiguration current : confs) {
			if (current.isDetachedMode()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Initialize the fields of this class.
	 */
	private void init() {
		final boolean bool = isPasteInDetachedMode(this.table);
		final PasteEObjectConfiguration configuration = (PasteEObjectConfiguration) AxisConfigurationUtils.getIAxisConfigurationUsedInTable(this.table, NattableaxisconfigurationPackage.eINSTANCE.getPasteEObjectConfiguration(), false);
		this.secondAxis = tableManager.getColumnElementsList();
		if (configuration != null) {
			this.postActions = configuration.getPostActions();
			this.detachedMode = configuration.isDetachedMode();
		}
	}

	/**
	 * This allows to execute the paste from string command.
	 *
	 * @param useProgressMonitor
	 *            boolean indicating that we must do the paste with a progress monitor
	 * @return the result status
	 */
	public IStatus executePasteFromStringCommand(boolean useProgressMonitor, boolean openDialog) {
		IStatus resultStatus = Status.OK_STATUS;

		// if (this.pasteColumn) {// not yet supported
		// return;
		// }
		if (this.isDisposed) {
			throw new RuntimeException("The command provider is disposed"); //$NON-NLS-1$
		}
		final String pasteJobName;
		// if (this.pasteColumn) {
		// pasteJobName = PASTE_COLUMNS_JOB_NAME;
		// } else {
		pasteJobName = PASTE_ROWS_JOB_NAME;
		// }
		if (this.detachedMode) {
			executePasteFromStringCommandInDetachedMode(useProgressMonitor, pasteJobName);
		} else {
			executePasteFromStringCommandInAttachedMode(useProgressMonitor, pasteJobName);
		}

		return resultStatus;
	}


	/**
	 * This allows to execute the paste from String command in the detached mode.
	 * 
	 * @param useProgressMonitor
	 *            boolean indicating that we must do the paste with a progress monitor.
	 * @param pasteJobName
	 *            The name of the paste job.
	 */
	private void executePasteFromStringCommandInDetachedMode(final boolean useProgressMonitor, final String pasteJobName) {
		// the map used to share objects between the paste action and the cell value managers
		final Map<Object, Object> sharedMap = new HashMap<Object, Object>();
		// the map used to store useful information for the paste
		sharedMap.put(Constants.PASTED_ELEMENT_CONTAINER_KEY, tableContext);
		sharedMap.put(Constants.REFERENCES_TO_SET_KEY, new ArrayList<IValueSetter>());
		sharedMap.put(Constants.CELLS_TO_ADD_KEY, new ArrayList<Cell>());

		// used to be able to apply stereotypes required by columns properties, in detached mode even if there is no post actions defined in the table configuration
		// see bug 431691: [Table 2] Paste from Spreadsheet must be able to apply required stereotypes for column properties in all usecases
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=431691
		sharedMap.put(Constants.ADDITIONAL_POST_ACTIONS_TO_CONCLUDE_PASTE_KEY, new ArrayList<String>());

		if (!useProgressMonitor) {
			final ICommand pasteCommand = getPasteFromStringCommandInDetachedMode(contextEditingDomain, tableEditingDomain, new NullProgressMonitor(), sharedMap);
			try {
				CheckedOperationHistory.getInstance().execute(pasteCommand, new NullProgressMonitor(), null);
			} catch (final ExecutionException e) {
				Activator.log.error(e);
			} finally {
				sharedMap.clear();
				this.tableManager = null;
			}
		} else {
			// we create a job in order to don't freeze the UI
			final UIJob job = new UIJob(pasteJobName) {

				@Override
				public IStatus runInUIThread(final IProgressMonitor monitor) {

					final ICommand pasteCommand = getPasteFromStringCommandInDetachedMode(contextEditingDomain, tableEditingDomain, monitor, sharedMap);
					if (pasteCommand == null) {
						tableManager = null;
						return new Status(IStatus.CANCEL, Activator.PLUGIN_ID, PASTE_COMMAND_HAS_BEEN_CANCELLED);
					}
					// we execute the paste command
					if (pasteCommand.canExecute()) {
						try {
							int initialRowsSize = tableManager.getBodyLayerStack().getRowHideShowLayer().getRowCount();

							CheckedOperationHistory.getInstance().execute(pasteCommand, monitor, null);

							int finalRowsSize = tableManager.getBodyLayerStack().getRowHideShowLayer().getRowCount();

							final SelectionLayer selectionLayer = tableManager.getBodyLayerStack().getSelectionLayer();
							selectionLayer.doCommand(new SelectRowsCommand(selectionLayer, 0, initialRowsSize, false, false));
							selectionLayer.doCommand(new SelectRowsCommand(selectionLayer, 0, finalRowsSize, true, false));
						} catch (final ExecutionException e) {
							return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "An exception occured during the paste", e); //$NON-NLS-1$
						} finally {
							tableManager = null;
							sharedMap.clear();
						}

						monitor.done();
						return Status.OK_STATUS;
					} else {
						tableManager = null;
						sharedMap.clear();
						return new Status(IStatus.ERROR, Activator.PLUGIN_ID, PASTE_COMMAND_CANT_BE_EXECUTED);
					}
				}
			};
			job.setUser(true);
			job.schedule();
		}
	}

	/**
	 * This allows to execute the paste from String command in the attached mode.
	 *
	 * @param useProgressMonitor
	 *            boolean indicating that we must do the paste with a progress monitor
	 * @param pasteJobName
	 *            The name of the paste job.
	 */
	private void executePasteFromStringCommandInAttachedMode(final boolean useProgressMonitor, final String pasteJobName) {
		if (!useProgressMonitor) {
			final ICommand pasteCommand = getPasteFromStringCommandInAttachedMode(contextEditingDomain, tableEditingDomain, new NullProgressMonitor());
			try {
				CheckedOperationHistory.getInstance().execute(pasteCommand, new NullProgressMonitor(), null);
			} catch (final ExecutionException e) {
				Activator.log.error(e);
			} finally {
				this.tableManager = null;
			}
		} else {
			// we create a job in order to don't freeze the UI
			final UIJob job = new UIJob(pasteJobName) {

				@Override
				public IStatus runInUIThread(final IProgressMonitor monitor) {

					final ICommand pasteCommand = getPasteFromStringCommandInAttachedMode(contextEditingDomain, tableEditingDomain, monitor);
					if (pasteCommand == null) {
						tableManager = null;
						return new Status(IStatus.CANCEL, Activator.PLUGIN_ID, PASTE_COMMAND_HAS_BEEN_CANCELLED);
					}
					// we execute the paste command
					if (pasteCommand.canExecute()) {
						try {
							int initialRowsSize = tableManager.getBodyLayerStack().getRowHideShowLayer().getRowCount();

							final EMFCommandOperation op = new EMFCommandOperation(contextEditingDomain, new GMFtoEMFCommandWrapper(pasteCommand));
							// EMFOperationCommand c = new EMFOperationCommand(contextEditingDomain, pasteCommand);
							CheckedOperationHistory.getInstance().execute(op, monitor, null);

							int finalRowsSize = tableManager.getBodyLayerStack().getRowHideShowLayer().getRowCount();

							final SelectionLayer selectionLayer = tableManager.getBodyLayerStack().getSelectionLayer();
							selectionLayer.doCommand(new SelectRowsCommand(selectionLayer, 0, initialRowsSize, false, false));
							selectionLayer.doCommand(new SelectRowsCommand(selectionLayer, 0, finalRowsSize, true, false));
						} catch (final Exception e) {
							return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "An exception occured during the paste", e); //$NON-NLS-1$
						} finally {
							tableManager = null;
						}

						monitor.done();
						return Status.OK_STATUS;
					} else {
						tableManager = null;
						return new Status(IStatus.ERROR, Activator.PLUGIN_ID, PASTE_COMMAND_CANT_BE_EXECUTED);
					}
				}
			};
			job.setUser(true);
			job.schedule();
		}
	}

	/**
	 * Create the paste row from string command for the detached mode.
	 * 
	 * @param contextEditingDomain
	 *            The context editing domain.
	 * @param tableEditingDomain
	 *            The table editing domain.
	 * @param progressMonitor
	 *            The progress monitor.
	 * @param sharedMap
	 *            The shared map.
	 * @return The created command for the paste in detached mode.
	 */
	private ICommand getPasteRowFromStringInDetachedModeCommand(final TransactionalEditingDomain contextEditingDomain, final TransactionalEditingDomain tableEditingDomain, final IProgressMonitor progressMonitor, final Map<Object, Object> sharedMap) {
		// initialize the progress monitor
		if (null != progressMonitor) {
			progressMonitor.beginTask(PASTE_ACTION_TASK_NAME, this.nbOperationsToDo);
		}

		final boolean isSingleHeaderColumnTreeTable = TableHelper.isSingleColumnTreeTable(table);

		// 2.2 create the creation request and find the command provider
		final ICommand pasteAllCommand = new AbstractTransactionalCommand(contextEditingDomain, PASTE_COMMAND_NAME, null) {

			/**
			 *
			 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
			 *
			 * @param monitor
			 * @param info
			 * @return
			 * @throws ExecutionException
			 */
			@SuppressWarnings("unchecked")
			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				final List<IStatus> resultStatus = new ArrayList<IStatus>();

				long readChar = 0;
				long previousreadChar = 0;

				// this map stores the last created object to a depth.
				// its allows us to find easily the context to use for each created element
				final Map<Integer, EObject> contextMap = new HashMap<Integer, EObject>();
				contextMap.put(Integer.valueOf(-1), table.getContext());

				// 2. create a map with the last paste configuration used by depth
				final Map<Integer, PasteEObjectConfiguration> confMap = new HashMap<Integer, PasteEObjectConfiguration>();

				final RowIterator rowIter = parser.parse();
				int nbReadLine = 0;
				// Manage the rows paste
				while (rowIter.hasNext()) {
					final CellIterator cellIter = rowIter.next();
					nbReadLine++;
					if (!cellIter.hasNext()) {
						continue;// to avoid blank line
					}
					// Check if the progress monitor catch a cancel click
					if (null != progressMonitor && progressMonitor.isCanceled()) {
						progressMonitor.done();
						localDispose();
						return CommandResult.newCancelledCommandResult();
					}
					readChar = readChar + (parser.getReadCharacters() - previousreadChar);
					previousreadChar = parser.getReadCharacters();

					if (null != progressMonitor && readChar > refreshEachReadChar) {
						readChar = 0;
						progressMonitor.worked(refreshEachReadChar);
					}

					// the iterator on columns
					final Iterator<?> secondAxisIterator = secondAxis.iterator();

					// Manage the first column of the row
					while (cellIter.hasNext()) {
						String valueAsString = cellIter.next();
						int nbReadCell = 1;

						if (isSingleHeaderColumnTreeTable && !valueAsString.isEmpty()) {
							// If the table is a single header column, parse the value string to manage the correct depth
							// (manage each separator character as empty cell)
							while (INDENTATION_CHARACTER == valueAsString.charAt(0)) {
								nbReadCell++;
								valueAsString = valueAsString.substring(1);
							}
						} else {
							// test if the value is empty (we are in the tree header)
							while (cellIter.hasNext() && valueAsString.isEmpty()) {
								valueAsString = cellIter.next();
								nbReadCell++;
							}
							// Remove the whitespace on beginning
							if (isSingleHeaderColumnTreeTable && !valueAsString.isEmpty()) {
								while (INDENTATION_CHARACTER == valueAsString.charAt(0)) {
									valueAsString = valueAsString.substring(1);
								}
							}
						}

						final int depth = getDepth(nbReadCell);
						final boolean isCategory = isCategory(nbReadCell);

						if (isCategory) {
							confMap.put(Integer.valueOf(depth), (PasteEObjectConfiguration) getPasteConfigurationsFor(depth, valueAsString));
							// lastConfiguration = (PasteEObjectConfiguration) getPasteConfigurationsFor(depth, valueAsString);
							while (cellIter.hasNext()) {
								cellIter.next();
							}
							break;
						}

						// we get the paste configuration to use
						PasteEObjectConfiguration pasteConfToUse = confMap.get(Integer.valueOf(depth));
						if (null == pasteConfToUse) {
							pasteConfToUse = (PasteEObjectConfiguration) getPasteConfigurationsFor(depth, null);
							if (null != pasteConfToUse) {
								confMap.put(Integer.valueOf(depth), pasteConfToUse);
							} else {
								final IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, PasteSeverityCode.PASTE_ERROR__NO_PASTE_CONFIGURATION, NLS.bind("No paste configuration found for the depth {0}", depth), null);
								return new CommandResult(status);
							}
						}

						// get the element type to use to create the element
						final IElementType typeToCreate = ElementTypeRegistry.getInstance().getType(pasteConfToUse.getPastedElementId());

						// Get the class type to create and get its factory
						final EClass eClassToCreate = typeToCreate.getEClass();
						final EFactory eFactory = eClassToCreate.getEPackage().getEFactoryInstance();

						// get the element type to use to create the element
						final Object createdElement = eFactory.create(eClassToCreate);

						// 4. we use the label to do a set name command on the created element
						if (createdElement instanceof EObject) {
							final EObject eobject = (EObject) createdElement;

							// add the created element to the context map
							contextMap.put(Integer.valueOf(depth), (EObject) createdElement);

							// get the context to use
							final EObject context = contextMap.get(depth - 1);
							final EStructuralFeature containmentFeature = pasteConfToUse.getPasteElementContainementFeature();
							if (containmentFeature.isMany()) {
								((Collection<EObject>) context.eGet(containmentFeature)).add(eobject);
							} else {
								context.eSet(containmentFeature, createdElement);
							}

							// get the feature used as ID for the element
							final EStructuralFeature nameFeature = ((EObject) createdElement).eClass().getEStructuralFeature("name"); //$NON-NLS-1$
							if (nameFeature != null) {
								eobject.eSet(nameFeature, valueAsString);
							}
							// we add the created element to the table, only if its parent is the context of the table and if the table is filled by DnD
							if (!FillingConfigurationUtils.hasTreeFillingConfigurationForDepth(table, 0) && ((EObject) createdElement).eContainer() == tableContext) {
								final Command addCommand = tableManager.getAddRowElementCommand(Collections.singleton(createdElement));

								if (addCommand != null) {// can be null
									addCommand.execute();
									addCommand.dispose();
								}
							}
						}

						crossCellIteratorToFirstBodyCell(cellIter, nbReadCell);

						while (secondAxisIterator.hasNext() && cellIter.hasNext()) {
							// we must exit of the header part!
							valueAsString = cellIter.next();
							// Remove the whitespace on beginning
							if (isSingleHeaderColumnTreeTable && !valueAsString.isEmpty()) {
								while (INDENTATION_CHARACTER == valueAsString.charAt(0)) {
									valueAsString = valueAsString.substring(1);
								}
							}

							final Object currentAxis = secondAxisIterator.next();
							if (!valueAsString.isEmpty()) {
								final Object columnObject = currentAxis;
								final Object rowObject = createdElement;

								final boolean isEditable = CellManagerFactory.INSTANCE.isCellEditable(columnObject, rowObject, sharedMap);
								if (isEditable) {
									final AbstractStringValueConverter converter = CellManagerFactory.INSTANCE.getOrCreateStringValueConverterClass(columnObject, rowObject, tableManager, existingConverters, pasteHelper.getMultiValueSeparator());
									CellManagerFactory.INSTANCE.setStringValue(columnObject, rowObject, valueAsString, converter, tableManager, sharedMap);
								}
							}
						}

						int tooManyCellOnRow = 0;
						while (cellIter.hasNext()) {
							cellIter.next();// required
							tooManyCellOnRow++;
						}

						if (tooManyCellOnRow != 0) {
							final String message = NLS.bind("There are too many cells on the rows number {0}", nbReadLine); //$NON-NLS-1$
							final IStatus status = new Status(IStatus.WARNING, Activator.PLUGIN_ID, PasteSeverityCode.PASTE_WARNING__TOO_MANY_CELLS_ON_ROWS, message, null);
							resultStatus.add(status);
						}
					}
				}

				progressMonitor.done();
				localDispose();
				if (resultStatus.isEmpty()) {
					return CommandResult.newOKCommandResult();
				} else {
					final IStatus resultingStatus = new MultiStatus(Activator.PLUGIN_ID, IStatus.OK, resultStatus.toArray(new IStatus[resultStatus.size()]), "The paste has been done, but we found some problems", null);
					return new CommandResult(resultingStatus);
				}
			}
		};
		return pasteAllCommand;
	}

	/**
	 * Get the paste command for the detached mode.
	 *
	 * @param contextEditingDomain
	 *            The context editing domain.
	 * @param tableEditingDomain
	 *            The table editing domain.
	 * @param progressMonitor
	 *            The progress monitor used.
	 * @param sharedMap
	 *            a map used to share objects and informations during the paste between this class and the cell value manager
	 * @return
	 * 		the command to use to finish the paste (the main part of the paste is directly done here)
	 */
	private ICommand getPasteFromStringCommandInDetachedMode(final TransactionalEditingDomain contextEditingDomain, final TransactionalEditingDomain tableEditingDomain, final IProgressMonitor progressMonitor, final Map<Object, Object> sharedMap) {
		if (this.pasteColumn) {
			return new UnexecutableCommand(new Status(IStatus.ERROR, Activator.PLUGIN_ID, Messages.PasteEObjectTreeAxisInNatTableCommandProvider_CantPasteColumnsInTreeTable));
		} else {
			return getPasteRowFromStringInDetachedModeCommand(contextEditingDomain, tableEditingDomain, progressMonitor, sharedMap);
		}
	}


	//
	// /**
	// *
	// * @param commandCreationCancelProvider
	// * the creation command progress monitor
	// * @param commandExecutionProgressMonitor
	// * the command execution progress monitor
	// * @return
	// */
	// private ICommand getPasteColumnFromStringInAttachedModeCommand(final TransactionalEditingDomain contextEditingDomain, final TransactionalEditingDomain tableEditingDomain, final IProgressMonitor progressMonitor) {
	// // initialize the progress monitor
	// if (progressMonitor != null) {
	// progressMonitor.beginTask(PASTE_ACTION_TASK_NAME, this.nbOperationsToDo);
	// }
	//
	// // 2.2 create the creation request and find the command provider
	// final CreateElementRequest createRequest = new CreateElementRequest(contextEditingDomain, this.tableContext, this.typeToCreate, (EReference) this.containmentFeature);
	// final IElementEditService tableContextCommandProvider = ElementEditServiceUtils.getCommandProvider(tableContext);
	//
	// final ICommand pasteAllCommand = new AbstractTransactionalCommand(contextEditingDomain, PASTE_COMMAND_NAME, null) {
	//
	//
	// /**
	// *
	// * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	// *
	// * @param monitor
	// * @param info
	// * @return
	// * @throws ExecutionException
	// */
	// @Override
	// protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
	// long readChar = 0;
	// long previousreadChar = 0;
	//
	// final RowIterator rowIter = parser.parse();
	// int nbCreatedElements = 0;
	// while (rowIter.hasNext()) {
	// final CellIterator cellIter = rowIter.next();
	// if (!cellIter.hasNext()) {
	// continue;// to avoid blank line
	// }
	// if (progressMonitor != null && progressMonitor.isCanceled()) {
	// progressMonitor.done();
	// localDispose();
	// return CommandResult.newCancelledCommandResult();
	// }
	// readChar = readChar + (parser.getReadCharacters() - previousreadChar);
	// previousreadChar = parser.getReadCharacters();
	// if (progressMonitor != null && readChar > refreshEachReadChar) {
	// readChar = 0;
	// progressMonitor.subTask(NLS.bind("{0} {1} have been created.", new Object[] { typeToCreate.getEClass().getName(), nbCreatedElements })); //$NON-NLS-1$
	// progressMonitor.worked(refreshEachReadChar);
	// }
	// nbCreatedElements++;
	// final ICommand commandCreation = tableContextCommandProvider.getEditCommand(createRequest);
	// if (commandCreation.canExecute()) {
	// // 1. we create the element
	// commandCreation.execute(monitor, info);
	// // we execute the creation command
	//
	// // 2. we add it to the table
	// final CommandResult res = commandCreation.getCommandResult();
	// commandCreation.dispose();
	//
	// final Object createdElement = res.getReturnValue();
	// final Command addCommand;
	// if (pasteColumn) {
	// addCommand = tableManager.getAddColumnElementCommand(Collections.singleton(createdElement));
	// } else {
	// addCommand = tableManager.getAddRowElementCommand(Collections.singleton(createdElement));
	// }
	// if (addCommand != null) {// can be null
	// addCommand.execute();
	// addCommand.dispose();
	// }
	//
	// // 3. we set the values
	// final Iterator<?> secondAxisIterator = secondAxis.iterator();
	// while (secondAxisIterator.hasNext() && cellIter.hasNext()) {
	// final Object currentAxis = secondAxisIterator.next();
	// final String valueAsString = cellIter.next();
	// final Object columnObject;
	// final Object rowObject;
	// if (pasteColumn) {
	// columnObject = createdElement;
	// rowObject = currentAxis;
	// } else {
	// columnObject = currentAxis;
	// rowObject = createdElement;
	// }
	//
	//
	// boolean isEditable = CellManagerFactory.INSTANCE.isCellEditable(columnObject, rowObject);
	//
	// if (isEditable) {
	// final AbstractStringValueConverter converter = CellManagerFactory.INSTANCE.getOrCreateStringValueConverterClass(columnObject, rowObject, tableManager, existingConverters, pasteHelper.getMultiValueSeparator());
	// final Command setValueCommand = CellManagerFactory.INSTANCE.getSetStringValueCommand(contextEditingDomain, columnObject, rowObject, valueAsString, converter, tableManager);
	// if (setValueCommand != null && setValueCommand.canExecute()) {
	// setValueCommand.execute();
	// setValueCommand.dispose();
	// }
	// }
	// }
	// // TODO inform the user
	// while (cellIter.hasNext()) {
	// cellIter.next();// required
	// }
	// }
	// }
	// progressMonitor.done();
	// localDispose();
	// return CommandResult.newOKCommandResult();
	// }
	// };
	// return pasteAllCommand;
	// }

	/**
	 * Check if this is a category.
	 * 
	 * @param nbReadCell
	 *            The number of cells read.
	 * @return <code>true</code> if this is a category, <code>false</code> otherwise.
	 */
	private boolean isCategory(final int nbReadCell) {
		return PasteTreeUtils.isCategory(nbReadCell, FillingConfigurationUtils.getMaxDepthForTree(table), StyleUtils.getHiddenDepths(table), FillingConfigurationUtils.hasTreeFillingConfigurationForDepth(table, 0));
	}

	/**
	 * Get the depth corresponding to the number of cells read
	 * 
	 * @param nbReadCell
	 *            The number of cell read.
	 * @return The depth number.
	 */
	private int getDepth(final int nbReadCell) {
		return PasteTreeUtils.getDepth(nbReadCell, FillingConfigurationUtils.getMaxDepthForTree(table), StyleUtils.getHiddenDepths(table), FillingConfigurationUtils.hasTreeFillingConfigurationForDepth(table, 0));
	}

	/**
	 * 
	 * @param cellIter
	 *            The cellIterator
	 * @param nbReadCell
	 *            The number of cells read.
	 */
	protected void crossCellIteratorToFirstBodyCell(final CellIterator cellIter, int nbReadCell) {
		// If this is a single column header tree table, we don't need to do anything, only the first column is used for the header in the excel spearsheet
		if (!TableHelper.isSingleColumnTreeTable(table)) {
			int nbColumns = (FillingConfigurationUtils.getMaxDepthForTree(table) + 1) * 2;
			if (!FillingConfigurationUtils.hasTreeFillingConfigurationForDepth(table, 0)) {
				nbColumns--;
			}

			// exit of the header part
			final List<Integer> hiddenDepth = StyleUtils.getHiddenDepths(table);
			final int nbVisibleColumns = nbColumns - hiddenDepth.size();

			while (nbReadCell < nbVisibleColumns) {
				cellIter.next();
				nbReadCell++;
			}
		}

	}

	/**
	 *
	 *
	 * @param contextEditingDomain
	 *            The context editing domain.
	 * @param tableEditingDomain
	 *            The table editing domain.
	 * @param progressMonitor
	 *            The progress monitor.
	 * @return The paste command for the attached mode.
	 */
	private ICommand getPasteRowFromStringInAttachedModeCommand(final TransactionalEditingDomain contextEditingDomain, final TransactionalEditingDomain tableEditingDomain, final IProgressMonitor progressMonitor) {
		// initialize the progress monitor
		if (progressMonitor != null) {
			progressMonitor.beginTask(PASTE_ACTION_TASK_NAME, this.nbOperationsToDo);
		}

		final boolean isSingleHeaderColumnTreeTable = TableHelper.isSingleColumnTreeTable(table);

		// 2.2 create the creation request and find the command provider
		final ICommand pasteAllCommand = new AbstractTransactionalCommand(contextEditingDomain, PASTE_COMMAND_NAME, null) {

			/**
			 *
			 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
			 *
			 * @param monitor
			 * @param info
			 * @return
			 * @throws ExecutionException
			 */
			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				final List<IStatus> resultStatus = new ArrayList<IStatus>();

				long readChar = 0;
				long previousreadChar = 0;

				// this map stores the last created object to a depth.
				// its allows us to find easily the context to use for each created element
				final Map<Integer, EObject> contextMap = new HashMap<Integer, EObject>();
				contextMap.put(Integer.valueOf(-1), table.getContext());

				// 2. create a map with the last paste configuration used by depth
				final Map<Integer, PasteEObjectConfiguration> confMap = new HashMap<Integer, PasteEObjectConfiguration>();

				final RowIterator rowIter = parser.parse();
				int nbReadLine = 0;
				while (rowIter.hasNext()) {
					final CellIterator cellIter = rowIter.next();
					nbReadLine++;
					if (!cellIter.hasNext()) {
						continue;// to avoid blank line
					}
					if (progressMonitor != null && progressMonitor.isCanceled()) {
						progressMonitor.done();
						localDispose();
						return CommandResult.newCancelledCommandResult();
					}
					readChar = readChar + (parser.getReadCharacters() - previousreadChar);
					previousreadChar = parser.getReadCharacters();

					if (progressMonitor != null && readChar > refreshEachReadChar) {
						readChar = 0;
						// TODO : uncomment me, and move me, NPE on typeToCreate
						// progressMonitor.subTask(NLS.bind("{0} {1} have been created.", new Object[] { typeToCreate.getEClass().getName(), nbCreatedElements })); //$NON-NLS-1$
						progressMonitor.worked(refreshEachReadChar);
					}

					// the iterator on columns
					final Iterator<?> secondAxisIterator = secondAxis.iterator();


					while (cellIter.hasNext()) {
						String valueAsString = cellIter.next();
						int nbReadCell = 1;

						if (isSingleHeaderColumnTreeTable && !valueAsString.isEmpty()) {
							// If the table is a single header column, parse the value string to manage the correct depth
							// (manage each separator character as empty cell)
							while (INDENTATION_CHARACTER == valueAsString.charAt(0)) {
								nbReadCell++;
								valueAsString = valueAsString.substring(1);
							}
						} else {
							// test if the value is empty (we are in the tree header)
							while (cellIter.hasNext() && valueAsString.isEmpty()) {
								valueAsString = cellIter.next();
								nbReadCell++;
							}
							// Remove the whitespace on beginning
							if (isSingleHeaderColumnTreeTable && !valueAsString.isEmpty()) {
								while (INDENTATION_CHARACTER == valueAsString.charAt(0)) {
									valueAsString = valueAsString.substring(1);
								}
							}
						}

						int depth = -1;
						boolean isCategory = false;
						try {
							depth = getDepth(nbReadCell);
							isCategory = isCategory(nbReadCell);
						} catch (final UnsupportedOperationException ex) {
							final String message = NLS.bind("No defined depth for line {0}", nbReadCell); //$NON-NLS-1$
							// The following lines allows to cancel all the paste if a problem of depth appears
							// If a partial paste is authorized, remove this lines
							Activator.log.error(message, ex);
							final IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, PasteSeverityCode.PASTE_ERROR__MORE_LINES_THAN_DEPTH, message, null);
							return new CommandResult(status);
						}

						if (isCategory) {
							confMap.put(Integer.valueOf(depth), (PasteEObjectConfiguration) getPasteConfigurationsFor(depth, valueAsString));
							// lastConfiguration = (PasteEObjectConfiguration) getPasteConfigurationsFor(depth, valueAsString);
							while (cellIter.hasNext()) {
								cellIter.next();
							}
							break;
						}

						// we get the paste configuration to use
						PasteEObjectConfiguration pasteConfToUse = confMap.get(Integer.valueOf(depth));
						if (pasteConfToUse == null) {
							pasteConfToUse = (PasteEObjectConfiguration) getPasteConfigurationsFor(depth, null);
							if (pasteConfToUse != null) {
								confMap.put(Integer.valueOf(depth), pasteConfToUse);
							} else {
								final IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, PasteSeverityCode.PASTE_ERROR__NO_PASTE_CONFIGURATION, NLS.bind("No paste configuration found for the depth {0}", depth), null);
								return new CommandResult(status);
							}
						}
						// get the paste configuration to use

						// get the element type to use to create the element
						final IElementType typeToCreate = ElementTypeRegistry.getInstance().getType(pasteConfToUse.getPastedElementId());

						final EStructuralFeature containmentFeature = pasteConfToUse.getPasteElementContainementFeature();

						// get the context to use
						final EObject context = contextMap.get(depth - 1);
						final CreateElementRequest createRequest1 = new CreateElementRequest(contextEditingDomain, context, typeToCreate, (EReference) containmentFeature);
						final IElementEditService creationContextCommandProvider = ElementEditServiceUtils.getCommandProvider(context);

						final ICommand commandCreation = creationContextCommandProvider.getEditCommand(createRequest1);
						if (null != commandCreation && commandCreation.canExecute()) {

							// 1. we create the element
							commandCreation.execute(monitor, info);

							// 2. we get the result of the command
							final CommandResult res = commandCreation.getCommandResult();
							commandCreation.dispose();

							// 3 we update the map
							final Object createdElement = res.getReturnValue();
							contextMap.put(Integer.valueOf(depth), (EObject) createdElement);

							// 4. we use the label to do a set name command on the created element

							// TODO : this class should be in oep.infra.emf.nattable
							if (createdElement instanceof EObject) {
								// TODO : this past must be specific for EMF AND for UML
								final EObject eobject = (EObject) createdElement;
								// get the feature used as ID for the element
								final EStructuralFeature nameFeature = eobject.eClass().getEStructuralFeature("name"); //$NON-NLS-1$
								if (nameFeature != null) {
									final SetRequest setNameRequest = new SetRequest(contextEditingDomain, eobject, nameFeature, valueAsString);
									final IElementEditService createdElementCommandProvider = ElementEditServiceUtils.getCommandProvider(createdElement);
									if (createdElementCommandProvider != null) {
										final ICommand setName = createdElementCommandProvider.getEditCommand(setNameRequest);
										if (setName != null && setName.canExecute()) {
											setName.execute(monitor, info);
										}
									}
								}
								// we add the created element to the table, only if its parent is the context of the table and if the table is filled by DnD
								if (!FillingConfigurationUtils.hasTreeFillingConfigurationForDepth(table, 0) && ((EObject) createdElement).eContainer() == tableContext) {
									final Command addCommand = tableManager.getAddRowElementCommand(Collections.singleton(createdElement));

									if (addCommand != null) {// can be null
										addCommand.execute();
										addCommand.dispose();
									}
								}
							}


							crossCellIteratorToFirstBodyCell(cellIter, nbReadCell);

							while (secondAxisIterator.hasNext() && cellIter.hasNext()) {
								// we must exit of the header part!
								valueAsString = cellIter.next();
								// Remove the whitespace on beginning
								if (isSingleHeaderColumnTreeTable && !valueAsString.isEmpty()) {
									while (INDENTATION_CHARACTER == valueAsString.charAt(0)) {
										valueAsString = valueAsString.substring(1);
									}
								}

								final Object currentAxis = secondAxisIterator.next();
								// valueAsString = cellIter.next();
								final Object columnObject;
								final Object rowObject;
								// if (pasteColumn) {
								// columnObject = createdElement;
								// rowObject = currentAxis;
								// } else {
								columnObject = currentAxis;
								rowObject = createdElement;
								// }


								final boolean isEditable = CellManagerFactory.INSTANCE.isCellEditable(columnObject, rowObject);

								if (isEditable) {
									final AbstractStringValueConverter converter = CellManagerFactory.INSTANCE.getOrCreateStringValueConverterClass(columnObject, rowObject, tableManager, existingConverters, pasteHelper.getMultiValueSeparator());
									final Command setValueCommand = CellManagerFactory.INSTANCE.getSetStringValueCommand(contextEditingDomain, columnObject, rowObject, valueAsString, converter, tableManager);
									if (setValueCommand != null && setValueCommand.canExecute()) {
										try {
											setValueCommand.execute();
										} catch (final Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										setValueCommand.dispose();
									}
								}
							}

							int tooManyCellOnRow = 0;
							while (cellIter.hasNext()) {
								cellIter.next();// required
								tooManyCellOnRow++;
							}

							if (tooManyCellOnRow != 0) {
								final String message = NLS.bind("There are too many cells on the rows number {0}", nbReadLine);
								final IStatus status = new Status(IStatus.WARNING, Activator.PLUGIN_ID, PasteSeverityCode.PASTE_WARNING__TOO_MANY_CELLS_ON_ROWS, message, null);
								resultStatus.add(status);
							}
						}
					}
				}
				progressMonitor.done();
				localDispose();
				if (resultStatus.isEmpty()) {
					return CommandResult.newOKCommandResult();
				} else {
					final IStatus resultingStatus = new MultiStatus(Activator.PLUGIN_ID, IStatus.OK, resultStatus.toArray(new IStatus[resultStatus.size()]), "The paste has been done, but we found some problems", null);
					return new CommandResult(resultingStatus);
				}
			}
		};
		return pasteAllCommand;
	}

	/**
	 * Get the paste command for the attached mode.
	 *
	 * @param contextEditingDomain
	 *            The context editing domain
	 * @param tableEditingDomain
	 *            The table editing domain
	 * @param progressMonitor
	 *            The progress monitor
	 * @return the command to use to finish the paste (the main part of the paste is directly done here)
	 */
	private ICommand getPasteFromStringCommandInAttachedMode(final TransactionalEditingDomain contextEditingDomain, final TransactionalEditingDomain tableEditingDomain, final IProgressMonitor progressMonitor) {
		if (this.pasteColumn) {
			return new UnexecutableCommand(new Status(IStatus.ERROR, Activator.PLUGIN_ID, Messages.PasteEObjectTreeAxisInNatTableCommandProvider_CantPasteColumnsInTreeTable));
		} else {
			return getPasteRowFromStringInAttachedModeCommand(contextEditingDomain, tableEditingDomain, progressMonitor);
		}
	}

	/**
	 * Get the post actions.
	 * 
	 * @return
	 * 		the list of the post actions to do
	 */
	private Collection<String> getPostActions() {
		return this.postActions;
	}

	/**
	 * Dispose fields of the class
	 */
	private void localDispose() {
		this.isDisposed = true;
		for (final AbstractStringValueConverter current : existingConverters.values()) {
			current.dispose();
		}
		this.existingConverters.clear();
		try {
			this.reader.close();
		} catch (final IOException e) {
			Activator.log.error(e);
		}
	}
}
