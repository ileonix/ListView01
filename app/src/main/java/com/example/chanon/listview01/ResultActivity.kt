package com.example.chanon.listview01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val bundle = intent.extras
        val name: String
        val position: Int
        name = bundle.getString("name")
        position = bundle.getInt("position")
        nameTextView.text = name
        positionTextView.text = position.toString()

        if(position%2==0){
            imagetextView.text = "user"
            imageView.setImageResource(R.drawable.user)
        }
        else{
            imagetextView.text = "user2"
            imageView.setImageResource(R.drawable.user2)
        }
        //แค่เพิ่ม meta-data ใน AndroidManifest.xml สร้าง menu.xml
//        <activity android:name=".ResultActivity">
//        <meta-data
//        android:name="android.support.PARENT_ACTIVITY"
//        android:value=".MainActivity"/>
//        </activity>

//        <item
//        android:id="@+id/action_home"
//        android:icon="?attr/homeAsUpIndicator"
//        android:title="action_home"
//        android:onClick="actionHomeHandler"
//        app:showAsAction="always" />

        //supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
//    fun actionHomeHandler(item: MenuItem){
//
//    }
}
