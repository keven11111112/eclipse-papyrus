/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.common.sync;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.EObjectValueStyle;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.StringValueStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.tools.util.TypeUtils;

/**
 * Utilities for working with the synchronization-related {@link NamedStyle}s.
 */
public class SyncStyles {
	// A style name that is compatible with the conventions for CSS attributes
	private static final String SYNC_STYLE_NAME = "papyrus-diagram-sync"; //$NON-NLS-1$

	/**
	 * Not instantiable by clients.
	 */
	private SyncStyles() {
		super();
	}

	static NamedStyle getSyncStyle(View view) {
		return view.getNamedStyle(NotationPackage.Literals.STRING_VALUE_STYLE, SYNC_STYLE_NAME);
	}

	public static SyncKind getSyncKind(View view) {
		SyncKind result = SyncKind.NONE;

		NamedStyle style = view.getNamedStyle(NotationPackage.Literals.STRING_VALUE_STYLE, SYNC_STYLE_NAME);
		if (style != null) {
			result = SyncKind.forStyle(style);
		}

		return result;
	}

	public static View getMaster(NamedStyle slaveStyle) {
		View result = null;

		if (slaveStyle instanceof EObjectValueStyle) {
			result = TypeUtils.as(((EObjectValueStyle) slaveStyle).getEObjectValue(), View.class);
		}

		return result;
	}

	public static void clearSync(View view) {
		NamedStyle syncStyle = getSyncStyle(view);
		if (syncStyle != null) {
			EcoreUtil.remove(syncStyle);
		}
	}

	public static NamedStyle setSync(View view) {
		return setSync(view, SyncKind.PEER);
	}

	private static NamedStyle setSync(View view, SyncKind kind) {
		StringValueStyle result = null;

		clearSync(view);

		if (kind != SyncKind.NONE) {
			result = (StringValueStyle) view.createStyle(NotationPackage.Literals.STRING_VALUE_STYLE);
			result.setName(SYNC_STYLE_NAME);
			result.setStringValue(kind.styleKey());
		}

		return result;
	}

	public static NamedStyle setSyncMaster(View view) {
		return setSync(view, SyncKind.MASTER);
	}

	public static NamedStyle setSyncSlave(View view) {
		return setSync(view, SyncKind.SLAVE);
	}

	public static Command getSyncCommand(final View view, final SyncKind kind) {
		return new AbstractCommand("Configure Synchronization") {
			private SyncKind previousKind;

			@Override
			protected boolean prepare() {
				previousKind = getSyncKind(view);
				return true;
			}

			@Override
			public void execute() {
				setSync(view, kind);
			}

			@Override
			public void undo() {
				setSync(view, previousKind);
			}

			@Override
			public void redo() {
				setSync(view, kind);
			}
		};
	}
}
