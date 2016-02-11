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

import java.util.Iterator;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.widgets.editors.TreeSelectorDialog;
import org.eclipse.papyrus.requirements.sysml.common.I_SysMLStereotype;
import org.eclipse.papyrus.requirements.sysml.traceability.commands.SatisfactionCreateCommand;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UseCase;
/**
 *Rule of tracability for abstraction 
 *
 */
public class SatisfyRule implements ITracabilityRule {

	public boolean canApplyTracability(Element element) {
		//this must be a usecase
		if( (element instanceof UseCase)){
			if(element.getAppliedStereotype(I_SysMLStereotype.REQUIREMENT_STEREOTYPE)==null){
				UseCase currentClass= (UseCase)element;
				boolean containsAnAbstraction=false;
				Iterator<Dependency> dependencyIterator=currentClass.getClientDependencies().iterator();
				while (dependencyIterator.hasNext()) {
					Dependency dependency = (Dependency) dependencyIterator.next();
					if( dependency instanceof Abstraction){
						if( dependency.getAppliedStereotype(I_SysMLStereotype.SATISFY_STEREOTYPE)!=null){
							containsAnAbstraction=true;
						}
						if( dependency instanceof Abstraction){
							containsAnAbstraction=true;
						}
					}

				}
				if(containsAnAbstraction){
					return false;
				}
				else{
					return true;
				}
			}
		}
		return false;
	}

	public boolean applyTracability(Element element, TransactionalEditingDomain domain) {
		//look for target of the abstraction
		TreeSelectorDialog dialog = new TreeSelectorDialog(Display.getDefault().getActiveShell());
		dialog.setContentProvider(new UMLContentProvider(element.getNearestPackage(), UMLPackage.eINSTANCE.getPackage_PackagedElement()));
		dialog.setLabelProvider(new UMLLabelProvider());
		dialog.setMessage("Choose Satisfy Link for "+((NamedElement)element).getQualifiedName());
		dialog.setTitle("Choose Satisfy Link for "+((NamedElement)element).getName());
		dialog.create();
		dialog.setDescription("Choose Satisfy Link for "+((NamedElement)element).getQualifiedName());
		if(dialog.open() == org.eclipse.jface.window.Window.OK) {
			Object[] result = dialog.getResult();
			SatisfactionCreateCommand cmd= new SatisfactionCreateCommand(domain, ((NamedElement)result[0]),((NamedElement)element) );
			domain.getCommandStack().execute(cmd);
		}
		return false;
	}

}
