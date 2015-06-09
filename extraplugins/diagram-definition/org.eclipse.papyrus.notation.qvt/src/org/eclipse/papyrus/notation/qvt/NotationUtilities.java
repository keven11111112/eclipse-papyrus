/**
 * Copyright (c) 2014 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.notation.qvt;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.OffscreenEditPartFactory;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.PapyrusWrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ConstraintFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure;
import org.eclipse.swt.widgets.Shell;

public class NotationUtilities {

	private Map<Diagram, DiagramEditPart> cache = new HashMap<Diagram, DiagramEditPart>();

	private Map<String, Map<String, String>> diagramMappings;

	private void buildDiagramMappings() {
		diagramMappings = new HashMap<String, Map<String, String>>();
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = registry.getExtensionPoint("org.eclipse.papyrus.infra.gmfdiag.common.notationTypesMapping");
		for (IExtension extension : extensionPoint.getExtensions()) {
			for (IConfigurationElement element : extension.getConfigurationElements()) {
				if (element.getName().equals("diagramMappings")) {
					String diagramId = element.getAttribute("diagramID");
					Map<String, String> childMappings = new HashMap<String, String>();
					diagramMappings.put(diagramId, childMappings);
					for (IConfigurationElement child : element.getChildren()) {
						String viewId = child.getAttribute("type");
						String viewType = child.getAttribute("humanReadableType");
						childMappings.put(viewId, viewType);
					}
				}
			}
		}
		augmentClazzDiagramMapping(diagramMappings.get("PapyrusUMLClassDiagram"));
		augmentProfileDiagramMapping(diagramMappings.get("PapyrusUMLProfileDiagram"));
		augmentComponentDiagramMapping(diagramMappings.get("PapyrusUMLComponentDiagram"));
		augmentCompositeStructureDiagramMapping(diagramMappings.get("CompositeStructure"));
		augmentDeploymentDiagramMapping(diagramMappings.get("PapyrusUMLDeploymentDiagram"));
		augmentUseCaseDiagramMapping(diagramMappings.get("UseCase"));
		augmentStateMachineDiagramMapping(diagramMappings.get("PapyrusUMLStateMachineDiagram"));
		augmentActivityDiagramMapping(diagramMappings.get("PapyrusUMLActivityDiagram"));
		augmentSequenceDiagramMapping(diagramMappings.get("PapyrusUMLSequenceDiagram"));
		augmentCommunicationDiagramMapping(diagramMappings.get("PapyrusUMLCommunicationDiagram"));
		augmentTimingDiagramMapping(diagramMappings.get("PapyrusUMLTimingDiagram"));
	}

	private void augmentClazzDiagramMapping(Map<String, String> map) {
		addMapping(map, "Name", "5038,5063,1,5066,5002,5005,5008,5011,5020,5023,5026,5161,5029,5032,5035,5037,0,5155,5153,5157,5040,5043,5046,5049,5052,5055,5017,5162,5014,5058,5061,5064");
		// addMapping(map, "Expression", "5159,5160");
		addMapping(map, "Constraint", "5067");
		addMapping(map, "Conveyed", "6040");
		addMapping(map, "Containment", "4023");
		addMapping(map, "Attachment", "4016,4014,4013,8500,4024,4025");
	}

	private void augmentProfileDiagramMapping(Map<String, String> map) {
		addMapping(map, "Name", "3,1008,1,1034,5029,1084,1015,5020,1047,5026,5023,5032,5035,2,5058,1046,5014,5062,1056,1050,1010,1059,5055,5061");
		// addMapping(map, "Expression", "5063,5064");
		addMapping(map, "attributes", "7017,7011");
		addMapping(map, "operations", "7018,7012");
		addMapping(map, "Attachment", "4014,8500,1022");
	}

	private void augmentComponentDiagramMapping(Map<String, String> map) {
		addMapping(map, "Name", "5255,5258,5008,5004,5262,5254,5266,5252,5265,5005,5006,5264,5261,5256,5257,0,5259");
		// addMapping(map, "Expression", "5253,5260");
		addMapping(map, "Attachment", "4016,4015,4009,4018");
		addMapping(map, "Custom", "2003,3072");
	}

	private void augmentCompositeStructureDiagramMapping(Map<String, String> map) {
		addMapping(
				map,
				"Name",
				"5192,5150,5112,5113,5114,5115,5116,5117,5121,5122,5123,5124,5156,5158,5159,5118,5119,5120,5160,5161,5162,5163,5164,5165,5166,5167,5168,5169,5170,5171,5172,5173,5174,5175,5151,5152,5142,5143,5178,5179,5180,5181,5182,5183,5184,5185,5186,5187,5188,5189,5190,5191,5193,6035,5194,6036,5195,6037,5196,6038,5197,5125,6029,6033,6034,5126,5198,5127,5128,5129,5130,5131,5132,5133,5137,5138,5139,5140,5155,5141,5154,5134,5135,5136,5144,5145,5146,5147,5148,5149,6040,6041,6042,6043,6044,6045,6046,6047,6048");
		// addMapping(map, "Expression", "6039,6049");
		addMapping(map, "TargetRole", "6027");
		addMapping(map, "Attachment", "4022,4001,4002,4003,4018,4019");
		addMapping(map, "Tag", "6030");
		addMapping(map, "Representation", "4020");
		addMapping(map, "RoleBinding", "3115");
	}

	private void augmentDeploymentDiagramMapping(Map<String, String> map) {
		addMapping(map, "Name", "1,55,7,48,35,2,5,6,8,9,53,50,37,20,45,22,47,24,43,27,29,41,57");
		// addMapping(map, "Expression", "3,58");
		addMapping(map, "Attachment", "4005,4008,4009");
	}

	private void augmentUseCaseDiagramMapping(Map<String, String> map) {
		addMapping(map, "Name", "5027,5028,5014,5015,5016,5017,5019,5025,5026,6039,5032,5018,5030,5029,5031,5020,5021,5022,5023,5024,6006,6007");
		addMapping(map, "QualifiedName", "6037,6041,6040");
		addMapping(map, "Stereotype", "6029,6027,6028");
		// addMapping(map, "Expression", "6042,6043,6044");
		addMapping(map, "Attachment", "4012,4014");
		addMapping(map, "Custom", "2011,3011,3018,2013,3009,3012");
	}

	private void augmentStateMachineDiagramMapping(Map<String, String> map) {
		addMapping(map, "Name", "6666,2001,5001,6001,8001,9001,10001,11001,12001,13001,14001,15001,16001,17001,18001,6668,7002");
		addMapping(map, "Stereotype", "7003,5002,8002,9002,10002,11002,12002,13002,14002,15002,16002,17002,18002");
		// addMapping(map, "Expression", "6669");
		addMapping(map, "Attachment", "667,670,8500");
		addMapping(map, "Custom", "2000");
	}

	private void augmentActivityDiagramMapping(Map<String, String> map) {
		addMapping(
				map,
				"Name",
				"5138,5001,6034,6033,6035,5003,5011,5012,5009,5010,5004,5013,5014,5015,5016,5006,5017,5018,5019,5020,5021,5022,5023,5038,5039,5040,5041,5036,5037,5007,5008,6036,6037,6038,6039,5127,5059,5049,5051,5053,5054,5056,5058,5060,5061,5063,5065,5072,5074,5076,5071,5078,5079,5077,5126,5124,5119,5120,5121,5178,5388,5391,5184,5186,5187,5123,5117,5377,5379,5382,5385,5118,5139,5144,5142,5148,5146,5129,5153,5149,5151,5152,5160,5154,5156,5357,5359,5362,5365,5368,5371,5374,5158,5163,5161,5332,5335,5166,5164,5171,5167,5169,5350,5341,5344,5347,5175,5172,5351,5354,5176,5189,5191,5203,5217,5245,5263,5219,5248,5266,5192,5205,5221,5223,5251,5254,5269,5272,5193,5207,5225,5260,5275,5195,5227,5281,5278,5194,5209,5229,5287,5284,5196,5231,5290,5293,5197,5235,5296,5299,5198,5211,5199,5237,5302,5305,5200,5213,5239,5308,5311,5201,5215,5241,5314,5317,5202,5243,5320,5323");
		addMapping(
				map,
				"Stereotype",
				"5080,5081,5082,5083,5084,5085,5086,5087,5088,5089,5090,5091,5092,5093,5094,5095,5096,5097,5098,5099,5100,5101,5102,5103,5104,5105,5106,5107,5108,5109,5110,5111,5112,5113,5114,5115,5125,5145,5147,5150,5155,5157,5159,5162,5168,5165,5170,5174,5179,5185,5183,5188,5204,5206,5208,5210,5212,5214,5216,5218,5220,5222,5224,5226,5228,5230,5232,5236,5238,5240,5242,5244,5247,5250,5253,5256,5262,5265,5268,5271,5274,5277,5280,5283,5286,5289,5292,5295,5298,5301,5304,5307,5310,5313,5316,5319,5322,5325,5334,5337,5340,5343,5346,5349,5353,5356,5358,5361,5364,5367,5370,5373,5376,5378,5381,5384,5386,5390,5393");
		// addMapping(map, "Expression", "5130,5131,5132,5133,5134,5135,5136,5137,5190");
		addMapping(map, "Attachment", "4001,4002,4006,4007");
		addMapping(map, "Custom", "2001,3083");
		addMapping(map, "Selection", "5177,5128,6005");
		addMapping(map, "Transformation", "6006");
		addMapping(map, "Type", "6012");
		addMapping(map, "Icon", "6015");
	}

	private void augmentSequenceDiagramMapping(Map<String, String> map) {
		addMapping(map, "Name", "5009,5011,5006,5001,5003,5007,5002,5008,5010,5005,5018,5016,6001,6002,6003,6004,6005,6006,6007,Gate_Name,BehaviorExecutionSpecification_Behavior");
		addMapping(map, "Type", "5004");
		addMapping(map, "Stereotype", "5013,5014,5015,5019,5017,6008,6009,6010,6011,6012,6013,6014,6015,8501");
		// addMapping(map, "Expression", "5023,5012");
		addMapping(map, "Attachment", "4010,4011,8500");
		addMapping(map, "Custom", "2001");
		addMapping(map, "Guard", "InteractionOperand_Guard");
	}

	private void augmentCommunicationDiagramMapping(Map<String, String> map) {
		addMapping(map, "Name", "5150,5001,0,5002,5064,5153,5155");
		addMapping(map, "Stereotype", "5154,5156");
		// addMapping(map, "Expression", "5160");
		addMapping(map, "Attachment", "8010,8011,8012,8013");
		addMapping(map, "Path", "8009");
		addMapping(map, "Custom", "8002");
	}

	private void augmentTimingDiagramMapping(Map<String, String> map) {
		addMapping(map, "Name", "33,37,21,22,30,31,10,14,38,34,35,60,68,36,32,70");
		addMapping(map, "Stereotype", "62,64,58,59,65,66,63");
		// addMapping(map, "Expression", "30,33");
		addMapping(map, "Custom", "2");
		addMapping(map, "Compact", "28");
		addMapping(map, "Constraint", "9");
	}

	private void addMapping(Map<String, String> map, String type, String ids) {
		for (String id : ids.split("\\s*,\\s*"))
			map.put(id, type);
	}

	public String getViewType(View view) {
		if (view == null)
			return null;
		if (diagramMappings == null)
			buildDiagramMappings();
		Diagram diagram = view.getDiagram();
		Map<String, String> childMappings = diagramMappings.get(diagram.getType());
		String type = (childMappings != null) ? childMappings.get(view.getType()) : null;
		if (type == null)
			type = view.getType();
		return type;
	}

	public void renderDiagram(final Diagram diagram) {
		if (!cache.containsKey(diagram)) {
			DiagramEditPart editpart = OffscreenEditPartFactory.getInstance().createDiagramEditPart(diagram, new Shell());
			cache.put(diagram, editpart);
			Thread.yield();
		}
	}

	public void disposeDiagram(final Diagram diagram) {
		if (cache.containsKey(diagram)) {
			DiagramEditPart editpart = cache.remove(diagram);
			editpart.getViewer().getControl().getParent().dispose();
		}
	}

	public Bounds getCombinedFragmentLabelBounds(Node node) {
		if (cache.containsKey(node.getDiagram())) {
			DiagramEditPart editpart = cache.get(node.getDiagram());
			GraphicalEditPart nodeEditPart = (GraphicalEditPart) editpart.getViewer().getEditPartRegistry().get(node);
			IFigure figure = (IFigure) invoke(nodeEditPart, "getPrimaryShape");
			if (figure != null) {
				figure = (IFigure) invoke(figure, "getHeaderLabel");
				if (figure != null) {
					Rectangle r = figure.getBounds().getCopy();
					figure.translateToAbsolute(r);

					Bounds b = NotationFactory.eINSTANCE.createBounds();
					b.setX(r.x);
					b.setY(r.y);
					b.setWidth(r.width);
					b.setHeight(r.height);
					return b;
				}
			}
		}
		return null;
	}

	public Bounds getBounds(Node node) {
		if (cache.containsKey(node.getDiagram())) {
			DiagramEditPart editpart = cache.get(node.getDiagram());
			GraphicalEditPart nodeEditPart = (GraphicalEditPart) editpart.getViewer().getEditPartRegistry().get(node);
			IFigure figure = nodeEditPart.getFigure();
			Rectangle r = figure.getBounds().getCopy();
			figure.translateToAbsolute(r);

			if (figure instanceof WrappingLabel) {
				WrappingLabel label = (WrappingLabel) figure;
				r = label.getTextBounds();
				figure.translateToAbsolute(r);
			}

			// special cases
			if (figure.getParent() instanceof NodeNamedElementFigure) {
				NodeNamedElementFigure parent = (NodeNamedElementFigure) figure.getParent();
				WrappingLabel tagLabel = parent.getTaggedLabel();
				if (tagLabel != null) {
					Rectangle tagRect = tagLabel.getTextBounds();
					tagLabel.translateToAbsolute(tagRect);
					r = tagRect.union(r);
				}
				PapyrusWrappingLabel stereotypeLabel = parent.getStereotypesLabel();
				if (stereotypeLabel != null) {
					Rectangle stereoetypeRect = stereotypeLabel.getTextBounds();
					stereotypeLabel.translateToAbsolute(stereoetypeRect);
					r = stereoetypeRect.union(r);
				}
			}
			else if (figure.getParent() instanceof ConstraintFigure) {
				ConstraintFigure parent = (ConstraintFigure) figure.getParent();
				WrappingLabel tagLabel = parent.getTaggedLabel();
				if (tagLabel != null) {
					Rectangle tagRect = tagLabel.getTextBounds();
					tagLabel.translateToAbsolute(tagRect);
					r = tagRect.union(r);
				}
			} else if (figure instanceof ConstraintFigure) {
				ConstraintFigure cf = (ConstraintFigure) figure;
				r = cf.getTextFlow().getBounds();
				cf.getTextFlow().translateToAbsolute(r);
			}

			Bounds b = NotationFactory.eINSTANCE.createBounds();
			b.setX(r.x);
			b.setY(r.y);
			b.setWidth(r.width);
			b.setHeight(r.height);
			return b;
		}
		return null;
	}

	public LinkedHashSet<Location> getPoints(Edge edge) {
		if (cache.containsKey(edge.getDiagram())) {
			DiagramEditPart editpart = cache.get(edge.getDiagram());
			ConnectionEditPart edgeEditPart = (ConnectionEditPart) editpart.getViewer().getEditPartRegistry().get(edge);
			PointList pl = ((Connection) edgeEditPart.getFigure()).getPoints();

			LinkedHashSet<Location> points = new LinkedHashSet<Location>();
			for (int i = 0; i < pl.size(); i++) {
				Point p = pl.getPoint(i);
				Location point = NotationFactory.eINSTANCE.createLocation();
				point.setX(p.x);
				point.setY(p.y);
				points.add(point);
			}

			return points;
		}
		return null;
	}

	private Object invoke(Object o, String methodName) {
		Method method;
		try {
			method = o.getClass().getMethod(methodName, new Class<?>[] {});
		} catch (Exception e1) {
			return null;
		}

		try {
			method.setAccessible(true);
			return method.invoke(o, new Object[] {});
		} catch (Exception e) {
			return null;
		}
	}

}