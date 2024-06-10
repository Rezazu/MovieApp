package com.example.movieapp.common

object Services {

    fun date(date: String?): String {
        val m = date?.subSequence(5,7)
        val d = date?.subSequence(8,10)
        val y = date?.subSequence(0,4)

        var monthName: String? = ""

        when(m) {
            "01" -> monthName = "January"
            "02" -> monthName = "February"
            "03" -> monthName = "March"
            "04" -> monthName = "April"
            "05" -> monthName = "May"
            "06" -> monthName = "June"
            "07" -> monthName = "July"
            "08" -> monthName = "August"
            "09" -> monthName = "September"
            "10" -> monthName = "October"
            "11" -> monthName = "November"
            "12" -> monthName = "December"
        }

        return "$d $monthName $y"
    }
}