package at.roteskreuz.stopcorona.model.entities.infection.exposure_keys

import at.roteskreuz.stopcorona.utils.asExposureInterval
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Describes infection info about user with data gathered from the Exposure SDK.
 */
@JsonClass(generateAdapter = true)
data class ApiIndexOfDiagnosisKeysArchives(
    @field:Json(name = "full_14_batch")
    val full14DaysBatch: ApiDiagnosisKeysBatch,

    @field:Json(name = "full_7_batch")
    val full07DaysBatch: ApiDiagnosisKeysBatch,

    @field:Json(name = "daily_batches")
    val dailyBatches: List<ApiDiagnosisKeysBatch>
)

@JsonClass(generateAdapter = true)
data class ApiDiagnosisKeysBatch(
    val interval: Long, // Interval number of the keys in that batch

    @field:Json(name = "batch_file_paths")
    val batchFilePaths: List<String>
) {

    // the diagnosis
    val intervalToEpochSeconds: Long by lazy {
        interval.asExposureInterval().toEpochSecond()
    }
}

