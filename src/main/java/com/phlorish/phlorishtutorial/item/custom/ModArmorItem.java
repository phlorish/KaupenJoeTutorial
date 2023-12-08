package com.phlorish.phlorishtutorial.item.custom;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.phlorish.phlorishtutorial.item.ModArmorMaterials;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ModArmorItem extends ArmorItem 
{
    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP =
        (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
            .put(ModArmorMaterials.SAPPHIRE, new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 1,
                false, false, true)).build();
    
    public ModArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) 
    {
        super(pMaterial, pType, pProperties);
    }
    

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) 
    {
        if(!level.isClientSide())
            applyFullArmorEffects(player);
    }

    private void applyFullArmorEffects(Player player)
    {
        ArmorMaterial bootMaterial = getMaterialFromSlotNullable(player, 0);
        
        if((bootMaterial == null) || !(MATERIAL_TO_EFFECT_MAP.containsKey(bootMaterial)))
            return;
        
        for (int index = 1; index < 4; index++) 
        {
            ArmorMaterial material = getMaterialFromSlotNullable(player, index);
            if((material == null) || !(material == bootMaterial))
                return;
        }
        
        MobEffectInstance effectInstance = MATERIAL_TO_EFFECT_MAP.get(bootMaterial);
        if(!player.hasEffect(effectInstance.getEffect()))
            player.addEffect(new MobEffectInstance(effectInstance));
        return;
    }

    private ArmorMaterial getMaterialFromSlotNullable(Player player, int i)
    {
        ItemStack stack = player.getInventory().getArmor(i);
            
        if(stack.isEmpty())
            return null;
        if(!(stack.getItem() instanceof ArmorItem))
            return null;
        ArmorItem armor = (ArmorItem)(stack.getItem());
            return armor.getMaterial();
    }
}
