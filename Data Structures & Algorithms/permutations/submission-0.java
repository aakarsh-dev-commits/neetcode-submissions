class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        for (boolean v : vis) {
            v = false;
        }

        dfs(nums,vis,new ArrayList<>());
        return ans;
    }

    public void dfs(int[] nums, boolean[] vis, List<Integer> ls) {
        if(nums.length == ls.size()){
            ans.add(new ArrayList<>(ls));
        }

        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) {
                continue;
            }

            ls.add(nums[i]);
            vis[i] = true;

            dfs(nums,vis,ls);

            ls.remove(ls.size()-1);
            vis[i] = false;
        }
    }
}
