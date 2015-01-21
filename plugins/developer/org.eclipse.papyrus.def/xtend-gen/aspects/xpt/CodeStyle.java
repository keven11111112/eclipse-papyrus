package aspects.xpt;

import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.xtend2.lib.StringConcatenation;

@Singleton
@SuppressWarnings("all")
public class CodeStyle extends xpt.CodeStyle {
  public CharSequence overrideI(final GenCommonBase xptSelf) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Override");
    _builder.newLine();
    return _builder;
  }
}
