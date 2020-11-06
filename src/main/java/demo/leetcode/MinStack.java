package demo.leetcode;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 * 三种方法：
 * 1. 辅助栈
 * 2. 栈节点时刻保留一对，其中包括每一步的最小值
 * 3. 自定应链表模拟栈操作，用头插法
 */
class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

        // 先往辅助栈中压入一个最大值,就不用判空了
        // stack2.push(Integer.MAX_VALUE);

    }

    public void push(int x) {
        stack.push(x);
        // 初次对比时，辅助栈可能为空
        stack2.push(Math.min(x, stack2.isEmpty() ? x : stack2.peek()));
    }


    public void pop() {
        stack.pop();
        stack2.pop();


    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return stack2.peek();
    }

    public void print() {
        System.out.println(stack.toString());
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.print();
        minStack.push(-2);
        minStack.print();
        minStack.push(0);
        minStack.print();
        minStack.push(-3);
        minStack.print();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.print();
        System.out.println(minStack.top());
        minStack.print();
        System.out.println(minStack.getMin());
        minStack.print();
        minStack.pop();
        minStack.pop();
        minStack.print();
        minStack.pop();


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