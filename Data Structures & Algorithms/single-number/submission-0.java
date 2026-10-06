class Solution {
    HashMap<Integer,Integer> map;
    public int singleNumber(int[] nums) {
        map = new HashMap<>();
        for(int i = 0; i < nums.length ; i++) {
            if(map.containsKey(nums[i])) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i],1);
            }
        }

        ArrayList<Integer> ls = new ArrayList<>(map.keySet());
        return ls.get(0);
    }
}
