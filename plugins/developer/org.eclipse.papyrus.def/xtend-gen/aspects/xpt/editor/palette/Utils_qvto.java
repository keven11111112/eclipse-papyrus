/**
 * Copyright (c) 2006, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.editor.palette;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Singleton;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.codegen.gmfgen.AbstractToolEntry;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.gmf.codegen.gmfgen.ToolEntry;
import org.eclipse.gmf.codegen.gmfgen.ToolGroup;
import org.eclipse.gmf.codegen.gmfgen.ToolGroupItem;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Singleton
@SuppressWarnings("all")
public class Utils_qvto extends xpt.editor.palette.Utils_qvto {
  /**
   * collect all tools availables and valid to generate the palette. A tool is not valid when it does not create either a link or a node
   */
  public Iterable<AbstractToolEntry> collectTools(final Palette palette) {
    Iterable<ToolGroup> _collectGroups = this.collectGroups(palette);
    final Function1<ToolGroup, Iterable<AbstractToolEntry>> _function = new Function1<ToolGroup, Iterable<AbstractToolEntry>>() {
      public Iterable<AbstractToolEntry> apply(final ToolGroup g) {
        EList<ToolGroupItem> _entries = g.getEntries();
        return Iterables.<AbstractToolEntry>filter(_entries, AbstractToolEntry.class);
      }
    };
    Iterable<Iterable<AbstractToolEntry>> _map = IterableExtensions.<ToolGroup, Iterable<AbstractToolEntry>>map(_collectGroups, _function);
    Iterable<AbstractToolEntry> _flatten = Iterables.<AbstractToolEntry>concat(_map);
    final Function1<AbstractToolEntry, Boolean> _function_1 = new Function1<AbstractToolEntry, Boolean>() {
      public Boolean apply(final AbstractToolEntry tool) {
        return Boolean.valueOf(Utils_qvto.this.isValidTool(tool));
      }
    };
    return IterableExtensions.<AbstractToolEntry>filter(_flatten, _function_1);
  }
  
  public boolean isValidTool(final AbstractToolEntry entry) {
    if ((entry instanceof ToolEntry)) {
      EList<GenNode> _genNodes = ((ToolEntry) entry).getGenNodes();
      final int nodes = _genNodes.size();
      EList<GenLink> _genLinks = ((ToolEntry) entry).getGenLinks();
      final int links = _genLinks.size();
      return ((nodes + links) != 0);
    } else {
      return true;
    }
  }
  
  public String getToolPath(final String it) {
    String result = null;
    boolean _isQuoted = this.isQuoted(it, "\"");
    if (_isQuoted) {
      int _length = it.length();
      int _minus = (_length - 1);
      String _substring = it.substring(1, _minus);
      result = _substring;
    } else {
      result = it;
    }
    return ("/" + result);
  }
  
  public boolean isQuoted(final String source, final String quoteStr) {
    boolean _equals = Objects.equal(quoteStr, null);
    if (_equals) {
      return false;
    }
    boolean _and = false;
    boolean _and_1 = false;
    int _length = source.length();
    int _length_1 = quoteStr.length();
    int _multiply = (_length_1 * 2);
    boolean _greaterEqualsThan = (_length >= _multiply);
    if (!_greaterEqualsThan) {
      _and_1 = false;
    } else {
      boolean _startsWith = source.startsWith(quoteStr);
      _and_1 = _startsWith;
    }
    if (!_and_1) {
      _and = false;
    } else {
      boolean _endsWith = source.endsWith(quoteStr);
      _and = _endsWith;
    }
    return _and;
  }
  
  public String getConstantIDName(final String it) {
    boolean _isQuoted = this.isQuoted(it, "\"");
    if (_isQuoted) {
      int _length = it.length();
      int _minus = (_length - 1);
      String _substring = it.substring(1, _minus);
      return this.getUpperAndUnderscoreString(_substring);
    } else {
      return this.getUpperAndUnderscoreString(it);
    }
  }
  
  public String getUpperAndUnderscoreString(final String value) {
    String _upperCase = value.toUpperCase();
    return _upperCase.replace(".", "_");
  }
}
