class Solution {

    public int scheduleCourse(int[][] courses) {

        Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        int curr = 0;
        for (int c[] : courses) {

            if (c[0] + curr <= c[1]) {

                curr += c[0];
                pq.offer(new int[]{c[0], c[1]});
            }
            
            else if (!pq.isEmpty() && c[0] < pq.peek()[0]) {

                curr -= pq.peek()[0];
                pq.poll();
                curr += c[0];
                pq.offer(new int[]{c[0], c[1]});
            }
        }

        return pq.size();
    }
}