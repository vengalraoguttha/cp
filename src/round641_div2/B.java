package round641_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
    private static int calculate(long[] arr, int prevPosition){
        if(prevPosition == -1){
            int max = 0;
            for(int i = 1; i < arr.length; i++){
                int val = calculate(arr, i);
                int current = Integer.MIN_VALUE;
                if(val != Integer.MIN_VALUE) current = 1 + val;
                if(current > max){
                    max = current;
                }
            }
            return max;
        }
        int max = 0;
        for(int i = prevPosition + prevPosition; i < arr.length; i += prevPosition){
            if(arr[i] > arr[prevPosition]){
                int val = calculate(arr, i);
                int current = Integer.MIN_VALUE;
                if(val != Integer.MIN_VALUE) current = 1 + val;
                if(current > max){
                    max = current;
                }
            }
        }
        return max;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0){
            int n = Integer.parseInt(br.readLine());
            long[] arr = new long[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            sb.append(calculate(arr, -1)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
