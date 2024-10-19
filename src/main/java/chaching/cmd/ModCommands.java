package chaching.cmd;

import chaching.stats.ModStats;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class ModCommands {
	public static void init(CommandDispatcher<ServerCommandSource> dispatcher) {
		// This method is called from Chaching.onInitialize()
		dispatcher.register(CommandManager.literal("balance")
			.executes(context -> {
				// This code runs when the /balance command is executed
				// Get the player
				ServerCommandSource source = context.getSource();
				// Get the player's balance
				int balance = source.getPlayer().getStatHandler().getStat(ModStats.BALANCE_STAT);
				// Send the player a message with their balance (e.g. "Player's balance: 0")
				source.sendMessage(Text.of(source.getPlayer().getDisplayName().getString() + "'s balance: " + balance));
				return 1;
			})
		);
	}
}
