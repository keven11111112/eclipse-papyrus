package utils;

import com.google.common.collect.Iterators;
import com.google.inject.Singleton;
import java.util.Iterator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.papyrus.papyrusgmfgenextension.AdditionalEditPartCandies;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@Singleton
@SuppressWarnings("all")
public class EditHelperUtils_qvto {
  public String getBaseEditHelperFullName(final GenDiagram diagram) {
    Resource _eResource = diagram.eResource();
    TreeIterator<EObject> _allContents = _eResource.getAllContents();
    Iterator<AdditionalEditPartCandies> _filter = Iterators.<AdditionalEditPartCandies>filter(_allContents, AdditionalEditPartCandies.class);
    boolean _isEmpty = IteratorExtensions.isEmpty(_filter);
    boolean _not = (!_isEmpty);
    if (_not) {
      Resource _eResource_1 = diagram.eResource();
      TreeIterator<EObject> _allContents_1 = _eResource_1.getAllContents();
      Iterator<AdditionalEditPartCandies> _filter_1 = Iterators.<AdditionalEditPartCandies>filter(_allContents_1, AdditionalEditPartCandies.class);
      AdditionalEditPartCandies _head = IteratorExtensions.<AdditionalEditPartCandies>head(_filter_1);
      String _baseEditHelperPackage = _head.getBaseEditHelperPackage();
      String _plus = (_baseEditHelperPackage + ".");
      String _baseEditHelperClassName = diagram.getBaseEditHelperClassName();
      return (_plus + _baseEditHelperClassName);
    } else {
      return diagram.getBaseEditHelperQualifiedClassName();
    }
  }
}
