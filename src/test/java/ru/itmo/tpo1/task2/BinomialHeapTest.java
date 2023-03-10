package ru.itmo.tpo1.task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BinomialHeapTest {
    private BinomialHeap heap;

    @BeforeEach
    void initHeap() {
        heap = new BinomialHeap();
        heap.insert(0);
        heap.insert(1);
        heap.insert(2);
    }

    @Test
    @DisplayName("вставка трёх элементов и проверка размера")
    void insert_shouldReturnRightSizeAndMin() {
        assertEquals(heap.getSize(), 3);
        assertEquals(heap.findMinimum(), 0);
    }

    @Test
    @DisplayName("Проверка на мин число после удаления")
    void findMinAfterDeleting_shouldReturnMin() {
        assertEquals(heap.findMinimum(), 0);
        heap.deleteMin();
        assertEquals(heap.findMinimum(), 1);
    }

    @Test
    @DisplayName("Проверка очистки кучи")
    void clear_shouldReturnSizeZero() {
        heap.clear();
        assertEquals(heap.getSize(), 0);
    }

    @Test
    @DisplayName("Получение мин значение с пустой кучей")
    void findMin_whenEmptyHeap_shouldThrowException() {
        heap = new BinomialHeap();
        assertThrows(IllegalArgumentException.class, heap::findMinimum);
    }

    @Test
    @DisplayName("Вставка, очистка, проверка")
    void insertAfterClear_shouldReturnSizeAndMin() {
        heap.clear();

        heap.insert(100);
        heap.insert(120);
        heap.insert(1000);

        assertEquals(heap.getSize(), 3);
        assertEquals(heap.findMinimum(), 100);
    }

    @Test
    @DisplayName("Вставляем элемент меньше минимального")
    void insertMin_shouldReturnMin() {
        assertEquals(heap.findMinimum(), 0);
        heap.insert(-1);
        assertEquals(heap.findMinimum(), -1);
    }
}
