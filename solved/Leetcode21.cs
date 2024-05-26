/*
21. Merge Two Sorted Lists
Easy

You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.
*/
#nullable enable

public class ListNode {
    public int val;
    public ListNode? next;
    public ListNode(int val=0, ListNode? next=null) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    private void TakeAllFrom(ref ListNode? curr, ref ListNode? root, ListNode otherlist) {
        while (true) {
            if (curr == null) {
                curr = new ListNode(otherlist.val);
                root = curr;
            } else {
                curr.next = new ListNode(otherlist.val);
                curr = curr.next;
            }
            if (otherlist.next == null) {
                return;
            }
            otherlist = otherlist.next;
        }
    }

    private void TakeValueFromNode(ref ListNode? curr, ref ListNode? root, ListNode otherlist) {
        if (curr == null) {
            curr = new ListNode(otherlist.val);
            root = curr;
            return;
        }

        curr.next = new ListNode(otherlist.val);
        curr = curr.next;
    }

    // overly safe, no garbage solution ( others returning root.next )
    public ListNode? MergeTwoLists(ListNode? list1, ListNode? list2) {
        ListNode? curr = null, root = null;

        while(true) {
            if (list1 == null && list2 != null) {
                TakeAllFrom(ref curr, ref root, list2);
                break;
            }
            else if (list1 != null && list2 == null) {
                TakeAllFrom(ref curr, ref root, list1);
                break;
            }
            else if (list1 == null && list2 == null) {
                break;
            }
            else if (list1 != null && list2 != null && list1.val > list2.val) {
                TakeValueFromNode(ref curr, ref root, list2);
                list2 = list2.next;
            }
            else if (list1 != null && list2 != null) {
                TakeValueFromNode(ref curr, ref root, list1);
                list1 = list1.next;
            }
        }

        return root;
    }

    // unsafe
    public ListNode? MergeTwoLists2(ListNode? list1, ListNode? list2) {
        ListNode root = new(-1);
        ListNode? curr = root;

        while(true) {
            if (list1 == null && list2 != null) {
                while (true) {
                    curr.next = new ListNode(list2.val);
                    if (list2.next == null) {
                        break;
                    }
                    list2 = list2.next;
                    curr = curr.next;
                }
                break;
            }
            else if (list1 != null && list2 == null) {
                while (true) {
                    curr.next = new ListNode(list1.val);
                    if (list1.next == null) {
                        break;
                    }
                    list1 = list1.next;
                    curr = curr.next;
                }
                break;
            }
            else if (list1 == null && list2 == null) {
                break;
            }
            else if (list1!.val > list2!.val) {
                curr.next = new ListNode(list2!.val);
                list2 = list2.next;
                curr = curr.next;
            }
            else  {
                curr.next = new ListNode(list1.val);
                list1 = list1.next;
                curr = curr.next;
            }
        }

        return root.next;
    }
}

Solution sol = new Solution();
ListNode? output;
ListNode? example1 = new(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
ListNode? example2 = new(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))));
output = sol.MergeTwoLists(example1, example2);
while (output != null) {
    Console.Write(output.val);
    output = output.next;
}
Console.Write("\n---\n");
example1 = new(1, new ListNode(2, new ListNode(4)));
example2 = new(1, new ListNode(3, new ListNode(4)));
output = sol.MergeTwoLists(example1, example2);
while (output != null) {
    Console.Write(output.val);
    output = output.next;
}
Console.Write("\n---\n");
example1 = null;
example2 = new(0);
output = sol.MergeTwoLists(example1, example2);
while (output != null) {
    Console.Write(output.val);
    output = output.next;
}
Console.Write("\n---\n");
example1 = null;
example2 = null;
output = sol.MergeTwoLists(example1, example2);
while (output != null) {
    Console.Write(output.val);
    output = output.next;
}
