package ru.itmo.tpo1.task3;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Дети
 */
@Data
@AllArgsConstructor
public class Child {
    private Feeling feeling;
    private List<Tooth> teeth = new ArrayList<>();

    public Child() {
        for (int i = 1; i <= 32; i++) {
            teeth.add(new Tooth(KnockingLevel.NONE, i));
        }
        this.feeling = Feeling.CHILL;
    }

    public void worry() {
        this.feeling = Feeling.ANXIETY;
        for (Tooth tooth: teeth)
            tooth.setKnockingLevel(KnockingLevel.CHILD);
    }
}
