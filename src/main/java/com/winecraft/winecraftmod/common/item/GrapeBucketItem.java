package com.winecraft.winecraftmod.common.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.world.World;

public class GrapeBucketItem extends Item {

    public GrapeBucketItem(Properties properties) {
        super(properties);
    }

    /** Behaviour is identical to {@link net.minecraft.item.SoupItem}, except item stack is replaced with Bucket */
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        //TODO: "Eating sound" is played on item use finish- implement super method but replace the sound.
        ItemStack itemstack = super.onItemUseFinish(stack, worldIn, entityLiving);
        return entityLiving instanceof PlayerEntity && ((PlayerEntity)entityLiving).abilities.isCreativeMode ? itemstack : new ItemStack(Items.BUCKET);
    }

    /** Use action ensures consumption sound is drinking instead of eating (despite being a food) */
    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }
}
