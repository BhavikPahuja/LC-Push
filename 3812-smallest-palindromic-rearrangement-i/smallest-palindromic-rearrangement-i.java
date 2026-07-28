class Solution {
    public String smallestPalindrome(String s) {
        
        int c[] = new int[26];

        for (int i=0; i<s.length(); i++) {

            c[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<26; i++) {

            while (c[i] > 1) {

                for (int j=0; j<c[i] / 2; j++) {

                    sb.append((char) (i + 'a'));
                    c[i] -= 2;
                }
            }
        }

        StringBuilder mid = new StringBuilder();

        for (int i=0; i<26; i++) {

            if (c[i] == 1) {

                mid.append((char) (i + 'a'));
            }
        }

        StringBuilder rev = new StringBuilder(sb).reverse();
        sb.append(mid);
        sb.append(rev);

        return sb.toString();
    }
}