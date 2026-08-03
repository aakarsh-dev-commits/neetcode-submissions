class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList<>();
        dfs(0,nums,0,target,new ArrayList<>());
        return ans;

    }

    public void dfs(int index , int[] nums ,int sum,int target ,List<Integer> ls ) {
        if(sum == target) {
            ans.add(new ArrayList<>(ls));
            return;
        }

        if(sum > target || index > nums.length -1) {
            return;
        }

        ls.add(nums[index]);
        sum += nums[index];

        dfs(index,nums,sum,target,ls);

        
        sum -= ls.get(ls.size()-1);
        ls.remove(ls.size()-1);

        dfs(index+1,nums,sum,target,ls);
    }
}
