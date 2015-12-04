/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.editor.welcome.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModelUtils;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.utils.TransactionHelper;
import org.eclipse.papyrus.infra.editor.welcome.IWelcomePageService;
import org.eclipse.papyrus.infra.editor.welcome.Welcome;
import org.eclipse.papyrus.infra.editor.welcome.WelcomeFactory;
import org.eclipse.papyrus.infra.editor.welcome.WelcomePage;
import org.eclipse.papyrus.infra.editor.welcome.WelcomeSection;
import org.eclipse.papyrus.infra.editor.welcome.internal.dnd.WelcomeSectionTransfer;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.views.properties.contexts.Tab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.uml2.common.util.UML2Util;

/**
 * @author damus
 *
 */
class WelcomeLayout {
	private static final String PREFERENCE_PAGE_ID = "org.eclipse.papyrus.infra.editor.welcome.content"; //$NON-NLS-1$

	private static final int NUM_ROWS = 2;

	private static final Function<Control, Control> textLabelAccessor = createTextLabelAccessor();

	private final int rowCount = NUM_ROWS;

	private final Composite parent;
	private final FormToolkit toolkit;
	private final IWelcomePageService welcomeService;

	private Map<Tab, Composite> tabControls = new HashMap<>();

	private List<WelcomeTab> tabs;
	private Map<WelcomeTab, Composite> sections;

	/**
	 * Constructor.
	 *
	 */
	WelcomeLayout(Composite parent, FormToolkit toolkit, IWelcomePageService welcomeService) {
		super();

		this.parent = parent;
		this.toolkit = toolkit;
		this.welcomeService = welcomeService;
	}

	public void dispose() {
		tabControls.values().forEach(body -> {
			if (!body.isDisposed()) {
				// The tab controls are the bodies of expandable composites
				body.getParent().dispose();
			}
		});
		tabControls.clear();

		tabs = null;
		sections = null;
	}

	void createSections(List<WelcomeTab> tabs) {
		sort(tabs);

		this.tabs = tabs;
		this.sections = new HashMap<>();

		for (int i = 0; i < tabs.size(); i++) {
			WelcomeTab tab = tabs.get(i);
			ExpandableComposite control = toolkit.createSection(parent, ExpandableComposite.TITLE_BAR);
			Composite body = toolkit.createComposite(control);
			body.setLayout(new GridLayout()); // XWTSection expects to fill a grid layout
			control.setClient(body);
			tab.register(body, tabControls);
			control.setData(tab);
			sections.put(tab, control);

			Transfer[] transfers = { WelcomeSectionTransfer.getInstance() };
			addDragSourceAdapter(control, transfers, new DragSourceAdapter() {

				@Override
				public void dragSetData(DragSourceEvent event) {
					event.data = control;
				}
			});
			addDropTargetAdapter(control, transfers, new DropTargetAdapter() {

				@Override
				public void drop(DropTargetEvent event) {
					if (event.data != control) {
						Composite target = (Composite) event.data;
						swapSections(tab, (WelcomeTab) target.getData());
					}
				}
			});

			control.setText(tab.getLabel());
			// TODO: tab images?
		}

		layoutTabSections();

		if (tabControls.isEmpty()) {
			// We didn't have any contributions
			ExpandableComposite messages = toolkit.createSection(parent, ExpandableComposite.NO_TITLE);
			Composite blank = toolkit.createComposite(messages);
			messages.setClient(blank);
			blank.setLayout(new GridLayout());
			toolkit.createLabel(blank, "No welcome content is configured in this workspace.");
			Hyperlink hyperlink = toolkit.createHyperlink(blank, "Open Welcome Preferences", SWT.WRAP);
			tabControls.put(null, blank); // So it can be destroyed on re-build

			hyperlink.addHyperlinkListener(new HyperlinkAdapter() {
				@Override
				public void linkActivated(HyperlinkEvent e) {
					PreferencesUtil.createPreferenceDialogOn(hyperlink.getShell(), PREFERENCE_PAGE_ID, null, null).open();
				}
			});
		}
	}

	private void sort(List<WelcomeTab> tabs) {
		// Do we have a user-defined sort order?
		Welcome welcome = welcomeService.getWelcome();
		if (welcome.getWelcomePage() != null) {
			Collections.sort(tabs, userDefinedOrdering(welcome.getWelcomePage()));
		} else {
			Collections.sort(tabs);
		}
	}

	private Comparator<WelcomeTab> userDefinedOrdering(WelcomePage welcomePage) {
		return (tab1, tab2) -> {
			int result;

			WelcomeSection section1 = welcomePage.getSection(tab1.getID());
			WelcomeSection section2 = welcomePage.getSection(tab2.getID());
			int index1 = welcomePage.getSections().indexOf(section1);
			int index2 = welcomePage.getSections().indexOf(section2);

			if ((index1 >= 0) && (index2 >= 0)) {
				// There is a user-defined ordering for these
				result = index1 - index2;
			} else {
				// We have only the intrinsic ordering
				result = tab1.compareTo(tab2);
			}

			return result;
		};
	}

