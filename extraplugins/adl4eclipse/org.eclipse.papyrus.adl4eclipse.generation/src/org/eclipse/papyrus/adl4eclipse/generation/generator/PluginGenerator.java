/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Thomas Daniellou (CEA LIST) - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.adl4eclipse.generation.generator;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.papyrus.adl4eclipse.org.ADL4Eclipse_Stereotypes;
import org.eclipse.papyrus.adltool.ADLConstants;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.EnumerationLiteral;

public class PluginGenerator extends BundleGenerator {

	private static final String NULL = "null";

	public PluginGenerator(Component component) {
		super(component);

		stereotype = component.getAppliedStereotype(ADL4Eclipse_Stereotypes.PLUGIN_STEREOTYPE);
	}

	@Override
	public void generate() throws CoreException {
		super.generate();

		// PlatformFilter
		Object value = component.getValue(stereotype, ADL4Eclipse_Stereotypes.PLUGIN_PLATFORMFILTER_ATT);
		if (value != null) {
			manifestEditor.setValue(ADLConstants.ECLIPSE_PLATFORMFILTER, value.toString().trim());
		}

		// Eclipse-BuddyPolicy
		List<?> stereotypeBuddyPolicy = (List<?>) component.getValue(stereotype, ADL4Eclipse_Stereotypes.PLUGIN_BUDDYPOLICY_ATT);
		StringBuilder stringBuilder = new StringBuilder();

		for (Object buddyPolicy : stereotypeBuddyPolicy) {
			if (stringBuilder.length() != 0) {
				stringBuilder.append(", ");
			}

			String buddyPolicyValue = buddyPolicy.toString().trim();
			stringBuilder.append(buddyPolicyValue);
		}

		if (stringBuilder.length() != 0) {
			manifestEditor.setValue(ADLConstants.ECLIPSE_BUDDY_POLICY, stringBuilder.toString());
		}

		// Eclipse-BundleShape
		EnumerationLiteral bundleShape = (EnumerationLiteral) component.getValue(stereotype, ADL4Eclipse_Stereotypes.PLUGIN_BUNDLESHAPE_ATT);
		if (!NULL.equals(bundleShape.getName())) {
			manifestEditor.setValue(ADLConstants.ECLIPSE_BUNDLE_SHAPE, bundleShape.getName());
		}

		// Eclipse-LazyStart
		boolean lazyStart = (boolean) component.getValue(stereotype, ADL4Eclipse_Stereotypes.PLUGIN_LAZYSTART_ATT);
		boolean manifestLazyStart = Boolean.valueOf(manifestEditor.getValue(ADLConstants.ECLIPSE_LAZYSTART));

		// Set the value on the manifest if the header exists already or if the value to set is true
		manifestEditor.setValue(ADLConstants.ECLIPSE_LAZYSTART, Boolean.toString(manifestLazyStart || lazyStart));

		// TODO: Set the values for the following headers
		// Eclipse-RegisterBuddy
		// Fragment-Host
		// Provide-Capability
		// Require-Capability
		// DynamicImport-Package

	}

}
