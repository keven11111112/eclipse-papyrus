/*******************************************************************************
 * Copyright (c) 2005, 2020 Borland Software Corporation, CEA LIST, ARTAL
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 * 
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *     Borland - initial API and implementation
 *     Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.gmf.mappings;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Child Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.ChildReference#getParentNode <em>Parent Node</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.ChildReference#getCompartment <em>Compartment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.ChildReference#getOwnedChild <em>Owned Child</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.ChildReference#getReferencedChild <em>Referenced Child</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getChildReference()
 * @model annotation="http://www.eclipse.org/gmf/2005/constraints ocl='not (ownedChild.oclIsUndefined() and referencedChild.oclIsUndefined())' description='Either \'ownedChild\' or \'referencedChild\' NodeMapping must be set'"
 *        annotation="http://www.eclipse.org/gmf/2005/constraints ocl='not childrenFeature.oclIsUndefined() implies childrenFeature.eContainingClass.isSuperTypeOf(parentNode.domainMetaElement)' description='\'Children Feature\' must be owned by \'Domain Meta Element\' or its super type of this reference parent Node Mapping'"
 *        annotation="http://www.eclipse.org/gmf/2005/constraints ocl='not containmentFeature.oclIsUndefined() implies containmentFeature.eContainingClass.isSuperTypeOf(parentNode.domainMetaElement)' description='\'Containment Feature\' must be owned by \'Domain Meta Element\' or its super type of this reference parent Node Mapping'"
 *        annotation="http://www.eclipse.org/gmf/2005/constraints ocl='not child.getDomainContext().oclIsUndefined() implies not containmentFeature.oclIsUndefined()' description='ChildReference to NodeMapping with domainElement should define \'containmentFeature\''"
 *        annotation="http://www.eclipse.org/gmf/2005/constraints ocl='let child:NodeMapping=(if ownedChild.oclIsUndefined() then referencedChild else ownedChild endif) in (((child.labelMappings->size() = 1) and child.labelMappings->forAll( soleLabel: LabelMapping | soleLabel.diagramLabel = child.diagramNode)) implies (child.diagramNode.affixedParentSide = gmfgraph::Direction::NONE))' description='Side-affixed children can not be pure labels'"
 *        annotation="http://www.eclipse.org/gmf/2005/constraints ocl='let child:NodeMapping=(if ownedChild.oclIsUndefined() then referencedChild else ownedChild endif) in ((not compartment.oclIsUndefined()) implies (child.diagramNode.affixedParentSide = gmfgraph::Direction::NONE))' description='Side-affixed children can not be placed in compartments'"
 * @generated
 */
public interface ChildReference extends NodeReference {
	/**
	 * Returns the value of the '<em><b>Parent Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.gmf.mappings.NodeMapping#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Node</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Node</em>' container reference.
	 * @see #setParentNode(NodeMapping)
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getChildReference_ParentNode()
	 * @see org.eclipse.papyrus.gmf.mappings.NodeMapping#getChildren
	 * @model opposite="children" required="true" transient="false"
	 * @generated
	 */
	NodeMapping getParentNode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.mappings.ChildReference#getParentNode <em>Parent Node</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Node</em>' container reference.
	 * @see #getParentNode()
	 * @generated
	 */
	void setParentNode(NodeMapping value);

	/**
	 * Returns the value of the '<em><b>Compartment</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.gmf.mappings.CompartmentMapping#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compartment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compartment</em>' reference.
	 * @see #setCompartment(CompartmentMapping)
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getChildReference_Compartment()
	 * @see org.eclipse.papyrus.gmf.mappings.CompartmentMapping#getChildren
	 * @model opposite="children"
	 * @generated
	 */
	CompartmentMapping getCompartment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.mappings.ChildReference#getCompartment <em>Compartment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compartment</em>' reference.
	 * @see #getCompartment()
	 * @generated
	 */
	void setCompartment(CompartmentMapping value);

	/**
	 * Returns the value of the '<em><b>Owned Child</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Child</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Child</em>' containment reference.
	 * @see #setOwnedChild(NodeMapping)
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getChildReference_OwnedChild()
	 * @model containment="true"
	 * @generated
	 */
	NodeMapping getOwnedChild();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.mappings.ChildReference#getOwnedChild <em>Owned Child</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Child</em>' containment reference.
	 * @see #getOwnedChild()
	 * @generated
	 */
	void setOwnedChild(NodeMapping value);

	/**
	 * Returns the value of the '<em><b>Referenced Child</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Child</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Child</em>' reference.
	 * @see #setReferencedChild(NodeMapping)
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getChildReference_ReferencedChild()
	 * @model
	 * @generated
	 */
	NodeMapping getReferencedChild();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.mappings.ChildReference#getReferencedChild <em>Referenced Child</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Child</em>' reference.
	 * @see #getReferencedChild()
	 * @generated
	 */
	void setReferencedChild(NodeMapping value);

} // ChildReference
