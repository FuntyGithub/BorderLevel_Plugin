package org.funty.borderlevel.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.WorldBorder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.funty.borderlevel.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BorderLevelCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length <= 0){
            sender.sendMessage(ChatColor.RED + "=====[Border Level]=====");
            sender.sendMessage(ChatColor.RED + "Name: " + Main.getPlugin().getDescription().getFullName());
            sender.sendMessage(ChatColor.RED + "Version: " + Main.getPlugin().getDescription().getVersion());
            sender.sendMessage(ChatColor.RED + "Author: " + Main.getPlugin().getDescription().getAuthors().toString());
            sender.sendMessage(ChatColor.RED + "Github: https://github.com/FuntyGithub/BorderLevel_Plugin");
            sender.sendMessage(ChatColor.RED + "=====[Border Level]=====");
        }else {
            String arg = args[0];
            Player player = (Player) sender;
            switch (arg){
                case "setup":
                    if(sender.isOp()){
                        WorldBorder worldBorder = Bukkit.getWorld(player.getWorld().getUID()).getWorldBorder();
                        for(Player players : Bukkit.getOnlinePlayers()) {
                            players.teleport(player.getWorld().getHighestBlockAt(worldBorder.getCenter()).getLocation().add(0.0,1,0.0));
                        }
                        worldBorder.setSize(10, 0);
                        worldBorder.setSize(1, (long) worldBorder.getSize());
                    }
                    break;
                default:
                    sender.sendMessage(ChatColor.RED + "=====[Border Level]=====");
                    sender.sendMessage(ChatColor.RED + "Name: " + Main.getPlugin().getDescription().getFullName());
                    sender.sendMessage(ChatColor.RED + "Version: " + Main.getPlugin().getDescription().getVersion());
                    sender.sendMessage(ChatColor.RED + "Author: " + Main.getPlugin().getDescription().getAuthors().toString());
                    sender.sendMessage(ChatColor.RED + "Github: https://github.com/FuntyGithub/BorderLevel_Plugin");
                    sender.sendMessage(ChatColor.RED + "=====[Border Level]=====");
                    break;
            }
        }
        return false;
    }

    private static final String[] COMMANDS = { "setup", "version"};
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        final List<String> completions = new ArrayList<>();
        StringUtil.copyPartialMatches(args[0], Arrays.asList(COMMANDS), completions);
        Collections.sort(completions);
        return completions;
    }
}
