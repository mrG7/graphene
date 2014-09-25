/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package graphene.model.idl;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class G_IdType extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"G_IdType\",\"namespace\":\"graphene.model.idl\",\"fields\":[{\"name\":\"name\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"friendlyName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"index\",\"type\":\"long\"},{\"name\":\"shortName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"tableSource\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
   private java.lang.String name;
   private java.lang.String friendlyName;
   private long index;
   private java.lang.String shortName;
   private java.lang.String tableSource;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public G_IdType() {}

  /**
   * All-args constructor.
   */
  public G_IdType(java.lang.String name, java.lang.String friendlyName, java.lang.Long index, java.lang.String shortName, java.lang.String tableSource) {
    this.name = name;
    this.friendlyName = friendlyName;
    this.index = index;
    this.shortName = shortName;
    this.tableSource = tableSource;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return name;
    case 1: return friendlyName;
    case 2: return index;
    case 3: return shortName;
    case 4: return tableSource;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: name = (java.lang.String)value$; break;
    case 1: friendlyName = (java.lang.String)value$; break;
    case 2: index = (java.lang.Long)value$; break;
    case 3: shortName = (java.lang.String)value$; break;
    case 4: tableSource = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'name' field.
   */
  public java.lang.String getName() {
    return name;
  }

  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.String value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'friendlyName' field.
   */
  public java.lang.String getFriendlyName() {
    return friendlyName;
  }

  /**
   * Sets the value of the 'friendlyName' field.
   * @param value the value to set.
   */
  public void setFriendlyName(java.lang.String value) {
    this.friendlyName = value;
  }

  /**
   * Gets the value of the 'index' field.
   */
  public java.lang.Long getIndex() {
    return index;
  }

  /**
   * Sets the value of the 'index' field.
   * @param value the value to set.
   */
  public void setIndex(java.lang.Long value) {
    this.index = value;
  }

  /**
   * Gets the value of the 'shortName' field.
   */
  public java.lang.String getShortName() {
    return shortName;
  }

  /**
   * Sets the value of the 'shortName' field.
   * @param value the value to set.
   */
  public void setShortName(java.lang.String value) {
    this.shortName = value;
  }

  /**
   * Gets the value of the 'tableSource' field.
   */
  public java.lang.String getTableSource() {
    return tableSource;
  }

  /**
   * Sets the value of the 'tableSource' field.
   * @param value the value to set.
   */
  public void setTableSource(java.lang.String value) {
    this.tableSource = value;
  }

  /** Creates a new G_IdType RecordBuilder */
  public static graphene.model.idl.G_IdType.Builder newBuilder() {
    return new graphene.model.idl.G_IdType.Builder();
  }
  
  /** Creates a new G_IdType RecordBuilder by copying an existing Builder */
  public static graphene.model.idl.G_IdType.Builder newBuilder(graphene.model.idl.G_IdType.Builder other) {
    return new graphene.model.idl.G_IdType.Builder(other);
  }
  
  /** Creates a new G_IdType RecordBuilder by copying an existing G_IdType instance */
  public static graphene.model.idl.G_IdType.Builder newBuilder(graphene.model.idl.G_IdType other) {
    return new graphene.model.idl.G_IdType.Builder(other);
  }
  
  /**
   * RecordBuilder for G_IdType instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<G_IdType>
    implements org.apache.avro.data.RecordBuilder<G_IdType> {

    private java.lang.String name;
    private java.lang.String friendlyName;
    private long index;
    private java.lang.String shortName;
    private java.lang.String tableSource;

    /** Creates a new Builder */
    private Builder() {
      super(graphene.model.idl.G_IdType.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(graphene.model.idl.G_IdType.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.friendlyName)) {
        this.friendlyName = data().deepCopy(fields()[1].schema(), other.friendlyName);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.index)) {
        this.index = data().deepCopy(fields()[2].schema(), other.index);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.shortName)) {
        this.shortName = data().deepCopy(fields()[3].schema(), other.shortName);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.tableSource)) {
        this.tableSource = data().deepCopy(fields()[4].schema(), other.tableSource);
        fieldSetFlags()[4] = true;
      }
    }
    
    /** Creates a Builder by copying an existing G_IdType instance */
    private Builder(graphene.model.idl.G_IdType other) {
            super(graphene.model.idl.G_IdType.SCHEMA$);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.friendlyName)) {
        this.friendlyName = data().deepCopy(fields()[1].schema(), other.friendlyName);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.index)) {
        this.index = data().deepCopy(fields()[2].schema(), other.index);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.shortName)) {
        this.shortName = data().deepCopy(fields()[3].schema(), other.shortName);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.tableSource)) {
        this.tableSource = data().deepCopy(fields()[4].schema(), other.tableSource);
        fieldSetFlags()[4] = true;
      }
    }

    /** Gets the value of the 'name' field */
    public java.lang.String getName() {
      return name;
    }
    
    /** Sets the value of the 'name' field */
    public graphene.model.idl.G_IdType.Builder setName(java.lang.String value) {
      validate(fields()[0], value);
      this.name = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'name' field has been set */
    public boolean hasName() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'name' field */
    public graphene.model.idl.G_IdType.Builder clearName() {
      name = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'friendlyName' field */
    public java.lang.String getFriendlyName() {
      return friendlyName;
    }
    
    /** Sets the value of the 'friendlyName' field */
    public graphene.model.idl.G_IdType.Builder setFriendlyName(java.lang.String value) {
      validate(fields()[1], value);
      this.friendlyName = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'friendlyName' field has been set */
    public boolean hasFriendlyName() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'friendlyName' field */
    public graphene.model.idl.G_IdType.Builder clearFriendlyName() {
      friendlyName = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'index' field */
    public java.lang.Long getIndex() {
      return index;
    }
    
    /** Sets the value of the 'index' field */
    public graphene.model.idl.G_IdType.Builder setIndex(long value) {
      validate(fields()[2], value);
      this.index = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'index' field has been set */
    public boolean hasIndex() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'index' field */
    public graphene.model.idl.G_IdType.Builder clearIndex() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'shortName' field */
    public java.lang.String getShortName() {
      return shortName;
    }
    
    /** Sets the value of the 'shortName' field */
    public graphene.model.idl.G_IdType.Builder setShortName(java.lang.String value) {
      validate(fields()[3], value);
      this.shortName = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'shortName' field has been set */
    public boolean hasShortName() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'shortName' field */
    public graphene.model.idl.G_IdType.Builder clearShortName() {
      shortName = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'tableSource' field */
    public java.lang.String getTableSource() {
      return tableSource;
    }
    
    /** Sets the value of the 'tableSource' field */
    public graphene.model.idl.G_IdType.Builder setTableSource(java.lang.String value) {
      validate(fields()[4], value);
      this.tableSource = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'tableSource' field has been set */
    public boolean hasTableSource() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'tableSource' field */
    public graphene.model.idl.G_IdType.Builder clearTableSource() {
      tableSource = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    public G_IdType build() {
      try {
        G_IdType record = new G_IdType();
        record.name = fieldSetFlags()[0] ? this.name : (java.lang.String) defaultValue(fields()[0]);
        record.friendlyName = fieldSetFlags()[1] ? this.friendlyName : (java.lang.String) defaultValue(fields()[1]);
        record.index = fieldSetFlags()[2] ? this.index : (java.lang.Long) defaultValue(fields()[2]);
        record.shortName = fieldSetFlags()[3] ? this.shortName : (java.lang.String) defaultValue(fields()[3]);
        record.tableSource = fieldSetFlags()[4] ? this.tableSource : (java.lang.String) defaultValue(fields()[4]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}