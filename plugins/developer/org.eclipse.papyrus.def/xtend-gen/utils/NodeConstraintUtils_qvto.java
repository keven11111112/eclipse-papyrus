/**
 * Copyright (c) 2010 CEA LIST
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Yann Tanguy (CEA LIST) - initial API and implementation
 */
package utils;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import com.google.inject.Singleton;
import java.util.Iterator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.codegen.gmfgen.GenConstraint;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.papyrus.papyrusgmfgenextension.GenNodeConstraint;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@Singleton
@SuppressWarnings("all")
public class NodeConstraintUtils_qvto {
  public boolean hasNodeCreationConstraint(final GenNode it) {
    Resource _eResource = it.eResource();
    TreeIterator<EObject> _allContents = _eResource.getAllContents();
    Iterator<GenNodeConstraint> _filter = Iterators.<GenNodeConstraint>filter(_allContents, GenNodeConstraint.class);
    final Function1<GenNodeConstraint, Boolean> _function = new Function1<GenNodeConstraint, Boolean>() {
      public Boolean apply(final GenNodeConstraint v) {
        boolean _and = false;
        EList<GenNode> _genNode = v.getGenNode();
        boolean _contains = _genNode.contains(it);
        if (!_contains) {
          _and = false;
        } else {
          GenConstraint _genConstraint = v.getGenConstraint();
          boolean _notEquals = (!Objects.equal(_genConstraint, null));
          _and = _notEquals;
        }
        return Boolean.valueOf(_and);
      }
    };
    Iterator<GenNodeConstraint> _filter_1 = IteratorExtensions.<GenNodeConstraint>filter(_filter, _function);
    int _size = IteratorExtensions.size(_filter_1);
    return (_size != 0);
  }
  
  public GenNodeConstraint getNodeCreationConstraint(final GenNode it) {
    boolean _hasNodeCreationConstraint = this.hasNodeCreationConstraint(it);
    if (_hasNodeCreationConstraint) {
      Resource _eResource = it.eResource();
      TreeIterator<EObject> _allContents = _eResource.getAllContents();
      Iterator<GenNodeConstraint> _filter = Iterators.<GenNodeConstraint>filter(_allContents, GenNodeConstraint.class);
      final Function1<GenNodeConstraint, Boolean> _function = new Function1<GenNodeConstraint, Boolean>() {
        public Boolean apply(final GenNodeConstraint v) {
          boolean _and = false;
          EList<GenNode> _genNode = v.getGenNode();
          boolean _contains = _genNode.contains(it);
          if (!_contains) {
            _and = false;
          } else {
            GenConstraint _genConstraint = v.getGenConstraint();
            boolean _notEquals = (!Objects.equal(_genConstraint, null));
            _and = _notEquals;
          }
          return Boolean.valueOf(_and);
        }
      };
      Iterator<GenNodeConstraint> _filter_1 = IteratorExtensions.<GenNodeConstraint>filter(_filter, _function);
      return IteratorExtensions.<GenNodeConstraint>head(_filter_1);
    } else {
      return null;
    }
  }
  
  public GenNode getOwningGenNode(final TypeModelFacet it) {
    Resource _eResource = it.eResource();
    TreeIterator<EObject> _allContents = _eResource.getAllContents();
    Iterator<GenNode> _filter = Iterators.<GenNode>filter(_allContents, GenNode.class);
    final Function1<GenNode, Boolean> _function = new Function1<GenNode, Boolean>() {
      public Boolean apply(final GenNode v) {
        TypeModelFacet _modelFacet = v.getModelFacet();
        return Boolean.valueOf(Objects.equal(_modelFacet, it));
      }
    };
    Iterator<GenNode> _filter_1 = IteratorExtensions.<GenNode>filter(_filter, _function);
    return IteratorExtensions.<GenNode>head(_filter_1);
  }
  
  public String getNodeCreationConstraintBody(final GenNode it) {
    GenNodeConstraint nodeConstraint = this.getNodeCreationConstraint(it);
    boolean _hasNodeCreationConstraint = this.hasNodeCreationConstraint(it);
    if (_hasNodeCreationConstraint) {
      boolean _and = false;
      GenConstraint _genConstraint = nodeConstraint.getGenConstraint();
      boolean _notEquals = (!Objects.equal(_genConstraint, null));
      if (!_notEquals) {
        _and = false;
      } else {
        GenConstraint _genConstraint_1 = nodeConstraint.getGenConstraint();
        String _body = _genConstraint_1.getBody();
        boolean _notEquals_1 = (!Objects.equal(_body, null));
        _and = _notEquals_1;
      }
      if (_and) {
        GenConstraint _genConstraint_2 = nodeConstraint.getGenConstraint();
        return _genConstraint_2.getBody();
      }
    }
    return "No GenNodeConstraint found.";
  }
}
