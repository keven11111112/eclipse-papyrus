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

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.inject.Singleton;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.papyrus.papyrusgmfgenextension.SpecificLocatorExternalLabel;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@Singleton
@SuppressWarnings("all")
public class EditPartsUtils_qvto {
  public boolean hasSpecificLocator(final GenExternalNodeLabel it) {
    Resource _eResource = it.eResource();
    TreeIterator<EObject> _allContents = _eResource.getAllContents();
    Iterator<SpecificLocatorExternalLabel> _filter = Iterators.<SpecificLocatorExternalLabel>filter(_allContents, SpecificLocatorExternalLabel.class);
    final Function1<SpecificLocatorExternalLabel, Boolean> _function = new Function1<SpecificLocatorExternalLabel, Boolean>() {
      public Boolean apply(final SpecificLocatorExternalLabel v) {
        EList<GenExternalNodeLabel> _genExternalNodeLabel = v.getGenExternalNodeLabel();
        return Boolean.valueOf(_genExternalNodeLabel.contains(it));
      }
    };
    Iterator<SpecificLocatorExternalLabel> _filter_1 = IteratorExtensions.<SpecificLocatorExternalLabel>filter(_filter, _function);
    int _size = IteratorExtensions.size(_filter_1);
    return (_size != 0);
  }
  
  public String getSpecificLocator(final GenExternalNodeLabel it) {
    boolean _hasSpecificLocator = this.hasSpecificLocator(it);
    if (_hasSpecificLocator) {
      Resource _eResource = it.eResource();
      TreeIterator<EObject> _allContents = _eResource.getAllContents();
      Iterator<SpecificLocatorExternalLabel> _filter = Iterators.<SpecificLocatorExternalLabel>filter(_allContents, SpecificLocatorExternalLabel.class);
      final Function1<SpecificLocatorExternalLabel, Boolean> _function = new Function1<SpecificLocatorExternalLabel, Boolean>() {
        public Boolean apply(final SpecificLocatorExternalLabel v) {
          EList<GenExternalNodeLabel> _genExternalNodeLabel = v.getGenExternalNodeLabel();
          return Boolean.valueOf(_genExternalNodeLabel.contains(it));
        }
      };
      Iterator<SpecificLocatorExternalLabel> _filter_1 = IteratorExtensions.<SpecificLocatorExternalLabel>filter(_filter, _function);
      SpecificLocatorExternalLabel _head = IteratorExtensions.<SpecificLocatorExternalLabel>head(_filter_1);
      return _head.getClasspath();
    }
    return null;
  }
  
  public List<GenExternalNodeLabel> getExternalLabelsWithoutSpecificLocator(final GenNode it) {
    EList<GenNodeLabel> _labels = it.getLabels();
    Iterable<GenExternalNodeLabel> _filter = Iterables.<GenExternalNodeLabel>filter(_labels, GenExternalNodeLabel.class);
    final Function1<GenExternalNodeLabel, Boolean> _function = new Function1<GenExternalNodeLabel, Boolean>() {
      public Boolean apply(final GenExternalNodeLabel l) {
        boolean _hasSpecificLocator = EditPartsUtils_qvto.this.hasSpecificLocator(l);
        return Boolean.valueOf((!_hasSpecificLocator));
      }
    };
    Iterable<GenExternalNodeLabel> _filter_1 = IterableExtensions.<GenExternalNodeLabel>filter(_filter, _function);
    return IterableExtensions.<GenExternalNodeLabel>toList(_filter_1);
  }
  
  public List<GenExternalNodeLabel> getExternalLabelsWithSpecificLocator(final GenNode it) {
    EList<GenNodeLabel> _labels = it.getLabels();
    Iterable<GenExternalNodeLabel> _filter = Iterables.<GenExternalNodeLabel>filter(_labels, GenExternalNodeLabel.class);
    final Function1<GenExternalNodeLabel, Boolean> _function = new Function1<GenExternalNodeLabel, Boolean>() {
      public Boolean apply(final GenExternalNodeLabel l) {
        return Boolean.valueOf(EditPartsUtils_qvto.this.hasSpecificLocator(l));
      }
    };
    Iterable<GenExternalNodeLabel> _filter_1 = IterableExtensions.<GenExternalNodeLabel>filter(_filter, _function);
    return IterableExtensions.<GenExternalNodeLabel>toList(_filter_1);
  }
}
