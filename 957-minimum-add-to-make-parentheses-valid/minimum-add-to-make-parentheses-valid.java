class Solution {

    public int minAddToMakeValid(String s) {

        int ans = 0, cnt = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                cnt++;
            } else {

                if (cnt == 0) {

                    ans++;
                } else {

                    cnt--;
                }
            }
        }

        return ans + cnt;     
    }
}