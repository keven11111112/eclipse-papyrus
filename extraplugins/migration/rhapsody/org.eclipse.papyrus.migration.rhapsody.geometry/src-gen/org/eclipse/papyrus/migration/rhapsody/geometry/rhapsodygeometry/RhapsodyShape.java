/**
 *   Copyright (c) 2016 CEA LIST and others.
 *   
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *     CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rhapsody Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * All the values are expressed in the root coordinate system (transformation matrixes are applied)
 * The only attribute to set is the rhapsodyMetamodelObject. All the other attributes will be derived from it if possible.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getTransform <em>Transform</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getRectangle <em>Rectangle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getRhapsodyMetamodelObject <em>Rhapsody Metamodel Object</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getParentRelativePosition <em>Parent Relative Position</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getAbsolutePosition <em>Absolute Position</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryPackage#getRhapsodyShape()
 * @model
 * @generated
 */
public interface RhapsodyShape extends EObject {
	/**
	 * Returns the value of the '<em><b>Transform</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transform</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transform</em>' containment reference.
	 * @see #setTransform(TransformMatrix)
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryPackage#getRhapsodyShape_Transform()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	TransformMatrix getTransform();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getTransform <em>Transform</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transform</em>' containment reference.
	 * @see #getTransform()
	 * @generated
	 */
	void setTransform(TransformMatrix value);

	/**
	 * Returns the value of the '<em><b>Rectangle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rectangle</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rectangle</em>' containment reference.
	 * @see #setRectangle(Rectangle)
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryPackage#getRhapsodyShape_Rectangle()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Rectangle getRectangle();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getRectangle <em>Rectangle</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rectangle</em>' containment reference.
	 * @see #getRectangle()
	 * @generated
	 */
	void setRectangle(Rectangle value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(RhapsodyShape)
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryPackage#getRhapsodyShape_Parent()
	 * @model ordered="false"
	 * @generated
	 */
	RhapsodyShape getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(RhapsodyShape value);

	/**
	 * Returns the value of the '<em><b>Rhapsody Metamodel Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rhapsody Metamodel Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rhapsody Metamodel Object</em>' reference.
	 * @see #setRhapsodyMetamodelObject(EObject)
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryPackage#getRhapsodyShape_RhapsodyMetamodelObject()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EObject getRhapsodyMetamodelObject();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getRhapsodyMetamodelObject <em>Rhapsody Metamodel Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rhapsody Metamodel Object</em>' reference.
	 * @see #getRhapsodyMetamodelObject()
	 * @generated
	 */
	void setRhapsodyMetamodelObject(EObject value);

	/**
	 * Returns the value of the '<em><b>Parent Relative Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Relative Position</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Relative Position</em>' containment reference.
	 * @see #setParentRelativePosition(Point)
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryPackage#getRhapsodyShape_ParentRelativePosition()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Point getParentRelativePosition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getParentRelativePosition <em>Parent Relative Position</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Relative Position</em>' containment reference.
	 * @see #getParentRelativePosition()
	 * @generated
	 */
	void setParentRelativePosition(Point value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(Integer)
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryPackage#getRhapsodyShape_Height()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Integer getHeight();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(Integer value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(Integer)
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryPackage#getRhapsodyShape_Width()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Integer getWidth();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(Integer value);

	/**
	 * Returns the value of the '<em><b>Absolute Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Absolute Position</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Absolute Position</em>' containment reference.
	 * @see #setAbsolutePosition(Point)
	 * @see org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryPackage#getRhapsodyShape_AbsolutePosition()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Point getAbsolutePosition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhapsodyShape#getAbsolutePosition <em>Absolute Position</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Absolute Position</em>' containment reference.
	 * @see #getAbsolutePosition()
	 * @generated
	 */
	void setAbsolutePosition(Point value);

} // RhapsodyShape
