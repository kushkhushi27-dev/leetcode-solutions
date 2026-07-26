class MinStack {
    Stack<Long> obj;
    long mini=Integer.MAX_VALUE;
    public MinStack() {
        obj = new Stack<>();
    }
    
    public void push(int value) {
        long val=value;
        if(obj.isEmpty()){ mini=val;
        obj.push(val);
        }else{
            if(value>mini) obj.push(val);
            else{
                obj.push(2*val-mini);
                mini=val;
            }
        }
    }
    
    public void pop() {
        if(obj.isEmpty()){
            return;
        }
        long n=obj.peek();
        obj.pop();
        if(n<mini) mini=2*mini-n;
    }
    
    public int top() {
        if(obj.isEmpty()){
            return -1;
        }
        long n=obj.peek();
        if(mini<n) return (int)n;
        return (int)mini;
    }
    
    public int getMin() {
        return (int)mini;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */