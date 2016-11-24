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

package org.eclipse.papyrus.uml.internationalization.utils.utils;

import java.util.Locale;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.internationalization.common.utils.InternationalizationPreferencesUtils;
import org.eclipse.papyrus.infra.internationalization.utils.utils.LabelInternationalizationUtils;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;

/**
 * The internationalization label manager for UML elements.
 */
public class UMLLabelInternationalization {

	/**
	 * The singleton instance.
	 */
	private static UMLLabelInternationalization instance;

	/**
	 * Constructor.
	 */
	protected UMLLabelInternationalization() {

	}

	/**
	 * Get the singleton instance (create it if not existing).
	 * 
	 * @return The singleton instance.
	 */
	public static UMLLabelInternationalization getInstance() {
		if (null == instance) {
			instance = new UMLLabelInternationalization();
		}
		return instance;
	}

	/**
	 * This allows to get the label of the named element.
	 * 
	 * @param namedElement
	 *            The named element.
	 * @return The label of the named element or the name if the label is null.
	 */
	public String getLabel(final NamedElement namedElement) {
		return getLabel(namedElement, true);
	}

	/**
	 * This allows to get the label of the named element.
	 * 
	 * @param namedElement
	 *            The named element.
	 * @param localize
	 *            Boolean to determinate if the locale must be used.
	 * @return The label of the named element or the name if the label is null.
	 */
	public String getLabel(final NamedElement namedElement, final boolean localize) {
		String result = null;
		if (null != namedElement.eResource() && InternationalizationPreferencesUtils.getInternationalizationPreference(namedElement)) {
			result = getLabelWithoutUML(namedElement, localize);
		}
		return null != result ? result : namedElement.getName();
	}

	/**
	 * This allows to get the label of the named element without the getName
	 * when the label is null.
	 * 
	 * @param namedElement
	 *            The named element.
	 * @return The label of the named element.
	 */
	public String getLabelWithoutUML(final NamedElement namedElement) {
		return getLabelWithoutUML(namedElement, true);
	}

	/**
	 * This allows to get the label of the named element without the getName
	 * when the label is null.
	 * 
	 * @param namedElement
	 *            The named element.
	 * @param localize
	 *            Boolean to determinate if the locale must be used.
	 * @return The label of the named element.
	 */
	public String getLabelWithoutUML(final NamedElement namedElement, final boolean localize) {
		return LabelInternationalizationUtils.getLabelWithoutSubstract(namedElement, localize);
	}

	/**
	 * This allows to set the named element label.
	 * 
	 * @param namedElement
	 *            The named element.
	 * @param value
	 *            The label value.
	 * @param locale
	 *            The locale for which set the value (if <code>null</code> set
	 *            it for the current locale).
	 */
	public void setLabel(final NamedElement namedElement, final String value, final Locale locale) {
		LabelInternationalizationUtils.setLabel(namedElement, value, locale);
	}

	/**
	 * This allows to get the set named element label command.
	 * 
	 * @param domain
	 *            The editing domain to use.
	 * @param namedElement
	 *            The named element.
	 * @param value
	 *            The value to set.
	 * @param locale
	 *            The locale for which set the value (if <code>null</code> set
	 *            it for the current locale).
	 * @return The command which allow to set the named element label.
	 */
	public Command getSetLabelCommand(final EditingDomain domain, final NamedElement namedElement, final String value, final Locale locale) {
		return LabelInternationalizationUtils.getSetLabelCommand(domain, namedElement, value, locale);
	}

	/**
	 * This allows to get the keyword of the stereotype.
	 * 
	 * @param stereotype
	 *            The stereotype.
	 * @return The keyword of the stereotype or the name if the keyword is null.
	 */
	public String getKeyword(final Stereotype stereotype) {
		return getKeyword(stereotype, true);
	}

	/**
	 * This allows to get the keyword of the stereotype.
	 * 
	 * @param stereotype
	 *            The stereotype.
	 * @param localize
	 *            Boolean to determinate if the locale must be used.
	 * @return The keyword of the stereotype or the name if the keyword is null.
	 */
	public String getKeyword(final Stereotype stereotype, final boolean localize) {
		String result = null;
		if (null != stereotype.eResource() && InternationalizationPreferencesUtils.getInternationalizationPreference(stereotype)) {
			result = LabelInternationalizationUtils.getLabelWithoutSubstract(stereotype, localize);
		}
		return null != result ? result : stereotype.getName();
	}

	/**
	 * This allows to get the keyword of the stereotype without the getName when
	 * the keyword is null.
	 * 
	 * @param stereotype
	 *            The stereotype.
	 * @return The keyword of the stereotype.
	 */
	public String getKeywordWithoutUML(final Stereotype stereotype) {
		return getKeywordWithoutUML(stereotype, true);
	}

	/**
	 * This allows to get the keyword of the stereotype without the getName when
	 * the keyword is null.
	 * 
	 * @param stereotype
	 *            The stereotype.
	 * @param localize
	 *            Boolean to determinate if the locale must be used.
	 * @return The keyword of the stereotype.
	 */
	public String getKeywordWithoutUML(final Stereotype stereotype, final boolean localize) {
		return LabelInternationalizationUtils.getLabelWithoutSubstract(stereotype, localize);
	}

	/**
	 * This allows to set the stereotype keyword.
	 * 
	 * @param stereotype
	 *            The stereotype.
	 * @param value
	 *            The label value.
	 * @param locale
	 *            The locale for which set the value (if <code>null</code> set
	 *            it for the current locale).
	 */
	public void setKeyword(final Stereotype stereotype, final String value, final Locale locale) {
		LabelInternationalizationUtils.setLabel(stereotype, value, locale);
	}

	/**
	 * This allows to get the set stereotype keyword command.
	 * 
	 * @param domain
	 *            The editing domain to use.
	 * @param stereotype
	 *            The stereotype.
	 * @param value
	 *            The value to set.
	 * @param locale
	 *            The locale for which set the value (if <code>null</code> set
	 *            it for the current locale).
	 * @return The command which allow to set the stereotype keyword.
	 */
	public Command getSetKeywordCommand(final EditingDomain domain, final Stereotype stereotype, final String value, final Locale locale) {
		return LabelInternationalizationUtils.getSetLabelCommand(domain, stereotype, value, locale);
	}
}
