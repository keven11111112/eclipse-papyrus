/*****************************************************************************
 * Copyright (c) 2010, 2015, 2017 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 422257
 *  Christian W. Damus - bug 482927
 *  Vincent Lorenzo (CEA LIST) - bug 520271 
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.generation.wizard;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.customization.properties.generation.Activator;
import org.eclipse.papyrus.customization.properties.generation.fieldselection.ContextElement;
import org.eclipse.papyrus.customization.properties.generation.fieldselection.FieldSelection;
import org.eclipse.papyrus.customization.properties.generation.fieldselection.PropertyDefinition;
import org.eclipse.papyrus.customization.properties.generation.generators.IGenerator;
import org.eclipse.papyrus.customization.properties.generation.layout.ILayoutGenerator;
import org.eclipse.papyrus.customization.properties.generation.messages.Messages;
import org.eclipse.papyrus.customization.properties.generation.wizard.widget.TernaryButton;
import org.eclipse.papyrus.infra.properties.contexts.Context;
import org.eclipse.papyrus.infra.properties.contexts.ContextsFactory;
import org.eclipse.papyrus.infra.properties.contexts.DataContextElement;
import org.eclipse.papyrus.infra.properties.contexts.Property;
import org.eclipse.papyrus.infra.properties.contexts.Section;
import org.eclipse.papyrus.infra.properties.contexts.Tab;
import org.eclipse.papyrus.infra.properties.contexts.View;
import org.eclipse.papyrus.infra.properties.ui.PropertyEditor;
import org.eclipse.papyrus.infra.properties.ui.UiFactory;
import org.eclipse.papyrus.infra.properties.ui.ValueAttribute;
import org.eclipse.papyrus.infra.properties.ui.runtime.IConfigurationManager;
import org.eclipse.papyrus.infra.properties.ui.runtime.PropertiesRuntime;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

/**
 * A Wizard for generating Property view contexts
 *
 * @author Camille Letavernier
 */
public class CreateContextWizard extends Wizard implements INewWizard {

	protected CreateContextMainPage mainPage;

	protected GeneratorPage generatorPage;

	protected SelectOutputPage selectOutputPage;

	// protected LayoutPage layout;

	protected SelectFieldsPage selectFieldsPage;

	/**
	 * The generated contexts
	 */
	protected List<Context> contexts;

	/**
	 * The IGenerator used to generate the context
	 */
	protected IGenerator generator;

	/**
	 * The ILayoutGenerator used to layout the context's sections
	 */
	protected ILayoutGenerator layoutGenerator;

	public CreateContextWizard() {
		setDefaultPageImageDescriptor(Activator.getDefault().getImageDescriptor("/icons/wizban-custom.png")); //$NON-NLS-1$
	}

