package com.phlorish.phlorishtutorial.block;

import java.util.function.Supplier;

import com.phlorish.phlorishtutorial.PhlorishTutorial;
import com.phlorish.phlorishtutorial.block.custom.SoundBlock;
import com.phlorish.phlorishtutorial.item.ModItems;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks 
{
    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, PhlorishTutorial.MODID);

    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block", 
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));
    public static final RegistryObject<Block> RAW_SAPPHIRE_BLOCK = registerBlock("raw_sapphire_block", 
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore",
        () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE), UniformInt.of(3,6)));
    public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
        () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE), UniformInt.of(3,6)));
    public static final RegistryObject<Block> NETHER_SAPPHIRE_ORE = registerBlock("nether_sapphire_ore",
        () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_QUARTZ_ORE), UniformInt.of(3,6)));
    public static final RegistryObject<Block> END_STONE_SAPPHIRE_ORE = registerBlock("end_stone_sapphire_ore",
        () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE).strength(5).requiresCorrectToolForDrops(), UniformInt.of(3,6)));

    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block", 
        () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.NOTE_BLOCK)));

    public static final RegistryObject<Block> SAPPHIRE_STAIRS = registerBlock("sapphire_stairs", 
        () -> new StairBlock(() -> ModBlocks.SAPPHIRE_BLOCK.get().defaultBlockState(), 
            BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));
    public static final RegistryObject<Block> SAPPHIRE_SLAB = registerBlock("sapphire_slab", 
        () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));

    public static final RegistryObject<Block> SAPPHIRE_BUTTON = registerBlock("sapphire_button", 
        () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
            BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> SAPPHIRE_PRESSURE_PLATE = registerBlock("sapphire_pressure_plate", 
        () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK), BlockSetType.IRON));

    public static final RegistryObject<Block> SAPPHIRE_FENCE = registerBlock("sapphire_fence", 
        () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));
    public static final RegistryObject<Block> SAPPHIRE_FENCE_GATE = registerBlock("sapphire_fence_gate", 
        () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK), SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, 
            SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF));
    public static final RegistryObject<Block> SAPPHIRE_WALL = registerBlock("sapphire_wall", 
        () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));

    public static final RegistryObject<Block> SAPPHIRE_DOOR = registerBlock("sapphire_door", 
        () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).noOcclusion(), BlockSetType.IRON));
    public static final RegistryObject<Block> SAPPHIRE_TRAPDOOR = registerBlock("sapphire_trapdoor", 
        () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).noOcclusion(), BlockSetType.IRON));

    public static final RegistryObject<Block> SAPPHIRE_BARREL = registerBlock("sapphire_barrel", 
        () -> new BarrelBlock(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void  register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
