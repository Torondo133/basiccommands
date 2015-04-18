package me.aron.basic;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Events implements Listener {
	
	
	@EventHandler
    public void onLogin(PlayerJoinEvent event) {
		event.setJoinMessage(null);
        String name = event.getPlayer().getName();
        
        Bukkit.broadcastMessage(ChatColor.GREEN + "[Basic Commands] " + ChatColor.DARK_AQUA + "Welcome back " + ChatColor.GREEN + name + ChatColor.DARK_AQUA + " to the server!");
		
		
    }
	
	@EventHandler
    public void onLogout(PlayerQuitEvent event) {
		event.setQuitMessage(null);
        String name = event.getPlayer().getName();
        
        Bukkit.broadcastMessage(ChatColor.GREEN + "[Basic Commands] " + ChatColor.GREEN + name + ChatColor.DARK_AQUA + " has quit the server!");
		
		
    }
	
	public void BlockBreak(BlockBreakEvent event) {
		
		if (event.getBlock().equals(Material.DIAMOND_ORE)) {
			
			event.getPlayer().sendMessage(ChatColor.GREEN + "[Basic Commands]"  + ChatColor.AQUA + "You just break a diamond block!");
			
		}
		
		
	}
}
