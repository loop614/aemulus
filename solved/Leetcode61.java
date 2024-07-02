/*
61. Rotate List
Medium
Given the head of a linked list, rotate the list to the right by k places.
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Leetcode61 {

    public static void main(String[] args) {
        Solution61 sol = new Solution61();
        ListNode example, res;

        example = new ListNode(1);
        example.next = new ListNode(2);
        example.next.next = new ListNode(3);
        res = sol.rotateRight(example, 2000000000);
        while (res != null) {
            System.out.print(res.val);
            System.out.print(" ");
            res = res.next;
        }
        System.out.println(" [2,3,1]");

        example = new ListNode(0);
        example.next = new ListNode(1);
        example.next.next = new ListNode(2);
        res = sol.rotateRight(example, 4);
        while (res != null) {
            System.out.print(res.val);
            System.out.print(" ");
            res = res.next;
        }
        System.out.println(" [2,0,1]");

        example = new ListNode(1);
        example.next = new ListNode(2);
        example.next.next = new ListNode(3);
        example.next.next.next = new ListNode(4);
        example.next.next.next.next = new ListNode(5);
        example.next.next.next.next.next = new ListNode(6);
        example.next.next.next.next.next.next = new ListNode(7);
        example.next.next.next.next.next.next.next = new ListNode(8);
        example.next.next.next.next.next.next.next.next = new ListNode(9);
        res = sol.rotateRight(example, 1);
        while (res != null) {
            System.out.print(res.val);
            System.out.print(" ");
            res = res.next;
        }
        System.out.println(" [9,1,2,3,4,5,6,7,8]");

        example = new ListNode(1);
        example.next = new ListNode(2);
        example.next.next = new ListNode(3);
        example.next.next.next = new ListNode(4);
        example.next.next.next.next = new ListNode(5);
        example.next.next.next.next.next = new ListNode(6);
        example.next.next.next.next.next.next = new ListNode(7);
        example.next.next.next.next.next.next.next = new ListNode(8);
        res = sol.rotateRight(example, 1);
        while (res != null) {
            System.out.print(res.val);
            System.out.print(" ");
            res = res.next;
        }
        System.out.println(" [8,1,2,3,4,5,6,7]");

        example = new ListNode(1);
        example.next = new ListNode(2);
        example.next.next = new ListNode(3);
        example.next.next.next = new ListNode(4);
        example.next.next.next.next = new ListNode(5);
        res = sol.rotateRight(example, 2);
        while (res != null) {
            System.out.print(res.val);
            System.out.print(" ");
            res = res.next;
        }
        System.out.println(" [4,5,1,2,3]");
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0) {
            return head;
        }
        if (head == null || head.next == null) {
            return head;
        }
        Deque<ListNode> deque = new ArrayDeque<>();
        while (head != null) {
            deque.add(head);
            head = head.next;
        }

        k = k % deque.size();
        while (k-- > 0) {
            deque.addFirst(deque.removeLast());
        }
        Iterator<ListNode> itr = deque.iterator();
        ListNode newHead = new ListNode();
        ListNode newHeadCopy = newHead;

        while (true) {
            ListNode thisone = itr.next();
            newHead.val = thisone.val;
            if (itr.hasNext()) {
                newHead.next = new ListNode();
                newHead = newHead.next;
            } else {
                break;
            }
        }

        return newHeadCopy;
    }
}
