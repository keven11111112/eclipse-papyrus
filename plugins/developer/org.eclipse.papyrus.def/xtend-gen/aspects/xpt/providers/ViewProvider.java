/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Artem Tikhomirov (Borland) - [257119] Create views directly, not through ViewFactories
 * 	  Michael Golubev (Montages) - #386838 - migrate to Xtend2
 *    Thibault Landre (Atos Origin) - initial API and implementation
 * 	  Vincent Lorenzo (CEA-LIST) Add a line to initialize the display of the compartments to true
 *    Vincent Lorenzo (CEA-LIST) - Add lines to initialize the display of the labels - Bug 335987 [General][Enhancement] Show/Hide Connectors Labels and External Nodes Labels
 */
package aspects.xpt.providers;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.codegen.gmfgen.ElementType;
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenLabel;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.LabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.MetamodelType;
import org.eclipse.gmf.codegen.gmfgen.NotationType;
import org.eclipse.gmf.codegen.gmfgen.SpecializationType;
import org.eclipse.gmf.codegen.gmfgen.Viewmap;
import org.eclipse.papyrus.papyrusgmfgenextension.LabelVisibilityPreference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import xpt.Common;
import xpt.Common_qvto;
import xpt.diagram.Utils_qvto;
import xpt.diagram.ViewmapAttributesUtils_qvto;
import xpt.diagram.editpolicies.LinkUtils_qvto;
import xpt.diagram.views.ViewStyles;
import xpt.editor.VisualIDRegistry;

@Singleton
@SuppressWarnings("all")
public class ViewProvider extends xpt.providers.ViewProvider {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private Common_qvto _common_qvto;
  
  @Inject
  @Extension
  private Utils_qvto _utils_qvto;
  
  @Inject
  @Extension
  private LinkUtils_qvto _linkUtils_qvto;
  
  @Inject
  @Extension
  private ViewmapAttributesUtils_qvto _viewmapAttributesUtils_qvto;
  
  @Inject
  @Extension
  private VisualIDRegistry _visualIDRegistry;
  
  @Inject
  private VisualIDRegistry xptVisualIDRegistry;
  
  @Inject
  private ViewStyles xptViewStyles;
  
