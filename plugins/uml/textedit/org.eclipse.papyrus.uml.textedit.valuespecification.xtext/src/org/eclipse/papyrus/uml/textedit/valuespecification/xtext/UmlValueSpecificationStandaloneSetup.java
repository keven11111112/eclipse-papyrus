/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.valuespecification.xtext;


/**
 * Initialization support for running Xtext languages
 * without equinox extension registry
 */
public class UmlValueSpecificationStandaloneSetup extends UmlValueSpecificationStandaloneSetupGenerated {

	public static void doSetup() {
		new UmlValueSpecificationStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
