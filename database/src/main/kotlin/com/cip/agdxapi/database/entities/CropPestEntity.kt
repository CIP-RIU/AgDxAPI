package com.cip.agdxapi.database.entities

import com.cip.agdxapi.database.entities.BaseEntity
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

/**
 * Pertains to crop pests data
 */
@Entity
@Table(name = "crop_pests")
class CropPestEntity : BaseEntity() {
    /**
     * Can be ISO2 or ISO3
     */
    @Column(name = "country_code", nullable = false)
    var countryCode: String? = null

    @Column(name = "lat", nullable = false)
    var lat: BigDecimal? = null

    @Column(name = "lon", nullable = false)
    var lon: BigDecimal? = null

    @Column(name = "alt", nullable = false)
    var alt: BigDecimal? = null

    @Column(name = "accuracy", nullable = false)
    var accuracy: BigDecimal? = null

    /**
     * North America Datum or World geodetic coordinate system
     */
    @Column(name = "geodetic_datum")
    var geodeticDatum: String? = null

    /**
     * Province, district or region
     */
    @Column(name = "location_level1")
    var locationLevel1: String? = null

    /**
     * municipality, district
     */
    @Column(name = "location_level2")
    var locationLevel2: String? = null

    /**
     * Administrative leve i.e city,down
     */
    @Column(name = "location_level3")
    var locationLevel3: String? = null

    /**
     * Date when it was detected
     */
    @Column(name = "date_observed")
    var dateObserved: LocalDate? = null

    /**
     * Date when it was identified
     */
    @Column(name = "date_identified")
    var dateIdentified: LocalDate? = null

    /**
     * Date when it was recorded into the system
     */
    @Column(name = "date_recorded")
    var dateRecorded: LocalDate? = null

    /**
     * Date the record was updated
     */
    @Column(name = "date_updated")
    var dateUpdated: LocalDate? = null

    /**
     * Date Accuracy in Days
     */
    @Column(name = "date_uncertainty_in_days")
    var dateUncertaintyInDays: Int? = null

    @Column(name = "crop_name")
    var cropName: String? = null

    @Column(name = "cultivar_name")
    var cultivarName: String? = null

    @Column(name = "pest_common_name")
    var pestCommonName: String? = null

    @Column(name = "pest_scientific_name")
    var pestScientificName: String? = null

    /**
     * Native or Introduced
     */
    @Column(name = "pest_nativity")
    var pestNativity: String? = null

    /**
     * Detected, Undetected
     */
    @Column(name = "pest_detection_status")
    var pestDetectionStatus: String? = null

    /**
     * Virus, Bacteria, Nematode, Plant, Insect
     */
    @Column(name = "pest_category")
    var pestCategory: String? = null

    /**
     * Forest, Soil
     */
    @Column(name = "pest_habitat")
    var pestHabitat: String? = null

    /**
     * Single plant
     */
    @Column(name = "pest_abundance")
    var pestAbundance: String? = null

    /**
     * Range of percent cover or description (low, medium, common, rare, etc.)
     */
    @Column(name = "pest_density")
    var pestDensity: String? = null

    /**
     * management status of the pest at time of recording (Treated, Untreated)
     */
    @Column(name = "pest_status")
    var pestStatus: String? = null

    /**
     * Vector of the pest
     */
    @Column(name = "pest_vector")
    var pestVector: String? = null

    /**
     * This can contain multiple identification methods (PCR,ELISA)
     */
    @Column(name = "pest_identification_method")
    var pestIdentificationMethod: String? = null

    /**
     * This can contain multiple verification methods
     */
    @Column(name = "pest_verification_method")
    var pestVerificationMethod: String? = null

    /**
     * The basis of the occurrence (Human observation)
     */
    @Column(name = "pest_record_basis")
    var pestRecordBasis: String? = null

    @Column(name = "pest_verified")
    var pestVerified: Boolean? = null

    /**
     * Severity scale on an number level (5)
     */
    @Column(name = "severity_number_scale")
    var severityNumberScale: Int? = null

    /**
     * Severity scale on an percentage level
     */
    @Column(name = "severity_percentage_scale")
    var severityPercentageScale: BigDecimal? = null

    /**
     * Severity scale on an range level (1-5,4-9)
     */
    @Column(name = "severity_range_scale")
    var severityRangeScale: String? = null

    /**
     * Number of measure for disease occurrence on subject population
     */
    @Column(name = "pest_incidence")
    var pestIncidence: String? = null

    /**
     * Purpose of visit to area for collected data
     */
    @Column(name = "visit_type")
    var visitType: String? = null

    /**
     * Area measurement unit ha,acre,sqm
     */
    @Column(name = "area_unit")
    var areaUnit: String? = null

    /**
     * Size of area sampled
     */
    @Column(name = "sampled_area_size")
    var sampledAreaSize: BigDecimal? = null

    /**
     * Size of area affected
     */
    @Column(name = "affected_area_size")
    var affectedAreaSize: BigDecimal? = null

    /**
     * Source of the sample i.e Field, greenhouse, lab
     */
    @Column(name = "sample_source")
    var sampleSource: String? = null

    /**
     * Description of the sample i.e roots, leaves
     */
    @Column(name = "sample_desc")
    var sampleDesc: String? = null

    @Column(name = "num_of_samples")
    var numOfSamples: Int? = null

    @Column(name = "num_of_affected_samples")
    var numOfAffectedSamples: Int? = null

    /**
     * Approximate or range of subjects observed or biocontrol agents released (15, 15-20)
     */
    @Column(name = "approximate_quantity")
    var approximateQuantity: String? = null

    /**
     * Unit of measure (individuals, adults, grams, etc.)
     */
    @Column(name = "sample_units")
    var sampleUnits: String? = null

    @Column(name = "lab_sample_id")
    var labSampleId: String? = null

    @Column(name = "has_visual_symptoms")
    var hasVisualSymptoms: Boolean? = null

    /**
     * Methodology/protocol used to take the data (Aerial survey)
     */
    @Column(name = "data_collection_method")
    var dataCollectionMethod: String? = null

    /**
     * GeneBank number for identification and confirmation
     */
    @Column(name = "genbank_accession_number")
    var genbankAccessionNumber: String? = null

    @Column(name = "project_name")
    var projectName: String? = null

    @Column(name = "identified_by")
    var identifiedBy: String? = null

    @Column(name = "reported_by")
    var reportedBy: String? = null

    @Column(name = "recorded_by")
    var recordedBy: String? = null

    @Column(name = "reviewed_by")
    var reviewedBy: String? = null

    @Column(name = "comments")
    var comments: String? = null

    @Column(name = "identification_method")
    var identificationMethod: String? = null

    @Column(name = "visually_identified")
    var visuallyIdentified: Boolean? = null

    /**
     * In the case of data from an aggregator,             the unique identifier from the original data set. Used in cases where two aggregators may encounter the same data.
     */
    @Column(name = "original_system_id")
    var originalSystemId: String? = null

    /**
     * Unique identifier from system contributing data for followup and updating
     */
    @Column(name = "contributing_system_id")
    var contributingSystemId: String? = null
}