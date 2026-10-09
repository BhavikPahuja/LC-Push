class Solution {

    record State(int cost, int idx) {}

    public long totalCost(int[] costs, int k, int candidates) {

        int n = costs.length;
        int i = 0, j = n - 1;

        PriorityQueue<State> pq1 = new PriorityQueue<>(Comparator.comparingInt(State::cost).thenComparingInt(State::idx));
        PriorityQueue<State> pq2 = new PriorityQueue<>(Comparator.comparingInt(State::cost).thenComparingInt(State::idx));

        for (; i<candidates; i++) {

            pq1.offer(new State(costs[i], i));
        }

        for (; j>n-candidates-1 && j >= i; j--) {

            pq2.offer(new State(costs[j], j));
        }

        long ans = 0;

        while (k-- > 0) {

            if (pq1.isEmpty()) {

                ans += pq2.poll().cost();
                continue;
            }

            if (pq2.isEmpty()) {

                ans += pq1.poll().cost();
                continue;
            }

            if (pq1.peek().cost() <= pq2.peek().cost()) {

                ans += pq1.poll().cost();

                if (i <= j) {

                    pq1.offer(new State(costs[i], i));
                    i++;
                }
            } else {
                
                ans += pq2.poll().cost();

                if (i <= j) {

                    pq2.offer(new State(costs[j], j));
                    j--;
                }
            }
        }

        return ans;
    }
}