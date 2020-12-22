package kickstart2020_round_D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class A {
    private static int solve(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = -1;
        List<Integer> indexes = new ArrayList<>();
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(max < arr[i]){
                max = arr[i];
                indexes.add(i);
            }
        }
        int count = 0;
        for(int index : indexes){
            if(index == n - 1){
                count++;
                continue;
            }
            if(arr[index + 1] < arr[index]){
                count++;
            }
        }

        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= t; i++){
            sb.append("Case #").append(i).append(": ").append(solve(br)).append("\n");
        }
        System.out.print(sb.toString());
    }
}
