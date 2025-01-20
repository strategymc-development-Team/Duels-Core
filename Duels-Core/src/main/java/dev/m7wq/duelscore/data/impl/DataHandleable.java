package dev.m7wq.duelscore.data.impl;

import dev.m7wq.duelscore.data.entity.DuelsData;

import java.util.HashMap;

public interface DataHandleable {

    DuelsData getData();
    void setData(HashMap<String,DuelsData> map);

}
