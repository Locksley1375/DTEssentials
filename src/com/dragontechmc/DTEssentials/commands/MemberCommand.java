package com.dragontechmc.DTEssentials.commands;

import java.net.URL;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.*;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextColors;

import com.dragontechmc.DTEssentials.config.Config;

public class MemberCommand implements CommandExecutor{

	URL MemberLink = Config.getNode("MemberLink");
	
	
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
    	
    	Text MemberMsg = Text.builder("here").onClick(TextActions.openUrl(MemberLink)).build();
    	
        src.sendMessage(Text.of(TextColors.GREEN," Become a Member for free by following the instructions ", TextColors.AQUA, MemberMsg ));
        return CommandResult.success();
    }
   

}
