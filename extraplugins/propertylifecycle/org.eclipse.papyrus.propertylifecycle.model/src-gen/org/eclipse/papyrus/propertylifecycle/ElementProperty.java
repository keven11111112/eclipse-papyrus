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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * These informations are used to select and edit the property
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.ElementProperty#getFeatureLabel <em>Feature Label</em>}</li>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.ElementProperty#getPriority <em>Priority</em>}</li>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.ElementProperty#getTriggers <em>Triggers</em>}</li>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.ElementProperty#getValueProcessor <em>Value Processor</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage#getElementProperty()
 * @model
 * @generated
 */
public interface ElementProperty extends EObject {
	/**
	 * Returns the value of the '<em><b>Feature Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Feature Label</em>' attribute.
	 * @see #setFeatureLabel(String)
	 * @see org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage#getElementProperty_FeatureLabel()
	 * @model required="true"
	 * @generated
	 */
	String getFeatureLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.propertylifecycle.ElementProperty#getFeatureLabel <em>Feature Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Feature Label</em>' attribute.
	 * @see #getFeatureLabel()
	 * @generated
	 */
	void setFeatureLabel(String value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(Integer)
	 * @see org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage#getElementProperty_Priority()
	 * @model default="0" required="true"
	 * @generated
	 */
	Integer getPriority();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.propertylifecycle.ElementProperty#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(Integer value);

	/**
	 * Returns the value of the '<em><b>Triggers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.propertylifecycle.AbstractTrigger}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Triggers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Triggers</em>' containment reference list.
	 * @see org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage#getElementProperty_Triggers()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<AbstractTrigger> getTriggers();

	/**
	 * Returns the value of the '<em><b>Value Processor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Processor</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Value Processor</em>' containment reference.
	 * @see #setValueProcessor(AbstractValueProcessor)
	 * @see org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage#getElementProperty_ValueProcessor()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	AbstractValueProcessor getValueProcessor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.propertylifecycle.ElementProperty#getValueProcessor <em>Value Processor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Value Processor</em>' containment reference.
	 * @see #getValueProcessor()
	 * @generated
	 */
	void setValueProcessor(AbstractValueProcessor value);

} // ElementProperty
