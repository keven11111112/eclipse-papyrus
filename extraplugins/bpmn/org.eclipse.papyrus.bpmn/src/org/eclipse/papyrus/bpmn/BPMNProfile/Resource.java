/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.Resource#getResourceParameters <em>Resource Parameters</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getResource()
 * @model
 * @generated
 */
public interface Resource extends ItemDefinition {
	/**
	 * Returns the value of the '<em><b>Resource Parameters</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Parameters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Parameters</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getResource_ResourceParameters()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ResourceParameter> getResourceParameters();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Resource::/resourceParameters : ResourceParameter [*] = class.ownedAcctribute with the stereotype <<ResourceParameter>> applied.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='Resource.resourceParameters'"
	 * @generated
	 */
	boolean ResourceresourceParameters(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Resource
