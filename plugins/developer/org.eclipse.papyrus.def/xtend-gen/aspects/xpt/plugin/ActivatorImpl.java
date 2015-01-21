package aspects.xpt.plugin;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderBase;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderContainer;
import org.eclipse.gmf.codegen.gmfgen.GenLanguage;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import plugin.Activator;
import xpt.Common;
import xpt.editor.DocumentProvider;
import xpt.expressions.getExpression;
import xpt.providers.ElementInitializers;

@Singleton
@SuppressWarnings("all")
public class ActivatorImpl extends xpt.plugin.ActivatorImpl {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  private Activator xptActivator;
  
  @Inject
  private DocumentProvider xptDocProvider;
  
  @Inject
  private ElementInitializers xptElementInitializers;
  
  @Inject
  private getExpression xptExpr;
  
  public CharSequence ActivatorImpl(final GenPlugin it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    GenEditorGenerator _editorGen = it.getEditorGen();
    CharSequence _copyright = this._common.copyright(_editorGen);
    _builder.append(_copyright, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("package ");
    CharSequence _packageName = this.xptActivator.packageName(it);
    _builder.append(_packageName, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedClassComment = this._common.generatedClassComment();
    _builder.append(_generatedClassComment, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public class ");
    CharSequence _className = this.xptActivator.className(it);
    _builder.append(_className, "\t");
    _builder.append(" extends org.eclipse.ui.plugin.AbstractUIPlugin {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _attrs = this.attrs(it);
    _builder.append(_attrs, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _constructor = this.constructor(it);
    _builder.append(_constructor, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _start = this.start(it);
    _builder.append(_start, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    GenEditorGenerator _editorGen_1 = it.getEditorGen();
    CharSequence _stop = this.stop(_editorGen_1);
    _builder.append(_stop, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _instance = this.getInstance(it);
    _builder.append(_instance, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _preferenceStore = this.getPreferenceStore();
    _builder.append(_preferenceStore, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _itemProvidersAdaptorFactory = this.getItemProvidersAdaptorFactory(it);
    _builder.append(_itemProvidersAdaptorFactory, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _itemImageDescriptor = this.getItemImageDescriptor(it);
    _builder.append(_itemImageDescriptor, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _bundleDescriptorImage = this.getBundleDescriptorImage(it);
    _builder.append(_bundleDescriptorImage, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _findImageDescriptor = this.findImageDescriptor(it);
    _builder.append(_findImageDescriptor, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _bundleImage = this.getBundleImage(it);
    _builder.append(_bundleImage, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _string = this.getString(it);
    _builder.append(_string, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    GenEditorGenerator _editorGen_2 = it.getEditorGen();
    GenDiagram _diagram = _editorGen_2.getDiagram();
    CharSequence _documentProviderGetter = this.documentProviderGetter(_diagram);
    _builder.append(_documentProviderGetter, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    GenEditorGenerator _editorGen_3 = it.getEditorGen();
    GenDiagram _diagram_1 = _editorGen_3.getDiagram();
    CharSequence _linkConstraint = this.linkConstraint(_diagram_1);
    _builder.append(_linkConstraint, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    GenEditorGenerator _editorGen_4 = it.getEditorGen();
    GenDiagram _diagram_2 = _editorGen_4.getDiagram();
    CharSequence _initializerGetter = this.initializerGetter(_diagram_2);
    _builder.append(_initializerGetter, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    GenEditorGenerator _editorGen_5 = it.getEditorGen();
    GenDiagram _diagram_3 = _editorGen_5.getDiagram();
    CharSequence _initializerSetter = this.initializerSetter(_diagram_3);
    _builder.append(_initializerSetter, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _providersAccessMethods = this.providersAccessMethods(it);
    _builder.append(_providersAccessMethods, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _logError = this.logError(it);
    _builder.append(_logError, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _logInfo = this.logInfo(it);
    _builder.append(_logInfo, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _logError_1 = this.getLogError(it);
    _builder.append(_logError_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _additions = this.additions(it);
    _builder.append(_additions, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence attrs(final GenPlugin it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public static final String ID = \"");
    String _iD = it.getID();
    _builder.append(_iD, "");
    _builder.append("\"; //$NON-NLS-1$");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _generatedMemberComment_1 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_1, "");
    _builder.newLineIfNotEmpty();
    _builder.append("private org.eclipse.papyrus.infra.core.log.LogHelper myLogHelper;");
    _builder.newLine();
    _builder.newLine();
    CharSequence _generatedMemberComment_2 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_2, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public static final org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint DIAGRAM_PREFERENCES_HINT =");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint(ID);");
    _builder.newLine();
    _builder.newLine();
    CharSequence _generatedMemberComment_3 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_3, "");
    _builder.newLineIfNotEmpty();
    _builder.append("private static ");
    CharSequence _className = this.xptActivator.className(it);
    _builder.append(_className, "");
    _builder.append(" instance;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _generatedMemberComment_4 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_4, "");
    _builder.newLineIfNotEmpty();
    _builder.append("private org.eclipse.emf.common.notify.AdapterFactory adapterFactory;");
    _builder.newLine();
    _builder.newLine();
    CharSequence _generatedMemberComment_5 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_5, "");
    _builder.newLineIfNotEmpty();
    _builder.append("private ");
    GenEditorGenerator _editorGen = it.getEditorGen();
    GenDiagram _diagram = _editorGen.getDiagram();
    CharSequence _qualifiedClassName = this.xptDocProvider.qualifiedClassName(_diagram);
    _builder.append(_qualifiedClassName, "");
    _builder.append(" documentProvider;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      GenEditorGenerator _editorGen_1 = it.getEditorGen();
      GenDiagram _diagram_1 = _editorGen_1.getDiagram();
      EList<GenLink> _links = _diagram_1.getLinks();
      final Function1<GenLink, Boolean> _function = new Function1<GenLink, Boolean>() {
        public Boolean apply(final GenLink l) {
          boolean _isSansDomain = l.isSansDomain();
          return Boolean.valueOf((!_isSansDomain));
        }
      };
      boolean _exists = IterableExtensions.<GenLink>exists(_links, _function);
      if (_exists) {
        CharSequence _generatedMemberComment_6 = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment_6, "");
        _builder.newLineIfNotEmpty();
        _builder.append("private ");
        GenEditorGenerator _editorGen_2 = it.getEditorGen();
        GenDiagram _diagram_2 = _editorGen_2.getDiagram();
        String _linkCreationConstraintsQualifiedClassName = _diagram_2.getLinkCreationConstraintsQualifiedClassName();
        _builder.append(_linkCreationConstraintsQualifiedClassName, "");
        _builder.append(" linkConstraints;");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    CharSequence _generatedMemberComment_7 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_7, "");
    _builder.newLineIfNotEmpty();
    _builder.append("private ");
    GenEditorGenerator _editorGen_3 = it.getEditorGen();
    GenDiagram _diagram_3 = _editorGen_3.getDiagram();
    CharSequence _qualifiedClassName_1 = this.xptElementInitializers.qualifiedClassName(_diagram_3);
    _builder.append(_qualifiedClassName_1, "");
    _builder.append(" initializers;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      GenEditorGenerator _editorGen_4 = it.getEditorGen();
      GenExpressionProviderContainer _expressionProviders = _editorGen_4.getExpressionProviders();
      boolean _notEquals = (!Objects.equal(_expressionProviders, null));
      if (_notEquals) {
        {
          GenEditorGenerator _editorGen_5 = it.getEditorGen();
          GenExpressionProviderContainer _expressionProviders_1 = _editorGen_5.getExpressionProviders();
          EList<GenExpressionProviderBase> _providers = _expressionProviders_1.getProviders();
          Iterable<GenExpressionInterpreter> _filter = Iterables.<GenExpressionInterpreter>filter(_providers, GenExpressionInterpreter.class);
          for(final GenExpressionInterpreter p : _filter) {
            CharSequence _generatedMemberComment_8 = this._common.generatedMemberComment();
            _builder.append(_generatedMemberComment_8, "");
            _builder.newLineIfNotEmpty();
            _builder.append("private ");
            CharSequence _expressionInterpriterQualifiedClassName = this.xptExpr.getExpressionInterpriterQualifiedClassName(p);
            _builder.append(_expressionInterpriterQualifiedClassName, "");
            _builder.append(" ");
            GenLanguage _language = p.getLanguage();
            _builder.append(_language, "");
            _builder.append("Factory;");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence start(final GenPlugin it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public void start(org.osgi.framework.BundleContext context) throws Exception {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("super.start(context);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("instance = this;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("myLogHelper = new org.eclipse.papyrus.infra.core.log.LogHelper(this);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint.registerPreferenceStore(DIAGRAM_PREFERENCES_HINT, getPreferenceStore());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("adapterFactory = org.eclipse.papyrus.infra.gmfdiag.common.Activator.getInstance().getItemProvidersAdapterFactory();");
    _builder.newLine();
    _builder.append("\t");
    GenEditorGenerator _editorGen = it.getEditorGen();
    GenDiagram _diagram = _editorGen.getDiagram();
    String _preferencesPackageName = _diagram.getPreferencesPackageName();
    _builder.append(_preferencesPackageName, "\t");
    _builder.append(".DiagramPreferenceInitializer diagramPreferenceInitializer = new ");
    GenEditorGenerator _editorGen_1 = it.getEditorGen();
    GenDiagram _diagram_1 = _editorGen_1.getDiagram();
    String _preferencesPackageName_1 = _diagram_1.getPreferencesPackageName();
    _builder.append(_preferencesPackageName_1, "\t");
    _builder.append(".DiagramPreferenceInitializer();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("diagramPreferenceInitializer.initializeDefaultPreferences();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence stop(final GenEditorGenerator it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public void stop(org.osgi.framework.BundleContext context) throws Exception {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("adapterFactory = null;");
    _builder.newLine();
    {
      GenDiagram _diagram = it.getDiagram();
      EList<GenLink> _links = _diagram.getLinks();
      final Function1<GenLink, Boolean> _function = new Function1<GenLink, Boolean>() {
        public Boolean apply(final GenLink l) {
          boolean _isSansDomain = l.isSansDomain();
          return Boolean.valueOf((!_isSansDomain));
        }
      };
      boolean _exists = IterableExtensions.<GenLink>exists(_links, _function);
      if (_exists) {
        _builder.append("    ");
        _builder.append("linkConstraints = null;");
        _builder.newLine();
      }
    }
    _builder.append("    ");
    _builder.append("initializers = null;");
    _builder.newLine();
    {
      GenExpressionProviderContainer _expressionProviders = it.getExpressionProviders();
      boolean _notEquals = (!Objects.equal(_expressionProviders, null));
      if (_notEquals) {
        {
          GenExpressionProviderContainer _expressionProviders_1 = it.getExpressionProviders();
          EList<GenExpressionProviderBase> _providers = _expressionProviders_1.getProviders();
          Iterable<GenExpressionInterpreter> _filter = Iterables.<GenExpressionInterpreter>filter(_providers, GenExpressionInterpreter.class);
          for(final GenExpressionInterpreter p : _filter) {
            _builder.append("    ");
            GenLanguage _language = p.getLanguage();
            _builder.append(_language, "    ");
            _builder.append("Factory = null;");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("    ");
    _builder.append("instance = null;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("super.stop(context);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getPreferenceStore() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("public org.eclipse.jface.preference.IPreferenceStore getPreferenceStore() {");
    _builder.newLine();
    _builder.append(" \t");
    _builder.append("org.eclipse.jface.preference.IPreferenceStore store=org.eclipse.papyrus.infra.gmfdiag.preferences.Activator.getDefault().getPreferenceStore();");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("return store;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence logError(final GenPlugin it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public void logError(String error) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("getLogHelper().warn(error);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    CharSequence _generatedMemberComment_1 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_1, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public void logError(String error, Throwable throwable) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("getLogHelper().error(error, throwable);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence logInfo(final GenPlugin it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public void logInfo(String message) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("getLogHelper().info(message);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    CharSequence _generatedMemberComment_1 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_1, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public void logInfo(String message, Throwable throwable) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("getLogHelper().error(message, throwable);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getLogError(final GenPlugin it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public org.eclipse.papyrus.infra.core.log.LogHelper getLogHelper() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return myLogHelper;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
