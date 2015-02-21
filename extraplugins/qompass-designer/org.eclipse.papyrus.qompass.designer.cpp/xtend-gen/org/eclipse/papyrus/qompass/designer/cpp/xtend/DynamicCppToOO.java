/**
 * Copyright (c) 2015 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr
 */
package org.eclipse.papyrus.qompass.designer.cpp.xtend;

import com.google.common.base.Objects;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.C_Cpp.Ptr;
import org.eclipse.papyrus.qompass.designer.core.PortInfo;
import org.eclipse.papyrus.qompass.designer.core.PortUtils;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.qompass.designer.core.extensions.IOOTrafo;
import org.eclipse.papyrus.qompass.designer.core.transformations.CompTypeTrafos;
import org.eclipse.papyrus.qompass.designer.core.transformations.LazyCopier;
import org.eclipse.papyrus.qompass.designer.core.transformations.PrefixConstants;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;
import org.eclipse.papyrus.qompass.designer.cpp.Constants;
import org.eclipse.papyrus.qompass.designer.cpp.Messages;
import org.eclipse.papyrus.qompass.designer.cpp.xtend.CppUtils;
import org.eclipse.papyrus.uml.tools.utils.ConnectorUtil;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * This class realizes the dynamic variant of the OO-transformation
 */
@SuppressWarnings("all")
public class DynamicCppToOO implements IOOTrafo {
  protected LazyCopier copier;
  
  private final static String PART_MANAGER = "services::PartManager";
  
  private final static String INIT_PARTS = "initParts";
  
  private final static String PARTS = "parts";
  
  private final static String progLang = "C/C++";
  
  protected org.eclipse.uml2.uml.Class bootloader;
  
  @Override
  public void init(final LazyCopier copier, final org.eclipse.uml2.uml.Class bootloader) {
    this.copier = copier;
    this.bootloader = bootloader;
  }
  
  @Override
  public void addPortOperations(final org.eclipse.uml2.uml.Class implementation) {
    this.addGetPortOperation(implementation);
    DynamicCppToOO.addConnectPortOperation(implementation);
  }
  
  /**
   * Add the get_p operation for each port with a provided interface. It also
   * adds a suitable implementation that evaluates delegation connectors from
   * the port to a property within the composite. The delegation target could
   * either be a normal class (no port) or an inner component.
   * 
   * @param implementation
   */
  public void addGetPortOperation(final org.eclipse.uml2.uml.Class implementation) {
    EList<Port> _allPorts2 = PortUtils.getAllPorts2(implementation);
    EList<PortInfo> _flattenExtendedPorts = PortUtils.flattenExtendedPorts(_allPorts2);
    for (final PortInfo portInfo : _flattenExtendedPorts) {
      {
        final Interface providedIntf = portInfo.getProvided();
        boolean _notEquals = (!Objects.equal(providedIntf, null));
        if (_notEquals) {
          String _name = portInfo.getName();
          final String opName = (PrefixConstants.getP_Prefix + _name);
          Operation op = implementation.getOwnedOperation(opName, null, null);
          boolean _notEquals_1 = (!Objects.equal(op, null));
          if (_notEquals_1) {
            Type _type = op.getType();
            boolean _notEquals_2 = (!Objects.equal(_type, providedIntf));
            if (_notEquals_2) {
              op.createOwnedParameter(Constants.retParamName, providedIntf);
            }
          } else {
            Operation _createOwnedOperation = implementation.createOwnedOperation(opName, null, null, providedIntf);
            op = _createOwnedOperation;
            EList<Parameter> _ownedParameters = op.getOwnedParameters();
            final Parameter retParam = _ownedParameters.get(0);
            retParam.setName(Constants.retParamName);
            StereotypeUtil.apply(retParam, Ptr.class);
            EClass _opaqueBehavior = UMLPackage.eINSTANCE.getOpaqueBehavior();
            Behavior _createOwnedBehavior = implementation.createOwnedBehavior(opName, _opaqueBehavior);
            final OpaqueBehavior behavior = ((OpaqueBehavior) _createOwnedBehavior);
            EList<Behavior> _methods = op.getMethods();
            _methods.add(behavior);
            Port _modelPort = portInfo.getModelPort();
            final ConnectorEnd ce = ConnectorUtil.getDelegation(implementation, _modelPort);
            String body = null;
            boolean _notEquals_3 = (!Objects.equal(ce, null));
            if (_notEquals_3) {
              final Property part = ce.getPartWithPort();
              final ConnectableElement role = ce.getRole();
              body = "return ";
              if ((role instanceof Port)) {
                String _body = body;
                StringConcatenation _builder = new StringConcatenation();
                String _nameRef = CppUtils.nameRef(part);
                _builder.append(_nameRef, "");
                _builder.append(PrefixConstants.getP_Prefix, "");
                String _name_1 = ((Port)role).getName();
                _builder.append(_name_1, "");
                _builder.append("();");
                body = (_body + _builder);
              } else {
                String _body_1 = body;
                String _name_2 = role.getName();
                body = (_body_1 + _name_2);
              }
            } else {
              InterfaceRealization _interfaceRealization = implementation.getInterfaceRealization(null, providedIntf);
              boolean implementsIntf = (!Objects.equal(_interfaceRealization, null));
              if ((!implementsIntf)) {
                final Interface providedIntfInCopy = this.copier.<Interface>getCopy(providedIntf);
                InterfaceRealization _interfaceRealization_1 = implementation.getInterfaceRealization(null, providedIntfInCopy);
                boolean _notEquals_4 = (!Objects.equal(_interfaceRealization_1, null));
                implementsIntf = _notEquals_4;
              }
              if (implementsIntf) {
                body = "return this;";
              } else {
                String _name_3 = providedIntf.getName();
                Port _port = portInfo.getPort();
                String _name_4 = _port.getName();
                String _name_5 = implementation.getName();
                String _format = String.format(Messages.CompImplTrafos_IntfNotImplemented, _name_3, _name_4, _name_5);
                throw new RuntimeException(_format);
              }
            }
            EList<String> _languages = behavior.getLanguages();
            _languages.add(Constants.progLang);
            EList<String> _bodies = behavior.getBodies();
            _bodies.add(body);
          }
        }
      }
    }
  }
  
