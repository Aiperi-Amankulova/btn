package com.example.questionnineactivity


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recyclerview.view.*

class Adapterq:RecyclerView.Adapter<Adapterq.VH>() {
    private var data = arrayListOf<DataClass>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview,parent,false)
        return VH(view)

    }

    override fun getItemCount(): Int {
        return data.size

    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(data[position])
    }

    fun update (list: ArrayList<DataClass>){
        this.data=list
        notifyDataSetChanged()
    }

    fun remove (poz:Int){
        if (poz > -1 && data.size > poz){
            data.removeAt(poz)
            notifyDataSetChanged()
        }
    }

    fun add(item: DataClass){
        data.add(item)
        notifyItemInserted(1)
    }




    class VH(view:View):RecyclerView.ViewHolder(view){
        fun bind (item:DataClass){
            itemView.tvt.text=item.tvt
            itemView.tvt.text=item.tvf
        }
    }


}