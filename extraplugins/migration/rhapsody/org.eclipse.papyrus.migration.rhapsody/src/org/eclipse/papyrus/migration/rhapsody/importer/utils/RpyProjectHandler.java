/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sebastien Revol (CEA LIST) sebastien.revol@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.migration.rhapsody.importer.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.widgets.util.FileUtil;
import org.eclipse.papyrus.migration.rhapsody.Activator;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFeature;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFeatureValue;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyFile;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyNode;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyNodeList;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyStringMap;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.RpyStringMapEntry;
import org.eclipse.papyrus.migration.rhapsody.parser.rpySyntax.SimpleValueList;
import org.eclipse.papyrus.migration.rhapsody.utils.RhapsodyShareFolderUtils;
import org.eclipse.papyrus.views.properties.storage.IContextStorageProvider.Null;

/**
 * @author sr246418
 *         Class allowing to easily parse Rhapsody projects.
 *         It can return a CST or an AST instance of the parsed files.
 */
public class RpyProjectHandler {

	private RpyFileHandler projectFile;

	public RpyFileHandler getProjectFile() {
		return projectFile;
	}

	private RpyFileHandler fileTable = null;
	private Map<String, RpyFileHandler> uriToHandler = new HashMap<String, RpyFileHandler>();
	private Map<Resource, RpyFileHandler> resourceToHandlerMap = new HashMap<Resource, RpyFileHandler>();
	private Map<String, String> aliasToPathMap = new HashMap<String, String>();

	private Map<String, RpyNode> idToProxyNode = new HashMap<String, RpyNode>();

	private Map<String, Object> sharedFilesMap = new HashMap<String, Object>();

	private List<String> predefinedTypesFileNames = new ArrayList<String>();

	private URI projectURI = null;
	private ResourceSet resSet;
	private URI rpyProjectFolderURI = null;



	private static final String RPY_SUFFIX = "_rpy";
	private static final String FILE_TABLE_NAME = "filesTable.dat";
	private static final String FILE_TABLE_FEATURE_NAME = "filesTable";
	private static final String OM_ROOT = "$OMROOT";



	// TODO : remove all these fields
	private static final String RHP_PROPERTY_PATH = "Properties";
	private static final String RHP_PROFILE_PATH = "Profiles";
	private static final String RHP_SETTINGS_PATH = "Settings";
	private static final String PREDEFINED_TYPES = "PredefinedTypes.sbs";
	private static final String PREDEFINED_TYPE_PREFIX = "PredefinedTypes";


	/**
	 * 
	 * Constructor.
	 *
	 * @param rpyFileURi
	 *            the URI of the file selected by the user (should be a uri like this : file:C:/...)
	 */
	// TODO : not yet used , not working yet
	public RpyProjectHandler(final URI rpyFileURi) {
		initializeExtensions();
		this.resSet = new ResourceSetImpl();
		this.projectURI = rpyFileURi;
		projectFile = getRpyFileHandler(projectURI.toFileString());

		String rpyFolder = projectURI.trimFileExtension().lastSegment() + RPY_SUFFIX;
		rpyProjectFolderURI = projectURI.trimSegments(1).appendSegment(rpyFolder).appendSegment("");
		loadFileTable();

		initializeSharedFileMap();
	}

	// TODO : replaced by an other constructor with URI
	public RpyProjectHandler(String rpyPath) {
		initializeExtensions();
		resSet = new ResourceSetImpl();
		projectURI = getNormalizedURI(rpyPath);

		projectFile = getRpyFileHandler(projectURI.toFileString());

		String rpyFolder = projectURI.trimFileExtension().lastSegment() + RPY_SUFFIX;
		rpyProjectFolderURI = projectURI.trimSegments(1).appendSegment(rpyFolder).appendSegment("");
		loadFileTable();

		initializeSharedFileMap();

	}

	/**
	 * 
	 */
	private void initializeExtensions() {


	}


	/**
	 * 
	 */
	private void initializeSharedFileMap() {
		String rhpHome = RhapsodyShareFolderUtils.getRhapsodyShareFolder();
		if (rhpHome != null) {
			File sharedFolder = new File(rhpHome);
			if (sharedFolder.exists() && sharedFolder.isDirectory()) {
				File profileFolder = new File(rhpHome + File.separator + RHP_PROFILE_PATH);
				scanSbsSharedFiles(profileFolder);
				File propertiesFolder = new File(rhpHome + File.separator + RHP_PROPERTY_PATH);
				scanSbsSharedFiles(propertiesFolder);
				File settingsFolder = new File(rhpHome + File.separator + RHP_SETTINGS_PATH);
				scanSbsSharedFiles(settingsFolder);
			}

		}

	}

