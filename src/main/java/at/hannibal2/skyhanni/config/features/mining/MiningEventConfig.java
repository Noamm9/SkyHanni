package at.hannibal2.skyhanni.config.features.mining;

import at.hannibal2.skyhanni.config.FeatureToggle;
import at.hannibal2.skyhanni.config.core.config.Position;
import at.hannibal2.skyhanni.features.mining.eventtracker.MiningEventType.Companion.CompressFormat;
import com.google.gson.annotations.Expose;
import io.github.notenoughupdates.moulconfig.annotations.ConfigEditorBoolean;
import io.github.notenoughupdates.moulconfig.annotations.ConfigEditorDropdown;
import io.github.notenoughupdates.moulconfig.annotations.ConfigLink;
import io.github.notenoughupdates.moulconfig.annotations.ConfigOption;

public class MiningEventConfig {

    @Expose
    @ConfigOption(name = "Enabled", desc = "Show information about upcoming Dwarven Mines and Crystal Hollows mining events, " +
        "also enables you sending data. §eTakes up to a minute to sync new events.")
    @ConfigEditorBoolean
    @FeatureToggle
    public boolean enabled = false;

    @Expose
    @ConfigOption(name = "Show Outside Mining Islands", desc = "Shows the event tracker when you are not inside of the Dwarven Mines or Crystal Hollows.")
    @ConfigEditorBoolean
    public boolean outsideMining = false;

    @Expose
    @ConfigOption(name = "What to Show", desc = "Choose which island's events are shown in the gui.")
    @ConfigEditorDropdown
    public ShowType showType = ShowType.ALL;

    @Expose
    @ConfigOption(name = "Compressed Format", desc = "Compresses the event names so that they are shorter.")
    @ConfigEditorDropdown
    public CompressFormat compressedFormat = CompressFormat.DEFAULT;

    @Expose
    @ConfigOption(name = "Compressed Island", desc = "Shows the islands only as icon.")
    @ConfigEditorBoolean
    public boolean islandAsIcon = false;

    @Expose
    @ConfigOption(name = "Show Passed Events", desc = "Shows the most recent passed event at the start greyed out. " +
        "§eTakes a little while to save last event.")
    @ConfigEditorBoolean
    public boolean passedEvents = false;


    public enum ShowType {
        ALL("All Mining Islands"),
        CRYSTAL("Crystal Hollows Only"),
        DWARVEN("Dwarven Mines Only"),
        MINESHAFT("Mineshaft Only"),
        CURRENT("Current Island Only"),
        ;

        private final String str;

        ShowType(String str) {
            this.str = str;
        }

        @Override
        public String toString() {
            return str;
        }
    }

    @Expose
    @ConfigLink(owner = MiningEventConfig.class, field = "enabled")
    public Position position = new Position(200, 60, false, true);
}