	@Override
	public boolean performFinish() {
		if (generator == null || contexts == null || contexts.isEmpty() || layoutGenerator == null) {
			return false;
		}

		IConfigurationManager configManager = PropertiesRuntime.getConfigurationManager();

		for (Context context : contexts) {
			Tab defaultTab = ContextsFactory.eINSTANCE.createTab();
			defaultTab.setId(context.getName().toLowerCase());
			defaultTab.setLabel(context.getUserLabel());
			defaultTab.setPriority(100);
			context.getTabs().add(defaultTab);

			FieldSelection fieldSelection = selectFieldsPage.getFieldSelection();

			// URI contextURI = context.eResource().getURI();
			// Resource selectionResource = context.eResource().getResourceSet().createResource(URI.createURI(context.getName() + "FieldSelection.xmi").resolve(contextURI)); //$NON-NLS-1$
			// selectionResource.getContents().add(fieldSelection);
			// try {
			// selectionResource.save(null);
			// } catch (IOException ex) {
			// Activator.log.error("Couldn't persist the field selection model", ex); //$NON-NLS-1$
			// }

			layoutGenerator.setGenerator(generator);

			for (View view : context.getViews()) {
				if (view.getConstraints().size() == 0) {
					continue;
				}

				List<PropertyEditor> editors = new LinkedList<PropertyEditor>();
				// the list of properties for the current view
				final List<Property> properties = new ArrayList<Property>();
				for (DataContextElement element : getAllContextElements(view.getDatacontexts())) {
					for (Property property : element.getProperties()) {
						if (isSelected(fieldSelection, property, view.getElementMultiplicity() != 1)) {
							properties.add(property);
						}
					}
				}

				final List<Property> tmpProperties = new ArrayList<Property>(properties);
				for (Property p1 : tmpProperties) {
					//Bug 519090
					// we remove all redefined properties from the list
					properties.removeAll(p1.getRedefinedProperties());
				}

				// we create the editor
				for (Property property : properties) {
					PropertyEditor editor = UiFactory.eINSTANCE.createPropertyEditor();
					editor.setProperty(property);
					editor.setWidgetType(configManager.getDefaultEditorType(property));
					editors.add(editor);
					ValueAttribute input = UiFactory.eINSTANCE.createValueAttribute();
					input.setName("input"); //$NON-NLS-1$
					input.setValue("{Binding}"); //$NON-NLS-1$
					editor.getAttributes().add(input);
				}

				List<Section> generatedSections = layoutGenerator.layoutElements(editors, view);
				defaultTab.getSections().addAll(generatedSections);
				view.getSections().addAll(generatedSections);
				context.getViews().add(view);
			}

			int i = 1;
			for (Tab tab : context.getTabs()) {
				i += tab.getSections().size();
			}
			final int numberOfSections = i;
			try {
				setNeedsProgressMonitor(true);
				final Context currentContext = context;

				final Map<String, Object> saveOptions = new HashMap<String, Object>();
				saveOptions.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_RECORD);

				getContainer().run(true, true, new IRunnableWithProgress() {

					public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
						monitor.beginTask(Messages.CreateContextWizard_propertyViewGenerationJobName + currentContext.getUserLabel(), numberOfSections + 1);
						monitor.worked(1);

						try {
							currentContext.eResource().save(saveOptions);
							monitor.worked(1);
							for (Tab tab : currentContext.getTabs()) {
								for (Section section : tab.getSections()) {
									if (monitor.isCanceled()) {
										return;
									}
									section.getWidget().eResource().save(saveOptions);
									monitor.worked(1);
								}
							}
						} catch (IOException ex) {
							Activator.log.error(ex);
							return;
						}
						monitor.done();
					}

				});
			} catch (InvocationTargetException ex) {
				Activator.log.error(ex);
			} catch (InterruptedException ex) {
				Activator.log.error(ex);
			}

		}

		return true;
	}

	private boolean isSelected(FieldSelection fieldSelection, Property property, boolean multiple) {
		PropertyDefinition definition = getPropertyDefinition(fieldSelection, property);
		if (definition == null) {
			return false;
		}
		TernaryButton.State value = multiple ? definition.getValueMultiple() : definition.getValueSingle();
		switch (value) {
		case TRUE:
			return true;
		case FALSE:
			return false;
		case DEFAULT:
			return multiple ? generator.isSelectedMultiple(property) : generator.isSelectedSingle(property);
		}

		return false;
	}

	protected PropertyDefinition getPropertyDefinition(FieldSelection fieldSelection, Property property) {
		List<String> propertyPath = getPropertyPath(property.getContextElement());
		if (propertyPath.isEmpty()) {
			return null;
		}

		ContextElement currentElement = null;
		for (ContextElement contextRoot : fieldSelection.getContextElements()) {
			if (contextRoot.getName().equals(propertyPath.get(0))) {
				currentElement = contextRoot;
			}
		}

		propertyPath.remove(0);
		if (currentElement == null) {
			return null;
		}

		while (propertyPath.size() > 0) {
			String name = propertyPath.get(0);
			propertyPath.remove(0);
			currentElement = findByName(currentElement, name);
		}

		if (currentElement == null) {
			return null;
		}

		for (PropertyDefinition definition : currentElement.getProperties()) {
			if (definition.getName().equals(property.getName())) {
				return definition;
			}
		}

		return null;
	}

	protected ContextElement findByName(ContextElement source, String name) {
		for (ContextElement element : source.getElements()) {
			if (element.getName().equals(name)) {
				return element;
			}
		}
		return null;
	}

	protected List<String> getPropertyPath(DataContextElement element) {
		List<String> result;
		if (element.getPackage() == null) {
			result = new LinkedList<String>();
		} else {
			result = getPropertyPath(element.getPackage());
		}
		result.add(element.getName());
		return result;
	}

	private Set<DataContextElement> getAllContextElements(Collection<DataContextElement> source) {
		Set<DataContextElement> result = new HashSet<DataContextElement>();
		for (DataContextElement element : source) {
			getAllContextElements(element, result);
		}
		return result;
	}

	private void getAllContextElements(DataContextElement source, Set<DataContextElement> result) {
		if (result.contains(source)) {
			return;
		}

		result.add(source);
		for (DataContextElement element : source.getSupertypes()) {
			getAllContextElements(element, result);
		}
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		addPage(mainPage = new CreateContextMainPage());
		addPage(generatorPage = new GeneratorPage());
		addPage(selectOutputPage = new SelectOutputPage());
		addPage(selectFieldsPage = new SelectFieldsPage());
		// addPage(layout = new LayoutPage());

		setWindowTitle(Messages.CreateContextWizard_pageTitle);

	}

	protected void setGenerator(IGenerator generator) {
		this.generator = generator;
		generatorPage.setGenerator(generator);
		generatorPage.doBinding();
	}

	protected void setContexts(List<Context> contexts) {
		if (!contexts.isEmpty()) {
			this.contexts = contexts;
		}
	}

}
