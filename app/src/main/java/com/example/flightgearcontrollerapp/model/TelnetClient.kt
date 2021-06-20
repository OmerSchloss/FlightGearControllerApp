package com.example.flightgearcontrollerapp.model

import java.io.PrintWriter
import java.net.Socket

class TelnetClient{

    private lateinit var client:Socket
    private lateinit var output:PrintWriter
    fun connect(ipAddress: String, portAddress: Int): Boolean {
        return try {
            client = Socket(ipAddress, portAddress)
            output = PrintWriter(client.getOutputStream(), true)
            true
        }catch (e: Exception){
            e.printStackTrace()
            false
        }
    }

    fun disconnect() {
        try{
            client.close()
        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}