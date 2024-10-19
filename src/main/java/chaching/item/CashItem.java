package chaching.item;

import chaching.stats.ModStats;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CashItem extends Item {
	public CashItem(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		user.increaseStat(ModStats.BALANCE, 1);
		// Decrease the stack size by 1
		ItemStack stack = user.getStackInHand(hand);
		stack.decrement(1);

		return super.use(world, user, hand);
	}
}
