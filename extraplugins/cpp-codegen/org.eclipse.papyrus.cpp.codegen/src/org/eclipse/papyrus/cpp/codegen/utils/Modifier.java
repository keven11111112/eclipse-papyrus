/*******************************************************************************
 * Copyright (c) 2006 - 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.cpp.codegen.utils;

import org.eclipse.papyrus.cpp.codegen.preferences.CppCodeGenUtils;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;

import Cpp.CppArray;
import Cpp.CppConst;
import Cpp.CppPtr;
import Cpp.CppRef;

/**
 * Utility functions managing the "modifier" of an element, i.e. additional information whether a passed
 * parameter or an attribute is a pointer, a reference, an array or constant.
 * 
 * @author ansgar
 * 
 */
public class Modifier {

	public String ptr;

	public String ref;

	public String array;

	public String isConst;

	public Modifier() {
		ptr = "";
		ref = "";
		array = "";
		isConst = "";
	}

	/**
	 * Create instance and initialize the ptr/ref/array/isConst attributes.
	 * 
	 * @param propertyOrParameter
	 */
	public Modifier(Element propertyOrParameter) {

		// Pointer
		CppPtr cppPtr = GenUtils.getApplication(propertyOrParameter, CppPtr.class);
		if(cppPtr != null) {
			ptr = (cppPtr.getDeclaration() != null) ? cppPtr.getDeclaration() : "*";
		} else {
			ptr = "";
		}

		// Ref
		ref = GenUtils.hasStereotype(propertyOrParameter, CppRef.class) ? "&" : "";
		boolean ptrOrRef = GenUtils.hasStereotype(propertyOrParameter, CppRef.class) ||
			GenUtils.hasStereotype(propertyOrParameter, CppPtr.class);

		// Array
		CppArray cppArray = GenUtils.getApplication(propertyOrParameter, CppArray.class);
		if(cppArray != null) {
			// explicit array definition
			array = (cppArray.getDefinition() != null) ? cppArray.getDefinition() : "[]";
		} else {
			// calculate array from multiplicity definition
			int multiplicity = 1;
			if(propertyOrParameter instanceof MultiplicityElement) {
				multiplicity = ((MultiplicityElement)propertyOrParameter).getUpper();
			}
			array = "";
			if(multiplicity == -1) {
				ptr += "*";
			} else if(multiplicity > 1) {
				array = "[" + multiplicity + "]";
			}
		}

		// out an inout parameter are realized by means of a pointer 
		if(propertyOrParameter instanceof Parameter) {
			ParameterDirectionKind directionKind = ((Parameter)propertyOrParameter).getDirection();
			if(directionKind == ParameterDirectionKind.IN_LITERAL) {
				ptr += " _IN_";
			}
			else if(directionKind == ParameterDirectionKind.OUT_LITERAL) {
				ptr += " _OUT_";
				if(!ptrOrRef) {
					ptr += CppCodeGenUtils.getOutInoutOp();
				}
			}
			else if(directionKind == ParameterDirectionKind.INOUT_LITERAL) {
				ptr += " _INOUT_";
				if(!ptrOrRef) {
					ptr += CppCodeGenUtils.getOutInoutOp();
				}
			}
		}
		// Const
		isConst = GenUtils.hasStereotype(propertyOrParameter, CppConst.class) ? "const " : "";
	}
}
