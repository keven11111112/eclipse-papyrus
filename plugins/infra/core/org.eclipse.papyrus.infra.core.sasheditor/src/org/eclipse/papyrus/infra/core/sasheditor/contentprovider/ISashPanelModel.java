package org.eclipse.papyrus.infra.core.sasheditor.contentprovider;

import java.util.List;

import org.eclipse.papyrus.infra.core.sasheditor.internal.SashWindowsContainer;

/**
 * This is the model for a Sash widget. A Sash contains two children (of type Sash or Folder)
 * separated by a sash. The sash can be moved, resizing the children.
 * This interface is used to specify that a sash with two children should be drawn.
 *
 * @author cedric dumoulin
 *
 */
public interface ISashPanelModel extends IAbstractPanelModel {

	/**
	 * Get the list of children that should be displayed in the folder.
	 * Children can be Panel (ie Sash or Folder)
	 *
	 * @return
	 */
	public List</* Panel */?> getChildren();

	/**
	 * Create the Interface used to access the real model.
	 * This method is called by the {@link SashWindowsContainer} to get the interface.
	 * The method is called only once for a given object.
	 *
	 * @param child
	 *            A child representing a panel and returned by getChildren().
	 * @return
	 */
	public IAbstractPanelModel createChildSashModel(/* Panel */Object child);

	/**
	 * Get the sash direction. Can be SWT.VERTICAL or SWT.HORIZONTAL.
	 */
	public int getSashDirection();

	/**
	 * Get the initial position of the Sash, in percent. This position is used to set the sash when a new part is created.
	 * The value is betwenn 1 and 100 (percent).
	 * A value of 0 mean that the sash should separate both part equaly (in the middle)
	 * 
	 * @return A value between 0 and 100. 
	 * 
	 * @since 2.0
	 */
	
	public int getSashInitialPosition();
}
