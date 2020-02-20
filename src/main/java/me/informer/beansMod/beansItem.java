package me.informer.beansMod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;


public class beansItem extends Item {
    public beansItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        
        if (playerEntity.getMainHandStack().getItem() == beansMod.BEANS_CLOSED_ITEM) {
            //When right clicked, the closed can of beans (BEANS_CLOSED_ITEM) will be removed and an open can of beans (BEANS_ITEM) will be added
            
            playerEntity.inventory.getMainHandStack().decrement(1);
            playerEntity.inventory.insertStack(new ItemStack(beansMod.BEANS_ITEM));
        
        }
        return new TypedActionResult<>(ActionResult.SUCCESS, playerEntity.getStackInHand(hand));
    }


}