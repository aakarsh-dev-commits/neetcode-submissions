class Solution {
    PriorityQueue<Integer> maxHeap;
    public int lastStoneWeight(int[] stones) {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());

         for(int stone : stones) {
            maxHeap.offer(stone);
        }
        
        return weight(maxHeap);

    }

    public int weight(PriorityQueue<Integer> maxHeap) {
       
        if(maxHeap.isEmpty()) {
            return 0;
        }
        if(maxHeap.size() == 1) {
            return maxHeap.peek();
        }

       
        int num1 = maxHeap.poll();
        int num2 = maxHeap.poll();

        if(num1 > num2) {
           maxHeap.offer(num1-num2);

        } 

        return weight(maxHeap);
    }
}
