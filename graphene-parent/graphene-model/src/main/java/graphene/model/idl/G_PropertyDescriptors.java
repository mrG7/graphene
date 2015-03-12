/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package graphene.model.idl;  
@SuppressWarnings("all")
/** An instance of PropertyDescriptors is used to contain the dataset-specific type and property descriptions returned
	 by getDescriptors()

	 ADDED IN 1.8 */
@org.apache.avro.specific.AvroGenerated
public class G_PropertyDescriptors extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"G_PropertyDescriptors\",\"namespace\":\"graphene.model.idl\",\"doc\":\"An instance of PropertyDescriptors is used to contain the dataset-specific type and property descriptions returned\\n\\t by getDescriptors()\\n\\n\\t ADDED IN 1.8\",\"fields\":[{\"name\":\"properties\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"G_PropertyDescriptor\",\"doc\":\"Used to add constraints for entity searches.\\n\\n          The 'memberOf' parameter is a list of G_TypeMapping that describe the property in the given types.\\n\\n          ADDED IN 1.8\\n     *\",\"fields\":[{\"name\":\"key\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"property descriptor unique key\"},{\"name\":\"friendlyText\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"a human readable property name to display if the key isn't friendly (optional)\",\"default\":null},{\"name\":\"propertyType\",\"type\":{\"type\":\"enum\",\"name\":\"G_PropertyType\",\"doc\":\"Allowed types for Property values.\\n\\n\\t CHANGED in 1.5\",\"symbols\":[\"DOUBLE\",\"LONG\",\"BOOLEAN\",\"STRING\",\"DATE\",\"GEO\",\"OTHER\"]},\"doc\":\"data type of the property\"},{\"name\":\"range\",\"type\":[{\"type\":\"enum\",\"name\":\"G_RangeType\",\"doc\":\"Allowed types for Ranges of values.\\n\\t\\n\\tCHANGED IN 1.6\",\"symbols\":[\"SINGLETON\",\"LIST\",\"BOUNDED\",\"DISTRIBUTION\"]},\"null\"],\"doc\":\"range of the Property to search on\"},{\"name\":\"constraint\",\"type\":[{\"type\":\"enum\",\"name\":\"G_Constraint\",\"doc\":\"Property value matching constraints\\n\\n\\t ADDED IN 1.8\",\"symbols\":[\"REQUIRED_EQUALS\",\"FUZZY_PARTIAL_OPTIONAL\",\"NOT\",\"OPTIONAL_EQUALS\",\"FUZZY_REQUIRED\"]},\"null\"],\"doc\":\"REQUIRED_EQUALS, FUZZY_PARTIAL_OPTIONAL, NOT, OPTIONAL_EQUALS, FUZZY_REQUIRED\"},{\"name\":\"freeTextIndexed\",\"type\":\"boolean\",\"doc\":\"indicates whether this property is indexed for free text queries *\",\"default\":false},{\"name\":\"defaultTerm\",\"type\":\"boolean\",\"doc\":\"indicates whether this property should be included in the set of default criteria to specify *\",\"default\":false},{\"name\":\"memberOf\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"G_TypeMapping\",\"doc\":\"Used to describe how an G_PropertyDescriptor maps to given a type.\\n\\n\\t\\tADDED IN 1.8\\n\\t *\",\"fields\":[{\"name\":\"type\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"The type that the mapping applies to *\"},{\"name\":\"memberKey\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"field that the G_Property maps to in the type *\"}]}},\"doc\":\"List of mappings against types to which this property belongs,  *\"}]}},\"default\":null},{\"name\":\"types\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"G_TypeDescriptor\",\"doc\":\"Used to describe applicable types for a searchable property. Types may be grouped with the 'group' parameter.\\n\\n\\t\\tADDED IN 1.8\\n\\t *\",\"fields\":[{\"name\":\"key\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"unique key of the type descriptor applicable to a property *\"},{\"name\":\"friendlyText\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"a human readable type name to display if the key isn't friendly (optional)\",\"default\":null},{\"name\":\"group\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"Group name (optional) *\",\"default\":null},{\"name\":\"exclusive\",\"type\":\"boolean\",\"doc\":\"Indicates whether searching within the defined group is exclusive *\",\"default\":true}]}},\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
   private java.util.List<graphene.model.idl.G_PropertyDescriptor> properties;
   private java.util.List<graphene.model.idl.G_TypeDescriptor> types;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public G_PropertyDescriptors() {}

  /**
   * All-args constructor.
   */
  public G_PropertyDescriptors(java.util.List<graphene.model.idl.G_PropertyDescriptor> properties, java.util.List<graphene.model.idl.G_TypeDescriptor> types) {
    this.properties = properties;
    this.types = types;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return properties;
    case 1: return types;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: properties = (java.util.List<graphene.model.idl.G_PropertyDescriptor>)value$; break;
    case 1: types = (java.util.List<graphene.model.idl.G_TypeDescriptor>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'properties' field.
   */
  public java.util.List<graphene.model.idl.G_PropertyDescriptor> getProperties() {
    return properties;
  }

  /**
   * Sets the value of the 'properties' field.
   * @param value the value to set.
   */
  public void setProperties(java.util.List<graphene.model.idl.G_PropertyDescriptor> value) {
    this.properties = value;
  }

  /**
   * Gets the value of the 'types' field.
   */
  public java.util.List<graphene.model.idl.G_TypeDescriptor> getTypes() {
    return types;
  }

  /**
   * Sets the value of the 'types' field.
   * @param value the value to set.
   */
  public void setTypes(java.util.List<graphene.model.idl.G_TypeDescriptor> value) {
    this.types = value;
  }

  /** Creates a new G_PropertyDescriptors RecordBuilder */
  public static graphene.model.idl.G_PropertyDescriptors.Builder newBuilder() {
    return new graphene.model.idl.G_PropertyDescriptors.Builder();
  }
  
  /** Creates a new G_PropertyDescriptors RecordBuilder by copying an existing Builder */
  public static graphene.model.idl.G_PropertyDescriptors.Builder newBuilder(graphene.model.idl.G_PropertyDescriptors.Builder other) {
    return new graphene.model.idl.G_PropertyDescriptors.Builder(other);
  }
  
  /** Creates a new G_PropertyDescriptors RecordBuilder by copying an existing G_PropertyDescriptors instance */
  public static graphene.model.idl.G_PropertyDescriptors.Builder newBuilder(graphene.model.idl.G_PropertyDescriptors other) {
    return new graphene.model.idl.G_PropertyDescriptors.Builder(other);
  }
  
  /**
   * RecordBuilder for G_PropertyDescriptors instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<G_PropertyDescriptors>
    implements org.apache.avro.data.RecordBuilder<G_PropertyDescriptors> {

    private java.util.List<graphene.model.idl.G_PropertyDescriptor> properties;
    private java.util.List<graphene.model.idl.G_TypeDescriptor> types;

    /** Creates a new Builder */
    private Builder() {
      super(graphene.model.idl.G_PropertyDescriptors.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(graphene.model.idl.G_PropertyDescriptors.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.properties)) {
        this.properties = data().deepCopy(fields()[0].schema(), other.properties);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.types)) {
        this.types = data().deepCopy(fields()[1].schema(), other.types);
        fieldSetFlags()[1] = true;
      }
    }
    
    /** Creates a Builder by copying an existing G_PropertyDescriptors instance */
    private Builder(graphene.model.idl.G_PropertyDescriptors other) {
            super(graphene.model.idl.G_PropertyDescriptors.SCHEMA$);
      if (isValidValue(fields()[0], other.properties)) {
        this.properties = data().deepCopy(fields()[0].schema(), other.properties);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.types)) {
        this.types = data().deepCopy(fields()[1].schema(), other.types);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'properties' field */
    public java.util.List<graphene.model.idl.G_PropertyDescriptor> getProperties() {
      return properties;
    }
    
    /** Sets the value of the 'properties' field */
    public graphene.model.idl.G_PropertyDescriptors.Builder setProperties(java.util.List<graphene.model.idl.G_PropertyDescriptor> value) {
      validate(fields()[0], value);
      this.properties = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'properties' field has been set */
    public boolean hasProperties() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'properties' field */
    public graphene.model.idl.G_PropertyDescriptors.Builder clearProperties() {
      properties = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'types' field */
    public java.util.List<graphene.model.idl.G_TypeDescriptor> getTypes() {
      return types;
    }
    
    /** Sets the value of the 'types' field */
    public graphene.model.idl.G_PropertyDescriptors.Builder setTypes(java.util.List<graphene.model.idl.G_TypeDescriptor> value) {
      validate(fields()[1], value);
      this.types = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'types' field has been set */
    public boolean hasTypes() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'types' field */
    public graphene.model.idl.G_PropertyDescriptors.Builder clearTypes() {
      types = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public G_PropertyDescriptors build() {
      try {
        G_PropertyDescriptors record = new G_PropertyDescriptors();
        record.properties = fieldSetFlags()[0] ? this.properties : (java.util.List<graphene.model.idl.G_PropertyDescriptor>) defaultValue(fields()[0]);
        record.types = fieldSetFlags()[1] ? this.types : (java.util.List<graphene.model.idl.G_TypeDescriptor>) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}