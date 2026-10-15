class Solution {
  
    public String maxSumOfSquares(int num, int sum) {
        
        if (sum > 9 * num) {

            return "";
        }
        
        StringBuilder sb = new StringBuilder();
      
        for (int i=0; i<num; i++) {
      
            int n = Math.min(sum, 9);
            sb.append(n);
            sum -= n;
        }
    
        return sb.toString();
    }
}