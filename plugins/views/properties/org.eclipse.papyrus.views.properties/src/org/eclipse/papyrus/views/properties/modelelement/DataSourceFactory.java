/*****************************************************************************
 * Copyright (c) 2010, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 435103
 *  Christian W. Damus (CEA) - bug 417409
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.modelelement;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.constraints.ConstraintDescriptor;
import org.eclipse.papyrus.infra.constraints.constraints.Constraint;
import org.eclipse.papyrus.infra.constraints.runtime.ConstraintFactory;
import org.eclipse.papyrus.infra.tools.util.ClassLoaderHelper;
import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.contexts.DataContextRoot;
import org.eclipse.papyrus.views.properties.contexts.ModelElementFactorySubstitution;
import org.eclipse.papyrus.views.properties.contexts.Substitution;
import org.eclipse.papyrus.views.properties.contexts.View;
import org.eclipse.papyrus.views.properties.environment.ModelElementFactoryDescriptor;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.views.properties.util.PropertiesUtil;
import org.eclipse.papyrus.views.properties.xwt.XWTSection;

/**
 * A Factory to build and populate DataSource with the right ModelElements
 *
 * @author Camille Letavernier
 */
public class DataSourceFactory {

	/**
	 * Singleton instance for DataSourceFactory
	 */
	public static DataSourceFactory instance = new DataSourceFactory();

	/**
	 * Creates a new DataSource from a selection and a view.
	 *
	 * @param selection
	 *            The selection of Objects
	 * @param view
	 *            The view to display
	 * @return The DataSource that can be passed to the DisplayEngine to display
	 *         the view
	 */
	public DataSource createDataSourceFromSelection(IStructuredSelection selection, View view) {
		SelectionEntry selectionEntry = new SelectionEntry(selection, view);

		if (!sources.containsKey(selectionEntry)) {
			DataSource source = new DataSource(view, selection);
			sources.put(selectionEntry, source);
		}

		return sources.get(selectionEntry);
	}

	public void removeFromCache(IStructuredSelection selection, View view) {
		if (selection == null || view == null) {
			return;
		}

		SelectionEntry entry = new SelectionEntry(selection, view);
		sources.remove(entry);
	}

	/**
	 * Returns the ModelElement corresponding to the given propertyPath and
	 * DataSource
	 *
	 * @param source
	 *            The DataSource used to retrieved informations such as the View
	 *            and the Selection
	 * @param propertyPath
	 *            The path describing the property for which we want a
	 *            ModelElement
	 * @return The matching modelElement
	 */
	public ModelElement getModelElementFromPropertyPath(DataSource source, String propertyPath) {
		String key = propertyPath.substring(0, propertyPath.lastIndexOf(":")); //$NON-NLS-1$
		for (Context context : PropertiesUtil.getDependencies(source.getView().getContext())) {
			DataContextElement element = PropertiesUtil.getContextElementByQualifiedName(key, context.getDataContexts());
			if (element != null) {
				ModelElement modelElement = DataSourceFactory.instance.createModelElement(element, source);
				if (modelElement != null) {
					modelElement.setDataSource(source);
				}
				return modelElement;
			}
		}
		return null;
	}

	/**
	 * Creates a ModelElement from the given DataContextElement and Selection.
	 *
	 * @param contextElement
	 *            The contextElement for which we are creating a ModelElement
	 * @param selection
	 *            The list of objects currently selected
	 * @return The model element corresponding to the given contextElement and
	 *         selection
	 */
	private ModelElement createModelElement(final DataContextElement contextElement, final DataSource dataSource) {
		IStructuredSelection selection = dataSource.getSelection();
		if (selection.size() == 1) { // Single Selection
			ModelElement modelElement = createFromSource(selection.getFirstElement(), contextElement, dataSource);
			return modelElement;
		} else { // MultiSelection
			// Bind the context element in a factory for the composite to create sub-elements
			CompositeModelElement composite = new CompositeModelElement(new CompositeModelElement.BoundModelElementFactory() {

				@Override
				public ModelElement createModelElement(Object sourceElement) {
					return createFromSource(sourceElement, contextElement, dataSource);
				}
			});

			Iterator<?> it = selection.iterator();
			while (it.hasNext()) {
				ModelElement element = createFromSource(it.next(), contextElement, dataSource);
				if (element != null) {
					composite.addModelElement(element);
				}
			}

			return composite;
		}
	}

	/**
	 * Retrieves the ModelElementFactory for the given DataContextElement. The
	 * ModelElementFactory is declared by the DataContextRoot owning the given
	 * DataContextElement
	 *
	 * @param context
	 *            The DataContextElement for which we want to retrieve the
	 *            ModelElementFactory
	 * @return The ModelElementFactory corresponding to the given
	 *         DataContextElement
	 */
	private ModelElementFactory getFactory(DataContextElement context, DataSource dataSource) {

		DataContextRoot rootPackage = getRootPackage(context);
		ModelElementFactoryDescriptor factoryDescriptor = rootPackage.getModelElementFactory();

		if (factoryDescriptor == null) {
			Activator.log.warn("No ModelElementFactory is attached to DataContextElement " + getQualifiedName(context)); //$NON-NLS-1$
			return null;
		}
		if (factoryDescriptor.eIsProxy()) {
			Activator.log.warn("Unresolved reference to the ModelElementFactory: " + EcoreUtil.getURI(factoryDescriptor)); //$NON-NLS-1$
			return null;
		}

		factoryDescriptor = getFactorySubstitution(factoryDescriptor, dataSource);

		String factoryName = factoryDescriptor.getFactoryClass();
		ModelElementFactory factory = ClassLoaderHelper.newInstance(factoryName, ModelElementFactory.class);

		return factory;
	}

