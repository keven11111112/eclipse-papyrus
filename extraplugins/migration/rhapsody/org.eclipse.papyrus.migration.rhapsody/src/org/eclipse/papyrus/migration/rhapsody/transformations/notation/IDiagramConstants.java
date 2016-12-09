/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are the property of the CEA. 
 * Any use is subject to specific agreement with the CEA.
 *
 * Contributors:
 * 
 * 		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.migration.rhapsody.transformations.notation;

public interface IDiagramConstants {

	public static final int STATEMACHINE_DEFAULT_MARGIN = 30;
	public static final int STATEMACHINE_DEFAULT_WIDTH = 1000;
	public static final int STATEMACHINE_DEFAULT_HEIGHT = 1000;
	public static final int STATEMACHINE_DEFAULT_HEADER = 13;
	public static final String STATEMACHINE_DIAGRAM_ID = "PapyrusUMLStateMachineDiagram"; //$NON-NLS-1$
	public static final String STATEMACHINE_PLUGIN_ID = "org.eclipse.papyrus.uml.diagram.statemachine"; //$NON-NLS-1$
	
	public static final int SEQUENCE_DEFAULT_MARGIN = 30;
	public static final int SEQUENCE_LIFELINE_WIDTH = 200;
	public static final int SEQUENCE_LIFELINE_HEIGHT = 600;
	public static final String SEQUENCE_DIAGRAM_ID = "PapyrusUMLSequenceDiagram"; //$NON-NLS-1$
	public static final String SEQUENCE_PLUGIN_ID = "org.eclipse.papyrus.uml.diagram.sequence"; //$NON-NLS-1$
	
	public static final int INTERNALBLOCK_DEFAULT_MARGIN = 30;
	public static final int INTERNALBLOCK_DEFAULT_HEIGHT = 400;
	public static final int INTERNALBLOCK_DEFAULT_WIDTH = 1000;
	public static final String INTERNALBLOCK_DIAGRAM_ID = "InternalBlock"; //$NON-NLS-1$
	public static final String INTERNALBLOCK_PLUGIN_ID = "org.eclipse.papyrus.sysml.diagram.internalblock"; //$NON-NLS-1$

	
	
	public static final String CLASS_DIAGRAM_ID ="PapyrusUMLClassDiagram";
	public static final String CLASS_DIAGRAM_PLUGIN_ID = "org.eclipse.papyrus.uml.diagram.clazz";
	
	// Sequence Diagram graphical IDs
	public static final String INTERACTION_VIEW_ID = "2001";
	public static final String INTERACTION_CPT_VIEW_ID = "7001";
	public static final String LIFELINE_VIEW_ID = "3001";
	
	// State Machine graphical IDs
	public static final String STATEMACHINE_VIEW_ID = "2000";
	public static final String STATEMACHINE_CPT_VIEW_ID = "2002";
	public static final String REGION_VIEW_ID = "3000";
	public static final String REGION_CPT_VIEW_ID = "3002";
	public static final String FINAL_STATE_VIEW_ID = "5000";
	public static final String FINAL_STATE_LABEL_ID = "5001";
	public static final String STATE_VIEW_ID = "6000";
	public static final String STATE_CPT_VIEW_ID = "6002";
	public static final String STATE_ENTRY_VIEW_ID = "690";
	public static final String STATE_DO_VIEW_ID = "691";
	public static final String STATE_EXIT_VIEW_ID = "692";

	// Pseudo states
	public static final String INITIAL_STATE_VIEW_ID = "8000";
	public static final String INITIAL_STATE_LABEL_ID = "8001";
	public static final String JOIN_STATE_VIEW_ID = "9000";
	public static final String FORK_STATE_VIEW_ID = "10000";
	public static final String CHOICE_STATE_VIEW_ID = "11000";
	public static final String CHOICE_STATE_LABEL_ID = "11001";
	public static final String JUNCTION_STATE_VIEW_ID = "12000";
	public static final String JUNCTION_STATE_LABEL_ID = "12001";
	public static final String SHALLOW_HISTORY_STATE_VIEW_ID = "13000";
	public static final String DEEP_HISTORY_STATE_VIEW_ID = "14000";
	public static final String TERMINATE_STATE_VIEW_ID = "15000";
	public static final String ENTRY_POINT_STATE_VIEW_ID = "16000";
	public static final String EXIT_POINT_STATE_VIEW_ID = "17000";
	public static final String TRANSITION_VIEW_ID = "7000";
	public static final String TRANSITION_NAME_LABEL_ID = "7001";
	public static final String CONNECTION_POINT_REFERENCE_VIEW_ID = "18000";
}
