/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.profile.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.diagram.common.editpolicies.HyperLinkPopupBarEditPolicy;
import org.eclipse.papyrus.diagram.common.editpolicies.QualifiedNameDisplayEditPolicy;
import org.eclipse.papyrus.diagram.common.figure.node.EnumerationFigure;
import org.eclipse.papyrus.diagram.profile.custom.policies.CustomGraphicalNodeEditPolicy;
import org.eclipse.papyrus.diagram.profile.custom.policies.itemsemantic.CustomEnumerationItemSemanticEditPolicyCN;
import org.eclipse.papyrus.diagram.profile.edit.policies.EnumerationItemSemanticEditPolicyCN;
import org.eclipse.papyrus.diagram.profile.edit.policies.OpenDiagramEditPolicy;
import org.eclipse.papyrus.diagram.profile.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.profile.providers.UMLElementTypes;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class EnumerationEditPartCN extends

ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3025;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public EnumerationEditPartCN(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new EnumerationItemSemanticEditPolicyCN());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenDiagramEditPolicy());
		installEditPolicy(EditPolicyRoles.POPUPBAR_ROLE, new HyperLinkPopupBarEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new CustomGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomEnumerationItemSemanticEditPolicyCN());
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeNodeLabelDisplayEditPolicy());
		installEditPolicy(QualifiedNameDisplayEditPolicy.QUALIFIED_NAME_POLICY, new QualifiedNameDisplayEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}





	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if(result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new EnumerationFigure();
	}

	/**
	 * @generated
	 */
	public EnumerationFigure getPrimaryShape() {
		return (EnumerationFigure)primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof EnumerationNameEditPartCN) {
			((EnumerationNameEditPartCN)childEditPart).setLabel(getPrimaryShape().getNameLabel());
			return true;
		}


		if(childEditPart instanceof EnumerationEnumerationLiteralCompartmentEditPartCN) {
			IFigure pane = getPrimaryShape().getEnumerationLiteralCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((EnumerationEnumerationLiteralCompartmentEditPartCN)childEditPart).getFigure());
			return true;
		}

		return false;
	}


	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof EnumerationNameEditPartCN) {
			return true;
		}
		if(childEditPart instanceof EnumerationEnumerationLiteralCompartmentEditPartCN) {
			IFigure pane = getPrimaryShape().getEnumerationLiteralCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((EnumerationEnumerationLiteralCompartmentEditPartCN)childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if(addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if(removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if(editPart instanceof EnumerationEnumerationLiteralCompartmentEditPartCN) {
			return getPrimaryShape().getEnumerationLiteralCompartmentFigure();
		}
		return getContentPane();
	}


	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(100, 100);
		return result;
	}


	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * 
	 * @param nodeShape
	 *        instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if(nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if(contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if(primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if(primaryShape instanceof Shape) {
			((Shape)primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if(primaryShape instanceof Shape) {
			((Shape)primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(EnumerationNameEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnSource() {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */();
		types.add(UMLElementTypes.Association_4001);
		types.add(UMLElementTypes.Association_4019);
		types.add(UMLElementTypes.Generalization_4002);
		types.add(UMLElementTypes.Dependency_4008);
		types.add(UMLElementTypes.Dependency_4018);
		types.add(UMLElementTypes.ElementImport_1064);
		types.add(UMLElementTypes.PackageImport_1065);
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */();
		if(targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof StereotypeEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof MetaclassEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof StereotypeEditPartCN) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof MetaclassEditPartCN) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.profile.edit.parts.EnumerationEditPartCN) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof StereotypeEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof MetaclassEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof StereotypeEditPartCN) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof MetaclassEditPartCN) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.profile.edit.parts.EnumerationEditPartCN) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof StereotypeEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof MetaclassEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof StereotypeEditPartCN) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof MetaclassEditPartCN) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.profile.edit.parts.EnumerationEditPartCN) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof DependencyNodeEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof StereotypeEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof MetaclassEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof ModelEditPartTN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof ProfileEditPartTN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof StereotypeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof MetaclassEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof ProfileEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.profile.edit.parts.EnumerationEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof DependencyNodeEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof StereotypeEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof MetaclassEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof ModelEditPartTN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof ProfileEditPartTN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof StereotypeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof MetaclassEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof ProfileEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.profile.edit.parts.EnumerationEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof DependencyNodeEditPart) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof StereotypeEditPart) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof MetaclassEditPart) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof ModelEditPartTN) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof ProfileEditPartTN) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof StereotypeEditPartCN) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof MetaclassEditPartCN) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof ProfileEditPartCN) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.diagram.profile.edit.parts.EnumerationEditPartCN) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.ElementImport_1064);
		}
		if(targetEditPart instanceof ModelEditPartTN) {
			types.add(UMLElementTypes.PackageImport_1065);
		}
		if(targetEditPart instanceof ProfileEditPartTN) {
			types.add(UMLElementTypes.PackageImport_1065);
		}
		if(targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.PackageImport_1065);
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.PackageImport_1065);
		}
		if(targetEditPart instanceof ProfileEditPartCN) {
			types.add(UMLElementTypes.PackageImport_1065);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.PackageImport_1065);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMATypesForTarget(IElementType relationshipType) {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */();
		if(relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Association_2015);
		}
		if(relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Stereotype_1026);
		}
		if(relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Class_1031);
		}
		if(relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if(relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if(relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Stereotype_1023);
		}
		if(relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Class_3028);
		}
		if(relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if(relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if(relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Association_2015);
		}
		if(relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Stereotype_1026);
		}
		if(relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Class_1031);
		}
		if(relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if(relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if(relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Stereotype_1023);
		}
		if(relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Class_3028);
		}
		if(relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if(relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if(relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Association_2015);
		}
		if(relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Stereotype_1026);
		}
		if(relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Class_1031);
		}
		if(relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if(relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if(relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Stereotype_1023);
		}
		if(relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Class_3028);
		}
		if(relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if(relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Dependency_2014);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Association_2015);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Stereotype_1026);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Class_1031);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Constraint_1014);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Model_2005);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Profile_1030);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Package_2007);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Stereotype_1023);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Class_3028);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Model_1027);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Profile_1024);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Package_1012);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Constraint_1028);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Dependency_2014);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Association_2015);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Stereotype_1026);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Class_1031);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Constraint_1014);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Model_2005);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Profile_1030);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Package_2007);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Stereotype_1023);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Class_3028);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Model_1027);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Profile_1024);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Package_1012);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Constraint_1028);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Dependency_2014);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Association_2015);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Stereotype_1026);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Class_1031);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Constraint_1014);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Model_2005);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Profile_1030);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Package_2007);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Stereotype_1023);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Class_3028);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Model_1027);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Profile_1024);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Package_1012);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Constraint_1028);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if(relationshipType == UMLElementTypes.PackageImport_1065) {
			types.add(UMLElementTypes.Model_2005);
		}
		if(relationshipType == UMLElementTypes.PackageImport_1065) {
			types.add(UMLElementTypes.Profile_1030);
		}
		if(relationshipType == UMLElementTypes.PackageImport_1065) {
			types.add(UMLElementTypes.Package_2007);
		}
		if(relationshipType == UMLElementTypes.PackageImport_1065) {
			types.add(UMLElementTypes.Model_1027);
		}
		if(relationshipType == UMLElementTypes.PackageImport_1065) {
			types.add(UMLElementTypes.Profile_1024);
		}
		if(relationshipType == UMLElementTypes.PackageImport_1065) {
			types.add(UMLElementTypes.Package_1012);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnTarget() {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */();
		types.add(UMLElementTypes.Association_4001);
		types.add(UMLElementTypes.Association_4019);
		types.add(UMLElementTypes.Generalization_4002);
		types.add(UMLElementTypes.Dependency_4008);
		types.add(UMLElementTypes.Dependency_4018);
		types.add(UMLElementTypes.ElementImport_1064);
		types.add(UMLElementTypes.CommentAnnotatedElement_1022);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4014);
		return types;
	}

	/**
	 * @generated
	 */
	public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMATypesForSource(IElementType relationshipType) {
		List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */();
		if(relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Association_2015);
		}
		if(relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Stereotype_1026);
		}
		if(relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Class_1031);
		}
		if(relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if(relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if(relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Stereotype_1023);
		}
		if(relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Class_3028);
		}
		if(relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if(relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if(relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Association_2015);
		}
		if(relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Stereotype_1026);
		}
		if(relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Class_1031);
		}
		if(relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if(relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if(relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Stereotype_1023);
		}
		if(relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Class_3028);
		}
		if(relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if(relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if(relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Association_2015);
		}
		if(relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Stereotype_1026);
		}
		if(relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Class_1031);
		}
		if(relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if(relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if(relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Stereotype_1023);
		}
		if(relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Class_3028);
		}
		if(relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if(relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Dependency_2014);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Association_2015);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Stereotype_1026);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Class_1031);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Constraint_1014);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Model_2005);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Profile_1030);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Package_2007);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Stereotype_1023);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Class_3028);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Model_1027);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Profile_1024);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Package_1012);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Constraint_1028);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Dependency_2014);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Association_2015);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Stereotype_1026);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Class_1031);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Constraint_1014);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Model_2005);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Profile_1030);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Package_2007);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Stereotype_1023);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Class_3028);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Model_1027);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Profile_1024);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Package_1012);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Constraint_1028);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Association_2015);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Stereotype_1026);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Class_1031);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Model_2005);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Profile_1030);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Package_2007);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Enumeration_2006);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.DataType_2010);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Stereotype_1023);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Class_3028);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Model_1027);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Profile_1024);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Package_1012);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.Enumeration_3025);
		}
		if(relationshipType == UMLElementTypes.ElementImport_1064) {
			types.add(UMLElementTypes.DataType_3027);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_1022) {
			types.add(UMLElementTypes.Comment_1002);
		}
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_1022) {
			types.add(UMLElementTypes.Comment_1007);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4014) {
			types.add(UMLElementTypes.Constraint_1014);
		}
		if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4014) {
			types.add(UMLElementTypes.Constraint_1028);
		}
		return types;
	}


	/**
	 * @generated
	 */
	public EditPart getTargetEditPart(Request request) {
		if(request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest)request).getViewAndElementDescriptor().getCreateElementRequestAdapter();
			IElementType type = (IElementType)adapter.getAdapter(IElementType.class);
			if(type == UMLElementTypes.EnumerationLiteral_1037) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(EnumerationEnumerationLiteralCompartmentEditPartCN.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}





	/**
	 * @generated
	 */
	@Override
	public Object getPreferredValue(EStructuralFeature feature) {
		IPreferenceStore preferenceStore = (IPreferenceStore)getDiagramPreferencesHint().getPreferenceStore();
		Object result = null;

		if(feature == NotationPackage.eINSTANCE.getLineStyle_LineColor() || feature == NotationPackage.eINSTANCE.getFontStyle_FontColor() || feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
			String prefColor = null;
			if(feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("EnumerationCN", PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("EnumerationCN", PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("EnumerationCN", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("EnumerationCN", PreferenceConstantHelper.COLOR_GRADIENT);
			GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(preferenceStore.getString(prefGradient));
			if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency()) {
				result = new Integer(gradientPreferenceConverter.getTransparency());
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
				result = gradientPreferenceConverter.getGradientData();
			}
		}

		if(result == null) {
			result = getStructuralFeatureValue(feature);
		}
		return result;
	}
}
