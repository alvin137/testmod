package com.alvin137.testmod.blocks;

import com.alvin137.testmod.items.TestItem;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RegisterBlocks {
	public static TestBlock tblock;
	public static void registerBlock() {
		initBlocks();
	}
	public static void initBlocks() {
	tblock = new TestBlock();
	}
	@SideOnly(Side.CLIENT)
    public static void initClient() {
	tblock.initModel();
}
}
