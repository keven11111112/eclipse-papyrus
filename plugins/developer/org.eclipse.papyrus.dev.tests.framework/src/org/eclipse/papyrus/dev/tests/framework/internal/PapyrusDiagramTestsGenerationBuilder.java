/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.dev.tests.framework.internal;

import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IDebugEventSetListener;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.Launch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.ILocalVariable;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.IVMRunner;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.VMRunnerConfiguration;

import com.google.common.base.Strings;

/**
 * A project builder that generates the diagram tests, if and only if the tests framework
 * project is currently open.
 */
public class PapyrusDiagramTestsGenerationBuilder extends IncrementalProjectBuilder {
	public static final String BUILDER_ID = "org.eclipse.papyrus.dev.tests.framework.builder"; //$NON-NLS-1$

	private static final String FRAMEWORK_PROJECT = "org.eclipse.papyrus.tests.framework"; //$NON-NLS-1$

	public PapyrusDiagramTestsGenerationBuilder() {
		super();
	}

	@Override
	protected void clean(IProgressMonitor monitor) throws CoreException {
		IJavaProject javaProject = JavaCore.create(getProject());

		if (javaProject != null) {
			IFolder testGen = findTestGen(javaProject);
			SubMonitor subMonitor = SubMonitor.convert(monitor, "Deleting generated tests", 51);
			deleteSources(testGen, subMonitor.newChild(50));
			testGen.refreshLocal(IResource.DEPTH_INFINITE, subMonitor.newChild(1));
		}
	}

	@Override
	protected IProject[] build(int kind, Map<String, String> args, IProgressMonitor monitor) throws CoreException {
		IJavaProject javaProject = JavaCore.create(getProject());

		if (javaProject != null) {
			IVMInstall vm = JavaRuntime.getVMInstall(javaProject);
			if (vm == null) {
				throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "No JVM configured for project " + getProject().getName()));
			}
			IVMRunner runner = vm.getVMRunner(ILaunchManager.RUN_MODE);
			if (runner == null) {
				throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Cannot get JVM runner for project " + getProject().getName()));
			}
			String[] classpath = JavaRuntime.computeDefaultRuntimeClassPath(javaProject);
			if (classpath == null) {
				throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Cannot determine classpath for project " + getProject().getName()));
			}

			SubMonitor subMonitor;
			IFolder testGen = findTestGen(javaProject);
			switch (kind) {
			case FULL_BUILD:
				// This build requires the tests framework project
				IProject framework = getProject().getWorkspace().getRoot().getProject(FRAMEWORK_PROJECT);
				if ((framework == null) || !framework.isAccessible()) {
					break;
				}

				subMonitor = SubMonitor.convert(monitor, "Generating tests", IProgressMonitor.UNKNOWN);
				VMRunnerConfiguration config = new VMRunnerConfiguration(getWorkflowClassName(javaProject), classpath);
				config.setWorkingDirectory(getProject().getLocation().toOSString());
				ILaunch launch = new Launch(null, ILaunchManager.RUN_MODE, null);
				runner.run(config, launch, null);
				IProcess[] processes = launch.getProcesses();
				if (processes.length > 0) {
					final Semaphore termination = new Semaphore(0);
					final IProcess generator = processes[0];

					IDebugEventSetListener debugListener = new IDebugEventSetListener() {

						@Override
						public void handleDebugEvents(DebugEvent[] events) {
							for (DebugEvent next : events) {
								if (next.getSource() == generator) {
									if (next.getKind() == DebugEvent.TERMINATE) {
										// Done
										termination.release();
									}
								}
							}

						}
					};

					DebugPlugin.getDefault().addDebugEventListener(debugListener);
					if (generator.isTerminated()) {
						termination.release(); // In case we missed the event
					}

					try {
						termination.tryAcquire(5L, TimeUnit.MINUTES);

						// Kick an incremental build to compile the new sources
						new Job("Build generated sources in project " + getProject().getName()) {

							@Override
							protected IStatus run(IProgressMonitor monitor) {
								IStatus result = Status.OK_STATUS;

								try {
									getProject().build(AUTO_BUILD, monitor);
								} catch (CoreException e) {
									result = e.getStatus();
								}

								return result;
							}
						}.schedule();
					} catch (Exception e) {
						throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Test code generation timed out in project " + getProject().getName()));
					} finally {
						DebugPlugin.getDefault().removeDebugEventListener(debugListener);
						testGen.refreshLocal(IResource.DEPTH_INFINITE, subMonitor);
					}
				}
				break;
			}
		}

		return null;
	}

	protected String getWorkflowClassName(IJavaProject javaProject) throws CoreException {
		String result = null;

		out: for (IPackageFragment packageFragment : javaProject.getPackageFragments()) {
			for (ICompilationUnit cu : packageFragment.getCompilationUnits()) {
				if (Strings.nullToEmpty(cu.getElementName()).endsWith("Workflow.java")) {
					IType type = cu.findPrimaryType();
					if (type != null) {
						for (IMethod method : type.getMethods()) {
							if (Flags.isStatic(method.getFlags())) {
								for (ILocalVariable param : method.getParameters()) {
									if ("GenerateTestsWorkflow".equals(Signature.getSignatureSimpleName(param.getTypeSignature()))) {
										result = type.getFullyQualifiedName();
										break out;
									}
								}
							}
						}
					}
				}
			}
		}

		if (result == null) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Unable to determine codegen workflow for project " + getProject().getName()));
		}

		return result;
	}

	protected IFolder findTestGen(IJavaProject javaProject) throws CoreException {
		IFolder result = null;

		for (IPackageFragmentRoot next : javaProject.getPackageFragmentRoots()) {
			if (!next.isReadOnly() && !next.isExternal() && !next.isArchive()) {
				IResource resource = next.getCorrespondingResource();
				if ((resource != null) && (resource.getType() == IResource.FOLDER)
						&& ("test-gen".equals(resource.getName()))) {

					result = (IFolder) resource;
					break;
				}
			}
		}

		return result;
	}

	protected void deleteSources(IFolder srcFolder, IProgressMonitor monitor) throws CoreException {
		IResource[] members = srcFolder.members();
		SubMonitor sub = SubMonitor.convert(monitor, members.length);

		for (IResource next : members) {
			switch (next.getType()) {
			case IResource.FILE:
				if (isJavaFile(next)) {
					next.delete(true, sub.newChild(1));
				} else {
					sub.worked(1);
				}
				break;
			case IResource.FOLDER:
				SubMonitor nested = sub.newChild(51);
				IFolder folder = (IFolder) next;
				deleteSources(folder, nested.newChild(50));
				if (folder.members().length == 0) {
					folder.delete(true, nested.newChild(1));
				}

				nested.done();
				break;
			}
		}

		sub.done();
	}

	protected boolean isJavaFile(IResource file) {
		return "java".equals(file.getProjectRelativePath().getFileExtension());
	}
}
