class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] arr = new int[position.length][2];
        for(int i = 0 ; i < position.length ; i++) {
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr , (x,y) -> x[0]-y[0]);

        Deque<Double> stack = new ArrayDeque<>();
        for(int i = position.length-1 ; i >= 0 ; i--) {
            if(i ==  position.length-1 ) {
            double time = (double)(target - arr[i][0])/arr[i][1];
            stack.push(time);
            continue;
            }

            double time = (double)(target - arr[i][0])/arr[i][1];
            double t = stack.peek();
            if(time > t) {
                stack.push(time);
            } 

        }

        int fleet = stack.size();
        return fleet;
    }
}
