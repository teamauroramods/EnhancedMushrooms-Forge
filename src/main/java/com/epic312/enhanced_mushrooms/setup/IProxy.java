package com.epic312.enhanced_mushrooms.setup;

import net.minecraft.world.World;

public interface IProxy {

    void init();

    World getClientWorld();
}
