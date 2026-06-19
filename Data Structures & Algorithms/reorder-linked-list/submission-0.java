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
    public void reorderList(ListNode head) {

        if(head == null || head.next == null) {
            return;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode div = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            div = slow;
            slow = slow.next;
        }

        div.next = null;

        ListNode h = slow;

        ListNode curr= h;
        ListNode nextNode = h;
        ListNode prev = null;

        while(nextNode.next != null) {
            nextNode = nextNode.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        curr.next = prev;
        
        ListNode l1 = head;
        ListNode l2 = curr;

        while(l1 != null && l2 != null) {
            ListNode n1 = l1.next;
            ListNode n2 = l2.next;

            l1.next = l2;

            if(n1 == null) {
                break;
            }

            l2.next = n1;

            l1 = n1;
            l2 = n2;
        }

        return;
    }
}