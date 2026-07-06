class Solution {
    List<List<Integer>> ans;
    HashMap<List<Integer>,Integer> map;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        map = new HashMap<>();
        dfs(nums, 0, new ArrayList<>());
        return ans;
    }

    public void dfs(int[] nums, int index, List<Integer> ls) {
        if (index == nums.length) {
            if(!map.containsKey(ls)){
            ans.add(new ArrayList<>(ls));
            map.put(ls,1);
            }
            return;
        }

        ls.add(nums[index]);
        dfs(nums, index + 1, ls);

        ls.remove(ls.size() - 1);

        dfs(nums, index + 1, ls);
    }
}
