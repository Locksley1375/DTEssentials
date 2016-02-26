package com.dragontechmc.DTEssentials.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.service.permission.*;
import org.spongepowered.api.service.sql.SqlService;
import org.spongepowered.api.text.*;
import org.spongepowered.api.util.Tristate;

import com.dragontechmc.DTEssentials.DTEssentials;

public class PermissionCommands implements CommandExecutor {

	DTEssentials plugin = null;
	
	private SqlService sql;
	
	public PermissionCommands(DTEssentials plugin){
		this.plugin = plugin;
	}

	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		
		Player player = args.<Player>getOne("player").get();
		String operation = args.<String>getOne("operation").get();
		String permission = args.<String>getOne("permission").get();
		
		if (operation.equals("add")){
			player.getSubjectData().setPermission(player.getActiveContexts(), permission, Tristate.TRUE);
			player.sendMessage(Text.of(player.hasPermission(permission)));
			/*try {
				getPlayerPermissions();
			} catch (SQLException e) {
				
			}*/
		}
		
		if (operation.equals("remove")){
			player.getSubjectData().setPermission(player.getActiveContexts(), permission, Tristate.UNDEFINED);
			player.sendMessage(Text.of(player.hasPermission(permission)));
		}
		
		return CommandResult.success();
	}
	/*
	public javax.sql.DataSource getDataSource(String jdbcUrl) throws SQLException {
	    if (sql == null) {
	        sql = plugin.getGame().getServiceManager().provide(SqlService.class).get();
	    }
	    return sql.getDataSource(jdbcUrl);
	}*/
	
	/*public ResultSet getPlayerPermissions() throws SQLException {
	    Connection conn = getDataSource("jdbc:h2:userPermissions.db").getConnection();
	    PreparedStatement statement = null;
	    
	    try {
	        statement = conn.prepareStatement("SELECT * FROM player");
	        statement.execute();
	    } finally {
	        conn.close();
	    }
	}*/
}