	/**
	 * @param profileFolder
	 */
	private void scanSbsSharedFiles(File folder) {
		if (folder.exists() && folder.isDirectory()) {
			for (File sbsFile : FileUtils.listFiles(folder, new String[] { "sbs" }, true)) {
				sharedFilesMap.put(sbsFile.getName(), sbsFile.getAbsolutePath());
				if (sbsFile.getName().startsWith(PREDEFINED_TYPE_PREFIX)) {
					predefinedTypesFileNames.add(sbsFile.getName());
				}
			}
		}
	}

	/**
	 * 
	 */
	private void loadFileTable() {
		URI fileTableURI = rpyProjectFolderURI.appendSegment(FILE_TABLE_NAME);
		Resource fileTableRes = getResource(fileTableURI);
		if (fileTableRes != null && !fileTableRes.getContents().isEmpty()) {
			fileTable = new RpyFileHandler(fileTableRes, this);
			RpyFile rpyTableFile = fileTable.getRpyFile();

			if (rpyTableFile != null && !rpyTableFile.getContents().isEmpty() && rpyTableFile.getContents().get(0) instanceof RpyFeature) {
				RpyFeature rootFeature = (RpyFeature) rpyTableFile.getContents().get(0);

				if (FILE_TABLE_FEATURE_NAME.equals(rootFeature.getName()) && rootFeature.getValue() instanceof RpyNodeList) {
					RpyFeatureValue value = RpyUtil.getFeatureValue(rootFeature);

					if (value instanceof RpyStringMap) {

						for (RpyStringMapEntry entry : ((RpyStringMap) value).getEntries()) {
							if (!entry.getValue().isEmpty()) {
								// remark key and value are switched compared to what has been defined in the RpySyntax
								String entryValue = entry.getValue();
								aliasToPathMap.put(entryValue, entry.getKey());
								if (entryValue.contains(" ")) {
									aliasToPathMap.put(entryValue.replaceAll(" ", "_"), entry.getKey());
								}
							}
						}
					}
				}
			}
		}
	}



	private Resource getResource(URI uri) {
		// Activator.log.info(NLS.bind(Messages.ResourceLoading, uri.toFileString()));

		File resourceFile = new File(uri.toFileString());
		if (resourceFile.exists()) {
			return resSet.getResource(uri, true);
		} else {
			// Activator.log.info(NLS.bind(Messages.GenericFileNotFound, uri.toFileString()));
			return null;
		}
	}




	/**
	 * @param rpyPath
	 */
	public void loadSubFiles() {


		File rpyProjectFolder = new File(rpyProjectFolderURI.toFileString());

		if (rpyProjectFolder.exists() && rpyProjectFolder.isDirectory()) {

			for (File subFile : FileUtils.listFiles(rpyProjectFolder, null, true)) {
				URI subFileURI = getNormalizedURI(subFile.getAbsolutePath());

				if (RpyUtil.SUPPORTED_EXTENSIONS.contains(subFileURI.fileExtension())) {

					if (!FILE_TABLE_NAME.equals(subFileURI.lastSegment())) {
						uriToHandler.put(subFileURI.toFileString(), getRpyFileHandler(subFileURI.toFileString()));
					}
				} else {
					Activator.log.info(NLS.bind(Messages.IgnoredSubFile, subFileURI.toFileString()));
				}
			}
		}
	}




	private URI getNormalizedURI(String fileString) {
		// TODO : improve me
		if (fileString.startsWith(OM_ROOT)) {
			String rhpInstall = RhapsodyShareFolderUtils.getRhapsodyShareFolder();

			// trick to allow to found library. doesn't work without this change!
			rhpInstall = rhpInstall.replaceAll("\\\\", "\\\\\\\\");

			if (rhpInstall != null) {
				// Activator.log.info(NLS.bind(Messages.RhapsodyHome, rhpInstall));
				fileString = fileString.replaceAll("\\" + OM_ROOT, rhpInstall);

			} else {
				Activator.log.error(NLS.bind(Messages.RhpNotFound, fileString), null);
				return null;
			}

		}

		fileString = fileString.replaceAll("\\\\\\\\", "\\\\");
		fileString = fileString.replaceAll("//", "/");
		URI uri = URI.createFileURI(fileString);
		if (uri.isRelative()) {
			uri = uri.resolve(rpyProjectFolderURI);
		}


		return resSet.getURIConverter().normalize(uri);

	}

