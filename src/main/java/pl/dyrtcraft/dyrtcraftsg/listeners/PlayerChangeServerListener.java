package pl.dyrtcraft.dyrtcraftsg.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import pl.DyrtCraft.DyrtCraftXP.events.PlayerChangeServerEvent;
import pl.dyrtcraft.dyrtcraftsg.DyrtCraftSG;

public class PlayerChangeServerListener implements Listener {

	DyrtCraftSG plugin;
	
	public PlayerChangeServerListener(DyrtCraftSG dyrtCraftSG) {
		plugin = dyrtCraftSG;
	}
	
	@EventHandler
	public void onPlayerChangeServer(PlayerChangeServerEvent e) {
		if(e.getServer().equalsIgnoreCase("Survival Games")) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(ChatColor.RED + "Juz jestes na Survival Games! Aby dolaczyc na arene kliknij na tabliczke!");
		} else {
			Bukkit.broadcastMessage(ChatColor.YELLOW + e.getPlayer().getName() + " przeszedl na serwer " + e.getServer());
		}
	}
	
}
