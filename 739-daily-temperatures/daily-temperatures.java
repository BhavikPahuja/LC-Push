class Solution {

    public int[] dailyTemperatures(int[] t) {

        int n = t.length;

        Stack<int[]> st = new Stack<>();
        int nge[] = new int[n];

        for (int i=n-1; i>=0; i--) {

            while (!st.isEmpty() && st.peek()[0] <= t[i]) {

                System.out.println("Pop: " + st.peek()[0]);

                st.pop();
            }

            if (!st.isEmpty()) {

                nge[i] = st.peek()[1] - i;
            }

            st.push(new int[]{t[i], i});

            System.out.println("Push: " + t[i]);
        }

        return nge;
    }
}