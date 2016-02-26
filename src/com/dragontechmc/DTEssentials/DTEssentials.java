package com.dragontechmc.DTEssentials;

import org.spongepowered.api.Game;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.game.state.GameStoppingServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.*;
import org.spongepowered.api.text.format.TextColors;

import com.dragontechmc.DTEssentials.commands.HelpCommand;
import com.dragontechmc.DTEssentials.commands.PermissionCommands;
import com.google.inject.Inject;

import org.slf4j.Logger;

@Plugin(id = "DTEstl", name = "DTEssentials", version = "1.0")
public class DTEssentials {

	@Inject
    private Game game;
	
	private Logger logger;

	@Inject
	private void setLogger(Logger logger) {
	    this.logger = logger;
	}
	
	public Logger getLogger() {
	    return logger;
	}
    
	@Listener
    public void onServerStart(GameStartedServerEvent event) {
		getLogger().info("DTEssentials has started!");
		
		buildCommands();
    }
	
	@Listener
    public void onServerStop(GameStoppingServerEvent event) {
		getLogger().info("DTEssentials has stopped!");
    }
	
	public void buildCommands(){
		CommandSpec helpCommandSpec = CommandSpec.builder()
			    .description(Text.builder("DTEssentials help command").color(TextColors.GOLD).build())
			    .permission("DTEssentials.command.help")
			    .arguments(
			    		GenericArguments.onlyOne(GenericArguments.string(Text.of("command")))
			    )
			    .executor(new HelpCommand(this))
			    .build();

		CommandSpec permissionCommandSpec = CommandSpec.builder()
			    .description(Text.builder("DTEssentials help command").color(TextColors.GOLD).build())
			    .arguments(
			    		GenericArguments.onlyOne(GenericArguments.player(Text.of("player"))),
			    		GenericArguments.onlyOne(GenericArguments.string(Text.of("operation"))),
			    		GenericArguments.onlyOne(GenericArguments.string(Text.of("permission")))
			    )
			    .executor(new PermissionCommands(this))
			    .build();
		
		game.getCommandManager().register(this, helpCommandSpec, "dte", "dt");
		game.getCommandManager().register(this, permissionCommandSpec, "permission", "perm");
	}
	
	public Game getGame() {
        return game;
    }
}
