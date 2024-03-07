/*
876. Middle of the Linked List
Easy
Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.
*/
public class ListNode {
    public int val;
    public ListNode? next;
    public ListNode(int val=0, ListNode? next=null) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode MiddleNode(ListNode head) {
        ListNode headC = head;
        while (headC.next != null && headC.next.next != null) {
            head = head.next;
            headC = headC.next.next;
        }
        if (headC.next != null) {
            head = head.next;
        }

        return head;
    }
}

Solution sol = new Solution();
ListNode root = new ListNode(1);
root.next = new ListNode(2);
root.next.next = new ListNode(3);
root.next.next.next = new ListNode(4);
root.next.next.next.next = new ListNode(5);
ListNode middle = sol.MiddleNode(root);
while (middle != null) {
    Console.Write(middle.val);
    middle = middle.next;
}
Console.Write("\n");

root = new ListNode(1);
root.next = new ListNode(2);
root.next.next = new ListNode(3);
root.next.next.next = new ListNode(4);
root.next.next.next.next = new ListNode(5);
root.next.next.next.next.next = new ListNode(6);
middle = sol.MiddleNode(root);
while (middle != null) {
    Console.Write(middle.val);
    middle = middle.next;
}
Console.Write("\n");
