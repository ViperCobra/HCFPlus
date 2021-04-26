package life.steeze.hcfplus.FSubCommands;

import life.steeze.hcfplus.Faction;
import life.steeze.hcfplus.HCFPlugin;
import life.steeze.hcfplus.NotInFaction;
import life.steeze.hcfplus.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.UUID;

public class KickCommand implements SubCommand {
    @Override
    public void perform(Player p, String[] args, HCFPlugin plugin) throws NotInFaction {
        Faction f = plugin.getData().getFactionOrError(p);
        UUID target = Bukkit.getOfflinePlayer(args[0]).getUniqueId();
        if(target.equals(p.getUniqueId())){
            p.sendMessage(ChatColor.RED + "You can't kick yourself. Try leaving instead.");
            return;
        }
        if(f.removePlayer(target)){
            p.sendMessage(ChatColor.GOLD + "Success!");
         } else {
            p.sendMessage(ChatColor.RED + "Player isn't in your faction");
        }
    }
}
