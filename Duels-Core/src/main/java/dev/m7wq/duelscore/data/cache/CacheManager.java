package dev.m7wq.duelscore.data.cache;

import dev.m7wq.duelscore.data.entity.DuelsData;
import lombok.Getter;

import java.util.HashMap;

@Getter
public class CacheManager {

    private HashMap<String, DuelsData> cacheMap = new HashMap<>();

    public DuelsData getData(String uuid){
        return cacheMap.getOrDefault(uuid,new DuelsData(uuid,0,0,0,0));
    }

}
