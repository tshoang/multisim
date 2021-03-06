/**
 * Copyright (c) 2014 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.multisim.ui.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.ptolemy.fmi.FMIModelDescription;
import org.ptolemy.fmi.FMIScalarVariable;
import org.ptolemy.fmi.FMIScalarVariable.Variability;
import org.ptolemy.fmi.FMUFile;

import ac.soton.multisim.FMUComponent;
import ac.soton.multisim.FMUParameter;
import ac.soton.multisim.MultisimFactory;
import ac.soton.multisim.diagram.edit.parts.FMUComponentEditPart;
import ac.soton.multisim.ui.dialogs.FMUParametersDialog;
import ac.soton.multisim.util.SimulationUtil;

/**
 * UI action to modify the FMU component parameters.
 * 
 * @author vitaly
 *
 */
public class SetParametersAction implements IObjectActionDelegate {

	private FMUComponentEditPart selectedElement;

	@Override
	public void run(IAction action) {
		final FMUComponent component = (FMUComponent) selectedElement.getNotationView().getElement();
		
		Map<String, Object> componentParams = new HashMap<String, Object>(component.getParameters().size());
		for (FMUParameter p : component.getParameters())
			componentParams.put(p.getName(), p.getStartValue());
		
		// read model description
		FMIModelDescription modelDescription = null;
		if (component.getFmu() != null) {
			modelDescription = component.getFmu().getModelDescription();
		} else {
			if (component.getPath() == null) {
				MessageDialog.openError(Display.getDefault().getActiveShell(), "Parameters Failure", "FMU path is not set.");
				return;
			}
			try {
				modelDescription = FMUFile.parseFMUFile(component.getPath());
			} catch (IOException e) {
				MessageDialog.openError(Display.getDefault().getActiveShell(), "Parameters Failure", "Could not read the FMU file '" + component.getPath() + "'.");
				return;
			}
		}
		
		// list all the parameters
		final List<FMUParameter> allParams = new ArrayList<FMUParameter>(modelDescription.modelVariables.size());
		Set<FMUParameter> modifiedParams = new HashSet<FMUParameter>(componentParams.size());
		for (FMIScalarVariable variable : modelDescription.modelVariables) {
			if (variable.variability == Variability.parameter) {	//XXX according to specification a parameter must also be an input, i.e. variable.causality == Causality.input
				FMUParameter param = MultisimFactory.eINSTANCE.createFMUParameter();
				param.setName(variable.name);
				param.setCausality(SimulationUtil.fmiGetCausality(variable));
				param.setType(SimulationUtil.fmiGetType(variable));
				param.setValue(SimulationUtil.fmiGetDefaultValue(variable));
				param.setComment(variable.description);
				allParams.add(param);
				if (componentParams.containsKey(variable.name)) {
					param.setStartValue(componentParams.get(variable.name));
					modifiedParams.add(param);
				} else {
					param.setStartValue(param.getValue());
				}
			}
		}
		
		// display configuration window
		final FMUParametersDialog dialog = new FMUParametersDialog(Display.getCurrent().getActiveShell(), allParams);
		dialog.setModified(modifiedParams);
		dialog.create();
		if (Window.OK == dialog.open()) {
			try {
				new AbstractEMFOperation(selectedElement.getEditingDomain(), "Set parameters command") {
					@Override
					protected IStatus doExecute(IProgressMonitor monitor,
							IAdaptable info) throws ExecutionException {
						component.getParameters().clear();
						component.getParameters().addAll(dialog.getModified());
						return null;
					}
				}.execute(null, null);
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		selectedElement = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.getFirstElement() instanceof FMUComponentEditPart)
				selectedElement = (FMUComponentEditPart) structuredSelection.getFirstElement();
		}
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// nothing to do here
	}

}
