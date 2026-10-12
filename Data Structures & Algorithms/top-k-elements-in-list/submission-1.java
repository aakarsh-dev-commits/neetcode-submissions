class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        int[] arr = new int[k];
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }else {
                map.put(nums[i],1);
            }
        }

        ArrayList<Integer> ls = new ArrayList<>(map.keySet());

        

        PriorityQueue<Integer> maxFreq = new PriorityQueue<>((s1, s2) -> map.get(s2) - map.get(s1));

        for(int i : ls) {
            maxFreq.add(i);
        }

        for (int i = 0; i < k; i++) {
            arr[i] = maxFreq.poll();
        }

        return arr;
    }
}
