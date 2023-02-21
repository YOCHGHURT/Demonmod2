package net.Malte.demonmod.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.Malte.demonmod.entity.custom.CustomIronGolemEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class CustomIronGolemModel <T extends CustomIronGolemEntity> extends SegmentedModel<T> {
    private final ModelRenderer DarkGolem;
    private final ModelRenderer Torso;
    private final ModelRenderer Chest;
    private final ModelRenderer RightLeg;
    private final ModelRenderer LeftArm;
    private final ModelRenderer Head;
    private final ModelRenderer LeftLeg;
    private final ModelRenderer RightArm;

    public CustomIronGolemModel() {
        textureWidth = 128;
        textureHeight = 128;

        DarkGolem = new ModelRenderer(this);
        DarkGolem.setRotationPoint(0.0F, 0.0F, 0.0F);


        Head = new ModelRenderer(this);
        Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        DarkGolem.addChild(Head);
        Head.setTextureOffset(0, 36).addBox(-5.0F, -68.0F, -5.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);

        Chest = new ModelRenderer(this);
        Chest.setRotationPoint(0.0F, 0.0F, 0.0F);
        DarkGolem.addChild(Chest);
        Chest.setTextureOffset(0, 0).addBox(-13.0F, -52.0F, -5.0F, 32.0F, 20.0F, 16.0F, 0.0F, false);

        Torso = new ModelRenderer(this);
        Torso.setRotationPoint(0.0F, 0.0F, 0.0F);
        DarkGolem.addChild(Torso);
        Torso.setTextureOffset(48, 36).addBox(-5.0F, -32.0F, -1.0F, 16.0F, 8.0F, 8.0F, 0.0F, false);

        RightArm = new ModelRenderer(this);
        RightArm.setRotationPoint(0.0F, 0.0F, 0.0F);
        DarkGolem.addChild(RightArm);
        RightArm.setTextureOffset(0, 68).addBox(-21.0F, -52.0F, -1.0F, 8.0F, 48.0F, 8.0F, 0.0F, false);

        LeftArm = new ModelRenderer(this);
        LeftArm.setRotationPoint(0.0F, 0.0F, 0.0F);
        DarkGolem.addChild(LeftArm);
        LeftArm.setTextureOffset(56, 60).addBox(19.0F, -52.0F, -1.0F, 8.0F, 48.0F, 8.0F, 0.0F, false);

        LeftLeg = new ModelRenderer(this);
        LeftLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
        DarkGolem.addChild(LeftLeg);
        LeftLeg.setTextureOffset(89, 76).addBox(5.0F, -24.0F, -1.0F, 8.0F, 24.0F, 8.0F, 0.0F, false);

        RightLeg = new ModelRenderer(this);
        RightLeg.setRotationPoint(  0.0F, 0.0F, 0.0F);
        DarkGolem.addChild(RightLeg);
        RightLeg.setTextureOffset(88, 44).addBox(-7.0F, -24.0F, -1.0F, 8.0F, 24.0F, 8.0F, 0.0F, false);





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
        Chest.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        Torso.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        RightArm.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        RightLeg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        LeftArm.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        LeftLeg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return null;
    }


    // public void setRotationAngle(ModelRenderer modelRenderer,float x, float y, float z){
        //modelRenderer.rotateAngleX = x;
        //modelRenderer.rotateAngleY = y;
        //modelRenderer.rotateAngleZ = z;
    }

