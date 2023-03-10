package ru.itmo.tpo1.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class SecTest {
    private static final double DELTA = 0.0001;

    @ParameterizedTest
    @DisplayName("Testing sec(x) on dots where the result is NaN")
    @ValueSource(doubles = {Math.PI / 2, 3 * Math.PI / 2})
    void sec_shouldThrowIllegalArgumentException(double dot) {
        assertThrows(IllegalArgumentException.class, () -> Sec.sec(dot));
    }

    @ParameterizedTest
    @DisplayName("Testing sec(x) on randomValue in {0; 2*Pi}")
    @ValueSource(doubles = {0, 0.1, 0.2, 1.0, 2.0, 3.0, 4.0})
    void sec_RandomValues(double dot) {
        assertEquals(1.0 / Math.cos(dot), Sec.sec(dot), DELTA);
    }

    @ParameterizedTest
    @DisplayName("Testing sec(x) on randomValue which is more than 2*Pi")
    @ValueSource(doubles = {3*Math.PI, 5*Math.PI, 4.22 * Math.PI})
    void sec_RandomValuesNotInRange(double dot) {
        assertEquals(1.0 / Math.cos(dot), Sec.sec(dot), DELTA);
    }
}
