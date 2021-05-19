package com.app.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

@Suppress("NAME_SHADOWING")
class MhsDetailsAct : AppCompatActivity() {
    private lateinit var tv_ip1: TextView
    private lateinit var tv_ip2: TextView
    private lateinit var tv_ip3: TextView
    private lateinit var tv_ip4: TextView
    private lateinit var tv_ip5: TextView
    private lateinit var tv_ip6: TextView
    private lateinit var tv_ip7: TextView

    companion object{
        const val EXTRA_DATA_CLASS_SEMESTER ="extra_data_class_semester"
    }


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mhs_details)

        //intent get data
        var intent = intent
        val alamat = intent.getStringExtra("alamat")
        val tgl_lahir = intent.getStringExtra("tanggal-lahir")
        val email = intent.getStringExtra("email")
        val jurusan = intent.getStringExtra("jurusan")

        val semester: DataClassSemester = intent.getParcelableExtra<DataClassSemester>(EXTRA_DATA_CLASS_SEMESTER) as DataClassSemester
        val sms1 = semester.sm1
        val sms2 = semester.sm2
        val sms3 = semester.sm3
        val sms4 = semester.sm4
        val sms5 = semester.sm5
        val sms6 = semester.sm6
        val sms7 = semester.sm7


        //get tv bio
        val tv_alamat = findViewById<TextView>(R.id.tv_alamat)
        val tv_tgl_lahir = findViewById<TextView>(R.id.tv_tgl_lahir)
        val tv_email = findViewById<TextView>(R.id.tv_email)
        val  tv_jurusan = findViewById<TextView>(R.id.tv_jurusan)

        //get tv IPS
         tv_ip1 = findViewById<TextView>(R.id.tv_ip1)
         tv_ip2 = findViewById<TextView>(R.id.tv_ip2)
         tv_ip3 = findViewById<TextView>(R.id.tv_ip3)
         tv_ip4 = findViewById<TextView>(R.id.tv_ip4)
         tv_ip5 = findViewById<TextView>(R.id.tv_ip5)
         tv_ip6 = findViewById<TextView>(R.id.tv_ip6)
         tv_ip7 = findViewById<TextView>(R.id.tv_ip7)

        // get tv IPK
        val tv_ipk1 = findViewById<TextView>(R.id.tv_ipk1)
        val tv_ipk2 = findViewById<TextView>(R.id.tv_ipk2)
        val tv_ipk3 = findViewById<TextView>(R.id.tv_ipk3)
        val tv_ipk4 = findViewById<TextView>(R.id.tv_ipk4)
        val tv_ipk5 = findViewById<TextView>(R.id.tv_ipk5)
        val tv_ipk6 = findViewById<TextView>(R.id.tv_ipk6)
        val tv_ipk7 = findViewById<TextView>(R.id.tv_ipk7)


        //change data with intent
        tv_alamat.text = alamat.toString()
        tv_tgl_lahir.text = tgl_lahir.toString()
        tv_email.text = email.toString()
        tv_jurusan.text = jurusan.toString()


        //change data with parcelabel
        tv_ip1.text = sms1.toString()
        tv_ip2.text = sms2.toString()
        tv_ip3.text = sms3.toString()
        tv_ip4.text = sms4.toString()
        tv_ip5.text = sms5.toString()
        tv_ip6.text = sms6.toString()
        tv_ip7.text = sms7.toString()


        //convert sms to Float
        val ips1: Float = sms1?.toFloat()!!
        val ips2: Float = sms2?.toFloat()!!
        val ips3: Float = sms3?.toFloat()!!
        val ips4: Float = sms4?.toFloat()!!
        val ips5: Float = sms5?.toFloat()!!
        val ips6: Float = sms6?.toFloat()!!
        val ips7: Float = sms7?.toFloat()!!



        val ipk1 = ips1
        val ipk2 = ips1+ips2
        val ipk3 = ips1+ips2+ips3
        val ipk4 = ips1+ips2+ips3+ips4
        val ipk5 = ips1+ips2+ips3+ips4+ips5
        val ipk6 = ips1+ips2+ips3+ips4+ips5+ips6
        val ipk7 = ips1+ips2+ips3+ips4+ips5+ips6+ips7

        //tv ipk
        tv_ipk1.text = String.format("%.2f",ipk1)
        tv_ipk2.text = String.format("%.2f",ipk2/2)
        tv_ipk3.text = String.format("%.2f",ipk3/3)
        tv_ipk4.text = String.format("%.2f",ipk4/4)
        tv_ipk5.text = String.format("%.2f",ipk5/5)
        tv_ipk6.text = String.format ("%.2f",ipk6/6)
        tv_ipk7.text = String.format("%.2f",ipk7/7)


        val btn_back = findViewById<Button>(R.id.btn_back)
        btn_back.setOnClickListener{
            val intent = Intent(this@MhsDetailsAct, MainActivity::class.java)
            startActivities(arrayOf(intent))
        }
    }

}