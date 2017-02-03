/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and Implementation
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.paletteconfiguration.widgets.editors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.papyrus.infra.properties.ui.modelelement.DataSource;
import org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElement;
import org.eclipse.papyrus.infra.properties.ui.modelelement.ModelElement;
import org.eclipse.papyrus.infra.properties.ui.runtime.DisplayEngine;
import org.eclipse.papyrus.infra.properties.ui.runtime.PropertiesRuntime;
import org.eclipse.papyrus.infra.properties.ui.util.PropertiesDisplayHelper;
import org.eclipse.papyrus.infra.properties.ui.widgets.CustomizablePropertyEditor;
import org.eclipse.papyrus.infra.types.AbstractAdviceBindingConfiguration;
import org.eclipse.papyrus.infra.types.AdviceConfiguration;
import org.eclipse.papyrus.infra.types.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.types.ElementTypeSetConfiguration;
import org.eclipse.papyrus.infra.types.MetamodelTypeConfiguration;
import org.eclipse.papyrus.infra.types.SpecializationTypeConfiguration;
import org.eclipse.papyrus.infra.types.core.extensionpoints.IAdviceKindExtensionPoint;
import org.eclipse.papyrus.infra.types.core.factories.impl.AbstractAdviceBindingFactory;
import org.eclipse.papyrus.infra.types.core.factories.impl.MetamodelTypeFactory;
import org.eclipse.papyrus.infra.types.core.factories.impl.SpecializationTypeFactory;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.ElementDescriptor;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteRessourcesConstants;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.ToolConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.messages.Messages;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.provider.ToolConfigurationItemProvider;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.utils.CreatePaletteItemUtil;
import org.eclipse.papyrus.uml.types.core.advices.applystereotype.ApplyStereotypeAdviceConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.views.properties.PropertySheetPage;

/**
 * Palette Tool Actions Property Editor. It's permits to edit actions defined through element type associated resources which can be found on the same resource set.
 */
public class PaletteToolActionsPropertyEditor implements CustomizablePropertyEditor, SelectionListener {

	/** the main composite */
	private Composite self;

	/** the display engine for the integrated properties composite */
	private DisplayEngine displayEngine;

	/** ArrowDown icon path */
	private static final String ICON_ARROW_DOWN = "/icons/Down_12x12.gif";//$NON-NLS-1$

	/** ArrowUp icon path */
	private static final String ICON_ARROW_UP = "/icons/Up_12x12.gif";//$NON-NLS-1$

	/** Delete icon path */
	private static final String ICON_DELETE = "/icons/Delete_12x12.gif";//$NON-NLS-1$

	/** Add icon path */
	private static final String ICON_ADD = "/icons/Add_12x12.gif";//$NON-NLS-1$

	/** the input */
	private DataSource input;

	/** the property */
	private String property;

	/** if its read only */
	private boolean readOnly;

	/** the actions viewer */
	private TableViewer actionsViewer;

	/** the properties composite */
	private Composite propertiesComposite;

	/** the editing domain */
	private AdapterFactoryEditingDomain editingDomain;

	/** the tool configuration source */
	private ToolConfiguration toolSource;

	/** Adds action menu. */
	private Menu addActionsMenu;

	/** Buttons Map. */
	private Map<ToolbarButtonIds, Button> buttonsMap = new HashMap<ToolbarButtonIds, Button>();

	/** List of actions descriptor */
	private List<ActionDescriptor> actionsDesciptors = new ArrayList<ActionDescriptor>();

	/** Element type set configuration model for ui level. */
	private ElementTypeSetConfiguration elementTypeSetConfigurationUI;

	/** Element type set configuration model for semantic level. */
	private ElementTypeSetConfiguration elementTypeSetConfigurationSemantic;

	/** list of actions advice which have not to be show */
	protected List<String> blackListedAdvice = new ArrayList<>(Collections.singleton("Set type"));//$NON-NLS-1$

	/** enumeration of existing entry types */
	private enum ToolbarButtonIds {
		UP, DOWN, ADD, DELETE
	}

