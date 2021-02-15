package app.nunome.sary.la1_day1_2

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class WeekMemoApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        val realmConfig = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(realmConfig)
    }
}