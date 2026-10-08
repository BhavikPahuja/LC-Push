class Solution {

    public String predictPartyVictory(String s) {

        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
    
        int n = s.length();

        for (int i=0; i<n; i++) {

            if (s.charAt(i) == 'R') {

                r.offer(i);
            } else {

                d.offer(i);
            }
        }

        while (!r.isEmpty() && !d.isEmpty()) {

            if (r.peek() < d.peek()) {

                r.offer(n++);
            } else {

                d.offer(n++);
            }

            r.poll();
            d.poll();
        }

        return r.isEmpty() ? "Dire" : "Radiant";
    }
}