  /**
   * Add a connect_<portName> operation for ports with a required interface.
   * Whereas operation and a behavior is added for each owned port, a behavior
   * (method) is needed for ports inherited from a component type (the
   * behavior is implementation specific, as it needs to take delegation to
   * parts into account)
   * 
   * @param implementation
   */
  public static void addConnectPortOperation(final org.eclipse.uml2.uml.Class implementation) {
    EList<Port> _allPorts2 = PortUtils.getAllPorts2(implementation);
    EList<PortInfo> _flattenExtendedPorts = PortUtils.flattenExtendedPorts(_allPorts2);
    for (final PortInfo portInfo : _flattenExtendedPorts) {
      {
        final Interface requiredIntf = portInfo.getRequired();
        boolean _notEquals = (!Objects.equal(requiredIntf, null));
        if (_notEquals) {
          String _name = portInfo.getName();
          final String opName = (PrefixConstants.connectQ_Prefix + _name);
          Operation _ownedOperation = implementation.getOwnedOperation(opName, null, null);
          boolean _notEquals_1 = (!Objects.equal(_ownedOperation, null));
          if (_notEquals_1) {
          } else {
            Operation op = implementation.createOwnedOperation(opName, null, null);
            boolean _or = false;
            int _upper = portInfo.getUpper();
            boolean _greaterThan = (_upper > 1);
            if (_greaterThan) {
              _or = true;
            } else {
              int _upper_1 = portInfo.getUpper();
              boolean _equals = (_upper_1 == (-1));
              _or = _equals;
            }
            final boolean multiPort = _or;
            if (multiPort) {
              org.eclipse.uml2.uml.Package _top = Utils.getTop(implementation);
              final NamedElement eLong = Utils.getQualifiedElement(_top, 
                CompTypeTrafos.INDEX_TYPE_FOR_MULTI_RECEPTACLE);
              if ((eLong instanceof Type)) {
                op.createOwnedParameter("index", ((Type) eLong));
              } else {
                String _format = String.format(Messages.CompImplTrafos_CannotFindType, 
                  CompTypeTrafos.INDEX_TYPE_FOR_MULTI_RECEPTACLE);
                throw new RuntimeException(_format);
              }
            }
            final Parameter refParam = op.createOwnedParameter("ref", requiredIntf);
            StereotypeUtil.apply(refParam, Ptr.class);
            EClass _opaqueBehavior = UMLPackage.eINSTANCE.getOpaqueBehavior();
            Behavior _createOwnedBehavior = implementation.createOwnedBehavior(opName, _opaqueBehavior);
            final OpaqueBehavior behavior = ((OpaqueBehavior) _createOwnedBehavior);
            EList<Behavior> _methods = op.getMethods();
            _methods.add(behavior);
            Port _modelPort = portInfo.getModelPort();
            final ConnectorEnd ce = ConnectorUtil.getDelegation(implementation, _modelPort);
            String body = null;
            boolean _notEquals_2 = (!Objects.equal(ce, null));
            if (_notEquals_2) {
              final Property part = ce.getPartWithPort();
              String _name_1 = part.getName();
              body = _name_1;
              final ConnectableElement role = ce.getRole();
              if ((role instanceof Port)) {
                String _name_2 = ((Port)role).getName();
                final String targetOpName = (PrefixConstants.connectQ_Prefix + _name_2);
                StringConcatenation _builder = new StringConcatenation();
                String _nameRef = CppUtils.nameRef(part);
                _builder.append(_nameRef, "");
                _builder.append(targetOpName, "");
                body = _builder.toString();
                boolean _or_1 = false;
                int _upper_2 = portInfo.getUpper();
                boolean _greaterThan_1 = (_upper_2 > 1);
                if (_greaterThan_1) {
                  _or_1 = true;
                } else {
                  int _upper_3 = portInfo.getUpper();
                  boolean _equals_1 = (_upper_3 == (-1));
                  _or_1 = _equals_1;
                }
                if (_or_1) {
                  String _body = body;
                  body = (_body + "(index, ref);");
                } else {
                  String _body_1 = body;
                  body = (_body_1 + "(ref);");
                }
              } else {
                String _body_2 = body;
                StringConcatenation _builder_1 = new StringConcatenation();
                String _name_3 = part.getName();
                _builder_1.append(_name_3, "");
                _builder_1.append(";");
                body = (_body_2 + _builder_1);
              }
            } else {
              String _name_4 = portInfo.getName();
              final String attributeName = (PrefixConstants.attributePrefix + _name_4);
              boolean _hasNonPortOwnedAttribute = Utils.hasNonPortOwnedAttribute(implementation, attributeName);
              boolean _not = (!_hasNonPortOwnedAttribute);
              if (_not) {
                final Property attr = implementation.createOwnedAttribute(attributeName, requiredIntf);
                Port _port = portInfo.getPort();
                LazyCopier.copyMultElemModifiers(_port, attr);
                attr.setAggregation(AggregationKind.SHARED_LITERAL);
              }
              body = attributeName;
              if (multiPort) {
                String _body_3 = body;
                body = (_body_3 + "[index]");
              }
              String _body_4 = body;
              body = (_body_4 + " = ref;");
            }
            EList<String> _languages = behavior.getLanguages();
            _languages.add(Constants.progLang);
            EList<String> _bodies = behavior.getBodies();
            _bodies.add(body);
            boolean _and = false;
            int _length = PrefixConstants.getConnQ_Prefix.length();
            boolean _greaterThan_2 = (_length > 0);
            if (!_greaterThan_2) {
              _and = false;
            } else {
              boolean _notEquals_3 = (!Objects.equal(ce, null));
              _and = _notEquals_3;
            }
            if (_and) {
              String _name_5 = portInfo.getName();
              final String getConnOpName = (PrefixConstants.getConnQ_Prefix + _name_5);
              Operation getConnOp = implementation.getOwnedOperation(getConnOpName, null, null);
              boolean _equals_2 = Objects.equal(getConnOp, null);
              if (_equals_2) {
                Operation _createOwnedOperation = implementation.createOwnedOperation(getConnOpName, null, null, requiredIntf);
                getConnOp = _createOwnedOperation;
                EList<Parameter> _ownedParameters = op.getOwnedParameters();
                final Parameter retParam = _ownedParameters.get(0);
                retParam.setName(Constants.retParamName);
                StereotypeUtil.apply(retParam, Ptr.class);
              }
              EClass _opaqueBehavior_1 = UMLPackage.eINSTANCE.getOpaqueBehavior();
              Behavior _createOwnedBehavior_1 = implementation.createOwnedBehavior(getConnOpName, _opaqueBehavior_1);
              final OpaqueBehavior getConnBehavior = ((OpaqueBehavior) _createOwnedBehavior_1);
              EList<Behavior> _methods_1 = getConnOp.getMethods();
              _methods_1.add(getConnBehavior);
              String _name_6 = portInfo.getName();
              final String name = (PrefixConstants.attributePrefix + _name_6);
              StringConcatenation _builder_2 = new StringConcatenation();
              _builder_2.append("return ");
              _builder_2.append(name, "");
              _builder_2.append(";");
              body = _builder_2.toString();
              EList<String> _languages_1 = behavior.getLanguages();
              _languages_1.add(Constants.progLang);
              EList<String> _bodies_1 = behavior.getBodies();
              _bodies_1.add(body);
            }
          }
        }
      }
    }
  }
  
