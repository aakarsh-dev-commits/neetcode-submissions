class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sum = new int[2];
        for(int i = 0 ; i < nums.length ; i++ ) {
            int val = nums[i];
            int find = target - val;
            for(int j = 0 ; j < nums.length ; j++ ) {
                if(i != j) {
                if(find == nums[j]) {
                    return new int[] {i ,j};
                }
                }
            }

        }
        return sum;
    }
}
