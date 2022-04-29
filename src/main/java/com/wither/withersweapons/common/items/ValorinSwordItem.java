package com.wither.withersweapons.common.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import com.wither.withersweapons.common.entities.ShadowFireBall;

public class ValorinSwordItem extends SwordItem {

	public ValorinSwordItem(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
		super(p_43269_, p_43270_, p_43271_, p_43272_);

	}

	private static final int COOLDOWN = 120;

	protected int getCooldown(final ItemStack launcher) {
		return COOLDOWN;
	}

	private boolean isAmmoRequired(final ItemStack stack, final Player player) {
		return false;
	}

	public int getDefaultProjectileRange() {
		return 15;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(final Level level, final Player player, final InteractionHand hand) {
		final ItemStack heldItem = player.getItemInHand(hand);

		final boolean ammoRequired = isAmmoRequired(heldItem, player);
		final ItemStack ammo = player.getProjectile(heldItem);
		final boolean hasAmmo = !ammo.isEmpty();

		if (!ammoRequired || hasAmmo) {
			final int cooldown = getCooldown(heldItem);
			if (cooldown > 0) {
				player.getCooldowns().addCooldown(this, cooldown);
			}

			level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.PLAYER_ATTACK_STRONG,
					SoundSource.NEUTRAL, 0.5f, 0.4f / (level.random.nextFloat() * 0.4f + 0.8f));

			if (!level.isClientSide) {
				ShadowFireBall natureball = new ShadowFireBall(level, player, player.getLookAngle().x * 1,
						player.getLookAngle().y * 1, player.getLookAngle().z * 1);
				natureball.setPos(natureball.getX(), player.getY() + player.getEyeHeight(), natureball.getZ());
				level.addFreshEntity(natureball);
			}

			if (ammoRequired) {
				ammo.shrink(1);
				heldItem.hurtAndBreak(1, player, (Player) -> {
					player.broadcastBreakEvent(player.getUsedItemHand());
				});
				if (ammo.isEmpty()) {
					player.getInventory().removeItem(ammo);

				}
			}

			return new InteractionResultHolder<>(InteractionResult.SUCCESS, heldItem);
		}

		return new InteractionResultHolder<>(InteractionResult.FAIL, heldItem);

	}

	@Override
	public UseAnim getUseAnimation(ItemStack p_40678_) {
		return UseAnim.BOW;
	}
	
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.setRemainingFireTicks(100);
		return super.hurtEnemy(stack, target, attacker);
	}

	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
		return repair.getItem() == Items.NETHERITE_INGOT;
	}

	@Override
			public void inventoryTick(final ItemStack stack, final Level world, final Entity entity, final int itemSlot, final boolean isSelected) {
				super.inventoryTick(stack, world, entity, itemSlot, isSelected);
				

				if (((LivingEntity) entity).getItemInHand(InteractionHand.MAIN_HAND).getItem() == this || ((LivingEntity) entity).getItemInHand(InteractionHand.OFF_HAND).getItem() == this) {
					((LivingEntity) entity).removeEffectNoUpdate(MobEffects.WITHER);
				}
	}
}
