/**
 * Copyright CEA-LIST 2009
 * available under EPL 1.0 licence
 *
 * This file is part of the Qompass tool chain (www.ec3m.net)
 *
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */

package org.eclipse.papyrus.qompass.designer.core.templates;

import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Wrap different ways to bind a template. This may be either a reference to an
 * Xtend template or a specific name template.
 */
public class TextTemplateBinding {

	/**
	 * Execute a script passed as parameter. It will be executed in the context
	 * of a base script that declares the meta-model (UML2) and has additional
	 * imports (currently none).
	 *
	 * @param template
	 *            The template in string form
	 * @param element
	 *            The UML element to which the template is applied
	 * @return the evaluated template
	 */
	public static String bind(String templateStr, Element element) throws TransformationException {
		return bind(templateStr, element, null);
	}

	/**
	 * Execute a script passed as parameter. It will be executed in the context
	 * of a base script that declares the meta-model (UML2). It allows for
	 * additional arguments
	 *
	 * @param template
	 *            The template in string form
	 * @param element
	 *            The UML element to which the template is applied
	 * @return the evaluated template
	 */
	public static String bind(String templateStr, Element element, Object args[]) throws TransformationException {
		if (templateStr.startsWith(XtendTemplateBinding.XTEND_MAGIC)) {
			return XtendTemplateBinding.bind(templateStr, element, args);
		}
		else if (element instanceof NamedElement) {
			String name = ((NamedElement) element).getName();
			if (templateStr.contains("[name/]")) {
				return templateStr.replace("[name/]", name);
			}
			else if (templateStr.contains("[name]")) {
				return templateStr.replace("[name/]", name);
			}
		}
		return templateStr;
		// throw new TransformationException("Template is not supported"); //$NON-NLS-1$
	}
}
