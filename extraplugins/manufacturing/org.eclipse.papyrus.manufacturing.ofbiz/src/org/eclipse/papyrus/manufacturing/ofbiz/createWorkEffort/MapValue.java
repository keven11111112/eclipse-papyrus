
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
 * <p>Java class for map-Value complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="map-Value"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}std-String"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}std-Integer"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}std-Long"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}std-Float"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}std-Double"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}std-Boolean"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}std-Locale"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}sql-Timestamp"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}sql-Date"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}sql-Time"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}col-ArrayList"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}col-LinkedList"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}col-Stack"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}col-Vector"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}col-TreeSet"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}col-HashSet"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}col-Collection"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}map-HashMap"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}map-Properties"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}map-Hashtable"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}map-WeakHashMap"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}map-TreeMap"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}map-Map"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}eepk-"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}eeval-"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}std-BigDecimal"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "map-Value", propOrder = {
    "stdString",
    "stdInteger",
    "stdLong",
    "stdFloat",
    "stdDouble",
    "stdBoolean",
    "stdLocale",
    "sqlTimestamp",
    "sqlDate",
    "sqlTime",
    "colArrayList",
    "colLinkedList",
    "colStack",
    "colVector",
    "colTreeSet",
    "colHashSet",
    "colCollection",
    "mapHashMap",
    "mapProperties",
    "mapHashtable",
    "mapWeakHashMap",
    "mapTreeMap",
    "mapMap",
    "eepk",
    "eeval",
    "stdBigDecimal"
})
public class MapValue
    implements Locatable
{

    @XmlElement(name = "std-String")
    protected StdString stdString;
    @XmlElement(name = "std-Integer")
    protected StdInteger stdInteger;
    @XmlElement(name = "std-Long")
    protected StdLong stdLong;
    @XmlElement(name = "std-Float")
    protected StdFloat stdFloat;
    @XmlElement(name = "std-Double")
    protected StdDouble stdDouble;
    @XmlElement(name = "std-Boolean")
    protected StdBoolean stdBoolean;
    @XmlElement(name = "std-Locale")
    protected StdLocale stdLocale;
    @XmlElement(name = "sql-Timestamp")
    protected SqlTimestamp sqlTimestamp;
    @XmlElement(name = "sql-Date")
    protected SqlDate sqlDate;
    @XmlElement(name = "sql-Time")
    protected SqlTime sqlTime;
    @XmlElement(name = "col-ArrayList")
    protected ColCollection colArrayList;
    @XmlElement(name = "col-LinkedList")
    protected ColCollection colLinkedList;
    @XmlElement(name = "col-Stack")
    protected ColCollection colStack;
    @XmlElement(name = "col-Vector")
    protected ColCollection colVector;
    @XmlElement(name = "col-TreeSet")
    protected ColCollection colTreeSet;
    @XmlElement(name = "col-HashSet")
    protected ColCollection colHashSet;
    @XmlElement(name = "col-Collection")
    protected ColCollection colCollection;
    @XmlElement(name = "map-HashMap")
    protected MapMap mapHashMap;
    @XmlElement(name = "map-Properties")
    protected MapMap mapProperties;
    @XmlElement(name = "map-Hashtable")
    protected MapMap mapHashtable;
    @XmlElement(name = "map-WeakHashMap")
    protected MapMap mapWeakHashMap;
    @XmlElement(name = "map-TreeMap")
    protected MapMap mapTreeMap;
    @XmlElement(name = "map-Map")
    protected MapMap mapMap;
    @XmlElement(name = "eepk-")
    protected MapMap eepk;
    @XmlElement(name = "eeval-")
    protected MapMap eeval;
    @XmlElement(name = "std-BigDecimal")
    protected StdBigDecimal stdBigDecimal;
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

    /**
     * Gets the value of the stdInteger property.
     * 
     * @return
     *     possible object is
     *     {@link StdInteger }
     *     
     */
    public StdInteger getStdInteger() {
        return stdInteger;
    }

    /**
     * Sets the value of the stdInteger property.
     * 
     * @param value
     *     allowed object is
     *     {@link StdInteger }
     *     
     */
    public void setStdInteger(StdInteger value) {
        this.stdInteger = value;
    }

    /**
     * Gets the value of the stdLong property.
     * 
     * @return
     *     possible object is
     *     {@link StdLong }
     *     
     */
    public StdLong getStdLong() {
        return stdLong;
    }

    /**
     * Sets the value of the stdLong property.
     * 
     * @param value
     *     allowed object is
     *     {@link StdLong }
     *     
     */
    public void setStdLong(StdLong value) {
        this.stdLong = value;
    }

    /**
     * Gets the value of the stdFloat property.
     * 
     * @return
     *     possible object is
     *     {@link StdFloat }
     *     
     */
    public StdFloat getStdFloat() {
        return stdFloat;
    }

    /**
     * Sets the value of the stdFloat property.
     * 
     * @param value
     *     allowed object is
     *     {@link StdFloat }
     *     
     */
    public void setStdFloat(StdFloat value) {
        this.stdFloat = value;
    }

    /**
     * Gets the value of the stdDouble property.
     * 
     * @return
     *     possible object is
     *     {@link StdDouble }
     *     
     */
    public StdDouble getStdDouble() {
        return stdDouble;
    }

    /**
     * Sets the value of the stdDouble property.
     * 
     * @param value
     *     allowed object is
     *     {@link StdDouble }
     *     
     */
    public void setStdDouble(StdDouble value) {
        this.stdDouble = value;
    }

    /**
     * Gets the value of the stdBoolean property.
     * 
     * @return
     *     possible object is
     *     {@link StdBoolean }
     *     
     */
    public StdBoolean getStdBoolean() {
        return stdBoolean;
    }

    /**
     * Sets the value of the stdBoolean property.
     * 
     * @param value
     *     allowed object is
     *     {@link StdBoolean }
     *     
     */
    public void setStdBoolean(StdBoolean value) {
        this.stdBoolean = value;
    }

    /**
     * Gets the value of the stdLocale property.
     * 
     * @return
     *     possible object is
     *     {@link StdLocale }
     *     
     */
    public StdLocale getStdLocale() {
        return stdLocale;
    }

    /**
     * Sets the value of the stdLocale property.
     * 
     * @param value
     *     allowed object is
     *     {@link StdLocale }
     *     
     */
    public void setStdLocale(StdLocale value) {
        this.stdLocale = value;
    }

    /**
     * Gets the value of the sqlTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link SqlTimestamp }
     *     
     */
    public SqlTimestamp getSqlTimestamp() {
        return sqlTimestamp;
    }

    /**
     * Sets the value of the sqlTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link SqlTimestamp }
     *     
     */
    public void setSqlTimestamp(SqlTimestamp value) {
        this.sqlTimestamp = value;
    }

    /**
     * Gets the value of the sqlDate property.
     * 
     * @return
     *     possible object is
     *     {@link SqlDate }
     *     
     */
    public SqlDate getSqlDate() {
        return sqlDate;
    }

    /**
     * Sets the value of the sqlDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link SqlDate }
     *     
     */
    public void setSqlDate(SqlDate value) {
        this.sqlDate = value;
    }

    /**
     * Gets the value of the sqlTime property.
     * 
     * @return
     *     possible object is
     *     {@link SqlTime }
     *     
     */
    public SqlTime getSqlTime() {
        return sqlTime;
    }

    /**
     * Sets the value of the sqlTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link SqlTime }
     *     
     */
    public void setSqlTime(SqlTime value) {
        this.sqlTime = value;
    }

    /**
     * Gets the value of the colArrayList property.
     * 
     * @return
     *     possible object is
     *     {@link ColCollection }
     *     
     */
    public ColCollection getColArrayList() {
        return colArrayList;
    }

    /**
     * Sets the value of the colArrayList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColCollection }
     *     
     */
    public void setColArrayList(ColCollection value) {
        this.colArrayList = value;
    }

    /**
     * Gets the value of the colLinkedList property.
     * 
     * @return
     *     possible object is
     *     {@link ColCollection }
     *     
     */
    public ColCollection getColLinkedList() {
        return colLinkedList;
    }

    /**
     * Sets the value of the colLinkedList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColCollection }
     *     
     */
    public void setColLinkedList(ColCollection value) {
        this.colLinkedList = value;
    }

    /**
     * Gets the value of the colStack property.
     * 
     * @return
     *     possible object is
     *     {@link ColCollection }
     *     
     */
    public ColCollection getColStack() {
        return colStack;
    }

    /**
     * Sets the value of the colStack property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColCollection }
     *     
     */
    public void setColStack(ColCollection value) {
        this.colStack = value;
    }

    /**
     * Gets the value of the colVector property.
     * 
     * @return
     *     possible object is
     *     {@link ColCollection }
     *     
     */
    public ColCollection getColVector() {
        return colVector;
    }

    /**
     * Sets the value of the colVector property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColCollection }
     *     
     */
    public void setColVector(ColCollection value) {
        this.colVector = value;
    }

    /**
     * Gets the value of the colTreeSet property.
     * 
     * @return
     *     possible object is
     *     {@link ColCollection }
     *     
     */
    public ColCollection getColTreeSet() {
        return colTreeSet;
    }

    /**
     * Sets the value of the colTreeSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColCollection }
     *     
     */
    public void setColTreeSet(ColCollection value) {
        this.colTreeSet = value;
    }

    /**
     * Gets the value of the colHashSet property.
     * 
     * @return
     *     possible object is
     *     {@link ColCollection }
     *     
     */
    public ColCollection getColHashSet() {
        return colHashSet;
    }

    /**
     * Sets the value of the colHashSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColCollection }
     *     
     */
    public void setColHashSet(ColCollection value) {
        this.colHashSet = value;
    }

    /**
     * Gets the value of the colCollection property.
     * 
     * @return
     *     possible object is
     *     {@link ColCollection }
     *     
     */
    public ColCollection getColCollection() {
        return colCollection;
    }

    /**
     * Sets the value of the colCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColCollection }
     *     
     */
    public void setColCollection(ColCollection value) {
        this.colCollection = value;
    }

    /**
     * Gets the value of the mapHashMap property.
     * 
     * @return
     *     possible object is
     *     {@link MapMap }
     *     
     */
    public MapMap getMapHashMap() {
        return mapHashMap;
    }

    /**
     * Sets the value of the mapHashMap property.
     * 
     * @param value
     *     allowed object is
     *     {@link MapMap }
     *     
     */
    public void setMapHashMap(MapMap value) {
        this.mapHashMap = value;
    }

    /**
     * Gets the value of the mapProperties property.
     * 
     * @return
     *     possible object is
     *     {@link MapMap }
     *     
     */
    public MapMap getMapProperties() {
        return mapProperties;
    }

    /**
     * Sets the value of the mapProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link MapMap }
     *     
     */
    public void setMapProperties(MapMap value) {
        this.mapProperties = value;
    }

    /**
     * Gets the value of the mapHashtable property.
     * 
     * @return
     *     possible object is
     *     {@link MapMap }
     *     
     */
    public MapMap getMapHashtable() {
        return mapHashtable;
    }

    /**
     * Sets the value of the mapHashtable property.
     * 
     * @param value
     *     allowed object is
     *     {@link MapMap }
     *     
     */
    public void setMapHashtable(MapMap value) {
        this.mapHashtable = value;
    }

    /**
     * Gets the value of the mapWeakHashMap property.
     * 
     * @return
     *     possible object is
     *     {@link MapMap }
     *     
     */
    public MapMap getMapWeakHashMap() {
        return mapWeakHashMap;
    }

    /**
     * Sets the value of the mapWeakHashMap property.
     * 
     * @param value
     *     allowed object is
     *     {@link MapMap }
     *     
     */
    public void setMapWeakHashMap(MapMap value) {
        this.mapWeakHashMap = value;
    }

    /**
     * Gets the value of the mapTreeMap property.
     * 
     * @return
     *     possible object is
     *     {@link MapMap }
     *     
     */
    public MapMap getMapTreeMap() {
        return mapTreeMap;
    }

    /**
     * Sets the value of the mapTreeMap property.
     * 
     * @param value
     *     allowed object is
     *     {@link MapMap }
     *     
     */
    public void setMapTreeMap(MapMap value) {
        this.mapTreeMap = value;
    }

    /**
     * Gets the value of the mapMap property.
     * 
     * @return
     *     possible object is
     *     {@link MapMap }
     *     
     */
    public MapMap getMapMap() {
        return mapMap;
    }

    /**
     * Sets the value of the mapMap property.
     * 
     * @param value
     *     allowed object is
     *     {@link MapMap }
     *     
     */
    public void setMapMap(MapMap value) {
        this.mapMap = value;
    }

    /**
     * Gets the value of the eepk property.
     * 
     * @return
     *     possible object is
     *     {@link MapMap }
     *     
     */
    public MapMap getEepk() {
        return eepk;
    }

    /**
     * Sets the value of the eepk property.
     * 
     * @param value
     *     allowed object is
     *     {@link MapMap }
     *     
     */
    public void setEepk(MapMap value) {
        this.eepk = value;
    }

    /**
     * Gets the value of the eeval property.
     * 
     * @return
     *     possible object is
     *     {@link MapMap }
     *     
     */
    public MapMap getEeval() {
        return eeval;
    }

    /**
     * Sets the value of the eeval property.
     * 
     * @param value
     *     allowed object is
     *     {@link MapMap }
     *     
     */
    public void setEeval(MapMap value) {
        this.eeval = value;
    }

    /**
     * Gets the value of the stdBigDecimal property.
     * 
     * @return
     *     possible object is
     *     {@link StdBigDecimal }
     *     
     */
    public StdBigDecimal getStdBigDecimal() {
        return stdBigDecimal;
    }

    /**
     * Sets the value of the stdBigDecimal property.
     * 
     * @param value
     *     allowed object is
     *     {@link StdBigDecimal }
     *     
     */
    public void setStdBigDecimal(StdBigDecimal value) {
        this.stdBigDecimal = value;
    }

    public Locator sourceLocation() {
        return locator;
    }

    public void setSourceLocation(Locator newLocator) {
        locator = newLocator;
    }

}
