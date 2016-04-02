/*
 * Copyright (c) 2012, 2015 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *    Christian W. Damus - adapt for Papyrus bundle tests (bug 440910)
 */
package org.eclipse.papyrus.bundles.tests.apireport;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.jar.Manifest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.TypeNameRequestor;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * A SAX XML handler that transforms the API report XML created by the
 * {@link APIReportGenerator} to an easy-to-read collapsible tree
 * presentation in HTML.
 */
public class API2HTML extends DefaultHandler {
	private static final String ANNOTATION = "annotation";

	private static final String ENUM = "enum";

	private static final String INTERFACE = "interface";

	private static final String CLASS = "class";

	private static final String PLUS = "plus.gif";

	private static final String MINUS = "minus.gif";

	private static final Pattern VERSION_CHANGED = Pattern.compile(
			"The ([^ ]+) version has been changed for the api component ([^ ]+) \\(from version ([^ ]+) to ([^ ]+)\\)");

	private int lastNodeID;

	private Category breaking = new Category("Breaking API Changes");

	private Category compatible = new Category("Compatible API Changes");

	private Category reexports = new Category("Re-Exported API Changes");

	private String buildQualifier;

	public API2HTML(File inputXML, String buildQualifier) throws Exception {
		this.buildQualifier = buildQualifier;

		try (InputStream in = new FileInputStream(inputXML)) {
			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
			parser.parse(in, this);
		}
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if ("delta".equalsIgnoreCase(qName)) {
			try {
				String componentVersion = null;
				String componentChange = null;

				String componentID = attributes.getValue("componentId");
				String typeName = attributes.getValue("type_name");
				String elementType = attributes.getValue("element_type");
				String kind = attributes.getValue("kind");
				String message = attributes.getValue("message");

				if (componentID == null || componentID.length() == 0) {
					if (message.startsWith("The API component ")) {
						componentID = message.substring("The API component ".length());
						componentID = componentID.substring(0, componentID.indexOf(' '));

						if (message.endsWith("added")) {
							componentChange = "The plugin has been added";
							componentVersion = readComponentVersion(componentID);
						} else if (message.endsWith("removed")) {
							componentChange = "The plugin has been removed";
						} else {
							System.out.println("No componentID: " + message);
							return;
						}
					}
				}

				if (componentChange == null && (typeName == null || typeName.length() == 0)) {
					Matcher matcher = VERSION_CHANGED.matcher(message);
					if (matcher.matches()) {
						componentChange = "The " + matcher.group(1) + " version has been changed from " + matcher.group(3) + " to "
								+ matcher.group(4);
					}
				}

				int pos = componentID.indexOf('(');
				if (pos != -1) {
					componentVersion = componentID.substring(pos + 1, componentID.length() - 1);
					componentID = componentID.substring(0, pos);
				}

				message = remove(message, typeName + ".");
				message = remove(message, " in an interface that is tagged with '@noimplement'");
				message = remove(message, " for interface " + typeName);
				message = remove(message, " for class " + typeName);
				if (!message.contains("modifier has been")) {
					message = remove(message, " to " + typeName);
				}

				if (message != null && message.startsWith("The deprecation modifiers has")) {
					message = "The deprecation modifier has" + message.substring("The deprecation modifiers has".length());
				}

				Category category;
				if (message.startsWith("The re-exported type")) {
					componentChange = message;
					category = reexports;
				} else {
					category = "true".equals(attributes.getValue("compatible")) ? compatible : breaking;
				}

				Map<String, Component> components = category.getComponents();

				Component component = components.get(componentID);
				if (component == null) {
					component = new Component(componentID);
					components.put(componentID, component);
				}

				if (componentVersion != null) {
					component.setComponentVersion(componentVersion);
				}

				if (componentChange != null) {
					component.getChanges().add(new Change(componentChange, kind));
				} else {
					if (typeName == null || typeName.length() == 0) {
						System.out.println("No typeName: " + message);
						return;
					}

					Type type = component.getTypes().get(typeName);
					if (type == null) {
						type = new Type(component, typeName);
						component.getTypes().put(typeName, type);
					}

					type.setElementType(elementType);
					type.getChanges().add(new Change(message, kind));
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	private String readComponentVersion(String componentID) throws Exception {
		String result = null;

		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(componentID);
		if ((project != null) && project.isAccessible()) {
			IFolder metaInf = project.getFolder("META-INF");
			if ((metaInf != null) && metaInf.isAccessible()) {
				IFile manifestFile = metaInf.getFile("MANIFEST.MF");
				if ((manifestFile != null) && manifestFile.isAccessible()) {
					try (InputStream in = manifestFile.getContents()) {
						Manifest manifest = new Manifest(in);
						java.util.jar.Attributes attributes = manifest.getMainAttributes();
						result = attributes.getValue("Bundle-Version");
					}
				}
			}
		}

		return result;
	}

	public void generate(File htmlFile) throws Exception {
		PrintStream out = new PrintStream(htmlFile);

		try {
			out.println("<!DOCTYPE HTML>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>API Evolution Report for Papyrus " + buildQualifier + "</title>");
			out.println("<link rel=stylesheet type='text/css' href='api.css'>");
			out.println("<base href='images/'>");
			out.println("<script type='text/javascript'>");
			out.println("  function toggle(id)");
			out.println("  {");
			out.println("    e = document.getElementById(id);");
			out.println("    e.style.display = (e.style.display == '' ? 'none' : '');");
			out.println("    img = document.getElementById('img_' + id);");
			out.println("    img.src = (e.style.display == 'none' ? '" + PLUS + "' : '" + MINUS + "');");
			out.println("  }");
			out.println("</script>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>API Evolution Report for Papyrus " + buildQualifier + "</h1>");

			breaking.generate(out, "");
			out.println("<p/>");
			compatible.generate(out, "");
			out.println("<p/>");
			reexports.generate(out, "");

			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
	}

	private List<String> sortedKeys(Map<String, ?> map) {
		List<String> list = new ArrayList<String>(map.keySet());
		Collections.sort(list);
		return list;
	}

	private String remove(String string, String remove) {
		if (string != null) {
			int pos = string.indexOf(remove);
			if (pos != -1) {
				string = string.substring(0, pos) + string.substring(pos + remove.length());
			}
		}

		return string;
	}

	public static void main(String[] args) throws Exception {
		new API2HTML(new File(args[0]), args[2]).generate(new File(args[1]));
	}

	/**
	 * @author Eike Stepper
	 */
	public static final class Version implements Comparable<Version> {
		private static final String SEPARATOR = ".";

		private int major = 0;

		private int minor = 0;

		private int micro = 0;

		public Version(String version) {
			StringTokenizer st = new StringTokenizer(version, SEPARATOR, true);
			major = Integer.parseInt(st.nextToken());

			if (st.hasMoreTokens()) {
				st.nextToken();
				minor = Integer.parseInt(st.nextToken());

				if (st.hasMoreTokens()) {
					st.nextToken();
					micro = Integer.parseInt(st.nextToken());
				}
			}
		}

		@Override
		public String toString() {
			return major + SEPARATOR + minor + SEPARATOR + micro;
		}

		@Override
		public int compareTo(Version o) {
			if (o == this) {
				return 0;
			}

			int result = major - o.major;
			if (result != 0) {
				return result;
			}

			result = minor - o.minor;
			if (result != 0) {
				return result;
			}

			result = micro - o.micro;
			if (result != 0) {
				return result;
			}

			return 0;
		}
	}

	/**
	 * @author Eike Stepper
	 */
	protected abstract class AbstractNode {
		private final String text;

		public AbstractNode(String text) {
			this.text = text;
		}

		public String getText() {
			return text.replaceAll("<", "&lt;").replaceAll("\"", "&quot;");
		}

		public String getIcon() {
			return "";
		}

		public void generate(PrintStream out, String indent) throws Exception {
			String href = getHref();
			out.print(indent + getIcon() + " " + (href != null ? "<a href='" + href + "' target='_blank'>" : "") + getText()
					+ (href != null ? "</a>" : ""));
		}

		protected String getHref() throws Exception {
			return null;
		}
	}

	/**
	 * @author Eike Stepper
	 */
	protected abstract class AbstractTreeNode extends AbstractNode {
		private int id;

		public AbstractTreeNode(String text) {
			super(text);
			id = ++lastNodeID;
		}

		@Override
		public void generate(PrintStream out, String indent) throws Exception {
			out.print(
					indent + "<div class='" + getClass().getSimpleName().toLowerCase() + "'><a href=\"javascript:toggle('node"
							+ id + "')\"><img src='" + (isCollapsed() ? PLUS : MINUS) + "' id='img_node" + id + "'></a>");
			super.generate(out, "");
			out.println("</div>");

			out.println(indent + "<div id=\"node" + id + "\" style='" + (isCollapsed() ? "display:none; " : "")
					+ "margin-left:20px;'>");

			generateChildren(out, indent + "  ");

			out.println(indent + "</div>");
		}

		protected abstract void generateChildren(PrintStream out, String indent) throws Exception;

		protected boolean isCollapsed() {
			return true;
		}
	}

	/**
	 * @author Eike Stepper
	 */
	private final class Category extends AbstractTreeNode {
		private final Map<String, Component> components = new HashMap<String, Component>();

		public Category(String text) {
			super(text);
		}

		public Map<String, Component> getComponents() {
			return components;
		}

		@Override
		protected void generateChildren(PrintStream out, String indent) throws Exception {
			if (components.isEmpty()) {
				out.println(indent + "<em>There are no " + getText().toLowerCase() + ".</em>");
			} else {
				for (String key : sortedKeys(components)) {
					Component component = components.get(key);
					component.generate(out, indent);
				}
			}
		}

		@Override
		protected boolean isCollapsed() {
			return false;
		}
	}

	/**
	 * @author Eike Stepper
	 */
	private final class Component extends AbstractTreeNode {
		private final List<Change> changes = new ArrayList<Change>();

		private final Map<String, Type> types = new HashMap<String, Type>();

		private Version componentVersion;

		public Component(String componentID) {
			super(componentID);
		}

		public String getComponentID() {
			return super.getText();
		}

		public void setComponentVersion(String componentVersion) {
			Version version = new Version(componentVersion);
			if (this.componentVersion == null || this.componentVersion.compareTo(version) < 0) {
				this.componentVersion = version;
			}
		}

		@Override
		public String getText() {
			String componentID = getComponentID();
			if (componentVersion != null) {
				componentID += "&nbsp;" + componentVersion;
			}

			return componentID;
		}

		@Override
		public String getIcon() {
			return "<img src='plugin.gif'>";
		}

		public List<Change> getChanges() {
			return changes;
		}

		public Map<String, Type> getTypes() {
			return types;
		}

		@Override
		protected void generateChildren(PrintStream out, String indent) throws Exception {
			for (Change change : changes) {
				change.generate(out, indent);
			}

			for (String key : sortedKeys(types)) {
				Type type = types.get(key);
				type.generate(out, indent);
			}
		}

		@Override
		protected String getHref() throws Exception {
			return null;
		}
	}

	/**
	 * @author Eike Stepper
	 */
	private final class Type extends AbstractTreeNode {
		private final List<Change> changes = new ArrayList<Change>();

		@SuppressWarnings("unused")
		private final Component component;

		private String elementType;

		public Type(Component component, String text) {
			super(text);
			this.component = component;
		}

		public String getTypeName() {
			return super.getText();
		}

		@Override
		public String getText() {
			String typeName = getTypeName();
			return typeName.replace('$', '.');
		}

		@Override
		public String getIcon() {
			try {
				return "<img src='" + getElementType() + ".gif'>";
			} catch (Exception ex) {
				return super.getIcon();
			}
		}

		public List<Change> getChanges() {
			return changes;
		}

		public void setElementType(String elementType) {
			if ("CLASS_ELEMENT_TYPE".equals(elementType)) {
				this.elementType = CLASS;
			} else if ("INTERFACE_ELEMENT_TYPE".equals(elementType)) {
				this.elementType = INTERFACE;
			} else if ("ENUM_ELEMENT_TYPE".equals(elementType)) {
				this.elementType = ENUM;
			} else if ("ANNOTATION_ELEMENT_TYPE".equals(elementType)) {
				this.elementType = ANNOTATION;
			}
		}

		public String getElementType() throws Exception {
			if (elementType == null) {
				String typeName = getTypeName();
				elementType = determineElementType(typeName);
			}

			return elementType;
		}

		@Override
		protected void generateChildren(PrintStream out, String indent) throws Exception {
			for (Change change : changes) {
				change.generate(out, indent);
			}
		}

		@Override
		protected String getHref() throws Exception {
			return null;
		}

		private String determineElementType(String typeName) throws MalformedURLException {
			final String[] result = { null };

			int lastDot = typeName.lastIndexOf('.');
			String packageName = typeName.substring(0, lastDot);
			typeName = typeName.substring(lastDot + 1).replace('$', '.');

			// This only finds top-level and nested type, not local or anonymous types.
			// But that's okay, because those are usually classes, anyways (anonymous
			// types always are)
			TypeNameRequestor requestor = new TypeNameRequestor() {
				@Override
				public void acceptType(int modifiers, char[] packageName, char[] simpleTypeName, char[][] enclosingTypeNames, String path) {
					// Only process the first match
					if (result[0] == null) {
						if (Flags.isAnnotation(modifiers)) {
							result[0] = ANNOTATION;
						} else if (Flags.isInterface(modifiers)) {
							result[0] = INTERFACE;
						} else if (Flags.isEnum(modifiers)) {
							result[0] = ENUM;
						} else {
							result[0] = CLASS;
						}
					}
				}
			};

			IJavaSearchScope scope = SearchEngine.createWorkspaceScope();
			SearchEngine engine = new SearchEngine();

			try {
				engine.searchAllTypeNames(packageName.toCharArray(), SearchPattern.R_EXACT_MATCH | SearchPattern.R_CASE_SENSITIVE,
						typeName.toCharArray(), SearchPattern.R_EXACT_MATCH | SearchPattern.R_CASE_SENSITIVE,
						IJavaSearchConstants.TYPE, scope,
						requestor,
						IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH, new NullProgressMonitor());
			} catch (JavaModelException e) {
				// No matter. We'll just assume it's a class
				result[0] = CLASS;
			}

			return (result[0] == null) ? CLASS : result[0];
		}
	}

	/**
	 * @author Eike Stepper
	 */
	private final class Change extends AbstractNode {
		private final String kind;

		public Change(String text, String kind) {
			super(text);
			if ("REMOVED".equals(kind)) {
				this.kind = "removal";
			} else if ("ADDED".equals(kind)) {
				this.kind = "addition";
			} else {
				this.kind = "change";
			}
		}

		@Override
		public String getIcon() {
			try {
				return "<img src='" + kind + ".gif'>";
			} catch (Exception ex) {
				return super.getIcon();
			}
		}

		@Override
		public void generate(PrintStream out, String indent) throws Exception {
			out.print(indent + "<img src='empty.gif'>");
			super.generate(out, "");
			out.println("<br>");
		}
	}
}
