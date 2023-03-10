package ru.itmo.tpo1.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HumanTest {

    private Human human;

    @BeforeEach
    void initHuman() {
        this.human = new Human();
    }

    @Test
    @DisplayName("Проверка, что изначально у человека 32 зуба")
    void humanCreating_shouldFeelTheTeeth() {
        int teethCount = 32;
        assertEquals(human.getTeeth().size(), teethCount);

    }

    @Test
    @DisplayName("Проверка, что изначально все зубы не стучат")
    void humanCreating_shouldKnockingLevelIsNone() {
        for (Tooth tooth: human.getTeeth()) {
            assertEquals(tooth.getKnockingLevel(), KnockingLevel.NONE);
        }
    }
}
