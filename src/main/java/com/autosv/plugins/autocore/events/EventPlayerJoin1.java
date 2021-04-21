package com.autosv.plugins.autocore.events;

import com.autosv.plugins.autocore.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventPlayerJoin1 implements Listener {

    @EventHandler
    public void onEvent(PlayerJoinEvent event) throws Exception {
        Player player = event.getPlayer();
        player.sendMessage("AutoCore Debug: Ur locale is now " + Utils.Players.getLocale(player));
    }

}
