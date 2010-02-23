/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL 
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sasheditor.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.jface.util.Geometry;
import org.eclipse.papyrus.sasheditor.contentprovider.IComponentModel;
import org.eclipse.papyrus.sasheditor.contentprovider.IEditorModel;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.sasheditor.editor.IPage;
import org.eclipse.papyrus.sasheditor.editor.IPageChangedListener;
import org.eclipse.papyrus.sasheditor.editor.IPageVisitor;
import org.eclipse.papyrus.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.internal.DragCursors;
import org.eclipse.ui.internal.dnd.DragUtil;
import org.eclipse.ui.internal.dnd.IDragOverListener;
import org.eclipse.ui.internal.dnd.IDropTarget;


/**
 * Main entry class of the SashWindows system.
 * This class allows to have a multitab window with sashes.
 * The class require a ContentProvider describing the content to be shown.
 * 
 * @author dumoulin
 */
public class SashWindowsContainer implements ISashWindowsContainer {

	/**
	 * The content provider describing the sashes, folders and tabs.
	 */
	private ISashWindowsContentProvider contentProvider;

	/**
	 * The manager used to get Main editor properties like Site, ActionBars, ...
	 */
	private IMultiEditorManager multiEditorManager;

	/**
	 * Tracker tracking the current active page. The tracker also disconnect last active page and connect
	 * the new one.
	 */
	private ActivePageTracker activePageTracker;

	/**
	 * The part used as root. We use an extra class as root in order to separate the code dedicated to
	 * ITilePart.
	 */
	private RootPart rootPart;

	/**
	 * The SWT container associated to this part. This is generally the container of the
	 * parent.
	 */
	private Composite container;

	/**
	 * The drop target.
	 */
	protected DropTarget dropTarget;

	/** A flag that indicates that the model is being synchronized. */
	private AtomicBoolean isRefreshing = new AtomicBoolean(false);

	/**
	 * Constructor.
	 * Build a Container without IEditor management. Trying to add a EditorPart will result in an Exception.
	 * The ContentProvider should not contain IEditorModel.
	 */
	public SashWindowsContainer() {
		this(null);
	}

	/**
	 * Constructor.
	 * Build a container with EditorPart management. The container will allow to add EditorPart
	 * (and thus IEditorModel to the ContentProvider).
	 * 
	 * @param multiEditorManager
	 *        The manager allowing to use {@link IEditorModel} in the model.
	 *        If null, the sash will not render IEditorModel.
	 * 
	 */
	public SashWindowsContainer(IMultiEditorManager multiEditorManager) {
		this.multiEditorManager = multiEditorManager;
		activePageTracker = new ActivePageTracker();

		if(multiEditorManager != null) {
			// Add listener on activePageChange.
			// This listener will take in charge editor services switching.
			activePageTracker.addActiveEditorChangedListener(new ActiveEditorServicesSwitcher(multiEditorManager.getEditorSite()));
		}
	}

	/**
	 * @return the contentProvider
	 */
	protected ISashWindowsContentProvider getContentProvider() {
		// Content provider should have been set.
		assert (contentProvider != null);
		// Double check for developement
		if(contentProvider == null)
			throw new IllegalStateException("ContentProvider should be set before calling any method requiring it.");

		return contentProvider;
	}

	/**
	 * Set the content provider describing the sashes, folders and tabs.
	 * 
	 * @param contentProvider
	 *        the contentProvider to set
	 */
	public void setContentProvider(ISashWindowsContentProvider contentProvider) {
		this.contentProvider = contentProvider;
	}

	/**
	 * Creates control associated to this Container.
	 * This method should be called when the parent is build.
	 * 
	 * @param parent
	 *        The parent in which the editor should be created; must not be <code>null</code>.
	 */
	public void createPartControl(Composite parent) {
		this.container = parent;

		rootPart = createRootPart();
		// Create the tree of tile part.
		rootPart.createPartControl(container);
		// Create children
		refreshTabs();
		// Set selection
		selectPage(lookupFirstValidPage());

		// postCreatePartControl();
		// TODO reactivate next
		initDrag(container);
		// activate();
	}

	/**
	 * Create the root part for the model.
	 */
	private RootPart createRootPart() {
		RootPart part = new RootPart(this);
		return part;
	}

