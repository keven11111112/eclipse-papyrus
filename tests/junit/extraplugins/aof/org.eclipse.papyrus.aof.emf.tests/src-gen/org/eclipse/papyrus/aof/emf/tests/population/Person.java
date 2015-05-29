/**
 */
package org.eclipse.papyrus.aof.emf.tests.population;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.aof.emf.tests.population.Person#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.aof.emf.tests.population.Person#getAge <em>Age</em>}</li>
 * <li>{@link org.eclipse.papyrus.aof.emf.tests.population.Person#getEmails <em>Emails</em>}</li>
 * <li>{@link org.eclipse.papyrus.aof.emf.tests.population.Person#getParent <em>Parent</em>}</li>
 * <li>{@link org.eclipse.papyrus.aof.emf.tests.population.Person#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.aof.emf.tests.population.PopulationPackage#getPerson()
 * @model
 * @generated
 */
public interface Person extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"Name"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.aof.emf.tests.population.PopulationPackage#getPerson_Name()
	 * @model default="Name" unique="false" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.aof.emf.tests.population.Person#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Age</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Age</em>' attribute.
	 * @see #setAge(int)
	 * @see org.eclipse.papyrus.aof.emf.tests.population.PopulationPackage#getPerson_Age()
	 * @model unique="false"
	 * @generated
	 */
	int getAge();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.aof.emf.tests.population.Person#getAge <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Age</em>' attribute.
	 * @see #getAge()
	 * @generated
	 */
	void setAge(int value);

	/**
	 * Returns the value of the '<em><b>Emails</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Emails</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Emails</em>' attribute list.
	 * @see org.eclipse.papyrus.aof.emf.tests.population.PopulationPackage#getPerson_Emails()
	 * @model
	 * @generated
	 */
	EList<String> getEmails();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.aof.emf.tests.population.Person#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(Person)
	 * @see org.eclipse.papyrus.aof.emf.tests.population.PopulationPackage#getPerson_Parent()
	 * @see org.eclipse.papyrus.aof.emf.tests.population.Person#getChildren
	 * @model opposite="children"
	 * @generated
	 */
	Person getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.aof.emf.tests.population.Person#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Person value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.aof.emf.tests.population.Person}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.aof.emf.tests.population.Person#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see org.eclipse.papyrus.aof.emf.tests.population.PopulationPackage#getPerson_Children()
	 * @see org.eclipse.papyrus.aof.emf.tests.population.Person#getParent
	 * @model opposite="parent" ordered="false"
	 * @generated
	 */
	EList<Person> getChildren();

} // Person
