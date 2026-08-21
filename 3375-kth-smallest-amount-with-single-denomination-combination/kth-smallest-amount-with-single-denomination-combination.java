class Solution {

    private long gcd(long a,long b){
    
        while (b != 0){
    
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private long count(long x,int[] coins){
        
        int n = coins.length;

        long count = 0;

        int totalMasks = 1 << n;

        for(int mask = 1; mask < totalMasks; mask++){
            
            long  lcm = 1;

            for (int i = 0;i < n; i++){

                if((mask & (1 << i)) != 0){

                    lcm = (lcm / gcd(lcm,coins[i]) * coins[i]);
                }
            }

            if(lcm > x){
        
                continue;
            }

            long ways = x/lcm;

            int bits = Integer.bitCount(mask);

            if(bits % 2 == 1){
            
                count += ways;
            }else{
            
                count -= ways;
            }
        }

        return count;
    }

    public long findKthSmallest(int[] coins, int k) {
        
        long mincoin = coins[0];

        for (int coin :coins){
        
            mincoin = Math.min(mincoin,coin);
        }

        long low = 1;
        long high = mincoin * (long)k;

        while(low < high){
        
            long mid = low +(high - low)/2;
            long count = count(mid,coins);
            
            if (count>=k){

                high = mid;
            }else{

                low = mid + 1;
            }
        }

        return low;
    }
}