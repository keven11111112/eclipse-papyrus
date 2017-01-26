/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.TypedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item Aware Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.ItemAwareElement#getDataState <em>Data State</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.ItemAwareElement#getBase_TypedElement <em>Base Typed Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.ItemAwareElement#getItemSubjectRef <em>Item Subject Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getItemAwareElement()
 * @model abstract="true"
 * @generated
 */
public interface ItemAwareElement extends BaseElement {
	/**
	 * Returns the value of the '<em><b>Data State</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.DataState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data State</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data State</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getItemAwareElement_DataState()
	 * @model ordered="false"
	 * @generated
	 */
	EList<DataState> getDataState();

	/**
	 * Returns the value of the '<em><b>Base Typed Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Typed Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Typed Element</em>' reference.
	 * @see #setBase_TypedElement(TypedElement)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getItemAwareElement_Base_TypedElement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	TypedElement getBase_TypedElement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ItemAwareElement#getBase_TypedElement <em>Base Typed Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Typed Element</em>' reference.
	 * @see #getBase_TypedElement()
	 * @generated
	 */
	void setBase_TypedElement(TypedElement value);

	/**
	 * Returns the value of the '<em><b>Item Subject Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item Subject Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item Subject Ref</em>' reference.
	 * @see #setItemSubjectRef(ItemDefinition)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getItemAwareElement_ItemSubjectRef()
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='itemSubjectRef '"
	 * @generated
	 */
	ItemDefinition getItemSubjectRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ItemAwareElement#getItemSubjectRef <em>Item Subject Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Item Subject Ref</em>' reference.
	 * @see #getItemSubjectRef()
	 * @generated
	 */
	void setItemSubjectRef(ItemDefinition value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * States extended by DataStates that are dataStates of item aware element stereotypes applied to ObjectNodes must be values of the inState property of the ObjectNodes, and vice versa.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='ItemAwareElement.dataState'"
	 * @generated
	 */
	boolean ItemAwareElementdataState(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ItemAwareElement
