/**
 * Copyright (c) 2007, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Artem Tikhomirov (Borland) - [257119] Create views directly, not through ViewFactories
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.diagram.views;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Arrays;
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenLabel;
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel;
import org.eclipse.gmf.codegen.gmfgen.Viewmap;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.diagram.ViewmapAttributesUtils_qvto;

/**
 * Renamed from xpt::diagram::views::Utils.xpt
 * in order to have consistent naming between Xtend files migrated from _qvto helpers and xpt templates
 */
@Singleton
@SuppressWarnings("all")
public class ViewStyles extends xpt.diagram.views.ViewStyles {
  @Inject
  @Extension
  private ViewmapAttributesUtils_qvto _viewmapAttributesUtils_qvto;
  
  protected CharSequence _offset(final GenExternalNodeLabel it, final String viewVar) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _or = false;
      Viewmap _viewmap = it.getViewmap();
      int _labelOffsetX = this._viewmapAttributesUtils_qvto.labelOffsetX(_viewmap, 0);
      boolean _notEquals = (_labelOffsetX != 0);
      if (_notEquals) {
        _or = true;
      } else {
        Viewmap _viewmap_1 = it.getViewmap();
        int _labelOffsetY = this._viewmapAttributesUtils_qvto.labelOffsetY(_viewmap_1, 0);
        boolean _notEquals_1 = (_labelOffsetY != 0);
        _or = _notEquals_1;
      }
      if (_or) {
        Viewmap _viewmap_2 = it.getViewmap();
        int _labelOffsetX_1 = this._viewmapAttributesUtils_qvto.labelOffsetX(_viewmap_2, 0);
        Viewmap _viewmap_3 = it.getViewmap();
        int _labelOffsetY_1 = this._viewmapAttributesUtils_qvto.labelOffsetY(_viewmap_3, 0);
        CharSequence _offset = this.offset(it, viewVar, _labelOffsetX_1, _labelOffsetY_1);
        _builder.append(_offset, "");
        _builder.newLineIfNotEmpty();
      } else {
        CharSequence _offset_1 = this.offset(it, viewVar, 0, 5);
        _builder.append(_offset_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence offset(final GenLabel it, final String viewVar) {
    if (it instanceof GenExternalNodeLabel) {
      return _offset((GenExternalNodeLabel)it, viewVar);
    } else if (it instanceof GenLinkLabel) {
      return _offset((GenLinkLabel)it, viewVar);
    } else if (it != null) {
      return _offset(it, viewVar);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, viewVar).toString());
    }
  }
}
