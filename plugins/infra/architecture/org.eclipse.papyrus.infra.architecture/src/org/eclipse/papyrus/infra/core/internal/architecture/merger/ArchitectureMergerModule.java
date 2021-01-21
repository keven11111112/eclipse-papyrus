/*****************************************************************************
 * Copyright (c) 2021 Christian W. Damus, CEA LIST, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.internal.architecture.merger;

import java.util.function.BiConsumer;

import org.eclipse.papyrus.infra.core.architecture.ADElement;
import org.eclipse.papyrus.infra.core.architecture.util.MergeTraceAdapter;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

/**
 * Guice module for configuration of the {@link InternalArchitectureDomainMerger}.
 */
public class ArchitectureMergerModule extends AbstractModule {

	static final String MERGE_TRACE = "MERGE_TRACE"; //$NON-NLS-1$

	public ArchitectureMergerModule() {
		super();
	}

	@Override
	protected final void configure() {
		basicConfigure();
		doConfigure();
	}

	private void basicConfigure() {
		bindMergeTraces();
	}

	private void bindMergeTraces() {
		MergeTraces traces = new MergeTraces();
		bind(MergeTraces.class).toInstance(traces);
		bind(MergeTraceAdapter.class).toInstance(traces);

		TypeLiteral<BiConsumer<? super ADElement, ? super ADElement>> mergeTracerType = new TypeLiteral<>() {
		};
		BiConsumer<? super ADElement, ? super ADElement> mergeTracer = traces::trace;
		bind(mergeTracerType).annotatedWith(Names.named(MERGE_TRACE)).toInstance(mergeTracer);
	}

	/**
	 * Overridden by subclasses to add further bindings. The default implementation does nothing.
	 */
	protected void doConfigure() {
		// Pass
	}

}
