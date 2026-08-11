class Solution {

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {

        Queue<Integer> q = new LinkedList<>();

        Set<Integer> curr_keys = new HashSet<>();
        Set<Integer> boxes = new HashSet<>();

        Set<Integer> seen = new HashSet<>();

        for (int i : initialBoxes) {

            if (status[i] == 0) {

                boxes.add(i);
            } else {
            
                q.offer(i);
            }
        }

        int ans = 0;

        while (!q.isEmpty()) {

            int curr = q.poll();

            ans += candies[curr];
            seen.add(curr);

            for (int key : keys[curr]) {

                curr_keys.add(key);
            }

            for (int box : containedBoxes[curr]) {

                if (status[box] == 1) {
                    if (!seen.contains(box)) {

                        seen.add(box);
                        q.offer(box);
                    }
                } else {

                    boxes.add(box);
                }
            }

            for (int key : curr_keys) {

                if (boxes.contains(key)) {

                    if (!seen.contains(key)) {

                        q.offer(key);
                    }

                    boxes.remove(key);
                }
            }
        }

        return ans;
    }
}