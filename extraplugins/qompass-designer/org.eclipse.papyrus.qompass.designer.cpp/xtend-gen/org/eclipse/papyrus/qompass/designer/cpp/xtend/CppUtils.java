package org.eclipse.papyrus.qompass.designer.cpp.xtend;

import com.google.common.base.Objects;
import org.eclipse.papyrus.C_Cpp.Ptr;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Property;

@SuppressWarnings("all")
public class CppUtils {
  public static String nameRef(final Property part) {
    String _name = part.getName();
    String _refOp = CppUtils.refOp(part);
    return (_name + _refOp);
  }
  
  /**
   * return the operator for (de-) referencing a part. If the part is
   * instantiate via the bootloader, it becomes a pointer. If it is
   * instantiated by the composite itself, it is not a pointer, it will be
   * instantiated along with the composite
   * 
   * @param part
   * @return
   */
  public static String refOp(final Property part) {
    String _xifexpression = null;
    boolean _or = false;
    AggregationKind _aggregation = part.getAggregation();
    boolean _equals = Objects.equal(_aggregation, AggregationKind.SHARED_LITERAL);
    if (_equals) {
      _or = true;
    } else {
      boolean _isApplied = StereotypeUtil.isApplied(part, Ptr.class);
      _or = _isApplied;
    }
    if (_or) {
      _xifexpression = "->";
    } else {
      _xifexpression = ".";
    }
    return _xifexpression;
  }
}
