package com.app.uts


import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var sms1 : String? = null
    var sms2 : String? = null
    var sms3 : String?= null
    var sms4 : String? = null
    var sms5 : String? = null
    var sms6 : String? = null
    var sms7 : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//      get TEXT from editext
        val txt_alamat = findViewById<EditText>(R.id.txt_alamat)
        val txt_tgl_lahir = findViewById<EditText>(R.id.txt_tgl_lahir)
        val txt_email = findViewById<EditText>(R.id.txt_email)
        val txt_jurusan = findViewById<EditText>(R.id.txt_jurusan)
        //Button
        val btn_clear = findViewById<Button>(R.id.btn_clear)
        //get string editex and passing to intent
         btn_submit.setOnClickListener{
            var alamat = txt_alamat.text.toString()
            var tgllahir = txt_tgl_lahir.text.toString()
            var email = txt_email.text.toString()
            var jurusan = txt_jurusan.text.toString()
            //passing data with intent
            val intent = Intent(this@MainActivity, MhsDetailsAct::class.java)
            intent.putExtra("alamat", alamat)
            intent.putExtra("tanggal-lahir", tgllahir)
            intent.putExtra("email",email)
            intent.putExtra("jurusan", jurusan)

             //send data semester to class parcelable
             val dataclass = DataClassSemester(
                 sms1,//semester 1
                 sms2,//semester 2
                 sms3,//semester 3
                 sms4,//semester 4
                 sms5,//semester 5
                 sms6,//semester 6
                 sms7 //semester 7
             )
             intent.putExtra(MhsDetailsAct.EXTRA_DATA_CLASS_SEMESTER, dataclass)//intent passing data to MhsDetails
            startActivities(arrayOf(intent))//arrayOf for passing  to more one data
            finish()
        }

        btn_clear.setOnClickListener{
            txt_alamat.setText("")
            txt_email.setText("")
            txt_tgl_lahir.setText("")
            txt_jurusan.setText("")
            tv_ip_semester.text = ""
        }

        //custom dialog
        (findViewById<View>(R.id.custom_dialog)).setOnClickListener { showCustomDialog() }
    }


    private fun displayDataResult(e: Event) {
        sms1  = e.sms1.toString()
        sms2 = e.sms2.toString()
        sms3  = e.sms3.toString()
         sms4  = e.sms4.toString()
        sms5  = e.sms5.toString()
        sms6  = e.sms6.toString()
        sms7 = e.sms7.toString()
        (findViewById<View>(R.id.tv_ip_semester) as TextView).text = sms1 +", "+sms2+", "+sms3+", "+sms4+
                ", "+sms5+", "+sms6+", "+ sms7

    }

    private fun showCustomDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE) // before
        dialog.setContentView(R.layout.dialog_event)
        dialog.setCancelable(true)
        val lp = WindowManager.LayoutParams()
        lp.copyFrom(dialog.window!!.attributes)
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT

        //get text from Dialog EditText
        val et_1 = dialog.findViewById<View>(R.id.et_1) as EditText
        val et_2 = dialog.findViewById<View>(R.id.et_2) as EditText
        val et_3 = dialog.findViewById<View>(R.id.et_3) as EditText
        val et_4 = dialog.findViewById<View>(R.id.et_4) as EditText
        val et_5 = dialog.findViewById<View>(R.id.et_5) as EditText
        val et_6 = dialog.findViewById<View>(R.id.et_6) as EditText
        val et_7 = dialog.findViewById<View>(R.id.et_7) as EditText


        //get dialog button
        (dialog.findViewById<View>(R.id.bt_close) as ImageButton).setOnClickListener { dialog.dismiss() }
        (dialog.findViewById<View>(R.id.bt_save) as Button).setOnClickListener {
            //declaration class Event
            val e = Event()
            e.sms1 = et_1.text.toString()
            e.sms2 = et_2.text.toString()
            e.sms3 = et_3.text.toString()
            e.sms4 = et_4.text.toString()
            e.sms5 = et_5.text.toString()
            e.sms6 = et_6.text.toString()
            e.sms7 = et_7.text.toString()
            //send params to displayData
            displayDataResult(e)
            dialog.dismiss()
        }
        dialog.show()
        dialog.window!!.attributes = lp
    }



}
