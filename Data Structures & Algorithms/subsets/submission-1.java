class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        dfs(0,nums,new ArrayList<>());
        return ans;
    }

    public void dfs(int index , int[] nums ,List<Integer> ls ) {
        if(index == nums.length) {
            ans.add(new ArrayList<>(ls));
            return;
        }

        ls.add(nums[index]);
        dfs(index+1,nums,ls);

        ls.remove(ls.size()-1);

        dfs(index+1,nums,ls);
    }
}
