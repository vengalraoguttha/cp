package round664_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class D {
    private static int[] dp;
    private static int calculate(int[] a, int n, int m, int d, int current){
        if(current >= n) return 0;
        if(dp[current] != -1) return dp[current];
        boolean isAngry = a[current] > m;
        int res = a[current] + calculate(a, n, m, d, isAngry ? current + d + 1 : current + 1);
        dp[current] = res;
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int[] arr = nextIntArray(br, 3);
        int n = arr[0];
        int d = arr[1];
        int m = arr[2];
        int[] a = nextIntArray(br, n);

        dp = new int[n];
        Arrays.fill(dp, -1);

        Arrays.sort(a);

        int[] c = new int[n];
        int ind = n - 1;
        int pos = 0;
        for(int i = 0; i < n; i++){
            if(a[ind] > m){
                long sum = 0;
                for(int j = pos; j < pos + d; j++){
                    sum += a[j];
                }
                if( (long) a[ind] > sum && pos + d - 1 < ind){
                    c[i] = a[ind];
                    i++;
                    ind--;
                    for(int j = pos; j < pos + d; j++){
                        c[i] = a[j];
                        i++;
                        if(i == n) break;
                    }
                    pos += d;
                    i--;
                }else {
                    for(int j = pos; j < pos + d; j++){
                        c[i] = a[j];
                        i++;
                        if(i == n) break;
                    }
                    pos += d;
                    i--;
                }
            }else {
                c[i] = a[pos];
                pos++;
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(a[i] <= m){
                list.add(a[i]);
            }
        }

        int index = list.size();
        for(int i = n - 1; i >= 0; i--){
            if(a[i] > m){
                list.add(index, arr[i]);
                index -= d;
                if(index < 0) index = 0;
            }
        }

//        System.out.println(Arrays.toString(c));

//        int total = 0;
//        for(int i = n - 1; i >= 0; i--){
//            total += c[i];
//        }
//        System.out.println(total);

        int[] dd = new int[n];
        int l = 0;
        for(int i = n - 1; i >= 0; i--){
            dd[i] = c[l];
            l++;
        }
        int x = calculate(dd, n, m, d, 0);
        Arrays.fill(dp, -1);
        int y = calculate(c, n, m, d, 0);
        sb.append(Math.max(x, y));
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

