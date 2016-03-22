package com.dragontechmc.DTEssentials.config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.dragontechmc.DTEssentials.DTEssentials;

import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import ninja.leaping.configurate.objectmapping.Setting;

public class Config {

	private File file;
	private CommentedConfigurationNode config;
	private ConfigurationLoader<CommentedConfigurationNode> loader;
	
	public Config(String configName) {
		String folder = "config/DTEssentials/";
        if (!new File(folder).isDirectory()) {
        	new File(folder).mkdirs();
        }
        
		file = new File(folder + configName);
		
		create();
		load();
		init();
	
		}
	
	public Config() {
		String folder = "config/DTEssentials/";
        if (!new File(folder).isDirectory()) {
        	new File(folder).mkdirs();
        }
		file = new File(folder, "config.conf");
		
		create();
		load();
		init();
		
	}
	
	
	public ConfigurationLoader<CommentedConfigurationNode> getLoader() {
		return loader;
	}

	public CommentedConfigurationNode getConfig() {
		return config;
	}
	
	public void save(){
		try {
			loader.save(config);
		} catch (IOException e) {
			DTEssentials.getLog().error("Config save failed");
			e.printStackTrace();
		}
	}
	
	public void init() {
		if(file.getName().equalsIgnoreCase("config.conf")){
			
				List<String> list = new ArrayList<>();
				
				list.add("fuck");
				list.add("bitch");
				list.add("shit");
			
			config.getNode("swears").setValue(list);
			// ^ This line hates me.... Help?
			
			config.getNode("Website").setValue("http://dragontechmc.com").setComment("/website command Answer");
			config.getNode("MemberLink").setValue("http://tinyurl.com/memberdt").setComment("/member command Answer");
			
			save();
		}
	}
	private void create(){
		if(!file.exists()) {
			try {
				file.createNewFile();		
			} catch (IOException e) {				
				Main.getLog().error("Config create failed");
				e.printStackTrace();
			}
		}
	}
	
	private void load(){
		loader = HoconConfigurationLoader.builder().setFile(file).build();
		try {
			config = loader.load();
		} catch (IOException e) {
			Main.getLog().error("Config load failed");
			e.printStackTrace();
		}
	}
	
	@Override
	public CommentedConfigurationNode get()
	{
		return configNode;
	}
	
}

