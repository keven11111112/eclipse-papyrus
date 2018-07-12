/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.types.core.impl;

import org.eclipse.gmf.runtime.emf.type.core.AdviceBindingInheritance;
import org.eclipse.gmf.runtime.emf.type.core.IContainerDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.papyrus.infra.types.AdviceConfiguration;
import org.eclipse.papyrus.infra.types.core.IConfiguredEditHelperAdviceDescriptor;

public class ConfiguredEditHelperAdviceDescriptor<T extends AdviceConfiguration> implements IConfiguredEditHelperAdviceDescriptor<T> {

	protected T editHelperAdviceConfiguration;

	protected String id;

	protected String typeId;

	protected IElementMatcher matcher;

	protected IContainerDescriptor containerDescriptor;

	protected IEditHelperAdvice editHelperAdvice;

	protected AdviceBindingInheritance inheritance;

	public ConfiguredEditHelperAdviceDescriptor(String id, String typeId, IElementMatcher matcher, IContainerDescriptor containerDescriptor, IEditHelperAdvice editHelperAdvice, AdviceBindingInheritance inheritance) {
		this.id = id;
		this.typeId = typeId;
		this.matcher = matcher;
		this.containerDescriptor = containerDescriptor;
		this.editHelperAdvice = editHelperAdvice;
		this.inheritance = inheritance;
	}

	public String getId() {
		return this.id;
	}

	public String getTypeId() {
		return this.typeId;
	}

	public IElementMatcher getMatcher() {
		return this.matcher;
	}

	public IContainerDescriptor getContainerDescriptor() {
		return this.containerDescriptor;
	}

	public IEditHelperAdvice getEditHelperAdvice() {
		return this.editHelperAdvice;
	}

	public AdviceBindingInheritance getInheritance() {
		return this.inheritance;
	}

	public void init(T editHelperAdviceConfiguration) {
		this.editHelperAdviceConfiguration = editHelperAdviceConfiguration;
	}
}
