package alvin137.testmod.items;

import alvin137.testmod.blocks.RegisterBlocks;
import alvin137.testmod.gui.GuiGUITestBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RegisterItems {
	public static AttackTestItem atktestitem;
	public static Bat bat;
	public static TestItem testitem;

	public static void registerItem() {
		initItems();
	}

	public static void initItems() {
		atktestitem = new AttackTestItem();
		bat = new Bat();
		testitem = new TestItem();
	}

	@SideOnly(Side.CLIENT)
	public static void initClient() {
		atktestitem.initModel();
		bat.initModel();
		testitem.initModel();
	}
}
