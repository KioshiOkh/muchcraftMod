package com.muchware.muchcraft.init;

import com.muchware.muchcraft.Muchcraft;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

    //ITEM HERE
    public static  final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Muchcraft.MODID);
    public  static  final RegistryObject<Item> muchcraft_item = ITEMS.register("muchcraft_item", () -> new Item(PROP()));
    public static  final RegistryObject<Item> muchcraft2_item = ITEMS.register("muchcraft2_item", () -> new Item(PROP()));

    // FOODS HERE
    public static  final RegistryObject<Item> muchcraft3_item_food = ITEMS.register("muchcraft3_item_food", () -> new Item(PROP().food(Foods.muchcraft3_item_food)));

    //TOOL HERE

        //SWORD HERE
        public static  final RegistryObject<SwordItem> muchcraft_sword = ITEMS.register("muchcraft_sword", () -> new SwordItem(Tiers.muchcraft, 5, -2.0f, PROP()));

        //PICKAXE HERE
        public static final  RegistryObject<PickaxeItem> muchcraft_pickaxe = ITEMS.register("muchcraft_pickaxe", () -> new PickaxeItem(Tiers.muchcraft, 3, -2.0f, PROP()));

        //AXE HERE
        public static final  RegistryObject<AxeItem> muchcraft_axe = ITEMS.register("muchcraft_axe", () -> new AxeItem(Tiers.muchcraft, 6, -2.0f, PROP()));

        //SHOVEL HERE
        public static final  RegistryObject<ShovelItem> muchcraft_shovel = ITEMS.register("muchcraft_shovel", () -> new ShovelItem(Tiers.muchcraft, 2.4f, -2.0f, PROP()));

        //HOE HERE
        public static final  RegistryObject<HoeItem> muchcraft_hoe = ITEMS.register("muchcraft_hoe", () -> new HoeItem(Tiers.muchcraft, 1, -2.0f, PROP()));



    private static Item.Properties PROP (){
        return new Item.Properties().tab(Muchcraft.TAB);
    }
    public static class Foods {
        public static final FoodProperties muchcraft3_item_food = new FoodProperties.Builder()
                .nutrition(4)
                .saturationMod(0.3f)
                    .build();
    }
    public static class Tiers{
        //level ->> Wood = 0, Stone/Gold = 1, Iron = 2, Diamond = 3, Netherite = 4
        public static final Tier muchcraft = new ForgeTier(2, 512, 1.5f, 3, 420, null, () ->  Ingredient.of(ItemInit.muchcraft_item.get()));
    }
}
