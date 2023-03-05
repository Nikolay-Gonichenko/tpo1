package ru.itmo.tpo1.task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HumanTest {

    @Test
    @DisplayName("Проверка, что изначально все зубы не трясутся")
    void humanCreating_shouldFeelTheTeeth() {
        int teethCount = 32;
        Human human = new Human();
        assertEquals(human.getTeeth().size(), teethCount);
        for (Tooth tooth: human.getTeeth()) {
            assertEquals(tooth.getKnockingLevel(), KnockingLevel.NONE);
        }
    }

    @Test
    @DisplayName("Проверка на состояние человка, когда он почувствовал тот самый момент")
    void humanFeelTheMoment_shouldReturnTrue() {
        Human human = new Human();
        Moment moment = new Moment(5);
        human.setLife(new Life(moment));

        assertTrue(human.feelTheMoment(moment));
        assertEquals(human.getFeeling(), Feeling.CHOCKING);
        for (Tooth tooth: human.getTeeth()) {
            assertEquals(tooth.getKnockingLevel(), KnockingLevel.CHILD);
        }
    }

    @Test
    @DisplayName("Проверка на состояние человка, когда он почувствовал не тот самый момент")
    void humanFeelTheMoment_shouldReturnFalse() {
        Human human = new Human();
        Moment moment = new Moment(5);
        human.setLife(new Life(moment));
        Moment momentFalse = new Moment(6);

        assertFalse(human.feelTheMoment(momentFalse));
        assertNull(human.getFeeling());
        for (Tooth tooth: human.getTeeth()) {
            assertEquals(tooth.getKnockingLevel(), KnockingLevel.NONE);
        }
    }
}
