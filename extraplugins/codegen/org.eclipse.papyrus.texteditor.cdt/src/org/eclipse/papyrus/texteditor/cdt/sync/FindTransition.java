package org.eclipse.papyrus.texteditor.cdt.sync;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Transition;

public class FindTransition {
	
	private static final String UNDERSCORE = "_"; //$NON-NLS-1$

	public static Behavior findBehavior(Classifier cl, String methodName) {
		for (Element element : cl.allOwnedElements()) {
			if (element instanceof Transition) {
				Transition transition = (Transition) element;
				Behavior effect = transition.getEffect();
				if ((effect != null) && behaviorMatches(effect, methodName)) {
					return transition.getEffect();
				}
			}
		}
		return null;
	}
	
	public static boolean behaviorMatches(Behavior behavior, String methodName) {
		return
			methodName.endsWith(NamedElement.SEPARATOR + behavior.getName()) ||
			methodName.endsWith(UNDERSCORE + behavior.getName()); 
	}
}
