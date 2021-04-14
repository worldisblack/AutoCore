package kr.mcv.autosv.plugins.autocore;

import org.bukkit.configuration.file.FileConfiguration;
import sun.util.locale.LocaleUtils;

import java.io.File;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class Lang {

    public final Locale defaultLocale = Locale.ENGLISH;

    public Locale currentLocale;

    public Map<Locale, FileConfiguration> languages;

    public void loadLanguages(File path) {
        if(!path.exists() || path.isFile()) return;

        File[] files = path.listFiles();
        for(File file : files) {
            if(!file.getName().endsWith(".properties") || !file.getName().startsWith("lang")) return;


        }
    }

    public void saveDefaultLanguages() {
        saveLanguages(false);
    }

    public void saveLanguages(boolean replace) {

    }

}
