/**
 * Copyright (c) 2006, 2009, 2013 Borland Software Corporation and others
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
 */
package aspects.diagram.editparts;

import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Iterator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel;
import org.eclipse.papyrus.papyrusgmfgenextension.LabelVisibilityPreference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import xpt.Common;

@Singleton
@SuppressWarnings("all")
public class LinkLabelEditPart extends diagram.editparts.LinkLabelEditPart {
  @Inject
  @Extension
  private Common _common;
  
  public CharSequence implementsList(final GenLinkLabel it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("implements org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart, org.eclipse.papyrus.infra.gmfdiag.common.editpart.IControlParserForDirectEdit");
    _builder.newLine();
    {
      Resource _eResource = it.eResource();
      TreeIterator<EObject> _allContents = _eResource.getAllContents();
      Iterator<LabelVisibilityPreference> _filter = Iterators.<LabelVisibilityPreference>filter(_allContents, LabelVisibilityPreference.class);
      final Function1<LabelVisibilityPreference, Boolean> _function = new Function1<LabelVisibilityPreference, Boolean>() {
        public Boolean apply(final LabelVisibilityPreference v) {
          EList<GenLinkLabel> _linkLabels = v.getLinkLabels();
          return Boolean.valueOf(_linkLabels.contains(it));
        }
      };
      Iterator<LabelVisibilityPreference> _filter_1 = IteratorExtensions.<LabelVisibilityPreference>filter(_filter, _function);
      int _size = IteratorExtensions.size(_filter_1);
      boolean _notEquals = (_size != 0);
      if (_notEquals) {
        _builder.append(", org.eclipse.papyrus.uml.diagram.common.editparts.ILabelRoleProvider");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence additions(final GenLinkLabel it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Resource _eResource = it.eResource();
      TreeIterator<EObject> _allContents = _eResource.getAllContents();
      Iterator<LabelVisibilityPreference> _filter = Iterators.<LabelVisibilityPreference>filter(_allContents, LabelVisibilityPreference.class);
      final Function1<LabelVisibilityPreference, Boolean> _function = new Function1<LabelVisibilityPreference, Boolean>() {
        public Boolean apply(final LabelVisibilityPreference v) {
          EList<GenLinkLabel> _linkLabels = v.getLinkLabels();
          return Boolean.valueOf(_linkLabels.contains(it));
        }
      };
      Iterator<LabelVisibilityPreference> _filter_1 = IteratorExtensions.<LabelVisibilityPreference>filter(_filter, _function);
      int _size = IteratorExtensions.size(_filter_1);
      boolean _notEquals = (_size != 0);
      if (_notEquals) {
        CharSequence _generatedClassComment = this._common.generatedClassComment();
        _builder.append(_generatedClassComment, "");
        _builder.newLineIfNotEmpty();
        _builder.append("public String getLabelRole(){");
        _builder.newLine();
        _builder.append("return \"");
        Resource _eResource_1 = it.eResource();
        TreeIterator<EObject> _allContents_1 = _eResource_1.getAllContents();
        Iterator<LabelVisibilityPreference> _filter_2 = Iterators.<LabelVisibilityPreference>filter(_allContents_1, LabelVisibilityPreference.class);
        final Function1<LabelVisibilityPreference, Boolean> _function_1 = new Function1<LabelVisibilityPreference, Boolean>() {
          public Boolean apply(final LabelVisibilityPreference v) {
            EList<GenLinkLabel> _linkLabels = v.getLinkLabels();
            return Boolean.valueOf(_linkLabels.contains(it));
          }
        };
        Iterator<LabelVisibilityPreference> _filter_3 = IteratorExtensions.<LabelVisibilityPreference>filter(_filter_2, _function_1);
        LabelVisibilityPreference _head = IteratorExtensions.<LabelVisibilityPreference>head(_filter_3);
        String _role = _head.getRole();
        _builder.append(_role, "");
        _builder.append("\";//$NON-NLS-1$");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        CharSequence _generatedClassComment_1 = this._common.generatedClassComment();
        _builder.append(_generatedClassComment_1, "");
        _builder.newLineIfNotEmpty();
        _builder.append("public String getIconPathRole(){");
        _builder.newLine();
        _builder.append("return \"");
        Resource _eResource_2 = it.eResource();
        TreeIterator<EObject> _allContents_2 = _eResource_2.getAllContents();
        Iterator<LabelVisibilityPreference> _filter_4 = Iterators.<LabelVisibilityPreference>filter(_allContents_2, LabelVisibilityPreference.class);
        final Function1<LabelVisibilityPreference, Boolean> _function_2 = new Function1<LabelVisibilityPreference, Boolean>() {
          public Boolean apply(final LabelVisibilityPreference v) {
            EList<GenLinkLabel> _linkLabels = v.getLinkLabels();
            return Boolean.valueOf(_linkLabels.contains(it));
          }
        };
        Iterator<LabelVisibilityPreference> _filter_5 = IteratorExtensions.<LabelVisibilityPreference>filter(_filter_4, _function_2);
        LabelVisibilityPreference _head_1 = IteratorExtensions.<LabelVisibilityPreference>head(_filter_5);
        String _iconPathRole = _head_1.getIconPathRole();
        _builder.append(_iconPathRole, "");
        _builder.append("\";//$NON-NLS-1$");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence extendsList(final GenLinkLabel it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("extends org.eclipse.papyrus.infra.gmfdiag.common.editpart.PapyrusLabelEditPart");
    return _builder;
  }
}
