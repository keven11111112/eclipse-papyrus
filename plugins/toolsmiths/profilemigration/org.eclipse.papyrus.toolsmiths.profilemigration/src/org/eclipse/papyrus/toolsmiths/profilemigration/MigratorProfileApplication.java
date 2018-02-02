/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Pauline DEVILLE (CEA LIST) pauline.deville@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.toolsmiths.profilemigration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.edit.tree.TreeNode;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.toolsmiths.profilemigration.factory.IMigratorFactory;
import org.eclipse.papyrus.toolsmiths.profilemigration.factory.MigratorFactory;
import org.eclipse.papyrus.toolsmiths.profilemigration.internal.data.structure.StereotypeApplicationRegistry;
import org.eclipse.papyrus.toolsmiths.profilemigration.internal.extensionPoint.AtomicMigratorRegistry;
import org.eclipse.papyrus.toolsmiths.profilemigration.internal.utils.AtomicMigratorComparator;
import org.eclipse.papyrus.toolsmiths.profilemigration.internal.utils.DifferenceTreeBuilder;
import org.eclipse.papyrus.toolsmiths.profilemigration.migrators.ICompositeMigrator;
import org.eclipse.papyrus.toolsmiths.profilemigration.migrators.atomic.IAtomicMigrator;
import org.eclipse.papyrus.toolsmiths.profilemigration.ui.preferences.ProfileMigrationPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

/**
 * The class is used to migrated the model to the new version of the profile
 */
public class MigratorProfileApplication {

	/**
	 * The profiled model which is migrated
	 */
	public static Package profiledModel;

	/**
	 * The applied profile which is currently use for the migration
	 */
	public static Profile appliedProfile;

	/**
	 * The comparison of the two profile (output of EMF compare)
	 */
	public static Comparison comparison;

	/**
	 * The list of profile applied during the migration
	 */
	public static Set<Profile> newAppliedProfile = new HashSet<>();

	/**
	 * The list of stereotype applied during the migration
	 */
	public static List<EObject> newStereotypeApplication = new ArrayList<>();

	/**
	 * the list of atomic migration detected between the two files
	 */
	protected List<IAtomicMigrator> atomicList;

	/**
	 * the list of composite migration detected between the two files
	 */
	protected List<ICompositeMigrator> compositeList;

	/**
	 * The list of file already open which is keep to avoid asking the user to select the file each time
	 */
	private static Map<String, String> cacheProfileToFile = new HashMap<>();

	/**
	 * Constructor.
	 *
	 */
	public MigratorProfileApplication() {
		atomicList = new ArrayList<>();
		compositeList = new ArrayList<>();
	}

	/**
	 * Reapply the profile on the package_
	 * 
	 * @param package_
	 *            package owning the stereotype application
	 * @param profile
	 *            the profile which must be reapply
	 * @return the list of newly applied stereotype
	 */
	public List<EObject> reapplyProfile(Package package_, Profile profile) {
		Resource profileAfterResource = profile.eResource();

		String path = getFileName(profile, profileAfterResource);
		if (path != null) {
			URI uri = URI.createFileURI(path);
			ResourceSet profileBeforeResourceSet = new ResourceSetImpl();
			Resource profileBeforeResource = profileBeforeResourceSet.getResource(uri, true);

			migrateNewAppliedProfile(package_, profile, profileBeforeResource, profileAfterResource);
		} else {
			MessageDialog message = new MessageDialog(Display.getDefault().getActiveShell(), "Incorect file", null, "The selected path is incorect so the profile will just be reapply.", MessageDialog.INFORMATION, new String[] { "OK" }, 0); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			message.open();
			package_.applyProfile(profile);
		}
		return newStereotypeApplication;
	}

	/**
	 * Migrate package_ to the new version of profile
	 * 
	 * @param package_
	 *            the package to migrate
	 * @param profile
	 *            the new profile
	 * @param profileBeforeResource
	 *            the resource corresponding to the profile before modification
	 * @param profileAfterResource
	 *            the resource corresponding to the new profile
	 * @return the migrated package
	 */
	public Package migrateNewAppliedProfile(Package package_, Profile profile, Resource profileBeforeResource, Resource profileAfterResource) {
		profiledModel = package_;
		appliedProfile = profile;
		newAppliedProfile.clear();

		try {
			// 1] initialize treeNode and registry (save all necessary data)
			TreeNode rootTreeNode = getTreeNode(profileBeforeResource, profileAfterResource);
			if (rootTreeNode != null) {
				new StereotypeApplicationRegistry(rootTreeNode, profiledModel);

				// 2] migrate
				migrateNewAppliedProfile(profiledModel, rootTreeNode, profile, true);
			} else {
				// this is the case where there is no modification in the profile
				profiledModel.applyProfile(profile);
			}
		} catch (Exception e) {
			Activator.log.error(e);
		}
		return profiledModel;
	}

