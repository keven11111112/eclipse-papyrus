/**
 */
package org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gmft Based Representation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.GmftBasedRepresentation#getReusedId <em>Reused Id</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.ExpansionModelPackage#getGmftBasedRepresentation()
 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='GMFT_Based_Representation'"
 * @generated
 */
public interface GmftBasedRepresentation extends Representation {
	/**
	 * Returns the value of the '<em><b>Reused Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reused Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reused Id</em>' attribute.
	 * @see #setReusedId(String)
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.ExpansionModelPackage#getGmftBasedRepresentation_ReusedId()
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='reusedID'"
	 * @generated
	 */
	String getReusedId();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.GmftBasedRepresentation#getReusedId <em>Reused Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reused Id</em>' attribute.
	 * @see #getReusedId()
	 * @generated
	 */
	void setReusedId(String value);

} // GmftBasedRepresentation
