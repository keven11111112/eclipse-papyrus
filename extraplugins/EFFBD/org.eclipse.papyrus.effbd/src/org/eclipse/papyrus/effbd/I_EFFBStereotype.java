/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier(CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.effbd;

public interface I_EFFBStereotype {
	/** Qualified name of the stereotype Function */
	public static final String FUNCTION_STEREOTYPE = "EFFBProfile::Function";
	/** name of property base_OpaqueAction of the stereotype Function */
	public static final String FUNCTION_BASE_OPAQUEACTION_ATT = "base_OpaqueAction";
	/** Qualified name of the stereotype ORBegin */
	public static final String ORBEGIN_STEREOTYPE = "EFFBProfile::ORBegin";
	/** name of property base_DecisionNode of the stereotype ORBegin */
	public static final String ORBEGIN_BASE_DECISIONNODE_ATT = "base_DecisionNode";
	/** Qualified name of the stereotype OREnd */
	public static final String OREND_STEREOTYPE = "EFFBProfile::OREnd";
	/** name of property base_MergeNode of the stereotype OREnd */
	public static final String OREND_BASE_MERGENODE_ATT = "base_MergeNode";
	/** Qualified name of the stereotype ANDBegin */
	public static final String ANDBEGIN_STEREOTYPE = "EFFBProfile::ANDBegin";
	/** name of property base_ForkNode of the stereotype ANDBegin */
	public static final String ANDBEGIN_BASE_FORKNODE_ATT = "base_ForkNode";
	/** Qualified name of the stereotype ANDEnd */
	public static final String ANDEND_STEREOTYPE = "EFFBProfile::ANDEnd";
	/** name of property base_JoinNode of the stereotype ANDEnd */
	public static final String ANDEND_BASE_JOINNODE_ATT = "base_JoinNode";
	/** Qualified name of the stereotype ITBegin */
	public static final String ITBEGIN_STEREOTYPE = "EFFBProfile::ITBegin";
	/** name of property base_MergeNode of the stereotype ITBegin */
	public static final String ITBEGIN_BASE_MERGENODE_ATT = "base_MergeNode";
	/** Qualified name of the stereotype ITEnd */
	public static final String ITEND_STEREOTYPE = "EFFBProfile::ITEnd";
	/** name of property base_DecisionNode of the stereotype ITEnd */
	public static final String ITEND_BASE_DECISIONNODE_ATT = "base_DecisionNode";
	/** Qualified name of the stereotype LPBegin */
	public static final String LPBEGIN_STEREOTYPE = "EFFBProfile::LPBegin";
	/** name of property base_MergeNode of the stereotype LPBegin */
	public static final String LPBEGIN_BASE_MERGENODE_ATT = "base_MergeNode";
	/** Qualified name of the stereotype LPEnd */
	public static final String LPEND_STEREOTYPE = "EFFBProfile::LPEnd";
	/** name of property base_DecisionNode of the stereotype LPEnd */
	public static final String LPEND_BASE_DECISIONNODE_ATT = "base_DecisionNode";
}
