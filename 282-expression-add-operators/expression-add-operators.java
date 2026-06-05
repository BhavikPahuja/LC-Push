class Solution {
    void rec(int level, String num, long val, long prev, int k, String curr, List<String> ans) {
        // pruning

        // base case
        if (level == num.length()) {
            if (val == k) {
                ans.add(curr);
            }
            return;
        }
        // cache check

        // compute
        for (int i=level; i<num.length(); i++) {
            if (i > level && num.charAt(level) == '0') {
                break;
            }
            String s = num.substring(level, i + 1);
            long currVal = Long.parseLong(s);
            if (level == 0) {
                rec(i + 1, num, currVal, currVal, k, s, ans);
            } else {
                rec(i + 1, num, val + currVal, currVal, k, curr + "+" + s, ans);
                rec(i + 1, num, val - currVal, -currVal, k, curr + "-" + s, ans);
                rec(i + 1, num, val - prev + (prev * currVal), prev * currVal, k, curr + "*" + s, ans);
            }
        }
        // save and return

    }
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        rec(0, num, 0, 0, target, "", ans);
        return ans;
    }
}