package ru.itmo.tpo1.task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoryTest {

    @Test
    @DisplayName("Проверка на выборку людей при рождении")
    void choosePeople_shouldChooseOnlyRight() {
        List<Human> humans = new ArrayList<>();
        String rightString = "Будущие свидетели Ответа";
        Moment momentToReady = new Moment(5);
        Human human1 = new Human();
        human1.setStatus(new Status(rightString));
        Human human2 = new Human();
        human2.setStatus(new Status(rightString));
        Human human3 = new Human();
        human3.setStatus(new Status("1234"));
        humans.add(human1);
        humans.add(human2);
        humans.add(human3);

        List<Human> humansAfterChoosing = Story.choosePeople(humans, momentToReady);
        assertEquals(humansAfterChoosing.size(), 2);
        for (Human human : humansAfterChoosing) {
            assertEquals(human.getLife().getMomentToReady().getImportance(), momentToReady.getImportance());
        }
    }
}
