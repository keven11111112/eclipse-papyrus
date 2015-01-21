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
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 *    Patrick Tessier (CEA) - initial API and implementation
 *    Thibault Landre (Atos Origin) - initial API and implementation
 *    Vincent Lorenzo (CEA-LIST) - Bug 335987 [General][Enhancement] Show/Hide Connectors Labels and External Nodes Labels
 */
package aspects.impl.diagram.editparts;

import aspects.xpt.CodeStyle;
import aspects.xpt.editor.VisualIDRegistry;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import impl.diagram.editparts.TextAware;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.codegen.gmfgen.GenChildSideAffixedNode;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenLabel;
import org.eclipse.gmf.codegen.gmfgen.GenNavigatorChildReference;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.ParentAssignedViewmap;
import org.eclipse.gmf.codegen.gmfgen.ToolEntry;
import org.eclipse.gmf.codegen.gmfgen.Viewmap;
import org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView;
import org.eclipse.papyrus.papyrusgmfgenextension.PropertyRefreshHook;
import org.eclipse.papyrus.papyrusgmfgenextension.SpecificLocator;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import utils.EditPartsUtils_qvto;
import xpt.Common;
import xpt.diagram.editparts.EditPartFactory;
import xpt.diagram.editparts.Utils_qvto;

@Singleton
@SuppressWarnings("all")
public class NodeEditPart extends impl.diagram.editparts.NodeEditPart {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private CodeStyle _codeStyle;
  
  @Inject
  @Extension
  private EditPartsUtils_qvto _editPartsUtils_qvto;
  
  @Inject
  @Extension
  private VisualIDRegistry _visualIDRegistry;
  
  @Inject
  @Extension
  private Utils_qvto _utils_qvto;
  
  @Inject
  private EditPartFactory xptEditPartFactory;
  
  @Inject
  private TextAware xptTextAware;
  
