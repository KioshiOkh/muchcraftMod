package com.muchware.muchcraft.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.MobEffectArgument;
import net.minecraft.commands.arguments.TeamArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.scores.PlayerTeam;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.UUID;

public class giveTeamEffect {
    public giveTeamEffect(CommandDispatcher<CommandSourceStack> dispatcher) {

        dispatcher.register(Commands.literal("giveTeamEffect").requires(source -> source.hasPermission(4))
                .then(Commands.argument("team", TeamArgument.team())
                        .then(Commands.argument("effect", MobEffectArgument.effect())
                            .then(Commands.argument("duration", IntegerArgumentType.integer(0, 1000000))
                                    .then(Commands.argument("amplifier", IntegerArgumentType.integer(0, 255))
                                            .then(Commands.argument("hideParticles", BoolArgumentType.bool())
                                            .executes(context ->{
                                                    return giveTeamEffects(context.getSource(),
                                                    TeamArgument.getTeam(context, "team"),
                                                    MobEffectArgument.getEffect(context, "effect"),
                                                    IntegerArgumentType.getInteger(context, "duration"),
                                                    IntegerArgumentType.getInteger(context, "amplifier"),
                                                    BoolArgumentType.getBool(context, "hideParticles")
                                                    );})))))));
    }
    private static int giveTeamEffects(CommandSourceStack source, PlayerTeam teamName, MobEffect effectName, @Nullable Integer duration, int amplifier, boolean hideParticles) throws CommandSyntaxException {
        int j;
        if (duration != null) {
            if (effectName.isInstantenous()) {
                j = duration;
            } else {
                j = duration * 20;
            }
        } else if (effectName.isInstantenous()) {
            j = 1;
        } else {
            j = 600;
        }
        source.sendFailure(Component.translatable("test 1 bestanden ", source.getDisplayName()));
            for (String playerName : teamName.getPlayers()) {
                LivingEntity playerEntity = null;
                if (playerName != null) {
                    System.out.println("test2");
                    ServerPlayer playerUUID = source.getServer().getPlayerList().getPlayer(UUID.fromString(playerName));
                    assert playerUUID != null;
                    playerEntity = (LivingEntity) Objects.requireNonNull(source.getServer().getLevel(Objects.requireNonNull(source.getEntity()).getCommandSenderWorld().dimension())).getEntity(playerUUID.getUUID());
                    assert playerEntity != null;
                    playerEntity.addEffect(new MobEffectInstance(effectName, j /* DURATION */, amplifier, false/*AMBIENT*/, hideParticles/*isVisible*/, true/*ShowIcon*/));
                }
                System.out.println("test3");
            }
        source.sendSuccess(Component.translatable("test bestanden ", source.getDisplayName()), true);
        return 1;
    }
}