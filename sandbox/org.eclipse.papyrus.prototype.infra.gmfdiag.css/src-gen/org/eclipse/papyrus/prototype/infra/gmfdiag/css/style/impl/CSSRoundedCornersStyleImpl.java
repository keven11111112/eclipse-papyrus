package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.core.dom.CSSStylableElement;

@SuppressWarnings("restriction")
public class CSSRoundedCornersStyleImpl implements CSSRoundedCornersStyle{
	
	private RoundedCornersStyle roundedCornersStyle;

	private CSSEngine engine;

	private CSSStylableElement element;

	public CSSRoundedCornersStyleImpl(RoundedCornersStyle roundedCornersStyle, CSSStylableElement element, CSSEngine engine){
		this.roundedCornersStyle = roundedCornersStyle;
 		this.engine = engine;
		this.element = element;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public int getCSSRoundedBendpointsRadius(){
		String cssValue = engine.retrieveCSSProperty(element, "roundedBendpointsRadius", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getRoundedCornersStyle_RoundedBendpointsRadius().getDefaultValue(); 
			return (Integer)defaultValue;
		}
		return (Integer)Integer.parseInt(cssValue);
	}
}
