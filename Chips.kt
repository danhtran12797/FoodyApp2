package com.oneibc.feature.dashboard

data class Chips(val id:String, val name:String) {
    companion object{
        fun create(position: Int=5, list: List<String>):List<Chips>{
            var lst=ArrayList<Chips>()
            for (i in 0 until position)
                lst.add(Chips(i.toString(), list.random()))
            return lst
        }
    }
}