class Solution:
    def tsp(self, cost):
        n = len(cost)
        
        dp = [[-1] * n for _ in range(1 << n)]

        def solve(mask, pos):
            # If all cities visited → return cost to go back to 0
            if mask == (1 << n) - 1:
                return cost[pos][0]

            if dp[mask][pos] != -1:
                return dp[mask][pos]

            ans = float('inf')

            # Try all unvisited cities
            for city in range(n):
                if not (mask & (1 << city)):
                    new_cost = cost[pos][city] + solve(mask | (1 << city), city)
                    ans = min(ans, new_cost)

            dp[mask][pos] = ans
            return ans

        # Start from city 0 with mask = 1
        return solve(1, 0)
