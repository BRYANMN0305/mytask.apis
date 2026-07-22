package co.edu.iub.myfirstprojectkotlin.dto.task

import co.edu.iub.myfirstprojectkotlin.model.TaskPriority
import co.edu.iub.myfirstprojectkotlin.model.TaskStatus
import java.time.LocalDateTime

data class TaskResponse(
    val id: Long,
    val title: String,
    val description: String?,
    val status: TaskStatus,
    val priority: TaskPriority,
    val userId: Long,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)