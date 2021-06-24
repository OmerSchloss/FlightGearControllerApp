package com.example.flightgearcontrollerapp.views

import com.example.flightgearcontrollerapp.model.FGModel
import com.example.flightgearcontrollerapp.view_model.VMJoyStick
import com.jackandphantom.joystickview.JoyStickView

class JoyStick(m: FGModel, joyStick: JoyStickView) {
    private val viewModel = VMJoyStick(m)
    init {

        joyStick.setOnMoveListener { angle, strength -> viewModel.updateMove(angle, strength)

        }

    }
//viewModel.updateMove(0.0,0f)
}