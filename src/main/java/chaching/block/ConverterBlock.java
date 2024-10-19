package chaching.block;

import chaching.stats.ModStats;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ConverterBlock extends Block {
	public ConverterBlock(Settings settings) {
		super(settings);
	}

	@Override
	protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
		// First, read their balance stat
		int balance = ((ServerPlayerEntity) player).getStatHandler().getStat(ModStats.BALANCE_STAT);

		// Then, set their balance stat to 0
		((ServerPlayerEntity) player).getStatHandler().setStat(player, ModStats.BALANCE_STAT, 0);

		// Finally, give them that amount of cash by running the give command
		player.getServer().getCommandManager().executeWithPrefix(player.getCommandSource(), "give @s chaching:cash " + balance);

		return super.onUse(state, world, pos, player, hit);
	}
}
