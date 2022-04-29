package com.wither.withersweapons.core.init;

import java.util.List;

import com.wither.withersweapons.WithersWeapons;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

public class ItemTiers {
	// int level, int uses, float speed, float attackDamageBonus, int
	// enchantmentValue

	
	public static final Tier VALORIN = TierSortingRegistry.registerTier(
			// harvestLevel, uses, toolSpeed, damage, enchantability
			new ForgeTier(4, 3200, 6.7f, 0.0f, 20,
					BlockTags.create(new ResourceLocation(WithersWeapons.MODID, "needs_valorin_tool")),
					() -> Ingredient.of(Items.NETHERITE_INGOT)),
			new ResourceLocation(WithersWeapons.MODID, "valorin"), List.of(Tiers.NETHERITE), List.of());
	
	
	public static final Tier PRIME = TierSortingRegistry.registerTier(
			// harvestLevel, uses, toolSpeed, damage, enchantability
			new ForgeTier(2, 745, 6.0F, 0.0F, 14,
					BlockTags.create(new ResourceLocation(WithersWeapons.MODID, "needs_great_tool")),
					() -> Ingredient.of(Items.IRON_INGOT)),
			new ResourceLocation(WithersWeapons.MODID, "great"), List.of(Tiers.IRON), List.of());

}