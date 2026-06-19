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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = l1;
        ListNode h2 = l2;

        int sum = 0;
        int digit = 0;
        int carry = 0;

        ListNode newNode = new ListNode(-1);
        ListNode temp = newNode;

        while(h1 != null && h2 != null) {
            sum = h1.val  + h2.val + carry;
            digit = sum % 10;
            carry = sum / 10;

            if(temp.val == -1) {
                temp.val = digit;
            } else {
                temp.next = new ListNode(digit);
                temp = temp.next;
            }

            h1 = h1.next;
            h2 = h2.next;
        }

        while(h1!= null) {
            sum = h1.val + carry;
            digit = sum % 10;
            carry = sum / 10;

            temp.next = new ListNode(digit);
            temp = temp.next;
            
            h1 = h1.next;
        }

        while(h2!= null) {
            sum = h2.val + carry;
            digit = sum % 10;
            carry = sum / 10;

            temp.next = new ListNode(digit);
            temp = temp.next;
            
            h2 = h2.next;
        }

        while(carry != 0) {
            sum = carry;
            digit = sum % 10;
            carry = sum / 10;

            temp.next = new ListNode(digit);
            temp = temp.next;
        }

        return newNode;

    }
}
