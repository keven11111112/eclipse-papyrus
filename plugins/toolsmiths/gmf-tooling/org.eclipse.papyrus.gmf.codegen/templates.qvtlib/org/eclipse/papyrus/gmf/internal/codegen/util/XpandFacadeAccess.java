/******************************************************************************
 * Copyright (c) 2009, 2020 Borland Software Corporation, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.codegen.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
import org.eclipse.papyrus.gmf.internal.xpand.BufferOutput;
import org.eclipse.papyrus.gmf.internal.xpand.XpandFacade;
import org.eclipse.papyrus.gmf.internal.xpand.model.Scope;
import org.eclipse.papyrus.gmf.internal.xpand.model.Variable;
import org.eclipse.papyrus.gmf.internal.xpand.util.BundleResourceManager;

/**
 * @author artem
 */
@SuppressWarnings("restriction")
public class XpandFacadeAccess {

	private static final String VAR_MM_ACCESS = "mapModeAccessor";
	private static final String VAR_RT_TOKEN = "runtimeToken";
	
	@Operation(contextual = true, kind = Kind.QUERY)
	public String xpand(Object self, String templateName, List<String> templateRoots) {
		StringBuilder result = new StringBuilder();
		ArrayList<URL> urls = new ArrayList<URL>(templateRoots.size());
		
		for (String s : templateRoots) {
			try {
				urls.add(new URL(s));
			} catch (MalformedURLException ex) {
				ILog l = Platform.getLog(Platform.getBundle("org.eclipse.papyrus.gmf.codegen")); //$NON-NLS-1$
				l.log(new Status(Status.ERROR, l.getBundle().getSymbolicName(), ex.getClass().getSimpleName(), ex));
			}
		}
		
		final Collection<Variable> globals = new ArrayList<Variable>();
		
		globals.add( new Variable(VAR_MM_ACCESS, EcorePackage.eINSTANCE.getEString(), ""));
		globals.add(new Variable(VAR_RT_TOKEN, EcorePackage.eINSTANCE.getEString(), "full"));
		
		BundleResourceManager rm = new BundleResourceManager(urls.toArray(new URL[urls.size()]));
		try {
			new XpandFacade(new Scope(rm, globals, new BufferOutput(result))).evaluate(templateName, self, null);
		} catch (Exception ex) {
			return ex.toString();
		}
		return result.toString();
	}
}
