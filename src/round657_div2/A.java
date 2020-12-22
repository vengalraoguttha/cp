package round657_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        String search = "abacaba";
        while (t-- > 0){
            int n = nextInt(br);
            String s = br.readLine();

            int count = 0;
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < search.length(); j++) {
                    if (i + j >= n) break;
                    if(s.charAt(i + j) == search.charAt(j)) {
                        if(j == search.length() - 1) count++;
                    }
                    else break;
                }
            }

            if(count > 1){
                sb.append("No\n");
                continue;
            }else if(count == 1){
                sb.append("Yes\n");
                for(int i = 0; i < n; i++){
                    if(s.charAt(i) == '?'){
                        sb.append('d');
                        continue;
                    }
                    sb.append(s.charAt(i));
                }
                sb.append("\n");
                continue;
            }

            boolean found = false;
            String aa = s;
            StringBuilder ans = new StringBuilder();
            for(int i = 0; i < n; i++){
                for(int j = 0; j < search.length(); j++){
                    if(i + j >= n) break;
                    if(s.charAt(i + j) == '?') {
                        if(j == search.length() - 1) found = true;
                        continue;
                    }
                    else if(s.charAt(i + j) == search.charAt(j)) {
                        if(j == search.length() - 1) found = true;
                        continue;
                    }
                    else break;
                }
                if(!found){
                    if(s.charAt(i) == '?') ans.append('d');
                    else ans.append(s.charAt(i));
                }else {
                    StringBuilder temp = new StringBuilder(ans);
                    for(int j = 0; j < search.length(); j++){
                        temp.append(search.charAt(j));
                    }
                    for(int j = i + search.length(); j < n; j++){
                        if(s.charAt(j) == '?') temp.append('d');
                        else temp.append(s.charAt(j));
                    }
                    //break;
                    count = 0;
                    for(int k = 0; k < n; k++) {
                        for (int j = 0; j < search.length(); j++) {
                            if (k + j >= n) break;
                            if(temp.charAt(k + j) == search.charAt(j)) {
                                if(j == search.length() - 1) count++;
                            }
                            else break;
                        }
                    }
                    if(count == 1) {
                        aa = temp.toString();
                        break;
                    }else {
                        found = false;
                        if(s.charAt(i) == '?') ans.append('d');
                        else ans.append(s.charAt(i));
                    }
                }
            }

            count = 0;
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < search.length(); j++) {
                    if (i + j >= n) break;
                    if(aa.charAt(i + j) == search.charAt(j)) {
                        if(j == search.length() - 1) count++;
                    }
                    else break;
                }
            }

            if(count == 1){
                sb.append("Yes\n");
                sb.append(aa).append("\n");
            }else {
                sb.append("No\n");
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
