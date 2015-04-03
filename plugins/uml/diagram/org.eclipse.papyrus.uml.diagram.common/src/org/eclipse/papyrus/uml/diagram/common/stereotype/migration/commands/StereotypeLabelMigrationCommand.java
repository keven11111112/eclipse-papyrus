/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Celine Janssens (ALL4TEC) celine.janssens@all4tec.net - Initial API and implementation
 *   Celine Janssens (ALL4TEC) celine.janssens@all4tec.net - Bug 455311 : Refactor Stereotype Displays
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.stereotype.migration.commands;

import java.util.Iterator;
import java.util.StringTokenizer;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.IStereotypeViewProvider;
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.StereotypeViewProvider;
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.helper.StereotypeDisplayCommandExecution;
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.helper.StereotypeDisplayUtil;
import org.eclipse.papyrus.uml.diagram.common.stereotype.migration.StereotypeMigrationHelper;
import org.eclipse.uml2.uml.Stereotype;

/**
 * This Command applies the user preferences for the Stereotype Label
 * In charge of check the visibility, depth and persistence based on the Old EAnnotation
 * 
 * @author Céline JANSSENS
 *
 */
public class StereotypeLabelMigrationCommand implements Runnable {

	// String Constant
	private static final String EANNOTATION_LIST_SEPARATOR = ","; //$NON-NLS-1$
	private static final String QUALIFIED_NAME_DEPTH = "full"; //$NON-NLS-1$


	private View mainView;

	// Static Instances of helpers and providers
	private static StereotypeDisplayUtil helper = StereotypeDisplayUtil.getInstance();
	private static StereotypeMigrationHelper migrationHelper = StereotypeMigrationHelper.getInstance();
	private static StereotypeDisplayCommandExecution commandHelper = StereotypeDisplayCommandExecution.getInstance();
	protected static IStereotypeViewProvider provider;


	/**
	 * Constructor.
	 *
	 * @param label
	 *            The Label of the Command
	 * @param content
	 *            The View of the element that is migrated.
	 */
	public StereotypeLabelMigrationCommand(String label, View content) {

		this.mainView = content;

	}


	/**
	 * Migrate the Stereotype Label from the old Version.
	 * 
	 * @param View
	 *            The element of the diagram to migrate
	 */
	protected void migrateStereotypeLabel(View view) {
		// Create the provider
		setProvider(view);

		if (migrationHelper.hasStereotypeEAnnotation(view)) {

			// Update Visibility
			String oldStereotype = getOldStereotypeToDisplay(view);
			updateNewStereotypeVisibility(view, oldStereotype);

			// Update Depth
			String oldQNStereotype = getOldQNStereotypeToDisplay(view);
			updateNewStereotypeDepth(view, oldQNStereotype);

		}
	}

	/**
	 * From the Stereotype List to display with they Qualified Name, update the Depth to full
	 * 
	 * @param view
	 *            The view of the object to migrate
	 * @param stereotypeList
	 *            List of Stereotype to display with their Qualified Name
	 */
	protected void updateNewStereotypeDepth(View view, String stereotypeList) {
		StringTokenizer tokenizer = new StringTokenizer(stereotypeList, EANNOTATION_LIST_SEPARATOR);

		while (tokenizer.hasMoreTokens()) {
			String stereotypeName = tokenizer.nextToken();
			View label = helper.getStereotypeLabel(view, stereotypeName);
			if (label != null) {
				commandHelper.setDepth(migrationHelper.getDomain(view), migrationHelper.getStereotypeFromString(view, stereotypeName), view, QUALIFIED_NAME_DEPTH, false);
			}
		}
	}


	/**
	 * From the Stereotype List to display , update the Visibility to true
	 * And hide visible Stereotype Label that should not be shown.
	 * 
	 * @param view
	 *            The view of the object to migrate
	 * @param stereotypeList
	 *            List of Stereotype to display
	 */
	protected void updateNewStereotypeVisibility(View view, String stereotypeList) {

		// Hide all the Label displayed but that should not to be shown
		hideStereotypeLabelNotDisplayed(stereotypeList, view);

	}


	/**
	 * Show each Stereotype from the Stereotype to display list.
	 * 
	 * @param stereotypeList
	 *            The list of stereotype to display
	 * @param view
	 *            The view of the object that is migrated
	 */
	private void showStereotypeLabelToBeDisplayed(String stereotypeList, View view) {
		StringTokenizer tokenizer = new StringTokenizer(stereotypeList, EANNOTATION_LIST_SEPARATOR);
		while (tokenizer.hasMoreTokens()) {
			String stereotypeName = tokenizer.nextToken();
			showStereotypeLabel(view, stereotypeName);
		}

	}

	/**
	 * Show the Label To display.
	 * Updating Visibility and Persistence
	 * 
	 * @param view
	 *            The view of the object to migrate
	 * @param stereotypeList
	 *            List of Stereotype to display
	 */
	protected void showStereotypeLabel(View view, String stereotypeName) {
		View label = provider.getLabel(migrationHelper.getStereotypeFromString(view, stereotypeName));
		if (label != null) {
			migrationHelper.updateVisibilityAndPersistence(label, view, true);
		}
	}


	/**
	 * Hide visible Stereotype Label that should not be shown.
	 * List all the applied Stereotypes, if the applied stereotype is not in the Stereotype to Display list,
	 * hide the Node.
	 * 
	 * @param view
	 *            The view of the object to migrate
	 * @param stereotypeList
	 *            List of Stereotype to display
	 */
	private void hideStereotypeLabelNotDisplayed(String stereotypeList, View view) {
		EList<Stereotype> appliedStereotypes = migrationHelper.getAppliedStereotypesFromView(view);
		Iterator<Stereotype> stereotypes = appliedStereotypes.iterator();
		while (stereotypes.hasNext()) {
			String stereotypeName = stereotypes.next().getQualifiedName();
			if (stereotypeList.indexOf(stereotypeName) == -1) {
				hideStereotypeLabel(view, stereotypeName);
			}
		}
	}




	/**
	 * Hide the Stereotype Label
	 * 
	 * @param view
	 *            The view of the object that is migrated
	 * @param stereotypeName
	 *            Name of the Stereotype of which the Label should be hidden
	 */
	private void hideStereotypeLabel(View view, String stereotypeName) {
		View label = provider.getLabel(migrationHelper.getStereotypeFromString(view, stereotypeName));
		migrationHelper.updateVisibilityAndPersistence(label, mainView, false);

	}


	/**
	 * Get List of Stereotype to display with their Qualified Name from the EAnnotation.
	 * 
	 * @param view
	 *            The view of the object to migrate
	 * @return The List of Stereotype to display with their Qualified Name
	 */
	protected String getOldQNStereotypeToDisplay(View view) {
		return migrationHelper.getStereotypesQNToDisplay(view);
	}


	/**
	 * Get List of Stereotype to display from the EAnnotation.
	 * 
	 * @param view
	 *            The view of the object to migrate
	 * @return The List of Stereotype to display
	 */
	protected String getOldStereotypeToDisplay(View view) {

		return migrationHelper.getStereotypesToDisplay(view);
	}

	/**
	 * Create the provider
	 * 
	 * @param view
	 *            The view on which stereotypes is applied and from which the Stereotype Views will be provided
	 */
	private void setProvider(View view) {
		provider = new StereotypeViewProvider(view);

	}


	/**
	 * @see java.lang.Runnable#run()
	 *
	 */
	@Override
	public void run() {
		migrateStereotypeLabel(mainView);

	}


}
