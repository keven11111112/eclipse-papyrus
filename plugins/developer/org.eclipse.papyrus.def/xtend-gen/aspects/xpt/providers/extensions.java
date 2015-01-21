/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 * 	  Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.providers;

import aspects.xpt.providers.ViewProvider;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.codegen.gmfgen.ElementType;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenParsers;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.ProviderPriority;
import org.eclipse.papyrus.papyrusgmfgenextension.GenerateUsingElementTypeCreationCommand;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import parsers.ParserProvider;
import xpt.Common;
import xpt.diagram.Utils_qvto;
import xpt.providers.EditPartProvider;
import xpt.providers.IconProvider;
import xpt.providers.ShortcutsDecoratorProvider;

@Singleton
@SuppressWarnings("all")
public class extensions extends xpt.providers.extensions {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private Utils_qvto _utils_qvto;
  
  @Inject
  private ViewProvider viewProvider;
  
  @Inject
  private IconProvider iconProvider;
  
  @Inject
  private EditPartProvider editPartProvider;
  
  @Inject
  private ParserProvider labelParsers;
  
  @Inject
  private ShortcutsDecoratorProvider shorcutProvider;
  
  public CharSequence extensions(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _extraLineBreak = this._common.extraLineBreak();
    _builder.append(_extraLineBreak, "");
    _builder.newLineIfNotEmpty();
    String _tripleSpace = this._common.tripleSpace(1);
    _builder.append(_tripleSpace, "");
    _builder.append("<extension point=\"org.eclipse.gmf.runtime.diagram.core.viewProviders\" id=\"view-provider\">");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_1 = this._common.tripleSpace(2);
    _builder.append(_tripleSpace_1, "");
    CharSequence _xmlGeneratedTag = this._common.xmlGeneratedTag();
    _builder.append(_xmlGeneratedTag, "");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_2 = this._common.tripleSpace(2);
    _builder.append(_tripleSpace_2, "");
    _builder.append("<viewProvider class=\"");
    CharSequence _qualifiedClassName = this.viewProvider.qualifiedClassName(it);
    _builder.append(_qualifiedClassName, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_3 = this._common.tripleSpace(3);
    _builder.append(_tripleSpace_3, "");
    _builder.append("<Priority name=\"");
    ProviderPriority _notationViewProviderPriority = it.getNotationViewProviderPriority();
    _builder.append(_notationViewProviderPriority, "");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    {
      EList<String> _shortcutsProvidedFor = it.getShortcutsProvidedFor();
      boolean _isEmpty = _shortcutsProvidedFor.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        String _tripleSpace_4 = this._common.tripleSpace(3);
        _builder.append(_tripleSpace_4, "");
        _builder.append("<object id=\"referencing-diagrams\" class=\"org.eclipse.gmf.runtime.notation.Diagram\">");
        _builder.newLineIfNotEmpty();
        String _tripleSpace_5 = this._common.tripleSpace(4);
        _builder.append(_tripleSpace_5, "");
        _builder.append("<method name=\"getType()\" value=\"");
        {
          EList<String> _shortcutsProvidedFor_1 = it.getShortcutsProvidedFor();
          boolean _hasElements = false;
          for(final String s : _shortcutsProvidedFor_1) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",", "");
            }
            _builder.append(s, "");
          }
        }
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
        String _tripleSpace_6 = this._common.tripleSpace(3);
        _builder.append(_tripleSpace_6, "");
        _builder.append("</object>");
        _builder.newLineIfNotEmpty();
        String _tripleSpace_7 = this._common.tripleSpace(3);
        _builder.append(_tripleSpace_7, "");
        _builder.append("<context viewClass=\"org.eclipse.gmf.runtime.notation.Node\" containerViews=\"referencing-diagrams\"/>");
        _builder.newLineIfNotEmpty();
      }
    }
    String _tripleSpace_8 = this._common.tripleSpace(3);
    _builder.append(_tripleSpace_8, "");
    _builder.append("<context viewClass=\"org.eclipse.gmf.runtime.notation.Diagram\" semanticHints=\"");
    GenEditorGenerator _editorGen = it.getEditorGen();
    String _modelID = _editorGen.getModelID();
    _builder.append(_modelID, "");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_9 = this._common.tripleSpace(3);
    _builder.append(_tripleSpace_9, "");
    _builder.append("<context viewClass=\"org.eclipse.gmf.runtime.notation.Node\" semanticHints=\"");
    EList<GenNode> _allNodes = it.getAllNodes();
    CharSequence _commaSeparatedVisualIDs = this.commaSeparatedVisualIDs(_allNodes);
    _builder.append(_commaSeparatedVisualIDs, "");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    {
      EList<GenLink> _links = it.getLinks();
      boolean _isEmpty_1 = _links.isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      if (_not_1) {
        String _tripleSpace_10 = this._common.tripleSpace(3);
        _builder.append(_tripleSpace_10, "");
        _builder.append("<context viewClass=\"org.eclipse.gmf.runtime.notation.Edge\" semanticHints=\"");
        EList<GenLink> _links_1 = it.getLinks();
        CharSequence _commaSeparatedVisualIDs_1 = this.commaSeparatedVisualIDs(_links_1);
        _builder.append(_commaSeparatedVisualIDs_1, "");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
      }
    }
    String _tripleSpace_11 = this._common.tripleSpace(2);
    _builder.append(_tripleSpace_11, "");
    _builder.append("</viewProvider>");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_12 = this._common.tripleSpace(1);
    _builder.append(_tripleSpace_12, "");
    _builder.append("</extension>");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    String _tripleSpace_13 = this._common.tripleSpace(1);
    _builder.append(_tripleSpace_13, "");
    _builder.append("<extension point=\"org.eclipse.gmf.runtime.diagram.ui.editpartProviders\" id=\"ep-provider\">");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_14 = this._common.tripleSpace(2);
    _builder.append(_tripleSpace_14, "");
    CharSequence _xmlGeneratedTag_1 = this._common.xmlGeneratedTag();
    _builder.append(_xmlGeneratedTag_1, "");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_15 = this._common.tripleSpace(2);
    _builder.append(_tripleSpace_15, "");
    _builder.append("<editpartProvider class=\"");
    CharSequence _qualifiedClassName_1 = this.editPartProvider.qualifiedClassName(it);
    _builder.append(_qualifiedClassName_1, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_16 = this._common.tripleSpace(3);
    _builder.append(_tripleSpace_16, "");
    _builder.append("<Priority name=\"");
    ProviderPriority _editPartProviderPriority = it.getEditPartProviderPriority();
    _builder.append(_editPartProviderPriority, "");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_17 = this._common.tripleSpace(3);
    _builder.append(_tripleSpace_17, "");
    _builder.append("<object class=\"org.eclipse.gmf.runtime.notation.Diagram\" id=\"generated-diagram\">");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_18 = this._common.tripleSpace(4);
    _builder.append(_tripleSpace_18, "");
    _builder.append("<method name=\"getType()\" value=\"");
    GenEditorGenerator _editorGen_1 = it.getEditorGen();
    String _modelID_1 = _editorGen_1.getModelID();
    _builder.append(_modelID_1, "");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_19 = this._common.tripleSpace(3);
    _builder.append(_tripleSpace_19, "");
    _builder.append("</object>");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_20 = this._common.tripleSpace(3);
    _builder.append(_tripleSpace_20, "");
    _builder.append("<object class=\"org.eclipse.gmf.runtime.notation.Node\" id=\"generated-nodes\">");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_21 = this._common.tripleSpace(4);
    _builder.append(_tripleSpace_21, "");
    _builder.append("<method name=\"getType()\" value=\"");
    EList<GenNode> _allNodes_1 = it.getAllNodes();
    CharSequence _commaSeparatedVisualIDs_2 = this.commaSeparatedVisualIDs(_allNodes_1);
    _builder.append(_commaSeparatedVisualIDs_2, "");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_22 = this._common.tripleSpace(3);
    _builder.append(_tripleSpace_22, "");
    _builder.append("</object>");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_23 = this._common.tripleSpace(3);
    _builder.append(_tripleSpace_23, "");
    _builder.append("<object class=\"org.eclipse.gmf.runtime.notation.Edge\" id=\"generated-links\">");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_24 = this._common.tripleSpace(4);
    _builder.append(_tripleSpace_24, "");
    _builder.append("<method name=\"getType()\" value=\"");
    EList<GenLink> _links_2 = it.getLinks();
    CharSequence _commaSeparatedVisualIDs_3 = this.commaSeparatedVisualIDs(_links_2);
    _builder.append(_commaSeparatedVisualIDs_3, "");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_25 = this._common.tripleSpace(3);
    _builder.append(_tripleSpace_25, "");
    _builder.append("</object>");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_26 = this._common.tripleSpace(3);
    _builder.append(_tripleSpace_26, "");
    _builder.append("<object class=\"org.eclipse.gmf.runtime.notation.Node\" id=\"generated-labels\">");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_27 = this._common.tripleSpace(4);
    _builder.append(_tripleSpace_27, "");
    _builder.append("<method name=\"getType()\" value=\"");
    EList<GenNode> _allNodes_2 = it.getAllNodes();
    final Function1<GenNode, EList<GenNodeLabel>> _function = new Function1<GenNode, EList<GenNodeLabel>>() {
      public EList<GenNodeLabel> apply(final GenNode n) {
        return n.getLabels();
      }
    };
    List<EList<GenNodeLabel>> _map = ListExtensions.<GenNode, EList<GenNodeLabel>>map(_allNodes_2, _function);
    Iterable<GenNodeLabel> _flatten = Iterables.<GenNodeLabel>concat(_map);
    CharSequence _commaSeparatedVisualIDs_4 = this.commaSeparatedVisualIDs(_flatten);
    _builder.append(_commaSeparatedVisualIDs_4, "");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_28 = this._common.tripleSpace(3);
    _builder.append(_tripleSpace_28, "");
    _builder.append("</object>");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_29 = this._common.tripleSpace(3);
    _builder.append(_tripleSpace_29, "");
    _builder.append("<object class=\"org.eclipse.gmf.runtime.notation.Node\" id=\"generated-compartments\">");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_30 = this._common.tripleSpace(4);
    _builder.append(_tripleSpace_30, "");
    _builder.append("<method name=\"getType()\" value=\"");
    EList<GenCompartment> _compartments = it.getCompartments();
    CharSequence _commaSeparatedVisualIDs_5 = this.commaSeparatedVisualIDs(_compartments);
    _builder.append(_commaSeparatedVisualIDs_5, "");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_31 = this._common.tripleSpace(3);
    _builder.append(_tripleSpace_31, "");
    _builder.append("</object>");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_32 = this._common.tripleSpace(3);
    _builder.append(_tripleSpace_32, "");
    _builder.append("<context views=\"generated-diagram,generated-nodes,generated-links,generated-labels,generated-compartments\"/>");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_33 = this._common.tripleSpace(2);
    _builder.append(_tripleSpace_33, "");
    _builder.append("</editpartProvider>");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_34 = this._common.tripleSpace(1);
    _builder.append(_tripleSpace_34, "");
    _builder.append("</extension>");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    String _tripleSpace_35 = this._common.tripleSpace(1);
    _builder.append(_tripleSpace_35, "");
    _builder.append("<extension point=\"org.eclipse.gmf.runtime.common.ui.services.iconProviders\" id=\"icon-provider\">");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_36 = this._common.tripleSpace(2);
    _builder.append(_tripleSpace_36, "");
    CharSequence _xmlGeneratedTag_2 = this._common.xmlGeneratedTag();
    _builder.append(_xmlGeneratedTag_2, "");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_37 = this._common.tripleSpace(2);
    _builder.append(_tripleSpace_37, "");
    _builder.append("<IconProvider class=\"");
    CharSequence _qualifiedClassName_2 = this.iconProvider.qualifiedClassName(it);
    _builder.append(_qualifiedClassName_2, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_38 = this._common.tripleSpace(3);
    _builder.append(_tripleSpace_38, "");
    _builder.append("<Priority name=\"");
    ProviderPriority _iconProviderPriority = it.getIconProviderPriority();
    _builder.append(_iconProviderPriority, "");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_39 = this._common.tripleSpace(2);
    _builder.append(_tripleSpace_39, "");
    _builder.append("</IconProvider>");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_40 = this._common.tripleSpace(1);
    _builder.append(_tripleSpace_40, "");
    _builder.append("</extension>");
    _builder.newLineIfNotEmpty();
    {
      boolean _and = false;
      GenEditorGenerator _editorGen_2 = it.getEditorGen();
      GenParsers _labelParsers = _editorGen_2.getLabelParsers();
      boolean _notEquals = (!Objects.equal(_labelParsers, null));
      if (!_notEquals) {
        _and = false;
      } else {
        GenEditorGenerator _editorGen_3 = it.getEditorGen();
        GenParsers _labelParsers_1 = _editorGen_3.getLabelParsers();
        boolean _isExtensibleViaService = _labelParsers_1.isExtensibleViaService();
        _and = _isExtensibleViaService;
      }
      if (_and) {
        CharSequence _extraLineBreak_1 = this._common.extraLineBreak();
        _builder.append(_extraLineBreak_1, "");
        _builder.newLineIfNotEmpty();
        String _tripleSpace_41 = this._common.tripleSpace(1);
        _builder.append(_tripleSpace_41, "");
        _builder.append("<extension point=\"org.eclipse.gmf.runtime.common.ui.services.parserProviders\" id=\"parser-provider\">");
        _builder.newLineIfNotEmpty();
        String _tripleSpace_42 = this._common.tripleSpace(2);
        _builder.append(_tripleSpace_42, "");
        CharSequence _xmlGeneratedTag_3 = this._common.xmlGeneratedTag();
        _builder.append(_xmlGeneratedTag_3, "");
        _builder.newLineIfNotEmpty();
        String _tripleSpace_43 = this._common.tripleSpace(2);
        _builder.append(_tripleSpace_43, "");
        _builder.append("<ParserProvider class=\"");
        GenEditorGenerator _editorGen_4 = it.getEditorGen();
        GenParsers _labelParsers_2 = _editorGen_4.getLabelParsers();
        CharSequence _qualifiedClassName_3 = this.labelParsers.qualifiedClassName(_labelParsers_2);
        _builder.append(_qualifiedClassName_3, "");
        _builder.append("\">");
        _builder.newLineIfNotEmpty();
        String _tripleSpace_44 = this._common.tripleSpace(3);
        _builder.append(_tripleSpace_44, "");
        _builder.append("<Priority name=\"");
        GenEditorGenerator _editorGen_5 = it.getEditorGen();
        GenParsers _labelParsers_3 = _editorGen_5.getLabelParsers();
        ProviderPriority _providerPriority = _labelParsers_3.getProviderPriority();
        _builder.append(_providerPriority, "");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
        String _tripleSpace_45 = this._common.tripleSpace(2);
        _builder.append(_tripleSpace_45, "");
        _builder.append("</ParserProvider>");
        _builder.newLineIfNotEmpty();
        String _tripleSpace_46 = this._common.tripleSpace(1);
        _builder.append(_tripleSpace_46, "");
        _builder.append("</extension>");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      boolean _generateShortcutIcon = it.generateShortcutIcon();
      if (_generateShortcutIcon) {
        CharSequence _extraLineBreak_2 = this._common.extraLineBreak();
        _builder.append(_extraLineBreak_2, "");
        _builder.newLineIfNotEmpty();
        String _tripleSpace_47 = this._common.tripleSpace(1);
        _builder.append(_tripleSpace_47, "");
        _builder.append("<extension point=\"org.eclipse.gmf.runtime.diagram.ui.decoratorProviders\" id=\"decorator-provider\">");
        _builder.newLineIfNotEmpty();
        String _tripleSpace_48 = this._common.tripleSpace(2);
        _builder.append(_tripleSpace_48, "");
        CharSequence _xmlGeneratedTag_4 = this._common.xmlGeneratedTag();
        _builder.append(_xmlGeneratedTag_4, "");
        _builder.newLineIfNotEmpty();
        String _tripleSpace_49 = this._common.tripleSpace(2);
        _builder.append(_tripleSpace_49, "");
        _builder.append("<decoratorProvider class=\"");
        CharSequence _qualifiedClassName_4 = this.shorcutProvider.qualifiedClassName(it);
        _builder.append(_qualifiedClassName_4, "");
        _builder.append("\">");
        _builder.newLineIfNotEmpty();
        String _tripleSpace_50 = this._common.tripleSpace(3);
        _builder.append(_tripleSpace_50, "");
        _builder.append("<Priority name=\"");
        ProviderPriority _shortcutsDecoratorProviderPriority = it.getShortcutsDecoratorProviderPriority();
        _builder.append(_shortcutsDecoratorProviderPriority, "");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
        String _tripleSpace_51 = this._common.tripleSpace(3);
        _builder.append(_tripleSpace_51, "");
        _builder.append("<object class=\"org.eclipse.gmf.runtime.notation.Node(org.eclipse.gmf.runtime.notation)\" id=\"generated-top-nodes\">");
        _builder.newLineIfNotEmpty();
        String _tripleSpace_52 = this._common.tripleSpace(4);
        _builder.append(_tripleSpace_52, "");
        _builder.append("<method name=\"getType()\" value=\"");
        EList<GenTopLevelNode> _topLevelNodes = it.getTopLevelNodes();
        CharSequence _commaSeparatedVisualIDs_6 = this.commaSeparatedVisualIDs(_topLevelNodes);
        _builder.append(_commaSeparatedVisualIDs_6, "");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
        String _tripleSpace_53 = this._common.tripleSpace(3);
        _builder.append(_tripleSpace_53, "");
        _builder.append("</object>");
        _builder.newLineIfNotEmpty();
        String _tripleSpace_54 = this._common.tripleSpace(3);
        _builder.append(_tripleSpace_54, "");
        _builder.append("<context decoratorTargets=\"generated-top-nodes\"/>");
        _builder.newLineIfNotEmpty();
        String _tripleSpace_55 = this._common.tripleSpace(2);
        _builder.append(_tripleSpace_55, "");
        _builder.append("</decoratorProvider>");
        _builder.newLineIfNotEmpty();
        String _tripleSpace_56 = this._common.tripleSpace(1);
        _builder.append(_tripleSpace_56, "");
        _builder.append("</extension>");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    String _tripleSpace_57 = this._common.tripleSpace(1);
    _builder.append(_tripleSpace_57, "");
    _builder.append("<extension point=\"org.eclipse.gmf.runtime.emf.type.core.elementTypes\" id=\"element-types\">");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_58 = this._common.tripleSpace(2);
    _builder.append(_tripleSpace_58, "");
    CharSequence _xmlGeneratedTag_5 = this._common.xmlGeneratedTag();
    _builder.append(_xmlGeneratedTag_5, "");
    _builder.newLineIfNotEmpty();
    {
      List<GenCommonBase> _allTypedElements = this._utils_qvto.getAllTypedElements(it);
      for(final GenCommonBase e : _allTypedElements) {
        ElementType _elementType = e.getElementType();
        CharSequence _elementTypeSafe = this.elementTypeSafe(_elementType);
        _builder.append(_elementTypeSafe, "");
        _builder.newLineIfNotEmpty();
      }
    }
    String _tripleSpace_59 = this._common.tripleSpace(1);
    _builder.append(_tripleSpace_59, "");
    _builder.append("</extension>");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    String _tripleSpace_60 = this._common.tripleSpace(1);
    _builder.append(_tripleSpace_60, "");
    _builder.append("<extension point=\"org.eclipse.gmf.runtime.emf.type.core.elementTypeBindings\" id=\"element-types-bindings\">");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_61 = this._common.tripleSpace(2);
    _builder.append(_tripleSpace_61, "");
    CharSequence _xmlGeneratedTag_6 = this._common.xmlGeneratedTag();
    _builder.append(_xmlGeneratedTag_6, "");
    _builder.newLineIfNotEmpty();
    {
      Resource _eResource = it.eResource();
      TreeIterator<EObject> _allContents = _eResource.getAllContents();
      Iterator<GenerateUsingElementTypeCreationCommand> _filter = Iterators.<GenerateUsingElementTypeCreationCommand>filter(_allContents, GenerateUsingElementTypeCreationCommand.class);
      int _size = IteratorExtensions.size(_filter);
      boolean _lessThan = (_size < 1);
      if (_lessThan) {
        String _tripleSpace_62 = this._common.tripleSpace(2);
        _builder.append(_tripleSpace_62, "");
        _builder.append("<clientContext id=\"");
        GenEditorGenerator _editorGen_6 = it.getEditorGen();
        GenPlugin _plugin = _editorGen_6.getPlugin();
        String _iD = _plugin.getID();
        _builder.append(_iD, "");
        _builder.append(".TypeContext\">");
        _builder.newLineIfNotEmpty();
        String _tripleSpace_63 = this._common.tripleSpace(3);
        _builder.append(_tripleSpace_63, "");
        _builder.append("<enablement>");
        _builder.newLineIfNotEmpty();
        String _tripleSpace_64 = this._common.tripleSpace(4);
        _builder.append(_tripleSpace_64, "");
        _builder.append("<test");
        _builder.newLineIfNotEmpty();
        String _tripleSpace_65 = this._common.tripleSpace(5);
        _builder.append(_tripleSpace_65, "");
        _builder.append("property=\"org.eclipse.gmf.runtime.emf.core.editingDomain\"");
        _builder.newLineIfNotEmpty();
        String _tripleSpace_66 = this._common.tripleSpace(5);
        _builder.append(_tripleSpace_66, "");
        _builder.append("value=\"");
        String _editingDomainID = it.getEditingDomainID();
        _builder.append(_editingDomainID, "");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
        String _tripleSpace_67 = this._common.tripleSpace(3);
        _builder.append(_tripleSpace_67, "");
        _builder.append("</enablement>");
        _builder.newLineIfNotEmpty();
        String _tripleSpace_68 = this._common.tripleSpace(2);
        _builder.append(_tripleSpace_68, "");
        _builder.append("</clientContext> ");
        _builder.newLineIfNotEmpty();
        String _tripleSpace_69 = this._common.tripleSpace(2);
        _builder.append(_tripleSpace_69, "");
        _builder.append("<binding context=\"");
        GenEditorGenerator _editorGen_7 = it.getEditorGen();
        GenPlugin _plugin_1 = _editorGen_7.getPlugin();
        String _iD_1 = _plugin_1.getID();
        _builder.append(_iD_1, "");
        _builder.append(".TypeContext\">");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      Resource _eResource_1 = it.eResource();
      TreeIterator<EObject> _allContents_1 = _eResource_1.getAllContents();
      Iterator<GenerateUsingElementTypeCreationCommand> _filter_1 = Iterators.<GenerateUsingElementTypeCreationCommand>filter(_allContents_1, GenerateUsingElementTypeCreationCommand.class);
      int _size_1 = IteratorExtensions.size(_filter_1);
      boolean _greaterThan = (_size_1 > 0);
      if (_greaterThan) {
        _builder.newLine();
        _builder.append("<binding context=\"org.eclipse.papyrus.infra.services.edit.TypeContext\">");
        _builder.newLine();
      }
    }
    {
      List<GenCommonBase> _allTypedElements_1 = this._utils_qvto.getAllTypedElements(it);
      for(final GenCommonBase e_1 : _allTypedElements_1) {
        String _tripleSpace_70 = this._common.tripleSpace(3);
        _builder.append(_tripleSpace_70, "");
        _builder.append("<elementType ref=\"");
        ElementType _elementType_1 = e_1.getElementType();
        String _uniqueIdentifier = _elementType_1.getUniqueIdentifier();
        _builder.append(_uniqueIdentifier, "");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
      }
    }
    String _tripleSpace_71 = this._common.tripleSpace(3);
    _builder.append(_tripleSpace_71, "");
    _builder.append("<advice ref=\"org.eclipse.gmf.runtime.diagram.core.advice.notationDepdendents\"/>");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_72 = this._common.tripleSpace(2);
    _builder.append(_tripleSpace_72, "");
    _builder.append("</binding>");
    _builder.newLineIfNotEmpty();
    String _tripleSpace_73 = this._common.tripleSpace(1);
    _builder.append(_tripleSpace_73, "");
    _builder.append("</extension>");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
