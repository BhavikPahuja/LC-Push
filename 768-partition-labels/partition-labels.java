class Solution {

    public List<Integer> partitionLabels(String s) {

        int n = s.length();
        int ed[] = new int[26];

        for (int i=0; i<n; i++) {

            ed[s.charAt(i) - 'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();
        int st = 0, max = 0;

        for (int i=0; i<n; i++) {

            char ch = s.charAt(i);

            max = Math.max(max, ed[ch - 'a']);

            if (i == max) {

                ans.add(max - st + 1);
                st = max + 1;
            }
        }

        return ans;
    }
}