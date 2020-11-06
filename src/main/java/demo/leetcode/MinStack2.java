package demo.leetcode;

import java.util.Arrays;

class MinStack2 {

    private final int INIT_SIZE = 100;

    private int[] elements;
    private int size;
    private int min;    /* 维护一个最小值 */
    private int minCount;


    /** initialize your data structure here. */
    public MinStack2() {
        elements = new int[INIT_SIZE];
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        ensureCapacity();       /* 扩容检测 */
        elements[size++] = x;
        /* 维护最小值 */
        if(x < min) {
            min = x;
            minCount = 1;
        } else if(x == min) {
            minCount++;
        }
    }

    public void pop() {
        int popNum = elements[--size]; /* 被删除的数 */
        /* 维护最小值 */
        if(popNum == min && --minCount == 0) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                min = Math.min(min, elements[i]);
            }
            minCount = 1;
        }
    }

    public int top() {
        return elements[size - 1];
    }

    public int getMin() {
        return min;  /* 直接返回最小值 */
    }

    /**
     * 是否需要扩容
     */
    private void ensureCapacity() {
        if(size >= elements.length - 1) {
            elements = Arrays.copyOf(elements, elements.length + (elements.length >> 1));
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
