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

import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Signal;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link SoaML.MessageType#getBase_Signal <em>Base Signal</em>}</li>
 *   <li>{@link SoaML.MessageType#getEncoding <em>Encoding</em>}</li>
 *   <li>{@link SoaML.MessageType#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link SoaML.MessageType#getBase_DataType <em>Base Data Type</em>}</li>
 * </ul>
 *
 * @see SoaML.SoaMLPackage#getMessageType()
 * @model
 * @generated
 */
public interface MessageType extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Signal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Signal</em>' reference.
	 * @see #setBase_Signal(Signal)
	 * @see SoaML.SoaMLPackage#getMessageType_Base_Signal()
	 * @model ordered="false"
	 * @generated
	 */
	Signal getBase_Signal();

	/**
	 * Sets the value of the '{@link SoaML.MessageType#getBase_Signal <em>Base Signal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Signal</em>' reference.
	 * @see #getBase_Signal()
	 * @generated
	 */
	void setBase_Signal(Signal value);

	/**
	 * Returns the value of the '<em><b>Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Encoding</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Encoding</em>' attribute.
	 * @see #setEncoding(String)
	 * @see SoaML.SoaMLPackage#getMessageType_Encoding()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getEncoding();

	/**
	 * Sets the value of the '{@link SoaML.MessageType#getEncoding <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Encoding</em>' attribute.
	 * @see #getEncoding()
	 * @generated
	 */
	void setEncoding(String value);

	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see SoaML.SoaMLPackage#getMessageType_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link SoaML.MessageType#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Data Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Data Type</em>' reference.
	 * @see #setBase_DataType(DataType)
	 * @see SoaML.SoaMLPackage#getMessageType_Base_DataType()
	 * @model ordered="false"
	 * @generated
	 */
	DataType getBase_DataType();

	/**
	 * Sets the value of the '{@link SoaML.MessageType#getBase_DataType <em>Base Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Data Type</em>' reference.
	 * @see #getBase_DataType()
	 * @generated
	 */
	void setBase_DataType(DataType value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.base_Class<>null  implies self.base_Class.ownedBehavior->size()=0'"
	 * @generated
	 */
	boolean noOwnedBehaviors(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='if self.base_Class<>null \r\nthen self.base_Class.ownedOperation->size()=0  \r\nelse\r\n\t if self.base_DataType<>null \r\n\t then self.base_DataType.ownedOperation->size()=0\r\n\t else self.base_Signal<>null implies true endif  \r\nendif'"
	 * @generated
	 */
	boolean noOwnedOperations(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='if self.base_Class<>null then self.base_Class.attribute->size()>0 implies self.base_Class.attribute->forAll (a|a.visibility=UML::VisibilityKind::public)\r\n else \r\n\t  (if self.base_DataType<>null then \r\n\t\t  \tself.base_DataType.attribute->size()>0 implies self.base_DataType.attribute->forAll(a|a.visibility=UML::VisibilityKind::public)\r\n \t\telse \r\n  \t\t\tself.base_Signal.attribute->size()>0 implies self.base_Signal.attribute-> forAll (a|a.visibility=UML::VisibilityKind::public)\r\n\t\tendif)\r\n endif'"
	 * @generated
	 */
	boolean publicAttributes(DiagnosticChain diagnostics, Map<Object, Object> context);

} // MessageType