	/**
	 * Constructor.
	 */
	public PaletteToolActionsPropertyEditor(final Composite parent, final int style) {
		self = new Composite(parent, style);

		GridLayout layout = new GridLayout(2, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;

		self.setLayout(layout);
		{
			GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
			data.horizontalSpan = 1;
			self.setLayoutData(data);
		}

		createActionsPreviewGroup();
		createActionsPropertiesGroup();

		addDisposeListener(self);
	}

	/**
	 * Adds dispose listener on display engine.
	 */
	protected void addDisposeListener(final Control control) {
		control.addDisposeListener(new DisposeListener() {

			@Override
			public void widgetDisposed(final DisposeEvent e) {
				disposeDisplayEngine();
			}
		});
	}

	/**
	 * Dispose the display engine.
	 */
	protected void disposeDisplayEngine() {
		if (null != displayEngine) {
			displayEngine.dispose();
			displayEngine = null;
		}
	}

	/**
	 * create the properties group
	 */
	protected void createActionsPropertiesGroup() {
		Composite parent = getControl();
		propertiesComposite = new Composite(parent, SWT.NONE);
		parent.getParent().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		FillLayout layout = new FillLayout(SWT.VERTICAL);
		layout.marginHeight = -5;
		layout.marginWidth = -5;
		propertiesComposite.setLayout(layout);
		propertiesComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

	/**
	 * @return the control
	 */
	protected Composite getControl() {
		return self;
	}

	/**
	 * Creates the palette preview group.
	 */
	protected void createActionsPreviewGroup() {
		Composite parent = getControl();
		Composite actionsComposite = new Composite(parent, SWT.NONE);
		{
			GridLayout layout = new GridLayout(2, false);
			layout.horizontalSpacing = 0;
			layout.verticalSpacing = 0;
			layout.marginHeight = 0;
			layout.marginWidth = 5;
			actionsComposite.setLayout(layout);
			GridData data = new GridData(SWT.FILL, SWT.FILL, false, true);
			data.widthHint = 215;
			actionsComposite.setLayoutData(data);
		}

		Label label = new Label(actionsComposite, SWT.NONE);
		{
			label.setText(Messages.PaletteToolActionsPropertyEditor_AppliedActions);
			GridData data = new GridData(SWT.FILL, SWT.CENTER, false, false);
			label.setLayoutData(data);
		}

		Composite toolbar = new Composite(actionsComposite, SWT.NONE);
		{
			GridLayout layout = new GridLayout(4, true);
			layout.horizontalSpacing = 0;
			toolbar.setLayout(layout);
			toolbar.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, false, false));
			populateToolBar(toolbar);
		}

		Table table = new Table(actionsComposite, SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		Button addButton = buttonsMap.get(ToolbarButtonIds.ADD);
		if (null != addButton) {
			addActionsMenu = new Menu(addButton);
			populateActionsMenu();
		}

		actionsViewer = new TableViewer(table);
		actionsViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				handleActionsSelectionChanged(event);
			}
		});

		// Refresh
		handleActionsSelectionChanged(null);
	}

	/**
	 * Populate actions add {@link Menu} with {@link MenuItem}.
	 */
	@SuppressWarnings("unchecked")
	protected void populateActionsMenu() {
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(IAdviceKindExtensionPoint.EXTENSION_POINT_ID);
		for (IConfigurationElement configurationElement : elements) {

			try {
				Object factoryClass = configurationElement.createExecutableExtension(IAdviceKindExtensionPoint.FACTORY_CLASS);
				if (factoryClass instanceof AbstractAdviceBindingFactory) {
					String description = getAdviceDesciption(configurationElement);
					if (!blackListedAdvice.contains(description)) {
						Image icon = getAdviceIcon(configurationElement);
						Class<AdviceConfiguration> adviceInterface = (Class<AdviceConfiguration>) Class.forName(configurationElement.getAttribute(IAdviceKindExtensionPoint.CONFIGURATION_CLASS));
						actionsDesciptors.add(new ActionDescriptor(adviceInterface, icon, description));
						createMenuItem(icon, description, factoryClass);
					}
				}
			} catch (CoreException | ClassNotFoundException | InvalidRegistryObjectException e) {
				Activator.log.error(e);
			}
		}
	}

	/**
	 * Gets the icon {@link Image} of the advice from the {@link IConfigurationElement} {@link IAdviceKindExtensionPoint}.
	 * 
	 * @param configurationElement
	 *            The {@link IConfigurationElement}.
	 * @return The related Icon.
	 */
	protected Image getAdviceIcon(final IConfigurationElement configurationElement) {
		String iconPath = configurationElement.getAttribute(IAdviceKindExtensionPoint.ICON);
		Image icon = null;
		if (null != iconPath) {
			icon = Activator.getPluginIconImage(configurationElement.getContributor().getName(), iconPath);
		}
		return icon;
	}

	/**
	 * Gets the description of the advice from the {@link IConfigurationElement} {@link IAdviceKindExtensionPoint}.
	 * If there is no description a default description is generated from the advice name.
	 * 
	 * @param configurationElement
	 *            The {@link IConfigurationElement}.
	 * @return The related description as {@link String}.
	 */
	protected String getAdviceDesciption(final IConfigurationElement configurationElement) {

		String description = configurationElement.getAttribute(IAdviceKindExtensionPoint.DESCRIPTION);
		if (null == description || description.isEmpty()) {
			StringBuilder desc = new StringBuilder(configurationElement.getAttribute(IAdviceKindExtensionPoint.CONFIGURATION_CLASS));

			String newDesc = desc.substring(desc.lastIndexOf(".") + 1);//$NON-NLS-1$
			newDesc = newDesc.replace("AdviceConfiguration", "");//$NON-NLS-1$ //$NON-NLS-2$
			newDesc = newDesc.replaceAll(
					String.format("%s|%s|%s", //$NON-NLS-1$
							"(?<=[A-Z])(?=[A-Z][a-z])", //$NON-NLS-1$
							"(?<=[^A-Z])(?=[A-Z])", //$NON-NLS-1$
							"(?<=[A-Za-z])(?=[^A-Za-z])"), //$NON-NLS-1$
					" ");//$NON-NLS-1$

			newDesc = newDesc.toLowerCase();

			desc = new StringBuilder(newDesc);

			String firstChar = String.valueOf(newDesc.charAt(0)).toUpperCase();
			desc.replace(0, 1, firstChar);
			description = desc.toString();
		}
		return description;
	}

	/**
	 * Create {@link MenuItem} for actions menu.
	 * 
	 * @param image
	 *            the image to set.
	 * @param text
	 *            the text to set
	 * @param factory
	 *            the action id binded to the Menu item
	 */
	protected void createMenuItem(final Image image, final String text, final Object factory) {
		MenuItem stereotypeMenuItem = new MenuItem(addActionsMenu, SWT.NONE);
		stereotypeMenuItem.setText(text);
		stereotypeMenuItem.setImage(image);
		stereotypeMenuItem.setData(factory);
		stereotypeMenuItem.addSelectionListener(this);
	}

	/**
	 * Creates the Add/Remove controls, and the Up/Down controls.
	 * 
	 * @param toolbar
	 *            the parent tool bar composite
	 */
	protected void populateToolBar(final Composite toolbar) {
		createButton(toolbar, Activator.getPluginIconImage(org.eclipse.papyrus.infra.widgets.Activator.PLUGIN_ID, ICON_ARROW_UP), Messages.PaletteToolActionsPropertyEditor_UpAction, ToolbarButtonIds.UP);
		createButton(toolbar, Activator.getPluginIconImage(org.eclipse.papyrus.infra.widgets.Activator.PLUGIN_ID, ICON_ARROW_DOWN), Messages.PaletteToolActionsPropertyEditor_DownAction, ToolbarButtonIds.DOWN);
		createButton(toolbar, Activator.getPluginIconImage(org.eclipse.papyrus.infra.widgets.Activator.PLUGIN_ID, ICON_ADD), Messages.PaletteToolActionsPropertyEditor_AddAction, ToolbarButtonIds.ADD);
		createButton(toolbar, Activator.getPluginIconImage(org.eclipse.papyrus.infra.widgets.Activator.PLUGIN_ID, ICON_DELETE), Messages.PaletteToolActionsPropertyEditor_RemoveAction, ToolbarButtonIds.DELETE);
	}

	/**
	 * Create a button.
	 * 
	 * @param image
	 *            the image of the button
	 * @param toolTipText
	 *            the toolTipText
	 * @param action
	 */
	protected void createButton(final Composite parent, final Image image, final String toolTipText, final ToolbarButtonIds buttonId) {
		Button button = new Button(parent, SWT.PUSH);
		button.setImage(image);
		button.addSelectionListener(this);
		button.setToolTipText(toolTipText);
		button.setData(buttonId);
		buttonsMap.put(buttonId, button);
	}


	/**
	 * Selection listener handler for buttons.
	 * {@inheritDoc}
	 */
	@Override
	public void widgetSelected(final SelectionEvent event) {
		Command command = null;
		if (event.getSource() instanceof Button) {
			Button selectedButton = (Button) event.getSource();
			Object data = selectedButton.getData();
			if (data instanceof ToolbarButtonIds) {
				ToolbarButtonIds buttonId = (ToolbarButtonIds) data;
				switch (buttonId) {
				case UP:
					command = getUpActionCommand();
					break;
				case DOWN:
					command = getDownActionCommand();
					break;
				case ADD:
					if (null != addActionsMenu) {
						addActionsMenu.setVisible(true);
					}
					break;
				case DELETE:
					command = getDeleteActionCommand();
					// remove the properties view
					if (null != displayEngine) {
						displayEngine.removeSection(propertiesComposite);
					}
					break;

				default:
					break;
				}
			}
		} else if ((event.getSource() instanceof MenuItem)) {
			// Get command for the add actions
			MenuItem selectedItem = (MenuItem) event.getSource();
			Object data = selectedItem.getData();
			if (data instanceof AbstractAdviceBindingFactory) {
				command = getCreateActionCommand((AbstractAdviceBindingFactory<?>) data);
			}
		}

		// Check and execute command
		if (null != command && command.canExecute()) {
			editingDomain.getCommandStack().execute(command);
		}

		// Refresh actions viewer
		refresh();
	}

	/**
	 * Get the {@link Command} to create the specific Action from the advice return be {@link AbstractAdviceBindingFactory.createAdviceBindingConfiguration()}.
	 * 
	 * @param adviceFactory
	 *            The {@link AbstractAdviceBindingFactory} to create advice.
	 * @return The command to create action.
	 */
	protected Command getCreateActionCommand(final AbstractAdviceBindingFactory<?> adviceFactory) {
		Command command = null;

		// The target element type
		ElementTypeConfiguration semanticElementType = getSemanticElementTypeFromTool(toolSource);
		// The new Advice configuration
		AbstractAdviceBindingConfiguration newAdvice = null;
		newAdvice = adviceFactory.createAdviceBindingConfiguration();
		if (null != newAdvice) {
			newAdvice.setTarget(semanticElementType);
			// Set the identifier
			newAdvice.setIdentifier(CreatePaletteItemUtil.generateID(semanticElementType.getIdentifier()));
			command = new AddCommand(editingDomain, elementTypeSetConfigurationSemantic.getAdviceBindingsConfigurations(), newAdvice);
		}
		return command;
	}

	/**
	 * @return The delete action command on the selection in the actionsViewer.
	 */
	protected Command getDeleteActionCommand() {
		Command command = null;
		ISelection selection;
		selection = actionsViewer.getSelection();

		if (!selection.isEmpty() && selection instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) selection).getFirstElement();
			if (firstElement instanceof AbstractAdviceBindingConfiguration) {
				command = new RemoveCommand(editingDomain, elementTypeSetConfigurationSemantic.getAdviceBindingsConfigurations(), firstElement);
			}
		}
		return command;
	}

	/**
	 * @return The down action command on the selection in the actionsViewer.
	 */
	protected Command getDownActionCommand() {
		Command command = null;
		ISelection selection;
		selection = actionsViewer.getSelection();
		if (!selection.isEmpty() && selection instanceof StructuredSelection) {
			Object actionToMove = ((StructuredSelection) selection).getFirstElement();

			EList<AbstractAdviceBindingConfiguration> adviceBindingsConfigurations = elementTypeSetConfigurationSemantic.getAdviceBindingsConfigurations();

			List<Object> elements = Arrays.asList(((IStructuredContentProvider) actionsViewer.getContentProvider()).getElements(toolSource));

			int indexInActionsList = elements.indexOf(actionToMove);
			if (elements.size() - 1 > indexInActionsList) {
				Object actionToReplace = elements.get(indexInActionsList + 1);
				int targetIndex = adviceBindingsConfigurations.indexOf(actionToReplace);
				command = new MoveCommand(editingDomain, adviceBindingsConfigurations, actionToMove, targetIndex);
			}
		}
		return command;
	}

	/**
	 * @return The up action command on the selection in the actionsViewer.
	 */
	protected Command getUpActionCommand() {
		Command command = null;
		ISelection selection;
		selection = actionsViewer.getSelection();
		if (!selection.isEmpty() && selection instanceof StructuredSelection) {
			Object actionToMove = ((StructuredSelection) selection).getFirstElement();

			EList<AbstractAdviceBindingConfiguration> adviceBindingsConfigurations = elementTypeSetConfigurationSemantic.getAdviceBindingsConfigurations();

			List<Object> elements = Arrays.asList(((IStructuredContentProvider) actionsViewer.getContentProvider()).getElements(toolSource));

			int indexInActionsList = elements.indexOf(actionToMove);
			if (0 < indexInActionsList) {
				Object actionToReplace = elements.get(indexInActionsList - 1);
				int targetIndex = adviceBindingsConfigurations.indexOf(actionToReplace);
				command = new MoveCommand(editingDomain, adviceBindingsConfigurations, actionToMove, targetIndex);
			}
		}
		return command;
	}

	/**
	 * Gets the {@link ElementTypeConfiguration} related to the {@link ToolConfigurationItemProvider} tool in the semantic {@link ElementTypeSetConfiguration} model.
	 * 
	 * @param tool
	 *            The selected {@link ToolConfigurationItemProvider}.
	 */
	protected ElementTypeConfiguration getSemanticElementTypeFromTool(final ToolConfiguration tool) {
		EList<ElementDescriptor> elementDescriptors = tool.getElementDescriptors();
		ElementTypeConfiguration elementTypeFound = null;

		if (!elementDescriptors.isEmpty()) {
			if (null != elementTypeSetConfigurationUI && null != elementTypeSetConfigurationSemantic) {
				ElementDescriptor elementDescriptor = elementDescriptors.get(0);

				// The element type id we are looking for on the UI Model
				String elementTypeId = elementDescriptor.getElementTypeId();

				// Search it in semantic model
				List<ElementTypeConfiguration> semanticElementTypes = new ArrayList<ElementTypeConfiguration>();

				Iterator<ElementTypeConfiguration> elementTypeConfigurations = elementTypeSetConfigurationUI.getElementTypeConfigurations().iterator();
				while (semanticElementTypes.isEmpty() && elementTypeConfigurations.hasNext()) {
					ElementTypeConfiguration elementTypeConfiguration = elementTypeConfigurations.next();
					// found it
					if (elementTypeId.equals(elementTypeConfiguration.getIdentifier())) {
						if (elementTypeConfiguration instanceof SpecializationTypeConfiguration) {
							semanticElementTypes = ((SpecializationTypeConfiguration) elementTypeConfiguration).getSpecializedTypes();
						}
					}
				}

				// The element type ids we are looking for on the Semantic Model
				Iterator<ElementTypeConfiguration> semanticElementTypesIterator = semanticElementTypes.iterator();
				while (null == elementTypeFound && semanticElementTypesIterator.hasNext()) {
					ElementTypeConfiguration semanticElementType = semanticElementTypesIterator.next();
					Iterator<ElementTypeConfiguration> elementTypeSemConfigurations = elementTypeSetConfigurationSemantic.getElementTypeConfigurations().iterator();
					while (null == elementTypeFound && elementTypeSemConfigurations.hasNext()) {
						ElementTypeConfiguration elementTypeConfiguration = elementTypeSemConfigurations.next();
						if (semanticElementType.equals(elementTypeConfiguration)) {
							elementTypeFound = elementTypeConfiguration;
						}
					}
				}
			}
		}
		return elementTypeFound;
	}

	/**
	 * Initialize the actions viewer.
	 */
	protected void initActionsViewer() {
		actionsViewer.setContentProvider(new ActionsContentProvider());
		actionsViewer.setLabelProvider(new ActionsLabelProvider());
		actionsViewer.setInput(toolSource);
		refresh();
	}

	/**
	 * Label provider for Actions of a {@link ToolConfiguration} as input. Can be {@link ApplyStereotypeAdviceConfiguration} or
	 */
	private class ActionsLabelProvider extends LabelProvider {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Image getImage(final Object element) {
			Image image = null;

			for (ActionDescriptor actionDescriptor : actionsDesciptors) {
				if (actionDescriptor.getAdvice().isInstance(element)) {
					image = actionDescriptor.getImage();
				}
			}
			return image;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getText(final Object element) {
			String text = Messages.PaletteToolActionsPropertyEditor_invalidAdvice;

			for (ActionDescriptor actionDescriptor : actionsDesciptors) {
				if (actionDescriptor.getAdvice().isInstance(element)) {
					text = actionDescriptor.getDescription();
				}
			}
			return text;
		}
	}

	/**
	 * Content provider for Actions of a {@link ToolConfiguration} as input. Can be {@link ApplyStereotypeAdviceConfiguration} or
	 */
	private class ActionsContentProvider implements IStructuredContentProvider {

		/**
		 * The key for source uml element put into the map options of the reslurce set.
		 */
		private static final String SOURCE_ECLASS = "sourceEClass";//$NON-NLS-1$


		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object[] getElements(final Object inputElement) {

			List<AbstractAdviceBindingConfiguration> actions = new ArrayList<AbstractAdviceBindingConfiguration>();

			// If there is element descriptors in selected tool configuration
			if (!toolSource.getElementDescriptors().isEmpty() && null != elementTypeSetConfigurationSemantic && null != elementTypeSetConfigurationUI) {
				String elementTypeId_UI = toolSource.getElementDescriptors().get(0).getElementTypeId();

				// get the element type of element descriptor on the UI element type model
				List<ElementTypeConfiguration> elementTypes = elementTypeSetConfigurationUI.getElementTypeConfigurations().stream().filter(p -> p.getIdentifier().equals(elementTypeId_UI)).collect(Collectors.toList());
				if (!elementTypes.isEmpty()) {
					// The first is enough
					if (elementTypes.get(0) instanceof SpecializationTypeConfiguration) {

						// Gets specialized types
						EList<ElementTypeConfiguration> elementTypesSem = ((SpecializationTypeConfiguration) elementTypes.get(0)).getSpecializedTypes();

						// for each gets advice configuration
						for (ElementTypeConfiguration elementTypeConfiguration : elementTypesSem) {
							IHintedType createElementType = null;
							if (elementTypeConfiguration instanceof SpecializationTypeConfiguration) {
								createElementType = new SpecializationTypeFactory().createElementType((SpecializationTypeConfiguration) elementTypeConfiguration);
							} else if (elementTypeConfiguration instanceof MetamodelTypeConfiguration) {
								createElementType = new MetamodelTypeFactory().createElementType((MetamodelTypeConfiguration) elementTypeConfiguration);
							}

							editingDomain.getResourceSet().getLoadOptions().put(SOURCE_ECLASS, createElementType.getEClass());
							actions.addAll(elementTypeSetConfigurationSemantic.getAdviceBindingsConfigurations().stream().filter(p -> null != p.getTarget() && p.getTarget().equals(elementTypeConfiguration)).collect(Collectors.toList()));
						}
					}
				}
			}
			return actions.toArray();
		}

	};

	/**
	 * handle the selection change event for the palette preview
	 *
	 * @param event
	 *            the event that is thrown by the palette viewer
	 */
	protected void handleActionsSelectionChanged(final SelectionChangedEvent event) {
		// Refresh Properties view
		if (null != event) {
			// retrieve current selection
			ISelection selection = event.getSelection();
			if (selection instanceof IStructuredSelection) {
				Object firstSelected = ((IStructuredSelection) selection).getFirstElement();

				if (null != firstSelected) {
					for (Control control : propertiesComposite.getChildren()) {
						control.dispose();
					}
					if (!PropertiesRuntime.getConstraintEngine().getDisplayUnits(firstSelected).isEmpty()) {
						displayEngine = PropertiesDisplayHelper.display(firstSelected, propertiesComposite);
					} else {
						PropertySheetPage propertySheetPage = new ExtendedPropertySheetPage(editingDomain);
						propertySheetPage.setPropertySourceProvider(new AdapterFactoryContentProvider(editingDomain.getAdapterFactory()));
						propertySheetPage.createControl(propertiesComposite);
						propertySheetPage.selectionChanged(null, selection);
					}
					propertiesComposite.layout();
				}
			}
		}

		// Refresh buttons
		refreshButtons();
	}

	/**
	 * Refresh the buttons.
	 */
	protected void refreshButtons() {
		if (!readOnly) {
			buttonsMap.get(ToolbarButtonIds.UP).setEnabled(null != getUpActionCommand());
			buttonsMap.get(ToolbarButtonIds.DOWN).setEnabled(null != getDownActionCommand());
			buttonsMap.get(ToolbarButtonIds.DELETE).setEnabled(null != getDeleteActionCommand());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DataSource getInput() {
		return input;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setInput(final DataSource input) {
		this.input = input;
		initialize();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getProperty() {
		return property;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setProperty(final String property) {
		this.property = property;
		initialize();
	}

	/**
	 * initialize domain and related models
	 */
	protected void initialize() {
		if (null != property && null != input) {
			ModelElement modelElement = input.getModelElement(property);
			if (modelElement instanceof EMFModelElement) {
				setEditingDomain((AdapterFactoryEditingDomain) ((EMFModelElement) modelElement).getDomain());
				setElementTypeModels();
				setToolSource(modelElement);
				initActionsViewer();
			}
		}
	}

	/**
	 * Set the toolSource field.
	 * 
	 * @param modelElement
	 *            The {@link ModelElement}.
	 */
	protected void setToolSource(final ModelElement modelElement) {
		if (((EMFModelElement) modelElement).getSource() instanceof ToolConfiguration) {
			toolSource = (ToolConfiguration) ((EMFModelElement) modelElement).getSource();
		}
	}

	/**
	 * Set semantic and UI element types models.
	 */
	protected void setElementTypeModels() {
		// Look for element types Models on the resource set
		Object UIRessource = editingDomain.getResourceSet().getLoadOptions().get(PaletteRessourcesConstants.ELEMENTTYPE_UI_RESSOURCE_IDENTIFIER);
		Object SemanticRessource = editingDomain.getResourceSet().getLoadOptions().get(PaletteRessourcesConstants.ELEMENTTYPE_SEMENTIC_RESSOURCE_IDENTIFIER);

		EObject UIModel = null;
		if (UIRessource instanceof Resource && !((Resource) UIRessource).getContents().isEmpty()) {
			UIModel = ((Resource) UIRessource).getContents().get(0);
		}
		EObject SemanticModel = null;
		if (SemanticRessource instanceof Resource && !((Resource) SemanticRessource).getContents().isEmpty()) {
			SemanticModel = ((Resource) SemanticRessource).getContents().get(0);
		}

		if (SemanticModel instanceof ElementTypeSetConfiguration && UIModel instanceof ElementTypeSetConfiguration) {
			elementTypeSetConfigurationUI = (ElementTypeSetConfiguration) UIModel;
			elementTypeSetConfigurationSemantic = (ElementTypeSetConfiguration) SemanticModel;
			setReadOnly(false);
		} else {
			setReadOnly(true);
		}
	}

	/**
	 * Set the editing domain.
	 */
	public void setEditingDomain(final AdapterFactoryEditingDomain editingDomain) {
		if (null != editingDomain) {
			this.editingDomain = editingDomain;
		}
	}

	/**
	 * @return The editing domain.
	 */
	public EditingDomain getDomain() {
		return editingDomain;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean getShowLabel() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setShowLabel(final boolean showLabel) {
		// Do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCustomLabel() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setCustomLabel(final String customLabel) {
		// Do nothing
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setReadOnly(final boolean readOnly) {
		if (readOnly != this.readOnly) {
			buttonsMap.values().stream().forEach(button -> button.setEnabled(!readOnly));
		}
		this.readOnly = readOnly;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean getReadOnly() {
		return readOnly;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// Do nothing
	}

	/**
	 * Refresh the actions viewer and the buttons.
	 */
	public void refresh() {
		actionsViewer.refresh();
		refreshButtons();
	}

}
