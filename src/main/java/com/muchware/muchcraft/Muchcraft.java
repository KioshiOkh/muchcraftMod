package com.muchware.muchcraft;

import com.muchware.muchcraft.init.BlockInit;
import com.muchware.muchcraft.init.ItemInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Muchcraft.MODID)
public class Muchcraft
{

    public static final String MODID = "muchcraft";
    public static final CreativeModeTab TAB = new CreativeModeTab(MODID){public @NotNull ItemStack makeIcon() {return new ItemStack(Blocks.BEACON);}};

    public Muchcraft()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        BlockInit.BLOCKS.register(bus);
        ItemInit.ITEMS.register(bus);

    }
}