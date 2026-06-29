class Solution {
    
    int calculate(int piles[], int h) {
        
        int ans = 0;
        for (int pile : piles) {
            
            if (pile % h == 0) {
                ans += (pile / h);
            } else {
                ans += (pile / h + 1);
            }
        }

        return ans;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int min = (int) 1e9;
        int max = - (int) 1e9;

        for (int pile : piles) {
            min = Math.min(min, pile);
            max = Math.max(max, pile);
        }

        int low = 1;
        int high = max;
        int ans = max;

        while (low < high) {
            int mid = (low + high) >>> 1;

            int time = calculate(piles, mid);

            if (time <= h) {
                ans = mid;
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}