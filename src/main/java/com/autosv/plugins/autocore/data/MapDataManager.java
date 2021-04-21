package com.autosv.plugins.autocore.data;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * data manage by key/value
 * data save type database or type
 *
 * @update 1.2-Alpha
 * @version 1.0
 * @since 1.2
 */
public class MapDataManager<K, V> {

    protected Map<K, V> data = new HashMap<>();

    protected File file;
    protected SaveType type;


    public MapDataManager(File file, SaveType type) throws Exception {
        if(type == SaveType.Database) throw new Exception("데e터 BㅔE스 Jㅓ장방Siㅋ은 ㅇr직ㅈl원 도lㅈl 않습ㄴlㄷr");

        this.file = file;
        this.type = type;
    }

    /**
     * get copied map data.
     *
     * @return map data
     */
    public Map<K, V> data() {
        return new HashMap<K, V>(data);
    }

    /**
     * put data at map
     * @param key key
     * @param value value
     * @return this
     */
    public MapDataManager put(K key, V value) {
        data.put(key, value);
        return this;
    }

    /**
     * get data from map
     * @param key key
     * @return value
     */
    public V get(K key) {
        return data.get(key);
    }

    /**
     * get data keys
     * @return keys
     */
    public Set<K> k() {
        return data.keySet();
    }

    /**
     * get data values
     * @return values
     */
    public Collection<V> v() {
        return data.values();
    }

    /**
     *
     */
    public enum SaveType {
        Directory,
        Onefile,
        Database
    }

}
