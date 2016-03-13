package com.dragontechmc.DTEssentials.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.service.pagination.PaginationList;
import org.spongepowered.api.service.pagination.PaginationService;
import java.util.ArrayList;
import java.util.List;



public class HelpCommand implements CommandExecutor {
	

	PaginationService paginationService =
		    Sponge.getServiceManager().provide(PaginationService.class).get();
		PaginationList.Builder builder = paginationService.builder();
	
		

		
	
	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		
		
		paginationService.builder()
		.title(Text.of("Dragon Tech Essentials Help"))
		.contents(Text.of("Item 1"), Text.of("Item 2"), Text.of("Item 3"))
	    	.header(Text.of("Header"))
		.footer(Text.of("Footer"))
		.padding(Text.of("="));
		
        return CommandResult.success();
	
	}

}
