class Solution:
    def maxTotalValue(self, nums: List[int], k: int) -> int:
        max = float('-inf')
        min = float('inf')
        for i in nums:
            if i > max:
                max = i
            if i < min:
                min = i
        return k * (max - min)