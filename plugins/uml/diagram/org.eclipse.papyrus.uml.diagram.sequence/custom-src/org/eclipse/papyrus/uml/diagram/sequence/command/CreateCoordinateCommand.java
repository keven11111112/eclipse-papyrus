package org.eclipse.papyrus.uml.diagram.sequence.command;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.Compartment;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.StringValueStyle;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.helper.StereotypeDisplayConstant;
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.helper.StereotypeDisplayUtil;
import org.eclipse.papyrus.uml.diagram.sequence.referencialgrilling.GrillingEditpart;
import org.eclipse.papyrus.uml.diagram.sequence.CustomMessages;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.referencialgrilling.GridManagementEditPolicy;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * the goal of this command is to create a basic compartment in the notation that represent a compartment of stereotypes
 *
 */
public class CreateCoordinateCommand extends RecordingCommand {


	private BasicCompartment compartment;

	private String name;

	private int position;
	private EObject semantic;

	/**
	 *
	 * Constructor.
	 *
	 * @param domain
	 * @param node
	 *            The EditPart view of the Compartment
	 */
	public CreateCoordinateCommand(TransactionalEditingDomain domain, BasicCompartment compartment, String name, Element semantic, int position) {
		super(domain, "create Grilling Structure");
		this.compartment = compartment;
		this.name = name;
		this.position = position;
		this.semantic = semantic;

	}

	@SuppressWarnings("unchecked")
	@Override
	public void doExecute() {

		// create One line
		Node coordinate = NotationFactory.eINSTANCE.createDecorationNode();
		Location linelocation = NotationFactory.eINSTANCE.createLocation();

		coordinate.setType(name);
		if (name.startsWith(GridManagementEditPolicy.COLUMN)) {
			linelocation.setX(position);
		}
		if (name.startsWith(GridManagementEditPolicy.ROW)) {
			linelocation.setY(position);
			UMLDiagramEditorPlugin.log.trace(CustomMessages.SEQUENCE_DEBUG_REFERENCEGRID, ">>>Create row at " + position); //$NON-NLS-1$
		}
		coordinate.setLayoutConstraint(linelocation);
		if (semantic != null) {
			coordinate.setElement(semantic);
		}
		ViewUtil.insertChildView(compartment, coordinate, ViewUtil.APPEND, true);
	}



}
