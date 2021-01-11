package com.cip.agdxapi.database.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "common_data")
public class CommonDataEntity extends com.cip.agdxapi.database.entities.BaseEntity {

    @Column(name = "lat", nullable = false)
    public BigDecimal lat;

    @Column(name = "lon", nullable = false)
    public BigDecimal lon;

    @Column(name = "alt", nullable = false)
    public BigDecimal alt;

    @Column(name = "accuracy", nullable = false)
    public BigDecimal accuracy;

    @Column(name = "country_code", nullable = false)
    public String countryCode;

    @Column(name = "country_name", nullable = false)
    public String countryName;

    @Column(name = "location_level1")
    public String locationLevel1;

    @Column(name = "location_level2")
    public String locationLevel2;

    @Column(name = "location_level3")
    public String locationLevel3;

    @Column(name = "date_reported")
    public LocalDateTime dateReported;

    @Column(name = "date_updated")
    public LocalDateTime dateUpdated;

    @Column(name = "date_reviewed")
    public LocalDateTime dateReviewed;

    @Column(name = "ontology_name")
    public String ontologyName;

    @Column(name = "common_name")
    public String commonName;

    @Column(name = "scientific_name")
    public String scientificName;

    @Column(name = "area_sampled")
    public BigDecimal areaSampled;

    @Column(name = "affected_area")
    public BigDecimal affectedArea;

    @Column(name = "area_unit")
    public BigDecimal areaUnit;

    @Column(name = "sample_source")
    public String sampleSource;

    @Column(name = "sample_desc")
    public String sampleDesc;

    @Column(name = "sample_size")
    public Integer sampleSize;

    @Column(name = "affected_sample_size")
    public Integer affectedSampleSize;

    @Column(name = "severity")
    public Integer severity;

    /**
     * whether detected or undetected
     */
    @Column(name = "occurrence_status")
    public String occurrenceStatus;

    @Column(name = "comments")
    public String comments;

    @Column(name = "identification_method")
    public String identificationMethod;

    @Column(name = "data_collection_method")
    public String dataCollectionMethod;

    @Column(name = "visually_identified")
    public Boolean visuallyIdentified;

    @Column(name = "image_url")
    public String imageUrl;

    @Column(name = "identified_by")
    public String identifiedBy;

}
