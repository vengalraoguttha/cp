package education_round_91;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int sIndex = 0;
            int m = 0;
            int l = 0;
            boolean found = false;
            for(int i = 1; i < n; i++){
                if(arr[i] < arr[i - 1] && arr[i - 1] > arr[sIndex]){
                    // found
                    m = i - 1;
                    l = i;
                    found = true;
                    break;
                }
                if(arr[i] < arr[sIndex]){
                    sIndex = i;
                }
            }

            if(found){
                sb.append("YES\n");
                sb.append(sIndex + 1).append(" ").append(m + 1).append(" ").append(l + 1).append("\n");
            }else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb.toString());
    }
}
