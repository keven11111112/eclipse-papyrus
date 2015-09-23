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
package org.eclipse.papyrus.aof.sync.emf.syncmapping;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.aof.core.IOne;

import org.eclipse.papyrus.aof.core.utils.ObserverTracker;

import org.eclipse.papyrus.aof.sync.AbstractMapping;
import org.eclipse.papyrus.aof.sync.IMapping;

import org.eclipse.papyrus.aof.sync.IMapping.Instance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance#getRight <em>Right</em>}</li>
 *   <li>{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance#getConsequents <em>Consequent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance#getTracker <em>Tracker</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.SyncMappingPackage#getMappingInstance()
 * @model superTypes="org.eclipse.papyrus.aof.sync.emf.syncmapping.InternalInstance<F, T>"
 * @generated
 */
public interface MappingInstance<F, T> extends EObject, AbstractMapping.InternalInstance<F, T> {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(IMapping)
	 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.SyncMappingPackage#getMappingInstance_Type()
	 * @model dataType="org.eclipse.papyrus.aof.sync.emf.syncmapping.Mapping<F, T>" required="true" ordered="false"
	 * @generated
	 */
	IMapping<F, T> getType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(IMapping<F, T> value);

	/**
	 * Returns the value of the '<em><b>Left</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' attribute.
	 * @see #setLeft(IOne)
	 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.SyncMappingPackage#getMappingInstance_Left()
	 * @model dataType="org.eclipse.papyrus.aof.sync.emf.syncmapping.One<F>" required="true" ordered="false"
	 * @generated
	 */
	IOne<F> getLeft();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance#getLeft <em>Left</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' attribute.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(IOne<F> value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' attribute.
	 * @see #setRight(IOne)
	 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.SyncMappingPackage#getMappingInstance_Right()
	 * @model dataType="org.eclipse.papyrus.aof.sync.emf.syncmapping.One<T>" required="true" ordered="false"
	 * @generated
	 */
	IOne<T> getRight();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance#getRight <em>Right</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' attribute.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(IOne<T> value);

	/**
	 * Returns the value of the '<em><b>Consequent</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.aof.sync.IMapping.Instance}&lt;?, ?>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Consequent</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Consequent</em>' containment reference list.
	 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.SyncMappingPackage#getMappingInstance_Consequent()
	 * @model type="org.eclipse.papyrus.aof.sync.emf.syncmapping.IMappingInstance<?, ?>" containment="true" ordered="false"
	 * @generated
	 */
	EList<Instance<?, ?>> getConsequents();

	/**
	 * Returns the value of the '<em><b>Tracker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tracker</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tracker</em>' attribute.
	 * @see #setTracker(ObserverTracker)
	 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.SyncMappingPackage#getMappingInstance_Tracker()
	 * @model dataType="org.eclipse.papyrus.aof.sync.emf.syncmapping.ObserverTracker" required="true" ordered="false"
	 * @generated
	 */
	ObserverTracker getTracker();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance#getTracker <em>Tracker</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tracker</em>' attribute.
	 * @see #getTracker()
	 * @generated
	 */
	void setTracker(ObserverTracker value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model consequentType="org.eclipse.papyrus.aof.sync.emf.syncmapping.IMappingInstance<?, ?>" consequentRequired="true" consequentOrdered="false"
	 * @generated
	 */
	void addConsequent(Instance<?, ?> consequent);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void destroy();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.papyrus.aof.sync.emf.syncmapping.Iterator<org.eclipse.papyrus.aof.sync.emf.syncmapping.IMappingInstance<?, ?>>" required="true" ordered="false"
	 * @generated
	 */
	Iterator<Instance<?, ?>> iterator();

} // MappingInstance
