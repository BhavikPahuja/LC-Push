class Solution {
    boolean check(int hash[]) {
        if (hash[0] > 0 && hash[1] > 0 && hash[2] > 0) {
            return true;
        }
        return false;
    }
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int i = 0, j = 0;
        int ans = 0;
        int hash[] = new int[26];
        while (j < n) {
            hash[s.charAt(j) - 'a']++;
            while (check(hash)) {
                ans += n - j;
                hash[s.charAt(i++) - 'a']--;
            }
            j++;
        }
        return ans;
    }
}