package org.eclipse.papyrus.uml.diagram.activity.helper;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IndirectMaskLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.Messages;
import org.eclipse.papyrus.uml.diagram.common.helper.StereotypedElementLabelHelper;
import org.eclipse.papyrus.uml.tools.utils.ICustomAppearance;
import org.eclipse.papyrus.uml.tools.utils.TypeUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Pin;
import org.eclipse.uml2.uml.TypedElement;

/**
 * Helper for labels displaying {@link Pin}
 */
public class PinLabelHelper extends StereotypedElementLabelHelper {

	private static PinLabelHelper labelHelper;

	private final Map<String, String> masks = new HashMap<String, String>();

	/**
	 * {@inheritDoc}
	 */
	public static PinLabelHelper getInstance() {
		if (labelHelper == null) {
			labelHelper = new PinLabelHelper();
		}
		return labelHelper;
	}


	private PinLabelHelper() {
		masks.put(ICustomAppearance.DISP_TYPE, Messages.ICustomAppearance_PIN_DISP_TYPE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String elementLabel(GraphicalEditPart editPart) {
		IMaskManagedLabelEditPolicy policy = (IMaskManagedLabelEditPolicy) editPart.getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);
		if (policy == null) {
			policy = (IMaskManagedLabelEditPolicy) editPart.getEditPolicy(IndirectMaskLabelEditPolicy.INDRIRECT_MASK_MANAGED_LABEL);
		}
		Collection<String> displayValue = Collections.emptySet();
		if (policy != null) {
			displayValue = policy.getCurrentDisplayValue();
		}
		NamedElement namedElement = getUMLElement(editPart);
		return namedElement != null ? getCustomLabel(namedElement, displayValue) : "";
	}

	/**
	 * {@inheritDoc}
	 */
	private String getCustomLabel(NamedElement namedElement, Collection<String> maskValues) {
		StringBuffer buffer = new StringBuffer();
		if (maskValues.contains(ICustomAppearance.DISP_NAME)) {
			buffer.append(" ");
			buffer.append(namedElement.getName()== null ? "" : namedElement.getName());
		}
		if (namedElement instanceof TypedElement) {
			if (maskValues.contains(ICustomAppearance.DISP_TYPE)) {
				if (((TypedElement) namedElement).getType() != null) {
					buffer.append(": " + ((TypedElement) namedElement).getType().getName());
				} else {
					buffer.append(": " + TypeUtil.UNDEFINED_TYPE_NAME);
				}
			}
		}
		return buffer.toString().trim();
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<String, String> getMasks() {
		return masks;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Pin getUMLElement(GraphicalEditPart editPart) {
		Element element = super.getUMLElement(editPart);
		return element instanceof Pin ? (Pin) element : null;
	}
}
