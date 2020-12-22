package round667_div3;

import education_dp.M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb2 = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        while (t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            String str = n+"";
            int sum = 0;
            for(int i = 0; i < str.length(); i++){
                sum += str.charAt(i) - '0';
            }
            StringBuilder sb = new StringBuilder();
            int carry = 0;
            boolean ch = false;
            for(int i = str.length() - 1; i >= 0; i--){
                int val = str.charAt(i) - '0';
                if(sum <= s){
                    if(i == str.length() - 1) sb.append(0);
                    break;
                }
                int add = 10 - (val + carry);
                carry = 1;
                if(add == 10) {
                    add = 0;
                    carry = 0;
                }
                sb.insert(0, ((char)(add + '0')));
                sum -= val;
                if(!ch){
                    sum++;
                    ch = true;
                }
            }
            sb2.append(Long.valueOf(sb.toString())).append("\n");
        }
        System.out.print(sb2.toString());
    }

    private static int nextInt(BufferedReader br) throws IOException{
        return Integer.parseInt(br.readLine());
    }

    private static int[] nextIntArray(BufferedReader br, int n) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }

    static class Pair<A, B>{
        A first;
        B second;
        public Pair(A first, B second){
            this.first = first;
            this.second = second;
        }
    }
}
