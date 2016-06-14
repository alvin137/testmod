package com.alvin137.testmod;

import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
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

import com.alvin137.testmod.items.RegisterItems;
import com.alvin137.testmod.proxy.CommonProxy;

import ibxm.Player;

@Mod(modid = Testmod.MODID, version = Testmod.VERSION, name = Testmod.NAME)
public class Testmod
{
	public static final String MODID = "testmod";
    public static final String VERSION = "1.0";
    public static final String NAME = "Testmod";

	@Instance(MODID)
	public static Testmod instance;
	
	@SidedProxy(clientSide="com.alvin137.testmod.proxy.ClientProxy", serverSide="com.alvin137.testmod.proxy.CommonProxy")
	public static CommonProxy proxy;
    
    public static Logger logger;
    
    public static CreativeTabs tabtestmod = new CreativeTabs("Testmod") {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return RegisterItems.testitem;
        }
    };
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
    	proxy.preinit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	proxy.init(event);
    }
    
    @EventHandler
    public void postinit(FMLPostInitializationEvent event) {
    	Checkmod.subDirList(".\\mods\\");
    }

    
    @SubscribeEvent
    public void onTickPass(TickEvent.PlayerTickEvent event){
    		proxy.ontickpass(event);
    }
    
    
    
    public static void killPlayer(EntityPlayer player) {
    	PotionEffect potioneffect1 = new PotionEffect(Potion.getPotionById(4), 1, 3, false, true);
    	PotionEffect potioneffect2 = new PotionEffect(Potion.getPotionById(9), 1, 3, false, true);
    	PotionEffect potioneffect3 = new PotionEffect(Potion.getPotionById(15), 1, 3, false, true);
    	
    	player.addPotionEffect(potioneffect1);
    	player.addPotionEffect(potioneffect2);
    	player.addPotionEffect(potioneffect3);
    }
}


