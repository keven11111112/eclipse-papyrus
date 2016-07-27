/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.migration.rsa.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.m2m.qvt.oml.ExecutionContext;
import org.eclipse.papyrus.migration.rsa.concurrent.ExecutorsPool;
import org.eclipse.papyrus.migration.rsa.internal.extension.TransformationExtension;
import org.eclipse.papyrus.migration.rsa.transformation.ImportTransformation;
import org.eclipse.uml2.uml.Port;

/**
 * An extension for the tests only that fills in UML 2.2-to-2.5 gaps
 * from RSA's UML-RT profile (especially for the Port conjugation semantics).
 */
public class UML25HandlerExtension implements TransformationExtension {
	public static boolean isEnabled = false;

	private List<EObject> umlContents = new ArrayList<>();

	/**
	 * Initializes me.
	 */
	public UML25HandlerExtension() {
		super();
	}

	@Override
	public Set<EPackage> getAdditionalSourceEPackages() {
		return Collections.emptySet();
	}

	@Override
	public int getNumberOfSteps() {
		return isEnabled ? 1 : 0;
	}

	@Override
	public void setTransformation(ImportTransformation importTransformation) {
		if (isEnabled) {
			umlContents.addAll(importTransformation.getInOutUMLModel().getContents());
		}
	}

	@Override
	public IStatus executeBefore(ExecutionContext context, IProgressMonitor monitor) {
		if (isEnabled) {
			monitor.beginTask("Populating UML 2.5 attributes", 1);

			try {
				Predicate<Object> isAnElement = EModelElement.class::isInstance;
				Predicate<Object> isAnEObject = EObject.class::isInstance;
				umlContents.stream()
						.filter(isAnElement.negate().and(isAnEObject))
						.map(EObject.class::cast)
						.forEach(this::processStereotypeApplication);
			} finally {
				monitor.done();
			}
		}
		return Status.OK_STATUS;
	}

	@Override
	public IStatus executeAfter(ExecutionContext context, IProgressMonitor monitor) {
		return Status.OK_STATUS;
	}

	@Override
	public void setResourceSet(ResourceSet resourceSet) {
		// Pass
	}

	@Override
	public void setExecutorsPool(ExecutorsPool executorsPool) {
		// Pass
	}

	//
	// UML 2.5 conversion
	//

	private void processStereotypeApplication(EObject stereotypeApplication) {
		EClass stereotype = stereotypeApplication.eClass();
		EStructuralFeature anyAttribute = stereotype.getEStructuralFeature("anyAttribute");
		if ((anyAttribute != null) && FeatureMapUtil.isFeatureMap(anyAttribute)) {
			FeatureMap featureMap = (FeatureMap) stereotypeApplication.eGet(anyAttribute);
			Port port = null;
			Boolean isConjugated = null;

			for (FeatureMap.Entry next : featureMap) {
				switch (next.getEStructuralFeature().getName()) {
				case "base_Port":
					port = dereference(stereotypeApplication, next.getValue(), Port.class);
					break;
				case "isConjugate":
				case "isConjugated":
					isConjugated = asBoolean(next.getValue());
					break;
				}
			}

			if ((port != null) && (isConjugated != null)) {
				port.setIsConjugated(isConjugated);
			}
		}
	}

	private <T extends EObject> T dereference(EObject owner, Object reference, Class<? extends T> type) {
		T result = null;

		if (reference instanceof String) {
			String fragment = (String) reference;
			EObject referenced = owner.eResource().getEObject(fragment);
			if (type.isInstance(referenced)) {
				result = type.cast(referenced);
			}
		}

		return result;
	}

	private static Boolean asBoolean(Object value) {
		return (value == null) ? Boolean.FALSE : Boolean.valueOf(value.toString());
	}
}
