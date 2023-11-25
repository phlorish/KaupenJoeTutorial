package com.phlorish.phlorishtutorial.datagen;

import java.util.List;
import java.util.function.Consumer;

import com.phlorish.phlorishtutorial.PhlorishTutorial;
import com.phlorish.phlorishtutorial.block.ModBlocks;
import com.phlorish.phlorishtutorial.item.ModItems;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    public static final List<ItemLike> SAPPHIRE_SMELTABLES = List.of(ModItems.RAW_SAPPHIRE.get(),
        ModBlocks.SAPPHIRE_ORE.get(), ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModBlocks.NETHER_SAPPHIRE_ORE.get(),
        ModBlocks.END_STONE_SAPPHIRE_ORE.get());


    public ModRecipeProvider(PackOutput pOutput) 
    {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) 
    {
        oreBlasting(pWriter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25f, 100, "sapphire");
        oreSmelting(pWriter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25f, 200, "sapphire");
    
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get())
            .pattern("SSS")
            .pattern("SSS")
            .pattern("SSS")
            .define('S', ModItems.SAPPHIRE.get())
            .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
            .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 9)
            .requires(ModBlocks.SAPPHIRE_BLOCK.get())
            .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
            .save(pWriter);
    }
    
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, 
        List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, 
        float pExperience, int pCookingTIme, String pGroup) 
    {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, 
            pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, 
        List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, 
        float pExperience, int pCookingTime, String pGroup) 
    {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, 
            pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, 
        RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, 
        List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, 
        float pExperience, int pCookingTime, String pGroup, String pRecipeName) 
    {
        for(ItemLike itemlike : pIngredients) 
        {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, 
                pExperience, pCookingTime, pCookingSerializer).group(pGroup)
                .unlockedBy(getHasName(itemlike), has(itemlike))
                .save(pFinishedRecipeConsumer, PhlorishTutorial.MODID + ":" + getItemName(pResult)
                 + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
