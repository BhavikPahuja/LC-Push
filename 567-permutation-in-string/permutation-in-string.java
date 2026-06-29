class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int f1[] = new int[26];
        for (int i=0; i<n; i++) {
            f1[s1.charAt(i) - 'a']++;
        }
        int f2[] = new int[26];
        for (int i=0; i<n-1; i++) {
            f2[s2.charAt(i) - 'a']++;
        }
        int i = 0, j = n - 1;
        while (j < m) {
            f2[s2.charAt(j++) - 'a']++;
            if (Arrays.equals(f1, f2)) {
                return true;
            }
            f2[s2.charAt(i++) - 'a']--;
        }
        return false;
    }
}