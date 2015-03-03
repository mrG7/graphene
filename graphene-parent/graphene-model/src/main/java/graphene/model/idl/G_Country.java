/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package graphene.model.idl;  
@SuppressWarnings("all")
/** Structured representation of country data, which includes geo-spatial data.
	  
	 ADDED IN 1.6 */
@org.apache.avro.specific.AvroGenerated
public class G_Country extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"G_Country\",\"namespace\":\"graphene.model.idl\",\"doc\":\"Structured representation of country data, which includes geo-spatial data.\\n\\t  \\n\\t ADDED IN 1.6\",\"fields\":[{\"name\":\"country\",\"type\":{\"type\":\"record\",\"name\":\"G_GeoData\",\"doc\":\"Structured representation of geo-spatial data.\",\"fields\":[{\"name\":\"text\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"doc\":\"an address or other place reference; unstructured text field\",\"default\":null},{\"name\":\"lat\",\"type\":[\"double\",\"null\"],\"doc\":\"latitude\",\"default\":null},{\"name\":\"lon\",\"type\":[\"double\",\"null\"],\"doc\":\"longitude\",\"default\":null},{\"name\":\"cc\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"doc\":\"ISO 3 digit country code\",\"default\":null}]},\"doc\":\"country geo data, including the name as text\"},{\"name\":\"region\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"the name of the global region to which the country belongs; any common classification here is acceptable\"},{\"name\":\"continent\",\"type\":{\"type\":\"enum\",\"name\":\"G_ContinentCode\",\"doc\":\"Standard two letter continent code\\n\\t  \\n\\t ADDED IN 1.6\",\"symbols\":[\"AF\",\"AS\",\"EU\",\"NA\",\"SA\",\"OC\",\"AN\"]},\"doc\":\"continent\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** country geo data, including the name as text */
   private graphene.model.idl.G_GeoData country;
  /** the name of the global region to which the country belongs; any common classification here is acceptable */
   private java.lang.String region;
  /** continent */
   private graphene.model.idl.G_ContinentCode continent;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public G_Country() {}

  /**
   * All-args constructor.
   */
  public G_Country(graphene.model.idl.G_GeoData country, java.lang.String region, graphene.model.idl.G_ContinentCode continent) {
    this.country = country;
    this.region = region;
    this.continent = continent;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return country;
    case 1: return region;
    case 2: return continent;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: country = (graphene.model.idl.G_GeoData)value$; break;
    case 1: region = (java.lang.String)value$; break;
    case 2: continent = (graphene.model.idl.G_ContinentCode)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'country' field.
   * country geo data, including the name as text   */
  public graphene.model.idl.G_GeoData getCountry() {
    return country;
  }

  /**
   * Sets the value of the 'country' field.
   * country geo data, including the name as text   * @param value the value to set.
   */
  public void setCountry(graphene.model.idl.G_GeoData value) {
    this.country = value;
  }

  /**
   * Gets the value of the 'region' field.
   * the name of the global region to which the country belongs; any common classification here is acceptable   */
  public java.lang.String getRegion() {
    return region;
  }

  /**
   * Sets the value of the 'region' field.
   * the name of the global region to which the country belongs; any common classification here is acceptable   * @param value the value to set.
   */
  public void setRegion(java.lang.String value) {
    this.region = value;
  }

  /**
   * Gets the value of the 'continent' field.
   * continent   */
  public graphene.model.idl.G_ContinentCode getContinent() {
    return continent;
  }

  /**
   * Sets the value of the 'continent' field.
   * continent   * @param value the value to set.
   */
  public void setContinent(graphene.model.idl.G_ContinentCode value) {
    this.continent = value;
  }

  /** Creates a new G_Country RecordBuilder */
  public static graphene.model.idl.G_Country.Builder newBuilder() {
    return new graphene.model.idl.G_Country.Builder();
  }
  
  /** Creates a new G_Country RecordBuilder by copying an existing Builder */
  public static graphene.model.idl.G_Country.Builder newBuilder(graphene.model.idl.G_Country.Builder other) {
    return new graphene.model.idl.G_Country.Builder(other);
  }
  
  /** Creates a new G_Country RecordBuilder by copying an existing G_Country instance */
  public static graphene.model.idl.G_Country.Builder newBuilder(graphene.model.idl.G_Country other) {
    return new graphene.model.idl.G_Country.Builder(other);
  }
  
  /**
   * RecordBuilder for G_Country instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<G_Country>
    implements org.apache.avro.data.RecordBuilder<G_Country> {

    private graphene.model.idl.G_GeoData country;
    private java.lang.String region;
    private graphene.model.idl.G_ContinentCode continent;

    /** Creates a new Builder */
    private Builder() {
      super(graphene.model.idl.G_Country.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(graphene.model.idl.G_Country.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.country)) {
        this.country = data().deepCopy(fields()[0].schema(), other.country);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.region)) {
        this.region = data().deepCopy(fields()[1].schema(), other.region);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.continent)) {
        this.continent = data().deepCopy(fields()[2].schema(), other.continent);
        fieldSetFlags()[2] = true;
      }
    }
    
    /** Creates a Builder by copying an existing G_Country instance */
    private Builder(graphene.model.idl.G_Country other) {
            super(graphene.model.idl.G_Country.SCHEMA$);
      if (isValidValue(fields()[0], other.country)) {
        this.country = data().deepCopy(fields()[0].schema(), other.country);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.region)) {
        this.region = data().deepCopy(fields()[1].schema(), other.region);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.continent)) {
        this.continent = data().deepCopy(fields()[2].schema(), other.continent);
        fieldSetFlags()[2] = true;
      }
    }

    /** Gets the value of the 'country' field */
    public graphene.model.idl.G_GeoData getCountry() {
      return country;
    }
    
    /** Sets the value of the 'country' field */
    public graphene.model.idl.G_Country.Builder setCountry(graphene.model.idl.G_GeoData value) {
      validate(fields()[0], value);
      this.country = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'country' field has been set */
    public boolean hasCountry() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'country' field */
    public graphene.model.idl.G_Country.Builder clearCountry() {
      country = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'region' field */
    public java.lang.String getRegion() {
      return region;
    }
    
    /** Sets the value of the 'region' field */
    public graphene.model.idl.G_Country.Builder setRegion(java.lang.String value) {
      validate(fields()[1], value);
      this.region = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'region' field has been set */
    public boolean hasRegion() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'region' field */
    public graphene.model.idl.G_Country.Builder clearRegion() {
      region = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'continent' field */
    public graphene.model.idl.G_ContinentCode getContinent() {
      return continent;
    }
    
    /** Sets the value of the 'continent' field */
    public graphene.model.idl.G_Country.Builder setContinent(graphene.model.idl.G_ContinentCode value) {
      validate(fields()[2], value);
      this.continent = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'continent' field has been set */
    public boolean hasContinent() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'continent' field */
    public graphene.model.idl.G_Country.Builder clearContinent() {
      continent = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public G_Country build() {
      try {
        G_Country record = new G_Country();
        record.country = fieldSetFlags()[0] ? this.country : (graphene.model.idl.G_GeoData) defaultValue(fields()[0]);
        record.region = fieldSetFlags()[1] ? this.region : (java.lang.String) defaultValue(fields()[1]);
        record.continent = fieldSetFlags()[2] ? this.continent : (graphene.model.idl.G_ContinentCode) defaultValue(fields()[2]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
