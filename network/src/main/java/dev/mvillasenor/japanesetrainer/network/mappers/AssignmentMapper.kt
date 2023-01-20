package dev.mvillasenor.japanesetrainer.network.mappers

import dev.mvillasenor.domain.Assignment
import dev.mvillasenor.japanesetrainer.network.models.AssignmentNetObj
import dev.mvillasenor.japanesetrainer.network.models.ResourceNetObj

internal fun ResourceNetObj<AssignmentNetObj>.toAssignment() = Assignment(
    id = id,
    url = url,
    createdAt = data.createdAt,
    subjectId = data.subjectId,
    subjectType = subjectTypeFromString(data.subjectType),
    srsStage = data.srsStage,
    unlockedAt = data.unlockedAt,
    startedAt = data.startedAt,
    passedAt = data.passedAt,
    burnedAt = data.burnedAt,
    availableAt = data.availableAt,
    resurrectedAt = data.resurrectedAt,
    hidden = data.hidden
)
