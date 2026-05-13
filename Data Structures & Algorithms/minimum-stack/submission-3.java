class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> mini;

    public MinStack() {
        stack = new ArrayDeque<>();
        mini = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(mini.isEmpty()) {
            mini.push(val);
        }else{
        int temp = mini.peek();    
        if(temp >= val) {
            mini.push(val);
        }
        } 
    }
    
    public void pop() {
        int temp1 = stack.peek();
        int temp2 = mini.peek();
        if (temp1 == temp2) {
            mini.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        int temp = mini.peek();
        return temp;
    }
}
