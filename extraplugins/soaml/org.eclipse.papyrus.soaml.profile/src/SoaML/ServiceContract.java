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
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body=' \r\nlet isComposit :  Boolean= self.base_Collaboration.ownedConnector->isEmpty()\r\n and self.base_Collaboration.getAllAttributes()\r\n->collect(oclAsType(UML::CollaborationUse))->notEmpty(),\r\nisSimple :Boolean=  self.base_Collaboration.getAllAttributes()\r\n->collect(oclAsType(UML::CollaborationUse))->isEmpty()\r\nin  self.base_Collaboration.role-> notEmpty() implies \r\nisSimple and  self.base_Collaboration.role-> forAll(role|\r\nrole.type.oclIsTypeOf(UML::Interface))\r\nor\r\nisComposit  and self.base_Collaboration.role->forAll(role|\r\nrole.type.oclIsTypeOf(UML::Interface) or\r\n(role.type.oclIsTypeOf(UML::Class)\tand\r\n(role.type.oclIsTypeOf(UML::Class) implies(role.type.getAppliedStereotypes()\r\n->select(s|s.name=\'Provider\' or s.name=\'Consumer\' \r\nor s.name=\'ServiceInterface\') ->size()=1))))\r\n'"
	 * @generated
	 */
	boolean RoleType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body=' self.base_Collaboration.ownedBehavior->size()>0 implies (\r\n\tself.base_Collaboration.ownedBehavior->asOrderedSet()->first().oclIsTypeOf(UML::Interaction) implies\r\n\t\tlet attachedInteraction=self.base_Collaboration.ownedBehavior->asOrderedSet()->first().oclAsType(UML::Interaction),\r\n\t\tlifelines=self.base_Collaboration.ownedBehavior->asOrderedSet()->first().oclAsType(UML::Interaction).lifeline,\r\n\t\tmessages= self.base_Collaboration.ownedBehavior->asOrderedSet()->first().oclAsType(UML::Interaction).message,\r\n\t\tmessOccuSpec=self.base_Collaboration.ownedBehavior->asOrderedSet()->first().oclAsType(UML::Interaction).fragment\r\n\t\t->select(f|f.oclIsTypeOf(MessageOccurrenceSpecification)) in \r\n\t\tlifelines->size()>0 implies lifelines->forAll(l| self.base_Collaboration.role -> includes(l.oclAsType(UML::Lifeline).represents)  ) \r\n\t\tand \r\n\t\tmessages->size()>0 implies messages\r\n\t\t--->select(m|m.messageSort=MessageSort::asynchCall) \r\n\t\t--signature of messages should be one of the operations or signal of the corresponding Service Declaration\r\n\t\t->forAll(m|m.signature.oclIsTypeOf(Operation) implies \r\n\t\t\tm.receiveEvent.oclAsType(MessageOccurrenceSpecification).covered->flatten()->asOrderedSet()\r\n\t\t\t->first().oclAsType(Lifeline).represents.type.oclAsType(Classifier).ownedElement->select(oclIsTypeOf(Operation))\r\n\t\t\t->includes(m.signature.oclAsType(Operation)) and \r\n\t\t\t\tm.signature.oclIsTypeOf(Signal) implies \r\n\t\t\t\tm.sendEvent->asOrderedSet()->first().oclAsType(MessageOccurrenceSpecification).covered->asOrderedSet()\r\n\t\t\t\t->first().oclAsType(Sequence)->asOrderedSet()->first().oclAsType(Lifeline).represents.type.oclAsType(Classifier).ownedElement\r\n\t\t\t\t->select(oclIsTypeOf(Signal))->includes(m.signature.oclAsType(Signal)\r\n\t\t\t))  )'"
	 * @generated
	 */
	boolean AttachedBehaviorCompatibility(DiagnosticChain diagnostics, Map<Object, Object> context);
} // ServiceContract
