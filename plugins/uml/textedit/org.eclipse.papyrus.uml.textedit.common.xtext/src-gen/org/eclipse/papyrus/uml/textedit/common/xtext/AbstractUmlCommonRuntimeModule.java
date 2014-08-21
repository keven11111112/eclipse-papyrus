/*
 * generated by Xtext
 */
package org.eclipse.papyrus.uml.textedit.common.xtext;

import java.util.Properties;

import org.eclipse.xtext.Constants;
import org.eclipse.xtext.service.DefaultRuntimeModule;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Manual modifications go to {org.eclipse.papyrus.uml.textedit.common.xtext.UmlCommonRuntimeModule}
 */
@SuppressWarnings("all")
public abstract class AbstractUmlCommonRuntimeModule extends DefaultRuntimeModule {

	protected Properties properties = null;

	@Override
	public void configure(Binder binder) {
		properties = tryBindProperties(binder, "org/eclipse/papyrus/uml/textedit/common/xtext/UmlCommon.properties");
		super.configure(binder);
	}

	public void configureLanguageName(Binder binder) {
		binder.bind(String.class).annotatedWith(Names.named(Constants.LANGUAGE_NAME)).toInstance("org.eclipse.papyrus.uml.textedit.common.xtext.UmlCommon");
	}

	public void configureFileExtensions(Binder binder) {
		if (properties == null || properties.getProperty(Constants.FILE_EXTENSIONS) == null) {
			binder.bind(String.class).annotatedWith(Names.named(Constants.FILE_EXTENSIONS)).toInstance("umlcommon");
		}
	}

	// contributed by org.eclipse.xtext.generator.grammarAccess.GrammarAccessFragment
	public java.lang.ClassLoader bindClassLoaderToInstance() {
		return getClass().getClassLoader();
	}

	// contributed by org.eclipse.xtext.generator.grammarAccess.GrammarAccessFragment
	public Class<? extends org.eclipse.xtext.IGrammarAccess> bindIGrammarAccess() {
		return org.eclipse.papyrus.uml.textedit.common.xtext.services.UmlCommonGrammarAccess.class;
	}

	// contributed by org.eclipse.xtext.generator.serializer.SerializerFragment
	@Override
	public Class<? extends org.eclipse.xtext.serializer.sequencer.ISemanticSequencer> bindISemanticSequencer() {
		return org.eclipse.papyrus.uml.textedit.common.xtext.serializer.UmlCommonSemanticSequencer.class;
	}

	// contributed by org.eclipse.xtext.generator.serializer.SerializerFragment
	public Class<? extends org.eclipse.xtext.serializer.sequencer.ISyntacticSequencer> bindISyntacticSequencer() {
		return org.eclipse.papyrus.uml.textedit.common.xtext.serializer.UmlCommonSyntacticSequencer.class;
	}

	// contributed by org.eclipse.xtext.generator.serializer.SerializerFragment
	@Override
	public Class<? extends org.eclipse.xtext.serializer.ISerializer> bindISerializer() {
		return org.eclipse.xtext.serializer.impl.Serializer.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public Class<? extends org.eclipse.xtext.parser.IParser> bindIParser() {
		return org.eclipse.papyrus.uml.textedit.common.xtext.parser.antlr.UmlCommonParser.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	@Override
	public Class<? extends org.eclipse.xtext.parser.ITokenToStringConverter> bindITokenToStringConverter() {
		return org.eclipse.xtext.parser.antlr.AntlrTokenToStringConverter.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public Class<? extends org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider> bindIAntlrTokenFileProvider() {
		return org.eclipse.papyrus.uml.textedit.common.xtext.parser.antlr.UmlCommonAntlrTokenFileProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public Class<? extends org.eclipse.xtext.parser.antlr.Lexer> bindLexer() {
		return org.eclipse.papyrus.uml.textedit.common.xtext.parser.antlr.internal.InternalUmlCommonLexer.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public com.google.inject.Provider<org.eclipse.papyrus.uml.textedit.common.xtext.parser.antlr.internal.InternalUmlCommonLexer> provideInternalUmlCommonLexer() {
		return org.eclipse.xtext.parser.antlr.LexerProvider.create(org.eclipse.papyrus.uml.textedit.common.xtext.parser.antlr.internal.InternalUmlCommonLexer.class);
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public void configureRuntimeLexer(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.parser.antlr.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.parser.antlr.LexerBindings.RUNTIME))
				.to(org.eclipse.papyrus.uml.textedit.common.xtext.parser.antlr.internal.InternalUmlCommonLexer.class);
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	@Override
	public Class<? extends org.eclipse.xtext.parser.antlr.ITokenDefProvider> bindITokenDefProvider() {
		return org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.validation.JavaValidatorFragment
	@org.eclipse.xtext.service.SingletonBinding(eager = true)
	public Class<? extends org.eclipse.papyrus.uml.textedit.common.xtext.validation.UmlCommonJavaValidator> bindUmlCommonJavaValidator() {
		return org.eclipse.papyrus.uml.textedit.common.xtext.validation.UmlCommonJavaValidator.class;
	}

	// contributed by org.eclipse.xtext.generator.exporting.QualifiedNamesFragment
	@Override
	public Class<? extends org.eclipse.xtext.naming.IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	@Override
	public Class<? extends org.eclipse.xtext.resource.IContainer.Manager> bindIContainer$Manager() {
		return org.eclipse.xtext.resource.containers.StateBasedContainerManager.class;
	}

	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	public Class<? extends org.eclipse.xtext.resource.containers.IAllContainersState.Provider> bindIAllContainersState$Provider() {
		return org.eclipse.xtext.resource.containers.ResourceSetBasedAllContainersStateProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	@Override
	public void configureIResourceDescriptions(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class).to(org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions.class);
	}

	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	@Override
	public void configureIResourceDescriptionsBuilderScope(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE))
				.to(org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions.class);
	}

	// contributed by org.eclipse.xtext.generator.generator.GeneratorFragment
	public Class<? extends org.eclipse.xtext.generator.IGenerator> bindIGenerator() {
		return org.eclipse.papyrus.uml.textedit.common.xtext.generator.UmlCommonGenerator.class;
	}

	// contributed by org.eclipse.xtext.generator.formatting.FormatterFragment
	@Override
	public Class<? extends org.eclipse.xtext.formatting.IFormatter> bindIFormatter() {
		return org.eclipse.papyrus.uml.textedit.common.xtext.formatting.UmlCommonFormatter.class;
	}

}
