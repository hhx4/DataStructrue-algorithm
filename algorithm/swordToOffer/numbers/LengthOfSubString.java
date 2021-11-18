package algorithm.swordToOffer.numbers;

import java.util.HashMap;

/**
 * @created by wt at 2021-11-14 21:35
 **/
public class LengthOfSubString {
    public static int lengthOfLongestSubstring(String s) {
        int left=0;
        int right=0;
        int max = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(right<s.length()){
            //判断右指针是否能够前移动。移动到下一个重复的字符处，并使用hashmap记录每一个字符的下标。
            while(right<s.length()&&!map.containsKey(s.charAt(right))){
                map.put(s.charAt(right),right);
                right++;
            }
            //如果移动到非末尾，将左指针重复字符的下标处后一位。并更新map中的下标，记录该非重复字符串的长度。
            //如果移动到末尾退出，则直接进性最大值判断；
            max = Math.max(right-left+1,max);
            if(right<s.length()){
                left = map.get(s.charAt(right))+1;
                map.put(s.charAt(right),right);
            }
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmzuxt"));
    }
}