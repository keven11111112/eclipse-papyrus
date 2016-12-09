/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   vincent.lorenzo@cea.fr (CEA LIST) - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.migration.rhapsody.utils;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.migration.rhapsody.Activator;
import org.eclipse.papyrus.migration.rhapsody.importer.utils.RpyProjectHandler;
import org.eclipse.papyrus.migration.rhapsody.messages.Messages;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

/**
 * This class allows to check if the given Rhapsody Folder is valid
 *
 */
public class RhapsodyShareFolderUtils {

	private static final String SELECT_FOLDER_TITLE = Messages.RhapsodyShareFolderUtils_PapyrusRhapsodyImporter_DialogTitle;

	private static final String SELECT_FOLDER_MESSAGE = Messages.RhapsodyShareFolderUtils_PapyrusRhapsodyImporter_DialogMessage;

	private static final String MESSAGE = "The given path is not the good one. Retry (Yes)/ Cancel (No)";

	/** The name of the tested files and folders allowing to decide if the given path is the Rhapsody Share folder */
	private static final String SHARE = "Share";//$NON-NLS-1$
	private static final String PROFILES_FOLDER = "Profiles"; //$NON-NLS-1$
	private static final String SYSML_PROFILE_FOLDER = "SysML"; //$NON-NLS-1$
	private static final String SYSML_PROFILE_FILE = "SysMLProfile.rpy"; //$NON-NLS-1$
	private static final String MARTE_PROFILE_FOLDER = "MARTE"; //$NON-NLS-1$

	private static final String PROPERTIES_FOLDER = "Properties"; //$NON-NLS-1$
	private static final String PREDEFINED_C_TYPE_FILE = "PredefinedTypesC.sbs"; //$NON-NLS-1$
	private static final String PREDEFINED_CPP_TYPE_FILE = "PredefinedTypesC++.sbs"; //$NON-NLS-1$

	private static final String RHAPSODY_HOME_VARIABLE_NAME = "RhapsodyHome"; //$NON-NLS-1$


	/**
	 * Constructor.
	 *
	 */
	private RhapsodyShareFolderUtils() {
		// to prevent instanciation
	}

	/**
	 * This method check if the path for the Rhapsody folder is saved in the preference.
	 * <ul>
	 * <li>if <code>true</code> : we do nothing</li>
	 * <li>if <code>false</code> : we read the System properties, to check if this information has been set in the eclipse.ini</li>
	 * <ul>
	 * <li>if <code>true</code> and if it is a correct value, we store it as preference</li>
	 * <li>if <code>false</code> : we do nothing</li>
	 * </ul>
	 * </ul>
	 */
	public static final void registerRhapsodySharedFolderFromEclipseInitIfRequired() {
		final ScopedPreferenceStore prefStore = (ScopedPreferenceStore) Activator.getDefault().getPreferenceStore();
		prefStore.setDefault(RHAPSODY_HOME_VARIABLE_NAME, "");
		final String prefValue = prefStore.getString(RHAPSODY_HOME_VARIABLE_NAME);
		if (null == prefValue || prefValue.isEmpty()) {
			final String propertyValue = System.getProperty(RHAPSODY_HOME_VARIABLE_NAME);
			if (propertyValue != null && !propertyValue.isEmpty()) {
				final String rhpInstall = normalizePath(propertyValue);
				if (isARhapsodySharedFolder(rhpInstall).isOK()) {
					prefStore.putValue(RHAPSODY_HOME_VARIABLE_NAME, rhpInstall);
					try {
						prefStore.save();
					} catch (IOException e) {
						Activator.log.error(e);
					}
				}
			}
		}
	}


