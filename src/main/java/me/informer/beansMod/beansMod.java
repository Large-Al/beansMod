package me.informer.beansMod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class beansMod implements ModInitializer {

    public static final Item BEANS_ITEM = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(6).saturationModifier(6f).build()));
    public static final beansItem BEANS_CLOSED_ITEM = new beansItem(new Item.Settings().group(ItemGroup.SEARCH));
    public static final Item BEANS_EMPTY_ITEM = new Item(new Item.Settings().group(ItemGroup.SEARCH));

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier("beans", "general"),
            () -> new ItemStack(BEANS_ITEM));

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("beans", "beans_item"), BEANS_ITEM);
        Registry.register(Registry.ITEM, new Identifier("beans", "beans_closed_item"), BEANS_CLOSED_ITEM);
        Registry.register(Registry.ITEM, new Identifier("beans", "beans_empty_item"), BEANS_EMPTY_ITEM);
    }
}
