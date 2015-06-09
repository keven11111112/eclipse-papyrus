package org.eclipse.papyrus.uml.nattable.stereotype.display.manager.axis;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager;

public class StereotypeDisplayPropertiesAxisManager extends AbstractAxisManager {

	public StereotypeDisplayPropertiesAxisManager() {
		// CEJ Auto-generated constructor stub
	}

	@Override
	public boolean isSlave() {
		// CEJ Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDynamic() {

		return false;
	}

	@Override
	public boolean canDestroyAxisElement(Integer axisIndex) {

		return false;
	}

	@Override
	public Command getDestroyAxisElementCommand(TransactionalEditingDomain domain, Integer axisPosition) {
		// CEJ Auto-generated method stub
		return null;
	}

}
