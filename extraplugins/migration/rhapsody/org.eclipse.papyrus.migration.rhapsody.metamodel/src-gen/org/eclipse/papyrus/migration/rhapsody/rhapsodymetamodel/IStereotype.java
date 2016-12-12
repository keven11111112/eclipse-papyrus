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
 * A representation of the model object '<em><b>IStereotype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype#getM2Classes <em>M2 Classes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype#getNewTerm <em>New Term</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype#getTags <em>Tags</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype#getLastID <em>Last ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype#getInheritances <em>Inheritances</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype#getRequiremenTracabilityHandle <em>Requiremen Tracability Handle</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype#getObjectCreation <em>Object Creation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype#getUmlDependencyID <em>Uml Dependency ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype#getTheMainDiagram <em>The Main Diagram</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype#getAnnotations <em>Annotations</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIStereotype()
 * @model
 * @generated
 */
public interface IStereotype extends IClassifier, ValueType, DeclarativesType, DependsOnType, M_pModelObjectType {
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference.
	 * @see #setProperties(IPropertyContainer)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIStereotype_Properties()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	IPropertyContainer getProperties();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype#getProperties <em>Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Properties</em>' containment reference.
	 * @see #getProperties()
	 * @generated
	 */
	void setProperties(IPropertyContainer value);

	/**
	 * Returns the value of the '<em><b>M2 Classes</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>M2 Classes</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>M2 Classes</em>' attribute list.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIStereotype_M2Classes()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getM2Classes();

	/**
	 * Returns the value of the '<em><b>New Term</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Term</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Term</em>' attribute.
	 * @see #setNewTerm(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIStereotype_NewTerm()
	 * @model
	 * @generated
	 */
	String getNewTerm();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype#getNewTerm <em>New Term</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Term</em>' attribute.
	 * @see #getNewTerm()
	 * @generated
	 */
	void setNewTerm(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' containment reference.
	 * @see #setDescription(IDescription)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIStereotype_Description()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	IDescription getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype#getDescription <em>Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' containment reference.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(IDescription value);

	/**
	 * Returns the value of the '<em><b>Tags</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ITag}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tags</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tags</em>' containment reference list.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIStereotype_Tags()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ITag> getTags();

	/**
	 * Returns the value of the '<em><b>Last ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last ID</em>' attribute.
	 * @see #setLastID(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIStereotype_LastID()
	 * @model
	 * @generated
	 */
	String getLastID();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype#getLastID <em>Last ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last ID</em>' attribute.
	 * @see #getLastID()
	 * @generated
	 */
	void setLastID(String value);

	/**
	 * Returns the value of the '<em><b>Inheritances</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IGeneralization}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inheritances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inheritances</em>' containment reference list.
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIStereotype_Inheritances()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<IGeneralization> getInheritances();

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
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIStereotype_Dependencies()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	IDependency getDependencies();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype#getDependencies <em>Dependencies</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependencies</em>' containment reference.
	 * @see #getDependencies()
	 * @generated
	 */
	void setDependencies(IDependency value);

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
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIStereotype_RequiremenTracabilityHandle()
	 * @model
	 * @generated
	 */
	String getRequiremenTracabilityHandle();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype#getRequiremenTracabilityHandle <em>Requiremen Tracability Handle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requiremen Tracability Handle</em>' attribute.
	 * @see #getRequiremenTracabilityHandle()
	 * @generated
	 */
	void setRequiremenTracabilityHandle(String value);

	/**
	 * Returns the value of the '<em><b>Object Creation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Creation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Creation</em>' attribute.
	 * @see #setObjectCreation(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIStereotype_ObjectCreation()
	 * @model
	 * @generated
	 */
	String getObjectCreation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype#getObjectCreation <em>Object Creation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Creation</em>' attribute.
	 * @see #getObjectCreation()
	 * @generated
	 */
	void setObjectCreation(String value);

	/**
	 * Returns the value of the '<em><b>Uml Dependency ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uml Dependency ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uml Dependency ID</em>' attribute.
	 * @see #setUmlDependencyID(String)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIStereotype_UmlDependencyID()
	 * @model
	 * @generated
	 */
	String getUmlDependencyID();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype#getUmlDependencyID <em>Uml Dependency ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uml Dependency ID</em>' attribute.
	 * @see #getUmlDependencyID()
	 * @generated
	 */
	void setUmlDependencyID(String value);

	/**
	 * Returns the value of the '<em><b>The Main Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>The Main Diagram</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>The Main Diagram</em>' reference.
	 * @see #setTheMainDiagram(IUnit)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIStereotype_TheMainDiagram()
	 * @model
	 * @generated
	 */
	IUnit getTheMainDiagram();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype#getTheMainDiagram <em>The Main Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>The Main Diagram</em>' reference.
	 * @see #getTheMainDiagram()
	 * @generated
	 */
	void setTheMainDiagram(IUnit value);

	/**
	 * Returns the value of the '<em><b>Annotations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotations</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotations</em>' containment reference.
	 * @see #setAnnotations(IComment)
	 * @see org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage#getIStereotype_Annotations()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	IComment getAnnotations();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IStereotype#getAnnotations <em>Annotations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotations</em>' containment reference.
	 * @see #getAnnotations()
	 * @generated
	 */
	void setAnnotations(IComment value);

} // IStereotype
