package pl.DyrtCraft.SurvivalGames;

import org.bukkit.plugin.java.JavaPlugin;

public class DyrtCraftSG extends JavaPlugin {

	/**
	 * 
	 * @author TheMolkaPL
	 * 
	 */
	
	public void onEnable() {
		// Info
		System.out.println("[DyrtCraftSG] Wlaczanie DyrtCraftSG wersja " + this.getDescription().getVersion() + " by " + this.getDescription().getAuthors() + ".");
		
		// Zapis configu
		saveDefaultConfig();
		
		// Komendy
		getCommand("dcsg").setExecutor(new pl.DyrtCraft.SurvivalGames.command.DcsgCommand(this));
		getCommand("lobby").setExecutor(new pl.DyrtCraft.SurvivalGames.command.LobbyCommand(this));
		getCommand("?").setExecutor(new pl.DyrtCraft.SurvivalGames.command.QuestionMarkCommand(this));
		
		// Eventy
		getServer().getPluginManager().registerEvents(new pl.DyrtCraft.SurvivalGames.JoinListener(this), this);
		getServer().getPluginManager().registerEvents(new pl.DyrtCraft.SurvivalGames.LeftListener(this), this);
	
		// Info
		System.out.println("[DyrtCraftSG] DyrtCraftSG wersja " + this.getDescription().getVersion() + " by " + this.getDescription().getAuthors() + " zostal poprawnie zaladowany." );
	}
	
}

/*
 * Copyright © 2013 DyrtCraft Network All rights reserved.
 */
