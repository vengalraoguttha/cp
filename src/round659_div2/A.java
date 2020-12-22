package round659_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        while (t-- > 0){
            int n = nextInt(br);
            int[] arr = nextIntArray(br, n);
            List<String> list = new ArrayList<>();
            char ch = 'a';
            StringBuilder current = new StringBuilder();
            for(int i = 0; i < arr[0]; i++){
                current.append(ch);
            }
            if(arr[0] == 0) current.append(ch);
            list.add(current.toString());
            for(int i = 0; i < n - 1; i++){
                int len = Math.max(arr[i], arr[i + 1]);
                len = Math.max(len, 1);
                current = new StringBuilder();
                String s = list.get(list.size() - 1);
                current.append(s.substring(0, arr[i]));
                ch = 'a';
                if(s.length() > arr[i]){
                    char c = s.charAt(arr[i]);
                    if(c == ch){
                        ch = 'b';
                    }
                }
                for(int j = arr[i]; j < len; j++){
                    current.append(ch);
                }
                list.add(current.toString());
            }
            if(arr[n - 1] != 0)
            list.add(list.get(list.size() - 1).substring(0, arr[n - 1]));
            else {
                ch = 'a';
                if(list.get(list.size() - 1).length() > arr[n - 1]){
                    char c = list.get(list.size() - 1).charAt(arr[n - 1]);
                    if(c == ch){
                        ch = 'b';
                    }
                }
                list.add(ch+"");
            }

            for(String val : list){
                sb.append(val).append("\n");
            }
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
