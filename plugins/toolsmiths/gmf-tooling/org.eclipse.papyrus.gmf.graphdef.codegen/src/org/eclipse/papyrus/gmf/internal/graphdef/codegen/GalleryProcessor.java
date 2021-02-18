/******************************************************************************
 * Copyright (c) 2006, 2020 Borland Software Corporation, CEA LIST, Artal
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
package org.eclipse.papyrus.gmf.internal.graphdef.codegen;

import java.util.Arrays;
import java.util.HashSet;

import org.eclipse.papyrus.gmf.gmfgraph.FigureDescriptor;
import org.eclipse.papyrus.gmf.gmfgraph.FigureGallery;
import org.eclipse.papyrus.gmf.graphdef.codegen.StandaloneGenerator.Config;
import org.eclipse.papyrus.gmf.graphdef.codegen.StandaloneGenerator.Processor;
import org.eclipse.papyrus.gmf.graphdef.codegen.StandaloneGenerator.ProcessorCallback;

/**
 * Straightforwardly transforms all top-level figures from supplied galleries
 * @author artem
 */
public class GalleryProcessor extends Processor {
	private final FigureGallery[] myInput;

	public GalleryProcessor(FigureGallery input) {
		this(new FigureGallery[] { input });
	}

	public GalleryProcessor(FigureGallery[] input) {
		assert !Arrays.asList(input).contains(null);
		myInput = input;
	}
	
	public void go(ProcessorCallback callback, Config config) throws InterruptedException {
		for (int i = 0; i < myInput.length; i++) {
			for (FigureDescriptor next : myInput[i].getDescriptors()) {
				String fqn = callback.visitFigure(next);
				handle(next, fqn);
			}
		}
	}

	/**
	 * does nothing by default, override to do smth usable
	 */
	protected void handle(FigureDescriptor next, String fqn) {
	}

	@Override
	public String[] getRequiredBundles() {
		HashSet<String> rv = new HashSet<String>();
		for (int i = 0; i < myInput.length; i++) {
			if (myInput[i].getImplementationBundle() != null && myInput[i].getImplementationBundle().trim().length() > 0) {
				rv.add(myInput[i].getImplementationBundle());
			}
		}
		return rv.toArray(new String[rv.size()]);
	}
}