	/**
	 * Returns a substitute ModelElementFactoryDescriptor if one is enabled. Returns the parameter as-is otherwise
	 *
	 * @param factory
	 * @return
	 */
	private ModelElementFactoryDescriptor getFactorySubstitution(ModelElementFactoryDescriptor factory, DataSource dataSource) {
		return getFactorySubstitution(factory, dataSource, new HashSet<ModelElementFactoryDescriptor>());
	}

	/**
	 * Returns a substitute ModelElementFactoryDescriptor if one is enabled. Returns the parameter as-is otherwise
	 *
	 * @param factory
	 * @return
	 */
	private ModelElementFactoryDescriptor getFactorySubstitution(ModelElementFactoryDescriptor factory, DataSource dataSource, Set<ModelElementFactoryDescriptor> browsedDescriptors) {
		if (browsedDescriptors.contains(factory)) {
			Activator.log.warn("Cycle detected in ModelElementFactory descriptors");
			return factory;
		}

		browsedDescriptors.add(factory);

		for (Context configuration : ConfigurationManager.getInstance().getEnabledContexts()) {
			for (Substitution substitution : configuration.getSubstitution()) {
				if (substitution instanceof ModelElementFactorySubstitution) {
					ModelElementFactorySubstitution factorySubstitution = (ModelElementFactorySubstitution) substitution;
					if (factorySubstitution.getSourceFactoryType() == factory) {
						if (factorySubstitution.getTargetFactoryType() == null) {
							Activator.log.warn("Invalid ModelElementFactorySubstitution: target factory is undefined");
							continue;
						}
						if (factorySubstitution.getTargetFactoryType().eIsProxy()) {
							Activator.log.warn("Invalid ModelElementFactorySubstitution: target factory is unresolved: " + EcoreUtil.getURI(factorySubstitution));
							continue;
						}

						if (isEnabled(factorySubstitution, dataSource)) {
							return getFactorySubstitution(factorySubstitution.getTargetFactoryType(), dataSource, browsedDescriptors);
						}
					}
				}
			}
		}

		return factory;
	}

	private boolean isEnabled(Substitution substitution, DataSource dataSource) {
		if (substitution.getConstraints().isEmpty()) {
			return true;
		}

		IStructuredSelection selection = dataSource.getSelection();

		for (Constraint constraint : parseConstraints(substitution)) {
			if (constraint.match(selection)) {
				return true;
			}
		}
		return false;
	}

	private List<Constraint> parseConstraints(Substitution substitution) {
		List<Constraint> result = new LinkedList<Constraint>();
		for (ConstraintDescriptor descriptor : substitution.getConstraints()) {
			result.add(ConstraintFactory.getInstance().createFromModel(descriptor));
		}
		return result;
	}

	private ModelElement createFromSource(Object selectedElement, DataContextElement context, DataSource dataSource) {
		ModelElementFactory factory = getFactory(context, dataSource);

		if (factory == null) {
			return null;
		}

		return factory.createFromSource(selectedElement, context);
	}

	private DataContextRoot getRootPackage(DataContextElement context) {
		if (context.getPackage() == null) {
			return (DataContextRoot) context;
		}
		return getRootPackage(context.getPackage());
	}

	private String getQualifiedName(DataContextElement context) {
		if (context.getPackage() == null) {
			return context.getName();
		}
		return getQualifiedName(context.getPackage()) + ":" + context.getName(); //$NON-NLS-1$
	}

	/**
	 * Singleton Constructor.
	 */
	private DataSourceFactory() {

	}

	private class SelectionEntry {

		private IStructuredSelection selection;

		private View view;

		public SelectionEntry(IStructuredSelection selection, View view) {
			if (selection == null) {
				throw new IllegalArgumentException("The selection must not be null");
			}
			if (view == null) {
				throw new IllegalArgumentException("The view must not be null");
			}
			this.selection = selection;
			this.view = view;
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof SelectionEntry)) {
				return false;
			}

			SelectionEntry other = (SelectionEntry) obj;
			return other.view.equals(view) && selection.equals(other.selection);
		}

		@Override
		public int hashCode() {
			return selection.hashCode() + view.hashCode();
		}
	}

	/**
	 * More than one {@link XWTSection} may share the same DataSource.
	 * They all need to listen on the same source, so that they can correctly
	 * refresh themselves. We maintain a cache for each Selection/View pair.
	 *
	 * The cache is cleaned when the sections are disposed.
	 */
	// TODO : More than one view can be displayed at the same time. The cache should only
	// rely on a selection ; not on a selection-view pair.
	// We may use a (ISelection, Context) key : the DataSource must be associated to a single context
	private Map<SelectionEntry, DataSource> sources = new HashMap<SelectionEntry, DataSource>();
}
