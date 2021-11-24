package com.cip.agdxapi.database.entities

import com.cip.agdxapi.enums.*
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*

/**
 * Pertains to crop pests data
 */
@Entity
@Table(name = "crop_pests")
class CropPestEntity : BaseEntity() {

    @Column(name = "crop_id")
    var cropId: Long? = null

    /**
     * Can be ISO2 or ISO3
     */
    @Column(name = "country_code", nullable = false)
    @Schema(description = "Can be ISO2(KE) or ISO3(KEN)", example = "KE")
    var countryCode: String? = null

    @Column(name = "lat", nullable = false)
    @Schema(description = "GPS lat", example = "36.821945")
    var lat: BigDecimal? = null

    @Column(name = "lon", nullable = false)
    @Schema(description = "GPS lon", example = "-1.292066")
    var lon: BigDecimal? = null

    @Column(name = "alt", nullable = false)
    @Schema(description = "Identification Altitude above sea level", example = "1200")
    var alt: BigDecimal? = null

    @Column(name = "accuracy", nullable = false)
    @Schema(description = "Accuracy of GPS location in meters", example = "1.0")
    var accuracy: BigDecimal? = null

    /**
     * North America Datum or World geodetic coordinate system
     */
    @Column(name = "geodetic_datum")
    @Schema(description = "North America Datum or World geodetic coordinate system", example = "NAD83")
    var geodeticDatum: String? = null

    /**
     * Province, district or region
     */
    @Column(name = "location_level1", columnDefinition = "TEXT")
    @Schema(description = "Province, district or region", example = "Carroll, Ohio, United States")
    var locationLevel1: String? = null

    /**
     * municipality, district
     */
    @Column(name = "location_level2", columnDefinition = "TEXT")
    @Schema(description = "Municipality,district", example = "Victoria")
    var locationLevel2: String? = null

    /**
     * Administrative leve i.e city,down
     */
    @Column(name = "location_level3", columnDefinition = "TEXT")
    @Schema(description = "Administrative level i.e city,down", example = "CITY")
    var locationLevel3: String? = null

    /**
     * Date when it was detected
     */
    @Column(name = "date_observed")
    @Schema(description = "Date when it was detected", example = "2021-01-13")
    var dateObserved: LocalDate? = null

    /**
     * Date when it was identified
     */
    @Column(name = "date_identified")
    @Schema(description = "Date when it was identified", example = "2021-01-13")
    var dateIdentified: LocalDate? = null

    /**
     * Date when it was recorded into the system
     */
    @Column(name = "date_recorded")
    @Schema(description = "Date when it was recorded into the system", example = "2021-01-13")
    var dateRecorded: LocalDate? = null

    /**
     * Date the record was updated
     */
    @Column(name = "date_updated")
    @Schema(description = "Date the record was updated", example = "2021-01-13")
    var dateUpdated: LocalDate? = null

    /**
     * Date Accuracy in Days
     */
    @Column(name = "date_uncertainty_in_days")
    @Schema(description = "Date Accuracy in Days", example = "1")
    var dateUncertaintyInDays: Int? = null

    @Column(name = "crop_name")
    @Schema(description = "Crop name", example = "Cassava")
    var cropName: String? = null

    @Column(name = "cultivar_name")
    @Schema(description = "Crop cultivar", example = "TMS 90257")
    var cultivarName: String? = null

    @Column(name = "pest_common_name")
    @Schema(description = "Common pest name", example = "Wooly apple aphid")
    var pestCommonName: String? = null

    @Column(name = "pest_scientific_name")
    @Schema(description = "Scientific pest name", example = "Eriosoma lanigerum")
    var pestScientificName: String? = null

