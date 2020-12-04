/******************************************************************************
 * Copyright (c) 2006, 2020 Borland Software Corporation, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.bridge.wizards.pages;

import java.util.List;

import org.eclipse.papyrus.gmf.mappings.LinkMapping;
import org.eclipse.papyrus.gmf.mappings.NodeMapping;
import org.eclipse.papyrus.gmf.tooldef.AbstractTool;
import org.eclipse.papyrus.gmf.tooldef.CreationTool;
import org.eclipse.papyrus.gmf.tooldef.ToolContainer;
import org.eclipse.papyrus.gmf.tooldef.ToolRegistry;

/**
 * @author artem
 */
public class ToolDefLookup implements ToolDefSupplier {
	private final ToolRegistry myRegistry;
	private final ToolContainer myNodeTools;
	private final ToolContainer myLinkTools;
	private final boolean sameToolContainer; // basically, myNodeTools == myLinkTools
	private int myNodeUseIndex = 0;
	private int myLinkUseIndex = 0;
	

	public ToolDefLookup(ToolRegistry registry) {
		assert registry != null && registry.getPalette() != null;
		myRegistry = registry;
		final List<AbstractTool> tools = myRegistry.getPalette().getTools();
		int i = tools.size();
		boolean found = false;
		while (!found && i > 0) {
			i--;
			if (tools.get(i) instanceof ToolContainer) {
				ToolContainer t = (ToolContainer) tools.get(i);
				found = t.getTools().size() > 0;
			}
		}
		if (!found) {
			myNodeTools = myLinkTools = myRegistry.getPalette();
			sameToolContainer = true;
			return;
		}
		myLinkTools = (ToolContainer) tools.get(i); 
		found = false;
		while (i > 0 && !found) {
			i--;
			if (tools.get(i) instanceof ToolContainer) {
				ToolContainer t = (ToolContainer) tools.get(i);
				found = t.getTools().size() > 0;
			}
		}
		if (!found) {
			myNodeTools = myLinkTools;
			sameToolContainer = true;
		} else {
			sameToolContainer = false;
			myNodeTools = (ToolContainer) tools.get(i);
		}
	}

	public AbstractTool findTool(NodeMapping nm) {
		final int nodeToolsLen = myNodeTools.getTools().size();
		for (int i = 0; i < nodeToolsLen; i++) {
			Object next = myNodeTools.getTools().get((myNodeUseIndex + i) % nodeToolsLen);
			if (isTool(next)) {
				myNodeUseIndex = (myNodeUseIndex + i + 1) % nodeToolsLen;
				if (sameToolContainer) {
					myLinkUseIndex = myNodeUseIndex;
				}
				return (AbstractTool) next;
			}
		}
		return null;
	}

	public AbstractTool findTool(LinkMapping lm) {
		final int linkToolsLen = myLinkTools.getTools().size();
		for (int i = 0; i < linkToolsLen; i++) {
			Object next = myLinkTools.getTools().get((myLinkUseIndex + i) % linkToolsLen);
			if (isTool(next)) {
				myLinkUseIndex = (myLinkUseIndex + i + 1) % linkToolsLen;
				if (sameToolContainer) {
					myNodeUseIndex = myLinkUseIndex;
				}
				return (AbstractTool) next;
			}
		}
		return null;
	}

	private boolean isTool(Object next) {
		return next instanceof CreationTool;
	}

}
