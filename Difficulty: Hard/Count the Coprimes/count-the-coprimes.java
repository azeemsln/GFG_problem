class Solution {
    void computeMobius(int n, int[] mu) {
        int[] is_prime = new int[n + 1];
        Arrays.fill(is_prime, 1);
        mu[0] = 0;
        mu[1] = 1;

        for (int i = 2; i <= n; ++i) {
            if (is_prime[i] == 1) {
                for (int j = i; j <= n; j += i) {
                    mu[j] *= -1;
                    is_prime[j] = 0;
                }
                // Not square-free
                for (int j = i * i; j <= n; j += i * i) {
                    mu[j] = 0;
                }
            }
        }
    }

    // Builds frequency array for values in 'arr'
    void buildFre(int[] arr, int[] freq) {
        for (int x : arr) freq[x]++;
    }

    // For each k, computes how many numbers in arr are divisible by k
    void computeDivCnt(int maxVal, int[] freq, int[] d) {
        for (int k = 1; k <= maxVal; ++k)
            for (int j = k; j <= maxVal; j += k) d[k] += freq[j];
    }

    // logic to count coprime pairs using Möbius and Inclusion-Exclusion
    int cntCoprime(int[] arr) {
        int maxVal = Arrays.stream(arr).max().getAsInt();
        int[] freq = new int[maxVal + 1];
        int[] d = new int[maxVal + 1];
        int[] mu = new int[maxVal + 1];
        Arrays.fill(mu, 1);

        buildFre(arr, freq);
        computeDivCnt(maxVal, freq, d);
        computeMobius(maxVal, mu);

        int result = 0;
        for (int k = 1; k <= maxVal; ++k) {
            if (mu[k] == 0 || d[k] < 2) continue;
            int pairs = (int)((long)d[k] * (d[k] - 1) / 2);
            result += mu[k] * pairs;
        }

        return result;
    }
}
