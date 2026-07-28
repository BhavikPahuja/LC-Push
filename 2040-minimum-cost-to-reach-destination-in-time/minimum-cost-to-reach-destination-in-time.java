class Solution {

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        
        int n = passingFees.length;

        List<List<int[]>> adj = new ArrayList<>();

        for (int i=0; i<n; i++) {

            adj.add(new ArrayList<>());
        }

        for (int edge[] : edges) {

            int u = edge[0], v = edge[1], time = edge[2];

            adj.get(u).add(new int[]{v, time});
            adj.get(v).add(new int[]{u, time});
        }

        int time[] = new int[n];
        Arrays.fill(time, (int) 1e9);
        time[n - 1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{n - 1, 0});

        while (!pq.isEmpty()) {

            int curr[] = pq.poll();

            for (int nei[] : adj.get(curr[0])) {

                if (curr[1] + nei[1] < time[nei[0]]) {

                    time[nei[0]] = curr[1] + nei[1];
                    pq.offer(new int[]{nei[0], time[nei[0]]});
                }
            }
        }

        PriorityQueue<int[]> pq1 = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq1.offer(new int[]{0, 0, passingFees[0]});

        int state[][] = new int[n][maxTime + 1];
        for (int i=0; i<n; i++) {

            Arrays.fill(state[i], (int) 1e9);
        }

        int min = (int) 1e9;

        while (!pq1.isEmpty()) {

            int curr[] = pq1.poll();

            if (curr[0] == n - 1) {

                min = Math.min(min, curr[2]);
            }

            for (int nei[] : adj.get(curr[0])) {

                if (curr[1] + nei[1] + time[nei[0]] <= maxTime) {

                    int currFare = curr[2] + passingFees[nei[0]];
                    if (currFare >= state[nei[0]][curr[1] + nei[1]]) {

                        continue;
                    }

                    state[nei[0]][curr[1] + nei[1]] = currFare;

                    pq1.offer(new int[]{nei[0], curr[1] + nei[1], currFare});
                }
            }
        }

        return min == (int) 1e9 ? -1 : min;
    }
}