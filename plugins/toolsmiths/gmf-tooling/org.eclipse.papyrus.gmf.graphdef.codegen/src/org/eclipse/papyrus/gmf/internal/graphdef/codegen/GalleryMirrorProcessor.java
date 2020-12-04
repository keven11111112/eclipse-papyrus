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

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;

import org.eclipse.papyrus.gmf.gmfgraph.ConnectionFigure;
import org.eclipse.papyrus.gmf.gmfgraph.CustomFigure;
import org.eclipse.papyrus.gmf.gmfgraph.DecorationFigure;
import org.eclipse.papyrus.gmf.gmfgraph.Figure;
import org.eclipse.papyrus.gmf.gmfgraph.FigureDescriptor;
import org.eclipse.papyrus.gmf.gmfgraph.FigureGallery;
import org.eclipse.papyrus.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.papyrus.gmf.graphdef.codegen.StandaloneGenerator.Config;
import org.eclipse.papyrus.gmf.graphdef.codegen.StandaloneGenerator.ProcessorCallback;

/**
 * In addition to {@link GalleryProcessor} activities, collects names of transformed figures and 
 * allows to create {@link FigureGallery} full of them. 
 * @author artem
 */
public class GalleryMirrorProcessor extends GalleryProcessor {
	private final Map<FigureDescriptor, String> myFigure2FQN = new IdentityHashMap<FigureDescriptor, String>();
	private String myGeneratedBundle;

	public GalleryMirrorProcessor(FigureGallery[] input) {
		super(input);
	}

	public void go(ProcessorCallback callback, Config config) throws InterruptedException {
		super.go(callback, config);
		myGeneratedBundle = config.getPluginID();
	}

	public FigureGallery convertFigureGallery(){
		FigureGallery result = GMFGraphFactory.eINSTANCE.createFigureGallery();
		result.setName("GeneratedGallery"); // FIXME smth reasonable
		result.setImplementationBundle(myGeneratedBundle);
		
		for (FigureDescriptor fd : myFigure2FQN.keySet()) {
			Figure nextOriginal = fd.getActualFigure();
			String nextConvertedFqn = myFigure2FQN.get(fd);
			CustomFigure custom = createCustomFigure(nextOriginal);
			custom.setName(fd.getName());
			custom.setQualifiedClassName(nextConvertedFqn);

			result.getFigures().add(custom);
		}
		return result;
	}

	public Map<FigureDescriptor, String> getGenerationInfo() {
		return Collections.unmodifiableMap(myFigure2FQN);
	}

	protected void handle(FigureDescriptor next, String fqn) {
		myFigure2FQN.put(next, fqn);
	}

	static CustomFigure createCustomFigure(Figure original){
		GMFGraphFactory factory = GMFGraphFactory.eINSTANCE;
		if (original instanceof DecorationFigure){
			return factory.createCustomDecoration();
		} 
		if (original instanceof ConnectionFigure){
			return factory.createCustomConnection();
		}
		return factory.createCustomFigure();
	}
}
