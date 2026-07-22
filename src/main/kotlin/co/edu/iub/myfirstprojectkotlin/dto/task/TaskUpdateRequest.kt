package co.edu.iub.myfirstprojectkotlin.dto.task

import co.edu.iub.myfirstprojectkotlin.model.TaskPriority
import co.edu.iub.myfirstprojectkotlin.model.TaskStatus

data class TaskUpdateRequest(
    val title: String?,
    val description: String?,
    val status: TaskStatus?,
    val priority: TaskPriority?
)