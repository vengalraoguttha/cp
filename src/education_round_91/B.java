package education_round_91;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Map<Character, Character> map = new HashMap<>();
        map.put('R', 'P');
        map.put('P', 'S');
        map.put('S', 'R');
        while (t-- > 0){
            String s = br.readLine();
            int[] arr = new int[26];
            for(int i = 0; i < s.length(); i++){
                arr[s.charAt(i) - 'A']++;
            }
            int r = arr['R' - 'A'];
            int p = arr['P' - 'A'];
            int si = arr['S' - 'A'];
            char req;
            if(r >= p && r >= si){
                req = 'R';
            }else if(p >= r && p >= si){
                req = 'P';
            }else{
                req = 'S';
            }
            for(int i = 0; i < s.length(); i++){
                sb.append(map.get(req));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
