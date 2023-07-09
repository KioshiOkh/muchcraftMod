package com.muchware.muchcraft.commands.events;

import com.muchware.muchcraft.Muchcraft;
import com.muchware.muchcraft.commands.CommandTest;
import com.muchware.muchcraft.commands.giveTeamEffect;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = Muchcraft.MODID)
public class ModEvent {

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        new CommandTest(event.getDispatcher());
        new giveTeamEffect(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }
}
