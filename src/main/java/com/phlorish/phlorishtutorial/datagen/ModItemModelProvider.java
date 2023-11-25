package com.phlorish.phlorishtutorial.datagen;

import com.phlorish.phlorishtutorial.PhlorishTutorial;
import com.phlorish.phlorishtutorial.item.ModItems;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
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
        simpleItem(ModItems.SAPPHIRE);
        simpleItem(ModItems.RAW_SAPPHIRE);

        simpleItem(ModItems.STRAWBERRY);

        simpleItem(ModItems.METAL_DETECTOR);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
             new ResourceLocation("item/generated")).texture("layer0",
             new ResourceLocation(PhlorishTutorial.MODID, "item/" + item.getId().getPath()));
    }
}
