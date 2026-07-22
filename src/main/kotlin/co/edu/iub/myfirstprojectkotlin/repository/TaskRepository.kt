package co.edu.iub.myfirstprojectkotlin.repository

import co.edu.iub.myfirstprojectkotlin.model.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository : JpaRepository<Task, Long> {
    fun findAllByOwnerId(ownerId: Long): List<Task>
    fun findByIdAndOwnerId(id: Long, ownerId: Long): Task?
}