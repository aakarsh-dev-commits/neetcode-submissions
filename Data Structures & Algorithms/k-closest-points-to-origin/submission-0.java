class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            int num1 = a[0]*a[0] + a[1]*a[1];
            int num2 = b[0]*b[0] + b[1]*b[1];
            return Integer.compare(num2, num1);
        });

        for (int[] point : points) {
            maxHeap.offer(point);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int size =  maxHeap.size();
        int[][] res = new int[size][];
        for (int i = 0; i < size; i++) {
            res[i] = maxHeap.poll();
        }

        return res;
    }
}
