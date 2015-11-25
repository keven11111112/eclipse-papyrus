
package org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import com.sun.xml.bind.Locatable;
import com.sun.xml.bind.annotation.XmlLocation;
import org.xml.sax.Locator;


/**
 * <p>Java class for map-Entry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="map-Entry"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}map-Key"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}map-Value"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "map-Entry", propOrder = {
    "mapKey",
    "mapValue"
})
public class MapEntry
    implements Locatable
{

    @XmlElement(name = "map-Key", required = true)
    protected MapKey mapKey;
    @XmlElement(name = "map-Value", required = true)
    protected MapValue mapValue;
    @XmlLocation
    @XmlTransient
    protected Locator locator;

    /**
     * Gets the value of the mapKey property.
     * 
     * @return
     *     possible object is
     *     {@link MapKey }
     *     
     */
    public MapKey getMapKey() {
        return mapKey;
    }

    /**
     * Sets the value of the mapKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link MapKey }
     *     
     */
    public void setMapKey(MapKey value) {
        this.mapKey = value;
    }

    /**
     * Gets the value of the mapValue property.
     * 
     * @return
     *     possible object is
     *     {@link MapValue }
     *     
     */
    public MapValue getMapValue() {
        return mapValue;
    }

    /**
     * Sets the value of the mapValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link MapValue }
     *     
     */
    public void setMapValue(MapValue value) {
        this.mapValue = value;
    }

    public Locator sourceLocation() {
        return locator;
    }

    public void setSourceLocation(Locator newLocator) {
        locator = newLocator;
    }

}