    /**
     * Native or Introduced
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "pest_nativity")
    @Schema(description = "Pest nativity status", example = "Native")
    var pestNativity: EnumNativity? = null

    /**
     * Detected, Undetected
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "pest_detection_status", columnDefinition = "TEXT")
    @Schema(description = "Pest detection status", example = "Detected")
    var pestDetectionStatus: EnumDetectionStatus? = null

    /**
     * Virus, Bacteria, Nematode, Plant, Insect
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "pest_category", columnDefinition = "TEXT")
    @Schema(description = "Pest category", example = "Insect")
    var pestCategory: EnumPestCategory? = null

    /**
     * Forest, Soil
     */
    @Column(name = "pest_habitat")
    @Schema(description = "Pest habitat", example = "Forest, Soil")
    var pestHabitat: String? = null

    /**
     * Single plant
     */
    @Column(name = "pest_abundance")
    @Schema(description = "Pest abundance", example = "Single plant")
    var pestAbundance: String? = null

    /**
     * Range of percent cover or description (low, medium, common, rare, etc.)
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "pest_density", columnDefinition = "TEXT")
    @Schema(description = "Range of percent cover or description (low, medium, common, rare, etc.)", example = "Common")
    var pestDensity: EnumDensity? = null

    /**
     * management status of the pest at time of recording (Treated, Untreated)
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "pest_status", columnDefinition = "TEXT")
    @Schema(description = "management status of the pest at time of recording (Treated, Untreated)", example = "Treated")
    var pestTreatmentStatus: EnumTreatmentStatus? = null

    /**
     * Vector of the pest
     */
    @Column(name = "pest_vector")
    @Schema(description = "Vector of the pest", example = "Pied Crow")
    var pestVector: String? = null

    /**
     * This can contain multiple identification methods (PCR,ELISA)
     */
    @Column(name = "pest_identification_method", columnDefinition = "TEXT")
    @Schema(description = "This can contain multiple identification methods (PCR,ELISA)", example = "PCR")
    var pestIdentificationMethod: String? = null

    /**
     * This can contain multiple verification methods
     */
    @Column(name = "pest_verification_method", columnDefinition = "TEXT")
    @Schema(description = "This can contain multiple verification methods", example = "Visual")
    var pestVerificationMethod: String? = null

    /**
     * The basis of the occurrence (Human observation)
     */
    @Column(name = "pest_record_basis", columnDefinition = "TEXT")
    @Schema(description = "The basis of the occurrence (Human observation)", example = "Human observation")
    var pestRecordBasis: String? = null

    @Column(name = "pest_verified")
    @Schema(description = "Observed pest has been verified")
    var pestVerified: Boolean? = null

    /**
     * Severity scale on an number level (5)
     */
    @Column(name = "severity_number_scale")
    @Schema(description = "Severity scale on an number level (5)", example = "5")
    var severityNumberScale: Int? = null

    /**
     * Severity scale on an percentage level
     */
    @Column(name = "severity_percentage_scale")
    @Schema(description = "Severity scale on an percentage level", example = "0.5")
    var severityPercentageScale: BigDecimal? = null

    /**
     * Severity scale on an range level (1-5,4-9)
     */
    @Column(name = "severity_range_scale")
    @Schema(description = "Severity scale on an range level", example = "1-5")
    var severityRangeScale: String? = null

    /**
     * Number of measure for disease occurrence on subject population
     */
    @Column(name = "pest_incidence")
    @Schema(description = "Number of measure for disease occurrence on subject population", example = "50 Percent")
    var pestIncidence: String? = null

    /**
     * Purpose of visit to area for collected data
     */
    @Column(name = "visit_type", columnDefinition = "TEXT")
    @Schema(description = "Purpose of visit to area for collected data", example = "Invasive Species Survey")
    var visitType: String? = null

    /**
     * Area measurement unit ha,acre,sqm
     */
    @Column(name = "area_unit")
    @Schema(description = "Area measurement unit ha,acre,sqm", example = "ha")
    var areaUnit: String? = null

    /**
     * Size of area sampled
     */
    @Column(name = "sampled_area_size", columnDefinition = "decimal", scale = 2, precision = 3)
    @Schema(description = "Size of area sampled", example = "20.5")
    var sampledAreaSize: BigDecimal? = null

