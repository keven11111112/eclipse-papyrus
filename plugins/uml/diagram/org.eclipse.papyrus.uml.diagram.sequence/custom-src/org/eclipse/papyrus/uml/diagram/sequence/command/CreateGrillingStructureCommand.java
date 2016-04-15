package org.eclipse.papyrus.uml.diagram.sequence.command;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
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
import org.eclipse.papyrus.uml.diagram.sequence.referencialgrilling.GrillingManagementEditPolicy;
import org.eclipse.uml2.uml.Stereotype;

/**
 * the goal of this command is to create a basic compartment in the notation that represent a compartment of stereotypes
 *
 */
public class CreateGrillingStructureCommand extends RecordingCommand {


	/**
	 * 
	 */
	private static final int Y_SPACE = 30;

	private static final int X_SPACE = 30;

	protected View node;

	protected Node parent;

	/**
	 *
	 * Constructor.
	 *
	 * @param domain
	 * @param node
	 *            The EditPart view of the Compartment
	 */
	public CreateGrillingStructureCommand(TransactionalEditingDomain domain, View node) {
		super(domain, "create Grilling Structure");
		this.node = node;

	}

	@SuppressWarnings("unchecked")
	@Override
	public void doExecute() {

		// Create the Graphical Compartment
		BasicCompartment compartment = NotationFactory.eINSTANCE.createBasicCompartment();
		// Complete the creation
		compartment.setType(GrillingEditpart.VISUAL_ID);
		ViewUtil.insertChildView(node, compartment, ViewUtil.APPEND, true);
		//create One line
		Node line= NotationFactory.eINSTANCE.createDecorationNode();
		Location linelocation=NotationFactory.eINSTANCE.createLocation();
		linelocation.setY(Y_SPACE);
		line.setType(GrillingManagementEditPolicy.COLUMN+"0");
		line.setLayoutConstraint(linelocation);
		ViewUtil.insertChildView(compartment, line, ViewUtil.APPEND, true);



	}



}
