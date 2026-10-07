class Solution {

    public boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> mpp = new HashMap<>();

        for (int i : arr) {

            mpp.put(i, mpp.getOrDefault(i, 0) + 1);
        }

        List<Integer> freq = new ArrayList<>();

        for (int val : mpp.values()) {

            freq.add(val);
        }

        Collections.sort(freq);

        System.out.println(freq.size());

        for (int i=0; i<freq.size()-1; i++) {

            if (freq.get(i).equals(freq.get(i+1))) {

                return false;
            }
        }
        
        return true;
    }
}