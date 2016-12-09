/**
 *   Copyright (c) 2016 CEA LIST and others.
 *   
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *     CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.Point;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.RhpGeometryPackage;
import org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.TransformMatrix;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transform Matrix</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.TransformMatrixImpl#getA <em>A</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.TransformMatrixImpl#getB <em>B</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.TransformMatrixImpl#getC <em>C</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.TransformMatrixImpl#getD <em>D</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.TransformMatrixImpl#getE <em>E</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.geometry.rhapsodygeometry.impl.TransformMatrixImpl#getF <em>F</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransformMatrixImpl extends MinimalEObjectImpl.Container implements TransformMatrix {
	/**
	 * The default value of the '{@link #getA() <em>A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getA()
	 * @generated
	 * @ordered
	 */
	protected static final Double A_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getA() <em>A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getA()
	 * @generated
	 * @ordered
	 */
	protected Double a = A_EDEFAULT;

	/**
	 * The default value of the '{@link #getB() <em>B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getB()
	 * @generated
	 * @ordered
	 */
	protected static final Double B_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getB() <em>B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getB()
	 * @generated
	 * @ordered
	 */
	protected Double b = B_EDEFAULT;

	/**
	 * The default value of the '{@link #getC() <em>C</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getC()
	 * @generated
	 * @ordered
	 */
	protected static final Double C_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getC() <em>C</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getC()
	 * @generated
	 * @ordered
	 */
	protected Double c = C_EDEFAULT;

	/**
	 * The default value of the '{@link #getD() <em>D</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getD()
	 * @generated
	 * @ordered
	 */
	protected static final Double D_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getD() <em>D</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getD()
	 * @generated
	 * @ordered
	 */
	protected Double d = D_EDEFAULT;

	/**
	 * The default value of the '{@link #getE() <em>E</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getE()
	 * @generated
	 * @ordered
	 */
	protected static final Double E_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getE() <em>E</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getE()
	 * @generated
	 * @ordered
	 */
	protected Double e = E_EDEFAULT;

	/**
	 * The default value of the '{@link #getF() <em>F</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getF()
	 * @generated
	 * @ordered
	 */
	protected static final Double F_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getF() <em>F</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getF()
	 * @generated
	 * @ordered
	 */
	protected Double f = F_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformMatrixImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RhpGeometryPackage.Literals.TRANSFORM_MATRIX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double getA() {
		return a;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setA(Double newA) {
		a = newA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double getB() {
		return b;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setB(Double newB) {
		b = newB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double getC() {
		return c;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setC(Double newC) {
		c = newC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double getD() {
		return d;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setD(Double newD) {
		d = newD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double getE() {
		return e;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setE(Double newE) {
		e = newE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double getF() {
		return f;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setF(Double newF) {
		f = newF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformMatrix add(TransformMatrix matrix) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformMatrix minus() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformMatrix minus(TransformMatrix matrix) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Point multiply(Point point) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformMatrix multiply(TransformMatrix matrix) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RhpGeometryPackage.TRANSFORM_MATRIX__A:
				return getA();
			case RhpGeometryPackage.TRANSFORM_MATRIX__B:
				return getB();
			case RhpGeometryPackage.TRANSFORM_MATRIX__C:
				return getC();
			case RhpGeometryPackage.TRANSFORM_MATRIX__D:
				return getD();
			case RhpGeometryPackage.TRANSFORM_MATRIX__E:
				return getE();
			case RhpGeometryPackage.TRANSFORM_MATRIX__F:
				return getF();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RhpGeometryPackage.TRANSFORM_MATRIX__A:
				setA((Double)newValue);
				return;
			case RhpGeometryPackage.TRANSFORM_MATRIX__B:
				setB((Double)newValue);
				return;
			case RhpGeometryPackage.TRANSFORM_MATRIX__C:
				setC((Double)newValue);
				return;
			case RhpGeometryPackage.TRANSFORM_MATRIX__D:
				setD((Double)newValue);
				return;
			case RhpGeometryPackage.TRANSFORM_MATRIX__E:
				setE((Double)newValue);
				return;
			case RhpGeometryPackage.TRANSFORM_MATRIX__F:
				setF((Double)newValue);
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
			case RhpGeometryPackage.TRANSFORM_MATRIX__A:
				setA(A_EDEFAULT);
				return;
			case RhpGeometryPackage.TRANSFORM_MATRIX__B:
				setB(B_EDEFAULT);
				return;
			case RhpGeometryPackage.TRANSFORM_MATRIX__C:
				setC(C_EDEFAULT);
				return;
			case RhpGeometryPackage.TRANSFORM_MATRIX__D:
				setD(D_EDEFAULT);
				return;
			case RhpGeometryPackage.TRANSFORM_MATRIX__E:
				setE(E_EDEFAULT);
				return;
			case RhpGeometryPackage.TRANSFORM_MATRIX__F:
				setF(F_EDEFAULT);
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
			case RhpGeometryPackage.TRANSFORM_MATRIX__A:
				return A_EDEFAULT == null ? a != null : !A_EDEFAULT.equals(a);
			case RhpGeometryPackage.TRANSFORM_MATRIX__B:
				return B_EDEFAULT == null ? b != null : !B_EDEFAULT.equals(b);
			case RhpGeometryPackage.TRANSFORM_MATRIX__C:
				return C_EDEFAULT == null ? c != null : !C_EDEFAULT.equals(c);
			case RhpGeometryPackage.TRANSFORM_MATRIX__D:
				return D_EDEFAULT == null ? d != null : !D_EDEFAULT.equals(d);
			case RhpGeometryPackage.TRANSFORM_MATRIX__E:
				return E_EDEFAULT == null ? e != null : !E_EDEFAULT.equals(e);
			case RhpGeometryPackage.TRANSFORM_MATRIX__F:
				return F_EDEFAULT == null ? f != null : !F_EDEFAULT.equals(f);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case RhpGeometryPackage.TRANSFORM_MATRIX___ADD__TRANSFORMMATRIX:
				return add((TransformMatrix)arguments.get(0));
			case RhpGeometryPackage.TRANSFORM_MATRIX___MINUS:
				return minus();
			case RhpGeometryPackage.TRANSFORM_MATRIX___MINUS__TRANSFORMMATRIX:
				return minus((TransformMatrix)arguments.get(0));
			case RhpGeometryPackage.TRANSFORM_MATRIX___MULTIPLY__POINT:
				return multiply((Point)arguments.get(0));
			case RhpGeometryPackage.TRANSFORM_MATRIX___MULTIPLY__TRANSFORMMATRIX:
				return multiply((TransformMatrix)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (a: "); //$NON-NLS-1$
		result.append(a);
		result.append(", b: "); //$NON-NLS-1$
		result.append(b);
		result.append(", c: "); //$NON-NLS-1$
		result.append(c);
		result.append(", d: "); //$NON-NLS-1$
		result.append(d);
		result.append(", e: "); //$NON-NLS-1$
		result.append(e);
		result.append(", f: "); //$NON-NLS-1$
		result.append(f);
		result.append(')');
		return result.toString();
	}

} //TransformMatrixImpl
