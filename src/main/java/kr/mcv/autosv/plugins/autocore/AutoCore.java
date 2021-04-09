package kr.mcv.autosv.plugins.autocore;

import org.bukkit.plugin.java.JavaPlugin;

import static kr.mcv.autosv.plugins.autocore.Utils.Message.*;

public final class AutoCore extends JavaPlugin {

    @Override
    public void onEnable() {
        sendMessage(console(), L.I, "플러그인을 로드하는 중입니다. Version " + getDescription().getVersion());
        long loadTimer = System.currentTimeMillis();

        long loadFin = System.currentTimeMillis() - loadTimer;
        sendMessage(console(), L.I, "플러그인이 로드됬습니다. Time " + loadFin + "ms 소요됨");
    }

    @Override
    public void onDisable() {
        sendMessage(console(), L.I, "플러그인을 언로드하는 중입니다. Version " + getDescription().getVersion());
        long unloadTimer = System.currentTimeMillis();

        long unloadFin = System.currentTimeMillis() - unloadTimer;
        sendMessage(console(), L.I, "플러그인이 언로드됬습니다. Time " + unloadFin + "ms 소요됨");
    }
}
