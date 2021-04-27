package life.steeze.hcfplus;

import life.steeze.hcfplus.FileUtils.ConfigManager;
import life.steeze.hcfplus.FileUtils.FactionsFile;
import life.steeze.hcfplus.Objects.Claim;
import life.steeze.hcfplus.Objects.Faction;
import life.steeze.hcfplus.Timers.AbilitiesTimer;
import life.steeze.hcfplus.Utilities.ClaimWand;
import life.steeze.hcfplus.Utilities.ColorGUI;
import life.steeze.hcfplus.Utilities.PlayerData;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class HCFPlugin extends JavaPlugin implements CommandExecutor {

    private AbilitiesTimer abilities;

    private PlayerData playerData;
    public PlayerData getData(){
        return this.playerData;
    }

    private ColorGUI colorGUI;
    public Inventory getColorGUI() {
        return colorGUI.getColors();
    }

    private ClaimWand claimWand;
    public ClaimWand getClaimWand(){ return claimWand; }
    public ItemStack getWand(){
        return claimWand.getWand();
    }

    private FactionsFile factionsFile;

    @Override
    public void onEnable(){
        this.playerData = new PlayerData();
        this.colorGUI = new ColorGUI();
        this.claimWand = new ClaimWand(this);
        getCommand("faction").setExecutor(new FCommand(this));
        ConfigManager.loadConfig(this.getConfig());
        factionsFile = new FactionsFile(this);
        factionsFile.loadFactions();
        ConfigurationSerialization.registerClass(Faction.class);
        ConfigurationSerialization.registerClass(Claim.class);
        getServer().getPluginManager().registerEvents(new Events(this), this);
        if(ConfigManager.USE_KITS){
            abilities = new AbilitiesTimer(this);
        }
    }

    @Override
    public void onDisable(){
        factionsFile.saveFactions();
    }
}
