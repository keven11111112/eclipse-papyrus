/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNInterface;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.Participant;
import org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantMultiplicity;
import org.eclipse.papyrus.bpmn.BPMNProfile.PartnerEntity;
import org.eclipse.papyrus.bpmn.BPMNProfile.PartnerRole;
import org.eclipse.papyrus.bpmn.BPMNProfile.util.BPMNProfileValidator;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Participant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ParticipantImpl#getBase_Property <em>Base Property</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ParticipantImpl#getProcessRef <em>Process Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ParticipantImpl#getParticipantMultiplicity <em>Participant Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ParticipantImpl#getPartnerEntityRef <em>Partner Entity Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ParticipantImpl#getPartnerRoleRef <em>Partner Role Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ParticipantImpl#getInterfaceRefs <em>Interface Refs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParticipantImpl extends BaseElementImpl implements Participant {
	/**
	 * The cached value of the '{@link #getBase_Property() <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Property()
	 * @generated
	 * @ordered
	 */
	protected Property base_Property;

	/**
	 * The cached value of the '{@link #getProcessRef() <em>Process Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessRef()
	 * @generated
	 * @ordered
	 */
	protected BPMNProcess processRef;
	/**
	 * The cached value of the '{@link #getParticipantMultiplicity() <em>Participant Multiplicity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParticipantMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected ParticipantMultiplicity participantMultiplicity;
	/**
	 * The cached value of the '{@link #getPartnerEntityRef() <em>Partner Entity Ref</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartnerEntityRef()
	 * @generated
	 * @ordered
	 */
	protected EList<PartnerEntity> partnerEntityRef;
	/**
	 * The cached value of the '{@link #getPartnerRoleRef() <em>Partner Role Ref</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartnerRoleRef()
	 * @generated
	 * @ordered
	 */
	protected EList<PartnerRole> partnerRoleRef;
	/**
	 * The cached value of the '{@link #getInterfaceRefs() <em>Interface Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaceRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<BPMNInterface> interfaceRefs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParticipantImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getParticipant();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getBase_Property() {
		if (base_Property != null && base_Property.eIsProxy()) {
			InternalEObject oldBase_Property = (InternalEObject)base_Property;
			base_Property = (Property)eResolveProxy(oldBase_Property);
			if (base_Property != oldBase_Property) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.PARTICIPANT__BASE_PROPERTY, oldBase_Property, base_Property));
			}
		}
		return base_Property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetBase_Property() {
		return base_Property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Property(Property newBase_Property) {
		Property oldBase_Property = base_Property;
		base_Property = newBase_Property;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.PARTICIPANT__BASE_PROPERTY, oldBase_Property, base_Property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNProcess getProcessRef() {
		if (processRef != null && processRef.eIsProxy()) {
			InternalEObject oldProcessRef = (InternalEObject)processRef;
			processRef = (BPMNProcess)eResolveProxy(oldProcessRef);
			if (processRef != oldProcessRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.PARTICIPANT__PROCESS_REF, oldProcessRef, processRef));
			}
		}
		return processRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNProcess basicGetProcessRef() {
		return processRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessRef(BPMNProcess newProcessRef) {
		BPMNProcess oldProcessRef = processRef;
		processRef = newProcessRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.PARTICIPANT__PROCESS_REF, oldProcessRef, processRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParticipantMultiplicity getParticipantMultiplicity() {
		if (participantMultiplicity != null && participantMultiplicity.eIsProxy()) {
			InternalEObject oldParticipantMultiplicity = (InternalEObject)participantMultiplicity;
			participantMultiplicity = (ParticipantMultiplicity)eResolveProxy(oldParticipantMultiplicity);
			if (participantMultiplicity != oldParticipantMultiplicity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.PARTICIPANT__PARTICIPANT_MULTIPLICITY, oldParticipantMultiplicity, participantMultiplicity));
			}
		}
		return participantMultiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParticipantMultiplicity basicGetParticipantMultiplicity() {
		return participantMultiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParticipantMultiplicity(ParticipantMultiplicity newParticipantMultiplicity) {
		ParticipantMultiplicity oldParticipantMultiplicity = participantMultiplicity;
		participantMultiplicity = newParticipantMultiplicity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.PARTICIPANT__PARTICIPANT_MULTIPLICITY, oldParticipantMultiplicity, participantMultiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PartnerEntity> getPartnerEntityRef() {
		if (partnerEntityRef == null) {
			partnerEntityRef = new EObjectWithInverseResolvingEList.ManyInverse<PartnerEntity>(PartnerEntity.class, this, BPMNProfilePackage.PARTICIPANT__PARTNER_ENTITY_REF, BPMNProfilePackage.PARTNER_ENTITY__PARTICIPANT_REF);
		}
		return partnerEntityRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PartnerRole> getPartnerRoleRef() {
		if (partnerRoleRef == null) {
			partnerRoleRef = new EObjectWithInverseResolvingEList.ManyInverse<PartnerRole>(PartnerRole.class, this, BPMNProfilePackage.PARTICIPANT__PARTNER_ROLE_REF, BPMNProfilePackage.PARTNER_ROLE__PARTICIPANT_REF);
		}
		return partnerRoleRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BPMNInterface> getInterfaceRefs() {
		if (interfaceRefs == null) {
			interfaceRefs = new EObjectResolvingEList<BPMNInterface>(BPMNInterface.class, this, BPMNProfilePackage.PARTICIPANT__INTERFACE_REFS);
		}
		return interfaceRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean Participantownership(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 BPMNProfileValidator.DIAGNOSTIC_SOURCE,
						 BPMNProfileValidator.PARTICIPANT__PARTICIPANTOWNERSHIP,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "Participantownership", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean Participanttype(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 BPMNProfileValidator.DIAGNOSTIC_SOURCE,
						 BPMNProfileValidator.PARTICIPANT__PARTICIPANTTYPE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "Participanttype", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ParticipantmultiplicityMinimum(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 BPMNProfileValidator.DIAGNOSTIC_SOURCE,
						 BPMNProfileValidator.PARTICIPANT__PARTICIPANTMULTIPLICITY_MINIMUM,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ParticipantmultiplicityMinimum", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean Participantrealizationsupplier(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 BPMNProfileValidator.DIAGNOSTIC_SOURCE,
						 BPMNProfileValidator.PARTICIPANT__PARTICIPANTREALIZATIONSUPPLIER,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "Participantrealizationsupplier", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ParticipantprocessRef(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 BPMNProfileValidator.DIAGNOSTIC_SOURCE,
						 BPMNProfileValidator.PARTICIPANT__PARTICIPANTPROCESS_REF,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ParticipantprocessRef", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ParticipantmultiplicityMaximum(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 BPMNProfileValidator.DIAGNOSTIC_SOURCE,
						 BPMNProfileValidator.PARTICIPANT__PARTICIPANTMULTIPLICITY_MAXIMUM,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ParticipantmultiplicityMaximum", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean participantpartnerEntityRef(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 BPMNProfileValidator.DIAGNOSTIC_SOURCE,
						 BPMNProfileValidator.PARTICIPANT__PARTICIPANTPARTNER_ENTITY_REF,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "participantpartnerEntityRef", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean participantpartnerRoleRef(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 BPMNProfileValidator.DIAGNOSTIC_SOURCE,
						 BPMNProfileValidator.PARTICIPANT__PARTICIPANTPARTNER_ROLE_REF,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "participantpartnerRoleRef", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ParticipantinterfaceRefs(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 BPMNProfileValidator.DIAGNOSTIC_SOURCE,
						 BPMNProfileValidator.PARTICIPANT__PARTICIPANTINTERFACE_REFS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ParticipantinterfaceRefs", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BPMNProfilePackage.PARTICIPANT__PARTNER_ENTITY_REF:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPartnerEntityRef()).basicAdd(otherEnd, msgs);
			case BPMNProfilePackage.PARTICIPANT__PARTNER_ROLE_REF:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPartnerRoleRef()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BPMNProfilePackage.PARTICIPANT__PARTNER_ENTITY_REF:
				return ((InternalEList<?>)getPartnerEntityRef()).basicRemove(otherEnd, msgs);
			case BPMNProfilePackage.PARTICIPANT__PARTNER_ROLE_REF:
				return ((InternalEList<?>)getPartnerRoleRef()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BPMNProfilePackage.PARTICIPANT__BASE_PROPERTY:
				if (resolve) return getBase_Property();
				return basicGetBase_Property();
			case BPMNProfilePackage.PARTICIPANT__PROCESS_REF:
				if (resolve) return getProcessRef();
				return basicGetProcessRef();
			case BPMNProfilePackage.PARTICIPANT__PARTICIPANT_MULTIPLICITY:
				if (resolve) return getParticipantMultiplicity();
				return basicGetParticipantMultiplicity();
			case BPMNProfilePackage.PARTICIPANT__PARTNER_ENTITY_REF:
				return getPartnerEntityRef();
			case BPMNProfilePackage.PARTICIPANT__PARTNER_ROLE_REF:
				return getPartnerRoleRef();
			case BPMNProfilePackage.PARTICIPANT__INTERFACE_REFS:
				return getInterfaceRefs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BPMNProfilePackage.PARTICIPANT__BASE_PROPERTY:
				setBase_Property((Property)newValue);
				return;
			case BPMNProfilePackage.PARTICIPANT__PROCESS_REF:
				setProcessRef((BPMNProcess)newValue);
				return;
			case BPMNProfilePackage.PARTICIPANT__PARTICIPANT_MULTIPLICITY:
				setParticipantMultiplicity((ParticipantMultiplicity)newValue);
				return;
			case BPMNProfilePackage.PARTICIPANT__PARTNER_ENTITY_REF:
				getPartnerEntityRef().clear();
				getPartnerEntityRef().addAll((Collection<? extends PartnerEntity>)newValue);
				return;
			case BPMNProfilePackage.PARTICIPANT__PARTNER_ROLE_REF:
				getPartnerRoleRef().clear();
				getPartnerRoleRef().addAll((Collection<? extends PartnerRole>)newValue);
				return;
			case BPMNProfilePackage.PARTICIPANT__INTERFACE_REFS:
				getInterfaceRefs().clear();
				getInterfaceRefs().addAll((Collection<? extends BPMNInterface>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BPMNProfilePackage.PARTICIPANT__BASE_PROPERTY:
				setBase_Property((Property)null);
				return;
			case BPMNProfilePackage.PARTICIPANT__PROCESS_REF:
				setProcessRef((BPMNProcess)null);
				return;
			case BPMNProfilePackage.PARTICIPANT__PARTICIPANT_MULTIPLICITY:
				setParticipantMultiplicity((ParticipantMultiplicity)null);
				return;
			case BPMNProfilePackage.PARTICIPANT__PARTNER_ENTITY_REF:
				getPartnerEntityRef().clear();
				return;
			case BPMNProfilePackage.PARTICIPANT__PARTNER_ROLE_REF:
				getPartnerRoleRef().clear();
				return;
			case BPMNProfilePackage.PARTICIPANT__INTERFACE_REFS:
				getInterfaceRefs().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BPMNProfilePackage.PARTICIPANT__BASE_PROPERTY:
				return base_Property != null;
			case BPMNProfilePackage.PARTICIPANT__PROCESS_REF:
				return processRef != null;
			case BPMNProfilePackage.PARTICIPANT__PARTICIPANT_MULTIPLICITY:
				return participantMultiplicity != null;
			case BPMNProfilePackage.PARTICIPANT__PARTNER_ENTITY_REF:
				return partnerEntityRef != null && !partnerEntityRef.isEmpty();
			case BPMNProfilePackage.PARTICIPANT__PARTNER_ROLE_REF:
				return partnerRoleRef != null && !partnerRoleRef.isEmpty();
			case BPMNProfilePackage.PARTICIPANT__INTERFACE_REFS:
				return interfaceRefs != null && !interfaceRefs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case BPMNProfilePackage.PARTICIPANT___PARTICIPANTOWNERSHIP__DIAGNOSTICCHAIN_MAP:
				return Participantownership((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.PARTICIPANT___PARTICIPANTTYPE__DIAGNOSTICCHAIN_MAP:
				return Participanttype((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.PARTICIPANT___PARTICIPANTMULTIPLICITY_MINIMUM__DIAGNOSTICCHAIN_MAP:
				return ParticipantmultiplicityMinimum((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.PARTICIPANT___PARTICIPANTREALIZATIONSUPPLIER__DIAGNOSTICCHAIN_MAP:
				return Participantrealizationsupplier((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.PARTICIPANT___PARTICIPANTPROCESS_REF__DIAGNOSTICCHAIN_MAP:
				return ParticipantprocessRef((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.PARTICIPANT___PARTICIPANTMULTIPLICITY_MAXIMUM__DIAGNOSTICCHAIN_MAP:
				return ParticipantmultiplicityMaximum((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.PARTICIPANT___PARTICIPANTPARTNER_ENTITY_REF__DIAGNOSTICCHAIN_MAP:
				return participantpartnerEntityRef((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.PARTICIPANT___PARTICIPANTPARTNER_ROLE_REF__DIAGNOSTICCHAIN_MAP:
				return participantpartnerRoleRef((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.PARTICIPANT___PARTICIPANTINTERFACE_REFS__DIAGNOSTICCHAIN_MAP:
				return ParticipantinterfaceRefs((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ParticipantImpl
