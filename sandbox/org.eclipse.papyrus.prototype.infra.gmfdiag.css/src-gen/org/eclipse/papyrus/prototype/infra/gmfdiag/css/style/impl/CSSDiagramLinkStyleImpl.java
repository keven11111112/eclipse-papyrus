package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.core.dom.CSSStylableElement;

@SuppressWarnings("restriction")
public class CSSDiagramLinkStyleImpl implements CSSDiagramLinkStyle{
	
	private DiagramLinkStyle diagramLinkStyle;

	private CSSEngine engine;

	private CSSStylableElement element;

	public CSSDiagramLinkStyleImpl(DiagramLinkStyle diagramLinkStyle, CSSStylableElement element, CSSEngine engine){
		this.diagramLinkStyle = diagramLinkStyle;
 		this.engine = engine;
		this.element = element;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

}
