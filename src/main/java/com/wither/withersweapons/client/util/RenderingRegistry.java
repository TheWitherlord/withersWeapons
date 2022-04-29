package com.wither.withersweapons.client.util;

import com.wither.withersweapons.WithersWeapons;
import com.wither.withersweapons.common.entities.render.ShadowFireBallRenderer;
import com.wither.withersweapons.core.init.InitEntity;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = WithersWeapons.MODID, bus = Bus.MOD)
public class RenderingRegistry {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onClientSetUpEvent(EntityRenderersEvent.RegisterRenderers event) {
    	
    
            event.registerEntityRenderer(InitEntity.SHADOW_FIRE_BALL, ShadowFireBallRenderer::new);


    

    }
    }
