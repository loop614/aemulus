/*
24. Swap Nodes in Pairs
Medium
Given a linked list, swap every two adjacent nodes and return its head.
You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
*/
public class Leetcode24 {
    public static void main(String... args) {
        Solution24 sol = new Solution24();
        ListNode24 res;
        ListNode24 example = new ListNode24(1);
        example.next = new ListNode24(2);
        example.next.next = new ListNode24(3);
        example.next.next.next = new ListNode24(4);
        example.next.next.next.next = new ListNode24(5);
        res = sol.swapPairs(example);
        while (res != null) {
            System.out.print(res.val);
            System.out.print(" ");
            res = res.next;
        }
        System.out.print("\n");

        example = new ListNode24(1);
        example.next = new ListNode24(2);
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
class ListNode24 {
    int val;
    ListNode24 next;
    ListNode24() {}
    ListNode24(int val) { this.val = val; }
    ListNode24(int val, ListNode24 next) { this.val = val; this.next = next; }
}

class Solution24 {
    public ListNode24 swapPairs(ListNode24 head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode24 headNextCopy = head.next;
        ListNode24 temp;
        ListNode24 headPrev = null;

        temp = head.next;
        head.next = head.next.next;
        temp.next = head;
        headPrev = head;
        head = head.next;

        while ( head != null && head.next != null ) {
            temp = head.next;
            head.next = head.next.next;
            temp.next = head;
            headPrev.next = temp;
            headPrev = head;
            head = head.next;
        }

        return headNextCopy;
    }
}
