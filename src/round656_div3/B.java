package round656_div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < 2*n; i++){
                int current = Integer.parseInt(st.nextToken());
                if(set.contains(current)) continue;
                set.add(current);
                sb.append(current).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
