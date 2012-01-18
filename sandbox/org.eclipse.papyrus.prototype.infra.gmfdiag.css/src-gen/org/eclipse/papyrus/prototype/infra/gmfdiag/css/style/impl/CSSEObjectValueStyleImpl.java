package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSEObjectValueStyleImpl implements CSSEObjectValueStyle{
	
	private EObjectValueStyle eObjectValueStyle;

	public CSSEObjectValueStyleImpl(EObjectValueStyle eObjectValueStyle){
		this.eObjectValueStyle = eObjectValueStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.String getCSSName(){
		return eObjectValueStyle.getName();
	}
}
