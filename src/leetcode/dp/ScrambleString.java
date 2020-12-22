package leetcode.dp;

import java.util.HashMap;
import java.util.Scanner;

public class ScrambleString {
    private HashMap<String, Boolean> dp;
    private boolean calculate(String s1, String s2){
        if(s1.equals(s2)) return true;
        if(s1.length() == 1) return false;
        String key = s1 + "-" + s2;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        boolean res = false;
        for(int i = 0; i < s1.length() - 1; i++){
            String prefix = s1.substring(0, i + 1);
            String suffix = s1.substring(i + 1);
            res = res || (calculate(prefix, s2.substring(0, i + 1)) && calculate(suffix, s2.substring(i + 1)));
            res = res || (calculate(suffix, s2.substring(0, suffix.length())) && calculate(prefix, s2.substring(suffix.length())));
        }
        dp.put(key, res);
        return res;
    }

    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        dp = new HashMap<>();
        return calculate(s1, s2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        ScrambleString scrambleString = new ScrambleString();
        System.out.println(scrambleString.isScramble(s1, s2));
    }
}
