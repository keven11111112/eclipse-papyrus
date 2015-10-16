package org.eclipse.papyrus.manufacturing.ofbiz.handlers;

import java.net.MalformedURLException;
import java.util.function.Predicate;
import java.util.stream.Stream;

import javax.xml.namespace.QName;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML.ProcessSegment;
import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML.ProcessSegmentInformation;
import org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort.CreateWorkEffort;
import org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort.CreateWorkEffortPortType;
import org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort.MapEntry;
import org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort.MapKey;
import org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort.MapMap;
import org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort.MapValue;
import org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort.StdString;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.NamedElement;

public class DeployProcessHandler extends AbstractHandler {
	private static final QName SERVICE_NAME = new QName("http://ofbiz.apache.org/service/", "createWorkEffort");

	private void callWs(String workEffortName, String workEffortType) {
		javax.xml.ws.Holder<MapMap> _createWorkEffort_mapMap = createWorkEffortMap(workEffortName, workEffortType);

		CreateWorkEffort ss = new CreateWorkEffort(CreateWorkEffort.WSDL_LOCATION, SERVICE_NAME);
		CreateWorkEffortPortType port = ss.getCreateWorkEffortPort();
		port.createWorkEffort(_createWorkEffort_mapMap);
		System.out.println("createWorkEffort._createWorkEffort_mapMap=" + _createWorkEffort_mapMap.value);
	}

	private javax.xml.ws.Holder<org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort.MapMap> createWorkEffortMap(String workEffortName, String workEffortType) {
		org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort.MapMap _createWorkEffort_mapMapVal = new org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort.MapMap();
		java.util.List<org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort.MapEntry> mapEntry = new java.util.ArrayList<org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort.MapEntry>();
		
		mapEntry.add(createMapEntry("login.username", "admin"));
		mapEntry.add(createMapEntry("login.password", "ofbiz"));
		mapEntry.add(createMapEntry("currentStatusId", "ROU_ACTIVE"));
		mapEntry.add(createMapEntry("workEffortName", workEffortName));
		mapEntry.add(createMapEntry("workEffortTypeId", workEffortType));

		_createWorkEffort_mapMapVal.getMapEntry().addAll(mapEntry);
		javax.xml.ws.Holder<MapMap> _createWorkEffort_mapMap = new javax.xml.ws.Holder<MapMap>(
				_createWorkEffort_mapMapVal);
		return _createWorkEffort_mapMap;
	}

	private MapEntry createMapEntry(String key, String value) {
		MapEntry mapEntry = new MapEntry();

		MapKey mapKey = new MapKey();
		StdString mapKeyValue = new StdString();
		mapKeyValue.setValue(key);
		mapKey.setStdString(mapKeyValue);

		MapValue mapValue = new MapValue();
		StdString mapValueValue = new StdString();
		mapValueValue.setValue(value);
		mapValue.setStdString(mapValueValue);

		mapEntry.setMapKey(mapKey);
		mapEntry.setMapValue(mapValue);
		return mapEntry;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public static void main(String[] args) throws MalformedURLException {
		new DeployProcessHandler().callWs("Build lego cars from Papyrus", "ROU_TASK");
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);

		if (selection instanceof IStructuredSelection) {
			if (selection == null || selection.isEmpty() || ((IStructuredSelection) selection).size() > 1) {
				NotificationBuilder.createInfoPopup("Please select only one process to deploy").run();
				return null;
			}
			EObject eObjectProcess = EMFHelper.getEObject(((IStructuredSelection) selection).getFirstElement());
			if (!(eObjectProcess instanceof NamedElement)) {
				NotificationBuilder.createInfoPopup("The selected object is not a UML object").run();
				return null;
			}
			NamedElement namedElement = (NamedElement) eObjectProcess;
			Stream<EObject> stereotypeApplications = namedElement.getStereotypeApplications().stream()
					.filter(new Predicate<EObject>() {

						@Override
						public boolean test(EObject eObject) {
							boolean isProcessSegmentInformation = eObject instanceof ProcessSegmentInformation;
							return isProcessSegmentInformation;
						}

					});
			Object[] array = stereotypeApplications.toArray();
			if(array.length != 1){
				NotificationBuilder.createInfoPopup("The selected object is not a B2MML::ProcessSegmentInformation").run();
				return null;
			}
			deployProcessSegments((ProcessSegmentInformation) array[0]);
		}
		return null;
	}

	private void deployProcessSegments(ProcessSegmentInformation processSegmentInformation) {
		ProcessSegment rootProcessSegment = processSegmentInformation.getProcesssegment();
		NamedElement baseElement = rootProcessSegment.getBase_Behavior();
		if(baseElement == null){
			baseElement = rootProcessSegment.getBase_Action();
		}
		String name = baseElement.getName();
		callWs(name, "ROUTING");
		
		EList<ProcessSegment> childProcessSegments = rootProcessSegment.getProcesssegment();
		for (ProcessSegment processSegment : childProcessSegments) {
			baseElement = processSegment.getBase_Behavior();
			if(baseElement == null){
				baseElement = processSegment.getBase_Action();
			}
			String childProcessSegmentName = baseElement.getName();
			callWs(name + ": " + childProcessSegmentName, "ROU_TASK");
		}
	}
}
