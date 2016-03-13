package com.dragontechmc.DTEssentials.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.action.HoverAction;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.service.pagination.PaginationList;
import org.spongepowered.api.service.pagination.PaginationService;
import java.util.ArrayList;
import java.util.List;



public class HelpCommand implements CommandExecutor {
	
	
	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		
		PaginationService ps = Sponge.getServiceManager().provide(PaginationService.class).get();
			
		Text member = Text.builder(" - /member").onHover(TextActions.showText(Text.of(TextColors.GOLD, "Learn how to get Member rank"))).build();
		Text wild = Text.builder(" - /wild").onHover(TextActions.showText(Text.of(TextColors.GOLD, "Learn how to get to the wild"))).build();
		
		
			ps.builder()
			.title(Text.of(TextColors.AQUA,"Dragon Tech Essentials Help"))
			.contents(Text.of(TextColors.AQUA, member), Text.of(TextColors.AQUA, wild), Text.of(TextColors.AQUA, "Item 3"))
			.header(Text.of(TextColors.GOLD," Hover over a command to see what it does"))
			.padding(Text.of(TextColors.GRAY,"="))
			.sendTo(src);
		
        return CommandResult.success();
		
	}
}


