public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val=0, ListNode next=null) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2) {
        ListNode solutionRoot = null;
        ListNode previous = null;
        int carryVal = 0;
        while (l1 != null || l2 != null) {
            ListNode current = new ListNode();
            int value1 = l1 != null ? l1.val : 0;
            int value2 = l2 != null ? l2.val : 0;
            if (solutionRoot == null) {
                solutionRoot = current;
            }
            if (previous != null) {
                previous.next = current;
            }
            current.val = 0;
            int sum = value1 + value2 + carryVal;
            if (sum > 0 && sum < 10) {
                current.val = sum;
                carryVal = 0;
            }
            else if (sum > 0 && sum >= 10) {
                current.val = sum - 10;
                carryVal = 1;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            previous = current;
        }
        if(carryVal == 1) {
            ListNode current = new ListNode();
            current.val = carryVal;
            previous.next = current;
        }

        return solutionRoot;
    }

    public void PrintList(ListNode root) {
        while (root != null) {
            Console.Write(root.val);
            Console.Write(" ");
            root = root.next;
        }
    }
}

Solution sol = new Solution();
ListNode res = new ListNode();

ListNode three = new ListNode(3);
ListNode four = new ListNode(4, three);
ListNode two = new ListNode(2, four);

ListNode four2 = new ListNode(4);
ListNode six = new ListNode(6, four2);
ListNode five = new ListNode(5, six);

res = sol.AddTwoNumbers(two, five);
sol.PrintList(res);
Console.Write("\n");
Console.WriteLine("7 0 8");
