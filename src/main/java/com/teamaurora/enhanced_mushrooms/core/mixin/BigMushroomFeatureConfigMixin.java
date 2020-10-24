package com.teamaurora.enhanced_mushrooms.core.mixin;

import jdk.internal.org.objectweb.asm.Opcodes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.feature.BigMushroomFeatureConfig;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BigMushroomFeatureConfig.class)
public class BigMushroomFeatureConfigMixin {
    @Shadow
    @Final
    BlockStateProvider field_227273_b_;

    /*@Redirect(method = "<init>*", at = @At(value = "FIELD", target = ""))
    private void onConstructed(BlockStateProvider p_i225832_1_, BlockStateProvider p_i225832_2_, int p_i225832_3_, CallbackInfo ci) {
        this.field_227273_b_ = p_i225832_2_;
    }*/

    //@ModifyArg(method = "<init>*")
    /*@Inject(method = "<init>*", at = @At(value = "RETURN"))
    private void help(BlockStateProvider p_i225832_1_, BlockStateProvider p_i225832_2_, int p_i225832_3_, CallbackInfo ci) {
        //field_227273_b_ = p_i225832_1_;

    }*/
    /*@Overwrite
    public BigMushroomFeatureConfig(BlockStateProvider p_i225832_1_, BlockStateProvider p_i225832_2_, int p_i225832_3_) {
        this.field_227272_a_ = p_i225832_1_;
        this.field_227273_b_ = p_i225832_2_;
        this.field_227274_c_ = p_i225832_3_;
    }*/
    //@Redirect(method = )
}
