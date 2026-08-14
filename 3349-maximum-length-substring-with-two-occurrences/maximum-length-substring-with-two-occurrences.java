class Solution {

    boolean check(int seen[]) {

        for (int i=0; i<26; i++) {

            if (seen[i] > 2) {

                return false;
            }
        }

        return true;
    }

    public int maximumLengthSubstring(String s) {

        int seen[] = new int[26];

        int i=0, j=0;
        int n = s.length();

        int ans = 0;

        while (j < n) {

            seen[s.charAt(j) - 'a']++;

            while (!check(seen)) {

                seen[s.charAt(i) - 'a']--;
                i++;
            }

            ans = Math.max(ans, j - i + 1);
        
            j++;
        }

        return ans;
    }
}