class Solution {

    public int minAddToMakeValid(String s) {

        int ans = 0;
        Stack<Integer> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                st.push(-1);
            } else {

                if (st.isEmpty()) {

                    ans++;
                } else {

                    st.pop();
                }
            }
        }

        ans += st.size();

        return ans;     
    }
}