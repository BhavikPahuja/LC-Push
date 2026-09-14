class Solution {

    int cuts(int k, int nums[]){

        int ans = 1;
        int curr = 0;

        for (int i : nums) {

            if (i + curr <= k) {

                curr += i;
            } else {

                ans++;
                curr = i;
            }
        }

        return ans;
    }

    public int splitArray(int[] nums, int k) {

        int low = -1, high = 0;
        for (int i : nums) {

            low = Math.max(low, i);
            high += i;
        }

        while (low <= high) {

            int mid = (low + high) >>> 1;

            if (cuts(mid, nums) > k) {

                low = mid + 1;
            } else {

                high = mid - 1;
            }
        }

        return low;
    }
}