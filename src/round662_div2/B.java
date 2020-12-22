package round662_div2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // code goes here
        int n = nextInt(br);
        int[] arr = nextIntArray(br, n);
        int q = nextInt(br);
        int[] counts = new int[100001];
        Set<Integer> twos = new HashSet<>();
        Set<Integer> fours = new HashSet<>();
        Set<Integer> six = new HashSet<>();
        Set<Integer> eights  = new HashSet<>();
        for(int i = 0; i < n; i++){
            counts[arr[i]]++;
        }

        for(int i = 0; i < counts.length; i++){
            if(counts[i] >= 8){
                eights.add(i);
            }else if(counts[i] >= 6){
                six.add(i);
            }else if(counts[i] >= 4){
                fours.add(i);
            }else if(counts[i] >= 2){
                twos.add(i);
            }
        }
        for(int i = 0; i < q; i++){
            String s = br.readLine();
            char sign = s.charAt(0);
            Integer val = Integer.valueOf(s.substring(2));
            if(sign == '+'){
                counts[val]++;

            }else {
                counts[val]--;
            }

            if(counts[val] >= 8){
                eights.remove(val);
                eights.add(val);
                six.remove(val);
                fours.remove(val);
                twos.remove(val);
            }else if(counts[val] >= 6){
                six.remove(val);
                eights.remove(val);
                six.add(val);
                fours.remove(val);
                twos.remove(val);
            }else if(counts[val] >= 4){
                fours.remove(val);
                eights.remove(val);
                six.remove(val);
                fours.add(val);
                twos.remove(val);
            }else if(counts[val] >= 2){
                twos.remove(val);
                eights.remove(val);
                six.remove(val);
                fours.remove(val);
                twos.add(val);
            }else {
                eights.remove(val);
                six.remove(val);
                fours.remove(val);
                twos.remove(val);
            }

            if(eights.size() >= 1 || fours.size() >= 2 || (fours.size() + six.size() >= 2) ||
                    (six.size() >= 1 && twos.size() >= 1) || (fours.size() >= 1 && twos.size() >= 2)){
                sb.append("YES\n");
            }else {
                sb.append("NO\n");
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
