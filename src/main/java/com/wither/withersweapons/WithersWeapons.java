package com.wither.withersweapons;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wither.withersweapons.core.init.InitEntity;
import com.wither.withersweapons.core.init.InitItem;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("withersweapons")
public class WithersWeapons {
	
	  public static CreativeModeTab tab = new CreativeModeTab("withersweapons") {
		  
		  @Override
		    public ItemStack makeIcon() {
		      return new ItemStack(Items.IRON_SWORD);
		    }
		  };


	
	public static final Logger LOGGER;
	public static final String MODID = "withersweapons";

	public WithersWeapons() {
		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		bus.addListener(this::setup);
		bus.addListener(this::Client);

		 InitItem.ITEMS.register(bus);
         InitEntity.ENTITIES.register(bus);


		 
		MinecraftForge.EVENT_BUS.register((Object) this);

	}

	private void setup(final FMLCommonSetupEvent event) {
		WithersWeapons.LOGGER.info("Preinitialized");


	}

	private void Client(final FMLClientSetupEvent event) {
		//ItemModelProperties.defineRenders();
	}

	

	

	static {
        LOGGER = LogManager.getLogger();
	}
}
		