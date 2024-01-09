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
        ListNode current = new ListNode();
        ListNode solutionRoot = current;
        int value1, value2, sum;
        bool carryVal = false;

        while (true) {
            value1 = l1 != null ? l1.val : 0;
            value2 = l2 != null ? l2.val : 0;
            sum = value1 + value2;
            if (carryVal) {sum++;}
            if (sum > 0) {
                if (sum < 10) {
                    current.val = sum;
                    carryVal = false;
                } else {
                    current.val = sum - 10;
                    carryVal = true;
                }
            }

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            if (l1 == null && l2 == null) {
                break;
            }
            current.next = new ListNode();
            current = current.next;
        }

        if(carryVal) {
            current.next = new ListNode(1);
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
