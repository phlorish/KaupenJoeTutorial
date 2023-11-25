package com.phlorish.phlorishtutorial.item.custom;

import org.jetbrains.annotations.Nullable;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

public class FuelItem extends Item
{
    private int burnTime = 0;

    public FuelItem(Properties pProperties, int burnTime) {
        super(pProperties);
        this.burnTime = burnTime;
        //TODO Auto-generated constructor stub
    }
    
    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        // TODO Auto-generated method stub
        return this.burnTime;
    }
}
