package bane34.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import bane34.events.ArduinoControll;

public class ArduinoLedMinecraftPlugin extends JavaPlugin {
	PluginDescriptionFile pdffile = getDescription();
	public String version = pdffile.getVersion();
	public String name = "[" + pdffile.getName() + "]";
	
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage(name + " inizializated");
		
		registerEvent();
	}
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("Plugin disabled");
	}
	
	public void registerEvent() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new ArduinoControll(), this);
	}
}
