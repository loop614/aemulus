/*
25. Reverse Nodes in k-Group
Hard
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
You may not alter the values in the list's nodes, only nodes themselves may be changed.
TODO: time improvments, remove printlns
*/
import java.util.List;
import java.util.ArrayList;

public class Leetcode25 {
    public static void main(String... args) {
        Solution25 sol = new Solution25();
        ListNode res;
        ListNode example;

        example = new ListNode(1);
        example.next = new ListNode(2);
        example.next.next = new ListNode(3);
        example.next.next.next = new ListNode(4);
        example.next.next.next.next = new ListNode(5);
        res = sol.reverseKGroup(example, 2);
        while (res != null) {
            System.out.print(res.val);
            System.out.print(" ");
            res = res.next;
        }
        System.out.print("\n");
        System.out.println("2 1 4 3 5");

        example = new ListNode(1);
        example.next = new ListNode(7);
        example.next.next = new ListNode(3);
        example.next.next.next = new ListNode(2);
        example.next.next.next.next = new ListNode(7);
        example.next.next.next.next.next = new ListNode(0);
        example.next.next.next.next.next.next = new ListNode(1);
        example.next.next.next.next.next.next.next = new ListNode(0);
        example.next.next.next.next.next.next.next.next = new ListNode(0);
        res = sol.reverseKGroup(example, 4);
        while (res != null) {
            System.out.print(res.val);
            System.out.print(" ");
            res = res.next;
        }
        System.out.print("\n");
        System.out.println("2,3,7,1,0,1,0,7,0");

        example = new ListNode(1);
        example.next = new ListNode(2);
        example.next.next = new ListNode(3);
        example.next.next.next = new ListNode(4);
        res = sol.reverseKGroup(example, 4);
        while (res != null) {
            System.out.print(res.val);
            System.out.print(" ");
            res = res.next;
        }
        System.out.print("\n");
        System.out.println("4 3 2 1");

        example = new ListNode(1);
        example.next = new ListNode(2);
        example.next.next = new ListNode(3);
        example.next.next.next = new ListNode(4);
        example.next.next.next.next = new ListNode(5);
        example.next.next.next.next.next = new ListNode(6);
        example.next.next.next.next.next.next = new ListNode(7);
        example.next.next.next.next.next.next.next = new ListNode(8);
        res = sol.reverseKGroup(example, 7);
        while (res != null) {
            System.out.print(res.val);
            System.out.print(" ");
            res = res.next;
        }
        System.out.print("\n");
        System.out.println("7 6 5 4 3 2 1 8");

        example = new ListNode(1);
        example.next = new ListNode(2);
        example.next.next = new ListNode(3);
        example.next.next.next = new ListNode(4);
        example.next.next.next.next = new ListNode(5);
        res = sol.reverseKGroup(example, 3);
        while (res != null) {
            System.out.print(res.val);
            System.out.print(" ");
            res = res.next;
        }
        System.out.print("\n");
        System.out.println("3 2 1 4 5");
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int ktemp = k - 1;
        int listLen = 0;
        List<ListNode> lefts = new ArrayList<ListNode>();
        List<ListNode> rights = new ArrayList<ListNode>();

        ListNode headCopy = head;
        boolean isOdd = k % 2 == 1;
        int countInGroup = 0;
        boolean doCount = true;

        while (head != null) {
            if (ktemp > k / 2 || (!isOdd && ktemp == k / 2)) {
                lefts.add(head);
                if ( doCount ) countInGroup++;
            } else if (ktemp < k / 2) {
                if (countInGroup > 0 && doCount) {
                    doCount = false;
                }
                rights.add(head);
            }
            head = head.next;

            if (ktemp == 0) {
                ktemp = k - 1;
            } else {
                ktemp--;
            }
            listLen++;
        }
        if (k > listLen || rights.isEmpty() || lefts.isEmpty()) {
            return headCopy;
        }

        head = headCopy;
        int leftPivot = 0;
        int rightPivot = countInGroup - 1;
        ktemp = countInGroup - 1;
        boolean groupStart = true;
        int groupCount = 1;
        ListNode left = null;
        ListNode right = null;
        ListNode temp = null;
        ListNode temp2 = null;
        ListNode prevRight = null;
        ListNode prevLeft = null;
        ListNode futureHead = headCopy;
        ListNode prevHead = headCopy;
        int stopCount = Math.min(rights.size(), lefts.size());

        while (leftPivot < lefts.size() && rightPivot < rights.size() && rightPivot >= 0 && stopCount-- > 0)  {
            left = lefts.get(leftPivot);
            right = rights.get(rightPivot);
            prevRight = getPrevInList(prevHead, right);
            prevLeft = getPrevInList(prevHead, left);

            if (groupStart) {
                groupStart = false;
                if (futureHead == headCopy) {
                    futureHead = rights.get(rightPivot);
                }
                prevHead = rights.get(rightPivot);
            }

            System.out.println("swap " + left.val + "-" + right.val);

            temp = left.next;
            temp2 = right.next;
            left.next = temp2;
            System.out.println("left " + left.val + " next " + (temp2 != null ? temp2.val : "null" ));
            if (temp != right) {
                System.out.println("right " + right.val + " next " + (temp != null ? temp.val : "null" ));
                right.next = temp;
            } else {
                right.next = left;
            }
            if (prevRight != null && prevRight != left) {
                System.out.println("prevRight " + prevRight.val + " next " + (left != null ? left.val : "null" ));
                prevRight.next = left;
            }
            if (prevLeft != null && prevLeft != right) {
                System.out.println("prevLeft " + prevLeft.val + " next " + (right != null ? right.val : "null" ));
                prevLeft.next = right;
            }

            ListNode res = futureHead;
            while (res != null) {
                System.out.print(res.val);
                System.out.print(" ");
                res = res.next;
            }
            System.out.print("\n---------\n");

            if (ktemp <= 0) {
                ktemp = countInGroup - 1;
                groupCount++;
                rightPivot = (countInGroup * groupCount ) - 1;
                groupStart = true;
            } else {
                rightPivot--;
                ktemp--;
            }
            leftPivot++;
            listLen--;
        }

        System.out.println("returning" + futureHead.val);

        return futureHead;
    }

    private ListNode getPrevInList(ListNode head, ListNode curr)
    {
        while (head != null)
        {
            if (head.next == curr) {
                return head;
            }
            head = head.next;
        }

        return null;
    }
}