	/**
	 * Notifies this page container that the specified page has been activated. This method
	 * is called after the current tabs has been changed, either by refreshing the tabs, or by a user
	 * UI action.
	 * This method just set correctly the active page value in the Container, and fire pageChanged events if needed.
	 * It does not change the selected page in the Part.
	 * 
	 * Propagate the event to activePageTracker.
	 * 
	 * @param childPart
	 */
	protected void pageChanged(PagePart childPart) {
		activePageTracker.setActiveEditor(childPart);
	}

	/**
	 * Notifies this page container that a pageChanged event has been fired by one swt Control.
	 * This method is usually called after the user selects a different tab.
	 * 
	 * The method record the new active folder in the ContentProvider, and calls {@link #pageChanged(PagePart)}.
	 * 
	 * @param childPart
	 */
	protected void pageChangedEvent(PagePart childPart) {

		// Check if it is really a change before changing the model (which can throw change event)
		// The folder model change is done before the tracker fires the listeners, like this
		// listeners can check the model.
		if(getActivePage() == childPart)
			return;

		contentProvider.setCurrentFolder(childPart.getParent().getRawModel());
		pageChanged(childPart);
	}

	/**
	 * Set the active page. The current active page will be the specified page.
	 * Do not record the new active folder in the ContentProvider
	 * 
	 * The method record the new CurrentFolder, and calls {@link #pageChanged(PagePart)}.
	 * 
	 * @param childPart
	 */
	protected void setActivePage(PagePart childPart) {
		pageChanged(childPart);
	}

	/**
	 * A change has happen in one of the inner parts. Relay the event.
	 * This method is called by inner parts whenever the event happen in one of the part.
	 * It collects and relay the firePropertyChange(int propertyId) calls from the inner IEditor.
	 * 
	 * @param propertyId
	 */
	protected void firePropertyChange(int propertyId) {
		// For now, we do nothing with this event.
	}

	/**
	 * Create the part for the specified newModel.
	 * 
	 * @param parent
	 *        The parent of the created part.
	 * @param partModel
	 *        The model for which a part should be created.
	 * @return
	 */
	protected PagePart createPagePart(TabFolderPart parent, IPageModel partModel, Object rawModel) {


		if(partModel instanceof IEditorModel) {
			// Check if we can use IEditorModel
			if(multiEditorManager == null)
				throw new IllegalArgumentException("Container can't accept IEditorModel as no IMultiEditorManager is set. Please set a IMultiEditorManager.");

			return new EditorPart(parent, (IEditorModel)partModel, rawModel, multiEditorManager);
		} else if(partModel instanceof IComponentModel) {
			return new ComponentPart(parent, (IComponentModel)partModel, rawModel);
		} else {
			// Return a default part
		}

		// TODO return a default part showing an error instead.
		throw new IllegalArgumentException("No Part found for the model '" + rawModel + "'");
	}

