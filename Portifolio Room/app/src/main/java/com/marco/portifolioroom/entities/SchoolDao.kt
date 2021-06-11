package com.marco.portifolioroom.entities

import androidx.room.*
import com.marco.portifolioroom.entities.relations.SchoolAndDirector
import com.marco.portifolioroom.entities.relations.SchoolWithStudents
import com.marco.portifolioroom.entities.relations.StudentSubjectCrossRef
import com.marco.portifolioroom.entities.relations.StudentWithSubjects

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef)


    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String) : List<SchoolAndDirector>


    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String): List<SchoolWithStudents>

    @Transaction
    @Query("SELECT * FROM subject WHERE subjectName = :subjectName")
    suspend fun getStudentsOfSubject(subjectName: String) : List<Subject>

    @Transaction
    @Query("SELECT * FROM student WHERE studentName = :studentName")
    suspend fun getSubjectsOfStudent(studentName: String ) : List<StudentWithSubjects>
}