package round655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int val = 0;
            boolean sorted = true;
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                int current = Integer.parseInt(st.nextToken());
                arr[i] = current;
                if(current < val){
                    sorted = false;
                }
                val = current;
            }
            int[] copy = Arrays.copyOf(arr, n);
            Arrays.sort(copy);
            int count = 0;
            for(int i = 0; i < n; i++){
                if(arr[i] == copy[i]){
                    count++;
                }
            }
            if(sorted){
                sb.append(0).append("\n");
            }else if(count == 0){
                sb.append(1).append("\n");
            }else {
                sb.append(2).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}
