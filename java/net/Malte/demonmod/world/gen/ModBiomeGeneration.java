package net.Malte.demonmod.world.gen;

import net.Malte.demonmod.world.biome.ModBiomes;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class ModBiomeGeneration {

    //Definiert den Typ des Biomes
    public static void generateBiomes() {
    addBiome(ModBiomes.DEMOINC_BIOME.get(), BiomeManager.BiomeType.WARM, 20, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.DRY);
    }

    // Nimmt das in "ModBiomes" erstellte Biome und fügt es zum "Biomewörterbuch" und zum "BiomManager" hinzu.
    private static void addBiome(Biome biome, BiomeManager.BiomeType type, int weight, BiomeDictionary.Type... types) {
        RegistryKey<Biome> key = RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES,
                Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome)));

        BiomeDictionary.addTypes(key, types);
        BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(key, weight));
    }
}

