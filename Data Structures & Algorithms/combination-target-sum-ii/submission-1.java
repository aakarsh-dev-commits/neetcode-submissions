class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, 0, candidates, target, new ArrayList<>());
        return ans;
    }

    public void dfs(int index, int sum, int[] candidates, int target, List<Integer> ls) {
        if (target == sum) {
            ans.add(new ArrayList<>(ls));
            return;
        }

        if (sum > target || index > candidates.length - 1) {
            return;
        }

        ls.add(candidates[index]);
        sum += candidates[index];

        dfs(index + 1, sum, candidates, target, ls);
        if (!ls.isEmpty()) {
            sum -= ls.get(ls.size() - 1);
            ls.remove(ls.size() - 1);
        }
        while(index+1 < candidates.length && candidates[index] == candidates[index+1]) {
            index++;
        }
        dfs(index + 1, sum, candidates, target, ls);
    }
}