	public List<RpyFileHandler> getFiles() {
		List<RpyFileHandler> ret = new ArrayList<RpyFileHandler>();
		ret.add(projectFile);
		ret.addAll(uriToHandler.values());
		return ret;
	}


	public RpyFileHandler getOwningFileHandler(RpyNode node) {
		Resource nodeResource = node.eResource();
		return resourceToHandlerMap.get(nodeResource);
	}

	public RpyNode getSimpleFeatureReferencedNode(RpyFeature feature) {
		if (RpyUtil.isDirectReference(feature)) {
			String id = RpyUtil.getStringValue((SimpleValueList) feature.getValue());
			RpyNode owningNode = (RpyNode) feature.eContainer();
			if (owningNode != null) {
				RpyFileHandler owningHandler = getOwningFileHandler(owningNode);
				if (owningHandler != null) {
					return owningHandler.getNodeById(id);
				}
			}
		}
		return null;
	}

	public List<RpyNode> getNodes(RpyNodeList nodeList) {
		List<RpyNode> ret = new ArrayList<RpyNode>();
		for (RpyNode node : nodeList.getValues()) {
			if (RpyUtil.RAW_CONTAINER_NAME.equals(node.getName())) {
				RpyFeatureValue value = RpyUtil.getNodeFeatureValue(node, RpyUtil.RAW_CONTAINER_VALUE_FEATURE_NAME);
				if (value instanceof RpyNodeList) {
					ret.addAll(getNodes((RpyNodeList) value));
				}

			} else if (RpyUtil.isRpyIHandle(node)) {
				RpyNode referencedNode = getReferencedNodeFromIHandle(node);
				if (referencedNode != null) {
					ret.add(referencedNode);
				}
			} else if (RpyUtil.isElementRef(node)) {
				RpyNode referencedNode = getReferencedNodeFromElementRef(node);
				if (referencedNode != null) {
					ret.add(referencedNode);
				}
			} else {
				ret.add(node);
			}
		}

		return ret;
	}


	/**
	 * @param node
	 * @return
	 */
	private RpyNode getReferencedNodeFromElementRef(RpyNode node) {
		String referencedFileName = RpyUtil.getElementFileRef(node);
		if (referencedFileName != null) {
			if (referencedFileName.isEmpty()) {
				// the "fileName" attribute is an empty string, it is a reference in the current file
				return getReferencedNodeInFileHandler(node, resourceToHandlerMap.get(node.eResource()), true);
			} else {

				String persistAt = RpyUtil.getElementPersistAt(node);
				if (persistAt != null) {
					referencedFileName = persistAt + "/" + referencedFileName;
					if (!persistAt.startsWith(OM_ROOT)) {
						URI currentNodeURI;
						// if the reference is in the rpy file, the path is relative to the rpy_folder
						if (node.eResource() == projectFile.getRpyFile().eResource()) {
							currentNodeURI = rpyProjectFolderURI;
						} else {
							// else the pas is relative to the current file
							currentNodeURI = node.eResource().getURI();
						}
						currentNodeURI = currentNodeURI.trimSegments(1);
						referencedFileName = currentNodeURI.toFileString() + "/" + referencedFileName;
					}
				} else {
					URI currentNodeURI = node.eResource().getURI();
					String resourceURIString = currentNodeURI.toFileString();
					if (!resourceURIString.startsWith(projectFile.getRpyFile().eResource().getURI().trimSegments(1).toFileString())) {
						referencedFileName = currentNodeURI.trimSegments(1).toFileString() + File.separator + referencedFileName;
					}
				}
				RpyFileHandler handler = getRpyFileHandler(referencedFileName);
				if (handler == null) {
					String filePathWithWrongRef = node.eResource().getURI().toFileString();
					Activator.log.error(NLS.bind(Messages.FileNotFoundElementReference, new String[] { referencedFileName, RpyUtil.getNodeIndexInFile(node), filePathWithWrongRef }), null);
				} else {
					return getReferencedNodeInFileHandler(node, handler, true);
				}


			}
		}
		return null;
	}




