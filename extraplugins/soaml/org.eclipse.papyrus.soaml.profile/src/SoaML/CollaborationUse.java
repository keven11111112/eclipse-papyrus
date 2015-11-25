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
package SoaML;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collaboration Use</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link SoaML.CollaborationUse#getBase_CollaborationUse <em>Base Collaboration Use</em>}</li>
 *   <li>{@link SoaML.CollaborationUse#isIsStrict <em>Is Strict</em>}</li>
 * </ul>
 *
 * @see SoaML.SoaMLPackage#getCollaborationUse()
 * @model
 * @generated
 */
public interface CollaborationUse extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Collaboration Use</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Collaboration Use</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Collaboration Use</em>' reference.
	 * @see #setBase_CollaborationUse(org.eclipse.uml2.uml.CollaborationUse)
	 * @see SoaML.SoaMLPackage#getCollaborationUse_Base_CollaborationUse()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.CollaborationUse getBase_CollaborationUse();

	/**
	 * Sets the value of the '{@link SoaML.CollaborationUse#getBase_CollaborationUse <em>Base Collaboration Use</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Collaboration Use</em>' reference.
	 * @see #getBase_CollaborationUse()
	 * @generated
	 */
	void setBase_CollaborationUse(org.eclipse.uml2.uml.CollaborationUse value);

	/**
	 * Returns the value of the '<em><b>Is Strict</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Strict</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Strict</em>' attribute.
	 * @see #setIsStrict(boolean)
	 * @see SoaML.SoaMLPackage#getCollaborationUse_IsStrict()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsStrict();

	/**
	 * Sets the value of the '{@link SoaML.CollaborationUse#isIsStrict <em>Is Strict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Strict</em>' attribute.
	 * @see #isIsStrict()
	 * @generated
	 */
	void setIsStrict(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='--only in case of defining Contract collaboratinUse inside the ServiceInterface\r\n--If the CollaborationUse has isStrict=true, then the parts must be compatible with the roles they are bound to.\r\nself.isStrict=true and self.base_CollaborationUse.owner.oclIsTypeOf(Classifier) \r\nand  self.base_CollaborationUse.type.oclAsType(UML::Collaboration).getAppliedStereotypes()->select(s|s.name=\'ServiceContract\')->size()=1 implies\r\n--For parts to be compatible with a role, one of the following must be true:\r\n--1. The role and part have the same type.\r\nself.base_CollaborationUse.roleBinding-> forAll(rb|\r\n\t(let supplierType =(rb.oclAsType(UML::Dependency).supplier->select(s|s.oclIsTypeOf(UML::Property))->select(s|s.oclAsType(UML::Property).type.oclIsTypeOf(Class))\r\n\t->collect(oclAsType(UML::Property).type ->asOrderedSet()->first())),\r\n\tclientType= (rb.oclAsType(UML::Dependency).client->select(s|s.oclIsTypeOf(UML::Property))->collect(t:UML::NamedElement|t.oclAsType(UML::Property).type)->asOrderedSet()->first())in (\r\n\tsupplierType= clientType\r\n--2. The part (the supplier) has a type that specializes the type of the role.\r\nor(clientType.oclAsType(Classifier).generalization.general->closure(general)->includes(supplierType)) \r\n--3. The part has a type that realizes the type of the role.\r\nor(clientType.oclAsType(Classifier).getRelationships().oclAsType(UML::Realization)->includes(supplierType)) \r\n--4. The part has a type that contains at least the ownedAttributes and ownedOperations of the role. In general this is a\r\n--special case of item 3 where the part has an Interface type that realizes another Interface.\r\nor(supplierType.oclAsType(Classifier).getAllAttributes()->includesAll(clientType.oclAsType(Classifier).getAllAttributes()) \r\n\tand supplierType.oclAsType(Classifier).getAllOperations()->includesAll(clientType.oclAsType(Classifier).getAllOperations())\r\n) )\r\n--5. The type of each role in a service contract shall have a uses dependency to the type of all roles that role is connected to.\r\n)\r\n)'"
	 * @generated
	 */
	boolean RoleBindingClientSupplierCompatibility(DiagnosticChain diagnostics, Map<Object, Object> context);

} // CollaborationUse
