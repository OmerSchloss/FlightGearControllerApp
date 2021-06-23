package com.example.flightgearcontrollerapp.view_model

import androidx.lifecycle.ViewModel
import com.example.flightgearcontrollerapp.model.FGModel
import java.util.concurrent.ExecutorService

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

    fun setThrottle(fl: Float) {
        model.setThrottle(fl)
    }

    fun setRudder(fl: Float) {
        model.setRudder(fl)
    }

}