	/**
	 * This method is used to get the treeNode from to files (before and after)
	 *
	 * @param before
	 *            the resource for the model before modification
	 * @param after
	 *            the resource for the model after modification
	 * @return the treeNode base on modifications
	 */
	protected TreeNode getTreeNode(Notifier before, Notifier after) {
		// get comparison model
		DefaultComparisonScope scope = new DefaultComparisonScope(after, before, null);
		EMFCompare comparator = EMFCompare.builder().build();
		comparison = comparator.compare(scope);

		// get TreeNode
		DifferenceTreeBuilder builder = new DifferenceTreeBuilder(comparison);
		TreeNode differenceTree = builder.buildMatchTree();

		return differenceTree;
	}

	/**
	 * This method migrate to model to the new version of the profile
	 * 
	 * @param model
	 *            the profiled model to migrate
	 * @param treeNode
	 *            the treeNode corresponding to differences between the profile before and after modifications
	 * @param profile
	 *            the concerned profile
	 * @param shouldReapply
	 *            true if we have to reapply the profile, false otherwise
	 */
	protected void migrateNewAppliedProfile(Package model, TreeNode treeNode, Profile profile, boolean shouldReapply) {
		// 1] clear lists
		atomicList.clear();
		compositeList.clear();

		// 2] initialize lists
		initAtomicList(treeNode, MigratorFactory.INSTANCE);
		initCompositeList();
		postProcessing();

		// 3] reapply profile if it is necessary
		if (shouldReapply) {
			model.applyProfile(appliedProfile);
		}

		// 4] migrate the initialize atomicList
		for (IAtomicMigrator atomic : atomicList) {
			atomic.migrationAction();
		}

		// 5] migrate for newly applied profiles (when move into new profile)
		for (Profile newProfile : newAppliedProfile) {
			newAppliedProfile.remove(newProfile);
			migrateNewAppliedProfile(model, treeNode, newProfile, false);
		}
	}

	/**
	 * Initialize the list of atomic migration
	 *
	 * @param treeNode
	 */
	protected void initAtomicList(TreeNode treeNode, IMigratorFactory migratorFactory) {
		atomicList.addAll(migratorFactory.instantiateMigrator(treeNode));
		for (TreeNode childNode : treeNode.getChildren()) {
			initAtomicList(childNode, migratorFactory);
		}
		atomicList.sort(new AtomicMigratorComparator());
	}

	/**
	 * Remove every erased migrator (erased by extension point)
	 */
	private void postProcessing() {
		List<IAtomicMigrator> toRemove = new ArrayList<>();
		for (AtomicMigratorRegistry.Descriptor descriptor : AtomicMigratorRegistry.INSTANCE.getRegistry()) {
			for (String replacement : descriptor.getErasedMigrators()) {
				for (IAtomicMigrator migrator : atomicList) {
					if (!(toRemove.contains(migrator)) && migrator.getClass().getName().equals(replacement)) {
						toRemove.add(migrator);
					}
				}
			}
		}
		atomicList.removeAll(toRemove);
	}


	/**
	 * Initialize the list of atomic migration from the list of atomic migration
	 */
	protected void initCompositeList() {
		// TODO [Composite migration] initialize this list of composite migration, a composite migration is composed of atomic migration, all atomic migration which compose it shall be remove from the atomic list
	}

	private static Shell getActiveShell() {
		Display display = Display.getDefault();
		Shell result = display.getActiveShell();

		if (result == null) {
			Shell[] shells = display.getShells();
			for (Shell shell : shells) {
				if (shell.getShells().length == 0) {
					result = shell;
				}
			}
		}

		return result;
	}

	private String getFileName(Profile profile, Resource profileAfterResource) {
		if (cacheProfileToFile.containsKey(((XMIResource) profileAfterResource).getID(profile))) {
			String path = cacheProfileToFile.get(((XMIResource) profileAfterResource).getID(profile));
			if (ProfileMigrationPreferencePage.getCachedFiles().contains(path)) {
				return path;
			} else {
				cacheProfileToFile.remove(((XMIResource) profileAfterResource).getID(profile));
			}
		}

		FileDialog dialog = new FileDialog(getActiveShell(), SWT.OPEN);
		dialog.setText(NLS.bind(Messages.MigratorProfileApplicationDelegate_SelectFileDialogTitle, profile.getName()));
		dialog.setFilterExtensions(new String[] { "*.profile.uml", "*" }); //$NON-NLS-1$ //$NON-NLS-2$
		dialog.setFilterNames(new String[] { "Profiles", "All" }); //$NON-NLS-1$ //$NON-NLS-2$
		String path = dialog.open();

		if (path != null) {
			// add all profile to the cache
			URI uri = URI.createFileURI(path);
			ResourceSet profileBeforeResourceSet = new ResourceSetImpl();
			Resource profileBeforeResource = profileBeforeResourceSet.getResource(uri, true);
			TreeIterator<EObject> iter = profileBeforeResource.getAllContents();
			while (iter.hasNext()) {
				EObject object = iter.next();
				if (object instanceof Package) {
					if (object instanceof Profile) {
						cacheProfileToFile.put(((XMIResource) profileBeforeResource).getID(object), path);
						if (!ProfileMigrationPreferencePage.getCachedFiles().contains(path)) {
							ProfileMigrationPreferencePage.addFile(path);
						}
					}
				} else {
					iter.prune();
				}
			}
		}
		return path;
	}
}
