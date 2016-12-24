package alvin137.testmod.blocks;

import alvin137.testmod.Testmod;
import alvin137.testmod.items.RegisterItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GenericBlocks extends Block {

	public GenericBlocks(Material materialIn, String name) {
		super(materialIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Testmod.tabtestmod);
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this), getRegistryName());
	}

	@Override
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		System.out.println("Debugged! Checked! Finshed!");
		if (playerIn.getHeldItemMainhand().getClass().equals(RegisterItems.testitem.getClass())) {
			System.out.println("Debugged! Checked! Finshed!");
		}
	}

	@SideOnly(Side.CLIENT)
	public void initModel() {

	}

}
