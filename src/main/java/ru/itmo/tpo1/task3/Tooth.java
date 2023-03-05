package ru.itmo.tpo1.task3;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Зуб
 */
@Data
@AllArgsConstructor
public class Tooth {
    private KnockingLevel knockingLevel;
    private int number;
}
