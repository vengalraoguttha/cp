package education_round_91;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken());
        long k = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        int[] b = new int[m];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }

        if(n == m){
            for(int i = 0; i < n; i++){
                if(a[i] != b[i]){
                    System.out.println(-1);
                    return;
                }
            }
            System.out.println(0);
            return;
        }

        int current = 0;
        for(int i = 0; i < n; i++){
            if(current == m) break;
            if(a[i] == b[current]){
                current++;
            }
        }

        if(current != m){
            System.out.println(-1);
            return;
        }

        current = 0;
        int previous = -1;
        int max = -1;
        long total = 0;
        for(int i = 0; i < n; i++){
            if(a[i] == b[current]){
                long removed = i - 1 - previous;
                current++;
                if(removed > 0){
                    if(removed >= k){
                        long p = removed % k;
                        total += p*y;
                        if((x*1.0/k) < y){
                            total += (removed/k)*x;
                        }else {
                            if(max > a[i] && previous != -1 && max > a[previous]){
                                total += (removed - p)*y;
                            }else {
                                total += x;
                                total += (removed - p - k)*y;
                            }
                        }
                    }else {
                        if(max > a[i] && previous != -1 && max > a[previous]){
                            System.out.println(-1);
                            return;
                        }else {
                            total += removed * y;
                        }
                    }
                }
                if(current == m){
                    max = -1;
                    for(int j = i + 1; j < n; j++){
                        max = Math.max(max, a[j]);
                    }
                    if(max > -1){
                        removed = n - 1 - i;
                        if(removed > 0){
                            if(removed >= k){
                                long p = removed % k;
                                total += p*y;
                                if((x*1.0/k) < y){
                                    total += (removed/k)*x;
                                }else {
                                    total += x;
                                    total += (removed - p - k)*y;
                                }
                            }else {
                                if(max > a[i] && previous != -1 && max > a[previous]){
                                    System.out.println(-1);
                                    return;
                                }else {
                                    total += removed * y;
                                }
                            }
                        }
                    }
                    break;
                }
                max = -1;
                previous = i;
            }else {
                max = Math.max(max, a[i]);
            }
        }
        System.out.println(total);
    }
}