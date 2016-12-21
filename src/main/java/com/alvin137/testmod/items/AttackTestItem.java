package com.alvin137.testmod.items;

import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AttackTestItem extends GenericItems {
	protected static String name = "atktestitem";
	public AttackTestItem() {
		super(name);
		ATTACK_DAMAGE_MODIFIER = UUID.fromString("33");
	}
}
