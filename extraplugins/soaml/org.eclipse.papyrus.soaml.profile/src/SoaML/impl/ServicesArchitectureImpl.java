/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Fadwa TMAR (CEA LIST) fadwa.tmar@cea.fr - Initial API and implementation
 *****************************************************************************/
package SoaML.impl;

import SoaML.ServicesArchitecture;
import SoaML.SoaMLPackage;
import SoaML.util.SoaMLValidator;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.uml2.uml.Image;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Services Architecture</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ServicesArchitectureImpl extends CollaborationImpl implements ServicesArchitecture {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServicesArchitectureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SoaMLPackage.Literals.SERVICES_ARCHITECTURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean participantsRoleCompatibility(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 SoaMLValidator.DIAGNOSTIC_SOURCE,
						 SoaMLValidator.SERVICES_ARCHITECTURE__PARTICIPANTS_ROLE_COMPATIBILITY,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "participantsRoleCompatibility", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean partsTypes(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 SoaMLValidator.DIAGNOSTIC_SOURCE,
						 SoaMLValidator.SERVICES_ARCHITECTURE__PARTS_TYPES,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "partsTypes", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void getIcon(Image image) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SoaMLPackage.SERVICES_ARCHITECTURE___PARTICIPANTS_ROLE_COMPATIBILITY__DIAGNOSTICCHAIN_MAP:
				return participantsRoleCompatibility((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case SoaMLPackage.SERVICES_ARCHITECTURE___PARTS_TYPES__DIAGNOSTICCHAIN_MAP:
				return partsTypes((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case SoaMLPackage.SERVICES_ARCHITECTURE___GET_ICON__IMAGE:
				getIcon((Image)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //ServicesArchitectureImpl
