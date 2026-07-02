class Twitter {
    ListNode newNode;
    HashMap<Integer, ListNode> map;
    HashMap<Integer, ArrayList<Integer> > map2;
    int time;
    public Twitter() {
        map = new HashMap<>();
        map2 = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if (map.containsKey(userId)) {
            ListNode head = map.get(userId);
            ListNode tail = head.last;
            ListNode temp = new ListNode(tweetId, time, null, tail);
            tail.next = temp;
            head.last = temp;

        } else {
            ListNode temp = new ListNode(tweetId, time);
            temp.last = temp;
            map.put(userId, temp);
            ArrayList<Integer> al = new ArrayList<>();
            al.add(userId);
            map2.put(userId, al);
        }
        time++;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ls = new ArrayList<>();
        if (!map2.containsKey(userId)) {
            return ls;
        }
        ArrayList follower = map2.get(userId);
        int fIndex = follower.size() - 1;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> { return b.time - a.time; });

        for (int i = fIndex; i >= 0; i--) {
            ListNode temp = map.get(follower.get(i)).last;
            if (temp.tweetId < 0) {
                continue;
            }
            while (temp != null) {
                pq.offer(temp);
                temp = temp.prev;
            }
        }

        while (ls.size() < 10 && !pq.isEmpty()) {
            ls.add(pq.poll().tweetId);
        }

        return ls;
    }

    public void follow(int followerId, int followeeId) {
        if (map2.containsKey(followerId)) {
            ArrayList<Integer> follower = map2.get(followerId);
            if (follower.contains(Integer.valueOf(followeeId))) {
                return;
            }
            if (followerId != followeeId) {
                follower.add(Integer.valueOf(followeeId));
            }
        } else {
            ListNode temp = new ListNode(-1, time);
            temp.last = temp;
            map.put(followerId, temp);
            ArrayList<Integer> ls = new ArrayList<>();
            ls.add(Integer.valueOf(followerId));
            ls.add(Integer.valueOf(followeeId));
            map2.put(followerId, ls);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        ArrayList<Integer> follower = map2.get(followerId);
        if (followerId != followeeId) {
            follower.remove(Integer.valueOf(followeeId));
        }
    }

    class ListNode {
        int tweetId;
        int time;
        ListNode next;
        ListNode prev;
        ListNode last;

        public ListNode(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }

        public ListNode(int tweetId, int time, ListNode next) {
            this.tweetId = tweetId;
            this.next = next;
            this.time = time;
        }

        public ListNode(int tweetId, int time, ListNode next, ListNode prev) {
            this.tweetId = tweetId;
            this.next = next;
            this.prev = prev;
            this.time = time;
        }

        public ListNode findTail(ListNode head) {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            return temp;
        }
    }
}
