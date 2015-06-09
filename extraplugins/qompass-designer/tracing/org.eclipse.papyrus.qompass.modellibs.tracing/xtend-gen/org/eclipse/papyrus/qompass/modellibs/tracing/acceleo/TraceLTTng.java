package org.eclipse.papyrus.qompass.modellibs.tracing.acceleo;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.qompass.designer.core.UMLTool;
import org.eclipse.papyrus.qompass.designer.core.extensions.IXtend;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationContext;
import org.eclipse.papyrus.qompass.modellibs.core.xtend.CppUtils;
import org.eclipse.papyrus.qompass.modellibs.tracing.acceleo.TraceUtils;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.Type;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class TraceLTTng implements IXtend {
  public CharSequence declareTP(final Classifier cl) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#if !defined(HFILENAME_H) || defined(TRACEPOINT_HEADER_MULTI_READ)");
    _builder.newLine();
    _builder.append("#define HFILENAME_H");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#ifdef __cplusplus");
    _builder.newLine();
    _builder.append("extern \"C\" {");
    _builder.newLine();
    _builder.append("#endif");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#include <lttng/tracepoint.h>");
    _builder.newLine();
    {
      EList<Operation> _allOperations = cl.getAllOperations();
      for(final Operation operation : _allOperations) {
        {
          boolean _hasTrace = TraceUtils.hasTrace(operation);
          if (_hasTrace) {
            String _tpName1 = this.tpName1();
            CharSequence _declareTPop = this.declareTPop(_tpName1, operation);
            _builder.append(_declareTPop, "");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.newLine();
    _builder.append("#undef TRACEPOINT_PROVIDER");
    _builder.newLine();
    _builder.append("#define TRACEPOINT_PROVIDER ");
    String _tpName1_1 = this.tpName1();
    _builder.append(_tpName1_1, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#undef TRACEPOINT_INCLUDE_FILE");
    _builder.newLine();
    _builder.append("#define TRACEPOINT_INCLUDE_FILE ");
    String _qualifiedName = TransformationContext.classifier.getQualifiedName();
    String _replaceAll = _qualifiedName.replaceAll("::", "/");
    _builder.append(_replaceAll, "");
    _builder.append(".h");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#include <lttng/tracepoint-event.h>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#ifdef __cplusplus");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("#endif");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#endif");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence declareEMF_URI(final Classifier cl) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#include <lttng/tracepoint.h>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("TRACEPOINT_MODEL_EMF_URI(UMLmodel, starting, \"");
    String _uRI = TransformationContext.sourceRoot.getURI();
    _builder.append(_uRI, "");
    _builder.append("\")");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence declareTPop(final String tpName, final Operation operation) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#include <stdint.h>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("// declare trace point");
    _builder.newLine();
    _builder.append("TRACEPOINT_EVENT(");
    String _tpName1 = this.tpName1();
    _builder.append(_tpName1, "");
    _builder.append(", ");
    String _tpName2 = this.tpName2(operation);
    _builder.append(_tpName2, "");
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("TP_ARGS(const char *, instanceName");
    {
      EList<Parameter> _parametersInInout = UMLTool.parametersInInout(operation);
      int _size = _parametersInInout.size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append(", ");
      }
    }
    {
      EList<Parameter> _parametersInInout_1 = UMLTool.parametersInInout(operation);
      boolean _hasElements = false;
      for(final Parameter parameter : _parametersInInout_1) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "\t");
        }
        CharSequence _flattenParNameAndType = this.flattenParNameAndType(parameter);
        _builder.append(_flattenParNameAndType, "\t");
      }
    }
    _builder.append("),");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("TP_FIELDS(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ctf_string(instanceName, instanceName)");
    _builder.newLine();
    {
      EList<Parameter> _parametersInInout_2 = UMLTool.parametersInInout(operation);
      for(final Parameter parameter_1 : _parametersInInout_2) {
        _builder.append("\t\t");
        Type _type = parameter_1.getType();
        UMLTool.declareDependency(TransformationContext.classifier, _type);
        Type _type_1 = parameter_1.getType();
        String _name = parameter_1.getName();
        CharSequence _flattenCtfType = this.flattenCtfType(_type_1, _name);
        _builder.append(_flattenCtfType, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    _builder.append("TRACEPOINT_MODEL_EMF_URI(");
    String _tpName1_1 = this.tpName1();
    _builder.append(_tpName1_1, "");
    _builder.append(", ");
    String _tpName2_1 = this.tpName2(operation);
    _builder.append(_tpName2_1, "");
    _builder.append(", \"");
    String _modelRef = this.modelRef(operation);
    _builder.append(_modelRef, "");
    _builder.append("\")");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence declareTracepointEventCreateClass(final Classifier clazz) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("TRACEPOINT_EVENT(");
    String _tpName1 = this.tpName1();
    _builder.append(_tpName1, "");
    _builder.append(", createClass, ");
    String _qualifiedName = clazz.getQualifiedName();
    _builder.append(_qualifiedName, "");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence declareTracepointEventDestroyClass(final Classifier clazz) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("TRACEPOINT_EVENT(");
    String _tpName1 = this.tpName1();
    _builder.append(_tpName1, "");
    _builder.append(", destroyClass, ");
    String _qualifiedName = clazz.getQualifiedName();
    _builder.append(_qualifiedName, "");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence declareCreateDestroy(final String tpName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("TRACEPOINT_EVENT(");
    _builder.append(tpName, "");
    _builder.append(", createClass,");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("TP_ARGS(const char *, classURI),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("TP_FIELDS(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ctf_string(classURI, classURI)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    _builder.append("TRACEPOINT_EVENT(");
    _builder.append(tpName, "");
    _builder.append(", destroyClass,");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("TP_ARGS(const char *, className),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("TP_FIELDS(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ctf_string(xmdID, className)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * The name that is used for the trace provider
   */
  public String tpName1() {
    TemplateBinding _binding = TransformationContext.getBinding();
    org.eclipse.uml2.uml.Package _nearestPackage = _binding.getNearestPackage();
    String _qualifiedName = _nearestPackage.getQualifiedName();
    return UMLTool.varName(_qualifiedName);
  }
  
  /**
   * The name that is used for the type
   */
  public String tpName2(final Operation operation) {
    return operation.getName();
  }
  
  /**
   * Reference either the port (if available in the context) or the operation that is traced
   */
  public String modelRef(final Operation operation) {
    String _xblockexpression = null;
    {
      Resource _eResource = TransformationContext.sourceRoot.eResource();
      final URI uri = _eResource.getURI();
      String _xifexpression = null;
      boolean _equals = Objects.equal(TransformationContext.port, null);
      if (_equals) {
        String _plus = (uri + "#");
        String _xmlID = UMLTool.xmlID(operation);
        _xifexpression = (_plus + _xmlID);
      } else {
        String _plus_1 = (uri + "#");
        String _xmlID_1 = UMLTool.xmlID(TransformationContext.port);
        _xifexpression = (_plus_1 + _xmlID_1);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public Object declareTraceOp(final Operation operation) {
    return null;
  }
  
  public CharSequence invokeTP(final Operation operation) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// create event with operationID/portID and pass call");
    _builder.newLine();
    {
      boolean _hasTrace = TraceUtils.hasTrace(operation);
      if (_hasTrace) {
        _builder.append("// use (call) tracepoint");
        _builder.newLine();
        _builder.append("tracepoint(");
        String _tpName1 = this.tpName1();
        _builder.append(_tpName1, "");
        _builder.append(", ");
        String _tpName2 = this.tpName2(operation);
        _builder.append(_tpName2, "");
        _builder.append(", instanceName");
        {
          EList<Parameter> _parametersInInout = UMLTool.parametersInInout(operation);
          int _size = _parametersInInout.size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append(", ");
          }
        }
        {
          EList<Parameter> _parametersInInout_1 = UMLTool.parametersInInout(operation);
          boolean _hasElements = false;
          for(final Parameter parameter : _parametersInInout_1) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(", ", "");
            }
            CharSequence _flattenParName = this.flattenParName(parameter);
            String _string = _flattenParName.toString();
            String _trim = _string.trim();
            _builder.append(_trim, "");
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      Type _type = operation.getType();
      boolean _notEquals = (!Objects.equal(_type, null));
      if (_notEquals) {
        _builder.append("return ");
      }
    }
    _builder.append("rconn->");
    CharSequence _cppCall = CppUtils.cppCall(operation);
    _builder.append(_cppCall, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence flattenParNameAndType(final Parameter parameter) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _and = false;
      Type _type = parameter.getType();
      if (!(_type instanceof DataType)) {
        _and = false;
      } else {
        _and = (!(parameter.getType() instanceof PrimitiveType));
      }
      if (_and) {
        {
          Type _type_1 = parameter.getType();
          EList<Property> _attributes = ((DataType) _type_1).getAttributes();
          boolean _hasElements = false;
          for(final Property attribute : _attributes) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(", ", "");
            }
            Type _type_2 = attribute.getType();
            CharSequence _cppTypeWB = this.cppTypeWB(_type_2);
            String _string = _cppTypeWB.toString();
            String _trim = _string.trim();
            _builder.append(_trim, "");
            _builder.append(", ");
            String _name = parameter.getName();
            String _plus = (_name + "_");
            String _name_1 = attribute.getName();
            String _plus_1 = (_plus + _name_1);
            _builder.append(_plus_1, "");
          }
        }
        _builder.newLineIfNotEmpty();
      } else {
        Type _type_3 = parameter.getType();
        CharSequence _cppTypeWB_1 = this.cppTypeWB(_type_3);
        String _string_1 = _cppTypeWB_1.toString();
        String _trim_1 = _string_1.trim();
        _builder.append(_trim_1, "");
        _builder.append(", ");
        String _name_2 = parameter.getName();
        _builder.append(_name_2, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence flattenParName(final Parameter parameter) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _and = false;
      Type _type = parameter.getType();
      if (!(_type instanceof DataType)) {
        _and = false;
      } else {
        _and = (!(parameter.getType() instanceof PrimitiveType));
      }
      if (_and) {
        {
          Type _type_1 = parameter.getType();
          EList<Property> _attributes = ((DataType) _type_1).getAttributes();
          boolean _hasElements = false;
          for(final Property attribute : _attributes) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(", ", "");
            }
            String _name = parameter.getName();
            _builder.append(_name, "");
            _builder.append(".");
            String _name_1 = attribute.getName();
            _builder.append(_name_1, "");
          }
        }
        _builder.newLineIfNotEmpty();
      } else {
        String _name_2 = parameter.getName();
        _builder.append(_name_2, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence flattenCtfType(final Type type, final String name) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _and = false;
      if (!(type instanceof DataType)) {
        _and = false;
      } else {
        _and = (!(type instanceof PrimitiveType));
      }
      if (_and) {
        {
          EList<Property> _attributes = ((DataType) type).getAttributes();
          boolean _hasElements = false;
          for(final Property attribute : _attributes) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate("\n", "");
            }
            Type _type = attribute.getType();
            String _name = attribute.getName();
            String _plus = ((name + "_") + _name);
            CharSequence _ctfType = this.ctfType(_type, _plus);
            _builder.append(_ctfType, "");
            _builder.newLineIfNotEmpty();
          }
        }
      } else {
        CharSequence _ctfType_1 = this.ctfType(type, name);
        _builder.append(_ctfType_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  /**
   * Support for C++ types with boolean
   */
  public CharSequence cppTypeWB(final Type type) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _or = false;
      boolean _or_1 = false;
      String _qualifiedName = type.getQualifiedName();
      boolean _equals = Objects.equal(_qualifiedName, "UMLPrimitiveTypes::Boolean");
      if (_equals) {
        _or_1 = true;
      } else {
        String _qualifiedName_1 = type.getQualifiedName();
        boolean _equals_1 = Objects.equal(_qualifiedName_1, "PrimitiveTypes::Boolean");
        _or_1 = _equals_1;
      }
      if (_or_1) {
        _or = true;
      } else {
        String _qualifiedName_2 = type.getQualifiedName();
        boolean _equals_2 = Objects.equal(_qualifiedName_2, "CORBA::Boolean");
        _or = _equals_2;
      }
      if (_or) {
        _builder.append("/* bool */ unsigned char");
        _builder.newLine();
      } else {
        CharSequence _cppType = CppUtils.cppType(type);
        _builder.append(_cppType, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  /**
   * Calculate the typename, defaulting to ctf_integer
   * TODO: treat pointer & ref stereotypes (can only evaulate on parameter or attribute, not on Type)
   */
  public CharSequence ctfType(final Type type, final String name) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _or = false;
      boolean _or_1 = false;
      String _qualifiedName = type.getQualifiedName();
      boolean _equals = Objects.equal(_qualifiedName, "CORBA::String");
      if (_equals) {
        _or_1 = true;
      } else {
        String _qualifiedName_1 = type.getQualifiedName();
        boolean _equals_1 = Objects.equal(_qualifiedName_1, "PrimitiveTypes::String");
        _or_1 = _equals_1;
      }
      if (_or_1) {
        _or = true;
      } else {
        String _qualifiedName_2 = type.getQualifiedName();
        boolean _equals_2 = Objects.equal(_qualifiedName_2, "UMLPrimitiveTypes::String");
        _or = _equals_2;
      }
      if (_or) {
        _builder.append("ctf_string(");
        _builder.append(name, "");
        _builder.append(", ");
        _builder.append(name, "");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
      } else {
        boolean _or_2 = false;
        boolean _or_3 = false;
        boolean _or_4 = false;
        String _qualifiedName_3 = type.getQualifiedName();
        boolean _equals_3 = Objects.equal(_qualifiedName_3, "CORBA::Float");
        if (_equals_3) {
          _or_4 = true;
        } else {
          String _qualifiedName_4 = type.getQualifiedName();
          boolean _equals_4 = Objects.equal(_qualifiedName_4, "CORBA::Double");
          _or_4 = _equals_4;
        }
        if (_or_4) {
          _or_3 = true;
        } else {
          String _qualifiedName_5 = type.getQualifiedName();
          boolean _equals_5 = Objects.equal(_qualifiedName_5, "AnsiCLibrary::float");
          _or_3 = _equals_5;
        }
        if (_or_3) {
          _or_2 = true;
        } else {
          String _qualifiedName_6 = type.getQualifiedName();
          boolean _equals_6 = Objects.equal(_qualifiedName_6, "AnsiCLibrary::double");
          _or_2 = _equals_6;
        }
        if (_or_2) {
          _builder.append("ctf_float(");
          CharSequence _cppType = CppUtils.cppType(type);
          _builder.append(_cppType, "");
          _builder.append(", ");
          _builder.append(name, "");
          _builder.append(", ");
          _builder.append(name, "");
          _builder.append(")");
          _builder.newLineIfNotEmpty();
        } else {
          _builder.append("ctf_integer(");
          CharSequence _cppTypeWB = this.cppTypeWB(type);
          _builder.append(_cppTypeWB, "");
          _builder.append(", ");
          _builder.append(name, "");
          _builder.append(", ");
          _builder.append(name, "");
          _builder.append(")");
          _builder.newLineIfNotEmpty();
        }
      }
    }
    return _builder;
  }
}
