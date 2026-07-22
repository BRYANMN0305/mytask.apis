package co.edu.iub.myfirstprojectkotlin.dto.task

import co.edu.iub.myfirstprojectkotlin.model.TaskPriority
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class TaskCreateRequest(
    @field:NotBlank
    val title: String,

    val description: String?,

    @field:NotNull
    val priority: TaskPriority
)