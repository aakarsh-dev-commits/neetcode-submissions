class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];

        dfs(nums,new ArrayList<>() , vis);
        return ans;
    }

    public void dfs(int[] nums , List<Integer> ls , boolean[] vis ) {
        if(ls.size() == nums.length) {
            ans.add(new ArrayList<>(ls));
            return;
        }

        for(int i = 0 ; i < nums.length ; i++) {
            if(vis[i]) {
                continue;
            }

            ls.add(nums[i]);
            vis[i] = true;
            dfs(nums,ls,vis);

            ls.remove(ls.size()-1);
            vis[i] = false;
        }
    }
}
