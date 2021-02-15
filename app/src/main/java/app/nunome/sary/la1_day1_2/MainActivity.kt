package app.nunome.sary.la1_day1_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val realm: Realm = Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weekdata: WeekData? = read()

        var num: Int =  0

        if (weekdata != null) {
            numTextView.setText(weekdata.weekNum)
        }

        plusButton.setOnClickListener {
            num = num + 1
            numTextView.text = num.toString()
        }

        minusButton.setOnClickListener {
            num = num - 1
            numTextView.text = num.toString()
        }

        numentryButton.setOnClickListener {
            val nument: String = numTextView.text.toString()
            save1(nument)
        }

        entryButton.setOnClickListener {
            weekBookTextView.text = booknameEditText.text.toString()
            val booktitle: String = numTextView.text.toString()
            save2(booktitle)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    fun read(): WeekData? {
        return realm.where(WeekData::class.java).findFirst()
    }

    fun save1(nument: String) {
        val weekdata: WeekData? = read()

        realm.executeTransaction {
            if (weekdata != null) {
                weekdata.weekNum = nument
            } else {
                val newData: WeekData = it.createObject(WeekData::class.java)
                newData.weekNum = nument
            }
        }
    }

    fun save2(booktitle: String) {
        val weekdata: WeekData? = read()

        realm.executeTransaction {
            if (weekdata != null) {
                weekdata.title = booktitle
            } else {
                val newData: WeekData = it.createObject(WeekData::class.java)
                newData.title = booktitle
            }
        }
    }
}