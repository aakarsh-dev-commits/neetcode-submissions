class Solution {
    List<String> ls;
    String[] comb = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    ;
    public List<String> letterCombinations(String digits) {
        ls = new ArrayList<>();
        if (digits.length() == 0) {
            return ls;
        }
        dfs(0, "", digits);
        return ls;
    }

    public void dfs(int index, String curStr, String digits) {
        if (curStr.length() == digits.length()) {
            ls.add(curStr);
            return;
        }

        String s = comb[digits.charAt(index) - '0'];

        for (char c : s.toCharArray()) {
            dfs(index + 1, curStr + c, digits);
        }
    }
}
