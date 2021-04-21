package com.autosv.plugins.autocore;

import arc.Core;
import arc.files.Fi;

/**
 * Manager for static vars
 *
 * @update 1.2-Alpha
 * @version 1.0
 * @since 1.2-Alpha
 */
public class Vars {

    /**
     * System locale use at console
     * this will modified by config
     */
    public static String systemLocale = "en_US";

    /**
     * Default user locale use at player
     * player can change own locale by command or gui
     * this will modified by config
     * set this value to "autodetect" to auto detect with players locale
     */
    public static String defaultUserLocale = "autodetect";

    public static long defaultBalance;

    public static int defaultMaxFriendLimit = -1;

    /**
     * load bundle and settings
     *
     *
     */
    public static void loadSettings() {
        try {
            Fi handle = Core.files.external("bundle");

        } catch (Exception ignored) {

        }
    }

}
