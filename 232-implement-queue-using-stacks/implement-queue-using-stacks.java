class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    void transfer(Stack<Integer> s1, Stack<Integer> s2) {

        while (!s1.isEmpty()) {

            s2.push(s1.pop());
        }
    }

    public MyQueue() {
        
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        
        s1.push(x);
    }
    
    public int pop() {
        
        transfer(s1, s2);
        int val = s2.pop();
        transfer(s2, s1);
        return val;
    }
    
    public int peek() {
        
        transfer(s1, s2);
        int val = s2.peek();
        transfer(s2, s1);
        return val;
    }
    
    public boolean empty() {
        
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */