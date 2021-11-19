package algorithm.swordToOffer.string;

/**
 * 判断字符串中的数字和字母是否是回文；
 **/
public class IsPalindrome {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome("0p");
        System.out.println(palindrome);
    }
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left += 1;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right -= 1;
            } else {
                char char1 = Character.toLowerCase(s.charAt(left++));
                char char2 = Character.toLowerCase(s.charAt(right--));
                if (char1 != char2) {
                    return false;
                }
            }
        }
        return true;
    }





   /* public static  boolean isPalindrome(String s) {
        if(s.length()<2){
            return true;
        }

        s = s.toLowerCase();
        StringBuilder tmp = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='a'&&s.charAt(i)<='z'){
                tmp.append(s.charAt(i));
            }else if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                tmp.append(s.charAt(i));
            }
        }
        String
        int left = 0;
        int right = tmp.length()-1;
        while(left<=right){
            if(tmp.charAt(left)!=tmp.charAt(right)) return false;
            left++;
            right--;
        }
        return true;

    }*/
}