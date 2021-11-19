package algorithm.swordToOffer.string;

/**
 * 最长不重复子字符串
 * theLongestUniqueSubstring
 **/
public class LengthOfLongestSubString {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int[] dic = new int[128];
        for (int r = 0,l = 0;r < s.length();r++) {
            dic[s.charAt(r)]++;
            //左右指针归并到一起；
            while (dic[s.charAt(r)] > 1) {
                dic[s.charAt(l++)]--;
            }
            max = Math.max(max,r - l + 1);
        }
        return max;
    }
}