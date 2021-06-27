# Android Joystick App

[Demo](https://youtu.be/lIkFrhPQ-Yg)

#### Submitters:
Omer schlos - 313301764

Avraham Bar Ilan - 205937949

## Summary
This project is a remote control joystick that connect "FlightGear" simulator and control the plane remotely.

The project implemented in MVVM architecture and written with kotlin.

## Setup
Before running the app you should do the following steps:
* Clone this repositories.
* Install Android Studio.
* Install Flight Gear Simulator (it is an open source project).
* Inside FlightGear go to Setting -> Additional Settings and write:
``--telnet=socket,in,10,127.0.0.1,6400,tcp``.
* Press Fly and hit the Autostart button.

![App](https://user-images.githubusercontent.com/60196825/123525379-dcc35180-d6d8-11eb-8a40-428ac9f3342f.png)

![Msg](https://user-images.githubusercontent.com/60196825/123525430-417eac00-d6d9-11eb-8c10-2e22e527ae12.png)

## Run
* Run the App in your favourite IDE
* Put your computer IP in the field and put ``6400`` in port field.
* press Connect To FlightGear and hit the Throttle up :airplane:.
* Enjoy your flight.

## UML
As you can see code is divided into 3 main sections: View, ViewModel and Model
![UML](https://user-images.githubusercontent.com/60196825/123525299-3a0ad300-d6d8-11eb-917c-306fd31477f5.jpg)

## Demo presentation
[Here is a nice presentation of the project](https://youtu.be/lIkFrhPQ-Yg)
(flight starts at 2:45)
