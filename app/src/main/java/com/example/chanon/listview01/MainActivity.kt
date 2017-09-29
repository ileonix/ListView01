package com.example.chanon.listview01

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_main.view.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_listView.adapter = myCustomAdapter(this)

        main_listView.setOnItemClickListener { adapterView, view, position, id ->
            val item = adapterView.getItemAtPosition(position) as String
            var intent = Intent(this,ResultActivity::class.java)
            intent.putExtra("name",item)
            intent.putExtra("position",position)
            startActivity(intent)
            Log.d("Result!","Item: $item at position $position")
        }
    }
                                    //name  type
    private class myCustomAdapter(context: Context): BaseAdapter(){
        private val mContext: Context
        private val names = arrayListOf<String>("Antony","Bourne","Constantin","Duorches","Elizabeth","Forte","Goerge","Freddy")
        init { //initial must do at first call
            mContext = context
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItem(position: Int): Any {
            return names[position]
        }

        override fun getCount(): Int {
            return names.size
        }
        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
//            val textView = TextView(mContext)
//            textView.text = "Show the mwssage"
//            return textView
            //LayoutInflater ใช้เพื่อให้เรียกหน้านี้ไปโผล่หน้าหลักที่ activity_main.xml

            val yellowColor = Color.parseColor("#FFFFCC")
            val greyColor = Color.parseColor("#778899")

            val rowMain: View
            if(convertView == null){
                val layoutInflator = LayoutInflater.from(viewGroup!!.context) //ถ้าใช้ใน oncreated จะใช้ this
                rowMain = layoutInflator.inflate(R.layout.row_main,viewGroup,false)
                Log.d("Result","Call from convertView Condition")
                val viewHolder = ViewHolder(rowMain.name_textView,rowMain.position_textView,rowMain.rowImageView)
                rowMain.tag = viewHolder
            }else{
                rowMain = convertView
            }

            val viewHolder = rowMain.tag as ViewHolder
            //Log.d("Result","Load name_textview")
            viewHolder.nameTextView.text = names.get(position)
            //Log.d("Result","Load position_textview")
            viewHolder.positionTextView.text = "Row Number: $position"

//            Log.d("Result","Load name_textview")
//            rowMain.name_textView.text = names.get(position)
//            Log.d("Result","Load position_textview")
//            rowMain.position_textView.text = "Row Number: $position"

            if(position%2==0){
                rowMain.setBackgroundColor(yellowColor)
                viewHolder.rowImageView.setImageResource(R.drawable.user)
                //rowMain.rowImageView.setImageResource(R.drawable.user)
            }
            else{
                viewHolder.rowImageView.setImageResource(R.drawable.user2)
                //rowMain.rowImageView.setImageResource(R.drawable.user2)
                rowMain.setBackgroundColor(greyColor)
            }

            return rowMain
        }

        private class ViewHolder(val nameTextView: TextView, val positionTextView: TextView, val  rowImageView: ImageView)
    }
}
