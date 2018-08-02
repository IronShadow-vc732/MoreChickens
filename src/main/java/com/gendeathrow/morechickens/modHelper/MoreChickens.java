package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import com.gendeathrow.morechickens.core.ChickensMore;
import com.gendeathrow.morechickens.core.ModItems;
import com.setycz.chickens.handler.SpawnType;
import com.setycz.chickens.registry.ChickensRegistryItem;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MoreChickens extends BaseModAddon
{
	@GameRegistry.ObjectHolder("minecraft:dirt")
	public static final Item blockDirt = null;
	@GameRegistry.ObjectHolder("minecraft:cobblestone")
	public static final Item blockCobblestone = null;
	@GameRegistry.ObjectHolder("minecraft:gravel")
	public static final Item blockGravel = null;
	
	public static ChickensRegistryItem xpChicken;
	public static ChickensRegistryItem dirtChicken;
	public static ChickensRegistryItem cobblestoneChicken;
	public static ChickensRegistryItem gravelChicken;
	
	public MoreChickens() 
	{
		super(ChickensMore.MODID, ChickensMore.NAME, "textures/entity/");

		this.setNeedsModPresent(false);
		this.setStartID(500);
	}

	@Override
	public List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> allChickens) 
	{
        xpChicken = addChicken(allChickens, 
				"xpChicken", 
				this.nextID(), 
				"xp_chicken.png", 
				new ItemStack(ModItems.solidXp, 1 , 0), 
				0x3dff1e, 0x3ff123, 
				SpawnType.NONE); 
        		
		ItemStack itemStackBlockDirt = new ItemStack(blockDirt, 1, 0);
        dirtChicken = addChicken(allChickens, 
				"dirtChicken", 
				this.nextID(), 
				"dirt_chicken.png", 
				itemStackBlockDirt, 
				0xDDD7A6, 0xB9855C, 
				SpawnType.NONE); 

		ItemStack itemStackBlockCobblestone = new ItemStack(blockCobblestone, 1, 0);
		cobblestoneChicken = addChicken(allChickens, 
				"cobblestoneChicken", 
				this.nextID(), 
				"cobblestone_chicken.png", 
				itemStackBlockCobblestone, 
				0xDDD7A6, 0x9A9A9A, 
				SpawnType.NONE); 

		ItemStack itemStackBlockGravel = new ItemStack(blockGravel, 1, 0);
		gravelChicken = addChicken(allChickens, 
				"gravelChicken", 
				this.nextID(), 
				"gravel_chicken.png", 
				itemStackBlockGravel, 
				0xDDD7A6, 0xAA9E98, 
				SpawnType.NONE); 
        
        return allChickens;
	}

	@Override
	public void RegisterAllParents(List<ChickensRegistryItem> allChickens) 
	{
		setParents(xpChicken, EmeraldChicken, GreenChicken);
		setParents(dirtChicken, WhiteChicken, GreenChicken);
		setParents(cobblestoneChicken, LavaChicken, WaterChicken);
		setParents(gravelChicken, cobblestoneChicken, FlintChicken);
	}

}
