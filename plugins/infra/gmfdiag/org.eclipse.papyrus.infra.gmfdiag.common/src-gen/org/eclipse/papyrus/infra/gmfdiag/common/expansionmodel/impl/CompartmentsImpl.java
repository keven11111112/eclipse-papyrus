/**
 */
package org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.CompartmentKind;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Compartments;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.ExpansionModelPackage;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Representation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compartments</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.CompartmentsImpl#getHint <em>Hint</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.CompartmentsImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.CompartmentsImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.CompartmentsImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.CompartmentsImpl#getEditPartQualifiedName <em>Edit Part Qualified Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompartmentsImpl extends MinimalEObjectImpl.Container implements Compartments {
	/**
	 * The default value of the '{@link #getHint() <em>Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHint()
	 * @generated
	 * @ordered
	 */
	protected static final String HINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHint() <em>Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHint()
	 * @generated
	 * @ordered
	 */
	protected String hint = HINT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<Representation> children;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final CompartmentKind KIND_EDEFAULT = CompartmentKind.LIST;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected CompartmentKind kind = KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getEditPartQualifiedName() <em>Edit Part Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditPartQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String EDIT_PART_QUALIFIED_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEditPartQualifiedName() <em>Edit Part Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditPartQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected String editPartQualifiedName = EDIT_PART_QUALIFIED_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompartmentsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpansionModelPackage.Literals.COMPARTMENTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHint() {
		return hint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHint(String newHint) {
		String oldHint = hint;
		hint = newHint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpansionModelPackage.COMPARTMENTS__HINT, oldHint, hint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Representation> getChildren() {
		if (children == null) {
			children = new EObjectResolvingEList<Representation>(Representation.class, this, ExpansionModelPackage.COMPARTMENTS__CHILDREN);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompartmentKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(CompartmentKind newKind) {
		CompartmentKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpansionModelPackage.COMPARTMENTS__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpansionModelPackage.COMPARTMENTS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEditPartQualifiedName() {
		return editPartQualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditPartQualifiedName(String newEditPartQualifiedName) {
		String oldEditPartQualifiedName = editPartQualifiedName;
		editPartQualifiedName = newEditPartQualifiedName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpansionModelPackage.COMPARTMENTS__EDIT_PART_QUALIFIED_NAME, oldEditPartQualifiedName, editPartQualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpansionModelPackage.COMPARTMENTS__HINT:
				return getHint();
			case ExpansionModelPackage.COMPARTMENTS__CHILDREN:
				return getChildren();
			case ExpansionModelPackage.COMPARTMENTS__KIND:
				return getKind();
			case ExpansionModelPackage.COMPARTMENTS__NAME:
				return getName();
			case ExpansionModelPackage.COMPARTMENTS__EDIT_PART_QUALIFIED_NAME:
				return getEditPartQualifiedName();
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
			case ExpansionModelPackage.COMPARTMENTS__HINT:
				setHint((String)newValue);
				return;
			case ExpansionModelPackage.COMPARTMENTS__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends Representation>)newValue);
				return;
			case ExpansionModelPackage.COMPARTMENTS__KIND:
				setKind((CompartmentKind)newValue);
				return;
			case ExpansionModelPackage.COMPARTMENTS__NAME:
				setName((String)newValue);
				return;
			case ExpansionModelPackage.COMPARTMENTS__EDIT_PART_QUALIFIED_NAME:
				setEditPartQualifiedName((String)newValue);
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
			case ExpansionModelPackage.COMPARTMENTS__HINT:
				setHint(HINT_EDEFAULT);
				return;
			case ExpansionModelPackage.COMPARTMENTS__CHILDREN:
				getChildren().clear();
				return;
			case ExpansionModelPackage.COMPARTMENTS__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case ExpansionModelPackage.COMPARTMENTS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ExpansionModelPackage.COMPARTMENTS__EDIT_PART_QUALIFIED_NAME:
				setEditPartQualifiedName(EDIT_PART_QUALIFIED_NAME_EDEFAULT);
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
			case ExpansionModelPackage.COMPARTMENTS__HINT:
				return HINT_EDEFAULT == null ? hint != null : !HINT_EDEFAULT.equals(hint);
			case ExpansionModelPackage.COMPARTMENTS__CHILDREN:
				return children != null && !children.isEmpty();
			case ExpansionModelPackage.COMPARTMENTS__KIND:
				return kind != KIND_EDEFAULT;
			case ExpansionModelPackage.COMPARTMENTS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ExpansionModelPackage.COMPARTMENTS__EDIT_PART_QUALIFIED_NAME:
				return EDIT_PART_QUALIFIED_NAME_EDEFAULT == null ? editPartQualifiedName != null : !EDIT_PART_QUALIFIED_NAME_EDEFAULT.equals(editPartQualifiedName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (hint: ");
		result.append(hint);
		result.append(", kind: ");
		result.append(kind);
		result.append(", name: ");
		result.append(name);
		result.append(", editPartQualifiedName: ");
		result.append(editPartQualifiedName);
		result.append(')');
		return result.toString();
	}

} //CompartmentsImpl
