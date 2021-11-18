package com.example.unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var mSubmitButton:Button
    private lateinit var mSpinner:Spinner
    private lateinit var mEditText: EditText
    private lateinit var mResultView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mSubmitButton=findViewById(R.id.submit_button)
        mSpinner=findViewById(R.id.spinner_list)
        mEditText=findViewById(R.id.unit_converter)
        mResultView=findViewById(R.id.result_textView)
        ArrayAdapter.createFromResource(this,
        R.array.spinner_list_item,
        android.R.layout.simple_spinner_item).also { adapter->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            mSpinner.adapter=adapter
        }
        mSpinner.onItemSelectedListener=this
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        afterClick(p0?.getItemAtPosition(p2).toString())
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        Toast.makeText(this,"Please select an item from the menu",
            Toast.LENGTH_LONG).show()
    }

    fun afterClick(str:String) {
        mSubmitButton.setOnClickListener(View.OnClickListener { view ->
            val unit = mEditText.text.toString().toDouble()
            when(str){
                "kg to lbs"->mResultView.text=(unit*2.20462262).toString()
                "degree to Fahrenheit"->mResultView.text=(unit*33.8).toString()
                "Fahrenheit to degree"->mResultView.text=(unit-17.2222222).toString()
                "lbs to kg"->mResultView.text=(unit*0.45359237).toString()
                else->Toast.makeText(this,"please select an item from the menu",
                    Toast.LENGTH_LONG).show()
            }
        })
    }
}
