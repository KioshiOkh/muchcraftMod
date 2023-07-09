package com.muchware.muchcraft.init;

import com.muchware.muchcraft.Muchcraft;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Muchcraft.MODID);

    public static final RegistryObject<Block> muchcraft_block = register("muchcraft_block",
            () -> new Block(BlockBehaviour
                        .Properties.of(Material.AMETHYST)
                        .strength(3.0f, 3.0f)),
                    new Item.Properties()
                                .tab(Muchcraft.TAB));

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> supplier, Item.Properties properties)
    {
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
        return block;
    }
}