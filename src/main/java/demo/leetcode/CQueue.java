package demo.leetcode;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 */
class CQueue {

    Stack<Integer> head, tail;

    public CQueue() {
        head = new Stack<>();
        tail = new Stack<>();

    }

    public void appendTail(int value) {
        tail.push(value);
    }

    public int deleteHead() {
        if (head.isEmpty()) {
            if (tail.isEmpty()) {
                return -1;
            } else {
                // 要将tail中的元素全部入栈head中，否则将乱序
                int size = tail.size();
                for (int i = 0; i < size - 1; i++) {
                    head.push(tail.pop());
                }
                return tail.pop();
            }
        } else {
            return head.pop();
        }
    }


    public static void main(String[] args) {

        CQueue cQueue = new CQueue();
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
