/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *      Thanh Liem PHAN (ALL4TEC) <thanhliem.phan@all4tec.net> - Bug 417095
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.export.image;

/**
 * Enumeration that is used to configure the image format.
 */
public enum ImageFormat {
	BMP, JPG, JPEG, PNG;

	private static final String BMP_EXT = "BMP"; //$NON-NLS-1$

	private static final String JPG_EXT = "JPG"; //$NON-NLS-1$

	private static final String JPEG_EXT = "JPEG"; //$NON-NLS-1$

	private static final String PNG_EXT = "PNG"; //$NON-NLS-1$

	private static final String BMP_FILTER_NAME = "BMP files (*.bmp)"; //$NON-NLS-1$

	private static final String JPG_FILTER_NAME = "JPG files (*.jpg)"; //$NON-NLS-1$

	private static final String JPEG_FILTER_NAME = "JPEG files (*.jpeg)"; //$NON-NLS-1$

	private static final String PNG_FILTER_NAME = "PNG files (*.png)"; //$NON-NLS-1$

	private static final String BMP_FILTER_EXT = "*.bmp"; //$NON-NLS-1$

	private static final String JPG_FILTER_EXT = "*.jpg"; //$NON-NLS-1$

	private static final String JPEG_FILTER_EXT = "*.jpeg"; //$NON-NLS-1$

	private static final String PNG_FILTER_EXT = "*.png"; //$NON-NLS-1$

	public static final String DEFAULT_IMAGE_NAME = "table_export.png"; //$NON-NLS-1$

	/** The list of all image extensions. */
	public static final String[] IMAGE_EXTENSION_LIST = { PNG_EXT, BMP_EXT, JPG_EXT, JPEG_EXT };

	/** The list of all image filter names. */
	public static final String[] IMAGE_FILTER_NAME_LIST = { PNG_FILTER_NAME, BMP_FILTER_NAME, JPG_FILTER_NAME, JPEG_FILTER_NAME };

	/** The list of all image filter extensions. */
	public static final String[] IMAGE_FILTER_EXTENSION_LIST = { PNG_FILTER_EXT, BMP_FILTER_EXT, JPG_FILTER_EXT, JPEG_FILTER_EXT };

	/**
	 * Return the corresponding filter extension string for a given image format.
	 *
	 * @param imageFormat
	 *            The image format
	 * @return The image file extenstion filter string
	 */
	public static String getImageFilterExtension(final ImageFormat imageFormat) {
		switch (imageFormat) {
		case BMP:
			return BMP_FILTER_EXT;
		case JPG:
			return JPG_FILTER_EXT;
		case JPEG:
			return JPEG_FILTER_EXT;
		case PNG:
			return PNG_FILTER_EXT;
		default:
			return null;
		}
	}

	/**
	 * @return The default image format string
	 */
	public static String getDefaultImageExtension() {
		return PNG_EXT;
	}

}
