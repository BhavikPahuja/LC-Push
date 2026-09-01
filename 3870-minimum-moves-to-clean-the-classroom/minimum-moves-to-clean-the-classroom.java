class Solution {

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length, n = classroom[0].length();
        
        int row = 0, col = 0;
        int cnt = 0;
        
        int[][] bit = new int[m][n];
        for (int i[] : bit) {
        
            Arrays.fill(i, -1);
        }
        
        for (int i = 0; i < m; i++) {
        
            for (int j = 0; j < n; j++) {
        
                char ch = classroom[i].charAt(j);
        
                if (ch == 'S') {
        
                    row = i;
                    col = j;
                } else if (ch == 'L') {
        
                    bit[i][j] = cnt++;
                }
            }
        }
        
        int k = (1 << cnt) - 1;
        if (k == 0) return 0;
        
        int min[][][] = new int[m][n][1 << cnt];
        for (int i = 0; i < m; i++) {
        
            for (int j = 0; j < n; j++) {
        
                Arrays.fill(min[i][j], -1);
            }
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col, 0, energy, 0});
        min[row][col][0] = energy;
        
        int dirs[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            
            int curr[] = queue.poll();
            int curr_row = curr[0], curr_col = curr[1];
            int mask = curr[2], e = curr[3], steps = curr[4];
            
            if (mask == k) {
                
                return steps;
            }
            
            if (e == 0) {

                continue;
            }
            
            for (int[] d : dirs) {
                
                int new_row = curr_row + d[0];
                int new_col = curr_col + d[1];
                
                if (new_row >= 0 && new_row < m && new_col >= 0 && new_col < n) {

                    char cell = classroom[new_row].charAt(new_col);
                    if (cell == 'X') {

                        continue;
                    }
                    
                    int new_energy = e - 1;
                    int new_mask = mask;
                    
                    if (cell == 'L' && bit[new_row][new_col] != -1) {
                        
                        new_mask |= (1 << bit[new_row][new_col]);
                    } else if (cell == 'R') {
                        
                        new_energy = energy;
                    }
                    
                    if (new_energy > min[new_row][new_col][new_mask]) {
                        
                        min[new_row][new_col][new_mask] = new_energy;
                        queue.offer(new int[]{new_row, new_col, new_mask, new_energy, steps + 1});
                    }
                }
            }
        }
        
        return -1;
    }
}