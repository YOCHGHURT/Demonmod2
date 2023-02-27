package net.Malte.demonmod.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.Malte.demonmod.entity.custom.CustomIronGolemEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class CustomIronGolemModel <T extends CustomIronGolemEntity> extends EntityModel<T> {
    private final ModelRenderer Head;
    private final ModelRenderer Body;
    private final ModelRenderer RightArm;
    private final ModelRenderer LeftArm;
    private final ModelRenderer LeftLeg;
    private final ModelRenderer RightLeg;

    public CustomIronGolemModel() {
        int i = 128;
        int j = 128;
        this.Head = (new ModelRenderer(this)).setTextureSize(128, 128);
        this.Head.setRotationPoint(0.0F, -7.0F, -2.0F);
        this.Head.setTextureOffset(0, 0).addBox(-4.0F, -12.0F, -5.5F, 8.0F, 10.0F, 8.0F, 0.0F);
        this.Head.setTextureOffset(24, 0).addBox(-1.0F, -5.0F, -7.5F, 2.0F, 4.0F, 2.0F, 0.0F);
        this.Body = (new ModelRenderer(this)).setTextureSize(128, 128);
        this.Body.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.Body.setTextureOffset(0, 40).addBox(-9.0F, -2.0F, -6.0F, 18.0F, 12.0F, 11.0F, 0.0F);
        this.Body.setTextureOffset(0, 70).addBox(-4.5F, 10.0F, -3.0F, 9.0F, 5.0F, 6.0F, 0.5F);
        this.RightArm = (new ModelRenderer(this)).setTextureSize(128, 128);
        this.RightArm.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.RightArm.setTextureOffset(60, 21).addBox(-13.0F, -2.5F, -3.0F, 4.0F, 30.0F, 6.0F, 0.0F);
        this.LeftArm = (new ModelRenderer(this)).setTextureSize(128, 128);
        this.LeftArm.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.LeftArm.setTextureOffset(60, 58).addBox(9.0F, -2.5F, -3.0F, 4.0F, 30.0F, 6.0F, 0.0F);
        this.LeftLeg = (new ModelRenderer(this, 0, 22)).setTextureSize(128, 128);
        this.LeftLeg.setRotationPoint(-4.0F, 11.0F, 0.0F);
        this.LeftLeg.setTextureOffset(37, 0).addBox(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, 0.0F);
        this.RightLeg = (new ModelRenderer(this, 0, 22)).setTextureSize(128, 128);
        this.RightLeg.mirror = true;
        this.RightLeg.setTextureOffset(60, 0).setRotationPoint(5.0F, 11.0F, 0.0F);
        this.RightLeg.addBox(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, 0.0F);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount,
                                  float ageInTicks, float netHeadYaw, float headPitch) {
        this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.Head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.LeftLeg.rotateAngleX = -1.5F * MathHelper.func_233021_e_(limbSwing, 13.0F) * limbSwingAmount;
        this.RightLeg.rotateAngleX = 1.5F * MathHelper.func_233021_e_(limbSwing, 13.0F) * limbSwingAmount;
        this.LeftLeg.rotateAngleY = 0.0F;
        this.RightLeg.rotateAngleY = 0.0F;
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn,
                       int packedOverlayIn, float red, float green, float blue, float alpha) {
        Head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        Body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        RightArm.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        RightLeg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        LeftArm.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        LeftLeg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }


    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

}
