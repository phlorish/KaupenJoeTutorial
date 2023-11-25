package com.phlorish.phlorishtutorial.datagen;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import com.phlorish.phlorishtutorial.PhlorishTutorial;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider
{

    public ModItemTagsProvider(PackOutput pOutput, CompletableFuture<Provider> pLookupProvider,
            CompletableFuture<TagLookup<Block>> pBlockTags,
            @Nullable ExistingFileHelper existingFileHelper) 
    {
        super(pOutput, pLookupProvider, pBlockTags, PhlorishTutorial.MODID, existingFileHelper);
        //TODO Auto-generated constructor stub
    }
    
    @Override
    protected void addTags(Provider pProvider) 
    {
        
    }
}
