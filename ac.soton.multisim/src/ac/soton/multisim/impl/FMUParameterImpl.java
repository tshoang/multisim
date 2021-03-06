/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package ac.soton.multisim.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eventb.emf.core.CorePackage;

import ac.soton.multisim.FMUParameter;
import ac.soton.multisim.MultisimPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FMU Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.multisim.impl.FMUParameterImpl#getStartValue <em>Start Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FMUParameterImpl extends AbstractVariableImpl implements FMUParameter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2015 University of Southampton.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html";

	/**
	 * The default value of the '{@link #getStartValue() <em>Start Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object START_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStartValue() <em>Start Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartValue()
	 * @generated
	 * @ordered
	 */
	protected Object startValue = START_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FMUParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MultisimPackage.Literals.FMU_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getStartValue() {
		return startValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartValue(Object newStartValue) {
		Object oldStartValue = startValue;
		startValue = newStartValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MultisimPackage.FMU_PARAMETER__START_VALUE, oldStartValue, startValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MultisimPackage.FMU_PARAMETER__START_VALUE:
				return getStartValue();
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
			case MultisimPackage.FMU_PARAMETER__START_VALUE:
				setStartValue(newValue);
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
			case MultisimPackage.FMU_PARAMETER__START_VALUE:
				setStartValue(START_VALUE_EDEFAULT);
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
			case MultisimPackage.FMU_PARAMETER__START_VALUE:
				return START_VALUE_EDEFAULT == null ? startValue != null : !START_VALUE_EDEFAULT.equals(startValue);
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
		result.append(" (startValue: ");
		result.append(startValue);
		result.append(')');
		return result.toString();
	}
	
	/**
	 * Override of {@link org.eventb.emf.core.impl.EventBNamedCommentedElementImpl.setName(String)}
	 * Removes the replacement of : and . characters in the name attribute.
	 * @custom
	 */
	public void setName(String newName) {
		if (newName == null) return;
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT__NAME, oldName, name));
	}

} //FMUParameterImpl
