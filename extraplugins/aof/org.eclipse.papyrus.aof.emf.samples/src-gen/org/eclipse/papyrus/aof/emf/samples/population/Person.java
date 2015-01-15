/**
 * Copyright (c) 2015 ESEO.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Olivier Beaudoux - code generated from model Population.ecore
 * 
 */
package org.eclipse.papyrus.aof.emf.samples.population;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.aof.emf.samples.population.Person#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.aof.emf.samples.population.Person#getBirthDay <em>Birth Day</em>}</li>
 *   <li>{@link org.eclipse.papyrus.aof.emf.samples.population.Person#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.papyrus.aof.emf.samples.population.Person#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.aof.emf.samples.population.Person#getSpouse <em>Spouse</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.aof.emf.samples.population.PopulationPackage#getPerson()
 * @model
 * @generated
 */
public interface Person extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.aof.emf.samples.population.PopulationPackage#getPerson_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.aof.emf.samples.population.Person#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Birth Day</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Birth Day</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Birth Day</em>' attribute.
	 * @see #setBirthDay(Date)
	 * @see org.eclipse.papyrus.aof.emf.samples.population.PopulationPackage#getPerson_BirthDay()
	 * @model required="true"
	 * @generated
	 */
	Date getBirthDay();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.aof.emf.samples.population.Person#getBirthDay <em>Birth Day</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Birth Day</em>' attribute.
	 * @see #getBirthDay()
	 * @generated
	 */
	void setBirthDay(Date value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.aof.emf.samples.population.Person}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.aof.emf.samples.population.Person#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see org.eclipse.papyrus.aof.emf.samples.population.PopulationPackage#getPerson_Children()
	 * @see org.eclipse.papyrus.aof.emf.samples.population.Person#getParent
	 * @model opposite="parent"
	 * @generated
	 */
	EList<Person> getChildren();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.aof.emf.samples.population.Person#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(Person)
	 * @see org.eclipse.papyrus.aof.emf.samples.population.PopulationPackage#getPerson_Parent()
	 * @see org.eclipse.papyrus.aof.emf.samples.population.Person#getChildren
	 * @model opposite="children"
	 * @generated
	 */
	Person getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.aof.emf.samples.population.Person#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Person value);

	/**
	 * Returns the value of the '<em><b>Spouse</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spouse</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spouse</em>' reference.
	 * @see #setSpouse(Person)
	 * @see org.eclipse.papyrus.aof.emf.samples.population.PopulationPackage#getPerson_Spouse()
	 * @model
	 * @generated
	 */
	Person getSpouse();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.aof.emf.samples.population.Person#getSpouse <em>Spouse</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spouse</em>' reference.
	 * @see #getSpouse()
	 * @generated
	 */
	void setSpouse(Person value);

} // Person
