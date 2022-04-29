package com.wither.withersweapons.core.init;

import net.minecraft.world.entity.MobCategory;
import com.wither.withersweapons.WithersWeapons;
import com.wither.withersweapons.common.entities.ShadowFireBall;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;


@Mod.EventBusSubscriber(modid = WithersWeapons.MODID, bus = Bus.MOD)

public class InitEntity {

	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES,
			WithersWeapons.MODID);

	public static EntityType<ShadowFireBall> SHADOW_FIRE_BALL;
	


	@SuppressWarnings("unchecked")
	@SubscribeEvent
	public static void regsiterEntities(final RegistryEvent.Register<EntityType<?>> event) {
		IForgeRegistry<EntityType<?>> reg = event.getRegistry();
		reg.registerAll(
				
				// shadow fire ball
				EntityType.Builder.<ShadowFireBall>of(ShadowFireBall::new, MobCategory.MISC)
						.sized(0.3125F, 0.3125F).setShouldReceiveVelocityUpdates(true).clientTrackingRange(4).fireImmune()
						.updateInterval(10).build("")
						.setRegistryName(WithersWeapons.MODID, "shadow_fire_ball"));
				
			

		
						SHADOW_FIRE_BALL = (EntityType<ShadowFireBall>) reg
						.getValue(new ResourceLocation(WithersWeapons.MODID, "shadow_fire_ball"));
	
	



	}
}
