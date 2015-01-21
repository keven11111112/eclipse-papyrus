/**
 * Copyright (c) 2010 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package utils;

import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet;
import org.eclipse.xtend2.lib.StringConcatenation;

@Singleton
@SuppressWarnings("all")
public class UtilsItemSemanticEditPolicy {
  public CharSequence getDestroyElementCommandByService(final GenNode i) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected org.eclipse.gef.commands.Command getDestroyElementCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest req) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.emf.ecore.EObject selectedEObject = req.getElementToDestroy();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.papyrus.infra.services.edit.service.IElementEditService provider =org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(selectedEObject);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if(provider != null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// Retrieve delete command from the Element Edit service");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.gmf.runtime.common.core.command.ICommand deleteCommand = provider.getEditCommand(req);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if(deleteCommand != null) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return new org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy(deleteCommand);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getDestroyElementCommandByService(final TypeLinkModelFacet it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected org.eclipse.gef.commands.Command getDestroyElementCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest req) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.emf.ecore.EObject selectedEObject = req.getElementToDestroy();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.papyrus.infra.services.edit.service.IElementEditService provider =org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(selectedEObject);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if(provider != null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// Retrieve delete command from the Element Edit service");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.gmf.runtime.common.core.command.ICommand deleteCommand = provider.getEditCommand(req);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if(deleteCommand != null) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return new org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy(deleteCommand);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
