class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, 0, target, candidates, new ArrayList<>());
        return ans;
    }

    public void dfs(int index, int sum, int target, int[] candidates, List<Integer> ls) {
        if (sum == target) {
            ans.add(new ArrayList<>(ls));
            return;
        }

        if (sum > target) {
            return;
        }

        if (index > candidates.length - 1) {
            return;
        }

        ls.add(candidates[index]);
        sum += candidates[index];

        dfs(index + 1, sum, target, candidates, ls);
        if (!ls.isEmpty()) {
            int temp = ls.get(ls.size() - 1);
            sum = sum - temp;
            ls.remove(ls.size() - 1);
        }

        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index = index + 1;
        }

        dfs(index + 1, sum, target, candidates, ls);
    }
}
