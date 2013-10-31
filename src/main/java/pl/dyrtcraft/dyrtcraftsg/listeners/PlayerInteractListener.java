package pl.dyrtcraft.dyrtcraftsg.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import pl.DyrtCraft.DyrtCraftXP.api.Bungee;
import pl.DyrtCraft.DyrtCraftXP.api.BungeeInventory;
import pl.dyrtcraft.dyrtcraftsg.ArenaInventory;
import pl.dyrtcraft.dyrtcraftsg.DyrtCraftSG;

public class PlayerInteractListener implements Listener {

	DyrtCraftSG plugin;
	
	public PlayerInteractListener(DyrtCraftSG dyrtCraftSG) {
		plugin = dyrtCraftSG;
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		try {
			if(e.getItem().getType() == Material.COMPASS) {
				if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+""+ChatColor.BOLD+"Serwery DyrtCraft Network")) {
					e.getPlayer().openInventory(BungeeInventory.getInventory());
				}
			}
			if(e.getItem().getType() == Material.NETHER_STAR) {
				if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+""+ChatColor.BOLD+"Areny Survival Games")) {
					e.getPlayer().openInventory(ArenaInventory.getInventory());
				}
			}
			if(e.getItem().getType() == Material.EYE_OF_ENDER) {
				if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+""+ChatColor.BOLD+"Powrót na serwer Lobby")) {
					Bungee.connect(e.getPlayer(), "Lobby", "lobby");
				}
			}
		} catch(NullPointerException ex) {}
	}
	
}
