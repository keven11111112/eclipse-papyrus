/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Christian W. Damus (CEA LIST) - Fix leaking of all UML models in search results
 *  Christian W. Damus (CEA LIST) - Replace workspace IResource dependency with URI for CDO compatibility
 *  Christian W. Damus (CEA) - bug 434681
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.search.ui.pages;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.PatternSyntaxException;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.ICheckable;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.ocl.examples.xtext.console.xtfo.EmbeddedXtextEditor;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.internal.context.EObjectContext;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.ParserContext;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.Value;
import org.eclipse.ocl.xtext.base.ui.model.BaseDocument;
import org.eclipse.ocl.xtext.essentialocl.ui.internal.EssentialOCLActivator;
import org.eclipse.ocl.xtext.essentialocl.utilities.EssentialOCLCSResource;
import org.eclipse.ocl.xtext.essentialocl.utilities.EssentialOCLPlugin;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.papyrus.uml.search.ui.Activator;
import org.eclipse.papyrus.uml.search.ui.CheckBoxFilteredTree;
import org.eclipse.papyrus.uml.search.ui.Messages;
import org.eclipse.papyrus.uml.search.ui.actions.ReplaceAction;
import org.eclipse.papyrus.uml.search.ui.listeners.ParticipantTypesTreeViewerCheckStateListener;
import org.eclipse.papyrus.uml.search.ui.providers.OCLContextContentProvider;
import org.eclipse.papyrus.uml.search.ui.providers.ParticipantTypeAttribute;
import org.eclipse.papyrus.uml.search.ui.providers.ParticipantTypeContentProvider;
import org.eclipse.papyrus.uml.search.ui.providers.ParticipantTypeElement;
import org.eclipse.papyrus.uml.search.ui.providers.ParticipantTypeLabelProvider;
import org.eclipse.papyrus.uml.search.ui.query.AbstractPapyrusQuery;
import org.eclipse.papyrus.uml.search.ui.query.CompositePapyrusQuery;
import org.eclipse.papyrus.uml.search.ui.query.CompositePapyrusQueryProvider;
import org.eclipse.papyrus.uml.search.ui.query.PapyrusOCLQuery;
import org.eclipse.papyrus.uml.search.ui.query.QueryInfo;
import org.eclipse.papyrus.uml.search.ui.query.WorkspaceQueryProvider;
import org.eclipse.papyrus.uml.stereotypecollector.StereotypeCollector;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.views.search.regex.PatternHelper;
import org.eclipse.papyrus.views.search.scope.ScopeCollector;
import org.eclipse.papyrus.views.search.scope.ScopeEntry;
import org.eclipse.search.ui.IReplacePage;
import org.eclipse.search.ui.ISearchPage;
import org.eclipse.search.ui.ISearchPageContainer;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResultPage;
import org.eclipse.search.ui.ISearchResultViewPart;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.outline.impl.EStructuralFeatureNode;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Injector;

/**
 *
 * Papyrus specific search page
 *
 */
public class PapyrusSearchPage extends DialogPage implements ISearchPage, IReplacePage {

	private HashMap<ParticipantTypeElement, List<ParticipantTypeAttribute>> participantsList = new HashMap<ParticipantTypeElement, List<ParticipantTypeAttribute>>();

	private HashMap<ParticipantTypeElement, List<ParticipantTypeAttribute>> stereotypeParticipantsList = new HashMap<ParticipantTypeElement, List<ParticipantTypeAttribute>>();

	private Collection<Stereotype> availableStereotypes;

	private static final String REGULAR_EXPRESSION_ILLFORMED = Messages.PapyrusSearchPage_0;

	private static final String OCL_QUERY_ILLFORMED = Messages.PapyrusSearchPage_0;

	private static final String SEARCH_ISSUE = Messages.PapyrusSearchPage_1;

	private Text searchQueryText;

	private Text oclContext;

	private ISearchPageContainer container;

	private CheckBoxFilteredTree participantTypesTree;

	private CheckBoxFilteredTree participantStereotypesTree;
	
	private CheckboxTreeViewer participantTypesTreeViewer;
	
	private CheckboxTreeViewer participantStereotypesTreeViewer;

	private Label searchQueryExplanatoryLabel;

	private Button btnRegularExpression;

	private Button btnCaseSensitive;


	private Button btnSearchAllStringAttributes;

	private Button btnSearchInName;

	private Combo queryKind;

	private Combo searchKind;

	private EmbeddedXtextEditor oclEditor;

	private Composite queryComposite;

	private EObject contextObject;

	private static final int TEXT_QUERY_KIND = 0;
	
	private static final int OCL_QUERY_KIND = 1;

	private static final int SIMPLE_SEARCH = 0;

	private static final int ADVANCED_SEARCH = 1;
	
	private int currentSearchKind = SIMPLE_SEARCH;
	
	private int currentQueryKind = TEXT_QUERY_KIND;

	private ParserContext parserContext;

//	private ModelManager modelManager = null;

	protected Composite textQueryComposite;

	private Composite advancedSearchComposite;

	private Composite textQueryFieldsComposite;

	private Button fBtnSearchForAllSelected;
	
	private Button fBtnSearchForAnySelected;

	private Label elementsLabel;
	
	private Label stereotypesLabel;
	
	private Label emptyLabel;
	
	private Label emptyLabel2;
	
	private Label emptyLabel3;
	
	private Label emptyLabel4;


