package alvin137.testmod;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

import java.util.Arrays;
import java.util.List;

/**
 * @author Dries007
 */
public class MTRMCommand extends CommandBase {
	@Override
	public List<String> getAliases() {
		return Arrays.asList("mtrm");
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (sender instanceof EntityPlayer)
			((EntityPlayer) sender).openGui(Testmod.instance, 0, sender.getEntityWorld(), 0, 0, 0);
	}

	@Override
	public String getName() {
		return "minetweakerrecipemaker";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "Step 4: PROFIT?";
	}

	// @Override
	// public boolean canCommandSenderUseCommand(ICommandSender p_71519_1_)
	// {
	// return MinecraftServer.getServer().isSinglePlayer() ||
	// super.canCommandSenderUseCommand(p_71519_1_);
	// }

}