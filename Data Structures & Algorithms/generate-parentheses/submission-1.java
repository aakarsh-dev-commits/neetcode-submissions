class Solution {
    StringBuilder stack;
    List<String> ls;
    public List<String> generateParenthesis(int n) {
        stack = new StringBuilder();
        ls = new ArrayList<>();

        backtrack(0,0,n);
        return ls;
    }

    public void backtrack(int open , int close , int n) {
        if(stack.length() == 2*n) {
            String ans = stack.toString();
            ls.add(ans);
            return;
        }

        if(open < n) {
            stack.append("(");
            backtrack(open+1,close,n);
            stack.deleteCharAt(stack.length()-1);
        }

        if(open > close) {
            stack.append(")");
            backtrack(open,close+1,n);
            stack.deleteCharAt(stack.length()-1);
        }
    }
}
