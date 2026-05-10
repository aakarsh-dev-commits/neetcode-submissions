class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();

        if(nums.length == 0) {
            return 0;
        }

        if(nums.length == 1) {
            return 1;
        }

        Arrays.sort(nums);

        int min = 0;
        int k = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            if(!(map.containsValue(nums[i]))) {
            map.put(k , nums[i]);
            k++;
            } 
        }

        int longest = 1;
        int maxLongest = 1;
        for(int i = 0 ; i < map.size() ; i++) {

            if(map.containsValue(map.get(i) + 1)) {
                longest++;
            } else {
                if(longest > maxLongest) {
                maxLongest = longest;
                }
                longest = 1;
            }

        
        }
        return maxLongest ;
    }
}