	/**
	 * @param handlerNode
	 * @return
	 */
	private RpyNode getReferencedNodeFromIHandle(RpyNode handlerNode) {

		String id = RpyUtil.getReferencedID(handlerNode);

		// we first check is the referenced element is not a local proxy to previously not found element
		RpyNode proxy = idToProxyNode.get(id);
		if (proxy != null) {
			return proxy;
		}

		// we first look at the _filename attribute
		String filePath = RpyUtil.getIHandleFileRef(handlerNode);

		if (filePath == null) {
			filePath = "";
		}

		if (filePath.isEmpty()) {
			// if the _filename feature is an empty string, it can be either in the current file, or in the root project RpyFile
			RpyNode localNode = getReferencedNodeInFileHandler(handlerNode, resourceToHandlerMap.get(handlerNode.eResource()), false);
			if (localNode != null) {
				return localNode;
			} else {
				localNode = getReferencedNodeInFileHandler(handlerNode, projectFile, false);
				if (localNode != null) {
					return localNode;
				}
			}
		} else {

			RpyFileHandler fileHandler = getRpyFileHandler(filePath);

			if (fileHandler == null) {
				// it seems that in some projects, the elements with a given ID are in a language specific predefined types
				// even if the Handler is referencing the default PredefinedTypes file.
				if (PREDEFINED_TYPES.equals(filePath)) {
					RpyNode referencedNode = searchForIDInAllPredefinedTypes(handlerNode);
					if (referencedNode != null) {
						return referencedNode;
					}
				}
				// if not found in the rpy folder, we have to look in the Rhapsody Install folder.
				fileHandler = getRpySharedFile(filePath);


			}
			if (fileHandler == null) {
				Activator.log.info(NLS.bind(Messages.GenericFileNotFound, filePath));
			}
			if (fileHandler != null) {
				RpyNode referencedNode = getReferencedNodeInFileHandler(handlerNode, fileHandler, false);
				if (referencedNode != null) {
					// ok we got it!
					return referencedNode;
				}
			}
		}


		// here either fileHandler is null (didn't find the referenced filename), either we didn't find
		// the searched node in the referenced file.
		// First case can occur for files located in subfolders for instance, and the real path to file should be
		// found in the fileTable.dat
		// Second case occurs when the node is indeed in a "subfile" of the root referenced file. The fileTable.dat
		// should help here as well...

		String referencedSubsystem = RpyUtil.getReferencedSubsystemFromHandle(handlerNode);
		String referencedClass = RpyUtil.getReferencedClassFromHandle(handlerNode);
		String referencedName = RpyUtil.getReferencedNameFromHandle(handlerNode);
		List<String> namesToTry = new ArrayList<String>();
		String referencedQN = "";
		if (referencedSubsystem != null) {
			namesToTry.add(referencedSubsystem);
			referencedQN += referencedSubsystem;
		}
		if (referencedClass != null) {
			if (referencedSubsystem == null) {
				namesToTry.add(referencedClass);
			} else {
				referencedQN += "::" + referencedClass;
				namesToTry.add(referencedQN);
			}
		}
		if (referencedName != null) {
			if (referencedQN.isEmpty()) {
				namesToTry.add(referencedName);
			} else {
				referencedQN += "::" + referencedName;
				namesToTry.add(referencedQN);
			}
		}

		for (String nameToTry : namesToTry) {
			filePath = aliasToPathMap.get(nameToTry);
			if (filePath != null) {
				filePath = "../" + filePath;
				RpyFileHandler fileHandler = getRpyFileHandler(filePath);
				if (fileHandler != null) {
					RpyNode result = getReferencedNodeInFileHandler(handlerNode, fileHandler, false);
					if (result != null) {
						return result;
					}
				} else {
					logFileNodeFound(handlerNode, filePath);
				}
			}
		}
		// if we arrive here, we have not found the node with the fileTable.dat
		// we give-up


		// it occurs that many handler don't even have ID information
		// we only report issues for node references which have an ID.
		if (id != null) {
			String filePathWithWrongRef = handlerNode.eResource().getURI().toFileString();
			Activator.log.error(NLS.bind(Messages.IDNotFoundInHandleRefAndInFileTable,
					new String[] { RpyUtil.getReferencedID(handlerNode), RpyUtil.getIHandleFileRef(handlerNode), namesToTry.toString(), RpyUtil.getNodeIndexInFile(handlerNode), filePathWithWrongRef }), null);
		}

		proxy = RpyUtil.createProxyNodeFromHandler(handlerNode);
		if (proxy != null) {
			idToProxyNode.put(id, proxy);
		}
		return proxy;

	}



