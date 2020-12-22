package round641_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0){
            String input = br.readLine();
            String[] split = input.split(" ");
            long n = Integer.parseInt(split[0]);
            int k = Integer.parseInt(split[1]);
            while ((n % 2 != 0) && k > 0){
                for(int i = 2; i <= n; i++){
                    if(n % i == 0){
                        n += i;
                        break;
                    }
                }
                k--;
            }
            n += (2*k);
            sb.append(n).append("\n");
        }
        System.out.println(sb.toString());
    }
}
