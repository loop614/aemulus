/*
83. Remove Duplicates from Sorted List
Easy
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
*/
public class Leetcode83 {
    public static void main(String[] args) {
        Solution83 sol = new Solution83();
        ListNode example;
        ListNode res;

        example = new ListNode(1);
        example.next = new ListNode(1);
        example.next.next = new ListNode(2);
        example.next.next.next = new ListNode(2);
        example.next.next.next.next = new ListNode(3);
        res = sol.deleteDuplicates(example);
        while (res != null) {
            System.out.print(res.val);
            System.out.print(" ");
            res = res.next;
        }
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

class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) { return null; }
        ListNode res = new ListNode(head.val);
        ListNode resCopy = res;
        int prev = head.val;
        head = head.next;
        while (head != null) {
            if (head.val == prev) {
                head = head.next;
                continue;
            }
            res.next = new ListNode(head.val);
            prev = head.val;
            res = res.next;
            head = head.next;
        }

        return resCopy;
    }
}
