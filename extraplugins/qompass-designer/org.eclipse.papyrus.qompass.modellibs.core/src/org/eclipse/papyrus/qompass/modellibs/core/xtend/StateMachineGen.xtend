package org.eclipse.papyrus.qompass.modellibs.core.xtend

import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.papyrus.C_Cpp.Ptr
import org.eclipse.papyrus.FCM.DerivedElement
import org.eclipse.papyrus.qompass.designer.core.StUtils
import org.eclipse.papyrus.qompass.designer.core.Utils
import org.eclipse.papyrus.qompass.designer.core.UMLTool
import org.eclipse.papyrus.qompass.designer.core.extensions.IXtend
import org.eclipse.papyrus.qompass.designer.core.sync.InterfaceSync
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationContext
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil
import org.eclipse.uml2.uml.Behavior
import org.eclipse.uml2.uml.BehavioredClassifier
import org.eclipse.uml2.uml.CallEvent
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.OpaqueExpression
import org.eclipse.uml2.uml.Operation
import org.eclipse.uml2.uml.Pseudostate
import org.eclipse.uml2.uml.PseudostateKind
import org.eclipse.uml2.uml.Reception
import org.eclipse.uml2.uml.Signal
import org.eclipse.uml2.uml.SignalEvent
import org.eclipse.uml2.uml.State
import org.eclipse.uml2.uml.StateMachine
import org.eclipse.uml2.uml.TimeEvent
import org.eclipse.uml2.uml.Transition
import org.eclipse.uml2.uml.Trigger
import org.eclipse.uml2.uml.Type
import org.eclipse.uml2.uml.ValueSpecification
import org.eclipse.uml2.uml.Vertex
import org.eclipse.uml2.uml.util.UMLUtil

import static org.eclipse.papyrus.qompass.designer.core.EnumService.*
import static org.eclipse.papyrus.qompass.designer.vsl.ParseVSL.*

import static extension org.eclipse.papyrus.qompass.designer.core.UMLTool.*
import static extension org.eclipse.papyrus.qompass.modellibs.core.xtend.BehaviorUtil.*
import static extension org.eclipse.papyrus.qompass.modellibs.core.xtend.CppUtils.cppCall
import static extension org.eclipse.papyrus.qompass.modellibs.core.xtend.StateMachineUtil.*

class StateMachineGen implements IXtend {

	Class clazz
	
	def getStateMachine(Class clazz) {
		// organized in a loop. But effectively supports single state machine
		for (smBehavior : (clazz as BehavioredClassifier).ownedBehaviors.filter[it instanceof StateMachine]) {
			return smBehavior as StateMachine
		}
		return null
	}
	
	def activate(Class clazz) {
		val sm = clazz.stateMachine
		val flattener = new UMLFlattener
		flattener.transform(sm)
		activate(clazz, sm)
	}
	
	def activate(Class clazz, StateMachine sm) '''
		m_currentState = STATE_«sm.region.initialState.name»;
#ifdef SM_VERBOSE
		cout << "SM «clazz.name»: in state «sm.region.initialState.name»" << endl;
#endif
		for (;;) {
			processEvents();
		}	
	'''
	
	def processEvents(Class clazz) {
		val sm = clazz.stateMachine
		// - Option to put processElements into original class (but, would need to copy dependencies & attributes)
		// create new operation in class owning the state machine.
		// val operation = clazz.createOperation("processEvents", null)
		// val ob = clazz.createOpaqueBehavior(operation)
		// ob.set(clazz.processEventsSM(sm).toString)
		// return "executor->processEvents();"
		this.clazz = clazz
		return clazz.processEventsSM(sm)
	}

	def eventInterceptor(Operation operation) '''
		«/*TODO: need better way to detect signal*/»
		«val derivedElement = UMLUtil.getStereotypeApplication(operation, DerivedElement)»
		«IF derivedElement.source instanceof Reception»
			«val signal = (derivedElement.source as Reception).signal»
			// create event with global signal ID
			core::ContainerServices::CallEvent_ event;
			event.operationID = «literal(SIGNAL_ENUM, operation.name)»;
			// map signal into value-buffer and copy attributes
			::«signal.qualifiedName» * signal = (::«signal.qualifiedName» *) &event.params;
			«FOR attribute : signal.ownedAttributes»
				signal->«attribute.name» = «attribute.name»;
			«ENDFOR»
			«Utils.getTop(operation).declareDependencyToSignalIDs»
			«UMLTool.declareDependency(TransformationContext.classifier, signal)»
		«ELSE»
			// create event with operationID/portID and pass call
			core::ContainerServices::CallEvent_ event;
			event.operationID = ID_«operation.name»;
		«ENDIF»
		event.portID = portID;
		out->writeEvent(event);

		«IF (operation.type != null)»return «ENDIF»rconn->«operation.cppCall»;
	'''

