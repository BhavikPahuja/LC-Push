class Solution {
    public long sumAndMultiply(int n) {
        

        long num = 0;
        long temp = n;
        long sum = 0;

        while (temp > 0) {
            long x = temp % 10;
            temp /= 10;

            if (x != 0) {

                num = num * 10 + x;
                sum += x;
            }
        }

        long ans = 0;
        while (num > 0) {

            ans = ans * 10 + num % 10;
            num /= 10;
        }

        return ans * sum;
    }
}