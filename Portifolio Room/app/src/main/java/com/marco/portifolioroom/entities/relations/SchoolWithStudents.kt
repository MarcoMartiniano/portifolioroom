package com.marco.portifolioroom.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.marco.portifolioroom.entities.School
import com.marco.portifolioroom.entities.Student

data class SchoolWithStudents (
        @Embedded val school: School,
        @Relation(
            parentColumn = "schoolName",
            entityColumn = "schoolName"
        )
    val students: List<Student>
)