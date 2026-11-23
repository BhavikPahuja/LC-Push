class ProductOfNumbers {

    ArrayList<Integer> pre;
    int n;

    public ProductOfNumbers() {
        
        pre = new ArrayList<>();

        pre.add(1);
        n = 0;
    }

    public void add(int num) {
        
        if (num == 0) {
        
            pre = new ArrayList<Integer>();
            pre.add(1);
            n = 0;
        } else {
        
            pre.add(pre.get(n) * num);
            n++;
        }
    }

    public int getProduct(int k) {
        
        if (k > n) {

            return 0;
        }

        return pre.get(n) / pre.get(n - k);
    }
}