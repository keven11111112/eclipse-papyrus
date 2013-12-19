package org.eclipse.papyrus.qompass.modellibs.tracing;

import org.eclipse.papyrus.qompass.designer.core.deployment.DepPlanUtils;
import org.eclipse.papyrus.qompass.designer.core.extensions.IInstanceConfigurator;
import org.eclipse.papyrus.qompass.designer.core.transformations.ContainerContext;
import org.eclipse.papyrus.qompass.designer.core.transformations.ContainerTrafo;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Property;

public class IConfiguratorTrace implements IInstanceConfigurator {

	static final String PROP_PORT_NAME = "portName"; //$NON-NLS-1$

	static final String PROP_INSTANCE_NAME = "instanceName"; //$NON-NLS-1$

	/**
	 * Configure the passed trace instance
	 * 
	 * @see org.eclipse.papyrus.qompass.designer.gentools.core.extensions.IInstanceConfigurator
	 */
	public void configureInstance(InstanceSpecification instance, Property componentPart, ContainerContext context) {
		// The tracing code needs informations about the component instance and port.

		String instanceName = instance.getName();
		int index = instanceName.lastIndexOf("."); //$NON-NLS-1$
		if(index != -1) {
			String lastSegment = instanceName.substring(index + 1);
			if(lastSegment.startsWith(ContainerTrafo.interceptorName)) {
				instanceName = instanceName.substring(0, index);
			}
		}

		DepPlanUtils.configureProperty(instance, PROP_INSTANCE_NAME, StringConstants.QUOTE + instanceName + StringConstants.QUOTE);

		// port in context => interception of port => provide information about port and interface
		if(context.port != null) {
			DepPlanUtils.configureProperty(instance, PROP_PORT_NAME, StringConstants.QUOTE + context.port.getName() + StringConstants.QUOTE);
		}
	}
}
