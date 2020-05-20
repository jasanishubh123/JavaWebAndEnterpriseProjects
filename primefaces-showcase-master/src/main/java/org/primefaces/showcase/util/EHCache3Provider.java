/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.primefaces.showcase.util;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;
import org.primefaces.cache.CacheProvider;

/**
 * Same class as org.primefaces.cache.EHCache3Provider
 * we need to copy it, to support 6.2.x elite
 */
public class EHCache3Provider implements CacheProvider {

    private CacheManager cacheManager;

    public EHCache3Provider() {
        XmlConfiguration xmlConfig = new XmlConfiguration(this.getClass().getResource("/ehcache.xml"));
        cacheManager = CacheManagerBuilder.newCacheManager(xmlConfig);
        cacheManager.init();
    }

    @Override
    public Object get(String region, String key) {
        Cache cacheRegion = getRegion(region);
        Object val = cacheRegion.get(key);

        return val;
    }

    @Override
    public void put(String region, String key, Object object) {
        Cache cacheRegion = getRegion(region);

        cacheRegion.put(key, object);
    }

    @Override
    public void remove(String region, String key) {
        Cache cacheRegion = getRegion(region);

        cacheRegion.remove(key);
    }

    @Override
    public void clear() {

    }

    protected Cache getRegion(String regionName) {
        Cache region = getCacheManager().getCache(regionName, String.class, Object.class);

        return region;
    }

    public CacheManager getCacheManager() {
        return cacheManager;
    }

    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }
}
