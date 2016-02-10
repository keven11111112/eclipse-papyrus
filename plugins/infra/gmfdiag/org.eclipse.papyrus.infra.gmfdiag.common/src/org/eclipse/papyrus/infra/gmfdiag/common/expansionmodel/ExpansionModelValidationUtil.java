/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel;

import java.util.Map;

import javax.naming.Context;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.util.ExpansionmodelValidator;
import org.eclipse.papyrus.infra.tools.util.ClassLoaderHelper;
import org.eclipse.papyrus.infra.types.core.registries.ElementTypeConfigurationTypeRegistry;

/**
 * This utility class has been added in order to ensure that model is well built.
 * See Requirement #org.eclipse.papyrus.infra.gmfdiag.expansion.Req_061
 * 
 *
 */
public class ExpansionModelValidationUtil {

	/**
	 * This method is used to ensure that properties are filled
	 * 
	 * @param abstractRepresentation
	 *            the {@link AbstractRepresentation} that is validate
	 * @param diagnostic
	 *            the {@link Diagnostic}
	 * @param context
	 *            the {@link Context}
	 * @return false if the kind is not filled and if the properties view Factory && editPartQualified name are null or equals to "".
	 */
	public static boolean validate_facrtories(AbstractRepresentation abstractRepresentation, DiagnosticChain diagnostic, Map context) {
		boolean valid = true;
		if (diagnostic != null) {
			if (abstractRepresentation.getKind() == null) {
				if (abstractRepresentation.getEditPartQualifiedName() == null || "".equals(abstractRepresentation.getEditPartQualifiedName().trim())) {
					if (abstractRepresentation.getViewFactory() == null || "".equals(abstractRepresentation.getViewFactory().trim())) {
						valid = false;
						diagnostic.add(new BasicDiagnostic(Diagnostic.ERROR,
								ExpansionmodelValidator.DIAGNOSTIC_SOURCE,
								ExpansionmodelValidator.ABSTRACT_REPRESENTATION__VALIDATE, "The representation '"
										+ abstractRepresentation.getName() + "' has no kind , no editpartQualifiedName, no viewFactory.",
								new Object[] { abstractRepresentation }));
					}
				}

			}
		}
		return valid;
	}

	/**
	 * this method is used to verify if provider and editpart can be loaded
	 * 
	 * @param abstractRepresentation
	 * @param diagnostic
	 * @param context
	 * @return
	 */
	public static boolean validate_loadclasses(AbstractRepresentation abstractRepresentation, DiagnosticChain diagnostic, Map context) {
		boolean valid = true;
		if (diagnostic != null) {
			if (abstractRepresentation.getEditPartQualifiedName() != null && !("".equals(abstractRepresentation.getEditPartQualifiedName().trim()))) {
				Class<?> loadedClass = ClassLoaderHelper.loadClass(abstractRepresentation.getEditPartQualifiedName());
				if (loadedClass == null) {
					valid = false;
					diagnostic.add(new BasicDiagnostic(Diagnostic.ERROR,
							ExpansionmodelValidator.DIAGNOSTIC_SOURCE,
							ExpansionmodelValidator.ABSTRACT_REPRESENTATION__VALIDATE, "The representation '"
									+ abstractRepresentation.getName() + "' references an edit part that does not exist " + abstractRepresentation.getEditPartQualifiedName(),
							new Object[] { abstractRepresentation }));

				}

			}
			if (abstractRepresentation.getViewFactory() != null && !("".equals(abstractRepresentation.getViewFactory().trim()))) {
				Class<?> loadedClass = ClassLoaderHelper.loadClass(abstractRepresentation.getViewFactory());
				if (loadedClass == null) {
					valid = false;
					diagnostic.add(new BasicDiagnostic(Diagnostic.ERROR,
							ExpansionmodelValidator.DIAGNOSTIC_SOURCE,
							ExpansionmodelValidator.ABSTRACT_REPRESENTATION__VALIDATE, "The representation '"
									+ abstractRepresentation.getName() + "' references a view factory that not exist " + abstractRepresentation.getViewFactory(),
							new Object[] { abstractRepresentation }));

				}
			}
		}
		return valid;
	}

	/**
	 * this method is used to verify if provider and editpart can be loaded
	 * 
	 * @param abstractRepresentation
	 * @param diagnostic
	 * @param context
	 * @return
	 */
	public static boolean validate_loadclasses(RepresentationKind abstractRepresentation, DiagnosticChain diagnostic, Map context) {
		boolean valid = true;
		if (diagnostic != null) {
			if (abstractRepresentation.getEditPartQualifiedName() != null || !("".equals(abstractRepresentation.getEditPartQualifiedName().trim()))) {
				Class<?> loadedClass = ClassLoaderHelper.loadClass(abstractRepresentation.getEditPartQualifiedName());
				if (loadedClass == null) {
					valid = false;
					diagnostic.add(new BasicDiagnostic(Diagnostic.ERROR,
							ExpansionmodelValidator.DIAGNOSTIC_SOURCE,
							ExpansionmodelValidator.ABSTRACT_REPRESENTATION__VALIDATE, "The representation '"
									+ abstractRepresentation.getName() + "' references an edit part that does not exist " + abstractRepresentation.getEditPartQualifiedName(),
							new Object[] { abstractRepresentation }));

				}

			}
			if (abstractRepresentation.getViewFactory() != null || !("".equals(abstractRepresentation.getViewFactory().trim()))) {
				Class<?> loadedClass = ClassLoaderHelper.loadClass(abstractRepresentation.getViewFactory());
				if (loadedClass == null) {
					valid = false;
					diagnostic.add(new BasicDiagnostic(Diagnostic.ERROR,
							ExpansionmodelValidator.DIAGNOSTIC_SOURCE,
							ExpansionmodelValidator.ABSTRACT_REPRESENTATION__VALIDATE, "The representation '"
									+ abstractRepresentation.getName() + "' references a view factory that does not exist " + abstractRepresentation.getViewFactory(),
							new Object[] { abstractRepresentation }));

				}
			}
		}
		return valid;
	}

	/**
	 * this method is used to verify if the element type exists.
	 * 
	 * @param abstractRepresentation
	 * @param diagnostic
	 * @param context
	 * @return
	 */
	public static boolean validate_ElementType(Representation abstractRepresentation, DiagnosticChain diagnostic, Map context) {
		boolean valid = true;
		String elementTypeID = abstractRepresentation.getGraphicalElementType();
		if (elementTypeID != null && !elementTypeID.isEmpty()) {
			// ensure that element types model are loaded
			ElementTypeConfigurationTypeRegistry.getInstance();
			final IElementType elementType = ElementTypeRegistry.getInstance().getType(elementTypeID);
			if (elementType == null) {
				valid = false;
				diagnostic.add(new BasicDiagnostic(Diagnostic.ERROR,
						ExpansionmodelValidator.DIAGNOSTIC_SOURCE,
						ExpansionmodelValidator.ABSTRACT_REPRESENTATION__VALIDATE, "The representation '"
								+ abstractRepresentation.getName() + "' references a element type that does not exist " + abstractRepresentation.getGraphicalElementType(),
						new Object[] { abstractRepresentation }));

			}
		}
		return valid;
	}

}
