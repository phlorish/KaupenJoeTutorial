package com.phlorish.phlorishtutorial.datagen;

import com.phlorish.phlorishtutorial.PhlorishTutorial;
import com.phlorish.phlorishtutorial.block.ModBlocks;
import com.phlorish.phlorishtutorial.item.ModItems;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider
{

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) 
    {
        super(output, PhlorishTutorial.MODID, existingFileHelper);
        //TODO Auto-generated constructor stub
    }
    

    @Override
    protected void registerModels() 
    {
        itemModelFromTexture(ModItems.SAPPHIRE);
        itemModelFromTexture(ModItems.RAW_SAPPHIRE);
        itemModelFromTexture(ModItems.STRAWBERRY);
        itemModelFromTexture(ModItems.METAL_DETECTOR);
        itemModelFromTexture(ModBlocks.SAPPHIRE_DOOR, true);

        withExistingParent(nameFromBlock(ModBlocks.SAPPHIRE_PRESSURE_PLATE), locationFromBlock(ModBlocks.SAPPHIRE_PRESSURE_PLATE));
        withExistingParent(nameFromBlock(ModBlocks.SAPPHIRE_FENCE_GATE), locationFromBlock(ModBlocks.SAPPHIRE_FENCE_GATE));
        withExistingParent(nameFromBlock(ModBlocks.SAPPHIRE_STAIRS), locationFromBlock(ModBlocks.SAPPHIRE_STAIRS));
        withExistingParent(nameFromBlock(ModBlocks.SAPPHIRE_SLAB), locationFromBlock(ModBlocks.SAPPHIRE_SLAB));
        withExistingParent(nameFromBlock(ModBlocks.SAPPHIRE_TRAPDOOR), locationFromBlock(ModBlocks.SAPPHIRE_TRAPDOOR, "_bottom"));

        buttonInventory(nameFromBlock(ModBlocks.SAPPHIRE_BUTTON), locationFromBlock(ModBlocks.SAPPHIRE_BLOCK));
        fenceInventory(nameFromBlock(ModBlocks.SAPPHIRE_FENCE), locationFromBlock(ModBlocks.SAPPHIRE_BLOCK));
        wallInventory(nameFromBlock(ModBlocks.SAPPHIRE_WALL), locationFromBlock(ModBlocks.SAPPHIRE_BLOCK));
    }

    private void itemModelFromTexture(RegistryObject<Item> item)
    {
        withExistingParent(nameFromItem(item),
             new ResourceLocation("item/generated")).texture("layer0", locationFromItem(item));
    }

    private void itemModelFromTexture(RegistryObject<Block> block, boolean isBlock) 
    {
        withExistingParent(nameFromBlock(block),
                new ResourceLocation("item/generated")).texture("layer0", locationFromBlockasItem(block));
    }

    private ResourceLocation locationFromItem(RegistryObject<Item> item)
    {
        return modLoc("item/" + nameFromItem(item));
    }

    private ResourceLocation locationFromBlock(RegistryObject<Block> block)
    {
        return modLoc("block/" + nameFromBlock(block));
    }

    private ResourceLocation locationFromBlock(RegistryObject<Block> block, String addendum)
    {
        return modLoc("block/" + nameFromBlock(block) + addendum);
    }

    private ResourceLocation locationFromBlockasItem(RegistryObject<Block> block)
    {
        return modLoc("item/" + nameFromBlock(block));
    }

    private String nameFromItem(RegistryObject<Item> item)
    {
        return item.getId().getPath();
    }

    private String nameFromBlock(RegistryObject<Block> block)
    {
        return block.getId().getPath();
    }
}
