package org.eclipse.papyrus.compare.ui.viewer.content;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.emf.compare.ui.ModelCompareInput;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeContentProvider;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.CompareTwoElementsDiffModel;


public class UMLModelContentMergeContentProvider extends ModelContentMergeContentProvider {

	public UMLModelContentMergeContentProvider(CompareConfiguration cc) {
		super(cc);
	}

	@Override
	public Object getLeftContent(Object element) {
		if(element instanceof ModelCompareInput) {
			// if we compared a complete resource set, we should display the different resources
			final Object diff = ((ModelCompareInput)element).getDiff();
			if(diff instanceof CompareTwoElementsDiffModel) {
				return new RootObject(((CompareTwoElementsDiffModel)diff).getLeftRoots().get(0));
			}
		}
		return super.getLeftContent(element);
	}

	@Override
	public Object getRightContent(Object element) {
		if(element instanceof ModelCompareInput) {
			// if we compared a complete resource set, we should display the different resources
			final Object diff = ((ModelCompareInput)element).getDiff();
			if(diff instanceof CompareTwoElementsDiffModel) {
				return new RootObject(((CompareTwoElementsDiffModel)diff).getRightRoots().get(0));
			}
		}
		return super.getRightContent(element);
	}

	public static class RootObject {

		public final Object object;

		public RootObject(Object object) {
			this.object = object;
		}
	}


}
