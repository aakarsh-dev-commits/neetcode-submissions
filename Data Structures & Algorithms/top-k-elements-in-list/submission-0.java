class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        int[] arr = new int[k];
        int s = 0;
        for(int i =0 ;i < nums.length ; i++) {
             if(map.containsKey(nums[i])) {
                map.put(nums[i] , map.get(nums[i]) + 1);
                
             } else {
                map.put(nums[i] , 1);
                map2.put(s , nums[i]);
                s++;
             }
        }

        // for(int i =0 ;i < map2.size() ; i++) {
        //     arr2[i] = map.get(map2.get(i));
        // }
        // int j = 0;
        // Arrays.sort(arr2);

        PriorityQueue<Integer> maxFreq = new PriorityQueue<>((s1,s2) -> map.get(s2) - map.get(s1));

        for(int i = 0 ; i < map2.size()  ; i++) {
            maxFreq.add(map2.get(i));
        }

        for(int i = 0 ; i < k  ; i++) {
            arr[i] = maxFreq.poll();
        }

        return arr;


    }
}