	private void layoutTabSections() {
		final int rows = this.rowCount;
		final int columns = Math.max(2, (tabs.size() + (tabs.size() % rows)) / rows);

		Control prev = null;
		Control prevCol = null;
		for (int i = 0; i < tabs.size(); i++) {
			Control section = sections.get(tabs.get(i));
			FormData fd = new FormData();
			if (i == 0) {
				fd.left = new FormAttachment(0);
				fd.right = new FormAttachment(100 / columns);
				fd.top = new FormAttachment(0);
				fd.bottom = new FormAttachment(100 / rows);
			} else {
				if (prevCol == null) {
					fd.left = new FormAttachment(0);
				} else {
					fd.left = new FormAttachment(prevCol, 5, SWT.RIGHT);
				}
				fd.right = new FormAttachment((100 * ((i / rows) + 1)) / columns);
				if (prev == null) {
					fd.top = new FormAttachment(0);
					fd.bottom = new FormAttachment(100 / rows);
				} else {
					fd.top = new FormAttachment(prev, 5, SWT.BOTTOM);
					fd.bottom = new FormAttachment((100 * ((i % rows) + 1)) / rows);
				}
			}

			section.setLayoutData(fd);

			if (((i + 1) % rows) == 0) {
				prevCol = section;
				prev = null;
			} else {
				prev = section;
			}
		}
	}

	void swapSections(WelcomeTab tab1, WelcomeTab tab2) {
		Collections.swap(tabs, tabs.indexOf(tab1), tabs.indexOf(tab2));
		updateWelcomeLayoutModel();
		layoutTabSections();
		parent.layout();
	}

	Composite getTabControl(Tab tab) {
		return tabControls.get(tab);
	}

	private void addDragSourceAdapter(Control control, Transfer[] transferTypes, DragSourceListener listener) {
		Control textLabel = textLabelAccessor.apply(control);
		DragSource drag = new DragSource(textLabel, DND.DROP_MOVE);
		drag.addDragListener(new DragSourceAdapter() {
			@Override
			public void dragStart(DragSourceEvent event) {
				event.image = Activator.getIcon(Activator.IMG_LAYOUT);
			}
		});
		drag.setTransfer(transferTypes);
		drag.addDragListener(listener);
		textLabel.addDisposeListener(event -> drag.dispose());
	}

	private void addDropTargetAdapter(Control control, Transfer[] transferTypes, DropTargetListener listener) {
		DropTarget drop = new DropTarget(control, DND.DROP_MOVE);
		drop.setTransfer(transferTypes);
		drop.addDropListener(listener);
		control.addDisposeListener(event -> drop.dispose());
	}

	private void updateWelcomeLayoutModel() {
		SashModel sashModel = SashModelUtils.getSashModel(welcomeService.getOwner());
		Resource res = sashModel.getResource();
		if (res != null) {
			Welcome welcome = welcomeService.getWelcome();
			try {
				TransactionHelper.run(EMFHelper.resolveEditingDomain(welcome), () -> {
					if (welcome.eResource() != res) {
						// Move it
						res.getContents().add(welcome);
					}

					WelcomePage page = welcome.getWelcomePage();
					if (page == null) {
						page = welcome.createWelcomePage();
					}

					// TODO: Hidden tab sections

					List<WelcomeSection> newSections = new ArrayList<>(tabs.size());
					for (WelcomeTab tab : tabs) {
						WelcomeSection section = page.getSection(tab.getID());
						if (section == null) {
							section = WelcomeFactory.eINSTANCE.createWelcomeSection();
							section.getIdentifiers().addAll(tab.getAllTabIDs());
						}
						newSections.add(section);
					}
					ECollections.setEList(page.getSections(), newSections);
				});
			} catch (Exception e) {
				Activator.log.error("Failed to update welcome page layout", e); //$NON-NLS-1$
			}
		}
	}

	void resetLayoutModel() {
		Welcome welcome = welcomeService.getWelcome();
		Resource res = welcomeService.getWelcomeResource();
		boolean[] recompute = { false };

		try {
			TransactionHelper.run(EMFHelper.resolveEditingDomain(welcome), () -> {
				if (welcome.eResource() != res) {
					// Move it
					res.getContents().add(welcome);
				}

				WelcomePage page = welcome.getWelcomePage();
				if (page != null) {
					new UML2Util() {
						{
							destroy(page);
							recompute[0] = true;
						}
					};
				}
			});
		} catch (Exception e) {
			Activator.log.error("Failed to reset new welcome page layout", e); //$NON-NLS-1$
		}

		if (recompute[0]) {
			sort(tabs);
			layoutTabSections();
			parent.layout();
		}
	}

	//
	// Reflection hacks
	//

	private static Function<Control, Control> createTextLabelAccessor() {
		Function<Control, Control> result;

		try {
			// It's protected API, so it really should be there
			Field textLabelField = ExpandableComposite.class.getDeclaredField("textLabel"); //$NON-NLS-1$
			textLabelField.setAccessible(true);
			result = section -> {
				try {
					return (Control) textLabelField.get(section);
				} catch (Exception e) {
					return section;
				}
			};
		} catch (Exception e) {
			result = control -> control;
		}

		return result;
	}
}
