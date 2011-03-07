/**
 * 
 *  Copyright (c) 2010 CEA LIST.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Tatiana Fesenko(CEA LIST) - initial API and implementation
 */
package org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl;

import org.eclipse.emf.compare.diff.merge.IMerger;
import org.eclipse.emf.compare.diff.metamodel.impl.AbstractDiffExtensionImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.StyledString;

import org.eclipse.papyrus.compare.UMLCompareUtils;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffExtension;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class UMLDiffExtensionImpl extends AbstractDiffExtensionImpl implements UMLDiffExtension {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UMLDiffExtensionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDiffPackage.Literals.UML_DIFF_EXTENSION;
	}
	
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @NOT-generated
	 */
	@Override
	public String getText() {
		StyledString result = UMLCompareUtils.getInstance().getDiffLabelSwitch().doSwitch(this);
		if (result != null) {
			return result.getString();
		}
		return "<LABEL NOT FOUND>";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IMerger provideMerger() {
		return null;
	}



} //UMLDiffExtensionImpl
