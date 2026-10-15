class Solution {
    public int[][] insert(int[][] iv, int[] niv) {
        
        int n = iv.length;

        List<List<Integer>> ll = new ArrayList<>();

        int i=0;
        while (i < n && iv[i][1] < niv[0]) {

            ll.add(List.of(iv[i][0], iv[i][1]));
            i++;
        }

        while (i < n && iv[i][0] <= niv[1]) {

            niv[0] = Math.min(niv[0], iv[i][0]);
            niv[1] = Math.max(niv[1], iv[i][1]);
            i++;
        }

        ll.add(List.of(niv[0], niv[1]));

        while (i < n) {

            ll.add(List.of(iv[i][0], iv[i][1]));
            i++;
        }

        System.out.println(ll);

        int nn = ll.size();

        int ans[][] = new int[nn][2];

        for (i=0; i<nn; i++) {

            ans[i][0] = ll.get(i).get(0);
            ans[i][1] = ll.get(i).get(1);
        }

        return ans;
    }
}