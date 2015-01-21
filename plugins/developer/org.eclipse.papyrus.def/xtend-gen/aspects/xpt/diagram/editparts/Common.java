/**
 * Copyright (c) 2006, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 * 	  Patrick Tessier (CEA LIST)
 */
package aspects.xpt.diagram.editparts;

import aspects.xpt.QualifiedClassNameProvider;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenContainerBase;
import org.eclipse.xtend2.lib.StringConcatenation;

@Singleton
@SuppressWarnings("all")
public class Common extends xpt.diagram.editparts.Common {
  @Inject
  private QualifiedClassNameProvider qualifiedClassNameProvider;
  
  public CharSequence installCanonicalEditPolicy(final GenContainerBase it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _needsCanonicalEditPolicy = it.needsCanonicalEditPolicy();
      if (_needsCanonicalEditPolicy) {
        _builder.append("\t\t\t\t");
        _builder.append("//in Papyrus diagrams are not strongly synchronised");
        _builder.newLine();
        _builder.append("//installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE, new ");
        String _canonicalEditPolicyQualifiedClassName = it.getCanonicalEditPolicyQualifiedClassName();
        _builder.append(_canonicalEditPolicyQualifiedClassName, "");
        _builder.append("());");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence creationEditPolicyNewInstance(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultCreationEditPolicy()");
    return _builder;
  }
  
  public CharSequence installSemanticEditPolicy(final GenCommonBase it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isSansDomain = it.isSansDomain();
      if (_isSansDomain) {
        _builder.append("removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.SEMANTIC_ROLE);");
        _builder.newLine();
      } else {
        _builder.append("installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.SEMANTIC_ROLE, new ");
        CharSequence _itemSemanticEditPolicyQualifiedClassName = this.qualifiedClassNameProvider.getItemSemanticEditPolicyQualifiedClassName(it);
        _builder.append(_itemSemanticEditPolicyQualifiedClassName, "");
        _builder.append("());");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
