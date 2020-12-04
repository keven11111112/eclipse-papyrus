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
package org.eclipse.papyrus.gmf.internal.bridge.genmodel;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenCustomPropertyTab;
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenPropertySheet;
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenPropertyTab;
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenStandardPropertyTab;
import org.eclipse.papyrus.gmf.codegen.gmfgen.GeneratedType;
import org.eclipse.papyrus.gmf.codegen.gmfgen.TypeTabFilter;
import org.eclipse.papyrus.gmf.mappings.CanvasMapping;

/**
 * @author artem
 */
public class PropertySheetHandler {

	protected static final String APPEARANCE = "appearance";
	protected static final String DIAGRAM = "diagram";
	protected static final String ADVANCED = "advanced";
	protected static final String DOMAIN = "domain";

	private GenPropertySheet myPropertySheet;

	public void initialize(GenPropertySheet propertySheet) {
		assert propertySheet != null;
		myPropertySheet = propertySheet;
	}

	public void process(CanvasMapping canvas) {
		addStandardTabs();
		addCustomTabs(canvas);
	}

	protected void addStandardTabs() {
		GenStandardPropertyTab t1 = GMFGenFactory.eINSTANCE.createGenStandardPropertyTab();
		t1.setID(APPEARANCE);
		addTab(t1);
		t1 = GMFGenFactory.eINSTANCE.createGenStandardPropertyTab();
		t1.setID(DIAGRAM);
		addTab(t1);
	}

	protected void addCustomTabs(CanvasMapping canvas) {
		if (!hasDomainModel(canvas)) {
			return;
		}
		GenCustomPropertyTab t1 = GMFGenFactory.eINSTANCE.createGenCustomPropertyTab();
		t1.setID(DOMAIN);
		t1.setLabel("Core");
		TypeTabFilter f = GMFGenFactory.eINSTANCE.createTypeTabFilter();
		f.getTypes().add(View.class.getName());
		f.getTypes().add("org.eclipse.gef.EditPart");
		if (myPropertySheet.getEditorGen().getNavigator() != null) {
			f.getGeneratedTypes().add(GeneratedType.ABSTRACT_NAVIGATOR_ITEM_LITERAL);
		}
		t1.setFilter(f);
		addTab(t1);
	}

	private void addTab(GenPropertyTab tab) {
		myPropertySheet.getTabs().add(tab);
	}

	private static boolean hasDomainModel(CanvasMapping canvas) {
		return canvas.getDomainModel() != null;
	}
}
