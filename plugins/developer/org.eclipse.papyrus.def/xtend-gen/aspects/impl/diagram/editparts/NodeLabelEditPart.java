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
 *    Thibault Landre (Atos Origin) - initial API and implementation
 */
package aspects.impl.diagram.editparts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.diagram.editparts.Common;
import xpt.diagram.editparts.Utils_qvto;

@Singleton
@SuppressWarnings("all")
public class NodeLabelEditPart extends impl.diagram.editparts.NodeLabelEditPart {
  @Inject
  @Extension
  private Utils_qvto _utils_qvto;
  
  @Inject
  private Common xptEditpartsCommon;
  
  public CharSequence handleNotificationEventBody(final GenNodeLabel it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Object feature = event.getFeature();");
    _builder.newLine();
    {
      GenNode _node = it.getNode();
      boolean _isStoringChildPositions = this._utils_qvto.isStoringChildPositions(_node);
      if (_isStoringChildPositions) {
        CharSequence _handleBounds = this.xptEditpartsCommon.handleBounds(it);
        _builder.append(_handleBounds, "");
        _builder.newLineIfNotEmpty();
      }
    }
    CharSequence _handleText = this.xptEditpartsCommon.handleText(it);
    _builder.append(_handleText, "");
    _builder.newLineIfNotEmpty();
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
}