	/**
	 * @param node
	 * @return
	 */
	private RpyNode searchForIDInAllPredefinedTypes(RpyNode node) {
		for (String predefinedTypesFileName : predefinedTypesFileNames) {
			RpyFileHandler handler = getRpySharedFile(predefinedTypesFileName);
			if (handler != null) {
				RpyNode ret = getReferencedNodeInFileHandler(node, handler, false);
				if (ret != null) {
					return ret;
				}
			}
		}
		return null;
	}

	/**
	 * @param node
	 * @param filePath
	 */
	private void logFileNodeFound(RpyNode node, String filePath) {
		String filePathWithWrongRef = node.eResource().getURI().toFileString();
		Activator.log.error(NLS.bind(Messages.FileNotFoundHandleReference, new String[] { filePath, RpyUtil.getNodeIndexInFile(node), filePathWithWrongRef }), null);
	}

	/**
	 * @param finalReferencedFileName
	 * @return
	 */
	private RpyFileHandler getRpySharedFile(String finalReferencedFileName) {
		Object sharedFile = sharedFilesMap.get(finalReferencedFileName);
		if (sharedFile instanceof RpyFileHandler) {
			return (RpyFileHandler) sharedFile;
		} else if (sharedFile instanceof String) {
			RpyFileHandler handler = getRpyFileHandler((String) sharedFile);
			if (handler != null) {
				sharedFilesMap.put(finalReferencedFileName, handler);
			}
			return handler;
		} else {
			return null;
		}

	}

	/**
	 * @param referencedURI
	 * @return
	 */
	private RpyFileHandler getRpyFileHandler(String uriString) {
		boolean isExternal = uriString.startsWith(OM_ROOT);
		URI referencedURI = getNormalizedURI(uriString);
		if (referencedURI != null) {
			RpyFileHandler result = uriToHandler.get(referencedURI.toFileString());
			if (result == null) {
				Resource resource = getResource(referencedURI);
				if (resource != null) {
					result = new RpyFileHandler(resource, this);
					uriToHandler.put(referencedURI.toFileString(), result);
					resourceToHandlerMap.put(resource, result);
					if (isExternal) {
						sharedFilesMap.put(referencedURI.lastSegment(), result);
					}
				}
			}
			return result;
		}
		return null;

	}

	/**
	 * @param node
	 * @param handler
	 * @return
	 */
	private RpyNode getReferencedNodeInFileHandler(RpyNode node, RpyFileHandler handler, boolean log) {
		String id = RpyUtil.getReferencedID(node);
		RpyNode referencedNode = null;
		if (id != null) {
			referencedNode = handler.getNodeById(id);
		}
		if (referencedNode != null && RpyUtil.isElementRef(referencedNode)) {
			return getReferencedNodeFromElementRef(referencedNode);
		}
		if (referencedNode == null && log) {
			logIDNotFound(handler, node);
		}
		return referencedNode;
	}

	/**
	 * @param id
	 * @param handler
	 * @param node
	 */
	private void logIDNotFound(RpyFileHandler handler, RpyNode node) {
		String id = RpyUtil.getReferencedID(node);
		String filePathWithWrongRef = node.eResource().getURI().toFileString();
		Activator.log.error(NLS.bind(Messages.NotFoundIDReference, new String[] { id, handler.getRpyFile().eResource().getURI().toFileString(), RpyUtil.getNodeIndexInFile(node), filePathWithWrongRef }), null);
	}

	public Map<String, Object> getSharedFilesMap() {
		return sharedFilesMap;
	}

	public void setSharedFilesMap(Map<String, Object> sharedFilesMap) {
		this.sharedFilesMap = sharedFilesMap;
		if (sharedFilesMap.isEmpty()) {
			initializeSharedFileMap();
		} else {
			for (Object sharedFileObj : sharedFilesMap.values()) {
				if (sharedFileObj instanceof RpyFileHandler) {
					resourceToHandlerMap.put(((RpyFileHandler) sharedFileObj).getRpyFile().eResource(), (RpyFileHandler) sharedFileObj);
				}
			}
		}
	}

	public Collection<RpyNode> getAllProxies() {
		return idToProxyNode.values();
	}



}



