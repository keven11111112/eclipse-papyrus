package aspects.xpt.plugin;

import aspects.xpt.editor.palette.Utils_qvto;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.codegen.gmfgen.AbstractToolEntry;
import org.eclipse.gmf.codegen.gmfgen.GenApplication;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenDiagramUpdater;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenMetricContainer;
import org.eclipse.gmf.codegen.gmfgen.GenNavigator;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.gmf.codegen.gmfgen.GenPropertySheet;
import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.gmf.codegen.gmfgen.ToolEntry;
import org.eclipse.gmf.codegen.gmfgen.ToolGroup;
import org.eclipse.gmf.codegen.gmfgen.ToolGroupItem;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import xpt.Common;
import xpt.editor.extensions;
import xpt.plugin.pluginUtils;

@Singleton
@SuppressWarnings("all")
public class plugin extends xpt.plugin.plugin {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private pluginUtils _pluginUtils;
  
  @Inject
  @Extension
  private Utils_qvto _utils_qvto;
  
  @Inject
  private extensions xptEditorExtension;
  
  @Inject
  private xpt.diagram.preferences.extensions xptPreferencesExtension;
  
  @Inject
  private xpt.propsheet.extensions xptPropsheetExtension;
  
  @Inject
  private xpt.navigator.extensions xptNavigatorExtension;
  
  @Inject
  private xpt.application.extensions xptApplicationExtension;
  
  @Inject
  private xpt.diagram.updater.extensions xptUpdaterExtension;
  
  @Inject
  private impl.actions.extensions xptActionExtension;
  
  @Inject
  private xpt.providers.extensions xptProvidersExtension;
  
