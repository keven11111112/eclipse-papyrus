/*******************************************************************************
 * Copyright (c) 2013, 2020 Borland Software Corporation, CEA LIST, Artal and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Michael Golubev (Montages) - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package gmfgraph

import java.util.List
import org.eclipse.papyrus.gmf.gmfgraph.CustomBorder

/**
 * FIXME: @Singleton is ugly way to workaround the absence of FILE directive and QVTO properties.
 * Fortunately, it is the only place across all GMFT templates where those 2 features had been used
 */
@com.google.inject.Singleton class Utils_Statefull_qvto {
	
	private List<CustomBorder> myBordersInUse;

	private List<CharSequence> myStaticFieldsStream;

	def void addBorder(CustomBorder border) {
		myBordersInUse.add(border);
	}

	def void clearState() {
		myBordersInUse = <CustomBorder>newLinkedList();
		myStaticFieldsStream = <CharSequence>newLinkedList();
	}

	def Iterable<CustomBorder> getBordersInUse() {
		return myBordersInUse;
	}

	/**
	 * XXX [MG]: workaround for «FILE» directive is not supported in Xtend2
	 */
	def void addToStaticStream(CharSequence code) {
		if (code != null && code.length > 0) {
			myStaticFieldsStream.add(code);
		}
	}

	def Iterable<CharSequence> staticStream() {
		return myStaticFieldsStream;
	}

}
