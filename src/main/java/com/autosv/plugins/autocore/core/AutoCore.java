package com.autosv.plugins.autocore.core;

import arc.Core;
import arc.files.Fi;
import com.autosv.plugins.autocore.events.EventPlayerJoin1;
import com.autosv.plugins.autocore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Plugin main
 *
 * @version 1.2
 * @since 1.0-Alpha
 */
public final class AutoCore extends JavaPlugin {

    @Override
    public void onEnable() {
        Utils.Message.sendMessage(Utils.Message.console(), Utils.MLevel.I, "플러그인을 로드하는 중입니다. Version " + getDescription().getVersion());
        long loadTimer = System.currentTimeMillis();

        Core.settings.setDataDirectory(new Fi(getDataFolder()));
        Core.settings.load();

        registerEvents();
        registerCommands();

        long loadFin = System.currentTimeMillis() - loadTimer;
        Utils.Message.sendMessage(Utils.Message.console(), Utils.MLevel.I, "플러그인이 로드됬습니다. Time " + loadFin + "ms 소요됨");
    }

    @Override
    public void onDisable() {
        Utils.Message.sendMessage(Utils.Message.console(), Utils.MLevel.I, "플러그인을 언로드하는 중입니다. Version " + getDescription().getVersion());
        long unloadTimer = System.currentTimeMillis();

        Core.settings.forceSave();

        long unloadFin = System.currentTimeMillis() - unloadTimer;
        Utils.Message.sendMessage(Utils.Message.console(), Utils.MLevel.I, "플러그인이 언로드됬습니다. Time " + unloadFin + "ms 소요됨");
    }

    public void registerEvents() {
        PluginManager manager = Bukkit.getPluginManager();
        registerEvent(manager, new EventPlayerJoin1());
    }

    public void registerEvent(PluginManager manager, Listener listener) {
        manager.registerEvents(listener, this);
    }

    public void registerCommands() {

    }

}
