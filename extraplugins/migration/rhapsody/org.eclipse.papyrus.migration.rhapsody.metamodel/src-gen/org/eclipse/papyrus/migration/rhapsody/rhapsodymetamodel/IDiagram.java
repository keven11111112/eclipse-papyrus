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
package org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IDiagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDiagram#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDiagram#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDiagram#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDiagram#getGraphicChart <em>Graphic Chart</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDiagram#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDiagram#getCodeUpdateCGTime <em>Code Update CG Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDiagram#getHyperLinks <em>Hyper Links</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIDiagram()
 * @model
 * @generated
 */
public interface IDiagram extends IUnit, TheMainDiagramType, DeclarativesType, DependsOnType, TargetType, M_pModelObjectType {
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference.
	 * @see #setProperties(PropertiesType)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIDiagram_Properties()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	PropertiesType getProperties();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDiagram#getProperties <em>Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Properties</em>' containment reference.
	 * @see #getProperties()
	 * @generated
	 */
	void setProperties(PropertiesType value);

	/**
	 * Returns the value of the '<em><b>Stereotypes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotypes</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotypes</em>' reference.
	 * @see #setStereotypes(IModelElement)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIDiagram_Stereotypes()
	 * @model
	 * @generated
	 */
	IModelElement getStereotypes();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDiagram#getStereotypes <em>Stereotypes</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotypes</em>' reference.
	 * @see #getStereotypes()
	 * @generated
	 */
	void setStereotypes(IModelElement value);

	/**
	 * Returns the value of the '<em><b>Modified Time Weak</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modified Time Weak</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modified Time Weak</em>' attribute list.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIDiagram_ModifiedTimeWeak()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getModifiedTimeWeak();

	/**
	 * Returns the value of the '<em><b>Graphic Chart</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graphic Chart</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graphic Chart</em>' containment reference.
	 * @see #setGraphicChart(GraphicChartType)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIDiagram_GraphicChart()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	GraphicChartType getGraphicChart();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IDiagram#getGraphicChart <em>Graphic Chart</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graphic Chart</em>' containment reference.
	 * @see #getGraphicChart()
	 * @generated
	 */
	void setGraphicChart(GraphicChartType value);

	/**
	 * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IAnnotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotations</em>' containment reference list.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIDiagram_Annotations()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<IAnnotation> getAnnotations();

	/**
	 * Returns the value of the '<em><b>Code Update CG Time</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code Update CG Time</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code Update CG Time</em>' attribute list.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIDiagram_CodeUpdateCGTime()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getCodeUpdateCGTime();

	/**
	 * Returns the value of the '<em><b>Hyper Links</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IMHyperLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hyper Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hyper Links</em>' containment reference list.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIDiagram_HyperLinks()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<IMHyperLink> getHyperLinks();

} // IDiagram
