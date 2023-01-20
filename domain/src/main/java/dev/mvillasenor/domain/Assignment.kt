package dev.mvillasenor.domain

import java.util.*

data class Assignment(
    val id: Int,
    val url: String,
    val createdAt: Date,
    val subjectId: Int,
    val subjectType: SubjectType,
    val srsStage: Int,
    val unlockedAt: Date?,
    val startedAt: Date?,
    val passedAt: Date?,
    val burnedAt: Date?,
    val availableAt: Date?,
    val resurrectedAt: Date?,
    val hidden: Boolean
)
