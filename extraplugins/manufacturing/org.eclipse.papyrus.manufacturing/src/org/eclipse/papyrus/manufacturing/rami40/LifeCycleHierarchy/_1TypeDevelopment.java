/**
 */
package org.eclipse.papyrus.manufacturing.rami40.LifeCycleHierarchy;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>1Type Development</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.manufacturing.rami40.LifeCycleHierarchy._1TypeDevelopment#getBase_Package <em>Base Package</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.manufacturing.rami40.LifeCycleHierarchy.LifeCycleHierarchyPackage#get_1TypeDevelopment()
 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='1-TypeDevelopment'"
 * @generated
 */
public interface _1TypeDevelopment extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Package</em>' reference.
	 * @see #setBase_Package(org.eclipse.uml2.uml.Package)
	 * @see org.eclipse.papyrus.manufacturing.rami40.LifeCycleHierarchy.LifeCycleHierarchyPackage#get_1TypeDevelopment_Base_Package()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.manufacturing.rami40.LifeCycleHierarchy._1TypeDevelopment#getBase_Package <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Package</em>' reference.
	 * @see #getBase_Package()
	 * @generated
	 */
	void setBase_Package(org.eclipse.uml2.uml.Package value);

} // _1TypeDevelopment
