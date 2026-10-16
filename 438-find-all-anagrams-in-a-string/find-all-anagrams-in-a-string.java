class Solution {
    
    boolean check(int a[], int b[]) {

        for (int i=0; i<26; i++) {

            if (a[i] != b[i]) {

                return false;
            }
        }

        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        
        int n = s.length();
        int m = p.length();

        if (n < m) {

            return new ArrayList<>();
        }

        int sh[] = new int[26];
        int ph[] = new int[26];

        for (char ch : p.toCharArray()) {

            ph[ch - 'a']++;
        }

        List<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = 0;

        for (; j<m; j++) {

            sh[s.charAt(j) - 'a']++;
        }

        while (j < n) {

            if (check(sh, ph)) {

                ans.add(i);
            }

            sh[s.charAt(i) - 'a']--;
            sh[s.charAt(j) - 'a']++;

            i++;
            j++;
        }

        if (check(sh, ph)) {

            ans.add(i);
        }

        return ans;
    }
}