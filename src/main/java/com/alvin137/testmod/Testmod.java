package com.alvin137.testmod;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientConnectedToServerEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.apache.logging.log4j.Logger;

import com.alvin137.testmod.items.RegisterItems;
import com.alvin137.testmod.modchecker.ModChecker;
import com.alvin137.testmod.modchecker.ModListCheckerExample;
import com.alvin137.testmod.proxy.CommonProxy;

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
        public ItemStack getTabIconItem() {
            return new ItemStack(RegisterItems.testitem);
        }
    };
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
    	logger = event.getModLog();
    	proxy.preinit(event);
    	ModChecker.check();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	proxy.init(event);
    }
    
    @EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }

    
    @SubscribeEvent
    public void onTickPass(TickEvent.PlayerTickEvent event){
    		proxy.ontickpass(event);
    }
    
    @SubscribeEvent
    public void onServerConnection(ClientConnectedToServerEvent event) {
    	proxy.onServerConnection(event);
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


