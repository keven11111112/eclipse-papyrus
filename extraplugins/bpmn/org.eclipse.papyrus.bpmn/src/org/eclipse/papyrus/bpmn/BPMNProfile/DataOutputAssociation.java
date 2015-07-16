/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Output Association</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getDataOutputAssociation()
 * @model
 * @generated
 */
public interface DataOutputAssociation extends DataAssociation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The source of DataAssociation shall be DataOutput
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='dataOutputAssociation.source'"
	 * @generated
	 */
	boolean dataOutputAssociationsource(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The target of DataAssociation can be every item-aware element visible to the current scope, e.g. a Data Object, a
	 * Property or an Expression.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='dataOutputAssociation.target'"
	 * @generated
	 */
	boolean dataOutputAssociationtarget(DiagnosticChain diagnostics, Map<Object, Object> context);

} // DataOutputAssociation
