package kickstart_round_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        int test = 1;
        while (t-- > 0){
            int n = nextInt(br);
            int[] e = new int[n];
            int[] r = new int[n];
            for(int i = 0; i < n; i++){
                int[] arr = nextIntArray(br, 2);
                e[i] = arr[0];
                r[i] = arr[1];
            }
            long sum = 0;
            for(int i = 0; i < n; i++){
                sum += e[i];
            }
            long firstRep = sum;
            for(int i = 0; i < n; i++){
                if(r[i] <= firstRep){
                    firstRep += e[i];
                }else {
                    break;
                }
            }
            List<Pair<Integer, Pair<Integer, Integer>>> pairs = new ArrayList<>();
            for(int i = 0; i < n; i++){
                pairs.add(new Pair<>(r[i], new Pair<>(e[i], i)));
            }
            pairs.sort(new Comparator<Pair<Integer, Pair<Integer, Integer>>>() {
                @Override
                public int compare(Pair<Integer, Pair<Integer, Integer>> o1, Pair<Integer, Pair<Integer, Integer>> o2) {
                    return o2.first - o1.first;
                }
            });

            boolean found = false;
            int index = 0;
            long[] subSums = new long[pairs.size()];
            for(int i = n - 1; i >= 0; i--){
                if(i == n - 1){
                    subSums[i] = e[i];
                }else {
                    subSums[i] = subSums[i + 1] + e[i];
                }
            }
            long ans = sum;
            int maxRem = 0;
            int[] rem = new int[n];
            for(int i = 0; i < pairs.size() - 1; i++){
                Pair<Integer, Pair<Integer, Integer>> pairPair = pairs.get(i);
                sum -= pairPair.second.first;
                if(sum >= pairPair.first){
                    found = true;
                    index = i;
                    break;
                }
                rem[pairPair.second.second] = pairPair.second.first;
                int start = i;
                int end = pairs.size() - 1;
                while (start <= end){
                    int mid = start + (end - start)/2;
                    long rr = 0;
                    for(int j = mid; j >= 0; j--){
                        rr += rem[j];
                    }
                    long totalSum = sum + subSums[mid] - rr;
                    if(totalSum >= pairs.get(mid).first){
                        if(ans < totalSum){
                            ans = totalSum;
                            maxRem = i;
                        }
                        end = mid - 1;
                    }else {
                        start = mid + 1;
                    }
                }
            }

            if(found){
                sb.append("Case #"+test+": "+index+" INDEFINITELY").append("\n");
            }else {
                sb.append("Case #"+test+": "+maxRem+" "+ans).append("\n");
            }
            test++;
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
