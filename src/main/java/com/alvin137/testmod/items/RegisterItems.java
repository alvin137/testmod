package com.alvin137.testmod.items;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RegisterItems {
	public static Bat bat;
	public static void registerItem() {
		initItems();
	}
	public static void initItems() {
		bat = new Bat();
	}
	@SideOnly(Side.CLIENT)
    public static void initClient() {
        
}
}
