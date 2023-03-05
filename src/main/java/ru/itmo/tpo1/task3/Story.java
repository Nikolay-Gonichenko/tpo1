package ru.itmo.tpo1.task3;

import java.util.ArrayList;
import java.util.List;

public class Story {
    public static List<Human> choosePeople(List<Human> humans, Moment momentToReady) {
        List<Human> special = new ArrayList<>();
        humans.forEach(
                human -> {
                    if (human.getStatus().getName().equals("Будущие свидетели Ответа")) {
                        human.setLife(new Life(momentToReady));
                        special.add(human);
                    }
                }
        );

        return special;
    }
}
