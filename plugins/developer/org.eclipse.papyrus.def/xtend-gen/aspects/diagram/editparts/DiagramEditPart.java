/**
 * Copyright (c) 2006, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.diagram.editparts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.xtend2.lib.StringConcatenation;

@Singleton
@SuppressWarnings("all")
public class DiagramEditPart extends diagram.editparts.DiagramEditPart {
  @Inject
  private aspects.impl.diagram.editparts.DiagramEditPart aspectDiagramEditPart;
  
  public CharSequence extendsList(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("extends ");
    CharSequence _extendsListContents = this.aspectDiagramEditPart.extendsListContents(it);
    _builder.append(_extendsListContents, "");
    return _builder;
  }
}
