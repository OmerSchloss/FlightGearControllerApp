package com.example.flightgearcontrollerapp.model

import java.io.PrintWriter
import java.net.InetSocketAddress
import java.net.Socket

class TelnetClient{

    private lateinit var client:Socket
    private lateinit var output:PrintWriter
    fun connect(ipAddress: String, portAddress: Int): Boolean {
        return try {
            client = Socket()
            client.connect(InetSocketAddress(ipAddress, portAddress),5000)
            output = PrintWriter(client.getOutputStream(), true)
            true
        }catch (e: Exception){
            e.printStackTrace()
            throw RuntimeException(e)
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