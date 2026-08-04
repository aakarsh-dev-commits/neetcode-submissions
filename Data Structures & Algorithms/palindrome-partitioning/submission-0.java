class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        dfs(s,0,new ArrayList<>());
        return ans;
    }

    public void dfs(String s, int index, List<String> ls) {
        if (index >= s.length()) {
            ans.add(new ArrayList<>(ls));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String check = s.substring(index, i+1);
            if (isPalindrome(check)) {
                ls.add(check);
                dfs(s, i + 1, ls);
                ls.remove(ls.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String word) {
        int l = 0;
        int r = word.length() - 1;

        while (l < r) {
            if (word.charAt(l) != word.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
