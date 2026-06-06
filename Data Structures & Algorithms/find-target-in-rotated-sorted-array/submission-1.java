class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length -1;
        
        while(l <= r) {
            if(nums[l] <= nums[r] && nums[l] <= target) {
               if(Arrays.binarySearch(nums , l , r+1, target) >=0) {
                return Arrays.binarySearch(nums , l , r+1, target);
               } else {
                return -1;
               }
            }

            int m = (l+r)/2;
            if(nums[m] >= nums[l]) {
                if(nums[m] >= target && target >= nums[l]) {
                    if(Arrays.binarySearch(nums , l , m+1, target) >=0) {
                        return Arrays.binarySearch(nums , l , m+1, target);
                        } else {
                            return -1;
                        }
                } else {
                     l = m+1;
                }
                
            } else if(nums[m] <= nums[r]) {
                if(nums[r] >= target && nums[m] <= target) {
                    if(Arrays.binarySearch(nums , m , r+1, target) >=0) {
                        return Arrays.binarySearch(nums , m , r+1, target);
                        } else {
                            return -1;
                        }
                } else {
                     r = m -1;
                }
            }
        }

        return - 1;
    }
}
