package alvin137.testmod.proxy;

import alvin137.testmod.blocks.RegisterBlocks;
import alvin137.testmod.blocks.tileentity.TileEntityGUITestBlock;
import alvin137.testmod.items.RegisterItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientConnectedToServerEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	public void preinit(FMLPreInitializationEvent e) {
		RegisterItems.registerItem();
		RegisterBlocks.registerBlock();
		
		GameRegistry.registerTileEntity(TileEntityGUITestBlock.class, "asdfasdf");
	}

	public void init(FMLInitializationEvent e) {
	}

	public void ontickpass(TickEvent.PlayerTickEvent e) {
	}

	public void proxy() {
	}

	public void onServerConnection(ClientConnectedToServerEvent e) {
	}
}
