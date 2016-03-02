package org.eclipse.papyrus.requirements.reqif.util;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.rmf.reqif10.AttributeDefinition;
import org.eclipse.rmf.reqif10.AttributeDefinitionBoolean;
import org.eclipse.rmf.reqif10.AttributeDefinitionEnumeration;
import org.eclipse.rmf.reqif10.AttributeDefinitionInteger;
import org.eclipse.rmf.reqif10.AttributeDefinitionReal;
import org.eclipse.rmf.reqif10.AttributeDefinitionString;
import org.eclipse.rmf.reqif10.AttributeDefinitionXHTML;
import org.eclipse.rmf.reqif10.AttributeValue;
import org.eclipse.rmf.reqif10.AttributeValueBoolean;
import org.eclipse.rmf.reqif10.AttributeValueEnumeration;
import org.eclipse.rmf.reqif10.AttributeValueInteger;
import org.eclipse.rmf.reqif10.AttributeValueReal;
import org.eclipse.rmf.reqif10.AttributeValueString;
import org.eclipse.rmf.reqif10.AttributeValueXHTML;
import org.eclipse.rmf.reqif10.SpecElementWithAttributes;
import org.eclipse.rmf.reqif10.SpecType;
import org.eclipse.rmf.reqif10.XhtmlContent;
import org.eclipse.rmf.reqif10.common.util.ReqIF10Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

public class ReqIFUtil {

