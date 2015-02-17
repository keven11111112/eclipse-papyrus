package org.eclipse.papyrus.emfgen.maven.test;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.eclipse.papyrus.emfgen.maven.EmfGenMojo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.sonatype.plexus.build.incremental.BuildContext;

/**
 * @author CEA Tech - Francois Le Fevre
 * 2014
 */
@PrepareForTest( EmfGenMojo.class )
@RunWith( PowerMockRunner.class )
public final class EmfGenMojoTest extends AbstractMojoTestCase
{
	private EmfGenMojo mojo;


	@Mock
	private BuildContext buildContext;

	@Before
	public void setUp() throws IllegalAccessException
	{
		mojo = new EmfGenMojo();
		System.out.println("configuration");
		setVariableValueToObject( mojo, "buildContext", buildContext );
	}

	//	@Parameters({"ecoreModel", "genModel", "outputDirectory", "isRelocate", "isGenModel", "isGenEdit", "isGenEditor", "isGenTests"})
	//	public EmfGenMojoTest(String ecoreModel, String genModel, String outputDirectory,Boolean isRelocate,  Boolean isGenModel, Boolean isGenEdit, Boolean isGenEditor, Boolean isGenTests )
	//	{
	//		mojo = new EmfGenMojo();
	//		mojo.setEcoreModel(ecoreModel);
	//		mojo.setGenModel(genModel);
	//		mojo.setOutputDirectory(outputDirectory);
	//		mojo.setIsRelocate(isRelocate);;
	//		mojo.setIsGenModel(isGenModel);
	//		mojo.setIsGenEdit(isGenEdit);
	//		mojo.setIsGenEditor(isGenEditor);
	//		mojo.setIsGenTests(isGenTests);
	//	}

	@Test
	public final void execute() throws MojoExecutionException,
	MojoFailureException
	{
		ClassLoader cl = ClassLoader.getSystemClassLoader();

		
		
		mojo.setEcoreModel(cl.getSystemResource("models/constraints/Constraints.ecore").toString().replace("file:", ""));
		mojo.setGenModel(cl.getSystemResource("models/constraints/Constraints.genmodel").toString().replace("file:", ""));
		mojo.setOutputDirectory("/export/home/flefevre/git/org.eclipse.papyrus/releng/emfgen/emfgen-maven-plugin/target/");
		mojo.setIsRelocate(true);;
		mojo.setIsGenModel(true);
		mojo.setIsGenEdit(true);
		mojo.setIsGenEditor(true);
		mojo.setIsGenTests(true);
		System.out.println("configuration done for: "+cl.getSystemResource("models/constraints/Constraints.ecore").toString().replace("file:", ""));
		buildContext.refresh(new File(cl.getSystemResource("models/constraints/Constraints.ecore").toString().replace("file:", "")));
		buildContext.refresh(new File(cl.getSystemResource("models/constraints/Constraints.genmodel").toString().replace("file:", "")));
		
		mojo.execute();
	}

	@After
	public void tearDown()
	{
	}
}
