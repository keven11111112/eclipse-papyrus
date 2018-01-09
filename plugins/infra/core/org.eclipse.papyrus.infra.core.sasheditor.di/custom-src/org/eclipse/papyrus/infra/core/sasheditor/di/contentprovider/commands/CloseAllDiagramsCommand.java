package org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.utils.IPageUtils;

/**
 * A command to be used with the Eclipse Commands Framework.
 * This command allows to close all diagrams openened in the current SashContainer implemented
 * on di.
 *
 * @author cedric dumoulin
 *
 */
public class CloseAllDiagramsCommand extends AbstractHandler {

	/**
	 * Check if the Command is enabled.
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		PageContext context = new PageContext(evaluationContext);
		setBaseEnabled((context.getOpenPageCount() > 0)
				&& context.getOpenPages().stream().allMatch(IPageUtils::canClose));
	}

	/**
	 * Execute the command. This method is called when the action is triggered.
	 *
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		PageContext context = new PageContext(event);
		if ((context.getOpenPageCount() > 0) && context.getOpenPages().stream().allMatch(IPageUtils::canClose)) {
			context.pageManager.closeAllOpenedPages();
		}

		return null;
	}

}
