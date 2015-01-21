/**
 * Copyright (c) 2006, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 * 	  Modified by Patrick Tessier (CEA LIST)
 * 	  Emilien Perico (Atos Origin) - update template for GMF 2.2 compliance
 */
package aspects.xpt.navigator;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenNavigator;
import org.eclipse.gmf.codegen.gmfgen.GenNavigatorChildReference;
import org.eclipse.gmf.codegen.gmfgen.GenNavigatorPath;
import org.eclipse.gmf.codegen.gmfgen.GenNavigatorPathSegment;
import org.eclipse.gmf.codegen.gmfgen.GenNavigatorReferenceType;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import xpt.CodeStyle;
import xpt.Common;
import xpt.Common_qvto;
import xpt.editor.VisualIDRegistry;
import xpt.navigator.Utils_qvto;

@Singleton
@SuppressWarnings("all")
public class NavigatorContentProvider extends xpt.navigator.NavigatorContentProvider {
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
  private CodeStyle _codeStyle;
  
  @Inject
  private VisualIDRegistry xptVisualIDRegistry;
  
  public CharSequence NavigatorContentProvider(final GenNavigator it) {
    StringConcatenation _builder = new StringConcatenation();
    GenEditorGenerator _editorGen = it.getEditorGen();
    CharSequence _copyright = this._common.copyright(_editorGen);
    _builder.append(_copyright, "");
    _builder.newLineIfNotEmpty();
    _builder.append("package ");
    CharSequence _packageName = this.packageName(it);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _generatedClassComment = this._common.generatedClassComment();
    _builder.append(_generatedClassComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public class ");
    CharSequence _className = this.className(it);
    _builder.append(_className, "");
    _builder.append(" implements org.eclipse.ui.navigator.ICommonContentProvider {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _attributes = this.attributes(it);
    _builder.append(_attributes, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _constructor = this.constructor(it);
    _builder.append(_constructor, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _genAllMethodNodeCase = this.genAllMethodNodeCase(it);
    _builder.append(_genAllMethodNodeCase, "\t");
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _iContentProvider = this.iContentProvider(it);
    _builder.append(_iContentProvider, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _iStructuredContentProvider = this.iStructuredContentProvider(it);
    _builder.append(_iStructuredContentProvider, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _iMementoAware = this.iMementoAware(it);
    _builder.append(_iMementoAware, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t   ");
    _builder.newLine();
    _builder.append("\t   ");
    CharSequence _iCommonContentProvider = this.iCommonContentProvider(it);
    _builder.append(_iCommonContentProvider, "\t   ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t   ");
    _builder.newLine();
    _builder.append("\t   ");
    CharSequence _iTreeContentProvider = this.iTreeContentProvider(it);
    _builder.append(_iTreeContentProvider, "\t   ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t   ");
    _builder.newLine();
    _builder.append("\t   ");
    CharSequence _additions = this.additions(it);
    _builder.append(_additions, "\t   ");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence processChanges(final GenNavigator it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for (java.util.Iterator<org.eclipse.emf.ecore.resource.Resource> it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.emf.ecore.resource.Resource nextResource = it.next();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("nextResource.unload();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("if (myViewer != null) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("return true;");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence initCommonAttributes(final GenNavigator it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain = ");
    CharSequence _createEditingDomain = this.createEditingDomain(it);
    _builder.append(_createEditingDomain, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("myEditingDomain = (org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain) editingDomain;");
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"serial\")");
    _builder.newLine();
    _builder.append("java.util.Map<org.eclipse.emf.ecore.resource.Resource, java.lang.Boolean> map = new java.util.HashMap<org.eclipse.emf.ecore.resource.Resource, java.lang.Boolean>() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    GenEditorGenerator _editorGen = it.getEditorGen();
    GenDiagram _diagram = _editorGen.getDiagram();
    CharSequence _overrideI = this._codeStyle.overrideI(_diagram);
    _builder.append(_overrideI, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public java.lang.Boolean get(java.lang.Object key) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (!containsKey(key)) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (key instanceof org.eclipse.emf.ecore.resource.Resource) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("put((org.eclipse.emf.ecore.resource.Resource) key, java.lang.Boolean.TRUE);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return super.get(key);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("};");
    _builder.newLine();
    _builder.append("myEditingDomain.setResourceToReadOnlyMap(map);");
    _builder.newLine();
    _builder.append("myViewerRefreshRunnable = new Runnable() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    GenEditorGenerator _editorGen_1 = it.getEditorGen();
    GenDiagram _diagram_1 = _editorGen_1.getDiagram();
    CharSequence _overrideI_1 = this._codeStyle.overrideI(_diagram_1);
    _builder.append(_overrideI_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public void run() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (myViewer != null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("myViewer.refresh();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("};");
    _builder.newLine();
    _builder.append("myWorkspaceSynchronizer = new org.eclipse.emf.workspace.util.WorkspaceSynchronizer(editingDomain, new org.eclipse.emf.workspace.util.WorkspaceSynchronizer.Delegate() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    GenEditorGenerator _editorGen_2 = it.getEditorGen();
    GenDiagram _diagram_2 = _editorGen_2.getDiagram();
    CharSequence _overrideC = this._codeStyle.overrideC(_diagram_2);
    _builder.append(_overrideC, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public void dispose() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    GenEditorGenerator _editorGen_3 = it.getEditorGen();
    GenDiagram _diagram_3 = _editorGen_3.getDiagram();
    CharSequence _overrideC_1 = this._codeStyle.overrideC(_diagram_3);
    _builder.append(_overrideC_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public boolean handleResourceChanged(final org.eclipse.emf.ecore.resource.Resource resource) {");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _processChanges = this.processChanges(it);
    _builder.append(_processChanges, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    GenEditorGenerator _editorGen_4 = it.getEditorGen();
    GenDiagram _diagram_4 = _editorGen_4.getDiagram();
    CharSequence _overrideC_2 = this._codeStyle.overrideC(_diagram_4);
    _builder.append(_overrideC_2, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public boolean handleResourceDeleted(org.eclipse.emf.ecore.resource.Resource resource) {");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _processChanges_1 = this.processChanges(it);
    _builder.append(_processChanges_1, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    GenEditorGenerator _editorGen_5 = it.getEditorGen();
    GenDiagram _diagram_5 = _editorGen_5.getDiagram();
    CharSequence _overrideC_3 = this._codeStyle.overrideC(_diagram_5);
    _builder.append(_overrideC_3, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public boolean handleResourceMoved(org.eclipse.emf.ecore.resource.Resource resource, final org.eclipse.emf.common.util.URI newURI) {");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _processChanges_2 = this.processChanges(it);
    _builder.append(_processChanges_2, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("});");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence constructor(final GenNavigator it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public ");
    CharSequence _className = this.className(it);
    _builder.append(_className, "");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _initCommonAttributes = this.initCommonAttributes(it);
    _builder.append(_initCommonAttributes, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence dispose(final GenNavigator it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public void dispose() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("myWorkspaceSynchronizer.dispose();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("myWorkspaceSynchronizer = null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("myViewerRefreshRunnable = null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("for (java.util.Iterator<org.eclipse.emf.ecore.resource.Resource> it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.emf.ecore.resource.Resource resource = it.next();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("resource.unload();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("((org.eclipse.emf.transaction.TransactionalEditingDomain) myEditingDomain).dispose();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("myEditingDomain = null;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getFileChildren(final GenNavigator it) {
    StringConcatenation _builder = new StringConcatenation();
    Iterable<GenNavigatorChildReference> references = this._utils_qvto.getChildReferencesFrom(it, null);
    _builder.newLineIfNotEmpty();
    CharSequence _fileResource = this.getFileResource(it);
    _builder.append(_fileResource, "");
    _builder.newLineIfNotEmpty();
    _builder.append("java.util.Collection<Object> result = new java.util.ArrayList<Object>();");
    _builder.newLine();
    {
      Set<String> _groupNames = this._utils_qvto.getGroupNames(references);
      for(final String groupName : _groupNames) {
        CharSequence _initGroupVariables = this.initGroupVariables(groupName, it, references, "file", null);
        _builder.append(_initGroupVariables, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("java.util.List<org.eclipse.gmf.runtime.notation.View> topViews = new java.util.ArrayList<org.eclipse.gmf.runtime.notation.View>(resource.getContents().size());");
    _builder.newLine();
    _builder.append("for (org.eclipse.emf.ecore.EObject o : resource.getContents()) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (o instanceof org.eclipse.gmf.runtime.notation.View) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("topViews.add((org.eclipse.gmf.runtime.notation.View) o);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    {
      for(final GenNavigatorChildReference ref : references) {
        CharSequence _addNavigatorItemsPrefix = this.addNavigatorItemsPrefix(ref);
        _builder.append(_addNavigatorItemsPrefix, "");
        _builder.append("selectViewsByType(resource.getContents(), ");
        GenCommonBase _child = ref.getChild();
        CharSequence _childViewType = this.getChildViewType(_child);
        _builder.append(_childViewType, "");
        _builder.append(")");
        CharSequence _addNavigatorItemsSuffix = this.addNavigatorItemsSuffix(ref, "file", false);
        _builder.append(_addNavigatorItemsSuffix, "");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      Set<String> _groupNames_1 = this._utils_qvto.getGroupNames(references);
      for(final String groupName_1 : _groupNames_1) {
        CharSequence _addGroups = this.addGroups(groupName_1, references);
        _builder.append(_addGroups, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("return result.toArray();");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getViewChildren(final GenNavigator it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("private Object[] getViewChildren(org.eclipse.gmf.runtime.notation.View view, Object parentElement) {");
    _builder.newLine();
    _builder.append("   \t");
    _builder.append("switch (");
    GenEditorGenerator _editorGen = it.getEditorGen();
    GenDiagram _diagram = _editorGen.getDiagram();
    CharSequence _visualIDMethodCall = this.xptVisualIDRegistry.getVisualIDMethodCall(_diagram);
    _builder.append(_visualIDMethodCall, "   \t");
    _builder.append("(view)) {");
    _builder.newLineIfNotEmpty();
    {
      Iterable<GenCommonBase> _navigatorContainerNodes = this._utils_qvto.getNavigatorContainerNodes(it);
      for(final GenCommonBase node : _navigatorContainerNodes) {
        CharSequence _caseNavigatorNode = this.caseNavigatorNode(node, it);
        _builder.append(_caseNavigatorNode, "");
        _builder.append("\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("   \t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return EMPTY_ARRAY;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence utilityMethods(final GenNavigator it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Iterable<GenCommonBase> _navigatorContainerNodes = this._utils_qvto.getNavigatorContainerNodes(it);
      boolean _notEmpty = this._common_qvto.<GenCommonBase>notEmpty(_navigatorContainerNodes);
      if (_notEmpty) {
        CharSequence _generatedMemberComment = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment, "");
        _builder.newLineIfNotEmpty();
        _builder.append("private java.util.Collection getLinksSourceByType(java.util.Collection edges, String type) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("java.util.Collection result = new java.util.ArrayList();");
        _builder.newLine();
        _builder.append(" \t");
        _builder.append("for (java.util.Iterator it = edges.iterator(); it.hasNext();) {");
        _builder.newLine();
        _builder.append(" \t\t");
        _builder.append("org.eclipse.gmf.runtime.notation.Edge nextEdge = (org.eclipse.gmf.runtime.notation.Edge) it.next();");
        _builder.newLine();
        _builder.append(" \t\t");
        _builder.append("org.eclipse.gmf.runtime.notation.View nextEdgeSource = nextEdge.getSource();");
        _builder.newLine();
        _builder.append(" \t\t");
        _builder.append("if (type.equals(nextEdgeSource.getType()) && isOwnView(nextEdgeSource)) {");
        _builder.newLine();
        _builder.append(" \t\t\t");
        _builder.append("result.add(nextEdgeSource);");
        _builder.newLine();
        _builder.append(" \t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append(" \t");
        _builder.append("}");
        _builder.newLine();
        _builder.append(" \t");
        _builder.append("return result;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        CharSequence _generatedMemberComment_1 = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment_1, "");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("private java.util.Collection getLinksTargetByType(java.util.Collection edges, String type) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("java.util.Collection result = new java.util.ArrayList();");
        _builder.newLine();
        _builder.append(" \t");
        _builder.append("for (java.util.Iterator it = edges.iterator(); it.hasNext();) {");
        _builder.newLine();
        _builder.append(" \t\t");
        _builder.append("org.eclipse.gmf.runtime.notation.Edge nextEdge = (org.eclipse.gmf.runtime.notation.Edge) it.next();");
        _builder.newLine();
        _builder.append(" \t\t");
        _builder.append("org.eclipse.gmf.runtime.notation.View nextEdgeTarget = nextEdge.getTarget();");
        _builder.newLine();
        _builder.append(" \t\t");
        _builder.append("if (type.equals(nextEdgeTarget.getType()) && isOwnView(nextEdgeTarget)) {");
        _builder.newLine();
        _builder.append(" \t\t\t");
        _builder.append("result.add(nextEdgeTarget);");
        _builder.newLine();
        _builder.append(" \t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append(" \t");
        _builder.append("}");
        _builder.newLine();
        _builder.append(" \t");
        _builder.append("return result;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        CharSequence _generatedMemberComment_2 = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment_2, "");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("private java.util.Collection getOutgoingLinksByType(java.util.Collection nodes, String type) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("java.util.Collection result = new java.util.ArrayList();");
        _builder.newLine();
        _builder.append(" \t");
        _builder.append("for (java.util.Iterator it = nodes.iterator(); it.hasNext();) {");
        _builder.newLine();
        _builder.append(" \t\t");
        _builder.append("org.eclipse.gmf.runtime.notation.View nextNode = (org.eclipse.gmf.runtime.notation.View) it.next();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));");
        _builder.newLine();
        _builder.append(" \t");
        _builder.append("}");
        _builder.newLine();
        _builder.append(" \t");
        _builder.append("return result;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        CharSequence _generatedMemberComment_3 = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment_3, "");
        _builder.newLineIfNotEmpty();
        _builder.append("private java.util.Collection getIncomingLinksByType(java.util.Collection nodes, String type) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("java.util.Collection result = new java.util.ArrayList();");
        _builder.newLine();
        _builder.append(" \t");
        _builder.append("for (java.util.Iterator it = nodes.iterator(); it.hasNext();) {");
        _builder.newLine();
        _builder.append(" \t\t");
        _builder.append("org.eclipse.gmf.runtime.notation.View nextNode = (org.eclipse.gmf.runtime.notation.View) it.next();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));");
        _builder.newLine();
        _builder.append(" \t");
        _builder.append("}");
        _builder.newLine();
        _builder.append(" \t");
        _builder.append("return result;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        CharSequence _generatedMemberComment_4 = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment_4, "");
        _builder.newLineIfNotEmpty();
        _builder.append("private java.util.Collection getChildrenByType(java.util.Collection nodes, String type) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("java.util.Collection result = new java.util.ArrayList();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("for (java.util.Iterator it = nodes.iterator(); it.hasNext();) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("org.eclipse.gmf.runtime.notation.View nextNode = (org.eclipse.gmf.runtime.notation.View) it.next();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("result.addAll(selectViewsByType(nextNode.getChildren(), type));");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return result;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        CharSequence _generatedMemberComment_5 = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment_5, "");
        _builder.newLineIfNotEmpty();
        _builder.append("private java.util.Collection getDiagramLinksByType(java.util.Collection diagrams, String type) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("java.util.Collection result = new java.util.ArrayList();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("for (java.util.Iterator it = diagrams.iterator(); it.hasNext();) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("org.eclipse.gmf.runtime.notation.Diagram nextDiagram = (org.eclipse.gmf.runtime.notation.Diagram) it.next();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("result.addAll(selectViewsByType(nextDiagram.getEdges(), type));");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return result;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        CharSequence _generatedMemberComment_6 = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment_6, "");
        _builder.newLineIfNotEmpty();
        _builder.append("private java.util.Collection selectViewsByType(java.util.Collection views, String type) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("java.util.Collection result = new java.util.ArrayList();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("for (java.util.Iterator it = views.iterator(); it.hasNext();) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("org.eclipse.gmf.runtime.notation.View nextView = (org.eclipse.gmf.runtime.notation.View) it.next();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("if (type.equals(nextView.getType()) && isOwnView(nextView)) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("result.add(nextView);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return result;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        CharSequence _generatedMemberComment_7 = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment_7, "");
        _builder.newLineIfNotEmpty();
        _builder.append("private java.util.Collection createNavigatorItems(java.util.Collection views, Object parent, boolean isLeafs) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("java.util.Collection result = new java.util.ArrayList();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("for (java.util.Iterator it = views.iterator(); it.hasNext();) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("result.add(new ");
        String _navigatorItemQualifiedClassName = it.getNavigatorItemQualifiedClassName();
        _builder.append(_navigatorItemQualifiedClassName, "\t\t");
        _builder.append("((org.eclipse.gmf.runtime.notation.View) it.next(), parent, isLeafs));");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return result;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generatedMemberComment_8 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_8, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("private boolean isOwnView(org.eclipse.gmf.runtime.notation.View view) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return ");
    GenEditorGenerator _editorGen = it.getEditorGen();
    GenDiagram _diagram = _editorGen.getDiagram();
    CharSequence _modelID = VisualIDRegistry.modelID(_diagram);
    _builder.append(_modelID, "\t\t\t");
    _builder.append(".equals(");
    GenEditorGenerator _editorGen_1 = it.getEditorGen();
    GenDiagram _diagram_1 = _editorGen_1.getDiagram();
    CharSequence _modelIDMethodCall = this.xptVisualIDRegistry.getModelIDMethodCall(_diagram_1);
    _builder.append(_modelIDMethodCall, "\t\t\t");
    _builder.append("(view));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.newLine();
    CharSequence _foreignShortcuts = this.getForeignShortcuts(it);
    _builder.append(_foreignShortcuts, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence getForeignShortcuts(final GenNavigator it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _and = false;
      GenEditorGenerator _editorGen = it.getEditorGen();
      GenDiagram _diagram = _editorGen.getDiagram();
      boolean _generateCreateShortcutAction = _diagram.generateCreateShortcutAction();
      if (!_generateCreateShortcutAction) {
        _and = false;
      } else {
        GenEditorGenerator _editorGen_1 = it.getEditorGen();
        GenDiagram _diagram_1 = _editorGen_1.getDiagram();
        Iterable<GenNavigatorChildReference> _childReferencesFrom = this._utils_qvto.getChildReferencesFrom(it, _diagram_1);
        boolean _notEmpty = this._common_qvto.<GenNavigatorChildReference>notEmpty(_childReferencesFrom);
        _and = _notEmpty;
      }
      if (_and) {
        _builder.newLine();
        _builder.append("\t");
        CharSequence _generatedMemberComment = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("private java.util.Collection getForeignShortcuts(org.eclipse.gmf.runtime.notation.Diagram diagram, Object parent) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("java.util.Collection result = new java.util.ArrayList();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("for (java.util.Iterator it = diagram.getChildren().iterator(); it.hasNext();) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("org.eclipse.gmf.runtime.notation.View nextView = (org.eclipse.gmf.runtime.notation.View) it.next();");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("if (!isOwnView(nextView) && nextView.getEAnnotation(\"Shortcut\") != null) { ");
        CharSequence _nonNLS = this._common.nonNLS();
        _builder.append(_nonNLS, "\t\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t\t");
        _builder.append("result.add(nextView);");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return createNavigatorItems(result, parent, false);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence caseNavigatorNode(final GenCommonBase it, final GenNavigator navigator) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case ");
    CharSequence _visualID = VisualIDRegistry.visualID(it);
    _builder.append(_visualID, "\t");
    _builder.append(": {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t\t\t\t\t");
    _builder.append("//modification of the template to avoid mistake of 65kb.");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return getViewChildrenFor");
    String _editPartClassName = it.getEditPartClassName();
    _builder.append(_editPartClassName, "\t\t");
    _builder.append("(view, parentElement);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence createEditingDomain(final GenNavigator it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("org.eclipse.emf.workspace.WorkspaceEditingDomainFactory.INSTANCE.createEditingDomain()");
    return _builder;
  }
  
  public CharSequence genAllMethodNodeCase(final GenNavigator it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Iterable<GenCommonBase> _navigatorContainerNodes = this._utils_qvto.getNavigatorContainerNodes(it);
      for(final GenCommonBase container : _navigatorContainerNodes) {
        CharSequence _caseMethodNodeNode = this.caseMethodNodeNode(container, it);
        _builder.append(_caseMethodNodeNode, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence caseMethodNodeNode(final GenCommonBase it, final GenNavigator navigator) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*Papyrus Template");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*this method is a modification of gmf code in order to avoid  getViewChidreen() method becoming greater than 64kb.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*@generated");
    _builder.newLine();
    _builder.append("**/");
    _builder.newLine();
    _builder.append("private Object[] getViewChildrenFor");
    String _editPartClassName = it.getEditPartClassName();
    _builder.append(_editPartClassName, "");
    _builder.append("(org.eclipse.gmf.runtime.notation.View view, Object parentElement){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("java.util.Collection result = new java.util.ArrayList();");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _addForeignShortcuts = this.addForeignShortcuts(it);
    _builder.append(_addForeignShortcuts, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    Iterable<GenNavigatorChildReference> _references = this._utils_qvto.getChildReferencesFrom(navigator, it);
    _builder.newLineIfNotEmpty();
    {
      Set<String> _groupNames = this._utils_qvto.getGroupNames(_references);
      for(final String groupNames : _groupNames) {
        _builder.append("\t\t");
        CharSequence _initGroupVariables = this.initGroupVariables(groupNames, navigator, _references, "parentElement", it);
        _builder.append(_initGroupVariables, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    {
      boolean _isEmpty = IterableExtensions.isEmpty(_references);
      boolean _not = (!_isEmpty);
      if (_not) {
        {
          int _size = IterableExtensions.size(_references);
          IntegerRange _upTo = new IntegerRange(1, _size);
          for(final Integer referencesIterator : _upTo) {
            _builder.append("\t\t");
            final Iterable<GenNavigatorChildReference> _converted__references = (Iterable<GenNavigatorChildReference>)_references;
            GenNavigatorChildReference reference = ((GenNavigatorChildReference[])Conversions.unwrapArray(_converted__references, GenNavigatorChildReference.class))[((referencesIterator).intValue() - 1)];
            _builder.newLineIfNotEmpty();
            {
              EList<GenNavigatorPath> _findConnectionPaths = reference.findConnectionPaths();
              boolean _isEmpty_1 = _findConnectionPaths.isEmpty();
              boolean _not_1 = (!_isEmpty_1);
              if (_not_1) {
                {
                  EList<GenNavigatorPath> _findConnectionPaths_1 = reference.findConnectionPaths();
                  int _size_1 = _findConnectionPaths_1.size();
                  IntegerRange _upTo_1 = new IntegerRange(1, _size_1);
                  for(final Integer pathsIterator : _upTo_1) {
                    _builder.append("\t\t");
                    _builder.append("\t");
                    EList<GenNavigatorPath> _findConnectionPaths_2 = reference.findConnectionPaths();
                    GenNavigatorPath path = _findConnectionPaths_2.get(((pathsIterator).intValue() - 1));
                    _builder.newLineIfNotEmpty();
                    {
                      EList<GenNavigatorPathSegment> _segments = path.getSegments();
                      boolean _isEmpty_2 = _segments.isEmpty();
                      boolean _not_2 = (!_isEmpty_2);
                      if (_not_2) {
                        {
                          EList<GenNavigatorPathSegment> _segments_1 = path.getSegments();
                          int _size_2 = _segments_1.size();
                          IntegerRange _upTo_2 = new IntegerRange(1, _size_2);
                          for(final Integer segmentsIterator : _upTo_2) {
                            _builder.append("\t\t");
                            _builder.append("\t");
                            EList<GenNavigatorPathSegment> _segments_2 = path.getSegments();
                            GenNavigatorPathSegment segment = _segments_2.get(((segmentsIterator).intValue() - 1));
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            {
                              if (((((referencesIterator).intValue() == 1) && ((pathsIterator).intValue() == 1)) && ((segmentsIterator).intValue() == 1))) {
                                _builder.append("java.util.Collection ");
                              }
                            }
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("connectedViews = ");
                            GenCommonBase _from = segment.getFrom();
                            GenNavigatorReferenceType _referenceType = reference.getReferenceType();
                            CharSequence _childrenMethodName = this.childrenMethodName(_from, _referenceType, segment);
                            _builder.append(_childrenMethodName, "\t\t\t\t");
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append("(");
                            {
                              if (((segmentsIterator).intValue() == 1)) {
                                _builder.append("java.util.Collections.singleton(view)");
                              } else {
                                _builder.append("connectedViews");
                              }
                            }
                            _builder.newLineIfNotEmpty();
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("\t");
                            _builder.append(", ");
                            GenCommonBase _to = segment.getTo();
                            CharSequence _typeMethodCall = this.xptVisualIDRegistry.typeMethodCall(_to);
                            _builder.append(_typeMethodCall, "\t\t\t\t");
                            _builder.append(");");
                            _builder.newLineIfNotEmpty();
                            _builder.newLine();
                          }
                        }
                      }
                    }
                    _builder.append("\t\t");
                    _builder.append("\t");
                    CharSequence _addNavigatorItemsPrefix = this.addNavigatorItemsPrefix(reference);
                    _builder.append(_addNavigatorItemsPrefix, "\t\t\t");
                    _builder.append("connectedViews");
                    GenNavigatorReferenceType _referenceType_1 = reference.getReferenceType();
                    boolean _notEquals = (!Objects.equal(_referenceType_1, GenNavigatorReferenceType.CHILDREN_LITERAL));
                    CharSequence _addNavigatorItemsSuffix = this.addNavigatorItemsSuffix(reference, "parentElement", _notEquals);
                    _builder.append(_addNavigatorItemsSuffix, "\t\t\t");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
          }
        }
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    {
      Set<String> _groupNames_1 = this._utils_qvto.getGroupNames(_references);
      for(final String groupNames_1 : _groupNames_1) {
        _builder.append("\t\t");
        CharSequence _addGroups = this.addGroups(groupNames_1, _references);
        _builder.append(_addGroups, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return result.toArray();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
