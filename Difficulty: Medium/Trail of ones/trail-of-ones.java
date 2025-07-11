class Solution {
    public int countConsec(int n) {
        // code here
        if (n == 0) return 1; // Base case when n is 0
        
        long total = 1L << n; // Calculate 2^n using bit shift
        
        // Initialize variables for the Fibonacci sequence
        long prevPrev = 1; // dp[0]
        long prev = 2;    // dp[1]
        
        for (int i = 2; i <= n; i++) {
            long current = prev + prevPrev;
            prevPrev = prev;
            prev = current;
        }
        
        return (int) (total - prev);
    }
}
