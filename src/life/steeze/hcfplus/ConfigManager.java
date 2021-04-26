package life.steeze.hcfplus;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigManager {

    public static void loadConfig(final FileConfiguration config){
        MAX_CLAIM_DISTANCE = config.getInt("max-claim-corner-distance");
        MIN_CLAIM_WIDTH = config.getInt("min-claim-width");
        MAX_DESCRIPTION_LENGTH = config.getInt("max-description-length");
        DTR_REGEN = config.getInt("dtr-regen");
        FORMAT_CHAT = config.getBoolean("format-chat");
        FORMATTED_CHAT = config.getString("formatted-chat");
        NO_TEAM_FORMATTED_CHAT = config.getString("no-team-formatted-chat");
        MOB_SPAWN_IN_CLAIMS = config.getBoolean("mob-spawn-in-claims");
    }

    /*
    Configurable things
     */
    public static int MAX_CLAIM_DISTANCE;
    public static int MIN_CLAIM_WIDTH;
    public static int MAX_DESCRIPTION_LENGTH;
    public static int DTR_REGEN;
    public static boolean FORMAT_CHAT;
    public static String FORMATTED_CHAT;
    public static String NO_TEAM_FORMATTED_CHAT;
    public static boolean MOB_SPAWN_IN_CLAIMS;
}
