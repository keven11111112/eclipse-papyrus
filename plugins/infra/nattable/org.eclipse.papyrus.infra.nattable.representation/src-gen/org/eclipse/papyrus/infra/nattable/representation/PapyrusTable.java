/**
 * Copyright (c) 2017 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Maged Elaasar - Initial API and implementation
 *  
 * 
 */
package org.eclipse.papyrus.infra.nattable.representation;

import org.eclipse.papyrus.infra.architecture.representation.PapyrusRepresentationKind;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Papyrus Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A representation kind that depicts elements form a UML model as a table
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.representation.PapyrusTable#getConfiguration <em>Configuration</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.nattable.representation.RepresentationPackage#getPapyrusTable()
 * @model
 * @generated
 */
public interface PapyrusTable extends PapyrusRepresentationKind {
	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The configuration of the table
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Configuration</em>' reference.
	 * @see #setConfiguration(TableConfiguration)
	 * @see org.eclipse.papyrus.infra.nattable.representation.RepresentationPackage#getPapyrusTable_Configuration()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescription='The configuration of the table' propertyCategory='Table'"
	 * @generated
	 */
	TableConfiguration getConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.representation.PapyrusTable#getConfiguration <em>Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(TableConfiguration value);

} // PapyrusTable