    /**
     * Size of area affected
     */
    @Column(name = "affected_area_size", columnDefinition = "decimal", scale = 2, precision = 3)
    @Schema(description = "Size of area affected", example = "15")
    var affectedAreaSize: BigDecimal? = null

    /**
     * Source of the sample i.e Field, greenhouse, lab
     */
    @Column(name = "sample_source", columnDefinition = "TEXT")
    @Schema(description = "Source of the sample i.e Field, greenhouse, lab", example = "Field")
    var sampleSource: String? = null

    /**
     * Description of the sample i.e roots, leaves
     */
    @Column(name = "sample_desc", columnDefinition = "TEXT")
    @Schema(description = "Description of the sample i.e roots, leaves", example = "Roots")
    var sampleDesc: String? = null

    @Column(name = "num_of_samples")
    @Schema(description = "Number of samples collected", example = "500")
    var numOfSamples: Int? = null

    @Column(name = "num_of_affected_samples")
    @Schema(description = "Number of affected samples collected", example = "350")
    var numOfAffectedSamples: Int? = null

    /**
     * Approximate or range of subjects observed or biocontrol agents released (15, 15-20)
     */
    @Column(name = "approximate_quantity")
    @Schema(description = "Approximate or range of subjects observed or biocontrol agents released (15, 15-20)", example = "15")
    var approximateQuantity: String? = null

    /**
     * Unit of measure (individuals, adults, grams, etc.)
     */
    @Column(name = "sample_units")
    @Schema(description = "Unit of measure (individuals, adults, grams, etc.)", example = "adults")
    var sampleUnits: String? = null

    @Column(name = "lab_sample_id")
    @Schema(description = "Lab sample identifier", example = "SMPL-567")
    var labSampleId: String? = null

    @Column(name = "has_visual_symptoms")
    @Schema(description = "Specimens portrayed visual symptoms related to the pest")
    var hasVisualSymptoms: Boolean? = null

    /**
     * Methodology/protocol used to take the data (Aerial survey)
     */
    @Column(name = "data_collection_method", columnDefinition = "TEXT")
    @Schema(description = "Methodology/protocol used to take the data (Aerial survey)", example = "Aerial survey")
    var dataCollectionMethod: String? = null

    /**
     * GeneBank number for identification and confirmation
     */
    @Column(name = "genbank_accession_number")
    @Schema(description = "GeneBank number for identification and confirmation", example = "LC.5656951")
    var genbankAccessionNumber: String? = null

    @Column(name = "project_name")
    @Schema(description = "Name of the project as the source of data", example = "EDDMAPS")
    var projectName: String? = null

    @Column(name = "identified_by")
    var identifiedBy: String? = null

    @Column(name = "reported_by")
    var reportedBy: String? = null

    @Column(name = "recorded_by")
    var recordedBy: String? = null

    @Column(name = "reviewed_by")
    var reviewedBy: String? = null

    @Column(name = "comments", columnDefinition = "TEXT")
    var comments: String? = null

    @Column(name = "identification_method", columnDefinition = "TEXT")
    var identificationMethod: String? = null

    @Column(name = "visually_identified")
    var visuallyIdentified: Boolean? = null

    /**
     * In the case of data from an aggregator,the unique identifier from the original data set.
     * Used in cases where two aggregators may encounter the same data.
     */
    @Column(name = "original_system_id")
    @Schema(
        description = "In the case of data from an aggregator,the unique identifier from the original data set." +
                "Used in cases where two aggregators may encounter the same data."
    )
    var originalSystemId: String? = null

    /**
     * Unique identifier from system contributing data for followup and updating
     */
    @Column(name = "contributing_system_id")
    @Schema(description = "Unique identifier from system contributing data for followup and updating")
    var contributingSystemId: String? = null

    @Column(name = "attribution", columnDefinition = "TEXT")
    var attribution: String? = null
}
