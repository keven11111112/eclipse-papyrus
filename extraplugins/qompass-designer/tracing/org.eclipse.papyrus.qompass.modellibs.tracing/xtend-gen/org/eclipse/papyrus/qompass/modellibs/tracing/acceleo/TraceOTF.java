package org.eclipse.papyrus.qompass.modellibs.tracing.acceleo;

import com.google.common.base.Objects;
import org.eclipse.papyrus.qompass.designer.core.EnumService;
import org.eclipse.papyrus.qompass.designer.core.UMLTool;
import org.eclipse.papyrus.qompass.designer.core.extensions.IXtend;
import org.eclipse.papyrus.qompass.modellibs.core.xtend.CppUtils;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Type;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class TraceOTF implements IXtend {
  public CharSequence traceOp(final Operation operation) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// <instance>_<port>_<operation>");
    _builder.newLine();
    _builder.append("// easier: <component>_<port>_<operation>");
    _builder.newLine();
    _builder.append("updateTimestamp ();");
    _builder.newLine();
    _builder.append("if (!hasDeclaredFunctions) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("declareFunctions();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("hasDeclaredFunctions = true;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("Tracing::TraceInit::wait();");
    _builder.newLine();
    _builder.append("int processID = Tracing::TraceInit::getProcessID();");
    _builder.newLine();
    _builder.append("OTF_Writer * writer = Tracing::TraceInit::getWriter();");
    _builder.newLine();
    _builder.append("OTF_Writer_writeEnter (writer, timestamp.ticks(), ");
    String _enumSvcPrefix = EnumService.enumSvcPrefix();
    _builder.append(_enumSvcPrefix, "");
    _builder.append("::id_");
    Element _owner = operation.getOwner();
    String _varName = UMLTool.varName(((NamedElement) _owner));
    _builder.append(_varName, "");
    _builder.append("_");
    String _varName_1 = UMLTool.varName(operation);
    _builder.append(_varName_1, "");
    _builder.append(", processID, 0);");
    _builder.newLineIfNotEmpty();
    _builder.append("OTF_Writer_writeEventComment (writer, timestamp.ticks(), processID, portName);");
    _builder.newLine();
    _builder.append("OTF_Writer_writeEventComment (writer, timestamp.ticks(), processID, instanceName);");
    _builder.newLine();
    _builder.append("Tracing::TraceInit::post();");
    _builder.newLine();
    {
      Type _type = operation.getType();
      boolean _notEquals = (!Objects.equal(_type, null));
      if (_notEquals) {
        _builder.append(" type.cppType ret = ");
      }
    }
    _builder.append("rconn->");
    CharSequence _cppCall = CppUtils.cppCall(operation);
    _builder.append(_cppCall, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("updateTimestamp ();");
    _builder.newLine();
    _builder.append("Tracing::TraceInit::wait();");
    _builder.newLine();
    _builder.append("OTF_Writer_writeLeave (writer, timestamp.ticks(), ");
    String _enumSvcPrefix_1 = EnumService.enumSvcPrefix();
    _builder.append(_enumSvcPrefix_1, "");
    _builder.append("::id_");
    Element _owner_1 = operation.getOwner();
    String _varName_2 = UMLTool.varName(((NamedElement) _owner_1));
    _builder.append(_varName_2, "");
    _builder.append("_");
    String _varName_3 = UMLTool.varName(operation);
    _builder.append(_varName_3, "");
    _builder.append(", processID, 0);");
    _builder.newLineIfNotEmpty();
    _builder.append("Tracing::TraceInit::post();");
    _builder.newLine();
    {
      Type _type_1 = operation.getType();
      boolean _notEquals_1 = (!Objects.equal(_type_1, null));
      if (_notEquals_1) {
        _builder.append(" return ret;");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
