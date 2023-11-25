package com.phlorish.phlorishtutorial.item;

import com.phlorish.phlorishtutorial.PhlorishTutorial;
import com.phlorish.phlorishtutorial.item.custom.FuelItem;
import com.phlorish.phlorishtutorial.item.custom.MetalDetectorItem;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PhlorishTutorial.MODID);

            public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
                () -> new Item(new Item.Properties()));
            public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire", 
                () -> new Item(new Item.Properties()));
            public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
                () -> new MetalDetectorItem(new Item.Properties().durability(100)));
            public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
                () -> new FuelItem(new Item.Properties().food(ModFoods.STRAWBERRY), 40));

            public static void register(IEventBus eventBus)
            {
                ITEMS.register(eventBus);
            }
}
