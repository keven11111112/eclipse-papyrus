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
 * A representation of the model object '<em><b>IState</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState#getStateType <em>State Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState#getDefaultTrans <em>Default Trans</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState#getEntryAction <em>Entry Action</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState#getInheritsFromHandle <em>Inherits From Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState#getExitAction <em>Exit Action</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState#getNestedStateChart <em>Nested State Chart</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState#getRequiremenTracabilityHandle <em>Requiremen Tracability Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState#getTheMainDiagram <em>The Main Diagram</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState#getSwimlane <em>Swimlane</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState#getCodeUpdateCGTime <em>Code Update CG Time</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIState()
 * @model
 * @generated
 */
public interface IState extends IStateVertex, ItsTargetType, M_pModelObjectType, DependsOnType, TargetType {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(IStateVertex)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIState_Parent()
	 * @model
	 * @generated
	 */
	IStateVertex getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(IStateVertex value);

	/**
	 * Returns the value of the '<em><b>State Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Type</em>' attribute.
	 * @see #setStateType(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIState_StateType()
	 * @model
	 * @generated
	 */
	String getStateType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState#getStateType <em>State Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Type</em>' attribute.
	 * @see #getStateType()
	 * @generated
	 */
	void setStateType(String value);

	/**
	 * Returns the value of the '<em><b>Default Trans</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Trans</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Trans</em>' reference.
	 * @see #setDefaultTrans(DefaultTransType)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIState_DefaultTrans()
	 * @model
	 * @generated
	 */
	DefaultTransType getDefaultTrans();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState#getDefaultTrans <em>Default Trans</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Trans</em>' reference.
	 * @see #getDefaultTrans()
	 * @generated
	 */
	void setDefaultTrans(DefaultTransType value);

	/**
	 * Returns the value of the '<em><b>Entry Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Action</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Action</em>' containment reference.
	 * @see #setEntryAction(IModelElement)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIState_EntryAction()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	IModelElement getEntryAction();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState#getEntryAction <em>Entry Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry Action</em>' containment reference.
	 * @see #getEntryAction()
	 * @generated
	 */
	void setEntryAction(IModelElement value);

	/**
	 * Returns the value of the '<em><b>Inherits From Handle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inherits From Handle</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherits From Handle</em>' reference.
	 * @see #setInheritsFromHandle(IState)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIState_InheritsFromHandle()
	 * @model
	 * @generated
	 */
	IState getInheritsFromHandle();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState#getInheritsFromHandle <em>Inherits From Handle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inherits From Handle</em>' reference.
	 * @see #getInheritsFromHandle()
	 * @generated
	 */
	void setInheritsFromHandle(IState value);

	/**
	 * Returns the value of the '<em><b>Exit Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exit Action</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exit Action</em>' containment reference.
	 * @see #setExitAction(IAction)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIState_ExitAction()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	IAction getExitAction();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState#getExitAction <em>Exit Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exit Action</em>' containment reference.
	 * @see #getExitAction()
	 * @generated
	 */
	void setExitAction(IAction value);

	/**
	 * Returns the value of the '<em><b>Nested State Chart</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested State Chart</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nested State Chart</em>' containment reference.
	 * @see #setNestedStateChart(NestedStateChartType)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIState_NestedStateChart()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	NestedStateChartType getNestedStateChart();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState#getNestedStateChart <em>Nested State Chart</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nested State Chart</em>' containment reference.
	 * @see #getNestedStateChart()
	 * @generated
	 */
	void setNestedStateChart(NestedStateChartType value);

	/**
	 * Returns the value of the '<em><b>Requiremen Tracability Handle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requiremen Tracability Handle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requiremen Tracability Handle</em>' attribute.
	 * @see #setRequiremenTracabilityHandle(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIState_RequiremenTracabilityHandle()
	 * @model
	 * @generated
	 */
	String getRequiremenTracabilityHandle();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState#getRequiremenTracabilityHandle <em>Requiremen Tracability Handle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requiremen Tracability Handle</em>' attribute.
	 * @see #getRequiremenTracabilityHandle()
	 * @generated
	 */
	void setRequiremenTracabilityHandle(String value);

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
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIState_Annotations()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<IAnnotation> getAnnotations();

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' containment reference.
	 * @see #setDependencies(IDependency)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIState_Dependencies()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	IDependency getDependencies();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState#getDependencies <em>Dependencies</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependencies</em>' containment reference.
	 * @see #getDependencies()
	 * @generated
	 */
	void setDependencies(IDependency value);

	/**
	 * Returns the value of the '<em><b>The Main Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>The Main Diagram</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>The Main Diagram</em>' reference.
	 * @see #setTheMainDiagram(IDiagram)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIState_TheMainDiagram()
	 * @model
	 * @generated
	 */
	IDiagram getTheMainDiagram();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState#getTheMainDiagram <em>The Main Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>The Main Diagram</em>' reference.
	 * @see #getTheMainDiagram()
	 * @generated
	 */
	void setTheMainDiagram(IDiagram value);

	/**
	 * Returns the value of the '<em><b>Swimlane</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Swimlane</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Swimlane</em>' reference.
	 * @see #setSwimlane(ISwimlane)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIState_Swimlane()
	 * @model
	 * @generated
	 */
	ISwimlane getSwimlane();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IState#getSwimlane <em>Swimlane</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Swimlane</em>' reference.
	 * @see #getSwimlane()
	 * @generated
	 */
	void setSwimlane(ISwimlane value);

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
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIState_CodeUpdateCGTime()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getCodeUpdateCGTime();

} // IState
