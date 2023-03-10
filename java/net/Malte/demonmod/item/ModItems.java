package net.Malte.demonmod.item;

import net.Malte.demonmod.DemonMod;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

import static net.Malte.demonmod.block.ModBlocks.BLOCKS;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DemonMod.MOD_ID);


    public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst",
            ()-> new Item(new Item.Properties().group(ModItemGroup.DEMON_GROUP)));



    public static final RegistryObject<Item> AMETHYST_SWORD = ITEMS.register("amethyst_sword",
            ()-> new SwordItem(ModItemTier.AMETHYST, 2, 3f,
                    new Item.Properties().group(ModItemGroup.DEMON_GROUP)));

    public static final RegistryObject<Item> AMETHYST_PICKAXE = ITEMS.register("amethyst_pickaxe",
            ()-> new PickaxeItem(ModItemTier.AMETHYST, 0, -1f,
                    new Item.Properties().group(ModItemGroup.DEMON_GROUP)));

    public static final RegistryObject<Item> AMETHYST_SHOVEL = ITEMS.register("amethyst_shovel",
            ()-> new ShovelItem(ModItemTier.AMETHYST, 0, -1f,
                    new Item.Properties().group(ModItemGroup.DEMON_GROUP)));

    public static final RegistryObject<Item> AMETHYST_AXE = ITEMS.register("amethyst_axe",
            ()-> new AxeItem(ModItemTier.AMETHYST, 4, -2f,
                    new Item.Properties().group(ModItemGroup.DEMON_GROUP)));

    public static final RegistryObject<Item> AMETHYST_HOE = ITEMS.register("amethyst_hoe",
            ()-> new HoeItem(ModItemTier.AMETHYST, 0, 0f,
                    new Item.Properties().group(ModItemGroup.DEMON_GROUP)));

    public static final RegistryObject<Item> AMETHYST_BOOTS = ITEMS.register("amethyst_boots",
            ()-> new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModItemGroup.DEMON_GROUP)));

    public static final RegistryObject<Item> AMETHYST_LEGGINGS = ITEMS.register("amethyst_leggings",
            ()-> new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModItemGroup.DEMON_GROUP)));

    public static final RegistryObject<Item> AMETHYST_CHESTPLATE = ITEMS.register("amethyst_chestplate",
            ()-> new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModItemGroup.DEMON_GROUP)));

    public static final RegistryObject<Item> AMETHYST_HELMET = ITEMS.register("amethyst_helmet",
            ()-> new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModItemGroup.DEMON_GROUP)));








    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
