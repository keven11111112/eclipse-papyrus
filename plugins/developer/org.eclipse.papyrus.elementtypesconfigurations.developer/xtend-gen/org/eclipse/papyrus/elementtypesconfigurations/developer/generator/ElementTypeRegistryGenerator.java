package org.eclipse.papyrus.elementtypesconfigurations.developer.generator;

import com.google.common.collect.Iterables;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@SuppressWarnings("all")
public class ElementTypeRegistryGenerator {
  public static Iterable<EObject> allContentsIterable(final Resource resource) {
    TreeIterator<EObject> _allContents = resource.getAllContents();
    return IteratorExtensions.<EObject>toIterable(_allContents);
  }
  
  public static String camelToUnderScore(final String in) {
    String regex = "([a-z])([A-Z])";
    String replacement = "$1_$2";
    return in.replaceAll(regex, replacement);
  }
  
  public static String safeName(final String in) {
    String result = ElementTypeRegistryGenerator.camelToUnderScore(in);
    String _replaceAll = result.replaceAll("[^A-Za-z0-9]", "_");
    result = _replaceAll;
    String _replaceAll_1 = result.replaceAll("_{2,}", "_");
    result = _replaceAll_1;
    String _upperCase = result.toUpperCase();
    result = _upperCase;
    String _replaceAll_2 = result.replaceAll("UML_", "");
    result = _replaceAll_2;
    return result;
  }
  
  public static CharSequence generateRegistry(final Resource it, final String outputType) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*****************************************************************************");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Copyright (c) 2014 CEA LIST.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* All rights reserved. This program and the accompanying materials");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* are made available under the terms of the Eclipse Public License v1.0");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* which accompanies this distribution, and is available at");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* http://www.eclipse.org/legal/epl-v10.html");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Contributors:");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* \t\tCEA LIST - Initial API and implementation");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*****************************************************************************/");
    _builder.newLine();
    _builder.append("import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;");
    _builder.newLine();
    _builder.append("import org.eclipse.gmf.runtime.emf.type.core.IHintedType;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    _builder.append(outputType, "");
    _builder.append(" extends AbstractElementTypeEnumerator {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/** Constant for UML nature */");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static final String UML_NATURE = \"UML_Nature\";");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      Iterable<EObject> _allContentsIterable = ElementTypeRegistryGenerator.allContentsIterable(it);
      Iterable<ElementTypeConfiguration> _filter = Iterables.<ElementTypeConfiguration>filter(_allContentsIterable, ElementTypeConfiguration.class);
      for(final ElementTypeConfiguration elementTypeConfiguration : _filter) {
        _builder.append("\t");
        _builder.append("public static final IHintedType ");
        String _name = elementTypeConfiguration.getName();
        String _safeName = ElementTypeRegistryGenerator.safeName(_name);
        String _upperCase = _safeName.toUpperCase();
        _builder.append(_upperCase, "\t");
        _builder.append(" = (IHintedType)getElementType(\"");
        String _identifier = elementTypeConfiguration.getIdentifier();
        _builder.append(_identifier, "\t");
        _builder.append("\"); //$NON-NLS-1$");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
