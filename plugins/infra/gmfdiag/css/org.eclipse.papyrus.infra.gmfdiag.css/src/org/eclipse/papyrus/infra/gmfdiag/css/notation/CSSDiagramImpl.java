/*****************************************************************************
 * Copyright (c) 2012, 2015 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - support adapter instead of custom resource impl for CSS (CDO)
 *  Christian W. Damus - bug 433206
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.notation;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.notation.EObjectListValueStyle;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.impl.DiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.DiagramCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.resource.CSSNotationResource;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsFactory;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusDiagram;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;

/**
 * Default implementation for CSSDiagram
 *
 * @author Camille letavernier
 */
@SuppressWarnings("restriction")
public class CSSDiagramImpl extends DiagramImpl implements CSSDiagram {

	protected ExtendedCSSEngine engine;

	@Override
	public ExtendedCSSEngine getEngine() {
		if (engine == null) {
			engine = new DiagramCSSEngine(getModelEngine(), this);
		}
		return engine;
	}

	private void disposeEngine() {
		if (engine != null) {
			engine.dispose();
			engine = null;
		}
	}

	@Override
	protected void eSetDirectResource(Resource.Internal resource) {
		Resource.Internal oldResource = eInternalResource();

		super.eSetDirectResource(resource);

		if (oldResource != resource) {
			// My engine is now invalid because my resource is different than before,
			// which makes its parent engine is obsolete
			disposeEngine();
		}
	}

	protected ExtendedCSSEngine getModelEngine() {
		Resource resource = eResource();
		return (resource == null) ? null : CSSNotationResource.getEngine(resource);
	}

	@Override
	public List<StyleSheet> getStyleSheets() {
		List<StyleSheet> result = new LinkedList<StyleSheet>();

		for (Object styleObject : getStyles()) {
			if (styleObject instanceof NamedStyle) {

				NamedStyle style = (NamedStyle) styleObject;

				if (CSSStyles.CSS_DIAGRAM_STYLESHEETS_KEY.equals(style.getName())) {
					if (style instanceof EObjectListValueStyle) {

						EObjectListValueStyle stylesheetsStyle = (EObjectListValueStyle) style;

						for (Object eObjectValue : stylesheetsStyle.getEObjectListValue()) {
							if (eObjectValue instanceof StyleSheet) {
								result.add((StyleSheet) eObjectValue);
							}
						}
					}
				}
			}
		}

		StyleSheet s = getViewpointDefinedStylesheet();
		if (s != null) {
			result.add(s);
		}

		return result;
	}

	private StyleSheet getViewpointDefinedStylesheet() {
		ViewPrototype proto = ViewPrototype.get(this);
		if (proto == null) {
			return null;
		}
		PapyrusView conf = proto.getConfiguration();
		if (conf == null || !(conf instanceof PapyrusDiagram)) {
			return null;
		}
		String path = ((PapyrusDiagram) conf).getCustomStyle();
		if (path == null || path.isEmpty()) {
			return null;
		}
		StyleSheetReference ref = StylesheetsFactory.eINSTANCE.createStyleSheetReference();
		ref.setPath(path);
		return ref;
	}

}
