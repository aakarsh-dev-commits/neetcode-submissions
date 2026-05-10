class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        java.util.Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] > 0) {
                break;
            }
            if(i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int target = -nums[i];
            int l = i+1;
            int high  = nums.length -1 ;
            while(l < high) {
                if(nums[l] + nums[high] == target) {
                    Integer[] arr = {nums[i] , nums[l] , nums[high]};
                    List<Integer> tls = Arrays.asList(arr);
                    if(!ls.contains(tls)) {
                     ls.add(tls);
                    }
                    l++;
                    high--;
                } else if (nums[l] + nums[high] < target) {
                    l++;
                } else if (nums[l] + nums[high] > target) {
                    high--;
                }
            }
        }

        return ls;
    }
}
