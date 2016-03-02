package org.eclipse.papyrus.requirements.reqif.util;

import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

public class EqualityHelperWithoutContainment extends HashMap<EObject, EObject>
{
	private static final long serialVersionUID = 1L;

	/**
	 * Returns whether <code>eObject1</code> and <code>eObject2</code> are {@link EqualityHelper equal}
	 * in the context of this helper instance.
	 * @return whether <code>eObject1</code> and <code>eObject2</code> are equal.
	 * @since 2.1.0
	 */
	public boolean equals(EObject eObject1, EObject eObject2)
	{
		// If the first object is null, the second object must be null.
		//
		if (eObject1 == null)
		{
			return eObject2 == null;
		}

		// We know the first object isn't null, so if the second one is, it can't be equal.
		//
		if (eObject2 == null)
		{
			return false;
		}

		// Both eObject1 and eObject2 are not null.
		// If eObject1 has been compared already...
		//
		Object eObject1MappedValue = get(eObject1);
		if (eObject1MappedValue != null)
		{
			// Then eObject2 must be that previous match.
			//
			return eObject1MappedValue == eObject2;
		}

		// If eObject2 has been compared already...
		//
		Object eObject2MappedValue = get(eObject2);
		if (eObject2MappedValue != null)
		{
			// Then eObject1 must be that match.
			//
			return eObject2MappedValue == eObject1;
		}

		// Neither eObject1 nor eObject2 have been compared yet.

		// If eObject1 and eObject2 are the same instance...
		//
		if (eObject1 == eObject2)
		{ 
			// Match them and return true.
			//
			put(eObject1, eObject2);
			put(eObject2, eObject1);
			return true;
		}

		// If eObject1 is a proxy...
		//  
		if (eObject1.eIsProxy())
		{
			// Then the other object must be a proxy with the same URI.
			//
			if (((InternalEObject)eObject1).eProxyURI().equals(((InternalEObject)eObject2).eProxyURI()))
			{
				put(eObject1, eObject2);
				put(eObject2, eObject1);
				return true;
			}
			else
			{
				return false;
			}
		}
		// If eObject1 isn't a proxy but eObject2 is, they can't be equal.
		//
		else if (eObject2.eIsProxy())
		{
			return false;
		}

		// If they don't have the same class, they can't be equal.
		//
		EClass eClass = eObject1.eClass();
		if (eClass != eObject2.eClass())
		{
			return false;
		}

		// Assume from now on that they match.
		//
		put(eObject1, eObject2);
		put(eObject2, eObject1);

		// Check all the values.
		//
		for (int i = 0, size = eClass.getFeatureCount(); i < size; ++i)
		{
			// Ignore derived features.
			//
			EStructuralFeature feature = eClass.getEStructuralFeature(i);
			if (!feature.isDerived())
			{
				if( feature instanceof EReference){
					if(! ((EReference)feature).isContainment()){
						if (!haveEqualFeature(eObject1, eObject2, feature))
						{
							remove(eObject1);
							remove(eObject2);
							return false;
						}
					}
				}
				else{

					if (!haveEqualFeature(eObject1, eObject2, feature))
					{
						remove(eObject1);
						remove(eObject2);
						return false;
					}
				}
			}
		}

		// There's no reason they aren't equal, so they are.
		//
		return true;
	}

	/**
	 * Returns whether <code>list1</code> and <code>list2</code> contain 
	 * {@link #equals(EObject, EObject) equal} {@link EObject}s at the same index.
	 * It is assumed that list1 and list2 only contain EObjects.
	 * @return whether <code>list1</code> and <code>list2</code> contain equal objects.
	 * @since 2.1.0
	 */
	public boolean equals(List<EObject> list1, List<EObject> list2)
	{
		int size = list1.size();
		if (size != list2.size())
		{
			return false;
		}

		for (int i = 0; i < size; i++)
		{
			EObject eObject1 = list1.get(i);
			EObject eObject2 = list2.get(i);
			if (!equals(eObject1, eObject2))
			{
				return false;
			}
		}

		return true;
	}

