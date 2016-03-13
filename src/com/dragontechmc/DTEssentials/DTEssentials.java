package com.dragontechmc.DTEssentials;

import org.spongepowered.api.Game;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.game.state.GameStoppingServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.text.Text;
import java.nio.file.Path;

import com.dragontechmc.DTEssentials.commands.*;
import com.google.inject.Inject;


import org.slf4j.Logger;

@Plugin(id = "dte", name = "DTEssentials 1.8.9", version = "1.0.1")
public class DTEssentials {
	
	
	@Inject
	@ConfigDir(sharedRoot = false)
	private Path configDir;

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
		
    }
	
    @Listener
    public void init(GameInitializationEvent event) {
        createAndRegisterCommands();

    }
    // Registers commands
	private void createAndRegisterCommands() {
		
		
		CommandSpec helpCommand = CommandSpec.builder()
				 .description(Text.of("Help Command"))
				 .permission("DTEssentials.new.dtehelp")
				 .arguments(
						 GenericArguments.onlyOne(GenericArguments.string(Text.of("help"))))
				 .executor(new HelpCommand())
				 .build();
		
		CommandSpec memberCommand = CommandSpec.builder()
			    .description(Text.of("Member Command"))
			    .permission("DTEssentials.member.membercmd")
			    .executor(new MemberCommand())
			    .build();
		
		
		CommandSpec wildCommand = CommandSpec.builder()
				 .description(Text.of("Wild Command"))
				 .permission("DTEssentials.new.wildcmd")
				 .executor(new WildCommand())
				 .build();

		Sponge.getCommandManager().register(this, helpCommand, "dte", "dtehelp");
		Sponge.getCommandManager().register(this, memberCommand, "member", "rankup", "join");
		Sponge.getCommandManager().register(this, wildCommand, "wild", "random");	
		
	}
	

	@Listener
    public void onServerStop(GameStoppingServerEvent event) {
		getLogger().info("DTEssentials has stopped!");
    }
	
	public Game getGame() {
        return game;
    }

	
	
}
