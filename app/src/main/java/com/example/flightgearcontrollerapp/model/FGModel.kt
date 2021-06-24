package com.example.flightgearcontrollerapp.model


class FGModel {
    private val telnetClient = TelnetClient()
    private var isConnected =false
    private var isExceptionOccurred = false
    private var isTouchingJoystick = false

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
        val h = Thread.UncaughtExceptionHandler { _, _ -> isExceptionOccurred = true;res= false }
        t.uncaughtExceptionHandler = h
        t.start()
        try {
            t.join()
            if (!isExceptionOccurred) {
                this.isTouchingJoystick = false
            }
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

    fun setAileron(fl: Float) {
        if(isConnected) {
            telnetClient.updateAileron(fl)
        }
    }

    fun setElevator(fl: Float) {
        if(isConnected) {
            telnetClient.updateElevator(fl)
        }
    }

}


