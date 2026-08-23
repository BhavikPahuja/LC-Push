class Solution {

    public boolean sumGame(String num) {

        int fs = 0;
        int ss = 0;

        int fq = 0;
        int sq = 0;

        int n = num.length();

        for (int i=0; i<n/2; i++) {

            char fc = num.charAt(i);
            char sc = num.charAt(n - i - 1);

            if (fc != '?') {

                fs += fc - '0';
            } else {

                fq++;
            }

            if (sc != '?') {

                ss += sc - '0';
            } else {

                sq++;
            }
        }

        if ((fq + sq) % 2 == 1) {

            return true;
        }

        return 2 * (fs - ss) != 9 * (sq - fq);
    }
}