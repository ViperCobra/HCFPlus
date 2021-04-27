package life.steeze.hcfplus.FSubCommands;

import life.steeze.hcfplus.*;
import life.steeze.hcfplus.Exceptions.NotInFaction;
import life.steeze.hcfplus.FileUtils.ConfigManager;
import life.steeze.hcfplus.Objects.Faction;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class DescCommand implements SubCommand {
    @Override
    public void perform(Player p, String[] args, HCFPlugin plugin) throws NotInFaction {
        Faction f = plugin.getData().getFactionOrError(p);
        if(!f.getLeader().equals(p.getUniqueId())){
            p.sendMessage(ChatColor.RED + "You must be the leader!");
            return;
        }
        String desc = String.join(" ", args);
        if (desc.toCharArray().length <= ConfigManager.MAX_DESCRIPTION_LENGTH) {
            f.setDescription(String.join(" ", args));
            p.sendMessage(ChatColor.YELLOW + "Success!");
        } else {
            p.sendMessage(ChatColor.RED + "Description exceeds maximum length.");
        }


    }
}
