package app.nunome.sary.la1_day1_2

import io.realm.RealmObject

open class WeekData (
    open var weekNum: String = "",
    open var title: String = ""
) : RealmObject()