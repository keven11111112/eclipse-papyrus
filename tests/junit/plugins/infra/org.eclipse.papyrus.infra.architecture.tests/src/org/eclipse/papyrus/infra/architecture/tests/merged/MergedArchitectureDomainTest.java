/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.architecture.tests.merged;

import static org.junit.Assert.assertEquals;

import org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureFactory;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureFramework;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureDomain;
import org.junit.Test;


public class MergedArchitectureDomainTest {

	@Test
	public void testMergeContextSameName() {
		ArchitectureFramework context1 = ArchitectureFactory.eINSTANCE.createArchitectureFramework();
		context1.setName("sameName");
		
		ArchitectureDomain architectureDomain1 = ArchitectureFactory.eINSTANCE.createArchitectureDomain();
		architectureDomain1.getContexts().add(context1);

		ArchitectureFramework context2 = ArchitectureFactory.eINSTANCE.createArchitectureFramework();
		context2.setName("sameName");		
		
		ArchitectureDomain architectureDomain2 = ArchitectureFactory.eINSTANCE.createArchitectureDomain();
		architectureDomain1.getContexts().add(context2);
		
		MergedArchitectureDomain mergedArchitectureDomain = new MergedArchitectureDomain();
		mergedArchitectureDomain.merge(architectureDomain1);
		mergedArchitectureDomain.merge(architectureDomain2);
		assertEquals("Context with same name aren't merged", 1, mergedArchitectureDomain.getContexts().size() );
	}

	@Test
	public void testMergeContextDifferentName() {
		ArchitectureFramework context1 = ArchitectureFactory.eINSTANCE.createArchitectureFramework();
		context1.setName("sameName");		
		
		ArchitectureDomain architectureDomain1 = ArchitectureFactory.eINSTANCE.createArchitectureDomain();
		architectureDomain1.getContexts().add(context1);

		ArchitectureFramework context2 = ArchitectureFactory.eINSTANCE.createArchitectureFramework();
		context2.setName("differentName");			
		
		ArchitectureDomain architectureDomain2 = ArchitectureFactory.eINSTANCE.createArchitectureDomain();
		architectureDomain2.getContexts().add(context2);
		
		MergedArchitectureDomain mergedArchitectureDomain = new MergedArchitectureDomain();
		mergedArchitectureDomain.merge(architectureDomain1);
		mergedArchitectureDomain.merge(architectureDomain2);
		assertEquals("Context with different name are merged", 2, mergedArchitectureDomain.getContexts().size());
	}	
	
}
