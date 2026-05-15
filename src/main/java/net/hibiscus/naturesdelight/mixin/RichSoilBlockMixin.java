package net.hibiscus.naturesdelight.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.hibiscus.naturesdelight.NaturesDelightBlocksAndItems;
import net.hibiscus.naturespirit.registration.NSMiscBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vectorwing.farmersdelight.common.block.RichSoilBlock;

@Mixin(RichSoilBlock.class)
public class RichSoilBlockMixin {
    @Inject(
        method = "convertMushroomToColony",
        at = @At("HEAD"),
        cancellable = true
    )
    private void naturesdelight$convertShiitake(
        BlockState targetState,
        BlockPos targetPos,
        ServerLevel level,
        CallbackInfoReturnable<Boolean> cir
    ) {
        if (targetState.is(NSBlocks.SHIITAKE_MUSHROOM.get())) {
            level.setBlockAndUpdate(
                targetPos,
                NaturesDelightBlocksAndItems.SHIITAKE_MUSHROOM_COLONY_BLOCK.get().defaultBlockState()
            );
            cir.setReturnValue(true);
        }
    }

}
