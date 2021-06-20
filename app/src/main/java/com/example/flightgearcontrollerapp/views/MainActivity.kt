package com.example.flightgearcontrollerapp.views

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.flightgearcontrollerapp.R
import com.example.flightgearcontrollerapp.R.id.*
import com.example.flightgearcontrollerapp.view_model.FGViewModel


class MainActivity : AppCompatActivity() {

    //private var vmConnection: FGViewModel = FGViewModel()
    private var isConnected = false
    private val vmConnection = FGViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickConnect(view: View) {
        if (view.id == btn_connect) {
            val btnConnection = findViewById<Button>(btn_connect)
            if (!isConnected) {
                val editTextIP = findViewById<EditText>(ip_address)
                val editTextPort = findViewById<EditText>(port_address)
                val builder = AlertDialog.Builder(this)
                builder.setTitle(getString(R.string.alert_dialog_flightgear_connection))
                builder.setMessage(getString(R.string.alert_instruction))
                builder.setPositiveButton(getString(R.string.ok_btn)){ dialog, _ ->
                    if ((editTextIP.text.toString() !="")&&(editTextPort.text.toString()!="")&&(vmConnection.connectToFG(editTextIP.text.toString(),editTextPort.text.toString()))) {
                        btnConnection.setText(R.string.disconnect)
                        isConnected = true
                    } else {
                        val conFailed = AlertDialog.Builder(this)
                        conFailed.setTitle(getString(R.string.alert_title))
                        conFailed.setMessage(getString(R.string.connection_failed))
                        val alertFail = conFailed.create()
                        alertFail.show()
                    }
                    dialog.cancel()
                }
                builder.setNegativeButton(getString(android.R.string.cancel)){ dialog, _ ->
                    dialog.cancel()
                }
                val alert = builder.create()
                alert.show()

            } else {
                vmConnection.disconnectFromFG()
                btnConnection.setText(R.string.btn_connect)
                isConnected = false
            }
        }
    }




}

