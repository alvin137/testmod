package com.alvin137.testmod.proxy;

import com.alvin137.testmod.items.RegisterItems;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class CommonProxy {
	public void preinit(FMLPreInitializationEvent e) {RegisterItems.registerItem();}
	public void init(FMLInitializationEvent e) {}
	public void ontickpass(TickEvent.PlayerTickEvent e) {}
	public void proxy() {}
}
