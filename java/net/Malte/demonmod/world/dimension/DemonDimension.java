package net.Malte.demonmod.world.dimension;

import net.Malte.demonmod.DemonMod;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class DemonDimension {
    public static RegistryKey<World> DDim = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
            new ResourceLocation(DemonMod.MOD_ID, "ddim"));
}
