package dev.mvillasenor.japanesetrainer.network.models

import java.util.*

data class AssignmentNO(
    val createdAt: Date,
    val subjectId: Int,
    val subjectType: String,
    val srsStage: Int,
    val unlockedAt: Date?,
    val startedAt: Date?,
    val passedAt: Date?,
    val burnedAt: Date?,
    val availableAt: Date?,
    val resurrectedAt: Date?,
    val hidden: Boolean
)