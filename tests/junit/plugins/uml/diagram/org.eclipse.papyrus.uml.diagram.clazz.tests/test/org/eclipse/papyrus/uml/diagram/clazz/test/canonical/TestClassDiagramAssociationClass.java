package org.eclipse.papyrus.uml.diagram.clazz.test.canonical;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.clazz.CreateClassDiagramCommand;
import org.eclipse.papyrus.uml.diagram.clazz.custom.edit.part.CustomUMLDiagramUpdater;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.clazz.test.IClassDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.tests.canonical.TestLink;
import org.junit.Test;

public class TestClassDiagramAssociationClass extends TestLink {

	@Override
	public DiagramUpdater getDiagramUpdater() {
		return CustomUMLDiagramUpdater.INSTANCE;
	}

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateClassDiagramCommand();
	}

	@Override
	protected String getProjectName() {
		return IClassDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IClassDiagramTestsConstants.FILE_NAME;
	}

	@Test
	public void testManageAssociationClass() {
		testToManageLink(UMLElementTypes.Class_2008, UMLElementTypes.Class_2008, UMLElementTypes.AssociationClass_4017, UMLElementTypes.Package_2007, true);
	}

	@Override
	public void installEnvironment(IElementType sourceType, IElementType targetType) {
		createdEdgesCount = 2;
		createdChildsCount = 1;
		super.installEnvironment(sourceType, targetType);
	}

	@Override
	public void testToCreateALink(IElementType linkType, String initialName) {
		testCreateLink(linkType, initialName);
	}

	@Override
	public void testToManageLink(IElementType sourceType, IElementType targetType, IElementType linkType, IElementType containerType, boolean allowedOntheSame, String initialName) {
		installEnvironment(sourceType, targetType);
		testToCreateALink(linkType, initialName);
		testDestroy(linkType);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		testViewDeletion(linkType);
		testDrop(linkType);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		testToCreateAlinkOnTheSame(linkType, allowedOntheSame);
	}
}