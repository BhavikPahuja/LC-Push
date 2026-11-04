class Solution {

    private void cleanTop(PriorityQueue<Integer> pq, Map<Integer, Integer> delayed) {

        while (!pq.isEmpty()) {

            int top = pq.peek();
            int count = delayed.getOrDefault(top, 0);

            if (count > 0) {

                pq.poll();

                if (count == 1) {

                    delayed.remove(top);
                } else {

                    delayed.put(top, count - 1);
                }
            } else {

                break;
            }
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length, m = n - x + 1;
        long[] cost = new long[m];

        PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Collections.reverseOrder()), rightHeap = new PriorityQueue<>();

        Map<Integer, Integer> delayed = new HashMap<>();

        long leftSum = 0, rightSum = 0, leftSize = 0, rightSize = 0;

        for (int i = 0; i < n; i++) {
            
            int num = nums[i];
            
            if (leftSize == 0 || num <= leftHeap.peek()) {
            
                leftHeap.offer(num);
                leftSum += num;
                leftSize++;
            } else {
            
                rightHeap.offer(num);
                rightSum += num;
                rightSize++;
            }

            if (i >= x) {
            
                int out = nums[i - x];
                delayed.put(out, delayed.getOrDefault(out, 0) + 1);
            
                if (out <= leftHeap.peek()) {
            
                    leftSum -= out;
                    leftSize--;
                } else {
            
                    rightSum -= out;
                    rightSize--;
                }
            }

            cleanTop(leftHeap, delayed);
            cleanTop(rightHeap, delayed);

            while (leftSize > rightSize + 1) {
            
                int val = leftHeap.poll();
                leftSum -= val;
                rightHeap.offer(val);
                rightSum += val;
                leftSize--;
                rightSize++;
                cleanTop(leftHeap, delayed);
            }

            while (leftSize < rightSize) {
            
                int val = rightHeap.poll();
                rightSum -= val;
                leftHeap.offer(val);
                leftSum += val;
                rightSize--;
                leftSize++;
                cleanTop(rightHeap, delayed);
            }

            cleanTop(leftHeap, delayed);
            cleanTop(rightHeap, delayed);

            if (i >= x - 1) {
            
                long median = leftHeap.peek();
                long curCost = (median * leftSize - leftSum) + (rightSum - median * rightSize);
                cost[i - x + 1] = curCost;
            }
        }

        long dp[] = new long[n + 1], INF = (long) 1e18;

        for (int j = 1; j <= k; j++) {

            long[] nextDp = new long[n + 1];
            Arrays.fill(nextDp, INF);

            for (int i = j * x; i <= n; i++) {

                nextDp[i] = nextDp[i - 1];

                if (dp[i - x] != INF) {

                    nextDp[i] = Math.min(nextDp[i], dp[i - x] + cost[i - x]);
                }
            }

            dp = nextDp;
        }

        return dp[n];
    }
}