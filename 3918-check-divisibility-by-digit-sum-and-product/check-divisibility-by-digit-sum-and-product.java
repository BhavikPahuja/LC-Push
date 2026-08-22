class Solution {
    
    public boolean checkDivisibility(int n) {
    
        int dSum = 0;
        int dProd = 1;
        int x = n;
    
        while (n != 0) {
    
            dSum += n%10;
            dProd *= n%10;
            n /= 10;
        }
    
        return x % (dSum + dProd) == 0;
    }
}