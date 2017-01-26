package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreEList.UnmodifiableEList;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.Lane;
import org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.util.UMLUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by GD249233 on 24/01/2017.
 */
public class LaneSetCustom {

	private LaneSetCustom() {
	}

	public static EList<Lane> getLanes(LaneSet laneSet){
		List<Lane> lanes = new ArrayList<>();
		ActivityPartition activityPartition = laneSet.getBase_ActivityPartition();
		if(activityPartition != null) {
			List<ActivityPartition> subPartitions = activityPartition.getSubpartitions();
			if (subPartitions != null && !subPartitions.isEmpty()) {
				lanes = subPartitions.stream().map(p -> UMLUtil.getStereotypeApplication(p, Lane.class)).filter(Objects::nonNull).collect(Collectors.toList());
			}
		}
		return new BasicEList<>(lanes);
//		return new UnmodifiableEList<>((laneSetImpl)laneSet, BPMNProfilePackage.eINSTANCE.getFlowElementsContainer_FlowElements(), lanes.size(), lanes.toArray());
	}
	
	public static EList<Lane> getParentLane(LaneSet laneSet){
		ActivityPartition activityPartition = laneSet.getBase_ActivityPartition();
		Lane lane = UMLUtil.getStereotypeApplication(activityPartition, Lane.class);
		List<Lane> lanes = new ArrayList<>();
		lanes.add(lane);
		return new BasicEList<>(lanes);
	}
}
