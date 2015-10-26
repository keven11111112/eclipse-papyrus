/**
 * Copyright (c) 2015 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 */
package org.eclipse.papyrus.aof.sync.emf.syncmapping.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.aof.sync.AbstractMapping;
import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.SyncMappingPackage
 * @generated
 */
public class SyncMappingSwitch<T1> extends Switch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SyncMappingPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SyncMappingSwitch() {
		if (modelPackage == null) {
			modelPackage = SyncMappingPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T1 doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case SyncMappingPackage.MAPPING_INSTANCE: {
			MappingInstance<?, ?> mappingInstance = (MappingInstance<?, ?>) theEObject;
			T1 result = caseMappingInstance(mappingInstance);
			if (result == null) {
				result = caseInternalInstance(mappingInstance);
			}
			if (result == null) {
				result = caseIMappingInstance(mappingInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case SyncMappingPackage.IMAPPING_INSTANCE: {
			IMapping.Instance<?, ?> iMappingInstance = (IMapping.Instance<?, ?>) theEObject;
			T1 result = caseIMappingInstance(iMappingInstance);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case SyncMappingPackage.INTERNAL_INSTANCE: {
			AbstractMapping.InternalInstance<?, ?> internalInstance = (AbstractMapping.InternalInstance<?, ?>) theEObject;
			T1 result = caseInternalInstance(internalInstance);
			if (result == null) {
				result = caseIMappingInstance(internalInstance);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case SyncMappingPackage.INTERNAL_EOBJECT: {
			InternalEObject internalEObject = (InternalEObject) theEObject;
			T1 result = caseInternalEObject(internalEObject);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case SyncMappingPackage.MAPPING_MODEL: {
			MappingModel mappingModel = (MappingModel) theEObject;
			T1 result = caseMappingModel(mappingModel);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <F, T> T1 caseMappingInstance(MappingInstance<F, T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IMapping Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IMapping Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <F, T> T1 caseIMappingInstance(IMapping.Instance<F, T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Internal Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Internal Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <F, T> T1 caseInternalInstance(AbstractMapping.InternalInstance<F, T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Internal EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Internal EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseInternalEObject(InternalEObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMappingModel(MappingModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T1 defaultCase(EObject object) {
		return null;
	}

} //SyncMappingSwitch
