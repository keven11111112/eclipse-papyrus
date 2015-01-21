/**
 * Copyright (c) 2006-2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.diagram.editpolicies;

import aspects.xpt.diagram.editpolicies.BaseItemSemanticEditPolicy;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Iterator;
import metamodel.MetaModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.papyrus.papyrusgmfgenextension.ConstrainedByReferenceCompartmentItemSemanticEditPolicy;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import xpt.Common;
import xpt.diagram.editpolicies.childContainerCreateCommand;

@Singleton
@SuppressWarnings("all")
public class CompartmentItemSemanticEditPolicy extends xpt.diagram.editpolicies.CompartmentItemSemanticEditPolicy {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private MetaModel _metaModel;
  
  @Inject
  private childContainerCreateCommand xptChildContainerCreateCommand;
  
  @Inject
  private BaseItemSemanticEditPolicy xptBaseItemSemanticEditPolicy;
  
  public CharSequence CompartmentItemSemanticEditPolicy(final GenCompartment it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    GenDiagram _diagram = it.getDiagram();
    GenEditorGenerator _editorGen = _diagram.getEditorGen();
    CharSequence _copyright = this._common.copyright(_editorGen);
    _builder.append(_copyright, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("package ");
    CharSequence _packageName = this.packageName(it);
    _builder.append(_packageName, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedClassComment = this._common.generatedClassComment();
    _builder.append(_generatedClassComment, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public class ");
    CharSequence _className = this.className(it);
    _builder.append(_className, "\t");
    _builder.append(" extends ");
    GenDiagram _diagram_1 = it.getDiagram();
    CharSequence _qualifiedClassName = this.xptBaseItemSemanticEditPolicy.qualifiedClassName(_diagram_1);
    _builder.append(_qualifiedClassName, "\t");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence __constructor = this._constructor(it);
    _builder.append(__constructor, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    EList<GenChildNode> _childNodes = it.getChildNodes();
    CharSequence _childContainerCreateCommand = this.xptChildContainerCreateCommand.childContainerCreateCommand(_childNodes);
    _builder.append(_childContainerCreateCommand, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _additions = this.additions(it);
    _builder.append(_additions, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    {
      Resource _eResource = it.eResource();
      TreeIterator<EObject> _allContents = _eResource.getAllContents();
      Iterator<ConstrainedByReferenceCompartmentItemSemanticEditPolicy> _filter = Iterators.<ConstrainedByReferenceCompartmentItemSemanticEditPolicy>filter(_allContents, ConstrainedByReferenceCompartmentItemSemanticEditPolicy.class);
      final Function1<ConstrainedByReferenceCompartmentItemSemanticEditPolicy, Boolean> _function = new Function1<ConstrainedByReferenceCompartmentItemSemanticEditPolicy, Boolean>() {
        public Boolean apply(final ConstrainedByReferenceCompartmentItemSemanticEditPolicy v) {
          EList<GenCommonBase> _genView = v.getGenView();
          return Boolean.valueOf(_genView.contains(it));
        }
      };
      Iterator<ConstrainedByReferenceCompartmentItemSemanticEditPolicy> _filter_1 = IteratorExtensions.<ConstrainedByReferenceCompartmentItemSemanticEditPolicy>filter(_filter, _function);
      int _size = IteratorExtensions.size(_filter_1);
      boolean _notEquals = (_size != 0);
      if (_notEquals) {
        _builder.append("\t");
        EList<GenChildNode> _childNodes_1 = it.getChildNodes();
        CharSequence _childNodeReference = this.getChildNodeReference(_childNodes_1);
        _builder.append(_childNodeReference, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        CharSequence _isCorrectCompartment = this.isCorrectCompartment(it);
        _builder.append(_isCorrectCompartment, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        CharSequence _constraintedMoveCommand = this.constraintedMoveCommand(it);
        _builder.append(_constraintedMoveCommand, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getChildNodeReference(final EList<GenChildNode> it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isEmpty = it.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        CharSequence _generatedMemberComment = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment, "");
        _builder.newLineIfNotEmpty();
        _builder.append("private static Set<EReference> compartmentReferences;");
        _builder.newLine();
        _builder.newLine();
        CharSequence _generatedMemberComment_1 = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment_1, "");
        _builder.newLineIfNotEmpty();
        _builder.append("static {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("compartmentReferences = new HashSet<EReference>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        {
          for(final GenChildNode n : it) {
            _builder.append("\t");
            TypeModelFacet _modelFacet = n.getModelFacet();
            CharSequence _childRef = this.childRef(_modelFacet, n);
            _builder.append(_childRef, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("}");
        _builder.newLine();
        CharSequence _generatedMemberComment_2 = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment_2, "");
        _builder.newLineIfNotEmpty();
        _builder.append("protected Iterable<EReference> getCompartmentReferences() {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return compartmentReferences;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence childRef(final TypeModelFacet it, final GenNode node) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("compartmentReferences.add(");
    TypeModelFacet _modelFacet = node.getModelFacet();
    GenFeature _containmentMetaFeature = _modelFacet.getContainmentMetaFeature();
    CharSequence _MetaFeature = this._metaModel.MetaFeature(_containmentMetaFeature);
    _builder.append(_MetaFeature, "");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence isCorrectCompartment(final GenCompartment it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected boolean isMovedIntoCorrectCompartment(MoveRequest req){");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("for(Object entry : req.getElementsToMove().entrySet()) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if(entry instanceof Map.Entry<?, ?>) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("Map.Entry<?, ?> mapEntry = (Map.Entry<?, ?>)entry;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("Object key = mapEntry.getKey();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if(key instanceof EObject) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("EObject dropppedObject = (EObject)key;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("EObject semanticHost = ((IGraphicalEditPart)getHost()).resolveSemanticElement();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("boolean foundERefrences = false;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if(semanticHost != null) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("for(EReference ref : getCompartmentReferences()) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("if(ref.isContainment()) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("foundERefrences = PackageUtil.canContain(semanticHost.eClass(), ref, dropppedObject.eClass(), false);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("foundERefrences = PackageUtil.canReference(semanticHost.eClass(), ref, dropppedObject.eClass());");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("if(foundERefrences) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence constraintedMoveCommand(final GenCompartment it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("protected Command getMoveCommand(MoveRequest req) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (isMovedIntoCorrectCompartment(req)){\t\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return super.getMoveCommand(req);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return UnexecutableCommand.INSTANCE;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
