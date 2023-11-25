package com.phlorish.phlorishtutorial.datagen.loot;

import java.util.Set;

import com.phlorish.phlorishtutorial.block.ModBlocks;
import com.phlorish.phlorishtutorial.item.ModItems;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLootSubProvider
{
    public ModBlockLootTables() 
    {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
        //TODO Auto-generated constructor stub
    }

    @Override
    protected void generate() 
    {
        this.dropSelf(ModBlocks.SAPPHIRE_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());

        this.add(ModBlocks.SAPPHIRE_ORE.get(), 
            createBundledOreDrops(ModBlocks.SAPPHIRE_ORE.get(),ModItems.RAW_SAPPHIRE.get()));
        this.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), 
            createBundledOreDrops(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),ModItems.RAW_SAPPHIRE.get()));
        this.add(ModBlocks.NETHER_SAPPHIRE_ORE.get(), 
            createBundledOreDrops(ModBlocks.NETHER_SAPPHIRE_ORE.get(),ModItems.RAW_SAPPHIRE.get()));
        this.add(ModBlocks.END_STONE_SAPPHIRE_ORE.get(), 
            createBundledOreDrops(ModBlocks.END_STONE_SAPPHIRE_ORE.get(),ModItems.RAW_SAPPHIRE.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() 
    {
        // TODO Auto-generated method stub
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    protected LootTable.Builder createBundledOreDrops(Block pBlock, Item item) 
    {
      return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F))).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }
}
