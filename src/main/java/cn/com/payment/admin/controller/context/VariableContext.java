package cn.com.payment.admin.controller.context;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.InvalidPropertyException;

/**
 * Variable Context is a utility class that is used by the Binary Streaming classes
 * to navigate Variables using the Spring BeanWrapper to back the context.
 * 
 */
public class VariableContext implements Serializable {

	private static final long serialVersionUID = 1476635022003187535L;
	
	// ///////////////////////////////////////////////
	/** The bean wrapper. */
	// MOD-710 Made this transient, since BeanWrapperImpl is not serializable.
	// Instances of this class need to be serialized for passing 
	// the result of a query across projects.
	private transient BeanWrapper beanWrapper;
	
	private Object target = null;

	/**
	 * Instantiates a new execution context.
	 */
	public VariableContext() {
		setBeanWrapper(new BeanWrapperImpl(this));
	}

	public VariableContext(Object target) {
		setBeanWrapper(new BeanWrapperImpl(target));
		this.target = target;
	}

	/**
	 * Checks whether property of given name exists.
	 * 
	 * @param propertyName the property name
	 * 
	 * @return true, if successful
	 */
	public boolean contains(String variableName) {
		try {
			getBeanWrapper().getPropertyDescriptor(variableName);
			return true;
		} catch (InvalidPropertyException ipe) {
			return false;
		}
	}

	/**
	 * Checks whether property's key is mapped.
	 * 
	 * @param propertyName the property name
	 * 
	 * @return true, if successful
	 */
	public boolean containsKey(Object variableName) {
		return contains(String.valueOf(variableName));
	}

	/**
	 * Gets the property.
	 * 
	 * @param propertyName the property name
	 * 
	 * @return the property
	 */
	public Object get(String variableName) {
		return getBeanWrapper().getPropertyValue(variableName);
	}

	/**
	 * Sets the property.
	 * 
	 * @param propertyName the property name
	 * @param value the value
	 */
	public void set(String variableName, Object value) {
		getBeanWrapper().setPropertyValue(variableName, value);
	}

	/**
	 * Used to further implement Map interface.
	 * 
	 * @return
	 */
	public Set<String> keySet() {
		Set<String> result = new HashSet<String>();
		for (PropertyDescriptor prop : getBeanWrapper().getPropertyDescriptors()) {
			result.add(prop.getName());
		}
		return result;
	}

	private void setBeanWrapper(BeanWrapper beanWrapper) {
		this.beanWrapper = beanWrapper;
	}

	private BeanWrapper getBeanWrapper() {
		if (beanWrapper == null) {
			// beanWrapper was set to null during serialization
			if (target == null) {
				beanWrapper = new BeanWrapperImpl(this);
			} else {
				beanWrapper = new BeanWrapperImpl(target);
			}
		}
		return beanWrapper;
	}
}