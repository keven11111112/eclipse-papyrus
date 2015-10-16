
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
 * <p>Java class for map-Key complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="map-Key"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}std-String"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "map-Key", propOrder = {

})
public class MapKey
    implements Locatable
{

    @XmlElement(name = "std-String", required = true)
    protected StdString stdString;
    @XmlLocation
    @XmlTransient
    protected Locator locator;

    /**
     * Gets the value of the stdString property.
     * 
     * @return
     *     possible object is
     *     {@link StdString }
     *     
     */
    public StdString getStdString() {
        return stdString;
    }

    /**
     * Sets the value of the stdString property.
     * 
     * @param value
     *     allowed object is
     *     {@link StdString }
     *     
     */
    public void setStdString(StdString value) {
        this.stdString = value;
    }

    public Locator sourceLocation() {
        return locator;
    }

    public void setSourceLocation(Locator newLocator) {
        locator = newLocator;
    }

}
