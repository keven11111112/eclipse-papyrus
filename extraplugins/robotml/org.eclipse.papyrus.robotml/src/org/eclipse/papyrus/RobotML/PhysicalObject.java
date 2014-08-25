/**
 */
package org.eclipse.papyrus.RobotML;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Physical Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotML.PhysicalObject#getEvelovesIn <em>Eveloves In</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.PhysicalObject#getHasSurface <em>Has Surface</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.PhysicalObject#getHeight <em>Height</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.PhysicalObject#getMass <em>Mass</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getPhysicalObject()
 * @model
 * @generated
 */
public interface PhysicalObject extends org.eclipse.papyrus.RobotML.System {
	/**
	 * Returns the value of the '<em><b>Eveloves In</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.RobotML.Environment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eveloves In</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Eveloves In</em>' reference list.
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getPhysicalObject_EvelovesIn()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Environment> getEvelovesIn();

	/**
	 * Returns the value of the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Surface</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Has Surface</em>' reference.
	 * @see #setHasSurface(Surface)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getPhysicalObject_HasSurface()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Surface getHasSurface();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.PhysicalObject#getHasSurface <em>Has Surface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Has Surface</em>' reference.
	 * @see #getHasSurface()
	 * @generated
	 */
	void setHasSurface(Surface value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Height</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getPhysicalObject_Height()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	float getHeight();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.PhysicalObject#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(float value);

	/**
	 * Returns the value of the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mass</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Mass</em>' attribute.
	 * @see #setMass(float)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getPhysicalObject_Mass()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	float getMass();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.PhysicalObject#getMass <em>Mass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Mass</em>' attribute.
	 * @see #getMass()
	 * @generated
	 */
	void setMass(float value);

} // PhysicalObject
