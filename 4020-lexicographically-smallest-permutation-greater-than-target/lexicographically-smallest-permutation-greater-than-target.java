class Solution {

    String ans = "";
    boolean found = false;

    void build(int level, int n, String curr, String k, boolean greater, int freq[]) {

        if (level == n) {

            if (greater) {

                found = true;
                ans = curr;
            }
            return;
        }

        int start = greater ? 0 : k.charAt(level) - 'a';

        for (int i=start; i<26; i++) {

            if (freq[i] > 0) {

                freq[i]--;
                build(level + 1, n, curr + (char) (i + 'a'), k, greater || i > k.charAt(level) - 'a', freq);
                freq[i]++;

                if (found) {

                    return;
                }
            }
        }
    }

    public String lexGreaterPermutation(String s, String target) {

        int freq[] = new int[26];

        for (char ch : s.toCharArray()) {

            freq[ch - 'a']++;
        }

        build(0, s.length(), "", target, false, freq);

        return ans;
    }
}