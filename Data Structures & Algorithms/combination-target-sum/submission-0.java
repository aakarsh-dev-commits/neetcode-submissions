class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList<>();
        dfs(0,nums,new ArrayList<>() ,0,target);
        return ans;
    }

    public void dfs(int index, int[] nums, List<Integer> ls, int sum, int target) {
        if(index > nums.length-1) {
            return;
        }
        if (sum == target) {
            ans.add(new ArrayList<>(ls));
            return;
        }

        if (sum > target) {
            return;
        }

        ls.add(nums[index]);
        sum += nums[index];

        dfs(index, nums, ls, sum,target);

        int temp = ls.get(ls.size() - 1);
        sum = sum - temp;
        ls.remove(ls.size() - 1);

        dfs(index+1, nums, ls,sum,target);
    }
}
