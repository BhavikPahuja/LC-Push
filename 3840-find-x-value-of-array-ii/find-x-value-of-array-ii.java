class Solution {

    private static void rebuild(int b, int a[], int n, int B, int k, int blockProd[], int blockCnt[]) {
        
        int l = b * B;
        int r = Math.min(n, l + B);
        int offset = b * k;

        for (int rem = 0; rem < k; rem++) {
        
            blockCnt[offset + rem] = 0;
        }

        int p = 1;
        for (int i = l; i < r; i++) {
        
            p = (p * a[i]) % k;
            blockCnt[offset + p]++;
        }
        
        blockProd[b] = p;
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
    
        int n = nums.length;
        int q = queries.length;
        int ans[] = new int[q];

        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
        
            a[i] = (int)(nums[i] % k);
        }

        int SHIFT = 9;
        int B = 1 << SHIFT;
        int numBlocks = (n + B - 1) >> SHIFT;

        int blockProd[] = new int[numBlocks];
        int blockCnt[] = new int[numBlocks * k];

        for (int b = 0; b < numBlocks; b++) {
        
            rebuild(b, a, n, B, k, blockProd, blockCnt);
        }

        for (int i = 0; i < q; i++) {
        
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int targetX = queries[i][3];

            a[idx] = val % k;
            rebuild(idx >> SHIFT, a, n, B, k, blockProd, blockCnt);

            int startBlock = start >> SHIFT;
            int endFirstBlock = Math.min(n, (startBlock + 1) << SHIFT);

            int ways = 0;
            int curr = 1;

            for (int j = start; j < endFirstBlock; j++) {
        
                curr = (curr * a[j]) % k;
        
                if (curr == targetX) {

                    ways++;
                }
            }

            int baseOffset = (startBlock + 1) * k;
            for (int b = startBlock + 1; b < numBlocks; b++, baseOffset += k) {
            
                for (int rem = 0; rem < k; rem++) {
            
                    if ((curr * rem) % k == targetX) {
            
                        ways += blockCnt[baseOffset + rem];
                    }
                }
            
                curr = (curr * blockProd[b]) % k;
            }

            ans[i] = ways;
        }

        return ans;
    }
}