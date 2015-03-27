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

import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Compartments;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.ExpansionModelPackage;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Representation;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.RepresentationKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Representation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.RepresentationImpl#getEditPartQualifiedName <em>Edit Part Qualified Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.RepresentationImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.RepresentationImpl#getGraphicalElementType <em>Graphical Element Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.RepresentationImpl#getCompartments <em>Compartments</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.RepresentationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.RepresentationImpl#getViewFactory <em>View Factory</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RepresentationImpl extends MinimalEObjectImpl.Container implements Representation {
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
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final RepresentationKind KIND_EDEFAULT = RepresentationKind.SHAPE;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected RepresentationKind kind = KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getGraphicalElementType() <em>Graphical Element Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphicalElementType()
	 * @generated
	 * @ordered
	 */
	protected static final String GRAPHICAL_ELEMENT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGraphicalElementType() <em>Graphical Element Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphicalElementType()
	 * @generated
	 * @ordered
	 */
	protected String graphicalElementType = GRAPHICAL_ELEMENT_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCompartments() <em>Compartments</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompartments()
	 * @generated
	 * @ordered
	 */
	protected EList<Compartments> compartments;

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
	 * The default value of the '{@link #getViewFactory() <em>View Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewFactory()
	 * @generated
	 * @ordered
	 */
	protected static final String VIEW_FACTORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getViewFactory() <em>View Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewFactory()
	 * @generated
	 * @ordered
	 */
	protected String viewFactory = VIEW_FACTORY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepresentationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpansionModelPackage.Literals.REPRESENTATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExpansionModelPackage.REPRESENTATION__EDIT_PART_QUALIFIED_NAME, oldEditPartQualifiedName, editPartQualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepresentationKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(RepresentationKind newKind) {
		RepresentationKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpansionModelPackage.REPRESENTATION__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGraphicalElementType() {
		return graphicalElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraphicalElementType(String newGraphicalElementType) {
		String oldGraphicalElementType = graphicalElementType;
		graphicalElementType = newGraphicalElementType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpansionModelPackage.REPRESENTATION__GRAPHICAL_ELEMENT_TYPE, oldGraphicalElementType, graphicalElementType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Compartments> getCompartments() {
		if (compartments == null) {
			compartments = new EObjectResolvingEList<Compartments>(Compartments.class, this, ExpansionModelPackage.REPRESENTATION__COMPARTMENTS);
		}
		return compartments;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExpansionModelPackage.REPRESENTATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getViewFactory() {
		return viewFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViewFactory(String newViewFactory) {
		String oldViewFactory = viewFactory;
		viewFactory = newViewFactory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpansionModelPackage.REPRESENTATION__VIEW_FACTORY, oldViewFactory, viewFactory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpansionModelPackage.REPRESENTATION__EDIT_PART_QUALIFIED_NAME:
				return getEditPartQualifiedName();
			case ExpansionModelPackage.REPRESENTATION__KIND:
				return getKind();
			case ExpansionModelPackage.REPRESENTATION__GRAPHICAL_ELEMENT_TYPE:
				return getGraphicalElementType();
			case ExpansionModelPackage.REPRESENTATION__COMPARTMENTS:
				return getCompartments();
			case ExpansionModelPackage.REPRESENTATION__NAME:
				return getName();
			case ExpansionModelPackage.REPRESENTATION__VIEW_FACTORY:
				return getViewFactory();
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
			case ExpansionModelPackage.REPRESENTATION__EDIT_PART_QUALIFIED_NAME:
				setEditPartQualifiedName((String)newValue);
				return;
			case ExpansionModelPackage.REPRESENTATION__KIND:
				setKind((RepresentationKind)newValue);
				return;
			case ExpansionModelPackage.REPRESENTATION__GRAPHICAL_ELEMENT_TYPE:
				setGraphicalElementType((String)newValue);
				return;
			case ExpansionModelPackage.REPRESENTATION__COMPARTMENTS:
				getCompartments().clear();
				getCompartments().addAll((Collection<? extends Compartments>)newValue);
				return;
			case ExpansionModelPackage.REPRESENTATION__NAME:
				setName((String)newValue);
				return;
			case ExpansionModelPackage.REPRESENTATION__VIEW_FACTORY:
				setViewFactory((String)newValue);
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
			case ExpansionModelPackage.REPRESENTATION__EDIT_PART_QUALIFIED_NAME:
				setEditPartQualifiedName(EDIT_PART_QUALIFIED_NAME_EDEFAULT);
				return;
			case ExpansionModelPackage.REPRESENTATION__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case ExpansionModelPackage.REPRESENTATION__GRAPHICAL_ELEMENT_TYPE:
				setGraphicalElementType(GRAPHICAL_ELEMENT_TYPE_EDEFAULT);
				return;
			case ExpansionModelPackage.REPRESENTATION__COMPARTMENTS:
				getCompartments().clear();
				return;
			case ExpansionModelPackage.REPRESENTATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ExpansionModelPackage.REPRESENTATION__VIEW_FACTORY:
				setViewFactory(VIEW_FACTORY_EDEFAULT);
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
			case ExpansionModelPackage.REPRESENTATION__EDIT_PART_QUALIFIED_NAME:
				return EDIT_PART_QUALIFIED_NAME_EDEFAULT == null ? editPartQualifiedName != null : !EDIT_PART_QUALIFIED_NAME_EDEFAULT.equals(editPartQualifiedName);
			case ExpansionModelPackage.REPRESENTATION__KIND:
				return kind != KIND_EDEFAULT;
			case ExpansionModelPackage.REPRESENTATION__GRAPHICAL_ELEMENT_TYPE:
				return GRAPHICAL_ELEMENT_TYPE_EDEFAULT == null ? graphicalElementType != null : !GRAPHICAL_ELEMENT_TYPE_EDEFAULT.equals(graphicalElementType);
			case ExpansionModelPackage.REPRESENTATION__COMPARTMENTS:
				return compartments != null && !compartments.isEmpty();
			case ExpansionModelPackage.REPRESENTATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ExpansionModelPackage.REPRESENTATION__VIEW_FACTORY:
				return VIEW_FACTORY_EDEFAULT == null ? viewFactory != null : !VIEW_FACTORY_EDEFAULT.equals(viewFactory);
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
		result.append(" (editPartQualifiedName: ");
		result.append(editPartQualifiedName);
		result.append(", kind: ");
		result.append(kind);
		result.append(", graphicalElementType: ");
		result.append(graphicalElementType);
		result.append(", name: ");
		result.append(name);
		result.append(", viewFactory: ");
		result.append(viewFactory);
		result.append(')');
		return result.toString();
	}

} //RepresentationImpl
