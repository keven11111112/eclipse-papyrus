/*****************************************************************************
 * Copyright (c) 2007-2013 Borland Software Corporation && others
 * 
 * All rights reserved. This program && the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, && is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Alexander Shatalin (Borland) - initial API && implementation
 * Michael Golubev (Borland) - [243151] explicit source/target for links
 *                           - #386838 - migrate to Xtend2
 * 
 *****************************************************************************/
package aspects.xpt.diagram.editpolicies

import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenLinkEnd

@Singleton class Utils_qvto extends xpt.diagram.editpolicies.Utils_qvto {

def Boolean containsCreateStartLinkCommand(GenLinkEnd it){
			for (l : getAllPotentialLinks(it)){
			if(createStartLinkCommand(l, it)){
				return true;
			}
		}
	
	return false;
}

def Boolean containsCreateCompleteLinkCommand(GenLinkEnd it){
			for (l : getAllPotentialLinks(it)){
			if(createCompleteLinkCommand(l, it)){
				return true;
			}
		}
	
	return false;
}


}
