package aspects.xpt;

import com.google.inject.Singleton;
import java.util.Arrays;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.xtend2.lib.StringConcatenation;

@Singleton
@SuppressWarnings("all")
public class QualifiedClassNameProvider extends xpt.QualifiedClassNameProvider {
  protected CharSequence _getItemSemanticEditPolicyQualifiedClassName(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultCompartmentSemanticEditPolicy");
    return _builder;
  }
  
  protected CharSequence _getItemSemanticEditPolicyQualifiedClassName(final GenCompartment it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultCompartmentSemanticEditPolicy");
    return _builder;
  }
  
  protected CharSequence _getItemSemanticEditPolicyQualifiedClassName(final GenLink it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultSemanticEditPolicy");
    return _builder;
  }
  
  protected CharSequence _getItemSemanticEditPolicyQualifiedClassName(final GenNode it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultSemanticEditPolicy");
    return _builder;
  }
  
  public CharSequence getItemSemanticEditPolicyQualifiedClassName(final GenCommonBase it) {
    if (it instanceof GenCompartment) {
      return _getItemSemanticEditPolicyQualifiedClassName((GenCompartment)it);
    } else if (it instanceof GenNode) {
      return _getItemSemanticEditPolicyQualifiedClassName((GenNode)it);
    } else if (it instanceof GenDiagram) {
      return _getItemSemanticEditPolicyQualifiedClassName((GenDiagram)it);
    } else if (it instanceof GenLink) {
      return _getItemSemanticEditPolicyQualifiedClassName((GenLink)it);
    } else if (it != null) {
      return _getItemSemanticEditPolicyQualifiedClassName(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
