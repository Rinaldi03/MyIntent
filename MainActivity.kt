package com.example.myintent

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity : Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithDataActivity : Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        val btnDialPhone : Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        val btnOpenCamera: Button = findViewById(R.id.btn_open_camera)
        btnOpenCamera.setOnClickListener (this)

    }

    override fun onClick(v: View?){
        when (v?.id){
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_move_activity_data -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)

                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Politeknik Negeri Bengkalis Student")

                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5)

                startActivity(moveWithDataIntent)
            }

            R.id.btn_dial_number -> {
                val phoneNumber = "082284668445"

                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))

                startActivity(dialPhoneIntent)
            }
            R.id.btn_open_camera -> {

                val dialCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

                startActivity(dialCamera)


            }
            
        }
    }
}