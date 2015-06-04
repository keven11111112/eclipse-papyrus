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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Contract</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see SoaML.SoaMLPackage#getServiceContract()
 * @model
 * @generated
 */
public interface ServiceContract extends Collaboration {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 *   self.base_Collaboration.role-> notEmpty()  implies self.base_Collaboration.role-> forAll(role|
	 * 		role.type.oclIsTypeOf(UML::Interface) 
	 * 	or 
	 * 		(role.type.oclIsTypeOf(UML::Class)	and 
	 * 		(role.type.oclIsTypeOf(UML::Class) implies (role.type.getAppliedStereotypes()->select(s|s.name='Provider')->size()>0 
	 * 			and  role.type.getAppliedStereotypes()->select(s|s.name='Consumer') ->size()>0
	 * 		)
	 * 			or  role.type.getAppliedStereotypes()->select(s| s.name='ServiceInterface') ->size()>0
	 * 		))) 
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean RoleType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 *  self.base_Collaboration.ownedBehavior->size()=1 implies
	 * 	self.base_Collaboration.ownedBehavior->asOrderedSet()->first().oclIsTypeOf(UML::Interaction) implies
	 * 		let attachedInteraction=self.base_Collaboration.ownedBehavior->asOrderedSet()->first().oclAsType(UML::Interaction),
	 * 		lifelines=self.base_Collaboration.ownedBehavior->asOrderedSet()->first().oclAsType(UML::Interaction).lifeline,
	 * 		messages= self.base_Collaboration.ownedBehavior->asOrderedSet()->first().oclAsType(UML::Interaction).message,
	 * 		messOccuSpec=self.base_Collaboration.ownedBehavior->asOrderedSet()->first().oclAsType(UML::Interaction).fragment
	 * 		->select(f|f.oclIsTypeOf(MessageOccurrenceSpecification)) in 
	 * 		lifelines->size()>0 implies lifelines->forAll(l| self.base_Collaboration.role -> includes(l.oclAsType(UML::Lifeline).represents)  ) 
	 * 		and 
	 * 		messages->size()>0 implies messages->select(m|m.messageSort=MessageSort::asynchCall) 
	 * 		--signature of messages should be one of the operations or signal of the corresponding Service Declaration
	 * 		->forAll(m|m.signature.oclIsTypeOf(Operation) implies 
	 * 			m.receiveEvent->asOrderedSet()->first().oclAsType(MessageOccurrenceSpecification).covered->asOrderedSet()
	 * 			->first().oclAsType(Sequence)->asOrderedSet()->first().oclAsType(Lifeline).represents.type.oclAsType(Classifier).ownedElement->select(oclIsTypeOf(Operation))
	 * 			->includes(m.signature.oclAsType(Operation)) and 
	 * 				m.signature.oclIsTypeOf(Signal) implies 
	 * 				m.sendEvent->asOrderedSet()->first().oclAsType(MessageOccurrenceSpecification).covered->asOrderedSet()
	 * 				->first().oclAsType(Sequence)->asOrderedSet()->first().oclAsType(Lifeline).represents.type.oclAsType(Classifier).ownedElement->select(oclIsTypeOf(Signal))
	 * 			->includes(m.signature.oclAsType(Signal)
	 * 			))  
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean AttachedBehaviorCompatibility(DiagnosticChain diagnostics, Map<Object, Object> context);
} // ServiceContract
