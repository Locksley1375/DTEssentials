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
import org.spongepowered.api.config.DefaultConfig;
import org.spongepowered.api.text.Text;
import java.nio.file.Path;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.ConfigurationOptions;
import java.io.IOException;
import java.net.URL;

import com.dragontechmc.DTEssentials.commands.*;
import com.google.inject.Inject;


import org.slf4j.Logger;

@Plugin(id = "dte", name = "DTEssentials 1.8.9", version = "1.0.1")
public class DTEssentials {
	
	
	@Inject
	@DefaultConfig(sharedRoot = true)
	private Path defaultConfig;

	@Inject
	@DefaultConfig(sharedRoot = true)
	private ConfigurationLoader<CommentedConfigurationNode> configManager;

	@Inject
	@ConfigDir(sharedRoot = false)
	private Path privateConfigDir;
	
	@Inject
    private Game game;
	
	private static Logger logger;

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
				 .executor(new HelpCommand())
				 .build();
		
		CommandSpec memberCommand = CommandSpec.builder()
			    .description(Text.of("Member Command"))
			    .permission("DTEssentials.member.membercmd")
			    .executor(new MemberCommand())
			    .build();
		
		CommandSpec slapCommand = CommandSpec.builder()
				 .description(Text.of("Slap Command"))
				 .arguments(GenericArguments.onlyOne(GenericArguments.player(Text.of("target"))))
				 .permission("DTEssentials.member.slapcmd")
				 .executor(new SlapCommand())
				 .build();
		
		CommandSpec teleportCommand = CommandSpec.builder()
			    .description(Text.of("Teleport Command"))
			    .arguments(GenericArguments.onlyOne(GenericArguments.player(Text.of("player"))))
			    .permission("DTEssentials.moderator.teleportcmd")
			    .executor(new TeleportCommand())
			    .build();
		
		
		CommandSpec wildCommand = CommandSpec.builder()
				 .description(Text.of("Wild Command"))
				 .permission("DTEssentials.new.wildcmd")
				 .executor(new WildCommand())
				 .build();

		Sponge.getCommandManager().register(this, helpCommand, "dte", "dtehelp");
		Sponge.getCommandManager().register(this, memberCommand, "member", "rankup", "join");
		Sponge.getCommandManager().register(this, slapCommand, "slap");
		Sponge.getCommandManager().register(this, teleportCommand, "tp", "teleport");
		Sponge.getCommandManager().register(this, wildCommand, "wild", "random", "rtp", "randomteleport", "randomtp");
		
	}
	

	@Listener
    public void onServerStop(GameStoppingServerEvent event) {
		getLogger().info("DTEssentials has stopped!");
    }
	
    public static Logger getLog() {
        return logger;
    }
	
	public Game getGame() {
        return game;
    }

	
	
}
