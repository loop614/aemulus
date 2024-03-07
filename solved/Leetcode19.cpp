/*
19. Remove Nth Node From End of List
Medium
Given the head of a linked list, remove the nth node from the end of the list and return its head
*/

// (!) must remove all free cals for leetcode

#include <iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* root = head;
        ListNode* headCopy = head;
        int count = 0;
        while (head) {
            count++;
            head = head->next;
        }
        count -= n;

        if (count < 1) {
            if (headCopy && headCopy->next) {
                ListNode *temp = headCopy->next;
                free(headCopy);
                return temp;
            }

            headCopy = nullptr;
            return headCopy;
        }

        while (headCopy) {
            count--;
            if (count == 0)
            {
                ListNode* temp = headCopy->next;
                headCopy->next = headCopy->next->next;
                free(temp);
                break;
            }
            headCopy = headCopy->next;
        }

        return root;
    }
};

int main() {
    Solution *sol = new Solution();
    ListNode* output;
    ListNode *example;

    example = new ListNode(1);
    example->next = new ListNode(2);
    output = sol->removeNthFromEnd(example, 2);
    cout << "[2] ";
    while (output) {
        cout << output->val << " ";
        output= output->next;
    }
    cout << endl;

    example = new ListNode(1);
    example->next = new ListNode(2);
    example->next->next = new ListNode(3);
    example->next->next->next = new ListNode(4);
    example->next->next->next->next = new ListNode(5);

    output = sol->removeNthFromEnd(example, 2);
    cout << "[1,2,3,5] ";
    while (output) {
        cout << output->val << " ";
        output= output->next;
    }
    cout << endl;

    output = sol->removeNthFromEnd(new ListNode(1), 1);
    cout << "[] ";
    while (output) {
        cout << output->val << " ";
        output= output->next;
    }
    cout << endl;

    example = new ListNode(1);
    example->next = new ListNode(2);
    output = sol->removeNthFromEnd(example, 1);
    cout << "[1] ";
    while (output) {
        cout << output->val << " ";
        output= output->next;
    }
    cout << endl;


    return 0;
}
