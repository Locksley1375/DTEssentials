package com.dragontechmc.DTEssentials.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.TeleportHelper;
import org.spongepowered.api.world.World;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.Sponge;

import javax.annotation.Nonnull;
import java.util.Optional;
import java.util.Random;

public class WildCommand implements CommandExecutor{
	
	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		
		if (src instanceof Player)
		{
			Player player = (Player) src;
			Location<World> playerLocation = player.getLocation();
			
			
		}
		
        return CommandResult.success();
		
	}

}
