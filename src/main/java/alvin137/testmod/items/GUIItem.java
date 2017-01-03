package alvin137.testmod.items;

import alvin137.testmod.Testmod;
import alvin137.testmod.blocks.tileentity.TileEntityGUITestBlock;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GUIItem extends GenericItems {

	public GUIItem() {
		super("guiitem");
		// TODO Auto-generated constructor stub
		
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer stack, World playerIn, BlockPos worldIn, EnumHand pos,
			EnumFacing hand, float facing, float hitX, float hitY) {
		if (!playerIn.isRemote) {
			TileEntity tileentity = new TileEntityGUITestBlock();
			stack.displayGUIChest((TileEntityGUITestBlock)tileentity);
            stack.addStat(StatList.FURNACE_INTERACTION);
            Testmod.logger.info("Activated");
		}
		return EnumActionResult.PASS;
	}

}
