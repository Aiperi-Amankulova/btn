package com.example.questionnineactivity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView?=null

    val adapter =Adapterq()
    private var tvt:TextView? = null
    private var tvf:TextView? = null
    private var buttonAdd: Button? =null
    private var btnDelete: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuclerviev)
        id()
        Adapter()
        clickLis()
    }

    private fun id() {
        tvt= findViewById(R.id.tvt)
        tvf= findViewById(R.id.textView)
        buttonAdd= findViewById(R.id.buttonAdd)
        btnDelete=findViewById(R.id.btnDelete)
    }

    private fun getDAta(): ArrayList<DataClass>  {
        val list = arrayListOf<DataClass>()
        for (i in 1..100){
            list.add(DataClass("go $i","go $i","hello$i"))
        }

        return list
    }

    private fun Adapter() {
        recyclerView?.adapter= adapter
        adapter.update(getDAta())

    }

    private fun clickLis() {
        buttonAdd?.setOnClickListener {
            !tvf?.text.isNullOrEmpty()
            adapter.remove(tvf?.text.toString().toInt())
        }

        btnDelete?.setOnClickListener {
            adapter.add(DataClass("hallo","mu","hi", "bue"))
        }
    }


}
