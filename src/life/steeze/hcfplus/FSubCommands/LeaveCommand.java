package life.steeze.hcfplus.FSubCommands;

import life.steeze.hcfplus.Faction;
import life.steeze.hcfplus.HCFPlugin;
import life.steeze.hcfplus.NotInFaction;
import life.steeze.hcfplus.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class LeaveCommand implements SubCommand {
    @Override
    public void perform(Player p, String[] args, HCFPlugin plugin) throws NotInFaction {
        Faction f = plugin.getData().getFactionOrError(p);
        f.removePlayer(p.getUniqueId());
    }
}