	/**
	 * Returns whether the two objects have {@link EqualityHelper equal} 
	 * {@link EObject#eIsSet(EStructuralFeature) isSet} states and {@link EObject#eGet(EStructuralFeature) value}s for the feature.
	 * @return whether the two objects have equal isSet states and values for the feature.
	 * @since 2.2.0
	 * @see #equals(EObject, EObject)
	 * @see #equals(List, List)
	 */
	protected boolean haveEqualFeature(EObject eObject1, EObject eObject2, EStructuralFeature feature)
	{
		// If the set states are the same, and the values of the feature are the structurally equal, they are equal.
		//
		final boolean isSet1 = eObject1.eIsSet(feature);
		final boolean isSet2 = eObject2.eIsSet(feature);
		if (isSet1 && isSet2)
		{
			return 
					feature instanceof EReference ?
							haveEqualReference(eObject1, eObject2, (EReference)feature) :
								haveEqualAttribute(eObject1, eObject2, (EAttribute)feature);
		}
		else
		{
			return isSet1 == isSet2;
		}
	}

	/**
	 * Returns whether the two objects have {@link EqualityHelper equal} {@link EObject#eGet(EStructuralFeature) value}s for the reference.
	 * @return whether the two objects have equal values for the reference.
	 * @since 2.1.0
	 * @see #equals(EObject, EObject)
	 * @see #equals(List, List)
	 */
	@SuppressWarnings("unchecked")
	protected boolean haveEqualReference(EObject eObject1, EObject eObject2, EReference reference)
	{
		Object value1 = eObject1.eGet(reference);
		Object value2 = eObject2.eGet(reference);

		return 
				reference.isMany() ?
						equals((List<EObject>)value1, (List<EObject>)value2) :
							equals((EObject)value1, (EObject)value2);
	}


	/**
	 * Returns whether the two objects have {@link EqualityHelper equal} {@link EObject#eGet(EStructuralFeature) value}s for the attribute.
	 * @return whether the two objects have equal values for the attribute.
	 * @since 2.1.0
	 * @see #equalFeatureMaps(FeatureMap, FeatureMap)
	 */
	protected boolean haveEqualAttribute(EObject eObject1, EObject eObject2, EAttribute attribute)
	{
		Object value1 = eObject1.eGet(attribute);
		Object value2 = eObject2.eGet(attribute);

		// If the first value is null, the second value must be null.
		//
		if (value1 == null)
		{
			return value2 == null;
		}

		// Since the first value isn't null, if the second one is, they aren't equal.
		//
		if (value2 == null)
		{
			return false;
		}

		// If this is a feature map...
		//
		if (FeatureMapUtil.isFeatureMap(attribute))
		{
			// The feature maps must be equal.
			//
			FeatureMap featureMap1 = (FeatureMap)value1;
			FeatureMap featureMap2 = (FeatureMap)value2;
			return equalFeatureMaps(featureMap1, featureMap2);
		}
		else
		{
			// The values must be Java equal.
			//
			return equalValues(value1, value2);
		}
	}

	/**
	 * Returns whether value1 and value2 are structurally equal.
	 * The default implementation only checks for Java equality.
	 * @param value1 the first non-null value.
	 * @param value2 the second potentially null value.
	 * @return whether value1 and value2 are structurally equal.
	 * @since 2.10
	 */
	protected boolean equalValues(Object value1, Object value2)
	{
		return value1.equals(value2);
	}

	/**
	 * Returns whether the two feature maps are {@link EqualityHelper equal}.
	 * @return whether the two feature maps are equal.
	 * @since 2.1.0
	 */
	protected boolean equalFeatureMaps(FeatureMap featureMap1, FeatureMap featureMap2)
	{
		// If they don't have the same size, the feature maps aren't equal.
		//
		int size = featureMap1.size();
		if (size != featureMap2.size())
		{
			return false;
		}

		// Compare entries in order.
		//
		for (int i = 0; i < size; i++)
		{
			// If entries don't have the same feature, the feature maps aren't equal.
			//
			EStructuralFeature feature = featureMap1.getEStructuralFeature(i);
			if (feature != featureMap2.getEStructuralFeature(i))
			{
				return false;
			}

			Object value1 = featureMap1.getValue(i);
			Object value2 = featureMap2.getValue(i);

			if (!equalFeatureMapValues(value1, value2, feature))
			{
				return false;
			}
		}

		// There is no reason they aren't equals.
		//
		return true;
	}

	/**
	 * Returns whether the two values of a feature map are {@link EqualityHelper equal}.
	 * @return whether the two values of a feature map are equal.
	 * @since 2.2.0
	 */
	protected boolean equalFeatureMapValues(Object value1, Object value2, EStructuralFeature feature)
	{
		if (feature instanceof EReference)
		{
			// If the referenced EObjects aren't equal, the feature maps aren't equal.
			//
			return equals((EObject)value1, (EObject)value2);
		}
		else
		{
			// If the values aren't Java equal, the feature maps aren't equal.
			//
			return value1 == null ? value2 == null : equalValues(value1, value2);
		}
	}

} // EqualityHelper