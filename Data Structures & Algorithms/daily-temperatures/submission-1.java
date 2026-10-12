class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int t : temperatures) {
        stack.push(t);
        }

        int[] store = new int[temperatures.length];
        int[] arr = new int[temperatures.length];

        int l = 0;
        for(int i = temperatures.length-1 ; i >= 0 ; i--) {
           if(i == temperatures.length-1 ) {
            continue;
           }
           int poped = stack.pop();
           store[l] = poped;
           int s = l;
           while(s >= 0) {
            if(temperatures[i] < store[s]) {
                break;
            }
            s--;
           }
           if(s < 0) {
            arr[i] = 0;
            l++;
            continue;
           }
           int index = l - s + 1 ;
           arr[i] = index;

           l++;

        }

        return arr;
    }
}
