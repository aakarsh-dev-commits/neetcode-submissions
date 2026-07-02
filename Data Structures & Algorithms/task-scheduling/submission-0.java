class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Pair> q = new ArrayDeque<>();
        int[] frequency = new int[26];

        for(char task : tasks) {
            frequency[task - 'A']++;
        }

        for(int i : frequency) {
            if(i > 0 ) {
                maxHeap.offer(i);
            }
        }
        int time = 0;
        while(!maxHeap.isEmpty() || !q.isEmpty()) {
            if(!q.isEmpty() && q.peek().time == time) {
                int pollFreq = q.poll().freq;
                maxHeap.offer(pollFreq);
            }
            if(maxHeap.isEmpty()) {
                time++;
                continue;
            }
            int freq = maxHeap.poll();
            time++;
            if(freq > 1) {
                Pair temp = new Pair(time+n , freq-1);
                q.offer(temp);
            }
            
        }
        return time;
    }

    class Pair {
        int time;
        int freq;

        public Pair(int time , int freq) {
            this.time = time;
            this.freq = freq;
        }
    }
}
