/*******************************************************************************
 *  Copyright (c) 2015 ESEO, Christian W. Damus, and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Olivier Beaudoux - initial API and implementation
 *     Christian W. Damus - bug 476683
 *******************************************************************************/
package org.eclipse.papyrus.aof.core.impl;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IConstraints;
import org.eclipse.papyrus.aof.core.IMetaClass;
import org.eclipse.papyrus.aof.core.IUnaryFunction;

public class AOFMetaClass<C> extends BaseMetaClass<C> {

	private Class<C> javaClass;

	public AOFMetaClass(BaseFactory factory, Class<C> javaClass) {
		super(factory);

		this.javaClass = javaClass;
	}

	@Override
	protected C computeDefaultInstance() {
		try {
			return newInstance();
		} catch (Exception e) {
			return null;
		}
	}

	// IMetaClass

	@Override
	public boolean isInstance(Object object) {
		return javaClass.isInstance(object);
	}

	@Override
	public C newInstance() {
		try {
			return javaClass.newInstance();
		} catch (Exception e) {
			throw new IllegalStateException("Default constructor of class " + javaClass + " is not defined, or not accessible, or generates an exception", e);
		}
	}

	@Override
	public boolean isSubTypeOf(IMetaClass<?> that) {
		if (that instanceof AOFMetaClass<?>) {
			AOFMetaClass<?> thatAOFClass = (AOFMetaClass<?>) that;
			return thatAOFClass.javaClass.isAssignableFrom(this.javaClass);
		} else {
			// Can't be a subtype of a metaclass from a different platform
			return false;
		}
	}

	private HashMap<Object, IUnaryFunction<C, ? extends IBox<?>>> cache = new HashMap<Object, IUnaryFunction<C, ? extends IBox<?>>>();

	@Override
	public <B> IUnaryFunction<C, IBox<B>> getPropertyAccessor(Object property) {
		if (!cache.containsKey(property)) {
			if (property instanceof String) {
				PropertyDescriptor descriptor = null;
				try {
					for (PropertyDescriptor next : Introspector.getBeanInfo(javaClass).getPropertyDescriptors()) {
						if (next.getName().equals(property)) {
							descriptor = next;
							break;
						}
					}
				} catch (IntrospectionException e) {
				}
				if (descriptor == null) {
					throw new IllegalArgumentException("Property " + property + " not defined in class " + javaClass);
				} else {
					Class<?> type = descriptor.getPropertyType();
					if (type != null) {
						if (IBox.class.isAssignableFrom(type)) {
							cache.put(property, new PropertyAccessor<B>(descriptor.getReadMethod()));
						} else {
							cache.put(property, new PropertyAdapterAccessor<B>(descriptor));
						}
				} else {
						throw new IllegalArgumentException("Property " + property + " has no supported type");
					}
				}
			} else {
				throw new IllegalArgumentException("Property " + property + " must be defined as a Java String");
			}

		}
		return (IUnaryFunction<C, IBox<B>>)cache.get(property);
	}

	// Object

	@Override
	public String toString() {
		return javaClass.toString();
	}


	private class PropertyAccessor<B> implements IUnaryFunction<C, IBox<B>> {

		private Method readMethod;

		public PropertyAccessor(Method readMethod) {
			this.readMethod = readMethod;
		}

		@Override
		public IBox<B> apply(C object) {
			IBox<B> result = null;
			try {
				result = (IBox<B>) readMethod.invoke(object);
			} catch (IllegalAccessException e) {
				throw new IllegalArgumentException("cannot access property reader " + readMethod, e);
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException("cannot access property reader " + readMethod, e);
			} catch (InvocationTargetException e) {
				throw new IllegalArgumentException("cannot access property reader " + readMethod, e);
			}
			return result;
		}
	}

	private class PropertyAdapterAccessor<B> implements IUnaryFunction<C, IBox<B>> {

		private PropertyDescriptor descriptor;

		public PropertyAdapterAccessor(PropertyDescriptor descriptor) {
			this.descriptor = descriptor;
		}

		@Override
		public IBox<B> apply(C object) {
			IBox<B> result = null;

			if (java.util.Collection.class.isAssignableFrom(descriptor.getPropertyType())) {
				result = getCollectionBox(object, descriptor);
			} else {
				result = getOneBox(object, descriptor);
			}

			return result;
		}

		protected IBox<B> getOneBox(Object object, PropertyDescriptor descriptor) {
			return getFactory().createBox(IConstraints.ONE, new OneDelegate<B>(object, descriptor));
		}

		protected IBox<B> getCollectionBox(Object object, PropertyDescriptor descriptor) {
			IBox<B> result;

			final Class<?> type = descriptor.getPropertyType();

			if (java.util.Set.class.isAssignableFrom(type)) {
				IConstraints constraints;
				if (java.util.TreeSet.class.isAssignableFrom(type)
						|| java.util.LinkedHashSet.class.isAssignableFrom(type)) {
					constraints = IConstraints.ORDERED_SET;
				} else {
					constraints = IConstraints.SET;
			}
				result = getFactory().createBox(constraints,
						new CollectionDelegate<B>(object, descriptor));
			} else if (java.util.List.class.isAssignableFrom(type)) {
				result = getFactory().createBox(IConstraints.SEQUENCE,
						new SequenceDelegate<B>(object, descriptor));
			} else {
				result = getFactory().createBox(IConstraints.BAG,
						new CollectionDelegate<B>(object, descriptor));
			}

			return result;
		}
	}

	private static class OneDelegate<B> extends BaseDelegate.OneDelegate<B> {
		private final Object object;
		private final Method readMethod;
		private final Method writeMethod;
		private final B defaultValue;

