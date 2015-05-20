package org.eclipse.papyrus.req.reqif.transformation;

public interface I_RI {
	/**  name of the stereotype "Requirement" */
	public static final String REQ = "Requirement";
	/**  name of property "text" of the stereotype "Requirement" */
	public static final String REQ_TEXT_ATT = "text";
	/**  name of property "id" of the stereotype "Requirement" */
	public static final String REQ_ID_ATT = "id";
	/**  name of property "name" of PackagedElement */
	public static final String PACKAGED_ELEMENT_NAME_ATT = "name";
	/** Qualified name of stereotype Requirement */
	public static final String REQ_STEREOTYPE = "SysML::Requirements::Requirement";
	/** Delete from the base model the requirements that are not in the external model*/
	public static final boolean DELETE_FROM_BASE = true;
	/** Copy all contents without references to the original object during a merge process. If it is true, it will overwrite the "changeable parameter" parameter */
	public static final boolean COPY_All_PROPERTY_VALUES = true;
	/** Change values in properties when the matchStereotypedPackagedElements method finds a match */
	public static final boolean PERFORM_CHANGES = true;
	/** Check package name during matching*/
	public static final boolean CHECK_PACKAGE_NAME = true;
	/**  name to show in at the beginning of user messages */
	public static final String TOOL_TITLE = "Papyrus SysML REQ Reimport";
	/** Confirmation message to make sure that the user really wants to delete requirements in base model*/
	public static final String TOOL_DEL_CONFIRM = "Do you really want to delete: ";
	/** Papyrus REQ reimport message when the tool finished without problems */
	public static final String TOOL_SUCCESS = "Successfull re-import";
	/** Papyrus REQ reimport message when the tool finished with problems */
	public static final String TOOL_FAIL = "UnSuccessfull re-import";
	/** Constant message when a File cannot be read*/
	public static final String TOOL_ERR_FILE_READ ="Not Readable files";
	/** Constant property value separator*/
	public static final String TOOL_PROPERTY_SEPARATOR =": ";
}
