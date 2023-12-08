package com.phlorish.phlorishtutorial.datagen;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import com.phlorish.phlorishtutorial.PhlorishTutorial;
import com.phlorish.phlorishtutorial.block.ModBlocks;
import com.phlorish.phlorishtutorial.util.ModTags;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagGenerator extends BlockTagsProvider
{

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<Provider> lookupProvider,
            @Nullable ExistingFileHelper existingFileHelper) 
    {
        super(output, lookupProvider, PhlorishTutorial.MODID, existingFileHelper);
    }
    
    @Override
    protected void addTags(Provider pProvider) 
    {
        this.tag(ModTags.Blocks.DETECTABLE_METALS)
            .add(ModBlocks.SAPPHIRE_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(ModBlocks.SAPPHIRE_BLOCK.get(),
                ModBlocks.RAW_SAPPHIRE_BLOCK.get(),
                ModBlocks.SAPPHIRE_ORE.get(),
                ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                ModBlocks.NETHER_SAPPHIRE_ORE.get(),
                ModBlocks.END_STONE_SAPPHIRE_ORE.get(),
                ModBlocks.SOUND_BLOCK.get(),
                ModBlocks.SAPPHIRE_BARREL.get(),
                ModBlocks.SAPPHIRE_BUTTON.get(),
                ModBlocks.SAPPHIRE_DOOR.get(),
                ModBlocks.SAPPHIRE_FENCE.get(),
                ModBlocks.SAPPHIRE_FENCE_GATE.get(),
                ModBlocks.SAPPHIRE_PRESSURE_PLATE.get(),
                ModBlocks.SAPPHIRE_SLAB.get(),
                ModBlocks.SAPPHIRE_STAIRS.get(),
                ModBlocks.SAPPHIRE_TRAPDOOR.get(),
                ModBlocks.SAPPHIRE_WALL.get());

        this.tag(ModTags.Blocks.NEEDS_SAPPHIRE_TOOL)
            .add(ModBlocks.SAPPHIRE_BLOCK.get(),
                ModBlocks.RAW_SAPPHIRE_BLOCK.get(),
                ModBlocks.SAPPHIRE_ORE.get(),
                ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                ModBlocks.NETHER_SAPPHIRE_ORE.get(),
                ModBlocks.END_STONE_SAPPHIRE_ORE.get(),
                ModBlocks.SAPPHIRE_BARREL.get(),
                ModBlocks.SAPPHIRE_BUTTON.get(),
                ModBlocks.SAPPHIRE_DOOR.get(),
                ModBlocks.SAPPHIRE_FENCE.get(),
                ModBlocks.SAPPHIRE_FENCE_GATE.get(),
                ModBlocks.SAPPHIRE_PRESSURE_PLATE.get(),
                ModBlocks.SAPPHIRE_SLAB.get(),
                ModBlocks.SAPPHIRE_STAIRS.get(),
                ModBlocks.SAPPHIRE_TRAPDOOR.get(),
                ModBlocks.SAPPHIRE_WALL.get());

        this.tag(BlockTags.FENCES)
            .add((ModBlocks.SAPPHIRE_FENCE.get()));
        this.tag(BlockTags.FENCE_GATES)
            .add((ModBlocks.SAPPHIRE_FENCE_GATE.get()));
        this.tag(BlockTags.WALLS)
            .add((ModBlocks.SAPPHIRE_WALL.get()));
    }
}
