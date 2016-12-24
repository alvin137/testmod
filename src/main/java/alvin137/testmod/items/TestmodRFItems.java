package alvin137.testmod.items;

import cofh.api.energy.IEnergyContainerItem;
import cofh.api.energy.ItemEnergyContainer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TestmodRFItems extends GenericItems implements IEnergyContainerItem {

	protected int capacity;
	protected int maxReceive;
	protected int maxExtract;

	public TestmodRFItems(String name) {
		super(name);
	}

	public TestmodRFItems(int capacity, String name) {

		this(capacity, capacity, capacity, name);
	}

	public TestmodRFItems(int capacity, int maxTransfer, String name) {

		this(capacity, maxTransfer, maxTransfer, name);
	}

	public TestmodRFItems(int capacity, int maxReceive, int maxExtract, String name) {
		super(name);
		this.capacity = capacity;
		this.maxReceive = maxReceive;
		this.maxExtract = maxExtract;
	}

	public TestmodRFItems setCapacity(int capacity) {

		this.capacity = capacity;
		return this;
	}

	public TestmodRFItems setMaxTransfer(int maxTransfer) {

		setMaxReceive(maxTransfer);
		setMaxExtract(maxTransfer);
		return this;
	}

	public TestmodRFItems setMaxReceive(int maxReceive) {

		this.maxReceive = maxReceive;
		return this;
	}

	public TestmodRFItems setMaxExtract(int maxExtract) {

		this.maxExtract = maxExtract;
		return this;
	}

	/* IEnergyContainerItem */
	@Override
	public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {

		if (!container.hasTagCompound()) {
			container.setTagCompound(new NBTTagCompound());
		}
		int energy = container.getTagCompound().getInteger("Energy");
		int energyReceived = Math.min(capacity - energy, Math.min(this.maxReceive, maxReceive));

		if (!simulate) {
			energy += energyReceived;
			container.getTagCompound().setInteger("Energy", energy);
		}
		return energyReceived;
	}

	@Override
	public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {

		if (container.getTagCompound() == null || !container.getTagCompound().hasKey("Energy")) {
			return 0;
		}
		int energy = container.getTagCompound().getInteger("Energy");
		int energyExtracted = Math.min(energy, Math.min(this.maxExtract, maxExtract));

		if (!simulate) {
			energy -= energyExtracted;
			container.getTagCompound().setInteger("Energy", energy);
		}
		return energyExtracted;
	}

	@Override
	public int getEnergyStored(ItemStack container) {

		if (container.getTagCompound() == null || !container.getTagCompound().hasKey("Energy")) {
			return 0;
		}
		return container.getTagCompound().getInteger("Energy");
	}

	@Override
	public int getMaxEnergyStored(ItemStack container) {

		return capacity;
	}

}
