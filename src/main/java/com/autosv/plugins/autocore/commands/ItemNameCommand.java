package com.autosv.plugins.autocore.commands;

import com.autosv.plugins.autocore.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * /iname command for user.
 * Use for changing item name
 *
 * @update 1.3-Alpha
 * @version 1.0
 * @since 1.3-Alpha
 */
public class ItemNameCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)) {
            Utils.Message.sendMessage(sender, Utils.MLevel.I, "");
            return false;
        }

        return false;
    }

}
