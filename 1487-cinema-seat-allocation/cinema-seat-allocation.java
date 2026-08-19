class Solution {
    public int maxNumberOfFamilies(int n, int[][] iSeats) {
        
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] i : iSeats) {

            map.computeIfAbsent(i[0], k -> new HashSet<>()).add(i[1]);
        }

        int res = 2 * n;

        for (Set<Integer> i : map.values()) {

            boolean left = !i.contains(2) && !i.contains(3) && !i.contains(4) && !i.contains(5);
            boolean middle = !i.contains(4) && !i.contains(5) && !i.contains(6) && !i.contains(7);
            boolean right = !i.contains(6) && !i.contains(7) && !i.contains(8) && !i.contains(9);

            res -= 2;

            if (left && right) {
                
                res += 2;
            } else if (left || middle || right) {
                
                res += 1;
            }
        }

        return res;
    }
}