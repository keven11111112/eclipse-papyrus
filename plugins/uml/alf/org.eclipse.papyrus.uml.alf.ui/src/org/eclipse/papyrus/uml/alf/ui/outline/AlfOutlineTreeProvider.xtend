/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  IJI - Initial implementation
 * 
 *****************************************************************************/

package org.eclipse.papyrus.uml.alf.ui.outline

import org.eclipse.papyrus.uml.alf.Member;
import org.eclipse.papyrus.uml.alf.QualifiedName

/**
 * Customization of the default outline structure.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#outline
 */
class AlfOutlineTreeProvider extends org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider {
  
  private static final String SUFFIX = "Impl"
  
  protected override Object _text(Object modelElement) {
    var text = modelElement.class.simpleName
    val l = text.length
    if (l > SUFFIX.length && text.endsWith(SUFFIX)) {
      text = text.substring(0, l - SUFFIX.length)
    }
    if (modelElement instanceof Member) {
      text = text + " " + (modelElement as Member).definition.name      
    } else if (modelElement instanceof QualifiedName) {
      text = text + " " + (modelElement as QualifiedName).pathName
    }
    return text
  }
  
}
	
