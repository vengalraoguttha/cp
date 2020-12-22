package round655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0){
            int n = Integer.parseInt(br.readLine());
            if( n % 2 == 0){
                sb.append(n/2).append(" ").append(n/2).append("\n");
            }else {
                int ans = 1;
                for(int j = 2; j*j <= n; j++){
                    if(n % j == 0){
                        ans = Math.max(ans, Math.max(j, n/j));
                    }
                }
                sb.append(ans).append(" ").append(n - ans).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}
