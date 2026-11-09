class Solution {
    
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
    
        int count[] = new int[k];
        PriorityQueue<int[]> busy = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        TreeSet<Integer> availableServers = new TreeSet<>();
        for (int i=0; i<k; i++) {
    
            availableServers.add(i);
        }

        int maxRequests = 0;

        for (int i=0; i<arrival.length; i++) {
    
            int time = arrival[i];
            int duration = load[i];

            while (!busy.isEmpty() && busy.peek()[0] <= time) {
    
                int finished[] = busy.poll();
                availableServers.add(finished[1]);
            }
    
            if (availableServers.isEmpty()) {

                continue;
            }

            Integer targetServer = availableServers.ceiling(i%k);

            if (targetServer == null) {

                targetServer = availableServers.first();
            }

            availableServers.remove(targetServer);
            busy.offer(new int[] {time + duration, targetServer});
            count[targetServer]++;
            maxRequests = Math.max(maxRequests, count[targetServer]);
        }

        List<Integer> result = new ArrayList<>();
        for (int i=0; i<k; i++) {
            
            if(count[i] == maxRequests) {

                result.add(i);
            }
        }

        return result;
    }
}