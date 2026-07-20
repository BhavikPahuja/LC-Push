class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    void transfer(Queue<Integer> q1, Queue<Integer> q2) {

        int val = -1;

        if (!q1.isEmpty()) {

            val = q1.poll();
            transfer(q1, q2);
        } else {

            return;
        }

        q2.offer(val);
    }

    public MyStack() {
        
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        
        transfer(q2, q1);
        q1.offer(x);
        transfer(q1, q2);
    }
    
    public int pop() {
        
        return q2.poll();
    }
    
    public int top() {
        
        return q2.peek();
    }
    
    public boolean empty() {
        
        return q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */