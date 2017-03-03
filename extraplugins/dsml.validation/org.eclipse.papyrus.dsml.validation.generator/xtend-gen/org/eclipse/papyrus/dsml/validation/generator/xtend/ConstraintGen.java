package org.eclipse.papyrus.dsml.validation.generator.xtend;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import java.util.Iterator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.dsml.validation.model.profilenames.Utils;
import org.eclipse.papyrus.infra.tools.file.IPFileSystemAccess;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * A generator for Java based constraints
 */
@SuppressWarnings("all")
public class ConstraintGen {
  public static CharSequence generateConstraint(final Constraint constraint) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Created by the Papyrus DSML plugin generator");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.newLine();
    _builder.append("package ");
    String _topPkg = Utils.getTopPkg();
    _builder.append(_topPkg);
    _builder.append(".constraints;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.core.runtime.IStatus;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.validation.AbstractModelConstraint;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.validation.IValidationContext;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EObject;");
    _builder.newLine();
    {
      boolean _isStaticProfile = Utils.isStaticProfile();
      boolean _not = (!_isStaticProfile);
      if (_not) {
        _builder.append("import org.eclipse.uml2.uml.Element;");
        _builder.newLine();
        _builder.append("import org.eclipse.uml2.uml.Stereotype;");
        _builder.newLine();
        _builder.append("import org.eclipse.uml2.uml.util.UMLUtil;");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("public class ");
    String _name = constraint.getName();
    _builder.append(_name);
    _builder.append("Constraint extends AbstractModelConstraint {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public IStatus validate(IValidationContext ctx) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("EObject target = ctx.getTarget();");
    _builder.newLine();
    _builder.newLine();
    {
      Boolean _isConstraintForStereotype = Utils.isConstraintForStereotype(constraint);
      if ((_isConstraintForStereotype).booleanValue()) {
        _builder.append("\t\t");
        final String qStereotypeName = Utils.getConstraintForStereotype(constraint);
        _builder.newLineIfNotEmpty();
        {
          boolean _isStaticProfile_1 = Utils.isStaticProfile();
          if (_isStaticProfile_1) {
            _builder.append("\t\t");
            final String qStereotypeNameJava = qStereotypeName.replace("::", ".");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("if (target instanceof ");
            _builder.append(qStereotypeNameJava, "\t\t");
            _builder.append(") {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("if (evaluateConstraint((");
            _builder.append(qStereotypeNameJava, "\t\t\t");
            _builder.append(") target)) {");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t\t");
            _builder.append("Stereotype stereotype = UMLUtil.getStereotype(target);");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("if (stereotype.getQualifiedName().equals(\"");
            _builder.append(qStereotypeName, "\t\t");
            _builder.append("\")) { //$NON-NLS-1$");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("Element element = UMLUtil.getBaseElement(target);");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("if (evaluateConstraint(element, stereotype)) {");
            _builder.newLine();
          }
        }
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("return ctx.createSuccessStatus();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("else {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("return ctx.createFailureStatus(\"\"); //$NON-NLS-1$ failure message is in plugin.xml");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return ctx.createSuccessStatus();");
        _builder.newLine();
      } else {
        _builder.append("\t\t");
        _builder.append("if (evaluateConstraint(target)) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("return ctx.createSuccessStatus();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("else {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("return ctx.createFailureStatus(\"\"); //$NON-NLS-1$ failure message is in plugin.xml");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      Boolean _isConstraintForStereotype_1 = Utils.isConstraintForStereotype(constraint);
      if ((_isConstraintForStereotype_1).booleanValue()) {
        {
          boolean _isStaticProfile_2 = Utils.isStaticProfile();
          if (_isStaticProfile_2) {
            _builder.append("\t");
            final String qStereotypeName_1 = Utils.getConstraintForStereotype(constraint);
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            final String qStereotypeNameJava_1 = qStereotypeName_1.replace("::", ".");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("private boolean evaluateConstraint(");
            _builder.append(qStereotypeNameJava_1, "\t");
            _builder.append(" self) {");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t");
            _builder.append("private boolean evaluateConstraint(Element self, Stereotype appliedStereotype) {");
            _builder.newLine();
          }
        }
        {
          String _javaConstraintBody = Utils.getJavaConstraintBody(constraint.getSpecification());
          boolean _notEquals = (!Objects.equal(_javaConstraintBody, null));
          if (_notEquals) {
            _builder.append("\t");
            _builder.append("\t");
            String _javaConstraintBody_1 = Utils.getJavaConstraintBody(constraint.getSpecification());
            _builder.append(_javaConstraintBody_1, "\t\t");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return true;");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      Boolean _isConstraintForStereotype_2 = Utils.isConstraintForStereotype(constraint);
      boolean _not_1 = (!(_isConstraintForStereotype_2).booleanValue());
      if (_not_1) {
        _builder.append("\t");
        _builder.append("private boolean evaluateConstraint(EObject self) {");
        _builder.newLine();
        {
          String _javaConstraintBody_2 = Utils.getJavaConstraintBody(constraint.getSpecification());
          boolean _notEquals_1 = (!Objects.equal(_javaConstraintBody_2, null));
          if (_notEquals_1) {
            _builder.append("\t");
            _builder.append("\t");
            String _javaConstraintBody_3 = Utils.getJavaConstraintBody(constraint.getSpecification());
            _builder.append(_javaConstraintBody_3, "\t\t");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return true;");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * @see org.eclipse.xtext.generator.IGenerator#doGenerate(org.eclipse.emf.ecore.resource.Resource, org.eclipse.xtext.generator.IFileSystemAccess)
   * 
   * @param input
   * @param fsa
   */
  public static void generate(final Resource input, final IPFileSystemAccess fsa) {
    final Iterator<Constraint> contentIterator = Iterators.<Constraint>filter(input.getAllContents(), Constraint.class);
    while (contentIterator.hasNext()) {
      {
        final Constraint constraint = contentIterator.next();
        Boolean _hasSpecificationForJava = Utils.hasSpecificationForJava(constraint);
        if ((_hasSpecificationForJava).booleanValue()) {
          String _name = constraint.getName();
          boolean _equals = Objects.equal(_name, null);
          if (_equals) {
            String _qualifiedName = constraint.getContext().getQualifiedName();
            String _plus = ("Constraint has no name, context: " + _qualifiedName);
            throw new RuntimeException(_plus);
          }
          String _replaceAll = Utils.getTopPkg().replaceAll("\\.", "/");
          String _plus_1 = (_replaceAll + "/constraints/");
          String _name_1 = constraint.getName();
          String _plus_2 = (_plus_1 + _name_1);
          final String fileName = (_plus_2 + 
            "Constraint.java");
          fsa.generateFile(fileName, ConstraintGen.generateConstraint(constraint).toString());
        }
      }
    }
  }
}
