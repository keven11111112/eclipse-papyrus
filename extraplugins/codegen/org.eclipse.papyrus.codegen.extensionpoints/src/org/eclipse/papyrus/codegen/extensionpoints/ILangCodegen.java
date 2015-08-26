/*******************************************************************************
 * Copyright (c) 2015 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.codegen.extensionpoints;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;

/**
 * Extension point that is implemented by a code generator for a specific
 * programming language
 */
public interface ILangCodegen {

	/**
	 * FILE KIND enumeration. It supports two distinction options (this might
	 * need revision in the future, but is sufficient for all currently
	 * supported languages)
	 */
	public enum FILE_KIND {
		HEADER, BODY
	}

	/**
	 * Provide a user friendly description of the generator
	 */
	public String getDescription();

	/**
	 * Some code generators use a non-trivial mapping from behaviors to methods in the generated code or
	 * add methods that are not part of a existing behavior in the model.
	 * This is a problem for code synchronization (update of model from code) as done for instance
	 * with the CDT editor integration.
	 * 
	 * @param methodName the name of the method as in the code
	 * @param body the body
	 * @return the associated synchronization information. Null indicates that a default mapping is used
	 */
	public SyncInformation getSyncInformation(String methodName, String body);
	
	/**
	 * Return true, if the generator is eligible for a certain type of model.
	 * The method may check for instance whether a certain profile (such as
	 * UML-RT) has been applied. Generators are allowed to return true for all
	 * models, if they do not have specific (profile related) requirements.
	 * 
	 * @param modelRoot
	 *            the root of a UML model (for which code should be generated)
	 * @return true, iff the generator is eligible for this model
	 */
	public boolean isEligible(Package modelRoot);

	/**
	 * Return the suffix of a code generator. Some languages use different
	 * suffixes depending on the file kind, e.g. C distinguishes between HEADER
	 * and BODY languages. Other languages can ignore this parameter.
	 * 
	 * @param FILE_KIND
	 *            The file kind
	 * @return
	 */
	public String getSuffix(FILE_KIND fileKind);

	/**
	 * Generate code for a specific language
	 *
	 * @param project
	 *            a project into which code is generated. if null, project is
	 *            determined automatically (see getTargetProject below)
	 * @param element
	 *            a packageable element, typically a classifier or a package
	 * @param monitor
	 *            a progress monitor
	 */
	public void generateCode(IProject project, PackageableElement element, IProgressMonitor monitor);

	/**
	 * Code might be generated into a specific project. It might be the project
	 * that hosts the UML file, but it may also be another project that is
	 * determined for instance by means of a naming convention (such as a common
	 * prefix and the name of the model). This functions locates and returns the
	 * target project for the given packageable element. If the project exists,
	 * but does not have the nature that is required by the language specific
	 * editor, the user is asked whether the nature should be added.
	 *
	 * Ensures that the target project is correctly setup to contain generated
	 * C/C++ code. Does not create a new project, but may modify existing ones.
	 *
	 * @param pe
	 *            a packageable element within a model
	 * @param createIfMissing
	 *            if true, a new project is created if it does not exist yet. if
	 *            false, null is returned if the project does not exist.
	 * @return the associated project (or null)
	 */
	public IProject getTargetProject(PackageableElement pe, boolean createIfMissing);

	/**
	 * Obtain fileName of file(s) generated for a named element. Delegates to
	 * location strategy. Caller must eventually add extensions.
	 * 
	 * @param project
	 *            a project into which code is generated. if null, project is
	 *            determined automatically
	 * @param element
	 *            a named element.
	 * @return a project relative file name
	 */
	public String getFileName(IProject project, NamedElement element);

	/**
	 * Clean the code for a certain element, i.e. remove code that has
	 * previously generated for this element This code is required for
	 * differential code generation which needs to remove elements for instance
	 * after they have been renamed.
	 *
	 * @param project
	 *            project in which code should be generated
	 * @param element
	 *            the element for which the generate code should be removed
	 */
	public void cleanCode(IProject project, PackageableElement element, IProgressMonitor monitor);
}
