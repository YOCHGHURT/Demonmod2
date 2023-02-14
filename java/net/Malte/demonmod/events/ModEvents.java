package net.Malte.demonmod.events;


import net.Malte.demonmod.DemonMod;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = DemonMod.MOD_ID)
public class ModEvents {

   // @SubscribeEvent
   // public static void onCommandsRegister(RegisterCommandsEvent event) {
      // new SetHomeCommand(event.getDispatcher());
      //  new ReturnHomeCommand(event.getDispatcher());

       // ConfigCommand.register(event.getDispatcher());



       // @SubscribeEvent
       // public static void onPlayerCloneEvent(PlayerEvent.Clone event) {
          //  if (!event.getOriginal().getentityworld().isRemote()) {
              //  event.getPlayer().getPersistentData().putIntArray(DemonMod.MOD_ID + "homepos",
                     //   event.getOriginal().getPersistentData().getIntArray(DemonMod.MOD_ID + "homepos"));
            }
