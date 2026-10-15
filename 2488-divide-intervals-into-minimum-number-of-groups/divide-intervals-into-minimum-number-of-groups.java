class Solution {

    public int minGroups(int[][] iv) {

        List<List<Integer>> ll = new ArrayList<>();

        for (int i[] : iv) {

            ll.add(List.of(i[0], 0));
            ll.add(List.of(i[1], 1));
        }

        ll.sort((a, b) -> {
        
            int cmp = Integer.compare(a.get(0), b.get(0));
            return cmp != 0 ? cmp : Integer.compare(a.get(1), b.get(1));
        });

        int cnt = 0;
        int ans = 0;

        for (List<Integer> i : ll) {

            if (i.get(1) == 0) {

                cnt++;
            } else {

                cnt--;
            }

            ans = Math.max(ans, cnt);
        }

        ans = Math.max(ans, cnt);

        return ans;
    }
}