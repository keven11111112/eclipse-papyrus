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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Population</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.aof.emf.samples.population.Population#getPersons <em>Persons</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.aof.emf.samples.population.PopulationPackage#getPopulation()
 * @model
 * @generated
 */
public interface Population extends EObject {
	/**
	 * Returns the value of the '<em><b>Persons</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.aof.emf.samples.population.Person}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Persons</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Persons</em>' containment reference list.
	 * @see org.eclipse.papyrus.aof.emf.samples.population.PopulationPackage#getPopulation_Persons()
	 * @model containment="true"
	 * @generated
	 */
	EList<Person> getPersons();

} // Population
