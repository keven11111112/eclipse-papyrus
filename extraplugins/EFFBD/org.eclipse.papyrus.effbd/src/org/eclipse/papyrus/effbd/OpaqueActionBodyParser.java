/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier(CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.effbd;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.effbd.command.UpdateOpaqueAction_body;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.uml2.uml.OpaqueAction;

public class OpaqueActionBodyParser implements IParser {

	@Override
	public String getEditString(IAdaptable element, int flags) {
		EObject eObject = EMFHelper.getEObject(element);
		if (eObject instanceof OpaqueAction) {
			return ((OpaqueAction) eObject).getBodies().get(0);
		}
		return "";
	}

	@Override
	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		if (editString != null) {
			return ParserEditStatus.EDITABLE_STATUS;
		}
		return ParserEditStatus.UNEDITABLE_STATUS;
	}

	@Override
	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		EObject eObject = EMFHelper.getEObject(element);
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(eObject);
		UpdateOpaqueAction_body setCommand = new UpdateOpaqueAction_body(editingDomain, (OpaqueAction) eObject, newString);
		return new EMFtoGMFCommandWrapper(setCommand);
	}

	@Override
	public String getPrintString(IAdaptable element, int flags) {
		EObject eObject = EMFHelper.getEObject(element);

		if (eObject instanceof OpaqueAction) {
			if (((OpaqueAction) eObject).getBodies().size() > 0) {
				return ((OpaqueAction) eObject).getBodies().get(0);
			}
		}
		return "";
	}

	@Override
	public boolean isAffectingEvent(Object event, int flags) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		// TODO Auto-generated method stub
		return null;
	}

}
