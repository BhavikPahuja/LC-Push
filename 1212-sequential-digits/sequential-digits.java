class Solution {

    void rec(int curr, int bit, int low, int high, List<Integer> ans) {

        if (curr > high) {

            return;
        }

        if (curr >= low && curr <= high) {

            ans.add(curr);
        }

        for (int i=0; i<=9; i++) {

            if (i == bit + 1) {

                rec(curr * 10 + i, i, low, high, ans);
            }
        }
    }

    public List<Integer> sequentialDigits(int low, int high) {
        
        List<Integer> ans = new ArrayList<>();

        for (int i=0; i<=9; i++) {

            rec(0, i, low, high, ans);
        }

        Collections.sort(ans);

        return ans;
    }
}