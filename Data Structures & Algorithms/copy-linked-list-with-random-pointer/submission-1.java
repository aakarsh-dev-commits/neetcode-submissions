/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {


        if(head == null) {
            return null;
        }

        if(head.next == null) {
            Node newNode = new Node(head.val);
            newNode.next = null;

            if(head.random == null) {
                newNode.random = null;
                return newNode;
            }

            newNode.random = newNode;
            return newNode;
        }

        HashMap<Integer , Integer> map = new HashMap<>(); 
        Node l1 = head;
        Node mov = head;
        int pos1 = 0;

        while(l1!= null) {

            Node trav = l1.random;
            mov = head;
            int pos2 = 0;

            if(trav == null) {
                map.put(pos1 , -1);
                pos1++;
                l1 = l1.next;
                continue;
            }

            while(mov != trav) {
                pos2++;
                mov = mov.next;
            }

            map.put(pos1, pos2);
            pos1++;
            l1 = l1.next; 
        }

        Node newNode = new Node(head.val);
        Node curr = newNode;
        Node temp = head.next;

        while(temp != null) {
            curr.next = new Node(temp.val);
            curr = curr.next;
            temp = temp.next;
        }
        curr.next = null;

        int pos = 0;
        Node temp1 = newNode;

        while(temp1 != null) {
            int rpos = map.get(pos);
            if(rpos == -1 ) {
                temp1.random = null;
            } else {
                Node temp2 = newNode;
                for(int i = 0 ; i < rpos ; i++) {
                    temp2 = temp2.next;
                }
                temp1.random = temp2;
            } 

            pos++;
            temp1 = temp1.next;
        }

        return newNode;

    }
}