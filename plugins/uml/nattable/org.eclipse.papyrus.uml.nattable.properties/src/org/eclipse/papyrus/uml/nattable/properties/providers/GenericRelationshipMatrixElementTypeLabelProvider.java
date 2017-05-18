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

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.types.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.types.ElementTypeSetConfiguration;
import org.eclipse.papyrus.infra.types.IconEntry;
import org.eclipse.papyrus.infra.types.MetamodelTypeConfiguration;
import org.eclipse.papyrus.infra.types.SpecializationTypeConfiguration;
import org.eclipse.papyrus.uml.nattable.properties.Activator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.Bundle;

/**
 * Custom Label provider for {@link ElementTypeConfiguration}.
 * This label provider has been created to hide that manipulated object are not UML Element or Profile
 *
 */
public class GenericRelationshipMatrixElementTypeLabelProvider implements ILabelProvider {

	/**
	 * 2 of the possibles contants returned by {@link GenericRelationshipMatrixElementTypeContentProvider} as root of the tree
	 */
	private final String UML = "UML"; //$NON-NLS-1$

	private final String SYSML = "SysML"; //$NON-NLS-1$

	/**
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 *
	 * @param listener
	 */
	@Override
	public void addListener(final ILabelProviderListener listener) {
		// nothing to do
	}

	/**
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 *
	 */
	@Override
	public void dispose() {
		// nothing to do
	}

	/**
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 *
	 * @param element
	 * @param property
	 * @return
	 */
	@Override
	public boolean isLabelProperty(final Object element, final String property) {
		// nothing to do
		return false;
	}

	/**
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 *
	 * @param listener
	 */
	@Override
	public void removeListener(final ILabelProviderListener listener) {
		// nothing to do
	}

	/**
	 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
	 *
	 * @param element
	 * @return
	 */
	@Override
	public Image getImage(final Object element) {
		URL url = null;
		if (element instanceof String) {// currently we have 2 levels in the displayed tree and the first one is String
			if (UML.equals(element)) {
				Bundle bundle = Platform.getBundle("org.eclipse.papyrus.uml.architecture"); //$NON-NLS-1$
				
				//TODO get the icons defined for the EPackage if exist ????

				url = bundle.getEntry("icons/uml.gif"); //$NON-NLS-1$
			} else if (SYSML.equals(element)) {
				Bundle bundle = Platform.getBundle("org.eclipse.papyrus.sysml.architecture"); //$NON-NLS-1$
				
				//TODO get the icons defined for the EPackage if exist ????
				url = bundle.getEntry("icons/sysml.gif"); //$NON-NLS-1$
			}
		} else if (element instanceof ElementTypeConfiguration) {
			url = getIconURL((ElementTypeConfiguration) element);
			if (null == url) {
				IElementType elementType = null;

				if (element instanceof MetamodelTypeConfiguration) {
					elementType = ElementTypeRegistry.getInstance().getType(((MetamodelTypeConfiguration) element).getIdentifier());
				} else if (element instanceof SpecializationTypeConfiguration) {
					elementType = ElementTypeRegistry.getInstance().getType(((SpecializationTypeConfiguration) element).getIdentifier());
				}
				if (null != elementType) {
					url = getIconURL(elementType);
				}
			}
		}
		if (null != url) {
			final Image im = ExtendedImageRegistry.INSTANCE.getImage(url); // $NON-NLS-1$
			if (null == im) {
				Activator.log.warn(NLS.bind("The image located at {0} as not been found", url)); //$NON-NLS-1$
			}
			return im;
		} else if (element instanceof ElementTypeConfiguration && !(element instanceof String)) {// we don't have a clean way currently to define icon for string excepted hard-coding
			Activator.log.warn(NLS.bind("No icon defined for ", element)); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * Duplicated code from org.eclipse.papyrus.infra.gmfdiag.common.providers.ElementTypeIconProvider
	 * 
	 * @param elementType
	 *            an element type
	 * @return
	 * 		the url of the icon to {@link Display} or <code>null</code> if not found
	 */
	private URL getIconURL(final IElementType elementType) {
		URL result = elementType.getIconURL();

		if ((result == null) && (elementType instanceof ISpecializationType)) {
			ISpecializationType subtype = (ISpecializationType) elementType;
			IElementType[] supertypes = subtype.getSpecializedTypes();
			if (supertypes != null) {
				for (int i = 0; (result == null) && (i < supertypes.length); i++) {
					result = getIconURL(supertypes[i]);
				}
			}
		}

		return result;
	}

	/**
	 * Duplicated code from AbstractElementTypeConfigurationFactory
	 * 
	 * @param elementTypeConfiguration
	 *            an element type configuration
	 * @return
	 * 		the url of the icon to use or <code>null</code> when not found
	 */
	private URL getIconURL(final ElementTypeConfiguration elementTypeConfiguration) {
		// icon associated to the elementType (GUI)
		IconEntry entry = elementTypeConfiguration.getIconEntry();
		URL iconURL = null;
		if (entry != null) {
			iconURL = getURLFromEntry(entry);
		}
		return iconURL;
	}

	/**
	 * Duplicated code from AbstractElementTypeConfigurationFactory
	 * 
	 * @param entry
	 *            an icon entry
	 * @return
	 * 		the url of the icon or <code>null</code> if not found
	 * 
	 */
	private URL getURLFromEntry(final IconEntry entry) {
		Bundle bundle = Platform.getBundle(entry.getBundleId());
		if (bundle == null) {
			Activator.log.warn(NLS.bind("Bundle {0} doesn't exist. I cannot found the expected icon {1}.", entry.getBundleId(), entry.getIconPath())); //$NON-NLS-1$
			return null;
		}
		URL result = bundle.getEntry(entry.getIconPath());
		if (result == null) {
			try {
				result = new URL(entry.getIconPath());
			} catch (MalformedURLException e) {
				Activator.log.error(NLS.bind("The icon path {0} seems invalid, I can't found this icon in the bundle {1}.", entry.getIconPath(), entry.getBundleId()), e); //$NON-NLS-1$
				result = null;
			}
		}
		return result;
	}


	/**
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 *
	 * @param element
	 * @return
	 */
	@Override
	public String getText(final Object element) {
		String returnedName = ""; //$NON-NLS-1$
		if (null != element) {
			returnedName = element.toString();
			if (element instanceof ElementTypeSetConfiguration) {
				returnedName = ((ElementTypeSetConfiguration) element).getName();
			}
			if (element instanceof ElementTypeConfiguration) {
				returnedName = ProviderUtils.getNameToDisplay((ElementTypeConfiguration) element);
			}
		}
		return returnedName;
	}

}
