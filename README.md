# ArduinoMinecraftController
A spigot plugin for minecaft 1.16.4 where you can turn on a led with a button inside minecraft
## Instalation
Open the arduino code an introduce it to your board. IMPORTANT, you need to check the arduino port in order to change it in the java code and you need to change in the arduino code the constant LED, by the fault is on the port 53 (for my arduino board), otherwise the plugin wont work. 
After this make a new java project. Set the compilance level to java 1.7, add the libraries to the project (in the libraries directory there are instructions btw) and export the project as a jar file, then, copy the jar file to your plugin folder in your server.
