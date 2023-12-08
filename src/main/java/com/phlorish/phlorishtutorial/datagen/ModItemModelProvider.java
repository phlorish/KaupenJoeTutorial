package com.phlorish.phlorishtutorial.datagen;

import java.util.LinkedHashMap;

import com.phlorish.phlorishtutorial.PhlorishTutorial;
import com.phlorish.phlorishtutorial.block.ModBlocks;
import com.phlorish.phlorishtutorial.item.ModItems;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider
{
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }


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

        trimmedArmorItem(ModItems.SAPPHIRE_HELMET);
        trimmedArmorItem(ModItems.SAPPHIRE_CHESTPLATE);
        trimmedArmorItem(ModItems.SAPPHIRE_LEGGINGS);
        trimmedArmorItem(ModItems.SAPPHIRE_BOOTS);

        itemModelFromTextureHandheld(ModItems.SAPPHIRE_SWORD);
        itemModelFromTextureHandheld(ModItems.SAPPHIRE_PICKAXE);
        itemModelFromTextureHandheld(ModItems.SAPPHIRE_AXE);
        itemModelFromTextureHandheld(ModItems.SAPPHIRE_SHOVEL);
        itemModelFromTextureHandheld(ModItems.SAPPHIRE_HOE);

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

    private void itemModelFromTextureHandheld(RegistryObject<Item> item)
    {
        withExistingParent(nameFromItem(item),
             new ResourceLocation("item/handheld")).texture("layer0", locationFromItem(item));
    }

    private void itemModelFromTexture(RegistryObject<Block> block, boolean isBlock) 
    {
        withExistingParent(nameFromBlock(block),
                new ResourceLocation("item/generated")).texture("layer0", locationFromBlockasItem(block));
    }

    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = PhlorishTutorial.MODID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
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
