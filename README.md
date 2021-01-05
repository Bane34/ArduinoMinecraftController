# ArduinoMinecraftController
A spigot plugin for minecaft 1.16.4 where you can turn on a led with a button inside minecraft
## Instalation
Open the arduino code. IMPORTANT, you need to check the arduino port in order to change it in the java code later and you need to change in the arduino code the constant LED, by the fault is on the port 53 (for my arduino board), otherwise the plugin wont work. Ones done that, upload the code to your board.
After this make a new java project. Set the compilance level to java 1.7, add the libraries to the project (in the libraries directory there are instructions btw), in the ArduinoControll.java change the variable and set it to your boards port. Export the project as a jar file, then, copy the jar file to your plugin folder in your server.
## How this works
The arduino code just sets the serial port to listen, in the java code, we have a minecraft event where we detect if a button is pushed, if so, the code will send a string as a byte and depeding on the byte, the arduino will turn on or off the LED
## Issues
If you hae any question or any doubt feel free to add me on discord and ask me. @Bane34_42#7292
