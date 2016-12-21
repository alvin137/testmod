package com.alvin137.testmod.items;

import com.alvin137.testmod.Testmod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Bat extends TestmodRFItems {
	
	protected static int capacity=300;
	protected static int maxReceive=30;
	protected static int maxExtract=30;
	protected static String name="bat";
	public Bat() {
		super(capacity, maxReceive, maxExtract, name);
	}
	
	@Override
	 public EnumActionResult onItemUse(EntityPlayer stack, World playerIn, BlockPos worldIn, EnumHand pos, EnumFacing hand, float facing, float hitX, float hitY) {
		if(!playerIn.isRemote) {
		//	receiveEnergy(stack, maxReceive, false);
			extractEnergy(stack.getHeldItemMainhand(), maxExtract, false);
			Testmod.logger.info(getEnergyStored(stack.getHeldItemMainhand()));
			receiveEnergy(stack.getHeldItemMainhand(), maxReceive, false);
			Testmod.logger.info(getEnergyStored(stack.getHeldItemMainhand()));
		}
		
		
		return EnumActionResult.PASS;
	}

}
