package ru.itmo.tpo1.task2;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BinomialHeap {
    private BinomialHeapNode nodes;
    private int size;

    public BinomialHeap() {
        nodes = null;
        size = 0;
    }

    /**
     * Получить размер кучи
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Очистка
     */
    public void clear() {
        nodes = null;
        size = 0;
    }

    /**
     * Вставка нового элемента
     *
     * @param value
     */
    public void insert(int value) {
        BinomialHeapNode temp = new BinomialHeapNode(value);
        if (nodes == null) {
            nodes = temp;
            size = 1;
        } else {
            unionNodes(temp);
            size++;
        }
    }

    /**
     * Объединение двух бин куч
     *
     * @param binHeap
     */
    private void merge(BinomialHeapNode binHeap) {
        BinomialHeapNode temp1 = nodes, temp2 = binHeap;

        while ((temp1 != null) && (temp2 != null)) {

            if (temp1.degree == temp2.degree) {

                BinomialHeapNode tmp = temp2;
                temp2 = temp2.sibling;
                tmp.sibling = temp1.sibling;
                temp1.sibling = tmp;
                temp1 = tmp.sibling;
            } else {

                if (temp1.degree < temp2.degree) {

                    if ((temp1.sibling == null)
                            || (temp1.sibling.degree
                            > temp2.degree)) {
                        BinomialHeapNode tmp = temp2;
                        temp2 = temp2.sibling;
                        tmp.sibling = temp1.sibling;
                        temp1.sibling = tmp;
                        temp1 = tmp.sibling;
                    } else {
                        temp1 = temp1.sibling;
                    }
                } else {
                    BinomialHeapNode tmp = temp1;
                    temp1 = temp2;
                    temp2 = temp2.sibling;
                    temp1.sibling = tmp;

                    if (tmp == nodes) {
                        nodes = temp1;
                    }
                }
            }
        }

        if (temp1 == null) {
            temp1 = nodes;

            while (temp1.sibling != null) {
                temp1 = temp1.sibling;
            }
            temp1.sibling = temp2;
        }
    }

    /**
     * Объединение двух бин деревьев
     *
     * @param binHeap
     */
    private void unionNodes(BinomialHeapNode binHeap) {
        merge(binHeap);

        BinomialHeapNode prevTemp = null, temp = nodes,
                nextTemp = nodes.sibling;

        while (nextTemp != null) {

            if ((temp.degree != nextTemp.degree)
                    || ((nextTemp.sibling != null)
                    && (nextTemp.sibling.degree
                    == temp.degree))) {
                prevTemp = temp;
                temp = nextTemp;
            } else {

                if (temp.key <= nextTemp.key) {
                    temp.sibling = nextTemp.sibling;
                    nextTemp.parent = temp;
                    nextTemp.sibling = temp.child;
                    temp.child = nextTemp;
                    temp.degree++;
                } else {

                    if (prevTemp == null) {
                        nodes = nextTemp;
                    } else {
                        prevTemp.sibling = nextTemp;
                    }

                    temp.parent = nextTemp;
                    temp.sibling = nextTemp.child;
                    nextTemp.child = temp;
                    nextTemp.degree++;
                    temp = nextTemp;
                }
            }
            nextTemp = temp.sibling;
        }
    }

    /**
     * Удаление наименьшего элемента
     *
     * @return
     */
    public int deleteMin() {
        if (nodes == null)
            return -1;

        BinomialHeapNode temp = nodes;
        BinomialHeapNode prevTemp = null;
        BinomialHeapNode minNode = nodes.findMinNode();

        while (temp.key != minNode.key) {
            prevTemp = temp;
            temp = temp.sibling;
        }

        if (prevTemp == null) {
            nodes = temp.sibling;
        } else {
            prevTemp.sibling = temp.sibling;
        }

        temp = temp.child;
        BinomialHeapNode fakeNode = temp;

        while (temp != null) {
            temp.parent = null;
            temp = temp.sibling;
        }

        if ((nodes == null) && (fakeNode == null)) {
            size = 0;
        } else {
            if (nodes == null) {
                nodes = fakeNode.reverse(null);
                size = nodes.getSize();
            } else {
                if (fakeNode == null) {
                    size = nodes.getSize();
                } else {
                    unionNodes(fakeNode.reverse(null));
                    size = nodes.getSize();
                }
            }
        }

        return minNode.key;
    }

    /**
     * Найти наименьшее значение
     *
     * @return
     */
    public int findMinimum() {
        if (nodes == null || nodes.getSize() == 0)
            throw new IllegalArgumentException();
        return nodes.findMinNode().key;
    }
}
