package net.Malte.demonmod.entity.render;

import net.Malte.demonmod.DemonMod;
import net.Malte.demonmod.entity.custom.CustomIronGolemEntity;
import net.Malte.demonmod.entity.model.CustomIronGolemModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CustomIronGolemRenderer extends MobRenderer<CustomIronGolemEntity, CustomIronGolemModel<CustomIronGolemEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(DemonMod.MOD_ID, "textures/entity/customirongolemtexture.png");

    public CustomIronGolemRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new CustomIronGolemModel<>(),0.7f);
    }

    @Override
    public ResourceLocation getEntityTexture(CustomIronGolemEntity entity) {
        return TEXTURE;
    }
}

