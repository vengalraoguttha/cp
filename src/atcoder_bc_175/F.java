package atcoder_bc_175;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class F {

    private static boolean isPalindrome(String s){
        int i = 0, j = s.length() - 1;
        while (i <= j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    private static long calculate(String a, String b, String[] strings, int[] costs){
        int len = Math.min(a.length(), b.length());
        int i = 0, j = b.length() - 1;
        while (i < len){
            if(a.charAt(i) != b.charAt(j)){
                return Long.MAX_VALUE;
            }
            i++;
            j--;
        }
        if(a.length() == b.length()) {
            return 0;
        }
        if(len != a.length()){
            if(isPalindrome(a.substring(len))){
                return 0;
            }
        }else {
            if(isPalindrome(b.substring(len))){
                return 0;
            }
        }

        long ans = Long.MAX_VALUE;
        for(int c = 0; c < strings.length; c++){
            if(len != a.length()){
                long temp = calculate(a.substring(len), strings[c], strings, costs);
                if(temp != Long.MAX_VALUE) ans = Math.min(ans, temp + costs[c]);
            }else {
                long temp = calculate(strings[c], b.substring(0, b.length() - len), strings, costs);
                if(temp != Long.MAX_VALUE) ans = Math.min(ans, temp + costs[c]);
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int n = nextInt(br);
        String[] strings = new String[n];
        int[] costs = new int[n];
        long ans = Long.MAX_VALUE;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            strings[i] = st.nextToken();
            costs[i] = Integer.parseInt(st.nextToken());
            if(isPalindrome(strings[i])){
                ans = Math.min(ans, costs[i]);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                // string[i] and string[j]
                if(isPalindrome(strings[i]) || isPalindrome(strings[j])) continue;
                long temp = calculate(strings[i], strings[j], strings, costs);
                if(temp != Long.MAX_VALUE)
                    ans = Math.min(ans, temp + costs[i] + costs[j]);

                // string[j] and string[i]
                temp = calculate(strings[j], strings[i], strings, costs);
                if(temp != Long.MAX_VALUE)
                    ans = Math.min(ans, temp + costs[i] + costs[j]);
                //System.out.println(i+" "+j+" "+temp);
            }
        }

        if(ans == Long.MAX_VALUE){
            sb.append(-1);
        }else {
            sb.append(ans);
        }

        System.out.print(sb.toString());
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

