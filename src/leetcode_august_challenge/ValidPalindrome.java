package leetcode_august_challenge;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') ||
                    (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') ||
                    (s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                sb.append(s.charAt(i));
            }
        }
        String modified = sb.toString().toLowerCase();
        int start = 0;
        int end = modified.length() - 1;
        while (start <= end){
            if(modified.charAt(start) != modified.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
