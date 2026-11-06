class Solution {
    
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
    
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        int arr[][] = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            
            arr[i][0] = queries[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int ans[] = new int[queries.length];
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0, right = 0;

        for (int i = 0; i < queries.length; i++) {
            
            int time = arr[i][0];
            
            while (right < logs.length && logs[right][1] <= time) {
            
                int server = logs[right][0];
                map.put(server, map.getOrDefault(server, 0) + 1);
                right++;
            }

            while (left < right && logs[left][1] < time - x) {
            
                int server = logs[left][0];
                map.put(server, map.get(server) - 1);
            
                if (map.get(server) == 0) {
            
                    map.remove(server);
                }
            
                left++;
            }
            
            ans[arr[i][1]] = n - map.size();
        }
        
        return ans;
    }
}