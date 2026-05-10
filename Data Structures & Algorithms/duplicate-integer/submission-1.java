class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],nums[i]);
            } else {
                return true;
            }
        }
        return false;
    }
}