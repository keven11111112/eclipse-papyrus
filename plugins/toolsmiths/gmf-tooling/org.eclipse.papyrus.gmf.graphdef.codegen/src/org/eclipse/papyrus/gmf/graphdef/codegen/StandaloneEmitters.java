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
 *    Michael Golubev (Borland) - initial API and implementation
 *    Artem Tikhomirov (Borland) - migrating JET-Xpand
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.graphdef.codegen;

import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.papyrus.gmf.common.UnexpectedBehaviourException;
import org.eclipse.papyrus.gmf.graphdef.codegen.StandaloneGenerator.Config;
import org.eclipse.papyrus.gmf.internal.common.codegen.TextEmitter;
import org.eclipse.papyrus.gmf.internal.common.codegen.XpandTextEmitter;
import org.eclipse.papyrus.gmf.internal.graphdef.codegen.Activator;
import org.eclipse.papyrus.gmf.internal.xpand.ResourceManager;

class StandaloneEmitters {
	private final ResourceManager myResourceManager;

	StandaloneEmitters(MapModeCodeGenStrategy mapModeStrategy, URL[] dynamicTemplates) {
		assert mapModeStrategy != null;
		myResourceManager = Activator.createResourceEngine(mapModeStrategy, dynamicTemplates);
	}
	
	public TextEmitter getBuildPropertiesEmitter() throws UnexpectedBehaviourException {
		return new XpandTextEmitter(myResourceManager, "plugin::BuildProperties", "Init");
	}
	
	public TextEmitter getPluginPropertiesEmitter() throws UnexpectedBehaviourException {
		return new XpandTextEmitter(myResourceManager, "plugin::PluginProperties", "Init") {
			@Override
			protected Object[] extractArguments(Object[] arguments) {
				assert arguments != null && arguments.length > 0 && arguments[0] instanceof Config;
				Config config = (Config) arguments[0];
				return new Object[] {
					config.getPluginFriendlyName(),
					config.getPluginProviderName()
				};
			}
		};
	}
	
	public TextEmitter getManifestMFEmitter() throws UnexpectedBehaviourException {
		return new XpandTextEmitter(myResourceManager, "plugin::Manifest", "Init") {
			@Override
			protected Object[] extractArguments(Object[] arguments) {
				assert arguments != null && arguments.length > 1 && arguments[0] instanceof Config && arguments[1] instanceof String[];
				Config config = (Config) arguments[0];
				List<String> exportedPackages = (config.getMainPackageName() == null || config.getMainPackageName().trim().length() == 0) ? Collections.singletonList(config.getPluginActivatorPackageName()) : Arrays.asList(config.getPluginActivatorPackageName(), config.getMainPackageName());
				List<String> referencedBundles = Arrays.asList((String[]) arguments[1]);
				return new Object[] {
					config.getPluginID(),
					config.getPluginActivatorPackageName() + '.' + config.getPluginActivatorClassName(),
					exportedPackages,
					referencedBundles
				};
			}
		};
	}
	
	public TextEmitter getPluginActivatorEmitter() throws UnexpectedBehaviourException {
		return new XpandTextEmitter(myResourceManager, "plugin::Activator", "Init") {
			@Override
			protected Object extractTarget(Object[] arguments) {
				assert arguments != null && arguments.length >= 2;
				assert arguments[2] instanceof List<?>;
				return arguments[2];
			}
			@Override
			protected Object[] extractArguments(Object[] arguments) {
				assert arguments != null && arguments.length > 0 && arguments[0] instanceof Config;
				Config config = (Config) arguments[0];
				return new Object[] {
					config.getPluginActivatorPackageName(),
					config.getPluginActivatorClassName(),
					config.getPluginID(),
				};
			}
		};
	}
}
