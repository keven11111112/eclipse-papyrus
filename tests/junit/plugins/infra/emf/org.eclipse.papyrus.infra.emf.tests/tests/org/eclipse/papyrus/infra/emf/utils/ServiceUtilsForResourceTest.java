/**
 * 
 */
package org.eclipse.papyrus.infra.emf.utils;

import static org.junit.Assert.*;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServiceMultiException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dumoulin
 *
 */
public class ServiceUtilsForResourceTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
	
		assertNotNull("Instance ready", ServiceUtilsForResource.getInstance());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource#getServiceRegistry(org.eclipse.emf.ecore.resource.Resource)}.
	 * @throws ServiceException 
	 */
	@Test
	public void testGetServiceRegistryResource() throws ServiceException {


		// Create services
		ServicesRegistry servicesRegistry = new ServicesRegistry();
		
		ModelSet modelSet = new ModelSet();
		URI uri = URI.createURI("temp.ecore");
		
		  // Register the default resource factory -- only needed for stand-alone!
		modelSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
		    Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		Resource resource = modelSet.createResource(uri);
		assertNotNull("resource created", resource);
		
		EClass obj1 = EcoreFactory.eINSTANCE.createEClass();
		EPackage pack2 = EcoreFactory.eINSTANCE.createEPackage();
		EClass obj2 = EcoreFactory.eINSTANCE.createEClass();
		pack2.getEClassifiers().add(obj2);		
		resource.getContents().add(obj1);
		resource.getContents().add(pack2);
		
		servicesRegistry.add(ModelSet.class, 1, modelSet);
		
		ServiceUtilsForResourceInitializerService initService = new ServiceUtilsForResourceInitializerService();
		servicesRegistry.add(ServiceUtilsForResourceInitializerService.class, 1, initService);
		
		servicesRegistry.startRegistry();
		
		// Check registry
		assertNotNull("service ModelSEt", servicesRegistry.getService(ModelSet.class) );
		assertNotNull("service initializer", servicesRegistry.getService(ServiceUtilsForResourceInitializerService.class) );
		assertNotNull("ModelSet service correctly initialized", ServiceUtils.getInstance().getModelSet(servicesRegistry) );
		
		// Do tests
		ServicesRegistry r2 = ServiceUtilsForResource.getInstance().getServiceRegistry(obj1.eResource());
		assertNotNull("found from obj1", r2);
		
		r2 = ServiceUtilsForResource.getInstance().getServiceRegistry(obj2.eResource());
		assertNotNull("found from obj2", r2);

		r2 = ServiceUtilsForResource.getInstance().getServiceRegistry(pack2.eResource());
		assertNotNull("found from pack2", r2);
	}

}
