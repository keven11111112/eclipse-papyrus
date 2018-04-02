/**
* Copyright (c) 2017 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Maged Elaasar - Initial API and implementation
 *  
 * 
 */
package org.eclipse.papyrus.infra.core.architecture;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.infra.types.ElementTypeSetConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The superclass of architectural description languages or architecture frameworks. It defines a collection of viewpoints on models.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#getViewpoints <em>Viewpoints</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#getDefaultViewpoints <em>Default Viewpoints</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#getElementTypes <em>Element Types</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#getExtensionPrefix <em>Extension Prefix</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#getCreationCommandClass <em>Creation Command Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#getConversionCommandClass <em>Conversion Command Class</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage#getArchitectureContext()
 * @model abstract="true"
 * @generated
 */
public interface ArchitectureContext extends ADElement {
	/**
	 * Returns the value of the '<em><b>Viewpoints</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.core.architecture.ArchitectureViewpoint}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureViewpoint#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Viewpoints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of viewpoints defined by the context
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Viewpoints</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage#getArchitectureContext_Viewpoints()
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureViewpoint#getContext
	 * @model opposite="context" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescription='The set of viewpoints defined by the context'"
	 * @generated
	 */
	EList<ArchitectureViewpoint> getViewpoints();

	/**
	 * Returns the value of the '<em><b>Default Viewpoints</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.core.architecture.ArchitectureViewpoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Viewpoints</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of viewpoints that are selected for the context by default
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Viewpoints</em>' reference list.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage#getArchitectureContext_DefaultViewpoints()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescription='The set of viewpoints that are selected for the context by default' propertyCategory='Context'"
	 * @generated
	 */
	EList<ArchitectureViewpoint> getDefaultViewpoints();

	/**
	 * Returns the value of the '<em><b>Element Types</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.types.ElementTypeSetConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of element type set configurations that are used by the context (typically found in .elementtypesconfigurations resources)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Element Types</em>' reference list.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage#getArchitectureContext_ElementTypes()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescription='The set of element type set configurations that are used by the context (typically found in .elementtypesconfigurations resources)' propertyCategory='Context'"
	 * @generated
	 */
	EList<ElementTypeSetConfiguration> getElementTypes();

	/**
	 * Returns the value of the '<em><b>Extension Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The prefix of the file extension of the UML models applying this context (e.g., <Name>.<prefixExtension>.uml)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Extension Prefix</em>' attribute.
	 * @see #setExtensionPrefix(String)
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage#getArchitectureContext_ExtensionPrefix()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescription='The prefix of the file extension of the UML models applying this context (e.g., &lt;Name&gt;.&lt;prefixExtension&gt;.uml)' propertyCategory='Context'"
	 * @generated
	 */
	String getExtensionPrefix();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#getExtensionPrefix <em>Extension Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension Prefix</em>' attribute.
	 * @see #getExtensionPrefix()
	 * @generated
	 */
	void setExtensionPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Creation Command Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creation Command Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The fully qualified name of a command that creates models applying this context. The command must implement the org.eclipse.papyrus.infra.architecture.commands.IModelCreationCommand inteface
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Creation Command Class</em>' attribute.
	 * @see #setCreationCommandClass(Class)
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage#getArchitectureContext_CreationCommandClass()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescription='The fully qualified name of a command that creates models applying this context. The command must implement the org.eclipse.papyrus.infra.architecture.commands.IModelCreationCommand inteface' propertyCategory='Context'"
	 * @generated
	 */
	Class<?> getCreationCommandClass();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#getCreationCommandClass <em>Creation Command Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creation Command Class</em>' attribute.
	 * @see #getCreationCommandClass()
	 * @generated
	 */
	void setCreationCommandClass(Class<?> value);

	/**
	 * Returns the value of the '<em><b>Conversion Command Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conversion Command Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The fully qualified name of a command that refactors models that switched to this context. The command must implement the org.eclipse.papyrus.infra.architecture.commands.IModelConversionCommand inteface
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Conversion Command Class</em>' attribute.
	 * @see #setConversionCommandClass(Class)
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage#getArchitectureContext_ConversionCommandClass()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescription='The fully qualified name of a command that refactors models that switched to this context. The command must implement the org.eclipse.papyrus.infra.architecture.commands.IModelConversionCommand inteface' propertyCategory='Context'"
	 * @generated
	 */
	Class<?> getConversionCommandClass();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#getConversionCommandClass <em>Conversion Command Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conversion Command Class</em>' attribute.
	 * @see #getConversionCommandClass()
	 * @generated
	 */
	void setConversionCommandClass(Class<?> value);

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain#getContexts <em>Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The domain that defines the context
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Domain</em>' container reference.
	 * @see #setDomain(ArchitectureDomain)
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage#getArchitectureContext_Domain()
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain#getContexts
	 * @model opposite="contexts" required="true" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescription='The domain that defines the context'"
	 * @generated
	 */
	ArchitectureDomain getDomain();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#getDomain <em>Domain</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' container reference.
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(ArchitectureDomain value);

} // ArchitectureContext
