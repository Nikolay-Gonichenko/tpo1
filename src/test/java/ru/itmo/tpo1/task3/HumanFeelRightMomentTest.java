package ru.itmo.tpo1.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HumanFeelRightMomentTest {
    private Human human;

    private Moment moment;

    @BeforeEach
    void initValues() {
        this.human = new Human();
        this.moment = new Moment(5);
        this.human.setLife(new Life(moment));
    }

    @Test
    @DisplayName("Проверка на состояние человка, когда он почувствовал тот самый момент")
    void humanFeelTheMoment_shouldReturnTrue() {
        assertTrue(human.feelTheMoment(moment));
        assertEquals(human.getFeeling(), Feeling.CHOCKING);

    }

    @Test
    @DisplayName("Когда человек почувствовал тот самый момент - его зубы стучат")
    void humanFeelTheMoment_shouldKnockingLevelIsChild() {
        human.feelTheMoment(moment);
        for (Tooth tooth: human.getTeeth()) {
            assertEquals(tooth.getKnockingLevel(), KnockingLevel.CHILD);
        }
    }
}
