package com.cip.agdxapi.core.geojson

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.annotation.JsonProperty
import javax.annotation.Generated

@JsonPropertyOrder(
    "affected_area",
    "crop",
    "cultivar_name",
    "dateCollection",
    "dateDiagnostic",
    "diagnostic",
    "disease",
    "id_location",
    "image",
    "lab",
    "lab_code",
    "ncbi",
    "result",
    "sample_origin",
    "sampling_area",
    "symptom"
)
class Properties {
    @JsonProperty("affected_area")
    var affectedArea = 0.0

    @JsonProperty("crop")
    var crop: String? = null

    @JsonProperty("cultivar_name")
    var cultivarName: String? = null

    @JsonProperty("dateCollection")
    var dateCollection: Long = 0

    @JsonProperty("dateDiagnostic")
    var dateDiagnostic: Long = 0

    @JsonProperty("diagnostic")
    var diagnostic: String? = null

    @JsonProperty("disease")
    var disease: String? = null

    @JsonProperty("id_location")
    var idLocation: Long = 0

    @JsonProperty("image")
    var image: List<String>? = null

    @JsonProperty("lab")
    var lab: List<String>? = null

    @JsonProperty("lab_code")
    var labCode: String? = null

    @JsonProperty("ncbi")
    var ncbi: String? = null

    @JsonProperty("result")
    var result: String? = null

    @JsonProperty("sample_origin")
    var sampleOrigin: String? = null

    @JsonProperty("sampling_area")
    var samplingArea: Long = 0

    @JsonProperty("symptom")
    var symptom: String? = null
}
