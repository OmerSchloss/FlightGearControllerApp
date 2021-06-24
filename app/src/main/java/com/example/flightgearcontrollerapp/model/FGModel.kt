package com.example.flightgearcontrollerapp.model


class FGModel {
    private val telnetClient = TelnetClient()
    private var isConnected =false

    fun connect(ipAddress: String, portAddress: String): Boolean {
        var res = false
        val t = Thread {
            try {
                res = telnetClient.connect(ipAddress, portAddress.toInt())
            } catch (e: Exception) {
                e.printStackTrace()
                throw RuntimeException(e)
            }
        }
        t.start()
        try {
            t.join()
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
        isConnected = true
        return res
    }

    fun disconnect() {
        telnetClient.disconnect()
        isConnected = false
    }

    fun setThrottle(fl: Float) {
        if(isConnected) {
            telnetClient.updateThrottle(fl)
        }
    }

    fun setRudder(fl: Float) {
        if(isConnected) {
            telnetClient.updateRudder(fl)
        }
    }

    fun setAileron(fl: Double) {
        if(isConnected) {
            telnetClient.updateAileron(fl)
        }
    }

    fun setElevator(fl: Double) {
        if(isConnected) {
            telnetClient.updateElevator(fl)
        }
    }

}


