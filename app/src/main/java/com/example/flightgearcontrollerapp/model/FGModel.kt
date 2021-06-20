package com.example.flightgearcontrollerapp.model


class FGModel {
    private val telnetClient = TelnetClient()
    private var isExceptionOccurred = false

    //private val joystickView = JoystickView()
    private var isTouchingJoystick = false

/*
    private val jsCenterX = 0
    private val jsCenterY = 0
    private val jsOuterRadius = 0
    private val jsInnerRadius = 0
*/


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
        return res
    }

    fun disconnect() {
        telnetClient.disconnect()
    }

}


