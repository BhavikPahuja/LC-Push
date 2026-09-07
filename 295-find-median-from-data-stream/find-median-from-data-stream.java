class MedianFinder {

    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;

    public MedianFinder() {
        
        pq1 = new PriorityQueue<>();
        pq2 = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {

        if (pq1.isEmpty() || num >= pq1.peek()) { 
            pq1.offer(num); 
        } else { 
            pq2.offer(num); 
        }

        while (pq1.size() > pq2.size() + 1) {

            pq2.offer(pq1.poll());
        }

        while (pq2.size() > pq1.size()) {

            pq1.offer(pq2.poll());
        }
    }
    
    public double findMedian() {
        
        if (pq1.size() > pq2.size()) {

            return pq1.peek();
        } else if (pq2.size() > pq1.size()) {

            return pq2.peek();
        } else {

            return (double) ((double) (pq1.peek() + pq2.peek()) / (double) (2));
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */