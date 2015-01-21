/**
 * Copyright (c) 2007, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 * 	  Thibault Landre (Atos Origin) - initial API and implementation
 *    Patrick Tessier (CEA LIST)
 */
package aspects.xpt.diagram.preferences;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.xtext.xbase.lib.Extension;
import plugin.Activator;
import xpt.Common;

@Singleton
@SuppressWarnings("all")
public class PreferenceInitializer extends xpt.diagram.preferences.PreferenceInitializer {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  private Activator xptActivator;
}