	def processEventsSM(BehavioredClassifier clazz, StateMachine sm) '''
		// processEvents body - generated by Qompass 
		//
		// supports ports «FOR port : (clazz as Class).ownedPorts» «literal('PortEnum_'+clazz.name, 'port_'+clazz.name+'_'+port.name)»«ENDFOR»

		core::ContainerServices::CallEvent_ event;
		int timeout;
		int newState;
		bool needsTrigger;

		switch(m_currentState) {
			«FOR state : sm.region.subvertices»
				case «literal('LStateIDs_'+clazz.name, 'STATE_'+state.name)»:
					// -------- treatment of accepted events
					«state.acceptableEvents»
					break;
			«ENDFOR»
			default:
				OSAL_ERROR ("Inconsistent state");
			break;
		}
		if (animOut != 0) {
			animOut->enterState(newState, «clazz.fragment»);
		}
	'''

	/*
	 * Pass the actual to which the port is bound. In case of a CallEvent, pass the implemented interface
	 * (Not the class to which the state machine is bound)
	 */
	def cetrigger(Operation operation) {
		val packageRef = operation.implementsInterface.boundPackageRef
		// declare dependency to OperationIDs enumeration
		packageRef.declareDependencyToOperationIDs
		'''«packageRef.qualifiedName»::ID_«operation.name»'''
	}

	// Use service for global enumerations
	def setrigger(Trigger trigger) {
		val se = trigger.event as SignalEvent
		literal(SIGNAL_ENUM, InterfaceSync.SIG_PREFIX + se.signal.name)
	}

	/**
	 * create code for acceptable events
	 * 
	 * big restriction: will only analyse first of possibly multiple triggers
	 */
	def acceptableEvents(Vertex state) '''
		// loop on state
		// execute action ...
		timeout = -1;	// no timeout by default
		«FOR transition : state.outgoings»
			«IF transition.triggers.size > 0»
				«val trigger = transition.triggers.get(0)»
				«IF (trigger.event instanceof TimeEvent)»
					«val timeEvent = trigger.event as TimeEvent»
					// transition «transition.name» - trigger: TimeEvent, expression «(timeEvent.when.expr as OpaqueExpression).bodies.get(0)».
					timeout = «getDurationFromVSL((timeEvent.when.expr as OpaqueExpression).bodies.get(0))»/1000;
				«ENDIF»
			«ENDIF»
		«ENDFOR»

		«IF ((state instanceof State) && (state as State).entry != null)»
			// execute entry action
			executor->«(state as State).entry.name»();
		«ENDIF»

		needsTrigger = true;

		«IF hasTransitionWithoutTrigger(state)»
			«FOR transition : state.outgoings»
				«IF transition.triggers.size == 0»
					«IF transition.guard != null»
						«transition.guard.specification.createGuardFct(null)»
						if (executor->«transition.guard.specification.name»()) {
					«ENDIF»
					newState = STATE_«transition.target.name»;
#ifdef SM_VERBOSE
						cout << "SM «clazz.name»: transition to state «transition.target.name»" << endl;
#endif
					«IF (transition.effect != null)»
						executor->«effectName(transition)»();
					«ENDIF»
						needsTrigger = false;
					«IF transition.guard != null»
						}
					«ENDIF»
				«ENDIF»
			«ENDFOR»
		«ENDIF»

		if (needsTrigger) {
			// get an event from the pool.
			event = ep->readEvent(timeout);
		}
		else {
			event.operationID = -1;
		}
		
		«val allOutgoings = state.outgoings»
		«FOR transition : allOutgoings»
			«IF transition.triggers.size > 0»
				// has «transition.triggers.size» outgoing transitions
				«val trigger = transition.triggers.get(0)»
				«IF (trigger.event instanceof TimeEvent)»
					// transition «transition.name» - trigger: TimeEvent (there should be at most one outgoing timed transition per state).
					if (event.operationID == core::ContainerServices::EventPool::ID_TIMEOUT) {
						«IF transition.guard != null»
							«transition.guard.specification.createGuardFct(null)»
							if (executor->«transition.guard.specification.name»()) {
						«ENDIF»
						newState = STATE_«transition.target.name»;
#ifdef SM_VERBOSE
						cout << "SM «clazz.name»: transition to state «transition.target.name»" << endl;
#endif
						«IF (transition.effect != null)»
							executor->«effectName(transition)»();
						«ENDIF»
						«IF transition.guard != null»
							}
						«ENDIF»
					}
				«ENDIF»
				«IF (trigger.event instanceof CallEvent)» 
					// transition «trigger.name» - trigger: CallEvent («trigger.event.name»), operation «(trigger.event as CallEvent).operation.name»
					if (event.operationID == «cetrigger((trigger.event as CallEvent).operation)») {
						newState = STATE_«transition.target.name»;
#ifdef SM_VERBOSE
						cout << "SM «clazz.name»: transition to state «transition.target.name»" << endl;
#endif
						«IF (transition.effect != null)»
							executor->«effectName(transition)»();
						«ENDIF»
					} 
				«ENDIF»
				«IF (trigger.event instanceof SignalEvent)» 
					«val signalEvent = trigger.event as SignalEvent»
					// transition «trigger.name» - trigger: SignalEvent («signalEvent.name»), signal «signalEvent.signal.name»
					if (event.operationID == «setrigger(trigger)») {
						«IF (transition.effect != null) || (transition.guard != null)»
							// map signal to parameter section
							::«signalEvent.signal.qualifiedName» * signal = (::«signalEvent.signal.qualifiedName» *) &event.params;
						«ENDIF»
						«IF transition.guard != null»
							«transition.guard.specification.createGuardFct(signalEvent)»
							if (executor->«transition.guard.specification.name»(signal)) {
						«ENDIF»
						newState = STATE_«transition.target.name»;
#ifdef SM_VERBOSE
						cout << "SM «clazz.name»: transition to state «transition.target.name» (due to signal «signalEvent.signal.name»)" << endl;
#endif
						«IF (transition.effect != null)»
							«transition.effect.addSignalParameter(signalEvent.signal)»
							executor->«effectName(transition)»(«IF signalEvent.signal.attributes.size > 0»signal«ENDIF»);
						«ENDIF»
						// ok = EvQUEUE ;
						«IF transition.guard != null»
							}
						«ENDIF»
					}
				«ENDIF»
			«ENDIF»
		«ENDFOR»
	
		if (newState != m_currentState) {
			m_currentState = newState;
			«IF ((state instanceof State) && (state as State).exit != null)»
			// execute exit action
			executor->«(state as State).exit.name»();
		«ENDIF»

			
		}
	'''
	
