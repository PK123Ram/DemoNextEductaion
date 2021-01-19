package com.example.demonexteductaion.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demonexteductaion.model.Student

class StudentViewModel() : ViewModel() {
    var studentName: String = ""
    var rollNum: Int = 0
    var marks: Int = 0

    constructor(student: Student) : this() {
        this.studentName = student.studentName
        this.rollNum = student.rollNumber
        this.marks = student.marks
    }

    var mutableStudentList = MutableLiveData<ArrayList<StudentViewModel>>()
    var arrayList = ArrayList<StudentViewModel>()

    fun getStudentList(): MutableLiveData<ArrayList<StudentViewModel>> {
        var s1 = Student("Kalyan", 1, 91)
        var s2 = Student("Ram", 2, 95)
        var s3 = Student("Syam", 3, 96)

        var s1_mutable = StudentViewModel(s1)
        var s2_mutable = StudentViewModel(s2)
        var s3_mutable = StudentViewModel(s3)
        arrayList.add(s1_mutable)
        arrayList.add(s2_mutable)
        arrayList.add(s3_mutable)

        mutableStudentList.value = arrayList

        return mutableStudentList
    }
}