	/**
	 * Get the active page.
	 * 
	 * @return
	 */
	private PagePart getActivePage() {
		return activePageTracker.getActiveEditor();
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.editor.ISashWindowsContainer#getActiveEditor()
	 * @return
	 * 
	 */
	public IEditorPart getActiveEditor() {
		PagePart pagePart = getActivePage();
		if(pagePart instanceof EditorPart)
			return ((EditorPart)pagePart).getIEditorPart();
		else
			return null;
	}

	/**
	 * Get the active page public API.
	 * 
	 * @return
	 */
	public IPage getActiveSashWindowsPage() {
		return getActivePage();
	}


	/**
	 * @see org.eclipse.papyrus.sasheditor.editor.ISashWindowsContainer#setFocus()
	 * 
	 */
	public void setFocus() {
		setFocus(getActivePage());
	}

	/**
	 * Sets focus to the control for the given page. If the page has an editor,
	 * this calls its <code>setFocus()</code> method. Otherwise, this calls <code>setFocus</code> on the control for the page.
	 * 
	 * @param pageIndex
	 *        the index of the page
	 */
	private void setFocus(PagePart part) {
		if(part != null)
			part.setFocus();
	}


	/**
	 * Refresh the tabs.
	 * Is we are already currently refreshing, simply return.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.editor.ISashWindowsContainer#refreshTabs()
	 * 
	 */
	public void refreshTabs() {

		// Check if we arent already refreshing
		if(isRefreshing.compareAndSet(false, true)) {
			try {
				refreshTabsInternal();
			} finally {
				isRefreshing.set(false);
			}
		} else {
			System.out.println("refresh inside refresh !");
		}

	}

	/**
	 * Real implementation of refreshTab.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.editor.ISashWindowsContainer#refreshTabs()
	 * 
	 */
	private void refreshTabsInternal() {
		//		System.out.println("start synchronize2() ------------------------");
		//		showTilesStatus();

		// Get the currently selected folder
		PagePart oldActivePage = getActivePage();

		// Do refresh
		container.setRedraw(false);
		// Create map of parts
		// PartMap<T> partMap = new PartMap<T>();
		PartLists garbageMaps = new PartLists();
		rootPart.fillPartMap(garbageMaps);

		// Synchronize parts
		rootPart.synchronize2(garbageMaps);


		// Remove orphaned parts (no more used)
		garbageMaps.garbage();

		// set active page if needed
		setActivePage(checkAndGetActivePage(oldActivePage, garbageMaps));

		// Reenable SWT and force layout
		container.setRedraw(true);
		container.layout(true, true);
		//		System.out.println("end synchronize2() ------------------------");
		//		showTilesStatus();
	}

	/**
	 * Select the specified page in the Parts. The specified page will becomes the active one.
	 * Appropriate events are fired.
	 * This is the programatic counterpart of selecting a page in the UI.
	 * If the provided page is null, do nothing.
	 * 
	 * @param page
	 *        The page to select or null.
	 */
	protected void selectPage(PagePart page) {
		if(page == null)
			return;
		TabFolderPart folder = page.getParent();
		folder.setActiveEditor(page);
	}

	/**
	 * Select the specified page in the Parts. The specified page will becomes the active one.
	 * Appropriate events are fired.
	 * This is the programatic counterpart of selecting a page in the UI.
	 * If the provided page is null, do nothing.
	 * 
	 * @param page
	 *        The page to select or null. The IPage should
	 *        be an instance previously returned by the SashContainer.
	 */
	public void selectPage(IPage page) {
		if(page == null)
			return;

		// check if we are a correct instance.
		if(!(page instanceof PagePart))
			return;

		selectPage((PagePart)page);
	}

	/**
	 * Lookup the {@link IPage} used to render the specified rawModel.
	 * 
	 * @param rawModel
	 *        The model for which the IPage is requested.
	 *        If the model is not rendered, return null;
	 * 
	 * @return The corresponding IPage or null if not found.
	 */
	public IPage lookupModelPage(Object rawModel) {
		// Use a visitor to lookup the first IPage
		LookupModelPageVisitor visitor = new LookupModelPageVisitor(rawModel);
		rootPart.visit(visitor);
		return visitor.result();
	}

	/**
	 * Check if the oldActivePage still alive, and set it if needed.
	 * If the oldActivePage is null, set an active page if one exist.
	 * If the oldActivePage still alive, let it as the active one. If it is
	 * disposed, get arbitrarily an active page if one exist.
	 * 
	 * @param oldActivePage
	 * @param partLists
	 * @param garbageMaps
	 * @return A valid active page or null if none exists.
	 */
	private PagePart checkAndGetActivePage(PagePart oldActivePage, PartLists partLists) {

		// Check if there is a created page
		PagePart activePage = partLists.getFirstCreatedPage();
		if(activePage != null)
			return activePage;

		// Check oldActivePage validity (in case it has been deleted)
		if(oldActivePage != null && !(oldActivePage.isOrphaned() || oldActivePage.isUnchecked()))
			return oldActivePage;

		// Get an active page if any
		return lookupFirstValidPage();
	}

	/**
	 * Lookup for a valid active Page. Return null if none is found.
	 * TODO Use a visitor to implements this method.
	 * 
	 * @return
	 */
	private PagePart lookupFirstValidPage() {
		// First get a list of active editors
		PartLists garbageMaps = new PartLists();
		rootPart.fillPartMap(garbageMaps);
		return garbageMaps.getFirstValidPage();
	}

	/**
	 * Show the status of the different Tiles composing the sash system.
	 * Used for debug purpose.
	 */
	public void showTilesStatus() {
		ShowPartStatusVisitor visitor = new ShowPartStatusVisitor();
		rootPart.visit(visitor);
	}


	/**
	 * Visit all the Pages (IEditorPage and IComponentPage), allowing to access to the public interface.
	 */
	public void visit(IPageVisitor pageVisitor) {
		PageVisitorWrapper visitor = new PageVisitorWrapper(pageVisitor);
		rootPart.visit(visitor);
	}


	/* ***************************************************** */
	/* Drag and Drop methods */
	/* ***************************************************** */

	/**
	 * 
	 */
	private void initDrag(Composite container) {
		DragUtil.addDragTarget(container, dragOverListener);

	}

	IDragOverListener dragOverListener = new IDragOverListener() {

		/**
		 * 
		 * @see org.eclipse.ui.internal.dnd.IDragOverListener#drag(org.eclipse.swt.widgets.Control, java.lang.Object, org.eclipse.swt.graphics.Point,
		 *      org.eclipse.swt.graphics.Rectangle)
		 */
		public IDropTarget drag(Control currentControl, Object draggedObject, Point position, Rectangle dragRectangle) {
			// TODO remove the cast by changing the method. Only folder can be source and target
			final TabFolderPart sourcePart = (TabFolderPart)rootPart.findPart(draggedObject); // (ITilePart) draggedObject;
			// Compute src tab index
			// TODO move that and previous in the sender of drag event. Use a class containing both as draggedObject.
			final int srcTabIndex = PTabFolder.getDraggedObjectTabIndex(draggedObject);

			System.out.println("drag to position=" + position);
			Rectangle containerDisplayBounds = DragUtil.getDisplayBounds(container);
			AbstractPanelPart targetPart = null;

			// Check if the cursor is inside the container
			if(containerDisplayBounds.contains(position)) {

				if(rootPart != null) {
					targetPart = (AbstractPanelPart)rootPart.findPart(position);
					// System.out.println("targetPart=" + targetPart
					// + ", position=" + position
					// + "container.toControl(position)=" + container.toControl(position));
				}

				if(targetPart != null) {
					final Control targetControl = targetPart.getControl();

					@SuppressWarnings("restriction")
					final Rectangle targetBounds = DragUtil.getDisplayBounds(targetControl);

					int side = Geometry.getClosestSide(targetBounds, position);
					int distance = Geometry.getDistanceFromEdge(targetBounds, position, side);

					// Reserve the 5 pixels around the edge of the part for the drop-on-edge cursor
					// Check if the target can handle the drop.
					if(distance >= 5) {
						// Otherwise, ask the part if it has any special meaning for this drop location
						// TODO remove cast; change return type of findPart()
						IDropTarget target = targetPart.getDropTarget(draggedObject, (TabFolderPart)sourcePart, position);
						if(target != null) {
							return target;
						}
					} else {
						// We are on the boarder, try to drop on the parent 
						// Warning : the parent could be the rootPart
						System.out.println("DropTarget near the border");
					}
					//                     
					if(distance > 30) {
						side = SWT.CENTER;
					}
					//                     
					// // If the part doesn't want to override this drop location then drop on the edge
					//                     
					// // A "pointless drop" would be one that will put the dragged object back where it started.
					// // Note that it should be perfectly valid to drag an object back to where it came from -- however,
					// // the drop should be ignored.
					//
					@SuppressWarnings("unused")
					boolean pointlessDrop = false;

					if(sourcePart == targetPart) {
						pointlessDrop = true;
					}

					return createDropTarget(sourcePart, srcTabIndex, side, side, targetPart);
				}
			} else {
				// Cursor is outside the container
				System.out.println("Outside container bounds");
				// This will be used to create a new Window.
				// We only allow dropping into a stack, not creating one
				// if (differentWindows)
				// return null;

				int side = Geometry.getClosestSide(containerDisplayBounds, position);

				boolean pointlessDrop = false;
				int cursor = Geometry.getOppositeSide(side);

				if(pointlessDrop) {
					side = SWT.NONE;
				}

				return createDropTarget(sourcePart, srcTabIndex, side, cursor, null);
			}
			return null;
		}

	};

	/**
	 * Create the drop target
	 */
	private DropTarget createDropTarget(final TabFolderPart sourcePart, int srcTabIndex, int side, int cursor, AbstractPart targetPart) {
		if(dropTarget == null) {
			dropTarget = new DropTarget(sourcePart, srcTabIndex, side, cursor, targetPart);
		} else {
			dropTarget.setTarget(sourcePart, srcTabIndex, side, cursor, targetPart);
		}
		return dropTarget;
	}

	/**
	 * Class implementing methods required by drop targets.
	 */
	protected class DropTarget implements IDropTarget {

		int count = 0;

		int cursor = SWT.TOP;

		private int side;

		private AbstractPanelPart targetPart;

		private int srcTabIndex;

		private TabFolderPart sourcePart;

		/**
		 * Constructor.
		 */
		public DropTarget(TabFolderPart sourcePart, int srcTabIndex, int cursor, int side, AbstractPart targetPart) {
			this.cursor = cursor;
			this.side = side;
			this.sourcePart = sourcePart;
			this.srcTabIndex = srcTabIndex;
			this.targetPart = (AbstractPanelPart)targetPart;
		}

		public void setTarget(TabFolderPart sourcePart, int srcTabIndex, int cursor, int side, AbstractPart targetPart) {
			this.cursor = cursor;
			this.side = side;
			this.sourcePart = sourcePart;
			this.srcTabIndex = srcTabIndex;
			this.targetPart = (AbstractPanelPart)targetPart;
		}

		/**
		 * A folder is dropped.
		 * 
		 * @see org.eclipse.ui.internal.dnd.IDropTarget#drop()
		 */
		public void drop() {
			// @TODO remove next cast
			if(side == SWT.CENTER) { // Add to target folder
				contentProvider.movePage(sourcePart.getPartModel(), srcTabIndex, ((TabFolderPart)targetPart).getPartModel(), -1);
			} else { // Create a new folder
				contentProvider.createFolder(sourcePart.getPartModel(), srcTabIndex, ((TabFolderPart)targetPart).getPartModel(), side);
			}
		}

		/**
		 * Return the cursor used during drag.
		 * 
		 * @see org.eclipse.ui.internal.dnd.IDropTarget#getCursor()
		 */
		public Cursor getCursor() {
			System.out.println(SashWindowsContainer.this.getClass().getSimpleName() + ".getCursor()-" + count++);
			return DragCursors.getCursor(DragCursors.positionToDragCursor(cursor));

		}

		public Rectangle getSnapRectangle() {
			System.out.println(SashWindowsContainer.this.getClass().getSimpleName() + ".getSnapRectangle(" + "sourcePart=" + sourcePart + ", targetPart=" + targetPart + ", side=" + side);
			Rectangle targetDisplayBounds;

			if(targetPart != null) {
				targetDisplayBounds = DragUtil.getDisplayBounds(targetPart.getControl());
			} else {
				// targetBounds = DragUtil.getDisplayBounds(getParent());
				targetDisplayBounds = DragUtil.getDisplayBounds(container);
			}

			if(side == SWT.CENTER || side == SWT.NONE) {
				return targetDisplayBounds;
			}

			int distance = Geometry.getDimension(targetDisplayBounds, !Geometry.isHorizontal(side));

			return Geometry.getExtrudedEdge(targetDisplayBounds, (int)(distance * getDockingRatio(sourcePart, targetPart)), side);
		}

		protected float getDockingRatio(AbstractPart dragged, AbstractPart target) {
			return 0.5f;
		}

	}

	/**
	 * Add a listener on pageChanged event.
	 * This implementation delegates to the internal PageTracker.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.editor.ISashWindowsContainer#addPageChangedListener(org.eclipse.papyrus.sasheditor.editor.IPageChangedListener)
	 * @param pageChangedListener
	 * 
	 */
	public void addPageChangedListener(IPageChangedListener pageChangedListener) {
		activePageTracker.addPageChangedListener(pageChangedListener);
	}

	/**
	 * Remove a listener on pageChanged event.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.editor.ISashWindowsContainer#removePageChangedListener(org.eclipse.papyrus.sasheditor.editor.IPageChangedListener)
	 * @param pageChangedListener
	 * 
	 */
	public void removePageChangedListener(IPageChangedListener pageChangedListener) {
		activePageTracker.removePageChangedListener(pageChangedListener);
	}


}
