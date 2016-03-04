/**
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.papyrusgmfgenextension;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Custom Diagram Updater Singleton</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.CustomDiagramUpdaterSingleton#getSingletonPath <em>Singleton Path</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getCustomDiagramUpdaterSingleton()
 * @model annotation="http://www.eclipse.org/emf/2002/GenModel Documentation='This object is used to register the diagram updater instance to use in the code. \r\nThe class must extends the generated diagram updater.\r\n\r\n'"
 * @generated
 */
public interface CustomDiagramUpdaterSingleton extends CommentedElement {
	/**
	 * Returns the value of the '<em><b>Singleton Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Singleton Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Singleton Path</em>' attribute.
	 * @see #setSingletonPath(String)
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getCustomDiagramUpdaterSingleton_SingletonPath()
	 * @model required="true"
	 * @generated
	 */
	String getSingletonPath();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.papyrusgmfgenextension.CustomDiagramUpdaterSingleton#getSingletonPath <em>Singleton Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Singleton Path</em>' attribute.
	 * @see #getSingletonPath()
	 * @generated
	 */
	void setSingletonPath(String value);

} // CustomDiagramUpdaterSingleton
