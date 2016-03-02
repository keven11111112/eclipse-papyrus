/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.customization.nattableconfiguration.utils;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.FeatureLabelProviderConfigurationImpl;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.ObjectLabelProviderConfigurationImpl;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.OperationLabelProviderConfigurationImpl;

/**
 * This class allows to define the simplification names for the nattable configuration wizard.
 */
public class NameSimplifier {

	/**
	 * To simplify the user choice, some axis managers identifier must be converted to simple name.
	 */
	public static final Map<String, String> axisManagerNames = new HashMap<String, String>();

	/**
	 * Define the label provider configuration class to use corresponding to axis manager.
	 * If one is not filled in this map, by default, the ObjectLabelProviderConfiguration must be used.
	 */
	public static final Map<String, String> labelProviderConfigurationByAxisManager = new HashMap<String, String>();

	/**
	 * The correspondence between the axis manager identifiers and the label provider contexts.
	 */
	public static final Map<String, String> correspondenceAxisManagerAndContext = new HashMap<String, String>();

	/**
	 * To simplify the user comprehension, the label provider configuration must be managed with simplest names.
	 */
	public static final Map<String, String> labelProviderConfigurationNames = new HashMap<String, String>();

	/**
	 * To simplify the user choice, the label provider context names must be simplified.
	 */
	public static final Map<String, String> labelProviderContextNames = new HashMap<String, String>();

