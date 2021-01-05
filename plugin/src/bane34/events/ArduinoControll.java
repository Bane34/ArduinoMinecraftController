package bane34.events;

import java.io.OutputStream;
import java.util.Enumeration;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

public class ArduinoControll implements Listener {
	private boolean button_clicked = false;
	
    private static final String TURN_OFF_LED = "0";
    private static final String TURN_ON_LED = "1";
    
    private OutputStream output = null;
    SerialPort serialPort;
    private final String PORT = "COM4"; //Set your arduino por here, in my case, the COM$
    private static final int TIMEOUT = 2000; //Ms
    private static final int DATA_RATE = 9600;
    
    public ArduinoControll() {
    	initConexion();
    }
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
	    Player player = event.getPlayer();
	    
	    if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
	        Block clicked = event.getClickedBlock();
	        if (!button_clicked && clicked.getType() == Material.STONE_BUTTON) {
	            player.sendMessage("button set!");
	            button_clicked = true;
	            sendData(TURN_ON_LED);
	            
	            return;
	        } 
	        else if(button_clicked && clicked.getType() == Material.STONE_BUTTON) {
	        	player.sendMessage("button unset!");
	        	button_clicked = false;
	        	sendData(TURN_OFF_LED);
	        	
	        	return;
	        }
	    }
	}
	    
	public void initConexion() {
		CommPortIdentifier puertoID = null;
	    Enumeration puertoEnum = CommPortIdentifier.getPortIdentifiers();
	    
	    while(puertoEnum.hasMoreElements()){
	    	CommPortIdentifier actualPuertoID = (CommPortIdentifier) puertoEnum.nextElement();
	    	if(PORT.equals(actualPuertoID.getName())){
	    		puertoID = actualPuertoID;
	            break;
	    	}
	    }
	        
	    if(puertoID == null){
	    	System.exit(-1);
	    }
	        
	    try{
	    	serialPort = (SerialPort) puertoID.open(this.getClass().getName(), TIMEOUT);
	            
	    	serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
	    	
	    	output = serialPort.getOutputStream();
	    } 
	    catch(Exception e){
	    	System.exit(-1);
	    }	
	}
	
	private void sendData(String data) {
		try {
			output.write(data.getBytes());
		}
		catch(Exception e) {
			System.exit(-1);
		}
	}
}
