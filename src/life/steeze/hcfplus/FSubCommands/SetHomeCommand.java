package life.steeze.hcfplus.FSubCommands;

import life.steeze.hcfplus.Faction;
import life.steeze.hcfplus.HCFPlugin;
import life.steeze.hcfplus.NotInFaction;
import life.steeze.hcfplus.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class SetHomeCommand implements SubCommand {
    @Override
    public void perform(Player p, String[] args, HCFPlugin plugin) throws NotInFaction {
        Faction f = plugin.getData().getFactionOrError(p);
        if(!f.getLeader().equals(p.getUniqueId())){
            p.sendMessage(ChatColor.RED + "You must be the leader of your faction to use this!");
            return;
        }
        f.setHome(p);
    }
}
