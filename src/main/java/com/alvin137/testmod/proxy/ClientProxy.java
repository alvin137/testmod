package com.alvin137.testmod.proxy;

import java.util.Date;

import com.alvin137.testmod.Testmod;
import com.alvin137.testmod.items.RegisterItems;

import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ClientProxy extends CommonProxy {
	int age;
	boolean likeold = false;
	Date date = new Date();
    int hour = date.getHours();
    int min = date.getMinutes();
    
    @Override
    public void preinit(FMLPreInitializationEvent e) {
    	super.preinit(e);
    	Configuration config = new Configuration(e.getSuggestedConfigurationFile());
    	config.load();
    	age = config.getInt("Your age", config.CATEGORY_GENERAL, 10, 1, 99, "Enter Your Age");
    	likeold = config.getBoolean("Legacy Type Shutdown", config.CATEGORY_GENERAL, false, null);
    	config.save();
    	OBJLoader.INSTANCE.addDomain(Testmod.MODID);
    	RegisterItems.initClient();
    	FMLCommonHandler.instance().bus().register(new Testmod());
    }
    @Override
	public void init(FMLInitializationEvent e) {
    	super.init(e);
		if(hour <= 05 && min <= 59 && age < 16 && likeold == false){
		Runtime runtime = Runtime.getRuntime();
    	runtime.exit(0);
		}
	}
	@Override
	public void ontickpass(TickEvent.PlayerTickEvent e) {
		super.ontickpass(e);
		if(hour <= 05 && min <= 59 && age < 16 && likeold == false)
    		Testmod.killPlayer(e.player);
    	else if(hour <= 05 && min <= 59 && age < 16 && likeold == true) {
    		Runtime runtime = Runtime.getRuntime();
    		runtime.exit(0);
    	}
	}
}
