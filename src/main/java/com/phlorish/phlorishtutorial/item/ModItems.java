package com.phlorish.phlorishtutorial.item;

import com.phlorish.phlorishtutorial.PhlorishTutorial;
import com.phlorish.phlorishtutorial.item.custom.FuelItem;
import com.phlorish.phlorishtutorial.item.custom.MetalDetectorItem;
import com.phlorish.phlorishtutorial.item.custom.ModArmorItem;

import net.minecraft.world.item.*;
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

            public static final RegistryObject<Item> SAPPHIRE_STAFF = ITEMS.register("sapphire_staff",
                () -> new Item(new Item.Properties().stacksTo(1)));
            public static final RegistryObject<Item> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword",
                () -> new SwordItem(ModToolTiers.SAPPHIRE, 4, 2.0f,
                    new Item.Properties().stacksTo(1)));
            public static final RegistryObject<Item> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe",
                () -> new PickaxeItem(ModToolTiers.SAPPHIRE, 3, 1.0f,
                    new Item.Properties().stacksTo(1)));
            public static final RegistryObject<Item> SAPPHIRE_AXE = ITEMS.register("sapphire_axe",
                () -> new AxeItem(ModToolTiers.SAPPHIRE, 5, 1.0f,
                    new Item.Properties().stacksTo(1)));
            public static final RegistryObject<Item> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel",
                () -> new ShovelItem(ModToolTiers.SAPPHIRE, 0, 0.0f,
                    new Item.Properties().stacksTo(1)));
            public static final RegistryObject<Item> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe",
                () -> new HoeItem(ModToolTiers.SAPPHIRE, 0, 0.0f,
                    new Item.Properties().stacksTo(1)));

            public static final RegistryObject<Item> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet",
                () -> new ModArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.HELMET, new Item.Properties()));
            public static final RegistryObject<Item> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate",
                () -> new ModArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
            public static final RegistryObject<Item> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings",
                () -> new ModArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
            public static final RegistryObject<Item> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots",
                () -> new ModArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.BOOTS, new Item.Properties()));

            public static void register(IEventBus eventBus)
            {
                ITEMS.register(eventBus);
            }
}
