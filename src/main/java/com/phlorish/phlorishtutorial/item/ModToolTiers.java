package com.phlorish.phlorishtutorial.item;

import java.util.List;

import com.phlorish.phlorishtutorial.PhlorishTutorial;
import com.phlorish.phlorishtutorial.util.ModTags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

public class ModToolTiers 
{
    public static final Tier SAPPHIRE = TierSortingRegistry.registerTier(
        new ForgeTier(5, 1500, 5.0f, 4.0f, 25, 
            ModTags.Blocks.NEEDS_SAPPHIRE_TOOL, () -> Ingredient.of(ModItems.SAPPHIRE.get())),
            new ResourceLocation(PhlorishTutorial.MODID, "sapphire"), List.of(Tiers.NETHERITE), List.of());
}
