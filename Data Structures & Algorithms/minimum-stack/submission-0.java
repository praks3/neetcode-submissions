class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        this.stack= new Stack<>();
        this.minStack= new Stack<>();
    }
    
    public void push(int val) {
        if(minStack.isEmpty() || minStack.peek()>=val){
            minStack.push(val);
        }
        stack.push(val);
    }
    
    public void pop() {
        int val = stack.pop();
        if(minStack.peek()==val){
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
