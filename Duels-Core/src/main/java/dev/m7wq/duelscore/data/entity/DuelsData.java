package dev.m7wq.duelscore.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DuelsData {

    String uuid;
    int wins;
    int loses;
    int coins;
    int winStreak;

}
