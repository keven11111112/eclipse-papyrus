package org.eclipse.papyrus.qompass.modellibs.tracing.acceleo;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.qompass.designer.core.extensions.IXtend;
import org.eclipse.papyrus.qompass.modellibs.core.xtend.CppUtils;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class TraceCout implements IXtend {
  public CharSequence traceOp(final Operation operation) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// declare operation & use it directly. Problem: declaration can not be within the scope of an operation");
    _builder.newLine();
    _builder.append("updateTimestamp();");
    _builder.newLine();
    _builder.append("cout << \"enter operation: \" << ");
    String _name = operation.getName();
    _builder.append(_name, "");
    _builder.append(" << \" at \" << timestamp.ticks() << \"  parameters: \"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    {
      EList<Parameter> _ownedParameters = operation.getOwnedParameters();
      for(final Parameter parameter : _ownedParameters) {
        _builder.append(" << \"");
        String _name_1 = parameter.getName();
        _builder.append(_name_1, "\t");
        _builder.append(" (of type ");
        Type _type = parameter.getType();
        String _name_2 = _type.getName();
        _builder.append(_name_2, "\t");
        _builder.append(") \"");
      }
    }
    _builder.append(" << endl;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      Type _type_1 = operation.getType();
      boolean _notEquals = (!Objects.equal(_type_1, null));
      if (_notEquals) {
        _builder.append(" type.cppType ret = ");
      }
    }
    _builder.append("rconn->");
    CharSequence _cppCall = CppUtils.cppCall(operation);
    _builder.append(_cppCall, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    {
      Type _type_2 = operation.getType();
      boolean _notEquals_1 = (!Objects.equal(_type_2, null));
      if (_notEquals_1) {
        _builder.append(" return ret;");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
