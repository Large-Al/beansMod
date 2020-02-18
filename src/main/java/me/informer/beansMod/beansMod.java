package me.informer.beansMod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class beansMod implements ModInitializer {

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier("beans", "general"),
            () -> new ItemStack(Items.BOWL));

    public static final Item BEANS_ITEM = new Item(new Item.Settings().group(ItemGroup.FOOD).group(ITEM_GROUP).food(new FoodComponent.Builder().hunger(6).saturationModifier(6f).build()));
    public static final beansItem BEANS_CLOSED_ITEM = new beansItem(new Item.Settings().group(ITEM_GROUP));
    public static final beansItem BEANS_EMPTY_ITEM = new beansItem(new Item.Settings().group(ITEM_GROUP));

    //public static final Item COFFEE_ITEM = new Item(new Item.Settings().group(ItemGroup.FOOD).group(ITEM_GROUP))


    @Override
    public void onInitialize() {

        //BEANS
        Registry.register(Registry.ITEM, new Identifier("beans", "beans_item"), BEANS_ITEM);
        Registry.register(Registry.ITEM, new Identifier("beans", "beans_closed_item"), BEANS_CLOSED_ITEM);
        Registry.register(Registry.ITEM, new Identifier("beans", "beans_empty_item"), BEANS_EMPTY_ITEM);

        //COFFEE



    }
}
