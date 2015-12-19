/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.uml2.uml.ForkNode;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.StructuredActivityNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Based Gateway</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGateway#isInstantiate <em>Instantiate</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGateway#getEventGatewayType <em>Event Gateway Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGateway#getBase_ForkNode <em>Base Fork Node</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGateway#getBase_StructuredActivityNode <em>Base Structured Activity Node</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGateway#getBase_InterruptibleActivityRegion <em>Base Interruptible Activity Region</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getEventBasedGateway()
 * @model
 * @generated
 */
public interface EventBasedGateway extends Gateway {
	/**
	 * Returns the value of the '<em><b>Instantiate</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instantiate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instantiate</em>' attribute.
	 * @see #setInstantiate(boolean)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getEventBasedGateway_Instantiate()
	 * @model default="false" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isInstantiate();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGateway#isInstantiate <em>Instantiate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instantiate</em>' attribute.
	 * @see #isInstantiate()
	 * @generated
	 */
	void setInstantiate(boolean value);

	/**
	 * Returns the value of the '<em><b>Event Gateway Type</b></em>' attribute.
	 * The default value is <code>"exclusive"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGatewayType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Gateway Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Gateway Type</em>' attribute.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGatewayType
	 * @see #setEventGatewayType(EventBasedGatewayType)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getEventBasedGateway_EventGatewayType()
	 * @model default="exclusive" required="true" ordered="false"
	 * @generated
	 */
	EventBasedGatewayType getEventGatewayType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGateway#getEventGatewayType <em>Event Gateway Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Gateway Type</em>' attribute.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGatewayType
	 * @see #getEventGatewayType()
	 * @generated
	 */
	void setEventGatewayType(EventBasedGatewayType value);

	/**
	 * Returns the value of the '<em><b>Base Fork Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Fork Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Fork Node</em>' reference.
	 * @see #setBase_ForkNode(ForkNode)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getEventBasedGateway_Base_ForkNode()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ForkNode getBase_ForkNode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGateway#getBase_ForkNode <em>Base Fork Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Fork Node</em>' reference.
	 * @see #getBase_ForkNode()
	 * @generated
	 */
	void setBase_ForkNode(ForkNode value);

	/**
	 * Returns the value of the '<em><b>Base Structured Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Structured Activity Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Structured Activity Node</em>' reference.
	 * @see #setBase_StructuredActivityNode(StructuredActivityNode)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getEventBasedGateway_Base_StructuredActivityNode()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	StructuredActivityNode getBase_StructuredActivityNode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGateway#getBase_StructuredActivityNode <em>Base Structured Activity Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Structured Activity Node</em>' reference.
	 * @see #getBase_StructuredActivityNode()
	 * @generated
	 */
	void setBase_StructuredActivityNode(StructuredActivityNode value);

	/**
	 * Returns the value of the '<em><b>Base Interruptible Activity Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Interruptible Activity Region</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Interruptible Activity Region</em>' reference.
	 * @see #setBase_InterruptibleActivityRegion(InterruptibleActivityRegion)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getEventBasedGateway_Base_InterruptibleActivityRegion()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	InterruptibleActivityRegion getBase_InterruptibleActivityRegion();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGateway#getBase_InterruptibleActivityRegion <em>Base Interruptible Activity Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Interruptible Activity Region</em>' reference.
	 * @see #getBase_InterruptibleActivityRegion()
	 * @generated
	 */
	void setBase_InterruptibleActivityRegion(InterruptibleActivityRegion value);

} // EventBasedGateway
