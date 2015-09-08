package org.eclipse.papyrus.dev.project.management.handlers.plugins;

import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.dev.project.management.Activator;
import org.eclipse.papyrus.dev.project.management.handlers.AbstractChangeProjectVersionHandler;
import org.eclipse.papyrus.dev.project.management.utils.Utils;
import org.eclipse.papyrus.eclipse.project.editors.file.ManifestEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IManifestEditor;


public class ChangePluginVersionHandler extends AbstractChangeProjectVersionHandler {


	@Override
	protected void setVersionNumber(final IProject project, final String newVersion, String notManagedProjectNames) {
		if (project.isOpen()) {
			try {
				if (project.hasNature(Utils.PLUGIN_NATURE)) {
					try {
						final IManifestEditor editor = new ManifestEditor(project);
						editor.init();
						// This test is necessary to bypass the plugins tagged 0.*.*
						if (editor.getBundleVersion().matches("[1-9]+\\.[0-9]+\\.[0-9]+\\.qualifier")) {
							editor.setBundleVersion(newVersion);
							editor.save();
						}
					} catch (final IOException e) {
						Activator.log.error(e);
						notManagedProjectNames += NLS.bind("- {0} \n", project.getName());
					} catch (final Throwable e) {
						Activator.log.error(e);
						notManagedProjectNames += NLS.bind("- {0} \n", project.getName());
					}

				} else {
					notManagedProjectNames += NLS.bind("- {0} \n", project.getName());
				}
			} catch (final CoreException e) {
				Activator.log.error(e);
			}
		} else {
			notManagedProjectNames += NLS.bind("- {0} \n", project.getName());
		}
	}

}
