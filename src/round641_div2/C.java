package round641_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class C {
    private static long gcd(long a, long b){
        if(a < b) return gcd(b, a);
        if(a % b == 0) return b;
        return gcd(b, a % b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Long> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }
        TreeMap<Long, Integer> treeMap = new TreeMap<>();
        for(int i = 0; i < arr.length; i++)
            treeMap.put(arr[i], treeMap.getOrDefault(arr[i], 0) + 1);
        long ans = -1;
        arr = new long[set.size()];
        int index = 0;
        for(Long val : set){
            arr[index] = val;
            index++;
        }
        for(int i = 0; i < set.size(); i++){
            for(int j = i+1; j < set.size(); j++){
                long lcm = (arr[i] * arr[j])/(gcd(arr[i], arr[j]));
                if(ans == -1){
                    ans = lcm;
                    if(treeMap.get(arr[i]) > 1){
                        ans = gcd(ans, arr[i]);
                    }
                    if(treeMap.get(arr[j]) > 1){
                        ans = gcd(ans, arr[j]);
                    }
                }
                else{
                    ans = gcd(ans, lcm);
                }
                if(ans == 1)
                    break;
            }
        }
        if(ans == -1){
            ans = arr[0];
        }
        System.out.println(ans);
    }
}
