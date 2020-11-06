package demo.leetcode;

import java.util.*;

/**
 * 倒序打印链表
 *
 * @author RDJ-YUZHENQUAN
 */
public class ReversePrint {


    public static void main(String[] args) {
        ReversePrint print = new ReversePrint();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        System.out.println("-------begin-----------");
        System.out.println(Arrays.toString(print.reversePrint(node1)));
        System.out.println("-------end-----------");
    }

    /**
     * 逆序遍历的另一种写法 size -i - 1
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {


        if (head == null) {
            return new int[1];
        }
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int size = list.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = list.get(size - i - 1).intValue();
        }
        return arr;
    }

    /**
     * 利用栈，后进先出 的特性，逆序
     *
     * @param head
     * @return
     */
    public int[] reversePrint2(ListNode head) {

        if (head == null) {
            return new int[1];
        }

        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = stack.pop().val;
        }
        return arr;
    }

    public int[] reversePrint3(ListNode head) {

        if (head == null) {
            return new int[1];
        }

        List<ListNode> temp = new ArrayList<>();
        temp = reverse(head, temp);

        int size = temp.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = temp.get(size - i - 1).val;
        }
        return arr;
    }


    public List<ListNode> reverse(ListNode head, List<ListNode> res) {
        if (head != null) {
            res.addAll(reverse(head.next, res));
        }
        return Collections.emptyList();
    }

}


