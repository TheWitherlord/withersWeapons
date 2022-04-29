package com.wither.withersweapons.core.init;

import com.wither.withersweapons.WithersWeapons;
import com.wither.withersweapons.common.items.PrimeAxeItem;
import com.wither.withersweapons.common.items.ValorinSwordItem;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class InitItem {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WithersWeapons.MODID);

	/**
	 * Items
	 */

	// The Swords
	public static final RegistryObject<Item> VALORIN = ITEMS.register("valorin",
			() -> new ValorinSwordItem(ItemTiers.VALORIN, 9, -3.0f,
					itemBuilder().rarity(Rarity.EPIC).fireResistant().stacksTo(1).tab(WithersWeapons.tab)));
	
	public static final RegistryObject<Item> VALORIN_UNPOWERED = ITEMS.register("valorin_unpowered",
			() -> new SwordItem(ItemTiers.VALORIN, 8, -3.0f,
					itemBuilder().rarity(Rarity.UNCOMMON).fireResistant().stacksTo(1).tab(WithersWeapons.tab)));
	
	public static final RegistryObject<Item> PRIME_AXE = ITEMS.register("prime_axe_staff",
			() -> new PrimeAxeItem(ItemTiers.PRIME, 8, -2.8f,
					itemBuilder().stacksTo(1).tab(WithersWeapons.tab)));

	private static Item.Properties itemBuilder() {
		return new Item.Properties();
	}
}