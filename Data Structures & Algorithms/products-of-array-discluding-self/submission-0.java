class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int product_wt0 = 1;
        int num_zero = 0;
        int[] res = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++ ) {
            if(nums[i] == 0) {
                num_zero++;
                if(num_zero > 1) {
                return new int[nums.length];
            }
                continue;
            }
            product = nums[i] * product;
        }

        

        for(int i = 0 ; i < nums.length ; i++ ) {

            if(nums[i] == 0 && num_zero == 1) {
                int[] temp =  new int[nums.length];
                temp[i] = product;
                return temp;
            } else {
            res[i] = product / nums[i];
            }
        }
        
        return res;
    }
}  
