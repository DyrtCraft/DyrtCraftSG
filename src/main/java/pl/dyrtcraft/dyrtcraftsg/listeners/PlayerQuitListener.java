package pl.dyrtcraft.dyrtcraftsg.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import pl.dyrtcraft.dyrtcraftsg.DyrtCraftSG;

public class PlayerQuitListener implements Listener {

	DyrtCraftSG plugin;
	
	public PlayerQuitListener(DyrtCraftSG dyrtCraftSG) {
		plugin = dyrtCraftSG;
	}
	
	@EventHandler
	public void onPlayerKick(PlayerKickEvent e) {
		e.setLeaveMessage(e.getPlayer() + " wyszedl z serwera");
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		e.setQuitMessage(e.getPlayer() + " wyszedl z serwera");
	}
	
}
