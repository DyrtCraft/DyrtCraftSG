package pl.DyrtCraft.SurvivalGames.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.DyrtCraft.SurvivalGames.DyrtCraftSG;

public class LobbyCommand implements CommandExecutor {

	/**
	 * 
	 * @author TheMolkaPL
	 * 
	 */
	
	private DyrtCraftSG plugin;
	
	public LobbyCommand(DyrtCraftSG dyrtCraftSG) {
		plugin=dyrtCraftSG;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		if(command.getName().equalsIgnoreCase("lobby")) {
			String brak_perm = plugin.getConfig().getString("wiadomosci.brak-perm");
			brak_perm.replaceAll("&", "§");
			
			if(args.length==0) {
				if(!(sender.hasPermission("dyrtcraft.survivalgames.lobby"))) {
					sender.sendMessage(brak_perm);
					return true;
				}
				if(!(sender instanceof Player)) {
		 			System.out.println("[DyrtCraftSG] Nie mozesz wykonac tego polecenia z poziomu konsoli!");
		    		return true;
				}
				if(plugin.getConfig().getString("lobby.world") == null) {
					sender.sendMessage(ChatColor.RED + "Lobby nie zostalo jeszcze ustawione!");
					return true;
				}
				
				Player p = (Player) sender;
				Location loc;
				
				String World = plugin.getConfig().getString("lobby.world");
                double x = plugin.getConfig().getDouble("lobby.x");
                double y = plugin.getConfig().getDouble("lobby.y");
                double z = plugin.getConfig().getDouble("lobby.z");
                loc = new Location(plugin.getServer().getWorld(World),x,y,z);
                p.teleport(loc);
                sender.sendMessage(ChatColor.GRAY + "Teleportacja do Lobby.");
				for(Player op : Bukkit.getOnlinePlayers()) {
					if(op.isOp() || op.hasPermission("dyrtcraft.survivalgames.powiadomienia")) {
						op.sendMessage(ChatColor.YELLOW + "* " + sender.getName() + " teleportowal sie do Lobby.");
					}
				}
				return true;
			}
			
			if(args.length==1) {
				Player gracz = Bukkit.getServer().getPlayer(args[0]);
				if(!(sender.hasPermission("dyrtcraft.survivalgames.lobby.admin"))) {
					sender.sendMessage(brak_perm);
					return true;
				}
				if(gracz == null) {
                	sender.sendMessage(ChatColor.RED + "Nie znaleziono gracza " + args[0] + "!");
                	return true;
                }
                if(plugin.getConfig().getString("lobby.world") == null) {
					sender.sendMessage(ChatColor.RED + "Lobby nie zostalo jeszcze ustawione!");
					return true;
				}
                Location loc;
                
                String World = plugin.getConfig().getString("lobby.world");
                double x = plugin.getConfig().getDouble("lobby.x");
                double y = plugin.getConfig().getDouble("lobby.y");
                double z = plugin.getConfig().getDouble("lobby.z");
                loc = new Location(plugin.getServer().getWorld(World),x,y,z);
                gracz.teleport(loc);
                gracz.sendMessage(ChatColor.GRAY + "Zostales przeteleportowany do Lobby przez " + sender.getName() + ".");
                for(Player op : Bukkit.getOnlinePlayers()) {
                	if(op.isOp() || op.hasPermission("dyrtcraft.survivalgames.powiadomienia")) {
                		op.sendMessage(ChatColor.YELLOW + "* " + sender.getName() + " przeteleportowal(a) " + gracz.getName() + "do Lobby.");
                	}
                }
                return true;
			}
		}
		return false;
	}

}

/*
 * Copyright © 2013 DyrtCraft Network All rights reserved.
 */
