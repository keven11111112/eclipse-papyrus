/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Pauline DEVILLE (CEA LIST) - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.toolsmiths.profilemigration.internal.handler;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.toolsmiths.profilemigration.internal.MigratorProfileApplicationDelegate;
import org.eclipse.papyrus.uml.profile.Activator;
import org.eclipse.papyrus.uml.profile.service.ReapplyProfilesService;
import org.eclipse.papyrus.uml.profile.service.ui.RefreshProfileDialog;
import org.eclipse.papyrus.uml.profile.validation.ProfileValidationHelper;
import org.eclipse.papyrus.uml.tools.helper.IProfileApplicationDelegate;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.utils.ProfileUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;

/**
 * Service to use the Profile migration tool when it is call by the ProfileMigrationToolHandler
 */
public class ProfileMigrationToolService extends ReapplyProfilesService {

	/**
	 * Boolean to know if we use the profile migration tool or the classic reapplying system (ReapplyProfilesService)
	 */
	public static boolean isUsingProfileMigrationTool = false;

	private ServicesRegistry servicesRegistry;

	private Package rootPackage;


	/**
	 * Constructor.
	 *
	 */
	public ProfileMigrationToolService() {
		super();
	}


	/**
	 * @see org.eclipse.papyrus.infra.ui.services.EditorLifecycleEventListener#postInit(org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor)
	 *
	 * @param editor
	 */
	@Override
	public void postInit(IMultiDiagramEditor editor) {
		super.postInit(editor);
	}

	/**
	 * Call the profile migration tool if isProfileMigrationToolHandler is true
	 * 
	 * @see org.eclipse.papyrus.infra.ui.services.EditorLifecycleEventListener#postDisplay(org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor)
	 *
	 * @param editor
	 */
	@Override
	public void postDisplay(IMultiDiagramEditor editor) {
		if (isUsingProfileMigrationTool) {
			ProfileMigration_checkProfiles(editor);
			isUsingProfileMigrationTool = false;
		} else {
			super.postDisplay(editor);
		}
	}

	/**
	 * @see org.eclipse.papyrus.infra.ui.services.EditorLifecycleEventListener#beforeClose(org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor)
	 *
	 * @param editor
	 */
	@Override
	public void beforeClose(IMultiDiagramEditor editor) {
		super.beforeClose(editor);
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#init(org.eclipse.papyrus.infra.core.services.ServicesRegistry)
	 *
	 * @param servicesRegistry
	 * @throws ServiceException
	 */
	@Override
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		super.init(servicesRegistry);
		this.servicesRegistry = servicesRegistry;
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#startService()
	 *
	 * @throws ServiceException
	 */
	@Override
	public void startService() throws ServiceException {
		super.startService();
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#disposeService()
	 *
	 * @throws ServiceException
	 */
	@Override
	public void disposeService() throws ServiceException {
		super.disposeService();
	}

	/**
	 * Get the root package and call profile migration tool
	 * 
	 * @param editor
	 *            the current MultiDiagramEditor
	 */
	protected void ProfileMigration_checkProfiles(IMultiDiagramEditor editor) {
		ModelSet modelSet;
		try {
			modelSet = servicesRegistry.getService(ModelSet.class);
		} catch (ServiceException ex) {
			return;
		}

		UmlModel umlModel = (UmlModel) modelSet.getModel(UmlModel.MODEL_ID);
		if (umlModel == null) {
			return;
		}

		rootPackage = getRootPackage(umlModel);

		if (rootPackage == null) {
			return;
		}

		ProfileMigration_checkAndRefreshProfiles(rootPackage, editor);
	}

	/**
	 * Check if applied profile is the latest version, if not call the profile migration tool
	 * 
	 * @param currentPackage
	 *            the package owning the profile to reapply
	 * @param editor
	 *            the current MultiDiagramEditor
	 * @return false if we can not access to the current display, true otherwise
	 */
	protected boolean ProfileMigration_checkAndRefreshProfiles(Package currentPackage, IMultiDiagramEditor editor) {
		if (Display.getCurrent() == null) {
			return false;
		}

		IProfileApplicationDelegate delegate = new MigratorProfileApplicationDelegate();
		for (ProfileApplication profileApplication : delegate.getProfileApplications(currentPackage)) {
			if (ProfileUtil.isDirty(currentPackage, delegate.getAppliedProfile(profileApplication))) {
				RefreshProfileDialog dialog = new RefreshProfileDialog(editor.getSite().getShell(), this.rootPackage);
				dialog.setCallback(profileMigration_getCallback(dialog));
				dialog.open();

				return true;
			}
		}

		for (Package nestedPackage : currentPackage.getNestedPackages()) {
			if (ProfileMigration_checkAndRefreshProfiles(nestedPackage, editor)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Reapply profile in rootPackage
	 * 
	 * @param dialog
	 *            the opened RefreshProfileDialog
	 * @return a runnable element which reapply the profile using the profile migration tool
	 */
	protected Runnable profileMigration_getCallback(final RefreshProfileDialog dialog) {
		return new Runnable() {

			@Override
			public void run() {
				Map<Package, Collection<Profile>> profilesToReapply = dialog.getProfilesToReapply();
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(rootPackage);

				if (domain != null) {

					// Create a flat list of profiles, for validation
					Collection<Profile> allProfiles = new LinkedList<>();
					for (Collection<Profile> profiles : profilesToReapply.values()) {
						allProfiles.addAll(profiles);
					}

					// Validate and apply
					if (ProfileValidationHelper.checkApplicableProfiles(Display.getCurrent().getActiveShell(), allProfiles)) {
						CompoundCommand command = new CompoundCommand();
						for (Map.Entry<Package, Collection<Profile>> profiles : profilesToReapply.entrySet()) {
							for (Profile profile : profiles.getValue()) {
								command.append(new ReapplyProfileCommand(profiles.getKey(), profile, domain));
							}
						}
						domain.getCommandStack().execute(command);
					}

				} else {
					Activator.log.error(new IllegalArgumentException("Cannot reapply profiles on Package " + rootPackage.getQualifiedName() + ". The EditingDomain cannot be found")); //$NON-NLS-1$ //$NON-NLS-2$
				}

			}

		};
	}


}
