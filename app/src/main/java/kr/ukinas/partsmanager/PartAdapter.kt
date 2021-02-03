package kr.ukinas.partsmanager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView



class PartAdapter(private val resultList: ArrayList<Part>, val myListener: MainActivity) :
    RecyclerView.Adapter<PartAdapter.PartViewHolder>() {

    inner class PartViewHolder(partView: View) : RecyclerView.ViewHolder(partView), View.OnClickListener {
        private val partList: ConstraintLayout = partView.findViewById(R.id.part_list)
        val partName: TextView = partView.findViewById(R.id.part_name)
        val partDescription: TextView = partView.findViewById(R.id.part_description)

        init {
            partList.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            resultList[position].datasheet?.let { myListener.onPartListClick(it) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartViewHolder {
        val partView = LayoutInflater.from(parent.context).inflate(R.layout.part, parent, false)
        return PartViewHolder(partView)
    }

    override fun onBindViewHolder(holder: PartViewHolder, position: Int) {
        val currentPart = resultList[position]
        holder.partName.text = currentPart.name
        holder.partDescription.text = currentPart.description
    }

    override fun getItemCount(): Int {
        return resultList.size
    }
}