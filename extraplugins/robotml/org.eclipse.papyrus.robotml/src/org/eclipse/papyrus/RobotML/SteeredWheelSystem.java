/**
 */
package org.eclipse.papyrus.RobotML;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Steered Wheel System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelRadius <em>Wheel Radius</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelWidth <em>Wheel Width</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getSuspensionRestLength <em>Suspension Rest Length</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelConnectionHeight <em>Wheel Connection Height</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getTypeOfWheel <em>Type Of Wheel</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDkp <em>Wheel Velocity PI Dkp</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDki <em>Wheel Velocity PI Dki</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDkd <em>Wheel Velocity PI Dkd</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelSteeringPIDkp <em>Wheel Steering PI Dkp</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelSteeringPIDkd <em>Wheel Steering PI Dkd</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelFriction <em>Wheel Friction</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getSuspensionStiffness <em>Suspension Stiffness</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getSuspensionDamping <em>Suspension Damping</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getSuspensionCompression <em>Suspension Compression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDmaxSum <em>Wheel Velocity PI Dmax Sum</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDmaxVal <em>Wheel Velocity PI Dmax Val</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem()
 * @model
 * @generated
 */
public interface SteeredWheelSystem extends LocomotionSystem {
	/**
	 * Returns the value of the '<em><b>Wheel Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wheel Radius</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wheel Radius</em>' attribute.
	 * @see #setWheelRadius(Float32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_WheelRadius()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	Object getWheelRadius();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelRadius <em>Wheel Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wheel Radius</em>' attribute.
	 * @see #getWheelRadius()
	 * @generated
	 */
	void setWheelRadius(Object value);

	/**
	 * Returns the value of the '<em><b>Wheel Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wheel Width</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wheel Width</em>' attribute.
	 * @see #setWheelWidth(Float32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_WheelWidth()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	Object getWheelWidth();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelWidth <em>Wheel Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wheel Width</em>' attribute.
	 * @see #getWheelWidth()
	 * @generated
	 */
	void setWheelWidth(Object value);

	/**
	 * Returns the value of the '<em><b>Suspension Rest Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suspension Rest Length</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suspension Rest Length</em>' attribute.
	 * @see #setSuspensionRestLength(Float32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_SuspensionRestLength()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	Object getSuspensionRestLength();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getSuspensionRestLength <em>Suspension Rest Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suspension Rest Length</em>' attribute.
	 * @see #getSuspensionRestLength()
	 * @generated
	 */
	void setSuspensionRestLength(Object value);

	/**
	 * Returns the value of the '<em><b>Wheel Connection Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wheel Connection Height</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wheel Connection Height</em>' attribute.
	 * @see #setWheelConnectionHeight(Float32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_WheelConnectionHeight()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	Object getWheelConnectionHeight();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelConnectionHeight <em>Wheel Connection Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wheel Connection Height</em>' attribute.
	 * @see #getWheelConnectionHeight()
	 * @generated
	 */
	void setWheelConnectionHeight(Object value);

	/**
	 * Returns the value of the '<em><b>Type Of Wheel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Of Wheel</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Of Wheel</em>' attribute.
	 * @see #setTypeOfWheel(String)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_TypeOfWheel()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.String" required="true" ordered="false"
	 * @generated
	 */
	Object getTypeOfWheel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getTypeOfWheel <em>Type Of Wheel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Of Wheel</em>' attribute.
	 * @see #getTypeOfWheel()
	 * @generated
	 */
	void setTypeOfWheel(Object value);

	/**
	 * Returns the value of the '<em><b>Wheel Velocity PI Dkp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wheel Velocity PI Dkp</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wheel Velocity PI Dkp</em>' attribute.
	 * @see #setWheelVelocityPIDkp(Float32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_WheelVelocityPIDkp()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	Object getWheelVelocityPIDkp();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDkp <em>Wheel Velocity PI Dkp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wheel Velocity PI Dkp</em>' attribute.
	 * @see #getWheelVelocityPIDkp()
	 * @generated
	 */
	void setWheelVelocityPIDkp(Object value);

	/**
	 * Returns the value of the '<em><b>Wheel Velocity PI Dki</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wheel Velocity PI Dki</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wheel Velocity PI Dki</em>' attribute.
	 * @see #setWheelVelocityPIDki(Float32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_WheelVelocityPIDki()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	Object getWheelVelocityPIDki();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDki <em>Wheel Velocity PI Dki</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wheel Velocity PI Dki</em>' attribute.
	 * @see #getWheelVelocityPIDki()
	 * @generated
	 */
	void setWheelVelocityPIDki(Object value);

