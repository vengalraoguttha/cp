package leetcode;

import java.util.ArrayList;
import java.util.List;

public class StrongPasswordChecker {
    public int strongPasswordChecker(String s) {
        int change = 0;
        if(s.length() < 6){
            change += 6 - s.length();
        } else if(s.length() > 20){
            change += s.length() - 20;
        }

        boolean lower = false, upper = false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') lower = true;
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') upper = true;
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            int count = 0;
            for(int j = i + 1; j < s.length(); j++){
                if(s.charAt(j) == s.charAt(i)) count++;
                else break;
            }
            if(count >= 3){
                list.add(count);
            }
            i += count;
        }

        int a = 0;
        for(int val : list){
            a += (val/3);
        }
        if(!lower) a++;
        if(!upper) a++;

        return Math.max(a, change);
    }
}
