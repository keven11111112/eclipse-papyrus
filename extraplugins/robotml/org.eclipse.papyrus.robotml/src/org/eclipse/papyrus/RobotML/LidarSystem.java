/**
 */
package org.eclipse.papyrus.RobotML;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lidar System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.LidarSystem#getNbLayers <em>Nb Layers</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.LidarSystem#getLayerAngleMin <em>Layer Angle Min</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.LidarSystem#getLayerAngleStep <em>Layer Angle Step</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.LidarSystem#getNoise <em>Noise</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.LidarSystem#getSigmaNoise <em>Sigma Noise</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.LidarSystem#getAngle_min <em>Angle min</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.LidarSystem#getAngle_max <em>Angle max</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.LidarSystem#getTime_increment <em>Time increment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.LidarSystem#getScan_time <em>Scan time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.LidarSystem#getRange_min <em>Range min</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.LidarSystem#getRange_max <em>Range max</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.LidarSystem#getNbRays <em>Nb Rays</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getLidarSystem()
 * @model
 * @generated
 */
public interface LidarSystem extends ObjectDetectionSensorSystem, ObjectTrackingSensorSystem {
	/**
	 * Returns the value of the '<em><b>Nb Layers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nb Layers</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nb Layers</em>' attribute.
	 * @see #setNbLayers(UInt32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getLidarSystem_NbLayers()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt32" required="true" ordered="false"
	 * @generated
	 */
	Object getNbLayers();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.LidarSystem#getNbLayers <em>Nb Layers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nb Layers</em>' attribute.
	 * @see #getNbLayers()
	 * @generated
	 */
	void setNbLayers(Object value);

	/**
	 * Returns the value of the '<em><b>Layer Angle Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Angle Min</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Angle Min</em>' attribute.
	 * @see #setLayerAngleMin(Float32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getLidarSystem_LayerAngleMin()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	Object getLayerAngleMin();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.LidarSystem#getLayerAngleMin <em>Layer Angle Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer Angle Min</em>' attribute.
	 * @see #getLayerAngleMin()
	 * @generated
	 */
	void setLayerAngleMin(Object value);

	/**
	 * Returns the value of the '<em><b>Layer Angle Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Angle Step</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Angle Step</em>' attribute.
	 * @see #setLayerAngleStep(Float32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getLidarSystem_LayerAngleStep()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	Object getLayerAngleStep();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.LidarSystem#getLayerAngleStep <em>Layer Angle Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer Angle Step</em>' attribute.
	 * @see #getLayerAngleStep()
	 * @generated
	 */
	void setLayerAngleStep(Object value);

	/**
	 * Returns the value of the '<em><b>Noise</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Noise</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Noise</em>' attribute.
	 * @see #setNoise(Bool)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getLidarSystem_Noise()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Bool" required="true" ordered="false"
	 * @generated
	 */
	Object getNoise();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.LidarSystem#getNoise <em>Noise</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Noise</em>' attribute.
	 * @see #getNoise()
	 * @generated
	 */
	void setNoise(Object value);

	/**
	 * Returns the value of the '<em><b>Sigma Noise</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sigma Noise</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sigma Noise</em>' attribute.
	 * @see #setSigmaNoise(Float32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getLidarSystem_SigmaNoise()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	Object getSigmaNoise();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.LidarSystem#getSigmaNoise <em>Sigma Noise</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sigma Noise</em>' attribute.
	 * @see #getSigmaNoise()
	 * @generated
	 */
	void setSigmaNoise(Object value);

	/**
	 * Returns the value of the '<em><b>Angle min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Angle min</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Angle min</em>' attribute.
	 * @see #setAngle_min(Float32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getLidarSystem_Angle_min()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	Object getAngle_min();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.LidarSystem#getAngle_min <em>Angle min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Angle min</em>' attribute.
	 * @see #getAngle_min()
	 * @generated
	 */
	void setAngle_min(Object value);

	/**
	 * Returns the value of the '<em><b>Angle max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Angle max</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Angle max</em>' attribute.
	 * @see #setAngle_max(Float32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getLidarSystem_Angle_max()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	Object getAngle_max();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.LidarSystem#getAngle_max <em>Angle max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Angle max</em>' attribute.
	 * @see #getAngle_max()
	 * @generated
	 */
	void setAngle_max(Object value);

	/**
	 * Returns the value of the '<em><b>Time increment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time increment</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time increment</em>' attribute.
	 * @see #setTime_increment(Float32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getLidarSystem_Time_increment()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='time_increment '"
	 * @generated
	 */
	Object getTime_increment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.LidarSystem#getTime_increment <em>Time increment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time increment</em>' attribute.
	 * @see #getTime_increment()
	 * @generated
	 */
	void setTime_increment(Object value);

	/**
	 * Returns the value of the '<em><b>Scan time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scan time</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scan time</em>' attribute.
	 * @see #setScan_time(Float32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getLidarSystem_Scan_time()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='scan_time  '"
	 * @generated
	 */
	Object getScan_time();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.LidarSystem#getScan_time <em>Scan time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scan time</em>' attribute.
	 * @see #getScan_time()
	 * @generated
	 */
	void setScan_time(Object value);

	/**
	 * Returns the value of the '<em><b>Range min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Range min</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Range min</em>' attribute.
	 * @see #setRange_min(Float32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getLidarSystem_Range_min()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	Object getRange_min();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.LidarSystem#getRange_min <em>Range min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range min</em>' attribute.
	 * @see #getRange_min()
	 * @generated
	 */
	void setRange_min(Object value);

	/**
	 * Returns the value of the '<em><b>Range max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Range max</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Range max</em>' attribute.
	 * @see #setRange_max(Float32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getLidarSystem_Range_max()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Float32" required="true" ordered="false"
	 * @generated
	 */
	Object getRange_max();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.LidarSystem#getRange_max <em>Range max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range max</em>' attribute.
	 * @see #getRange_max()
	 * @generated
	 */
	void setRange_max(Object value);

	/**
	 * Returns the value of the '<em><b>Nb Rays</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nb Rays</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nb Rays</em>' attribute.
	 * @see #setNbRays(UInt32)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getLidarSystem_NbRays()
	 * @model dataType="org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UInt32" required="true" ordered="false"
	 * @generated
	 */
	Object getNbRays();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.LidarSystem#getNbRays <em>Nb Rays</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nb Rays</em>' attribute.
	 * @see #getNbRays()
	 * @generated
	 */
	void setNbRays(Object value);

} // LidarSystem
