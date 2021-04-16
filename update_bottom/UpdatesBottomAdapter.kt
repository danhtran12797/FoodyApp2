package com.oneibc.feature.notifications.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.oneibc.R
import com.oneibc.common.model.Chip
import com.oneibc.databinding.ItemBigBottomUpdateBinding
import com.oneibc.databinding.ItemSmallBottomUpdateBinding

private const val ITEM_BIG_TYPE=0
private const val ITEM_SMALL_TYPE=1

class UpdatesBottomAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var count=0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            ITEM_BIG_TYPE->ItemBigHolder(
                ItemBigBottomUpdateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            else->ItemSmallHolder(
                ItemSmallBottomUpdateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder.itemViewType){
            ITEM_BIG_TYPE->{
                (holder as ItemBigHolder).bind()
            }
            else->(holder as ItemSmallHolder).bind()
        }
    }

    override fun getItemCount(): Int {
        return 8
    }

    override fun getItemViewType(position: Int): Int {
        if (count>3)
            count=0
        return if(count<2){
            count++
            ITEM_BIG_TYPE
        }
        else{
            count++
            ITEM_SMALL_TYPE
        }
    }

    inner class ItemSmallHolder(private val binding:ItemSmallBottomUpdateBinding):RecyclerView.ViewHolder(binding.root){
        init {
            val listChips= Chip.create(5, UpdateBottom.createListName(binding.root.context))
            binding.chipGroupView.initComponent(listChips) {
                Toast.makeText(binding.root.context, "${listChips[it].name}", Toast.LENGTH_SHORT).show()
            }
        }

        fun bind(){

        }
    }

    inner class ItemBigHolder(private val binding:ItemBigBottomUpdateBinding):RecyclerView.ViewHolder(binding.root){
        init {
            val listChips= Chip.create(5, UpdateBottom.createListName(binding.root.context))
            binding.chipGroupView.initComponent(listChips) {
                Toast.makeText(binding.root.context, "${listChips[it].name}", Toast.LENGTH_SHORT).show()
            }
        }

        fun bind(){

        }
    }
}

data class UpdateBottom(val id:String, val image:Int, val content:String, val listChip:List<Chip>){
    companion object{
        fun createListName(context: Context)= listOf(
            context.getString(R.string.jurisdictions_free),
            context.getString(R.string.open_account),
            context.getString(R.string.managing_members),
            context.getString(R.string.back),
            context.getString(R.string.service_fee),
            context.getString(R.string.set_up_service),
            context.getString(R.string.billing_information),
            context.getString(R.string.company_formation_unfinished),
            context.getString(R.string.cash),
            context.getString(R.string.confirmation),
            context.getString(R.string.jurisdiction_incorporation),
            context.getString(R.string.dashboard)
        )

//        fun create(position: Int, context: Context):List<UpdateBottom>{
//            val list=ArrayList<UpdateBottom>()
//            for (i in 0 until position){
//                list.add(
//                    UpdateBottom(i.toString(), context.resources.dra, )
//                )
//            }
//        }
    }
}