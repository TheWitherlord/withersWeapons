package com.wither.withersweapons.common.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class PrimeAxeItem extends AxeItem{

	public PrimeAxeItem(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
		super(p_43269_, p_43270_, p_43271_, p_43272_);
	}
	
	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
		return repair.getItem() == Items.IRON_INGOT;
	}

	@Override
			public void inventoryTick(final ItemStack stack, final Level world, final Entity entity, final int itemSlot, final boolean isSelected) {
				super.inventoryTick(stack, world, entity, itemSlot, isSelected);
				

				if (((LivingEntity) entity).getItemInHand(InteractionHand.MAIN_HAND).getItem() == this || ((LivingEntity) entity).getItemInHand(InteractionHand.OFF_HAND).getItem() == this) {
					((LivingEntity) entity)	.addEffect(new MobEffectInstance(MobEffects.JUMP, 5, 3, true, false));

				}
	}
}