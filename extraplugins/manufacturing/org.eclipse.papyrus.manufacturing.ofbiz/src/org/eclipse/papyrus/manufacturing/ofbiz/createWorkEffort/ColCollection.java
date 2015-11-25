
package org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import com.sun.xml.bind.Locatable;
import com.sun.xml.bind.annotation.XmlLocation;
import org.xml.sax.Locator;


/**
 * <p>Java class for col-Collection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="col-Collection"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}null" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}std-String" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}std-Integer" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}std-Long" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}std-Float" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}std-Double" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}std-Boolean" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}std-Locale" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}sql-Timestamp" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}sql-Date" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}sql-Time" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}col-ArrayList" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}col-LinkedList" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}col-Stack" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}col-Vector" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}col-TreeSet" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}col-HashSet" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}col-Collection" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}map-HashMap" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}map-Properties" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}map-Hashtable" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}map-WeakHashMap" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}map-TreeMap" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}map-Map" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}eepk-" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}eeval-" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://ofbiz.apache.org/service/}std-BigDecimal" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "col-Collection", propOrder = {
    "_null",
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
public class ColCollection
    implements Locatable
{

    @XmlElement(name = "null", nillable = true)
    protected List<Null> _null;
    @XmlElement(name = "std-String")
    protected List<StdString> stdString;
    @XmlElement(name = "std-Integer")
    protected List<StdInteger> stdInteger;
    @XmlElement(name = "std-Long")
    protected List<StdLong> stdLong;
    @XmlElement(name = "std-Float")
    protected List<StdFloat> stdFloat;
    @XmlElement(name = "std-Double")
    protected List<StdDouble> stdDouble;
    @XmlElement(name = "std-Boolean")
    protected List<StdBoolean> stdBoolean;
    @XmlElement(name = "std-Locale")
    protected List<StdLocale> stdLocale;
    @XmlElement(name = "sql-Timestamp")
    protected List<SqlTimestamp> sqlTimestamp;
    @XmlElement(name = "sql-Date")
    protected List<SqlDate> sqlDate;
    @XmlElement(name = "sql-Time")
    protected List<SqlTime> sqlTime;
    @XmlElement(name = "col-ArrayList")
    protected List<ColCollection> colArrayList;
    @XmlElement(name = "col-LinkedList")
    protected List<ColCollection> colLinkedList;
    @XmlElement(name = "col-Stack")
    protected List<ColCollection> colStack;
    @XmlElement(name = "col-Vector")
    protected List<ColCollection> colVector;
    @XmlElement(name = "col-TreeSet")
    protected List<ColCollection> colTreeSet;
    @XmlElement(name = "col-HashSet")
    protected List<ColCollection> colHashSet;
    @XmlElement(name = "col-Collection")
    protected List<ColCollection> colCollection;
    @XmlElement(name = "map-HashMap")
    protected List<MapMap> mapHashMap;
    @XmlElement(name = "map-Properties")
    protected List<MapMap> mapProperties;
    @XmlElement(name = "map-Hashtable")
    protected List<MapMap> mapHashtable;
    @XmlElement(name = "map-WeakHashMap")
    protected List<MapMap> mapWeakHashMap;
    @XmlElement(name = "map-TreeMap")
    protected List<MapMap> mapTreeMap;
    @XmlElement(name = "map-Map")
    protected List<MapMap> mapMap;
    @XmlElement(name = "eepk-")
    protected List<MapMap> eepk;
    @XmlElement(name = "eeval-")
    protected List<MapMap> eeval;
    @XmlElement(name = "std-BigDecimal")
    protected List<StdBigDecimal> stdBigDecimal;
    @XmlLocation
    @XmlTransient
    protected Locator locator;

    /**
     * Gets the value of the null property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the null property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNull().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Null }
     * 
     * 
     */
    public List<Null> getNull() {
        if (_null == null) {
            _null = new ArrayList<Null>();
        }
        return this._null;
    }

    /**
     * Gets the value of the stdString property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stdString property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStdString().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StdString }
     * 
     * 
     */
    public List<StdString> getStdString() {
        if (stdString == null) {
            stdString = new ArrayList<StdString>();
        }
        return this.stdString;
    }

    /**
     * Gets the value of the stdInteger property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stdInteger property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStdInteger().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StdInteger }
     * 
     * 
     */
    public List<StdInteger> getStdInteger() {
        if (stdInteger == null) {
            stdInteger = new ArrayList<StdInteger>();
        }
        return this.stdInteger;
    }

    /**
     * Gets the value of the stdLong property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stdLong property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStdLong().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StdLong }
     * 
     * 
     */
    public List<StdLong> getStdLong() {
        if (stdLong == null) {
            stdLong = new ArrayList<StdLong>();
        }
        return this.stdLong;
    }

    /**
     * Gets the value of the stdFloat property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stdFloat property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStdFloat().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StdFloat }
     * 
     * 
     */
    public List<StdFloat> getStdFloat() {
        if (stdFloat == null) {
            stdFloat = new ArrayList<StdFloat>();
        }
        return this.stdFloat;
    }

    /**
     * Gets the value of the stdDouble property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stdDouble property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStdDouble().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StdDouble }
     * 
     * 
     */
    public List<StdDouble> getStdDouble() {
        if (stdDouble == null) {
            stdDouble = new ArrayList<StdDouble>();
        }
        return this.stdDouble;
    }

    /**
     * Gets the value of the stdBoolean property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stdBoolean property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStdBoolean().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StdBoolean }
     * 
     * 
     */
    public List<StdBoolean> getStdBoolean() {
        if (stdBoolean == null) {
            stdBoolean = new ArrayList<StdBoolean>();
        }
        return this.stdBoolean;
    }

    /**
     * Gets the value of the stdLocale property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stdLocale property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStdLocale().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StdLocale }
     * 
     * 
     */
    public List<StdLocale> getStdLocale() {
        if (stdLocale == null) {
            stdLocale = new ArrayList<StdLocale>();
        }
        return this.stdLocale;
    }

    /**
     * Gets the value of the sqlTimestamp property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sqlTimestamp property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSqlTimestamp().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SqlTimestamp }
     * 
     * 
     */
    public List<SqlTimestamp> getSqlTimestamp() {
        if (sqlTimestamp == null) {
            sqlTimestamp = new ArrayList<SqlTimestamp>();
        }
        return this.sqlTimestamp;
    }

    /**
     * Gets the value of the sqlDate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sqlDate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSqlDate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SqlDate }
     * 
     * 
     */
    public List<SqlDate> getSqlDate() {
        if (sqlDate == null) {
            sqlDate = new ArrayList<SqlDate>();
        }
        return this.sqlDate;
    }

    /**
     * Gets the value of the sqlTime property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sqlTime property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSqlTime().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SqlTime }
     * 
     * 
     */
    public List<SqlTime> getSqlTime() {
        if (sqlTime == null) {
            sqlTime = new ArrayList<SqlTime>();
        }
        return this.sqlTime;
    }

    /**
     * Gets the value of the colArrayList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the colArrayList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColArrayList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ColCollection }
     * 
     * 
     */
    public List<ColCollection> getColArrayList() {
        if (colArrayList == null) {
            colArrayList = new ArrayList<ColCollection>();
        }
        return this.colArrayList;
    }

    /**
     * Gets the value of the colLinkedList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the colLinkedList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColLinkedList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ColCollection }
     * 
     * 
     */
    public List<ColCollection> getColLinkedList() {
        if (colLinkedList == null) {
            colLinkedList = new ArrayList<ColCollection>();
        }
        return this.colLinkedList;
    }

    /**
     * Gets the value of the colStack property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the colStack property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColStack().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ColCollection }
     * 
     * 
     */
    public List<ColCollection> getColStack() {
        if (colStack == null) {
            colStack = new ArrayList<ColCollection>();
        }
        return this.colStack;
    }

    /**
     * Gets the value of the colVector property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the colVector property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColVector().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ColCollection }
     * 
     * 
     */
    public List<ColCollection> getColVector() {
        if (colVector == null) {
            colVector = new ArrayList<ColCollection>();
        }
        return this.colVector;
    }

    /**
     * Gets the value of the colTreeSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the colTreeSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColTreeSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ColCollection }
     * 
     * 
     */
    public List<ColCollection> getColTreeSet() {
        if (colTreeSet == null) {
            colTreeSet = new ArrayList<ColCollection>();
        }
        return this.colTreeSet;
    }

    /**
     * Gets the value of the colHashSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the colHashSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColHashSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ColCollection }
     * 
     * 
     */
    public List<ColCollection> getColHashSet() {
        if (colHashSet == null) {
            colHashSet = new ArrayList<ColCollection>();
        }
        return this.colHashSet;
    }

    /**
     * Gets the value of the colCollection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the colCollection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColCollection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ColCollection }
     * 
     * 
     */
    public List<ColCollection> getColCollection() {
        if (colCollection == null) {
            colCollection = new ArrayList<ColCollection>();
        }
        return this.colCollection;
    }

    /**
     * Gets the value of the mapHashMap property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mapHashMap property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMapHashMap().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MapMap }
     * 
     * 
     */
    public List<MapMap> getMapHashMap() {
        if (mapHashMap == null) {
            mapHashMap = new ArrayList<MapMap>();
        }
        return this.mapHashMap;
    }

    /**
     * Gets the value of the mapProperties property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mapProperties property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMapProperties().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MapMap }
     * 
     * 
     */
    public List<MapMap> getMapProperties() {
        if (mapProperties == null) {
            mapProperties = new ArrayList<MapMap>();
        }
        return this.mapProperties;
    }

    /**
     * Gets the value of the mapHashtable property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mapHashtable property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMapHashtable().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MapMap }
     * 
     * 
     */
    public List<MapMap> getMapHashtable() {
        if (mapHashtable == null) {
            mapHashtable = new ArrayList<MapMap>();
        }
        return this.mapHashtable;
    }

    /**
     * Gets the value of the mapWeakHashMap property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mapWeakHashMap property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMapWeakHashMap().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MapMap }
     * 
     * 
     */
    public List<MapMap> getMapWeakHashMap() {
        if (mapWeakHashMap == null) {
            mapWeakHashMap = new ArrayList<MapMap>();
        }
        return this.mapWeakHashMap;
    }

    /**
     * Gets the value of the mapTreeMap property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mapTreeMap property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMapTreeMap().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MapMap }
     * 
     * 
     */
    public List<MapMap> getMapTreeMap() {
        if (mapTreeMap == null) {
            mapTreeMap = new ArrayList<MapMap>();
        }
        return this.mapTreeMap;
    }

    /**
     * Gets the value of the mapMap property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mapMap property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMapMap().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MapMap }
     * 
     * 
     */
    public List<MapMap> getMapMap() {
        if (mapMap == null) {
            mapMap = new ArrayList<MapMap>();
        }
        return this.mapMap;
    }

    /**
     * Gets the value of the eepk property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eepk property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEepk().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MapMap }
     * 
     * 
     */
    public List<MapMap> getEepk() {
        if (eepk == null) {
            eepk = new ArrayList<MapMap>();
        }
        return this.eepk;
    }

    /**
     * Gets the value of the eeval property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eeval property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEeval().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MapMap }
     * 
     * 
     */
    public List<MapMap> getEeval() {
        if (eeval == null) {
            eeval = new ArrayList<MapMap>();
        }
        return this.eeval;
    }

    /**
     * Gets the value of the stdBigDecimal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stdBigDecimal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStdBigDecimal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StdBigDecimal }
     * 
     * 
     */
    public List<StdBigDecimal> getStdBigDecimal() {
        if (stdBigDecimal == null) {
            stdBigDecimal = new ArrayList<StdBigDecimal>();
        }
        return this.stdBigDecimal;
    }

    public Locator sourceLocation() {
        return locator;
    }

    public void setSourceLocation(Locator newLocator) {
        locator = newLocator;
    }

}
