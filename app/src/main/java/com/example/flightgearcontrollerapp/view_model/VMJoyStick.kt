package com.example.flightgearcontrollerapp.view_model

import com.example.flightgearcontrollerapp.model.FGModel
import java.lang.Math.toRadians
import kotlin.math.cos
import kotlin.math.sin

class VMJoyStick(m: FGModel) {
    private val model = m
    fun updateMove(angle: Double, strength: Float) {
        val length = strength /100
        val x = length*cos( toRadians(angle))
        val y = length*sin( toRadians(angle))
        model.setAileron(x)
        model.setElevator(y)
    }
}