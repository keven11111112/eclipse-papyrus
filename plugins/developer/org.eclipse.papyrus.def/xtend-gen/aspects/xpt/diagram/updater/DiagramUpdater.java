/**
 * Copyright (c) 2007, 2010, 2014 Borland Software Corporation, CEA, and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Borland) - [243151] explicit source/target for links
 *    Michael Golubev (Montages) - API extracted to gmf.tooling.runtime, template migrated to Xtend2
 *    Christian W. Damus (CEA) - bug 426732: override the cross-reference searches for views to use the CrossReferenceAdapter
 */
package aspects.xpt.diagram.updater;

import aspects.xpt.editor.VisualIDRegistry;
import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import metamodel.MetaModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenContainerBase;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenDiagramUpdater;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkEnd;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet;
import org.eclipse.papyrus.papyrusgmfgenextension.CustomDiagramUpdaterSingleton;
import org.eclipse.papyrus.papyrusgmfgenextension.SpecificDiagramUpdater;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import xpt.Common;
import xpt.Common_qvto;
import xpt.GenModelUtils_qvto;
import xpt.diagram.updater.LinkDescriptor;
import xpt.diagram.updater.NodeDescriptor;
import xpt.diagram.updater.UpdaterLinkType;
import xpt.diagram.updater.Utils_qvto;

@Singleton
@SuppressWarnings("all")
public class DiagramUpdater extends xpt.diagram.updater.DiagramUpdater {
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
  private GenModelUtils_qvto _genModelUtils_qvto;
  
  @Inject
  private LinkDescriptor linkDescriptor;
  
  @Inject
  private VisualIDRegistry xptVisualIDRegistry;
  
  @Inject
  private NodeDescriptor nodeDescriptor;
  
  @Inject
  private MetaModel xptMetaModel;
  
