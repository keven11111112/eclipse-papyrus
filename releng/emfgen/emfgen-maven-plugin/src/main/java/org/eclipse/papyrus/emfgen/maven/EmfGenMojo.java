package org.eclipse.papyrus.emfgen.maven;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Execute;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.papyrus.emfgen.core.EmfGenerator;
import org.eclipse.papyrus.emfgen.core.EmfGeneratorAppOptions;
import org.sonatype.plexus.build.incremental.BuildContext;
/**
 *  @author CEA Tech - Francois Le Fevre
 * 2014
 **/
@Mojo( name = "emfgen", defaultPhase = LifecyclePhase.GENERATE_SOURCES )
public class EmfGenMojo extends AbstractMojo
{
	@Component
	private BuildContext buildContext;

	public void setBuildContext( BuildContext context )
	{
		this.buildContext = context;
	}

	public void execute() throws MojoExecutionException
	{
		getLog().info("Welcome to EmfGen");
		getLog().info("dealing with "+genModel+" and "+ ecoreModel +" output: "+ outputDirectory);
		if ( !buildContext.hasDelta( genModel ) && !buildContext.hasDelta( ecoreModel ) )
		{
			getLog().debug( "Skipping unchanged data: " + genModel + " @ " +  ecoreModel);
		}
		else{
			getLog().info("Welcome to EmfGen");
			getLog().info("dealing with "+genModel+" and "+ ecoreModel +" output: "+ outputDirectory);

			File genModelFile = new File(genModel);
			buildContext.removeMessages( genModelFile );

			EmfGeneratorAppOptions emfGeneratorAppOptions = new EmfGeneratorAppOptions(genModel,ecoreModel, outputDirectory,isRelocate, isGenModel, isGenEdit,isGenEditor,isGenTests);
			EmfGenerator myEmfGenerator = new EmfGenerator();
			try {
				myEmfGenerator.execute(emfGeneratorAppOptions.getEmfModel(), emfGeneratorAppOptions.getEmfGeneratorOptions());

				GenModel genModel = myEmfGenerator.getGenModel(emfGeneratorAppOptions.getEmfModel(), emfGeneratorAppOptions.getEmfGeneratorOptions() );
				Generator generator = myEmfGenerator.getGenerator(genModel);
				
				myEmfGenerator.generateProjectTypeModel(generator,genModel, emfGeneratorAppOptions.getEmfGeneratorOptions());
				File outDir = new File(outputDirectory+"/"+genModel.getModelDirectory()) ;
				buildContext.refresh( outDir );
				
				myEmfGenerator.generateProjectTypeEdit(generator,genModel, emfGeneratorAppOptions.getEmfGeneratorOptions());
				outDir = new File(outputDirectory+"/"+genModel.getEditDirectory()) ;
				buildContext.refresh( outDir );
				
				myEmfGenerator.generateProjectTypeEditor(generator,genModel, emfGeneratorAppOptions.getEmfGeneratorOptions());
				outDir = new File(outputDirectory+"/"+genModel.getEditorDirectory()) ;
				buildContext.refresh( outDir );
				
				myEmfGenerator.generateProjectTypeTest(generator,genModel, emfGeneratorAppOptions.getEmfGeneratorOptions());
				//outDir = new File(outputDirectory+"/"+genModel.getTestsDirectory()) ;
				//buildContext.refresh( outDir );
				

			}	catch ( IOException e )
			{
				MojoExecutionException mojoExecutionException =
						new MojoExecutionException( "Couldn't read file: " + e.getMessage(), e );
				buildContext.addMessage( genModelFile, 1 /* line */, 1 /* column */, mojoExecutionException.getMessage(),
						BuildContext.SEVERITY_ERROR, mojoExecutionException );
				throw mojoExecutionException;
			}
		}
	}

	/**
	 * Output directory
	 * */
	@Parameter
	private String outputDirectory = null;

	/**
	 * Ecore path
	 */
	@Parameter
	private String ecoreModel = null;

	/**
	 * genModel path
	 */
	@Parameter
	private String genModel = null;

	/**
	 * isRelocate
	 */
	@Parameter
	private Boolean isRelocate = null;

	/**
	 * isGenModel
	 */
	@Parameter
	private Boolean isGenModel = null;

	/**
	 * isGenEdit
	 */
	@Parameter
	private Boolean isGenEdit = null;

	/**
	 * isGenEditor
	 */
	@Parameter
	private Boolean isGenEditor = null;

	/**
	 * isGenTests
	 */
	@Parameter
	private Boolean isGenTests = null;

	public String getOutputDirectory() {
		return outputDirectory;
	}

	public String getEcoreModel() {
		return ecoreModel;
	}

	public String getGenModel() {
		return genModel;
	}

	public void setOutputDirectory(String outputDirectory) {
		this.outputDirectory = outputDirectory;
	}

	public void setEcoreModel(String ecoreModel) {
		this.ecoreModel = ecoreModel;
	}

	public void setGenModel(String genModel) {
		this.genModel = genModel;
	}

	public Boolean getIsGenModel() {
		return isGenModel;
	}

	public void setIsGenModel(Boolean isGenModel) {
		this.isGenModel = isGenModel;
	}

	public Boolean getIsGenEdit() {
		return isGenEdit;
	}

	public void setIsGenEdit(Boolean isGenEdit) {
		this.isGenEdit = isGenEdit;
	}

	public Boolean getIsGenEditor() {
		return isGenEditor;
	}

	public void setIsGenEditor(Boolean isGenEditor) {
		this.isGenEditor = isGenEditor;
	}

	public Boolean getIsGenTests() {
		return isGenTests;
	}

	public void setIsGenTests(Boolean isGenTests) {
		this.isGenTests = isGenTests;
	}

	public Boolean getIsRelocate() {
		return isRelocate;
	}

	public void setIsRelocate(Boolean isRelocate) {
		this.isRelocate = isRelocate;
	}



}
