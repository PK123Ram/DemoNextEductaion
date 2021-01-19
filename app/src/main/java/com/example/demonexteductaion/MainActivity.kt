package com.example.demonexteductaion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.demonexteductaion.adapter.StudentAdapter
import com.example.demonexteductaion.viewmodel.StudentViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var recylerview : RecyclerView?=null
    private var studentAdapter : StudentAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recylerview = findViewById(R.id.recyclerView) as RecyclerView
        DividerItemDecoration(
            this, // context
            RecyclerView.VERTICAL
        ).apply {
            recyclerView.addItemDecoration(this)
        }
        var studentviewmodel:StudentViewModel = ViewModelProviders.of(this).get(StudentViewModel::class.java)
        studentviewmodel.getStudentList().observe(this, Observer { listOfStudents ->
            studentAdapter = StudentAdapter(this,listOfStudents!!)
            recylerview!!.adapter = studentAdapter
        })
    }
}