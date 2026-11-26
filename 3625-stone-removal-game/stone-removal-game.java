class Solution {

    public boolean canAliceWin(int n) {

        boolean w = false;
        boolean a = true;

        int t = 10;

        while (n > 0) {

            if (n >= t) {

                w = a;

                n -= t;
                t--;
                a = !a;
            } else {

                w = !a;
                break;
            }
        }

        return w;
    }
}