package com.phlorish.phlorishtutorial.util;

import com.phlorish.phlorishtutorial.PhlorishTutorial;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags 
{
    public static class Blocks
    {
        public static final TagKey<Block> DETECTABLE_METALS = tag("detectable_metals");
        
        private static TagKey<Block> tag(String name)
        {
            return BlockTags.create(new ResourceLocation(PhlorishTutorial.MODID, name));
        }
    }

    public static class Items
    {
        private static TagKey<Item> tag(String name)
        {
            return ItemTags.create(new ResourceLocation(PhlorishTutorial.MODID, name));
        }
    }
}
