
package org.eclipse.papyrus.uml.nattable.stereotype.display.manager.axis;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.papyrus.infra.emf.nattable.manager.axis.EObjectTreeAxisManagerForEventList;
import org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManagerForEventList;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.ITreeItemAxis;

public class NotationTreeTableAxisManager extends EObjectTreeAxisManagerForEventList
		implements IAxisManagerForEventList {

	public NotationTreeTableAxisManager() {

	}


	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractTreeAxisManagerForEventList#fillChildrenForSemanticElement(org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.ITreeItemAxis)
	 *
	 * @param axis
	 */
	@Override
	protected void fillChildrenForSemanticElement(ITreeItemAxis axis) {

		super.fillChildrenForSemanticElement(axis);
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractTreeAxisManagerForEventList#fillChildrenForTreeFillingConfiguration(org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.ITreeItemAxis)
	 *
	 * @param axis
	 */
	@Override
	protected void fillChildrenForTreeFillingConfiguration(ITreeItemAxis axis) {
		// CEJ Auto-generated method stub
		super.fillChildrenForTreeFillingConfiguration(axis);
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractTreeAxisManagerForEventList#fillListWithGrandSon(org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.ITreeItemAxis)
	 *
	 * @param element
	 */
	@Override
	public void fillListWithGrandSon(ITreeItemAxis element) {

		super.fillListWithGrandSon(element);
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractTreeAxisManagerForEventList#fillListWithRoots()
	 *
	 */
	@Override
	public void fillListWithRoots() {

		super.fillListWithRoots();
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractTreeAxisManagerForEventList#isAlreadyManaged(java.lang.Object)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public boolean isAlreadyManaged(Object object) {

		return super.isAlreadyManaged(object);
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractTreeAxisManagerForEventList#updateManagedList(java.util.List, java.util.List)
	 *
	 * @param toAdd
	 * @param toRemove
	 */
	@Override
	protected void updateManagedList(List<Object> toAdd, List<Object> toRemove) {

		super.updateManagedList(toAdd, toRemove);
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractTreeAxisManagerForEventList#fillListWithChildren(org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.ITreeItemAxis)
	 *
	 * @param parentAxis
	 */
	@Override
	public void fillListWithChildren(ITreeItemAxis parentAxis) {

		super.fillListWithChildren(parentAxis);
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractTreeAxisManagerForEventList#manageSetNotification(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	protected void manageSetNotification(Notification notification) {

		super.manageSetNotification(notification);
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractTreeAxisManagerForEventList#manageUnsetNotification(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	protected void manageUnsetNotification(Notification notification) {

		super.manageUnsetNotification(notification);
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractTreeAxisManagerForEventList#manageAddITreeItemAxisForSemanticElement(org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.ITreeItemAxis)
	 *
	 * @param axis
	 */
	@Override
	protected void manageAddITreeItemAxisForSemanticElement(ITreeItemAxis axis) {

		super.manageAddITreeItemAxisForSemanticElement(axis);
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractTreeAxisManagerForEventList#manageAddNotification(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	protected void manageAddNotification(Notification notification) {
		// CEJ Auto-generated method stub
		super.manageAddNotification(notification);
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractTreeAxisManagerForEventList#manageAddManyNotification(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	protected void manageAddManyNotification(Notification notification) {
		// CEJ Auto-generated method stub
		super.manageAddManyNotification(notification);
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractTreeAxisManagerForEventList#manageMoveNotification(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	protected void manageMoveNotification(Notification notification) {
		// CEJ Auto-generated method stub
		super.manageMoveNotification(notification);
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractTreeAxisManagerForEventList#manageRemoveITreeItemAxisForSemanticElement(org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.ITreeItemAxis)
	 *
	 * @param axis
	 */
	@Override
	protected void manageRemoveITreeItemAxisForSemanticElement(ITreeItemAxis axis) {
		// CEJ Auto-generated method stub
		super.manageRemoveITreeItemAxisForSemanticElement(axis);
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractTreeAxisManagerForEventList#manageRemoveNotification(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	protected void manageRemoveNotification(Notification notification) {
		// CEJ Auto-generated method stub
		super.manageRemoveNotification(notification);
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractTreeAxisManagerForEventList#manageRemoveSemanticElement(java.lang.Object)
	 *
	 * @param object
	 */
	@Override
	protected void manageRemoveSemanticElement(Object object) {
		// CEJ Auto-generated method stub
		super.manageRemoveSemanticElement(object);
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractTreeAxisManagerForEventList#manageRemoveManyNotification(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	protected void manageRemoveManyNotification(Notification notification) {
		// CEJ Auto-generated method stub
		super.manageRemoveManyNotification(notification);
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractTreeAxisManagerForEventList#updateChildren(org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.ITreeItemAxis)
	 *
	 * @param semanticElementRepresentation
	 */
	@Override
	protected void updateChildren(ITreeItemAxis semanticElementRepresentation) {
		// CEJ Auto-generated method stub
		super.updateChildren(semanticElementRepresentation);
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractTreeAxisManagerForEventList#updateSemanticElement(java.lang.Object)
	 *
	 * @param semanticElement
	 */
	@Override
	protected void updateSemanticElement(Object semanticElement) {
		// CEJ Auto-generated method stub
		super.updateSemanticElement(semanticElement);
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractTreeAxisManagerForEventList#managedHideShowCategoriesForDepth(java.util.List, java.util.List)
	 *
	 * @param depthToHide
	 * @param depthToShow
	 */
	@Override
	public void managedHideShowCategoriesForDepth(List<Integer> depthToHide, List<Integer> depthToShow) {
		// CEJ Auto-generated method stub
		super.managedHideShowCategoriesForDepth(depthToHide, depthToShow);
	}


}
