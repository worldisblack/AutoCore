package com.autosv.plugins.autocore.data;

import com.autosv.plugins.autocore.Vars;

import java.util.List;
import java.util.UUID;

/**
 * Data of player
 * stores uuid, balance, language, and more
 *
 * @author choigun
 * @version 1.0
 * @since 1.2-Alpha
 */
public class BasePlayer {

    protected String userLanguage = Vars.defaultUserLocale;

    protected long balance = Vars.defaultBalance;

    /**
     * players uuid
     */
    protected UUID uuid;

    /**
     * players first join time milliseconds
     * this variable is constant
     * @see BasePlayer#lastJoinTimeMillis
     */
    protected long firstJoinTimeMillis;

    /**
     * players last join time millisecond.
     * @see BasePlayer#firstJoinTimeMillis
     */
    protected long lastJoinTimeMillis;

    /**
     * players friends. can set limit at config
     *
     */
    protected List<BasePlayer> friends;

    /**
     * players friend limit. default by config
     * @see BasePlayer#friends
     * @see Vars#defaultMaxFriendLimit
     */
    protected int maxFriendLimit = Vars.defaultMaxFriendLimit;

    /**
     * create player data by default value
     * @param uuid players uuid
     * @param firstJoinTimeMillis player first join time as millisecond
     */
    protected BasePlayer(UUID uuid, long firstJoinTimeMillis) {
        uuid(uuid).firstJoinTimeMillis(firstJoinTimeMillis);
    }

    /**
     * Set player balance.
     *
     * @param newBalance new player balance
     * @return this
     */
    public BasePlayer balance(long newBalance) {
        this.balance = newBalance;
        return this;
    }

    /**
     * Get player balance.
     *
     * @return players balance
     */
    public long balance() {
        return balance;
    }

    /**
     * Set user language.
     *
     * @param newLanguage new user language
     * @return this
     */
    public BasePlayer userLanguage(String newLanguage) {
        this.userLanguage = newLanguage;
        return this;
    }

    /**
     * Get user language.
     *
     * @return users language
     */
    public String userLanguage() {
        return this.userLanguage;
    }

    /**
     * Set player uuid.
     *
     * @param uuid a new uuid
     * @return this
     */
    protected BasePlayer uuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    /**
     * Get player uuid.
     *
     * @return players uuid
     */
    public UUID uuid() {
        return this.uuid;
    }

    protected BasePlayer firstJoinTimeMillis(long firstJoinTimeMillis) {
        this.firstJoinTimeMillis = firstJoinTimeMillis;
        return this;
    }

    public long firstJoinTimeMillis() {
        return this.firstJoinTimeMillis;
    }

    public BasePlayer lastJoinTimeMillis(long lastJoinTimeMillis) {
        this.lastJoinTimeMillis = lastJoinTimeMillis;
        return this;
    }

    public long lastJoinTimeMillis() {
        return this.lastJoinTimeMillis;
    }

}
