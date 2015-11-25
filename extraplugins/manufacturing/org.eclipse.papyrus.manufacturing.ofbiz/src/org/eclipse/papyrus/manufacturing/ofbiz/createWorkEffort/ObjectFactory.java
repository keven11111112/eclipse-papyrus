
package org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Null_QNAME = new QName("http://ofbiz.apache.org/service/", "null");
    private final static QName _ColArrayList_QNAME = new QName("http://ofbiz.apache.org/service/", "col-ArrayList");
    private final static QName _ColLinkedList_QNAME = new QName("http://ofbiz.apache.org/service/", "col-LinkedList");
    private final static QName _ColStack_QNAME = new QName("http://ofbiz.apache.org/service/", "col-Stack");
    private final static QName _ColVector_QNAME = new QName("http://ofbiz.apache.org/service/", "col-Vector");
    private final static QName _ColTreeSet_QNAME = new QName("http://ofbiz.apache.org/service/", "col-TreeSet");
    private final static QName _ColHashSet_QNAME = new QName("http://ofbiz.apache.org/service/", "col-HashSet");
    private final static QName _ColCollection_QNAME = new QName("http://ofbiz.apache.org/service/", "col-Collection");
    private final static QName _MapTreeMap_QNAME = new QName("http://ofbiz.apache.org/service/", "map-TreeMap");
    private final static QName _MapWeakHashMap_QNAME = new QName("http://ofbiz.apache.org/service/", "map-WeakHashMap");
    private final static QName _MapHashtable_QNAME = new QName("http://ofbiz.apache.org/service/", "map-Hashtable");
    private final static QName _MapProperties_QNAME = new QName("http://ofbiz.apache.org/service/", "map-Properties");
    private final static QName _MapHashMap_QNAME = new QName("http://ofbiz.apache.org/service/", "map-HashMap");
    private final static QName _MapMap_QNAME = new QName("http://ofbiz.apache.org/service/", "map-Map");
    private final static QName _MapEntry_QNAME = new QName("http://ofbiz.apache.org/service/", "map-Entry");
    private final static QName _MapKey_QNAME = new QName("http://ofbiz.apache.org/service/", "map-Key");
    private final static QName _MapValue_QNAME = new QName("http://ofbiz.apache.org/service/", "map-Value");
    private final static QName _Eepk_QNAME = new QName("http://ofbiz.apache.org/service/", "eepk-");
    private final static QName _Eeval_QNAME = new QName("http://ofbiz.apache.org/service/", "eeval-");
    private final static QName _CusObj_QNAME = new QName("http://ofbiz.apache.org/service/", "cus-obj");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.eclipse.papyrus.manufacturing.ofbiz.createWorkEffort
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Null }
     * 
     */
    public Null createNull() {
        return new Null();
    }

    /**
     * Create an instance of {@link StdString }
     * 
     */
    public StdString createStdString() {
        return new StdString();
    }

    /**
     * Create an instance of {@link StdInteger }
     * 
     */
    public StdInteger createStdInteger() {
        return new StdInteger();
    }

    /**
     * Create an instance of {@link StdLong }
     * 
     */
    public StdLong createStdLong() {
        return new StdLong();
    }

    /**
     * Create an instance of {@link StdFloat }
     * 
     */
    public StdFloat createStdFloat() {
        return new StdFloat();
    }

    /**
     * Create an instance of {@link StdDouble }
     * 
     */
    public StdDouble createStdDouble() {
        return new StdDouble();
    }

    /**
     * Create an instance of {@link StdBoolean }
     * 
     */
    public StdBoolean createStdBoolean() {
        return new StdBoolean();
    }

    /**
     * Create an instance of {@link StdLocale }
     * 
     */
    public StdLocale createStdLocale() {
        return new StdLocale();
    }

    /**
     * Create an instance of {@link StdBigDecimal }
     * 
     */
    public StdBigDecimal createStdBigDecimal() {
        return new StdBigDecimal();
    }

    /**
     * Create an instance of {@link SqlTimestamp }
     * 
     */
    public SqlTimestamp createSqlTimestamp() {
        return new SqlTimestamp();
    }

    /**
     * Create an instance of {@link SqlDate }
     * 
     */
    public SqlDate createSqlDate() {
        return new SqlDate();
    }

    /**
     * Create an instance of {@link SqlTime }
     * 
     */
    public SqlTime createSqlTime() {
        return new SqlTime();
    }

    /**
     * Create an instance of {@link ColCollection }
     * 
     */
    public ColCollection createColCollection() {
        return new ColCollection();
    }

    /**
     * Create an instance of {@link MapMap }
     * 
     */
    public MapMap createMapMap() {
        return new MapMap();
    }

    /**
     * Create an instance of {@link MapEntry }
     * 
     */
    public MapEntry createMapEntry() {
        return new MapEntry();
    }

    /**
     * Create an instance of {@link MapKey }
     * 
     */
    public MapKey createMapKey() {
        return new MapKey();
    }

    /**
     * Create an instance of {@link MapValue }
     * 
     */
    public MapValue createMapValue() {
        return new MapValue();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Null }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ofbiz.apache.org/service/", name = "null")
    public JAXBElement<Null> createNull(Null value) {
        return new JAXBElement<Null>(_Null_QNAME, Null.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ColCollection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ofbiz.apache.org/service/", name = "col-ArrayList")
    public JAXBElement<ColCollection> createColArrayList(ColCollection value) {
        return new JAXBElement<ColCollection>(_ColArrayList_QNAME, ColCollection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ColCollection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ofbiz.apache.org/service/", name = "col-LinkedList")
    public JAXBElement<ColCollection> createColLinkedList(ColCollection value) {
        return new JAXBElement<ColCollection>(_ColLinkedList_QNAME, ColCollection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ColCollection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ofbiz.apache.org/service/", name = "col-Stack")
    public JAXBElement<ColCollection> createColStack(ColCollection value) {
        return new JAXBElement<ColCollection>(_ColStack_QNAME, ColCollection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ColCollection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ofbiz.apache.org/service/", name = "col-Vector")
    public JAXBElement<ColCollection> createColVector(ColCollection value) {
        return new JAXBElement<ColCollection>(_ColVector_QNAME, ColCollection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ColCollection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ofbiz.apache.org/service/", name = "col-TreeSet")
    public JAXBElement<ColCollection> createColTreeSet(ColCollection value) {
        return new JAXBElement<ColCollection>(_ColTreeSet_QNAME, ColCollection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ColCollection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ofbiz.apache.org/service/", name = "col-HashSet")
    public JAXBElement<ColCollection> createColHashSet(ColCollection value) {
        return new JAXBElement<ColCollection>(_ColHashSet_QNAME, ColCollection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ColCollection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ofbiz.apache.org/service/", name = "col-Collection")
    public JAXBElement<ColCollection> createColCollection(ColCollection value) {
        return new JAXBElement<ColCollection>(_ColCollection_QNAME, ColCollection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MapMap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ofbiz.apache.org/service/", name = "map-TreeMap")
    public JAXBElement<MapMap> createMapTreeMap(MapMap value) {
        return new JAXBElement<MapMap>(_MapTreeMap_QNAME, MapMap.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MapMap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ofbiz.apache.org/service/", name = "map-WeakHashMap")
    public JAXBElement<MapMap> createMapWeakHashMap(MapMap value) {
        return new JAXBElement<MapMap>(_MapWeakHashMap_QNAME, MapMap.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MapMap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ofbiz.apache.org/service/", name = "map-Hashtable")
    public JAXBElement<MapMap> createMapHashtable(MapMap value) {
        return new JAXBElement<MapMap>(_MapHashtable_QNAME, MapMap.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MapMap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ofbiz.apache.org/service/", name = "map-Properties")
    public JAXBElement<MapMap> createMapProperties(MapMap value) {
        return new JAXBElement<MapMap>(_MapProperties_QNAME, MapMap.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MapMap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ofbiz.apache.org/service/", name = "map-HashMap")
    public JAXBElement<MapMap> createMapHashMap(MapMap value) {
        return new JAXBElement<MapMap>(_MapHashMap_QNAME, MapMap.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MapMap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ofbiz.apache.org/service/", name = "map-Map")
    public JAXBElement<MapMap> createMapMap(MapMap value) {
        return new JAXBElement<MapMap>(_MapMap_QNAME, MapMap.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MapEntry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ofbiz.apache.org/service/", name = "map-Entry")
    public JAXBElement<MapEntry> createMapEntry(MapEntry value) {
        return new JAXBElement<MapEntry>(_MapEntry_QNAME, MapEntry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MapKey }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ofbiz.apache.org/service/", name = "map-Key")
    public JAXBElement<MapKey> createMapKey(MapKey value) {
        return new JAXBElement<MapKey>(_MapKey_QNAME, MapKey.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MapValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ofbiz.apache.org/service/", name = "map-Value")
    public JAXBElement<MapValue> createMapValue(MapValue value) {
        return new JAXBElement<MapValue>(_MapValue_QNAME, MapValue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MapMap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ofbiz.apache.org/service/", name = "eepk-")
    public JAXBElement<MapMap> createEepk(MapMap value) {
        return new JAXBElement<MapMap>(_Eepk_QNAME, MapMap.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MapMap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ofbiz.apache.org/service/", name = "eeval-")
    public JAXBElement<MapMap> createEeval(MapMap value) {
        return new JAXBElement<MapMap>(_Eeval_QNAME, MapMap.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ofbiz.apache.org/service/", name = "cus-obj")
    public JAXBElement<Object> createCusObj(Object value) {
        return new JAXBElement<Object>(_CusObj_QNAME, Object.class, null, value);
    }

}
