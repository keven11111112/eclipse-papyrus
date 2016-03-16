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
package org.eclipse.papyrus.customization.palette.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.customization.palette.Messages;
import org.eclipse.papyrus.uml.diagram.common.part.PaletteUtil;
import org.eclipse.papyrus.uml.diagram.common.service.AspectCreationEntry;
import org.eclipse.papyrus.uml.diagram.common.service.IPapyrusPaletteConstant;
import org.eclipse.papyrus.uml.diagram.common.service.palette.StereotypeAspectActionProvider;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Content provider for the available tools viewer, when the
 */
public class ProfileToolsMetaclassStereotypeTreeContentProvider implements ITreeContentProvider {

	/** profile to display */
	final protected Profile profile;

	/** standard uml tools palette entries */
	final protected Collection<PaletteEntry> standardEntries;

	/**
	 * Creates a new ProfileToolsMetaclassStereotypeTreeContentProvider.
	 *
	 * @param profile
	 *            the profile for which tools are built
	 * @param standardEntries
	 *            list of standard uml tools palette entries
	 */
	public ProfileToolsMetaclassStereotypeTreeContentProvider(final Profile profile, final Collection<PaletteEntry> standardEntries) {
		this.profile = profile;
		this.standardEntries = standardEntries;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		// nothing to do here
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] getChildren(Object parentElement) {
		Object[] children;
		if (parentElement instanceof Profile) {
			children = standardEntries.toArray();

		} else if (parentElement instanceof AspectCreationEntry) {
			children = new Object[0];

		} else if (parentElement instanceof PaletteEntry) {
			List<AspectCreationEntry> entries = new ArrayList<AspectCreationEntry>();
			// display all stereotypes applicable to the type of element created by this tool
			if (parentElement instanceof CombinedTemplateCreationEntry) {
				CombinedTemplateCreationEntry entry = (CombinedTemplateCreationEntry) parentElement;
				EClass toolMetaclass = PaletteUtil.getToolMetaclass(entry);
				if (toolMetaclass != null) {
					for (Stereotype stereotype : profile.getOwnedStereotypes()) {
						List<Class> metaclasses = stereotype.getAllExtendedMetaclasses();
						for (Class stMetaclass : metaclasses) {
							// get Eclass
							java.lang.Class<?> metaclassClass = stMetaclass.getClass();
							if (metaclassClass != null) {
								EClassifier metaClassifier = UMLPackage.eINSTANCE.getEClassifier(stMetaclass.getName());
								if (((EClass) metaClassifier).isSuperTypeOf(toolMetaclass)) {
									// should create the palette entry
									Map<String, Object> properties = new HashMap<String, Object>();
									properties.put(IPapyrusPaletteConstant.ASPECT_ACTION_KEY, StereotypeAspectActionProvider.createConfigurationNode(stereotype.getQualifiedName()));
									StringBuilder name = new StringBuilder();
									name.append(stereotype.getName());
									name.append(" (");//$NON-NLS-1$
									name.append(entry.getLabel());
									name.append(")");//$NON-NLS-1$
									AspectCreationEntry aspectEntry = new AspectCreationEntry(name.toString(), Messages.PaletteConfigurationContentPage_CreateAnElementWithAStereotype, // $NON-NLS-1$ //$NON-NLS-2$
											entry.getId(), // $NON-NLS-4$
											entry.getSmallIcon(), entry, properties);
									entries.add(aspectEntry);
								}
							}

						}
					}
				}
			}
			children = entries.toArray();
		} else {
			children = new Object[0];
		}
		return children;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] getElements(final Object inputElement) {
		return inputElement instanceof Profile ? standardEntries.toArray() : new Object[0];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getParent(final Object element) {
		return element instanceof Stereotype ? ((Stereotype) element).getProfile() : null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasChildren(final Object element) {
		boolean hasChildren = false;
		if (element instanceof Profile) {
			hasChildren = true;
		} else if (element instanceof PaletteEntry) {
			hasChildren = true;
		}
		return hasChildren;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
		// Do nothing
	}

}