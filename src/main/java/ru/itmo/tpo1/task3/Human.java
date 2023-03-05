package ru.itmo.tpo1.task3;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Human {
    private List<Tooth> teeth = new ArrayList<>();
    private Feeling feeling;
    private Life life;
    private Status status;

    public Human() {
        for (int i = 1; i <= 32; i++) {
            teeth.add(new Tooth(KnockingLevel.NONE, i));
        }
    }

    public boolean feelTheMoment(Moment moment) {
        if (moment.getImportance() == life.getMomentToReady().getImportance()) {
            teeth.forEach(
                    tooth -> tooth.setKnockingLevel(KnockingLevel.CHILD)
            );
            this.feeling = Feeling.CHOCKING;
            return true;
        }
        return false;
    }

    public boolean isReady(Status status) {
        return this.status.equals(status);
    }
}
