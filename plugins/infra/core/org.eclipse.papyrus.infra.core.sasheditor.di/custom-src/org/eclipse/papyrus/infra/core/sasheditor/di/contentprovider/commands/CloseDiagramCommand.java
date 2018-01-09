package org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.utils.IPageUtils;
import org.eclipse.papyrus.infra.core.sasheditor.internal.SashWindowsContainer;

/**
 * A command to be used with the Eclipse Commands Framework.
 * This command is to be used with {@link SashWindowsContainer} implemented with the Di model.
 * This command allows to close the currently openened diagram.
 *
 * @author cedric dumoulin
 *
 */
public class CloseDiagramCommand extends AbstractHandler {

	/**
	 * Check if the Command is enabled.
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		setBaseEnabled(IPageUtils.canClose(new PageContext(evaluationContext).currentPage));
	}

	/**
	 * Execute the command. This method is called when the action is triggered.
	 *
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		PageContext context = new PageContext(event);

		if (context.isValid() && IPageUtils.canClose(context.currentPage)) {
			context.pageManager.closePage(context.currentPageIdentifier);
		}

		return null;
	}

}
