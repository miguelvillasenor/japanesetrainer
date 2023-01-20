package dev.mvillasenor.japanesetrainer.network.models

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