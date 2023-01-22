package dev.mvillasenor.japanesetrainer.date.database.entities.assignment

import com.google.gson.annotations.SerializedName
import java.util.*

internal data class AssignmentNetObj(
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("subject_id")
    val subjectId: Int,
    @SerializedName("subject_type")
    val subjectType: String,
    @SerializedName("srs_stage")
    val srsStage: Int,
    @SerializedName("unlocked_at")
    val unlockedAt: Date?,
    @SerializedName("started_at")
    val startedAt: Date?,
    @SerializedName("passed_at")
    val passedAt: Date?,
    @SerializedName("burned_at")
    val burnedAt: Date?,
    @SerializedName("available_at")
    val availableAt: Date?,
    @SerializedName("resurrected_at")
    val resurrectedAt: Date?,
    @SerializedName("hidden")
    val hidden: Boolean
)

//internal fun ResourceNetObj<AssignmentNetObj>.toAssignment() = Assignment(
//    id = id,
//    url = url,
//    createdAt = data.createdAt,
//    subjectId = data.subjectId,
//    subjectType = subjectTypeFromString(data.subjectType),
//    srsStage = data.srsStage,
//    unlockedAt = data.unlockedAt,
//    startedAt = data.startedAt,
//    passedAt = data.passedAt,
//    burnedAt = data.burnedAt,
//    availableAt = data.availableAt,
//    resurrectedAt = data.resurrectedAt,
//    hidden = data.hidden
//)
