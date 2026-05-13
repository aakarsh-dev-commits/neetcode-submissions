class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();

        if(s.length() % 2 != 0) {
            return false;
        }

        for (int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[' ) {
                stack.push(c);
            } else {

                if(stack.isEmpty()) {
                    return false;
                }

                char v = stack.pop();
                if(v == '(' && c ==')') {
                continue;
                }else if (v == '[' && c ==']') {
                continue;
                }else if (v == '{' && c =='}') {
                continue;
                } else {
                return false;
                }
            }
        }

        if(stack.isEmpty()) {
            return true;
        }

        return false;
    }
}
