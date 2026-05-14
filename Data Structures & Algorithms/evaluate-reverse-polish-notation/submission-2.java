class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0 ; i < tokens.length ; i++ ) {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/") ) {
                int u = stack.pop();
                int v = stack.pop();
                int temp = 0;
                switch (tokens[i]) {
                    case "+" : temp = v + u; break;
                    case "-" : temp = v - u; break;
                    case "*" : temp = v * u; break;
                    case "/" : temp = v / u; break;
                }

                stack.push(temp);
            } else {
                int temp = Integer.valueOf(tokens[i]);
                stack.push(temp);
            }
        }

        int result = stack.pop();

        return result;
    }
}