  public CharSequence diagramUpdaterInstanceToUse(final GenDiagramUpdater it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Resource _eResource = it.eResource();
      TreeIterator<EObject> _allContents = _eResource.getAllContents();
      Iterator<CustomDiagramUpdaterSingleton> _filter = Iterators.<CustomDiagramUpdaterSingleton>filter(_allContents, CustomDiagramUpdaterSingleton.class);
      final Function1<CustomDiagramUpdaterSingleton, Boolean> _function = new Function1<CustomDiagramUpdaterSingleton, Boolean>() {
        public Boolean apply(final CustomDiagramUpdaterSingleton v) {
          String _singletonPath = v.getSingletonPath();
          return Boolean.valueOf((!Objects.equal(_singletonPath, null)));
        }
      };
      Iterator<CustomDiagramUpdaterSingleton> _filter_1 = IteratorExtensions.<CustomDiagramUpdaterSingleton>filter(_filter, _function);
      int _size = IteratorExtensions.size(_filter_1);
      boolean _equals = (_size == 
        1);
      if (_equals) {
        Resource _eResource_1 = it.eResource();
        TreeIterator<EObject> _allContents_1 = _eResource_1.getAllContents();
        Iterator<CustomDiagramUpdaterSingleton> _filter_2 = Iterators.<CustomDiagramUpdaterSingleton>filter(_allContents_1, CustomDiagramUpdaterSingleton.class);
        final Function1<CustomDiagramUpdaterSingleton, Boolean> _function_1 = new Function1<CustomDiagramUpdaterSingleton, Boolean>() {
          public Boolean apply(final CustomDiagramUpdaterSingleton v) {
            String _singletonPath = v.getSingletonPath();
            return Boolean.valueOf((!Objects.equal(_singletonPath, null)));
          }
        };
        Iterator<CustomDiagramUpdaterSingleton> _filter_3 = IteratorExtensions.<CustomDiagramUpdaterSingleton>filter(_filter_2, _function_1);
        CustomDiagramUpdaterSingleton _head = IteratorExtensions.<CustomDiagramUpdaterSingleton>head(_filter_3);
        String _singletonPath = _head.getSingletonPath();
        _builder.append(_singletonPath, "");
        _builder.newLineIfNotEmpty();
      } else {
        String _diagramUpdaterQualifiedClassName = it.getDiagramUpdaterQualifiedClassName();
        _builder.append(_diagramUpdaterQualifiedClassName, "");
        _builder.append(".INSTANCE");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  protected CharSequence typeOfCrossReferenceAdapter() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter");
    return _builder;
  }
  
  public CharSequence getSemanticChildrenMethodCall(final GenContainerBase it) {
    StringConcatenation _builder = new StringConcatenation();
    GenDiagramUpdater _diagramUpdater = this.diagramUpdater(it);
    CharSequence _diagramUpdaterInstanceToUse = this.diagramUpdaterInstanceToUse(_diagramUpdater);
    _builder.append(_diagramUpdaterInstanceToUse, "");
    _builder.append(".");
    CharSequence _semanticChildrenMethodName = this.getSemanticChildrenMethodName(it);
    _builder.append(_semanticChildrenMethodName, "");
    return _builder;
  }
  
  public CharSequence doGetSomeLinksMethodCall(final GenCommonBase it, final UpdaterLinkType linkType) {
    StringConcatenation _builder = new StringConcatenation();
    GenDiagram _diagram = it.getDiagram();
    GenDiagramUpdater _diagramUpdater = this.diagramUpdater(_diagram);
    CharSequence _diagramUpdaterInstanceToUse = this.diagramUpdaterInstanceToUse(_diagramUpdater);
    _builder.append(_diagramUpdaterInstanceToUse, "");
    _builder.append(".");
    CharSequence _linkGetterName = this.linkGetterName(it, linkType);
    _builder.append(_linkGetterName, "");
    return _builder;
  }
  
  public CharSequence _constructor(final GenDiagramUpdater it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected ");
    String _diagramUpdaterClassName = it.getDiagramUpdaterClassName();
    _builder.append(_diagramUpdaterClassName, "");
    _builder.append("(){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("//to prevent instantiation allowing the override");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence classSingleton(final GenDiagramUpdater it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Resource _eResource = it.eResource();
      TreeIterator<EObject> _allContents = _eResource.getAllContents();
      Iterator<CustomDiagramUpdaterSingleton> _filter = Iterators.<CustomDiagramUpdaterSingleton>filter(_allContents, CustomDiagramUpdaterSingleton.class);
      final Function1<CustomDiagramUpdaterSingleton, Boolean> _function = new Function1<CustomDiagramUpdaterSingleton, Boolean>() {
        public Boolean apply(final CustomDiagramUpdaterSingleton v) {
          String _singletonPath = v.getSingletonPath();
          return Boolean.valueOf((!Objects.equal(_singletonPath, null)));
        }
      };
      Iterator<CustomDiagramUpdaterSingleton> _filter_1 = IteratorExtensions.<CustomDiagramUpdaterSingleton>filter(_filter, _function);
      int _size = IteratorExtensions.size(_filter_1);
      boolean _notEquals = (_size != 1);
      if (_notEquals) {
        CharSequence _generatedMemberComment = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment, "");
        _builder.newLineIfNotEmpty();
        _builder.append("public static final  ");
        String _diagramUpdaterQualifiedClassName = it.getDiagramUpdaterQualifiedClassName();
        _builder.append(_diagramUpdaterQualifiedClassName, "");
        _builder.append(" INSTANCE = new ");
        String _diagramUpdaterClassName = it.getDiagramUpdaterClassName();
        _builder.append(_diagramUpdaterClassName, "");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence DiagramUpdater(final GenDiagramUpdater it) {
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
    _builder.append(" implements  org.eclipse.gmf.tooling.runtime.update.DiagramUpdater {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _classSingleton = this.classSingleton(it);
    _builder.append(_classSingleton, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence __constructor = this._constructor(it);
    _builder.append(__constructor, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _isShortcutOrphaned = this.isShortcutOrphaned(it);
    _builder.append(_isShortcutOrphaned, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    GenEditorGenerator _editorGen_1 = it.getEditorGen();
    GenDiagram _diagram = _editorGen_1.getDiagram();
    EList<GenContainerBase> _allContainers = _diagram.getAllContainers();
    final Function1<GenContainerBase, Boolean> _function = new Function1<GenContainerBase, Boolean>() {
      public Boolean apply(final GenContainerBase container) {
        return Boolean.valueOf(DiagramUpdater.this._utils_qvto.hasSemanticChildren(container));
      }
    };
    Iterable<GenContainerBase> semanticContainers = IterableExtensions.<GenContainerBase>filter(_allContainers, _function);
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _genericSemanticChildrenOfView = this.getGenericSemanticChildrenOfView(it, semanticContainers);
    _builder.append(_genericSemanticChildrenOfView, "\t");
    _builder.newLineIfNotEmpty();
    {
      for(final GenContainerBase next : semanticContainers) {
        _builder.append("\t");
        CharSequence _semanticChildrenOfView = this.getSemanticChildrenOfView(next);
        _builder.append(_semanticChildrenOfView, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _phantomNodesIterator = this.getPhantomNodesIterator(it);
    _builder.append(_phantomNodesIterator, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    GenEditorGenerator _editorGen_2 = it.getEditorGen();
    GenDiagram _diagram_1 = _editorGen_2.getDiagram();
    Iterable<GenCommonBase> _allSemanticElements = this._utils_qvto.getAllSemanticElements(_diagram_1);
    CharSequence _genericConnectedLinks = this.getGenericConnectedLinks(it, _allSemanticElements, UpdaterLinkType.CONTAINED);
    _builder.append(_genericConnectedLinks, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    GenEditorGenerator _editorGen_3 = it.getEditorGen();
    GenDiagram _diagram_2 = _editorGen_3.getDiagram();
    Iterable<GenLinkEnd> _allSemanticDiagramElements = this._utils_qvto.getAllSemanticDiagramElements(_diagram_2);
    CharSequence _genericConnectedLinks_1 = this.getGenericConnectedLinks(it, _allSemanticDiagramElements, UpdaterLinkType.INCOMING);
    _builder.append(_genericConnectedLinks_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    GenEditorGenerator _editorGen_4 = it.getEditorGen();
    GenDiagram _diagram_3 = _editorGen_4.getDiagram();
    Iterable<GenLinkEnd> _allSemanticDiagramElements_1 = this._utils_qvto.getAllSemanticDiagramElements(_diagram_3);
    CharSequence _genericConnectedLinks_2 = this.getGenericConnectedLinks(it, _allSemanticDiagramElements_1, UpdaterLinkType.OUTGOING);
    _builder.append(_genericConnectedLinks_2, "\t");
    _builder.newLineIfNotEmpty();
    {
      GenEditorGenerator _editorGen_5 = it.getEditorGen();
      GenDiagram _diagram_4 = _editorGen_5.getDiagram();
      Iterable<GenCommonBase> _allSemanticElements_1 = this._utils_qvto.getAllSemanticElements(_diagram_4);
      for(final GenCommonBase e : _allSemanticElements_1) {
        _builder.append("\t");
        CharSequence _containedLinks = this.getContainedLinks(e);
        _builder.append(_containedLinks, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      GenEditorGenerator _editorGen_6 = it.getEditorGen();
      GenDiagram _diagram_5 = _editorGen_6.getDiagram();
      Iterable<GenLinkEnd> _allSemanticDiagramElements_2 = this._utils_qvto.getAllSemanticDiagramElements(_diagram_5);
      for(final GenLinkEnd e_1 : _allSemanticDiagramElements_2) {
        _builder.append("\t");
        CharSequence _incomingLinks = this.getIncomingLinks(e_1);
        _builder.append(_incomingLinks, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      GenEditorGenerator _editorGen_7 = it.getEditorGen();
      GenDiagram _diagram_6 = _editorGen_7.getDiagram();
      Iterable<GenLinkEnd> _allSemanticDiagramElements_3 = this._utils_qvto.getAllSemanticDiagramElements(_diagram_6);
      for(final GenLinkEnd e_2 : _allSemanticDiagramElements_3) {
        _builder.append("\t");
        CharSequence _outgoingLinks = this.getOutgoingLinks(e_2);
        _builder.append(_outgoingLinks, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      GenEditorGenerator _editorGen_8 = it.getEditorGen();
      GenDiagram _diagram_7 = _editorGen_8.getDiagram();
      Iterable<GenLink> _allContainedLinks = this._utils_qvto.getAllContainedLinks(_diagram_7);
      for(final GenLink link : _allContainedLinks) {
        _builder.append("\t");
        CharSequence _containedLinksByTypeMethod = this.getContainedLinksByTypeMethod(link);
        _builder.append(_containedLinksByTypeMethod, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      GenEditorGenerator _editorGen_9 = it.getEditorGen();
      GenDiagram _diagram_8 = _editorGen_9.getDiagram();
      Iterable<GenLink> _allIncomingLinks = this._utils_qvto.getAllIncomingLinks(_diagram_8);
      for(final GenLink link_1 : _allIncomingLinks) {
        _builder.append("\t");
        CharSequence _incomingLinksByTypeMethod = this.getIncomingLinksByTypeMethod(link_1);
        _builder.append(_incomingLinksByTypeMethod, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      GenEditorGenerator _editorGen_10 = it.getEditorGen();
      GenDiagram _diagram_9 = _editorGen_10.getDiagram();
      Iterable<GenLink> _allOutgoingLinks = this._utils_qvto.getAllOutgoingLinks(_diagram_9);
      for(final GenLink link_2 : _allOutgoingLinks) {
        _builder.append("\t");
        CharSequence _outgoingLinksByTypeMethod = this.getOutgoingLinksByTypeMethod(link_2);
        _builder.append(_outgoingLinksByTypeMethod, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _runtimeTypedInstance = this.runtimeTypedInstance(it);
    _builder.append(_runtimeTypedInstance, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _additions = this.additions(it);
    _builder.append(_additions, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getConnectedLinks(final GenCommonBase it, final Iterable<GenLink> genLinks, final UpdaterLinkType linkType, final boolean needCrossReferencer) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("public ");
    CharSequence _listOfLinkDescriptors = this.listOfLinkDescriptors(it);
    _builder.append(_listOfLinkDescriptors, "\t\t");
    _builder.append(" ");
    CharSequence _linkGetterName = this.linkGetterName(it, linkType);
    _builder.append(_linkGetterName, "\t\t");
    _builder.append("(org.eclipse.gmf.runtime.notation.View view) {");
    _builder.newLineIfNotEmpty();
    {
      boolean _notEmpty = this._common_qvto.<GenLink>notEmpty(genLinks);
      if (_notEmpty) {
        GenClass _metaClass = this._utils_qvto.getMetaClass(it);
        CharSequence _DeclareAndAssign = this.xptMetaModel.DeclareAndAssign(_metaClass, "modelElement", "view.getElement()");
        _builder.append(_DeclareAndAssign, "");
        _builder.newLineIfNotEmpty();
        {
          if (needCrossReferencer) {
            CharSequence _typeOfCrossReferenceAdapter = this.typeOfCrossReferenceAdapter();
            _builder.append(_typeOfCrossReferenceAdapter, "");
            _builder.append(" crossReferencer = ");
            CharSequence _typeOfCrossReferenceAdapter_1 = this.typeOfCrossReferenceAdapter();
            _builder.append(_typeOfCrossReferenceAdapter_1, "");
            _builder.append(".getCrossReferenceAdapter(view.eResource().getResourceSet());");
            _builder.newLineIfNotEmpty();
          }
        }
        GenDiagramUpdater _diagramUpdater = this.diagramUpdater(it);
        CharSequence _newLinkedListOfLinkDescriptors = this.newLinkedListOfLinkDescriptors(_diagramUpdater, "result");
        _builder.append(_newLinkedListOfLinkDescriptors, "");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
        {
          for(final GenLink link : genLinks) {
            GenClass _metaClass_1 = this._utils_qvto.getMetaClass(it);
            boolean _isExternalInterface = this._genModelUtils_qvto.isExternalInterface(_metaClass_1);
            CharSequence _colectConnectedLinks = this.colectConnectedLinks(link, linkType, needCrossReferencer, _isExternalInterface);
            _builder.append(_colectConnectedLinks, "");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("return result;");
        _builder.newLine();
      } else {
        _builder.append("return ");
        CharSequence _newEmptyList = this.newEmptyList();
        _builder.append(_newEmptyList, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence colectConnectedLinks(final GenLink it, final UpdaterLinkType linkType, final boolean needCrossReferencer, final boolean isExternalInterface) {
    StringConcatenation _builder = new StringConcatenation();
    {
      LinkModelFacet _modelFacet = it.getModelFacet();
      boolean _notEquals = (!Objects.equal(_modelFacet, null));
      if (_notEquals) {
        {
          boolean _and = false;
          if (!isExternalInterface) {
            _and = false;
          } else {
            LinkModelFacet _modelFacet_1 = it.getModelFacet();
            boolean _oclIsKindOf = this._common_qvto.oclIsKindOf(_modelFacet_1, FeatureLinkModelFacet.class);
            boolean _not = (!_oclIsKindOf);
            _and = _not;
          }
          if (_and) {
            _builder.append("if (");
            LinkModelFacet _modelFacet_2 = it.getModelFacet();
            GenClass _linkEndType = this._utils_qvto.getLinkEndType(_modelFacet_2, linkType);
            CharSequence _IsInstance = this.xptMetaModel.IsInstance(_linkEndType, "modelElement");
            _builder.append(_IsInstance, "");
            _builder.append(") {");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("result.addAll(");
        LinkModelFacet _modelFacet_3 = it.getModelFacet();
        CharSequence _chooseConnectedLinksByTypeMethodName = this.chooseConnectedLinksByTypeMethodName(_modelFacet_3, linkType, it);
        _builder.append(_chooseConnectedLinksByTypeMethodName, "");
        _builder.append("(");
        {
          boolean _and_1 = false;
          if (!isExternalInterface) {
            _and_1 = false;
          } else {
            LinkModelFacet _modelFacet_4 = it.getModelFacet();
            boolean _oclIsKindOf_1 = this._common_qvto.oclIsKindOf(_modelFacet_4, FeatureLinkModelFacet.class);
            boolean _not_1 = (!_oclIsKindOf_1);
            _and_1 = _not_1;
          }
          if (_and_1) {
            LinkModelFacet _modelFacet_5 = it.getModelFacet();
            GenClass _linkEndType_1 = this._utils_qvto.getLinkEndType(_modelFacet_5, linkType);
            CharSequence _CastEObject = this.xptMetaModel.CastEObject(_linkEndType_1, "modelElement");
            _builder.append(_CastEObject, "");
          } else {
            _builder.append("modelElement");
          }
        }
        {
          if (needCrossReferencer) {
            _builder.append(", crossReferencer");
          }
        }
        _builder.append("));  ");
        _builder.newLineIfNotEmpty();
        {
          boolean _and_2 = false;
          if (!isExternalInterface) {
            _and_2 = false;
          } else {
            LinkModelFacet _modelFacet_6 = it.getModelFacet();
            boolean _oclIsKindOf_2 = this._common_qvto.oclIsKindOf(_modelFacet_6, FeatureLinkModelFacet.class);
            boolean _not_2 = (!_oclIsKindOf_2);
            _and_2 = _not_2;
          }
          if (_and_2) {
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence getIncomingLinksByTypeMethod(final GenLink it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("   ");
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "   ");
    _builder.newLineIfNotEmpty();
    _builder.append("   \t\t");
    _builder.append("protected java.util.Collection<");
    GenDiagramUpdater _diagramUpdater = this.diagramUpdater(it);
    CharSequence _qualifiedClassName = this.linkDescriptor.qualifiedClassName(_diagramUpdater);
    _builder.append(_qualifiedClassName, "   \t\t");
    _builder.append("> ");
    CharSequence _connectedLinksByTypeMethodName = this.getConnectedLinksByTypeMethodName(it, 
      UpdaterLinkType.INCOMING);
    _builder.append(_connectedLinksByTypeMethodName, "   \t\t");
    _builder.append("(");
    LinkModelFacet _modelFacet = it.getModelFacet();
    GenClass _targetType = _modelFacet.getTargetType();
    CharSequence _QualifiedClassName = this.xptMetaModel.QualifiedClassName(_targetType);
    _builder.append(_QualifiedClassName, "   \t\t");
    _builder.append(" target, ");
    CharSequence _typeOfCrossReferenceAdapter = this.typeOfCrossReferenceAdapter();
    _builder.append(_typeOfCrossReferenceAdapter, "   \t\t");
    _builder.append(" crossReferencer) {");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    GenDiagramUpdater _diagramUpdater_1 = this.diagramUpdater(it);
    CharSequence _newLinkedListOfLinkDescriptors = this.newLinkedListOfLinkDescriptors(_diagramUpdater_1, "result");
    _builder.append(_newLinkedListOfLinkDescriptors, " ");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting> settings = crossReferencer.getInverseReferences(target);");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("for (org.eclipse.emf.ecore.EStructuralFeature.Setting setting : settings) {");
    _builder.newLine();
    _builder.append("    ");
    LinkModelFacet _modelFacet_1 = it.getModelFacet();
    CharSequence _incomingLinksByTypeMethodBody = this.getIncomingLinksByTypeMethodBody(_modelFacet_1, it);
    _builder.append(_incomingLinksByTypeMethodBody, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("}");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("return result;  ");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getICustomDiagramUpdater(final GenContainerBase it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("org.eclipse.papyrus.uml.diagram.common.part.ICustomDiagramUpdater<");
    GenDiagramUpdater _diagramUpdater = this.diagramUpdater(it);
    CharSequence _qualifiedClassName = this.nodeDescriptor.qualifiedClassName(_diagramUpdater);
    _builder.append(_qualifiedClassName, "");
    _builder.append(">");
    return _builder;
  }
  
  public CharSequence getSemanticChildrenOfView(final GenContainerBase it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Resource _eResource = it.eResource();
      TreeIterator<EObject> _allContents = _eResource.getAllContents();
      Iterator<SpecificDiagramUpdater> _filter = Iterators.<SpecificDiagramUpdater>filter(_allContents, SpecificDiagramUpdater.class);
      final Function1<SpecificDiagramUpdater, Boolean> _function = new Function1<SpecificDiagramUpdater, Boolean>() {
        public Boolean apply(final SpecificDiagramUpdater v) {
          boolean _and = false;
          GenCommonBase _genNode = v.getGenNode();
          boolean _equals = Objects.equal(_genNode, it);
          if (!_equals) {
            _and = false;
          } else {
            String _classpath = v.getClasspath();
            boolean _notEquals = (!Objects.equal(_classpath, null));
            _and = _notEquals;
          }
          return Boolean.valueOf(_and);
        }
      };
      Iterator<SpecificDiagramUpdater> _filter_1 = IteratorExtensions.<SpecificDiagramUpdater>filter(_filter, _function);
      int _size = IteratorExtensions.size(_filter_1);
      boolean _notEquals = (_size != 0);
      if (_notEquals) {
        CharSequence _generatedMemberComment = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment, "");
        _builder.newLineIfNotEmpty();
        {
          Resource _eResource_1 = it.eResource();
          TreeIterator<EObject> _allContents_1 = _eResource_1.getAllContents();
          Iterator<SpecificDiagramUpdater> _filter_2 = Iterators.<SpecificDiagramUpdater>filter(_allContents_1, SpecificDiagramUpdater.class);
          final Function1<SpecificDiagramUpdater, Boolean> _function_1 = new Function1<SpecificDiagramUpdater, Boolean>() {
            public Boolean apply(final SpecificDiagramUpdater v) {
              boolean _and = false;
              GenCommonBase _genNode = v.getGenNode();
              boolean _equals = Objects.equal(_genNode, it);
              if (!_equals) {
                _and = false;
              } else {
                String _classpath = v.getClasspath();
                boolean _notEquals = (!Objects.equal(_classpath, null));
                _and = _notEquals;
              }
              return Boolean.valueOf(_and);
            }
          };
          Iterator<SpecificDiagramUpdater> _filter_3 = IteratorExtensions.<SpecificDiagramUpdater>filter(_filter_2, _function_1);
          Iterable<SpecificDiagramUpdater> _iterable = IteratorExtensions.<SpecificDiagramUpdater>toIterable(_filter_3);
          for(final SpecificDiagramUpdater updater : _iterable) {
            _builder.append("public  ");
            CharSequence _listOfNodeDescriptors = this.listOfNodeDescriptors(it);
            _builder.append(_listOfNodeDescriptors, "");
            _builder.append(" ");
            CharSequence _semanticChildrenMethodName = this.getSemanticChildrenMethodName(it);
            _builder.append(_semanticChildrenMethodName, "");
            _builder.append("(org.eclipse.gmf.runtime.notation.View view) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            CharSequence _iCustomDiagramUpdater = this.getICustomDiagramUpdater(it);
            _builder.append(_iCustomDiagramUpdater, "\t");
            _builder.append(" customUpdater = new ");
            String _classpath = updater.getClasspath();
            _builder.append(_classpath, "\t");
            _builder.append("();");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("return customUpdater.getSemanticChildren(view);");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
          }
        }
      } else {
        CharSequence _generatedMemberComment_1 = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment_1, "");
        _builder.newLineIfNotEmpty();
        _builder.append("public  ");
        CharSequence _listOfNodeDescriptors_1 = this.listOfNodeDescriptors(it);
        _builder.append(_listOfNodeDescriptors_1, "");
        _builder.append(" ");
        CharSequence _semanticChildrenMethodName_1 = this.getSemanticChildrenMethodName(it);
        _builder.append(_semanticChildrenMethodName_1, "");
        _builder.append("(org.eclipse.gmf.runtime.notation.View view) {");
        _builder.newLineIfNotEmpty();
        {
          boolean _or = false;
          Set<GenFeature> _semanticChildrenChildFeatures = this._utils_qvto.getSemanticChildrenChildFeatures(it);
          boolean _notEmpty = this._common_qvto.<GenFeature>notEmpty(_semanticChildrenChildFeatures);
          if (_notEmpty) {
            _or = true;
          } else {
            Iterable<GenNode> _phantomNodes = this._utils_qvto.getPhantomNodes(it);
            boolean _notEmpty_1 = this._common_qvto.<GenNode>notEmpty(_phantomNodes);
            _or = _notEmpty_1;
          }
          if (_or) {
            _builder.append("\t");
            CharSequence _defineModelElement = this.defineModelElement(it);
            _builder.append(_defineModelElement, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            GenDiagramUpdater _diagramUpdater = this.diagramUpdater(it);
            CharSequence _newLinkedListOfNodeDescriptors = this.newLinkedListOfNodeDescriptors(_diagramUpdater, "result");
            _builder.append(_newLinkedListOfNodeDescriptors, "\t");
            _builder.append("();");
            _builder.newLineIfNotEmpty();
            {
              Set<GenFeature> _semanticChildrenChildFeatures_1 = this._utils_qvto.getSemanticChildrenChildFeatures(it);
              for(final GenFeature childMetaFeature : _semanticChildrenChildFeatures_1) {
                {
                  boolean _equals = Objects.equal(null, childMetaFeature);
                  if (_equals) {
                    _builder.append("\t");
                    _builder.append("{ \t/*FIXME no containment/child feature found in the genmodel, toolsmith need to specify Class here manually*/ childElement = ");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("/*FIXME no containment/child feature found in the genmodel, toolsmith need to specify correct one here manually*/;");
                    _builder.newLine();
                  } else {
                    boolean _isListType = childMetaFeature.isListType();
                    if (_isListType) {
                      _builder.append("\t");
                      _builder.append("for (java.util.Iterator<?> it = ");
                      GenClass _modelElementType = this._utils_qvto.getModelElementType(it);
                      CharSequence _featureValue = this.xptMetaModel.getFeatureValue(childMetaFeature, "modelElement", _modelElementType);
                      _builder.append(_featureValue, "\t");
                      _builder.append(".iterator(); it.hasNext();) {");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      GenClass _typeGenClass = childMetaFeature.getTypeGenClass();
                      CharSequence _DeclareAndAssign = this.xptMetaModel.DeclareAndAssign(_typeGenClass, "childElement", "it.next()", true);
                      _builder.append(_DeclareAndAssign, "\t");
                      _builder.newLineIfNotEmpty();
                    } else {
                      _builder.append("\t");
                      _builder.append("{ ");
                      GenClass _typeGenClass_1 = childMetaFeature.getTypeGenClass();
                      GenClass _modelElementType_1 = this._utils_qvto.getModelElementType(it);
                      CharSequence _DeclareAndAssign_1 = this.xptMetaModel.DeclareAndAssign(_typeGenClass_1, "childElement", "modelElement", _modelElementType_1, childMetaFeature);
                      _builder.append(_DeclareAndAssign_1, "\t");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                }
                _builder.append("\t");
                _builder.append("int visualID = ");
                GenDiagram _diagram = it.getDiagram();
                CharSequence _nodeVisualIDMethodCall = this.xptVisualIDRegistry.getNodeVisualIDMethodCall(_diagram);
                _builder.append(_nodeVisualIDMethodCall, "\t");
                _builder.append("(view, ");
                GenClass _typeGenClass_2 = childMetaFeature.getTypeGenClass();
                CharSequence _DowncastToEObject = this.xptMetaModel.DowncastToEObject(_typeGenClass_2, "childElement");
                _builder.append(_DowncastToEObject, "\t");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                {
                  Iterable<GenNode> _semanticChildren = this._utils_qvto.getSemanticChildren(it, childMetaFeature);
                  for(final GenNode next : _semanticChildren) {
                    _builder.append("\t");
                    boolean _and = false;
                    boolean _notEquals_1 = (!Objects.equal(null, childMetaFeature));
                    if (!_notEquals_1) {
                      _and = false;
                    } else {
                      boolean _isListType_1 = childMetaFeature.isListType();
                      _and = _isListType_1;
                    }
                    CharSequence _checkChildElementVisualID = this.checkChildElementVisualID(next, Boolean.valueOf(_and));
                    _builder.append(_checkChildElementVisualID, "\t");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
            {
              Iterable<GenNode> _phantomNodes_1 = this._utils_qvto.getPhantomNodes(it);
              boolean _notEmpty_2 = this._common_qvto.<GenNode>notEmpty(_phantomNodes_1);
              if (_notEmpty_2) {
                _builder.append("\t");
                _builder.append("org.eclipse.emf.ecore.resource.Resource resource = modelElement.eResource();");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("for (java.util.Iterator<org.eclipse.emf.ecore.EObject> it = getPhantomNodesIterator(resource); it.hasNext();) {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("org.eclipse.emf.ecore.EObject childElement = it.next();");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("if (childElement == modelElement) {");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("continue;");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                {
                  Iterable<GenNode> _phantomNodes_2 = this._utils_qvto.getPhantomNodes(it);
                  for(final GenNode phantom : _phantomNodes_2) {
                    _builder.append("\t");
                    _builder.append("\t");
                    CharSequence _addNextIfPhantom = this.addNextIfPhantom(phantom);
                    _builder.append(_addNextIfPhantom, "\t\t");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
            _builder.append("\t");
            _builder.append("return result;");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append("return ");
            CharSequence _newEmptyList = this.newEmptyList();
            _builder.append(_newEmptyList, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence defineLinkSource(final TypeLinkModelFacet it, final boolean inLoop) {
    StringConcatenation _builder = new StringConcatenation();
    {
      GenFeature _sourceMetaFeature = it.getSourceMetaFeature();
      boolean _isListType = _sourceMetaFeature.isListType();
      if (_isListType) {
        _builder.append("java.util.List<?> sources = ");
        GenFeature _sourceMetaFeature_1 = it.getSourceMetaFeature();
        GenClass _metaClass = it.getMetaClass();
        CharSequence _featureValue = this.xptMetaModel.getFeatureValue(_sourceMetaFeature_1, "link", _metaClass);
        _builder.append(_featureValue, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("Object theSource = sources.size() == 1 ? sources.get(0) : null;");
        _builder.newLine();
        _builder.append("if (");
        GenClass _sourceType = it.getSourceType();
        CharSequence _NotInstance = this.xptMetaModel.NotInstance(_sourceType, "theSource");
        _builder.append(_NotInstance, "");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        CharSequence _stopLinkProcessing = this.stopLinkProcessing(inLoop);
        _builder.append(_stopLinkProcessing, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        GenClass _sourceType_1 = it.getSourceType();
        CharSequence _DeclareAndAssign = this.xptMetaModel.DeclareAndAssign(_sourceType_1, "src", "theSource", true);
        _builder.append(_DeclareAndAssign, "");
        _builder.newLineIfNotEmpty();
      } else {
        GenClass _sourceType_2 = it.getSourceType();
        GenClass _metaClass_1 = it.getMetaClass();
        GenFeature _sourceMetaFeature_2 = it.getSourceMetaFeature();
        CharSequence _DeclareAndAssign_1 = this.xptMetaModel.DeclareAndAssign(_sourceType_2, "src", "link", _metaClass_1, _sourceMetaFeature_2);
        _builder.append(_DeclareAndAssign_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence isDiagram(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  public CharSequence defineLinkDestination(final TypeLinkModelFacet it, final Boolean inLoop) {
    StringConcatenation _builder = new StringConcatenation();
    {
      GenFeature _targetMetaFeature = it.getTargetMetaFeature();
      boolean _isListType = _targetMetaFeature.isListType();
      if (_isListType) {
        _builder.append("java.util.List<?> targets = ");
        GenFeature _targetMetaFeature_1 = it.getTargetMetaFeature();
        GenClass _metaClass = it.getMetaClass();
        CharSequence _featureValue = this.xptMetaModel.getFeatureValue(_targetMetaFeature_1, "link", _metaClass);
        _builder.append(_featureValue, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("Object theTarget = targets.size() == 1 ? targets.get(0) : null;");
        _builder.newLine();
        _builder.append("if (");
        GenClass _targetType = it.getTargetType();
        CharSequence _NotInstance = this.xptMetaModel.NotInstance(_targetType, "theTarget");
        _builder.append(_NotInstance, "");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        CharSequence _stopLinkProcessing = this.stopLinkProcessing((inLoop).booleanValue());
        _builder.append(_stopLinkProcessing, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        GenClass _targetType_1 = it.getTargetType();
        CharSequence _DeclareAndAssign = this.xptMetaModel.DeclareAndAssign(_targetType_1, "dst", "theTarget", true);
        _builder.append(_DeclareAndAssign, "");
        _builder.newLineIfNotEmpty();
      } else {
        GenClass _targetType_2 = it.getTargetType();
        GenClass _metaClass_1 = it.getMetaClass();
        GenFeature _targetMetaFeature_2 = it.getTargetMetaFeature();
        CharSequence _DeclareAndAssign_1 = this.xptMetaModel.DeclareAndAssign(_targetType_2, "dst", "link", _metaClass_1, _targetMetaFeature_2);
        _builder.append(_DeclareAndAssign_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence getOutgoingLinksByTypeMethodSignature(final GenLink it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected java.util.Collection<");
    GenDiagramUpdater _diagramUpdater = this.diagramUpdater(it);
    CharSequence _qualifiedClassName = this.linkDescriptor.qualifiedClassName(_diagramUpdater);
    _builder.append(_qualifiedClassName, "");
    _builder.append("> ");
    CharSequence _connectedLinksByTypeMethodName = this.getConnectedLinksByTypeMethodName(it, UpdaterLinkType.OUTGOING);
    _builder.append(_connectedLinksByTypeMethodName, "");
    _builder.append("(");
    LinkModelFacet _modelFacet = it.getModelFacet();
    GenClass _sourceType = _modelFacet.getSourceType();
    CharSequence _QualifiedClassName = this.xptMetaModel.QualifiedClassName(_sourceType);
    _builder.append(_QualifiedClassName, "");
    _builder.append(" source)");
    return _builder;
  }
  
  public CharSequence getGenericSemanticChildrenOfView(final GenDiagramUpdater it, final Iterable<GenContainerBase> semanticContainers) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("public ");
    CharSequence _listOfNodeDescriptors = this.listOfNodeDescriptors(it);
    _builder.append(_listOfNodeDescriptors, "\t\t");
    _builder.append(" getSemanticChildren(org.eclipse.gmf.runtime.notation.View view) {");
    _builder.newLineIfNotEmpty();
    {
      boolean _notEmpty = this._common_qvto.<GenContainerBase>notEmpty(semanticContainers);
      if (_notEmpty) {
        _builder.append("\t");
        _builder.append("switch (");
        GenEditorGenerator _editorGen = it.getEditorGen();
        GenDiagram _diagram = _editorGen.getDiagram();
        CharSequence _visualIDMethodCall = this.xptVisualIDRegistry.getVisualIDMethodCall(_diagram);
        _builder.append(_visualIDMethodCall, "\t");
        _builder.append("(view)) {");
        _builder.newLineIfNotEmpty();
        {
          for(final GenContainerBase next : semanticContainers) {
            _builder.append("\t");
            _builder.append("\t");
            CharSequence _semanticChildrenCase = this.getSemanticChildrenCase(next);
            _builder.append(_semanticChildrenCase, "\t\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("return ");
    CharSequence _newEmptyList = this.newEmptyList();
    _builder.append(_newEmptyList, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _getContainedLinksByTypeMethod(final TypeLinkModelFacet it, final GenLink genLink) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("protected java.util.Collection<");
    GenDiagramUpdater _diagramUpdater = this.diagramUpdater(genLink);
    CharSequence _qualifiedClassName = this.linkDescriptor.qualifiedClassName(_diagramUpdater);
    _builder.append(_qualifiedClassName, "\t");
    _builder.append("> ");
    CharSequence _connectedLinksByTypeMethodName = this.getConnectedLinksByTypeMethodName(genLink, UpdaterLinkType.CONTAINED);
    _builder.append(_connectedLinksByTypeMethodName, "\t");
    _builder.append("(");
    GenFeature _childMetaFeature = it.getChildMetaFeature();
    GenClass _genClass = _childMetaFeature.getGenClass();
    CharSequence _QualifiedClassName = this.xptMetaModel.QualifiedClassName(_genClass);
    _builder.append(_QualifiedClassName, "\t");
    _builder.append(" container) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _containedLinksByTypeMethodBody = this.getContainedLinksByTypeMethodBody(it, genLink, false);
    _builder.append(_containedLinksByTypeMethodBody, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getGenericConnectedLinks(final GenDiagramUpdater it, final Iterable<? extends GenCommonBase> linkContainers, final UpdaterLinkType linkType) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public ");
    CharSequence _listOfLinkDescriptors = this.listOfLinkDescriptors(it);
    _builder.append(_listOfLinkDescriptors, "\t");
    _builder.append(" get");
    String _linkMethodSuffix = this._utils_qvto.getLinkMethodSuffix(linkType);
    _builder.append(_linkMethodSuffix, "\t");
    _builder.append("Links(org.eclipse.gmf.runtime.notation.View view) {");
    _builder.newLineIfNotEmpty();
    {
      boolean _notEmpty = this._common_qvto.notEmpty(linkContainers);
      if (_notEmpty) {
        _builder.append("\t");
        _builder.append("switch (");
        GenEditorGenerator _editorGen = it.getEditorGen();
        GenDiagram _diagram = _editorGen.getDiagram();
        CharSequence _visualIDMethodCall = this.xptVisualIDRegistry.getVisualIDMethodCall(_diagram);
        _builder.append(_visualIDMethodCall, "\t");
        _builder.append("(view)) {");
        _builder.newLineIfNotEmpty();
        {
          for(final GenCommonBase next : linkContainers) {
            _builder.append("\t");
            _builder.append("\t");
            CharSequence _containedLinksCase = this.getContainedLinksCase(next, linkType);
            _builder.append(_containedLinksCase, "\t\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("return ");
    CharSequence _newEmptyList = this.newEmptyList();
    _builder.append(_newEmptyList, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence runtimeTypedInstance(final GenDiagramUpdater it) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  public CharSequence getContainedLinksByTypeMethod(final LinkModelFacet it, final GenLink genLink) {
    if (it instanceof FeatureLinkModelFacet) {
      return _getContainedLinksByTypeMethod((FeatureLinkModelFacet)it, genLink);
    } else if (it instanceof TypeLinkModelFacet) {
      return _getContainedLinksByTypeMethod((TypeLinkModelFacet)it, genLink);
    } else if (it != null) {
      return _getContainedLinksByTypeMethod(it, genLink);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, genLink).toString());
    }
  }
}
