/**
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 * Quentin Le Menez (CEA LIST) quentin.lemenez@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.propertylifecycle;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Specify the basic triggers of an element's lifecycle
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.BasicTrigger#isOnCreate <em>On Create</em>}</li>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.BasicTrigger#isOnDelete <em>On Delete</em>}</li>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.BasicTrigger#isOnOpen <em>On Open</em>}</li>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.BasicTrigger#isOnMove <em>On Move</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage#getBasicTrigger()
 * @model
 * @generated
 */
public interface BasicTrigger extends AbstractTrigger {
	/**
	 * Returns the value of the '<em><b>On Create</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Create</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>On Create</em>' attribute.
	 * @see #setOnCreate(boolean)
	 * @see org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage#getBasicTrigger_OnCreate()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isOnCreate();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.propertylifecycle.BasicTrigger#isOnCreate <em>On Create</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>On Create</em>' attribute.
	 * @see #isOnCreate()
	 * @generated
	 */
	void setOnCreate(boolean value);

	/**
	 * Returns the value of the '<em><b>On Delete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Delete</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>On Delete</em>' attribute.
	 * @see #setOnDelete(boolean)
	 * @see org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage#getBasicTrigger_OnDelete()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isOnDelete();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.propertylifecycle.BasicTrigger#isOnDelete <em>On Delete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>On Delete</em>' attribute.
	 * @see #isOnDelete()
	 * @generated
	 */
	void setOnDelete(boolean value);

	/**
	 * Returns the value of the '<em><b>On Open</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Open</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>On Open</em>' attribute.
	 * @see #setOnOpen(boolean)
	 * @see org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage#getBasicTrigger_OnOpen()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isOnOpen();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.propertylifecycle.BasicTrigger#isOnOpen <em>On Open</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>On Open</em>' attribute.
	 * @see #isOnOpen()
	 * @generated
	 */
	void setOnOpen(boolean value);

	/**
	 * Returns the value of the '<em><b>On Move</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Move</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>On Move</em>' attribute.
	 * @see #setOnMove(boolean)
	 * @see org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage#getBasicTrigger_OnMove()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isOnMove();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.propertylifecycle.BasicTrigger#isOnMove <em>On Move</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>On Move</em>' attribute.
	 * @see #isOnMove()
	 * @generated
	 */
	void setOnMove(boolean value);

} // BasicTrigger
