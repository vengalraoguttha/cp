package round656_div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
    private static int calculate(String s, int start, int end, char ch){
        if(start == end){
            if(s.charAt(start) != ch) return 1;
            else return 0;
        }
        int size = end - start + 1;
        int diff1 = 0, diff2 = 0;
        for(int i = start; i < start + size/2; i++){
            if(ch != s.charAt(i)) diff1++;
        }
        for(int i = start + size/2; i <= end; i++){
            if(ch != s.charAt(i)) diff2++;
        }
        return Math.min(diff1 + calculate(s, start + size/2, end, (char) ((int)ch + 1)),
                diff2 + calculate(s, start, start + size/2 - 1, (char) ((int)ch + 1)));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0){
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            sb.append(calculate(s, 0, n -1, 'a')).append("\n");
        }
        System.out.print(sb.toString());
    }
}
