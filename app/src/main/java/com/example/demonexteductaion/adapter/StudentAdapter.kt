package com.example.demonexteductaion.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.demonexteductaion.R
import com.example.demonexteductaion.databinding.StudentDataBinding
import com.example.demonexteductaion.viewmodel.StudentViewModel

class StudentAdapter(
    private val context: Context,
    private val arrayList: ArrayList<StudentViewModel>
) : RecyclerView.Adapter<StudentAdapter.StudentCustomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentCustomViewHolder {
        val studentDataBinding: StudentDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.item_student,parent,false)
        return  StudentCustomViewHolder(studentDataBinding)
    }

    override fun onBindViewHolder(holder: StudentCustomViewHolder, position: Int) {
        val studentViewModel = arrayList[position]
        holder.onBind(studentViewModel)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class StudentCustomViewHolder(val studentDataBinding: StudentDataBinding) :
        RecyclerView.ViewHolder(studentDataBinding.root) {
        fun onBind(studentViewModel: StudentViewModel) {
            studentDataBinding.studentmodel = studentViewModel
            studentDataBinding.executePendingBindings()
        }
    }
}