	/**
	 * Returns the value of the '<em><b>Wheel Velocity PI Dkd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wheel Velocity PI Dkd</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wheel Velocity PI Dkd</em>' attribute.
	 * @see #setWheelVelocityPIDkd(Float32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_WheelVelocityPIDkd()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	Object getWheelVelocityPIDkd();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDkd <em>Wheel Velocity PI Dkd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wheel Velocity PI Dkd</em>' attribute.
	 * @see #getWheelVelocityPIDkd()
	 * @generated
	 */
	void setWheelVelocityPIDkd(Object value);

	/**
	 * Returns the value of the '<em><b>Wheel Steering PI Dkp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wheel Steering PI Dkp</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wheel Steering PI Dkp</em>' attribute.
	 * @see #setWheelSteeringPIDkp(Float32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_WheelSteeringPIDkp()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	Object getWheelSteeringPIDkp();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelSteeringPIDkp <em>Wheel Steering PI Dkp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wheel Steering PI Dkp</em>' attribute.
	 * @see #getWheelSteeringPIDkp()
	 * @generated
	 */
	void setWheelSteeringPIDkp(Object value);

	/**
	 * Returns the value of the '<em><b>Wheel Steering PI Dkd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wheel Steering PI Dkd</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wheel Steering PI Dkd</em>' attribute.
	 * @see #setWheelSteeringPIDkd(Float32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_WheelSteeringPIDkd()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	Object getWheelSteeringPIDkd();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelSteeringPIDkd <em>Wheel Steering PI Dkd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wheel Steering PI Dkd</em>' attribute.
	 * @see #getWheelSteeringPIDkd()
	 * @generated
	 */
	void setWheelSteeringPIDkd(Object value);

	/**
	 * Returns the value of the '<em><b>Wheel Friction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wheel Friction</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wheel Friction</em>' attribute.
	 * @see #setWheelFriction(Float32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_WheelFriction()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	Object getWheelFriction();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelFriction <em>Wheel Friction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wheel Friction</em>' attribute.
	 * @see #getWheelFriction()
	 * @generated
	 */
	void setWheelFriction(Object value);

	/**
	 * Returns the value of the '<em><b>Suspension Stiffness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suspension Stiffness</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suspension Stiffness</em>' attribute.
	 * @see #setSuspensionStiffness(Float32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_SuspensionStiffness()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	Object getSuspensionStiffness();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getSuspensionStiffness <em>Suspension Stiffness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suspension Stiffness</em>' attribute.
	 * @see #getSuspensionStiffness()
	 * @generated
	 */
	void setSuspensionStiffness(Object value);

	/**
	 * Returns the value of the '<em><b>Suspension Damping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suspension Damping</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suspension Damping</em>' attribute.
	 * @see #setSuspensionDamping(Float32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_SuspensionDamping()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	Object getSuspensionDamping();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getSuspensionDamping <em>Suspension Damping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suspension Damping</em>' attribute.
	 * @see #getSuspensionDamping()
	 * @generated
	 */
	void setSuspensionDamping(Object value);

	/**
	 * Returns the value of the '<em><b>Suspension Compression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suspension Compression</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suspension Compression</em>' attribute.
	 * @see #setSuspensionCompression(Float32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_SuspensionCompression()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	Object getSuspensionCompression();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getSuspensionCompression <em>Suspension Compression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suspension Compression</em>' attribute.
	 * @see #getSuspensionCompression()
	 * @generated
	 */
	void setSuspensionCompression(Object value);

	/**
	 * Returns the value of the '<em><b>Wheel Velocity PI Dmax Sum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wheel Velocity PI Dmax Sum</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wheel Velocity PI Dmax Sum</em>' attribute.
	 * @see #setWheelVelocityPIDmaxSum(Float32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_WheelVelocityPIDmaxSum()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	Object getWheelVelocityPIDmaxSum();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDmaxSum <em>Wheel Velocity PI Dmax Sum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wheel Velocity PI Dmax Sum</em>' attribute.
	 * @see #getWheelVelocityPIDmaxSum()
	 * @generated
	 */
	void setWheelVelocityPIDmaxSum(Object value);

	/**
	 * Returns the value of the '<em><b>Wheel Velocity PI Dmax Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wheel Velocity PI Dmax Val</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wheel Velocity PI Dmax Val</em>' attribute.
	 * @see #setWheelVelocityPIDmaxVal(Float32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getSteeredWheelSystem_WheelVelocityPIDmaxVal()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	Object getWheelVelocityPIDmaxVal();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDmaxVal <em>Wheel Velocity PI Dmax Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wheel Velocity PI Dmax Val</em>' attribute.
	 * @see #getWheelVelocityPIDmaxVal()
	 * @generated
	 */
	void setWheelVelocityPIDmaxVal(Object value);

} // SteeredWheelSystem