  public CharSequence plugin(final GenPlugin it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<?eclipse version=\"3.0\"?>");
    _builder.newLine();
    GenEditorGenerator _editorGen = it.getEditorGen();
    CharSequence _xcopyright = this._common.xcopyright(_editorGen);
    _builder.append(_xcopyright, "");
    _builder.newLineIfNotEmpty();
    _builder.append("<plugin>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    GenEditorGenerator _editorGen_1 = it.getEditorGen();
    CharSequence _extensions = this.xptEditorExtension.extensions(_editorGen_1);
    _builder.append(_extensions, "\t\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    GenEditorGenerator _editorGen_2 = it.getEditorGen();
    GenDiagram _diagram = _editorGen_2.getDiagram();
    CharSequence _validation = this.validation(_diagram);
    _builder.append(_validation, "\t\t\t\t");
    _builder.newLineIfNotEmpty();
    {
      GenEditorGenerator _editorGen_3 = it.getEditorGen();
      GenMetricContainer _metrics = _editorGen_3.getMetrics();
      boolean _notEquals = (!Objects.equal(_metrics, null));
      if (_notEquals) {
        GenEditorGenerator _editorGen_4 = it.getEditorGen();
        GenMetricContainer _metrics_1 = _editorGen_4.getMetrics();
        CharSequence _metrics_2 = this.metrics(_metrics_1);
        _builder.append(_metrics_2, "");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    GenEditorGenerator _editorGen_5 = it.getEditorGen();
    CharSequence _palettePredefinedEntries = this.palettePredefinedEntries(_editorGen_5);
    _builder.append(_palettePredefinedEntries, "\t\t");
    _builder.newLineIfNotEmpty();
    GenEditorGenerator _editorGen_6 = it.getEditorGen();
    CharSequence _paletteEntries = this.paletteEntries(_editorGen_6);
    _builder.append(_paletteEntries, "");
    _builder.newLineIfNotEmpty();
    GenEditorGenerator _editorGen_7 = it.getEditorGen();
    GenDiagram _diagram_1 = _editorGen_7.getDiagram();
    CharSequence _extensions_1 = this.xptPreferencesExtension.extensions(_diagram_1);
    _builder.append(_extensions_1, "");
    _builder.newLineIfNotEmpty();
    {
      GenEditorGenerator _editorGen_8 = it.getEditorGen();
      GenPropertySheet _propertySheet = _editorGen_8.getPropertySheet();
      boolean _notEquals_1 = (!Objects.equal(_propertySheet, null));
      if (_notEquals_1) {
        GenEditorGenerator _editorGen_9 = it.getEditorGen();
        GenPropertySheet _propertySheet_1 = _editorGen_9.getPropertySheet();
        CharSequence _extensions_2 = this.xptPropsheetExtension.extensions(_propertySheet_1);
        _builder.append(_extensions_2, "");
      }
    }
    _builder.newLineIfNotEmpty();
    GenEditorGenerator _editorGen_10 = it.getEditorGen();
    GenDiagram _diagram_2 = _editorGen_10.getDiagram();
    CharSequence _extensions_3 = this.xptProvidersExtension.extensions(_diagram_2);
    _builder.append(_extensions_3, "");
    _builder.newLineIfNotEmpty();
    {
      GenEditorGenerator _editorGen_11 = it.getEditorGen();
      GenNavigator _navigator = _editorGen_11.getNavigator();
      boolean _notEquals_2 = (!Objects.equal(_navigator, null));
      if (_notEquals_2) {
        GenEditorGenerator _editorGen_12 = it.getEditorGen();
        GenNavigator _navigator_1 = _editorGen_12.getNavigator();
        CharSequence _extensions_4 = this.xptNavigatorExtension.extensions(_navigator_1);
        _builder.append(_extensions_4, "");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      GenEditorGenerator _editorGen_13 = it.getEditorGen();
      GenApplication _application = _editorGen_13.getApplication();
      boolean _notEquals_3 = (!Objects.equal(_application, null));
      if (_notEquals_3) {
        GenEditorGenerator _editorGen_14 = it.getEditorGen();
        GenApplication _application_1 = _editorGen_14.getApplication();
        CharSequence _extensions_5 = this.xptApplicationExtension.extensions(_application_1);
        _builder.append(_extensions_5, "");
      }
    }
    _builder.newLineIfNotEmpty();
    GenEditorGenerator _editorGen_15 = it.getEditorGen();
    CharSequence _extensionsConstraintProviders = this._pluginUtils.extensionsConstraintProviders(_editorGen_15);
    _builder.append(_extensionsConstraintProviders, "");
    _builder.newLineIfNotEmpty();
    GenEditorGenerator _editorGen_16 = it.getEditorGen();
    GenDiagramUpdater _diagramUpdater = _editorGen_16.getDiagramUpdater();
    CharSequence _extensions_6 = this.xptUpdaterExtension.extensions(_diagramUpdater);
    _builder.append(_extensions_6, "");
    _builder.newLineIfNotEmpty();
    GenEditorGenerator _editorGen_17 = it.getEditorGen();
    CharSequence _Main = this.xptActionExtension.Main(_editorGen_17);
    _builder.append(_Main, "");
    _builder.newLineIfNotEmpty();
    CharSequence _additions = this.additions(it);
    _builder.append(_additions, "");
    _builder.newLineIfNotEmpty();
    _builder.append("</plugin>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence additions(final GenPlugin it) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  public CharSequence palettePredefinedEntries(final GenEditorGenerator it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _xmlGeneratedTag = this._common.xmlGeneratedTag();
    _builder.append(_xmlGeneratedTag, "");
    _builder.newLineIfNotEmpty();
    _builder.append("<extension");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("id=\"");
    GenPlugin _plugin = it.getPlugin();
    String _name = _plugin.getName();
    _builder.append(_name, "\t");
    _builder.append(".palettedefinition\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("name=\"");
    GenPlugin _plugin_1 = it.getPlugin();
    String _name_1 = _plugin_1.getName();
    _builder.append(_name_1, "\t");
    _builder.append(" Predefined Entries\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("point=\"org.eclipse.gmf.runtime.diagram.ui.paletteProviders\"> ");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _xmlGeneratedTag_1 = this._common.xmlGeneratedTag();
    _builder.append(_xmlGeneratedTag_1, "\t");
    _builder.append("\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<paletteProvider class=\"org.eclipse.gmf.runtime.diagram.ui.providers.DefaultPaletteProvider\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<Priority name=\"Lowest\"/>");
    _builder.newLine();
    _builder.append("\t\t   \t\t");
    _builder.append("<contribution");
    _builder.newLine();
    _builder.append("\t\t   \t\t    \t");
    _builder.append("factoryClass=\"");
    GenDiagram _diagram = it.getDiagram();
    Palette _palette = _diagram.getPalette();
    String _packageName = _palette.getPackageName();
    _builder.append(_packageName, "\t\t   \t\t    \t");
    _builder.append(".");
    GenDiagram _diagram_1 = it.getDiagram();
    Palette _palette_1 = _diagram_1.getPalette();
    String _factoryClassName = _palette_1.getFactoryClassName();
    _builder.append(_factoryClassName, "\t\t   \t\t    \t");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t   \t\t");
    _builder.append("<predefinedEntry id=\"standardGroup/noteStack/noteTool\" remove=\"true\"/> ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<predefinedEntry id=\"standardGroup/noteStack/textTool\" remove=\"true\"/> ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<predefinedEntry id=\"standardGroup/noteStack/noteattachmentTool\" remove=\"true\"/>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    {
      GenDiagram _diagram_2 = it.getDiagram();
      Palette _palette_2 = _diagram_2.getPalette();
      Iterable<AbstractToolEntry> _collectTools = this._utils_qvto.collectTools(_palette_2);
      for(final AbstractToolEntry tool : _collectTools) {
        _builder.append("\t\t");
        CharSequence _predefinedEntryDefinition = this.predefinedEntryDefinition(tool);
        _builder.append(_predefinedEntryDefinition, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</contribution>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</paletteProvider>\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("</extension>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence paletteEntries(final GenEditorGenerator it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _xmlGeneratedTag = this._common.xmlGeneratedTag();
    _builder.append(_xmlGeneratedTag, "");
    _builder.newLineIfNotEmpty();
    _builder.append("<extension");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("id=\"");
    GenPlugin _plugin = it.getPlugin();
    String _name = _plugin.getName();
    _builder.append(_name, "\t");
    _builder.append(".standard\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("name=\"");
    GenPlugin _plugin_1 = it.getPlugin();
    String _name_1 = _plugin_1.getName();
    _builder.append(_name_1, "\t");
    _builder.append(" Standard Palette\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("point=\"org.eclipse.gmf.runtime.diagram.ui.paletteProviders\"> ");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _xmlGeneratedTag_1 = this._common.xmlGeneratedTag();
    _builder.append(_xmlGeneratedTag_1, "\t");
    _builder.append("\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<paletteProvider class=\"org.eclipse.gmf.runtime.diagram.ui.providers.DefaultPaletteProvider\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<Priority name=\"Low\"/>");
    _builder.newLine();
    _builder.append("\t\t   \t\t");
    _builder.append("<contribution");
    _builder.newLine();
    _builder.append("\t\t   \t\t    \t");
    _builder.append("factoryClass=\"");
    GenDiagram _diagram = it.getDiagram();
    Palette _palette = _diagram.getPalette();
    String _packageName = _palette.getPackageName();
    _builder.append(_packageName, "\t\t   \t\t    \t");
    _builder.append(".");
    GenDiagram _diagram_1 = it.getDiagram();
    Palette _palette_1 = _diagram_1.getPalette();
    String _factoryClassName = _palette_1.getFactoryClassName();
    _builder.append(_factoryClassName, "\t\t   \t\t    \t");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t   \t\t");
    _builder.append("<predefinedEntry id=\"standardGroup/noteStack/noteTool\" remove=\"true\"/> ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<predefinedEntry id=\"standardGroup/noteStack/textTool\" remove=\"true\"/> ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<predefinedEntry id=\"standardGroup/noteStack/noteattachmentTool\" remove=\"true\"/>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    {
      GenDiagram _diagram_2 = it.getDiagram();
      Palette _palette_2 = _diagram_2.getPalette();
      EList<ToolGroup> _groups = _palette_2.getGroups();
      for(final ToolGroup tool : _groups) {
        _builder.append("\t\t");
        CharSequence _groupUsage = this.groupUsage(tool);
        _builder.append(_groupUsage, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("</contribution>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<editor id=\"");
    GenPlugin _plugin_2 = it.getPlugin();
    String _iD = _plugin_2.getID();
    _builder.append(_iD, "\t\t");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</paletteProvider>\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("</extension>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence groupUsage(final ToolGroup it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<entry");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("description=\"");
    String _description = it.getDescription();
    _builder.append(_description, "      ");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("      ");
    _builder.append("id=");
    {
      String _id = it.getId();
      boolean _isQuoted = this._utils_qvto.isQuoted(_id, "\"");
      if (_isQuoted) {
        String _id_1 = it.getId();
        _builder.append(_id_1, "      ");
      } else {
        _builder.append("\"");
        String _id_2 = it.getId();
        _builder.append(_id_2, "      ");
        _builder.append("\"");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("      ");
    _builder.append("kind=\"");
    {
      boolean _and = false;
      boolean _isStack = it.isStack();
      if (!_isStack) {
        _and = false;
      } else {
        boolean _isToolsOnly = it.isToolsOnly();
        _and = _isToolsOnly;
      }
      if (_and) {
        _builder.append("stack");
      } else {
        _builder.append("drawer");
      }
    }
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("      ");
    _builder.append("label=\"");
    String _title = it.getTitle();
    _builder.append(_title, "      ");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("      ");
    _builder.append("large_icon=\"");
    String _largeIconPath = it.getLargeIconPath();
    _builder.append(_largeIconPath, "      ");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("      ");
    _builder.append("path=\"");
    String _path = this.getPath(it);
    _builder.append(_path, "      ");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("      ");
    _builder.append("small_icon=\"");
    String _smallIconPath = it.getSmallIconPath();
    _builder.append(_smallIconPath, "      ");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("   ");
    _builder.append("<expand");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("force=\"true\">");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("</expand>");
    _builder.newLine();
    _builder.append("</entry>");
    _builder.newLine();
    {
      EList<ToolGroupItem> _entries = it.getEntries();
      final Function1<ToolGroupItem, Boolean> _function = new Function1<ToolGroupItem, Boolean>() {
        public Boolean apply(final ToolGroupItem e) {
          return Boolean.valueOf((e instanceof ToolEntry));
        }
      };
      Iterable<ToolGroupItem> _filter = IterableExtensions.<ToolGroupItem>filter(_entries, _function);
      for(final ToolGroupItem entry : _filter) {
        CharSequence _olUsage = this.toolUsage(entry, it);
        _builder.append(_olUsage, "");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<ToolGroupItem> _entries_1 = it.getEntries();
      final Function1<ToolGroupItem, Boolean> _function_1 = new Function1<ToolGroupItem, Boolean>() {
        public Boolean apply(final ToolGroupItem e) {
          return Boolean.valueOf((e instanceof ToolGroup));
        }
      };
      Iterable<ToolGroupItem> _filter_1 = IterableExtensions.<ToolGroupItem>filter(_entries_1, _function_1);
      for(final ToolGroupItem entry_1 : _filter_1) {
        CharSequence _olUsage_1 = this.toolUsage(entry_1, it);
        _builder.append(_olUsage_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  private String getPath(final ToolEntry it) {
    EObject _eContainer = it.eContainer();
    return this.buildPath(_eContainer);
  }
  
  private String getPath(final ToolGroup it) {
    EObject _eContainer = it.eContainer();
    return this.buildPath(_eContainer);
  }
  
  private String buildPath(final EObject it) {
    StringBuilder path = new StringBuilder();
    EObject container = it;
    while ((container instanceof ToolGroup)) {
      {
        String _id = ((ToolGroup) container).getId();
        String _toolPath = this._utils_qvto.getToolPath(_id);
        path.insert(0, _toolPath);
        EObject _eContainer = ((ToolGroup)container).eContainer();
        container = _eContainer;
      }
    }
    String _xifexpression = null;
    int _length = path.length();
    boolean _notEquals = (_length != 0);
    if (_notEquals) {
      _xifexpression = path.toString();
    } else {
      _xifexpression = "/";
    }
    return _xifexpression;
  }
  
  protected CharSequence _toolUsage(final ToolEntry it, final ToolGroup group) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<predefinedEntry");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("id=");
    {
      String _id = it.getId();
      boolean _isQuoted = this._utils_qvto.isQuoted(_id, "\"");
      if (_isQuoted) {
        String _id_1 = it.getId();
        _builder.append(_id_1, "        ");
      } else {
        _builder.append("\"");
        String _id_2 = it.getId();
        _builder.append(_id_2, "        ");
        _builder.append("\"");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("path=\"");
    String _path = this.getPath(it);
    _builder.append(_path, "\t\t");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("</predefinedEntry>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _toolUsage(final ToolGroup it, final ToolGroup group) {
    StringConcatenation _builder = new StringConcatenation();
    Object _groupUsage = this.groupUsage(it);
    _builder.append(_groupUsage, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence predefinedEntryDefinition(final AbstractToolEntry it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<entry");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("defineOnly=\"true\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("description=\"");
    String _description = it.getDescription();
    _builder.append(_description, "      ");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("      ");
    _builder.append("id=");
    {
      String _id = it.getId();
      boolean _isQuoted = this._utils_qvto.isQuoted(_id, "\"");
      if (_isQuoted) {
        String _id_1 = it.getId();
        _builder.append(_id_1, "      ");
      } else {
        _builder.append("\"");
        String _id_2 = it.getId();
        _builder.append(_id_2, "      ");
        _builder.append("\"");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("      ");
    _builder.append("kind=\"tool\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("label=\"");
    String _title = it.getTitle();
    _builder.append(_title, "      ");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("      ");
    _builder.append("large_icon=\"");
    String _largeIconPath = it.getLargeIconPath();
    _builder.append(_largeIconPath, "      ");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("      ");
    _builder.append("path=\"\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("small_icon=\"");
    String _smallIconPath = it.getSmallIconPath();
    _builder.append(_smallIconPath, "      ");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</entry>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence toolUsage(final EObject it, final ToolGroup group) {
    if (it instanceof ToolEntry) {
      return _toolUsage((ToolEntry)it, group);
    } else if (it instanceof ToolGroup) {
      return _toolUsage((ToolGroup)it, group);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, group).toString());
    }
  }
}
