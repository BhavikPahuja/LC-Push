class Solution {

    public int edgeScore(int[] edges) {

        int n = edges.length;

        long freq[] = new long[n];    
    
        for (int i=0; i<n; i++) {

            freq[edges[i]] += i;
        }

        int max = 0;

        for (int i=0; i<n; i++) {

            if (freq[i] > freq[max]) {

                max = i;
            }
        }

        return max;
    }
}