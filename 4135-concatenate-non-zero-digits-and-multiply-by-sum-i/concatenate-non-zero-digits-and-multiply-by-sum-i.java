class Solution {
    public long sumAndMultiply(int n) {
        

        int num = 0;
        int temp = n;
        int sum = 0;

        while (temp > 0) {
            int x = temp % 10;
            temp /= 10;

            if (x != 0) {

                num = num * 10 + x;
                sum += x;
            }
        }

        int ans = 0;
        while (num > 0) {

            ans = ans * 10 + num % 10;
            num /= 10;
        }

        return 1L * ans * sum;
    }
}