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

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import com.google.inject.Singleton;
import java.util.Iterator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@Singleton
@SuppressWarnings("all")
public class ChildNodeLabelEditPart extends diagram.editparts.ChildNodeLabelEditPart {
  public CharSequence extendsList(final GenChildLabelNode it) {
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
        _builder.append("extends ");
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
            _builder.newLineIfNotEmpty();
            CharSequence _specifyInheritance = this.specifyInheritance(((ExtendedGenView) extendedObject));
            _builder.append(_specifyInheritance, "");
            _builder.newLineIfNotEmpty();
          }
        }
      } else {
        _builder.append("extends org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence specifyInheritance(final ExtendedGenView it) {
    StringConcatenation _builder = new StringConcatenation();
    String _superOwnedEditPart = it.getSuperOwnedEditPart();
    _builder.append(_superOwnedEditPart, "");
    return _builder;
  }
  
  public CharSequence implementsList(final GenChildLabelNode it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("implements org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart, org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart, org.eclipse.papyrus.infra.gmfdiag.common.editpart.IControlParserForDirectEdit");
    return _builder;
  }
}
