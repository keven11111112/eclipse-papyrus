/**
 */
package org.eclipse.papyrus.aof.emf.tests.population.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.aof.emf.tests.population.Person;
import org.eclipse.papyrus.aof.emf.tests.population.PopulationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.aof.emf.tests.population.impl.PersonImpl#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.aof.emf.tests.population.impl.PersonImpl#getAge <em>Age</em>}</li>
 * <li>{@link org.eclipse.papyrus.aof.emf.tests.population.impl.PersonImpl#getEmails <em>Emails</em>}</li>
 * <li>{@link org.eclipse.papyrus.aof.emf.tests.population.impl.PersonImpl#getParent <em>Parent</em>}</li>
 * <li>{@link org.eclipse.papyrus.aof.emf.tests.population.impl.PersonImpl#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PersonImpl extends MinimalEObjectImpl.Container implements Person {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "Name";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getAge() <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getAge()
	 * @generated
	 * @ordered
	 */
	protected static final int AGE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAge() <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getAge()
	 * @generated
	 * @ordered
	 */
	protected int age = AGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEmails() <em>Emails</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getEmails()
	 * @generated
	 * @ordered
	 */
	protected EList<String> emails;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected Person parent;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<Person> children;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected PersonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PopulationPackage.Literals.PERSON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PopulationPackage.PERSON__NAME, oldName, name));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public int getAge() {
		return age;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setAge(int newAge) {
		int oldAge = age;
		age = newAge;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PopulationPackage.PERSON__AGE, oldAge, age));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<String> getEmails() {
		if (emails == null) {
			emails = new EDataTypeUniqueEList<String>(String.class, this, PopulationPackage.PERSON__EMAILS);
		}
		return emails;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Person getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject) parent;
			parent = (Person) eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PopulationPackage.PERSON__PARENT, oldParent, parent));
				}
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Person basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetParent(Person newParent, NotificationChain msgs) {
		Person oldParent = parent;
		parent = newParent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PopulationPackage.PERSON__PARENT, oldParent, newParent);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setParent(Person newParent) {
		if (newParent != parent) {
			NotificationChain msgs = null;
			if (parent != null) {
				msgs = ((InternalEObject) parent).eInverseRemove(this, PopulationPackage.PERSON__CHILDREN, Person.class, msgs);
			}
			if (newParent != null) {
				msgs = ((InternalEObject) newParent).eInverseAdd(this, PopulationPackage.PERSON__CHILDREN, Person.class, msgs);
			}
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PopulationPackage.PERSON__PARENT, newParent, newParent));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<Person> getChildren() {
		if (children == null) {
			children = new EObjectWithInverseResolvingEList<Person>(Person.class, this, PopulationPackage.PERSON__CHILDREN, PopulationPackage.PERSON__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case PopulationPackage.PERSON__PARENT:
			if (parent != null) {
				msgs = ((InternalEObject) parent).eInverseRemove(this, PopulationPackage.PERSON__CHILDREN, Person.class, msgs);
			}
			return basicSetParent((Person) otherEnd, msgs);
		case PopulationPackage.PERSON__CHILDREN:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getChildren()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case PopulationPackage.PERSON__PARENT:
			return basicSetParent(null, msgs);
		case PopulationPackage.PERSON__CHILDREN:
			return ((InternalEList<?>) getChildren()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case PopulationPackage.PERSON__NAME:
			return getName();
		case PopulationPackage.PERSON__AGE:
			return getAge();
		case PopulationPackage.PERSON__EMAILS:
			return getEmails();
		case PopulationPackage.PERSON__PARENT:
			if (resolve) {
				return getParent();
			}
			return basicGetParent();
		case PopulationPackage.PERSON__CHILDREN:
			return getChildren();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case PopulationPackage.PERSON__NAME:
			setName((String) newValue);
			return;
		case PopulationPackage.PERSON__AGE:
			setAge((Integer) newValue);
			return;
		case PopulationPackage.PERSON__EMAILS:
			getEmails().clear();
			getEmails().addAll((Collection<? extends String>) newValue);
			return;
		case PopulationPackage.PERSON__PARENT:
			setParent((Person) newValue);
			return;
		case PopulationPackage.PERSON__CHILDREN:
			getChildren().clear();
			getChildren().addAll((Collection<? extends Person>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case PopulationPackage.PERSON__NAME:
			setName(NAME_EDEFAULT);
			return;
		case PopulationPackage.PERSON__AGE:
			setAge(AGE_EDEFAULT);
			return;
		case PopulationPackage.PERSON__EMAILS:
			getEmails().clear();
			return;
		case PopulationPackage.PERSON__PARENT:
			setParent((Person) null);
			return;
		case PopulationPackage.PERSON__CHILDREN:
			getChildren().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case PopulationPackage.PERSON__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case PopulationPackage.PERSON__AGE:
			return age != AGE_EDEFAULT;
		case PopulationPackage.PERSON__EMAILS:
			return emails != null && !emails.isEmpty();
		case PopulationPackage.PERSON__PARENT:
			return parent != null;
		case PopulationPackage.PERSON__CHILDREN:
			return children != null && !children.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", age: ");
		result.append(age);
		result.append(", emails: ");
		result.append(emails);
		result.append(')');
		return result.toString();
	}

} // PersonImpl
