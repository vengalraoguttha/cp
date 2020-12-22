package mashup_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class H {

    public static void main(String[] args) throws IOException{
        new H().solve();
    }

    private void solve() throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(f.readLine());
        int[] s = new int[n];
        int[] c = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(f.readLine());
        for (int i = 0; i < n; i++) s[i] = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(f.readLine());
        for (int i = 0; i < n; i++) c[i] = Integer.parseInt(tokenizer.nextToken());

        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][0] = c[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (s[j] >= s[i]) continue;
                for (int k = 0; k < 2; k++) {
                    if (dp[j][k] == Integer.MAX_VALUE) continue;
                    dp[i][k + 1] = Math.min(dp[i][k + 1], dp[j][k] + c[i]);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) res = Math.min(res, dp[i][2]);

        if (res == Integer.MAX_VALUE) {
            out.println(-1);
        } else out.println(res);
        out.close();
    }
}
