package com.marco.portifolioroom.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.marco.portifolioroom.entities.Student
import com.marco.portifolioroom.entities.Subject

data class SubjectsWithStudents (
    @Embedded val student: Student,
    @Relation(
          parentColumn = "subjectName",
            entityColumn = "studentName",
            associateBy = Junction(StudentSubjectCrossRef::class)
              )
        val students: List<Student>
)