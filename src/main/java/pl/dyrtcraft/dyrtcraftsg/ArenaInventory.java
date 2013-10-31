package pl.dyrtcraft.dyrtcraftsg;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ArenaInventory implements Listener {

	private static Inventory inv;
	
	private ItemStack _1, _2, _3, _4, _5, _6, _7, _8;
	
	DyrtCraftSG plugin;
	
	public ArenaInventory(DyrtCraftSG dyrtCraftSG) {
		plugin = dyrtCraftSG;
		
		inv = Bukkit.createInventory(null, 9, ChatColor.DARK_GRAY + "Wybierz arene SG:");
		
		_1 = create("Ruiny", 1);
		_2 = create("Karaiby", 2);
		_3 = create("Karaiby2", 3);
		_4 = create("Ruiny2", 4);
		_5 = create("Fallen Empire", 5);
		_6 = create("SGAJ320", 6);
		_7 = create("WronsWorld", 7);
		_8 = create("SolarForest2", 8);
		
		inv.setItem(0, _1);
		inv.setItem(1, _2);
		inv.setItem(2, _3);
		inv.setItem(3, _4);
		inv.setItem(4, _5);
		inv.setItem(5, _6);
		inv.setItem(6, _7);
		inv.setItem(7, _8);
	}
	
	public static Inventory getInventory() {
		return inv;
	}
	
	private ItemStack create(String name, int numer) {
		ItemStack i = new ItemStack(Material.GOLD_SWORD, numer);
		ItemMeta iMeta = i.getItemMeta();
		iMeta.setDisplayName(ChatColor.GOLD+"Arena " + numer + ": " + name + ".");
		i.setItemMeta(iMeta);
		return i;
	}
	
	private void join(Player player, int arena) {
		player.performCommand("sg join " + arena);
		player.closeInventory();
	}
	
	@EventHandler
	public void onPlayerInventoryClick(InventoryClickEvent e) {
		if(!(e.getInventory().getName() == inv.getName())) return;
		e.setCancelled(true);
		
		if(e.getSlot() == 0) {
			join((Player) e.getWhoClicked(), 1);
		}
		if(e.getSlot() == 1) {
			join((Player) e.getWhoClicked(), 2);
		}
		if(e.getSlot() == 2) {
			join((Player) e.getWhoClicked(), 3);
		}
		if(e.getSlot() == 3) {
			join((Player) e.getWhoClicked(), 4);
		}
		if(e.getSlot() == 4) {
			join((Player) e.getWhoClicked(), 5);
		}
		if(e.getSlot() == 5) {
			join((Player) e.getWhoClicked(), 6);
		}
		if(e.getSlot() == 6) {
			join((Player) e.getWhoClicked(), 7);
		}
		if(e.getSlot() == 7) {
			join((Player) e.getWhoClicked(), 8);
		}
	}
	
}
