package org.eclipse.papyrus.qompass.designer.core.transformations;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.FCM.PortKind;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepUtils;
import org.eclipse.papyrus.qompass.designer.core.extensions.IOOTrafo;
import org.eclipse.papyrus.qompass.designer.core.extensions.OOTrafo;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.EncapsulatedClassifier;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.StructuredClassifier;

public class ExecuteOOTrafo {
	
	IOOTrafo ooTrafo;
	
	ExecuteOOTrafo(IOOTrafo ooTrafo) {
		this.ooTrafo = ooTrafo;
	}
	
	/**
	 * Why is pkg a parameter ?? [wait: the transformation should rather have a
	 * component as this parameter]
	 * Need to take traversal of components out of transformation [btw. shouldn't
	 * the transformation be instance based]
	 *
	 * @param pkg
	 * @throws TransformationException
	 */
	public void transformPackage(Package pkg) throws TransformationException {
		EList<PackageableElement> peList = new BasicEList<PackageableElement>();
		peList.addAll(pkg.getPackagedElements());
		for (PackageableElement element : peList) {
			if (element instanceof Package) {
				transformPackage((Package) element);
			}
			else if (element instanceof Class) {
				Class implementation = (Class) element;
				// we may not apply the transformation to the boot-loader
				// itself, in particular it would transform
				// singletons into pointers.
				if (Utils.isCompImpl(implementation)
						// && (implementation != bootloader)
						&& !StereotypeUtil.isApplied(implementation, PortKind.class)) {
					ooTrafo.addPortOperations(implementation);
					ooTrafo.addConnectionOperation(implementation);
					ooTrafo.transformParts(implementation);
				}
			}
			// now delete connectors
			if (element instanceof StructuredClassifier) {
				removeConnectors((StructuredClassifier) element);
			}
			if (element instanceof EncapsulatedClassifier) {
				removePorts((EncapsulatedClassifier) element);
			}
		}
	}
	
	/**
	 * Helper: remove connectors from a structured classifier (in most cases a class)
	 * 
	 * @param implementation A component
	 */
	public void removeConnectors(StructuredClassifier implementation) {
		EList<Connector> connectors = new BasicEList<Connector>();
		connectors.addAll(implementation.getOwnedConnectors());
		for (Connector connector : connectors) {
			connector.destroy();
		}
	}

	/**
	 * Helper: remove ports from a from an encapsulated classifier (in most cases a class)
	 * 
	 * @param implementation A component
	 */
	public void removePorts(EncapsulatedClassifier implementation) {
		EList<Port> portListCopy = new BasicEList<Port>();
		portListCopy.addAll(implementation.getOwnedPorts());
		// avoid dangling references by calling destroy on the port list
		for (Port port : portListCopy) {
			port.destroy();
		}	
	}
	
	public static void transform(LazyCopier copier, Class bootloader, Model genModel, boolean OOmodel) throws TransformationException {
		String ooTransformation = DepUtils.getOOTransformationFromPackage(genModel);
		if (ooTransformation == null) {
			// default OO transformation
			ooTransformation = "StaticCpp"; //$NON-NLS-1$
		}
		IOOTrafo ooTrafo = OOTrafo.getOOTrafo(ooTransformation);
		ooTrafo.init(copier, bootloader);
		ExecuteOOTrafo executeOOTrafo = new ExecuteOOTrafo(ooTrafo);
		executeOOTrafo.transformPackage(genModel);
		
		// complete access operations?
	}

	// TODO: always false. Is it really task of OO trafo to decide whether something is
	// instantiated by bootloader or not?
	public static boolean instantiateViaBootloader(StructuralFeature slot) {
		return false;
	}
	
	// TODO: currently used by BOOTLOADER generator. Why needed?
	public static final String CREATE_CONNECTIONS = "createConnections"; //$NON-NLS-1$
}
