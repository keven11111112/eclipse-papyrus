/**
 * Copyright (c) 2007, 2010 Borland Software Corporation and others
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

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import metamodel.MetaModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.Common;
import xpt.OclMigrationProblems_qvto;
import xpt.diagram.Utils_qvto;

@Singleton
@SuppressWarnings("all")
public class CreateNodeCommand extends xpt.diagram.commands.CreateNodeCommand {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private OclMigrationProblems_qvto _oclMigrationProblems_qvto;
  
  @Inject
  @Extension
  private MetaModel _metaModel;
  
  @Inject
  @Extension
  private Utils_qvto _utils_qvto;
  
  @Inject
  private MetaModel xptMetaModel;
  
  public CharSequence CreateNodeCommand(final GenNode it) {
    StringConcatenation _builder = new StringConcatenation();
    GenDiagram _diagram = it.getDiagram();
    GenEditorGenerator _editorGen = _diagram.getEditorGen();
    CharSequence _copyright = this._common.copyright(_editorGen);
    _builder.append(_copyright, "");
    _builder.newLineIfNotEmpty();
    _builder.append("package ");
    CharSequence _packageName = this.packageName(it);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    CharSequence _generatedClassComment = this._common.generatedClassComment();
    _builder.append(_generatedClassComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public class ");
    CharSequence _className = this.className(it);
    _builder.append(_className, "");
    _builder.append(" extends org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      TypeModelFacet _modelFacet = it.getModelFacet();
      boolean _isPhantomElement = _modelFacet.isPhantomElement();
      boolean _not = (!_isPhantomElement);
      if (_not) {
        _builder.append("\t");
        CharSequence _generatedMemberComment = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("private org.eclipse.gmf.runtime.notation.Diagram diagram = null;");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    CharSequence __constructor = this._constructor(it);
    _builder.append(__constructor, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _elementToEdit = this.getElementToEdit(it);
    _builder.append(_elementToEdit, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _canExecuteMethod = this.canExecuteMethod(it);
    _builder.append(_canExecuteMethod, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _doExecuteWithResultMethod = this.doExecuteWithResultMethod(it);
    _builder.append(_doExecuteWithResultMethod, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _doConfigureMethod = this.doConfigureMethod(it);
    _builder.append(_doConfigureMethod, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _additions = this.additions(it);
    _builder.append(_additions, "\t");
    _builder.append("\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence _constructor(final GenNode it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public ");
    CharSequence _className = this.className(it);
    _builder.append(_className, "");
    _builder.append("(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest req, org.eclipse.gmf.runtime.notation.Diagram diagram) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("super(req.getLabel(), null, req);");
    _builder.newLine();
    {
      TypeModelFacet _modelFacet = it.getModelFacet();
      boolean _isPhantomElement = _modelFacet.isPhantomElement();
      boolean _not = (!_isPhantomElement);
      if (_not) {
        _builder.append("\t");
        _builder.append("this.diagram = diagram;");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence doExecuteWithResultMethod(final GenNode it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected org.eclipse.gmf.runtime.common.core.command.CommandResult doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor monitor, org.eclipse.core.runtime.IAdaptable info) throws org.eclipse.core.commands.ExecutionException {");
    _builder.newLine();
    _builder.append(" \t\t\t\t");
    _builder.newLine();
    {
      TypeModelFacet _modelFacet = it.getModelFacet();
      GenClass _metaClass = _modelFacet.getMetaClass();
      EClass _ecoreClass = _metaClass.getEcoreClass();
      boolean _isAbstract = _ecoreClass.isAbstract();
      boolean _notEquals = (_isAbstract != true);
      if (_notEquals) {
        {
          TypeModelFacet _modelFacet_1 = it.getModelFacet();
          boolean _isPhantomElement = _modelFacet_1.isPhantomElement();
          if (_isPhantomElement) {
            TypeModelFacet _modelFacet_2 = it.getModelFacet();
            CharSequence _phantomElementCreation = this.phantomElementCreation(_modelFacet_2, it, "newElement");
            _builder.append(_phantomElementCreation, "");
            _builder.newLineIfNotEmpty();
          } else {
            TypeModelFacet _modelFacet_3 = it.getModelFacet();
            CharSequence _normalElementCreation = this.normalElementCreation(_modelFacet_3, it, "newElement");
            _builder.append(_normalElementCreation, "");
            _builder.newLineIfNotEmpty();
          }
        }
        CharSequence _extraLineBreak = this._common.extraLineBreak();
        _builder.append(_extraLineBreak, "");
        _builder.newLineIfNotEmpty();
        TypeModelFacet _modelFacet_4 = it.getModelFacet();
        CharSequence _initialize = this.initialize(_modelFacet_4, it, "newElement");
        _builder.append(_initialize, "");
        _builder.newLineIfNotEmpty();
        {
          if (true) {
            CharSequence _extraLineBreak_1 = this._common.extraLineBreak();
            _builder.append(_extraLineBreak_1, "");
            _builder.newLineIfNotEmpty();
            _builder.append("doConfigure(newElement, monitor, info);");
            _builder.newLine();
            CharSequence _extraLineBreak_2 = this._common.extraLineBreak();
            _builder.append(_extraLineBreak_2, "");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("((org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest) getRequest()).setNewElement(");
        TypeModelFacet _modelFacet_5 = it.getModelFacet();
        GenClass _metaClass_1 = _modelFacet_5.getMetaClass();
        CharSequence _DowncastToEObject = this.xptMetaModel.DowncastToEObject(_metaClass_1, "newElement");
        _builder.append(_DowncastToEObject, "\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("return org.eclipse.gmf.runtime.common.core.command.CommandResult.newOKCommandResult(newElement);");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("throw new UnsupportedOperationException(\"Unimplemented operation (abstract domain element).\");");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence canExecute_Normal(final TypeModelFacet it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      GenFeature _containmentMetaFeature = it.getContainmentMetaFeature();
      boolean _notEquals = (!Objects.equal(_containmentMetaFeature, null));
      if (_notEquals) {
        {
          GenFeature _containmentMetaFeature_1 = it.getContainmentMetaFeature();
          EStructuralFeature _ecoreFeature = _containmentMetaFeature_1.getEcoreFeature();
          boolean _notEquals_1 = (!Objects.equal(_ecoreFeature, null));
          if (_notEquals_1) {
            {
              boolean _or = false;
              GenFeature _containmentMetaFeature_2 = it.getContainmentMetaFeature();
              EStructuralFeature _ecoreFeature_1 = _containmentMetaFeature_2.getEcoreFeature();
              boolean _isUnbounded = this._oclMigrationProblems_qvto.isUnbounded(_ecoreFeature_1);
              boolean _not = (!_isUnbounded);
              if (_not) {
                _or = true;
              } else {
                boolean _and = false;
                GenFeature _childMetaFeature = it.getChildMetaFeature();
                GenFeature _containmentMetaFeature_3 = it.getContainmentMetaFeature();
                boolean _notEquals_2 = (!Objects.equal(_childMetaFeature, _containmentMetaFeature_3));
                if (!_notEquals_2) {
                  _and = false;
                } else {
                  GenFeature _childMetaFeature_1 = it.getChildMetaFeature();
                  EStructuralFeature _ecoreFeature_2 = _childMetaFeature_1.getEcoreFeature();
                  boolean _isUnbounded_1 = this._oclMigrationProblems_qvto.isUnbounded(_ecoreFeature_2);
                  boolean _not_1 = (!_isUnbounded_1);
                  _and = _not_1;
                }
                _or = _and;
              }
              if (_or) {
                {
                  GenFeature _containmentMetaFeature_4 = it.getContainmentMetaFeature();
                  EStructuralFeature _ecoreFeature_3 = _containmentMetaFeature_4.getEcoreFeature();
                  boolean _isUnbounded_2 = this._oclMigrationProblems_qvto.isUnbounded(_ecoreFeature_3);
                  boolean _not_2 = (!_isUnbounded_2);
                  if (_not_2) {
                    GenFeature _containmentMetaFeature_5 = it.getContainmentMetaFeature();
                    GenClass _genClass = _containmentMetaFeature_5.getGenClass();
                    CharSequence _DeclareAndAssign = this._metaModel.DeclareAndAssign(_genClass, "container", "getElementToEdit()");
                    _builder.append(_DeclareAndAssign, "");
                    _builder.newLineIfNotEmpty();
                    {
                      GenFeature _containmentMetaFeature_6 = it.getContainmentMetaFeature();
                      EStructuralFeature _ecoreFeature_4 = _containmentMetaFeature_6.getEcoreFeature();
                      boolean _isSingleValued = this._oclMigrationProblems_qvto.isSingleValued(_ecoreFeature_4);
                      if (_isSingleValued) {
                        _builder.append("\t\t");
                        _builder.append("if (");
                        GenFeature _containmentMetaFeature_7 = it.getContainmentMetaFeature();
                        GenFeature _containmentMetaFeature_8 = it.getContainmentMetaFeature();
                        GenClass _genClass_1 = _containmentMetaFeature_8.getGenClass();
                        CharSequence _featureValue = this._metaModel.getFeatureValue(_containmentMetaFeature_7, "container", _genClass_1);
                        _builder.append(_featureValue, "\t\t");
                        _builder.append(" != null) {");
                        _builder.newLineIfNotEmpty();
                      } else {
                        _builder.append("\t\t");
                        _builder.append("if (");
                        GenFeature _containmentMetaFeature_9 = it.getContainmentMetaFeature();
                        GenFeature _containmentMetaFeature_10 = it.getContainmentMetaFeature();
                        GenClass _genClass_2 = _containmentMetaFeature_10.getGenClass();
                        CharSequence _featureValue_1 = this._metaModel.getFeatureValue(_containmentMetaFeature_9, "container", _genClass_2);
                        _builder.append(_featureValue_1, "\t\t");
                        _builder.append(".size() >= ");
                        GenFeature _containmentMetaFeature_11 = it.getContainmentMetaFeature();
                        EStructuralFeature _ecoreFeature_5 = _containmentMetaFeature_11.getEcoreFeature();
                        int _upperBound = _ecoreFeature_5.getUpperBound();
                        _builder.append(_upperBound, "\t\t");
                        _builder.append(") {");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("\t\t\t");
                    _builder.append("return false;");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
                {
                  boolean _and_1 = false;
                  GenFeature _childMetaFeature_2 = it.getChildMetaFeature();
                  GenFeature _containmentMetaFeature_12 = it.getContainmentMetaFeature();
                  boolean _notEquals_3 = (!Objects.equal(_childMetaFeature_2, _containmentMetaFeature_12));
                  if (!_notEquals_3) {
                    _and_1 = false;
                  } else {
                    GenFeature _childMetaFeature_3 = it.getChildMetaFeature();
                    EStructuralFeature _ecoreFeature_6 = _childMetaFeature_3.getEcoreFeature();
                    boolean _isUnbounded_3 = this._oclMigrationProblems_qvto.isUnbounded(_ecoreFeature_6);
                    boolean _not_3 = (!_isUnbounded_3);
                    _and_1 = _not_3;
                  }
                  if (_and_1) {
                    {
                      GenFeature _childMetaFeature_4 = it.getChildMetaFeature();
                      EStructuralFeature _ecoreFeature_7 = _childMetaFeature_4.getEcoreFeature();
                      boolean _isSingleValued_1 = this._oclMigrationProblems_qvto.isSingleValued(_ecoreFeature_7);
                      if (_isSingleValued_1) {
                        _builder.append("\t\t");
                        _builder.append("if (");
                        GenFeature _childMetaFeature_5 = it.getChildMetaFeature();
                        GenFeature _containmentMetaFeature_13 = it.getContainmentMetaFeature();
                        GenClass _genClass_3 = _containmentMetaFeature_13.getGenClass();
                        CharSequence _featureValue_2 = this._metaModel.getFeatureValue(_childMetaFeature_5, "container", _genClass_3);
                        _builder.append(_featureValue_2, "\t\t");
                        _builder.append(" != null) {");
                        _builder.newLineIfNotEmpty();
                      } else {
                        _builder.append("\t\t");
                        _builder.append("if (");
                        GenFeature _childMetaFeature_6 = it.getChildMetaFeature();
                        GenFeature _containmentMetaFeature_14 = it.getContainmentMetaFeature();
                        GenClass _genClass_4 = _containmentMetaFeature_14.getGenClass();
                        CharSequence _featureValue_3 = this._metaModel.getFeatureValue(_childMetaFeature_6, "container", _genClass_4);
                        _builder.append(_featureValue_3, "\t\t");
                        _builder.append(".size() >= ");
                        GenFeature _childMetaFeature_7 = it.getChildMetaFeature();
                        EStructuralFeature _ecoreFeature_8 = _childMetaFeature_7.getEcoreFeature();
                        int _upperBound_1 = _ecoreFeature_8.getUpperBound();
                        _builder.append(_upperBound_1, "\t\t");
                        _builder.append(") {");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("\t\t");
                    _builder.append("\t\t");
                    _builder.append("return false;");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
              }
            }
          }
        }
      }
    }
    _builder.newLine();
    _builder.append("org.eclipse.emf.ecore.EObject target = getElementToEdit();");
    _builder.newLine();
    _builder.append("org.eclipse.papyrus.infra.viewpoints.policy.ModelAddData data = org.eclipse.papyrus.infra.viewpoints.policy.PolicyChecker.getCurrent().getChildAddData(diagram, target.eClass(), ");
    GenClass _metaClass = it.getMetaClass();
    CharSequence _MetaClass = this._metaModel.MetaClass(_metaClass);
    _builder.append(_MetaClass, "");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("return data.isPermitted();");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence normalElementCreation(final TypeModelFacet it, final GenNode node, final String varName) {
    StringConcatenation _builder = new StringConcatenation();
    GenClass _metaClass = it.getMetaClass();
    CharSequence _NewInstance = this.xptMetaModel.NewInstance(_metaClass, varName);
    _builder.append(_NewInstance, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("org.eclipse.emf.ecore.EObject target = getElementToEdit();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.papyrus.infra.viewpoints.policy.ModelAddData data = org.eclipse.papyrus.infra.viewpoints.policy.PolicyChecker.getCurrent().getChildAddData(diagram, target, ");
    _builder.append(varName, "\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("if (data.isPermitted()) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (data.isPathDefined()) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (!data.execute(target, ");
    _builder.append(varName, "\t\t\t\t");
    _builder.append(")) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.append("return org.eclipse.gmf.runtime.common.core.command.CommandResult.newErrorCommandResult(\"Failed to follow the policy-specified for the insertion of the new element\");");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} else {");
    _builder.newLine();
    CharSequence _extraLineBreak = this._common.extraLineBreak();
    _builder.append(_extraLineBreak, "");
    _builder.newLineIfNotEmpty();
    {
      GenFeature _containmentMetaFeature = it.getContainmentMetaFeature();
      boolean _notEquals = (!Objects.equal(_containmentMetaFeature, null));
      if (_notEquals) {
        GenFeature _containmentMetaFeature_1 = it.getContainmentMetaFeature();
        GenClass _genClass = _containmentMetaFeature_1.getGenClass();
        CharSequence _DeclareAndAssign = this.xptMetaModel.DeclareAndAssign(_genClass, "qualifiedTarget", "target");
        _builder.append(_DeclareAndAssign, "");
        _builder.newLineIfNotEmpty();
        GenFeature _containmentMetaFeature_2 = it.getContainmentMetaFeature();
        GenFeature _containmentMetaFeature_3 = it.getContainmentMetaFeature();
        GenClass _genClass_1 = _containmentMetaFeature_3.getGenClass();
        CharSequence _modifyFeature = this.xptMetaModel.modifyFeature(_containmentMetaFeature_2, "qualifiedTarget", _genClass_1, varName);
        _builder.append(_modifyFeature, "");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("//");
        _builder.newLine();
        _builder.append("// FIXME no containment feature found in the genmodel, toolsmith need to manually write code here to add ");
        _builder.append(varName, "");
        _builder.append(" to a parent");
        _builder.newLineIfNotEmpty();
        _builder.append("//");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return org.eclipse.gmf.runtime.common.core.command.CommandResult.newErrorCommandResult(\"The active policy restricts the addition of this element\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      boolean _hasExplicitChildFeature = this._utils_qvto.hasExplicitChildFeature(it);
      if (_hasExplicitChildFeature) {
        GenFeature _childMetaFeature = it.getChildMetaFeature();
        GenClass _genClass_2 = _childMetaFeature.getGenClass();
        CharSequence _DeclareAndAssign_1 = this.xptMetaModel.DeclareAndAssign(_genClass_2, "childHolder", "getElementToEdit()");
        _builder.append(_DeclareAndAssign_1, "");
        _builder.newLineIfNotEmpty();
        GenFeature _childMetaFeature_1 = it.getChildMetaFeature();
        GenFeature _childMetaFeature_2 = it.getChildMetaFeature();
        GenClass _genClass_3 = _childMetaFeature_2.getGenClass();
        CharSequence _modifyFeature_1 = this.xptMetaModel.modifyFeature(_childMetaFeature_1, "childHolder", _genClass_3, varName);
        _builder.append(_modifyFeature_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