  /**
   * Add an operation "createConnections" that implements the connections
   * between composite parts. It only takes the assembly connections into
   * account, since delegation connectors are handled by the get_ and connect_
   * port operations above.
   * 
   * @param implementation
   */
  @Override
  public void addConnectionOperation(final org.eclipse.uml2.uml.Class compositeImplementation) throws TransformationException {
    String createConnBody = "";
    final Map<ConnectorEnd, Integer> indexMap = new HashMap<ConnectorEnd, Integer>();
    EList<Connector> _ownedConnectors = compositeImplementation.getOwnedConnectors();
    for (final Connector connector : _ownedConnectors) {
      boolean _isAssembly = ConnectorUtil.isAssembly(connector);
      if (_isAssembly) {
        EList<ConnectorEnd> _ends = connector.getEnds();
        int _size = _ends.size();
        boolean _notEquals = (_size != 2);
        if (_notEquals) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Connector <");
          String _name = connector.getName();
          _builder.append(_name, "");
          _builder.append("> does not have two ends. This is currently not supported");
          throw new TransformationException(_builder.toString());
        }
        EList<ConnectorEnd> _ends_1 = connector.getEnds();
        final ConnectorEnd end1 = _ends_1.get(0);
        EList<ConnectorEnd> _ends_2 = connector.getEnds();
        final ConnectorEnd end2 = _ends_2.get(1);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("// realization of connector <");
        String _name_1 = connector.getName();
        _builder_1.append(_name_1, "");
        _builder_1.append(">\\n");
        String cmd = _builder_1.toString();
        boolean _and = false;
        ConnectableElement _role = end1.getRole();
        if (!(_role instanceof Port)) {
          _and = false;
        } else {
          ConnectableElement _role_1 = end1.getRole();
          boolean _isExtendedPort = PortUtils.isExtendedPort(((Port) _role_1));
          _and = _isExtendedPort;
        }
        if (_and) {
          ConnectableElement _role_2 = end1.getRole();
          final Port port = ((Port) _role_2);
          final EList<PortInfo> subPorts = PortUtils.flattenExtendedPort(port);
          for (final PortInfo subPort : subPorts) {
            {
              String _cmd = cmd;
              StringConcatenation _builder_2 = new StringConcatenation();
              _builder_2.append("  ");
              _builder_2.append("// realization of connection for sub-port ");
              Port _port = subPort.getPort();
              String _name_2 = _port.getName();
              _builder_2.append(_name_2, "  ");
              _builder_2.append("\\n");
              cmd = (_cmd + _builder_2);
              String _cmd_1 = cmd;
              Port _port_1 = subPort.getPort();
              String _connectPorts = DynamicCppToOO.connectPorts(indexMap, connector, end1, end2, _port_1);
              cmd = (_cmd_1 + _connectPorts);
              String _cmd_2 = cmd;
              Port _port_2 = subPort.getPort();
              String _connectPorts_1 = DynamicCppToOO.connectPorts(indexMap, connector, end2, end1, _port_2);
              cmd = (_cmd_2 + _connectPorts_1);
            }
          }
        } else {
          String _cmd = cmd;
          String _connectPorts = DynamicCppToOO.connectPorts(indexMap, connector, end1, end2, null);
          cmd = (_cmd + _connectPorts);
          String _cmd_1 = cmd;
          String _connectPorts_1 = DynamicCppToOO.connectPorts(indexMap, connector, end2, end1, null);
          cmd = (_cmd_1 + _connectPorts_1);
        }
        String _createConnBody = createConnBody;
        createConnBody = (_createConnBody + (cmd + "\n"));
      }
    }
    int _length = createConnBody.length();
    boolean _greaterThan = (_length > 0);
    if (_greaterThan) {
      final Operation operation = compositeImplementation.createOwnedOperation(Constants.CREATE_CONNECTIONS, null, null);
      String _name_2 = operation.getName();
      String _plus = ("b:" + _name_2);
      EClass _opaqueBehavior = UMLPackage.eINSTANCE.getOpaqueBehavior();
      Behavior _createOwnedBehavior = compositeImplementation.createOwnedBehavior(_plus, _opaqueBehavior);
      final OpaqueBehavior behavior = ((OpaqueBehavior) _createOwnedBehavior);
      EList<String> _languages = behavior.getLanguages();
      _languages.add(Constants.progLang);
      EList<String> _bodies = behavior.getBodies();
      _bodies.add(createConnBody);
      behavior.setSpecification(operation);
    }
  }
  
  /**
   * Create the body C++ code code that creates a connection between the two ends
   * of a connector. This function checks whether the first end really is a receptacle
   * and the second really is a facet.
   * TODO: cleaner rewrite in xtend
   * 
   * @param indexMap
   *            a map of indices that are used in case of multiplex
   *            receptacles
   * @param connector
   *            a connector
   * @param receptacleEnd
   *            an end of the connector that may point to a receptacle port
   * @param facetEnd
   *            an end of the connector that may point to a facet port
   * @param subPort
   *            a sub-port in case of extended ports
   * @return
   * @throws TransformationException
   */
  public static String connectPorts(final Map<ConnectorEnd, Integer> indexMap, final Connector connector, final ConnectorEnd receptacleEnd, final ConnectorEnd facetEnd, final Port subPort) throws TransformationException {
    final Association association = connector.getType();
    boolean _and = false;
    ConnectableElement _role = receptacleEnd.getRole();
    if (!(_role instanceof Port)) {
      _and = false;
    } else {
      ConnectableElement _role_1 = facetEnd.getRole();
      _and = (_role_1 instanceof Port);
    }
    if (_and) {
      ConnectableElement _role_2 = facetEnd.getRole();
      final Port facetPort = ((Port) _role_2);
      ConnectableElement _role_3 = receptacleEnd.getRole();
      final Port receptaclePort = ((Port) _role_3);
      final PortInfo facetPI = PortInfo.fromSubPort(facetPort, subPort);
      final PortInfo receptaclePI = PortInfo.fromSubPort(receptaclePort, subPort);
      boolean _and_1 = false;
      Interface _provided = facetPI.getProvided();
      boolean _notEquals = (!Objects.equal(_provided, null));
      if (!_notEquals) {
        _and_1 = false;
      } else {
        Interface _required = receptaclePI.getRequired();
        boolean _notEquals_1 = (!Objects.equal(_required, null));
        _and_1 = _notEquals_1;
      }
      if (_and_1) {
        final Property facetPart = facetEnd.getPartWithPort();
        final Property receptaclePart = receptacleEnd.getPartWithPort();
        String subPortName = "";
        boolean _notEquals_2 = (!Objects.equal(subPort, null));
        if (_notEquals_2) {
          String _subPortName = subPortName;
          String _name = subPort.getName();
          String _plus = ("_" + _name);
          subPortName = (_subPortName + _plus);
        }
        final String indexName = DynamicCppToOO.getIndexName(indexMap, receptaclePort, receptacleEnd);
        StringConcatenation _builder = new StringConcatenation();
        String _nameRef = CppUtils.nameRef(receptaclePart);
        _builder.append(_nameRef, "");
        _builder.append("connect_");
        String _name_1 = receptaclePort.getName();
        _builder.append(_name_1, "");
        _builder.append(" ");
        _builder.append(subPortName, "");
        _builder.append(";");
        final String setter = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        String _nameRef_1 = CppUtils.nameRef(facetPart);
        _builder_1.append(_nameRef_1, "");
        _builder_1.append("get_");
        String _name_2 = facetPort.getName();
        _builder_1.append(_name_2, "");
        _builder_1.append(" ");
        _builder_1.append(subPortName, "");
        _builder_1.append("()");
        final String getter = _builder_1.toString();
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append(setter, "");
        _builder_2.append("(");
        _builder_2.append(indexName, "");
        _builder_2.append(getter, "");
        _builder_2.append(");\\n");
        return _builder_2.toString();
      }
    } else {
      ConnectableElement _role_4 = receptacleEnd.getRole();
      if ((_role_4 instanceof Port)) {
        ConnectableElement _role_5 = receptacleEnd.getRole();
        final Port receptaclePort_1 = ((Port) _role_5);
        Interface _required_1 = PortUtils.getRequired(receptaclePort_1);
        boolean _notEquals_3 = (!Objects.equal(_required_1, null));
        if (_notEquals_3) {
          ConnectableElement _role_6 = facetEnd.getRole();
          final Property facetPart_1 = ((Property) _role_6);
          final Property receptaclePart_1 = facetEnd.getPartWithPort();
          final String indexName_1 = DynamicCppToOO.getIndexName(indexMap, receptaclePort_1, receptacleEnd);
          StringConcatenation _builder_3 = new StringConcatenation();
          String _nameRef_2 = CppUtils.nameRef(receptaclePart_1);
          _builder_3.append(_nameRef_2, "");
          _builder_3.append("connect_");
          String _name_3 = receptaclePort_1.getName();
          _builder_3.append(_name_3, "");
          final String setter_1 = _builder_3.toString();
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append("&");
          String _name_4 = facetPart_1.getName();
          _builder_4.append(_name_4, "");
          final String getter_1 = _builder_4.toString();
          StringConcatenation _builder_5 = new StringConcatenation();
          _builder_5.append(setter_1, "");
          _builder_5.append("(");
          _builder_5.append(indexName_1, "");
          _builder_5.append(getter_1, "");
          _builder_5.append(");\\n");
          return _builder_5.toString();
        }
      } else {
        ConnectableElement _role_7 = facetEnd.getRole();
        if ((_role_7 instanceof Port)) {
          ConnectableElement _role_8 = facetEnd.getRole();
          final Port facetPort_1 = ((Port) _role_8);
          Interface _provided_1 = PortUtils.getProvided(facetPort_1);
          boolean _notEquals_4 = (!Objects.equal(_provided_1, null));
          if (_notEquals_4) {
            final Property facetPart_2 = facetEnd.getPartWithPort();
            ConnectableElement _role_9 = facetEnd.getRole();
            final Property receptaclePart_2 = ((Property) _role_9);
            final String setter_2 = receptaclePart_2.getName();
            StringConcatenation _builder_6 = new StringConcatenation();
            String _nameRef_3 = CppUtils.nameRef(facetPart_2);
            _builder_6.append(_nameRef_3, "");
            _builder_6.append("get_");
            String _name_5 = facetPort_1.getName();
            _builder_6.append(_name_5, "");
            _builder_6.append("();");
            final String getter_2 = _builder_6.toString();
            StringConcatenation _builder_7 = new StringConcatenation();
            _builder_7.append(setter_2, "");
            _builder_7.append(" = ");
            _builder_7.append(getter_2, "");
            _builder_7.append(";\\n");
            return _builder_7.toString();
          }
        } else {
          boolean _notEquals_5 = (!Objects.equal(association, null));
          if (_notEquals_5) {
            ConnectableElement _role_10 = facetEnd.getRole();
            final Property facetPart_3 = ((Property) _role_10);
            ConnectableElement _role_11 = receptacleEnd.getRole();
            final Property receptaclePart_3 = ((Property) _role_11);
            Type _type = facetPart_3.getType();
            final Property assocProp1 = association.getMemberEnd(null, _type);
            boolean _and_2 = false;
            boolean _notEquals_6 = (!Objects.equal(assocProp1, null));
            if (!_notEquals_6) {
              _and_2 = false;
            } else {
              boolean _isNavigable = assocProp1.isNavigable();
              _and_2 = _isNavigable;
            }
            if (_and_2) {
              StringConcatenation _builder_8 = new StringConcatenation();
              String _nameRef_4 = CppUtils.nameRef(receptaclePart_3);
              _builder_8.append(_nameRef_4, "");
              String _name_6 = assocProp1.getName();
              _builder_8.append(_name_6, "");
              final String setter_3 = _builder_8.toString();
              StringConcatenation _builder_9 = new StringConcatenation();
              _builder_9.append("&");
              String _name_7 = facetPart_3.getName();
              _builder_9.append(_name_7, "");
              final String getter_3 = _builder_9.toString();
              StringConcatenation _builder_10 = new StringConcatenation();
              _builder_10.append(setter_3, "");
              _builder_10.append(" = ");
              _builder_10.append(getter_3, "");
              _builder_10.append(";\\n");
              return _builder_10.toString();
            }
          } else {
            String _name_8 = connector.getName();
            String _plus_1 = ("Connector <" + _name_8);
            String _plus_2 = (_plus_1 + 
              "> does not use ports, but it is not typed (only connectors between ports should not be typed)");
            throw new TransformationException(_plus_2);
          }
        }
      }
    }
    return "";
  }
  
  /**
   * Handle ports with multiplicity > 1. The idea is that we could have
   * multiple connections targeting a receptacle. The first connection would
   * start with index 0. Implementations can make no assumption which
   * connection is associated with a certain index. [want to avoid associative
   * array in runtime].
   * 
   * @param port
   * @param end
   * @return
   */
  public static String getIndexName(final Map<ConnectorEnd, Integer> indexMap, final Port port, final ConnectorEnd end) {
    boolean _or = false;
    int _upper = port.getUpper();
    boolean _greaterThan = (_upper > 1);
    if (_greaterThan) {
      _or = true;
    } else {
      int _upper_1 = port.getUpper();
      boolean _equals = (_upper_1 == (-1));
      _or = _equals;
    }
    if (_or) {
      Integer indexValue = indexMap.get(end);
      boolean _equals_1 = Objects.equal(indexValue, null);
      if (_equals_1) {
        indexValue = Integer.valueOf(0);
        indexMap.put(end, indexValue);
      }
      String index = (indexValue + ", ");
      indexValue++;
      indexMap.put(end, indexValue);
      return index;
    }
    return "";
  }
  
  /**
   * Transform parts if necessary.
   * 
   * @param compositeImplementation
   *            a (composite) component
   */
  @Override
  public void transformParts(final org.eclipse.uml2.uml.Class compositeImplementation) {
    String initPartsBody = "";
    EList<Property> _parts = Utils.getParts(compositeImplementation);
    for (final Property attribute : _parts) {
      {
        final Type type = attribute.getType();
        if ((type instanceof org.eclipse.uml2.uml.Class)) {
          String _initPartsBody = initPartsBody;
          String _initPartBody = this.initPartBody(attribute);
          initPartsBody = (_initPartsBody + _initPartBody);
          attribute.destroy();
        }
      }
    }
    org.eclipse.uml2.uml.Package _top = Utils.getTop(compositeImplementation);
    final NamedElement partManager = Utils.getQualifiedElement(_top, DynamicCppToOO.PART_MANAGER);
    if ((partManager instanceof Type)) {
      compositeImplementation.createOwnedAttribute(DynamicCppToOO.PARTS, ((Type) partManager));
    }
    final Operation operation = compositeImplementation.createOwnedOperation(DynamicCppToOO.INIT_PARTS, null, null);
    String _name = operation.getName();
    String _plus = ("b:" + _name);
    EClass _opaqueBehavior = UMLPackage.eINSTANCE.getOpaqueBehavior();
    Behavior _createOwnedBehavior = compositeImplementation.createOwnedBehavior(_plus, _opaqueBehavior);
    final OpaqueBehavior behavior = ((OpaqueBehavior) _createOwnedBehavior);
    EList<String> _languages = behavior.getLanguages();
    _languages.add(DynamicCppToOO.progLang);
    EList<String> _bodies = behavior.getBodies();
    _bodies.add(initPartsBody);
  }
  
  public String initPartBody(final Property part) {
    String _name = part.getName();
    String _plus = ("parts.add(" + _name);
    String _plus_1 = (_plus + ", ");
    Type _type = part.getType();
    String _plus_2 = (_plus_1 + _type);
    return (_plus_2 + ")");
  }
}
