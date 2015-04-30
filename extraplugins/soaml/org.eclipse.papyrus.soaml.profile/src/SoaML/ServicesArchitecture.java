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
import org.eclipse.uml2.uml.Image;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Services Architecture</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see SoaML.SoaMLPackage#getServicesArchitecture()
 * @model
 * @generated
 */
public interface ServicesArchitecture extends Collaboration {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * let properties : Set (UML::ConnectableElement) = self.base_Collaboration.role,
	 * collBUses: Set(UML::Element)= self.base_Collaboration.collaborationUse in
	 * collBUses->notEmpty() implies 
	 * -- Each participant satisfying roles in a ServicesArchitecture shall have a port for each role binding attached to that participant. 
	 * --This port shall have a type compliant with the type of the role used in the ServiceContract.
	 * collBUses.oclAsType(UML::CollaborationUse).roleBinding-> forAll(rb| let 
	 * 	portTypesOfSupplier=	rb.oclAsType(UML::Dependency).supplier->select(s|s.oclIsTypeOf(UML::Property))->select(s|s.oclAsType(UML::Property).type.oclIsTypeOf(Class))->collect(oclAsType(UML::Property).type.oclAsType(Class).getAllAttributes())->select(att|att.oclIsTypeOf(UML::Port))->collect(oclAsType(UML::Port).type) , clientType=rb.oclAsType(UML::Dependency).client->select(s|s.oclIsTypeOf(UML::Property))->collect(t:UML::NamedElement|t.oclAsType(UML::Property).type)->asOrderedSet()->first()in 	
	 * portTypesOfSupplier->includes(clientType)--1. The role correspond to a port type on the supplier.
	 * --2. the supplier has a port type that specializes the type of the role.
	 * or(clientType.oclAsType(Classifier).generalization.general->closure(general)->includes(portTypesOfSupplier)) 
	 * --3. the supplier has a port type that realizes the type of the role.
	 * or(clientType.oclAsType(Classifier).getRelationships().oclAsType(UML::Realization)->includes(portTypesOfSupplier)) 
	 * --4. the supplier has a port type that contains at least the ownedAttributes and ownedOperations of the role.
	 * or(portTypesOfSupplier.oclAsType(Classifier).getAllAttributes()->includesAll(clientType.oclAsType(Classifier).getAllAttributes()) 
	 * 	and portTypesOfSupplier.oclAsType(Classifier).getAllOperations()->includesAll(clientType.oclAsType(Classifier).getAllOperations())
	 * ) )
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean participantsRoleCompatibility(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * let properties : Set (UML::ConnectableElement) = self.base_Collaboration.role,
	 * collBUses: Set(UML::Element)= self.base_Collaboration.collaborationUse in
	 * properties->notEmpty() implies 
	 * properties-> forAll(p|p.type->exists(p|p.getAppliedStereotypes()->select(s|s.name='Participant' or s.name='Capability')->size()=1) )
	 * 
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	 
	boolean partsTypes(DiagnosticChain diagnostics, Map<Object, Object> context);
} // ServicesArchitecture
