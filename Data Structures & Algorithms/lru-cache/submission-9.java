class LRUCache {
    HashMap<Integer, ListNode> map;
    ListNode head;
    ListNode tail;

    int capacity;
    int net;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        this.net = 0;
        head = new ListNode();
        head.next = null;
        head.prev = null;
        tail = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode temp = map.get(key);

            if (head == tail) {
                return temp.value;
            }
            if (temp.value == -1) {
                return -1;
            }

            if (temp == tail) {
                return temp.value;
            }
            if (temp == head) {
                head = head.next;
                head.prev = null;
                tail.next = temp;
                temp.prev = tail;
                temp.next = null;
                tail = tail.next;
                return temp.value;
            }
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            tail.next = temp;
            temp.prev = tail;
            temp.next = null;
            tail = tail.next;
            return temp.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (net == 0) {
            head.key = key;
            head.value = value;
            map.put(key, head);
            net++;
            return;
        }

        if (map.containsKey(key)) {
            ListNode temp = map.get(key);
            if (head == tail) {
                temp.value = value;
                return;
            }
            if (temp == tail) {
                temp.value = value;
                return;
            }
            if (temp == head) {
                head = head.next;
                head.prev = null;
                tail.next = temp;
                temp.prev = tail;
                temp.next = null;
                tail = tail.next;
                temp.value = value;
                map.put(temp.key, temp);
                return;
            }
            temp.value = value;
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            tail.next = temp;
            temp.prev = tail;
            temp.next = null;
            tail = tail.next;
            map.put(temp.key, temp);
        } else {
            if (net < capacity) {
                net++;
                ListNode newNode = new ListNode(key, value);
                tail.next = newNode;
                newNode.prev = tail;
                tail = tail.next;
                newNode.next = null;
                map.put(key, newNode);
            } else {
                if (head == tail) {
                    ListNode temp = head;
                    map.remove(temp.key);
                    temp.value = value;
                    temp.key = key;
                    map.put(key,temp);
                    return;
                }
                ListNode temp = head;
                head = head.next;
                map.remove(temp.key);
                head.prev = null;
                ListNode newNode = new ListNode(key, value);
                tail.next = newNode;
                newNode.prev = tail;
                tail = tail.next;
                newNode.next = null;
                map.put(key, newNode);
            }
        }
    }

    class ListNode {
        int value;
        int key;
        ListNode next;
        ListNode prev;

        public ListNode() {}

        public ListNode(int key, int value) {
            this.value = value;
            this.key = key;
        }

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }
}
