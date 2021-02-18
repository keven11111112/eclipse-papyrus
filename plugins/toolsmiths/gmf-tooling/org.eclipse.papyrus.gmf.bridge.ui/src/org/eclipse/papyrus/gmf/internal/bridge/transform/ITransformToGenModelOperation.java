/******************************************************************************
 * Copyright (c) 2013, 2020 Borland Software Corporation, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Michael Golubev (Borland) - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.bridge.transform;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.gmf.mappings.Mapping;

public interface ITransformToGenModelOperation {

	public TransformOptions getOptions();

	public ResourceSet getResourceSet();

	public Diagnostic getGMFGenValidationResult();

	public Diagnostic getMapmodelValidationResult();

	public GenModel findGenmodel() throws CoreException;

	public GenModelDetector getGenModelDetector();

	public void setGenURI(URI gmfGen);

	public IStatus executeTransformation(IProgressMonitor pm);

	public Mapping loadMappingModel(URI uri, IProgressMonitor pm) throws CoreException;

	public IStatus getStaleGenmodelStatus();
	
	public GenModel loadGenModel(URI uri, IProgressMonitor pm) throws CoreException;

}
