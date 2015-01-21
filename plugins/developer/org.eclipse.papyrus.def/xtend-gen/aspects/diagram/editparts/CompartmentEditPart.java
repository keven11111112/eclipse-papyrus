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
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Iterator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import xpt.Common;

@Singleton
@SuppressWarnings("all")
public class CompartmentEditPart extends diagram.editparts.CompartmentEditPart {
  @Inject
  @Extension
  private Common _common;
  
  public CharSequence extendsList(final GenCompartment it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
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
        _builder.append("extends ");
        {
          boolean _isListLayout = it.isListLayout();
          if (_isListLayout) {
            _builder.append("org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart");
          } else {
            _builder.append("org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart");
          }
        }
        _builder.newLineIfNotEmpty();
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
  
  public CharSequence additions(final GenCompartment it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _handleSize = this.handleSize(it);
    _builder.append(_handleSize, "");
    _builder.newLineIfNotEmpty();
    CharSequence _refreshbound = this.refreshbound(it);
    _builder.append(_refreshbound, "");
    _builder.newLineIfNotEmpty();
    CharSequence _refreshvisual = this.refreshvisual(it);
    _builder.append(_refreshvisual, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence handleSize(final GenCompartment it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("protected void handleNotificationEvent(org.eclipse.emf.common.notify.Notification notification) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Object feature = notification.getFeature();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getSize_Width().equals(feature)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("|| org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getSize_Height().equals(feature)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("|| org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLocation_X().equals(feature)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("|| org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLocation_Y().equals(feature)) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("refreshBounds();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super.handleNotificationEvent(notification);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} ");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence refreshbound(final GenCompartment it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected void refreshBounds() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int width = ((Integer) getStructuralFeatureValue(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getSize_Width())).intValue();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int height = ((Integer) getStructuralFeatureValue(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getSize_Height())).intValue();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.draw2d.geometry.Dimension size = new org.eclipse.draw2d.geometry.Dimension(width, height);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x = ((Integer) getStructuralFeatureValue(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLocation_X())).intValue();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int y = ((Integer) getStructuralFeatureValue(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLocation_Y())).intValue();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.draw2d.geometry.Point loc = new org.eclipse.draw2d.geometry.Point(x, y);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("((org.eclipse.gef.GraphicalEditPart) getParent()).setLayoutConstraint(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("getFigure(),");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new org.eclipse.draw2d.geometry.Rectangle(loc, size));");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence refreshvisual(final GenCompartment it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("protected void refreshVisuals() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super.refreshVisuals();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("refreshBounds();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
