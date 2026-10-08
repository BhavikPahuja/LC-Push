class Solution {

    public int equalPairs(int[][] grid) {

        int n = grid.length;

        Map<List<Integer>, Integer> mpp = new HashMap<>();

        for (int i=0; i<n; i++) {

            List<Integer> temp = new ArrayList<>();

            for (int j=0; j<n; j++) {

                temp.add(grid[i][j]);
            }

            mpp.put(temp, mpp.getOrDefault(temp, 0) + 1);
        }

        int ans = 0;

        for (int j=0; j<n; j++) {

            List<Integer> temp = new ArrayList<>();

            for (int i=0; i<n; i++) {

                temp.add(grid[i][j]);
            }

            if (mpp.containsKey(temp)) {

                ans += mpp.get(temp);
            }
        }

        return ans;
    }
}