package org.eclipse.papyrus.cpp.cdtproject;

import org.eclipse.core.resources.IProject;
import org.eclipse.papyrus.codegen.extensionpoints.ILangProjectSupport;

/**
 * C++ language support
 */
public class CppProjectSupport extends C_CppProjectSupport implements ILangProjectSupport {

	private static final String CppLanguage = "C++"; //$NON-NLS-1$

	@Override
	public IProject createProject(String projectName) {
		IProject project = super.createProject(projectName);

		return  project;
	}
}
