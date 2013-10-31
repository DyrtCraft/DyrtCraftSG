package pl.dyrtcraft.dyrtcraftsg.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.PlayerInventory;

import pl.dyrtcraft.dyrtcraftsg.ArenaInventory;
import pl.dyrtcraft.dyrtcraftsg.DyrtCraftSG;

public class PlayerJoinListener implements Listener {

	DyrtCraftSG plugin;
	
	public PlayerJoinListener(DyrtCraftSG dyrtCraftSG) {
		plugin = dyrtCraftSG;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		e.setJoinMessage(e.getPlayer() + " dolaczyl na serwer");
		
		PlayerInventory pi = e.getPlayer().getInventory();
		
        pi.setHelmet(null);
        pi.setChestplate(null);
        pi.setLeggings(null);
        pi.setBoots(null);
		pi.clear();
		
		pi.setItem(0, DyrtCraftSG.arena());
		pi.setItem(7, DyrtCraftSG.compass());
		pi.setItem(8, DyrtCraftSG.lobby());
		
		e.getPlayer().setGameMode(GameMode.ADVENTURE);
		
		e.getPlayer().setHealth(20.0);
		e.getPlayer().setFoodLevel(20);
		
		e.getPlayer().setExp(0);
		e.getPlayer().setLevel(0);
		
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "spawn " + e.getPlayer());
		e.getPlayer().openInventory(ArenaInventory.getInventory());
	}
	
}
