package pl.DyrtCraft.SurvivalGames.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.DyrtCraft.SurvivalGames.DyrtCraftSG;

public class DcsgCommand implements CommandExecutor {
	
	/**
	 * 
	 * @author TheMolkaPL
	 * 
	 */
	
	private DyrtCraftSG plugin;
	
	public DcsgCommand(DyrtCraftSG dyrtCraftSG) {
		plugin=dyrtCraftSG;
	}
	
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		if(command.getName().equalsIgnoreCase("dcsg")) {
			if(args.length==0) {
				return brakArg(sender);
			}
			
			if(args.length==1) {
				if(args[0].equalsIgnoreCase("info")) {
					return infoArg(sender);
				}
				
				if(args[0].equalsIgnoreCase("reload")) {
					return reloadArg(sender);
				}
				
				if(args[0].equalsIgnoreCase("setlobby")) {
					return setLobbyArg(sender);
				}
			}
		}
		return false;
	}

	
	// Brak lub bledny argument
	private boolean brakArg(CommandSender sender) {
		sender.sendMessage(ChatColor.RED + "Bledny argument!");
		sender.sendMessage("Prawidlowe uzycie: /dcsg <info|reload|setlobby>");		
		return true;
	}
	
	// Informacje o pluginie
	private boolean infoArg(CommandSender sender) {
		sender.sendMessage(ChatColor.GOLD + " >==========[ " + ChatColor.BOLD + ChatColor.AQUA + "DyrtCraftSG" + ChatColor.RESET + ChatColor.GOLD + " ]==========< ");
		sender.sendMessage(ChatColor.GOLD + "Wersja: " + ChatColor.GRAY + plugin.getDescription().getVersion());
		sender.sendMessage(ChatColor.GOLD + "Autor: " + plugin.getDescription().getAuthors());
		sender.sendMessage(ChatColor.GOLD + " >==========[ " + ChatColor.BOLD + ChatColor.AQUA + "DyrtCraftSG" + ChatColor.RESET + ChatColor.GOLD + " ]==========< ");
		return true;
	}
	
	// Reload config.yml
	private boolean reloadArg(CommandSender sender) {
		String brak_perm = plugin.getConfig().getString("wiadomosci.brak-perm");
		brak_perm.replaceAll("&", "§");
		
		if(!(sender.hasPermission("dyrtcraft.survivalgames.reload"))) {
			sender.sendMessage(brak_perm);
			return true;
		}
		sender.sendMessage(ChatColor.GRAY + "Przeladowywanie pliku config.yml.....");
		System.out.println("[DyrtCraftSG] (" + sender.getName() + "): Przeladowywanie pliku config.yml.....");
		plugin.reloadConfig();
		sender.sendMessage(ChatColor.DARK_GREEN + "Plik config.yml zostal pomyslnie przeladowany!");
		System.out.println("[DyrtCraftSG] (" + sender.getName() + "): Plik config.yml zostal pomyslnie przeladowany!");
		return true;
	}
	
	// Ustawienie lokalizacji lobby
	private boolean setLobbyArg(CommandSender sender) {
		String brak_perm = plugin.getConfig().getString("wiadomosci.brak-perm");
		brak_perm.replaceAll("&", "§");
		
		if(!(sender.hasPermission("dyrtcraft.survivalgames.lobby.set"))) {
			sender.sendMessage(brak_perm);
			return true;
		}
		if(!(sender instanceof Player)) {
 			System.out.println("[DyrtCraftSG] Nie mozesz wykonac tego polecenia z poziomu konsoli!");
    		return true;
		}
		Player p = (Player) sender;
		Location loc;
        loc = p.getLocation();
        plugin.getConfig().set("lobby.world", loc.getWorld().getName());
        plugin.getConfig().set("lobby.x", loc.getX());
        plugin.getConfig().set("lobby.y", loc.getY());
        plugin.getConfig().set("lobby.z", loc.getZ());
        plugin.saveConfig();
        sender.sendMessage(ChatColor.DARK_GREEN + "Pomyslnie utworzono Lobby. " +
        		"(x-" + ChatColor.GOLD + loc.getX() + 
        		ChatColor.DARK_GREEN + " y-" + ChatColor.GOLD + loc.getY() + 
        		ChatColor.DARK_GREEN + " z-" + ChatColor.GOLD + loc.getZ() + 
        		ChatColor.DARK_GREEN + " w swiecie " + ChatColor.GOLD + loc.getWorld().getName() + 
        		ChatColor.DARK_GREEN + ".");
        
        for(Player op : Bukkit.getOnlinePlayers()) {
        	if(op.isOp() || op.hasPermission("dyrtcraft.survivalgames.powiadomienia")) {
        		op.sendMessage(ChatColor.YELLOW + "* " + sender.getName() + " ustawil nowy punkt Lobby.");
        	}
        }
		return true;
	}
}

/*
 * Copyright © 2013 DyrtCraft Network All rights reserved.
 */
