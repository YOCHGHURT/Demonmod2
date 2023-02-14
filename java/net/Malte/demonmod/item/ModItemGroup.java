package net.Malte.demonmod.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup DEMON_GROUP = new ItemGroup("demonModTab")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.AMETHYST.get());
        }
    }; //Anonyme Klasse (Override einer anderen Klasse)
}
