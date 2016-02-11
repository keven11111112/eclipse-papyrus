package org.eclipse.papyrus.eclipse.project.editors.interfaces;

import java.util.Set;

import org.w3c.dom.Document;

public interface IFeatureProjectEditor {

	void init();

	void save();

	void createFiles(final Set<String> files);

	/**
	 * Retrieves the feature.xml XML Document associated to this project.
	 *
	 * @return The XML Document associated to this feature.xml file
	 */
	Document getDocument();

	/**
	 * Gets the feature's id.
	 *
	 * @return the feature's id
	 */
	String getId();

	/**
	 * Gets the feature's label.
	 *
	 * @return the feature's label
	 */
	String getLabel();

	/**
	 * Gets the feature's version.
	 *
	 * @return the feature's version
	 */
	String getVersion();

	/**
	 * Gets the feature's provider name.
	 *
	 * @return the feature's provider name
	 */
	String getProviderName();

	/**
	 * Gets the operating system of the feature
	 * @return
	 */
	String getOS();

	String getWS();

	String getNL();

	String getArch();

	String getDescriptionText();

	String getDescriptionURL();

	String getCopyrightText();

	String getCopyrightURL();

	String getLicenseText();

	String getLicenceURL();

	void setId(final String id);

	void setLabel(final String label);

	void setVersion(final String version);

	void setProviderName(final String providerName);

	void setOS(final String os);

	void setWS(final String ws);

	void setNL(final String nl);

	void setArch(final String arch);

	void setDescription(final String descriptionURL, final String descriptionDesc);

	void setCopyright(final String copyrightURL, final String copyrightDesc);

	void setLicense(final String licenseURL, final String licenseDesc);

	void setUpdateURL(final String urlLabel, final String url);

	void addPlugin(final String pluginName);

	void addRequiredFeature(final String featureName, final String version);

	void addRequiredPlugin(String pluginName);

	void addInclude(String featureName, String version);

}
