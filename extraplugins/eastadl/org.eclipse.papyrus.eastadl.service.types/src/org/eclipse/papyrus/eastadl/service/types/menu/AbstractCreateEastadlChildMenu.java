package org.eclipse.papyrus.eastadl.service.types.menu;

import org.eclipse.papyrus.infra.ui.util.AbstractCreateMenuFromCommandCategory;

public class AbstractCreateEastadlChildMenu extends AbstractCreateMenuFromCommandCategory {

	/** the cateogory of the command used to create EASTADL elements */
	public static final String EASTADL_CREATION_COMMAND_CATEGORY = "org.eclipse.papyrus.eastadl.service.types.eastadlElementCreationCommands"; //$NON-NLS-1$

	/**
	 * Constructor.
	 *
	 */
	public AbstractCreateEastadlChildMenu() {
		super(EASTADL_CREATION_COMMAND_CATEGORY);
	}
}
