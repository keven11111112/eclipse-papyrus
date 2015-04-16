/**
 * Copyright (c) 2014 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.dd.dg.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemFontProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.eclipse.papyrus.dd.dg.util.DGAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * @generated
 */
public class DGItemProviderAdapterFactory extends DGAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {

	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public DGItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
		supportedTypes.add(IItemColorProvider.class);
		supportedTypes.add(IItemFontProvider.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.Canvas} instances.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CanvasItemProvider canvasItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.Canvas}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCanvasAdapter() {
		if (canvasItemProvider == null) {
			canvasItemProvider = new CanvasItemProvider(this);
		}

		return canvasItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.Group} instances.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected GroupItemProvider groupItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.Group}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGroupAdapter() {
		if (groupItemProvider == null) {
			groupItemProvider = new GroupItemProvider(this);
		}

		return groupItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.MoveTo} instances.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MoveToItemProvider moveToItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.MoveTo}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMoveToAdapter() {
		if (moveToItemProvider == null) {
			moveToItemProvider = new MoveToItemProvider(this);
		}

		return moveToItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.ClipPath} instances.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ClipPathItemProvider clipPathItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.ClipPath}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createClipPathAdapter() {
		if (clipPathItemProvider == null) {
			clipPathItemProvider = new ClipPathItemProvider(this);
		}

		return clipPathItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.Style} instances.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected StyleItemProvider styleItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.Style}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStyleAdapter() {
		if (styleItemProvider == null) {
			styleItemProvider = new StyleItemProvider(this);
		}

		return styleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.Paint} instances.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PaintItemProvider paintItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.Paint}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPaintAdapter() {
		if (paintItemProvider == null) {
			paintItemProvider = new PaintItemProvider(this);
		}

		return paintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.Circle} instances.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CircleItemProvider circleItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.Circle}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCircleAdapter() {
		if (circleItemProvider == null) {
			circleItemProvider = new CircleItemProvider(this);
		}

		return circleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.ClosePath} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ClosePathItemProvider closePathItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.ClosePath}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createClosePathAdapter() {
		if (closePathItemProvider == null) {
			closePathItemProvider = new ClosePathItemProvider(this);
		}

		return closePathItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.CubicCurveTo} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CubicCurveToItemProvider cubicCurveToItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.CubicCurveTo}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCubicCurveToAdapter() {
		if (cubicCurveToItemProvider == null) {
			cubicCurveToItemProvider = new CubicCurveToItemProvider(this);
		}

		return cubicCurveToItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.Definitions} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DefinitionsItemProvider definitionsItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.Definitions}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDefinitionsAdapter() {
		if (definitionsItemProvider == null) {
			definitionsItemProvider = new DefinitionsItemProvider(this);
		}

		return definitionsItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.StyleSheet} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected StyleSheetItemProvider styleSheetItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.StyleSheet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStyleSheetAdapter() {
		if (styleSheetItemProvider == null) {
			styleSheetItemProvider = new StyleSheetItemProvider(this);
		}

		return styleSheetItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.StyleRule} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected StyleRuleItemProvider styleRuleItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.StyleRule}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStyleRuleAdapter() {
		if (styleRuleItemProvider == null) {
			styleRuleItemProvider = new StyleRuleItemProvider(this);
		}

		return styleRuleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.StyleSelector} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected StyleSelectorItemProvider styleSelectorItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.StyleSelector}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStyleSelectorAdapter() {
		if (styleSelectorItemProvider == null) {
			styleSelectorItemProvider = new StyleSelectorItemProvider(this);
		}

		return styleSelectorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.Ellipse} instances.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EllipseItemProvider ellipseItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.Ellipse}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEllipseAdapter() {
		if (ellipseItemProvider == null) {
			ellipseItemProvider = new EllipseItemProvider(this);
		}

		return ellipseItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.EllipticalArcTo} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EllipticalArcToItemProvider ellipticalArcToItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.EllipticalArcTo}.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEllipticalArcToAdapter() {
		if (ellipticalArcToItemProvider == null) {
			ellipticalArcToItemProvider = new EllipticalArcToItemProvider(this);
		}

		return ellipticalArcToItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.QuadraticCurveTo} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected QuadraticCurveToItemProvider quadraticCurveToItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.QuadraticCurveTo}.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createQuadraticCurveToAdapter() {
		if (quadraticCurveToItemProvider == null) {
			quadraticCurveToItemProvider = new QuadraticCurveToItemProvider(this);
		}

		return quadraticCurveToItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.GradientStop} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected GradientStopItemProvider gradientStopItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.GradientStop}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGradientStopAdapter() {
		if (gradientStopItemProvider == null) {
			gradientStopItemProvider = new GradientStopItemProvider(this);
		}

		return gradientStopItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.Image} instances.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ImageItemProvider imageItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.Image}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createImageAdapter() {
		if (imageItemProvider == null) {
			imageItemProvider = new ImageItemProvider(this);
		}

		return imageItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.Line} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LineItemProvider lineItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.Line}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLineAdapter() {
		if (lineItemProvider == null) {
			lineItemProvider = new LineItemProvider(this);
		}

		return lineItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.Marker} instances.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MarkerItemProvider markerItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.Marker}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMarkerAdapter() {
		if (markerItemProvider == null) {
			markerItemProvider = new MarkerItemProvider(this);
		}

		return markerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.LinearGradient} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected LinearGradientItemProvider linearGradientItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.LinearGradient}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLinearGradientAdapter() {
		if (linearGradientItemProvider == null) {
			linearGradientItemProvider = new LinearGradientItemProvider(this);
		}

		return linearGradientItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.LineTo} instances.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected LineToItemProvider lineToItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.LineTo}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLineToAdapter() {
		if (lineToItemProvider == null) {
			lineToItemProvider = new LineToItemProvider(this);
		}

		return lineToItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.Matrix} instances.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MatrixItemProvider matrixItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.Matrix}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMatrixAdapter() {
		if (matrixItemProvider == null) {
			matrixItemProvider = new MatrixItemProvider(this);
		}

		return matrixItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.Path} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PathItemProvider pathItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.Path}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPathAdapter() {
		if (pathItemProvider == null) {
			pathItemProvider = new PathItemProvider(this);
		}

		return pathItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.Pattern} instances.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternItemProvider patternItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.Pattern}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPatternAdapter() {
		if (patternItemProvider == null) {
			patternItemProvider = new PatternItemProvider(this);
		}

		return patternItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.Polygon} instances.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PolygonItemProvider polygonItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.Polygon}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPolygonAdapter() {
		if (polygonItemProvider == null) {
			polygonItemProvider = new PolygonItemProvider(this);
		}

		return polygonItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.Polyline} instances.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PolylineItemProvider polylineItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.Polyline}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPolylineAdapter() {
		if (polylineItemProvider == null) {
			polylineItemProvider = new PolylineItemProvider(this);
		}

		return polylineItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.RadialGradient} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected RadialGradientItemProvider radialGradientItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.RadialGradient}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRadialGradientAdapter() {
		if (radialGradientItemProvider == null) {
			radialGradientItemProvider = new RadialGradientItemProvider(this);
		}

		return radialGradientItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.Rectangle} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected RectangleItemProvider rectangleItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.Rectangle}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRectangleAdapter() {
		if (rectangleItemProvider == null) {
			rectangleItemProvider = new RectangleItemProvider(this);
		}

		return rectangleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.RootCanvas} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected RootCanvasItemProvider rootCanvasItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.RootCanvas}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRootCanvasAdapter() {
		if (rootCanvasItemProvider == null) {
			rootCanvasItemProvider = new RootCanvasItemProvider(this);
		}

		return rootCanvasItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.Rotate} instances.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RotateItemProvider rotateItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.Rotate}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRotateAdapter() {
		if (rotateItemProvider == null) {
			rotateItemProvider = new RotateItemProvider(this);
		}

		return rotateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.Scale} instances.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ScaleItemProvider scaleItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.Scale}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createScaleAdapter() {
		if (scaleItemProvider == null) {
			scaleItemProvider = new ScaleItemProvider(this);
		}

		return scaleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.Skew} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SkewItemProvider skewItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.Skew}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSkewAdapter() {
		if (skewItemProvider == null) {
			skewItemProvider = new SkewItemProvider(this);
		}

		return skewItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.Text} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextItemProvider textItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.Text}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTextAdapter() {
		if (textItemProvider == null) {
			textItemProvider = new TextItemProvider(this);
		}

		return textItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.Translate} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TranslateItemProvider translateItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.Translate}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTranslateAdapter() {
		if (translateItemProvider == null) {
			translateItemProvider = new TranslateItemProvider(this);
		}

		return translateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.dd.dg.Use} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UseItemProvider useItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.dd.dg.Use}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createUseAdapter() {
		if (useItemProvider == null) {
			useItemProvider = new UseItemProvider(this);
		}

		return useItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void dispose() {
		if (canvasItemProvider != null) canvasItemProvider.dispose();
		if (groupItemProvider != null) groupItemProvider.dispose();
		if (moveToItemProvider != null) moveToItemProvider.dispose();
		if (clipPathItemProvider != null) clipPathItemProvider.dispose();
		if (styleItemProvider != null) styleItemProvider.dispose();
		if (paintItemProvider != null) paintItemProvider.dispose();
		if (circleItemProvider != null) circleItemProvider.dispose();
		if (closePathItemProvider != null) closePathItemProvider.dispose();
		if (cubicCurveToItemProvider != null) cubicCurveToItemProvider.dispose();
		if (definitionsItemProvider != null) definitionsItemProvider.dispose();
		if (styleSheetItemProvider != null) styleSheetItemProvider.dispose();
		if (styleRuleItemProvider != null) styleRuleItemProvider.dispose();
		if (styleSelectorItemProvider != null) styleSelectorItemProvider.dispose();
		if (ellipseItemProvider != null) ellipseItemProvider.dispose();
		if (ellipticalArcToItemProvider != null) ellipticalArcToItemProvider.dispose();
		if (quadraticCurveToItemProvider != null) quadraticCurveToItemProvider.dispose();
		if (gradientStopItemProvider != null) gradientStopItemProvider.dispose();
		if (imageItemProvider != null) imageItemProvider.dispose();
		if (lineItemProvider != null) lineItemProvider.dispose();
		if (markerItemProvider != null) markerItemProvider.dispose();
		if (linearGradientItemProvider != null) linearGradientItemProvider.dispose();
		if (lineToItemProvider != null) lineToItemProvider.dispose();
		if (matrixItemProvider != null) matrixItemProvider.dispose();
		if (pathItemProvider != null) pathItemProvider.dispose();
		if (patternItemProvider != null) patternItemProvider.dispose();
		if (polygonItemProvider != null) polygonItemProvider.dispose();
		if (polylineItemProvider != null) polylineItemProvider.dispose();
		if (radialGradientItemProvider != null) radialGradientItemProvider.dispose();
		if (rectangleItemProvider != null) rectangleItemProvider.dispose();
		if (rootCanvasItemProvider != null) rootCanvasItemProvider.dispose();
		if (rotateItemProvider != null) rotateItemProvider.dispose();
		if (scaleItemProvider != null) scaleItemProvider.dispose();
		if (skewItemProvider != null) skewItemProvider.dispose();
		if (textItemProvider != null) textItemProvider.dispose();
		if (translateItemProvider != null) translateItemProvider.dispose();
		if (useItemProvider != null) useItemProvider.dispose();
	}
}
