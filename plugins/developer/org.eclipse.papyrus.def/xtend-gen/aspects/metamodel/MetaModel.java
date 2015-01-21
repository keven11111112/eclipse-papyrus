package aspects.metamodel;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import metamodel.MetaModel_qvto;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@Singleton
@SuppressWarnings("all")
public class MetaModel extends metamodel.MetaModel {
  @Inject
  @Extension
  private MetaModel_qvto _metaModel_qvto;
  
  public CharSequence DeclareAndAssign2(final GenClass it, final String assignee, final String src, final GenClass srcMetaClass, final GenFeature srcFeature, final String srcExt, final boolean needCast) {
    StringConcatenation _builder = new StringConcatenation();
    String _qualifiedInterfaceName = this._metaModel_qvto.getQualifiedInterfaceName(it);
    _builder.append(_qualifiedInterfaceName, "");
    _builder.append(" ");
    _builder.append(assignee, "");
    _builder.append(" = ");
    CharSequence _featureValue = this.getFeatureValue(srcFeature, src, srcMetaClass);
    _builder.append(_featureValue, "");
    _builder.append(".");
    _builder.append(srcExt, "");
    _builder.append(";");
    return _builder;
  }
}
