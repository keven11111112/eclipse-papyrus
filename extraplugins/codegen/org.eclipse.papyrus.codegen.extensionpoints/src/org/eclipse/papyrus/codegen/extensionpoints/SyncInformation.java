package org.eclipse.papyrus.codegen.extensionpoints;

import org.eclipse.uml2.uml.Behavior;

/**
 * Some code generators map behaviors in a non-trivial way or add methods that have not been generated.
 * The following information allows (generic) synchronization code, as within the CDT editor to
 * make a useful update of the source model. 
 */
public class SyncInformation {
	/**
	 * true, iff the method has been added by the generate and does not need synchronization.
	 */
	public boolean isGenerated;
	
	/**
	 * the associated behavior within the source model, in case of a non-trivial method.
	 * If the element does not exist yet in the source model, it may be null.
	 */
	public Behavior behavior;
	
	/*
	 * The qualified name of a behavior to create in the model. This is used, if there should be an associated behavior in the
     * model, but it does not exist yet. Only one of the two attributes (behavior and createBehaviorName) must be set.
     */
	public String createBehaviorName;
}