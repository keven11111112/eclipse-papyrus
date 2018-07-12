/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.bundles.tests;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assume.assumeThat;

import java.io.File;
import java.util.Calendar;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.papyrus.bundles.tests.apireport.API2HTML;
import org.eclipse.papyrus.bundles.tests.apireport.APIReportGenerator;
import org.eclipse.papyrus.bundles.tests.apireport.ReportFixture;
import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.junit.utils.PrintingProgressMonitor;
import org.junit.Test;

/**
 * Pseudo-test cases that generate API reports.
 * 
 * @since 1.2
 */
public class APIReports extends AbstractPapyrusTest {

	/**
	 * System property name for the location of the API Baseline for calculation of
	 * the API delta report. The value must be an absolute path in the local filesystem.
	 * If this property is not specified, the {@link #apiDeltaReport()} pseudo-test is skipped.
	 */
	public static final String APIREPORT_BASELINE_PROPERTY = "apireport.baseline"; //$NON-NLS-1$

	/**
	 * System property name for the location of the API delta report to generate.
	 * The value must be an absolute path in the local filesystem. If this property
	 * is not specified, the report will be generated in the current working directory.
	 */
	public static final String APIREPORT_OUTPUT_DIR_PROPERTY = "apireport.outputdir"; //$NON-NLS-1$

	/**
	 * System property name for a boolean indicating whether to log verbose progress
	 * of the API report generation to stdout.
	 */
	public static final String APIREPORT_VERBOSE = "apireport.verbose"; //$NON-NLS-1$

	/**
	 * Constructor.
	 *
	 */
	public APIReports() {
		super();
	}

	/**
	 * Run the API change analysis report, if the baseline is provided by the
	 * {@linkplain #APIREPORT_BASELINE_PROPERTY system property}.
	 */
	@Test
	public void apiDeltaReport() throws Exception {
		String baseline = System.getProperty(APIREPORT_BASELINE_PROPERTY, "");
		assumeThat("No API baseline specified via -D" + APIREPORT_BASELINE_PROPERTY, baseline, not(""));

		File baselineLocation = new File(baseline);
		IPath outputDir = new Path(System.getProperty(APIREPORT_OUTPUT_DIR_PROPERTY, System.getProperty("user.dir")));

		// Generate the report XML
		ReportFixture fixture = new ReportFixture(outputDir);

		PrintingProgressMonitor progress = new PrintingProgressMonitor();
		if (!Boolean.getBoolean(APIREPORT_VERBOSE)) {
			progress = progress.filter("^\\s+add");
		}
		new APIReportGenerator(baselineLocation, fixture.getXMLReportFile()).generate(progress);

		// And the HTML from that
		Calendar today = Calendar.getInstance();
		String qualifier = String.format("v%04d%02d%02d-%02d%02d%02d",
				today.get(Calendar.YEAR), today.get(Calendar.MONTH) + 1, today.get(Calendar.DATE),
				today.get(Calendar.HOUR_OF_DAY), today.get(Calendar.MINUTE), today.get(Calendar.SECOND));
		new API2HTML(fixture.getXMLReportFile(), qualifier).generate(fixture.getHTMLReportFile());
	}

}
