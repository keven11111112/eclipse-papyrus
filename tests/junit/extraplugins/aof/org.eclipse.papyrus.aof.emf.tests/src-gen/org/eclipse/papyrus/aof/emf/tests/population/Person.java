/*******************************************************************************
 *  Copyright (c) 2015 ESEO, Christian W. Damus, and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     ESEO - initial API and implementation
 *     Christian W. Damus - bug 476683
 *******************************************************************************/
package org.eclipse.papyrus.aof.emf.tests.population;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.aof.emf.tests.population.Person#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.aof.emf.tests.population.Person#getAge <em>Age</em>}</li>
 *   <li>{@link org.eclipse.papyrus.aof.emf.tests.population.Person#getEmails <em>Emails</em>}</li>
 *   <li>{@link org.eclipse.papyrus.aof.emf.tests.population.Person#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.aof.emf.tests.population.Person#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.papyrus.aof.emf.tests.population.Person#getFavorite <em>Favorite</em>}</li>
 *   <li>{@link org.eclipse.papyrus.aof.emf.tests.population.Person#getLockerCombination <em>Locker Combination</em>}</li>
 *   <li>{@link org.eclipse.papyrus.aof.emf.tests.population.Person#getAcquaintances <em>Acquaintances</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.aof.emf.tests.population.PopulationPackage#getPerson()
 * @model
 * @generated
 */
public interface Person extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"Name"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.aof.emf.tests.population.PopulationPackage#getPerson_Name()
	 * @model default="Name" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.aof.emf.tests.population.Person#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Age</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Age</em>' attribute.
	 * @see #setAge(int)
	 * @see org.eclipse.papyrus.aof.emf.tests.population.PopulationPackage#getPerson_Age()
	 * @model
	 * @generated
	 */
	int getAge();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.aof.emf.tests.population.Person#getAge <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Age</em>' attribute.
	 * @see #getAge()
	 * @generated
	 */
	void setAge(int value);

	/**
	 * Returns the value of the '<em><b>Emails</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Emails</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Emails</em>' attribute list.
	 * @see org.eclipse.papyrus.aof.emf.tests.population.PopulationPackage#getPerson_Emails()
	 * @model
	 * @generated
	 */
	EList<String> getEmails();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.aof.emf.tests.population.Person#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(Person)
	 * @see org.eclipse.papyrus.aof.emf.tests.population.PopulationPackage#getPerson_Parent()
	 * @see org.eclipse.papyrus.aof.emf.tests.population.Person#getChildren
	 * @model opposite="children"
	 * @generated
	 */
	Person getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.aof.emf.tests.population.Person#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Person value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.aof.emf.tests.population.Person}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.aof.emf.tests.population.Person#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see org.eclipse.papyrus.aof.emf.tests.population.PopulationPackage#getPerson_Children()
	 * @see org.eclipse.papyrus.aof.emf.tests.population.Person#getParent
	 * @model opposite="parent" ordered="false"
	 * @generated
	 */
	EList<Person> getChildren();

	/**
	 * Returns the value of the '<em><b>Favorite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Favorite</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Favorite</em>' reference.
	 * @see #isSetFavorite()
	 * @see #unsetFavorite()
	 * @see #setFavorite(Person)
	 * @see org.eclipse.papyrus.aof.emf.tests.population.PopulationPackage#getPerson_Favorite()
	 * @model unsettable="true"
	 * @generated
	 */
	Person getFavorite();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.aof.emf.tests.population.Person#getFavorite <em>Favorite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Favorite</em>' reference.
	 * @see #isSetFavorite()
	 * @see #unsetFavorite()
	 * @see #getFavorite()
	 * @generated
	 */
	void setFavorite(Person value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.aof.emf.tests.population.Person#getFavorite <em>Favorite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFavorite()
	 * @see #getFavorite()
	 * @see #setFavorite(Person)
	 * @generated
	 */
	void unsetFavorite();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.aof.emf.tests.population.Person#getFavorite <em>Favorite</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Favorite</em>' reference is set.
	 * @see #unsetFavorite()
	 * @see #getFavorite()
	 * @see #setFavorite(Person)
	 * @generated
	 */
	boolean isSetFavorite();

	/**
	 * Returns the value of the '<em><b>Locker Combination</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Locker Combination</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Locker Combination</em>' attribute list.
	 * @see org.eclipse.papyrus.aof.emf.tests.population.PopulationPackage#getPerson_LockerCombination()
	 * @model unique="false"
	 * @generated
	 */
	EList<Integer> getLockerCombination();

	/**
	 * Returns the value of the '<em><b>Acquaintances</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.aof.emf.tests.population.Person}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Acquaintances</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Acquaintances</em>' reference list.
	 * @see org.eclipse.papyrus.aof.emf.tests.population.PopulationPackage#getPerson_Acquaintances()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Person> getAcquaintances();

} // Person
