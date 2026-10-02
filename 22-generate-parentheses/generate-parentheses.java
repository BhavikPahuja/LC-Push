class Solution {

  void rec(List<String> ans, String curr, int o, int c, int n) {
    
    if (curr.length() == n * 2) {
    
      ans.add(curr);
      return;
    }
    
    if (o < n) {

        rec(ans, curr + "(", o + 1, c, n);
    }
    
    if (c < o) {

        rec(ans, curr + ")", o, c + 1, n);
    }
  }
  public List<String> generateParenthesis(int n) {
    
    List<String> ans = new ArrayList<>();
    rec(ans, "", 0, 0, n);
    return ans;
  }
}