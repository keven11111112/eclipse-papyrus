/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Vincent LORENZO (CEA-LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.properties.providers;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.papyrus.infra.architecture.ArchitectureDescriptionUtils;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureContext;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.nattable.manager.cell.CellManagerFactory;
import org.eclipse.papyrus.infra.nattable.manager.cell.IGenericMatrixRelationshipCellManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.types.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.types.ElementTypeSetConfiguration;
import org.eclipse.papyrus.infra.types.MetamodelTypeConfiguration;
import org.eclipse.papyrus.infra.types.SpecializationTypeConfiguration;
import org.eclipse.papyrus.infra.widgets.providers.IGraphicalContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.swt.widgets.Composite;

/**
 * The content provider used by Generic Matrix to choose relationship element type
 */
public final class GenericRelationshipMatrixElementTypeContentProvider implements IStaticContentProvider, IGraphicalContentProvider, IHierarchicContentProvider, ITreeContentProvider, IContentProvider {

	/**
	 * The architecture context which allows to get all available element types
	 */
	private final MergedArchitectureContext architextureContext;

	/**
	 * The list of the metamodel uri to ignore
	 */
	private Collection<String> nsURIToIgnore;

	/**
	 * The list of the managed relationship identified by their EClass
	 */
	private Collection<EClass> managedRelationships;

	/**
	 * The list of the identifiers of the ElementTypeSetConfiguration to ignore
	 */
	private Collection<String> elementTypeSetConfigurationToIgnore;

	/**
	 * separator used in the display name field of the IElementType
	 */
	private final String displayNameSeparator = "::"; //$NON-NLS-1$

	/**
	 * the map with the available configuration organized by the metamodel name deduced from the display name of the IElementType
	 */
	private Map<String, Collection<ElementTypeConfiguration>> configurationByMetamodelMap;

	/**
	 * The compartor used to sort Element typess
	 */
	private Comparator<ElementTypeConfiguration> comparator = new ElementTypeConfigurationComparator();


	/**
	 * Constructor.
	 *
	 * @param context
	 */
	public GenericRelationshipMatrixElementTypeContentProvider(final EObject context) {
		if (null != context && null != context.eResource() && null != context.eResource().getResourceSet()) {
			this.architextureContext = new ArchitectureDescriptionUtils((ModelSet) context.eResource().getResourceSet()).getArchitectureContext();
		} else {
			this.architextureContext = null;
		}
		initFields();
	}

	/**
	 * This method allows to init the field of this class
	 */
	private void initFields() {
		this.nsURIToIgnore = initURIToIgnore();
		this.managedRelationships = initManagedRelationships();
		this.elementTypeSetConfigurationToIgnore = initElementTypeSetConfigurations();
		this.configurationByMetamodelMap = initMapContents();
	}

	/**
	 * @return
	 */
	private Map<String, Collection<ElementTypeConfiguration>> initMapContents() {
		Map<String, Collection<ElementTypeConfiguration>> mapByMetamodel = new TreeMap<String, Collection<ElementTypeConfiguration>>();
		if (null == this.architextureContext) {
			return null;
		}

		// we build the set of the supported configuration according to the context and the existing Matrix Cell Managers
		for (final ElementTypeSetConfiguration typeSet : this.architextureContext.getElementTypes()) {
			if (this.elementTypeSetConfigurationToIgnore.contains(typeSet.getIdentifier()) || typeSet.getMetamodelNsURI() == null || this.nsURIToIgnore.contains(typeSet.getMetamodelNsURI())) {
				continue;
			}
			for (final ElementTypeConfiguration config : typeSet.getElementTypeConfigurations()) {
				if (isManagedElementTypeConfiguration(config)) {
					// 1. we determine the metamodel name from the display name (I know, this pattern is not sure, but it works for UML and SysML 1.1)
					String metamodelName = ""; //$NON-NLS-1$
					final String displayName = ProviderUtils.getElementTypeDisplayName(config);


					final String[] res = displayName.split(this.displayNameSeparator);
					if (res.length > 2) {
						continue;// we ignore it, probably an element type to define a feature inside an object (ie : UML::CollaborationUse::RoleBinding
					}
					if (res.length == 2) {
						metamodelName = res[0];
					}

					final Collection<ElementTypeConfiguration> list;
					if (!mapByMetamodel.containsKey(metamodelName)) {
						list = new TreeSet<ElementTypeConfiguration>(comparator);
						mapByMetamodel.put(metamodelName, list);
					}
					mapByMetamodel.get(metamodelName).add(config);
				}
			}
		}
		return mapByMetamodel;
	}


	/**
	 * @return
	 * 		the list of the nsURI of metamodels to ignore
	 */
	private Collection<String> initURIToIgnore() {
		final Collection<String> uriToIgnore = new HashSet<String>();
		uriToIgnore.add(EcorePackage.eINSTANCE.getNsURI());
		uriToIgnore.add(NattablePackage.eINSTANCE.getNsURI());
		uriToIgnore.add(NotationPackage.eINSTANCE.getNsURI());// to avoid dependency on GMF
		return uriToIgnore;
	}

	/**
	 * 
	 * @return
	 * 		a collection with the managed relationship identified by their EClass
	 */
	private Collection<EClass> initManagedRelationships() {
		final Set<EClass> managedRelationships = new HashSet<EClass>();
		for (final IGenericMatrixRelationshipCellManager current : CellManagerFactory.INSTANCE.getRegisteredGenericMatrixRelationshipCellManager()) {
			managedRelationships.add(current.getManagedRelationship());
		}
		return managedRelationships;
	}

	/**
	 * @return
	 * 		a collection with the identifier of the ElementTypeSetConfigurations to ignore
	 */
	private Collection<String> initElementTypeSetConfigurations() {
		final Set<String> ignoredStypeSets = new HashSet<String>();
		ignoredStypeSets.add("org.eclipse.papyrus.umldi.service.types.UMLDIElementTypeSet"); //$NON-NLS-1$
		return ignoredStypeSets;
	}

	/**
	 * 
	 * @param configuration
	 *            an element type configuration
	 * @return
	 * 		<code>true</code> if the element type is managed by a CellManager and <code>false</code> otherwise
	 */
	private boolean isManagedElementTypeConfiguration(final ElementTypeConfiguration configuration) {
		if (configuration instanceof MetamodelTypeConfiguration) {
			return this.managedRelationships.contains(((MetamodelTypeConfiguration) configuration).getEClass());
		}
		if (configuration instanceof SpecializationTypeConfiguration) {
			final SpecializationTypeConfiguration a = (SpecializationTypeConfiguration) configuration;
			if (a.getSpecializedTypes().size() == 1) {
				return isManagedElementTypeConfiguration(a.getSpecializedTypes().get(0));
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	@Override
	public Object[] getElements(final Object inputElement) {
		return getElements();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider#getElements()
	 */
	@Override
	public Object[] getElements() {
		if (null != this.configurationByMetamodelMap) {
			// this.configurationByMetamodelMap.s
			return this.configurationByMetamodelMap.keySet().toArray();
		}
		return new Object[0];
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 *
	 * @param parentElement
	 * @return
	 */
	@Override
	public Object[] getChildren(final Object parentElement) {
		if (parentElement instanceof String && this.configurationByMetamodelMap.containsKey(parentElement)) {
			return this.configurationByMetamodelMap.get(parentElement).toArray();
		}
		return null;
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 *
	 * @param element
	 * @return
	 */
	@Override
	public Object getParent(final Object element) {
		if (element instanceof String) {
			return null;
		}
		if (element instanceof ElementTypeConfiguration) {
			for (final Entry<String, Collection<ElementTypeConfiguration>> entry : this.configurationByMetamodelMap.entrySet()) {
				if (entry.getValue().contains(element)) {
					return entry.getKey();
				}
			}
		}
		return null;
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 *
	 * @param element
	 * @return
	 */
	@Override
	public boolean hasChildren(final Object element) {
		if (element instanceof String) {
			return 0 != this.configurationByMetamodelMap.get(element).size();
		}
		return false;
	}

	/**
	 * @see org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider#isValidValue(java.lang.Object)
	 *
	 * @param element
	 * @return
	 */
	@Override
	public boolean isValidValue(Object element) {
		final IElementType elementType;

		if (element instanceof MetamodelTypeConfiguration) {
			elementType = ElementTypeRegistry.getInstance().getType(((MetamodelTypeConfiguration) element).getIdentifier());
		} else if (element instanceof SpecializationTypeConfiguration) {
			elementType = ElementTypeRegistry.getInstance().getType(((SpecializationTypeConfiguration) element).getIdentifier());
		} else {
			elementType = null;
		}
		return null != elementType;
	}

	/**
	 * @see org.eclipse.papyrus.infra.widgets.providers.IGraphicalContentProvider#createBefore(org.eclipse.swt.widgets.Composite)
	 *
	 * @param parent
	 */
	@Override
	public void createBefore(Composite parent) {
		// nothing to do
	}

	/**
	 * @see org.eclipse.papyrus.infra.widgets.providers.IGraphicalContentProvider#createAfter(org.eclipse.swt.widgets.Composite)
	 *
	 * @param parent
	 */
	@Override
	public void createAfter(Composite parent) {
		// nothing to do
	}

	/**
	 * This comparator is used to sort the provider {@link ElementTypeConfiguration}
	 */
	private class ElementTypeConfigurationComparator implements Comparator<ElementTypeConfiguration> {

		/**
		 * the label provider used to compare the {@link ElementTypeConfiguration}
		 */
		private ILabelProvider provider = new GenericRelationshipMatrixElementTypeLabelProvider();

		/**
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 *
		 * @param arg0
		 * @param arg1
		 * @return
		 */
		@Override
		public int compare(ElementTypeConfiguration arg0, ElementTypeConfiguration arg1) {
			return provider.getText(arg0).compareToIgnoreCase(provider.getText(arg1));
		}

	}
}
