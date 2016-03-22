package com.dragontechmc.DTEssentials.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;


public class SlapCommand implements CommandExecutor{
	
	
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
	
				
				if(src instanceof Player){
					
					Player player = (Player) src;
					Player target = args.<Player>getOne("target").get();
					
					player.sendMessage(Text.of("You have slapped ", target.getDisplayNameData()));
					target.sendMessage(Text.of("You have been slapped by ", player.getDisplayNameData()));
					
				}
		
		return CommandResult.success();
	}

}
