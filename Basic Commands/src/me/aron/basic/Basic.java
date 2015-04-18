package me.aron.basic;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Basic extends JavaPlugin implements Listener{
	
	public void onEnable() {
		
		Events Events = new Events();
		getServer().getPluginManager().registerEvents(Events , this);
		
		Logger log = Logger.getLogger("Minecraft");
		log.info("Basic Commands is now enabled");
		
	}
		
	public void onDisable() {
			
		Logger log = Logger.getLogger("Minecraft");
		log.info("Basic Commands is now disabled");
		
	}
	
public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		Player player = (Player) sender;
	
	
	if(player.hasPermission("gamemodes")) {
		if(lbl.equalsIgnoreCase("1")) {
			player.setGameMode(GameMode.CREATIVE);
			player.sendMessage(ChatColor.GREEN +  "[BasicCommands] " + ChatColor.AQUA + "You are now in creative mode.");
		} else if(lbl.equalsIgnoreCase("0")) {
			player.setGameMode(GameMode.SURVIVAL);
			player.sendMessage(ChatColor.GREEN +  "[BasicCommands] " + ChatColor.AQUA + "You are now in survival mode.");
		} else if(lbl.equalsIgnoreCase("2")) {
			player.setGameMode(GameMode.ADVENTURE);
			player.sendMessage(ChatColor.GREEN +  "[BasicCommands] " + ChatColor.AQUA + "You are now in adventure mode.");
		}
	} else {
		player.sendMessage(ChatColor.GREEN +  "[BasicCommands] " + ChatColor.RED + "You do not have permissions for that command!");
	}
	
	if(player.hasPermission("mobs")) {

	if(lbl.equalsIgnoreCase("remove")) {
          for(Entity en : player.getWorld().getEntities()){
              if(!(en instanceof Player)) {
            	  en.remove();
            	  player.sendMessage(ChatColor.GREEN +  "[BasicCommands] " + ChatColor.BLUE + "You removed all the items and mobs!");
              }
         }
	} else if (lbl.equalsIgnoreCase("cow")) {
		player.getWorld().spawnEntity(player.getLocation(), EntityType.COW);
		player.sendMessage(ChatColor.GREEN +  "[BasicCommands] " + ChatColor.BLUE + "You spawned a Cow");
					
	} else if (lbl.equalsIgnoreCase("sheep")) {
		player.getWorld().spawnEntity(player.getLocation(), EntityType.SHEEP);
		player.sendMessage(ChatColor.GREEN +  "[BasicCommands] " + ChatColor.BLUE + "You spawned a Sheep");
		
	} else if (lbl.equalsIgnoreCase("pig")) {
		player.getWorld().spawnEntity(player.getLocation(), EntityType.PIG);
		player.sendMessage(ChatColor.GREEN +  "[BasicCommands] " + ChatColor.BLUE + "You spawned a Pig");
		
	} else if (lbl.equalsIgnoreCase("chicken")) {
		player.getWorld().spawnEntity(player.getLocation(), EntityType.CHICKEN);
		player.sendMessage(ChatColor.GREEN +  "[BasicCommands] " + ChatColor.BLUE + "You spawned a Chicken");
		
	} else if (lbl.equalsIgnoreCase("villager")) {
		player.getWorld().spawnEntity(player.getLocation(), EntityType.VILLAGER);
		player.sendMessage(ChatColor.GREEN +  "[BasicCommands] " + ChatColor.BLUE + "You spawned a Villager");
		
	}
	if(player.hasPermission("rename")) {
	if(lbl.equalsIgnoreCase("rename")) {
	
	if(args.length == 1) {
		
		ItemStack i = player.getItemInHand();
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(args[0]);
		i.setItemMeta(im);
		player.sendMessage(ChatColor.GREEN +  "[BasicCommands]" + ChatColor.BLUE + "You renamed the item in your hand to: " + ChatColor.AQUA + args[0]);
		}	
	}
	
	}
	 
    if (sender instanceof Player) {

                if (lbl.equalsIgnoreCase("broadcast")) {

                		if (player.hasPermission("broadcast")) {

                				if (args.length >= 1) {

                					String msg = "";
                					for (int i = 0; i < args.length; i++) {
                						msg = msg + args[i] + " ";
                					}

                					Bukkit.broadcastMessage(ChatColor.RED + "[Broadcast] " + ChatColor.GREEN + msg); return true;

                				}else {
                					player.sendMessage(ChatColor.GREEN + "[BasicCommands] " + "Wrong usage, use it like: A message must contain at least 1 word!");
                					return false;
                				}

                		}else {
                			player.sendMessage(ChatColor.GREEN + "[BasicCommands] " + ChatColor.RED + "You do not Permissions to perform this Command."); return true;
                		}

                	}
    			}else {
            		System.out.println("[BasicCommands] This Command must be executed by an ingame Player");
    			}
		}
	if(player.hasPermission("spawn")) {
		
		if(lbl.equalsIgnoreCase("spawn")) {
				
			player.teleport(player.getWorld().getSpawnLocation());
			player.sendMessage(ChatColor.GREEN + "[BasicCommands] " + ChatColor.RED + "You are now on the spawn!.");
				
			}
			
		} else {
			player.sendMessage(ChatColor.GREEN + "[BasicCommands] " + ChatColor.RED + "You do not have Permissions to perform this Command.");
		}
	
	if(player.hasPermission("spawn.set")) {
		
		if(lbl.equalsIgnoreCase("spawnset")) {
			
			World world = player.getWorld();
			Location loc = player.getLocation();
			world.setSpawnLocation(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ());
			player.sendMessage(ChatColor.GREEN + "[BasicCommands] " + ChatColor.RED + "You set the spawn, right here.");
			
		}
		
	} else {
		player.sendMessage(ChatColor.GREEN + "[BasicCommands] " + ChatColor.RED + "You do not have Permissions to perform this Command.");
	}
	
	return false;
	}
	
}
