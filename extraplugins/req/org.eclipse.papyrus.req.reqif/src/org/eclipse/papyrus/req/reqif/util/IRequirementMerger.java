package org.eclipse.papyrus.req.reqif.util;

import java.util.ArrayList;
import java.util.HashSet;

import org.eclipse.uml2.uml.Element;

public interface IRequirementMerger {

	/**
	 * 
	 * @return the list that must be deleted during merge
	 */
	public ArrayList<Element> getElementToDelete();

	/**
	 * 
	 * @return the list of added element during merge
	 */
	public ArrayList<Element> getAddedElements();

	/**
	 * 
	 * @param copyAllPropertyValues
	 *        is an option. true means that the user wants to copy the name
	 *        and all the stereotype values. This option disables the
	 *        changeableProperty parameter.
	 * @param deleteFromBase
	 *        is an option. True means that element that not match with right will be removed
	 * @return true merge finishes successfully
	 */
	boolean merge();

	public HashSet<Element> getModifiedElement();
}
