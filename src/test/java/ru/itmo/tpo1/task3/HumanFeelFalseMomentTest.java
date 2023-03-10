package ru.itmo.tpo1.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HumanFeelFalseMomentTest {
    private Human human;

    private Moment rightMoment;
    private Moment momentFalse;

    @BeforeEach
    void initValues() {
        human = new Human();
        rightMoment = new Moment(5);
        human.setLife(new Life(rightMoment));
        momentFalse = new Moment(6);
    }

    @Test
    @DisplayName("Проверка на состояние человка, когда он почувствовал не тот самый момент")
    void humanFeelTheMoment_shouldReturnFalse() {
        assertFalse(human.feelTheMoment(momentFalse));
        assertNull(human.getFeeling());
    }

    @Test
    @DisplayName("Проверка на состояние зубов человка, когда он почувствовал не тот самый момент")
    void humanFeelTheMoment_shouldKnockingLevelNone() {
        for (Tooth tooth: human.getTeeth()) {
            assertEquals(tooth.getKnockingLevel(), KnockingLevel.NONE);
        }
    }
}
