package com.autosv.plugins.autocore.utils;

import arc.Core;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/**
 * Utilities.
 *
 * @update 1.2-Alpha
 * @version 1.2
 * @since 1.0-Alpha
 */
public class Utils {

    /**
     * Player utilities
     *
     * @update 1.2-Alpha
     * @version 1.0
     * @since 1.2-Alpha
     */
    public static class Players {
        public static Locale getLocale(Player p) throws Exception {
            return new Locale(getLanguage(p));
        }

        public static String getLanguage(Player p) throws Exception {
            Object ep = getMethod("getHandle", p.getClass()).invoke(p, (Object[]) null);
            Field f = ep.getClass().getDeclaredField("locale");
            f.setAccessible(true);
            return (String) f.get(ep);
        }

        private static Method getMethod(String name, Class<?> clazz) {
            for (Method m : clazz.getDeclaredMethods()) {
                if (m.getName().equals(name))
                    return m;
            }
            return null;
        }
    }

    /**
     * Message sending utilities
     *
     * @update 1.2-Alpha
     * @version 1.2
     * @since 1.0-Alpha
     */
    public static class Message {

        public static String defaultPrefix = "!";

        public static void sendMessage(MLevel level, String message, Object... args) {
            sendMessage(defaultPrefix, level, message, args);
        }

        public static void sendMessage(String prefix, MLevel level, String message, Object... args) {
            sendMessage(console(), level, message, args);
        }

        public static void sendMessage(CommandSender sender, MLevel level, String message, Object... args) {
            sendMessage(sender, defaultPrefix, level, message, args);
        }

        public static void sendMessage(CommandSender sender, String prefix, MLevel level, String message, Object... args) {
            sender.sendMessage(color(String.format(level.toString().replace("$p", prefix) + getText(message).replace("%s", "&8%s" + level.toString().replace("$p", "")), args)));
        }

        public static String color(String string) {
            return ChatColor.translateAlternateColorCodes('&', string);
        }

        public static CommandSender console() {
            return Bukkit.getConsoleSender();
        }

        public static String getText(CharSequence text) {
            if (Core.bundle == null || text == null || text.length() <= 0 || text.charAt(0) != '$' && text.charAt(0) != '@') {
                return text.toString();
            } else {
                String out = text.toString().substring(1);
                return Core.bundle.get(out, text.toString());
            }
        }
    }

    public enum MLevel {
        I { // Info
            @Override
            public String toString() {
                return " &a$p ";
            }
        },
        W { // Warn
            @Override
            public String toString() {
                return " &e$p ";
            }
        },
        E { // Err
            @Override
            public String toString() {
                return " &c$p ";
            }
        },
        A { // Announce
            @Override
            public String toString() {
                return " &6$p ";
            }
        }
    }

}