	/**
	 * This static method generates the string representation of the given
	 * {@link XhtmlContent} and returns it.
	 * 
	 * @param xhtmlContent
	 *        , the ReqIF container that holds the xhtml content (See also:
	 *        {@link XhtmlContent})
	 * @return the string representation of the given {@link XhtmlContent} or
	 *         null if no root element exists.
	 * @throws IOException
	 */
	public static String getXmlOnlyString(XhtmlContent xhtmlContent) throws IOException {
		if(xhtmlContent.getXhtml() == null) {
			return "";
		}
		StringWriter str = new StringWriter();
		Map<Object, Object> options = new HashMap<Object, Object>();
		options.put(XMLResource.OPTION_DECLARE_XML, Boolean.FALSE);
		options.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.FALSE);
		options.put(XMLResource.OPTION_FORMATTED, Boolean.FALSE);
		options.put(XMLResource.OPTION_KEEP_DEFAULT_CONTENT, Boolean.FALSE);
		options.put(XMLResource.OPTION_ROOT_OBJECTS, Collections.singletonList(xhtmlContent.getXhtml()));
		// options.put(XMLResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.FALSE);
		// options.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE,
		// Boolean.FALSE);
		XMLResourceImpl ri = new XMLResourceImpl();
		ri.save(str, options);
		String out = str.toString();
		if(out.toLowerCase().contains("<html") || out.toLowerCase().contains("<xhtml")) {
			out = out.trim();
			out = out.replaceAll("</xhtml:XhtmlDivType>", "");
			out = out.replaceAll("<xhtml:XhtmlDivType xmlns:xhtml=\"http://www.w3.org/1999/xhtml\">", "");
			out = out.replaceAll("<xhtml:XhtmlDivType>", "");
		}
		return out.toString();
	}

	public static AttributeValue getAttributeValue(SpecElementWithAttributes specElement, AttributeDefinition attributeDefinition) {
		for(AttributeValue value : specElement.getValues()) {
			AttributeDefinition definition = ReqIF10Util.getAttributeDefinition(value);
			if(attributeDefinition.getLongName().equals(definition.getLongName())) {
				return value;
			}
		}
		// maybe it has a default value in the definition.
		if(attributeDefinition instanceof AttributeDefinitionEnumeration) {
			return ((AttributeDefinitionEnumeration)attributeDefinition).getDefaultValue();
		}
		// maybe it has a default value in the definition.
		if(attributeDefinition instanceof AttributeDefinitionBoolean) {
			return ((AttributeDefinitionBoolean)attributeDefinition).getDefaultValue();
		}
		// maybe it has a default value in the definition.
		if(attributeDefinition instanceof AttributeDefinitionInteger) {
			return ((AttributeDefinitionInteger)attributeDefinition).getDefaultValue();
		}
		// maybe it has a default value in the definition.
		if(attributeDefinition instanceof AttributeDefinitionReal) {
			return ((AttributeDefinitionReal)attributeDefinition).getDefaultValue();
		}
		// maybe it has a default value in the definition.
		if(attributeDefinition instanceof AttributeDefinitionString) {
			return ((AttributeDefinitionString)attributeDefinition).getDefaultValue();
		}
		// maybe it has a default value in the definition.
		if(attributeDefinition instanceof AttributeDefinitionXHTML) {
			return ((AttributeDefinitionXHTML)attributeDefinition).getDefaultValue();
		}
		return null;
	}

	/**
	 * fill properties of stereotypes form the SpecElementWithAttributes and the
	 * map of stereotypes
	 * 
	 * @param reqStereotypesMap
	 *        map of stereotypes (specificationType, SpecObjectTypes)
	 * @param specif
	 *        SpecElementWithAttributes that contains attributes
	 * @param umlElement
	 *        the UmlElement that is stereotypes and where properties will
	 *        be filled
	 * @param specType
	 *        the type of the SpecElementWithAttributes
	 */
	public static void importSpecAttributesValue(Stereotype reqStereotype, Element umlElement, SpecType specType, SpecElementWithAttributes specif) {
		if(specType != null) {
			for(AttributeDefinition attDefinition : specType.getSpecAttributes()) {
				AttributeValue att = ReqIFUtil.getAttributeValue(specif, attDefinition);
				if(att != null) {
					if(att instanceof AttributeValueString) {
						String attributeName = ((AttributeValueString)att).getDefinition().getLongName().trim();
						attributeName = getNormalName(attributeName);
						Property aProperty = getProperty(reqStereotype, attributeName);
						if(aProperty != null) {
							umlElement.setValue(reqStereotype, attributeName, ((AttributeValueString)att).getTheValue());
							if(attributeName.toLowerCase().equals("id")) {
								if(umlElement instanceof NamedElement) {
									((NamedElement)umlElement).setName(((AttributeValueString)att).getTheValue());
								}
							}
						}
					} else if(att instanceof AttributeValueBoolean) {
						String attributeName = ((AttributeValueBoolean)att).getDefinition().getLongName().trim();
						attributeName = getNormalName(attributeName);
						Property aProperty = getProperty(reqStereotype, attributeName);
						if(aProperty != null) {
							umlElement.setValue(reqStereotype, attributeName, ((AttributeValueBoolean)att).isTheValue());
						}
					} else if(att instanceof AttributeValueInteger) {
						String attributeName = ((AttributeValueInteger)att).getDefinition().getLongName().trim();
						attributeName = getNormalName(attributeName);
						Property aProperty = getProperty(reqStereotype, attributeName);
						if(aProperty != null) {
							umlElement.setValue(reqStereotype, attributeName, ((AttributeValueInteger)att).getTheValue().intValue());
						}
					} else if(att instanceof AttributeValueReal) {
						String attributeName = ((AttributeValueReal)att).getDefinition().getLongName().trim();
						attributeName = getNormalName(attributeName);
						Property aProperty = getProperty(reqStereotype, attributeName);
						if(aProperty != null) {
							umlElement.setValue(reqStereotype, attributeName, ((AttributeValueReal)att).getTheValue());
						}
					} else if(att instanceof AttributeValueEnumeration) {
						String attributeName = ((AttributeValueEnumeration)att).getDefinition().getLongName().trim();
						attributeName = getNormalName(attributeName);
						Property aProperty = getProperty(reqStereotype, attributeName);
						if(aProperty != null) {
							if(((AttributeValueEnumeration)att).getValues().size() > 0) {
								String EnumerationValue = getNormalName(((AttributeValueEnumeration)att).getValues().get(0).getLongName());
								// look for Enumeration literal
								Enumeration aEnumeration = null;
								// look for attribute
								Property referedAttribute = null;
								for(Property property : reqStereotype.getAllAttributes()) {
									if(property.getName().equals(attributeName)) {
										referedAttribute = property;
									}
								}
								aEnumeration = (Enumeration)referedAttribute.getType();
								EnumerationLiteral aEnumerationLiteral = null;
								for(EnumerationLiteral aLiteral : aEnumeration.getOwnedLiterals()) {
									if(EnumerationValue.equals(aLiteral.getName())) {
										aEnumerationLiteral = aLiteral;
									}
								}
								if(aEnumerationLiteral != null) {
									umlElement.setValue(reqStereotype, attributeName, aEnumerationLiteral);
								}
							}
						}
					} else if(att instanceof AttributeValueXHTML) {
						String attributeName = ((AttributeValueXHTML)att).getDefinition().getLongName().trim();
						attributeName = getNormalName(attributeName);
						Property aProperty = getProperty(reqStereotype, attributeName);
						if(aProperty != null) {
							if((((AttributeValueXHTML)att).getTheValue()) != null) {
								if((((AttributeValueXHTML)att).getTheValue().getXhtmlSource()) != null) {
									umlElement.setValue(reqStereotype, attributeName, ((AttributeValueXHTML)att).getTheValue().getXhtmlSource());
								} else {
									try {
										umlElement.setValue(reqStereotype, attributeName,
											// ProrXhtmlSimplifiedHelper.generateXMLString((((AttributeValueXHTML)att).getTheValue())));
											ReqIFUtil.getXmlOnlyString(((AttributeValueXHTML)att).getTheValue()));
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
							}
						}
					} else {
						// set Null value
						String attributeName = (attDefinition).getLongName().trim();
						attributeName = getNormalName(attributeName);
						Property aProperty = getProperty(reqStereotype, attributeName);
						if(aProperty != null) {
							umlElement.setValue(reqStereotype, attributeName, null);
						}
					}
				}
			}
		}
	}

	/**
	 * get the property from a stereotype
	 * 
	 * @param stereotype
	 * @param propertyName
	 * @return the property from a stereotype maybe null
	 */
	public static Property getProperty(Stereotype stereotype, String propertyName) {
		Property property = null;
		for(Property attribute : stereotype.getAllAttributes()) {
			if(attribute.getName().equals(propertyName)) {
				return attribute;
			}
		}
		return property;
	}

	/**
	 * transform a name that could be a anme without ' 'or '.'
	 * 
	 * @param attributeName
	 *        the string that will be transformed
	 * @return the normal String
	 */
	public static String getNormalName(String attributeName) {
		attributeName = attributeName.replace(' ', '_');
		attributeName = attributeName.replace('.', '_');
		return attributeName;
	}
}
