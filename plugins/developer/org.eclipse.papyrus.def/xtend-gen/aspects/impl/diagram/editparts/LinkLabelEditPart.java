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
 *    Thibault Landre (Atos Origin) - initial API and implementation
 */
package aspects.impl.diagram.editparts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.diagram.editparts.Common;

@Singleton
@SuppressWarnings("all")
public class LinkLabelEditPart extends impl.diagram.editparts.LinkLabelEditPart {
  @Inject
  @Extension
  private Common _common;
  
  public CharSequence handleNotificationEventBody(final GenLinkLabel it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Object feature = event.getFeature();");
    _builder.newLine();
    CharSequence _handleText = this._common.handleText(it);
    _builder.append(_handleText, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      boolean _isElementIcon = it.isElementIcon();
      if (_isElementIcon) {
        _builder.append("if(event.getNewValue() instanceof org.eclipse.emf.ecore.EAnnotation && org.eclipse.papyrus.infra.emf.appearance.helper.VisualInformationPapyrusConstants.DISPLAY_NAMELABELICON.equals(((org.eclipse.emf.ecore.EAnnotation)event.getNewValue()).getSource())){\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("refreshLabel();");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("super.handleNotificationEvent(event);");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence linkLabelDragPolicyQualifiedClassName(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.PapyrusLinkLabelDragPolicy");
    return _builder;
  }
}