  public CharSequence ViewProvider(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    GenEditorGenerator _editorGen = it.getEditorGen();
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
    _builder.append(" ");
    CharSequence _extendsList = this.extendsList(it);
    _builder.append(_extendsList, "\t");
    CharSequence _implementsList = this.implementsList(it);
    _builder.append(_implementsList, "\t");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("public final boolean provides(org.eclipse.gmf.runtime.common.core.service.IOperation operation) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (operation instanceof org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return provides((org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation) operation);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    CharSequence __assert = this._common._assert("operation instanceof org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewOperation");
    _builder.append(__assert, "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("if (operation instanceof org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return provides((org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation) operation);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} else if (operation instanceof org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return provides((org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation) operation);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} else if (operation instanceof org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return provides((org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation) operation);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generatedMemberComment_1 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_1, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("protected boolean provides(org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation op) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/*");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (op.getViewKind() == Node.class)");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return getNodeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (op.getViewKind() == Edge.class)");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return getEdgeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t      ");
    _builder.append("// check Diagram Type should be the class diagram");
    _builder.newLine();
    _builder.append("\t         ");
    _builder.append("String modelID = ");
    CharSequence _modelIDMethodCall = this._visualIDRegistry.getModelIDMethodCall(it);
    _builder.append(_modelIDMethodCall, "\t         ");
    _builder.append("(op.getContainerView());");
    _builder.newLineIfNotEmpty();
    _builder.append("\t         ");
    _builder.append("if(!getDiagramProvidedId().equals(modelID)) {");
    _builder.newLine();
    _builder.append("\t               ");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("\t         ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t         ");
    _builder.newLine();
    _builder.append("\t         ");
    _builder.append("int visualID = ");
    CharSequence _visualIDMethodCall = this._visualIDRegistry.getVisualIDMethodCall(it);
    _builder.append(_visualIDMethodCall, "\t         ");
    _builder.append("(op.getSemanticHint());");
    _builder.newLineIfNotEmpty();
    _builder.append("\t         ");
    _builder.append("if(org.eclipse.gmf.runtime.notation.Node.class.isAssignableFrom(op.getViewKind())) {");
    _builder.newLine();
    _builder.append("\t               ");
    _builder.append("return ");
    CharSequence _canCreateNodeMethodCall = this._visualIDRegistry.canCreateNodeMethodCall(it);
    _builder.append(_canCreateNodeMethodCall, "\t               ");
    _builder.append("(op.getContainerView(), visualID);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t         ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedMemberComment_2 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_2, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t     ");
    _builder.append("protected String getDiagramProvidedId() {");
    _builder.newLine();
    _builder.append("\t     ");
    _builder.append("/*");
    _builder.newLine();
    _builder.append("\t     ");
    _builder.append("* Indicates for which diagram this provider works for.");
    _builder.newLine();
    _builder.append("\t     ");
    _builder.append("* <p>");
    _builder.newLine();
    _builder.append("\t     ");
    _builder.append("* This method can be overloaded when diagram editor inherits from another one, but should never be <code>null</code>");
    _builder.newLine();
    _builder.append("\t     ");
    _builder.append("* </p>");
    _builder.newLine();
    _builder.append("\t     ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append("\t      ");
    _builder.append("* @return the unique identifier of the diagram for which views are provided.");
    _builder.newLine();
    _builder.append("\t     ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t           ");
    _builder.append("return ");
    CharSequence _modelID = VisualIDRegistry.modelID(it);
    _builder.append(_modelID, "\t           ");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t     ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generatedMemberComment_3 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_3, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("protected boolean provides(org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation op) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return ");
    CharSequence _modelID_1 = VisualIDRegistry.modelID(it);
    _builder.append(_modelID_1, "\t\t\t");
    _builder.append(".equals(op.getSemanticHint())");
    {
      GenClass _domainDiagramElement = it.getDomainDiagramElement();
      boolean _notEquals = (!Objects.equal(_domainDiagramElement, null));
      if (_notEquals) {
        _builder.append(" && ");
        CharSequence _diagramVisualIDMethodCall = this.xptVisualIDRegistry.getDiagramVisualIDMethodCall(it);
        _builder.append(_diagramVisualIDMethodCall, "\t\t\t");
        _builder.append("(getSemanticElement(op.getSemanticAdapter())) != -1");
      }
    }
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generatedMemberComment_4 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_4, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("protected boolean provides(org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation op) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (op.getContainerView() == null) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("org.eclipse.gmf.runtime.emf.type.core.IElementType elementType = getSemanticElementType(op.getSemanticAdapter());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("org.eclipse.emf.ecore.EObject domainElement = getSemanticElement(op.getSemanticAdapter());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("int visualID;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (op.getSemanticHint() == null) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("// In this situation there should be NO elementType, visualID will be determined");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("// by VisualIDRegistry.getNodeVisualID() for domainElement.");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (elementType != null || domainElement == null) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("visualID = ");
    CharSequence _nodeVisualIDMethodCall = this.xptVisualIDRegistry.getNodeVisualIDMethodCall(it);
    _builder.append(_nodeVisualIDMethodCall, "\t\t\t\t");
    _builder.append("(op.getContainerView(), domainElement);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("visualID = ");
    CharSequence _visualIDMethodCall_1 = this.xptVisualIDRegistry.getVisualIDMethodCall(it);
    _builder.append(_visualIDMethodCall_1, "\t\t\t\t");
    _builder.append("(op.getSemanticHint());");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("if (elementType != null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (!");
    String _elementTypesQualifiedClassName = it.getElementTypesQualifiedClassName();
    _builder.append(_elementTypesQualifiedClassName, "\t\t\t\t");
    _builder.append(".isKnownElementType(elementType) || (!(elementType instanceof org.eclipse.gmf.runtime.emf.type.core.IHintedType))) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.append("return false; // foreign element type");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("String elementTypeHint = ((org.eclipse.gmf.runtime.emf.type.core.IHintedType) elementType).getSemanticHint();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (!op.getSemanticHint().equals(elementTypeHint)) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return false; // if semantic hint is specified it should be the same as in element type");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("//if (domainElement != null && visualID != ");
    CharSequence _nodeVisualIDMethodCall_1 = this._visualIDRegistry.getNodeVisualIDMethodCall(it);
    _builder.append(_nodeVisualIDMethodCall_1, "\t\t\t");
    _builder.append("(op.getContainerView(), domainElement)) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("//\treturn false; // visual id for node EClass should match visual id from element type");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("//}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} else {");
    _builder.newLine();
    {
      List<GenCommonBase> _allTypedElements = this._utils_qvto.getAllTypedElements(it);
      final Function1<GenCommonBase, Boolean> _function = new Function1<GenCommonBase, Boolean>() {
        public Boolean apply(final GenCommonBase e) {
          ElementType _elementType = e.getElementType();
          return Boolean.valueOf((!Objects.equal(_elementType, null)));
        }
      };
      Iterable<GenCommonBase> _filter = IterableExtensions.<GenCommonBase>filter(_allTypedElements, _function);
      boolean _isEmpty = IterableExtensions.isEmpty(_filter);
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.append("\t\t\t");
        _builder.append("if (!");
        CharSequence _modelID_2 = VisualIDRegistry.modelID(it);
        _builder.append(_modelID_2, "\t\t\t");
        _builder.append(".equals(");
        CharSequence _modelIDMethodCall_1 = this.xptVisualIDRegistry.getModelIDMethodCall(it);
        _builder.append(_modelIDMethodCall_1, "\t\t\t");
        _builder.append("(op.getContainerView()))) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("return false; // foreign diagram");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("switch (visualID) {");
        _builder.newLine();
        {
          EList<GenNode> _allNodes = it.getAllNodes();
          final Function1<GenNode, Boolean> _function_1 = new Function1<GenNode, Boolean>() {
            public Boolean apply(final GenNode e) {
              ElementType _elementType = e.getElementType();
              return Boolean.valueOf((_elementType instanceof NotationType));
            }
          };
          boolean _exists = IterableExtensions.<GenNode>exists(_allNodes, _function_1);
          if (_exists) {
            {
              EList<GenNode> _allNodes_1 = it.getAllNodes();
              final Function1<GenNode, ElementType> _function_2 = new Function1<GenNode, ElementType>() {
                public ElementType apply(final GenNode e) {
                  return e.getElementType();
                }
              };
              List<ElementType> _map = ListExtensions.<GenNode, ElementType>map(_allNodes_1, _function_2);
              Iterable<NotationType> _filter_1 = Iterables.<NotationType>filter(_map, NotationType.class);
              for(final NotationType e : _filter_1) {
                _builder.append("\t\t\t");
                CharSequence _localCaseVisualID = this.localCaseVisualID(e);
                _builder.append(_localCaseVisualID, "\t\t\t");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t\t\t");
            _builder.append("break; // pure design element");
            _builder.newLine();
          }
        }
        {
          EList<GenNode> _allNodes_2 = it.getAllNodes();
          final Function1<GenNode, Boolean> _function_3 = new Function1<GenNode, Boolean>() {
            public Boolean apply(final GenNode e) {
              boolean _or = false;
              ElementType _elementType = e.getElementType();
              if ((_elementType instanceof MetamodelType)) {
                _or = true;
              } else {
                ElementType _elementType_1 = e.getElementType();
                _or = (_elementType_1 instanceof SpecializationType);
              }
              return Boolean.valueOf(_or);
            }
          };
          boolean _exists_1 = IterableExtensions.<GenNode>exists(_allNodes_2, _function_3);
          if (_exists_1) {
            {
              EList<GenNode> _allNodes_3 = it.getAllNodes();
              final Function1<GenNode, ElementType> _function_4 = new Function1<GenNode, ElementType>() {
                public ElementType apply(final GenNode e) {
                  return e.getElementType();
                }
              };
              List<ElementType> _map_1 = ListExtensions.<GenNode, ElementType>map(_allNodes_3, _function_4);
              Iterable<MetamodelType> _filter_2 = Iterables.<MetamodelType>filter(_map_1, MetamodelType.class);
              for(final MetamodelType e_1 : _filter_2) {
                _builder.append("\t\t\t");
                CharSequence _localCaseVisualID_1 = this.localCaseVisualID(e_1);
                _builder.append(_localCaseVisualID_1, "\t\t\t");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              EList<GenNode> _allNodes_4 = it.getAllNodes();
              final Function1<GenNode, ElementType> _function_5 = new Function1<GenNode, ElementType>() {
                public ElementType apply(final GenNode e) {
                  return e.getElementType();
                }
              };
              List<ElementType> _map_2 = ListExtensions.<GenNode, ElementType>map(_allNodes_4, _function_5);
              Iterable<SpecializationType> _filter_3 = Iterables.<SpecializationType>filter(_map_2, SpecializationType.class);
              for(final SpecializationType e_2 : _filter_3) {
                _builder.append("\t\t\t");
                CharSequence _localCaseVisualID_2 = this.localCaseVisualID(e_2);
                _builder.append(_localCaseVisualID_2, "\t\t\t");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t\t\t");
            _builder.append("if (domainElement == null || visualID != ");
            CharSequence _nodeVisualIDMethodCall_2 = this.xptVisualIDRegistry.getNodeVisualIDMethodCall(it);
            _builder.append(_nodeVisualIDMethodCall_2, "\t\t\t");
            _builder.append("(op.getContainerView(), domainElement)) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("return false; // visual id in semantic hint should match visual id for domain element");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("break;");
            _builder.newLine();
          }
        }
        _builder.append("\t\t\t");
        _builder.append("default:");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("return false;");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
      } else {
        _builder.append("\t\t\t");
        _builder.append("return false;");
        _builder.newLine();
      }
    }
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return ");
    CharSequence _canCreateNodeMethodCall_1 = this._visualIDRegistry.canCreateNodeMethodCall(it);
    _builder.append(_canCreateNodeMethodCall_1, "\t\t\t\t");
    _builder.append("(op.getContainerView(), visualID);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generatedMemberComment_5 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_5, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("protected boolean provides(org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation op) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.emf.type.core.IElementType elementType = getSemanticElementType(op.getSemanticAdapter());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//RS: add code for extended types creation");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if(elementType instanceof org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.gmf.runtime.emf.type.core.IElementType closestNonExtendedType = org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils.getClosestDiagramType(elementType);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if(!");
    String _elementTypesQualifiedClassName_1 = it.getElementTypesQualifiedClassName();
    _builder.append(_elementTypesQualifiedClassName_1, "\t\t");
    _builder.append(".isKnownElementType(closestNonExtendedType) || (!(closestNonExtendedType instanceof org.eclipse.gmf.runtime.emf.type.core.IHintedType))) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("return false; // foreign element type.");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (!");
    String _elementTypesQualifiedClassName_2 = it.getElementTypesQualifiedClassName();
    _builder.append(_elementTypesQualifiedClassName_2, "\t\t");
    _builder.append(".isKnownElementType(elementType) || (!(elementType instanceof org.eclipse.gmf.runtime.emf.type.core.IHintedType))) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("return false; // foreign element type");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//if (!");
    String _elementTypesQualifiedClassName_3 = it.getElementTypesQualifiedClassName();
    _builder.append(_elementTypesQualifiedClassName_3, "\t");
    _builder.append(".isKnownElementType(elementType) || (!(elementType instanceof org.eclipse.gmf.runtime.emf.type.core.IHintedType))) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//\treturn false; // foreign element type");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// END R.S.");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String elementTypeHint = ((org.eclipse.gmf.runtime.emf.type.core.IHintedType) elementType).getSemanticHint();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (elementTypeHint == null || (op.getSemanticHint() != null && !elementTypeHint.equals(op.getSemanticHint()))) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return false; // our hint is visual id and must be specified, and it should be the same as in element type");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//int visualID = ");
    CharSequence _visualIDMethodCall_2 = this._visualIDRegistry.getVisualIDMethodCall(it);
    _builder.append(_visualIDMethodCall_2, "\t");
    _builder.append("(elementTypeHint);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//org.eclipse.emf.ecore.EObject domainElement = getSemanticElement(op.getSemanticAdapter());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//if (domainElement != null && visualID != ");
    CharSequence _linkWithClassVisualIDMethodCall = this._visualIDRegistry.getLinkWithClassVisualIDMethodCall(it);
    _builder.append(_linkWithClassVisualIDMethodCall, "\t");
    _builder.append("(domainElement)) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//\treturn false; // visual id for link EClass should match visual id from element type");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return true; ");
    _builder.append("\t}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generatedMemberComment_6 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_6, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("@SuppressWarnings(\"unchecked\")");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public org.eclipse.gmf.runtime.notation.Diagram createDiagram(org.eclipse.core.runtime.IAdaptable semanticAdapter, String diagramKind, org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint preferencesHint) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("org.eclipse.gmf.runtime.notation.Diagram diagram = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createDiagram();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("org.eclipse.papyrus.infra.gmfdiag.common.reconciler.DiagramVersioningUtils.stampCurrentVersion(diagram);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("diagram.getStyles().add(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createDiagramStyle());");
    _builder.newLine();
    _builder.append("\t\t\t");
    CharSequence _addCustomStyles = this.xptViewStyles.addCustomStyles(it, "diagram.getStyles()");
    _builder.append(_addCustomStyles, "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("diagram.setType(");
    CharSequence _modelID_3 = VisualIDRegistry.modelID(it);
    _builder.append(_modelID_3, "\t\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("diagram.setElement(");
    {
      GenClass _domainDiagramElement_1 = it.getDomainDiagramElement();
      boolean _notEquals_1 = (!Objects.equal(_domainDiagramElement_1, null));
      if (_notEquals_1) {
        _builder.append("getSemanticElement(semanticAdapter)");
      } else {
        _builder.append("null");
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    {
      String _units = it.getUnits();
      boolean _notEquals_2 = (!Objects.equal(_units, null));
      if (_notEquals_2) {
        _builder.append("\t\t");
        _builder.append("diagram.setMeasurementUnit(org.eclipse.gmf.runtime.notation.MeasurementUnit.");
        String _units_1 = it.getUnits();
        String _upperCase = _units_1.toUpperCase();
        _builder.append(_upperCase, "\t\t");
        _builder.append("_LITERAL);");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<GenClass> _styles = it.getStyles();
      boolean _isEmpty_1 = _styles.isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      if (_not_1) {
        _builder.append("\t\t");
        _builder.append("// initializeFromPreferences");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("org.eclipse.jface.preferences.IPreferenceStore store = (org.eclipse.jface.preferences.IPreferenceStore) preferencesHint.getPreferenceStore();");
        _builder.newLine();
        _builder.append("\t\t");
        CharSequence _initializeStyles = this.initializeStyles(it, "diagram", "store", false, false, false);
        _builder.append(_initializeStyles, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("return diagram;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generatedMemberComment_7 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_7, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("public org.eclipse.gmf.runtime.notation.Node createNode(org.eclipse.core.runtime.IAdaptable semanticAdapter, org.eclipse.gmf.runtime.notation.View containerView, String semanticHint, int index, boolean persisted, org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint preferencesHint) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("final org.eclipse.emf.ecore.EObject domainElement = getSemanticElement(semanticAdapter);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("final int visualID;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (semanticHint == null) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("visualID = ");
    CharSequence _nodeVisualIDMethodCall_3 = this.xptVisualIDRegistry.getNodeVisualIDMethodCall(it);
    _builder.append(_nodeVisualIDMethodCall_3, "\t\t\t\t");
    _builder.append("(containerView, domainElement);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("visualID = ");
    CharSequence _visualIDMethodCall_3 = this.xptVisualIDRegistry.getVisualIDMethodCall(it);
    _builder.append(_visualIDMethodCall_3, "\t\t\t\t");
    _builder.append("(semanticHint);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("switch(visualID) {");
    _builder.newLine();
    {
      EList<GenNode> _allNodes_5 = it.getAllNodes();
      for(final GenNode n : _allNodes_5) {
        _builder.append("\t\t\t");
        CharSequence _caseVisualID = this.xptVisualIDRegistry.caseVisualID(n);
        _builder.append(_caseVisualID, "\t\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("return create");
        String _uniqueIdentifier = n.getUniqueIdentifier();
        _builder.append(_uniqueIdentifier, "\t\t\t\t");
        _builder.append("(domainElement, containerView, index, persisted, preferencesHint);");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// can\'t happen, provided #provides(CreateNodeViewOperation) is correct");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generatedMemberComment_8 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_8, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("public org.eclipse.gmf.runtime.notation.Edge createEdge(org.eclipse.core.runtime.IAdaptable semanticAdapter, org.eclipse.gmf.runtime.notation.View containerView, String semanticHint, int index, boolean persisted, org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint preferencesHint) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("org.eclipse.gmf.runtime.emf.type.core.IElementType elementType = getSemanticElementType(semanticAdapter);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("String elementTypeHint = ((org.eclipse.gmf.runtime.emf.type.core.IHintedType) elementType).getSemanticHint();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("switch (");
    CharSequence _visualIDMethodCall_4 = this.xptVisualIDRegistry.getVisualIDMethodCall(it);
    _builder.append(_visualIDMethodCall_4, "\t\t\t");
    _builder.append("(elementTypeHint)) {");
    _builder.newLineIfNotEmpty();
    {
      EList<GenLink> _links = it.getLinks();
      for(final GenLink link : _links) {
        _builder.append("\t\t\t");
        CharSequence _caseVisualID_1 = this.xptVisualIDRegistry.caseVisualID(link);
        _builder.append(_caseVisualID_1, "\t\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("return create");
        String _uniqueIdentifier_1 = link.getUniqueIdentifier();
        _builder.append(_uniqueIdentifier_1, "\t\t\t\t");
        _builder.append("(");
        {
          boolean _isTypeLink = this._linkUtils_qvto.isTypeLink(link);
          if (_isTypeLink) {
            _builder.append(" getSemanticElement(semanticAdapter), ");
          }
        }
        _builder.append("containerView, index, persisted, preferencesHint);");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// can never happen, provided #provides(CreateEdgeViewOperation) is correct");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<GenNode> _allNodes_6 = it.getAllNodes();
      for(final GenNode next : _allNodes_6) {
        _builder.append("\t\t");
        CharSequence _createNodeMethod = this.createNodeMethod(next);
        _builder.append(_createNodeMethod, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<GenLink> _links_1 = it.getLinks();
      for(final GenLink next_1 : _links_1) {
        _builder.append("\t\t");
        CharSequence _createEdgeMethod = this.createEdgeMethod(next_1);
        _builder.append(_createEdgeMethod, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      EList<GenTopLevelNode> _topLevelNodes = it.getTopLevelNodes();
      boolean _isEmpty_2 = _topLevelNodes.isEmpty();
      boolean _not_2 = (!_isEmpty_2);
      if (_not_2) {
        _builder.append("\t\t");
        CharSequence _generatedMemberComment_9 = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment_9, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("protected void stampShortcut(org.eclipse.gmf.runtime.notation.View containerView, org.eclipse.gmf.runtime.notation.Node target) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("if (!");
        CharSequence _modelID_4 = VisualIDRegistry.modelID(it);
        _builder.append(_modelID_4, "\t\t\t");
        _builder.append(".equals(");
        CharSequence _modelIDMethodCall_2 = this.xptVisualIDRegistry.getModelIDMethodCall(it);
        _builder.append(_modelIDMethodCall_2, "\t\t\t");
        _builder.append("(containerView))) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t\t");
        CharSequence _addShortcutAnnotation = this._common.addShortcutAnnotation(it, "target");
        _builder.append(_addShortcutAnnotation, "\t\t\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      boolean _or = false;
      boolean _or_1 = false;
      EList<GenLink> _links_2 = it.getLinks();
      final Function1<GenLink, EList<GenLinkLabel>> _function_6 = new Function1<GenLink, EList<GenLinkLabel>>() {
        public EList<GenLinkLabel> apply(final GenLink l) {
          return l.getLabels();
        }
      };
      List<EList<GenLinkLabel>> _map_3 = ListExtensions.<GenLink, EList<GenLinkLabel>>map(_links_2, _function_6);
      Iterable<GenLinkLabel> _flatten = Iterables.<GenLinkLabel>concat(_map_3);
      boolean _notEmpty = this._common_qvto.<GenLinkLabel>notEmpty(_flatten);
      if (_notEmpty) {
        _or_1 = true;
      } else {
        EList<GenTopLevelNode> _topLevelNodes_1 = it.getTopLevelNodes();
        final Function1<GenTopLevelNode, EList<GenNodeLabel>> _function_7 = new Function1<GenTopLevelNode, EList<GenNodeLabel>>() {
          public EList<GenNodeLabel> apply(final GenTopLevelNode n) {
            return n.getLabels();
          }
        };
        List<EList<GenNodeLabel>> _map_4 = ListExtensions.<GenTopLevelNode, EList<GenNodeLabel>>map(_topLevelNodes_1, _function_7);
        Iterable<GenNodeLabel> _flatten_1 = Iterables.<GenNodeLabel>concat(_map_4);
        boolean _notEmpty_1 = this._common_qvto.<GenNodeLabel>notEmpty(_flatten_1);
        _or_1 = _notEmpty_1;
      }
      if (_or_1) {
        _or = true;
      } else {
        EList<GenChildNode> _childNodes = it.getChildNodes();
        final Function1<GenChildNode, EList<GenNodeLabel>> _function_8 = new Function1<GenChildNode, EList<GenNodeLabel>>() {
          public EList<GenNodeLabel> apply(final GenChildNode n) {
            return n.getLabels();
          }
        };
        List<EList<GenNodeLabel>> _map_5 = ListExtensions.<GenChildNode, EList<GenNodeLabel>>map(_childNodes, _function_8);
        Iterable<GenNodeLabel> _flatten_2 = Iterables.<GenNodeLabel>concat(_map_5);
        boolean _notEmpty_2 = this._common_qvto.<GenNodeLabel>notEmpty(_flatten_2);
        _or = _notEmpty_2;
      }
      if (_or) {
        _builder.append("\t\t");
        CharSequence _generatedMemberComment_10 = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment_10, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("protected org.eclipse.gmf.runtime.notation.Node createLabel(org.eclipse.gmf.runtime.notation.View owner, String hint) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("org.eclipse.gmf.runtime.notation.DecorationNode rv = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createDecorationNode();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("rv.setType(hint);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.insertChildView(owner, rv, org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.APPEND, true);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("return rv;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      EList<GenNode> _allNodes_7 = it.getAllNodes();
      final Function1<GenNode, EList<GenCompartment>> _function_9 = new Function1<GenNode, EList<GenCompartment>>() {
        public EList<GenCompartment> apply(final GenNode n) {
          return n.getCompartments();
        }
      };
      List<EList<GenCompartment>> _map_6 = ListExtensions.<GenNode, EList<GenCompartment>>map(_allNodes_7, _function_9);
      Iterable<GenCompartment> _flatten_3 = Iterables.<GenCompartment>concat(_map_6);
      boolean _notEmpty_3 = this._common_qvto.<GenCompartment>notEmpty(_flatten_3);
      if (_notEmpty_3) {
        _builder.append("\t\t");
        CharSequence _generatedMemberComment_11 = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment_11, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("protected org.eclipse.gmf.runtime.notation.Node createCompartment(org.eclipse.gmf.runtime.notation.View owner, String hint, boolean canCollapse, boolean hasTitle, boolean canSort, boolean canFilter) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("//SemanticListCompartment rv = NotationFactory.eINSTANCE.createSemanticListCompartment();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("//rv.setShowTitle(showTitle);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("//rv.setCollapsed(isCollapsed);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("org.eclipse.gmf.runtime.notation.Node rv;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("if (canCollapse) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("rv = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createBasicCompartment();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("} else {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("rv = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createDecorationNode();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("rv.setLayoutConstraint(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createBounds());");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("if (hasTitle) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("org.eclipse.gmf.runtime.notation.TitleStyle ts = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createTitleStyle();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("rv.getStyles().add(ts);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("if (canSort) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("rv.getStyles().add(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createSortingStyle());");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("if (canFilter) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("rv.getStyles().add(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createFilteringStyle());");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("rv.setType(hint);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.insertChildView(owner, rv, org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.APPEND, true);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("return rv;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _semanticElementMethod = this.getSemanticElementMethod(it);
    _builder.append(_semanticElementMethod, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    CharSequence _semanticElementTypeMethod = this.getSemanticElementTypeMethod(it);
    _builder.append(_semanticElementTypeMethod, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    CharSequence _additions = this.additions(it);
    _builder.append(_additions, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _createNodeMethod(final GenNode it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public org.eclipse.gmf.runtime.notation.Node create");
    String _uniqueIdentifier = it.getUniqueIdentifier();
    _builder.append(_uniqueIdentifier, "");
    _builder.append("(org.eclipse.emf.ecore.EObject domainElement, org.eclipse.gmf.runtime.notation.View containerView, int index, boolean persisted, org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint preferencesHint) {");
    _builder.newLineIfNotEmpty();
    {
      Viewmap _viewmap = it.getViewmap();
      boolean _canUseShapeStyle = this._viewmapAttributesUtils_qvto.canUseShapeStyle(_viewmap);
      if (_canUseShapeStyle) {
        _builder.append("\t");
        _builder.append("org.eclipse.gmf.runtime.notation.Shape node = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createShape();");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("org.eclipse.gmf.runtime.notation.Node node = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createNode();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("node.getStyles().add(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createDescriptionStyle());");
        _builder.newLine();
        _builder.append("\t");
        Viewmap _viewmap_1 = it.getViewmap();
        CharSequence _addFontLineFillStylesConditionally = this.xptViewStyles.addFontLineFillStylesConditionally(_viewmap_1, "node.getStyles()");
        _builder.append(_addFontLineFillStylesConditionally, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    CharSequence _addLinkedDiagramStyle = this.xptViewStyles.addLinkedDiagramStyle(it, "node.getStyles()");
    _builder.append(_addLinkedDiagramStyle, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _addCustomStyles = this.xptViewStyles.addCustomStyles(it, "node.getStyles()");
    _builder.append(_addCustomStyles, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("node.setLayoutConstraint(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createBounds());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("node.setType(");
    CharSequence _typeMethodCall = this.xptVisualIDRegistry.typeMethodCall(it);
    _builder.append(_typeMethodCall, "\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.insertChildView(containerView, node, index, persisted);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("node.setElement(domainElement);");
    _builder.newLine();
    {
      if ((it instanceof GenTopLevelNode)) {
        _builder.append("\t");
        _builder.append("stampShortcut(containerView, node);");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("// initializeFromPreferences ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("final org.eclipse.jface.preference.IPreferenceStore prefStore = (org.eclipse.jface.preference.IPreferenceStore) preferencesHint.getPreferenceStore();");
    _builder.newLine();
    _builder.append("\t");
    Viewmap _viewmap_2 = it.getViewmap();
    boolean _isFixedForeground = this._viewmapAttributesUtils_qvto.isFixedForeground(_viewmap_2);
    boolean _not = (!_isFixedForeground);
    Viewmap _viewmap_3 = it.getViewmap();
    boolean _isFixedBackground = this._viewmapAttributesUtils_qvto.isFixedBackground(_viewmap_3);
    boolean _not_1 = (!_isFixedBackground);
    Viewmap _viewmap_4 = it.getViewmap();
    boolean _isFixedFont = this._viewmapAttributesUtils_qvto.isFixedFont(_viewmap_4);
    boolean _not_2 = (!_isFixedFont);
    CharSequence _initializeStyles = this.initializeStyles(it, "node", "prefStore", _not, _not_1, _not_2);
    _builder.append(_initializeStyles, "\t");
    _builder.newLineIfNotEmpty();
    {
      EList<GenNodeLabel> _labels = it.getLabels();
      for(final GenNodeLabel label : _labels) {
        _builder.append("\t");
        CharSequence _initLabel = this.initLabel(label, "node", "prefStore");
        _builder.append(_initLabel, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<GenCompartment> _compartments = it.getCompartments();
      for(final GenCompartment comp : _compartments) {
        _builder.append("\t");
        CharSequence _initCompartment = this.initCompartment(comp, "node", "prefStore");
        _builder.append(_initCompartment, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<GenCompartment> _compartments_1 = it.getCompartments();
      int _size = _compartments_1.size();
      boolean _notEquals = (_size != 0);
      if (_notEquals) {
        _builder.append("org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(");
        _builder.append("node", "");
        _builder.append(", ");
        _builder.append("prefStore", "");
        _builder.append(", \"");
        ElementType _elementType = it.getElementType();
        String _displayName = _elementType.getDisplayName();
        _builder.append(_displayName, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t\t");
    _builder.append("return node;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _createNodeMethod(final GenChildLabelNode it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public org.eclipse.gmf.runtime.notation.Node create");
    String _uniqueIdentifier = it.getUniqueIdentifier();
    _builder.append(_uniqueIdentifier, "");
    _builder.append("(org.eclipse.emf.ecore.EObject domainElement, org.eclipse.gmf.runtime.notation.View containerView, int index, boolean persisted, org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint preferencesHint) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.notation.Node node = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createShape();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("node.setLayoutConstraint(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createLocation());");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _addLinkedDiagramStyle = this.xptViewStyles.addLinkedDiagramStyle(it, "node.getStyles()");
    _builder.append(_addLinkedDiagramStyle, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _addCustomStyles = this.xptViewStyles.addCustomStyles(it, "node.getStyles()");
    _builder.append(_addCustomStyles, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("node.setType(");
    CharSequence _typeMethodCall = this.xptVisualIDRegistry.typeMethodCall(it);
    _builder.append(_typeMethodCall, "\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.insertChildView(containerView, node, index, persisted);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("node.setElement(domainElement);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("final org.eclipse.jface.preference.IPreferenceStore prefStore = (org.eclipse.jface.preference.IPreferenceStore) preferencesHint.getPreferenceStore();");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _initFontFromPrefs = this.initFontFromPrefs(it, "node", "prefStore");
    _builder.append(_initFontFromPrefs, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _initForegroundFromPrefs = this.initForegroundFromPrefs(it, "node", "prefStore");
    _builder.append(_initForegroundFromPrefs, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return node;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence createEdgeMethod(final GenLink it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public org.eclipse.gmf.runtime.notation.Edge create");
    String _uniqueIdentifier = it.getUniqueIdentifier();
    _builder.append(_uniqueIdentifier, "");
    _builder.append("(");
    {
      boolean _isTypeLink = this._linkUtils_qvto.isTypeLink(it);
      if (_isTypeLink) {
        _builder.append("org.eclipse.emf.ecore.EObject domainElement, ");
      }
    }
    _builder.append("org.eclipse.gmf.runtime.notation.View containerView, int index, boolean persisted, org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint preferencesHint) {");
    _builder.newLineIfNotEmpty();
    {
      Viewmap _viewmap = it.getViewmap();
      boolean _isFixedForeground = this._viewmapAttributesUtils_qvto.isFixedForeground(_viewmap);
      if (_isFixedForeground) {
        _builder.append("org.eclipse.gmf.runtime.notation.Edge edge = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createEdge();");
        _builder.newLine();
        _builder.append("edge.getStyles().add(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createRoutingStyle());");
        _builder.newLine();
      } else {
        _builder.append("org.eclipse.gmf.runtime.notation.Connector edge = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createConnector();");
        _builder.newLine();
      }
    }
    {
      Viewmap _viewmap_1 = it.getViewmap();
      boolean _isFixedFont = this._viewmapAttributesUtils_qvto.isFixedFont(_viewmap_1);
      boolean _not = (!_isFixedFont);
      if (_not) {
        _builder.append("edge.getStyles().add(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createFontStyle());");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    CharSequence _addCustomStyles = this.xptViewStyles.addCustomStyles(it, "edge.getStyles()");
    _builder.append(_addCustomStyles, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.notation.RelativeBendpoints bendpoints = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createRelativeBendpoints();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("java.util.List<org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint> points = new java.util.ArrayList<org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint>(2); ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("points.add(new org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("points.add(new org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("bendpoints.setPoints(points);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("edge.setBendpoints(bendpoints);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.insertChildView(containerView, edge, index, persisted);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("edge.setType(");
    CharSequence _typeMethodCall = this.xptVisualIDRegistry.typeMethodCall(it);
    _builder.append(_typeMethodCall, "\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("edge.setElement(");
    {
      boolean _isTypeLink_1 = this._linkUtils_qvto.isTypeLink(it);
      if (_isTypeLink_1) {
        _builder.append("domainElement");
      } else {
        _builder.append("null");
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("// initializePreferences");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("final org.eclipse.jface.preference.IPreferenceStore prefStore = (org.eclipse.jface.preference.IPreferenceStore) preferencesHint.getPreferenceStore();");
    _builder.newLine();
    _builder.append("\t");
    Viewmap _viewmap_2 = it.getViewmap();
    boolean _isFixedForeground_1 = this._viewmapAttributesUtils_qvto.isFixedForeground(_viewmap_2);
    boolean _not_1 = (!_isFixedForeground_1);
    Viewmap _viewmap_3 = it.getViewmap();
    boolean _isFixedFont_1 = this._viewmapAttributesUtils_qvto.isFixedFont(_viewmap_3);
    boolean _not_2 = (!_isFixedFont_1);
    CharSequence _initializeStyles = this.initializeStyles(it, "edge", "prefStore", _not_1, false, _not_2);
    _builder.append(_initializeStyles, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//if (routing != null) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//\torg.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//}");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _initRountingFromPrefs = this.initRountingFromPrefs(it, "edge", "prefStore");
    _builder.append(_initRountingFromPrefs, "\t");
    _builder.newLineIfNotEmpty();
    {
      EList<GenLinkLabel> _labels = it.getLabels();
      for(final GenLinkLabel label : _labels) {
        _builder.append("\t");
        CharSequence _initLabel = this.initLabel(label, "edge", "prefStore");
        _builder.append(_initLabel, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    CharSequence _initLabelVisibility = this.initLabelVisibility(it, "edge", "prefStore");
    _builder.append(_initLabelVisibility, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return edge;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getSemanticElementMethod(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected org.eclipse.emf.ecore.EObject getSemanticElement(org.eclipse.core.runtime.IAdaptable semanticAdapter) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (semanticAdapter == null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.emf.ecore.EObject eObject = (org.eclipse.emf.ecore.EObject) semanticAdapter.getAdapter(org.eclipse.emf.ecore.EObject.class);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (eObject != null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil.resolve(org.eclipse.emf.transaction.util.TransactionUtil.getEditingDomain(eObject), eObject);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getSemanticElementTypeMethod(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected org.eclipse.gmf.runtime.emf.type.core.IElementType getSemanticElementType(org.eclipse.core.runtime.IAdaptable semanticAdapter) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (semanticAdapter == null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return (org.eclipse.gmf.runtime.emf.type.core.IElementType) semanticAdapter.getAdapter(org.eclipse.gmf.runtime.emf.type.core.IElementType.class);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence initLabel(final GenLabel it, final String nodeVar, final String prefStoreVar) {
    StringConcatenation _builder = new StringConcatenation();
    int _visualID = it.getVisualID();
    String labelVar = ("label" + Integer.valueOf(_visualID));
    _builder.newLineIfNotEmpty();
    _builder.append("org.eclipse.gmf.runtime.notation.Node ");
    _builder.append(labelVar, "");
    _builder.append(" = createLabel(");
    _builder.append(nodeVar, "");
    _builder.append(", ");
    CharSequence _typeMethodCall = this.xptVisualIDRegistry.typeMethodCall(it);
    _builder.append(_typeMethodCall, "");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    {
      LabelModelFacet _modelFacet = it.getModelFacet();
      boolean _notEquals = (!Objects.equal(_modelFacet, null));
      if (_notEquals) {
        LabelModelFacet _modelFacet_1 = it.getModelFacet();
        CharSequence _addTextStyle = this.xptViewStyles.addTextStyle(_modelFacet_1, (labelVar + ".getStyles()"));
        _builder.append(_addTextStyle, "");
        _builder.newLineIfNotEmpty();
      }
    }
    CharSequence _addCustomStyles = this.xptViewStyles.addCustomStyles(it, (labelVar + ".getStyles()"));
    _builder.append(_addCustomStyles, "");
    _builder.newLineIfNotEmpty();
    {
      boolean _or = false;
      boolean _oclIsKindOf = this._common_qvto.oclIsKindOf(it, GenExternalNodeLabel.class);
      if (_oclIsKindOf) {
        _or = true;
      } else {
        boolean _oclIsKindOf_1 = this._common_qvto.oclIsKindOf(it, GenLinkLabel.class);
        _or = _oclIsKindOf_1;
      }
      if (_or) {
        _builder.append(labelVar, "");
        _builder.append(".setLayoutConstraint(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createLocation());");
        _builder.newLineIfNotEmpty();
        CharSequence _offset = this.xptViewStyles.offset(it, labelVar);
        _builder.append(_offset, "");
        _builder.newLineIfNotEmpty();
      }
    }
    CharSequence _initializeStyles = this.initializeStyles(it, labelVar, prefStoreVar, false, false, false);
    _builder.append(_initializeStyles, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence additions(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("private void initFontStyleFromPrefs(org.eclipse.gmf.runtime.notation.View view, final org.eclipse.jface.preference.IPreferenceStore store, String elementName)");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String fontConstant = org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.getElementConstant(elementName, org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.FONT);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String fontColorConstant = org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.getElementConstant(elementName, org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.COLOR_FONT);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.notation.FontStyle viewFontStyle = (org.eclipse.gmf.runtime.notation.FontStyle) view.getStyle(org.eclipse.gmf.runtime.notation.NotationPackage.Literals.FONT_STYLE);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (viewFontStyle != null) ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.swt.graphics.FontData fontData = org.eclipse.jface.preference.PreferenceConverter.getFontData(store, fontConstant);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("viewFontStyle.setFontName(fontData.getName());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("viewFontStyle.setFontHeight(fontData.getHeight());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("viewFontStyle.setBold((fontData.getStyle() & org.eclipse.swt.SWT.BOLD) != 0);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("viewFontStyle.setItalic((fontData.getStyle() & org.eclipse.swt.SWT.ITALIC) != 0);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.swt.graphics.RGB fontRGB = org.eclipse.jface.preference.PreferenceConverter.getColor(store, fontColorConstant);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("viewFontStyle.setFontColor(org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities.RGBToInteger(fontRGB).intValue());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    CharSequence _generatedMemberComment_1 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_1, "");
    _builder.newLineIfNotEmpty();
    _builder.append("private void initForegroundFromPrefs(org.eclipse.gmf.runtime.notation.View view, final org.eclipse.jface.preference.IPreferenceStore store, String elementName)");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String lineColorConstant = org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.getElementConstant(elementName, org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.COLOR_LINE);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.swt.graphics.RGB lineRGB = org.eclipse.jface.preference.PreferenceConverter.getColor(store, lineColorConstant);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(view, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLineStyle_LineColor(), org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities.RGBToInteger(lineRGB));");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    CharSequence _generatedMemberComment_2 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_2, "");
    _builder.newLineIfNotEmpty();
    _builder.append("private void initBackgroundFromPrefs(org.eclipse.gmf.runtime.notation.View view, final org.eclipse.jface.preference.IPreferenceStore store, String elementName)");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String fillColorConstant = org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.getElementConstant(elementName, org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.COLOR_FILL);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String gradientColorConstant = org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.getElementConstant(elementName,org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.COLOR_GRADIENT);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String gradientPolicyConstant = org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.getElementConstant(elementName,org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.GRADIENT_POLICY);");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.swt.graphics.RGB fillRGB = org.eclipse.jface.preference.PreferenceConverter.getColor(store, fillColorConstant);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(view, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFillStyle_FillColor(), org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities.RGBToInteger(fillRGB));");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.notation.FillStyle fillStyle = (org.eclipse.gmf.runtime.notation.FillStyle) view");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append(".getStyle(org.eclipse.gmf.runtime.notation.NotationPackage.Literals.FILL_STYLE);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fillStyle");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append(".setFillColor(org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities.RGBToInteger(fillRGB).intValue());");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append(";");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (store.getBoolean(gradientPolicyConstant)) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter gradientPreferenceConverter = new org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter(");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("store.getString(gradientColorConstant));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fillStyle.setGradient(gradientPreferenceConverter.getGradientData());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fillStyle");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append(".setTransparency(gradientPreferenceConverter.getTransparency());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence initFontFromPrefs(final GenCommonBase it, final String viewVar, final String prefStoreVar) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _specificInitFontFromPrefs = this.specificInitFontFromPrefs(it, viewVar, prefStoreVar);
    _builder.append(_specificInitFontFromPrefs, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence specificInitFontFromPrefs(final GenNode it, final String viewVar, final String prefStoreVar) {
    StringConcatenation _builder = new StringConcatenation();
    {
      ElementType _elementType = it.getElementType();
      String _displayName = _elementType.getDisplayName();
      String _upperCase = _displayName.toUpperCase();
      boolean _equals = "UNDEFINED".equals(_upperCase);
      boolean _not = (!_equals);
      if (_not) {
        _builder.append("org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initFontStyleFromPrefs(");
        _builder.append(viewVar, "");
        _builder.append(", ");
        _builder.append(prefStoreVar, "");
        _builder.append(", \"");
        ElementType _elementType_1 = it.getElementType();
        String _displayName_1 = _elementType_1.getDisplayName();
        _builder.append(_displayName_1, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence specificInitFontFromPrefs(final GenChildNode it, final String viewVar, final String prefStoreVar) {
    StringConcatenation _builder = new StringConcatenation();
    {
      ElementType _elementType = it.getElementType();
      String _displayName = _elementType.getDisplayName();
      String _upperCase = _displayName.toUpperCase();
      boolean _equals = "UNDEFINED".equals(_upperCase);
      boolean _not = (!_equals);
      if (_not) {
        _builder.append("org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initFontStyleFromPrefs(");
        _builder.append(viewVar, "");
        _builder.append(", ");
        _builder.append(prefStoreVar, "");
        _builder.append(", \"");
        ElementType _elementType_1 = it.getElementType();
        String _displayName_1 = _elementType_1.getDisplayName();
        _builder.append(_displayName_1, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence specificInitFontFromPrefs(final GenLink it, final String viewVar, final String prefStoreVar) {
    StringConcatenation _builder = new StringConcatenation();
    {
      ElementType _elementType = it.getElementType();
      String _displayName = _elementType.getDisplayName();
      String _upperCase = _displayName.toUpperCase();
      boolean _equals = "UNDEFINED".equals(_upperCase);
      boolean _not = (!_equals);
      if (_not) {
        _builder.append("org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initFontStyleFromPrefs(");
        _builder.append(viewVar, "");
        _builder.append(", ");
        _builder.append(prefStoreVar, "");
        _builder.append(", \"");
        ElementType _elementType_1 = it.getElementType();
        String _displayName_1 = _elementType_1.getDisplayName();
        _builder.append(_displayName_1, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence specificInitFontFromPrefs(final GenCommonBase it, final String viewVar, final String prefStoreVar) {
    StringConcatenation _builder = new StringConcatenation();
    {
      ElementType _elementType = it.getElementType();
      String _displayName = _elementType.getDisplayName();
      String _upperCase = _displayName.toUpperCase();
      boolean _equals = "UNDEFINED".equals(_upperCase);
      boolean _not = (!_equals);
      if (_not) {
        _builder.append("org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initFontStyleFromPrefs(");
        _builder.append(viewVar, "");
        _builder.append(", ");
        _builder.append(prefStoreVar, "");
        _builder.append(", \"");
        ElementType _elementType_1 = it.getElementType();
        String _displayName_1 = _elementType_1.getDisplayName();
        _builder.append(_displayName_1, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence initForegroundFromPrefs(final GenCommonBase it, final String viewVar, final String prefStoreVar) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _specificInitForegroundFromPrefs = this.specificInitForegroundFromPrefs(it, viewVar, prefStoreVar);
    _builder.append(_specificInitForegroundFromPrefs, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence specificInitForegroundFromPrefs(final GenNode it, final String viewVar, final String prefStoreVar) {
    StringConcatenation _builder = new StringConcatenation();
    {
      ElementType _elementType = it.getElementType();
      String _displayName = _elementType.getDisplayName();
      String _upperCase = _displayName.toUpperCase();
      boolean _equals = "UNDEFINED".equals(_upperCase);
      boolean _not = (!_equals);
      if (_not) {
        _builder.append("org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initForegroundFromPrefs(");
        _builder.append(viewVar, "");
        _builder.append(", ");
        _builder.append(prefStoreVar, "");
        _builder.append(", \"");
        ElementType _elementType_1 = it.getElementType();
        String _displayName_1 = _elementType_1.getDisplayName();
        _builder.append(_displayName_1, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence specificInitForegroundFromPrefs(final GenChildNode it, final String viewVar, final String prefStoreVar) {
    StringConcatenation _builder = new StringConcatenation();
    {
      ElementType _elementType = it.getElementType();
      String _displayName = _elementType.getDisplayName();
      String _upperCase = _displayName.toUpperCase();
      boolean _equals = "UNDEFINED".equals(_upperCase);
      boolean _not = (!_equals);
      if (_not) {
        _builder.append("org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initForegroundFromPrefs(");
        _builder.append(viewVar, "");
        _builder.append(", ");
        _builder.append(prefStoreVar, "");
        _builder.append(", \"");
        ElementType _elementType_1 = it.getElementType();
        String _displayName_1 = _elementType_1.getDisplayName();
        _builder.append(_displayName_1, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence specificInitForegroundFromPrefs(final GenLink it, final String viewVar, final String prefStoreVar) {
    StringConcatenation _builder = new StringConcatenation();
    {
      ElementType _elementType = it.getElementType();
      String _displayName = _elementType.getDisplayName();
      String _upperCase = _displayName.toUpperCase();
      boolean _equals = "UNDEFINED".equals(_upperCase);
      boolean _not = (!_equals);
      if (_not) {
        _builder.append("org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initForegroundFromPrefs(");
        _builder.append(viewVar, "");
        _builder.append(", ");
        _builder.append(prefStoreVar, "");
        _builder.append(", \"");
        ElementType _elementType_1 = it.getElementType();
        String _displayName_1 = _elementType_1.getDisplayName();
        _builder.append(_displayName_1, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence specificInitForegroundFromPrefs(final GenCommonBase it, final String viewVar, final String prefStoreVar) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  public CharSequence initBackgroundFromPrefs(final GenCommonBase it, final String viewVar, final String prefStoreVar) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _specificInitBackgroundFromPrefs = this.specificInitBackgroundFromPrefs(it, viewVar, prefStoreVar);
    _builder.append(_specificInitBackgroundFromPrefs, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence specificInitBackgroundFromPrefs(final GenNode it, final String viewVar, final String prefStoreVar) {
    StringConcatenation _builder = new StringConcatenation();
    {
      ElementType _elementType = it.getElementType();
      String _displayName = _elementType.getDisplayName();
      String _upperCase = _displayName.toUpperCase();
      boolean _equals = "UNDEFINED".equals(_upperCase);
      boolean _not = (!_equals);
      if (_not) {
        _builder.append("org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initBackgroundFromPrefs(");
        _builder.append(viewVar, "");
        _builder.append(", ");
        _builder.append(prefStoreVar, "");
        _builder.append(", \"");
        ElementType _elementType_1 = it.getElementType();
        String _displayName_1 = _elementType_1.getDisplayName();
        _builder.append(_displayName_1, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence specificInitBackgroundFromPrefs(final GenChildNode it, final String viewVar, final String prefStoreVar) {
    StringConcatenation _builder = new StringConcatenation();
    {
      ElementType _elementType = it.getElementType();
      String _displayName = _elementType.getDisplayName();
      String _upperCase = _displayName.toUpperCase();
      boolean _equals = "UNDEFINED".equals(_upperCase);
      boolean _not = (!_equals);
      if (_not) {
        _builder.append("org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initBackgroundFromPrefs(");
        _builder.append(viewVar, "");
        _builder.append(", ");
        _builder.append(prefStoreVar, "");
        _builder.append(", \"");
        ElementType _elementType_1 = it.getElementType();
        String _displayName_1 = _elementType_1.getDisplayName();
        _builder.append(_displayName_1, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence specificInitBackgroundFromPrefs(final GenLink it, final String viewVar, final String prefStoreVar) {
    StringConcatenation _builder = new StringConcatenation();
    {
      ElementType _elementType = it.getElementType();
      String _displayName = _elementType.getDisplayName();
      String _upperCase = _displayName.toUpperCase();
      boolean _equals = "UNDEFINED".equals(_upperCase);
      boolean _not = (!_equals);
      if (_not) {
        _builder.append("org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initBackgroundFromPrefs(");
        _builder.append(viewVar, "");
        _builder.append(", ");
        _builder.append(prefStoreVar, "");
        _builder.append(", \"");
        ElementType _elementType_1 = it.getElementType();
        String _displayName_1 = _elementType_1.getDisplayName();
        _builder.append(_displayName_1, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence specificInitBackgroundFromPrefs(final GenCommonBase it, final String viewVar, final String prefStoreVar) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  public CharSequence initRountingFromPrefs(final GenCommonBase it, final String viewVar, final String prefStoreVar) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _specificInitRountingFromPrefs = this.specificInitRountingFromPrefs(it, viewVar, prefStoreVar);
    _builder.append(_specificInitRountingFromPrefs, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence specificInitRountingFromPrefs(final GenNode it, final String viewVar, final String prefStoreVar) {
    StringConcatenation _builder = new StringConcatenation();
    {
      ElementType _elementType = it.getElementType();
      String _displayName = _elementType.getDisplayName();
      String _upperCase = _displayName.toUpperCase();
      boolean _equals = "UNDEFINED".equals(_upperCase);
      boolean _not = (!_equals);
      if (_not) {
        _builder.append("org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initRountingFromPrefs(");
        _builder.append(viewVar, "");
        _builder.append(", ");
        _builder.append(prefStoreVar, "");
        _builder.append(", \"");
        ElementType _elementType_1 = it.getElementType();
        String _displayName_1 = _elementType_1.getDisplayName();
        _builder.append(_displayName_1, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence specificInitRountingFromPrefs(final GenChildNode it, final String viewVar, final String prefStoreVar) {
    StringConcatenation _builder = new StringConcatenation();
    {
      ElementType _elementType = it.getElementType();
      String _displayName = _elementType.getDisplayName();
      String _upperCase = _displayName.toUpperCase();
      boolean _equals = "UNDEFINED".equals(_upperCase);
      boolean _not = (!_equals);
      if (_not) {
        _builder.append("org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initRountingFromPrefs(");
        _builder.append(viewVar, "");
        _builder.append(", ");
        _builder.append(prefStoreVar, "");
        _builder.append(", \"");
        ElementType _elementType_1 = it.getElementType();
        String _displayName_1 = _elementType_1.getDisplayName();
        _builder.append(_displayName_1, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence specificInitRountingFromPrefs(final GenLink it, final String viewVar, final String prefStoreVar) {
    StringConcatenation _builder = new StringConcatenation();
    {
      ElementType _elementType = it.getElementType();
      String _displayName = _elementType.getDisplayName();
      String _upperCase = _displayName.toUpperCase();
      boolean _equals = "UNDEFINED".equals(_upperCase);
      boolean _not = (!_equals);
      if (_not) {
        _builder.append("org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initRountingFromPrefs(");
        _builder.append(viewVar, "");
        _builder.append(", ");
        _builder.append(prefStoreVar, "");
        _builder.append(", \"");
        ElementType _elementType_1 = it.getElementType();
        String _displayName_1 = _elementType_1.getDisplayName();
        _builder.append(_displayName_1, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence specificInitRountingFromPrefs(final GenCommonBase it, final String viewVar, final String prefStoreVar) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  public CharSequence initLabelVisibility(final GenLink it, final String viewVar, final String prefStoreVar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    {
      EList<GenLinkLabel> _labels = it.getLabels();
      Iterable<GenLinkLabel> _filter = Iterables.<GenLinkLabel>filter(_labels, GenLinkLabel.class);
      final Function1<GenLinkLabel, Boolean> _function = new Function1<GenLinkLabel, Boolean>() {
        public Boolean apply(final GenLinkLabel lbl) {
          Resource _eResource = it.eResource();
          TreeIterator<EObject> _allContents = _eResource.getAllContents();
          Iterator<LabelVisibilityPreference> _filter = Iterators.<LabelVisibilityPreference>filter(_allContents, LabelVisibilityPreference.class);
          final Function1<LabelVisibilityPreference, Boolean> _function = new Function1<LabelVisibilityPreference, Boolean>() {
            public Boolean apply(final LabelVisibilityPreference label) {
              EList<GenLinkLabel> _linkLabels = label.getLinkLabels();
              return Boolean.valueOf(_linkLabels.contains(lbl));
            }
          };
          Iterator<LabelVisibilityPreference> _filter_1 = IteratorExtensions.<LabelVisibilityPreference>filter(_filter, _function);
          int _size = IteratorExtensions.size(_filter_1);
          return Boolean.valueOf((_size != 0));
        }
      };
      boolean _exists = IterableExtensions.<GenLinkLabel>exists(_filter, _function);
      if (_exists) {
        _builder.append("org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(");
        _builder.append(viewVar, "");
        _builder.append(", ");
        _builder.append(prefStoreVar, "");
        _builder.append(", \"");
        ElementType _elementType = it.getElementType();
        String _displayName = _elementType.getDisplayName();
        _builder.append(_displayName, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence initLabelVisibility(final GenNode it, final String viewVar, final String prefStoreVar) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<GenNodeLabel> _labels = it.getLabels();
      Iterable<GenExternalNodeLabel> _filter = Iterables.<GenExternalNodeLabel>filter(_labels, GenExternalNodeLabel.class);
      final Function1<GenExternalNodeLabel, Boolean> _function = new Function1<GenExternalNodeLabel, Boolean>() {
        public Boolean apply(final GenExternalNodeLabel lbl) {
          Resource _eResource = it.eResource();
          TreeIterator<EObject> _allContents = _eResource.getAllContents();
          Iterator<LabelVisibilityPreference> _filter = Iterators.<LabelVisibilityPreference>filter(_allContents, LabelVisibilityPreference.class);
          final Function1<LabelVisibilityPreference, Boolean> _function = new Function1<LabelVisibilityPreference, Boolean>() {
            public Boolean apply(final LabelVisibilityPreference label) {
              EList<GenExternalNodeLabel> _externalNodeLabels = label.getExternalNodeLabels();
              return Boolean.valueOf(_externalNodeLabels.contains(lbl));
            }
          };
          Iterator<LabelVisibilityPreference> _filter_1 = IteratorExtensions.<LabelVisibilityPreference>filter(_filter, _function);
          int _size = IteratorExtensions.size(_filter_1);
          return Boolean.valueOf((_size != 0));
        }
      };
      boolean _exists = IterableExtensions.<GenExternalNodeLabel>exists(_filter, _function);
      if (_exists) {
        _builder.append("org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(");
        _builder.append(viewVar, "");
        _builder.append(", ");
        _builder.append(prefStoreVar, "");
        _builder.append(", \"");
        ElementType _elementType = it.getElementType();
        String _displayName = _elementType.getDisplayName();
        _builder.append(_displayName, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence createNodeMethod(final GenNode it) {
    if (it instanceof GenChildLabelNode) {
      return _createNodeMethod((GenChildLabelNode)it);
    } else if (it != null) {
      return _createNodeMethod(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
