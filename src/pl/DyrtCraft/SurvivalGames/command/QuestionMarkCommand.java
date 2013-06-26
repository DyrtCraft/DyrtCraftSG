package pl.DyrtCraft.SurvivalGames.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.DyrtCraft.SurvivalGames.DyrtCraftSG;

public class QuestionMarkCommand implements CommandExecutor {

	/**
	 * 
	 * @author TheMolkaPL
	 * 
	 */
	
	//private DyrtCraftSG plugin;
	
	public QuestionMarkCommand(DyrtCraftSG dyrtCraftSG) {
		//plugin=dyrtCraftSG;
	}
	
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {		
		if(command.getName().equalsIgnoreCase("?")) {
			for(Player op : Bukkit.getOnlinePlayers()) {
				if(op.isOp() || op.hasPermission("dyrtcraft.survivalgames.powiadomienia")) {
					op.sendMessage(ChatColor.YELLOW + "* " + sender.getName() + " uzyl '?'.");
				}
			}
			return true;
		}
		return false;
	}

}

/*
 * Copyright © 2013 DyrtCraft Network All rights reserved.
 */
