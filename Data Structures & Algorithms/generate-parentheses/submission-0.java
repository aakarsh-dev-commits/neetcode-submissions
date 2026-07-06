class Solution {
    StringBuilder stack;
    List<String> res;
    public List<String> generateParenthesis(int n) {
        stack = new StringBuilder();
        res = new ArrayList<>();
        backtrack(0,0,n);
        return res;
    }

    public void backtrack(int close , int open , int n) {
        if(stack.length() == 2*n) {
            String add = stack.toString();
            res.add(add);
            return;
        }

        if(open < n) {
            stack.append('(');
            backtrack(close,open+1, n);
            stack.deleteCharAt(stack.length()-1);
        }

        if(open > close) {
            stack.append(')');
            backtrack(close+1,open, n);
            stack.deleteCharAt(stack.length()-1);
        }
    }


}
