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
package aspects.diagram.editparts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.Common;

@Singleton
@SuppressWarnings("all")
public class NodeLabelEditPart extends diagram.editparts.NodeLabelEditPart {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  private impl.diagram.editparts.NodeLabelEditPart xptNodeLabelEditPart;
  
  public CharSequence implementsList(final GenNodeLabel it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("implements org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart, org.eclipse.papyrus.infra.gmfdiag.common.editpart.IControlParserForDirectEdit");
    return _builder;
  }
  
  public CharSequence extendsList(final GenNodeLabel it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("extends org.eclipse.papyrus.infra.gmfdiag.common.editpart.PapyrusCompartmentEditPart");
    return _builder;
  }
  
  public CharSequence handleNotificationEvent(final GenNodeLabel it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected void handleNotificationEvent(org.eclipse.emf.common.notify.Notification event) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("refreshLabel();");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _handleNotificationEventBody = this.xptNodeLabelEditPart.handleNotificationEventBody(it);
    _builder.append(_handleNotificationEventBody, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence additions(final GenNodeLabel it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    _builder.newLine();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("private static final String ADD_PARENT_MODEL = \"AddParentModel\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    CharSequence _generatedMemberComment_1 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_1, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public void activate() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super.activate();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("addOwnerElementListeners();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedMemberComment_2 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_2, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("protected void addOwnerElementListeners() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("addListenerFilter(ADD_PARENT_MODEL, this, ((org.eclipse.gmf.runtime.notation.View) getParent().getModel()));");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedMemberComment_3 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_3, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public void deactivate() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("removeOwnerElementListeners();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super.deactivate();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedMemberComment_4 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_4, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("protected void removeOwnerElementListeners() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("removeListenerFilter(ADD_PARENT_MODEL);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
}