	protected void createSimpleSearchQueryField() {

		textQueryComposite = new Composite(queryComposite, SWT.NONE);
		textQueryComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		textQueryComposite.setLayout(new GridLayout(2, false));

		textQueryFieldsComposite = new Composite(textQueryComposite, SWT.NONE);
		textQueryFieldsComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		textQueryFieldsComposite.setLayout(new GridLayout(1, false));

		searchQueryExplanatoryLabel = new Label(textQueryFieldsComposite, SWT.NONE);
		searchQueryExplanatoryLabel.setText(Messages.PapyrusSearchPage_48);
		searchQueryExplanatoryLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		
		searchQueryText = new Text(textQueryFieldsComposite, SWT.BORDER);
		searchQueryText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		searchQueryText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent evt) {
				validateRegex();
			}
		});
		searchQueryText.setFocus();

		Composite compositeParameters = new Composite(textQueryComposite, SWT.NONE);
		compositeParameters.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		compositeParameters.setLayout(new GridLayout(1, false));

		btnCaseSensitive = new Button(compositeParameters, SWT.CHECK);
		btnCaseSensitive.setText(Messages.PapyrusSearchPage_5);

		btnRegularExpression = new Button(compositeParameters, SWT.CHECK);
		btnRegularExpression.setText(Messages.PapyrusSearchPage_6);
		btnRegularExpression.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				btnCaseSensitive.setEnabled(!btnRegularExpression.getSelection());
				validateRegex();
				searchQueryText.forceFocus();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});



		Group grpSearchFor = new Group(textQueryComposite, SWT.NONE);
		grpSearchFor.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		grpSearchFor.setLayout(new GridLayout(1, false));
		grpSearchFor.setText(Messages.PapyrusSearchPage_8);

		Composite groupComposite = new Composite(grpSearchFor, SWT.NONE);
		groupComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		groupComposite.setLayout(new GridLayout(2, false));

		Label lblSearchKind = new Label(groupComposite, SWT.NONE);
		lblSearchKind.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		lblSearchKind.setText(Messages.PapyrusSearchPage_7);

		searchKind = new Combo(groupComposite, SWT.VERTICAL | SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
		searchKind.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1));
		searchKind.add(Messages.PapyrusSearchPage_11);
		searchKind.add(Messages.PapyrusSearchPage_12);
		searchKind.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (searchKind.getSelectionIndex() != currentSearchKind) {
					for (Control childControl : advancedSearchComposite.getChildren()) {
						childControl.dispose();
					}
				
					if (searchKind.getSelectionIndex() == ADVANCED_SEARCH) {
						participantsList.clear();
						stereotypeParticipantsList.clear();
						createResultList();
						createAdvancedSearch();
					} else if (searchKind.getSelectionIndex() == SIMPLE_SEARCH) {
						simpleSearch();
					}/* else {
						Other search kinds in the future
					}*/
					
					advancedSearchComposite.layout();
				}
			}
		});

		advancedSearchComposite = new Composite(groupComposite, SWT.NONE);
		// gd_advancedSearchComposite.widthHint = 479;
		advancedSearchComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		advancedSearchComposite.setLayout(new GridLayout(3, false));

		if (currentSearchKind == ADVANCED_SEARCH) {
			searchKind.select(ADVANCED_SEARCH);
			participantsList.clear();
			stereotypeParticipantsList.clear();
			createResultList();
			createAdvancedSearch();
		} else if (currentSearchKind == SIMPLE_SEARCH) {
			searchKind.select(SIMPLE_SEARCH);
			simpleSearch();
		}/* else {
			Other search kinds in the future
		}*/
	}

	protected void createResultList() {
		ProgressMonitorDialog dialog = new ProgressMonitorDialog(getShell());
		IRunnableWithProgress computeAvailableTypes = new IRunnableWithProgress() {

			public void run(IProgressMonitor thePM) throws InterruptedException {

				// UML metaclasses
				for (EClassifier eClassifier : UMLPackage.eINSTANCE.getEClassifiers()) {
					if (eClassifier instanceof EClass) {
						ParticipantTypeElement parentElement = new ParticipantTypeElement(eClassifier);
						if (parentElement.getElement() instanceof EClass) {
							List<ParticipantTypeAttribute> attributeList = new ArrayList<ParticipantTypeAttribute>();
							for (EObject eAttribute : ((EClass) (parentElement).getElement()).getEAllAttributes()) {
								ParticipantTypeAttribute attribute = new ParticipantTypeAttribute(eAttribute, (parentElement));
								attributeList.add(attribute);


							}
							participantsList.put(parentElement, attributeList);
						}
					}
				}
				
				// Find available stereotypes
				availableStereotypes = StereotypeCollector.getInstance().computeAppliedStereotypes(container);
				for (Stereotype stereotype : availableStereotypes) {
					ParticipantTypeElement parentElement = new ParticipantTypeElement(stereotype);
					List<ParticipantTypeAttribute> attributeList = new ArrayList<ParticipantTypeAttribute>();
					for (Property property : ((Stereotype) parentElement.getElement()).getAllAttributes()) {
						if (!property.getName().startsWith("base_")) { //$NON-NLS-1$
							if (property.getType() instanceof Element) {
								ParticipantTypeAttribute attribute = new ParticipantTypeAttribute(property, parentElement);
								attributeList.add(attribute);
							}
						}

					}

					stereotypeParticipantsList.put(parentElement, attributeList);
				}
			}

		};

		try {
			dialog.run(true, true, computeAvailableTypes);
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	protected void createAdvancedSearch() {
		elementsLabel = new Label(advancedSearchComposite, SWT.NONE);
		elementsLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		elementsLabel.setText(Messages.PapyrusSearchPage_44);
		
		stereotypesLabel = new Label(advancedSearchComposite, SWT.NONE);
		stereotypesLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		stereotypesLabel.setText(Messages.PapyrusSearchPage_45);
		
		//TODO Better solution than this empty label to fill last row 1, col 3 with empty space
		emptyLabel = new Label(advancedSearchComposite, SWT.NONE);
		emptyLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		emptyLabel.setText("");
		
		participantTypesTree = new CheckBoxFilteredTree(advancedSearchComposite, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.SINGLE, new PatternFilter(), true);
		participantTypesTree.setLayout(new GridLayout());
		GridData typesChechboxTreeViewerGridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		typesChechboxTreeViewerGridData.heightHint = 150;
		participantTypesTree.setLayoutData(typesChechboxTreeViewerGridData);
		
		participantStereotypesTree = new CheckBoxFilteredTree(advancedSearchComposite, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.SINGLE, new PatternFilter(), true);
		participantStereotypesTree.setLayout(new GridLayout());
		GridData stereotypesChechboxTreeViewerGridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		stereotypesChechboxTreeViewerGridData.heightHint = 150;
		participantStereotypesTree.setLayoutData(stereotypesChechboxTreeViewerGridData);
		
		participantTypesTreeViewer = (CheckboxTreeViewer) participantTypesTree.getViewer();
		participantTypesTreeViewer.setContentProvider(new ParticipantTypeContentProvider());
		participantTypesTreeViewer.setLabelProvider(new ParticipantTypeLabelProvider());
		participantTypesTreeViewer.setSorter(new ViewerSorter());
		participantTypesTreeViewer.setCheckStateProvider(new ICheckStateProvider() {

			public boolean isGrayed(Object element) {
				return false;
			}

			public boolean isChecked(Object element) {
				if (element instanceof ParticipantTypeElement) {

					return ((ParticipantTypeElement) element).isChecked();

				}
				return false;
			}
		});
		
		participantStereotypesTreeViewer = (CheckboxTreeViewer) participantStereotypesTree.getViewer();
		// TODO ParticipantStereotypeContentProvider
		participantStereotypesTreeViewer.setContentProvider(new ParticipantTypeContentProvider());
		// TODO ParticipantStereotypeLabelProvider
		participantStereotypesTreeViewer.setLabelProvider(new ParticipantTypeLabelProvider());
		participantStereotypesTreeViewer.setSorter(new ViewerSorter());
		participantStereotypesTreeViewer.setCheckStateProvider(new ICheckStateProvider() {

			public boolean isGrayed(Object element) {
				return false;
			}

			public boolean isChecked(Object element) {
				if (element instanceof ParticipantTypeElement) {

					return ((ParticipantTypeElement) element).isChecked();

				}
				return false;
			}
		});
		
		Composite participantManipualtionComposite = new Composite(advancedSearchComposite, SWT.NONE);
		participantManipualtionComposite.setLayout(new GridLayout(1, false));
		participantManipualtionComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, true, 1, 1));

		Button btnSelectSub = new Button(participantManipualtionComposite, SWT.PUSH);
		btnSelectSub.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnSelectSub.setText(Messages.PapyrusSearchPage_14);
		btnSelectSub.setToolTipText(Messages.PapyrusSearchPageTooltip_1);
		btnSelectSub.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				ISelection selection = participantTypesTreeViewer.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object selectedElement = ((IStructuredSelection) selection).getFirstElement();

					if (selectedElement instanceof ParticipantTypeElement) {
						List<ParticipantTypeAttribute> attributeParentList = new ArrayList<ParticipantTypeAttribute>();

						for (Object attribute : participantsList.get(selectedElement)) {
							if (attribute instanceof ParticipantTypeAttribute) {
								if (((ParticipantTypeAttribute) attribute).isChecked()) {
									attributeParentList.add(((ParticipantTypeAttribute) attribute));
								}

							}
						}
						if (((ParticipantTypeElement) selectedElement).getElement() instanceof EClass) {

							selectAllSubUML((ParticipantTypeElement) selectedElement, attributeParentList);

						} else if (((ParticipantTypeElement) selectedElement).getElement() instanceof Stereotype) {

							selectAllSubSter((ParticipantTypeElement) selectedElement, attributeParentList);

						}
					}
				}

				participantTypesTreeViewer.refresh();
			}
		});

		Button btnSelectAll = new Button(participantManipualtionComposite, SWT.PUSH);
		btnSelectAll.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnSelectAll.setText(Messages.PapyrusSearchPage_9);

		btnSelectAll.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				for (ParticipantTypeElement element : participantsList.keySet()) {
					if (!element.isChecked()) {
						element.setChecked(true);

						for (ParticipantTypeAttribute attribute : participantsList.get(element)) {
							attribute.setChecked(true);

						}
					}
				}
				participantTypesTreeViewer.refresh();

			}
		});

		Button btnDeselectAll = new Button(participantManipualtionComposite, SWT.PUSH);
		btnDeselectAll.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnDeselectAll.setText(Messages.PapyrusSearchPage_10);
		btnDeselectAll.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				for (ParticipantTypeElement element : participantsList.keySet()) {
					if (element.isChecked()) {
						element.setChecked(false);

						for (ParticipantTypeAttribute attribute : participantsList.get(element)) {
							attribute.setChecked(false);


						}
					}
				}
				participantTypesTreeViewer.refresh();
			}
		});
		
		Button btnSelectAllSt = new Button(participantManipualtionComposite, SWT.PUSH);
		btnSelectAllSt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnSelectAllSt.setText(Messages.PapyrusSearchPage_46);

		btnSelectAllSt.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				for (ParticipantTypeElement element : stereotypeParticipantsList.keySet()) {
					if (!element.isChecked()) {
						element.setChecked(true);

						for (ParticipantTypeAttribute attribute : stereotypeParticipantsList.get(element)) {
							attribute.setChecked(true);
						}
					}
				}
				participantStereotypesTreeViewer.refresh();

			}
		});

		Button btnDeselectAllSt = new Button(participantManipualtionComposite, SWT.PUSH);
		btnDeselectAllSt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnDeselectAllSt.setText(Messages.PapyrusSearchPage_47);
		btnDeselectAllSt.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				for (ParticipantTypeElement element : stereotypeParticipantsList.keySet()) {
					if (element.isChecked()) {
						element.setChecked(false);

						for (ParticipantTypeAttribute attribute : stereotypeParticipantsList.get(element)) {
							attribute.setChecked(false);
						}
					}
				}
				participantStereotypesTreeViewer.refresh();
			}
		});
		
		Button btnRefreshTypes = new Button(participantManipualtionComposite, SWT.PUSH);
		btnRefreshTypes.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnRefreshTypes.setText(Messages.PapyrusSearchPage_15);
		btnRefreshTypes.setToolTipText(Messages.PapyrusSearchPageTooltip_2);
		btnRefreshTypes.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				participantsList.clear();
				stereotypeParticipantsList.clear();
				createResultList();

				//createAdvancedSearch();

				participantTypesTreeViewer.refresh();
				participantStereotypesTreeViewer.refresh();
			}
		});

		participantTypesTreeViewer.setInput(participantsList);
		((ICheckable) participantTypesTreeViewer).addCheckStateListener(new ParticipantTypesTreeViewerCheckStateListener(participantTypesTreeViewer, participantsList));
		
		participantStereotypesTreeViewer.setInput(stereotypeParticipantsList);
		((ICheckable) participantStereotypesTreeViewer).addCheckStateListener(new ParticipantTypesTreeViewerCheckStateListener(participantStereotypesTreeViewer, stereotypeParticipantsList));

		//TODO Better solution than this empty label to fill last row 1, col 3 with empty space
		emptyLabel2 = new Label(advancedSearchComposite, SWT.NONE);
		emptyLabel2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		emptyLabel2.setText("");
		
		fBtnSearchForAllSelected = new Button(advancedSearchComposite, SWT.CHECK);
		fBtnSearchForAllSelected.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		fBtnSearchForAllSelected.setText(Messages.PapyrusSearchPage_13);
		
		//TODO Better solution than this empty label to fill last row 1, col 3 with empty space
		emptyLabel3 = new Label(advancedSearchComposite, SWT.NONE);
		emptyLabel3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		emptyLabel3.setText("");
		
		//TODO Better solution than this empty label to fill last row 1, col 3 with empty space
		emptyLabel4 = new Label(advancedSearchComposite, SWT.NONE);
		emptyLabel4.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		emptyLabel4.setText("");
		
		fBtnSearchForAnySelected = new Button(advancedSearchComposite, SWT.CHECK);
		fBtnSearchForAnySelected.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		fBtnSearchForAnySelected.setText(Messages.PapyrusSearchPage_49);
		
		currentSearchKind = ADVANCED_SEARCH;
		currentQueryKind = TEXT_QUERY_KIND;
	}

	protected void selectAllSubSter(final ParticipantTypeElement elementParent, final List<ParticipantTypeAttribute> attributeParentList) {

		ProgressMonitorDialog dialog = new ProgressMonitorDialog(getShell());
		IRunnableWithProgress computeAvailableTypes = new IRunnableWithProgress() {

			public void run(IProgressMonitor thePM) throws InterruptedException {
				for (Object element : participantsList.keySet()) {
					if (element instanceof ParticipantTypeElement) {
						checkAllSubSter((ParticipantTypeElement) element, elementParent, attributeParentList);

					}
				}


			}

		};


		try {
			dialog.run(true, true, computeAvailableTypes);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}

	protected void checkAllSubSter(ParticipantTypeElement element, ParticipantTypeElement elementParent, List<ParticipantTypeAttribute> attributeParentList) {
		if (element.getElement() instanceof Stereotype) {
			List<Class> superTypes = ((Class) element.getElement()).getSuperClasses();

			if (superTypes.contains(elementParent.getElement())) {
				element.setChecked(true);


				// Proceed with attributes
				for (ParticipantTypeAttribute attributeParent : attributeParentList) {
					for (ParticipantTypeAttribute attributeToEvaluate : participantsList.get(element)) {
						if (attributeParent.getElement() == attributeToEvaluate.getElement()) {

							attributeToEvaluate.setChecked(true);


						}

					}
				}
			}
		}
	}

	protected void selectAllSubUML(final ParticipantTypeElement elementParent, final List<ParticipantTypeAttribute> attributeParentList) {

		ProgressMonitorDialog dialog = new ProgressMonitorDialog(getShell());
		IRunnableWithProgress computeAvailableTypes = new IRunnableWithProgress() {

			public void run(IProgressMonitor thePM) throws InterruptedException {
				for (Object element : participantsList.keySet()) {
					if (element instanceof ParticipantTypeElement) {
						checkAllSubUML((ParticipantTypeElement) element, elementParent, attributeParentList);

					}
				}
			}

		};

		try {
			dialog.run(true, true, computeAvailableTypes);
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}


	protected void checkAllSubUML(ParticipantTypeElement element, ParticipantTypeElement elementParent, List<ParticipantTypeAttribute> attributeParentList) {
		if (element.getElement() instanceof EClass) {
			List<EClass> superTypes = ((EClass) element.getElement()).getEAllSuperTypes();

			if (superTypes.contains(elementParent.getElement())) {
				// participantTypesTreeViewer.setChecked(element, true);
				element.setChecked(true);


				// Proceed with attributes
				for (ParticipantTypeAttribute attributeParent : attributeParentList) {
					for (ParticipantTypeAttribute attributeToEvaluate : participantsList.get(element)) {
						if (attributeParent.getElement() == attributeToEvaluate.getElement()) {

							attributeToEvaluate.setChecked(true);


						}

					}
				}
			}
		}

	}


	protected void simpleSearch() {


		Composite participantManipualtionComposite = new Composite(advancedSearchComposite, SWT.NONE);
		participantManipualtionComposite.setLayout(new GridLayout(1, false));
		participantManipualtionComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, true, 1, 1));


		btnSearchInName = new Button(participantManipualtionComposite, SWT.RADIO);
		btnSearchInName.setText(Messages.PapyrusSearchPage_16);
		btnSearchInName.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 0, 1));
		btnSearchInName.setSelection(true);


		btnSearchAllStringAttributes = new Button(participantManipualtionComposite, SWT.RADIO);
		btnSearchAllStringAttributes.setText(Messages.PapyrusSearchPage_17);
		btnSearchAllStringAttributes.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		
		currentSearchKind = SIMPLE_SEARCH;
		currentQueryKind = TEXT_QUERY_KIND;
	}


	public Object[] getMetaClassesList() {
		Set<EObject> umlMetaClasses = new HashSet<EObject>();

		for (EClassifier eClassifier : UMLPackage.eINSTANCE.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				umlMetaClasses.add(eClassifier);
			}
		}
		return umlMetaClasses.toArray();

	}


	protected void createOCLSearchQueryField(EObject root) {

		Composite client = queryComposite;

		Composite oclContextComposite = new Composite(client, SWT.NONE);
		oclContextComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		oclContextComposite.setLayout(new GridLayout(2, false));

		oclContext = new Text(oclContextComposite, SWT.BORDER);
		oclContext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		oclContext.setEnabled(false);
		oclContext.setFocus();

		Button btnSelectContext = new Button(oclContextComposite, SWT.PUSH);
		btnSelectContext.setText(Messages.PapyrusSearchPage_18);
		btnSelectContext.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {

				LabelProviderService labelProviderService = new LabelProviderServiceImpl();
				ILabelProvider labelProvider = labelProviderService.getLabelProvider();

				ScopeEntry currentScope = getCurrentScopeEntry();

				if (currentScope != null) {

					try {
						((UmlModel) currentScope.getModelSet().getModel(UmlModel.MODEL_ID)).lookupRoot();

						ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(Display.getCurrent().getActiveShell(), labelProvider, new OCLContextContentProvider());
						dialog.setTitle(Messages.PapyrusSearchPage_19);
						dialog.setMessage(Messages.PapyrusSearchPage_20);
						dialog.setInput(currentScope.getModelSet());
						dialog.setAllowMultiple(false);
						dialog.open();
						Object selection = dialog.getFirstResult();

						if (selection instanceof EObject) {

							refreshSelection(selection);

							if (contextObject instanceof NamedElement) {
								oclContext.setText(((NamedElement) contextObject).getQualifiedName());
							} else {
								oclContext.setText(labelProvider.getText(contextObject));
							}
						}

					} catch (NotFoundException notFoundException) {

						Activator.log.error(Messages.PapyrusQuery_0 + currentScope.getModelSet(), notFoundException);
					}
				}

			}
		});
		btnSelectContext.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));

		Injector injector = EssentialOCLActivator.getInstance().getInjector(EssentialOCLPlugin.LANGUAGE_ID);
		Composite editorComposite = client;
		oclEditor = new EmbeddedXtextEditor(editorComposite, injector, SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);

		oclEditor.getViewer().getTextWidget().addVerifyKeyListener(new VerifyKeyListener() {

			public void verifyKey(VerifyEvent e) {
				// System.out.println("verifyKey: " + e.keyCode);
				if (e.keyCode == SWT.KEYPAD_CR || e.keyCode == SWT.CR) {
					if ((e.stateMask & (SWT.CTRL | SWT.SHIFT)) == 0) {
						e.doit = false;
					}
				}
			}
		});

		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		data.heightHint = convertHeightInCharsToPixels(3);
		editorComposite.setLayoutData(data);

		refreshSelection(root);
		
		currentQueryKind = OCL_QUERY_KIND;
	}

	protected ScopeEntry getCurrentScopeEntry() {
		if (container.getSelectedScope() == ISearchPageContainer.SELECTION_SCOPE) {
			Collection<URI> scope = ScopeCollector.getInstance().computeSearchScope(container);

			// this is only used for OCL queries, which currently assume workspace-like availability of the model content
			Collection<ScopeEntry> scopeEntries = WorkspaceQueryProvider.createScopeEntries(scope);

			if (scopeEntries.size() == 1) {
				Object[] entries = scopeEntries.toArray();
				ScopeEntry selectedResource = (ScopeEntry) entries[0];

				return selectedResource;
			}
		}
		return null;
	}

	public void createControl(Composite parent) {

		initializeDialogUnits(parent);
		Composite searchComposite = new Composite(parent, SWT.NONE);
		searchComposite.setFont(parent.getFont());
		searchComposite.setLayout(new GridLayout(2, false));
		searchComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		Label lblSearchString = new Label(searchComposite, SWT.NONE);
		lblSearchString.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		lblSearchString.setText(Messages.PapyrusSearchPage_4);

		queryKind = new Combo(searchComposite, SWT.VERTICAL | SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
		queryKind.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, false, false, 1, 1));
		queryKind.add(Messages.PapyrusSearchPage_21);
		queryKind.add(Messages.PapyrusSearchPage_22);

		queryKind.select(TEXT_QUERY_KIND);

		queryKind.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (queryKind.getSelectionIndex() != currentQueryKind) {
					for (Control childControl : queryComposite.getChildren()) {
						childControl.dispose();
					}

					if (queryKind.getSelectionIndex() == TEXT_QUERY_KIND) {
						createSimpleSearchQueryField();
					} else {
						if (container.getSelectedScope() == ISearchPageContainer.SELECTION_SCOPE) {

							ScopeEntry currentScope = getCurrentScopeEntry();
							if (currentScope != null) {
								if (currentScope.getModelSet() != null) {

									try {
										EObject root = ((UmlModel) currentScope.getModelSet().getModel(UmlModel.MODEL_ID)).lookupRoot();
										createOCLSearchQueryField(root);

										if (contextObject instanceof NamedElement) {
											oclContext.setText(((NamedElement) contextObject).getQualifiedName());
										} else {
											LabelProviderService labelProviderService = new LabelProviderServiceImpl();
											ILabelProvider labelProvider = labelProviderService.getLabelProvider();
											oclContext.setText(labelProvider.getText(contextObject));
										}
									} catch (NotFoundException notFoundException) {

										Activator.log.error(Messages.PapyrusQuery_0 + currentScope.getModelSet(), notFoundException);
									}
								} else {
									MessageDialog.openWarning(Display.getCurrent().getActiveShell(), Messages.PapyrusSearchPage_23, Messages.PapyrusSearchPage_24);
									createSimpleSearchQueryField();
									queryKind.select(TEXT_QUERY_KIND);
								}
							} else {
								MessageDialog.openWarning(Display.getCurrent().getActiveShell(), Messages.PapyrusSearchPage_25, Messages.PapyrusSearchPage_26);
								createSimpleSearchQueryField();
								queryKind.select(TEXT_QUERY_KIND);
							}
						} else {
							MessageDialog.openWarning(Display.getCurrent().getActiveShell(), Messages.PapyrusSearchPage_27, Messages.PapyrusSearchPage_28);
							createSimpleSearchQueryField();
							queryKind.select(TEXT_QUERY_KIND);
						}
					}
					queryComposite.layout();
				}
			}
		});


		queryComposite = new Composite(searchComposite, SWT.NONE);
		queryComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		queryComposite.setLayout(new GridLayout(1, false));

		createSimpleSearchQueryField();

		setControl(parent);
	}

	public boolean getSearchAllStringAttributes() {
		if (btnSearchAllStringAttributes != null) {
			return btnSearchAllStringAttributes.getSelection();
		} else {
			return false;
		}
	}

	/**
	 * Validate syntax of the regular expression of the search query text.
	 *
	 * @return true, if successful
	 */
	private boolean validateRegex() {

		try {
			PatternHelper.getInstance().createPattern(searchQueryText.getText(), btnCaseSensitive.getSelection(), btnRegularExpression.getSelection());
			searchQueryExplanatoryLabel.setForeground(getControl().getForeground());
			searchQueryExplanatoryLabel.setText(""); //$NON-NLS-1$
			return true;

		} catch (PatternSyntaxException e) {
			searchQueryExplanatoryLabel.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
			searchQueryExplanatoryLabel.setText(e.getDescription());

			return false;
		}
	}

	protected void refreshSelection(final Object selected) {
		final BaseDocument editorDocument = (BaseDocument) oclEditor.getDocument();
		editorDocument.modify(new IUnitOfWork<Object, XtextResource>() {

			public Value exec(XtextResource resource) throws Exception {
				Object selectedObject = selected;
				if (selectedObject instanceof IOutlineNode) {
					if (selectedObject instanceof EObjectNode) {
						EObjectNode selectedObjectNode = (EObjectNode) selectedObject;
						selectedObjectNode.getEObjectURI();
						contextObject = null; // FIXME
												// metamodelManager.loadResource(eObjectURI,
												// null, null);
					} else if (selectedObject instanceof EStructuralFeatureNode) {
						contextObject = null;
					} else {
						contextObject = null;
					}
				} else {
					if (selectedObject instanceof IAdaptable) {
						selectedObject = ((IAdaptable) selectedObject).getAdapter(EObject.class);
					}
					if (selectedObject instanceof EObject) {
						contextObject = (EObject) selectedObject;
					} else {
						contextObject = null;
					}
				}
				EnvironmentFactory environmentFactory = getEnvironmentFactory();
				parserContext = new EObjectContext(environmentFactory, null, contextObject);
				EssentialOCLCSResource csResource = (EssentialOCLCSResource) resource;
				if (csResource != null) {
					if (contextObject != null) {
						csResource.getCS2AS();			// FIXME redundant ??
					}
					ResourceSet resourceSet = oclEditor.getResourceSet();
					if (resourceSet != null) {
						environmentFactory.adapt(resourceSet);			// FIXME redundant ??
					}
					csResource.setParserContext(parserContext);
				}

				return null;
			}
		});
	}


	@SuppressWarnings("unused")
	private Collection<ScopeEntry> createScopeEntries(Collection<URI> scope) {
		Collection<ScopeEntry> results = new HashSet<ScopeEntry>();

		for (URI resource : scope) {

			ScopeEntry scopeEntry = new ScopeEntry(resource);

			results.add(scopeEntry);

		}

		return results;
	}

	@SuppressWarnings("unused")
	private List<ParticipantTypeElement> getParticipantsToEvaluate(HashMap<ParticipantTypeElement, List<ParticipantTypeAttribute>> participantsList) {
		List<ParticipantTypeElement> participantsToEvaluate = new ArrayList<ParticipantTypeElement>();

		for (ParticipantTypeElement element : participantsList.keySet()) {
			if (element.isChecked()) {
				participantsToEvaluate.add(element);
				for (ParticipantTypeAttribute attributesToEvaluate : participantsList.get(element)) {
					if (attributesToEvaluate.isChecked()) {
						participantsToEvaluate.add(attributesToEvaluate);
					}
				}
			}
		}
		return participantsToEvaluate;
	}

	public boolean performAction() {

		if (queryKind.getSelectionIndex() == TEXT_QUERY_KIND) {
			if (validateRegex()) {
				Collection<URI> scope = ScopeCollector.getInstance().computeSearchScope(container);
				AbstractPapyrusQuery compositeQuery;
				if (searchKind.getSelectionIndex() == SIMPLE_SEARCH) {
					if (searchQueryText.getText().length() == 0) {
						MessageDialog.openError(Display.getCurrent().getActiveShell(), Messages.PapyrusSearchPage_29, Messages.PapyrusSearchPage_30);
						return false;
					} else {
						// One query per di file to avoid one single slow query on many files
						ArrayList<AbstractPapyrusQuery> queries = new ArrayList<AbstractPapyrusQuery>(scope.size());
						boolean delay = scope.size() > 1 ? false : true;
						
						for (URI uri : scope) {
							Collection<URI> singleScope = new HashSet<URI>();
							singleScope.add(uri);
							
							QueryInfo info = new QueryInfo(searchQueryText.getText(), btnCaseSensitive.getSelection(), btnRegularExpression.getSelection(), btnSearchAllStringAttributes.getSelection(), singleScope, delay);
							ISearchQuery query = CompositePapyrusQueryProvider.getInstance().createSimpleSearchQuery(info);
							
							queries.add((AbstractPapyrusQuery) query);
						}
						
						compositeQuery = CompositePapyrusQuery.compose(queries);
					}
				} else {


					List<ParticipantTypeElement> participantsToEvaluate = new ArrayList<ParticipantTypeElement>();
					
					for (ParticipantTypeElement element : this.participantsList.keySet()) {
						if (element.isChecked()) {
							participantsToEvaluate.add(element);
							
							if (searchQueryText.getText().length() > 0) {
								for (ParticipantTypeAttribute attributesToEvaluate : participantsList.get(element)) {
									if (attributesToEvaluate.isChecked()) {
										participantsToEvaluate.add(attributesToEvaluate);
									}
								}
							}
						}
					}
					
					for (ParticipantTypeElement element : this.stereotypeParticipantsList.keySet()) {
						if (element.isChecked()) {
							participantsToEvaluate.add(element);
							
							if (searchQueryText.getText().length() > 0) {
								for (ParticipantTypeAttribute attributesToEvaluate : stereotypeParticipantsList.get(element)) {
									if (attributesToEvaluate.isChecked()) {
										participantsToEvaluate.add(attributesToEvaluate);
									}
								}
							}
						}
					}
					
					if (participantsToEvaluate.size() == 0) {
						MessageDialog.openError(Display.getCurrent().getActiveShell(), Messages.PapyrusSearchPage_31, Messages.PapyrusSearchPage_32);
						return false;
					} else {
						// One query per di file to avoid one single slow query on many files
						ArrayList<AbstractPapyrusQuery> queries = new ArrayList<AbstractPapyrusQuery>(scope.size());
						boolean delay = scope.size() > 1 ? false : true;
						
						for (URI uri : scope) {
							Collection<URI> singleScope = new HashSet<URI>();
							singleScope.add(uri);
							
							QueryInfo info = new QueryInfo(searchQueryText.getText(), btnCaseSensitive.getSelection(), btnRegularExpression.getSelection(), participantsToEvaluate, singleScope, fBtnSearchForAllSelected.getSelection(), fBtnSearchForAnySelected.getSelection(), delay);
							ISearchQuery query = CompositePapyrusQueryProvider.getInstance().createAdvancedSearchQuery(info);
							
							queries.add((AbstractPapyrusQuery) query);
						}
						
						compositeQuery = CompositePapyrusQuery.compose(queries);
					}

				}
				if (compositeQuery.canRunInBackground()) {
					NewSearchUI.runQueryInBackground(compositeQuery);
				}

				return true;
			} else {
				MessageDialog.openError(Display.getCurrent().getActiveShell(), SEARCH_ISSUE, REGULAR_EXPRESSION_ILLFORMED);
				return false;
			}
		} else {

			ScopeEntry scopeEntry = getCurrentScopeEntry();

			if (scopeEntry != null) {

				try {

					PivotUtil.checkResourceErrors("", oclEditor.getResource()); //$NON-NLS-1$
					@SuppressWarnings("unused") ExpressionInOCL expressionInOCL = parserContext.getExpression((CSResource) oclEditor.getResource());
					ISearchQuery query = new PapyrusOCLQuery((BaseDocument) oclEditor.getDocument(), parserContext, getEnvironmentFactory(), null, contextObject, scopeEntry);


					if (query.canRunInBackground()) {
						NewSearchUI.runQueryInBackground(query);
					}
				} catch (ParserException e) {
					@SuppressWarnings("unused") Object value = new InvalidValueException(e, Messages.PapyrusSearchPage_35);
					MessageDialog.openError(Display.getCurrent().getActiveShell(), SEARCH_ISSUE, OCL_QUERY_ILLFORMED);
					return false;
				}

				return true;
			} else {
				return false;
			}
		}
	}

	public void setContainer(ISearchPageContainer container) {
		this.container = container;
		this.container.setPerformActionEnabled(true);
	}

	public boolean performReplace() {
		if (queryKind.getSelectionIndex() == TEXT_QUERY_KIND) {
			if (container.getSelectedScope() == ISearchPageContainer.SELECTION_SCOPE) {
				if (validateRegex()) {
					if (searchQueryText.getText().length() == 0) {
						MessageDialog.openError(Display.getCurrent().getActiveShell(), Messages.PapyrusSearchPage_36, Messages.PapyrusSearchPage_37);
						return false;
					}

					Collection<URI> scope = ScopeCollector.getInstance().computeSearchScope(container);

					AbstractPapyrusQuery query;
					if (searchKind.getSelectionIndex() == SIMPLE_SEARCH) {
						QueryInfo info = new QueryInfo(searchQueryText.getText(), btnCaseSensitive.getSelection(), btnRegularExpression.getSelection(), btnSearchAllStringAttributes.getSelection(), scope);
						query = CompositePapyrusQueryProvider.getInstance().createSimpleSearchQuery(info);
					} else {
						List<ParticipantTypeElement> participantsToEvaluate = new ArrayList<ParticipantTypeElement>();
						for (ParticipantTypeElement element : this.participantsList.keySet()) {
							if (element.isChecked()) {
								participantsToEvaluate.add(element);
								if (participantsList.get(element).size() == 0) {
									MessageDialog.openError(Display.getCurrent().getActiveShell(), Messages.PapyrusSearchPage_38, Messages.PapyrusSearchPage_39);
									return false;

								} else {
									for (ParticipantTypeAttribute attributesToEvaluate : participantsList.get(element)) {
										if (attributesToEvaluate.isChecked()) {
											participantsToEvaluate.add(attributesToEvaluate);
											boolean canDoReplace = false;
											if (attributesToEvaluate.getElement() instanceof EAttribute) {
												Object value = element.getElement().eGet((EAttribute) attributesToEvaluate.getElement());
												if (value instanceof String) {
													canDoReplace = true;
												}
											} else if (attributesToEvaluate.getElement() instanceof Property) {
												Property property = (Property) attributesToEvaluate.getElement();
												if (UMLUtil.isString(property.getType())) {
													canDoReplace = true;
												}
											}
											if (!canDoReplace) {
												MessageDialog.openError(Display.getCurrent().getActiveShell(), Messages.PapyrusSearchPage_40, Messages.PapyrusSearchPage_41);
												return false;
											}
										}
									}
								}
							}
						}
						QueryInfo info = new QueryInfo(searchQueryText.getText(), btnCaseSensitive.getSelection(), btnRegularExpression.getSelection(), participantsToEvaluate, scope, fBtnSearchForAllSelected.getSelection(), fBtnSearchForAnySelected.getSelection());
						query = CompositePapyrusQueryProvider.getInstance().createAdvancedSearchQuery(info);

					}

					NewSearchUI.runQueryInForeground(container.getRunnableContext(), query);


					Display.getCurrent().syncExec(new Runnable() {

						public void run() {
							ISearchResultViewPart view = NewSearchUI.activateSearchResultView();
							if (view != null) {
								ISearchResultPage page = view.getActivePage();

								if (page instanceof PapyrusSearchResultPage) {
									PapyrusSearchResultPage resultPage = (PapyrusSearchResultPage) page;
									ReplaceAction replaceAction = new ReplaceAction(resultPage.getSite().getShell(), resultPage, null);
									replaceAction.run();
								}
							}
						}
					});

					NewSearchUI.removeQuery(query);
					return true;
				} else {
					MessageDialog.openError(Display.getCurrent().getActiveShell(), SEARCH_ISSUE, REGULAR_EXPRESSION_ILLFORMED);
					return false;
				}
			} else {
				MessageDialog.openWarning(Display.getCurrent().getActiveShell(), Messages.PapyrusSearchPage_27, Messages.PapyrusSearchPage_28);
				return false;
			}
		} else {
			MessageDialog.openWarning(Display.getCurrent().getActiveShell(), Messages.PapyrusSearchPage_42, Messages.PapyrusSearchPage_43);
			return false;
		}

	}

	protected EnvironmentFactory getEnvironmentFactory() {
		return oclEditor.getOCL().getEnvironmentFactory();
	}

	protected void flushEvents() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		while (workbench.getDisplay().readAndDispatch()) {
			;
		}
	}

	public void reset() {
		if (oclEditor != null) {
			flushEvents();
			// editor.close(false);
			flushEvents();
		}
		parserContext = null;
		contextObject = null;
	}
}
