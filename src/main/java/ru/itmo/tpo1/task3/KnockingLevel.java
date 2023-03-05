package ru.itmo.tpo1.task3;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Степень стучания
 */
@Getter
@AllArgsConstructor
public enum KnockingLevel {
    NONE(0), CHILD(1), ADULT(2);
    private final int level;
}
