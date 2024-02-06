/*
23. Merge k Sorted Lists
Hard
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.
*/
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val=0, ListNode next=null) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    /*
     * beats 30% by execution time
     * beats 38% by memory usage
     */
    public ListNode MergeKLists(ListNode[] lists) {
        bool sbreak = true;
        for (int i = 0; i < lists.Length; i++) {
            if (lists[i] != null) {
                sbreak = false;
                break;
            }
        }
        if (sbreak) {return null;}

        ListNode combine = new ListNode();
        ListNode root = combine;
        int currMin, currIndex, noNullCount;

        while (true) {
            currIndex = lists.Length - 1;
            currMin = int.MaxValue;
            noNullCount = 0;
            for (int i = 0; i < lists.Length; i++) {
                if (lists[i] != null) {
                    noNullCount++;
                    if (currMin > lists[i].val) {
                        currMin = lists[i].val;
                        currIndex = i;
                    }
                }
            }
            combine.val = lists[currIndex].val;
            lists[currIndex] = lists[currIndex].next;
            if (noNullCount == 1 && lists[currIndex] == null) {
                break;
            }
            combine.next = new ListNode();
            combine = combine.next;
        }

        return root;
    }
}

Solution sol = new Solution();
ListNode output;

ListNode example = new ListNode(1);
example.next = new ListNode(4);
example.next.next = new ListNode(5);

ListNode example2 = new ListNode(1);
example2.next = new ListNode(3);
example2.next.next = new ListNode(4);

ListNode example3 = new ListNode(2);
example3.next = new ListNode(6);

ListNode[] exampleAr = new ListNode[] {example, example2, example3};
output = sol.MergeKLists(exampleAr);

while (output != null) {
    Console.Write(output.val);
    output = output.next;
    Console.Write("\n");
}
Console.WriteLine("-------------");
ListNode[] exampleAr2 = new ListNode[] {};
output = sol.MergeKLists(exampleAr2);

while (output != null) {
    Console.Write(output.val);
    output = output.next;
    Console.Write("\n");
}
Console.WriteLine("-------------");
ListNode[] exampleAr3 = new ListNode[] {null};
output = sol.MergeKLists(exampleAr3);

while (output != null) {
    Console.Write(output.val);
    output = output.next;
    Console.Write("\n");
}
Console.WriteLine("-------------");
ListNode[] exampleAr4 = new ListNode[] {null, null};
output = sol.MergeKLists(exampleAr4);

while (output != null) {
    Console.Write(output.val);
    output = output.next;
    Console.Write("\n");
}
Console.WriteLine("-------------");
ListNode[] exampleAr5 = new ListNode[] {new ListNode(1)};
output = sol.MergeKLists(exampleAr5);

while (output != null) {
    Console.Write(output.val);
    output = output.next;
    Console.Write("\n");
}
