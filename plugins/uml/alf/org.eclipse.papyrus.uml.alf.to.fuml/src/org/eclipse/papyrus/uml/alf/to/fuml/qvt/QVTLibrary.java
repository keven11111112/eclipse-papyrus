/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  IJI - Initial implementation
 *  MDS - Updated for Luna
 * 
 *****************************************************************************/

package org.eclipse.papyrus.uml.alf.to.fuml.qvt;

import org.eclipse.m2m.qvt.oml.blackbox.java.Module;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
import org.eclipse.papyrus.uml.alf.AlfStandaloneSetup;
import org.eclipse.papyrus.uml.alf.SyntaxElement;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.serializer.ISerializer;

import com.google.inject.Injector;

@Module(packageURIs = { "http://www.omg.org/spec/ALF/20120827" })
public class QVTLibrary {

	public QVTLibrary() {
		super();
	}

	@Operation(contextual = true, kind = Kind.QUERY)
	public static String serialize(SyntaxElement element) {
		Injector injector = new AlfStandaloneSetup().createInjectorAndDoEMFRegistration();
		ISerializer serializer = injector.getInstance(ISerializer.class);
		SaveOptions options = SaveOptions.newBuilder().format().noValidation().getOptions();
		return serializer.serialize(element, options);
	}

}
