package org.eclipse.papyrus.manufacturing.ofbiz.handlers;

import java.util.Map;

import javax.xml.namespace.QName;

import org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort.CreateWorkEffort;
import org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort.CreateWorkEffortPortType;
import org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort.MapEntry;
import org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort.MapKey;
import org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort.MapValue;
import org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort.StdString;
import org.eclipse.ui.commands.AbstractHandler;
import org.eclipse.ui.commands.ExecutionException;

public class DeployProcessAxis extends AbstractHandler {
    private static final QName SERVICE_NAME = new QName("http://ofbiz.apache.org/service/", "createWorkEffort");

	@Override
	public Object execute(Map parameterValuesByName) throws ExecutionException {
        org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort.MapMap _createWorkEffort_mapMapVal = new org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort.MapMap();
        java.util.List<org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort.MapEntry> _createWorkEffort_mapMapValMapEntry = new java.util.ArrayList<org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort.MapEntry>();
        
		_createWorkEffort_mapMapValMapEntry.add(createMapEntry("login.username", "admin"));
        _createWorkEffort_mapMapValMapEntry.add(createMapEntry("login.password", "ofbiz"));
        _createWorkEffort_mapMapValMapEntry.add(createMapEntry("currentStatusId", "ROU_ACTIVE"));
        _createWorkEffort_mapMapValMapEntry.add(createMapEntry("workEffortName", "Build lego cars from java"));
        _createWorkEffort_mapMapValMapEntry.add(createMapEntry("workEffortTypeId", "ROUTING"));
		
		_createWorkEffort_mapMapVal.getMapEntry().addAll(_createWorkEffort_mapMapValMapEntry);
        javax.xml.ws.Holder<org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort.MapMap> _createWorkEffort_mapMap = new javax.xml.ws.Holder<org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort.MapMap>(_createWorkEffort_mapMapVal);

        CreateWorkEffort ss = new CreateWorkEffort(CreateWorkEffort.WSDL_LOCATION, SERVICE_NAME);
        CreateWorkEffortPortType port = ss.getCreateWorkEffortPort();  
		port.createWorkEffort(_createWorkEffort_mapMap);
        System.out.println("createWorkEffort._createWorkEffort_mapMap=" + _createWorkEffort_mapMap.value);
		
		return parameterValuesByName;
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
}
