class Solution:
    def maxIceCream(self, costs: List[int], coins: int) -> int:
        max_val = max(costs)
        count_sort = [0] * (max_val + 1)
        for cost in costs:
            count_sort[cost] += 1
        ans = 0
        for i in range(max_val + 1):
            if count_sort[i] != 0:
                for j in range(count_sort[i]):
                    if coins >= i:
                        coins -= i
                        ans += 1
        return ans