package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import com.setycz.chickens.handler.SpawnType;
import com.setycz.chickens.registry.ChickensRegistryItem;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ExNihiloCreatioAddon extends BaseModAddon
{
	public static ExNihiloCreatioAddon INSTANCE;

	@GameRegistry.ObjectHolder("exnihilocreatio:block_dust")
	public static final Item blockDust = null;
	@GameRegistry.ObjectHolder("exnihilocreatio:block_netherrack_crushed")
	public static final Item blockNetherrackCrushed = null;
	@GameRegistry.ObjectHolder("exnihilocreatio:block_endstone_crushed")
	public static final Item blockEndstoneCrushed = null;
	
	public static ChickensRegistryItem dustChicken = null;
	public static ChickensRegistryItem netherrackCrushedChicken = null;
	public static ChickensRegistryItem endstoneCrushedChicken = null;
	
	public ExNihiloCreatioAddon() 
	{
		super("exnihilocreatio", "Ex Nihilo Creatio", "textures/entity/exnihilocreatio/");
		setStartID(2230);
		INSTANCE = this;
	}

	@Override
	public List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> allChickens) 
	{
		ItemStack itemStackBlockDust = new ItemStack(blockDust, 1, 0);
		dustChicken = addChicken(allChickens, 
				"dustChicken", 
				this.nextID(), 
				"dust_chicken.png", 
				itemStackBlockDust, 
				0xDDD7A6, 0xE9E8D3, 
				SpawnType.NONE);
		
		ItemStack itemStackBlockNetherrackCrushed = new ItemStack(blockNetherrackCrushed, 1, 0);
		netherrackCrushedChicken = addChicken(allChickens, 
				"netherrackCrushedChicken", 
				this.nextID(), 
				"netherrack_crushed_chicken.png", 
				itemStackBlockNetherrackCrushed, 
				0xDDD7A6, 0x391010, 
				SpawnType.NONE);
		
		ItemStack itemStackBlockEndstoneCrushed = new ItemStack(blockEndstoneCrushed, 1, 0);
		endstoneCrushedChicken = addChicken(allChickens, 
				"endstoneCrushedChicken", 
				this.nextID(), 
				"endstone_crushed_chicken.png", 
				itemStackBlockEndstoneCrushed, 
				0xDDD7A6, 0xD3D7A1, 
				SpawnType.NONE);
	
		return allChickens;
	}

	@Override
	public void RegisterAllParents(List<ChickensRegistryItem> allChickens) 
	{
		setParents(dustChicken, ClayChicken, LavaChicken);
		setParents(netherrackCrushedChicken, LavaChicken, RedstoneChicken);
		setParents(endstoneCrushedChicken, LavaChicken, GlowstoneChicken);
	}
}