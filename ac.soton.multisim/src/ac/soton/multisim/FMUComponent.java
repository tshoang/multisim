/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package ac.soton.multisim;

import org.eclipse.emf.common.util.EList;

import de.prob.cosimulation.FMU;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FMU Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.multisim.FMUComponent#getPath <em>Path</em>}</li>
 *   <li>{@link ac.soton.multisim.FMUComponent#getParameters <em>Parameters</em>}</li>
 *   <li>{@link ac.soton.multisim.FMUComponent#getFmu <em>Fmu</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.multisim.MultisimPackage#getFMUComponent()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='validPath'"
 * @generated
 */
public interface FMUComponent extends Component {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2015 University of Southampton.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html";

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see ac.soton.multisim.MultisimPackage#getFMUComponent_Path()
	 * @model required="true"
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link ac.soton.multisim.FMUComponent#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link ac.soton.multisim.FMUParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see ac.soton.multisim.MultisimPackage#getFMUComponent_Parameters()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<FMUParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Fmu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fmu</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fmu</em>' attribute.
	 * @see #setFmu(FMU)
	 * @see ac.soton.multisim.MultisimPackage#getFMUComponent_Fmu()
	 * @model dataType="ac.soton.multisim.FMU" transient="true"
	 * @generated
	 */
	FMU getFmu();

	/**
	 * Sets the value of the '{@link ac.soton.multisim.FMUComponent#getFmu <em>Fmu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fmu</em>' attribute.
	 * @see #getFmu()
	 * @generated
	 */
	void setFmu(FMU value);

} // FMUComponent
