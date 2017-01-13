/*****************************************************************************
 * Copyright (c) 2017 Christian W. Damus and others.
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

import java.util.Collections;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.qvt.oml.ExecutionContext;
import org.eclipse.papyrus.migration.rsa.concurrent.ExecutorsPool;
import org.eclipse.papyrus.migration.rsa.internal.extension.PostProcessExtension;
import org.eclipse.papyrus.migration.rsa.transformation.ImportTransformation;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;

/**
 * An extension for the tests does some recognizable post-processing.
 * It prepends all element names with "123".
 */
public class PostProcessor implements PostProcessExtension {
	public static boolean isEnabled = false;

	private ImportTransformation transformation;

	/**
	 * Initializes me.
	 */
	public PostProcessor() {
		super();
	}

	@Override
	public Set<EPackage> getAdditionalSourceEPackages() {
		return Collections.emptySet();
	}

	@Override
	public int getNumberOfSteps() {
		return 0;
	}

	@Override
	public void setTransformation(ImportTransformation importTransformation) {
		if (isEnabled) {
			this.transformation = importTransformation;
		}
	}

	@Override
	public IStatus postProcess(ExecutionContext context, IProgressMonitor monitor) {
		ImportTransformation transformation = this.transformation;
		this.transformation = null;

		if (isEnabled) {
			return transformation.getInOutUMLModel().getContents().stream()
					.filter(Package.class::isInstance).map(Package.class::cast)
					.findFirst()
					.map(package_ -> {
						monitor.beginTask("Renaming elements", IProgressMonitor.UNKNOWN);

						package_.setName("123 " + package_.getName());
						package_.eAllContents().forEachRemaining(eobj -> {
							if (eobj instanceof NamedElement) {
								NamedElement named = (NamedElement) eobj;
								if (named.isSetName()) {
									named.setName("123 " + named.getName());
								}
							}
						});

						monitor.done();

						return Status.OK_STATUS;
					})
					.orElse(Status.CANCEL_STATUS);
		}

		return Status.OK_STATUS;
	}

	@Override
	public IStatus executeBefore(ExecutionContext context, IProgressMonitor monitor) {
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
}
