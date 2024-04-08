/*
24. Swap Nodes in Pairs
Medium
Given a linked list, swap every two adjacent nodes and return its head.
You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
*/
public class Leetcode14 {
    public static void main(String... args) {
        Solution24 sol = new Solution24();
        ListNode res;
        ListNode example = new ListNode(1);
        example.next = new ListNode(2);
        example.next.next = new ListNode(3);
        example.next.next.next = new ListNode(4);
        example.next.next.next.next = new ListNode(5);
        res = sol.swapPairs(example);
        while (res != null) {
            System.out.print(res.val);
            System.out.print(" ");
            res = res.next;
        }
        System.out.print("\n");

        example = new ListNode(1);
        example.next = new ListNode(2);
        res = sol.swapPairs(example);
        while (res != null) {
            System.out.print(res.val);
            System.out.print(" ");
            res = res.next;
        }
        System.out.print("\n");
    }
}

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode headNextCopy = head.next;
        ListNode temp;
        ListNode headPrev = null;

        while ( head != null && head.next != null ) {
            temp = head.next;
            head.next = head.next.next;
            temp.next = head;
            if (headPrev != null) {
                headPrev.next = temp;
            }

            headPrev = head;
            head = head.next;
        }

        return headNextCopy;
    }
}