	/**
	 * Initialize the previous map.
	 */
	static {
		axisManagerNames.put("org.eclipse.papyrus.infra.emf.nattable.feature.axis.manager", "EMF Feature"); //$NON-NLS-1$ //$NON-NLS-2$
		axisManagerNames.put("org.eclipse.papyrus.infra.emf.nattable.operation.axis.manager", "EMF Operation"); //$NON-NLS-1$ //$NON-NLS-2$
		axisManagerNames.put("org.eclipse.papyrus.uml.nattable.element.axis.manager", "UML Element"); //$NON-NLS-1$ //$NON-NLS-2$
		axisManagerNames.put("org.eclipse.papyrus.uml.nattable.feature.axis.manager", "UML Feature"); //$NON-NLS-1$ //$NON-NLS-2$
		axisManagerNames.put("org.eclipse.papyrus.uml.nattable.operation.axis.manager", "UML Operation"); //$NON-NLS-1$ //$NON-NLS-2$
		axisManagerNames.put("org.eclipse.papyrus.infra.uml.nattable.class.tree.axis.manager", "UML Tree Axis"); //$NON-NLS-1$ //$NON-NLS-2$
		axisManagerNames.put("org.eclipse.papyrus.sysml.nattable.requirement.axis.manager", "SysML Requirement"); //$NON-NLS-1$ //$NON-NLS-2$
		axisManagerNames.put("org.eclipse.papyrus.sysml.nattable.allocate.axis.manager", "SysML Allocation"); //$NON-NLS-1$ //$NON-NLS-2$

		labelProviderConfigurationByAxisManager.put("org.eclipse.papyrus.infra.emf.nattable.feature.axis.manager", FeatureLabelProviderConfigurationImpl.class.getSimpleName()); //$NON-NLS-1$
		labelProviderConfigurationByAxisManager.put("org.eclipse.papyrus.infra.emf.nattable.operation.axis.manager", OperationLabelProviderConfigurationImpl.class.getSimpleName()); //$NON-NLS-1$
		labelProviderConfigurationByAxisManager.put("org.eclipse.papyrus.uml.nattable.element.axis.manager", ObjectLabelProviderConfigurationImpl.class.getSimpleName()); //$NON-NLS-1$
		labelProviderConfigurationByAxisManager.put("org.eclipse.papyrus.uml.nattable.feature.axis.manager", FeatureLabelProviderConfigurationImpl.class.getSimpleName()); //$NON-NLS-1$
		labelProviderConfigurationByAxisManager.put("org.eclipse.papyrus.uml.nattable.operation.axis.manager", OperationLabelProviderConfigurationImpl.class.getSimpleName()); //$NON-NLS-1$
		labelProviderConfigurationByAxisManager.put("org.eclipse.papyrus.infra.uml.nattable.class.tree.axis.manager", ObjectLabelProviderConfigurationImpl.class.getSimpleName()); //$NON-NLS-1$
		labelProviderConfigurationByAxisManager.put("org.eclipse.papyrus.sysml.nattable.requirement.axis.manager", ObjectLabelProviderConfigurationImpl.class.getSimpleName()); //$NON-NLS-1$
		labelProviderConfigurationByAxisManager.put("org.eclipse.papyrus.sysml.nattable.allocate.axis.manager", ObjectLabelProviderConfigurationImpl.class.getSimpleName()); //$NON-NLS-1$
		labelProviderConfigurationByAxisManager.put("org.eclipse.papyrus.uml.nattable.stereotype.display.axis.manager", FeatureLabelProviderConfigurationImpl.class.getSimpleName()); //$NON-NLS-1$ //$NON-NLS-2$
		labelProviderConfigurationByAxisManager.put("org.eclipse.papyrus.uml.nattable.stereotype.display.properties.axis.manager", ObjectLabelProviderConfigurationImpl.class.getSimpleName()); //$NON-NLS-1$
		labelProviderConfigurationByAxisManager.put("org.eclipse.papyrus.uml.nattable.stereotype.property.axis.manager", FeatureLabelProviderConfigurationImpl.class.getSimpleName()); //$NON-NLS-1$ //$NON-NLS-2$

		correspondenceAxisManagerAndContext.put("org.eclipse.papyrus.infra.emf.nattable.feature.axis.manager", "org.eclipse.papyrus.infra.nattable.header.feature.labelprovider"); //$NON-NLS-1$ //$NON-NLS-2$
		correspondenceAxisManagerAndContext.put("org.eclipse.papyrus.infra.emf.nattable.operation.axis.manager", "org.eclipse.papyrus.infra.nattable.header.operation.labelprovider"); //$NON-NLS-1$ //$NON-NLS-2$
		correspondenceAxisManagerAndContext.put("org.eclipse.papyrus.uml.nattable.element.axis.manager", "org.eclipse.papyrus.infra.nattable.header.labelprovider"); //$NON-NLS-1$ //$NON-NLS-2$
		correspondenceAxisManagerAndContext.put("org.eclipse.papyrus.uml.nattable.feature.axis.manager", "org.eclipse.papyrus.infra.nattable.header.feature.labelprovider"); //$NON-NLS-1$ //$NON-NLS-2$
		correspondenceAxisManagerAndContext.put("org.eclipse.papyrus.uml.nattable.operation.axis.manager", "org.eclipse.papyrus.infra.nattable.header.operation.labelprovider"); //$NON-NLS-1$ //$NON-NLS-2$
		correspondenceAxisManagerAndContext.put("org.eclipse.papyrus.infra.uml.nattable.class.tree.axis.manager", "org.eclipse.papyrus.infra.nattable.header.labelprovider"); //$NON-NLS-1$ //$NON-NLS-2$
		correspondenceAxisManagerAndContext.put("org.eclipse.papyrus.sysml.nattable.requirement.axis.manager", "org.eclipse.papyrus.infra.nattable.header.labelprovider"); //$NON-NLS-1$ //$NON-NLS-2$
		correspondenceAxisManagerAndContext.put("org.eclipse.papyrus.sysml.nattable.allocate.axis.manager", "org.eclipse.papyrus.infra.nattable.header.labelprovider"); //$NON-NLS-1$ //$NON-NLS-2$
		correspondenceAxisManagerAndContext.put("org.eclipse.papyrus.uml.nattable.stereotype.display.axis.manager", "org.eclipse.papyrus.infra.nattable.header.feature.labelprovider"); //$NON-NLS-1$ //$NON-NLS-2$
		correspondenceAxisManagerAndContext.put("org.eclipse.papyrus.uml.nattable.stereotype.display.properties.axis.manager", "org.eclipse.papyrus.infra.nattable.header.labelprovider"); //$NON-NLS-1$ //$NON-NLS-2$
		correspondenceAxisManagerAndContext.put("org.eclipse.papyrus.uml.nattable.stereotype.property.axis.manager", "org.eclipse.papyrus.infra.nattable.header.feature.labelprovider"); //$NON-NLS-1$ //$NON-NLS-2$

		labelProviderConfigurationNames.put(ObjectLabelProviderConfigurationImpl.class.getSimpleName(), "Object"); //$NON-NLS-1$
		labelProviderConfigurationNames.put(FeatureLabelProviderConfigurationImpl.class.getSimpleName(), "Feature"); //$NON-NLS-1$
		labelProviderConfigurationNames.put(OperationLabelProviderConfigurationImpl.class.getSimpleName(), "Operation"); //$NON-NLS-1$

		labelProviderContextNames.put("org.eclipse.papyrus.infra.nattable.header.labelprovider", "Header"); //$NON-NLS-1$ //$NON-NLS-2$
		labelProviderContextNames.put("org.eclipse.papyrus.infra.nattable.header.feature.labelprovider", "Header Feature"); //$NON-NLS-1$ //$NON-NLS-2$
		labelProviderContextNames.put("org.eclipse.papyrus.infra.nattable.header.operation.labelprovider", "Header Operation"); //$NON-NLS-1$ //$NON-NLS-2$
	}
}
