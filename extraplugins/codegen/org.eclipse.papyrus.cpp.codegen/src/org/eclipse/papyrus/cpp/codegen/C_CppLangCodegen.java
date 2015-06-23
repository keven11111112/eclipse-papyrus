/*******************************************************************************
 * Copyright (c) 2006 - 2015 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - ansgar.radermacher@cea.fr   initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.cpp.codegen;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.C_Cpp.C_CppPackage;
import org.eclipse.papyrus.codegen.base.ModelElementsCreator;
import org.eclipse.papyrus.codegen.extensionpoints.ILangCodegen;
import org.eclipse.papyrus.cpp.codegen.transformation.CppModelElementsCreator;
import org.eclipse.papyrus.cpp.codegen.utils.LocateCppProject;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;

/**
 * C++ language support
 *
 */
public class C_CppLangCodegen implements ILangCodegen {

	protected ModelElementsCreator creator = null;

	protected IProject lastProject = null;

	@Override
	public String getDescription() {
		return Messages.C_CppLangCodegen_GeneratorDesc; 
	}

	@Override
	public boolean isEligible(Package modelRoot) {
		return (modelRoot.getAppliedProfile(C_CppPackage.eINSTANCE.getName()) != null);
	}
	
	@Override
	public void generateCode(IProject project, PackageableElement element, IProgressMonitor monitor)
	{
		manageCreator(project, element);
		creator.createPackageableElement(element, monitor);
	}

	@Override
	public void cleanCode(IProject project, PackageableElement element, IProgressMonitor monitor) {
		manageCreator(project, element);
		creator.removePackageableElement(element, monitor);
	}

	@Override
	public String getFileName(IProject project, NamedElement element) {
		manageCreator(project, element);
		return creator.getFileName(element);
	}

	@Override
	public IProject getTargetProject(PackageableElement pe, boolean createIfMissing) {
		return LocateCppProject.getTargetProject(pe, createIfMissing);
	}
	
	protected void manageCreator(IProject project, Element element) {
		if ((project == null) && (element instanceof PackageableElement)) {
			project = getTargetProject((PackageableElement) element, false);
		}
		if ((creator == null) || (project != lastProject)) {
			lastProject = project;
			creator = new CppModelElementsCreator(project);
		}
	}
}
