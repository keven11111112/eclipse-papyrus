/**
 * Copyright (c) 2007, 2009 Borland Software Corporation
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 * 	  Thibault Landre (Atos Origin) - add Papyrus dependencies to Papyrus GMF diagram
 * 	  Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr : add the dependencyorg.eclipse.papyrus.infra.services.edit
 */
package aspects.xpt.plugin;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Iterator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.codegen.gmfgen.GenApplication;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenNavigator;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.gmf.codegen.gmfgen.GenPropertySheet;
import org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingDeleteService;
import org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingReorientService;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import xpt.Common;

@Singleton
@SuppressWarnings("all")
public class manifest extends xpt.plugin.manifest {
  @Inject
  @Extension
  private Common _common;
  
  public CharSequence requireBundle(final GenPlugin it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Require-Bundle: org.eclipse.core.runtime,");
    _builder.newLine();
    {
      GenEditorGenerator _editorGen = it.getEditorGen();
      GenApplication _application = _editorGen.getApplication();
      boolean _equals = Objects.equal(_application, null);
      if (_equals) {
        _builder.append(" org.eclipse.core.resources,");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      boolean _or = false;
      GenEditorGenerator _editorGen_1 = it.getEditorGen();
      GenDiagram _diagram = _editorGen_1.getDiagram();
      boolean _generateShortcutIcon = _diagram.generateShortcutIcon();
      if (_generateShortcutIcon) {
        _or = true;
      } else {
        boolean _and = false;
        GenEditorGenerator _editorGen_2 = it.getEditorGen();
        GenNavigator _navigator = _editorGen_2.getNavigator();
        boolean _notEquals = (!Objects.equal(_navigator, null));
        if (!_notEquals) {
          _and = false;
        } else {
          GenEditorGenerator _editorGen_3 = it.getEditorGen();
          GenNavigator _navigator_1 = _editorGen_3.getNavigator();
          boolean _isGenerateDomainModelNavigator = _navigator_1.isGenerateDomainModelNavigator();
          _and = _isGenerateDomainModelNavigator;
        }
        _or = _and;
      }
      if (_or) {
        _builder.append(" org.eclipse.core.expressions,");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(" org.eclipse.jface,");
    _builder.newLineIfNotEmpty();
    {
      GenEditorGenerator _editorGen_4 = it.getEditorGen();
      GenApplication _application_1 = _editorGen_4.getApplication();
      boolean _equals_1 = Objects.equal(_application_1, null);
      if (_equals_1) {
        _builder.append(" org.eclipse.ui.ide,");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(" org.eclipse.ui.views,");
    _builder.newLineIfNotEmpty();
    {
      GenEditorGenerator _editorGen_5 = it.getEditorGen();
      GenNavigator _navigator_2 = _editorGen_5.getNavigator();
      boolean _notEquals_1 = (!Objects.equal(_navigator_2, null));
      if (_notEquals_1) {
        _builder.append(" org.eclipse.ui.navigator,");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("org.eclipse.ui.navigator.resources,");
        _builder.newLine();
      }
    }
    _builder.append(" org.eclipse.emf.ecore,");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("org.eclipse.emf.ecore.xmi,");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.eclipse.emf.edit.ui,");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.eclipse.gmf.runtime.emf.core,");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.eclipse.gmf.runtime.emf.commands.core,");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.eclipse.gmf.runtime.emf.ui.properties,");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.eclipse.gmf.runtime.diagram.ui,");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.eclipse.papyrus.uml.diagram.common,");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.eclipse.papyrus.infra.gmfdiag.common,");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.eclipse.papyrus.uml.service.types,");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.eclipse.papyrus.infra.widgets,");
    _builder.newLine();
    {
      boolean _isPrintingEnabled = it.isPrintingEnabled();
      if (_isPrintingEnabled) {
        _builder.append(" org.eclipse.gmf.runtime.diagram.ui.printing,");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("org.eclipse.gmf.runtime.diagram.ui.printing.render,");
        _builder.newLine();
      }
    }
    {
      GenEditorGenerator _editorGen_6 = it.getEditorGen();
      GenPropertySheet _propertySheet = _editorGen_6.getPropertySheet();
      boolean _notEquals_2 = (!Objects.equal(_propertySheet, null));
      if (_notEquals_2) {
        _builder.append(" org.eclipse.gmf.runtime.diagram.ui.properties,");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(" org.eclipse.gmf.runtime.diagram.ui.providers,");
    _builder.newLineIfNotEmpty();
    {
      GenEditorGenerator _editorGen_7 = it.getEditorGen();
      GenApplication _application_2 = _editorGen_7.getApplication();
      boolean _equals_2 = Objects.equal(_application_2, null);
      if (_equals_2) {
        _builder.append(" org.eclipse.gmf.runtime.diagram.ui.providers.ide,");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(" org.eclipse.gmf.runtime.diagram.ui.render,");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("org.eclipse.gmf.runtime.diagram.ui.resources.editor,");
    _builder.newLine();
    {
      GenEditorGenerator _editorGen_8 = it.getEditorGen();
      GenApplication _application_3 = _editorGen_8.getApplication();
      boolean _equals_3 = Objects.equal(_application_3, null);
      if (_equals_3) {
        _builder.append(" org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide,");
        _builder.newLineIfNotEmpty();
      }
    }
    EList<String> reqPlugins = it.getAllRequiredPlugins();
    _builder.newLineIfNotEmpty();
    {
      boolean _contains = reqPlugins.contains("org.eclipse.gmf.tooling.runtime");
      boolean _not = (!_contains);
      if (_not) {
        boolean notUsetBooleanVar = reqPlugins.add("org.eclipse.gmf.tooling.runtime");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      for(final String reqId : reqPlugins) {
        _builder.append(" ");
        _builder.append(reqId, "");
        _builder.append(";visibility:=reexport,");
        CharSequence _extraLineBreak = this._common.extraLineBreak();
        _builder.append(_extraLineBreak, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(" org.eclipse.gef,");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("org.eclipse.papyrus.infra.gmfdiag.preferences,");
    _builder.newLine();
    {
      boolean _or_1 = false;
      Resource _eResource = it.eResource();
      TreeIterator<EObject> _allContents = _eResource.getAllContents();
      Iterator<EditPartUsingDeleteService> _filter = Iterators.<EditPartUsingDeleteService>filter(_allContents, EditPartUsingDeleteService.class);
      int _size = IteratorExtensions.size(_filter);
      boolean _notEquals_3 = (_size != 0);
      if (_notEquals_3) {
        _or_1 = true;
      } else {
        Resource _eResource_1 = it.eResource();
        TreeIterator<EObject> _allContents_1 = _eResource_1.getAllContents();
        Iterator<EditPartUsingReorientService> _filter_1 = Iterators.<EditPartUsingReorientService>filter(_allContents_1, EditPartUsingReorientService.class);
        int _size_1 = IteratorExtensions.size(_filter_1);
        boolean _notEquals_4 = (_size_1 != 0);
        _or_1 = _notEquals_4;
      }
      if (_or_1) {
        _builder.append(" ");
        _builder.append("org.eclipse.papyrus.extensionpoints.editors,");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("org.eclipse.papyrus.infra.services.edit");
        _builder.newLine();
      } else {
        _builder.append(" ");
        _builder.append("org.eclipse.papyrus.extensionpoints.editors");
        _builder.newLine();
      }
    }
    return _builder;
  }
}