		@SuppressWarnings("unchecked")
		OneDelegate(final Object object, final PropertyDescriptor property) {
			super();

			this.object = object;
			this.readMethod = property.getReadMethod();
			this.writeMethod = property.getWriteMethod();
			this.defaultValue = (B) getDefaultValue(property.getPropertyType());
		}

		@SuppressWarnings("unchecked")
		protected B read() {
			try {
				return (B) readMethod.invoke(object);
			} catch (IllegalAccessException e) {
				throw new IllegalArgumentException("cannot access property reader " + readMethod, e);
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException("cannot access property reader " + readMethod, e);
			} catch (InvocationTargetException e) {
				throw new IllegalArgumentException("cannot access property reader " + readMethod, e);
			}
		}
		
		protected void write(B element) {
			if (writeMethod == null) {
				throw new IllegalStateException("read-only property"); //$NON-NLS-1$
			}

			try {
				writeMethod.invoke(object, element);
			} catch (IllegalAccessException e) {
				throw new IllegalArgumentException("cannot access property writer " + writeMethod, e);
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException("cannot access property writer " + writeMethod, e);
			} catch (InvocationTargetException e) {
				throw new IllegalArgumentException("cannot access property writer " + writeMethod, e);
			}
		}

		@Override
		public final B getDefaultElement() {
			return defaultValue;
		}

	}
	
	private static class CollectionDelegate<B> extends BaseDelegate<B> {
		private final Object object;
		private final Method readMethod;

		CollectionDelegate(Object object, PropertyDescriptor property) {
			super();

			this.object = object;
			this.readMethod = property.getReadMethod();
		}

		@SuppressWarnings("unchecked")
		java.util.Collection<B> read() {
			try {
				return (java.util.Collection<B>) readMethod.invoke(object);
			} catch (IllegalAccessException e) {
				throw new IllegalArgumentException("cannot access property reader " + readMethod, e);
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException("cannot access property reader " + readMethod, e);
			} catch (InvocationTargetException e) {
				throw new IllegalArgumentException("cannot access property reader " + readMethod, e);
			}
		}

		@Override
		public int length() {
			return read().size();
		}
		
		@Override
		public Iterator<B> iterator() {
			return read().iterator();
		}

		@Override
		public B get(int index) {
			B result = null;
			
			Iterator<B> iter = iterator();
			for (int i = index; iter.hasNext() && i >= 0; i--) {
				result = iter.next();
			}
			
			return result;
		}

		@Override
		public void add(int index, B element) {
			java.util.Collection<B> collection = read();
			if (collection.add(element)) {
				fireAdded(collection.size() - 1, element);
			}
		}

		@Override
		public void remove(B element) {
			java.util.Collection<B> collection = read();
			if (collection.remove(element)) {
				fireRemoved(collection.size(), element);
			}
		}
		
		@Override
		public void removeAt(int index) {
			B removed = null;
			java.util.Collection<B> collection = read();
			Iterator<B> iter = collection.iterator();
			for (int i = index; iter.hasNext(); i--) {
				removed = iter.next();
				if (i <= 0) {
					iter.remove();
					break;
				}
			}
			fireRemoved(index, removed);
		}

		@Override
		public void set(int index, B element) {
			B removed = null;
			java.util.Collection<B> collection = read();
			Iterator<B> iter = collection.iterator();
			for (int i = index; iter.hasNext(); i--) {
				removed = iter.next();
				if (i <= 0) {
					iter.remove();
					break;
				}
			}
			if (collection.add(element)) {
				fireReplaced(index, element, removed);
			} else {
				// No duplicates, so this effectively did a removal
				fireRemoved(index, removed);
			}
		}

		@Override
		public void move(int newIndex, int oldIndex) {
			// Unordered collections cannot support this
			throw new UnsupportedOperationException("move"); //$NON-NLS-1$
		}
	}
	
	private static class SequenceDelegate<B> extends CollectionDelegate<B> {

		SequenceDelegate(Object object, PropertyDescriptor property) {
			super(object, property);
		}

		@Override
		public B get(int index) {
			return read().get(index);
		}

		List<B> read() {
			return (List<B>) super.read();
		}

		@Override
		public void add(int index, B element) {
			read().add(index, element);
			fireAdded(index, element);
		}

		@Override
		public void removeAt(int index) {
			B oldElement = read().remove(index);
			fireRemoved(index, oldElement);
		}

		@Override
		public void set(int index, B element) {
			B oldElement = get(0);

			if (!Objects.equals(oldElement, element)) {
				read().set(index, element);
				fireReplaced(index, element, oldElement);
			}
		}

		@Override
		public void move(int newIndex, int oldIndex) {
			List<B> list = read();
			B element = list.get(oldIndex);
			if (newIndex != oldIndex) {
				list.remove(oldIndex);
				list.add(newIndex, element);
				fireMoved(newIndex, oldIndex, element);
			}
		}

	}
	
	static Object getDefaultValue(Class<?> type) {
		Object result = null; // For non-primitives
		
		if (type.isPrimitive()) {
			if (type == boolean.class) {
				result = false;
			} else if (type == int.class) {
				result = 0;
			} else if (type == long.class) {
				result = 0L;
			} else if (type == float.class) {
				result = 0.0f;
			} else if (type == double.class) {
				result = 0.0d;
			} else if (type == byte.class) {
				result = (byte)0;
			} else if (type == char.class) {
				result = '\0';
			} else if (type == short.class) {
				result = (short)0;
			}
		}
		
		return result;
	}
}
