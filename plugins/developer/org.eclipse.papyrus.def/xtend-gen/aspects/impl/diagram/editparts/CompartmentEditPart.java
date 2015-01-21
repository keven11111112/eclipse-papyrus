/**
 * Copyright (c) 2006, 2009 Borland Software Corporation
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
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.Common;

@Singleton
@SuppressWarnings("all")
public class CompartmentEditPart extends impl.diagram.editparts.CompartmentEditPart {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  private xpt.diagram.editparts.Common xptEditpartsCommon;
  
  public CharSequence createDefaultEditPoliciesBody(final GenCompartment it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("super.createDefaultEditPolicies();");
    _builder.newLine();
    {
      boolean _isCanCollapse = it.isCanCollapse();
      if (_isCanCollapse) {
        _builder.append("installEditPolicy(org.eclipse.gef.EditPolicy.PRIMARY_DRAG_ROLE, new org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableCompartmentEditPolicy());");
        _builder.newLine();
      }
    }
    CharSequence _installSemanticEditPolicy = this.xptEditpartsCommon.installSemanticEditPolicy(it);
    _builder.append(_installSemanticEditPolicy, "");
    _builder.newLineIfNotEmpty();
    {
      EList<GenChildNode> _childNodes = it.getChildNodes();
      boolean _isEmpty = _childNodes.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.append("installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CREATION_ROLE, new org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultCreationEditPolicy());");
        _builder.newLine();
        _builder.append("installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.DRAG_DROP_ROLE, new org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy());");
        _builder.newLine();
        _builder.append("installEditPolicy(org.eclipse.papyrus.uml.diagram.common.editpolicies.DuplicatePasteEditPolicy.PASTE_ROLE, new org.eclipse.papyrus.uml.diagram.common.editpolicies.DuplicatePasteEditPolicy());");
        _builder.newLine();
      }
    }
    CharSequence _installCanonicalEditPolicy = this.xptEditpartsCommon.installCanonicalEditPolicy(it);
    _builder.append(_installCanonicalEditPolicy, "");
    _builder.newLineIfNotEmpty();
    CharSequence _behaviour = this.xptEditpartsCommon.behaviour(it);
    _builder.append(_behaviour, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence getTargetEditPartMethod(final GenCompartment it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public org.eclipse.gef.EditPart getTargetEditPart(org.eclipse.gef.Request request) {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return super.getTargetEditPart(request);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
