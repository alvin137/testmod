package com.alvin137.testmod.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TestItem extends GenericItems {
	protected static String name = "testitem";
	public TestItem() {
		super(name);
	}
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		if(!worldIn.isRemote) {
		Block blockIn = worldIn.getBlockState(pos).getBlock();
		System.out.println("BlockName : " + blockIn.getUnlocalizedName());
		System.out.println("ModName : " + blockIn.getRegistryName().getResourceDomain());
		}
        return EnumActionResult.PASS;
    }
}
