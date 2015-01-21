/**
 * Copyright (c) 2006, 2009, 2013 Borland Software Corporation and others
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
package aspects.impl.diagram.editparts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.diagram.editparts.Common;

/**
 * Revisit: [MG]: @Inject extension same-named-api-class -> template extends api-class?
 */
@Singleton
@SuppressWarnings("all")
public class ChildNodeLabelEditPart extends impl.diagram.editparts.ChildNodeLabelEditPart {
  @Inject
  @Extension
  private Common _common;
  
  public CharSequence handleNotificationEventBody(final GenChildLabelNode it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t\t");
    _builder.append("Object feature = event.getFeature();");
    _builder.newLine();
    CharSequence _handleText = this._common.handleText(it);
    _builder.append(_handleText, "");
    _builder.newLineIfNotEmpty();
    {
      boolean _isLabelElementIcon = it.isLabelElementIcon();
      if (_isLabelElementIcon) {
        _builder.append("if(event.getNewValue() instanceof org.eclipse.emf.ecore.EAnnotation && org.eclipse.papyrus.infra.emf.appearance.helper.VisualInformationPapyrusConstants.DISPLAY_NAMELABELICON.equals(((org.eclipse.emf.ecore.EAnnotation)event.getNewValue()).getSource())){\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("refreshLabel();");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("if (org.eclipse.uml2.uml.UMLPackage.eINSTANCE.getFeature_IsStatic().equals(feature)) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("refreshUnderline();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("super.handleNotificationEvent(event);");
    _builder.newLine();
    return _builder;
  }
}