	public static final boolean checkRhapsodyShareFolderAndAskForItWhenRequired() {
		boolean finalResult = null != RhapsodyShareFolderUtils.getRhapsodyShareFolder();
		if (!finalResult) {
			final String result = browseFileSystemForRhapsodyShareFolder(Display.getDefault().getActiveShell(), "");
			if (null != result && !result.isEmpty()) {
				boolean isOk = isARhapsodySharedFolder(result).isOK();
				if (isOk) {
					registerRhapsodyShareFolderFromString(result);
					finalResult = true;
				}
			}
			if (!finalResult) {
				boolean res = MessageDialog.openQuestion(Display.getDefault().getActiveShell(), SELECT_FOLDER_TITLE, MESSAGE);
				if (res) {
					finalResult = checkRhapsodyShareFolderAndAskForItWhenRequired();
				}
			}
		}
		return finalResult;
	}

	public static final String browseFileSystemForRhapsodyShareFolder(final Shell parentShell, final String initialPath) {
		DirectoryDialog dialog = new DirectoryDialog(parentShell);
		dialog.setFilterPath(initialPath);
		dialog.setText(SELECT_FOLDER_TITLE);
		dialog.setMessage(SELECT_FOLDER_MESSAGE);
		String result = dialog.open();
		return result;
	}

	/**
	 * This method register the Rhapsody share folder
	 * 
	 * @param shareFolderPath
	 *            the share folder path
	 */
	public static final void registerRhapsodyShareFolderFromString(final String shareFolderPath) {
		final ScopedPreferenceStore prefStore = (ScopedPreferenceStore) Activator.getDefault().getPreferenceStore();
		prefStore.setValue(RHAPSODY_HOME_VARIABLE_NAME, shareFolderPath);
		try {
			prefStore.save();
		} catch (IOException e) {
			Activator.log.error(e);
		}
	}

	/**
	 * 
	 * @return the path for the Rhapsody Share folder or <code>null</code> when it is not fill
	 */
	public static final String getRhapsodyShareFolder() {
		final String rhpShareFolder = Activator.getDefault().getPreferenceStore().getString(RHAPSODY_HOME_VARIABLE_NAME);
		if (null != rhpShareFolder && !rhpShareFolder.isEmpty()) {
			return rhpShareFolder;
		}
		return null;
	}

	/**
	 * 
	 * @param shareFolderPath
	 *            the path for the share folder defined as JVM args
	 * @return
	 * 		the path removing the backslashed chars
	 */
	private static final String normalizePath(final String shareFolderPath) {
		String rhpInstall = shareFolderPath.replaceAll("\\\\\\\\", "\\\\"); //$NON-NLS-1$ //$NON-NLS-2$
		rhpInstall = rhpInstall.replaceAll("//", "/"); //$NON-NLS-1$ //$NON-NLS-2$
		return rhpInstall;
	}

