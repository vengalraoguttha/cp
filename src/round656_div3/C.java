package round656_div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            if(n <= 2){
                sb.append("0\n");
                continue;
            }
            int current = arr[n - 1];
            boolean increasing = true;
            int point = -1;
            for(int i = n - 2; i >= 0; i--){
                if(current > arr[i] && increasing){
                    increasing = false;
                }
                if(arr[i] > current){
                    if(increasing){
                        current = arr[i];
                    }else {
                        point = i;
                        break;
                    }
                }else if(arr[i] < current){
                    current = arr[i];
                }
            }

            if(point == -1) point = 0;
            else point++;
            sb.append(point).append("\n");
        }
        System.out.print(sb.toString());
    }
}
