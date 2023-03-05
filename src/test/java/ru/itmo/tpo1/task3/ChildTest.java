package ru.itmo.tpo1.task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChildTest {

    @Test
    @DisplayName("Проверка на создание ребёка: он должен быть спокоен и его зубы не стучат")
    void childCreating_shouldChill() {
        Child child = new Child();
        assertEquals(child.getFeeling(), Feeling.CHILL);
        for (Tooth tooth: child.getTeeth())
            assertEquals(tooth.getKnockingLevel(), KnockingLevel.NONE);
    }

    @Test
    @DisplayName("Ребёнок волнутеся: должно измениться чувство и зубы должны начать стучать")
    void worry_ShouldChangeFeelingAndTeeth() {
        Child child = new Child();
        child.worry();
        assertEquals(child.getFeeling(), Feeling.ANXIETY);
        for (Tooth tooth: child.getTeeth())
            assertEquals(tooth.getKnockingLevel(), KnockingLevel.CHILD);
    }
}
