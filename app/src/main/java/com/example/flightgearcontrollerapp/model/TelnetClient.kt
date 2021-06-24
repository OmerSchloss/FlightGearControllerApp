package com.example.flightgearcontrollerapp.model

import java.io.PrintWriter
import java.net.InetSocketAddress
import java.net.Socket
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class TelnetClient{

    private lateinit var client:Socket
    private lateinit var output:PrintWriter
    private lateinit var executor: ExecutorService

    fun connect(ipAddress: String, portAddress: Int): Boolean {
         try {
            client = Socket()
            client.connect(InetSocketAddress(ipAddress, portAddress),5000)
            output = PrintWriter(client.getOutputStream(), true)
            executor = Executors.newSingleThreadExecutor()
            return true
        }catch (e: Exception){
            e.printStackTrace()
            throw RuntimeException(e)
        }
    }

    fun disconnect() {
        try{
            client.close()
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun updateThrottle(fl: Float) {
        executor.execute { output.print("set /controls/engines/current-engine/throttle $fl\r\n");output.flush() }
    }

    fun updateRudder(fl: Float) {
        executor.execute { output.print("set /controls/flight/rudder $fl\r\n");output.flush() }
    }

    fun updateAileron(fl: Float) {
        executor.execute { output.print("set /controls/flight/aileron $fl\r\n");output.flush() }
    }

    fun updateElevator(fl: Float) {
        executor.execute { output.print("set /controls/flight/elevator $fl\r\n");output.flush() }
    }

}