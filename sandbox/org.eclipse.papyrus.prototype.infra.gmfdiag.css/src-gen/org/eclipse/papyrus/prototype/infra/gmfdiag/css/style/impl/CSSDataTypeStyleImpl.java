package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSDataTypeStyleImpl implements CSSDataTypeStyle{
	
	private DataTypeStyle dataTypeStyle;

	public CSSDataTypeStyleImpl(DataTypeStyle dataTypeStyle){
		this.dataTypeStyle = dataTypeStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.String getCSSName(){
		return dataTypeStyle.getName();
	}
}
