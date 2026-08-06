class Solution {

    int prod(int n) {

        int ans = 1;

        while (n > 0) {

            ans *= (n % 10);
            n /= 10;
        }

        return ans;
    }

    public int smallestNumber(int n, int t) {

        while (true) {

            if (prod(n) % t == 0) {

                return n;
            }

            n++;
        }
    }
}