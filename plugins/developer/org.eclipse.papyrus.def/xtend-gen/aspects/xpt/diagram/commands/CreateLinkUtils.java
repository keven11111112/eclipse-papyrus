/**
 * Copyright (c) 2007-2012 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.diagram.commands;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Arrays;
import metamodel.MetaModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.Common;
import xpt.diagram.Utils_qvto;

@Singleton
@SuppressWarnings("all")
public class CreateLinkUtils extends xpt.diagram.commands.CreateLinkUtils {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private Utils_qvto _utils_qvto;
  
  @Inject
  private MetaModel xptMetaModel;
  
  /**
   * Fields of command that creates link.
   */
  protected CharSequence _fields(final LinkModelFacet it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _extraLineBreak = this._common.extraLineBreak();
    _builder.append(_extraLineBreak, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "\t");
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("protected final org.eclipse.emf.ecore.EObject source;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedMemberComment_1 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_1, "\t");
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("protected final org.eclipse.emf.ecore.EObject target;");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _fields(final TypeLinkModelFacet it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _extraLineBreak = this._common.extraLineBreak();
    _builder.append(_extraLineBreak, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "\t");
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("protected final org.eclipse.emf.ecore.EObject source;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedMemberComment_1 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_1, "\t");
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("protected final org.eclipse.emf.ecore.EObject target;");
    _builder.newLine();
    {
      boolean _hasContainerOtherThanSource = this._utils_qvto.hasContainerOtherThanSource(it);
      if (_hasContainerOtherThanSource) {
        _builder.newLine();
        CharSequence _generatedMemberComment_2 = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment_2, "");
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
        _builder.append("protected ");
        GenFeature _containmentMetaFeature = it.getContainmentMetaFeature();
        GenClass _genClass = _containmentMetaFeature.getGenClass();
        CharSequence _QualifiedClassName = this.xptMetaModel.QualifiedClassName(_genClass);
        _builder.append(_QualifiedClassName, "");
        _builder.append(" container;");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  protected CharSequence _containerAccessor(final TypeLinkModelFacet it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasContainerOtherThanSource = this._utils_qvto.hasContainerOtherThanSource(it);
      if (_hasContainerOtherThanSource) {
        _builder.newLine();
        _builder.append("\t");
        CharSequence _generatedMemberComment = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment, "\t");
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public ");
        GenFeature _containmentMetaFeature = it.getContainmentMetaFeature();
        GenClass _genClass = _containmentMetaFeature.getGenClass();
        CharSequence _QualifiedClassName = this.xptMetaModel.QualifiedClassName(_genClass);
        _builder.append(_QualifiedClassName, "\t");
        _builder.append(" getContainer() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return container;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        CharSequence _generatedMemberComment_1 = this._common.generatedMemberComment(
          ("Default approach is to traverse ancestors of the source to find instance of container.\n" + "Modify with appropriate logic."));
        _builder.append(_generatedMemberComment_1, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("protected ");
        GenFeature _containmentMetaFeature_1 = it.getContainmentMetaFeature();
        GenClass _genClass_1 = _containmentMetaFeature_1.getGenClass();
        CharSequence _QualifiedClassName_1 = this.xptMetaModel.QualifiedClassName(_genClass_1);
        _builder.append(_QualifiedClassName_1, "\t");
        _builder.append(" deduceContainer(org.eclipse.emf.ecore.EObject source, org.eclipse.emf.ecore.EObject target) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("// Find container element for the new link.");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("// Climb up by containment hierarchy starting from the source");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("// and return the first element that is instance of the container class.");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("for (org.eclipse.emf.ecore.EObject element = source; element != null; element = element.eContainer()) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("if (");
        GenFeature _containmentMetaFeature_2 = it.getContainmentMetaFeature();
        GenClass _genClass_2 = _containmentMetaFeature_2.getGenClass();
        CharSequence _IsInstance = this.xptMetaModel.IsInstance(_genClass_2, "element");
        _builder.append(_IsInstance, "\t\t\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t\t");
        _builder.append("return ");
        GenFeature _containmentMetaFeature_3 = it.getContainmentMetaFeature();
        GenClass _genClass_3 = _containmentMetaFeature_3.getGenClass();
        CharSequence _CastEObject = this.xptMetaModel.CastEObject(_genClass_3, "element");
        _builder.append(_CastEObject, "\t\t\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return null;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence fields(final LinkModelFacet it) {
    if (it instanceof TypeLinkModelFacet) {
      return _fields((TypeLinkModelFacet)it);
    } else if (it != null) {
      return _fields(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  public CharSequence containerAccessor(final LinkModelFacet it) {
    if (it instanceof TypeLinkModelFacet) {
      return _containerAccessor((TypeLinkModelFacet)it);
    } else if (it != null) {
      return _containerAccessor(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
