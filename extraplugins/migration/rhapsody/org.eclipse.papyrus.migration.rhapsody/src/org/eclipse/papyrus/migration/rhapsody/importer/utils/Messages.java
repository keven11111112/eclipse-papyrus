/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sebastien Revol (CEA LIST) sebastien.revol@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.migration.rhapsody.importer.utils;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	static {
		NLS.initializeMessages("org.eclipse.papyrus.migration.rhapsody.importer.utils.messages", Messages.class); //$NON-NLS-1$
	}

	private Messages() {
	}
	
	
	public static String IgnoredSubFile;
	
	public static String FailedToLoadProject;
	public static String FailedToLoadTable;
	public static String FailedToLoadResource;

	public static String RhpNotFound;

	public static String RhapsodyHome;
	public static String ResourceLoading;

	public static String GenericFileNotFound;
	public static String FileNotFoundHandleReference;

	public static String NotFoundIDReference;

	public static String FileNotFoundElementReference;

	public static String FileAliasNotResolved;
	
	public static  String UnknownExtension;
	
	public static String IDNotFoundInHandleRefAndInFileTable ;
	public static String FeatureNotFound; 

}