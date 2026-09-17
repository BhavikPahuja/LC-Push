class Solution {

    public int minSumOfLengths(int[] arr, int target) {

        int lens[] = new int[(int) 1e5];
        int n = arr.length;

        int prev = (int) 1e9, ans = (int) 1e9, sum = 0;

        for (int l=0, r=0; r<n; r++) {

            sum += arr[r];

            for (; sum > target; l++) {

                sum -= arr[l];
            }

            lens[r] = prev;

            if (sum == target) {

                int len = r - l + 1;

                if (l > 0) {

                    ans = Math.min(ans, len + lens[l - 1]);
                }

                lens[r] = Math.min(lens[r], len);
            }

            prev = lens[r];
        }

        return ans >= (int) 1e9 ? -1 : ans;
    }
}