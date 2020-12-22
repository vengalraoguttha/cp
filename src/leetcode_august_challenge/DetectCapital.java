package leetcode_august_challenge;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if(word.charAt(0) >= 'A' && word.charAt(0) <= 'Z'){
            if(word.length() == 1) return true;
            if(word.charAt(1) >= 'A' && word.charAt(1) <= 'Z'){
                boolean allCap = true;
                for(int i = 2; i < word.length(); i++){
                    if(word.charAt(i) >= 'a' && word.charAt(i) <= 'z'){
                        allCap = false;
                        break;
                    }
                }
                if(allCap) return true;
                return false;
            } else {
                boolean small = true;
                for(int i = 2; i < word.length(); i++){
                    if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'){
                        small = false;
                        break;
                    }
                }
                if(small){
                    return true;
                }
                return false;
            }
        }else {
            boolean small = true;
            for(int i = 1; i < word.length(); i++){
                if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'){
                    small = false;
                    break;
                }
            }
            if(small){
                return true;
            }
            return false;
        }
    }
}
