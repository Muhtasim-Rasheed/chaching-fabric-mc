package chaching.stats;

import chaching.Chaching;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.stat.Stat;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;

public class ModStats {
	public static final Identifier BALANCE = Identifier.of(Chaching.MOD_ID, "balance");
	public static Stat BALANCE_STAT;

	public static void init() {
		// This method is called from Chaching.onInitialize()
		Registry.register(Registries.CUSTOM_STAT, BALANCE, BALANCE);
		BALANCE_STAT = Stats.CUSTOM.getOrCreateStat(BALANCE);
	}
}
