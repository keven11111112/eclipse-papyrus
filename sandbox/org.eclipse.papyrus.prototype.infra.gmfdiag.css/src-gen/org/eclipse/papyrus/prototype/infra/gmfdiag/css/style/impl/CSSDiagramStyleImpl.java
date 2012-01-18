package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.core.dom.CSSStylableElement;

@SuppressWarnings("restriction")
public class CSSDiagramStyleImpl implements CSSDiagramStyle{
	
	private DiagramStyle diagramStyle;

	private CSSEngine engine;

	private CSSStylableElement element;

	public CSSDiagramStyleImpl(DiagramStyle diagramStyle, CSSStylableElement element, CSSEngine engine){
		this.diagramStyle = diagramStyle;
 		this.engine = engine;
		this.element = element;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public int getCSSPageX(){
		String cssValue = engine.retrieveCSSProperty(element, "pageX", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getPageStyle_PageX().getDefaultValue(); 
			return (Integer)defaultValue;
		}
		return (Integer)Integer.parseInt(cssValue);
	}

	public int getCSSPageY(){
		String cssValue = engine.retrieveCSSProperty(element, "pageY", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getPageStyle_PageY().getDefaultValue(); 
			return (Integer)defaultValue;
		}
		return (Integer)Integer.parseInt(cssValue);
	}

	public int getCSSPageWidth(){
		String cssValue = engine.retrieveCSSProperty(element, "pageWidth", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getPageStyle_PageWidth().getDefaultValue(); 
			return (Integer)defaultValue;
		}
		return (Integer)Integer.parseInt(cssValue);
	}

	public int getCSSPageHeight(){
		String cssValue = engine.retrieveCSSProperty(element, "pageHeight", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getPageStyle_PageHeight().getDefaultValue(); 
			return (Integer)defaultValue;
		}
		return (Integer)Integer.parseInt(cssValue);
	}

	public java.lang.String getCSSDescription(){
		String cssValue = engine.retrieveCSSProperty(element, "description", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getDescriptionStyle_Description().getDefaultValue(); 
			return (String)defaultValue;
		}
		return cssValue;
	}
}
