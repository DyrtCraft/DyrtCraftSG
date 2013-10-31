package pl.dyrtcraft.dyrtcraftsg;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import pl.dyrtcraft.dyrtcraftsg.listeners.PlayerChangeServerListener;
import pl.dyrtcraft.dyrtcraftsg.listeners.PlayerInteractListener;
import pl.dyrtcraft.dyrtcraftsg.listeners.PlayerJoinListener;
import pl.dyrtcraft.dyrtcraftsg.listeners.PlayerQuitListener;

public class DyrtCraftSG extends JavaPlugin {

	@Override
	public void onEnable() {
		getLogger().info("[DyrtCraftSG] Rejestrowanie listenerów...");
		getServer().getPluginManager().registerEvents(new ArenaInventory(this), this);
		getServer().getPluginManager().registerEvents(new PlayerChangeServerListener(this), this);
		getServer().getPluginManager().registerEvents(new PlayerInteractListener(this), this);
		getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
		getServer().getPluginManager().registerEvents(new PlayerQuitListener(this), this);
		getLogger().info("[DyrtCraftSG] Zarejestrowano listenery!");
	}
	
	public static ItemStack arena() {
		ItemStack i = new ItemStack(Material.NETHER_STAR, 1);
		ItemMeta iMeta = i.getItemMeta();
		iMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Areny Survival Games");
		iMeta.setLore(Arrays.asList(ChatColor.DARK_GREEN + "Kliknij, aby wybrac arene SG!"));
		i.setItemMeta(iMeta);
		return i;
	}
	
	public static ItemStack compass() {
		ItemStack i = new ItemStack(Material.COMPASS, 1);
		ItemMeta iMeta = i.getItemMeta();
		iMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Serwery DyrtCraft Network");
		iMeta.setLore(Arrays.asList(ChatColor.DARK_GREEN + "Kliknij, aby wybrac serwer!"));
		i.setItemMeta(iMeta);
		return i;
	}
	
	public static ItemStack lobby() {
		ItemStack i = new ItemStack(Material.EYE_OF_ENDER, 1);
		ItemMeta iMeta = i.getItemMeta();
		iMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Powrót na serwer Lobby");
		iMeta.setLore(Arrays.asList(ChatColor.DARK_GREEN + "Kliknij, aby przejsc do Lobby!"));
		i.setItemMeta(iMeta);
		return i;
	}
	
}
