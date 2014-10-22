/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package graphene.model.idl;  
@SuppressWarnings("all")
/** * a Graph object */
@org.apache.avro.specific.AvroGenerated
public class G_Graph extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"G_Graph\",\"namespace\":\"graphene.model.idl\",\"doc\":\"* a Graph object\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"* The id of the graph\"},{\"name\":\"nodes\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"G_Entity\",\"doc\":\"The nodes in the social, financial, communications or other graphs. May represent concrete individuals or organizations,\\r\\n\\t specific proxies such as accounts, or the implicit individuals or groups behind those other entities.\",\"fields\":[{\"name\":\"uid\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"This uid must represent either (1) a globally unique identifier that can be used to retrieve data for an\\r\\n\\t\\t\\texplicit entity, or (2) encoded query information that can be used to find a set of associated record\\r\\n\\t\\t\\tnotionally representing an implicit entity (e.g. Loans&FirstName&LastName&Gender). Must not be used for\\r\\n\\t\\t\\tIDs that aren't globally unique.  For example, in Kiva, \\\"Lenders\\\" has a UID (\\\"L12345\\\") while \\\"Borrowers\\\"\\r\\n\\t\\t\\thave an encoded search in the Loans table for uid (\\\"B{loan:23456;name=Daniel}\\\").  The encoded information\\r\\n\\t\\t\\tis data layer-specific, may be different from entity to entity or data set to data set, and should be\\r\\n\\t\\t\\tconsidered opaque to the consumers of the entities.  Entities of type 2 should always have the Entity Tag\\r\\n\\t\\t\\tANONYMOUS to help distinguish them when required.\"},{\"name\":\"tags\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"enum\",\"name\":\"G_EntityTag\",\"doc\":\"This is the current list of tags for Entities:\\r\\n\\t \\r\\n\\t CHANGED in 1.6:\\r\\n\\t   - added ACCOUNT_OWNER, CLUSTER_SUMMARY\",\"symbols\":[\"ACCOUNT_OWNER\",\"ACCOUNT\",\"GROUP\",\"CLUSTER\",\"CLUSTER_SUMMARY\",\"FILE\",\"ANONYMOUS\",\"PROMPT_FOR_DETAILS\",\"OTHER\"]}},\"doc\":\"Entity Tags (see above, e.g. \\\"ACCOUNT\\\")\"},{\"name\":\"provenance\",\"type\":[{\"type\":\"record\",\"name\":\"G_Provenance\",\"doc\":\"This is a placeholder for future modeling of provenance. It is not a required field in any service calls.\",\"fields\":[{\"name\":\"uri\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Placeholder for now. Express provenance as a single URI.\"}]},\"null\"],\"default\":null},{\"name\":\"uncertainty\",\"type\":[{\"type\":\"record\",\"name\":\"G_Uncertainty\",\"doc\":\"This is a placeholder for future modeling of uncertainty. It is not a required field in any service calls.\\r\\n\\t\\r\\n\\tCHANGED IN 1.6\",\"fields\":[{\"name\":\"confidence\",\"type\":\"double\",\"doc\":\"Placeholder for now. Express original source confidence as a single number from 0 to 1.\",\"default\":1}]},\"null\"],\"default\":null},{\"name\":\"properties\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"G_Property\",\"doc\":\"Each property on an Entity or Link is a name-value pair, with data type information, as well as optional\\r\\n\\t provenance. Tags provide a way for the data provider to associate semantic annotations to each property\\r\\n\\t in terms of the semantics of the application.  \\r\\n\\t \\r\\n\\t CHANGED IN 1.6\",\"fields\":[{\"name\":\"key\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"the field name in the underlying data source\"},{\"name\":\"friendlyText\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"doc\":\"user-friendly short-text for key (displayable)\",\"default\":null},{\"name\":\"range\",\"type\":[{\"type\":\"record\",\"name\":\"G_SingletonRange\",\"doc\":\"Single value\\r\\n\\t\\r\\n\\tADDED IN 1.5\",\"fields\":[{\"name\":\"value\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",{\"type\":\"record\",\"name\":\"G_GeoData\",\"doc\":\"Structured representation of geo-spatial data.\",\"fields\":[{\"name\":\"text\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"doc\":\"an address or other place reference; unstructured text field\",\"default\":null},{\"name\":\"lat\",\"type\":[\"double\",\"null\"],\"doc\":\"latitude\",\"default\":null},{\"name\":\"lon\",\"type\":[\"double\",\"null\"],\"doc\":\"longitude\",\"default\":null},{\"name\":\"cc\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"doc\":\"ISO 3 digit country code\",\"default\":null}]}]},{\"name\":\"type\",\"type\":{\"type\":\"enum\",\"name\":\"G_PropertyType\",\"doc\":\"Allowed types for Property values.\\r\\n\\r\\n\\t CHANGED in 1.5\",\"symbols\":[\"DOUBLE\",\"LONG\",\"BOOLEAN\",\"STRING\",\"DATE\",\"GEO\",\"OTHER\"]},\"doc\":\"One of DOUBLE, LONG, BOOLEAN, STRING, DATE, GEO, OTHER\"}]},{\"type\":\"record\",\"name\":\"G_ListRange\",\"doc\":\"List of values\\r\\n\\t\\r\\n\\tADDED IN 1.5\",\"fields\":[{\"name\":\"values\",\"type\":{\"type\":\"array\",\"items\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"G_GeoData\"]}},{\"name\":\"type\",\"type\":\"G_PropertyType\",\"doc\":\"One of DOUBLE, LONG, BOOLEAN, STRING, DATE, GEO, OTHER\"}]},{\"type\":\"record\",\"name\":\"G_BoundedRange\",\"doc\":\"Bounded or unbounded range values\\r\\n\\t\\r\\n\\tADDED IN 1.5\",\"fields\":[{\"name\":\"start\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"G_GeoData\",\"null\"],\"doc\":\"start of range, or null if unbounded start\"},{\"name\":\"end\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"G_GeoData\",\"null\"],\"doc\":\"end of range, or null if unbounded start\"},{\"name\":\"inclusive\",\"type\":\"boolean\",\"doc\":\"If true, range includes specified endpoint. If false, range is exclusive.\"},{\"name\":\"type\",\"type\":\"G_PropertyType\",\"doc\":\"One of DOUBLE, LONG, BOOLEAN, STRING, DATE, GEO, OTHER\"}]},{\"type\":\"record\",\"name\":\"G_DistributionRange\",\"doc\":\"Describes a distribution of values. \\r\\n\\t \\r\\n\\tADDED IN 1.6\",\"fields\":[{\"name\":\"distribution\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"G_Frequency\",\"doc\":\"A frequency or probability element of a distribution.\\r\\n\\t \\r\\n\\tADDED IN 1.6\",\"fields\":[{\"name\":\"range\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"G_GeoData\",\"G_ListRange\",\"G_BoundedRange\"],\"doc\":\"the value range which occurs with some specified frequency\"},{\"name\":\"frequency\",\"type\":\"double\",\"doc\":\"frequency as a count, or probability as a value from 0-1.\"}]}}},{\"name\":\"rangeType\",\"type\":{\"type\":\"enum\",\"name\":\"G_RangeType\",\"doc\":\"Allowed types for Ranges of values.\\r\\n\\t\\r\\n\\tCHANGED IN 1.6\",\"symbols\":[\"SINGLETON\",\"LIST\",\"BOUNDED\",\"DISTRIBUTION\"]},\"doc\":\"Describes how the values in the distribution are summarised\"},{\"name\":\"type\",\"type\":\"G_PropertyType\",\"doc\":\"The type of value that the distribution describes. One of DOUBLE, LONG, BOOLEAN, STRING, DATE, GEO, OTHER\"},{\"name\":\"isProbability\",\"type\":\"boolean\",\"doc\":\"True if a probability distribution, false if a frequency distribution\",\"default\":false}]}],\"doc\":\"range of values\",\"default\":null},{\"name\":\"provenance\",\"type\":[\"G_Provenance\",\"null\"],\"default\":null},{\"name\":\"uncertainty\",\"type\":[\"G_Uncertainty\",\"null\"],\"default\":null},{\"name\":\"tags\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"enum\",\"name\":\"G_PropertyTag\",\"doc\":\"Tags are defined by the application layer as a taxonomy of user and application concepts,\\r\\n\\t independent of the data sources. This allows application semantics to be re-used with new\\r\\n\\t data, with a minimum of new software design and development. Data layer entity types, link\\r\\n\\t types and properties should be mapped into the list of tags. The application layer must be\\r\\n\\t able to search by native field name or by tag interchangeably, and properties returned must\\r\\n\\t contain both native field names as well as tags.\\r\\n\\t \\r\\n\\t The list of tags may change as application features evolve, though that will require\\r\\n\\t collaboration with the data layer providers. Evolving the tag list should not change the\\r\\n\\t Data Access or Search APIs.\\r\\n\\r\\n\\t This is the current list of tags for Properties:\\r\\n\\t \\r\\n\\t CHANGED in 1.5:\\r\\n\\t   - CREDIT/DEBIT changed to INFLOWING/OUTFLOWING\\r\\n\\t   - added USD\\r\\n\\t   - added DURATION\\r\\n\\t   \\r\\n\\t CHANGED in 1.6:\\r\\n\\t   - added ENTITY_TYPE\\r\\n\\t   - added ACCOUNT_OWNER, CLUSTER_SUMMARY, COUNTRY_CODE\\r\\n\\t   \\r\\n\\t CHANGED in 1.7:\\r\\n\\t   - added CLUSTER\",\"symbols\":[\"ID\",\"TYPE\",\"ENTITY_TYPE\",\"ACCOUNT_OWNER\",\"CLUSTER_SUMMARY\",\"CLUSTER\",\"NAME\",\"LABEL\",\"STAT\",\"TEXT\",\"STATUS\",\"ANNOTATION\",\"WARNING\",\"LINKED_DATA\",\"IMAGE\",\"GEO\",\"COUNTRY_CODE\",\"DATE\",\"AMOUNT\",\"INFLOWING\",\"OUTFLOWING\",\"COUNT\",\"SERIES\",\"CONSTRU","CTED\",\"RAW\",\"USD\",\"DURATION\"]}},\"doc\":\"one or more tags from the Tag list, used to map this source-specific field into the semantics of applications\"}]}}}]}}},{\"name\":\"edges\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"G_Link\",\"doc\":\"* The links in the social, financial, communications or other graphs. May represent communication events, financial transactions\\r\\n\\t * or social connections.\",\"fields\":[{\"name\":\"tags\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"enum\",\"name\":\"G_LinkTag\",\"doc\":\"This is the current list of tags for Links:\",\"symbols\":[\"FINANCIAL\",\"SOCIAL\",\"COMMUNICATION\",\"OTHER\"]}},\"doc\":\"Link Tags (see above, e.g. \\\"FINANCIAL\\\")\"},{\"name\":\"source\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"doc\":\"source entity uid\",\"default\":null},{\"name\":\"target\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"doc\":\"target entity uid\",\"default\":null},{\"name\":\"directed\",\"type\":\"boolean\",\"doc\":\"true if directed, false if undirected\",\"default\":true},{\"name\":\"provenance\",\"type\":[\"G_Provenance\",\"null\"],\"default\":null},{\"name\":\"uncertainty\",\"type\":[\"G_Uncertainty\",\"null\"],\"default\":null},{\"name\":\"properties\",\"type\":{\"type\":\"array\",\"items\":\"G_Property\"}}]}}},{\"name\":\"properties\",\"type\":{\"type\":\"array\",\"items\":\"G_Property\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** * The id of the graph */
   private java.lang.String id;
   private java.util.List<graphene.model.idl.G_Entity> nodes;
   private java.util.List<graphene.model.idl.G_Link> edges;
   private java.util.List<graphene.model.idl.G_Property> properties;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public G_Graph() {}

  /**
   * All-args constructor.
   */
  public G_Graph(java.lang.String id, java.util.List<graphene.model.idl.G_Entity> nodes, java.util.List<graphene.model.idl.G_Link> edges, java.util.List<graphene.model.idl.G_Property> properties) {
    this.id = id;
    this.nodes = nodes;
    this.edges = edges;
    this.properties = properties;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return nodes;
    case 2: return edges;
    case 3: return properties;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.String)value$; break;
    case 1: nodes = (java.util.List<graphene.model.idl.G_Entity>)value$; break;
    case 2: edges = (java.util.List<graphene.model.idl.G_Link>)value$; break;
    case 3: properties = (java.util.List<graphene.model.idl.G_Property>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   * * The id of the graph   */
  public java.lang.String getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * * The id of the graph   * @param value the value to set.
   */
  public void setId(java.lang.String value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'nodes' field.
   */
  public java.util.List<graphene.model.idl.G_Entity> getNodes() {
    return nodes;
  }

  /**
   * Sets the value of the 'nodes' field.
   * @param value the value to set.
   */
  public void setNodes(java.util.List<graphene.model.idl.G_Entity> value) {
    this.nodes = value;
  }

  /**
   * Gets the value of the 'edges' field.
   */
  public java.util.List<graphene.model.idl.G_Link> getEdges() {
    return edges;
  }

  /**
   * Sets the value of the 'edges' field.
   * @param value the value to set.
   */
  public void setEdges(java.util.List<graphene.model.idl.G_Link> value) {
    this.edges = value;
  }

  /**
   * Gets the value of the 'properties' field.
   */
  public java.util.List<graphene.model.idl.G_Property> getProperties() {
    return properties;
  }

  /**
   * Sets the value of the 'properties' field.
   * @param value the value to set.
   */
  public void setProperties(java.util.List<graphene.model.idl.G_Property> value) {
    this.properties = value;
  }

  /** Creates a new G_Graph RecordBuilder */
  public static graphene.model.idl.G_Graph.Builder newBuilder() {
    return new graphene.model.idl.G_Graph.Builder();
  }
  
  /** Creates a new G_Graph RecordBuilder by copying an existing Builder */
  public static graphene.model.idl.G_Graph.Builder newBuilder(graphene.model.idl.G_Graph.Builder other) {
    return new graphene.model.idl.G_Graph.Builder(other);
  }
  
  /** Creates a new G_Graph RecordBuilder by copying an existing G_Graph instance */
  public static graphene.model.idl.G_Graph.Builder newBuilder(graphene.model.idl.G_Graph other) {
    return new graphene.model.idl.G_Graph.Builder(other);
  }
  
  /**
   * RecordBuilder for G_Graph instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<G_Graph>
    implements org.apache.avro.data.RecordBuilder<G_Graph> {

    private java.lang.String id;
    private java.util.List<graphene.model.idl.G_Entity> nodes;
    private java.util.List<graphene.model.idl.G_Link> edges;
    private java.util.List<graphene.model.idl.G_Property> properties;

    /** Creates a new Builder */
    private Builder() {
      super(graphene.model.idl.G_Graph.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(graphene.model.idl.G_Graph.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.nodes)) {
        this.nodes = data().deepCopy(fields()[1].schema(), other.nodes);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.edges)) {
        this.edges = data().deepCopy(fields()[2].schema(), other.edges);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.properties)) {
        this.properties = data().deepCopy(fields()[3].schema(), other.properties);
        fieldSetFlags()[3] = true;
      }
    }
    
    /** Creates a Builder by copying an existing G_Graph instance */
    private Builder(graphene.model.idl.G_Graph other) {
            super(graphene.model.idl.G_Graph.SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.nodes)) {
        this.nodes = data().deepCopy(fields()[1].schema(), other.nodes);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.edges)) {
        this.edges = data().deepCopy(fields()[2].schema(), other.edges);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.properties)) {
        this.properties = data().deepCopy(fields()[3].schema(), other.properties);
        fieldSetFlags()[3] = true;
      }
    }

    /** Gets the value of the 'id' field */
    public java.lang.String getId() {
      return id;
    }
    
    /** Sets the value of the 'id' field */
    public graphene.model.idl.G_Graph.Builder setId(java.lang.String value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'id' field has been set */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'id' field */
    public graphene.model.idl.G_Graph.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'nodes' field */
    public java.util.List<graphene.model.idl.G_Entity> getNodes() {
      return nodes;
    }
    
    /** Sets the value of the 'nodes' field */
    public graphene.model.idl.G_Graph.Builder setNodes(java.util.List<graphene.model.idl.G_Entity> value) {
      validate(fields()[1], value);
      this.nodes = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'nodes' field has been set */
    public boolean hasNodes() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'nodes' field */
    public graphene.model.idl.G_Graph.Builder clearNodes() {
      nodes = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'edges' field */
    public java.util.List<graphene.model.idl.G_Link> getEdges() {
      return edges;
    }
    
    /** Sets the value of the 'edges' field */
    public graphene.model.idl.G_Graph.Builder setEdges(java.util.List<graphene.model.idl.G_Link> value) {
      validate(fields()[2], value);
      this.edges = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'edges' field has been set */
    public boolean hasEdges() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'edges' field */
    public graphene.model.idl.G_Graph.Builder clearEdges() {
      edges = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'properties' field */
    public java.util.List<graphene.model.idl.G_Property> getProperties() {
      return properties;
    }
    
    /** Sets the value of the 'properties' field */
    public graphene.model.idl.G_Graph.Builder setProperties(java.util.List<graphene.model.idl.G_Property> value) {
      validate(fields()[3], value);
      this.properties = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'properties' field has been set */
    public boolean hasProperties() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'properties' field */
    public graphene.model.idl.G_Graph.Builder clearProperties() {
      properties = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    public G_Graph build() {
      try {
        G_Graph record = new G_Graph();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.String) defaultValue(fields()[0]);
        record.nodes = fieldSetFlags()[1] ? this.nodes : (java.util.List<graphene.model.idl.G_Entity>) defaultValue(fields()[1]);
        record.edges = fieldSetFlags()[2] ? this.edges : (java.util.List<graphene.model.idl.G_Link>) defaultValue(fields()[2]);
        record.properties = fieldSetFlags()[3] ? this.properties : (java.util.List<graphene.model.idl.G_Property>) defaultValue(fields()[3]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
