class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0,nums,new ArrayList<>());

        return ans;

    }

    public void dfs(int index,int[] nums ,List<Integer> ls) {
        if(index == nums.length) {
            ans.add(new ArrayList<>(ls));
            return;
        }

        ls.add(nums[index]);
        dfs(index+1,nums,ls);

        if(!ls.isEmpty()) {
        ls.remove(ls.size()-1);
        }

        while(index+1 < nums.length && nums[index+1] == nums[index]) {
            index++;
        }

        dfs(index+1,nums,ls);
    }
}