	def boolean hasTransitionWithoutTrigger(Vertex state) {
		for (transition : state.outgoings) {
			if (transition.triggers.size == 0) {
				return true;
			}
		}
		return false;		
	}
	
	def EList<Transition> calculateTransitions(Vertex state) {
		val allOutgoings = new BasicEList<Transition>
		allOutgoings.addAll(state.outgoings)
		for (transition : state.outgoings) {
			if (transition.target instanceof Pseudostate) {
				val ps = transition.target as Pseudostate
				if (ps.kind == PseudostateKind.JUNCTION_LITERAL) {
					allOutgoings.addAll(ps.outgoings.clone)
				}
			}
		}
		return allOutgoings
	}
	
	/**
	 * Effects are moved from behaviors embedded into transitions towards behaviors of the class. Calculate the name of these
	 * effects. The class FilterStateMachines moves the effects (TODO: single name calculation)
	 */
	def effectName(Transition transition) {
		// transition.containingStateMachine.name + "_" + transition.effect.name
		if (transition.effect.name == null) {
			throw new TransformationException(
				String.format("effect of transition has no name (in SM %s)", transition.containingStateMachine.name))
		}
		transition.effect.name
	}
	
	def void addSignalParameter(Behavior behavior, Signal signal) {
		if (behavior.ownedParameters.size == 0) {
			val parameter = behavior.createOwnedParameter("signal", signal)
			StereotypeUtil.apply(parameter, Ptr)
		}
	}

	def void moveBehavior(String newName, Class tmClass, Behavior effect) {
		val copiedEffect = EcoreUtil.copy(effect)
		if (tmClass.getOwnedOperation(newName, null, null) != null) {
			// has already been added
			return;
		}
		val operation = tmClass.createOwnedOperation(newName, null, null);
		for (parameter : effect.getOwnedParameters()) {
			val newParameter = EcoreUtil.copy(parameter);
			operation.getOwnedParameters().add(newParameter);
			StUtils.copyStereotypes(parameter, newParameter);
		}
		copiedEffect.setSpecification(operation);
		copiedEffect.setName(newName);
		tmClass.getOwnedBehaviors().add(copiedEffect);
	}

	static final String CLIB_BOOL = "AnsiCLibrary::bool"

	def void createGuardFct(ValueSpecification specification, SignalEvent event) {
		val name = specification.getName()
		
		if (clazz.getOwnedBehavior(name) != null) {
			return
		}
		var booleanNamedElement = Utils.getQualifiedElement(TransformationContext.sourceRoot, CLIB_BOOL);
		
		if (booleanNamedElement instanceof Type) {
			val booleanType = TransformationContext.copier.getCopy(booleanNamedElement) as Type
			val operation = clazz.createOperation(name, booleanType as Type)
			if (event != null) {
				val sigParam = operation.createOwnedParameter("signal", event.signal)
				StereotypeUtil.apply(sigParam, Ptr)
			}
			val ob = clazz.createOpaqueBehavior(operation)
			if (specification instanceof OpaqueExpression) {
				ob.getLanguages().addAll(specification.getLanguages());
				for (String body : specification.getBodies()) {
					ob.getBodies().add("return " + body + ";");
				}
			}
		}
		else {
			System.out.println("was");
		}
			// if (tmClass.getOwnedOperation(newName, null, null) != null) {
		// copiedEffect.setSpecification(operation);
	}
}