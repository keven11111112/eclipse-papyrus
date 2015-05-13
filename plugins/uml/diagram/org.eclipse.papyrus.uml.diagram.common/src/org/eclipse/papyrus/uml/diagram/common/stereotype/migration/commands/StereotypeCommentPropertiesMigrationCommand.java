/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Celine JANSSENS (ALL4TEC) celine.janssens@all4tec.net - Initial API and implementation
 *   Celine JANSSENS (ALL4TEC) celine.janssens@all4tec.net - Bug 455311 : Refactor Stereotype Display
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.stereotype.migration.commands;

import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.stereotype.StereotypeLocationEnum;
import org.eclipse.papyrus.uml.diagram.common.util.CommandUtil;

/**
 * 
 * Command to Migrate the StereotypeComment from old Structure (with EAnnotation) to the Structure with NamedStyle.
 * 
 * @author Céline JANSSENS
 *
 */
public class StereotypeCommentPropertiesMigrationCommand extends StereotypePropertiesMigrationCommand {

	/**
	 * Constructor.
	 * 
	 * @param label
	 *            Label of the Command
	 * @param content
	 *            Main view on which the Stereotype is applied
	 */
	public StereotypeCommentPropertiesMigrationCommand(String label, View content) {
		super(label, content);

	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.stereotype.migration.commands.StereotypePropertiesMigrationCommand#updateStereotypePropertyDisplay(org.eclipse.gmf.runtime.notation.View, java.lang.String, java.lang.Enum)
	 *
	 */
	@Override
	protected void updateStereotypePropertyDisplay(View view, String propertyList, Enum<?> location) {
		// In case of the Comment, the view will be the comment itself instead of the main View.
		if (StereotypeLocationEnum.IN_COMMENT.equals(location)) {

			View newComment = helper.getStereotypeComment(view);
			if (newComment != null) {
				super.updateStereotypePropertyDisplay(newComment, propertyList, location);
				setConstraint(view, newComment);

			}
			deleteOldComment(view);
		}
	}

	/**
	 * @param view
	 * @param newComment
	 */
	private void setConstraint(final View view, final View newComment) {
		if (newComment instanceof Node) {
			View oldComment = migrationHelper.getOldStereotypeComment(view);
			if (oldComment instanceof Node) {
				((Node) newComment).setLayoutConstraint(((Node) oldComment).getLayoutConstraint());
			}
		}
	}

	/**
	 * @param view
	 */
	private void deleteOldComment(final View hostView) {
		// Delete Comment from the Old Structure

		View oldComment = migrationHelper.getOldStereotypeComment(hostView);
		if (oldComment != null) {
			DeleteCommand deleteComment = new DeleteCommand(oldComment);
			CommandUtil.executeUnsafeCommand(deleteComment, hostView);
		}
		Edge oldLink = migrationHelper.getOldStereotypeLinkComment(hostView);
		if (oldLink != null) {
			DeleteCommand deleteLink = new DeleteCommand(oldLink);
			CommandUtil.executeUnsafeCommand(deleteLink, hostView);
		}




	}




}
