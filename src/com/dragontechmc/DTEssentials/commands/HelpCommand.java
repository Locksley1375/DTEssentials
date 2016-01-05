package com.dragontechmc.DTEssentials.commands;

import java.util.ArrayList;
import java.util.List;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.source.CommandBlockSource;
import org.spongepowered.api.command.source.ConsoleSource;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.service.pagination.PaginationBuilder;
import org.spongepowered.api.service.pagination.PaginationService;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;

import com.dragontechmc.DTEssentials.DTEssentials;

public class HelpCommand implements CommandExecutor {

	DTEssentials plugin = null;
	
	public HelpCommand(DTEssentials plugin){
		this.plugin = plugin;
	}
	
	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		
		String command = args.<String>getOne("command").get();
		
		PaginationService paginationService = plugin.getGame().getServiceManager().provide(PaginationService.class).get();
    	PaginationBuilder builder = paginationService.builder();
		
		List<Text> contents = new ArrayList<>();
		
		if (command.equals("help") || command.equals("?")){
    		if(src instanceof Player) {
    			contents.add(Texts.of("/dte help"));
    			
    	    	builder.title(Texts.of("DTEssentials help"))
    	        .contents(contents)
    	        .footer(Texts.of(""))
    	        .paddingString("=")
    	        .sendTo(src);
        	}
        	else if(src instanceof ConsoleSource) {
        		src.sendMessage(Texts.of("-- DTEssentials plugin help --"));
        		src.sendMessage(Texts.of("/dte help"));
        	}
        	else if(src instanceof CommandBlockSource) {
        	    
        	}
    	}
		
		return CommandResult.success();
	}
}
