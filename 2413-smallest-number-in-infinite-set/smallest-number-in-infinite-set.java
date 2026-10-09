class SmallestInfiniteSet {
    
    Set<Integer> seen;
    PriorityQueue<Integer> pq;
    int curr = 1;
    
    public SmallestInfiniteSet() {
    
        seen = new HashSet<>();
        pq = new PriorityQueue<>();
    }
    
    public int popSmallest() {
    
        if(!pq.isEmpty()){
    
            int num = pq.poll();
            seen.remove(num);
            return num;
        }
    
        return curr++;
    }
    
    public void addBack(int num) {
    
        if(num<curr && !seen.contains(num)){
    
            pq.add(num);
            seen.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */