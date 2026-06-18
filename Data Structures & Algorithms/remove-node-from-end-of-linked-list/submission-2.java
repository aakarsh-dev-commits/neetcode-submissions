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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int size = 0;
        ListNode h = head;
        while(h.next != null) {
            h = h.next;
            size++;
        }
        size++;

        if(size == 1) {
            head = null;
            return head;
        }   

        int start = size - n;

        ListNode prev = head;
        ListNode curr = head;

        for(int i = 0 ; i < start; i++) {
            prev = curr;
            curr = curr.next;
        }

        if( prev == curr) {
            head = head.next;
            return head;
        }

        prev.next = curr.next;
        curr = null;

        return head;

    }
}
