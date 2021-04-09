package kr.mcv.autosv.plugins.autocore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Utils {

    public static class Message {

        public static String defaultPrefix = "!";

        public static void sendMessage(L level, String message) {
            Bukkit.getConsoleSender().sendMessage(color(level.toString().replace("$p", defaultPrefix) + message));
        }

        public static void sendMessage(String prefix, L level, String message) {
            Bukkit.getConsoleSender().sendMessage(color(level.toString().replace("$p", prefix) + message));
        }

        public static void sendMessage(CommandSender sender, L level, String message) {
            sender.sendMessage(color(level.toString().replace("$p", defaultPrefix) + message));
        }

        public static void sendMessage(CommandSender sender, String prefix, L level, String message) {
            sender.sendMessage(color(level.toString().replace("$p", prefix) + message));
        }

        public static String color(String string) {
            return ChatColor.translateAlternateColorCodes('&', string);
        }

        public static CommandSender console() {
            return Bukkit.getConsoleSender();
        }

        public enum L {
            I {
                @Override
                public String toString() {
                    return " &a$p ";
                }
            },
            W {
                @Override
                public String toString() {
                    return " &e$p ";
                }
            },
            E {
                @Override
                public String toString() {
                    return " &c$p ";
                }
            }
        }

    }
}
