package ru.itmo.tpo1.task2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * Узел бин дерева
 */
@AllArgsConstructor
@Data
public class BinomialHeapNode {
    int key, degree;
    BinomialHeapNode parent;
    BinomialHeapNode sibling;
    BinomialHeapNode child;


    public BinomialHeapNode(int k) {
        key = k;
        degree = 0;
        parent = null;
        sibling = null;
        child = null;
    }

    /**
     * Развернуть дерево
     * @param sibl
     * @return
     */
    public BinomialHeapNode reverse(BinomialHeapNode sibl) {
        BinomialHeapNode ret;
        if (sibling != null)
            ret = sibling.reverse(this);
        else
            ret = this;
        sibling = sibl;
        return ret;
    }

    /**
     * Получить минимальный узел
     * @return
     */
    public BinomialHeapNode findMinNode() {
        BinomialHeapNode x = this;
        BinomialHeapNode y = this;
        int min = x.key;

        while (x != null) {
            if (x.key < min) {
                y = x;
                min = x.key;
            }

            x = x.sibling;
        }

        return y;
    }

    /**
     * Получить размер дерева
     * @return
     */
    public int getSize() {
        return (1 + ((child == null) ? 0 : child.getSize())
                        + ((sibling == null) ? 0 : sibling.getSize()));
    }
}
