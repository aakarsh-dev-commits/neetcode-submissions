class Solution {
    public int[] twoSum(int[] nums, int target) {

        for(int i = 0 ; i < nums.length ; i++) {
            int check = target - nums[i];
            for(int j = 0 ; j < nums.length ; j++) {
                if ( check == nums[j] && j != i) {
                    int[] arr = {Math.min(i,j) , Math.max(i,j)};
                    return arr;
                }
            }
        }
        return null;
    }
}
