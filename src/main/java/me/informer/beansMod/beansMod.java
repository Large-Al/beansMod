package me.informer.beansMod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class beansMod implements ModInitializer {

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier("beans", "general"),
            () -> new ItemStack(Items.BOWL));

    public static final Item BEANS_ITEM = new Item(new Item.Settings().group(ItemGroup.FOOD).group(ITEM_GROUP).food(new FoodComponent.Builder().hunger(6).saturationModifier(6f).build()));
    public static final beansItem BEANS_CLOSED_ITEM = new beansItem(new Item.Settings().group(ITEM_GROUP));
    public static final beansItem BEANS_EMPTY_ITEM = new beansItem(new Item.Settings().group(ITEM_GROUP));

    public static final beansStatusEffect COFFEE_EFFECT = new beansStatusEffect(StatusEffectType.BENEFICIAL, 1427050);

    //Texture will go in texture/mob_effect
    public static final Potion COFFEE = new Potion(new StatusEffectInstance[]{new StatusEffectInstance(COFFEE_EFFECT, 3600)});

    @Override
    public void onInitialize() {

        //BEANS
        Registry.register(Registry.ITEM, new Identifier("beans", "beans_item"), BEANS_ITEM);
        Registry.register(Registry.ITEM, new Identifier("beans", "beans_closed_item"), BEANS_CLOSED_ITEM);
        Registry.register(Registry.ITEM, new Identifier("beans", "beans_empty_item"), BEANS_EMPTY_ITEM);

        //COFFEE

        Registry.register(Registry.POTION, "coffee", COFFEE);
        Registry.register(Registry.STATUS_EFFECT, 33, "coffee_effect", COFFEE_EFFECT).addAttributeModifier(EntityAttributes.MOVEMENT_SPEED, "91AEAA56-376B-4498-935B-2F7F68070635", 0.20000000298023224D,EntityAttributeModifier.Operation.MULTIPLY_TOTAL).addAttributeModifier(EntityAttributes.ATTACK_SPEED, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3", 0.10000000149011612D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);

    }
}
