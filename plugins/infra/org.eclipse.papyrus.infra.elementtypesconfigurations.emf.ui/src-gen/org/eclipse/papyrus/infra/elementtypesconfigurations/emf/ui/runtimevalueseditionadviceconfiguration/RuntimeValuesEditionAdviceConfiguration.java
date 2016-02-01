/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.papyrus.infra.elementtypesconfigurations.AbstractAdviceBindingConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Runtime Values Edition Advice Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.RuntimeValuesEditionAdviceConfiguration#getViewsToDisplay <em>Views To Display</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.RuntimevalueseditionadviceconfigurationPackage#getRuntimeValuesEditionAdviceConfiguration()
 * @model
 * @generated
 */
public interface RuntimeValuesEditionAdviceConfiguration extends AbstractAdviceBindingConfiguration {
	/**
	 * Returns the value of the '<em><b>Views To Display</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.ViewToDisplay}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Views To Display</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Views To Display</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.RuntimevalueseditionadviceconfigurationPackage#getRuntimeValuesEditionAdviceConfiguration_ViewsToDisplay()
	 * @model containment="true"
	 * @generated
	 */
	EList<ViewToDisplay> getViewsToDisplay();

} // RuntimeValuesEditionAdviceConfiguration
