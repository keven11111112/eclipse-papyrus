/**
 * Copyright (c) 2011 - 2013 Montages AG
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Svyatoslav Kovalsky (Montages) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.impl.diagram.editparts;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenParserImplementation;
import org.eclipse.gmf.codegen.gmfgen.LabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.OclChoiceParser;
import org.eclipse.gmf.codegen.gmfgen.PredefinedEnumParser;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.Common_qvto;

@Singleton
@SuppressWarnings("all")
public class ChoiceUtils_qvto extends impl.diagram.editparts.ChoiceUtils_qvto {
  @Inject
  @Extension
  private Common_qvto _common_qvto;
  
  public boolean isChoiceLabel(final LabelModelFacet modelFacet) {
    GenParserImplementation parser = modelFacet.getParser();
    boolean _notEquals = (!Objects.equal(parser, null));
    if (_notEquals) {
      boolean _or = false;
      boolean _oclIsKindOf = this._common_qvto.oclIsKindOf(parser, PredefinedEnumParser.class);
      if (_oclIsKindOf) {
        _or = true;
      } else {
        boolean _oclIsKindOf_1 = this._common_qvto.oclIsKindOf(parser, OclChoiceParser.class);
        _or = _oclIsKindOf_1;
      }
      return _or;
    } else {
      return false;
    }
  }
}
