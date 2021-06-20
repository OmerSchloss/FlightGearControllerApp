package com.example.flightgearcontrollerapp.view_model

import androidx.lifecycle.ViewModel
import com.example.flightgearcontrollerapp.model.FGModel

class FGViewModel : ViewModel() {
    private val model = FGModel()
    fun connectToFG(ipAddress: String, portAddress: String): Boolean{
        if(model.connect(ipAddress,portAddress)){
            return true
        }
        return false
    }

    fun disconnectFromFG() {
        model.disconnect()
    }
}
