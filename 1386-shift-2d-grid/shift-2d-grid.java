class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        List<List<Integer>> ans = new ArrayList<>();
        int n = grid.length, m = grid[0].length;
        int total = n * m;

        for(int i =0 ;i < n;i++){
            
            ans.add(new ArrayList<>(m));
            
            for(int j=0; j<m; j++){
                ans.get(i).add(0);
            }
            
        }

        for(int i=0; i<n; i++){      

            for(int j=0; j<m; j++){
                
                int val = i * m +j;
                int after = (val + k ) % total;

                int r = after / m;
                int c = after % m;

                ans.get(r).set(c , grid[i][j]);

            }
        }

        return ans;
    }
}