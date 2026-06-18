/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {



        if(list1 == null && list2 != null) {
            return list2;
        }

        if(list1 != null && list2 == null) {
            return list1;
        }

        if(list1 == null && list2 == null) {
            return list1;
        }

        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode newNode;
        ListNode head3;

        if(head1.val  <= head2.val) {
            newNode = new ListNode(head1.val);
            head3 = newNode;
            head1 = head1.next;
        } else {
            newNode = new ListNode(head2.val);
            head3 = newNode;
            head2 = head2.next;
        }
         
        while(head1 != null && head2 != null) {
            if(head1.val  <= head2.val) {
                head3.next = new ListNode(head1.val);
                head1 = head1.next;
            } else {
                head3.next = new ListNode(head2.val);
                head2 = head2.next;
            }
            head3 = head3.next;
        }

        while(head1 != null) {
            head3.next = new ListNode(head1.val);
            head1 = head1.next;
            head3 = head3.next;
        }

        while(head2 != null) {
            head3.next = new ListNode(head2.val);
            head2 = head2.next;
            head3 = head3.next;
        }

        return newNode;
    }
}