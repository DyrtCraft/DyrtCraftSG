package pl.DyrtCraft.SurvivalGames;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeftListener implements Listener {

	/**
	 * 
	 * @author TheMolkaPL
	 * 
	 */
	
	public LeftListener(DyrtCraftSG dyrtCraftSG) {
	}
	
	public void onLeft(PlayerQuitEvent e) {
		e.setQuitMessage(ChatColor.YELLOW + "* " + e.getPlayer().getName() + " wyszedl na serwer.");
	}
	
}

/*
 * Copyright © 2013 DyrtCraft Network All rights reserved.
 */
