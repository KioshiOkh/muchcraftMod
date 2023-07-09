package com.muchware.muchcraft.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;


public class CommandTest {
    public CommandTest(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(Commands.literal("much").executes(command -> {
            return 0;
        }));
    }

    private int effect(CommandSourceStack source) throws CommandSyntaxException {
        ServerPlayer player = source.getPlayerOrException();
        source.sendSuccess(Component.translatable("test bestanden ", player.getDisplayName()), true);
        return 1;
    }
}