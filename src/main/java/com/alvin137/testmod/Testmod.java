package com.alvin137.testmod;

import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.FMLConfigGuiFactory;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.fml.common.network.NetworkCheckHandler;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.apache.logging.log4j.core.Logger;

import ibxm.Player;

@Mod(modid = Testmod.MODID, version = Testmod.VERSION, name = Testmod.NAME)
public class Testmod
{
	public static final String MODID = "testmod";
    public static final String VERSION = "1.0";
    public static final String NAME = "Testmod";

	@Instance(MODID)
	public static Testmod instance;
	
	@SidedProxy(clientSide="com.alvin137.testmod.ClientProxy", serverSide="com.alvin137.testmod.CommonProxy")
	public static CommonProxy proxy;
	
	int age;
	Date date = new Date();
	
        
    int hour = date.getHours();
    int min = date.getMinutes();
    
    boolean likeold = false;
    
    public static Logger logger;
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
    	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
    	config.load();
    	age = config.getInt("Your age", config.CATEGORY_GENERAL, 10, 1, 99, "Enter Your Age");
    	likeold = config.getBoolean("Legacy Type Shutdown", config.CATEGORY_GENERAL, false, null);
    	config.save();
    	FMLCommonHandler.instance().bus().register(new Testmod());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	if(hour <= 05 && min <= 59 && age < 16 && likeold == false){
    		logger.debug("Killing Time!");
    		proxy.proxy();
    	}
    }
    
    @EventHandler
    public void postinit(FMLPostInitializationEvent event) {
    	Checkmod.subDirList(".\\mods\\");
    }

    
    @SubscribeEvent
    public void onTickPass(TickEvent.PlayerTickEvent event){
    	if(hour <= 05 && min <= 59 && age < 16 && likeold == false)
    		killPlayer(event.player);
    	else if(hour <= 05 && min <= 59 && age < 16 && likeold == true)
    		proxy.proxy();
    }
    
    
    
    public void killPlayer(EntityPlayer player) {
    	PotionEffect potioneffect1 = new PotionEffect(Potion.getPotionById(4), 1, 3, false, true);
    	PotionEffect potioneffect2 = new PotionEffect(Potion.getPotionById(9), 1, 3, false, true);
    	PotionEffect potioneffect3 = new PotionEffect(Potion.getPotionById(15), 1, 3, false, true);
    	
    	player.addPotionEffect(potioneffect1);
    	player.addPotionEffect(potioneffect2);
    	player.addPotionEffect(potioneffect3);
    }
}


