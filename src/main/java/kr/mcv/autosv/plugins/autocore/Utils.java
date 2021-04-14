package kr.mcv.autosv.plugins.autocore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Utils {

    public static class Message {

        public static String defaultPrefix = "!";

        public static void sendMessage(MLevel level, String message) {
            sendMessage(defaultPrefix, level, message);
        }

        public static void sendMessage(String prefix, MLevel level, String message) {
            sendMessage(console(), level, message);
        }

        public static void sendMessage(CommandSender sender, MLevel level, String message) {
            sendMessage(sender, defaultPrefix, level, message);
        }

        public static void sendMessage(CommandSender sender, String prefix, MLevel level, String message) {
            if(message.startsWith("@")) {
                String k = message.substring(0);

            }

            if(message.startsWith("@@")) message = message.substring(0);
            sender.sendMessage(color(level.toString().replace("$p", prefix) + message));
        }

        public static String color(String string) {
            return ChatColor.translateAlternateColorCodes('&', string);
        }

        public static CommandSender console() {
            return Bukkit.getConsoleSender();
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
