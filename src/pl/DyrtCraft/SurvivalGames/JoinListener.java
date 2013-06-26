package pl.DyrtCraft.SurvivalGames;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class JoinListener implements Listener {

	/**
	 * 
	 * @author TheMolkaPL
	 *
	 */
	
	private DyrtCraftSG plugin;
	
	public JoinListener(DyrtCraftSG dyrtCraftSG) {
		plugin=dyrtCraftSG;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e ) {	
		// Zmienne
		PlayerInventory pi = e.getPlayer().getInventory();
		
		// Czyszczenie eq, zmiana gm, dzwiek
        pi.setHelmet(null);
        pi.setChestplate(null);
        pi.setLeggings(null);
        pi.setBoots(null);

		pi.clear();
		pi.addItem(new ItemStack(Material.EMERALD, 1));
		e.getPlayer().setGameMode(GameMode.ADVENTURE);
		//e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENDERDRAGON_GROWL, 10, 1);
		
		// Powiadomienie
		e.setJoinMessage(ChatColor.YELLOW + "* " + e.getPlayer().getName() + " dolaczyl na serwer.");
		
	    // Auto teleportacja do lobby
	    if (plugin.getConfig().getString("lobby.world") == null) {
			e.getPlayer().sendMessage(ChatColor.RED + "Lobby nie zostalo jeszcze ustalone!");
		} else {
			World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("lobby.world"));
			double x = plugin.getConfig().getDouble("lobby.x");
			double y = plugin.getConfig().getDouble("lobby.y");
			double z = plugin.getConfig().getDouble("lobby.z");
			e.getPlayer().teleport(new Location(w, x, y, z));
		}
	}
	
}

/*
 * Copyright © 2013 DyrtCraft Network All rights reserved.
 */