	/**
	 * 
	 * @param path
	 *            a path
	 * @return
	 * 		<code>true</code> if the path is the Rhapsody SysML Share Folder. In this case, it should contains predefined types library, SysML profile and a Marte folder
	 */
	public static final IStatus isARhapsodySharedFolder(final String path) {
		IStatus status;
		if (path.endsWith(SHARE)) {
			final File file = new File(path);
			// final File file2 = new File(uri);
			if (file.exists()) {
				status = checkSysMLProfileFile(path);
				if (status.isOK()) {
					status = checkPredefinedCType(path);
				}
				if (status.isOK()) {
					status = checkPredefinedCppType(path);
				}
				if (status.isOK()) {
					status = checkMarteFolder(path);
				}
			} else {
				status = createFolderErrorStatusFor(path, false);
			}
		} else {
			status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind("The given folder is not named \"{0}\".", SHARE));
		}
		return status;
	}

	/**
	 * 
	 * @param RhapsodyShareFolderPath
	 * @return
	 * 		<code>true</code> if the Rhaposdy SysML Profiles has been found
	 */
	public static final IStatus checkSysMLProfileFile(final String RhapsodyShareFolderPath) {
		IPath path = new Path(RhapsodyShareFolderPath);
		path = path.append(PROFILES_FOLDER);
		path = path.append(SYSML_PROFILE_FOLDER);
		path = path.append(SYSML_PROFILE_FILE);
		if (path.toFile().exists()) {
			return createFileOKStatusFor(path.toOSString(), false);
		}
		return createFileErrorStatusFor(path.toOSString(), false);
	}

	/**
	 * 
	 * @param RhapsodyShareFolderPath
	 * @return
	 * 		<code>true</code> if the Rhaposdy Predefined C Types file has been found
	 */
	public static final IStatus checkPredefinedCType(final String RhapsodyShareFolderPath) {
		IPath path = new Path(RhapsodyShareFolderPath);
		path = path.append(PROPERTIES_FOLDER);
		path = path.append(PREDEFINED_C_TYPE_FILE);
		if (path.toFile().exists()) {
			return createFileOKStatusFor(path.toOSString(), false);
		}
		return createFileErrorStatusFor(path.toOSString(), false);
	}

	/**
	 * 
	 * @param RhapsodyShareFolderPath
	 * @return
	 * 		<code>true</code> if the Rhaposdy Predefined CPP Types file has been found
	 */
	public static final IStatus checkPredefinedCppType(final String RhapsodyShareFolderPath) {
		IPath path = new Path(RhapsodyShareFolderPath);
		path = path.append(PROPERTIES_FOLDER);
		path = path.append(PREDEFINED_CPP_TYPE_FILE);
		if (path.toFile().exists()) {
			return createFileOKStatusFor(path.toOSString(), false);
		}
		return createFileErrorStatusFor(path.toOSString(), false);
	}

	/**
	 * 
	 * @param RhapsodyShareFolderPath
	 * @return
	 * 		<code>true</code> if the Rhaposdy Marte folder has been found
	 */
	public static final IStatus checkMarteFolder(final String RhapsodyShareFolderPath) {
		IPath path = new Path(RhapsodyShareFolderPath);
		path = path.append(PROFILES_FOLDER);
		path = path.append(MARTE_PROFILE_FOLDER);
		if (path.toFile().exists()) {
			return createFolderOKStatusFor(path.toOSString(), false);
		}
		return createFolderErrorStatusFor(path.toOSString(), false);
	}


	private static IStatus createFileErrorStatusFor(final String name, final boolean isMulti) {
		if (isMulti) {
			return new MultiStatus(Activator.PLUGIN_ID, IStatus.OK, NLS.bind("The required file \"{0}\" doesn't exist in the \"{1}\" folder.", name, SHARE), null); //$NON-NLS-1$
		}
		return new Status(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind("The required file \"{0}\" doesn't exist in the \"{1}\" folder.", name, SHARE)); //$NON-NLS-1$
	}

	private static IStatus createFolderErrorStatusFor(final String name, final boolean isMulti) {
		if (isMulti) {
			return new MultiStatus(Activator.PLUGIN_ID, IStatus.OK, NLS.bind("The required folder \"{0}\" doesn't exist in the \"{1}\" folder.", name, SHARE), null); //$NON-NLS-1$
		}
		return new Status(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind("The required folder \"{0}\" doesn't exist in the \"{1}\" folder.", name, SHARE)); //$NON-NLS-1$
	}

	private static IStatus createFileOKStatusFor(final String name, final boolean isMulti) {
		if (isMulti) {
			return new MultiStatus(Activator.PLUGIN_ID, IStatus.OK, NLS.bind("The required file \"{0}\" doesn't exist in the \"{1}\" folder.", name, SHARE), null); //$NON-NLS-1$
		}
		return new Status(IStatus.OK, Activator.PLUGIN_ID, NLS.bind("The required file \"{0}\" doesn't exist in the \"{1}\" folder.", name, SHARE)); //$NON-NLS-1$
	}

	private static IStatus createFolderOKStatusFor(final String name, final boolean isMulti) {
		if (isMulti) {
			return new MultiStatus(Activator.PLUGIN_ID, IStatus.OK, NLS.bind("The required folder \"{0}\" doesn't exist in the \"{1}\" folder.", name, SHARE), null); //$NON-NLS-1$
		}
		return new Status(IStatus.OK, Activator.PLUGIN_ID, NLS.bind("The required folder \"{0}\" doesn't exist in the \"{1}\" folder.", name, SHARE)); //$NON-NLS-1$
	}
}
