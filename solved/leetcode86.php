<?php
/*
86. Partition List
Medium
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.
*/

class ListNode
{
    public $val = 0;
    public $next = null;
    function __construct($val = 0, $next = null)
    {
        $this->val = $val;
        $this->next = $next;
    }
}

class Solution
{
    /**
     * @param ListNode $head
     * @param Integer $x
     * @return ListNode
     */
    function partition($head, $x)
    {
        $smaller = null;
        $bigger = null;
        $biggerHead = null;
        $smallerHead = null;
        while ($head !== null) {
            $new = new ListNode($head->val);
            if ($head->val < $x) {
                if ($smaller === null) {
                    $smaller = $new;
                    $smallerHead = $smaller;
                } else {
                    $smaller->next = $new;
                    $smaller = $new;
                }
            } else {
                if ($bigger === null) {
                    $bigger = $new;
                    $biggerHead = $bigger;
                } else {
                    $bigger->next = $new;
                    $bigger = $new;
                }
            }
            $head = $head->next;
        }

        if ($smaller === null) {
            return $biggerHead;
        }

        $smaller->next = $biggerHead;

        return $smallerHead;
    }

    function print($head)
    {
        while ($head !== null) {
            echo $head->val . " ";
            $head = $head->next;
        }
        echo PHP_EOL;
    }
}

$sol = new Solution();

$example = new ListNode(
    25,
    new ListNode(
        1,
        new ListNode(
            10,
            new ListNode(4)
        )
    )
);

$example = $sol->partition($example, 5);
$sol->print($example);
