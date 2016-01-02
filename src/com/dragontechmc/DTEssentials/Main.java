package com.dragontechmc.DTEssentials;

import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.game.state.GameStoppingServerEvent;
import org.spongepowered.api.plugin.Plugin;

import com.google.inject.Inject;

import org.slf4j.Logger;

@Plugin(id = "DTEstl", name = "DTEssentials", version = "1.0")
public class Main {
	
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
    public void onServerStop(GameStoppingServerEvent event) {
		getLogger().info("DTEssentials has stopped!");
    }
	
}