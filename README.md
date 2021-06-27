# Android Joystick App :airplane:

[Demo](https://youtu.be/lIkFrhPQ-Yg)

#### Submitters:
Omer Schloss - 313301764

Avraham Bar Ilan - 205937949

## Summary
This project is a remote control joystick that connect "FlightGear" simulator and control the plane remotely.

The project implemented in MVVM architecture and written with kotlin.

You can download a .apk file of the app [from here](https://github.com/OmerSchloss/FlightGearControllerApp/blob/master/FlightGearController.apk) and look for this nice icon:

![WhatsApp Image 2021-06-27 at 14 54 04](https://user-images.githubusercontent.com/60196825/123543567-d7f1b280-d757-11eb-8cb6-a51632a78c5f.jpeg)

Or you can clone this repo and run it with Android Emulator on your computer.


## Setup

* Install Flight Gear Simulator ([Download from here](https://www.flightgear.org/download/)).
* Inside FlightGear go to Setting -> Additional Settings and write:
``--telnet=socket,in,10,127.0.0.1,6400,tcp``.
* Press Fly and press Autostart.

![App](https://user-images.githubusercontent.com/60196825/123525379-dcc35180-d6d8-11eb-8a40-428ac9f3342f.png)

![Msg](https://user-images.githubusercontent.com/60196825/123525430-417eac00-d6d9-11eb-8c10-2e22e527ae12.png)

## Run
* Run the App.
* Put your computer IP in the field and put ``6400`` in port field.
* press Connect To FlightGear and hit the Throttle up.
* Enjoy your flight.

## UML
As you can see the code is divided into 3 main sections: View, ViewModel and Model.
![UML](https://user-images.githubusercontent.com/60196825/123525299-3a0ad300-d6d8-11eb-917c-306fd31477f5.jpg)

## Demo presentation
[Here is a nice presentation of the project](https://youtu.be/lIkFrhPQ-Yg)
(flight starts at 2:45)
