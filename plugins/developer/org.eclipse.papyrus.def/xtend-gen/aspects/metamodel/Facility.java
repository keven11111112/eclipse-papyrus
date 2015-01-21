package aspects.metamodel;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import metamodel.Facility_qvto;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.codegen.gmfgen.DynamicModelAccess;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.Common;

@Singleton
@SuppressWarnings("all")
public class Facility extends metamodel.Facility {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private Facility_qvto _facility_qvto;
  
  public CharSequence getMethod(final GenPackage it, final DynamicModelAccess dma) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment("@throws IllegalStateException if no EPackage with given URI is registered.");
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public static ");
    CharSequence _className = this.className(dma);
    _builder.append(_className, "");
    _builder.append(" get");
    String _nameToken = this._facility_qvto.getNameToken(it);
    _builder.append(_nameToken, "");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("if (");
    String _fieldName = this._facility_qvto.fieldName(it);
    _builder.append(_fieldName, "\t");
    _builder.append(" == null) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("org.eclipse.emf.ecore.EPackage pkg = getRegistry().getEPackage(\"");
    EPackage _ecorePackage = it.getEcorePackage();
    String _nsURI = _ecorePackage.getNsURI();
    _builder.append(_nsURI, "\t\t");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("if (pkg == null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new IllegalStateException(\"Package ");
    EPackage _ecorePackage_1 = it.getEcorePackage();
    String _name = _ecorePackage_1.getName();
    _builder.append(_name, "\t\t\t");
    _builder.append("(");
    EPackage _ecorePackage_2 = it.getEcorePackage();
    String _nsURI_1 = _ecorePackage_2.getNsURI();
    _builder.append(_nsURI_1, "\t\t\t");
    _builder.append(") not found\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    String _fieldName_1 = this._facility_qvto.fieldName(it);
    _builder.append(_fieldName_1, "\t\t");
    _builder.append(" = new ");
    CharSequence _className_1 = this.className(dma);
    _builder.append(_className_1, "\t\t");
    _builder.append("(pkg);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    String _fieldName_2 = this._facility_qvto.fieldName(it);
    _builder.append(_fieldName_2, "\t\t");
    _builder.append(".init");
    String _nameToken_1 = this._facility_qvto.getNameToken(it);
    _builder.append(_nameToken_1, "\t\t");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return ");
    String _fieldName_3 = this._facility_qvto.fieldName(it);
    _builder.append(_fieldName_3, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