  protected CharSequence _extendsListContents(final GenNode it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Resource _eResource = it.eResource();
      TreeIterator<EObject> _allContents = _eResource.getAllContents();
      Iterator<ExtendedGenView> _filter = Iterators.<ExtendedGenView>filter(_allContents, ExtendedGenView.class);
      final Function1<ExtendedGenView, Boolean> _function = new Function1<ExtendedGenView, Boolean>() {
        public Boolean apply(final ExtendedGenView v) {
          boolean _and = false;
          EList<GenCommonBase> _genView = v.getGenView();
          boolean _contains = _genView.contains(it);
          if (!_contains) {
            _and = false;
          } else {
            String _superOwnedEditPart = v.getSuperOwnedEditPart();
            boolean _notEquals = (!Objects.equal(_superOwnedEditPart, null));
            _and = _notEquals;
          }
          return Boolean.valueOf(_and);
        }
      };
      Iterator<ExtendedGenView> _filter_1 = IteratorExtensions.<ExtendedGenView>filter(_filter, _function);
      int _size = IteratorExtensions.size(_filter_1);
      boolean _notEquals = (_size != 0);
      if (_notEquals) {
        {
          Resource _eResource_1 = it.eResource();
          TreeIterator<EObject> _allContents_1 = _eResource_1.getAllContents();
          Iterator<ExtendedGenView> _filter_2 = Iterators.<ExtendedGenView>filter(_allContents_1, ExtendedGenView.class);
          final Function1<ExtendedGenView, Boolean> _function_1 = new Function1<ExtendedGenView, Boolean>() {
            public Boolean apply(final ExtendedGenView v) {
              boolean _and = false;
              EList<GenCommonBase> _genView = v.getGenView();
              boolean _contains = _genView.contains(it);
              if (!_contains) {
                _and = false;
              } else {
                String _superOwnedEditPart = v.getSuperOwnedEditPart();
                boolean _notEquals = (!Objects.equal(_superOwnedEditPart, null));
                _and = _notEquals;
              }
              return Boolean.valueOf(_and);
            }
          };
          Iterator<ExtendedGenView> _filter_3 = IteratorExtensions.<ExtendedGenView>filter(_filter_2, _function_1);
          Iterable<ExtendedGenView> _iterable = IteratorExtensions.<ExtendedGenView>toIterable(_filter_3);
          for(final ExtendedGenView extendedObject : _iterable) {
            CharSequence _specifyInheritance = this.specifyInheritance(((ExtendedGenView) extendedObject));
            _builder.append(_specifyInheritance, "");
            _builder.newLineIfNotEmpty();
          }
        }
      } else {
        _builder.append("org.eclipse.papyrus.infra.gmfdiag.common.editpart.NodeEditPart");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  protected CharSequence _extendsListContents(final GenChildSideAffixedNode it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Resource _eResource = it.eResource();
      TreeIterator<EObject> _allContents = _eResource.getAllContents();
      Iterator<ExtendedGenView> _filter = Iterators.<ExtendedGenView>filter(_allContents, ExtendedGenView.class);
      final Function1<ExtendedGenView, Boolean> _function = new Function1<ExtendedGenView, Boolean>() {
        public Boolean apply(final ExtendedGenView v) {
          boolean _and = false;
          EList<GenCommonBase> _genView = v.getGenView();
          boolean _contains = _genView.contains(it);
          if (!_contains) {
            _and = false;
          } else {
            String _superOwnedEditPart = v.getSuperOwnedEditPart();
            boolean _notEquals = (!Objects.equal(_superOwnedEditPart, null));
            _and = _notEquals;
          }
          return Boolean.valueOf(_and);
        }
      };
      Iterator<ExtendedGenView> _filter_1 = IteratorExtensions.<ExtendedGenView>filter(_filter, _function);
      int _size = IteratorExtensions.size(_filter_1);
      boolean _notEquals = (_size != 0);
      if (_notEquals) {
        {
          Resource _eResource_1 = it.eResource();
          TreeIterator<EObject> _allContents_1 = _eResource_1.getAllContents();
          Iterator<ExtendedGenView> _filter_2 = Iterators.<ExtendedGenView>filter(_allContents_1, ExtendedGenView.class);
          final Function1<ExtendedGenView, Boolean> _function_1 = new Function1<ExtendedGenView, Boolean>() {
            public Boolean apply(final ExtendedGenView v) {
              boolean _and = false;
              EList<GenCommonBase> _genView = v.getGenView();
              boolean _contains = _genView.contains(it);
              if (!_contains) {
                _and = false;
              } else {
                String _superOwnedEditPart = v.getSuperOwnedEditPart();
                boolean _notEquals = (!Objects.equal(_superOwnedEditPart, null));
                _and = _notEquals;
              }
              return Boolean.valueOf(_and);
            }
          };
          Iterator<ExtendedGenView> _filter_3 = IteratorExtensions.<ExtendedGenView>filter(_filter_2, _function_1);
          Iterable<ExtendedGenView> _iterable = IteratorExtensions.<ExtendedGenView>toIterable(_filter_3);
          for(final ExtendedGenView extendedObject : _iterable) {
            CharSequence _specifyInheritance = this.specifyInheritance(extendedObject);
            _builder.append(_specifyInheritance, "");
            _builder.newLineIfNotEmpty();
          }
        }
      } else {
        {
          boolean _hasBorderItems = this._utils_qvto.hasBorderItems(it);
          if (_hasBorderItems) {
            _builder.append("org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart");
          } else {
            _builder.append("org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence addFixedChild(final GenNode it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("protected boolean addFixedChild(org.eclipse.gef.EditPart childEditPart) {");
    _builder.newLine();
    {
      Iterable<? extends GenLabel> _innerFixedLabels = this._utils_qvto.getInnerFixedLabels(it);
      for(final GenLabel label : _innerFixedLabels) {
        Viewmap _viewmap = label.getViewmap();
        ParentAssignedViewmap childViewmap = ((ParentAssignedViewmap) _viewmap);
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("if (childEditPart instanceof ");
        CharSequence _editPartQualifiedClassName = this.xptEditPartFactory.getEditPartQualifiedClassName(label);
        _builder.append(_editPartQualifiedClassName, "\t\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("((");
        CharSequence _editPartQualifiedClassName_1 = this.xptEditPartFactory.getEditPartQualifiedClassName(label);
        _builder.append(_editPartQualifiedClassName_1, "\t\t\t");
        _builder.append(") childEditPart).");
        CharSequence _labelSetterName = this.xptTextAware.labelSetterName(childViewmap);
        _builder.append(_labelSetterName, "\t\t\t");
        _builder.append("(getPrimaryShape().");
        String _getterName = childViewmap.getGetterName();
        _builder.append(_getterName, "\t\t\t");
        _builder.append("());");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("return true;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      Iterable<GenCompartment> _pinnedCompartments = this._utils_qvto.getPinnedCompartments(it);
      for(final GenCompartment compartment : _pinnedCompartments) {
        Viewmap _viewmap_1 = compartment.getViewmap();
        ParentAssignedViewmap childViewmap_1 = ((ParentAssignedViewmap) _viewmap_1);
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("if (childEditPart instanceof ");
        String _editPartQualifiedClassName_2 = compartment.getEditPartQualifiedClassName();
        _builder.append(_editPartQualifiedClassName_2, "\t\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("org.eclipse.draw2d.IFigure pane = getPrimaryShape().");
        String _getterName_1 = childViewmap_1.getGetterName();
        _builder.append(_getterName_1, "\t\t\t");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way ");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("pane.add(((");
        String _editPartQualifiedClassName_3 = compartment.getEditPartQualifiedClassName();
        _builder.append(_editPartQualifiedClassName_3, "\t\t\t");
        _builder.append(") childEditPart).getFigure());");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("return true;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}\t");
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      Iterable<GenChildSideAffixedNode> _sideAffixedChildren = this._utils_qvto.getSideAffixedChildren(it);
      for(final GenChildSideAffixedNode child : _sideAffixedChildren) {
        _builder.append("\t\t");
        _builder.newLine();
        _builder.newLine();
        {
          Resource _eResource = it.eResource();
          TreeIterator<EObject> _allContents = _eResource.getAllContents();
          Iterator<SpecificLocator> _filter = Iterators.<SpecificLocator>filter(_allContents, SpecificLocator.class);
          final Function1<SpecificLocator, Boolean> _function = new Function1<SpecificLocator, Boolean>() {
            public Boolean apply(final SpecificLocator v) {
              EList<GenChildSideAffixedNode> _genChildSideAffixedNode = v.getGenChildSideAffixedNode();
              return Boolean.valueOf(_genChildSideAffixedNode.contains(child));
            }
          };
          Iterator<SpecificLocator> _filter_1 = IteratorExtensions.<SpecificLocator>filter(_filter, _function);
          int _size = IteratorExtensions.size(_filter_1);
          boolean _notEquals = (_size != 0);
          if (_notEquals) {
            {
              Resource _eResource_1 = it.eResource();
              TreeIterator<EObject> _allContents_1 = _eResource_1.getAllContents();
              Iterator<SpecificLocator> _filter_2 = Iterators.<SpecificLocator>filter(_allContents_1, SpecificLocator.class);
              final Function1<SpecificLocator, Boolean> _function_1 = new Function1<SpecificLocator, Boolean>() {
                public Boolean apply(final SpecificLocator v) {
                  EList<GenChildSideAffixedNode> _genChildSideAffixedNode = v.getGenChildSideAffixedNode();
                  return Boolean.valueOf(_genChildSideAffixedNode.contains(child));
                }
              };
              Iterator<SpecificLocator> _filter_3 = IteratorExtensions.<SpecificLocator>filter(_filter_2, _function_1);
              Iterable<SpecificLocator> _iterable = IteratorExtensions.<SpecificLocator>toIterable(_filter_3);
              for(final SpecificLocator extendedObject : _iterable) {
                CharSequence _genSpecificLocator = this.genSpecificLocator(extendedObject, child);
                _builder.append(_genSpecificLocator, "");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.newLine();
          } else {
            _builder.append("if (childEditPart instanceof ");
            String _editPartQualifiedClassName_4 = child.getEditPartQualifiedClassName();
            _builder.append(_editPartQualifiedClassName_4, "");
            _builder.append(") {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t");
            _builder.append("org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator locator = new org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator(getMainFigure(), org.eclipse.draw2d.PositionConstants.");
            String _preferredSideName = child.getPreferredSideName();
            _builder.append(_preferredSideName, "\t\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t");
            _builder.append("getBorderedFigure().getBorderItemContainer().add(((");
            String _editPartQualifiedClassName_5 = child.getEditPartQualifiedClassName();
            _builder.append(_editPartQualifiedClassName_5, "\t\t\t");
            _builder.append(") childEditPart).getFigure(), locator);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t");
            _builder.append("return true;");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t\t");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence installGraphicalNodeEditPolicy(final GenNode it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("installEditPolicy(org.eclipse.gef.EditPolicy.GRAPHICAL_NODE_ROLE, new org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultGraphicalNodeEditPolicy());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence setLineWidth(final GenNode it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected void setLineWidth(int width) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("super.setLineWidth(width);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence setLineStyle(final GenNode it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected void setLineType(int style) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (primaryShape instanceof org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IPapyrusNodeFigure) {\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("((org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IPapyrusNodeFigure) primaryShape).setLineStyle(style);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence createFigure(final GenNode it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment(
      ((("Creates figure for this edit part.\n" + 
        "\n") + 
        "Body of this method does not depend on settings in generation model\n") + 
        "so you may safely remove <i>generated</i> tag and modify it.\n"));
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure create");
    {
      boolean _hasBorderItems = this._utils_qvto.hasBorderItems(it);
      if (_hasBorderItems) {
        _builder.append("Main");
      } else {
        _builder.append("Node");
      }
    }
    _builder.append("Figure() {");
    _builder.newLineIfNotEmpty();
    {
      if ((it instanceof GenChildSideAffixedNode)) {
        _builder.append("\t");
        _builder.append("org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure figure = createNodePlate();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("figure.setLayoutManager(new org.eclipse.draw2d.StackLayout());");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("org.eclipse.draw2d.IFigure shape = createNodeShape();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("figure.add(shape);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("contentPane = setupContentPane(shape);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return figure;");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("return new org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SelectableBorderedNodeFigure(createMainFigureWithSVG());");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence borderItemSelectionEditPolicy(final GenNode it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasBorderItems = this._utils_qvto.hasBorderItems(it);
      if (_hasBorderItems) {
        _builder.append("org.eclipse.gmf.runtime.notation.View childView = (org.eclipse.gmf.runtime.notation.View) child.getModel();");
        _builder.newLine();
        _builder.append("switch (");
        GenDiagram _diagram = it.getDiagram();
        CharSequence _visualIDMethodCall = this._visualIDRegistry.getVisualIDMethodCall(_diagram);
        _builder.append(_visualIDMethodCall, "");
        _builder.append("(childView)) {");
        _builder.newLineIfNotEmpty();
        {
          Iterable<GenExternalNodeLabel> _externalLabels = this._utils_qvto.getExternalLabels(it);
          int _size = IterableExtensions.size(_externalLabels);
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            {
              Iterable<GenExternalNodeLabel> _externalLabels_1 = this._utils_qvto.getExternalLabels(it);
              for(final GenExternalNodeLabel nextLabel : _externalLabels_1) {
                CharSequence _caseVisualID = this._visualIDRegistry.caseVisualID(nextLabel);
                _builder.append(_caseVisualID, "");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t");
            _builder.append("return ");
            CharSequence _borderItemSelectionEP = this.borderItemSelectionEP(it);
            _builder.append(_borderItemSelectionEP, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          Iterable<GenChildSideAffixedNode> _sideAffixedChildren = this._utils_qvto.getSideAffixedChildren(it);
          int _size_1 = IterableExtensions.size(_sideAffixedChildren);
          boolean _greaterThan_1 = (_size_1 > 0);
          if (_greaterThan_1) {
            {
              Iterable<GenChildSideAffixedNode> _sideAffixedChildren_1 = this._utils_qvto.getSideAffixedChildren(it);
              for(final GenChildSideAffixedNode nextBorderItem : _sideAffixedChildren_1) {
                CharSequence _caseVisualID_1 = this._visualIDRegistry.caseVisualID(nextBorderItem);
                _builder.append(_caseVisualID_1, "");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t\t\t\t\t");
            _builder.append("return new org.eclipse.papyrus.uml.diagram.common.editpolicies.BorderItemResizableEditPolicy();");
            _builder.newLine();
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence createLayoutEditPolicyBody_FLOW_LAYOUT(final GenNode it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("org.eclipse.gmf.runtime.diagram.ui.editpolicies.FlowLayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.FlowLayoutEditPolicy() {");
    _builder.newLine();
    {
      boolean _hasBorderItems = this._utils_qvto.hasBorderItems(it);
      if (_hasBorderItems) {
        _builder.append("\t");
        CharSequence _extraLineBreak = this._common.extraLineBreak();
        _builder.append(_extraLineBreak, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        CharSequence _overrideC = this._codeStyle.overrideC(it);
        _builder.append(_overrideC, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("protected org.eclipse.gef.EditPolicy createChildEditPolicy(org.eclipse.gef.EditPart child) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        CharSequence _borderItemSelectionEditPolicy = this.borderItemSelectionEditPolicy(it);
        _builder.append(_borderItemSelectionEditPolicy, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return super.createChildEditPolicy(child);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    CharSequence _overrideC_1 = this._codeStyle.overrideC(it);
    _builder.append(_overrideC_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("protected org.eclipse.gef.commands.Command createAddCommand(org.eclipse.gef.EditPart child, org.eclipse.gef.EditPart after) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _overrideC_2 = this._codeStyle.overrideC(it);
    _builder.append(_overrideC_2, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("protected org.eclipse.gef.commands.Command createMoveChildCommand(org.eclipse.gef.EditPart child, org.eclipse.gef.EditPart after) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _overrideC_3 = this._codeStyle.overrideC(it);
    _builder.append(_overrideC_3, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("protected org.eclipse.gef.commands.Command getCreateCommand(org.eclipse.gef.requests.CreateRequest request) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("};");
    _builder.newLine();
    _builder.append("return lep;");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence createLayoutEditPolicyBody_DEFAULT(final GenNode it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _overrideC = this._codeStyle.overrideC(it);
    _builder.append(_overrideC, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("protected org.eclipse.gef.EditPolicy createChildEditPolicy(org.eclipse.gef.EditPart child) {");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _borderItemSelectionEditPolicy = this.borderItemSelectionEditPolicy(it);
    _builder.append(_borderItemSelectionEditPolicy, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("org.eclipse.gef.EditPolicy result = child.getEditPolicy(org.eclipse.gef.EditPolicy.PRIMARY_DRAG_ROLE);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (result == null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("result = new org.eclipse.gef.editpolicies.NonResizableEditPolicy();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return result;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _overrideC_1 = this._codeStyle.overrideC(it);
    _builder.append(_overrideC_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("protected org.eclipse.gef.commands.Command getMoveChildrenCommand(org.eclipse.gef.Request request) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _overrideC_2 = this._codeStyle.overrideC(it);
    _builder.append(_overrideC_2, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("protected org.eclipse.gef.commands.Command getCreateCommand(org.eclipse.gef.requests.CreateRequest request) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("};");
    _builder.newLine();
    _builder.append("return lep;");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence specifyInheritance(final ExtendedGenView it) {
    StringConcatenation _builder = new StringConcatenation();
    String _superOwnedEditPart = it.getSuperOwnedEditPart();
    _builder.append(_superOwnedEditPart, "");
    return _builder;
  }
  
  public CharSequence genSpecificLocator(final GenCommonBase it, final GenChildSideAffixedNode child) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  public CharSequence genSpecificLocator(final ToolEntry it, final GenChildSideAffixedNode child) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  public CharSequence genSpecificLocator(final GenNavigatorChildReference it, final GenChildSideAffixedNode child) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  public CharSequence genSpecificLocator(final SpecificLocator it, final GenChildSideAffixedNode child) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//Papyrus Gencode :");
    String _comment = it.getComment();
    _builder.append(_comment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("if (childEditPart instanceof ");
    String _editPartQualifiedClassName = child.getEditPartQualifiedClassName();
    _builder.append(_editPartQualifiedClassName, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator locator = new ");
    String _classpath = it.getClasspath();
    _builder.append(_classpath, "\t\t\t");
    _builder.append("(getMainFigure(), org.eclipse.draw2d.PositionConstants.");
    String _preferredSideName = child.getPreferredSideName();
    _builder.append(_preferredSideName, "\t\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("getBorderedFigure().getBorderItemContainer().add(((");
    String _editPartQualifiedClassName_1 = child.getEditPartQualifiedClassName();
    _builder.append(_editPartQualifiedClassName_1, "\t\t\t");
    _builder.append(") childEditPart).getFigure(), locator);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence borderItemSelectionEP(final GenNode it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy() {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _overrideC = this._codeStyle.overrideC(it);
    _builder.append(_overrideC, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("protected java.util.List<?> createSelectionHandles() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.gef.handles.MoveHandle mh = new org.eclipse.gef.handles.MoveHandle((org.eclipse.gef.GraphicalEditPart) getHost());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("mh.setBorder(null);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return java.util.Collections.singletonList(mh);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence specificHandleNotificationEvent(final GenNode it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    {
      Resource _eResource = it.eResource();
      TreeIterator<EObject> _allContents = _eResource.getAllContents();
      Iterator<ExtendedGenView> _filter = Iterators.<ExtendedGenView>filter(_allContents, ExtendedGenView.class);
      final Function1<ExtendedGenView, Boolean> _function = new Function1<ExtendedGenView, Boolean>() {
        public Boolean apply(final ExtendedGenView v) {
          EList<GenCommonBase> _genView = v.getGenView();
          return Boolean.valueOf(_genView.contains(it));
        }
      };
      Iterator<ExtendedGenView> _filter_1 = IteratorExtensions.<ExtendedGenView>filter(_filter, _function);
      int _size = IteratorExtensions.size(_filter_1);
      boolean _notEquals = (_size != 0);
      if (_notEquals) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append("*Papyrus codeGen");
        _builder.newLine();
        _builder.append("*@generated");
        _builder.newLine();
        _builder.append("**/");
        _builder.newLine();
        _builder.append("protected void handleNotificationEvent(org.eclipse.emf.common.notify.Notification event) {");
        _builder.newLine();
        {
          EList<GenNodeLabel> _labels = it.getLabels();
          Iterable<GenExternalNodeLabel> _filter_2 = Iterables.<GenExternalNodeLabel>filter(_labels, GenExternalNodeLabel.class);
          int _size_1 = IterableExtensions.size(_filter_2);
          boolean _notEquals_1 = (_size_1 != 0);
          if (_notEquals_1) {
            _builder.append("/*");
            _builder.newLine();
            _builder.append(" ");
            _builder.append("* when a node have external node labels, the methods refreshChildren() remove the EditPart corresponding to the Label from the EditPart");
            _builder.newLine();
            _builder.append(" ");
            _builder.append("* Registry. After that, we can\'t reset the visibility to true (using the Show/Hide Label Action)!");
            _builder.newLine();
            _builder.append(" ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("if(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getView_Visible().equals(event.getFeature())) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("Object notifier = event.getNotifier();");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("java.util.List<?> modelChildren = ((org.eclipse.gmf.runtime.notation.View)getModel()).getChildren();");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("if(!(notifier instanceof org.eclipse.gmf.runtime.notation.Edge)) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("if(modelChildren.contains(event.getNotifier())) {");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("return;");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("super.handleNotificationEvent(event);");
        _builder.newLine();
        {
          Resource _eResource_1 = it.eResource();
          TreeIterator<EObject> _allContents_1 = _eResource_1.getAllContents();
          Iterator<ExtendedGenView> _filter_3 = Iterators.<ExtendedGenView>filter(_allContents_1, ExtendedGenView.class);
          final Function1<ExtendedGenView, Boolean> _function_1 = new Function1<ExtendedGenView, Boolean>() {
            public Boolean apply(final ExtendedGenView v) {
              EList<GenCommonBase> _genView = v.getGenView();
              return Boolean.valueOf(_genView.contains(it));
            }
          };
          Iterator<ExtendedGenView> _filter_4 = IteratorExtensions.<ExtendedGenView>filter(_filter_3, _function_1);
          Iterable<ExtendedGenView> _iterable = IteratorExtensions.<ExtendedGenView>toIterable(_filter_4);
          for(final ExtendedGenView extendedObject : _iterable) {
            {
              PropertyRefreshHook _propRefreshHook = extendedObject.getPropRefreshHook();
              boolean _notEquals_2 = (!Objects.equal(_propRefreshHook, null));
              if (_notEquals_2) {
                _builder.append("\t");
                PropertyRefreshHook _propRefreshHook_1 = extendedObject.getPropRefreshHook();
                CharSequence _specificHandleNotificationEventBody = this.specificHandleNotificationEventBody(_propRefreshHook_1);
                _builder.append(_specificHandleNotificationEventBody, "\t");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("\t");
        _builder.newLine();
        _builder.append(" \t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence specificHandleNotificationEventBody(final PropertyRefreshHook it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _comment = it.getComment();
      boolean _notEquals = (!Objects.equal(_comment, null));
      if (_notEquals) {
        _builder.append("//");
        String _comment_1 = it.getComment();
        _builder.append(_comment_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("if (resolveSemanticElement() != null) {");
    _builder.newLine();
    _builder.append("if(");
    String _triggeringCondition = it.getTriggeringCondition();
    _builder.append(_triggeringCondition, "");
    _builder.append("){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _action = it.getAction();
    _builder.append(_action, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("refreshVisuals();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence addBorderItem(final GenNode it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Iterable<GenExternalNodeLabel> _externalLabels = this._utils_qvto.getExternalLabels(it);
      int _size = IterableExtensions.size(_externalLabels);
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        CharSequence _generatedMemberComment = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment, "");
        _builder.newLineIfNotEmpty();
        _builder.append("protected void addBorderItem(org.eclipse.draw2d.IFigure borderItemContainer, org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart borderItemEditPart) {");
        _builder.newLine();
        {
          List<GenExternalNodeLabel> _externalLabelsWithoutSpecificLocator = this._editPartsUtils_qvto.getExternalLabelsWithoutSpecificLocator(it);
          int _size_1 = _externalLabelsWithoutSpecificLocator.size();
          boolean _greaterThan_1 = (_size_1 > 0);
          if (_greaterThan_1) {
            _builder.append("if (");
            {
              List<GenExternalNodeLabel> _externalLabelsWithoutSpecificLocator_1 = this._editPartsUtils_qvto.getExternalLabelsWithoutSpecificLocator(it);
              boolean _hasElements = false;
              for(final GenExternalNodeLabel label : _externalLabelsWithoutSpecificLocator_1) {
                if (!_hasElements) {
                  _hasElements = true;
                } else {
                  _builder.appendImmediate(" || ", "");
                }
                _builder.append("borderItemEditPart instanceof ");
                String _editPartQualifiedClassName = label.getEditPartQualifiedClassName();
                _builder.append(_editPartQualifiedClassName, "");
              }
            }
            _builder.append(") {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator locator = new org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator(getMainFigure(), org.eclipse.draw2d.PositionConstants.SOUTH);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("locator.setBorderItemOffset(new org.eclipse.draw2d.geometry.Dimension(-20, -20));");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("borderItemContainer.add(borderItemEditPart.getFigure(), locator);");
            _builder.newLine();
            _builder.append("} else");
            _builder.newLine();
          }
        }
        {
          List<GenExternalNodeLabel> _externalLabelsWithSpecificLocator = this._editPartsUtils_qvto.getExternalLabelsWithSpecificLocator(it);
          for(final GenExternalNodeLabel label_1 : _externalLabelsWithSpecificLocator) {
            _builder.append("if (borderItemEditPart instanceof ");
            String _editPartQualifiedClassName_1 = label_1.getEditPartQualifiedClassName();
            _builder.append(_editPartQualifiedClassName_1, "");
            _builder.append(") {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator locator = new ");
            String _specificLocator = this._editPartsUtils_qvto.getSpecificLocator(label_1);
            _builder.append(_specificLocator, "\t");
            _builder.append("(getMainFigure());");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("borderItemContainer.add(borderItemEditPart.getFigure(), locator);");
            _builder.newLine();
            _builder.append("} else");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("super.addBorderItem(borderItemContainer, borderItemEditPart);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence setupNodePlate(final GenNode it) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  public CharSequence setupNodePlate(final GenChildSideAffixedNode it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//FIXME: workaround for #154536");
    _builder.newLine();
    _builder.append("result.getBounds().setSize(result.getPreferredSize());");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence extendsListContents(final GenNode it) {
    if (it instanceof GenChildSideAffixedNode) {
      return _extendsListContents((GenChildSideAffixedNode)it);
    } else if (it != null) {
      return _extendsListContents(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
