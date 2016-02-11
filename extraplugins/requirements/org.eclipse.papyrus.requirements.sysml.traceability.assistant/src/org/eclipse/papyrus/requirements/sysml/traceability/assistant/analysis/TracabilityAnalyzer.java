/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Patrick Tessier (patrick.tessier@cea.fr) CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.requirements.sysml.traceability.assistant.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Element;

/**
 * the purpose of this class us to analyze the model
 * and to propose to set the tracability
 *
 */
public class TracabilityAnalyzer {
	/**list of element for which question must not be asked**/
	private ArrayList<Element> blackbox= new ArrayList<Element>();
	/** list of tracability rules**/
	private ArrayList<ITracabilityRule> tracabilityRules= new ArrayList<ITracabilityRule>();

	/**
	 * Constructor
	 */
	public TracabilityAnalyzer() {
		super();
		tracabilityRules.add(new AbstractionRule());
		tracabilityRules.add(new SatisfyRule());
		tracabilityRules.add(new DeriveReqRule());
	}

	/**
	 * apply tracability rules on the model
	 * @param model the package to analyze
	 * @param domain the domain to execute command
	 */
	public  void runAnalysis(org.eclipse.uml2.uml.Package model, TransactionalEditingDomain domain){
		HashMap<Element, ArrayList<ITracabilityRule>> interestingElement= new HashMap<Element, ArrayList<ITracabilityRule>>();
		Iterator<Element> modelIterator= model.allOwnedElements().iterator();

		//go through the model in order to know the list of element where we apply the tracability rules.
		while (modelIterator.hasNext()) {
			
			Element currentElement = (Element) modelIterator.next();
			//test if the element is not referenced in the blackbox
			if( !blackbox.contains(currentElement)){
				//look for if a trace rules can be applied
				Iterator<ITracabilityRule> tracabilityIterator= tracabilityRules.iterator();
				while (tracabilityIterator.hasNext()) {
					ITracabilityRule tracabilityRule = (ITracabilityRule) tracabilityIterator.next();
					if( tracabilityRule.canApplyTracability(currentElement)){
						if( interestingElement.containsKey(currentElement)){
							interestingElement.get(currentElement).add(tracabilityRule);
						}
						else{
							interestingElement.put(currentElement, new ArrayList<ITracabilityRule>());
							interestingElement.get(currentElement).add(tracabilityRule);
						}
					}
				}
			}
		}
		//for each element execute the rules
		Iterator<Element> elementKeyiterator=interestingElement.keySet().iterator();
		while (elementKeyiterator.hasNext()) {
			Element currentKey = (Element) elementKeyiterator.next();
			Iterator<ITracabilityRule> tracabilityIterator= interestingElement.get(currentKey).iterator();
			while (tracabilityIterator.hasNext()) {
				ITracabilityRule iTracabilityRule = (ITracabilityRule) tracabilityIterator.next();
				iTracabilityRule.applyTracability(currentKey, domain);
			}
		}
	}
}
