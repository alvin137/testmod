package com.alvin137.testmod.items;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RegisterItems {
	public static Bat bat;
	public static TestItem testitem;
	public static void registerItem() {
		initItems();
	}
	public static void initItems() {
		bat = new Bat();
		testitem = new TestItem();
	}
	@SideOnly(Side.CLIENT)
    public static void initClient() {
		bat.initModel();
		testitem.initModel();
}
}
